package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import entity.ProductType;
import exception.ProductTypeException;
import factory.ObjectFactory;

import service.IProductTypeService;

public class ProductTypeAction extends MappingDispatchAction{

	private IProductTypeService typeService = (IProductTypeService) ObjectFactory.getObject("typeService");
	
	public ActionForward addType(ActionMapping mapping,ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String name = request.getParameter("name");
		System.out.println(name);
		try {
			typeService.addType(name);
			return mapping.findForward("success");
		} catch (ProductTypeException e) {
			request.setAttribute("addTypeMsg", e.getMessage());
			return mapping.findForward("fail");
		}
	}
	
	public ActionForward findAll(ActionMapping mapping,ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		List<ProductType> types = new ArrayList<ProductType>();				
		try {
			types = typeService.findAll();
			request.setAttribute("types", types);
			return mapping.findForward("success");
		} catch (ProductTypeException e) {
			request.setAttribute("typeMsg", e.getMessage());
			return mapping.findForward("fail");
		}
	}
	
	public ActionForward toModifyType(ActionMapping mapping,ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		ProductType type = new ProductType();
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			type = typeService.toModifyType(id);
			request.setAttribute("type", type);
			return mapping.findForward("success");
		} catch (ProductTypeException e) {
			request.setAttribute("typeMsg", e.getMessage());
			return mapping.findForward("fail");
		}
	}
	
	public ActionForward modifyType(ActionMapping mapping,ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		
		try {
			typeService.modifyType(id, name);
			return mapping.findForward("success");
		} catch (ProductTypeException e) {
			request.setAttribute("typeMsg", e.getMessage());
			return mapping.findForward("fail");
		}
	}
	
	public ActionForward modifyStatus(ActionMapping mapping,ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		int id = Integer.parseInt(request.getParameter("id"));
		int status = Integer.parseInt(request.getParameter("status"));
		typeService.modifyStatus(id, status);
		return mapping.findForward("success");
	}
	
}
