<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KH 온라인 문방구</title>
</head>
<body>
    
    <h1>KH 온라인 문방구</h1>

    <form action="/OrderServlet" method="POST">


        <table border="1">
            <tr>
                <th colspan="3">주문자 명</th>
            </tr>
            <tr>
                <th colspan="3"><input type="text"name="name"></th>
            </tr>
            <tr>
                <th>검정 펜</th>
                <th>500원</th>
                <th><input type="number" min="0" max="100" value="0" name="blackPen"></th>
            </tr>
            <tr>
                <th>빨간 펜</th>
                <th>700원</th>
                <th><input type="number" min="0" max="100" value="0" name="redPen"></th>
            </tr>
            <tr>
                <th>파란 펜</th>
                <th>700원</th>
                <th><input type="number" min="0" max="100" value="0" name="bluePen"></th>
            </tr>
            <tr>
                <th>화이트</th>
                <th>1000원</th>
                <th><input type="number" min="0" max="100" value="0" name="white"></th>
            </tr>
            <tr>
                <th colspan="3"><button>구매</button> <button>초기화</button>  </th>
            </tr>
        </table>

    
</body>
</html>