package com.sagar.ImageDatabaseDemo.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageDataService {

    public String uploadImage(MultipartFile file) throws IOException;

    public byte[] downloadImage(String fileName);
}
