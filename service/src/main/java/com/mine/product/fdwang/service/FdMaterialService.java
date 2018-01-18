package com.mine.product.fdwang.service;

import com.mine.product.fdwang.comm.domain.FdMaterial;
import com.mine.product.fdwang.resp.ResponseResult;

public interface FdMaterialService {
    public ResponseResult<Long> saveOrUpdate(FdMaterial record);
}
