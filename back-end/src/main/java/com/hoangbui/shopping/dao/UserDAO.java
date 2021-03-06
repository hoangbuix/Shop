package com.hoangbui.shopping.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO<E> extends CommonDAO<E> {
    E findByUsernameOrEmail(String s);

    E findByEmail(String email);

    E findByActivationCode(String code);

    E findByIdAndRole(int id);

    void updateActiveCodeAndActiveFlag(E instance);
}