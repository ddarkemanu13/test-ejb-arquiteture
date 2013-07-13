package org.business.utils.dao;

import java.util.List;

public interface IDefaultDAO<T> {
	
	T findById(Long id);

    List<T> findAll();

    void delete(Object object);

    void create(Object object);

    void update(Object object);

}
