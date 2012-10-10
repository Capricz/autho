package com.zliang.autho.service;

import java.util.List;

import com.zliang.autho.entities.Function;

/**
 * The service interface for the Function entity.
 */
public interface IFunctionService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Function findFunctionById(int id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Function</code> entity.
	 */
	public List<Function> findAllFunctions() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFunction(Function function) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFunction(Function function) throws Exception;
	/**
	 * Service method for named queries
	 */
}