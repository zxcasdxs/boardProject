<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <style>

        .register {
            margin: auto;
            display: flex;
            width: 70%;
            flex-direction: column;
        }

        .register div {
            margin-top: 10px;
        }

    </style>
</head>
<body>
<div class="register">
    <form action="/board/read" method="get">
        <div class="form-group">
            <label for="formGroupExampleInput">Title</label>
            <input type="text" name="title" class="form-control" value="${dto.title}" readonly id="formGroupExampleInput" placeholder="제목">
        </div>
        <div class="form-group">
            <label for="formGroupExampleInput2">Assort</label>
            <input type="text" name="assort" class="form-control" value="${dto.assort}" readonly id="formGroupExampleInput2" placeholder="분류">
        </div>
        <div class="form-group">
            <label for="exampleFormControlTextarea1">Content</label>
            <textarea class="form-control" name="content" value="${dto.content}" readonly id="exampleFormControlTextarea1" rows="7" placeholder="내용을 입력하세요."></textarea>
        </div>
        <div class="form-group">
            <label for="formGroupExampleInput2">Writer</label>
            <input type="text" name="writer" class="form-control" value="${dto.writer}" readonly id="formGroupExampleInput3" placeholder="작성자">
        </div>
        <div>
            <button onclick="location.href='/board/update'" type="submit" class="btn btn-primary">수정</button>
            <button onclick="location.href='/board/update'" type="submit" class="btn btn-danger">삭제</button>
            <button onclick="location.href='/board/list'" type="button" class="btn btn-outline-dark">목록</button>
        </div>
    </form>
</div>
</body>
</html>