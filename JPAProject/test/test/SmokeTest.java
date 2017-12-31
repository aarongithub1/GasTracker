package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Gas;

public class SmokeTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private Gas gas;

	@Before
	public void set_up() throws Exception {
		this.emf = Persistence.createEntityManagerFactory("GasPU");
		this.em = emf.createEntityManager();
//		this.actor = em.find(Actor.class, 1);
	}
	
	@After
	public void tear_down() throws Exception { 
		this.em.close();
		this.emf.close();
	}
	
	@Test
	public void smoke_test() {
		boolean test = true;
		assertEquals(true, test);
	}
	
	@Test
	public void database_query_test() {
		this.gas = em.find(Gas.class, 2);
		assertEquals(20, gas.getNumGallons(), 0.001);
	}
	
	
}