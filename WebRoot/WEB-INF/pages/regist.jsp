<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>+
  </head>
  
  <body>
    <h1>用户注册</h1>
    <a href="${pageContext.request.contextPath}/showLogin.do">返回登录</a>
    <hr/>
    
    <form action="${pageContext.request.contextPath}/regist.do" method="post">
    	用户名:<input type="text" name="user.username" /><br/>
  		密&nbsp;&nbsp;&nbsp;码:<input type="password" name="user.password" /><br/>
  		手机号:<input type="text" name="user.phone" /><br/>
  		邮&nbsp;&nbsp;&nbsp;箱:<input type="text" name="user.email" /><br/>
  		地&nbsp;&nbsp;&nbsp;址:<input type="text" name="user.address" /><br/>
  		<input type="submit" value="注册">
  		<span style="color:red;">${registMsg }</span>
    </form>
    
  </body>
</html>
