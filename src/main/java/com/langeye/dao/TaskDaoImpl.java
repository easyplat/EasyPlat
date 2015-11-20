package com.langeye.dao;

import com.langeye.entity.Article;
import com.langeye.entity.Task;
import com.langeye.general.GeneralDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by Fish on 2015/11/6.
 */
@Repository("taskDao")
public class TaskDaoImpl extends GeneralDaoImpl<Task> implements TaskDao {

}
