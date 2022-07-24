package com.example.blogproject.aboutaop.repository;

import org.springframework.stereotype.Repository;

@Repository
public class AopRepository {
    public String save() {
        try{
//            Thread.sleep(1000);
            return "RepositoryOk";
        }catch (Exception e){
            e.printStackTrace();
            return "RepositoryFail";
        }

    }
}
