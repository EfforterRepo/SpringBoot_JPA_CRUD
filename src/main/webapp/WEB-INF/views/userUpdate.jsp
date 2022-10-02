<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>유저 정보 업데이트</h3>
<script type="text/javascript">
    
        // 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
        function checkValue()
        {
            if(!document.userInfo.memberId.value){
                alert("유저 데이터 번호를 입력하세요.");
                return false;
            }
            
            if(!document.userInfo.userPw.value){
                alert("비밀번호를 입력하세요.");
                return false;
            }
            
            if(!document.userInfo.userName.value){
                alert("이름을 입력하세요.");
                return false;
            }
            
            if(!document.userInfo.userName.value){
                alert("이름을 입력하세요.");
                return false;
            }
        }
    </script>

<form method="post" name="userInfo" action="update_exe" onsubmit="return checkValue();">
	<fieldset id="regbox">
		<legend>유저 정보 변경</legend>
		<input type="text" placeholder="유저 데이터 번호" name="memberId"/><br/>
		<input type="text" placeholder="아이디" name="userId"/><br/>
		<input type="password" placeholder="비밀번호" name="userPw"/><br/>
		<input type="text" placeholder="이름" name="userName"/><br/>
		<input type="submit" value="회원가입">
	</fieldset>
</form>



</body>
</html>