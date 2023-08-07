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
				<tr>
					<th>상품명</th>
					<th>이자율</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="d" varStatus="i">
					<!--list를 items에 넣고 하나씩 d에 대입하며 출력반복-->
					<tr>
						<td><a href="./detail?bookNum=${d.bookNum}">
								${d.bookName}</a></td>
						<td>${d.bookRate}</td>

					</tr>
				</c:forEach>

			</tbody>

		</table>

		<nav aria-label="Page navigation example">
			<ul class="pagination">
				
					<li class="page-item ${pager.pre?'':'disabled'}"><a class="page-link"
						href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
					</a></li>
			
				<c:forEach begin="${pager.startNum }" end="${pager.lastNum}" var="i">
					<li class="page-item"><a class="page-link"
						href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
				</c:forEach>
				
					<li class="page-item ${pager.next?'':'disabled'}"><a class="page-link"
						href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
	
			</ul>
		</nav>

		<div class="input-group mb-3">
			<form action="./list" method="get">
				<select class="form-select"  name="kind" aria-label="Default select example">
					<option value="name">Name</option>
					<option value="contents">Contents</option>
				</select> 
				<input type="text" name="search" class="form-control"
					aria-label="Amount (to the nearest dollar)">
				<div class="col-auto">
    				<button type="submit" class="btn btn-primary">검색</button>
  				</div>
  			</form>		
		</div>


		<a class="btn btn-success" href="./add">상품등록</a>
	</section>
	<button id="list">GetList</button>
	<!-- <%-- <c:forEach begin="1" end="10" step="2" var="num"> <!--begin = 시작값 end = 끝값 step= 증가단위 var= 변수  -->
		<!-- <h1>${num}</h1> -->
	<!-- </c:forEach> --%> -->

	<script type="text/javascript" src="../resources/js/bookList.js"></script>

</body>
</html>