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
		<h1>${requestScope.dto.bookName}</h1>
		<!-- 영역.속성명.게터이름-->
		<div>${dto.bookContents}</div>
		<h1>${dto.bookRate}</h1>
		<!-- 영역은 생략가능하지만 다른영역에도 같은 속성명이 있으면 안된다. -->

		<c:choose>
			<c:when test="${dto.bookSale==1}">
				<h1>판매중</h1>
			</c:when>
			<c:otherwise>
				<h1>판매종료</h1>
			</c:otherwise>
		</c:choose>
		
		<c:forEach items="${dto.fileDTOs}" var="f">
			<img alt="" src="/resources/upload/bankBook/${f.fileName }">
		</c:forEach>
		
		<a href="./update?bookNum=${dto.bookNum}" class="btn btn-warning">수정</a> 
		<button id="update">수정</button>
		<button id="del" class="btn btn-danger" data-delete-name="bookNum" data-delete-num="${dto.bookNum}">삭제</button>
		<a href="../bookACCount/add?bookNum=${dto.bookNum }">상품가입</a>
		<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#accountModal">
 	 		상품가입
		</button>

		<div class="mb-3">
			<textarea  id="comment" name="accountPassword"></textarea>
			<button id="commentAdd">댓글등록</button>
		</div>
		<div>
			<table id="commentList">
				
			</table>
			<div id="more">

			</div>

		</div>

		<!--Modal-->
		<div class="modal fade" id="accountModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			  <div class="modal-content">
				<div class="modal-header">
				  <h1 class="modal-title fs-5" id="exampleModalLabel">비밀번호 입력</h1>
				  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
				 	<div class="mb-3">
						<input type="password" class="form-control" id="pw" name="accountPassword">
					</div>
				</div>
				<div class="modal-footer">
				  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="close">Close</button>
				  <button type="button" class="btn btn-primary" data-add-num="${dto.bookNum}" data-total-page="${pager.totalPage}" id="add" >상품가입</button>
				</div>
			  </div>
			</div>
		  </div><br><br>
		<!-- <%-- <c:if test="${dto.bookSale==1}">
		<h1>판매중</h1>
	</c:if>
	<c:if test="${dto.bookSale==0}">
		<h1>판매종료</h1>
	</c:if>  --%> -->
	
	
	<script src="../resources/js/delete.js"></script>
	<script>
		let totalPage = 0;
		let bn= $('#add').attr("data-add-num")
		let pageNum=1;
		let tpn= $('#add').attr("data-total-page")

		$("#commentAdd").click(function(){
			let contents=$("#comment").val();
			$.ajax({
				type:'post',
				url:"commentAdd",
				data:{
					bookNum:bn,
					commentContents:contents
				},
				success:function(result){
					if(result.trim()>0){
						alert('댓글등록OK');
						$("#commentList").empty();
						$("#comment").val("");
						pageNum=1;
						getCommentList(bn,1);
					}
				},
				error:function(){
					alert("에러");
				}
			})
		})


		$("#more").on("click","#moreButton",function(){
			if(pageNum>=totalPage){
				alert("마지막페이지")
				return
			}
			pageNum++;
			getCommentList(bn,pageNum)
		});

		getCommentList(bn,pageNum)

		function getCommentList(bookNum,page){
			$.ajax({
				type:'get',
				url:"./comment",
				data:{
					bookNum:bookNum,
					page:page
				},
				success:function(result){
					$('#commentList').append(result);
					totalPage = $('#totalPage').attr('data-totalPage')
					let btn5 = '<button id="moreButton">더보기('+pageNum+'/'+totalPage+')</button>';
					$('#more').html(btn5);

				},
				error:function(){
					alert("에러")
				}
			})
			
		}
		// const add = document.getElementById("add");
		// add.addEventListener("click",function(){
		// 	let bookNum=add.getAttribute("data-add-num");
		// 	let pw=document.getElementById("pw").value;
		// 	// ajax1(bookNum,pw);
		// 	ajax2(bookNum,pw);
			
			
		// });
		$('#add').click(function(){
			let bookNum=$('#add').attr("data-add-num");
			let pw=$('#pw').val();
			ajax3(bookNum,pw);
		})
		// function ajax1(bookNum,pw){
		// 	//1.ajax를 사용하기위한 객체
		// 	let xhttp=new XMLHttpRequest();

		// 	//2.요청 정보
		// 	xhttp.open("POST","../bookACCount/add");

		// 	//3.요청 header 정보
		// 	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

		// 	//4.요청 발생(post일 경우 파라미터 작성 key=값&key2=값2)
		// 	xhttp.send("bookNum="+bookNum+"&accountPassword="+pw);

		// 	xhttp.onreadystatechange=function(){
		// 		if(this.readyState==4&&this.status==200){
		// 			let r = this.responseText.trim();
		// 			console.log(r);
		// 			if(r>0){
		// 				alert("가입 성공")
		// 			}else{
		// 				alert("가입 실패")
		// 			}
		// 			document.getElementById("close").click();
		// 			location.href="../";
		// 		}
		// 	}
		// }
		// function ajax2(bookNum,pw){
			//자바스크립트
			// fetch("../bookACCount/add",{
			// 	method:"post",
			// 	body:"bookNum="+bookNum+"&accountPassword="+pw,
			// 	headers:{
			// 		"Content-type":"application/x-www-form-urlencoded"
			// 	}
			// })
			// .then((response)=>{
			// 	return response.text();
			// })
			// .then((r)=>{
			// 	if(r>0){
			// 		alert("가입 성공")
			// 	}else{
			// 		alert("가입 실패")
			// 	}
			// 	location.href="../"
			// })
		// }
		function ajax3(bookNum,pw){
			$.ajax({
				type:'post',
				url:'../bookACCount/add',
				data:{
					bookNum:bookNum,
					accountPassword:pw
				},
				success:function(r){
					if(r.trim()>0){
					alert("가입 성공")
			 		}else{
			 		alert("가입 실패")
				 	}
				 	location.href="../"
				},
				error:function(){
					alert("에러")
				}
			})
		}
	</script>
	<!-- <script>
		setBookNum(${dto.bookNum});
	</script> -->
	</section>
	
</body>
</html>