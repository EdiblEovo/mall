package com.edible.malldao;

import com.edible.mallmodel.OrderItem;
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

public interface OrderItemDao {
    @Delete({
        "delete from oms_order_item",
        "where item_id = #{itemId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer itemId);

    @Insert({
        "insert into oms_order_item (order_id, product_id, ",
        "product_price, order_quantity)",
        "values (#{orderId,jdbcType=INTEGER}, #{productId,jdbcType=INTEGER}, ",
        "#{productPrice,jdbcType=DECIMAL}, #{orderQuantity,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="itemId", before=false, resultType=Integer.class)
    int insert(OrderItem record);

    @InsertProvider(type=OrderItemSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="itemId", before=false, resultType=Integer.class)
    int insertSelective(OrderItem record);

    @Select({
        "select",
        "item_id, order_id, product_id, product_price, order_quantity",
        "from oms_order_item",
        "where item_id = #{itemId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="item_id", property="itemId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_price", property="productPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="order_quantity", property="orderQuantity", jdbcType=JdbcType.INTEGER)
    })
    OrderItem selectByPrimaryKey(Integer itemId);

    @Select({
            "select",
            "item_id, order_id, product_id, product_price, order_quantity",
            "from oms_order_item",
            "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="item_id", property="itemId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
            @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
            @Result(column="product_price", property="productPrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="order_quantity", property="orderQuantity", jdbcType=JdbcType.INTEGER)
    })
    List<OrderItem> selectByOrderId(Integer orderId);

    @UpdateProvider(type=OrderItemSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderItem record);

    @Update({
        "update oms_order_item",
        "set order_id = #{orderId,jdbcType=INTEGER},",
          "product_id = #{productId,jdbcType=INTEGER},",
          "product_price = #{productPrice,jdbcType=DECIMAL},",
          "order_quantity = #{orderQuantity,jdbcType=INTEGER}",
        "where item_id = #{itemId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OrderItem record);
}