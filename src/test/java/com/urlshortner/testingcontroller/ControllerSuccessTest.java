package com.urlshortner.testingcontroller;




import com.urlshortner.JsonUtil;
import com.urlshortner.controller.URLController;
import com.urlshortner.dto.OriginalUrl;
import com.urlshortner.dto.ShortUrl;
import com.urlshortner.service.URLShortService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(value = URLController.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class ControllerSuccessTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private URLShortService urlShortService;

    @Test
    public void when_createdShortUrl_checkForDuplicate_returnShortUrl() throws Exception {
        ShortUrl shortUrl = new ShortUrl("http://localhost:8080/urlly/l");
        given(urlShortService.createShortUrl(Mockito.any())).willReturn(shortUrl);

        mvc.perform(post("/urlly/reduce").contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(shortUrl)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.shortUrl", CoreMatchers.is(shortUrl.getShortUrl())));

    }

    @Test
    public void when_getOriginalUrl_returnOriginalUrl() throws Exception {
        OriginalUrl originalUrl = new OriginalUrl("https://mail.google.com");
        given(urlShortService.getFullUrl(Mockito.any())).willReturn(originalUrl);

        mvc.perform(post("/urlly/retrieve").contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(originalUrl)))
                .andExpect(jsonPath("$.originalUrl",CoreMatchers.is(originalUrl.getOriginalUrl())));
    }

    @Test
    public void when_redirectUrl_returnOriginalUrl() throws Exception{
        OriginalUrl originalUrl = new OriginalUrl("https://mail.google.com");
        given(urlShortService.redirectToOriginalUrl(Mockito.any())).willReturn(originalUrl);

        mvc.perform(get("/urlly/{shortUrl}","shortUrl").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.redirectedUrl("https://mail.google.com"));
    }

}
