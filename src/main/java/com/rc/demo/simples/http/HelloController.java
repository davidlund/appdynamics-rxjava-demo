package com.rc.demo.simples.http;

import com.rc.demo.simples.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;

@RestController
public class HelloController {

    @Autowired
    private MyService myService;

    @RequestMapping("/hello")
    public DeferredResult<String> result(){
        Observable<String> observableResult = myService.callRepository();
        DeferredResult<String> deferredResult = new DeferredResult<String>(60000l);
        observableResult.subscribe(m->deferredResult.setResult(m), e->deferredResult.setErrorResult(e));
        return deferredResult;
    }
}
