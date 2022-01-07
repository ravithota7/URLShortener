package com.urlshortner.dto;

public class OriginalUrl {

    private String originalUrl;

    public OriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public OriginalUrl() {
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
