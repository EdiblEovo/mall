package com.edible.malldao;

import com.edible.mallmodel.MallStatistic;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface MallStatisticDao {
    @Delete({
        "delete from ums_mall_statistic",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ums_mall_statistic (id, order_count, ",
        "shop_count, member_count, ",
        "product_count, consume_amount, ",
        "fee_amount, advertise_amount, ",
        "income, time)",
        "values (#{id,jdbcType=INTEGER}, #{orderCount,jdbcType=INTEGER}, ",
        "#{shopCount,jdbcType=INTEGER}, #{memberCount,jdbcType=INTEGER}, ",
        "#{productCount,jdbcType=INTEGER}, #{consumeAmount,jdbcType=DECIMAL}, ",
        "#{feeAmount,jdbcType=DECIMAL}, #{advertiseAmount,jdbcType=DECIMAL}, ",
        "#{income,jdbcType=DECIMAL}, #{time,jdbcType=TIMESTAMP})"
    })
    int insert(MallStatistic record);

    @InsertProvider(type=MallStatisticSqlProvider.class, method="insertSelective")
    int insertSelective(MallStatistic record);

    @Select({
        "select",
        "id, order_count, shop_count, member_count, product_count, consume_amount, fee_amount, ",
        "advertise_amount, income, time",
        "from ums_mall_statistic",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="order_count", property="orderCount", jdbcType=JdbcType.INTEGER),
        @Result(column="shop_count", property="shopCount", jdbcType=JdbcType.INTEGER),
        @Result(column="member_count", property="memberCount", jdbcType=JdbcType.INTEGER),
        @Result(column="product_count", property="productCount", jdbcType=JdbcType.INTEGER),
        @Result(column="consume_amount", property="consumeAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="fee_amount", property="feeAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="advertise_amount", property="advertiseAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="income", property="income", jdbcType=JdbcType.DECIMAL),
        @Result(column="time", property="time", jdbcType=JdbcType.TIMESTAMP)
    })
    MallStatistic selectByPrimaryKey(Integer id);

    @UpdateProvider(type=MallStatisticSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MallStatistic record);

    @Update({
        "update ums_mall_statistic",
        "set order_count = #{orderCount,jdbcType=INTEGER},",
          "shop_count = #{shopCount,jdbcType=INTEGER},",
          "member_count = #{memberCount,jdbcType=INTEGER},",
          "product_count = #{productCount,jdbcType=INTEGER},",
          "consume_amount = #{consumeAmount,jdbcType=DECIMAL},",
          "fee_amount = #{feeAmount,jdbcType=DECIMAL},",
          "advertise_amount = #{advertiseAmount,jdbcType=DECIMAL},",
          "income = #{income,jdbcType=DECIMAL},",
          "time = #{time,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MallStatistic record);
}