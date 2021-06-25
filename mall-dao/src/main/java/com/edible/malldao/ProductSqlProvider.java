package com.edible.malldao;

import com.edible.mallmodel.Product;
import org.apache.ibatis.jdbc.SQL;

public class ProductSqlProvider {
    public String insertSelective(Product record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("pms_product");
        
        if (record.getShopId() != null) {
            sql.VALUES("shop_id", "#{shopId,jdbcType=INTEGER}");
        }
        
        if (record.getProductName() != null) {
            sql.VALUES("product_name", "#{productName,jdbcType=VARCHAR}");
        }
        
        if (record.getProductPrice() != null) {
            sql.VALUES("product_price", "#{productPrice,jdbcType=INTEGER}");
        }
        
        if (record.getStock() != null) {
            sql.VALUES("stock", "#{stock,jdbcType=INTEGER}");
        }
        
        if (record.getSoldQuantity() != null) {
            sql.VALUES("sold_quantity", "#{soldQuantity,jdbcType=INTEGER}");
        }
        
        if (record.getMonthlySoldQuantity() != null) {
            sql.VALUES("monthly_sold_quantity", "#{monthlySoldQuantity,jdbcType=INTEGER}");
        }
        
        if (record.getAdvertisePrice() != null) {
            sql.VALUES("advertise_price", "#{advertisePrice,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Product record) {
        SQL sql = new SQL();
        sql.UPDATE("pms_product");
        
        if (record.getShopId() != null) {
            sql.SET("shop_id = #{shopId,jdbcType=INTEGER}");
        }
        
        if (record.getProductName() != null) {
            sql.SET("product_name = #{productName,jdbcType=VARCHAR}");
        }
        
        if (record.getProductPrice() != null) {
            sql.SET("product_price = #{productPrice,jdbcType=INTEGER}");
        }
        
        if (record.getStock() != null) {
            sql.SET("stock = #{stock,jdbcType=INTEGER}");
        }
        
        if (record.getSoldQuantity() != null) {
            sql.SET("sold_quantity = #{soldQuantity,jdbcType=INTEGER}");
        }
        
        if (record.getMonthlySoldQuantity() != null) {
            sql.SET("monthly_sold_quantity = #{monthlySoldQuantity,jdbcType=INTEGER}");
        }
        
        if (record.getAdvertisePrice() != null) {
            sql.SET("advertise_price = #{advertisePrice,jdbcType=INTEGER}");
        }
        
        sql.WHERE("product_id = #{productId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}