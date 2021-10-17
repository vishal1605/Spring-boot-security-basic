package com.jwt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.beans.Clinit;

@Repository
public interface ClientRepository extends JpaRepository<Clinit, Integer> {

	public Clinit findByName(String name);

}
