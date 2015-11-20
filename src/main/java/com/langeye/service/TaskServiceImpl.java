package com.langeye.service;

import com.langeye.common.Pager;
import com.langeye.dao.ArticleDao;
import com.langeye.dao.TaskDao;
import com.langeye.entity.Article;
import com.langeye.entity.Task;
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
@Service("taskService")
@Transactional
public class TaskServiceImpl extends GeneralServiceImpl<Task> implements TaskService {

    @Autowired(required = true)
    @Qualifier("taskDao")
    private TaskDao dao;

    public void save(Task entity) {
        dao.save(entity);
    }

    public void update(Task entity) {
        dao.update(entity);
    }

    public void delete(Task entity) {
        dao.delete(entity);
    }

    public Pager<Task> paging(Task entity, int page, int pageSize) {
        Pager<Task> pager = new Pager<Task>();
        pager.setPage(page);
        pager.setPageSize(pageSize);
        List<Task> list = getAll();
        pager.setTotalRecord(list.size());
        pager.setRecords(list);
        return pager;
    }

    public List<Task> getAll() {
        return dao.getAll();
    }

    public Task get(Serializable id) {
        return dao.get(id);
    }
}
