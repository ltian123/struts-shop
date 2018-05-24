package service.impl;

import java.util.List;

import constant.TypeConstant;
import dao.IProductTypeDao;
import entity.ProductType;
import exception.ProductTypeException;
import factory.ObjectFactory;
import service.IProductTypeService;

public class ProductTypeServiceImpl implements IProductTypeService{

	private IProductTypeDao typeDao = (IProductTypeDao) ObjectFactory.getObject("typeDao");
	
	public void addType(String name) throws ProductTypeException {
		ProductType pt = typeDao.selectTypeByName(name);
		if(pt != null){
			throw new ProductTypeException("该类型已经存在");
		}
		ProductType type = new ProductType();
		type.setName(name);
		type.setStatus(TypeConstant.PRODUCT_TYPE_ENABLE);
		typeDao.insertType(type);
	}

	public List<ProductType> findAll() throws ProductTypeException {
		List<ProductType> types = typeDao.selectAll();
		if(types != null){
			return types;
		}
		throw new ProductTypeException("没有商品类型的信息,请先添加");
	}

	public void modifyType(int id, String name) throws ProductTypeException {
		//如果商品类型的名称是原来的,可以修改
		ProductType pt1 = typeDao.selectById(id);
		ProductType pt2 = typeDao.selectTypeByName(name);
		
		//可以修改的情况
		if(pt1.getName().equals(name) || pt2 == null){
			typeDao.updateType(id, name);
		}else{
			throw new ProductTypeException("该类型已经存在");
		}
		
		
//		if(pt1.getName().equals(name)){
//			//可以修改
//		}
//		
//		//如果商品类型的名称不是原来的,并且在数据库中已经存在了,不能修改
//		else{
////			ProductType pt2 = typeDao.selectTypeByName(name);
//			if(pt2 != null){
//				//不能修改
//			}
//			//如果商品类型的名称不是原来的,并且在数据库也不存在,能修改
//			else{
//				//pt2 == null
//				//可以修改
//			}
//		}
		
		
		
		
		
		
	}

	public ProductType toModifyType(int id) throws ProductTypeException {
		ProductType type = typeDao.selectById(id);
		if(type != null){
			return type;
		}
		throw new ProductTypeException("该类型不存在,请重新查询");
	}

	public void modifyStatus(int id, int status) {
		if(status == TypeConstant.PRODUCT_TYPE_DISABLE){
			status = TypeConstant.PRODUCT_TYPE_ENABLE;
		}else{
			status = TypeConstant.PRODUCT_TYPE_DISABLE;
		}
		typeDao.updateStatus(id, status);
	}

	public List<ProductType> findAllByStatus() throws ProductTypeException {
		List<ProductType> types = typeDao.selectAllByStatus(TypeConstant.PRODUCT_TYPE_ENABLE);
		if(types != null){
			return types;
		}
		throw new ProductTypeException("商品类型信息为空,请先添加");
	}
}
