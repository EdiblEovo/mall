package com.edible.malldao;

import com.edible.mallmodel.Order;
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

import java.util.List;

public interface OrderDao {
    @Delete({
        "delete from oms_order",
        "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer orderId);

    @Insert({
        "insert into oms_order (member_id, shop_id, ",
        "status, created_time, ",
        "pay_amount, return_amount, ",
        "fee_amount)",
        "values (#{memberId,jdbcType=INTEGER}, #{shopId,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{createdTime,jdbcType=TIMESTAMP}, ",
        "#{payAmount,jdbcType=DECIMAL}, #{returnAmount,jdbcType=DECIMAL}, ",
        "#{feeAmount,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="orderId", before=false, resultType=Integer.class)
    int insert(Order record);

    @InsertProvider(type=OrderSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="orderId", before=false, resultType=Integer.class)
    int insertSelective(Order record);

    @Select({
        "select",
        "order_id, member_id, shop_id, status, created_time, pay_amount, return_amount, ",
        "fee_amount",
        "from oms_order",
        "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="member_id", property="memberId", jdbcType=JdbcType.INTEGER),
        @Result(column="shop_id", property="shopId", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="return_amount", property="returnAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="fee_amount", property="feeAmount", jdbcType=JdbcType.DECIMAL)
    })
    Order selectByPrimaryKey(Integer orderId);

    @Select({
            "select",
            "order_id, member_id, shop_id, status, created_time, pay_amount, return_amount, ",
            "fee_amount",
            "from oms_order",
            "where member_id = #{memberId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="member_id", property="memberId", jdbcType=JdbcType.INTEGER),
            @Result(column="shop_id", property="shopId", jdbcType=JdbcType.INTEGER),
            @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
            @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="return_amount", property="returnAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="fee_amount", property="feeAmount", jdbcType=JdbcType.DECIMAL)
    })
    List<Order> selectByMemberId(Integer memberId);

    @Select({
            "select",
            "order_id, member_id, shop_id, status, created_time, pay_amount, return_amount, ",
            "fee_amount",
            "from oms_order",
            "where shop_id = #{shopId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="member_id", property="memberId", jdbcType=JdbcType.INTEGER),
            @Result(column="shop_id", property="shopId", jdbcType=JdbcType.INTEGER),
            @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
            @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="pay_amount", property="payAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="return_amount", property="returnAmount", jdbcType=JdbcType.DECIMAL),
            @Result(column="fee_amount", property="feeAmount", jdbcType=JdbcType.DECIMAL)
    })
    List<Order> selectByShopId(Integer shopId);

    @UpdateProvider(type=OrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Order record);

    @Update({
        "update oms_order",
        "set member_id = #{memberId,jdbcType=INTEGER},",
          "shop_id = #{shopId,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP},",
          "pay_amount = #{payAmount,jdbcType=DECIMAL},",
          "return_amount = #{returnAmount,jdbcType=DECIMAL},",
          "fee_amount = #{feeAmount,jdbcType=DECIMAL}",
        "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Order record);

    @Update({
            "update oms_order",
            "set status = #{status,jdbcType=INTEGER",
            "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    int updateStatusByOrderId(int orderId, int status);
}