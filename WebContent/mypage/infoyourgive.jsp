<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="mypagesidemenu.jsp"%>

<link href="/css/mypage.css" rel="stylesheet" type="text/css" />

<section class="top_section">
</section>

<div class="mygiveList">
	<h1><span>기 부 한 내 역</span></h1>
	<table class="mygiveList_table">
	<thead>
	<tr>
		<td>기부 재능</td>
		<td>모집 인원</td>
		<td>제목</td>
		<td>내용</td>
		<td>위치</td>
		<td>마감일</td>
		<td>스크랩</td>
	</tr>
	</thead>
	<c:forEach var="infoyourgive" items="${infoYourGive}">
		<tr>
			<td>${infoyourgive.talent1}&ensp;/&ensp;${infoyourgive.talent2}</td>
			<td>0&ensp;/&ensp;${infoyourgive.people}</td>
			<td><a href="#">${infoyourgive.subject}</a></td>
			<td><a href="#">${infoyourgive.content}</a></td>
			<td>${infoyourgive.location}</td>
			<td>${infoyourgive.closing_date}&ensp;</td>
			<td><input type="checkbox" id="clip"></td>
		</tr>
	</c:forEach>
	</table>
</div>

<div id=member></div>


<%@ include file="../footer.jsp"%>