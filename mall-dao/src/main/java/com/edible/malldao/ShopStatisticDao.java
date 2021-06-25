package com.edible.malldao;

import com.edible.mallmodel.ShopStatistic;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ShopStatisticDao {
    @Delete({
        "delete from ums_shop_statistic",
        "where shop_id = #{shopId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer shopId);

    @Insert({
        "insert into ums_shop_statistic (shop_id, product_count, ",
        "order_count, income_amount, ",
        "fee_amount, advertise_amount)",
        "values (#{shopId,jdbcType=INTEGER}, #{productCount,jdbcType=INTEGER}, ",
        "#{orderCount,jdbcType=INTEGER}, #{incomeAmount,jdbcType=DECIMAL}, ",
        "#{feeAmount,jdbcType=DECIMAL}, #{advertiseAmount,jdbcType=DECIMAL})"
    })
    int insert(ShopStatistic record);

    @InsertProvider(type=ShopStatisticSqlProvider.class, method="insertSelective")
    int insertSelective(ShopStatistic record);

    @Select({
        "select",
        "shop_id, product_count, order_count, income_amount, fee_amount, advertise_amount",
        "from ums_shop_statistic",
        "where shop_id = #{shopId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="shop_id", property="shopId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="product_count", property="productCount", jdbcType=JdbcType.INTEGER),
        @Result(column="order_count", property="orderCount", jdbcType=JdbcType.INTEGER),
        @Result(column="income_amount", property="incomeAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="fee_amount", property="feeAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="advertise_amount", property="advertiseAmount", jdbcType=JdbcType.DECIMAL)
    })
    ShopStatistic selectByPrimaryKey(Integer shopId);

    @UpdateProvider(type=ShopStatisticSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ShopStatistic record);

    @Update({
        "update ums_shop_statistic",
        "set product_count = #{productCount,jdbcType=INTEGER},",
          "order_count = #{orderCount,jdbcType=INTEGER},",
          "income_amount = #{incomeAmount,jdbcType=DECIMAL},",
          "fee_amount = #{feeAmount,jdbcType=DECIMAL},",
          "advertise_amount = #{advertiseAmount,jdbcType=DECIMAL}",
        "where shop_id = #{shopId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ShopStatistic record);
}