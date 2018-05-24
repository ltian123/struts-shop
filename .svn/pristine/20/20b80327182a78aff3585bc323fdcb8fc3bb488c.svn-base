package service.impl;

import java.util.List;

import dao.IProductDao;
import entity.Product;
import exception.ProductException;
import factory.ObjectFactory;
import service.IProductService;
import vo.ProductVo;

public class ProductServiceImpl implements IProductService{

	private IProductDao productDao = (IProductDao) ObjectFactory.getObject("productDao");
	
	public void addProduct(Product product) throws ProductException {
		//加上业务处理
		if(product.getTypeId() == -1){
			throw new ProductException("商品类型选择有误,请重新选择");
		}
		productDao.insertProduct(product);
		
	}

	public List<ProductVo> findAllProducts() throws ProductException {
		List<ProductVo> productVos = productDao.selectAll();
		if(productVos != null){
			return productVos;
		}
		throw new ProductException("数据库中不存在有效商品");
	}

	public Product findById(int id) throws ProductException {
		Product product = productDao.selectById(id);
		if(product!=null){
			return product;
		}
		throw new ProductException("未找到对应商品信息");
	}

	public void modifyProduct(Product product) throws ProductException {
		Product p1 = productDao.selectById(product.getId());
		Product p2 = productDao.selectByName(product.getName());
		
		//数据库中不存在该商品----p2 ==null
		//数据库中存在该商品,但是是原来的 p1.getName().equals(product.getName())
		if(p1.getName().equals(product.getName()) || p2 == null){
			productDao.updateProduct(product);
			return;
		}
		throw new ProductException("该商品名称已经存在");
	}

}
