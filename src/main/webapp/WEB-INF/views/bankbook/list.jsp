<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootStrap.jsp"></c:import>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>
	
	<section class="container mt-5">
		<h1 class="text-center">BankBook List</h1>


		<table class="table table-dark table-hover mt-3">
			<thead>
				<th>상품명</th>
				<th>이자율</th>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="d" varStatus="i">
					<!--list를 items에 넣고 하나씩 d에 대입하며 출력반복-->
					<tr>
						<td><a href="./detail?bookNum=${d.bookNum}">
								${d.bookName}</td>
						<td>${d.bookRate}${i.index}</td>

					</tr>
				</c:forEach>

			</tbody>

		</table>

		<a class="btn btn-success" href="./add">상품등록</a>
	</section>
	<%-- <c:forEach begin="1" end="10" step="2" var="num"> <!--begin = 시작값 end = 끝값 step= 증가단위 var= 변수  -->
		<h1>${num}</h1>
	</c:forEach> --%>
	
</body>
</html>