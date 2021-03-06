package com.hoangbui.shopping.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "product_category")
@Table(name = "product_category")
public class ProductCategoryEntity extends BaseEntity {
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "product_id")
    private int productId;

//    @ManyToMany(cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE
//    })
//    @JoinTable(name = "post_tag",
//            joinColumns = @JoinColumn(name = "product_id"),
//            inverseJoinColumns = @JoinColumn(name = "category_id")
//    )
//    private List<CategoryEntity> tags = new ArrayList<>();
}