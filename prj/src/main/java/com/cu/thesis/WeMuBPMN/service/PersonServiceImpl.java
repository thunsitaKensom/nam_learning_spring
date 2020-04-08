package com.cu.thesis.WeMuBPMN.service;

import java.util.Date;

import com.cu.thesis.WeMuBPMN.entity.Person;
import com.cu.thesis.WeMuBPMN.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService
{
 
    private PersonRepository personRepository;

    @Autowired
    public void setPersonRepository(PersonRepository personRepository)
    {
        this.personRepository = personRepository;
    }
    
    @Override
    public Person viewOwner()
    {
        return new Person("Chatri", "Ngambenchawong", new Date(03/05/1996), "169-171","48110","thunsita.k@kkumail.com", "0957237199");
    }

    @Override
    public Iterable<Person> listAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Integer id) {
        return personRepository.findById(id).get();
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }



    

}