package com.zliang.autho.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.zliang.autho.entities.Module;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Module entity.
 */
@Repository
public class ModuleJPADao implements IModuleDao {
    @PersistenceContext
    private EntityManager em;

	public ModuleJPADao() {
		super();
	}
	/**
	 * Return the persistent entities returned from a named query.
	 */
	@SuppressWarnings("unchecked")
	public List findByNamedQuery(String queryName) {
		Query queryObject = em.createNamedQuery(queryName);
		return queryObject.getResultList();
	}
	/**
	 * Return the persistent entities returned from a named query with named parameters.
	 */
	@SuppressWarnings("unchecked")
	public List findByNamedQuery(String queryName, String[] paramNames, Object[] paramValues) {
		if (paramNames.length != paramValues.length) {
			throw new IllegalArgumentException();
		}
		Map<String, Object> params = new java.util.HashMap<String, Object>(paramNames.length);
		for (int i = 0; i < paramNames.length; ++i) {
			params.put(paramNames[i], paramValues[i]);
		}
		
		Query queryObject = em.createNamedQuery(queryName);
		if (params != null) {
			for (Map.Entry<String, ?> entry : params.entrySet()) {
				queryObject.setParameter(entry.getKey(), entry.getValue());
			}
		}
		return queryObject.getResultList();

	}
	/**
	 * Find an entity by its id (primary key).
	 * @return The found entity instance or null if the entity does not exist.
	 */
	public Module findModuleById(int id) {
		return (Module)em.find(Module.class, new Integer(id));
	}
	/**
	 * Return all persistent instances of the <code>Module</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Module> findAllModules() {
        try {
    		String jpqlString = "select module from " + Module.class.getSimpleName() + " module";
            Query query = em.createQuery( jpqlString );
            return query.getResultList();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}
	/**
	 * Make the given instance managed and persistent.
	 */
	public void persistModule(Module module) {
		em.persist(em.merge(module));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeModule(Module module) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(module));
	}
}