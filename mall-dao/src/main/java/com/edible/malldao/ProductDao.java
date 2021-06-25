package com.edible.malldao;

import com.edible.mallmodel.Product;
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

public interface ProductDao {
    @Delete({
        "delete from pms_product",
        "where product_id = #{productId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer productId);

    @Insert({
        "insert into pms_product (shop_id, product_name, ",
        "product_price, stock, ",
        "sold_quantity, monthly_sold_quantity, ",
        "advertise_price)",
        "values (#{shopId,jdbcType=INTEGER}, #{productName,jdbcType=VARCHAR}, ",
        "#{productPrice,jdbcType=DECIMAL}, #{stock,jdbcType=INTEGER}, ",
        "#{soldQuantity,jdbcType=INTEGER}, #{monthlySoldQuantity,jdbcType=INTEGER}, ",
        "#{advertisePrice,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="productId", before=false, resultType=Integer.class)
    int insert(Product record);

    @InsertProvider(type=ProductSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="productId", before=false, resultType=Integer.class)
    int insertSelective(Product record);

    @Select({
        "select",
        "product_id, shop_id, product_name, product_price, stock, sold_quantity, monthly_sold_quantity, ",
        "advertise_price",
        "from pms_product",
        "where product_id = #{productId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="shop_id", property="shopId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_price", property="productPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="sold_quantity", property="soldQuantity", jdbcType=JdbcType.INTEGER),
        @Result(column="monthly_sold_quantity", property="monthlySoldQuantity", jdbcType=JdbcType.INTEGER),
        @Result(column="advertise_price", property="advertisePrice", jdbcType=JdbcType.DECIMAL)
    })
    Product selectByPrimaryKey(Integer productId);

    @Select({
            "select",
            "product_id, shop_id, product_name, product_price, stock, sold_quantity, monthly_sold_quantity, ",
            "advertise_price",
            "from pms_product",
            "where shop_id = #{shopId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="shop_id", property="shopId", jdbcType=JdbcType.INTEGER),
            @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_price", property="productPrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
            @Result(column="sold_quantity", property="soldQuantity", jdbcType=JdbcType.INTEGER),
            @Result(column="monthly_sold_quantity", property="monthlySoldQuantity", jdbcType=JdbcType.INTEGER),
            @Result(column="advertise_price", property="advertisePrice", jdbcType=JdbcType.DECIMAL)
    })
    List<Product> selectByShopId(Integer shopId);

    @Select({
            "select",
            "product_id, shop_id, product_name, product_price, stock, sold_quantity, monthly_sold_quantity, ",
            "advertise_price",
            "from pms_product"
    })
    @Results({
            @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="shop_id", property="shopId", jdbcType=JdbcType.INTEGER),
            @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_price", property="productPrice", jdbcType=JdbcType.DECIMAL),
            @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
            @Result(column="sold_quantity", property="soldQuantity", jdbcType=JdbcType.INTEGER),
            @Result(column="monthly_sold_quantity", property="monthlySoldQuantity", jdbcType=JdbcType.INTEGER),
            @Result(column="advertise_price", property="advertisePrice", jdbcType=JdbcType.DECIMAL)
    })
    List<Product> selectAll();

    @UpdateProvider(type=ProductSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Product record);

    @Update({
        "update pms_product",
        "set shop_id = #{shopId,jdbcType=INTEGER},",
          "product_name = #{productName,jdbcType=VARCHAR},",
          "product_price = #{productPrice,jdbcType=DECIMAL},",
          "stock = #{stock,jdbcType=INTEGER},",
          "sold_quantity = #{soldQuantity,jdbcType=INTEGER},",
          "monthly_sold_quantity = #{monthlySoldQuantity,jdbcType=INTEGER},",
          "advertise_price = #{advertisePrice,jdbcType=DECIMAL}",
        "where product_id = #{productId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Product record);
}