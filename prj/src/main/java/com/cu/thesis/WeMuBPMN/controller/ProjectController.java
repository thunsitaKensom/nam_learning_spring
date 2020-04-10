package com.cu.thesis.WeMuBPMN.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cu.thesis.WeMuBPMN.entity.Project;
import com.cu.thesis.WeMuBPMN.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    /**
     * New person.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "project/new")
    public String newProduct(Model model) {
        model.addAttribute("project", new Project());
        return "project/editProject";
    }

    /**
     * Save person to database.
     *
     * @param person
     * @return
     */
    @RequestMapping(value = "/project", method = RequestMethod.POST)
    public String saveProduct(Project project) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        project.setProj_date(dateFormat.format(date));
        projectService.saveProject(project);
        return "redirect:/projects";
    }

    /**
     * List all products.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("projects", projectService.listAllProjects());
        return "project/projects";
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "project/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("project", projectService.getProjectById(id));
        return "project/viewProject";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping(value = "project/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("project", projectService.getProjectById(id));
        return "project/editProject";
    }

    /**
     * Delete person by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "project/delete/{id}")
    public String delete(@PathVariable Integer id) {
        projectService.deleteProject(id);
        return "redirect:/projects";
    }

}