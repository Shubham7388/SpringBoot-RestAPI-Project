package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Politician;
import com.nt.exception.PoliticianNotFoundException;
import com.nt.repository.IPoliticianRepo;


@Service("politicianService")
public class PoliticianServiceImpl implements IPoliticianService 
{
	@Autowired
	private IPoliticianRepo politicianRepo;
	
	
	@Override
	public String registerPolitician(Politician politician) {
		int id=politicianRepo.save(politician).getPid();
		return "Politician is registred with id:: "+id;
	}


	@Override
	public List<Politician> showAllPolitician() {
		List<Politician> list=politicianRepo.findAll();
		list.sort((t1,t2)->t1.getPid().compareTo(t2.getPid()));
		return list;
	}


	@Override
	public Politician showPoliticianById(Integer pid) throws PoliticianNotFoundException {
		Politician list=politicianRepo.findById(pid).orElseThrow(()->new PoliticianNotFoundException(pid+" :: Politician not found"));
		return list;
	}


	@Override
	public List<Politician> showPoliticianById(String party1, String party2, String party3) throws PoliticianNotFoundException {
		List<Politician> list=politicianRepo.showAllPoliticianByParty(party1, party2, party3);
		return list;
	}


	@Override
	public String updatePolitician(Politician poli) throws PoliticianNotFoundException {
		Optional<Politician> politician=politicianRepo.findById(poli.getPid());
		if(politician.isPresent()) {
			politicianRepo.save(poli);
			return poli.getPid()+":: id record is updated";
		} else {
		throw new PoliticianNotFoundException(poli.getPid()+":: Politician not found");
		}
	}


	@Override
	public List<Politician> showPoliticianByName(String name) throws PoliticianNotFoundException {
		List<Politician> list=politicianRepo.showPoliticianByName(name);
		return list;
	}




}
