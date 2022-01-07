package com.urlshortner.service;

import java.net.URL;

public interface URLShortService {

    String shortUrl(URL fullUrl);
    String fullUrl(URL shortUrl);

}
