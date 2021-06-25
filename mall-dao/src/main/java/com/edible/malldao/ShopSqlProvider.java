package com.edible.malldao;

import com.edible.mallmodel.Shop;
import org.apache.ibatis.jdbc.SQL;

public class ShopSqlProvider {
    public String insertSelective(Shop record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ums_shop");
        
        if (record.getUsername() != null) {
            sql.VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getShopName() != null) {
            sql.VALUES("shop_name", "#{shopName,jdbcType=VARCHAR}");
        }
        
        if (record.getIncome() != null) {
            sql.VALUES("income", "#{income,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Shop record) {
        SQL sql = new SQL();
        sql.UPDATE("ums_shop");
        
        if (record.getUsername() != null) {
            sql.SET("username = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getShopName() != null) {
            sql.SET("shop_name = #{shopName,jdbcType=VARCHAR}");
        }
        
        if (record.getIncome() != null) {
            sql.SET("income = #{income,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        sql.WHERE("shop_id = #{shopId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}