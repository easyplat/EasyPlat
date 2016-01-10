package com.langeye.general;

import com.langeye.common.Pager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Author:  Fish
 * Date:    2015/12/3.
 * Project: EasyPlat
 */
public abstract class JdbcDaoImpl<TEntity extends GeneralEntity> implements GeneralDao<TEntity> {

    @Resource(name = "jdbc")
    private JdbcTemplate jdbc;

    protected TEntity queryForObject(String sql,RowMapper<TEntity> rowMapper,Object[] paras){
        return jdbc.queryForObject(sql,rowMapper,paras);
    }

    protected List<TEntity> queryForList(String sql,RowMapper<TEntity> rowMapper,Object[] paras ){
        return jdbc.query(sql,rowMapper,paras);
    }
}
