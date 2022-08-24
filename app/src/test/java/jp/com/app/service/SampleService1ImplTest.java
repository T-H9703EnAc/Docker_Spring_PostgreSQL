package jp.com.app.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jp.com.app.dto.SampleDto1Response;

@SpringBootTest
public class SampleService1ImplTest {
    @Autowired
    SampleService1 service1;

    @Test
    public void Test1()throws Exception{
        List<SampleDto1Response> res = service1.getSelectSql();

        System.out.println(res);
    }
}
