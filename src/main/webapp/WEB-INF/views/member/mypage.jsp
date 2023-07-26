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
		<h1 class="my-4">My Page</h1>
	
	
		<h3>아이디:${member.id}</h3>
		<h3>이름:${member.name}</h3>
		<h3>이메일:${member.email}</h3>
		<h3>생년월일:${member.birth}</h3>
	
		<a class="btn btn-primary" href="./memberUpdate">회원수정</a>
	</section>
	
</body>
</html>