<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootStrap.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>

	<section class="container mt-5">
		<h1>${board} Add PAGE</h1>

		<form action="./add" method="post" id="frm" enctype="multipart/form-data">
			<div>
				<label for="formId" class="form-label">작성자</label> <input
					type="text" name="name" class="form-control" id="formId"
					value="${member.id }" readonly="readonly"><br>
			</div>
			<div>
				<label for="subject" class="form-label">제목</label> <input
					type="text" name="subject" id="subject" class="form-control"><br>
			</div>
			<div class="mb-3">
				<label for="contents" class="form-label">글내용</label>
				<textarea rows="" cols="" name="contents" class="form-control"
					id="contents"></textarea>
			</div>
			<!-- <select name="bookSale">     2번째방법
				<option value="1" selected>판매가능</option>     
				<option value="0">판매중지</option>
			</select> -->
			<div class="mb-3">
				<button type="button" id="addFile">File추가</button>
			</div>
			<div id="fileList" class="mb-5"></div>
			

			
			<button class="btn btn-success" type="button" id="btn">등록</button>
			<!-- 버튼 타입을 생략하면 서브밋타입 -->
			<input type="reset" class="btn btn-danger">

		</form>
	</section>
	<script src="../resources/js/file.js"></script>
	<script>
		const btn = document.getElementById("btn");
		const subject = document.getElementById("subject");
		const frm = document.getElementById("frm");

		$("#contents").summernote({
			height:400,
			callbacks:{
				onImageUpload: function(files){
					alert("이미지 업로드")
					//이미지를 server로 전송하고
					//응답으로 이미지경로와 파일명을 받아서
					//img 태그를 만들어서 src속성에 이미지경로를 넣는것
					let formData = new FormData();//<form></form>
					formData.append("files",files[0]);// <input type="file" name="files">
					$.ajax({
						type:'post',
						url:"setContentsImg",
						data:formData,
						enctype:'multipart/form-data',
						cache:false,
						contentType:false,
						processData:false,
						success:function(result){
							$('#contents').summernote('insertImage',result.trim());
						},error:function(){
							console.log("에러")
						}
					})
				},
				onMediaDelete:function(files){
					let path = $(files[0]).attr("src");// /resources/upload/notice/파일명
					$.ajax({
						type:'post',
						url:'./setContentsImgDelete',
						data:{
							path:path
						},
						success:function(result){
							console.log(result);
						},
						error:function(){
							console.log("에러");
						}
					})
				}
			}
			
		});

		btn.addEventListener("click",function(){
			if(subject.value==''){
				alert("제목을 입력해주세요");
				subject.focus();
			}else{
				frm.submit();
			}
		});
	</script>

</body>
</html>