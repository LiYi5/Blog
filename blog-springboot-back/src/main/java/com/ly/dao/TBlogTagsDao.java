package com.ly.dao;

import com.ly.entity.TBlogTags;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (TBlogTags)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-28 11:28:32
 */
@Component
@Mapper
public interface TBlogTagsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param blogsId 主键
     * @return 实例对象
     */
    TBlogTags queryById(Long blogsId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TBlogTags> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tBlogTags 实例对象
     * @return 对象列表
     */
    List<TBlogTags> queryAll(TBlogTags tBlogTags);

    /**
     * 新增数据
     *
     * @param tBlogTags 实例对象
     * @return 影响行数
     */
    int insert(TBlogTags tBlogTags);

    /**
     * 修改数据
     *
     * @param tBlogTags 实例对象
     * @return 影响行数
     */
    int update(TBlogTags tBlogTags);

    /**
     * 通过主键删除数据
     *
     * @param blogsId 主键
     * @return 影响行数
     */
    int deleteById(Long blogsId);

}