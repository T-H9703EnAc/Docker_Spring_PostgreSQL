package jp.com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.com.app.service.SampleService3;

@RestController
@RequestMapping(value = "/api/property")
public class SampleController4 {
    @Autowired
    SampleService3 service3;
    @GetMapping("/getProperty")
    String getTestHelloProperty(){
        return service3.getProperty();
    }
}
