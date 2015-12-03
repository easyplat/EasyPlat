package com.langeye.service.impl;

import com.langeye.common.Pager;
import com.langeye.dao.ArticleDao;
import com.langeye.dao.RoleDao;
import com.langeye.entity.Article;
import com.langeye.entity.Role;
import com.langeye.general.GeneralServiceImpl;
import com.langeye.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Fish on 2015/11/6.
 */
@Service("articleService")
@Transactional
public class ArticleServiceImpl extends GeneralServiceImpl<Article> implements ArticleService {

    @Autowired(required = true)
    @Qualifier("articleDao")
    private ArticleDao dao;

    public void save(Article entity) {
        dao.save(entity);
    }

    public void update(Article entity) {
        dao.update(entity);
    }

    public void delete(Article entity) {
        dao.delete(entity);
    }

    public Pager<Article> paging(Article entity, int page, int pageSize) {
        Pager<Article> pager = new Pager<Article>();
        pager.setPage(page);
        pager.setPageSize(pageSize);
        List<Article> list = getAll();
        pager.setTotalRecord(list.size());
        pager.setRecords(list);
        return pager;
    }

    public List<Article> getAll() {
        return dao.getAll();
    }

    public Article get(Serializable id) {
        return dao.get(id);
    }
}
