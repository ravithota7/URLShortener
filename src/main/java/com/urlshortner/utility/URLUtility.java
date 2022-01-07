package com.urlshortner.utility;

import org.springframework.stereotype.Component;

@Component
public class URLUtility {

    private static String KEY = "Mlp0PLmZaq1QAzXsw2WSxCde3EDcVfr4RFvBgt5TGbNhy6YHnJu7UjKi8Iko9O";
    private static int BASE = KEY.length();

    public String getShortUrl(Long num) {

        StringBuilder str = new StringBuilder();
        while (num > 0) {
            str.insert(0, KEY.charAt((int) (num % BASE)));
            num = num / BASE;
        }
        return str.toString();

    }

    public Long getId(String shortUrl){
        Long num = 0L;
        for(int i=0;i<shortUrl.length();i++){
            num = num*BASE + KEY.indexOf(shortUrl.charAt(i));
        }
        return num;
    }

}
