<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<c:import url="../temp/bootStrap.jsp"></c:import>
</head>
<body>

	<section class="container mt-5">
		<c:forEach items="${comment}" var="d" varStatus="i">
				<!--list를 items에 넣고 하나씩 d에 대입하며 출력반복-->
					<tr>
						<td>${d.id }</td>
						<td>${d.commentContents}</td><br>
					</tr>
				</c:forEach>
	</section>
</body>
</html>