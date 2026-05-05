package edu.vwcc.jobtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.vwcc.jobtracker.model.JobApplication;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

}