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
import org.springframework.mock.web.MockHttpServletResponse;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SampleController2Test {
    @Autowired
    private MockMvc mockMvc;

    final String URL = "/api/post";

    @Test
    public void Test_getSelect() throws Exception {
        String url = URL + "/selectSql";
        MvcResult result =  mockMvc.perform(
            post(url)
                .with(csrf()))
            .andExpect(status().isOk()) // レスポンスのステータスコードが200であることを確認
            .andReturn(); 
                MockHttpServletResponse res = result.getResponse();
                System.out.println(res.getContentAsString()); // 戻乳のjsonを表示
    }

    @Test
    public void Test_getInsert() throws Exception {
        String url = URL + "/insertSql";
        mockMvc.perform(post(url)
                    .with(csrf())
                    .param("id", "4") // パラメータを付与
                    .param("name", "Sirou") // パラメータを付与
                )
                .andExpect(status().isOk()) // レスポンスのステータスコードが200であることを確認
                .andReturn();
    }

    @Test
    public void Test_updateSql() throws Exception {
        String url = URL + "/updateSql";
        mockMvc.perform(post(url)
                    .with(csrf())
                    .param("id", "4") // パラメータを付与
                    .param("name", "sirou") // パラメータを付与
                )
                .andExpect(status().isOk()) // レスポンスのステータスコードが200であることを確認
                .andReturn();
    }

    @Test
    public void Test_deleteSql() throws Exception {
        String url = URL + "/deleteSql";
        mockMvc.perform(post(url)
                    .with(csrf())
                    .param("id", "4") // パラメータを付与
                )
                .andExpect(status().isOk()) // レスポンスのステータスコードが200であることを確認
                .andReturn();
    }
}
