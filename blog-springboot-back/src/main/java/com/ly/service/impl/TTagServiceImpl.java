package com.ly.service.impl;

import com.ly.entity.TTag;
import com.ly.dao.TTagDao;
import com.ly.service.TTagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TTag)表服务实现类
 *
 * @author makejava
 * @since 2021-04-27 21:33:21
 */
@Service("tTagService")
public class TTagServiceImpl implements TTagService {
    @Resource
    private TTagDao tTagDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TTag queryById(Long id) {
        return this.tTagDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TTag> queryAllByLimit(int offset, int limit) {
        return this.tTagDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tTag 实例对象
     * @return 实例对象
     */
    @Override
    public TTag insert(TTag tTag) {
        this.tTagDao.insert(tTag);
        return tTag;
    }

    /**
     * 修改数据
     *
     * @param tTag 实例对象
     * @return 实例对象
     */
    @Override
    public TTag update(TTag tTag) {
        this.tTagDao.update(tTag);
        return this.queryById(tTag.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tTagDao.deleteById(id) > 0;
    }

    @Override
    public int getTotalType() {
        List<TTag> tTags = tTagDao.queryAll(null);
        return tTags.size();
    }

    @Override
    public boolean getTag(TTag tTag) {
        List<TTag> tTags = tTagDao.queryAll(tTag);
        return tTags.size()>0;
    }

    @Override
    public List<TTag> getAllTag() {

        return tTagDao.queryAll(null);
    }
}