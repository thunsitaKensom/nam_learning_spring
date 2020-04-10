package com.cu.thesis.WeMuBPMN.service;

import com.cu.thesis.WeMuBPMN.entity.Project;

public interface ProjectService {

    Iterable<Project> listAllProjects();

    Project getProjectById(Integer id);

    Project saveProject(Project product);

    void deleteProject(Integer id);
}