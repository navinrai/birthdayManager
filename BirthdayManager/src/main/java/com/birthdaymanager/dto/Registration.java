package com.birthdaymanager.dto;

/**
 * Created by umesh.soni on 3/10/2017.
 */
public class Registration {

    private User user;

    public Registration(){
        System.out.println("Registration constructor");
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
