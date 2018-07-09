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
    
    <title>My JSP 'index.jsp' starting page</title>
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
   		$(function(){
   			var cid='${school.cityArea.cid}';//拿到上次的查询条件
   			if(cid!=''){
   				$("[name='cityArea.cid']").val(cid);//为下拉框设置默认选项
   			}else{
   				$("[name='cityArea.cid']").val(-1);//为下拉框设置请选择
   			}
   			
   			var currPage='${pager.currPage}';
   			var totalPages='${pager.totalPages}';
   			if(currPage<=1){
   				$("#prev").removeAttr("href");//去上一页的超链接
   			}
   			if(currPage>=totalPages){
   				$("#next").removeAttr("href");//去下一页的超链接
   			}
   			
   		})
   
   		function toPager(currPage){
   			$("#myForm").attr("action","toPager.do?currPage="+currPage);
   			$("#myForm").submit();//整体提交表单
   		}
   		function del(did){
   			if(confirm("你确定要删除吗?")){
   				location.href="doDel.do?did="+did;
   			}
   		}
   		
   </script>
  </head>
  
  <body>
  	<c:if test="${param.flag=='yes' }">
  		<script type="text/javascript">
  			alert("操作成功");
  		</script>
  	</c:if>
  	
  	<c:if test="${param.flag=='no' }">
  		<script type="text/javascript">
  			alert("操作失败");
  		</script>
  	</c:if>
  
  
  <center>
	    <form id="myForm" action="toPager.do" method="post">
	    	请选择城区：<select name="cityArea.cid">
	    					<option value="-1">请选择</option>
	    					<c:forEach items="${clist}" var="c">
	    						<option value="${c.cid }">${c.name }</option>
	    					</c:forEach>
	    			   </select>
	    	<input type="submit" value="查询"/>
	    	<a href="toInsert.do">新增</a>
	    	<table border="1" width="80%" align="center">
	    			<tr>
	    				<td>驾校名称</td>
	    				<td>所在城区</td>
	    				<td>地址</td>
	    				<td>电话</td>
	    				<td>操作</td>
	    			</tr>
	    			<c:forEach items="${list }" var="s">
	    			<tr>
	    				<td>${s.dname }</td>
	    				<td>${s.cityArea.name }</td>
	    				<td>${s.address }</td>
	    				<td>${s.phone }</td>
	    				<td><a href="toUpdate.do?did=${s.did }">修改</a>&nbsp;
	    				<a href="javaScript:del(${s.did })">删除</a></td>
	    				
	    			</tr>
	    			</c:forEach>
	    	</table>
	   		总记录数:[${pager.totalCounts}] &nbsp;&nbsp;${pager.currPage }/${pager.totalPages }
	    	<a href="javaScript:toPager(1)">首页</a>&nbsp;&nbsp;
	    	<a id="prev" href="javaScript:toPager(${pager.currPage-1})">上一页</a>&nbsp;&nbsp;
	    	<a id="next" href="javaScript:toPager(${pager.currPage+1})">下一页</a>&nbsp;&nbsp;
	    	<a href="javaScript:toPager(${pager.totalPages})">尾页</a>&nbsp;&nbsp;
	    	
	    </form>
   </center>
  </body>
</html>
