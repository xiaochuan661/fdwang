package com.mine.product.fdwang.service.impl;

import com.mine.product.fdwang.comm.domain.FdMaterial;
import com.mine.product.fdwang.exception.FdWangException;
import com.mine.product.fdwang.mapper.FdMaterialMapper;
import com.mine.product.fdwang.resp.ResponseResult;
import com.mine.product.fdwang.service.FdMaterialService;
import com.mine.product.fdwang.util.BinaryUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FdMaterialServiceImpl implements FdMaterialService {


    @Resource
    private FdMaterialMapper materialMapper;

    @Override
    public ResponseResult<Long> saveOrUpdate(FdMaterial record) {
        if(BinaryUtils.isEmpty(record)) throw new FdWangException("参数不能为空");
        Long id = record.getId();
        if(BinaryUtils.isEmpty(id)){
            materialMapper.insertSelective(record);

        }else{
            materialMapper.updateByPrimaryKey(record);
        }
        return null;
    }
}
