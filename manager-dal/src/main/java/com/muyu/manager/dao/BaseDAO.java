package com.muyu.manager.dao;

import java.util.Collection;
import java.util.List;

/**
 * Created by Administrator on 2015/12/6.
 */
public interface BaseDAO<T, ID extends Long> {
    T getById(ID id);

    List<T> getByIds(Collection<ID> ids);

    ID save(T o);

    int deleteById(ID id);

    int batchDeleteById(ID[] ids);

    int update(T o);

    List<T> findByPage(int page,int pageSize);

}
