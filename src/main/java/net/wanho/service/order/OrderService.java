package net.wanho.service.order;

import net.wanho.pojo.Order;
import net.wanho.pojo.vo.ShoppingCart;
import net.wanho.service.base.BaseService;

public interface OrderService extends BaseService<Order> {

    public Order productOrder(Order order, ShoppingCart cartlist);
}
