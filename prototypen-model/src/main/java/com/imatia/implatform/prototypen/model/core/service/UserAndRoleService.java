package com.imatia.implatform.prototypen.model.core.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imatia.implatform.prototypen.api.core.service.IUserAndRoleService;
import com.imatia.implatform.prototypen.model.core.dao.RoleDao;
import com.imatia.implatform.prototypen.model.core.dao.ServerRoleDao;
import com.imatia.implatform.prototypen.model.core.dao.UserDao;
import com.imatia.implatform.prototypen.model.core.dao.UserRoleDao;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.dto.EntityResultMapImpl;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.common.services.user.UserInformation;
import com.ontimize.jee.common.util.remote.BytesBlock;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import com.ontimize.jee.server.security.SecurityTools;
import com.ontimize.jee.server.security.encrypt.IPasswordEncryptHelper;

@Lazy
@Service("UserAndRoleService")
public class UserAndRoleService implements IUserAndRoleService {

	/** The user dao. */
	@Autowired
	private UserDao userDao;
	/** The user roles dao. */
	@Autowired
	private UserRoleDao userRolesDao;
	/** The user dao. */
	@Autowired
	private RoleDao roleDao;

	/** The server role dao. */
	@Autowired
	private ServerRoleDao serverRoleDao;
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;

	@Autowired(required = false)
	private IPasswordEncryptHelper passwordEncrypter;

	/*
	 * (non-Javadoc)
	 */
	@Override
	public EntityResult userQuery(final Map<?, ?> keysValues, final List<?> attributes) throws OntimizeJEERuntimeException {

		final EntityResult toRet = this.daoHelper.query(this.userDao, keysValues, attributes);
		if (toRet.containsKey(UserDao.USR_PHOTO)) {
			final List<Object> photoCustomer = (List<Object>) toRet.get(UserDao.USR_PHOTO);
			for (int i = 0; i < photoCustomer.size(); i++) {
				final Object o = photoCustomer.get(i);
				if (o instanceof BytesBlock) {
					photoCustomer.set(i, ((BytesBlock) o).getBytes());
				}
			}
		}

		return toRet;
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	@Transactional(rollbackFor = Throwable.class)
	public EntityResult userUpdate(final Map<?, ?> attributesValues, final Map<?, ?> keysValues) throws OntimizeJEERuntimeException {
		try {
			return this.daoHelper.update(this.userDao, this.encryptPassword(attributesValues), keysValues);
		} finally {
			this.invalidateSecurityManager();
		}
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	@Transactional(rollbackFor = Throwable.class)
	public EntityResult userDelete(final Map<?, ?> keysValues) throws OntimizeJEERuntimeException {
		try {
			return this.daoHelper.delete(this.userDao, keysValues);
		} finally {
			this.invalidateSecurityManager();
		}
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	@Transactional(rollbackFor = Throwable.class)
	public EntityResult userInsert(final Map<?, ?> keysValues) throws OntimizeJEERuntimeException {
		return this.daoHelper.insert(this.userDao, this.encryptPassword(keysValues));
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	public EntityResult roleQuery(final Map<?, ?> keysValues, final List<?> attributes) throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.roleDao, keysValues, attributes);
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	@Transactional(rollbackFor = Throwable.class)
	public EntityResult roleUpdate(final Map<?, ?> attributesValues, final Map<?, ?> keysValues) throws OntimizeJEERuntimeException {
		try {
			return this.daoHelper.update(this.roleDao, attributesValues, keysValues);
		} finally {
			this.invalidateSecurityManager();
		}
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	@Transactional(rollbackFor = Throwable.class)
	public EntityResult roleDelete(final Map<?, ?> keysValues) throws OntimizeJEERuntimeException {
		try {
			this.serverRoleDao.unsafeDelete(keysValues);
			return this.daoHelper.delete(this.roleDao, keysValues);
		} finally {
			this.invalidateSecurityManager();
		}
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	@Transactional(rollbackFor = Throwable.class)
	public EntityResult roleInsert(final Map<?, ?> keysValues) throws OntimizeJEERuntimeException {
		try {
			return this.daoHelper.insert(this.roleDao, keysValues);
		} finally {
			this.invalidateSecurityManager();
		}
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	public EntityResult serverRoleQuery(final Map<?, ?> keysValues, final List<?> attributes) throws OntimizeJEERuntimeException {
		if (!keysValues.containsKey(RoleDao.ROLE_ID)) {
			return this.daoHelper.query(this.serverRoleDao, keysValues, attributes, "id_serverRole_all");
		}
		return this.daoHelper.query(this.serverRoleDao, keysValues, attributes, "id_serverRole");
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	@Transactional(rollbackFor = Throwable.class)
	public EntityResult serverRoleUpdate(final Map<?, ?> attributesValues, final Map<?, ?> keysValues) throws OntimizeJEERuntimeException {
		try {
			if ("S".equals(attributesValues.get("actived"))) {
				// insert
				final Map<String, Object> valuesToInsert = new HashMap<>();
				valuesToInsert.put(RoleDao.ROLE_ID, keysValues.get(RoleDao.ROLE_ID));
				valuesToInsert.put(ServerRoleDao.SRP_ID, keysValues.get(ServerRoleDao.SRP_ID));
				return this.daoHelper.insert(this.serverRoleDao, valuesToInsert);
			} else if (keysValues.get(ServerRoleDao.RSP_ID) != null) {
				// delete
				final Map<String, Object> valuesToDelete = new HashMap<>();
				valuesToDelete.put(ServerRoleDao.RSP_ID, keysValues.get(ServerRoleDao.RSP_ID));
				return this.daoHelper.delete(this.serverRoleDao, valuesToDelete);
			}
			return new EntityResultMapImpl();
		} finally {
			this.invalidateSecurityManager();
		}
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public EntityResult rolesForUserQuery(final Map<?, ?> keysValues, final List<?> attributes) throws OntimizeJEERuntimeException {
		if (!keysValues.containsKey(UserDao.USR_ID)) {
			return this.daoHelper.query(this.userRolesDao, keysValues, attributes, "rolesWithoutUser");
		}
		return this.daoHelper.query(this.userRolesDao, keysValues, attributes, "fullRolesWithUser");

	}

	/*
	 * (non-Javadoc)
	 */

	@Transactional(rollbackFor = Throwable.class)
	@Override
	public EntityResult rolesForUserUpdate(final Map<?, ?> attributesValues, final Map<?, ?> keysValues)
			throws OntimizeJEERuntimeException {
		try {
			if ("S".equals(attributesValues.get("actived"))) {
				// insert
				final Map<String, Object> valuesToInsert = new HashMap<>();
				valuesToInsert.put(UserDao.USR_ID, keysValues.get(UserDao.USR_ID));
				valuesToInsert.put(RoleDao.ROLE_ID, keysValues.get(RoleDao.ROLE_ID));
				return this.daoHelper.insert(this.userRolesDao, valuesToInsert);
			} else if (keysValues.get(UserRoleDao.URO_ID) != null) {
				// delete
				final Map<String, Object> valuesToDelete = new HashMap<>();
				valuesToDelete.put(UserRoleDao.URO_ID, keysValues.get(UserRoleDao.URO_ID));
				return this.daoHelper.delete(this.userRolesDao, valuesToDelete);
			}
			return new EntityResultMapImpl();
		} finally {
			this.invalidateSecurityManager();
		}
	}

	/**
	 * Pivot roles.
	 *
	 * @param res the res
	 * @return the entity result
	 */
	private EntityResult pivotRoles(final EntityResult res) {

		final List<Object> l = new ArrayList<>();
		final Map<Object, Object> hresgistro = new HashMap<>();
		final EntityResult respivot = new EntityResultMapImpl(new ArrayList<>(res.keySet()));

		for (int i = 0; i < res.calculateRecordNumber(); i++) {
			final Map<?, ?> hres = res.getRecordValues(i);
			if (hresgistro.containsKey(hres.get(UserDao.USR_ID))) {
				final Map<String, Object> aux = (HashMap<String, Object>) hresgistro
						.get(hres.get(UserDao.USR_ID));
				aux.put(RoleDao.ROLE_NAME, (String) aux.get(RoleDao.ROLE_NAME) + ", " + hres.get(RoleDao.ROLE_NAME));
				hresgistro.put(hres.get(UserDao.USR_ID), aux);
			} else {
				hresgistro.put(hres.get(UserDao.USR_ID), hres);
				l.add(hres.get(UserDao.USR_ID));
			}
		}

		for (int i = 0; i < l.size(); i++) {
			respivot.addRecord((HashMap<?, ?>) hresgistro.get(l.get(i)));
		}

		return respivot;
	}

	/**
	 * Refresh security manager.
	 */
	private void invalidateSecurityManager() {
		SecurityTools.invalidateSecurityManager(this.daoHelper.getApplicationContext());
	}

	protected Map<?, ?> encryptPassword(final Map<?, ?> av) {
		if (this.passwordEncrypter != null) {
			final String plainPass = (String) av.get(UserDao.PASSWORD);
			if (plainPass != null) {
				((Map<String, Object>) av).put(UserDao.PASSWORD, this.passwordEncrypter.encrypt(plainPass));
			}
		}
		return av;
	}

	@Override
	public EntityResult passwordUpdate(final Map<?, ?> attributesValues, final Map<?, ?> keysValues)
			throws OntimizeJEERuntimeException {

		final List<Object> l = new ArrayList<>();
		l.add(UserDao.PASSWORD);
		final EntityResult oldPassword = this.daoHelper.query(userDao, keysValues, l);
		if (((List) oldPassword.get(UserDao.PASSWORD)).get(0).equals(attributesValues.get(UserDao.OLD_PASSWORD))) {
			final Map<String, Object> newPassword = new HashMap<>();
			newPassword.put(UserDao.PASSWORD, attributesValues.get(UserDao.NEW_PASSWORD));
			return this.daoHelper.update(userDao, newPassword, keysValues);
		} else {
			final EntityResult error = new EntityResultMapImpl();
			error.setCode(EntityResult.OPERATION_WRONG);
			error.setMessage("The old password isn't correct!");
			return error;
		}
	}

	@Override
	public EntityResult loginUserQuery(final Map<?, ?> keysValues, final List<?> attributes) throws OntimizeJEERuntimeException {
		final UserInformation userInfo = (UserInformation) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		final EntityResult eR = new EntityResultMapImpl();
		final Map<String, Object> usrMap = new HashMap<>();

		for (final Object key : userInfo.getOtherData().keySet()) {
			if (userInfo.getOtherData().get(key) != null)
			{
				usrMap.put(String.valueOf(key), userInfo.getOtherData().get(key));
			}
		}
		eR.putAll(usrMap);
		return eR;
	}
}
