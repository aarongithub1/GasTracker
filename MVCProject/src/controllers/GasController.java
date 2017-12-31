package controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.GasDAO;
import entities.Gas;

@RestController
public class GasController {
	
	@Autowired
	private GasDAO gasDAO;
	
	@RequestMapping(path="ping", method=RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	@RequestMapping(path="gas", method=RequestMethod.GET)
	public List<Gas> index() {
		return gasDAO.index();
	}
	
	@RequestMapping(path="gas/{id}", method=RequestMethod.GET)
	public Gas show(@PathVariable int id) {
		return gasDAO.show(id);
	}
	
	@RequestMapping(path="gas", method=RequestMethod.POST)
	public Gas create(@RequestBody String json, HttpServletResponse res) {
		Gas g = gasDAO.create(json);
		
		if(g == null) {
			res.setStatus(400);
		}
		else {
			res.setStatus(201);
		}
		
		return g;
		
	}
	
	@RequestMapping(path="gas/{id}", method=RequestMethod.PUT)
	public Gas update(@PathVariable int id, @RequestBody String json, HttpServletResponse res) {
		Gas g = gasDAO.update(id, json);
		System.out.println("Controller: " + g);
		
		if(g == null) {
			res.setStatus(400);
		}
		else {
			res.setStatus(201);
		}
		
		return g;
		
	}
	
	
}
