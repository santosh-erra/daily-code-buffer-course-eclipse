package com.dailycodebuffer.orderservice.mapper;

import com.dailycodebuffer.orderservice.dto.OrderDTO;
import com.dailycodebuffer.orderservice.entity.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class  OrderMapper  {
    public Order asEntity(OrderDTO OrderDTO) {
        Order Order = new Order();
        BeanUtils.copyProperties(OrderDTO, Order);

        return Order;
    }

    public OrderDTO asDTO(Order Order) {
        OrderDTO OrderDTO = new OrderDTO();
        BeanUtils.copyProperties(Order, OrderDTO);
        return OrderDTO;
    }

    public List<OrderDTO> asDTOList(List<Order> Orders) {

        List<OrderDTO> OrderDTOList = new ArrayList<>();
        for (Order prod : Orders) {
            OrderDTO OrderDTO = new OrderDTO();
            BeanUtils.copyProperties(prod, OrderDTO);
            OrderDTOList.add(OrderDTO);
        }

        return OrderDTOList;
    }
}