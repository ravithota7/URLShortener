package com.urlshortner.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class URLEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long urlId;
    private String fullUrl;

    public URLEntity(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public URLEntity() {
    }

    public URLEntity(Long urlId, String fullUrl) {
        this.urlId = urlId;
        this.fullUrl = fullUrl;
    }

    public Long getUrlId() {
        return urlId;
    }

    public void setUrlId(Long urlId) {
        this.urlId = urlId;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    @Override
    public String toString() {
        return "URLEntity{" +
                "urlId=" + urlId +
                ", fullUrl='" + fullUrl + '\'' +
                '}';
    }
}
