package com.cu.thesis.WeMuBPMN.service;

import com.cu.thesis.WeMuBPMN.entity.Person;

public interface PersonService
{
    Person viewOwner();
    Iterable<Person> listAllPersons();
    Person getPersonById(Integer id);
    Person savePerson(Person product);
    void deletePerson(Integer id);
}