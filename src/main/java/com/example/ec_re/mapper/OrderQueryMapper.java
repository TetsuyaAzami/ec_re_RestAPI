package com.example.ec_re.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.example.ec_re.domain.Order;
import com.example.ec_re.domain.OrderStatus;

@Repository
@Mapper
public interface OrderQueryMapper {
	Order findShoppingCartByUserId(Integer userId, OrderStatus orderStatus);
}
