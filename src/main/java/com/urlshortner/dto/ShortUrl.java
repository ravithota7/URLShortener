package com.urlshortner.dto;

public class ShortUrl {

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
