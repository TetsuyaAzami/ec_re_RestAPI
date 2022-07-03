package com.example.ec_re.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.example.ec_re.domain.Topping;

@Repository
@Mapper
public interface ToppingDetailMapper {
	List<Topping> findAll();
}
