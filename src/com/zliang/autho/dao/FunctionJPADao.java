package com.zliang.autho.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.zliang.autho.entities.Function;

import org.springframework.stereotype.Repository;

/**
 * The DAO class for the Function entity.
 */
@Repository
public class FunctionJPADao implements IFunctionDao {
    @PersistenceContext
    private EntityManager em;

	public FunctionJPADao() {
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
	public Function findFunctionById(int id) {
		return (Function)em.find(Function.class, new Integer(id));
	}
	/**
	 * Return all persistent instances of the <code>Function</code> entity.
	 */
	@SuppressWarnings("unchecked")
	public List<Function> findAllFunctions() {
        try {
    		String jpqlString = "select function from " + Function.class.getSimpleName() + " function";
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
	public void persistFunction(Function function) {
		em.persist(em.merge(function));
	}
	/**
	 * Remove the given persistent instance.
	 */
	public void removeFunction(Function function) {
		/*In JPA, objects detach automatically when they are serialized or when a persistence context ends.
		 The merge method returns a managed copy of the given detached entity.*/
		em.remove(em.merge(function));
	}
}