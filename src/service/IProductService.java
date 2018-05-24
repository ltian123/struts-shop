package service;

import java.util.List;

import vo.ProductVo;

import entity.Product;
import exception.ProductException;

public interface IProductService {

	/**
	 * ....
	 * @param product
	 * @throws ProductException 
	 */
	public void addProduct(Product product) throws ProductException;
	
	/**
	 * ...
	 * @return
	 * @throws ProductException 
	 */
	public List<ProductVo> findAllProducts() throws ProductException;
	
	
	/**
	 * ...
	 * @param id
	 * @return
	 * @throws ProductException 
	 */
	public Product findById(int id) throws ProductException;
	
	/**
	 * 
	 * @param product
	 * @throws ProductException 
	 */
	public void modifyProduct(Product product) throws ProductException;
}
