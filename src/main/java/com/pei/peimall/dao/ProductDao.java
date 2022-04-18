package com.pei.peimall.dao;

import com.pei.peimall.dto.ProductRequest;
import com.pei.peimall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

}
