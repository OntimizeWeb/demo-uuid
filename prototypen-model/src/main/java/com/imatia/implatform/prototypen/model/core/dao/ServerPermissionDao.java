package com.imatia.implatform.prototypen.model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository(value = "ServerPermissionDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/ServerPermissionDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class ServerPermissionDao extends OntimizeJdbcDaoSupport {

	public ServerPermissionDao() {
		super();
	}
}
