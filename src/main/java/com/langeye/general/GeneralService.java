package com.langeye.general;

import com.langeye.common.Pager;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Fish on 2015/11/6.
 */
public interface GeneralService<TEntity> {
    /**
     * ����ʵ��
     * @param entity
     */
    public void save(TEntity entity);

    /**
     * ����ʵ��
     * @param entity
     */
    public void update(TEntity entity);

    /**
     * ɾ��ʵ��
     * @param entity
     */
    public void delete(TEntity entity);

    /**
     * ��ҳʵ��
     * @param entity        ��ѯ����
     * @param page          ��ǰҳ��
     * @param pageSize      ��ҳ��
     * @return               ���ؼ�¼
     */
    public Pager<TEntity> paging(TEntity entity,int page,int pageSize);

    /**
     * ��ѯ��������
     * @return
     */
    public List<TEntity> getAll();

    /**
     * ��ѯ��һʵ��
     * @param id
     * @return
     */
    public TEntity get(Serializable id);
}
