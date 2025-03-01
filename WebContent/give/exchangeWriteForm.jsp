<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<link href="/css/give.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<style>
.ui-datepicker-trigger {
   width: 26px;
   padding-left: 5px;
   position: fixed;
}
</style>
<script>
   $(function() {
       $("#closing_date").datepicker({
          showOn: "button",
          buttonImage: "/images/calendar.jpg",
          buttonImageOnly: true,
          showMonthAfterYear: true,
          dateFormat: "yy-mm-dd",
          monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
          dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
          firstDay: 1,
          minDate: 1,
       });
   });
</script>

<!-- 메인 시작 -->
<section class="top_section">
</section>

<article>
   <form name="form" id=modiform method="post">
   
   <div class="giveMenu">
      <ul>
         <li><a href="javascript:void(0);" onclick="menu_list('8')">언어</a></li>
         <li><a href="javascript:void(0);" onclick="menu_list('9')">예술</a></li>
         <li><a href="javascript:void(0);" onclick="menu_list('10')">스포츠</a></li>
         <li><a href="javascript:void(0);" onclick="menu_list('11')">컴퓨터</a></li>
         <li><a href="javascript:void(0);" onclick="menu_list('12')">그외</a></li>
      </ul>
   </div>
   
   <div class="giveWrite">
   <div class="giveWrite_container">
      <input type="hidden" id="board" value="exchange">
      <input type="hidden" name="id" value="${loginInfo.id}">
      <input type="hidden" name="category">
      <input type="hidden" name="key">
      <input type="hidden" id="no" name="no" value="${modExchange.no }">
      <table class="giveWrite_table" width="50%">
      <tr>
         <th>기부 재능</th>
         <td>
            <select id="give_talent1" name="give_talent1">
               <option value="" <c:if test="${modExchange.give_talent1 eq ''}">selected</c:if>>선택</option>
               <option value="언어" <c:if test="${modExchange.give_talent1 eq '언어'}">selected</c:if>>언어</option>
               <option value="예술" <c:if test="${modExchange.give_talent1 eq '예술'}">selected</c:if>>예술</option>
               <option value="스포츠" <c:if test="${modExchange.give_talent1 eq '스포츠'}">selected</c:if>>스포츠</option>
               <option value="컴퓨터" <c:if test="${modExchange.give_talent1 eq '컴퓨터'}">selected</c:if>>컴퓨터</option>
               <option value="그 외" <c:if test="${modExchange.give_talent1 eq '그외'}">selected</c:if>>그외</option>
            </select>
            <input type="text" id="give_talent2" name="give_talent2" size="10" maxlength="10" value="${modExchange.give_talent2}">
         </td>
         <th>희망 재능</th>
         <td>
            <select id="wish_talent1" name="wish_talent1">
               <option value="" <c:if test="${modExchange.wish_talent1 eq ''}">selected</c:if>>선택</option>
               <option value="언어" <c:if test="${modExchange.wish_talent1 eq '언어'}">selected</c:if>>언어</option>
               <option value="예술" <c:if test="${modExchange.wish_talent1 eq '예술'}">selected</c:if>>예술</option>
               <option value="스포츠" <c:if test="${modExchange.wish_talent1 eq '스포츠'}">selected</c:if>>스포츠</option>
               <option value="컴퓨터" <c:if test="${modExchange.wish_talent1 eq '컴퓨터'}">selected</c:if>>컴퓨터</option>
               <option value="그외" <c:if test="${modExchange.wish_talent1 eq '그외'}">selected</c:if>>그외</option>
            </select>
            <input type="text" id="wish_talent2" name="wish_talent2" size="10" maxlength="10" value="${modExchange.wish_talent2}">
         </td>
      </tr>
      <tr>
         <th>제목</th>
         <td colspan=3><input type="text" id="subject" name="subject" onclick="countBoardSubtext()" value="${modExchange.subject}">&nbsp;
         <span id="count_sub">(0 / 최대
         100자)</span> </td>
      </tr>
      <tr>
         <th>내용</th>
         <td colspan=3><textarea id="content" name="content" rows="10" onclick="countBoardtext()">${modExchange.content}</textarea><br>
         &nbsp;<span id="count_con">(0 / 최대
         5000자)</span> </td>
      </tr>
      <tr>
         <th>위치</th>
         <td>
            <input type="text" id="location" name="location" size="20" value="${modExchange.location}">
            <input class="board_submit_btn" type="button" id="location_search" value="찾기" onclick="popup()">
         </td>
         <th>마감일</th>
         <td>
            <input type="text" id="closing_date" name="closing_date" size="10" value="${modExchange.closing_date}" readonly="readonly">
         </td>
      </tr>
      </table>
      <c:if test="${empty modExchange}">
         <input class="board_list_btn" type="button" id="giveReg_ok" value="등록" onclick="regClass()">
      </c:if>
      <c:if test="${!empty modExchange}">
         <input class="board_list_btn" type="button" id="giveMod_ok" value="수정" onclick="modClass()">
      </c:if>
      <input class="boardDetail_delete_btn" type="button" id="calcel" value="취소" onclick="go_back()">
   </div>
   </div>
   </form>
   <div class="clear"></div>
</article>
<!-- 메인 끝 -->

<%@ include file="../footer.jsp" %>