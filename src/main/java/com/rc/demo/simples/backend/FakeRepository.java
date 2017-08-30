package com.rc.demo.simples.backend;

import org.springframework.stereotype.Repository;

@Repository
public class FakeRepository {

    public String sayHello(){
        try{
            Thread.sleep(200);
        }catch(Exception e){
            //ignore
        }
        return "Hello World";
    }
}
