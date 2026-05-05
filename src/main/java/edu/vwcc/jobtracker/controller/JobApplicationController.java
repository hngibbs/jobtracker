package edu.vwcc.jobtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.vwcc.jobtracker.model.JobApplication;
import edu.vwcc.jobtracker.service.JobApplicationService;

@Controller
public class JobApplicationController {

    @Autowired
    private JobApplicationService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("jobs", service.getAllJobs());
        return "index";
    }

    @GetMapping("/new")
    public String showNewJobForm(Model model) {
        model.addAttribute("job", new JobApplication());
        return "form";
    }

    @PostMapping("/save")
    public String saveJob(@ModelAttribute("job") JobApplication job) {
        service.saveJob(job);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteJob(@PathVariable Long id) {
        service.deleteJob(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        JobApplication job = service.getJobById(id);
        model.addAttribute("job", job);
        return "form";
    }
}