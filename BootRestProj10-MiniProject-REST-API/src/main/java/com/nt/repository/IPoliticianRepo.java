package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Politician;

public interface IPoliticianRepo extends JpaRepository<Politician, Integer> {

}
