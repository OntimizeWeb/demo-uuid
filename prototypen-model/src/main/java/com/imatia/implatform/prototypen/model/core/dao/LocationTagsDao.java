package com.imatia.implatform.prototypen.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository(value = "LocationTagsDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/LocationTagsDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class LocationTagsDao extends OntimizeJdbcDaoSupport {

  public static final String LOCATION_TAG_ID = "location_tag_id";
  public static final String REF_TAG_ID = "ref_tag_id";
  public static final String REF_LOCATION_ID = "ref_location_id";
  public static final String VALUE = "value";
  public static final String DOWN_DATE = "down_date";
  public static final String DOWN_USER = "down_user";

  public static final String QUERY_LOCATION_TAGS_DEFAULT = "default";

  public LocationTagsDao() {
    super();
  }
}