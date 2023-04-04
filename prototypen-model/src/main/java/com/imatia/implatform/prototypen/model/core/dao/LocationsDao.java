package com.imatia.implatform.prototypen.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository(value = "LocationsDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/LocationsDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class LocationsDao extends OntimizeJdbcDaoSupport {

  public static final String LOCATION_ID = "location_id";
  public static final String REF_PARENT_LOCATION_ID = "ref_parent_location_id";
  public static final String NAME = "name";
  public static final String DESCRIPTION = "description";
  public static final String DOWN_DATE = "down_date";
  public static final String DOWN_USER = "down_user";

  public static final String QUERY_LOCATIONS_DEFAULT = "default";

  public LocationsDao() {
    super();
  }
}