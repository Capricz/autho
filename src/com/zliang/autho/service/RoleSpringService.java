package com.zliang.autho.service;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.zliang.autho.entities.Role;
import com.zliang.autho.dao.IRoleDao;

/**
 * The service class for the Role entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class RoleSpringService implements IRoleService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IRoleDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "UserinfoService";
	
	public RoleSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IRoleService</code> instance.
	 */
	public static IRoleService getInstance(ApplicationContext context) {
		return (IRoleService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Role findRoleById(int id) throws Exception {
		try {
			return getDao().findRoleById(id);
		} catch (RuntimeException e) {
			throw new Exception("findRoleById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Role</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Role> findAllRoles() throws Exception {
		try {
			return getDao().findAllRoles();
		} catch (RuntimeException e) {
			throw new Exception("findAllRoles failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistRole(Role role) throws Exception {
		try {
			getDao().persistRole(role);
		} catch (RuntimeException e) {
			throw new Exception("persistRole failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeRole(Role role) throws Exception {
		try {
			getDao().removeRole(role);
		} catch (RuntimeException e) {
			throw new Exception("removeRole failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IRoleDao dao) {
		this.dao = dao;
	}
	public IRoleDao getDao() {
		return this.dao;
	}
}