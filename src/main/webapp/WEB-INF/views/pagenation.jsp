<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
            crossorigin="anonymous"
    />
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
            crossorigin="anonymous"
    ></script>
    <link rel="stylesheet" href="/css/pagenation.css" />
    <title>Document</title>
</head>
<body>
<div class="custom_page">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">uuid</th>
            <th scope="col">유저 이름</th>
            <th scope="col">주소</th>
            <th scope="col">소개</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="dto" items="${dtos.dataList}">
            <tr>
                <th scope="row">${dto.uuid}</th>
                <td>${dto.userName}</td>
                <td>${dto.address}</td>
                <td>${dto.intro}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <li class="page-item ">
                <a class="page-link <c:if test='${dtos.first eq "true"}'>disabled</c:if>" href="/page/user?page=${dtos.currentPage-1}">Previous</a>
            </li>

            <c:forEach begin="${dtos.startBlockPage}" end="${dtos.endBlockPage}" var ="p">
                <li class="page-item
                    <c:if test='${p eq dtos.currentPage+1}'>active</c:if>
                "><a class="page-link" href="/page/user?page=${p-1}">${p}</a></li>
            </c:forEach>

            <li class="page-item">
                <a class="page-link <c:if test='${dtos.last eq "true"}'>disabled</c:if>" href="/page/user?page=${dtos.currentPage+1}">Next</a>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>
