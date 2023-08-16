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
		<h1 class="text-center">${board} Detail</h1>


		<table class="table mt-3">
			<thead class="table-dark">
				<tr>
					<th class="text-center" style="width:70%">SUBJECT</th>
					<th class="text-center">NAME</th>
					<th class="text-center">DATE</th>
					<th class="text-center">HIT</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="text-center" >${dto.subject}</td>
					<td class="text-center" >${dto.name}</td>
					<td class="text-center" >${dto.createDate}</td>
					<td class="text-center" >${dto.hit}</td>
				</tr>
				<tr>
					<td colspan="4">${dto.contents }</td>
				<tr>
			</tbody>

		</table>
		<c:forEach items="${dto.fileDTOs}" var="f">
			<a href="./fileDown?fileNum=${f.fileNum}">${f.originalName}</a>
		</c:forEach>
		
		<form id="frm" action="">
			<input type="hidden" name="num" value="${dto.num}">
		</form>
		<c:if test="${board ne 'notice'}">
			<!-- <a href="./reply?num=${dto.num}" class="btn btn-info">댓글</a> -->
		<button  id="reply" class="c1 btn btn-info" data-url="reply">답글</button>
		</c:if>
		<!-- <a href="./update?num=${dto.num}" class="btn btn-warning">수정</a>  -->
		<button  id="update" class="c1 btn btn-warning" data-url="update">수정</button>
		<button type="button" id="del" class="c1 btn btn-danger" data-url="delete" data-delete-name="num" data-delete-num="${dto.num}">삭제</button>
		<script src="../resources/js/delete.js"></script>
		

	</section>
	
</body>
</html>