package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Gas;

@Repository
@Transactional
public class GasDAOImpl implements GasDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Gas> index() {
		String query = "SELECT g FROM Gas g";
		List<Gas> index = em.createQuery(query, Gas.class).getResultList();
		System.out.println(index);
		return index;
	}

	@Override
	public Gas show(int id) {
		
		return em.find(Gas.class, id);
	}

	@Override
	public Gas create(String json) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			Gas newGas = mapper.readValue(json, Gas.class);
			em.persist(newGas);
			em.flush();
			return newGas;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
//	@Override
//	public Quiz update(int id, String json) {
//		ObjectMapper mapper = new ObjectMapper();
//		
//		try {
//			Quiz updateQuiz = mapper.readValue(json, Quiz.class);
//			Quiz oldQuiz = em.find(Quiz.class, id);
//			oldQuiz.setName(updateQuiz.getName());
//			em.persist(oldQuiz);
////			em.flush();
//			return oldQuiz;
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
	
	@Override
	public Gas update(int id, String json) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			Gas updateGas = mapper.readValue(json, Gas.class);
			Gas oldGas = em.find(Gas.class, id);
			oldGas.setNumGallons(updateGas.getNumGallons());
			oldGas.setPricePerGallon(updateGas.getPricePerGallon());
			oldGas.setMilesDriven(updateGas.getMilesDriven());
			oldGas.setMpg(updateGas.getMpg());
			em.persist(oldGas);
			System.out.println("DAO: " + oldGas);
			return oldGas;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean delete(int id) {
		
		return false;
	}

}
