<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
table.type02 {
  border-collapse: separate;
  border-spacing: 0;
  text-align: left;
  line-height: 1.5;
  border-top: 1px solid #ccc;
  border-left: 1px solid #ccc;
  margin : 20px 10px;
}
table.type02 th {
  width: 150px;
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  border-right: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
  border-top: 1px solid #fff;
  border-left: 1px solid #fff;
  background: #eee;
}
table.type02 td {
  width: 350px;
  padding: 10px;
  vertical-align: top;
  border-right: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>유저 리스트</h3>
<a href="home">홈으로가기</a>
<table class = "type02">
    <tr>
      <th>데이터 번호</th>
      <th>아이디</th>
      <th>비밀번호</th>
      <th>이름</th>
      <th>생성시간</th>
    </tr>
 <c:forEach items = "${list}" var = "list_member">
    <tr>
      <td>${list_member.getMemberID()}</td>
      <td>${list_member.getLoginID()}</td>
      <td>${list_member.getPassword()}</td>
      <td>${list_member.getName()}</td>
      <td>${list_member.getReg_day()}</td>
    </tr>
</c:forEach>
 </table>

</body>
</html>