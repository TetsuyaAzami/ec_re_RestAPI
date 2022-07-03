package com.example.ec_re.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import com.example.ec_re.domain.OrderStatus;

@MappedJdbcTypes(JdbcType.INTEGER)
public class OrderStatusTypeHandler extends BaseTypeHandler<OrderStatus> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, OrderStatus parameter,
			JdbcType jdbcType) throws SQLException {
		ps.setInt(i, parameter.status());
	}

	@Override
	public OrderStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return doGetResult(rs.getInt(columnName));
	}

	@Override
	public OrderStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return doGetResult(rs.getInt(columnIndex));
	}

	@Override
	public OrderStatus getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		return doGetResult(cs.getInt(columnIndex));
	}

	private OrderStatus doGetResult(Integer value) {
		if (OrderStatus.inShoppingCart.status() == value)
			return OrderStatus.inShoppingCart;
		if (OrderStatus.ordered.status() == value)
			return OrderStatus.ordered;
		throw new RuntimeException("不正なOrderStatusです。TypeHandlerを見直してください");
	}

}
