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
		<h1>Update Page</h1>

		<form action="./update" method="post" enctype="multipart/form-data">
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
		<label for="contents" class="form-label">내용</label>
			<textarea class="form-control mb-5" rows="" cols="" name="contents" id="contents">${dto.contents}</textarea>
		</div>
		<div class="mb-3">
			<button type="button" id="addFile">File추가</button>
		</div>

		<div id="fileList" class="my-5">
			
		</div>
		<div>
			<c:forEach items="${dto.fileDTOs}" var="f">
				<div class="alert alert-info" role="alert">
					${f.originalName}
				</div>
				<span class="delets" data-delete-num="${f.fileNum}">X</span>
			</c:forEach>
		</div>
			<button>수정</button>

		</form>
	</section>
	<script src="../resources/js/file.js"></script>
	<script>
		$('#contents').summernote();

	</script>
</body>
</html>