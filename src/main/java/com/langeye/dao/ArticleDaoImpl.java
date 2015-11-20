package com.langeye.dao;

import com.langeye.entity.Article;
import com.langeye.general.GeneralDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by Fish on 2015/11/6.
 */
@Repository("articleDao")
public class ArticleDaoImpl extends GeneralDaoImpl<Article> implements ArticleDao {

}
