package com.sagar.FileDemo.services.impl;

import com.sagar.FileDemo.entity.FileData;
import com.sagar.FileDemo.repository.StorageRepository;
import com.sagar.FileDemo.services.FileDataService;
import com.sagar.FileDemo.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileDataServiceImpl implements FileDataService {

    @Autowired
    private StorageRepository storageRepository;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
       FileData fileData =   storageRepository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(FileUtils.compressImage(file.getBytes())).build());
        if(fileData != null) {
            return "file uploaded successfully : "+file.getOriginalFilename();
        }else {
            return "file not upload due to some error : "+file.getOriginalFilename();
        }
    }

    @Override
    public byte[] downloadImage(String fileName) {
        Optional<FileData> dbFileData = storageRepository.findByName(fileName);
            byte[] images = FileUtils.decompressImage(dbFileData.get().getImageData());
            return images;

    }
}
