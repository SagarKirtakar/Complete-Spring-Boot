package com.sagar.ImageDatabaseDemo.controller;

import com.sagar.ImageDatabaseDemo.services.ImageDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageDataController {

    @Autowired
    private ImageDataService imageDataService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
      String msg =  imageDataService.uploadImage(file);
      if(msg != null) {
          return ResponseEntity.ok(msg);
      }else {
          return ResponseEntity.noContent().build();
      }
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName) {
    byte [] imageData = imageDataService.downloadImage(fileName);
    return ResponseEntity.ok().contentType(MediaType.valueOf("image/png")).body(imageData);
    }


}
