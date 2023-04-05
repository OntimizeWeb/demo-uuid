package com.imatia.implatform.prototypen.ws.core.rest;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imatia.implatform.prototypen.api.core.service.IUserAndRoleService;
import com.imatia.implatform.prototypen.model.core.dao.RoleDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.dto.EntityResultMapImpl;

@RestController
@ComponentScan(basePackageClasses={com.imatia.implatform.prototypen.api.core.service.IUserAndRoleService.class})
public class PermissionsRestController {

	@Autowired
	private IUserAndRoleService userSrv;

	@GetMapping(
	value = {"/permissions"},
	consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public EntityResult getClientPermissions() {
		try {
			EntityResult erPermissions = this.userSrv.getClientPermissions();
			if (erPermissions.calculateRecordNumber() > 0) {
				final HashMap<String, Object> permissions = new HashMap<>();
				permissions.put("permission", erPermissions.getRecordValues(0).get(RoleDao.JSON_CLIENT_PERMISSION));
				final EntityResult er = new EntityResultMapImpl();
				er.addRecord(permissions);
				er.setCode(EntityResult.OPERATION_SUCCESSFUL);
				return er;
			}

			return null;
		} catch (final Exception e) {
			e.printStackTrace();
			return new EntityResultMapImpl(EntityResult.OPERATION_WRONG, EntityResult.DATA_RESULT, e.getMessage());
		}
	}
}
