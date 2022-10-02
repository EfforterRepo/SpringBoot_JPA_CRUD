<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>유저 데이터 삭제</h3>
<script type="text/javascript">
    
        // 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
        function checkValue()
        {
            if(!document.userInfo.memberId.value){
                alert("삭제할 유저 데이터 번호를 입력하세요.");
                return false;
            }
        }
    </script>

<form method="post" name="userInfo" action="delete_exe" onsubmit="return checkValue();">
	<fieldset id="regbox">
		<legend>유저 데이터 삭제</legend>
		<input type="number" placeholder="삭제할 유저 데이터 번호" name="memberId"/><br/>
		<input type="submit" value="삭제하기">
	</fieldset>
</form>



</body>
</html>