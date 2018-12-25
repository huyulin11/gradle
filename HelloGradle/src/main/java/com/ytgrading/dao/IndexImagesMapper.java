package com.ytgrading.dao;

import com.ytgrading.dto.IndexImages;
import com.ytgrading.dto.IndexImagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexImagesMapper {
	int countByExample(@Param("imagestype") String example);

	int deleteByExample(IndexImagesExample example);

	int deleteByPrimaryKey(String id);

	int insert(IndexImages record);

	int insertSelective(IndexImages record);

	List<IndexImages> selectByExample(@Param("flag") String flag);

	List<IndexImages> selectByType(@Param("imagestype") String imagestype);

	List<IndexImages> selectByid(@Param("id") String id);

	IndexImages selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") IndexImages record,
			@Param("example") IndexImagesExample example);

	int updateByExample(@Param("record") IndexImages record,
			@Param("example") IndexImagesExample example);

	int updateByPrimaryKeySelective(IndexImages record);

	int updateByPrimaryKey(IndexImages record);
}