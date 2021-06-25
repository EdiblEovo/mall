package com.edible.malldao;

import com.edible.mallmodel.AdvertiseOrder;
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

public interface AdvertiseOrderDao {
    @Delete({
        "delete from sms_advertise_order",
        "where advertise_id = #{advertiseId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer advertiseId);

    @Insert({
        "insert into sms_advertise_order (shop_id, product_id, ",
        "advertise_price, advertise_count, ",
        "start_time, end_time)",
        "values (#{shopId,jdbcType=INTEGER}, #{productId,jdbcType=INTEGER}, ",
        "#{advertisePrice,jdbcType=DECIMAL}, #{advertiseCount,jdbcType=INTEGER}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="advertiseId", before=false, resultType=Integer.class)
    int insert(AdvertiseOrder record);

    @InsertProvider(type=AdvertiseOrderSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="advertiseId", before=false, resultType=Integer.class)
    int insertSelective(AdvertiseOrder record);

    @Select({
        "select",
        "advertise_id, shop_id, product_id, advertise_price, advertise_count, start_time, ",
        "end_time",
        "from sms_advertise_order",
        "where advertise_id = #{advertiseId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="advertise_id", property="advertiseId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="shop_id", property="shopId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="advertise_price", property="advertisePrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="advertise_count", property="advertiseCount", jdbcType=JdbcType.INTEGER),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP)
    })
    AdvertiseOrder selectByPrimaryKey(Integer advertiseId);

    @UpdateProvider(type=AdvertiseOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AdvertiseOrder record);

    @Update({
        "update sms_advertise_order",
        "set shop_id = #{shopId,jdbcType=INTEGER},",
          "product_id = #{productId,jdbcType=INTEGER},",
          "advertise_price = #{advertisePrice,jdbcType=DECIMAL},",
          "advertise_count = #{advertiseCount,jdbcType=INTEGER},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP}",
        "where advertise_id = #{advertiseId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AdvertiseOrder record);
}