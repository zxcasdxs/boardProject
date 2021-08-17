<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../includes/header.jsp"%>

<body>

<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th scope="col">번호</th>
        <th scope="col">제목</th>
        <th scope="col">내용(100자)</th>
        <th scope="col">작성자</th>
        <th scope="col">[조회수]</th>
        <th scope="col">작성일</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${All}" var="dto">
    <tr>
        <th scope="row">${dto.bno}</th>
        <td>${dto.title}</td>
        <td>${dto.content}</td>
        <td>${dto.writer}</td>
        <td>[${dto.count}]</td>
        <td>${dto.regdate}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>


<nav aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item"><a class="page-link" href="#">Previous</a></li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item"><a class="page-link" href="#">4</a></li>
        <li class="page-item"><a class="page-link" href="#">5</a></li>
        <li class="page-item"><a class="page-link" href="#">Next</a></li>
    </ul>
</nav>
</body>
</html>