package com.cu.thesis.WeMuBPMN.repository;

import com.cu.thesis.WeMuBPMN.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>
{

}