package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import entity.Product;
import entity.ProductType;
import exception.ProductException;
import exception.ProductTypeException;
import factory.ObjectFactory;

import service.IProductService;
import service.IProductTypeService;
import vo.ProductVo;

public class ProductAction extends MappingDispatchAction{

	private IProductTypeService typeService = (IProductTypeService) ObjectFactory.getObject("typeService");
	private IProductService productService = (IProductService) ObjectFactory.getObject("productService");
	
	
	public ActionForward toAddProduct(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse repsonHttpServletResponse){
		List<ProductType> types = new ArrayList<ProductType>();
		try {
			types = typeService.findAllByStatus();
			request.setAttribute("types", types);
			return mapping.findForward("success");
		} catch (ProductTypeException e) {
			request.setAttribute("typeMsg", e.getMessage());
			return mapping.findForward("fail");
		}
	}
	public ActionForward addProduct(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse repsonHttpServletResponse){
		
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		int typeId = Integer.parseInt(request.getParameter("typeId"));
		
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		product.setTypeId(typeId);
		
		try {
			productService.addProduct(product);
			return mapping.findForward("success");
		} catch (ProductException e) {
			request.setAttribute("typeMsg", e.getMessage());
			return mapping.findForward("fail");
		}
	}
	
	public ActionForward findAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse repsonHttpServletResponse){
		List<ProductVo> productVos = new ArrayList<ProductVo>();
		try {
			productVos = productService.findAllProducts();
			request.setAttribute("productVos", productVos);
			return mapping.findForward("success");
		} catch (ProductException e) {
			request.setAttribute("productMsg", e.getMessage());
			return mapping.findForward("fail");
		}
	}
	
	public ActionForward toModifyProduct(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse repsonHttpServletResponse){
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = new Product();
		List<ProductType> types = new ArrayList<ProductType>();
		
		
		try {
			product = productService.findById(id);
			types = typeService.findAll();
			request.setAttribute("product", product);
			request.setAttribute("types", types);
			return mapping.findForward("success");
		} catch (ProductException e) {
			request.setAttribute("productMsg", e.getMessage());
		} catch (ProductTypeException e) {
			request.setAttribute("productMsg", e.getMessage());
		}
		
		
		return mapping.findForward("fail");
	}
	public ActionForward modifyProduct(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse repsonHttpServletResponse){
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		int typeId = Integer.parseInt(request.getParameter("typeId"));
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		product.setTypeId(typeId);
		
		try {
			productService.modifyProduct(product);
			request.getSession().setAttribute("modifyMsg","");
			return mapping.findForward("success");
		} catch (ProductException e) {
			request.getSession().setAttribute("modifyMsg", e.getMessage());
			return mapping.findForward("fail");
		}
		
	}
}
