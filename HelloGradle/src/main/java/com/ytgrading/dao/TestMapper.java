package com.ytgrading.dao;

import com.ytgrading.dto.Test;
import com.ytgrading.dto.TestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestMapper {
    int findCountBySql();

    int deleteByExample(TestExample example);

    int insert(Test record);

    int insertSelective(Test record);

    List<Test> selectByExample(TestExample example);

    int updateByExampleSelective(@Param("record") Test record, @Param("example") TestExample example);

    int updateByExample(@Param("record") Test record, @Param("example") TestExample example);
    
    //分页
    List<Test> selectByPage(@Param("page") int page, @Param("pagesize") int pagesize);
}