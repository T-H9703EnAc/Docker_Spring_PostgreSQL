package jp.com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.com.app.dto.SampleDto2Request;
import jp.com.app.exception.DBException;
import jp.com.app.service.SampleService2;

@RestController
@RequestMapping(value = "/api/error")
public class SampleController3 {
    @Autowired
    SampleService2 service2;

    @GetMapping("/getError")
    public void getError(SampleDto2Request request) throws DBException{
        try {
            service2.getError(request);
        } catch (DBException e) {
            e.printStackTrace();
            throw new DBException();
        }
        
    }

    @PostMapping("/postError")
    public void postError(SampleDto2Request request) throws DBException{
        try {
            service2.postError(request);
        } catch (DBException e) {
            e.printStackTrace();
            throw new DBException();
        }       
    }
    
}
