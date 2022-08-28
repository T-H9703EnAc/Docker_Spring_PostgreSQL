package jp.com.app.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import jp.com.app.dto.SampleDto1Request;
import jp.com.app.dto.SampleDto1Response;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SampleService1ImplTest {
    @Autowired
    SampleService1 service1;

    @Test
    public void Test1()throws Exception{
        List<SampleDto1Response> res = service1.getSelectSql();
        System.out.println(res);
    }

    @Test
    public void Test2()throws Exception{
        SampleDto1Request req = new SampleDto1Request();
        req.setId("4");
        req.setName("Sirou");
        service1.getInsertSql(req);        
    }

    @Test
    public void Test3()throws Exception{
        SampleDto1Request req = new SampleDto1Request();
        req.setId("4");
        req.setName("Gorou");
        service1.getUpdateSql(req);
        
    }

    @Test
    public void Test4()throws Exception{
        SampleDto1Request req = new SampleDto1Request();
        req.setId("4");
        service1.getDeleteSql(req);
        
    }
}
