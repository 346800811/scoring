<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table border='1'>
	<tr>
		<td></td>
		<c:forEach items="${marks}" var="mark" varStatus="st1">
			<td>${mark.name}</td>
		</c:forEach>
	</tr>
	<c:forEach items="${projs}" var="proj" varStatus="st2">
		<tr>
			<td>${proj.name}</td>
				<c:forEach items="${marks}" var="mark" varStatus="st3">
					<td>${scarr[st2.index][st3.index]}</td>
				</c:forEach>
		</tr>
	</c:forEach>
</table>