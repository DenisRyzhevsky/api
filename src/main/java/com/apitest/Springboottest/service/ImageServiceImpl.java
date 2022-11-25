package com.apitest.Springboottest.service;

import com.apitest.Springboottest.entity.ImageEntity;
import com.apitest.Springboottest.repository.ImageRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepo imageRepo;

    public ImageServiceImpl(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }

    @Override
    public ImageEntity saveImageEntity(MultipartFile file) throws Exception {
        String fileName = org.springframework.util.StringUtils.
                cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            if (fileName.contains("..")) {
                throw new Exception("File name contains invalid path sequence " + fileName);
            }

            ImageEntity imageEntity = new ImageEntity(fileName,
                    file.getContentType(),
                    file.getBytes());
            return imageRepo.save(imageEntity);

        }catch (Exception e) {
            throw new Exception("could not save file: " + fileName);
        }
    }

    @Override
    public ImageEntity getImageEntity(String fileId) throws Exception {
        return imageRepo.findById(fileId).orElseThrow(() -> new Exception("File not found by id " + fileId));
    }
}
