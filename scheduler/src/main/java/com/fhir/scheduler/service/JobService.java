package com.fhir.scheduler.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.fhir.scheduler.entity.Available_jobs;
import com.fhir.scheduler.entity.History;
import com.fhir.scheduler.util.ClassJobRequest;
import com.fhir.scheduler.util.HttpJobRequest;
import com.fhir.scheduler.util.UpdateClassJob;
import com.fhir.scheduler.util.UpdateHttpReq;
import org.springframework.scheduling.quartz.QuartzJobBean;

public interface JobService {
	boolean scheduleOneTimeJob(String jobName, Class<? extends QuartzJobBean> jobClass, Date date,String jobType);
	boolean scheduleCronJob(String jobName, Class<? extends QuartzJobBean> jobClass, Date date, String cronExpression,String jobType);
	
	boolean updateOneTimeJob(String jobName, Date date);
	boolean updateCronJob(String jobName, Date date, String cronExpression);
	
	boolean unScheduleJob(String jobName);
	boolean deleteJob(String jobName);
	boolean pauseJob(String jobName);
	boolean resumeJob(String jobName);
	boolean startJobNow(String jobName);
	boolean isJobRunning(String jobName);
	List<Map<String, Object>> getAllJobs();
	boolean isJobWithNamePresent(String jobName);
	String getJobState(String jobName);
	boolean stopJob(String jobName);
	List<Available_jobs>  getAvailableJobs();

	boolean checkJobDetailsExists(String jobName);

	String getJobType(String jobName);
	boolean checkValidDate(Date date) throws ParseException;
	List<History> getLog();

	boolean addHttpJob(HttpJobRequest payload);

	boolean addClassJob(ClassJobRequest req);

	List<Available_jobs> getConfiguredJobs();

	boolean deleteConfiguredJob(String jobName);

	boolean updateHttpJob(UpdateHttpReq payload);

	boolean updateClassJob(UpdateClassJob req);

	boolean stopSpecialJob(String jobName);

	List<Map<String, Object>> getSpecialJobs();
}
