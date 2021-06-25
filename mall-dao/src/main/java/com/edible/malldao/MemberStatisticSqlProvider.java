package com.edible.malldao;

import com.edible.mallmodel.MemberStatistic;
import org.apache.ibatis.jdbc.SQL;

public class MemberStatisticSqlProvider {
    public String insertSelective(MemberStatistic record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ums_member_statistic");
        
        if (record.getMemberId() != null) {
            sql.VALUES("member_id", "#{memberId,jdbcType=INTEGER}");
        }
        
        if (record.getOrderCount() != null) {
            sql.VALUES("order_count", "#{orderCount,jdbcType=INTEGER}");
        }
        
        if (record.getConsumeAmount() != null) {
            sql.VALUES("consume_amount", "#{consumeAmount,jdbcType=DECIMAL}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(MemberStatistic record) {
        SQL sql = new SQL();
        sql.UPDATE("ums_member_statistic");
        
        if (record.getOrderCount() != null) {
            sql.SET("order_count = #{orderCount,jdbcType=INTEGER}");
        }
        
        if (record.getConsumeAmount() != null) {
            sql.SET("consume_amount = #{consumeAmount,jdbcType=DECIMAL}");
        }
        
        sql.WHERE("member_id = #{memberId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}