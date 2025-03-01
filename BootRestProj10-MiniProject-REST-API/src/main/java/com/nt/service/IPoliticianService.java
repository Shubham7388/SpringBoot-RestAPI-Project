package com.nt.service;

import java.util.List;

import com.nt.entity.Politician;
import com.nt.exception.PoliticianNotFoundException;

public interface IPoliticianService
{
	public String registerPolitician(Politician politician);	//register politician
	public List<Politician> showAllPolitician();			//showing all politician
	public Politician showPoliticianById(Integer pid) throws PoliticianNotFoundException;		//showing politician by id
	public List<Politician> showPoliticianById(String party1, String party2, String party3) throws PoliticianNotFoundException;    //showing politician by party
	public String updatePolitician(Politician politician) throws PoliticianNotFoundException;		//Update Politician record Using Put mode request
	public List<Politician> showPoliticianByName(String name) throws PoliticianNotFoundException; 		//find politician by name
//	public String partialPoliticianUpdate(Integer id,String newParty, String name) throws Exception;
	public String partialPoliticianUpdate(Integer id, Politician poli) throws Exception;
	public String deletePoliticianById(Integer id) throws Exception;
}
