package com.zliang.autho.service;

import java.util.List;

import com.zliang.autho.entities.Userinfo;

/**
 * The service interface for the Userinfo entity.
 */
public interface IUserinfoService {
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Userinfo findUserinfoById(int id) throws Exception;
	/**
	 * Return all persistent instances of the <code>Userinfo</code> entity.
	 */
	public List<Userinfo> findAllUserinfos() throws Exception;
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUserinfo(Userinfo userinfo) throws Exception;
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUserinfo(Userinfo userinfo) throws Exception;
	/**
	 * Service method for named queries
	 */
}