package com.langeye.service.impl;

import com.langeye.common.Pager;
import com.langeye.dao.RoleDao;
import com.langeye.entity.Role;
import com.langeye.general.GeneralServiceImpl;
import com.langeye.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Fish on 2015/11/6.
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl extends GeneralServiceImpl<Role> implements RoleService {

    @Autowired(required = true)
    @Qualifier("roleDao")
    private RoleDao dao;

    public void save(Role role) {
        dao.save(role);
    }

    public void update(Role role) {
        dao.update(role);
    }

    public void delete(Role role) {
        dao.delete(role);
    }

    public Pager<Role> paging(Role role, int page, int pageSize) {
        Pager<Role> pager = new Pager<Role>();
        pager.setPage(page);
        pager.setPageSize(pageSize);
        List<Role> list = getAll();
        pager.setTotalRecord(list.size());
        pager.setRecords(list);
        return pager;
    }

    public List<Role> getAll() {
        return dao.getAll();
    }

    public Role get(Serializable id) {
        return dao.get(id);
    }
}
