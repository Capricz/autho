package com.zliang.autho.service;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.zliang.autho.entities.Module;
import com.zliang.autho.dao.IModuleDao;

/**
 * The service class for the Module entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class ModuleSpringService implements IModuleService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IModuleDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "UserinfoService";
	
	public ModuleSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IModuleService</code> instance.
	 */
	public static IModuleService getInstance(ApplicationContext context) {
		return (IModuleService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Module findModuleById(int id) throws Exception {
		try {
			return getDao().findModuleById(id);
		} catch (RuntimeException e) {
			throw new Exception("findModuleById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Module</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Module> findAllModules() throws Exception {
		try {
			return getDao().findAllModules();
		} catch (RuntimeException e) {
			throw new Exception("findAllModules failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistModule(Module module) throws Exception {
		try {
			getDao().persistModule(module);
		} catch (RuntimeException e) {
			throw new Exception("persistModule failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeModule(Module module) throws Exception {
		try {
			getDao().removeModule(module);
		} catch (RuntimeException e) {
			throw new Exception("removeModule failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IModuleDao dao) {
		this.dao = dao;
	}
	public IModuleDao getDao() {
		return this.dao;
	}
}