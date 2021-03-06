<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-6 col-sm-offset-3">
	<h3>
		<p class="text-center">쪽지함</p>
	</h3>
	<table class="table table-striped table-hover">
		<colgroup>
			<col style="width: 10%;" />
			<col style="width: 75%;" />
			<col style="width: 15%;" />
		</colgroup>
		<thead>
			<tr>
				<th class="messageNo">NO</th>
				<th class="title">제목</th>
				<!-- <th class="messageType">종류</th>
				<th class="timePosted">등록시간</th> -->
				<!-- recruitNo를 통해 해당 게시판으로 이동 가능 -->
				<th class="recruitNo">해당 봉사글</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="bvo" items="${requestScope.lvo.list}">
				<tr>
					<td>${bvo.messageNo }</td>
					<td><a
						href="${initParam.root}message_show_content.ymv?messageNo=${bvo.messageNo}">
							${bvo.title }</a></td>
					<!-- 신청자 알람 선정자 알람 확인서 알람 일반 알람 등 으로 나누기 -->
					<!-- recruitNo를 통해 해당 게시판으로 이동 하게 링크 걸기 -->
					<td><a
						href="${initParam.root}voluntary_show_content.ymv?recruitNo=${bvo.recruitNo }&noApplicate=no">
							바로가기</a></td>
				</tr>
				
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br></br>
	<div class="text-center">
		<ul class="pagination">
		<c:choose>
				<c:when test="${requestScope.lvo.pagingBean.previousPageGroup}">
					<li class="active"><a
						href="message_board.ymv?pageNo=${requestScope.lvo.pagingBean.
    startPageOfPageGroup-1}">«</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a
						href="#">«</a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i"
				begin="${requestScope.lvo.pagingBean.startPageOfPageGroup}"
				end="${requestScope.lvo.pagingBean.endPageOfPageGroup}">
				<c:choose>
					<c:when test="${requestScope.lvo.pagingBean.nowPage!=i}">
						<li><a href="message_board.ymv?pageNo=${i}">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li class="active"><a href="#">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${requestScope.lvo.pagingBean.nextPageGroup}">
					<li class="active"><a
						href="message_board.ymv?pageNo=${requestScope.lvo.pagingBean.
    endPageOfPageGroup+1}">»</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a
						href="#">»</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>








