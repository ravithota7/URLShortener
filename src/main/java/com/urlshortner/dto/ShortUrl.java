package com.urlshortner.dto;



import java.io.Serializable;

public class ShortUrl implements Serializable {

    private String shortUrl;

    public ShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public ShortUrl() {
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
