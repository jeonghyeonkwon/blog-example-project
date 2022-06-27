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
    <link rel="stylesheet" href="/css/dynamic-form.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="/js/dynamicForm.js"></script>
    <title>동적 폼 생성</title>
<body>
<div class="dynamic-form">
    <div class="dynamic-button">
        <button type="button" class="btn btn-success">폼 추가</button>
        <!-- <button type="button" class="btn btn-danger">폼 삭제</button> -->
    </div>
    <div class="dynamic-img">
        <img src="https://via.placeholder.com/150" class="img-thumbnail" />
    </div>
    <div class="dynamic-field">
        <input class="form-control form-control-lg" type="text" />
        <button type="button" class="btn btn-primary">바로 밑 추가</button>
    </div>
</div>
</body>
</html>
