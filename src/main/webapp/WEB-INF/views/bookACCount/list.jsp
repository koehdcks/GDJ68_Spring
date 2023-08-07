<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	
	<section class="container mt-5">
		<h1 class="text-center">상품 가입 목록</h1>


		<table class="table mt-3">
			<thead class="table-dark">
				<th>계좌번호</th><th>잔액</th><th>DATE</th>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="d" varStatus="i">
					<!--list를 items에 넣고 하나씩 d에 대입하며 출력반복-->
					<tr>
						<td>${d.account}</td>
						<td>${d.accountBalance}</td>
						<td>${d.accountDate}</td>
					</tr>
				</c:forEach>

			</tbody>

		</table>
		<nav aria-label="Page navigation example">
			<ul class="pagination">
			
				<li class="page-item ${pager.pre?'':'disabled'}"><a class="page-link move" href="#" data-num="${pager.startNum-1}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>

				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li class="page-item"><a class="page-link move" href="#" data-num="${i}">${i}</a></li>
				</c:forEach>
		
				<li class="page-item ${pager.next?'':'disabled'}" ><a class="page-link move" href="#" data-num="${pager.lastNum+1}" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
	
			</ul>
		</nav>
		
			
		
	</section>
	<script>
		
	</script>

</body>
</html>