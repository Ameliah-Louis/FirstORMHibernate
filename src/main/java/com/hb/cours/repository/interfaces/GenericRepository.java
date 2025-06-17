package com.hb.cours.repository.interfaces;

import com.hb.cours.model.Skill;

import java.util.List;

public interface GenericRepository <T, K>{
    List<T> findAll();
    T findById(K id);
    boolean persist(T entity);
    boolean update(T entity);
    boolean delete(K id);
}