package com.urlshortner.service;

import com.urlshortner.dto.OriginalUrl;
import com.urlshortner.dto.ShortUrl;
import com.urlshortner.entity.URLEntity;
import com.urlshortner.repo.UrlRepo;
import com.urlshortner.utility.URLUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class URLShortServiceImpl implements URLShortService {

    @Autowired
    UrlRepo urlRepo;

    @Autowired
    URLUtility urlUtility;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Override
    public ShortUrl createShortUrl(String fullUrl) {
        Optional<URLEntity> urlEntity = getByFullUrl(fullUrl);
        if(urlEntity.isPresent()){
            logger.info("URL already exits in Db");
            return new ShortUrl(urlUtility.getShortUrl(urlEntity.get().getUrlId()));
        }
        else{
            logger.info("Saving url in db");
            return new ShortUrl(urlUtility.getShortUrl(urlRepo.save(new URLEntity(fullUrl)).getUrlId()));
        }
    }

    private Optional<URLEntity> getByFullUrl(String fullUrl) {
        logger.info("retrieving url from db by entity");
        return urlRepo.findByFullUrl(fullUrl);
    }

    private Optional<URLEntity> getFromId(Long id){
        logger.info("Retrieving url from db by id");
        return urlRepo.findById(id);
    }

    @Override
    public OriginalUrl getFullUrl(String shortUrl) throws Exception {
        Long urlId = urlUtility.getId(shortUrl);
        logger.info("retrieving url from db");
        return new OriginalUrl(getFromId(urlId).orElseThrow( ()-> new Exception("not mapped to any url") ).getFullUrl());
    }
}
