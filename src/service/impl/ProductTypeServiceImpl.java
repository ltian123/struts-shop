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
			throw new ProductTypeException("�������Ѿ�����");
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
		throw new ProductTypeException("û����Ʒ���͵���Ϣ,��������");
	}

	public void modifyType(int id, String name) throws ProductTypeException {
		//�����Ʒ���͵�������ԭ����,�����޸�
		ProductType pt1 = typeDao.selectById(id);
		ProductType pt2 = typeDao.selectTypeByName(name);
		
		//�����޸ĵ����
		if(pt1.getName().equals(name) || pt2 == null){
			typeDao.updateType(id, name);
		}else{
			throw new ProductTypeException("�������Ѿ�����");
		}
		
		
//		if(pt1.getName().equals(name)){
//			//�����޸�
//		}
//		
//		//�����Ʒ���͵����Ʋ���ԭ����,���������ݿ����Ѿ�������,�����޸�
//		else{
////			ProductType pt2 = typeDao.selectTypeByName(name);
//			if(pt2 != null){
//				//�����޸�
//			}
//			//�����Ʒ���͵����Ʋ���ԭ����,���������ݿ�Ҳ������,���޸�
//			else{
//				//pt2 == null
//				//�����޸�
//			}
//		}
		
		
		
		
		
		
	}

	public ProductType toModifyType(int id) throws ProductTypeException {
		ProductType type = typeDao.selectById(id);
		if(type != null){
			return type;
		}
		throw new ProductTypeException("�����Ͳ�����,�����²�ѯ");
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
		throw new ProductTypeException("��Ʒ������ϢΪ��,��������");
	}
}