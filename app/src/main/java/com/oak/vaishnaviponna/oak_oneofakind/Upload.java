package com.oak.vaishnaviponna.oak_oneofakind;

/**
 * Created by Kartheeka on 3/5/2017.
 */

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Belal on 2/23/2017.
 */
@IgnoreExtraProperties
public class Upload{

    public String name;
    public String url;
    public String email;
    public String phoneno;
    public String username;
    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public Upload() {
    }

    public Upload(String name, String url, String email,String phoneno,String username) {
        this.name = name;
        this.url= url;
        this.email=email;
        this.phoneno=phoneno;
        this.username=username;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getEmail(){return email;}
    public String getPhoneno(){return phoneno;}
    public String getUsername(){return username;}
}