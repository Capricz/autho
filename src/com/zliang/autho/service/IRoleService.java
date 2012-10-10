package com.zliang.autho.service;

import java.util.List;

import com.zliang.autho.entities.Role;

/**
 * The service interface for the Role entity.
 */
public interface IRoleService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Role findRoleById(int id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Role</code> entity.
	 */
	public List<Role> findAllRoles() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRole(Role role) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRole(Role role) throws Exception;
	/**
	 * Service method for named queries
	 */
}