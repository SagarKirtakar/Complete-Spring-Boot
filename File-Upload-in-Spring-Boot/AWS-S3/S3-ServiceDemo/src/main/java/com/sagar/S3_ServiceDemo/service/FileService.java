package com.sagar.S3_ServiceDemo.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.sagar.S3_ServiceDemo.config.StorageConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileService {

    private final AmazonS3 s3Client;
    private final StorageConfig storageConfig;

    public String uploadFile(MultipartFile file) {

        File fileObj = convertMultiPartFileToFile(file);

        String fileName = System.currentTimeMillis()
                + "_"
                + file.getOriginalFilename();

        try {
            s3Client.putObject(
                    new PutObjectRequest(
                            storageConfig.getBucketName(),
                            fileName,
                            fileObj
                    )
            );

            return "File Uploaded Successfully : " + fileName;

        } finally {
            if (fileObj.exists()) {
                fileObj.delete();
            }
        }

    }

    public byte[] downloadFile(String fileName) {

        S3Object s3Object = s3Client.getObject(
                storageConfig.getBucketName(),
                fileName
        );

        try (S3ObjectInputStream inputStream = s3Object.getObjectContent()) {

            return inputStream.readAllBytes();

        } catch (IOException e) {
            throw new RuntimeException("Error downloading file: " + fileName, e);
        }
    }

    public String deleteFile(String fileName) {

        if (!s3Client.doesObjectExist(storageConfig.getBucketName(), fileName)) {
            throw new RuntimeException("File not found: " + fileName);
        }

        s3Client.deleteObject(storageConfig.getBucketName(), fileName);

        return "File deleted successfully : " + fileName;
    }

    private File convertMultiPartFileToFile(MultipartFile file) {

        File convertedFile = new File(file.getOriginalFilename());

        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error converting MultipartFile to File", e);
        }

        return convertedFile;
    }


}