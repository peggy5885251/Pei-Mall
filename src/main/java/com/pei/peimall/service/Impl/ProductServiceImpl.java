package com.pei.peimall.service.Impl;

import com.pei.peimall.dao.Impl.ProductDaoImpl;
import com.pei.peimall.dao.ProductDao;
import com.pei.peimall.model.Product;
import com.pei.peimall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
