package jp.com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.com.app.service.SampleService1;
import jp.com.app.dto.SampleDto1Request;
import jp.com.app.dto.SampleDto1Response;

@RestController
@RequestMapping(value = "/api/get")
public class SampleController1 {
    @Autowired
    SampleService1 service1;
    
    @GetMapping("/selectSql")
    public List<SampleDto1Response> getSelect(){
        return service1.getSelectSql();
    }

    @GetMapping("/insertSql")
    public void getInsert(SampleDto1Request request){
        service1.getInsertSql(request);
        
    }

    @GetMapping("/updateSql")
    public void getUpdate(SampleDto1Request request){
        service1.getUpdateSql(request);
    }

    @GetMapping("/deleteSql")
    public void getDelete(SampleDto1Request request){
        service1.getDeleteSql(request);
    }
}

