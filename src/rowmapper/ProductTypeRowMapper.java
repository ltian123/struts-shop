package rowmapper;

import java.sql.ResultSet;

import entity.ProductType;

import util.RowMapper;

public class ProductTypeRowMapper implements RowMapper {

	public Object maprow(ResultSet rs) throws Exception {
		ProductType type = new ProductType();
		type.setId(rs.getInt("id"));
		type.setName(rs.getString("name"));
		type.setStatus(rs.getInt("status"));
		return type;
	}

}
