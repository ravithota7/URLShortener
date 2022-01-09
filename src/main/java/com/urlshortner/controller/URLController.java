package com.urlshortner.controller;

import com.urlshortner.dto.OriginalUrl;
import com.urlshortner.dto.ShortUrl;
import com.urlshortner.service.URLShortService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "urly")
public class URLController {

    @Autowired
    URLShortService urlShortService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());


    @PostMapping(path = "reduce")
    public ResponseEntity<ShortUrl> createShortUrl(@RequestBody OriginalUrl originalUrl){
        logger.info("Entered createShortUrl of {} with originalUrl {}",this.getClass(),originalUrl.getOriginalUrl());
        return new ResponseEntity<>(urlShortService.createShortUrl(originalUrl.getOriginalUrl()), HttpStatus.CREATED);
    }


    @PostMapping(path = "retrieve")
    public ResponseEntity<OriginalUrl> getOriginalUrl(@RequestBody ShortUrl shortUrl) throws Exception {
        logger.info("Entered getOriginalUrl of {} with shortUrl {}",this.getClass(),shortUrl.getShortUrl());
        return new ResponseEntity<>(urlShortService.getFullUrl(shortUrl.getShortUrl()),HttpStatus.OK);
        //return ResponseEntity.ok(urlShortService.getFullUrl(shortUrl.getShortUrl()));
    }

}
