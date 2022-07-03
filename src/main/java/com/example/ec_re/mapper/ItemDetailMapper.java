package com.example.ec_re.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.example.ec_re.domain.Item;

@Repository
@Mapper
public interface ItemDetailMapper {
	Item detail(Integer itemId);
}
