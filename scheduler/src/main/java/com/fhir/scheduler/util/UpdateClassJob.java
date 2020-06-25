package com.fhir.scheduler.util;

public class UpdateClassJob {
    private String jobName ;
    private String startMethod ;
    private String stopMethod ;

    public UpdateClassJob() {
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getStartMethod() {
        return startMethod;
    }

    public void setStartMethod(String startMethod) {
        this.startMethod = startMethod;
    }

    public String getStopMethod() {
        return stopMethod;
    }

    public void setStopMethod(String stopMethod) {
        this.stopMethod = stopMethod;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
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

    public UpdateClassJob(String jobName, String startMethod, String stopMethod, String classPath, String parameters, boolean enableCron) {
        this.jobName = jobName;
        this.startMethod = startMethod;
        this.stopMethod = stopMethod;
        this.classPath = classPath;
        this.parameters = parameters;
        this.enableCron = enableCron;
    }

    private String classPath ;
    private String parameters ;
    private boolean enableCron ;

}
