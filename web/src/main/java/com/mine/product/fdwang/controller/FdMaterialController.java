package com.mine.product.fdwang.controller;

import com.mine.product.fdwang.comm.domain.FdMaterial;
import com.mine.product.fdwang.resp.ResponseResult;
import com.mine.product.fdwang.service.FdMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/material")
public class FdMaterialController {

    @Autowired
    private FdMaterialService materialService;


    @PostMapping("/saveOrUpdate")
    public ResponseResult<Long> saveOrUpdate(@RequestBody FdMaterial record){
        return materialService.saveOrUpdate(record);
    }
}
