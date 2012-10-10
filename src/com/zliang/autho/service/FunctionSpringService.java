package com.zliang.autho.service;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.context.ApplicationContext;
import com.zliang.autho.entities.Function;
import com.zliang.autho.dao.IFunctionDao;

/**
 * The service class for the Function entity.
 */
@Transactional(propagation=Propagation.REQUIRED)
public class FunctionSpringService implements IFunctionService {
	/**
	 * The dao instance injected by Spring.
	 */
	private IFunctionDao dao;
	/**
	 * The service Spring bean id, used in the applicationContext.xml file.
	 */
	private static final String SERVICE_BEAN_ID = "UserinfoService";
	
	public FunctionSpringService() {
		super();
	}
	/**
	 * Returns the singleton <code>IFunctionService</code> instance.
	 */
	public static IFunctionService getInstance(ApplicationContext context) {
		return (IFunctionService)context.getBean(SERVICE_BEAN_ID);
	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public Function findFunctionById(int id) throws Exception {
		try {
			return getDao().findFunctionById(id);
		} catch (RuntimeException e) {
			throw new Exception("findFunctionById failed with the id " + id + ": " + e.getMessage());
		}
	}
	/**
	 * Return all persistent instances of the <code>Function</code> entity.
	 */
	@Transactional(propagation=Propagation.NEVER, readOnly=true)
	public List<Function> findAllFunctions() throws Exception {
		try {
			return getDao().findAllFunctions();
		} catch (RuntimeException e) {
			throw new Exception("findAllFunctions failed: " + e.getMessage());
		}
	}

	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistFunction(Function function) throws Exception {
		try {
			getDao().persistFunction(function);
		} catch (RuntimeException e) {
			throw new Exception("persistFunction failed: " + e.getMessage());
		}
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFunction(Function function) throws Exception {
		try {
			getDao().removeFunction(function);
		} catch (RuntimeException e) {
			throw new Exception("removeFunction failed: " + e.getMessage());
		}
	}
	/**
	 * Service method for named queries
	 */

	/**
	 * Called by Spring using the injection rules specified in 
	 * the Spring beans file "applicationContext.xml".
	 */
	public void setDao(IFunctionDao dao) {
		this.dao = dao;
	}
	public IFunctionDao getDao() {
		return this.dao;
	}
}