package com.hoangbui.shopping.dao;

import com.hoangbui.shopping.model.mapper.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseDAO<E> {
    <E> List<E> query(String sql, RowMapper<E> rowMapper, Object... parameters);

    Integer queryId(String sql, RowMapper<E> rowMapper, Object... parameters);

    void update(String sql, Object... parameters);

    void delete(String sql, Object... parameters);

    Integer insert(String sql, Object... parameters);

    int count(String sql, Object... parameters);

}