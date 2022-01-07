package com.urlshortner.repo;

import com.urlshortner.entity.URLEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepo extends JpaRepository<URLEntity,Long> {
    Optional<URLEntity> findByFullUrl(String fullUrl);
}
