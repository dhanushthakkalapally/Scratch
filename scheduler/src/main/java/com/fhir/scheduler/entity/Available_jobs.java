package com.fhir.scheduler.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Component
public class Available_jobs {

    @Id
    private String job_name;

    private String class_path ;
    private String start_method;
    private String stop_method;

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public Boolean getStatus() {
        return status;
    }

    private  String parameters;

    private Date start_time_sp;

    public Date getStart_time_sp() {
        return start_time_sp;
    }

    public void setStart_time_sp(Date start_time_sp) {
        this.start_time_sp = start_time_sp;
    }

    public String getClass_path() {
        return class_path;
    }

    public void setClass_path(String class_path) {
        this.class_path = class_path;
    }

    public String getStart_method() {
        return start_method;
    }

    public void setStart_method(String start_method) {
        this.start_method = start_method;
    }

    public String getStop_method() {
        return stop_method;
    }

    public void setStop_method(String stop_method) {
        this.stop_method = stop_method;
    }

    private Boolean status ;

    private String start_url;


    private String stop_url;

    private boolean cron_enabled ;

    public boolean isCron_enabled() {
        return cron_enabled;
    }

    public void setCron_enabled(boolean cron_enabled) {
        this.cron_enabled = cron_enabled;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getStart_url() {
        return start_url;
    }

    public void setStart_url(String start_url) {
        this.start_url = start_url;
    }

    public String getStop_url() {
        return stop_url;
    }

    public void setStop_url(String stop_url) {
        this.stop_url = stop_url;
    }


}
