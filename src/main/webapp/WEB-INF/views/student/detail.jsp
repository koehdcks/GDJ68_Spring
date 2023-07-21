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
		<h1>Detail Page</h1>

		<!-- Getter 이름 : 메서드에서 get을 제외하고 첫번째글자를 소문자로 바꾼것 -->
		<h1>학생번호:${dto.stuNum}</h1>
		<h1>${requestScope.dto.stuName}</h1>
		<!-- 영역.속성명.게터이름-->
		<h1>국어:${dto.stuKor}</h1>
		<h1>영어:${dto.stuEng}</h1>
		<h1>수학:${dto.stuMath}</h1>
		<h1>총점:${dto.stuTotal}</h1>
		<h1>평균:${dto.stuAvg}</h1>
		<!-- 영역은 생략가능하지만 다른영역에도 같은 속성명이 있으면 안된다. -->

		
		<a href="./update?stuNum=${dto.stuNum}" class="btn btn-warning">수정</a> 
		<a href="./delete?stuNum=${dto.stuNum}" class="btn btn-danger">삭제</a>
		<%-- <c:if test="${dto.bookSale==1}">
		<h1>판매중</h1>
	</c:if>
	<c:if test="${dto.bookSale==0}">
		<h1>판매종료</h1>
	</c:if> --%>
	</section>
</body>
</html>