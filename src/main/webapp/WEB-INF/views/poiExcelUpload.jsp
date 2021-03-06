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
    <link rel="stylesheet" href="/css/poi-excel-upload.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="/js/poi-excel-upload.js"></script>
    <title>엑셀 업로드</title>
</head>
<body>
<div class="upload-btn">
    <div class="input-group mb-3">
        <input type="file" class="form-control excel-file" id="inputGroupFile02" />
        <button class="input-group-text poi-upload-btn"
        >파일 올리기</button>
    </div>
    <a href="/uploadExample.xlsx">
    <button type="button" class="btn btn-primary">기본 형식 다운로드</button>
    </a>
</div>
<div class="upload-form">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">num</th>
            <th scope="col">성</th>
            <th scope="col">이름</th>
            <th scope="col">etc</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
</div>
</body>
</html>
