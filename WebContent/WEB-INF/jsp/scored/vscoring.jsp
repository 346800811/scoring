<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table border='1'>
	<tr>
		<td></td>
		<c:forEach items="${marks}" var="mark" varStatus="st1">
			<td><span  onclick="return validate_channel_info(this);" >${mark.name}</span></td>
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
<script type="text/javascript" src="/scored/scripts/test.js"></script>
<script type="text/javascript">
function validate_channel_info(channelform) {
	alert("请输入正确的名字");
}
</script>