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
	<section>
		<h1>Update Page</h1>

		<form action="./update" method="post">
		<div>
			<input type="hidden" name="bookNum" value="${dto.bookNum}">
			<label for="formName" class="form-label">상품명</label>
		</div>
			<input type="text" name="bookName" class="form-control" id="formName" value="${dto.bookName}"><br>
			상세설명
			<textarea rows="" cols="" name="bookContents">${dto.bookContents}</textarea>
			이자율<input type="text" name="bookRate" value="${dto.bookRate }"><br>
			<p>
				판매가능 <input type="radio" value="1" checked name="bookSale"><br>
				<!--1번째방법 -->
				판매중지 <input type="radio" value="0" name="bookSale"><br>
			</p>
			<!-- <select name="bookSale">     2번째방법
				<option value="1" selected>판매가능</option>     
				<option value="0">판매중지</option>
			</select> -->

			<input type="button" value="수정">
			<input type="reset">

		</form>
	</section>
</body>
</html>