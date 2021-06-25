package com.edible.malldao;

import com.edible.mallmodel.MemberStatistic;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface MemberStatisticDao {
    @Delete({
        "delete from ums_member_statistic",
        "where member_id = #{memberId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer memberId);

    @Insert({
        "insert into ums_member_statistic (member_id, order_count, ",
        "consume_amount)",
        "values (#{memberId,jdbcType=INTEGER}, #{orderCount,jdbcType=INTEGER}, ",
        "#{consumeAmount,jdbcType=DECIMAL})"
    })
    int insert(MemberStatistic record);

    @InsertProvider(type=MemberStatisticSqlProvider.class, method="insertSelective")
    int insertSelective(MemberStatistic record);

    @Select({
        "select",
        "member_id, order_count, consume_amount",
        "from ums_member_statistic",
        "where member_id = #{memberId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="member_id", property="memberId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="order_count", property="orderCount", jdbcType=JdbcType.INTEGER),
        @Result(column="consume_amount", property="consumeAmount", jdbcType=JdbcType.DECIMAL)
    })
    MemberStatistic selectByPrimaryKey(Integer memberId);

    @UpdateProvider(type=MemberStatisticSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MemberStatistic record);

    @Update({
        "update ums_member_statistic",
        "set order_count = #{orderCount,jdbcType=INTEGER},",
          "consume_amount = #{consumeAmount,jdbcType=DECIMAL}",
        "where member_id = #{memberId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MemberStatistic record);
}