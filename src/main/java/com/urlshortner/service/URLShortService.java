package com.urlshortner.service;

import com.urlshortner.dto.OriginalUrl;
import com.urlshortner.dto.ShortUrl;


public interface URLShortService {

    ShortUrl createShortUrl(String fullUrl);
    OriginalUrl getFullUrl(String shortUrl) throws Exception;

}
