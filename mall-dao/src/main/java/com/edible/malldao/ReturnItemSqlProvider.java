package com.edible.malldao;

import com.edible.mallmodel.ReturnItem;
import org.apache.ibatis.jdbc.SQL;

public class ReturnItemSqlProvider {
    public String insertSelective(ReturnItem record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("oms_return_item");
        
        if (record.getOrderId() != null) {
            sql.VALUES("order_id", "#{orderId,jdbcType=INTEGER}");
        }
        
        if (record.getProductId() != null) {
            sql.VALUES("product_id", "#{productId,jdbcType=INTEGER}");
        }
        
        if (record.getProductPrice() != null) {
            sql.VALUES("product_price", "#{productPrice,jdbcType=INTEGER}");
        }
        
        if (record.getReturnQuantity() != null) {
            sql.VALUES("return_quantity", "#{returnQuantity,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ReturnItem record) {
        SQL sql = new SQL();
        sql.UPDATE("oms_return_item");
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{orderId,jdbcType=INTEGER}");
        }
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{productId,jdbcType=INTEGER}");
        }
        
        if (record.getProductPrice() != null) {
            sql.SET("product_price = #{productPrice,jdbcType=INTEGER}");
        }
        
        if (record.getReturnQuantity() != null) {
            sql.SET("return_quantity = #{returnQuantity,jdbcType=INTEGER}");
        }
        
        sql.WHERE("return_id = #{returnId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}