package com.urlshortner.controller;

import com.urlshortner.dto.OriginalUrl;
import com.urlshortner.dto.ShortUrl;
import com.urlshortner.service.URLShortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;

@RestController
@RequestMapping(path = "/urly")
public class URLController {

    @Autowired
    URLShortService urlShortService;

    @PostMapping(path = "reduce")
    public ResponseEntity<ShortUrl> createShortUrl(@RequestBody OriginalUrl originalUrl){
        return ResponseEntity.ok(urlShortService.createShortUrl(originalUrl.getOriginalUrl()));
    }

    @PostMapping(path = "retrieve")
    public ResponseEntity<OriginalUrl> getOriginalUrl(@RequestBody ShortUrl shortUrl) throws Exception {
        return ResponseEntity.ok(urlShortService.getFullUrl(shortUrl.getShortUrl()));
    }

}
