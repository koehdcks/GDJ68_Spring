<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<h1 class="my-4">회원정보수정 페이지</h1>
		
		<form action="./memberUpdate" method="post">
		<div>
			<label for="formPw" class="form-label">패스워드</label>
			<input type="password" value=${sessionScope.member.pw } name="pw" class="form-control" id="formPw"><br>
		</div>
		<div>
			<label for="formName" class="form-label">이름</label>
			<input type="text" value=${member.name } name="name" class="form-control" id="formName"><br>
		</div>
		<div class="mb-5">
  			<label for="formEmail" class="form-label">Email</label>
  			<input type="email" value=${member.email } name="email" class="form-control" id="formEmail" placeholder="name@example.com">
		</div>
		<div class="mb-5">
			<label for="formBirth" class="form-label">생년월일</label>
			<input type="date" value=${member.birth } name="birth" id="formBirth">
		</div>
		<div>
			<button class="btn btn-success">회원수정</button>
		</div>

		</form>
		
	
	</section>
	
</body>
</html>