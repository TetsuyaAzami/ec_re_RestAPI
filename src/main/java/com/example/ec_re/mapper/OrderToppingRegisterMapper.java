package com.example.ec_re.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.example.ec_re.domain.OrderTopping;

@Repository
@Mapper
public interface OrderToppingRegisterMapper {
	void addOrderToppingToCart(List<OrderTopping> orderToppingList);
}
