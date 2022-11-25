package com.apitest.Springboottest.repository;

import com.apitest.Springboottest.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImageRepo extends JpaRepository <ImageEntity, String> {

}
