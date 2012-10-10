package com.zliang.autho.service;

import java.util.List;

import com.zliang.autho.entities.Module;

/**
 * The service interface for the Module entity.
 */
public interface IModuleService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Module findModuleById(int id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Module</code> entity.
	 */
	public List<Module> findAllModules() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistModule(Module module) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeModule(Module module) throws Exception;
	/**
	 * Service method for named queries
	 */
}