package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import service.IUserService;
import util.MD5Util;

import entity.User;
import exception.UserExistException;
import factory.ObjectFactory;
import form.UserForm;

public class UserAction extends MappingDispatchAction{
	
	private IUserService userService = (IUserService) ObjectFactory.getObject("userService");
	
	public ActionForward regist(ActionMapping mapping,ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		UserForm userForm = (UserForm) form;
		User user = userForm.getUser();
		user.setPassword(MD5Util.md5(user.getPassword()));
//		System.out.println(user);
		try {
			userService.register(user);
			return mapping.findForward("success");
		} catch (UserExistException e) {
			request.setAttribute("registMsg", e.getMessage());
			return mapping.findForward("fail");
		}
	}
	
	public ActionForward login(ActionMapping mapping,ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		try {
			user = userService.login(username, MD5Util.md5(password));
			request.getSession().setAttribute("user", user);
			return mapping.findForward("success");
		} catch (UserExistException e) {
			request.setAttribute("loginMsg", e.getMessage());
			return mapping.findForward("fail");
		}
		
	}

}
