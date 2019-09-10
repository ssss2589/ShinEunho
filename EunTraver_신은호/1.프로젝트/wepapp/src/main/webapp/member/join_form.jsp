<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../Header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.html"%>
<%@ page isELIgnored="false"%>
<link rel="stylesheet" href="css/shopping.css">
<script>
	function idcheck() {
		if (document.formm.id.value == "") {
			alert("아이디를 입력해 주세요.");
		} else {
			window.open("NonageServlet?command=id_check_form&id="+document.formm.id.value,"아이디 중복 확인",
					"width = 550px , height = 400px,resizable = no");
		}
	}

	function post_zip() {
		window.open("NonageServlet?command=find_zip_num","우편번호 찾기",
				"width = 550px , height = 400px,resizable = no")
	}

	function go_save() {
		if(formm.id.value ==""){
			alert("아이디를 입력해주세요");
			return;
		}
		formm.submit();
	}
</script>
<article>
	<h2>회원가입</h2>
	<form id="join" action="NonageServlet?command=joinMember" method="post"
		name="formm">
		<fieldset>
			<legend>기본 기입 정보</legend>
			<label>사용할 아이디</label> <input type="text" name="id" size="12">
			<input type="hidden" name="reid"> <input type="button"
				value="중복 체크" class="dup" onclick="idcheck()"><br> <label>비밀번호</label>
			<input type="password" name="pwd"><br> <label>비밀번호
				재입력</label> <input type="password" name="pwdCheck"><br> <label>이름</label>
			<input type="text" name="name"><br> <label>이메일</label> <input
				type="text" name="email"><br>
		</fieldset>
		<fieldset>
			<legend>추가 정보</legend>
			<label>우편번호</label> <input type="text" name="zipNum" size="12">
			<input type="button" value="주소 찾기" class="dup" onclick="post_zip()"><br>
			<label>주소</label> <input type="text" name="addr1" size="28"><br>
			<label></label> <input type="text" name="addr2" size="40"> <br>
			<label>전화번호</label> <input type="text" name="phone"><br>
		</fieldset>
		<div class="clear"></div>
		<div id="buttons">
			<input type="button" value="회원가입" class="submit" onclick="go_save()">
			<input type="reset" value="취소" class="cancel">
		</div>

	</form>
</article>
<%@ include file="../footer.jsp"%>
