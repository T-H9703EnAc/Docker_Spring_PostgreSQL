package jp.com.app.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SampleController1Test {

    @Autowired
    private MockMvc mockMvc;

    final String URL = "/api/get";

    @Test
    public void Test_getSelect() throws Exception {
        String url = URL + "/selectSql";
        MvcResult result =  mockMvc.perform(
                get(url))
                .andExpect(status().isOk()) // レスポンスのステータスコードが200であることを確認
                .andReturn(); 
                MockHttpServletResponse res = result.getResponse();
                System.out.println(res.getContentAsString()); // 戻乳のjsonを表示
    }

    @Test
    public void Test_getInsert() throws Exception {
        String url = URL + "/insertSql";
        mockMvc.perform(
                get(url)
                .param("id", "4")         // 　パラメータを付与
                .param("name", "sirou"))  //   パラメータを付与
                .andExpect(status().isOk()); // レスポンスのステータスコードが200であることを確認
    }

    @Test
    public void Test_updateSql() throws Exception {
        String url = URL + "/updateSql";
        mockMvc.perform(
                get(url)
                .param("id", "4")         // 　パラメータを付与
                .param("name", "Sirou"))  //   パラメータを付与
                .andExpect(status().isOk()); // レスポンスのステータスコードが200であることを確認
    }

    @Test
    public void Test_deleteSql() throws Exception {
        String url = URL + "/deleteSql";
        mockMvc.perform(
                get(url)
                .param("id", "4")) // パラメータを付与
                .andExpect(status().isOk()); // レスポンスのステータスコードが200であることを確認
    }
}
