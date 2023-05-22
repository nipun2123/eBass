package com.example.ebass.ui.services;

public class AllCompanyModel {

    private String companyCode;
    private int companyPic;
    private String companyName;
    private String companyCategory;
    private String companyLocation;
    private float companyRate;


    public AllCompanyModel(String companyCode,int companyPic, String companyName, String companyCategory, String companyLocation, float companyRate){
        this.companyCode = companyCode;
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

    public String getCompanyCode() {
        return companyCode;
    }

}
