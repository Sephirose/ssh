<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>
<body style="font-size: 30px;">
	登录成功

	<c:forEach var="entry" items="${data}">
		<c:if test="${entry.key eq 'name'}">
			这是name操作：${entry.value}
		</c:if>
		
		<c:if test="${entry.key eq 'value'}">
			这是value操作：${entry.value}
		</c:if>
	</c:forEach>
</body>
</html>