package jp.com.app.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class PropertyInfomation {
    @Autowired
    private Environment environment;

    public String getHello() {
        return environment.getProperty("test.data");    
    }

}
