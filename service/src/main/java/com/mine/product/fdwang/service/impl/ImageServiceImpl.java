package com.mine.product.fdwang.service.impl;

import com.mine.product.fdwang.service.ImageService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Calendar;

@Service
public class ImageServiceImpl implements ImageService {

    @Value("${project.local.space}")
    private String localSpace;

    @Override
    public String uploadImage(MultipartFile file) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String dayDir = year+""+month+""+day;
        File parent = new File(localSpace+"/"+dayDir);
        if(!parent.exists()) parent.mkdirs();
        String fileName = file.getOriginalFilename();

        String imagePath = calendar.getTime().getTime()+"_"+fileName;
        try {
            OutputStream outputStream = new FileOutputStream(new File(parent+"/"+imagePath));
            InputStream inputStream = file.getInputStream();
            IOUtils.copy(inputStream,outputStream);
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/"+dayDir+"/"+imagePath;

    }
}
