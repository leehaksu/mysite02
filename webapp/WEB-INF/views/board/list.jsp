<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/board.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/include/header.jsp" />
		<div id="content">
			<div id="board">
				<form id="search_form"
					action="${pageContext.servletContext.contextPath}/board"
					method="post">
					<input type="hidden" name="a" value="search"> <input
						type="text" id="kwd" name="kwd" value=""> <input
						type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>삭제</th>
		
					</tr>
					<c:forEach items="${list}" var="vo" varStatus="status">
						<tr>
							<td>${vo.no}</td>
							<c:choose>
								<c:when test ="${vo.depth>0}">
								<td class="left" style="padding-left:${20*vo.depth }px">
										<img src="${pageContext.request.contextPath }/assets/images/reply.png">
								<a href="${pageContext.servletContext.contextPath}/board?a=view&no=${vo.no}&depth=${vo.depth}">${vo.title}</a>
								</c:when>
								<c:otherwise>
								<td class="left">
								<a href="${pageContext.servletContext.contextPath}/board?a=view&no=${vo.no}&depth=${vo.depth}">${vo.title}</a>
							</c:otherwise>
							</c:choose>
							<td>${vo.writer}</td>
							<td>${vo.hit}</td>
							<td>${vo.regDate}</td>
							<td>
							<c:if test ="${vo.user_no==authUser.no}">
							<a href="${pageContext.servletContext.contextPath}/board?a=delete&no=${vo.no}" class="del">삭제</a>
							</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
				<div class="pager">
				<ul>
					<li><a href="${pageContext.servletContext.contextPath}/board?page=${beforeNumber}">◀</a></li>
					<c:forEach begin="${firstNumber}" end="${endNumber}" varStatus="status" var="i" step="1">
						<c:if test="${fisrtNumber==0 }">
						<li class="selected"><a href="${pageContext.servletContext.contextPath}/board?page=${i}">${i}</a>
						</c:if>
					<li class="selected"><a href="${pageContext.servletContext.contextPath}/board?page=${firstNumber+i}">${firstNumber+i}</a>	
				</c:forEach>
				<li><a href="${pageContext.servletContext.contextPath}/board?page=${endNumber+1}">▶</a></li>
				
				</ul>
				</div>
				<div class="bottom">
					<a
						href="${pageContext.servletContext.contextPath}/board?a=writeForm"
						id="new-book">글쓰기</a>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/navigation.jsp"></c:import>
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	</div>
</body>
</html>