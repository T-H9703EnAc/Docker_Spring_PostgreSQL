package jp.com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.com.app.dto.SampleDto1Request;
import jp.com.app.dto.SampleDto1Response;
import jp.com.app.service.SampleService1;

@RestController
@RequestMapping(value = "/api/post")
public class SampleController2 {
    @Autowired
    SampleService1 service1;
    
    @PostMapping("/selectSql")
    public List<SampleDto1Response> getSelect(){
        return service1.getSelectSql();
    }

    @PostMapping("/insertSql")
    public void getInsert(SampleDto1Request request){
        service1.getInsertSql(request);
        
    }

    @PostMapping("/updateSql")
    public void getUpdate(SampleDto1Request request){
        service1.getUpdateSql(request);
    }

    @PostMapping("/deleteSql")
    public void getDelete(SampleDto1Request request){
        service1.getDeleteSql(request);
    }
}
