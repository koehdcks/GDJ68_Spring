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
	
	<div>
		<p>
			<img alt="" src="../resources/upload/member/${member.memberFileDTO.fileName}">
		</p>
		<p>
			${member.id} : ${member.name}
		</p>
		<p>
			${member.email}
		</p>
		<p>
			${member.birth}
		</p>
		
	</div>
	
	<a class="btn btn-primary" href="./memberUpdate">회원수정</a>
	<div id="productList">

	</div>
	
	</section>

	<script>
		const productList=document.getElementById("productList");

		getList(1);
		//자바스크립트
		// productList.addEventListener("click",function(event){
		// 	if(event.target.classList.contains("move")){
		// 		let page = event.target.getAttribute("data-num");
		// 		console.log("before")
		// 		getList(page);
		// 	}
		// })

		//제이쿼리
		$('#productList').on("click",".move",function(){
			let page = $(this).attr("data-num")
			getList(page);
		})

		function getList(page){
			//자바스크립트로 작성
			// fetch("../bookACCount/list?page="+page,{
			// method:'get'
			// })
			// .then((response)=>{return response.text()})
			// .then((r)=>{
			// 	console.log("ajax 실행")
			// 	productList.innerHTML=r;
			// 	console.log("after")
			// })

			//제이쿼리로 작성
			$.ajax({
			type:'get',
			url:"../bookACCount/list",
			data:{
				page:page
			},
			success:function(result){
				$('#productList').html(result.trim());
			},
			error:function(){
				alert("error")
			}
		})

		}
		
		
	</script>
</body>
</html>