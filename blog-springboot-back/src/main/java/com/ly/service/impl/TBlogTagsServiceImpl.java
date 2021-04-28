package com.ly.service.impl;

import com.ly.entity.TBlogTags;
import com.ly.dao.TBlogTagsDao;
import com.ly.service.TBlogTagsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TBlogTags)表服务实现类
 *
 * @author makejava
 * @since 2021-04-28 11:28:35
 */
@Service("tBlogTagsService")
public class TBlogTagsServiceImpl implements TBlogTagsService {
    @Resource
    private TBlogTagsDao tBlogTagsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param blogsId 主键
     * @return 实例对象
     */
    @Override
    public TBlogTags queryById(Long blogsId) {
        return this.tBlogTagsDao.queryById(blogsId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TBlogTags> queryAllByLimit(int offset, int limit) {
        return this.tBlogTagsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tBlogTags 实例对象
     * @return 实例对象
     */
    @Override
    public TBlogTags insert(TBlogTags tBlogTags) {
        this.tBlogTagsDao.insert(tBlogTags);
        return tBlogTags;
    }

    /**
     * 修改数据
     *
     * @param tBlogTags 实例对象
     * @return 实例对象
     */
    @Override
    public TBlogTags update(TBlogTags tBlogTags) {
        this.tBlogTagsDao.update(tBlogTags);
        return this.queryById(tBlogTags.getBlogsId());
    }

    /**
     * 通过主键删除数据
     *
     * @param blogsId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long blogsId) {
        return this.tBlogTagsDao.deleteById(blogsId) > 0;
    }
}