package com.fhir.scheduler.util;

public class ClassJobRequest {
    private String jobName ;
    private String startmethod ;
    private String stopmethod ;
    private String classpath ;
    private String parameters ;
    private boolean enableCron ;

    public ClassJobRequest(String jobName, String startmethod, String stopmethod, String classpath, String parameters, boolean enableCron) {
        this.jobName = jobName;
        this.startmethod = startmethod;
        this.stopmethod = stopmethod;
        this.classpath = classpath;
        this.parameters = parameters;
        this.enableCron = enableCron;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getStartmethod() {
        return startmethod;
    }

    public void setStartmethod(String startmethod) {
        this.startmethod = startmethod;
    }

    public String getStopmethod() {
        return stopmethod;
    }

    public void setStopmethod(String stopmethod) {
        this.stopmethod = stopmethod;
    }

    public String getClasspath() {
        return classpath;
    }

    public void setClasspath(String classpath) {
        this.classpath = classpath;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public boolean isEnableCron() {
        return enableCron;
    }

    public void setEnableCron(boolean enableCron) {
        this.enableCron = enableCron;
    }

    public ClassJobRequest() {
    }
}
