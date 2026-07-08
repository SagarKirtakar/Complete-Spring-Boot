package com.sagar.ImageFileSystem.controller;

import com.sagar.ImageFileSystem.services.FileDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileController {

    @Autowired
    private FileDataService fileDataService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImageFileSystem(@RequestParam("image") MultipartFile file) throws IOException {
        String msg =  fileDataService.uploadImageFileSystem(file);
        if(msg != null) {
            return ResponseEntity.ok(msg);
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<?> downloadImageFileSystem(@PathVariable String fileName) throws IOException {
        byte [] imageData = fileDataService.downloadImageFileSystem(fileName);
        return ResponseEntity.ok().contentType(MediaType.valueOf("image/png")).body(imageData);
    }
}
