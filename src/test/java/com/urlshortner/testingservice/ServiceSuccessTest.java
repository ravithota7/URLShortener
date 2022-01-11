package com.urlshortner.testingservice;


import com.urlshortner.dto.OriginalUrl;
import com.urlshortner.dto.ShortUrl;
import com.urlshortner.entity.URLEntity;
import com.urlshortner.repo.UrlRepo;
import com.urlshortner.service.URLShortService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class ServiceSuccessTest {

    @Autowired
    URLShortService urlShortService;

    @MockBean
    UrlRepo urlRepo;

    @BeforeEach
    public  void setUp(){
        URLEntity urlEntity = new URLEntity(1L,"https://mail.google.com");
        OriginalUrl originalUrl = new OriginalUrl("https://mail.google.com");

        Mockito.when(urlRepo.save(urlEntity)).thenReturn(urlEntity);
        Mockito.when(urlRepo.findById(1L)).thenReturn(Optional.of(urlEntity));
        Mockito.when(urlRepo.findByFullUrl(originalUrl.getOriginalUrl())).thenReturn(Optional.of(urlEntity));
    }

    @Test
    public void when_createShortUrl(){
        ShortUrl shortUrl = urlShortService.createShortUrl("https://mail.google.com");
        assertEquals(shortUrl.getShortUrl(),"http://localhost:8080/urlly/l");
    }

    @Test
    public void when_getFullUrl() throws Exception {
        OriginalUrl originalUrl = urlShortService.getFullUrl("http://localhost:8080/urlly/l");
        assertEquals(originalUrl.getOriginalUrl(),"https://mail.google.com");
    }

    @Test
    public void when_redirectToOriginalUrl() throws Exception {
        OriginalUrl originalUrl = urlShortService.redirectToOriginalUrl("l");
        assertEquals(originalUrl.getOriginalUrl(),"https://mail.google.com");
    }


}
