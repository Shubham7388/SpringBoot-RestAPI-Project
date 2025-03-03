package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Politician;

public interface IPoliticianRepo extends JpaRepository<Politician, Integer> {

	@Query("from Politician where party IN (:party1,:party2,:party3) order by pname asc")
	public List<Politician> showAllPoliticianByParty(String party1,String party2, String party3);
	
	@Query("from Politician where pname=:name")
	public List<Politician> showPoliticianByName(@Param("name") String name);
}
