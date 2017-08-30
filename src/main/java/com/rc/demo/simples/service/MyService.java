package com.rc.demo.simples.service;

import com.rc.demo.simples.backend.FakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

@Service
public class MyService {

    @Autowired
    private FakeRepository fakeRepository;

    public Observable<String> callRepository(){
        return Observable.defer(()->Observable.just(fakeRepository.sayHello()));
    }
}
