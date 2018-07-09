<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
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
  			var cid=$("[name='school.cityArea.cid']").val();
  			if(cid=="-1"){
  				alert("请选择一个城区");
  				$("[name='school.cityArea.cid']").focus();
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
   <%--	<fm:form id="myForm" action="doUpdate.do" method="post"
   	modelAttribute="school">
   		<fm:hidden path="did"/>
   		驾校名称:<fm:input path="dname"/><br/>
   		所在城区:<fm:select path="cityArea.cid"
   				items="${clist }" itemValue="cid" itemLabel="name">
   					&lt;%&ndash; <option value="-1">请选择</option>
   					<c:forEach items="${clist}" var="c">
   						<option value="${c.cid }">${c.name }</option>
   					</c:forEach> &ndash;%&gt;
   				</fm:select><br/>
   		地址:<fm:input path="address"/><br/>
   		电话:<fm:input path="phone"/><br/>
   		<input type="submit" value="提交"/>
   	</fm:form>--%>
   <form id="myForm" action="doUpdate.do" method="post">
	   <input type="hidden" name="did" value="${school.did}"/>
	   驾校名称:<input type="text" name="dname" value="${school.dname}"/><br/>
	   所在城区:

				<select name="cityArea.cid" id="xx">
						<option value="-1">请选择</option>
						   <c:forEach items="${clist}" var="xx">
							   <option value="${xx.cid }">${xx.name}</option>
						   </c:forEach>
				</select>

	   <br/>
	   地址:<input type="text" name="address" value="${school.address}"/><br/>
	   电话:<input type="text" name="phone" value="${school.phone}"/><br/>
	   <input type="submit" value="提交"/>
   </form>
  </body>
</html>
