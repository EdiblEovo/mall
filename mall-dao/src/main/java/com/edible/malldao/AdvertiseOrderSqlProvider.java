package com.edible.malldao;

import com.edible.mallmodel.AdvertiseOrder;
import org.apache.ibatis.jdbc.SQL;

public class AdvertiseOrderSqlProvider {
    public String insertSelective(AdvertiseOrder record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sms_advertise_order");
        
        if (record.getShopId() != null) {
            sql.VALUES("shop_id", "#{shopId,jdbcType=INTEGER}");
        }
        
        if (record.getProductId() != null) {
            sql.VALUES("product_id", "#{productId,jdbcType=INTEGER}");
        }
        
        if (record.getAdvertisePrice() != null) {
            sql.VALUES("advertise_price", "#{advertisePrice,jdbcType=INTEGER}");
        }
        
        if (record.getAdvertiseCount() != null) {
            sql.VALUES("advertise_count", "#{advertiseCount,jdbcType=INTEGER}");
        }
        
        if (record.getStartTime() != null) {
            sql.VALUES("start_time", "#{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.VALUES("end_time", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(AdvertiseOrder record) {
        SQL sql = new SQL();
        sql.UPDATE("sms_advertise_order");
        
        if (record.getShopId() != null) {
            sql.SET("shop_id = #{shopId,jdbcType=INTEGER}");
        }
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{productId,jdbcType=INTEGER}");
        }
        
        if (record.getAdvertisePrice() != null) {
            sql.SET("advertise_price = #{advertisePrice,jdbcType=INTEGER}");
        }
        
        if (record.getAdvertiseCount() != null) {
            sql.SET("advertise_count = #{advertiseCount,jdbcType=INTEGER}");
        }
        
        if (record.getStartTime() != null) {
            sql.SET("start_time = #{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            sql.SET("end_time = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("advertise_id = #{advertiseId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}