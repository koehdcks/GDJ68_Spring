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
		<h1>Add PAGE</h1>

		<form action="./add" method="post">
		<div>
			<label for="formName" class="form-label">학생명</label>
			<input type="text" name="stuName" class="form-control" id="formName"><br>
		</div>
		<div>
			<label for="formKor" class="form-label">국어점수</label>
			<input type="text" name="stuKor" id="formKor" class="form-control"><br>
		</div>
		<div>
			<label for="formEng" class="form-label">영어점수</label>
			<input type="text" name="stuEng" id="formEng" class="form-control"><br>
		</div>
		<div>
			<label for="formMath" class="form-label">수학점수</label>
			<input type="text" name="stuMath" id="formMath" class="form-control"><br>
		</div>
	
			<!-- <select name="bookSale">     2번째방법
				<option value="1" selected>판매가능</option>     
				<option value="0">판매중지</option>
			</select> -->

			<button class="btn btn-success">등록</button>
			<!-- 버튼 타입을 생략하면 서브밋타입 -->
			<input type="reset" class="btn btn-danger">

		</form>
	</section>

</body>
</html>