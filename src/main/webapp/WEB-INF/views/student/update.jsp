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
			<input type="hidden" name="stuNum" value="${dto.stuNum}">
			<label for="formName" class="form-label">학생명</label>
		</div>
			<input type="text" name="stuName" class="form-control" id="formName" value="${dto.stuName}"><br>
	
			
			국<input type="text" name="stuRate" value="${dto.stuKor }"><br>
			영<input type="text" name="stuRate" value="${dto.stuEng }"><br>
			수<input type="text" name="stuRate" value="${dto.stuMath }"><br>
			총<input type="text" name="stuRate" value="${dto.stuTotal }"><br>
			평<input type="text" name="stuRate" value="${dto.stuAvg }"><br>
			
			<!-- <select name="bookSale">     2번째방법
				<option value="1" selected>판매가능</option>     
				<option value="0">판매중지</option>
			</select> -->

			<input type="submit" value="수정">
			<input type="reset">

		</form>
	</section>
</body>
</html>