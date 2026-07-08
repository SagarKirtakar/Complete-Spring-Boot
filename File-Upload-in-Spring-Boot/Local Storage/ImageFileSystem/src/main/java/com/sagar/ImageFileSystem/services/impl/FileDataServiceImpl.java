package com.sagar.ImageFileSystem.services.impl;

import com.sagar.ImageFileSystem.entity.FileData;
import com.sagar.ImageFileSystem.repository.FileDataRepository;
import com.sagar.ImageFileSystem.services.FileDataService;
import com.sagar.ImageFileSystem.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class FileDataServiceImpl implements FileDataService {

    @Autowired
    private FileDataRepository fileDataRepository;

    private final String FOLDER_PATH = "C:/Users/Sagar/Desktop/MyFiles/";

    @Override
    public String uploadImageFileSystem(MultipartFile file) throws IOException {

        String filePath = FOLDER_PATH+file.getOriginalFilename();

        FileData fileData = fileDataRepository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if(fileData != null) {
            return "file uploaded successfully : "+filePath;
        }else {
            return "file not upload due to some error?";
        }
    }

    @Override
    public byte[] downloadImageFileSystem(String fileName) throws IOException {
        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
        String filePath = fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }
}
