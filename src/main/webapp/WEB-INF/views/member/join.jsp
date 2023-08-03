<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<c:import url="../temp/bootStrap.jsp"></c:import>
	<style>
		.f{
			color:red;
		}

		.s{
			color:blue;
		}
	</style>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>
	<section class="container mt-5">
		<h1>회원가입</h1>

		<form action="./join" method="post" enctype="multipart/form-data">
		<div>
			<label for="id" class="form-label">아이디</label>
			<input type="text" name="id" class="form-control input" id="id">
			<div id="idIn"></div>
		</div>
		<div>
			<label for="pw" class="form-label">패스워드</label>
			<input type="password" name="pw" class="form-control input" id="pw">
			<div id="pwIn"></div>
		</div>
		<div>
			<label for="pw2" class="form-label">패스워드확인</label>
			<input type="password" name="pw2" class="form-control input" id="pw2">
			<div id="pw2In"></div>
		</div>
		<div>
			<label for="name1" class="form-label">이름</label>
			<input type="text" name="name" class="form-control input" id="name1">
			<div id="nameIn"></div>
		</div>
		<div class="mb-5">
  			<label for="email" class="form-label">Email address</label>
  			<input type="email" name="email" class="form-control input" id="email" placeholder="name@example.com">
			<div id="emailIn"></div>
		</div>
		<div class="mb-5">
			<label for="birth" class="form-label input" data-name="생년월일">생년월일</label>
			<input type="date" name="birth" id="birth">
		</div>
		
		<div class="mb-5">
			<label for="pic" class="form-label">사진첨부</label>
			<input type="file" name="pic" id="pic">
		</div>
		
		
		<div>
			<button type="button" class="btn btn-success" id="btn">회원가입</button>
		</div>

		</form>
	</section>
	<script src="/resources/js/member.js"></script>
</body>
</html>