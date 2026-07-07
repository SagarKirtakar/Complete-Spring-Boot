package com.sagar.FileDemo.controller;

import com.sagar.FileDemo.services.FileDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileDataController {

    @Autowired
    private FileDataService fileDataService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
      String msg =  fileDataService.uploadImage(file);
      if(msg != null) {
          return ResponseEntity.ok(msg);
      }else {
          return ResponseEntity.noContent().build();
      }
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName) {
    byte [] imageData = fileDataService.downloadImage(fileName);
    return ResponseEntity.ok().contentType(MediaType.valueOf("image/png")).body(imageData);
    }


}
