package com.edible.malldao;

import com.edible.mallmodel.Admin;
import com.edible.mallmodel.Member;
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

public interface MemberDao {
    @Delete({
        "delete from ums_member",
        "where member_id = #{memberId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer memberId);

    @Insert({
        "insert into ums_member (username, password, ",
        "email, nickname, ",
        "created_time, status)",
        "values (#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{nickname,jdbcType=VARCHAR}, ",
        "#{createdTime,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="memberId", before=false, resultType=Integer.class)
    int insert(Member record);

    @InsertProvider(type=MemberSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="memberId", before=false, resultType=Integer.class)
    int insertSelective(Member record);

    @Select({
        "select",
        "member_id, username, password, email, nickname, created_time, status",
        "from ums_member",
        "where member_id = #{memberId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="member_id", property="memberId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    Member selectByPrimaryKey(Integer memberId);

    @Select({
            "select",
            "member_id, username, password, email, nickname, created_time, status",
            "from ums_member",
            "where username = #{username,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="member_id", property="memberId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
            @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
            @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    Member selectByUsername(String username);

    @Select({
            "select",
            "member_id, username, password, email, nickname, created_time, status",
            "from ums_member",
            "where email = #{email,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="member_id", property="memberId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
            @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
            @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    Member selectByEmail(String email);

    @Select({
            "select",
            "member_id, username, password, email, nickname, created_time, status",
            "from ums_member",
            "where username = #{username,jdbcType=VARCHAR}",
            "and password = #{password, jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="member_id", property="memberId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
            @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
            @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    Member login(String username, String password);

    @UpdateProvider(type=MemberSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Member record);

    @Update({
        "update ums_member",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "nickname = #{nickname,jdbcType=VARCHAR},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER}",
        "where member_id = #{memberId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Member record);
}