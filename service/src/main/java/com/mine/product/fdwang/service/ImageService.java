package com.mine.product.fdwang.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    public String uploadImage(MultipartFile file);
}
