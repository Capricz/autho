package com.zliang.autho.dao;

import java.util.List;

import com.zliang.autho.entities.Role;

/**
 * The DAO interface for the Role entity.
 */
public interface IRoleDao {
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
	public Role findRoleById(int id);
	/**
	 * Return all persistent instances of the <code>Role</code> entity.
	 */
	public List<Role> findAllRoles();
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRole(Role role);
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRole(Role role);
}