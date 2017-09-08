<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table border='1'>
	<tr>
		<td>id</td>
		<td>name</td>
	</tr>
	<c:forEach items="${cs}" var="o" varStatus="st">
		<tr>
			<td>${o.id}</td>
			<td>${o.name}</td>
		</tr>
	</c:forEach>
</table>