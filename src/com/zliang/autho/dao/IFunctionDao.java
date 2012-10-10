package com.zliang.autho.dao;

import java.util.List;

import com.zliang.autho.entities.Function;

/**
 * The DAO interface for the Function entity.
 */
public interface IFunctionDao {
	/**
	 * Return the persistent entities returned from a named query.
	 */
	@SuppressWarnings("unchecked")
	public List findByNamedQuery(String queryName);
	/**
	 * Return the persistent entities returned from a named query with named parameters.
	 */
	@SuppressWarnings("unchecked")
	public List findByNamedQuery(String queryName, String[] paramNames, Object[] paramValues);
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Function findFunctionById(int id);
	/**
	 * Return all persistent instances of the <code>Function</code> entity.
	 */
	public List<Function> findAllFunctions();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFunction(Function function);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFunction(Function function);
}