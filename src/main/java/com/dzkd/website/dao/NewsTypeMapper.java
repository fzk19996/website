package com.dzkd.website.dao;

import com.dzkd.website.pojo.NewsType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsTypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int deleteBatch(List<NewsType> newsTypeList);

    int insert(NewsType record);

    int insertSelective(NewsType record);

    NewsType selectByPrimaryKey(Integer typeId);

    List<NewsType> selectAll(String typeName);

    int updateByPrimaryKeySelective(NewsType record);

    int updateByPrimaryKey(NewsType record);
}