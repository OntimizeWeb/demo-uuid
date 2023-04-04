package com.imatia.implatform.prototypen.api.core.service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import java.util.List;
import java.util.Map;

public interface ILocationsService {

  /**
   * Locations query.
   *
   * @param keyMap   the keys values
   * @param attrList the attributes
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  EntityResult locationsQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;

  /**
   * Locations update.
   *
   * @param attrMap the attributes values
   * @param keyMap  the keys values
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  EntityResult locationsUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
      throws OntimizeJEERuntimeException;

  /**
   * Locations delete.
   *
   * @param keyMap the keys values
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  EntityResult locationsDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

  /**
   * Locations insert.
   *
   * @param attrMap the attributes values
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  EntityResult locationsInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;


  /**
   * Location tags query.
   *
   * @param keyMap   the keys values
   * @param attrList the attributes
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  EntityResult locationTagsQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;

  /**
   * Location tags update.
   *
   * @param attrMap the attributes values
   * @param keyMap  the keys values
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  EntityResult locationTagsUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
      throws OntimizeJEERuntimeException;

  /**
   * Location tags delete.
   *
   * @param keyMap the keys values
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  EntityResult locationTagsDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

  /**
   * Location tags insert.
   *
   * @param attrMap the attributes values
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  EntityResult locationTagsInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;

}
