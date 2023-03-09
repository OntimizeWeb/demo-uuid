package com.imatia.implatform.prototypen.model.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.imatia.implatform.prototypen.api.core.service.IServerPermissionService;
import com.imatia.implatform.prototypen.model.core.dao.RoleServerPermissionDao;
import com.imatia.implatform.prototypen.model.core.dao.ServerPermissionDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Lazy
@Service("ServerPermissionService")
public class ServerPermissionService implements IServerPermissionService{
	
	@Autowired private DefaultOntimizeDaoHelper daoHelper;
	
	@Autowired private ServerPermissionDao serverPermissionDao;
	
	@Autowired private RoleServerPermissionDao roleServerPermissionDao;

	@Override
	public EntityResult serverPermissionQuery(final Map<?, ?> keysValues, final List<?> attributes)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(serverPermissionDao, keysValues, attributes);
	}

	@Override
	public EntityResult serverPermissionUpdate(final Map<?, ?> attributesValues, final Map<?, ?> keysValues)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(serverPermissionDao, attributesValues, keysValues);
	}

	@Override
	public EntityResult serverPermissionDelete(final Map<?, ?> keysValues) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(serverPermissionDao, keysValues);
	}

	@Override
	public EntityResult serverPermissionInsert(final Map<?, ?> keysValues) throws OntimizeJEERuntimeException {
		return this.daoHelper.insert(serverPermissionDao, keysValues);
	}

	@Override
	public EntityResult roleServerPermissionQuery(final Map<?, ?> keysValues, final List<?> attributes)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(roleServerPermissionDao, keysValues, attributes);
	}

	@Override
	public EntityResult roleServerPermissionUpdate(final Map<?, ?> attributesValues, final Map<?, ?> keysValues)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(roleServerPermissionDao, attributesValues, keysValues);
	}

	@Override
	public EntityResult roleServerPermissionDelete(final Map<?, ?> keysValues) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(roleServerPermissionDao, keysValues);
	}

	@Override
	public EntityResult roleServerPermissionInsert(final Map<?, ?> keysValues) throws OntimizeJEERuntimeException {
		return this.daoHelper.insert(roleServerPermissionDao, keysValues);
	}

}
