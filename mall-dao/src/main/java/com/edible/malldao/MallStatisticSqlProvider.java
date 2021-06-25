package com.edible.malldao;

import com.edible.mallmodel.MallStatistic;
import org.apache.ibatis.jdbc.SQL;

public class MallStatisticSqlProvider {
    public String insertSelective(MallStatistic record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ums_mall_statistic");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getOrderCount() != null) {
            sql.VALUES("order_count", "#{orderCount,jdbcType=INTEGER}");
        }
        
        if (record.getShopCount() != null) {
            sql.VALUES("shop_count", "#{shopCount,jdbcType=INTEGER}");
        }
        
        if (record.getMemberCount() != null) {
            sql.VALUES("member_count", "#{memberCount,jdbcType=INTEGER}");
        }
        
        if (record.getProductCount() != null) {
            sql.VALUES("product_count", "#{productCount,jdbcType=INTEGER}");
        }
        
        if (record.getConsumeAmount() != null) {
            sql.VALUES("consume_amount", "#{consumeAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getFeeAmount() != null) {
            sql.VALUES("fee_amount", "#{feeAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getAdvertiseAmount() != null) {
            sql.VALUES("advertise_amount", "#{advertiseAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getIncome() != null) {
            sql.VALUES("income", "#{income,jdbcType=DECIMAL}");
        }
        
        if (record.getTime() != null) {
            sql.VALUES("time", "#{time,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(MallStatistic record) {
        SQL sql = new SQL();
        sql.UPDATE("ums_mall_statistic");
        
        if (record.getOrderCount() != null) {
            sql.SET("order_count = #{orderCount,jdbcType=INTEGER}");
        }
        
        if (record.getShopCount() != null) {
            sql.SET("shop_count = #{shopCount,jdbcType=INTEGER}");
        }
        
        if (record.getMemberCount() != null) {
            sql.SET("member_count = #{memberCount,jdbcType=INTEGER}");
        }
        
        if (record.getProductCount() != null) {
            sql.SET("product_count = #{productCount,jdbcType=INTEGER}");
        }
        
        if (record.getConsumeAmount() != null) {
            sql.SET("consume_amount = #{consumeAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getFeeAmount() != null) {
            sql.SET("fee_amount = #{feeAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getAdvertiseAmount() != null) {
            sql.SET("advertise_amount = #{advertiseAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getIncome() != null) {
            sql.SET("income = #{income,jdbcType=DECIMAL}");
        }
        
        if (record.getTime() != null) {
            sql.SET("time = #{time,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}