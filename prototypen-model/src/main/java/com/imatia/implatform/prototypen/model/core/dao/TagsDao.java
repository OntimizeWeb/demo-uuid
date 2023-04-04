package com.imatia.implatform.prototypen.model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository(value = "TagsDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/TagsDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class TagsDao extends OntimizeJdbcDaoSupport {

  public static final String TAG_ID = "tag_id";
  public static final String NAME = "name";
  public static final String DESCRIPTION = "description";
  public static final String DOWN_DATE = "down_date";
  public static final String DOWN_USER = "down_user";

  public static final String QUERY_TAGS_DEFAULT = "default";

  public TagsDao() {
    super();
  }
}