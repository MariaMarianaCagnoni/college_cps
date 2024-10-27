package dev.mariamariana.college_cps.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBaseService<T, ID> {

    List<T> findAll();

    Page<T> findPageable(Pageable pageable);

    T findById(ID id);

    T create(T entity);

    T update(ID id, T entity);

    void deleteById(ID id);

    T beforeUpdate(T found, T toUpdate);

    boolean beforeDelete(ID id);

}
