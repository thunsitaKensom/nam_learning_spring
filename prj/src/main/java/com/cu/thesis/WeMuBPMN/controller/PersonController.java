package com.cu.thesis.WeMuBPMN.controller;

import com.cu.thesis.WeMuBPMN.entity.Person;
import com.cu.thesis.WeMuBPMN.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonController
{
    @Autowired
    private PersonService personService;
    
    @GetMapping(value ="/person/owner")
    public String index(ModelMap model){
        Person person = personService.viewOwner();
        //person - parameter แรก ถูกเอาไปใช้ที่หน้า UI
        model.addAttribute("person",person);
        //บอกว่าไฟล์เราอยู่ที่ Folder person ไฟล์ index.html
        return "person/owner";
    }

    /**
     * List all products.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("persons", personService.listAllPersons());
        return "person/persons";
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "person/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("person", personService.getPersonById(id));
        return "person/viewPerson";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping(value = "person/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("person", personService.getPersonById(id));
        return "person/editPerson";
    }

    @RequestMapping(value = "/")
    public String home(Model model) {
        Person person = personService.getPersonById(10);
        model.addAttribute("person", person);
        model.addAttribute("title", person.getFullname()+"!");
        return "home/index";
    }



    /**
     * New person.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "person/new")
    public String newProduct(Model model) {
        model.addAttribute("person", new Person());
        return "person/editPerson";
    }

    /**
     * Save person to database.
     *
     * @param person
     * @return
     */
    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public String saveProduct(Person person) {
        personService.savePerson(person);
        return "redirect:/persons";
        //return "redirect:/person/" + person.getId();
    }

    /**
     * Delete person by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "person/delete/{id}")
    public String delete(@PathVariable Integer id) {
        personService.deletePerson(id);
        return "redirect:/persons";
    }
}