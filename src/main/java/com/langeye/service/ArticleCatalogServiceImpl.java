package com.langeye.service;

import com.langeye.common.Pager;
import com.langeye.dao.ArticleCatalogDao;
import com.langeye.dao.ArticleDao;
import com.langeye.entity.Article;
import com.langeye.entity.ArticleCatalog;
import com.langeye.general.GeneralServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Fish on 2015/11/6.
 */
@Service("articleCatalogService")
@Transactional
public class ArticleCatalogServiceImpl extends GeneralServiceImpl<ArticleCatalog> implements ArticleCatalogService {

    @Autowired(required = true)
    @Qualifier("articleCatalogDao")
    private ArticleCatalogDao dao;

    public void save(ArticleCatalog entity) {
        dao.save(entity);
    }

    public void update(ArticleCatalog entity) {
        dao.update(entity);
    }

    public void delete(ArticleCatalog entity) {
        dao.delete(entity);
    }

    public Pager<ArticleCatalog> paging(ArticleCatalog entity, int page, int pageSize) {
        Pager<ArticleCatalog> pager = new Pager<ArticleCatalog>();
        pager.setPage(page);
        pager.setPageSize(pageSize);
        List<ArticleCatalog> list = getAll();
        pager.setTotalRecord(list.size());
        pager.setRecords(list);
        return pager;
    }

    public List<ArticleCatalog> getAll() {
        return dao.getAll();
    }

    public ArticleCatalog get(Serializable id) {
        return dao.get(id);
    }
}
