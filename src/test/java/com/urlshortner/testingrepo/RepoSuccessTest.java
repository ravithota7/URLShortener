package com.urlshortner.testingrepo;

import com.urlshortner.entity.URLEntity;
import com.urlshortner.repo.UrlRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RepoSuccessTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UrlRepo urlRepo;

    @Test
    public void whenSave_thenReturnUrlEntity(){
        URLEntity urlEntity = new URLEntity("https://mail.google.com");
        testEntityManager.persistAndFlush(urlEntity);
        URLEntity resultEntity = urlRepo.saveAndFlush(urlEntity);
        assertEquals(resultEntity.getUrlId(),urlEntity.getUrlId());
        assertEquals(resultEntity.getFullUrl(),urlEntity.getFullUrl());
    }

    @Test
    public void whenFindById_thenReturnUrlEntity(){
        URLEntity urlEntity = new URLEntity("https://mail.google.com");
        testEntityManager.persistAndFlush(urlEntity);
        Optional<URLEntity> resultEntity = urlRepo.findById(1L);
        assertTrue(resultEntity.isPresent());
        assertEquals(resultEntity.get().getUrlId(),urlEntity.getUrlId());
        assertEquals(resultEntity.get().getFullUrl(),urlEntity.getFullUrl());
    }

    @Test
    public void whenFindByFullUrl_thenReturnUrlEntity(){
        URLEntity urlEntity = new URLEntity("https://mail.google.com");
        testEntityManager.persistAndFlush(urlEntity);
        Optional<URLEntity> resultEntity = urlRepo.findByFullUrl("https://mail.google.com");
        assertTrue(resultEntity.isPresent());
        assertEquals(resultEntity.get().getUrlId(),urlEntity.getUrlId());
        assertEquals(resultEntity.get().getFullUrl(),urlEntity.getFullUrl());
    }

}
