/**
 * 
 */
package com.zliang.autho.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sun.org.apache.xpath.internal.functions.Function;

/**
 * @author zhojiali
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/app-config-test.xml")
public class FunctionSpringServiceTest {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private IFunctionService funcService;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.zliang.autho.service.FunctionSpringService#findFunctionById(int)}.
	 */
	@Test
	public void testFindFunctionById() {
		String jpql = " FROM Function WHERE fid = 1";
		Function function = jdbcTemplate.queryForObject(jpql, Function.class);
		Assert.assertNotNull(function);
	}

	/**
	 * Test method for {@link com.zliang.autho.service.FunctionSpringService#findAllFunctions()}.
	 * @throws Exception 
	 */
	@Test
	public void testFindAllFunctions() throws Exception {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("autho");
		EntityManager em = factory.createEntityManager();
//		List<com.zliang.autho.entities.Function> functions = funcService.findAllFunctions();
		String jpql = " From Function ";
		Query query = em.createQuery(jpql);
		assertNotNull(query);
		List<Function> resultList = query.getResultList();
		assertNotNull(resultList);
		assertEquals(3, resultList.size());
		em.close();
		factory.close();
		
	}

	/**
	 * Test method for {@link com.zliang.autho.service.FunctionSpringService#persistFunction(com.zliang.autho.entities.Function)}.
	 */
	@Test
	public void testPersistFunction() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.zliang.autho.service.FunctionSpringService#removeFunction(com.zliang.autho.entities.Function)}.
	 */
	@Test
	public void testRemoveFunction() {
		fail("Not yet implemented");
	}

}
