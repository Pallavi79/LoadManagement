package com.developer.TransportManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.developer.TransportManagement.entities.Load;
import com.developer.TransportManagement.services.TransportService;

@RestController
public class MyController {
	
	@Autowired
	private TransportService service;
	
	@GetMapping("/home")
	public String home() {
		return "Hello this is home page";
	}

	@GetMapping("/load")
	public List<Load> getLoadDeatils(){
		return this.service.getLoadDetails();
	}
	
	@GetMapping("/load/{loadId}")
	public Load getLoad(@PathVariable String loadId) {
		return this.service.getLoad(Long.parseLong(loadId));
	}
	
	@PostMapping("/load")
	public Load addLoad(@RequestBody Load load) {
		return this.service.addLoad(load);
	}
	
	@PutMapping("/load/{loadId}")
	public Load updateLoad(@RequestBody Load load,@PathVariable String loadId) {
		return this.service.updateLoad(load,Long.parseLong(loadId));
	}
	
	@DeleteMapping("/load/{loadId}")
	public String deleteLoad(@PathVariable String loadId){
		try {
			this.service.deleteLoad(Long.parseLong(loadId));
			return "Sucessfully deleted";
		}
		catch(Exception e){
			return "INTERNAL_SERVER_ERROR";
		}
	}
}
