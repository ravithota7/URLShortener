package com.urlshortner.dto;


import java.io.Serializable;

public class OriginalUrl implements Serializable {

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
