package com.zliang.autho.dao;

import java.util.List;

import com.zliang.autho.entities.Module;

/**
 * The DAO interface for the Module entity.
 */
public interface IModuleDao {
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
	public Module findModuleById(int id);
	/**
	 * Return all persistent instances of the <code>Module</code> entity.
	 */
	public List<Module> findAllModules();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistModule(Module module);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeModule(Module module);
}