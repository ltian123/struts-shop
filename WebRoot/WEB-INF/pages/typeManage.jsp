<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>商品类型管理</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <!-- bootstrap核心的css文件 -->
  	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css"></link>
  	<!-- jQuery文件 必须在bootstrap的js文件之前导入 -->
  	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
  	<!-- bootstrap核心的js文件 -->
  	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
  </head>
  
  <body style="padding: 10px 10px;">
  	<div class="panel panel-primary">
  		<div class="panel-heading">
  		商品类型管理
  		</div>
  	</div>
  	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addType"> 添加</button>
  	<table class="table table-hover table-bordered">
  		<tr>
  			<th>序号</th>
  			<th>名称</th>
  			<th>状态</th>
  			<th>操作</th>
  		</tr>
  		<c:forEach items="${types }" var="type" varStatus="i">
  		<tr>
  			<td>${i.index+1 }</td>
  			<td>${type.name }</td>
  			<td>
				<c:choose>
					<c:when test="${type.status eq 1 }">启用</c:when>
					<c:otherwise>禁用</c:otherwise>
				</c:choose>
			</td>
  			<td>
  				<c:choose>
					<c:when test="${type.status eq 1 }">
						<a class="btn btn-danger" href="${pageContext.request.contextPath}/modifyStatus.do?id=${type.id }&status=${type.status}" role="button">禁用</a>
					</c:when>
					<c:otherwise>
					<a class="btn btn-success" href="${pageContext.request.contextPath}/modifyStatus.do?id=${type.id }&status=${type.status}" role="button">启用</a>
					</c:otherwise>
				</c:choose>
  				
  			</td>
  		</tr>
  		</c:forEach>
  	</table>
  	
  	
  	<!-- 添加类型的模态框 -->
  	<div class="modal fade" id="addType" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    <form class="form-horizontal" action="${pageContext.request.contextPath}/addType.do" method="post">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加商品类型</h4>
      </div>
      <div class="modal-body">
      	<div class="form-group">
	    	<label for="inputEmail3" class="col-sm-2 control-label">类型名称</label>
	    	<div class="col-sm-10">
	      		<input type="text" class="form-control" id="typeName" name="name" placeholder="请输入类型名称">
	    	</div>
	  	</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
<%--        <button type="button" class="btn btn-primary">添加</button>--%>
        <input type="submit"  class="btn btn-primary" value="添加">
      </div>
      </form>
    </div>
  </div>
</div>
  	
  </body>
</html>
