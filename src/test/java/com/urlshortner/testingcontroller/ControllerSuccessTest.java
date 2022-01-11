//package com.urlshortner.testingcontroller;
//
//
//import com.urlshortner.controller.URLController;
//import com.urlshortner.dto.OriginalUrl;
//import com.urlshortner.dto.ShortUrl;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ControllerSuccessTest {
//
//    @Autowired
//    private URLController urlController;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    private int port=8080;
//
//    @Test
//    public void contextLoads() throws Exception{
//        assertThat(urlController).isNotNull();
//    }
//
//    @Test
//    public void createShortURL(){
//        assertThat(this.restTemplate.postForObject("http://localhost:"+port+"/urly"+"/reduce",
//                new OriginalUrl("http://localhost:8080/urly/reduce"), ShortUrl.class).getShortUrl()).isEqualTo("l");
//    }
//
//}
