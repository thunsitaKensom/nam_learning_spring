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
public class Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min=3, max=30)	
    private String Fistname;

    @NotNull
    @Size(min=3, max=50)	
    private String Lastname;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date BirthDate;

    @NotNull
    @Size(min=3, max=250)	
    private String Address;

    @NotNull
    @Size(min=5, max=5)	
    private String Zipcode;

    @NotNull
    @Size(min=5, max=50)	
    private String Email;

    @NotNull
    @Size(min=9, max=10)	
    private String Phone;

    public Person()
    {

    }
    
    public Person(String pFirstname, String pLastname, Date pBirthDate, String pAddress, String pZipcode, String pEmail, String pPhone)
    {
        this.Fistname = pFirstname;
        this.Lastname = pLastname;
        this.BirthDate = pBirthDate;
        this.Address = pAddress;
        this.Zipcode = pZipcode;
        this.Email = pEmail;
        this.Phone = pPhone;
    }

    public void setId(Integer pId)
    {
        this.id = pId;
    }

    public Integer getId()
    {
        return this.id;
    }

    public void setFirstname(String pFirstname)
    {
        this.Fistname = pFirstname;
    }

    public String getFirstname()
    {
        return this.Fistname;
    }

    public void setLastname(String pLastname)
    {
        this.Lastname = pLastname;
    }

    public String getLastname()
    {
        return this.Lastname;
    }

    public String getFullname()
    {
        return this.getFirstname() + " " + this.getLastname();
    }

    public void setBirthDate(Date pBirthDate)
    {
        this.BirthDate = pBirthDate;
    }

    public Date getBirthDate()
    {
        return this.BirthDate;
    }

    public void setAddress(String pAddress)
    {
        this.Address = pAddress;
    }

    public String getAddress()
    {
        return this.Address;
    }

    public void setZipcode(String pZipcode)
    {
        this.Zipcode = pZipcode;
    }

    public String getZipcode()
    {
        return this.Zipcode;
    }

    public void setEmail(String pEmail)
    {
        this.Email = pEmail;
    }

    public String getEmail()
    {
        return this.Email;
    }

    public void setPhone(String pPhone)
    {
        this.Phone = pPhone;
    }

    public String getPhone()
    {
        return this.Phone;
    }
}