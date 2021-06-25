package com.edible.malldao;

import com.edible.mallmodel.ShopStatistic;
import org.apache.ibatis.jdbc.SQL;

public class ShopStatisticSqlProvider {
    public String insertSelective(ShopStatistic record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ums_shop_statistic");
        
        if (record.getShopId() != null) {
            sql.VALUES("shop_id", "#{shopId,jdbcType=INTEGER}");
        }
        
        if (record.getProductCount() != null) {
            sql.VALUES("product_count", "#{productCount,jdbcType=INTEGER}");
        }
        
        if (record.getOrderCount() != null) {
            sql.VALUES("order_count", "#{orderCount,jdbcType=INTEGER}");
        }
        
        if (record.getIncomeAmount() != null) {
            sql.VALUES("income_amount", "#{incomeAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getFeeAmount() != null) {
            sql.VALUES("fee_amount", "#{feeAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getAdvertiseAmount() != null) {
            sql.VALUES("advertise_amount", "#{advertiseAmount,jdbcType=DECIMAL}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ShopStatistic record) {
        SQL sql = new SQL();
        sql.UPDATE("ums_shop_statistic");
        
        if (record.getProductCount() != null) {
            sql.SET("product_count = #{productCount,jdbcType=INTEGER}");
        }
        
        if (record.getOrderCount() != null) {
            sql.SET("order_count = #{orderCount,jdbcType=INTEGER}");
        }
        
        if (record.getIncomeAmount() != null) {
            sql.SET("income_amount = #{incomeAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getFeeAmount() != null) {
            sql.SET("fee_amount = #{feeAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getAdvertiseAmount() != null) {
            sql.SET("advertise_amount = #{advertiseAmount,jdbcType=DECIMAL}");
        }
        
        sql.WHERE("shop_id = #{shopId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}