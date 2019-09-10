<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1 {
	font: 40px "판타지", Fantasy;
}

table {
	align-content: center;
}

</style>
<script type="text/javascript">
	function inputChecked(obj){
		if(obj.name.value == ""){
			alert("이름을 입력해주세요.");
			document.form.name.focus();
		}else if(obj.id.value ==""){
			alert("아이디를 입력해주세요.");
			document.form.id.focus();
		}else if(obj.pw.value ==""){
			alert("비밀번호를 입력해주세요.");
			document.form.pw.focus();
		}else if(obj.pw2.value ==""){
			alert("비밀번호확인을 입력해주세요.");
			document.form.pw2.focus();
		}else if(obj.pw2.value != obj.pw.value){
			alert("비밀번호가 같지않습니다.");
			document.form.pw2.focus();
		}else if(obj.sex.value ==""){
			alert("성별을 체크해주세요.");
			document.form.sex.focus();
		}else if(obj.rrn.value =="" || obj.rrn2.value ==""){
			alert("주민등록번호를 입력해주세요.");
			if(obj.rrn.value ==""){
				document.form.rrn.focus();
			}else{
				document.form.rrn2.focus();
			}
		}else if(obj.email.value =="" || obj.email2.value ==""){
			alert("이메일을  입력해주세요.")
			if(obj.email.value ==""){
				document.form.email.focus();
			}else{
				document.form.email2.focus();
			}
		}else if(obj.phone.value ==""){
			alert("폰번호를 입력해주세요.")
			document.form.phone.focus();
		}else{
				
			obj.action ="/wepapp/MemberServletEx"
			obj.submit();
		}
		
	}
</script>
</head>
<body onload="document.form.name.focus()">
<form action="" method="post" name="form">
	<h1 align="center" style="color: green;">Eun-style</h1>
	<fieldset>
		<legend>회원가입</legend>
		<table>
			<tr>
				<td>
					<h3>이름</h3>
				</td>
			</tr>
			<tr>
				<td><input type="text" maxlength="5" name="name"></td>
			</tr>
			<tr>
				<td>
					<h3>아이디</h3>
				</td>
			</tr>
			<tr>
				<td><input type="text" maxlength="8" name="id"></td>
			</tr>
			<tr>
				<td>
					<h3>비밀번호</h3>
				</td>
			</tr>
			<tr>
				<td><input type="password" maxlength="8" name="pw"></td>
			</tr>
			<tr>
				<td>
					<h3>비밀번호 재확인</h3>
				</td>
			</tr>
			<tr>
				<td><input type="password" maxlength="8" name="pw2"></td>
			</tr>
			<tr>
				<td>
					<h3>성별</h3>
				</td>
			</tr>
			<tr>
				<td>
					<input type=radio name="sex" value="남자">남자
					<input type=radio name="sex" value="여자">여자
				</td>
			</tr>
			<tr>
				<td>
					<h3>주민번호</h3>
				</td>
			</tr>
			<tr>
				<td><input type="text" size="20" maxlength="6" name="rrn">
					- <input type="text" size="20" maxlength="7" name="rrn2">
				</td>
			</tr>
			<tr>
				<td>
					<h3>이메일</h3>
				</td>
			</tr>
			<tr>
				<td><input type="text" size="20" name="email"> @ <input
					type="text" size="20" name="email2"></td>
			</tr>
			<tr>
				<td>
					<h3>휴대전화</h3>
				</td>
			</tr>
			<tr>
				<td><input type="number" size="20" maxlength="11" name="phone"></td>
			</tr>
		</table>
		<input type = "button" value = "확인" onclick="inputChecked(this.form)"/>
		<input type = "reset" value = "취소" />
	</fieldset>
	</form>

</body>
</html>