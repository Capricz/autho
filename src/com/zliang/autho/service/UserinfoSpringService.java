package com.zliang.autho.service;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.zliang.autho.entities.Userinfo;
import com.zliang.autho.dao.IUserinfoDao;

/**
 * The service class for the Userinfo entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class UserinfoSpringService implements IUserinfoService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IUserinfoDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "UserinfoService";
	
	public UserinfoSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IUserinfoService</code> instance.
	 */
	public static IUserinfoService getInstance(ApplicationContext context) {
		return (IUserinfoService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Userinfo findUserinfoById(int id) throws Exception {
		try {
			return getDao().findUserinfoById(id);
		} catch (RuntimeException e) {
			throw new Exception("findUserinfoById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Userinfo</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Userinfo> findAllUserinfos() throws Exception {
		try {
			return getDao().findAllUserinfos();
		} catch (RuntimeException e) {
			throw new Exception("findAllUserinfos failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistUserinfo(Userinfo userinfo) throws Exception {
		try {
			getDao().persistUserinfo(userinfo);
		} catch (RuntimeException e) {
			throw new Exception("persistUserinfo failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeUserinfo(Userinfo userinfo) throws Exception {
		try {
			getDao().removeUserinfo(userinfo);
		} catch (RuntimeException e) {
			throw new Exception("removeUserinfo failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IUserinfoDao dao) {
		this.dao = dao;
	}
	public IUserinfoDao getDao() {
		return this.dao;
	}
}