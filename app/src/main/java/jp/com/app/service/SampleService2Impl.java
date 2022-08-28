package jp.com.app.service;

import org.springframework.stereotype.Service;

import jp.com.app.dto.SampleDto2Request;
import jp.com.app.exception.DBException;

@Service
public class SampleService2Impl implements SampleService2{

    @Override
    public void getError(SampleDto2Request req) throws DBException {
        if(req.getId().equals("1")){
            System.out.println("正常です。");
        }else{
            throw new DBException();
        }   
    }

    @Override
    public void postError(SampleDto2Request req) throws DBException{
        if(req.getId().equals("1")){
            System.out.println("正常です。");
        }else{
            throw new DBException();
        }
    }
}
