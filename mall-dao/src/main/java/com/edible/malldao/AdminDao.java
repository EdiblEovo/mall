package com.edible.malldao;

import com.edible.mallmodel.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AdminDao {
    @Delete({
        "delete from ums_admin",
        "where admin_id = #{adminId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer adminId);

    @Insert({
        "insert into ums_admin (username, password, ",
        "nickname)",
        "values (#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{nickname,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="adminId", before=false, resultType=Integer.class)
    int insert(Admin record);

    @InsertProvider(type=AdminSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="adminId", before=false, resultType=Integer.class)
    int insertSelective(Admin record);

    @Select({
        "select",
        "admin_id, username, password, nickname",
        "from ums_admin",
        "where admin_id = #{adminId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR)
    })
    Admin selectByPrimaryKey(Integer adminId);

    @Select({
            "select",
            "admin_id, username, password, nickname",
            "from ums_admin",
            "where username = #{username,jdbcType=VARCHAR}",
            "and password = #{password, jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="admin_id", property="adminId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR)
    })
    Admin login(String username, String password);

    @UpdateProvider(type=AdminSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Admin record);

    @Update({
        "update ums_admin",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "nickname = #{nickname,jdbcType=VARCHAR}",
        "where admin_id = #{adminId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Admin record);
}