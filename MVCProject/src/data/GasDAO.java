package data;

import java.util.List;

import entities.Gas;

public interface GasDAO {
	
	public List<Gas> index();
	public Gas show(int id);
	public Gas create(String json);
	public Gas update(int id, String json);
	public boolean delete(int id);

}
