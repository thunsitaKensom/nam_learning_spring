package com.cu.thesis.WeMuBPMN.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min = 3, max = 30)
    private String Proj_name;

    @NotNull
    @Size(min = 3, max = 250)
    private String Proj_desc;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String Proj_date;

    public Project() {

    }

    public Project(String Proj_name, String Proj_desc, String Proj_date) {
        this.Proj_name = Proj_name;
        this.Proj_desc = Proj_desc;
        this.Proj_date = Proj_date;
    }

    public void setId(Integer pId) {
        this.id = pId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setProj_name(String Proj_name) {
        this.Proj_name = Proj_name;
    }

    public String getProj_name() {
        return this.Proj_name;
    }

    public void setProj_desc(String Proj_desc) {
        this.Proj_desc = Proj_desc;
    }

    public String getProj_desc() {
        return this.Proj_desc;
    }

    public void setProj_date(String Proj_date) {
        this.Proj_date = Proj_date;
    }

    public String getProj_date() {
        return this.Proj_date;
    }

}