package jp.com.app.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SampleController3Test {
    @Autowired
    private MockMvc mockMvc;

    final String URL = "/api/error";

    @Test
    public void Test_getError_正常() throws Exception {
        String url = URL + "/getError";
        mockMvc.perform(
                get(url)
                .param("id", "1"))  //   パラメータを付与
                .andExpect(status().isOk()) // レスポンスのステータスコードが200であることを確認
                .andReturn();          
    }

    @Test
    public void Test_getError_異常() throws Exception {
        String url = URL + "/getError";
        MvcResult result = mockMvc.perform(
                get(url)
                .param("id", "4"))  //   パラメータを付与
                .andExpect(status().isInternalServerError()) // レスポンスのステータスコードが500であることを確認
                .andReturn();
        
        // ステータスを表示
        System.out.println(result.getResponse().getStatus());
        // エラーメッセージ表示
        System.out.println(result.getResponse().getContentAsString());
    }

    
    @Test
    public void Test_postError_正常() throws Exception {
        String url = URL + "/postError";
        mockMvc.perform(post(url)
                            .with(csrf())
                            .param("id", "1") // パラメータを付与
                        )
                .andExpect(status().isInternalServerError()) // レスポンスのステータスコードが200であることを確認
                .andReturn();
    }

    @Test
    public void Test_postError_異常() throws Exception {
        String url = URL + "/postError";
        MvcResult result = mockMvc.perform(post(url)
                            .with(csrf())
                            .param("id", "4") // パラメータを付与
                        )
                        .andExpect(status().isInternalServerError()) // レスポンスのステータスコードが500であることを確認
                        .andReturn();
        
        // ステータスを表示
        System.out.println(result.getResponse().getStatus());
        // エラーメッセージ表示
        System.out.println(result.getResponse().getContentAsString());
    }
}
