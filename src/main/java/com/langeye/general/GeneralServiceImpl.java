package com.langeye.general;

import com.langeye.common.Pager;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Fish on 2015/11/6.
 */
@Transactional
public abstract class GeneralServiceImpl<TEntity extends GeneralEntity> implements GeneralService<TEntity>{

}
