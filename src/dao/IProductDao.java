package dao;

import java.util.List;

import vo.ProductVo;

import entity.Product;

public interface IProductDao {

	/**
	 * 
	 * @param product
	 */
	public void insertProduct(Product product);
	
	/**
	 * 查询所有商品信息
	 * @return
	 */
	public List<ProductVo> selectAll();
	
	/**
	 * 根据商品编号查询商品信息
	 * @param id
	 * @return
	 */
	public Product selectById(int id);
	
	/**
	 * 
	 * @param product
	 */
	public void updateProduct(Product product);
	
	/**
	 * ...
	 * @param name
	 * @return
	 */
	public Product selectByName(String name);
}
