<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'insert.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script type="text/javascript" src="/static/js/jquery-1.12.4.js"></script>
  <script type="text/javascript">
  		function checkDname(){
  			var dname=$("[name='dname']").val();
  			if(dname==""||dname.length==0){
  				alert("驾校名称必填");
  				$("[name='dname']").focus();
  				return false;
  			}
  			return true;
  		}
  		function checkCid(){
  			var cid=$("[name='cityArea.cid']").val();
  			if(cid=="-1"){
  				alert("请选择一个城区");
  				$("[name='cityArea.cid']").focus();
  				return false;
  			}
  			return true;
  		}
  		$(function(){
  			$("#myForm").submit(
  				function(){
  					if(!checkDname()) return false;
  					if(!checkCid()) return false;
  					return true;
  				}
  			);
  		});
  </script>
  
  </head>
  
  <body>
   	<form id="myForm" action="doInsert.do" method="post">
   		驾校名称:<input type="text" name="dname"/><br/>
   		所在城区:<select name="cityArea.cid">
   					<option value="-1">请选择</option>
   					<c:forEach items="${clist}" var="c">
   						<option value="${c.cid }">${c.name }</option>
   					</c:forEach>
   				</select><br/>
   		地址:<input type="text" name="address"/><br/>
   		电话:<input type="text" name="phone"/><br/>
   		<input type="submit" value="提交"/>
   	</form>
  </body>
</html>
