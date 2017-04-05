package org.launchcode.controllers;

import org.launchcode.models.*;
import org.launchcode.models.data.JobData;
import org.launchcode.models.forms.JobForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "job")
public class JobController {

    private JobData jobData = JobData.getInstance();
    private CoreCompetency coreCompetencyId;
    private Location locationId;
    public String name;
    private PositionType positionTypeId;
    private Employer employerId;

    // The detail display for a given Job at URLs like /job?id=17
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id) {

        // TODO #1 - get the Job with the given ID and pass it into the view
        Job someJob = jobData.findById(id);//rs
        model.addAttribute("job", someJob);
        return "job-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new JobForm());
        return "new-job";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid JobForm jobForm, Errors errors, RedirectAttributes attributes) {

        // TODO #6 - Validate the JobForm model, and if valid, create a
        // new Job and add it to the jobData data store. Then
        // redirect to the job detail view for the new Job.


        if (errors.hasErrors()){
            return "new-job";
        }
//        get id from form, find id in list of jobs, pass to newJob
        Job newJob = new Job(jobForm.getName(), jobData.getEmployers().findById(jobForm.getEmployerId()),
                jobData.getLocations().findById(jobForm.getLocationId()),

                jobData.getPositionTypes().findById(jobForm.getPositionTypeId()),
                jobData.getCoreCompetencies().findById(jobForm.getCoreCompetencyId()));

// add to jobData
        jobData.add(newJob);
// add id
            attributes.addAttribute("id", newJob.getId());
            return "redirect:/job";


    }
}

