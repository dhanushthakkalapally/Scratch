package com.fhir.scheduler.job;

import com.fhir.scheduler.entity.Available_jobs;
import com.fhir.scheduler.repo.Jobs_repo;
import com.fhir.scheduler.util.JobResponseCode;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.web.client.RestTemplate;


@DisallowConcurrentExecution
public class OneTimeJob  extends QuartzJobBean {

    @Autowired
    Jobs_repo jobs_repo;

    String job_name ;






    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        job_name = jobExecutionContext.getJobDetail().getKey().getName();
        Available_jobs job = jobs_repo.findAvailable_jobsByJob_name(job_name);
        if(!job.isCron_enabled()){
           try {
//               RestTemplate req = new RestTemplate();
//               ResponseEntity<String> entity = req.getForEntity(job.getStart_url(), String.class);
               job.setStart_time_sp(null);
               jobs_repo.save(job);
               jobExecutionContext.getJobDetail().getJobDataMap().put("status_queue", "done");
           }catch(Exception e){
               jobExecutionContext.getJobDetail().getJobDataMap().put("status_queue", "failed");
               jobExecutionContext.getJobDetail().getJobDataMap().put("status", JobResponseCode.FAILURE);
               jobExecutionContext.getJobDetail().getJobDataMap().put("information", JobResponseCode.INVALID_URL);
           }

        }






    }
}
