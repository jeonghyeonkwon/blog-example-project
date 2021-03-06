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
    <link rel="stylesheet" href="/css/poi-excel-down.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="/js/poi-excel-down.js"></script>
    <title>엑셀 다운로드</title>
<body>
<div class="poi-form">
    <div class="btn-form">
        <button type="button" class="btn btn-primary excel-down">
            엑셀 다운로드
        </button>
        <button type="button" class="btn btn-success add-row">행 추가</button>
    </div>
    <div class="table-form">
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">제목을 입력하세요</th>
                <th scope="col">
                    <input class="form-control form-control-lg" type="text" />
                </th>
                <th scope="col">
                    <input class="form-control form-control-lg" type="text" />
                </th>
                <th scope="col">
                    <input class="form-control form-control-lg" type="text" />
                </th>
            </tr>
            </thead>
            <tbody>
            <tr class="poi-row">
                <th scope="row">1</th>
                <td>
                    <input class="form-control form-control-lg" type="text" />
                </td>
                <td>
                    <input class="form-control form-control-lg" type="text" />
                </td>
                <td>
                    <input class="form-control form-control-lg" type="text" />
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
