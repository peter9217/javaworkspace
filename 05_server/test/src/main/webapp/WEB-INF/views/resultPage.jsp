<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>결과</title>
</head>
<body>
    <h1> <%= request.getParameter("name") %>님의 구매 목록</h1>

    검은 펜  <%= request.getParameter("blackPen") %>개 : <%= request.getAttribute("black") %> <br>
    빨간 펜  <%= request.getParameter("redPen") %>개 : <%= request.getAttribute("red") %> <br> 
    파란 펜  <%= request.getParameter("bluePen") %>개 : <%= request.getAttribute("blue") %> <br>
    화이트  <%= request.getParameter("white") %>개 : <%= request.getAttribute("white") %> <br>
    <hr>
    총합 <%= request.getAttribute("total") %>


</body>
</html>