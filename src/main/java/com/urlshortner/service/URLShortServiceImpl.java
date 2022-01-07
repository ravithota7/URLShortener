package com.urlshortner.service;

import com.urlshortner.repo.UrlRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;

public class URLShortServiceImpl implements URLShortService {

    @Autowired
    UrlRepo urlRepo;

    @Override
    public String shortUrl(URL fullUrl) {
        return null;
    }

    @Override
    public String fullUrl(URL shortUrl) {
        return null;
    }
}
