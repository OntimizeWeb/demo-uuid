package com.imatia.implatform.prototypen.api.core.service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import java.util.List;
import java.util.Map;

public interface ITagsService {

  /**
   * Tags query.
   *
   * @param keyMap   the keys values
   * @param attrList the attributes
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  EntityResult tagsQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;

  /**
   * Tags update.
   *
   * @param attrMap the attributes values
   * @param keyMap  the keys values
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  EntityResult tagsUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

  /**
   * Tags delete.
   *
   * @param keyMap the keys values
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  EntityResult tagsDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

  /**
   * Tags insert.
   *
   * @param attrMap the attributes values
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  EntityResult tagsInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;

}
