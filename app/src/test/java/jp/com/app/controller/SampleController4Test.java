package jp.com.app.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SampleController4Test {

    @Autowired
    private MockMvc mockMvc;

    final String URL = "/api";

    @Test
    public void Test_getSelect() throws Exception {
        String url = URL + "/property/getProperty";
        MvcResult result =  mockMvc.perform(
                get(url))
                .andExpect(status().isOk()) // レスポンスのステータスコードが200であることを確認
                .andReturn(); 
                MockHttpServletResponse res = result.getResponse();
                System.out.println(res.getContentAsString()); // 戻り値のjsonを表示
    }
}
