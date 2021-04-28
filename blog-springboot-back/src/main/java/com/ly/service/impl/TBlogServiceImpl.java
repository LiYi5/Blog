package com.ly.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ly.entity.TBlog;
import com.ly.dao.TBlogDao;
import com.ly.entity.TTag;
import com.ly.entity.TType;
import com.ly.service.TBlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TBlog)表服务实现类
 *
 * @author makejava
 * @since 2021-04-27 21:31:28
 */
@Service("tBlogService")
public class TBlogServiceImpl implements TBlogService {
    @Resource
    private TBlogDao tBlogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TBlog queryById(Long id) {
        return this.tBlogDao.queryById(id);
    }

    @Override
    public TBlog queryByBlog(TBlog tBlog) {
        return tBlogDao.queryByBlog(tBlog);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TBlog> queryAllByLimit(int offset, int limit) {
        return this.tBlogDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tBlog 实例对象
     * @return 实例对象
     */
    @Override
    public TBlog insert(TBlog tBlog) {
        this.tBlogDao.insert(tBlog);
        return tBlog;
    }

    /**
     * 修改数据
     *
     * @param tBlog 实例对象
     * @return 实例对象
     */
    @Override
    public TBlog update(TBlog tBlog) {
        this.tBlogDao.update(tBlog);
        return this.queryById(tBlog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tBlogDao.deleteById(id) > 0;
    }

    @Override
    public List<TBlog> queryByType(TType tType) {
        return tBlogDao.queryByType(tType);
    }

    @Override
    public List<TBlog> queryAll() {
        return tBlogDao.queryAllBlog();
    }

    @Override
    public List<TBlog> queryBytitleOrType(Integer page,String title, String type) {
        PageHelper.startPage(page, 8);
        List<TBlog> tBlogs = tBlogDao.queryBytitleOrType(title, type);
        return tBlogs;
    }

    @Override
    public int getTotalBlog() {
        List<TBlog> tBlogs = tBlogDao.queryAll(null);
        return tBlogs.size();
    }

    @Override
    public TBlog queryByBlog(String title) {
        return tBlogDao.queryByTitle(title);
    }

}