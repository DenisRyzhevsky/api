package com.apitest.Springboottest.controller;

import com.apitest.Springboottest.ResponseData;
import com.apitest.Springboottest.entity.ImageEntity;
import com.apitest.Springboottest.service.ImageService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ImageController {

    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file")MultipartFile file) throws Exception {
        ImageEntity imageEntity = null;
        String downloadURl = "";
        imageEntity = imageService.saveImageEntity(file);
        downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(imageEntity.getId()).toUriString();

        return new ResponseData(imageEntity.getFileName(), downloadURl,
                file.getContentType(), file.getSize());
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        ImageEntity imageEntity = null;
        imageEntity = imageService.getImageEntity(fileId);
        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(imageEntity.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "imageEntity; filename=\"" + imageEntity.getFileName()
                                + "\"")
                .body(new ByteArrayResource(imageEntity.getData()));
    }
}
