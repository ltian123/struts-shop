package rowmapper;

import java.sql.ResultSet;

import entity.User;

import util.RowMapper;

public class UserRowMapper implements RowMapper{

	public Object maprow(ResultSet rs) throws Exception {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setPhone(rs.getString("phone"));
		user.setAddress(rs.getString("address"));
		user.setEmail(rs.getString("email"));
		return user;
	}

}
