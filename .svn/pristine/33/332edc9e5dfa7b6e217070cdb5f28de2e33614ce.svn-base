package rowmapper;

import java.sql.ResultSet;

import entity.Product;

import util.RowMapper;

public class ProductRowMapper implements RowMapper {

	public Object maprow(ResultSet rs) throws Exception {
		Product product = new Product();
		product.setId(rs.getInt("id"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getDouble("price"));
		product.setTypeId(rs.getInt("type_id"));
		return product;
	}

}
