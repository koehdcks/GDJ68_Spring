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
		<h1>상품가입 PAGE</h1>
		<form action="./add" method="post" id="frm">
			<input type="hidden" name="bookNum" value="${dto.bookNum}">
			<div class="mb-3">
				<label for="formPw" class="form-label">비밀번호</label>
				<input type="password" class="form-control" id="pw" name="accountPassword">
			</div>
			
			<button type="button" id="btn" class="btn btn-primary">상품가입</button>
		</form>
	</section>
	
	<script type="text/javascript">
		const btn = document.getElementById('btn');
		const pw = document.getElementById("pw");
		const prm = document.getElementById("frm");
		
		btn.addEventListener("click", function(){
			if(pw.value.length==4&&Number.isInteger(pw.value*1)){
				frm.submit();
				
			}else{
				alert("비번 4글자 또는 숫자로만 작성")
			}
		});
	</script>
</body>
</html>