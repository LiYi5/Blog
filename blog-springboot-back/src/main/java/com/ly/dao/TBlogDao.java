package com.ly.dao;

import com.ly.entity.TBlog;
import com.ly.entity.TType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (TBlog)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-27 21:31:24
 */
@Component
@Mapper
public interface TBlogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TBlog queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TBlog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tBlog 实例对象
     * @return 对象列表
     */
    List<TBlog> queryAll(TBlog tBlog);

    /**
     * 新增数据
     *
     * @param tBlog 实例对象
     * @return 影响行数
     */
    int insert(TBlog tBlog);

    /**
     * 修改数据
     *
     * @param tBlog 实例对象
     * @return 影响行数
     */
    int update(TBlog tBlog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    TBlog queryByBlog(TBlog tBlog);

    List<TBlog> queryByType(TType tType);

    List<TBlog> queryBytitleOrType(@Param("title") String title, @Param("name")String type);

    List<TBlog> queryAllBlog();

    TBlog queryByTitle(String title);

    List<TBlog> queryAllInfo();

    List<TBlog> queryBlogByName(String name);
}