package com.example.ec_re.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import com.example.ec_re.domain.Item;

@Repository
@Mapper
public interface ItemListMapper {
	List<Item> findAll(RowBounds rowBounds);

	List<Item> findByName(String itemName, RowBounds rowBounds);
}
