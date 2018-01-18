package com.mine.product.fdwang.service.impl;

import com.mine.product.fdwang.service.ImageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class ImageServiceImpl implements ImageService {

    @Value("${project.local.space}")
    private String localSpace;

    @Override
    public String uploadImage(MultipartFile file) {
        File dir = new File(localSpace);
        String fileName = file.getName();
        
        return null;

    }
}
