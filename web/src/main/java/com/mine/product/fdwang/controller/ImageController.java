package com.mine.product.fdwang.controller;

import com.mine.product.fdwang.resp.ResponseResult;
import com.mine.product.fdwang.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/rest/image")
public class ImageController {


    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseResult<String> uploadImage( @RequestParam("file") MultipartFile file){
        String imagePath = imageService.uploadImage(file);
        return new ResponseResult<>(imagePath);
    }
}
