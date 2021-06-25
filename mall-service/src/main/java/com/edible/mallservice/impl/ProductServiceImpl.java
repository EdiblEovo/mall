package com.edible.mallservice.impl;

import com.edible.malldao.ProductDao;
import com.edible.mallmodel.Product;
import com.edible.mallservice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public int createProduct(Product product) {
        return productDao.insert(product);
    }

    @Override
    public int deleteProduct(Product product) {
        return productDao.deleteByPrimaryKey(product.getProductId());
    }

    @Override
    public int updateProduct(Product product) {
        return productDao.updateByPrimaryKey(product);
    }

    @Override
    public Product getProductByProductId(int productId) {return productDao.selectByPrimaryKey(productId);}

    @Override
    public List<Product> getProductByShopId(int shopId) {
        return productDao.selectByShopId(shopId);
    }

    @Override
    public List<Product> getAllProduct(int page, int row) {
        PageHelper.startPage(page, row);
        return productDao.selectAll();
    }

    @Override
    public BigDecimal getProductPriceByProductId(int productId) {
        return productDao.selectByPrimaryKey(productId).getProductPrice();
    }


}
