package com.edible.malldao;

import com.edible.mallmodel.Order;
import org.apache.ibatis.jdbc.SQL;

public class OrderSqlProvider {
    public String insertSelective(Order record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("oms_order");
        
        if (record.getMemberId() != null) {
            sql.VALUES("member_id", "#{memberId,jdbcType=INTEGER}");
        }
        
        if (record.getShopId() != null) {
            sql.VALUES("shop_id", "#{shopId,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedTime() != null) {
            sql.VALUES("created_time", "#{createdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayAmount() != null) {
            sql.VALUES("pay_amount", "#{payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getReturnAmount() != null) {
            sql.VALUES("return_amount", "#{returnAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getFeeAmount() != null) {
            sql.VALUES("fee_amount", "#{feeAmount,jdbcType=DECIMAL}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Order record) {
        SQL sql = new SQL();
        sql.UPDATE("oms_order");
        
        if (record.getMemberId() != null) {
            sql.SET("member_id = #{memberId,jdbcType=INTEGER}");
        }
        
        if (record.getShopId() != null) {
            sql.SET("shop_id = #{shopId,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedTime() != null) {
            sql.SET("created_time = #{createdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayAmount() != null) {
            sql.SET("pay_amount = #{payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getReturnAmount() != null) {
            sql.SET("return_amount = #{returnAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getFeeAmount() != null) {
            sql.SET("fee_amount = #{feeAmount,jdbcType=DECIMAL}");
        }
        
        sql.WHERE("order_id = #{orderId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}