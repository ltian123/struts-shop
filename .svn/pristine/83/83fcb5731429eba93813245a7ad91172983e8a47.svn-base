package dao.impl;

import java.util.ArrayList;
import java.util.List;

import rowmapper.ProductTypeRowMapper;

import util.JDBCTemplate;
import dao.IProductTypeDao;
import entity.ProductType;
import factory.ObjectFactory;

public class ProductTypeDaoImpl implements IProductTypeDao{

	private JDBCTemplate jdbcTemplate = (JDBCTemplate) ObjectFactory.getObject("jdbc");
	
	public ProductType selectTypeByName(String name) {
		String sql = new StringBuffer()
				.append("select id,name,status ")
				.append("from t_product_type ")
				.append("where name = ? ")
				.toString();
		List<ProductType> types = jdbcTemplate.query(sql, new ProductTypeRowMapper(), name);
		return types.size()==0?null:types.get(0);
	}

	public void insertType(ProductType type) {
		String sql = new StringBuffer()
				.append("insert into ")
				.append("t_product_type(name,status) ")
				.append("values(?,?) ")
				.toString();
		jdbcTemplate.saveOrUpdate(sql, type.getName(),type.getStatus());
	}

	public List<ProductType> selectAll() {
		String sql = new StringBuffer()
				.append("select id,name,status ")
				.append("from t_product_type ")
				.toString();
		List<ProductType> types = jdbcTemplate.query(sql, new ProductTypeRowMapper());
		return types.size()==0?null:types;
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		System.out.println(list);
	}

	public void updateType(int id, String name) {
		String sql = new StringBuffer()
				.append("update t_product_type ")
				.append("set name = ? ")
				.append("where id = ? ")
				.toString();
		jdbcTemplate.saveOrUpdate(sql, name,id);
	}

	public ProductType selectById(int id) {
		String sql = new StringBuffer()
				.append("select id,name,status ")
				.append("from t_product_type ")
				.append("where id = ? ")
				.toString();
		List<ProductType> types = jdbcTemplate.query(sql, new ProductTypeRowMapper(), id);
		return types.size()==0?null:types.get(0);
	}

	public void updateStatus(int id, int status) {
		String sql = new StringBuffer()
				.append("update t_product_type ")
				.append("set status = ? ")
				.append("where id = ? ")
				.toString();
		jdbcTemplate.saveOrUpdate(sql, status,id);
	}

	public List<ProductType> selectAllByStatus(int status) {
		String sql = new StringBuffer()
				.append("select id, name, status ")
				.append("from t_product_type ")
				.append("where status = ? ")
				.toString();
		List<ProductType> types = jdbcTemplate.query(sql, new ProductTypeRowMapper(),status);		
		return types.size()==0?null:types;
	}

}
