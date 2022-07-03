package com.example.ec_re.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.example.ec_re.domain.Order;

@Repository
@Mapper
public interface OrderRegisterMapper {
	void saveNewShoppingCart(Order order);

	Integer finishingOrder(Order order);
}
