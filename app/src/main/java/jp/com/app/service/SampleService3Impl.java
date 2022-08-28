package jp.com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.com.app.util.PropertyInfomation;

@Service
public class SampleService3Impl implements SampleService3{
    @Autowired
    PropertyInfomation property;

    @Override
    public String getProperty() {
        return property.getHello();
    }
    
}
