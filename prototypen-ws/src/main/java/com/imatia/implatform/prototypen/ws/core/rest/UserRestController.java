package com.imatia.implatform.prototypen.ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.server.rest.ORestController;

import com.imatia.implatform.prototypen.api.core.service.IUserAndRoleService;


@RestController
@RequestMapping("/users")
@ComponentScan(basePackageClasses={com.imatia.implatform.prototypen.api.core.service.IUserAndRoleService.class})
public class UserRestController extends ORestController<IUserAndRoleService> {

	@Autowired
	private IUserAndRoleService userSrv;

	@Override
	public IUserAndRoleService getService() {
		return this.userSrv;
	}

	@PostMapping(
		value = "/login",
		produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EntityResult> login() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
