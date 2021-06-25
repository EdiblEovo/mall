package com.edible.malldao;

import com.edible.mallmodel.Admin;
import org.apache.ibatis.jdbc.SQL;

public class AdminSqlProvider {
    public String insertSelective(Admin record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ums_admin");
        
        if (record.getUsername() != null) {
            sql.VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getNickname() != null) {
            sql.VALUES("nickname", "#{nickname,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Admin record) {
        SQL sql = new SQL();
        sql.UPDATE("ums_admin");
        
        if (record.getUsername() != null) {
            sql.SET("username = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getNickname() != null) {
            sql.SET("nickname = #{nickname,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("admin_id = #{adminId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}