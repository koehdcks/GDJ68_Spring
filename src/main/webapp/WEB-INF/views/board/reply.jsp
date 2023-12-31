<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<h1>${board} Reply page</h1>
		
		<form action="./reply" method="post" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${num.num}">
			<div>
				<label for="formId" class="form-label">작성자</label> <input
					type="text" name="name" class="form-control" id="formId"
					value="${member.id }" readonly="readonly"><br>
			</div>
			<div>
				<label for="formTitle" class="form-label">제목</label> <input
					type="text" name="subject" id="formTitle" class="form-control"><br>
			</div>
			<div class="mb-3">
				<label for="formContents" class="form-label">답글</label>
				<textarea rows="" cols="" name="contents" class="form-control"
					id="formContents"></textarea>
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