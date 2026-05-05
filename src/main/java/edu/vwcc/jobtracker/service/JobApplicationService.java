package edu.vwcc.jobtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vwcc.jobtracker.model.JobApplication;
import edu.vwcc.jobtracker.repository.JobApplicationRepository;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository repository;

    public List<JobApplication> getAllJobs() {
        return repository.findAll();
    }

    public JobApplication saveJob(JobApplication job) {
        return repository.save(job);
    }

    public JobApplication getJobById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteJob(Long id) {
        repository.deleteById(id);
    }
}