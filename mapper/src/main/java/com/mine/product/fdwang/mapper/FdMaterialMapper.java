package com.mine.product.fdwang.mapper;

import com.mine.product.fdwang.comm.domain.FdMaterial;
import com.mine.product.fdwang.comm.domain.FdMaterialExample;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface FdMaterialMapper {
    int countByExample(FdMaterialExample example);

    int deleteByExample(FdMaterialExample example);

    @Delete({
        "delete from fd_material",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into fd_material (id, name, ",
        "unit, img_path, description, ",
        "data_status, created_time, ",
        "modified_time, creater, ",
        "modifier)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{unit,jdbcType=VARCHAR}, #{imgPath,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{dataStatus,jdbcType=INTEGER}, #{createdTime,jdbcType=TIMESTAMP}, ",
        "#{modifiedTime,jdbcType=TIMESTAMP}, #{creater,jdbcType=VARCHAR}, ",
        "#{modifier,jdbcType=VARCHAR})"
    })
    int insert(FdMaterial record);

    int insertSelective(FdMaterial record);

    List<FdMaterial> selectByExample(FdMaterialExample example);

    @Select({
        "select",
        "id, name, unit, img_path, description, data_status, created_time, modified_time, ",
        "creater, modifier",
        "from fd_material",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("BaseResultMap")
    FdMaterial selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FdMaterial record, @Param("example") FdMaterialExample example);

    int updateByExample(@Param("record") FdMaterial record, @Param("example") FdMaterialExample example);

    int updateByPrimaryKeySelective(FdMaterial record);

    @Update({
        "update fd_material",
        "set name = #{name,jdbcType=VARCHAR},",
          "unit = #{unit,jdbcType=VARCHAR},",
          "img_path = #{imgPath,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "data_status = #{dataStatus,jdbcType=INTEGER},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP},",
          "modified_time = #{modifiedTime,jdbcType=TIMESTAMP},",
          "creater = #{creater,jdbcType=VARCHAR},",
          "modifier = #{modifier,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(FdMaterial record);
}