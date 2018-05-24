package dao.impl;

import java.util.List;

import rowmapper.ProductRowMapper;
import rowmapper.ProductVoRowMapper;

import util.JDBCTemplate;
import vo.ProductVo;
import dao.IProductDao;
import entity.Product;
import factory.ObjectFactory;

public class ProductDaoImpl implements IProductDao{

	private JDBCTemplate jdbcTemplate = (JDBCTemplate) ObjectFactory.getObject("jdbc");
	
	public void insertProduct(Product product) {
		String sql = new StringBuffer()
				.append("insert into ")
				.append("t_product(name,price,type_id) ")
				.append("values(?,?,?) ")
				.toString();
		jdbcTemplate.saveOrUpdate(sql, product.getName(),product.getPrice(),product.getTypeId());
	}

	public List<ProductVo> selectAll() {
		String sql = new StringBuffer()
				.append("select p.id,p.name, ")
				.append("p.price,pt.name typeName ")
				.append("from t_product p ")
				.append("left join t_product_type pt ")
				.append("on p.type_id = pt.id ")
				.append("where pt.status = 1 ")
				.toString();
		List<ProductVo> productVos = jdbcTemplate.query(sql, new ProductVoRowMapper());
		return productVos.size()==0?null:productVos;
	}
	public static void main(String[] args) {
		System.out.println(new ProductDaoImpl().selectAll());
	}

	public Product selectById(int id) {
		String sql = new StringBuffer()
				.append("select id,name,price,type_id ")
				.append("from t_product ")
				.append("where id = ? ")
				.toString();
		List<Product> products = jdbcTemplate.query(sql, new ProductRowMapper(), id);
		return products.size()==0?null:products.get(0);
	}

	public void updateProduct(Product product) {
		String sql = new StringBuffer()
				.append("update t_product ")
				.append("set name = ?, ")
				.append("price = ?, ")
				.append("type_id = ? ")
				.append("where id = ? ")
				.toString();
		jdbcTemplate.saveOrUpdate(sql, product.getName(),product.getPrice(),product.getTypeId(),product.getId());
	}

	public Product selectByName(String name) {
		String sql = new StringBuffer()
				.append("select id,name,price,type_id ")
				.append("from t_product ")
				.append("where name = ? ")
				.toString();
		List<Product> list = jdbcTemplate.query(sql, new ProductRowMapper(), name);
		return list.size()==0?null:list.get(0);
	}

	
}
