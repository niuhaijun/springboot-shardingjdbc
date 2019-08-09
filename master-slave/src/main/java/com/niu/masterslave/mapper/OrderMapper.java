package com.niu.masterslave.mapper;

import com.niu.masterslave.model.Order;
import com.niu.masterslave.model.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OrderMapper {
    int countByExample(OrderExample example);

    /**
     * 返回被删除数据的个数
     */
    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(String uuid);

    /**
     * 插入成功返回1
     * 插入失败抛异常
     */
    int insert(Order record);

    int insertSelective(Order record);

    /**
     * 返回符合查询条件的数据
     */
    List<Order> selectByExampleWithRowbounds(OrderExample example, RowBounds rowBounds);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(String uuid);

    /**
     * 返回符合条件匹配的数据个数
     */
    int updateByExampleSelective(@Param("record") Order record,
        @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Long sumByExample(OrderExample example);

    void batchInsert(@Param("items") List<Order> items);
}