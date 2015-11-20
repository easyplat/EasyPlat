package com.langeye.general;

import com.langeye.common.Pager;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Fish on 2015/11/6.
 */
public interface GeneralService<TEntity> {
    /**
     * 新增实体
     * @param entity
     */
    public void save(TEntity entity);

    /**
     * 更新实体
     * @param entity
     */
    public void update(TEntity entity);

    /**
     * 删除实体
     * @param entity
     */
    public void delete(TEntity entity);

    /**
     * 分页实体
     * @param entity        查询条件
     * @param page          当前页码
     * @param pageSize      分页数
     * @return               返回记录
     */
    public Pager<TEntity> paging(TEntity entity,int page,int pageSize);

    /**
     * 查询所有资料
     * @return
     */
    public List<TEntity> getAll();

    /**
     * 查询单一实体
     * @param id
     * @return
     */
    public TEntity get(Serializable id);
}
