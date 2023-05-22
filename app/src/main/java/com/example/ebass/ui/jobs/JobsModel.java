package com.example.ebass.ui.jobs;

import java.util.Date;

public class JobsModel {

    private int jobId;
    private String jobCategory;
    private String jobDescription;
    private int[] images;
    private int status;
    private Date jobRequestDate;


    public String getJobCategory() {
        return jobCategory;
    }

    public JobsModel setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
        return this;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public JobsModel setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
        return this;
    }

    public int[] getImages() {
        return images;
    }

    public JobsModel setImages(int[] images) {
        this.images = images;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public JobsModel setStatus(int status) {
        this.status = status;
        return this;
    }

    public Date getJobRequestDate() {
        return jobRequestDate;
    }

    public JobsModel setJobRequestDate(Date jobRequestDate) {
        this.jobRequestDate = jobRequestDate;
        return this;
    }

    public int getJobId() {
        return jobId;
    }

    public JobsModel setJobId(int jobId) {
        this.jobId = jobId;
        return this;
    }
}
