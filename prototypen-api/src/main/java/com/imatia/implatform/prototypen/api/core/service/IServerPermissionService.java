package com.imatia.implatform.prototypen.api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface IServerPermissionService {

	/**
	 * Server permissions query.
	 *
	 * @param keysValues the keys values
	 * @param attributes the attributes
	 * @return the entity result
	 * @throws OntimizeJEERuntimeException the ontimize jee exception
	 */
	EntityResult serverPermissionQuery(Map<?, ?> keysValues, List<?> attributes) throws OntimizeJEERuntimeException;

	/**
	 * Server permissions update.
	 *
	 * @param attributesValues the attributes values
	 * @param keysValues       the keys values
	 * @return the entity result
	 * @throws OntimizeJEERuntimeException the ontimize jee exception
	 */
	EntityResult serverPermissionUpdate(Map<?, ?> attributesValues, Map<?, ?> keysValues)
			throws OntimizeJEERuntimeException;

	/**
	 * Server permissions delete.
	 *
	 * @param keysValues the keys values
	 * @return the entity result
	 * @throws OntimizeJEERuntimeException the ontimize jee exception
	 */
	EntityResult serverPermissionDelete(Map<?, ?> keysValues) throws OntimizeJEERuntimeException;

	/**
	 * Server permissions insert.
	 *
	 * @param keysValues the keys values
	 * @return the entity result
	 * @throws OntimizeJEERuntimeException the ontimize jee exception
	 */
	EntityResult serverPermissionInsert(Map<?, ?> keysValues) throws OntimizeJEERuntimeException;

	/**
	 * Server role permissions query.
	 *
	 * @param keysValues the keys values
	 * @param attributes the attributes
	 * @return the entity result
	 * @throws Exception the exception
	 */
	EntityResult roleServerPermissionQuery(Map<?, ?> keysValues, List<?> attributes) throws OntimizeJEERuntimeException;

	/**
	 * Server role permissions update.
	 *
	 * @param attributesValues the attributes values
	 * @param keysValues       the keys values
	 * @return the entity result
	 * @throws OntimizeJEERuntimeException the ontimize jee exception
	 */
	EntityResult roleServerPermissionUpdate(Map<?, ?> attributesValues, Map<?, ?> keysValues)
			throws OntimizeJEERuntimeException;

	/**
	 * Server role permissions delete.
	 *
	 * @param keysValues the keys values
	 * @return the entity result
	 * @throws OntimizeJEERuntimeException the ontimize jee exception
	 */
	EntityResult roleServerPermissionDelete(Map<?, ?> keysValues) throws OntimizeJEERuntimeException;

	/**
	 * Server role permissions insert.
	 *
	 * @param keysValues the keys values
	 * @return the entity result
	 * @throws OntimizeJEERuntimeException the ontimize jee exception
	 */
	EntityResult roleServerPermissionInsert(Map<?, ?> keysValues) throws OntimizeJEERuntimeException;
}
