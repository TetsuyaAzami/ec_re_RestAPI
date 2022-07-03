package com.example.ec_re.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.example.ec_re.domain.OrderItem;

@Repository
@Mapper
public interface ItemRegisterMapper {
	void addItemToCart(OrderItem orderItem);
}
