package com.edible.malldao;

import com.edible.mallmodel.Shop;
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

public interface ShopDao {
    @Delete({
        "delete from ums_shop",
        "where shop_id = #{shopId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer shopId);

    @Insert({
        "insert into ums_shop (username, password, ",
        "shop_name, income, ",
        "status)",
        "values (#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{shopName,jdbcType=VARCHAR}, #{income,jdbcType=DECIMAL}, ",
        "#{status,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="shopId", before=false, resultType=Integer.class)
    int insert(Shop record);

    @InsertProvider(type=ShopSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="shopId", before=false, resultType=Integer.class)
    int insertSelective(Shop record);

    @Select({
        "select",
        "shop_id, username, password, shop_name, income, status",
        "from ums_shop",
        "where shop_id = #{shopId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="shop_id", property="shopId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_name", property="shopName", jdbcType=JdbcType.VARCHAR),
        @Result(column="income", property="income", jdbcType=JdbcType.DECIMAL),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    Shop selectByPrimaryKey(Integer shopId);

    @Select({
            "select",
            "shop_id, username, password, shop_name, income, status",
            "from ums_shop",
            "where username = #{username,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="shop_id", property="shopId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="shop_name", property="shopName", jdbcType=JdbcType.VARCHAR),
            @Result(column="income", property="income", jdbcType=JdbcType.DECIMAL),
            @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    Shop selectByUsername(String username);

    @Select({
            "select",
            "shop_id, username, password, shop_name, income, status",
            "from ums_shop",
            "where shop_name = #{shopName,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="shop_id", property="shopId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="shop_name", property="shopName", jdbcType=JdbcType.VARCHAR),
            @Result(column="income", property="income", jdbcType=JdbcType.DECIMAL),
            @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    Shop selectByShopName(String shopName);

    @Select({
        "select",
        "shop_id, username, password, shop_name, income, status",
        "from ums_shop",
        "where username = #{username,jdbcType=VARCHAR}",
        "and password = #{password, jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="shop_id", property="shopId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_name", property="shopName", jdbcType=JdbcType.VARCHAR),
        @Result(column="income", property="income", jdbcType=JdbcType.DECIMAL),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    Shop login(String username, String password);

    @UpdateProvider(type=ShopSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Shop record);

    @Update({
        "update ums_shop",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "shop_name = #{shopName,jdbcType=VARCHAR},",
          "income = #{income,jdbcType=DECIMAL},",
          "status = #{status,jdbcType=INTEGER}",
        "where shop_id = #{shopId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Shop record);
}