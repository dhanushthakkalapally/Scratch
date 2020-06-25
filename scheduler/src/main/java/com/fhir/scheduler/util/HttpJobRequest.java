package com.fhir.scheduler.util;

public class HttpJobRequest {
    private String jobName ;
    private String starturl ;
    private String stopurl ;
    private boolean enableCron;

    public HttpJobRequest(String jobName, String starturl, String stopurl, boolean enableCron) {
        this.jobName = jobName;
        this.starturl = starturl;
        this.stopurl = stopurl;
        this.enableCron = enableCron;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getStarturl() {
        return starturl;
    }

    public void setStarturl(String starturl) {
        this.starturl = starturl;
    }

    public String getStopurl() {
        return stopurl;
    }

    public void setStopurl(String stopurl) {
        this.stopurl = stopurl;
    }

    public boolean isEnableCron() {
        return enableCron;
    }

    public void setEnableCron(boolean enableCron) {
        this.enableCron = enableCron;
    }

    public HttpJobRequest() {
    }



}

