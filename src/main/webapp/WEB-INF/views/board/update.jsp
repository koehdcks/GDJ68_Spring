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
		<h1>Update Page</h1>

		<form action="./update" method="post">
		<div>
			<input type="hidden" name="num" value="${dto.num}">
		</div>
		<div>
			<label for="formName" class="form-label">작성자</label>
			<input type="text" name="name" class="form-control" id="formName" value="${dto.name}" readonly="readonly"><br>
		</div>
		<div>
			<label for="formName" class="form-label">제목</label>
			<input type="text" name="subject" class="form-control" id="formName" value="${dto.subject}" ><br>
		</div>
		<div>
		<label for="formContents" class="form-label">내용</label>
			<textarea class="form-control mb-5" rows="" cols="" name="contents" id="formContents">${dto.contents}</textarea>
		</div>

			<input type="submit" value="수정">
			<input type="reset">

		</form>
	</section>
</body>
</html>