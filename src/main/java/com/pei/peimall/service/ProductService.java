package com.pei.peimall.service;

import com.pei.peimall.dto.ProductRequest;
import com.pei.peimall.model.Product;
import org.springframework.stereotype.Component;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
