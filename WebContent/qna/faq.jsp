<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>

<link href="/css/qna.css" rel="stylesheet" type="text/css" />

<!-- <section class="top_section">
</section>
 -->
	<div style="
    background-color: #50d2d4;
"><img class="faq_img" src="/images/faq.jpg" /></div>
	<nav class="tabmenu">
		<input type="hidden" id="qnaId" value="${loginInfo.id }">
	
		<ul>
			<li onclick="select_list('1')"><a href="#">문의 내역</a></li>
			<li onclick="select_list('2')"><a href="#">문의 하기</a></li>
			<li class="on"><a href="/qna/faq">자주 묻는 질문</a></li>
		</ul>
	</nav>
	<div>
		<ul class="faq_table">
		<c:forEach var="faq" items="${faqList}">
		<li>
		<dl>
			<dt class="faqtitle">
				<a href=#>${faq.subject}</a>
			</dt>
			<dd>
				<br>${faq.content}
			</dd>
		</dl>
		</li>
		</c:forEach>
<!-- 		<li>
		<dl>
			<dt class="faqtitle">
				<a href=#>재능기부를 받기 전에 작성자 분께 궁금한 것이 있어요.</a>
			</dt>
				<dd>
					<br> 쪽지보내기로 재능기부 받기 신청하셨다면 회원님의 프로필이 작성자에게 전송됩니다. 이제 가끔 재능기부에 들려서 답장이 왔는지 확인해주세요. 쪽지로 간단한 협의를 마치시고 레슨을 시작하시면 됩니다.
					<br>프로필에 정보가 많을수록 연락올 확률이 높으니 프로필을 자세하게 작성해주시는 것이 좋습니다.
				</dd>
			</dl>
		</li>
		<li>
			<dl>		
			<dt class="faqtitle">
				<a href=#>재능기부 글을 작성했는데 이제 어떻게 해야 하나요?</a>
			</dt>
				<dd>
					<br> 새로운 재능기부 글을 개설하셨다면 일반적으로 2주안에 1~2명에서 많게는 5~8명까지 쪽지신청이 접수되며 받은쪽지함에서 확인해보실수 있습니다.
					<br>신청하신 회원님들의 프로필을 확인해 보시고 그중에 원하시는 분과 쪽지로 내용과 장소를 협의하신후 재능기부를 시작하시면 됩니다.
				</dd>
			</dl>
		</li>
		<li>
			<dl>
			<dt class="faqtitle">
				<a href=#>배우고 싶은 건 많은데 가르쳐줄게 없으면 어떻게 하나요?</a>
			</dt>
				<dd>
					<br> 한국인이라면 기본적으로 한국어를 가르쳐 주실수 있습니다. 그리고 운전을 하신다면 운전을 가르쳐 주실수도 있고 요리도 가능합니다.
					<br>또는 직업으로 하고 계신 일을 가르쳐 주셔도 됩니다. 의외로 많은 분들이 여러분의 레슨을 기다리고 있습니다. 한번 시작해보세요!
				</dd>
			</dl>
		</li>
		<li>
			<dl>
			<dt class="faqtitle">
				<a href=#>연락을 주고 받은 끝에 재능교환을 시작하기로 했습니다. 이제 어떻게 해야 하나요?</a>
			</dt>
				<dd>
					<br> 재능교환 성공을 축하드립니다^^
					<br>재능교환을 시작하셨다면 더이상 재능교환 신청을 받으실 필요가 없으시니 해당 작성글로 가셔서 신청마감하기를 클릭하셔서 재능교환 신청을 마감해주세요.
				</dd>
			</dl>
		</li>
		<li>
			<dl>
			<dt class="faqtitle">
				<a href=#>쪽지를 보내도 답장이 잘 오지 않습니다.</a>
			</dt>
				<dd>
					<br>쪽지를 보내도 답변이 오지 않으신다면 프로필을 좀더 자세하게 채워주시는 것이 좋습니다.
					<br>특히 12주간의 커리큘럼을 상세하게 써주신다면 좀더 연락이 올 확률이 높아집니다.
				</dd>
			</dl>
		</li> -->
		</ul>
	</div>
	<div class="bottom"></div>
<%@ include file="../footer.jsp" %>