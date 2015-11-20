package com.langeye.dao;

import com.langeye.entity.Role;
import com.langeye.general.GeneralDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by Fish on 2015/11/6.
 */
@Repository("roleDao")
public class RoleDaoImpl extends GeneralDaoImpl<Role> implements RoleDao {

}
