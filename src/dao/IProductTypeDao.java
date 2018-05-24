package dao;

import java.util.List;

import entity.ProductType;

public interface IProductTypeDao {

	/**
	 * 根据类型名称查询类型信息
	 * @param name
	 * @return
	 */
	public ProductType selectTypeByName(String name);
	
	/**
	 * 添加商品类型信息
	 * @param type
	 */
	public void insertType(ProductType type);
	
	/**
	 * 查询所有商品类型的信息
	 * @return
	 */
	public List<ProductType> selectAll();
	
	/**
	 * 修改商品类型
	 * @param id
	 * @param name
	 */
	public void updateType(int id, String name);
	
	/**
	 * 根据id查询商品类型的信息
	 * @param id
	 * @return
	 */
	public ProductType selectById(int id);
	
	/**
	 * 修改状态
	 * @param id
	 * @param status
	 */
	public void updateStatus(int id,int status);
	
	/**
	 * 查询启用的商品类型
	 * @param status
	 * @return
	 */
	public List<ProductType> selectAllByStatus(int status);
	
}
