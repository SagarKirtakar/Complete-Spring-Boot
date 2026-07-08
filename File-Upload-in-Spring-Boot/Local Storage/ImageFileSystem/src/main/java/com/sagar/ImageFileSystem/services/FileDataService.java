package com.sagar.ImageFileSystem.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileDataService {

    public String uploadImageFileSystem(MultipartFile file) throws IOException;

    public byte[] downloadImageFileSystem(String fileName) throws IOException;
}
