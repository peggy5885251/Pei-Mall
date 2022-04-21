package com.pei.peimall.dao;

import com.pei.peimall.constant.ProductCategory;
import com.pei.peimall.dto.ProductRequest;
import com.pei.peimall.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductCategory category, String search);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
