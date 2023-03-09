package com.imatia.implatform.prototypen.ws.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imatia.implatform.prototypen.api.core.service.IServerPermissionService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/permissions")
@ComponentScan(basePackageClasses = { com.imatia.implatform.prototypen.api.core.service.IServerPermissionService.class })
public class ServerPermissionRestController extends ORestController<IServerPermissionService> {

	@Autowired
	private IServerPermissionService serverPermisionService;

	@Override
	public IServerPermissionService getService() {
		return serverPermisionService;
	}
}
