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
		<h1 class="text-center">Detail</h1>


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
			<%-- <c:forEach items="${dto.fileDTOs}" var="f">
			<img alt="" src="/resources/upload/notice/${f.fileName }">
		</c:forEach> --%>
		
		<a href="./update?num=${dto.num }" class="btn btn-warning">수정</a> 
		<a href="./delete?num=${dto.num}" class="btn btn-danger">삭제</a>
		
	</section>
	
</body>
</html>