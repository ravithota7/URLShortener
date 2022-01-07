package com.urlshortner.repo;

import com.urlshortner.entity.URLEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepo extends JpaRepository<URLEntity,String> {
}
