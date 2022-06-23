package com.example.blogproject.page.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name="PAGE_USER")
@Getter
public class PageUser {

    @Id
    private String uuid;

    private String userName;

    private String address;

    private String intro;
    protected  PageUser(){}
    public PageUser(String uuid,String userName,String address, String intro){
        this.uuid = uuid;
        this.userName = userName;
        this.address = address;
        this.intro = intro;
    }

}
