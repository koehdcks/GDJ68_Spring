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
		<h1>Add PAGE</h1>

		<form action="./add" method="post">
		<div>
			<label for="formName" class="form-label">상품명</label>
			<input type="text" name="bookName" class="form-control" id="formName"><br>
		</div>
		<div class="mb-3">
			<label for="formContents" class="form-label">상세설명</label>
			<textarea rows="" cols="" name="bookContents"class="form-control" id="formContents"></textarea>
		</div>
			<label for="formRate" class="form-label">이자율</label>
			<input type="text" name="bookRate" id="formRate" class="form-control"><br>
		<div>
			 <input type="radio" value="1" checked name="bookSale" class="form-check-input">판매가능<br>
			
			 <input type="radio" value="0" name="bookSale" class="form-check-input">판매중지<br>
		</div>
		<div>	
			축구 <input type="checkbox" value="FootBall" checked name="sports" class="form-check-input"><br>
			농구 <input type="checkbox" value="BasketBall" name="sports" class="form-check-input"><br>
			야구 <input type="checkbox" value="BaseBall" checked name="sports" class="form-check-input"><br>
			배구 <input type="checkbox" value="VallyBall" name="sports" class="form-check-input"><br>
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