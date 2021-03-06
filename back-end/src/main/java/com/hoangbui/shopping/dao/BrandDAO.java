package com.hoangbui.shopping.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface BrandDAO<E> extends CommonDAO<E> {
    E findByBrandName(String brandName);
}
