package com.sagar.ImageDatabaseDemo.services.impl;

import com.sagar.ImageDatabaseDemo.entity.ImageData;
import com.sagar.ImageDatabaseDemo.repository.StorageRepository;
import com.sagar.ImageDatabaseDemo.services.ImageDataService;
import com.sagar.ImageDatabaseDemo.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageDataServiceImpl implements ImageDataService {

    @Autowired
    private StorageRepository storageRepository;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
       ImageData imageData =   storageRepository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if(imageData != null) {
            return "file uploaded successfully : "+file.getOriginalFilename();
        }else {
            return "file not upload due to some error : "+file.getOriginalFilename();
        }
    }

    @Override
    public byte[] downloadImage(String fileName) {
        Optional<ImageData> dbFileData = storageRepository.findByName(fileName);
            byte[] images = ImageUtils.decompressImage(dbFileData.get().getImageData());
            return images;

    }
}
