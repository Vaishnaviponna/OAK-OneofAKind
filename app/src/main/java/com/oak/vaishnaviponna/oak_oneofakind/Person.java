package com.oak.vaishnaviponna.oak_oneofakind;



/**
 * Created by Kartheeka on 3/3/2017.
 */

public class Person {
    //name and address string
    public String name;
    private String address;
    private String phoneno;
    private String pincode;
    private String email;
    private String password;
    private String imagepath;
    private String uid;

    public Person() {
      /*Blank default constructor essential for Firebase*/
    }
    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String name) {
        this.uid = uid;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneno(){ return phoneno;}

    public void setPhoneno(String phoneno){ this.phoneno= phoneno;}



    public String getPincode(){ return pincode;}

    public void setPincode(String pincode){ this.pincode= pincode;}


    public String getEmail(){ return email;}

    public void setEmail(String email){ this.email= email;}


    public String getPassword(){ return password;}

    public void setPassword(String password){ this.password= password;}

}
