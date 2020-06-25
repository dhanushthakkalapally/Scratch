package com.fhir.scheduler.service;

import com.fhir.scheduler.entity.Available_jobs;
import com.fhir.scheduler.repo.History_repo;
import com.fhir.scheduler.entity.History;
import com.fhir.scheduler.repo.Jobs_repo;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JobsListener implements JobListener{
	@Autowired
	CheckInterrupted checkInterrupted;

	@Autowired
	History_repo repo;

	@Autowired
	Jobs_repo jobs_repo;



	@Override
	public String getName() {
		return "globalJob";
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		System.out.println("JobsListener.jobToBeExecuted()");
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		System.out.println("JobsListener.jobExecutionVetoed()");
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		String jobName = context.getJobDetail().getKey().getName();
	Available_jobs job =  jobs_repo.findAvailable_jobsByJob_name(jobName);
	if(job.isCron_enabled() ||(!job.isCron_enabled() & context.getJobDetail().getJobDataMap().getString("status_queue")=="failed")) {
			checkInterrupted.deleteIfExists(context.getJobDetail().getKey().getName());
			History history = new History();
			history.setJob_name(context.getJobDetail().getKey().getName());
			history.setStatus(context.getJobDetail().getJobDataMap().getString("status"));
			history.setInformation(context.getJobDetail().getJobDataMap().getString("information"));
			history.setJob_start_time(context.getFireTime());
			history.setJob_complete_time(new Date((context.getFireTime().getTime() + context.getJobRunTime())));
			if(context.getJobDetail().getJobDataMap().getString("status_queue")=="failed"){
				job.setStatus(false);
				job.setStart_time_sp(null);
				jobs_repo.save(job);
			}
			repo.save(history);
			System.out.println("JobsListener.jobWasExecuted()");
		}
	}

}
