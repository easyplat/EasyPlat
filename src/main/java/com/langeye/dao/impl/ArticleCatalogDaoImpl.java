package com.langeye.dao.impl;

import com.langeye.dao.ArticleCatalogDao;
import com.langeye.entity.Article;
import com.langeye.entity.ArticleCatalog;
import com.langeye.general.GeneralDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by Fish on 2015/11/6.
 */
@Repository("articleCatalogDao")
public class ArticleCatalogDaoImpl extends GeneralDaoImpl<ArticleCatalog> implements ArticleCatalogDao {

}
