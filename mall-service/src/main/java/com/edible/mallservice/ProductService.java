package com.edible.mallservice;

import com.edible.mallmodel.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    int createProduct(Product product);

    int deleteProduct(Product product);

    int updateProduct(Product product);

    Product getProductByProductId(int productId);

    List<Product> getProductByShopId(int shopId);

    List<Product> getAllProduct(int page, int row);

    BigDecimal getProductPriceByProductId(int productId);

}
