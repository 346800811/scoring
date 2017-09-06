<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
	<form name="channelform" action="login/in" onsubmit="return validate_channel_info(this);" method="post">
	名字:
	<input type="text" name="username" /> <br>
	密码:
	<input type="password" name="passwd" /> <br>
	类型:
	<select id="projtype" name="projtype">
		<c:forEach items="${projType}" var="p">
			<%-- <option value="${u.id }" <c:if test="${user.user_id==u.id}"><c:out value="selected"/></c:if>>${u.name}</option> --%>
			<option value="${p.type}" >${p.name}</option>
		</c:forEach>
	</select><br>
	<input type="submit" value="登录">
	</form>

	<script type="text/javascript">
	function validate_channel_info(channelform) {
		if(channelform.username.value=="") {
			alert("请输入正确的名字");
			return false;
		}
		return true;
	}
	</script>
</body>
