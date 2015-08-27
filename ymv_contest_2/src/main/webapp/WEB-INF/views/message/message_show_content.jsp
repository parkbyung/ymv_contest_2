<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="${initParam.root}resources/jquery.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#deleteBtn").click(function(){
			if(confirm("삭제하시겠습니까?")){
				location.href="message_board_delete.ymv?messageNo="+${requestScope.mgvo.messageNo};
			}else{
				return;
			}
		})
	})
</script>
	<div class="col-sm-8 col-sm-offset-2">
		<table class="table table-hover">
			<tr>
				<td colspan="2">NO : ${requestScope.mgvo.messageNo }</td>
				<td colspan="2">종류 : ${requestScope.mgvo.messageType }</td>
				<td colspan="2">시간: ${requestScope.mgvo.timePosted}</td>
			</tr>
			<tr>
				<td colspan="5"><font style="font-weight: bold;">${requestScope.mgvo.title}</font></td>
				<td colspan="1">받는이 : ${requestScope.mgvo.receiverName }</td>
			</tr>
			<tr>			
				<td colspan="6">	
				<br><pre>${requestScope.mgvo.content}</pre></td>
		</tr>
			<tr>
				<td valign="middle" align="center" colspan="6"><a
					href="${initParam.root}message_board.ymv" class="btn btn-default btn-xs">목록</a>
					<input type="button" class="btn btn-default btn-xs" id ="deleteBtn" value="삭제" ></a>
				</td>
		</table>
	</div>