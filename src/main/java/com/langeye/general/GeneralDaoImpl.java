package com.langeye.general;

import com.langeye.common.Pager;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Fish on 2015/11/6.
 */
public class GeneralDaoImpl<TEntity extends GeneralEntity>
        /*extends HibernateDaoSupport*/ implements GeneralDao<TEntity> {
    protected Class<TEntity> entityClass;
    /*private HibernateTemplate template;*/
    private SessionFactory sessionFactory;

    public GeneralDaoImpl() {
        Type[] type = ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments();
        Class<TEntity> c = (Class<TEntity>) type[0];
        this.entityClass = c;
    }

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(TEntity tEntity) {
        sessionFactory.getCurrentSession().save(tEntity);
        sessionFactory.getCurrentSession().flush();
    }

    public void update(TEntity tEntity) {
        sessionFactory.getCurrentSession().saveOrUpdate(tEntity);
        sessionFactory.getCurrentSession().flush();
    }

    public void delete(TEntity tEntity) {
        sessionFactory.getCurrentSession().delete(tEntity);
        sessionFactory.getCurrentSession().flush();
    }

    public Pager<TEntity> paging(TEntity tEntity, int page, int pageSize) {

        return null;
    }

    public List<TEntity> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(this.entityClass).list();
    }

    public TEntity get(Serializable id) {
        return (TEntity) sessionFactory.getCurrentSession().get(this.entityClass, id);
    }

    protected TEntity get(final String hql, final Object... paras) {
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        if (paras.length > 0) {
            for (int i = 0; i < paras.length; i++) {
                query.setParameter(i, paras[i]);
            }
        }
        return (TEntity) query.uniqueResult();
    }

    protected Pager<TEntity> paging(String hql,int page,int pageSize,Object... paras){
        Pager<TEntity> pager = new Pager<TEntity>();
        //Criteria criteria = sessionFactory.getCurrentSession().createCriteria(this.entityClass)
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        if (paras.length > 0) {
            for (int i = 0; i < paras.length; i++) {
                query.setParameter(i, paras[i]);
            }
        }
        return pager;
    }
}
