package com.sagar.FileDemo.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileDataService {

    public String uploadImage(MultipartFile file) throws IOException;

    public byte[] downloadImage(String fileName);
}
