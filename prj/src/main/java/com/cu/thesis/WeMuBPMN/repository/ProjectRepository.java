package com.cu.thesis.WeMuBPMN.repository;

import com.cu.thesis.WeMuBPMN.entity.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}