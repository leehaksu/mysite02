<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>회원정보 수정</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/user.css" rel="stylesheet"
	type="text/css">
</head>
<body>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<div id="content">
			<div id="user">
				<form id="join-form" name="modifyform" method="post"
					action="${pageContext.servletContext.contextPath}/user?">
					<input type='hidden' name="a" value="modify" /> <label
						class="block-label" for="name">이름</label> <input id="name"
						name="name" type="text" value=""> <label
						class="block-label" for="email">이메일</label> <label
						class="block-albe" for="email">${email}</label> <label
						class="block-label">패스워드</label> <input name="password"
						type="password" value="">
					<c:choose>
						<c:when test="${gender==female}">
							<fieldset>
								<legend>성별</legend>
								<label>여</label> <input type="radio" name="gender"
									value="female" checked="checked"> <label>남</label> <input
									type="radio" name="gender" value="male">
							</fieldset>
						</c:when>
						<c:otherwise>
							<fieldset>
								<legend>성별</legend>
								<label>여</label> <input type="radio" name="gender"
									value="female"> <label>남</label> <input type="radio"
									name="gender" value="male" checked="checked">
							</fieldset>
						</c:otherwise>
					</c:choose>
					<input type="submit" value="수정하기">
				</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/navigation.jsp"></c:import>
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	</div>
</body>
</body>
</html>