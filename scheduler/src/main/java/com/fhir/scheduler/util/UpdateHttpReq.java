package com.fhir.scheduler.util;

public class UpdateHttpReq {


    private String jobName ;
    private String startUrl ;

    public UpdateHttpReq() {
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getStartUrl() {
        return startUrl;
    }

    public void setStartUrl(String startUrl) {
        this.startUrl = startUrl;
    }

    public String getStopUrl() {
        return stopUrl;
    }

    public void setStopUrl(String stopUrl) {
        this.stopUrl = stopUrl;
    }

    public boolean isEnableCron() {
        return enableCron;
    }

    public void setEnableCron(boolean enableCron) {
        this.enableCron = enableCron;
    }

    public UpdateHttpReq(String jobName, String startUrl, String stopUrl, boolean enableCron) {
        this.jobName = jobName;
        this.startUrl = startUrl;
        this.stopUrl = stopUrl;
        this.enableCron = enableCron;
    }

    private String stopUrl ;
    private boolean enableCron;



}
