package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	
	//For register politician
	@PostMapping("/register")
	public ResponseEntity<String> registerPolitician(@RequestBody Politician politician) {
		try {
			String msg=politicianService.registerPolitician(politician);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Problem in internal server:: ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//for getting all politician record
	@GetMapping("/show")
	public ResponseEntity<List<Politician>> showAllPolitician() {
		List<Politician> politician=politicianService.showAllPolitician();
		return new ResponseEntity<List<Politician>>(politician,HttpStatus.OK);
	}
	
	
	//find politician record by id
	@GetMapping("/findbyId/{pid}")
	public ResponseEntity<Politician> showPoliticianById(@PathVariable("pid") Integer id) {
		Politician politician=politicianService.showPoliticianById(id);
		return new ResponseEntity<Politician>(politician,HttpStatus.OK);
	}
	
	
	//for getting politician record by party
	@GetMapping("/findByparty/{party1}/{party2}/{party3}")
	public ResponseEntity<?> showPoliticianByParty(@PathVariable(required = false) String party1,
																																	@PathVariable(required = false) String party2,
																																	@PathVariable(required = false) String party3) {
		try {
			List<Politician> list=politicianService.showPoliticianById(party1, party2, party3);
			return new ResponseEntity<List<Politician>>(list,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Internal Problem:: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/modify")
	public ResponseEntity<?> updatePolitician(@RequestBody Politician poli) {
		try {
			String msg=politicianService.updatePolitician(poli);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findbyName/{name}")
	public ResponseEntity<?> showPoliticianbyName(@PathVariable("name") String name) {
		try {
			List<Politician> list=politicianService.showPoliticianByName(name);
			return new ResponseEntity<List<Politician>>(list,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Internal Problem:: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
		//In this partial method I'm passing party and name as parameter
//	@PatchMapping("/partial-update/{pid}/{party}/{pname}")
//	public ResponseEntity<?> partialUpdate(@PathVariable("pid") Integer id, @PathVariable("party") String party ,@PathVariable("pname") String name ) throws Exception {
//		String msg=politicianService.partialPoliticianUpdate(id, party, name);
//		return new ResponseEntity<String>(msg,HttpStatus.OK);
//	}
	
	////In this partial method I'm passing party and name as request body
	@PatchMapping("/partial-update/{pid}")
	public ResponseEntity<?> partialUpdate(@PathVariable("pid") Integer id, @RequestBody Politician poli ) throws Exception {
		String msg=politicianService.partialPoliticianUpdate(id, poli);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<?> politicianDeleteByID(@PathVariable("pid") Integer id) throws Exception {
		String msg=politicianService.deletePoliticianById(id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
