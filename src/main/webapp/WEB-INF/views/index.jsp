<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form {
  width:400px;
  height:400px;
  font-size:20px;
}
</style>
</head>
<body>
<h1>JPA + MariaDB + SpringBoot </h1>
<h4>CRUD Test</h4>
<a href = "insert">C : 유저 추가</a><br/>
<a href = "list">R : 유저 리스트</a><br/>
<a href = "update">U : 유저 정보수정</a><br/>
<a href = "delete">D : 유저 정보삭제</a><br/>
</body>
</html>