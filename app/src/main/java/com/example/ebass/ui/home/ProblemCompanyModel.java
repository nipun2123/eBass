package com.example.ebass.ui.home;

public class ProblemCompanyModel {

    private int companyPic;
    private String companyName;
    private String companyCategory;
    private String companyLocation;
    private float companyRate;


    public ProblemCompanyModel(int companyPic, String companyName, String companyCategory, String companyLocation, float companyRate){
        this.companyPic = companyPic;
        this.companyName = companyName;
        this.companyCategory = companyCategory;
        this.companyLocation = companyLocation;
        this.companyRate = companyRate;
    }

    public int getCompanyPic() {
        return companyPic;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyCategory() {
        return companyCategory;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public float getCompanyRate() {
        return companyRate;
    }
}
