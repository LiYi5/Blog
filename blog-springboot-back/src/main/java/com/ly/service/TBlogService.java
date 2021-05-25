package com.ly.service;

import com.ly.entity.ApiResult;
import com.ly.entity.TBlog;
import com.ly.entity.TTag;
import com.ly.entity.TType;

import java.util.List;

/**
 * (TBlog)表服务接口
 *
 * @author makejava
 * @since 2021-04-27 21:31:27
 */
public interface TBlogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TBlog queryById(Long id);

    TBlog queryByBlog(TBlog tBlog);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TBlog> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tBlog 实例对象
     * @return 实例对象
     */
    TBlog insert(TBlog tBlog);

    /**
     * 修改数据
     *
     * @param tBlog 实例对象
     * @return 实例对象
     */
    TBlog update(TBlog tBlog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    List<TBlog> queryByType(TType tType);

    List<TBlog>  queryAll();

    List<TBlog> queryBytitleOrType(Integer page, Integer size, String title, String type);

    int getTotalBlog();

    TBlog queryByBlog(String title);

    List<TBlog> queryAllInfo(Integer page, int i);

    List<TBlog> queryByName(String name);
}