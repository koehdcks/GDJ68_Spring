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
		<h1 class="text-center">${board} List</h1>


		<table class="table mt-3">
			<thead class="table-dark">
				<tr>
					<th class="text-center">NO</th>
					<th>SUBJECT</th>
					<th class="text-center">NAME</th>
					<th class="text-center">DATE</th>
					<th class="text-center">HIT</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="d" varStatus="i">
					<!--list를 items에 넣고 하나씩 d에 대입하며 출력반복-->
					<tr>
						<td class="text-center" >${d.num}</td>
						<td><a  href="./detail?num=${d.num}"><c:catch><c:forEach begin="1" end="${d.depth}">--</c:forEach></c:catch>${d.subject}</a></td>
						<td class="text-center" >${d.name}</td>
						<td class="text-center" >${d.createDate}</td>
						<td class="text-center" >${d.hit}</td>

					</tr>
				</c:forEach>

			</tbody>

		</table>
		<nav aria-label="Page navigation example">
			<ul class="pagination">
			
				<li class="page-item ${pager.pre?'':'disabled'}"><a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>

				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
				</c:forEach>
		
				<li class="page-item ${pager.next?'':'disabled'}" ><a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}"aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
	
			</ul>
		</nav>
		
		<div class="input-group mb-3">
			<form action="./list" method="get">
				<select class="form-select"  name="kind" aria-label="Default select example">
					<option value="subject">Subject</option>
					<option value="contents">Contents</option>
					<option value="name">Name</option>
				</select> 
				<input type="text" name="search" class="form-control"
					aria-label="Amount (to the nearest dollar)">
				<div class="col-auto">
    				<button type="submit" class="btn btn-primary">검색</button>
  				</div>
  			</form>		
		</div>
			
		<a class="btn btn-success" href="./add">글등록</a>
	</section>
	
</body>
</html>