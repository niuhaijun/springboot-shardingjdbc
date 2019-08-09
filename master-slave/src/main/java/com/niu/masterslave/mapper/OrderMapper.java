package com.niu.masterslave.mapper;

import com.niu.masterslave.model.Order;
import com.niu.masterslave.model.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OrderMapper {
    int countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExampleWithRowbounds(OrderExample example, RowBounds rowBounds);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") Order record,
        @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Long sumByExample(OrderExample example);

    void batchInsert(@Param("items") List<Order> items);
}