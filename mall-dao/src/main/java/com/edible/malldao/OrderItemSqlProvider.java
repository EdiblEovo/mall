package com.edible.malldao;

import com.edible.mallmodel.OrderItem;
import org.apache.ibatis.jdbc.SQL;

public class OrderItemSqlProvider {
    public String insertSelective(OrderItem record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("oms_order_item");
        
        if (record.getOrderId() != null) {
            sql.VALUES("order_id", "#{orderId,jdbcType=INTEGER}");
        }
        
        if (record.getProductId() != null) {
            sql.VALUES("product_id", "#{productId,jdbcType=INTEGER}");
        }
        
        if (record.getProductPrice() != null) {
            sql.VALUES("product_price", "#{productPrice,jdbcType=INTEGER}");
        }
        
        if (record.getOrderQuantity() != null) {
            sql.VALUES("order_quantity", "#{orderQuantity,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OrderItem record) {
        SQL sql = new SQL();
        sql.UPDATE("oms_order_item");
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{orderId,jdbcType=INTEGER}");
        }
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{productId,jdbcType=INTEGER}");
        }
        
        if (record.getProductPrice() != null) {
            sql.SET("product_price = #{productPrice,jdbcType=INTEGER}");
        }
        
        if (record.getOrderQuantity() != null) {
            sql.SET("order_quantity = #{orderQuantity,jdbcType=INTEGER}");
        }
        
        sql.WHERE("item_id = #{itemId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}