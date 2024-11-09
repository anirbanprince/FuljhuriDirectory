package com.proseobd.fuljhuridirectory.datamodels;

public class WorkshopData {

    private String name;
    private String owner;
    private String address;
    private String mobile;
    private String email;
    private String profileImage;

    public WorkshopData () {}

    public WorkshopData(String name, String owner, String address, String mobile, String email, String profileImage) {

        this.name = name;
        this.owner = owner;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.profileImage = profileImage;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
