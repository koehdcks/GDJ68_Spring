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
		<h1 class="text-center">List</h1>


		<table class="table mt-3">
			<thead class="table-dark">
				<tr>
					<th class="text-center">NO</th>
					<th class="text-center" style="width:70%">SUBJECT</th>
					<th class="text-center">NAME</th>
					<th class="text-center">DATE</th>
					<th class="text-center">HIT</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="d" varStatus="i">
					<!--list를 items에 넣고 하나씩 d에 대입하며 출력반복-->
					<tr>
						<td class="text-center" >${d.noticeNum}</td>
						<td class="text-center" ><a  href="./detail?noticeNum=${d.noticeNum}">${d.noticeTitle}</a></td>
						<td class="text-center" >${d.noticeName}</td>
						<td class="text-center" >${d.noticeDate}</td>
						<td class="text-center" >${d.noticeHit}</td>

					</tr>
				</c:forEach>

			</tbody>

		</table>
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="./list?page=${pager.startNum-1}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
				<c:forEach begin="${pager.startNum }" end="${pager.lastNum}" var="i">
				<li class="page-item"><a class="page-link" href="./list?page=${i}">${i}</a></li>
				</c:forEach>
				<li class="page-item"><a class="page-link" href="./list?page=${pager.lastNum+1}"aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
			
		<a class="btn btn-success" href="./add">글등록</a>
	</section>
	
</body>
</html>