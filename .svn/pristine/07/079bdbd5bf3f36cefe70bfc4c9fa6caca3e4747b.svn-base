package rowmapper;

import java.sql.ResultSet;

import util.RowMapper;
import vo.ProductVo;

public class ProductVoRowMapper implements RowMapper {

	public Object maprow(ResultSet rs) throws Exception {
		ProductVo productVo = new ProductVo();
		productVo.setId(rs.getInt("id"));
		productVo.setName(rs.getString("name"));
		productVo.setPrice(rs.getDouble("price"));
		productVo.setTypeName(rs.getString("typeName"));
		return productVo;
	}

}
