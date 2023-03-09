package com.imatia.implatform.prototypen.model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository(value="RoleDao")
@Lazy
@ConfigurationFile(
		configurationFile = "dao/RoleDao.xml",
		configurationFilePlaceholder = "dao/placeholders.properties"
		)
public class RoleDao extends OntimizeJdbcDaoSupport {

	public static final String JSON_CLIENT_PERMISSION = "rol_json_client_permission";
	public static final String ROLE_ID = "rol_id";
	public static final String ROLE_NAME = "rol_name";

	public RoleDao() {
		super();
	}
}
