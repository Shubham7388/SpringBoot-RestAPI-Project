package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Politician;
import com.nt.service.IPoliticianService;

@RestController
@RequestMapping("/politician-api")
public class PoliticianOperationController 
{
	@Autowired
	private IPoliticianService politicianService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerPolitician(@RequestBody Politician politician) {
		try {
			String msg=politicianService.registerPolitician(politician);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Problem in internal server:: ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/show")
	public ResponseEntity<List<Politician>> showAllPolitician() {
		List<Politician> politician=politicianService.showAllPolitician();
		return new ResponseEntity<List<Politician>>(politician,HttpStatus.OK);
	}
	
	@GetMapping("/findbyId/{pid}")
	public ResponseEntity<Politician> showPoliticianById(@PathVariable("pid") Integer id) {
		Politician politician=politicianService.showPoliticianById(id);
		return new ResponseEntity<Politician>(politician,HttpStatus.OK);
	}
}
