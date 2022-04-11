package com.pei.peimall.service;

import com.pei.peimall.model.Product;
import org.springframework.stereotype.Component;

public interface ProductService {
    Product getProductById(Integer productId);

}
