package service;

import java.util.List;

import entity.ProductType;
import exception.ProductTypeException;

public interface IProductTypeService {

	/**
	 * 添加商品类型
	 * @param name
	 * @throws ProductTypeException 
	 */
	public void addType(String name) throws ProductTypeException;
	
	/**
	 * ...
	 * @return
	 * @throws ProductTypeException 
	 */
	public List<ProductType> findAll() throws ProductTypeException;
	
	/**
	 * ...
	 * @param id
	 * @param name
	 * @throws ProductTypeException 
	 */
	public void modifyType(int id, String name) throws ProductTypeException;
	
	/**
	 * ..
	 * @param id
	 * @return
	 * @throws ProductTypeException 
	 */
	public ProductType toModifyType(int id) throws ProductTypeException;
	
	/**
	 * ...
	 * @param id
	 * @param status
	 */
	public void modifyStatus(int id, int status);
	
	/**
	 * 
	 * @return
	 * @throws ProductTypeException 
	 */
	public List<ProductType> findAllByStatus() throws ProductTypeException;
	
}
