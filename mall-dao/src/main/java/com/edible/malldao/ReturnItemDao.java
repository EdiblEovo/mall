package com.edible.malldao;

import com.edible.mallmodel.ReturnItem;
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

public interface ReturnItemDao {
    @Delete({
        "delete from oms_return_item",
        "where return_id = #{returnId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer returnId);

    @Insert({
        "insert into oms_return_item (order_id, product_id, ",
        "product_price, return_quantity)",
        "values (#{orderId,jdbcType=INTEGER}, #{productId,jdbcType=INTEGER}, ",
        "#{productPrice,jdbcType=DECIMAL}, #{returnQuantity,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="returnId", before=false, resultType=Integer.class)
    int insert(ReturnItem record);

    @InsertProvider(type=ReturnItemSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="returnId", before=false, resultType=Integer.class)
    int insertSelective(ReturnItem record);

    @Select({
        "select",
        "return_id, order_id, product_id, product_price, return_quantity",
        "from oms_return_item",
        "where return_id = #{returnId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="return_id", property="returnId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_price", property="productPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="return_quantity", property="returnQuantity", jdbcType=JdbcType.INTEGER)
    })
    ReturnItem selectByPrimaryKey(Integer returnId);

    @Select({
            "select",
            "return_id, order_id, product_id, product_price, return_quantity",
            "from oms_return_item",
            "where order_id = #{orderId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="return_id", property="returnId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="order_id", property="orderId", jdbcType=JdbcType.INTEGER),
            @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
            @Result(column="product_price", property="productPrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="return_quantity", property="returnQuantity", jdbcType=JdbcType.INTEGER)
    })
    List<ReturnItem> selectByOrderId(Integer orderId);

    @UpdateProvider(type=ReturnItemSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ReturnItem record);

    @Update({
        "update oms_return_item",
        "set order_id = #{orderId,jdbcType=INTEGER},",
          "product_id = #{productId,jdbcType=INTEGER},",
          "product_price = #{productPrice,jdbcType=DECIMAL},",
          "return_quantity = #{returnQuantity,jdbcType=INTEGER}",
        "where return_id = #{returnId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ReturnItem record);
}