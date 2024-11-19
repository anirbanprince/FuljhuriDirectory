package com.proseobd.fuljhuridirectory.datamodels;

public class UpMemberData {

    private String name;
    private String designation;
    private String mobile;
    private String wordNo;
    private String profileImage;
    private String email;


    public UpMemberData () {}

    public UpMemberData(String name, String designation, String mobile, String wordNo, String profileImage, String email) {

        this.name = name;
        this.designation = designation;
        this.mobile = mobile;
        this.wordNo = wordNo;
        this.profileImage = profileImage;
        this.email = email;

    }


    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getWordNo() {
        return wordNo;
    }

    public void setWordNo(String wordNo) {
        this.wordNo = wordNo;
    }

}
