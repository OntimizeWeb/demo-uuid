package com.imatia.implatform.prototypen.model.core.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imatia.implatform.prototypen.api.core.service.ILocationsService;
import com.imatia.implatform.prototypen.model.core.dao.LocationTagsDao;
import com.imatia.implatform.prototypen.model.core.dao.LocationsDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("LocationsService")
@Lazy
public class LocationsService implements ILocationsService {

  private final DefaultOntimizeDaoHelper daoHelper;
  private final LocationsDao locationsDao;
  private final LocationTagsDao locationTagsDao;

  @Autowired
  public LocationsService(DefaultOntimizeDaoHelper daoHelper, LocationsDao locationsDao,
      LocationTagsDao locationTagsDao) {
    this.daoHelper = daoHelper;
    this.locationsDao = locationsDao;
    this.locationTagsDao = locationTagsDao;
  }


  /**
   * Locations query.
   *
   * @param keyMap   the keys values
   * @param attrList the attributes
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  @Override
  public EntityResult locationsQuery(Map<String, Object> keyMap, List<String> attrList)
      throws OntimizeJEERuntimeException {
    return this.daoHelper.query(locationsDao, keyMap, attrList, LocationsDao.QUERY_LOCATIONS_DEFAULT);
  }

  /**
   * Locations update.
   *
   * @param attrMap the attributes values
   * @param keyMap  the keys values
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public EntityResult locationsUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
      throws OntimizeJEERuntimeException {
    return this.daoHelper.update(locationsDao, attrMap, keyMap);
  }

  /**
   * Locations delete.
   *
   * @param keyMap the keys values
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public EntityResult locationsDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
    Map<Object, Object> attrMap = new HashMap<>();
    attrMap.put(LocationsDao.DOWN_DATE, new Timestamp(Calendar.getInstance().getTimeInMillis()));
    String downUserData = SecurityContextHolder.getContext()
            .getAuthentication().getName();
    attrMap.put(LocationsDao.DOWN_USER, downUserData);
    return this.daoHelper.update(locationsDao, attrMap, keyMap);
  }

  /**
   * Locations insert.
   *
   * @param attrMap the attributes values
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public EntityResult locationsInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
    if (!attrMap.containsKey(LocationsDao.LOCATION_ID)) {
      attrMap.put(LocationsDao.LOCATION_ID, UUID.randomUUID());
    }
    return this.daoHelper.insert(locationsDao, attrMap);
  }


  /**
   * LocationTags query.
   *
   * @param keyMap   the keys values
   * @param attrList the attributes
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  @Override
  public EntityResult locationTagsQuery(Map<String, Object> keyMap, List<String> attrList)
      throws OntimizeJEERuntimeException {
    return this.daoHelper.query(locationTagsDao, keyMap, attrList, LocationTagsDao.QUERY_LOCATION_TAGS_DEFAULT);
  }

  /**
   * LocationTags update.
   *
   * @param attrMap the attributes values
   * @param keyMap  the keys values
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public EntityResult locationTagsUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
      throws OntimizeJEERuntimeException {
    return this.daoHelper.update(locationTagsDao, attrMap, keyMap);
  }

  /**
   * LocationTags delete.
   *
   * @param keyMap the keys values
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public EntityResult locationTagsDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
    Map<Object, Object> attrMap = new HashMap<>();
    attrMap.put(LocationTagsDao.DOWN_DATE, new Timestamp(Calendar.getInstance().getTimeInMillis()));

    String downUserData = SecurityContextHolder.getContext()
            .getAuthentication().getName();
    attrMap.put(LocationTagsDao.DOWN_USER, downUserData);
    return this.daoHelper.update(locationTagsDao, attrMap, keyMap);
  }

  /**
   * LocationTags insert.
   *
   * @param attrMap the attributes values
   * @return the entity result
   * @throws OntimizeJEERuntimeException the ontimize jee exception
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public EntityResult locationTagsInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
    if (!attrMap.containsKey(LocationTagsDao.LOCATION_TAG_ID)) {
      attrMap.put(LocationTagsDao.LOCATION_TAG_ID, UUID.randomUUID());
    }
    return this.daoHelper.insert(locationTagsDao, attrMap);
  }
}
