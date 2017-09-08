<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<body>
<%
	String url = null; String stayTime = "3"; // 延迟时间（秒） 
 %>
<c:if test="${result}">
	登录成功！3秒后跳转。。。
	<% url = "http://localhost:8080/scoring/vscore/list"; %>
</c:if>
<c:if test="${!result}">
	登录失败！请重新登录。。。
	<% url = "http://localhost:8080/scoring/user/login"; %>
</c:if>
<%
	String content=stayTime+";URL="+url;
	response.setHeader("REFRESH",content); // 跳转页面
 %>
</body>

</html>