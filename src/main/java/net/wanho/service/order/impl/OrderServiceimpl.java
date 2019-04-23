package net.wanho.service.order.impl;

import net.wanho.mapper.OrderMapper;
import net.wanho.pojo.Order;
import net.wanho.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceimpl implements OrderService {


    @Autowired
    private OrderMapper orderMapper;


    @Override
    public int deleteByPrimaryKey(Long tid) {
        return orderMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public int insert(Order record) {
        return orderMapper.insert(record);
    }

    @Override
    public int insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    @Override
    public Order selectByPrimaryKey(Long tid) {
        return orderMapper.selectByPrimaryKey(tid);
    }

    @Override
    public int updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }
}
