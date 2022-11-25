package com.apitest.Springboottest.service;

import com.apitest.Springboottest.entity.ImageEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    ImageEntity saveImageEntity(MultipartFile file) throws Exception;

    ImageEntity getImageEntity(String fileId) throws Exception;
}
