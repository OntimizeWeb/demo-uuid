package com.imatia.implatform.prototypen.model.core.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imatia.implatform.prototypen.api.core.service.ITagsService;
import com.imatia.implatform.prototypen.model.core.dao.TagsDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("TagsService")
@Lazy
public class TagsService implements ITagsService {

  private final DefaultOntimizeDaoHelper daoHelper;
  private final TagsDao tagsDao;

  @Autowired
  public TagsService(DefaultOntimizeDaoHelper daoHelper, TagsDao tagsDao) {
    this.daoHelper = daoHelper;
    this.tagsDao = tagsDao;
  }

  /**
   * Tags query.
   *
   * @param keyMap   the keys values
   * @param attrList the attributes
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  @Override
  public EntityResult tagsQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException {
    //translateUuid(keyMap, TagsDao.TAG_ID);
    return this.daoHelper.query(tagsDao, keyMap, attrList, TagsDao.QUERY_TAGS_DEFAULT);
  }

  /**
   * Tags update.
   *
   * @param attrMap the attributes values
   * @param keyMap  the keys values
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public EntityResult tagsUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
      throws OntimizeJEERuntimeException {
    //translateUuid(keyMap, TagsDao.TAG_ID);
    //translateUuid(attrMap, TagsDao.TAG_ID);
    return this.daoHelper.update(tagsDao, attrMap, keyMap);
  }

  /**
   * Tags delete.
   *
   * @param keyMap the keys values
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public EntityResult tagsDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
    //translateUuid(keyMap, TagsDao.TAG_ID);
    Map<Object, Object> attrMap = new HashMap<>();
    attrMap.put(TagsDao.DOWN_DATE, new Timestamp(Calendar.getInstance().getTimeInMillis()));
    String downUserData = SecurityContextHolder.getContext()
            .getAuthentication().getName();
    attrMap.put(TagsDao.DOWN_USER, downUserData);
    return this.daoHelper.update(tagsDao, attrMap, keyMap);
  }

  /**
   * Tags insert.
   *
   * @param attrMap the attributes values
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public EntityResult tagsInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
    //if (!attrMap.containsKey(TagsDao.TAG_ID)) {
    //  attrMap.put(TagsDao.TAG_ID, UUID.randomUUID());
    //}
    //translateUuid(attrMap, TagsDao.TAG_ID);
    return this.daoHelper.insert(tagsDao, attrMap);
  }
}
