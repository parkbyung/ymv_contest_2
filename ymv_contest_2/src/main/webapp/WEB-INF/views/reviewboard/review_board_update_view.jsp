<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="${initParam.root}resources/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#reviewForm").submit(function() {
			if ($("#title").val() == "") {
				alert("제목을 입력해주세요");
				return false;
			} else if ($("#content").val() == "") {
				alert("상세정보를 입력해 주세요");
				return false;
			}
			else if ($("#fileName").val() == "") {
				if (confirm("새로운 파일을 첨부하지 않으십니까?") == true) {
					$("#hidden").val("2");
					location.href = "review_board_update.ymv";
				} else {
					return false;			
				}
			}
		});
		
		$("#updateCancel").click(function(){
			if(confirm("취소하시겠습니까?")==true){
				location.href="review_board.ymv";
			}else{
				return;
			}
		});
	});
</script>

<div class="col-md-6 col-md-offset-3">
<h3>봉사 후기 수정</h3>
		<form method=post action="review_board_update.ymv" class="form-horizontal" enctype="multipart/form-data" id = "reviewForm">
			<table class="table table-hover">
				<tr>
					<td><b> 글번호 <input type=text name=boardNo
							value="${requestScope.rvo.boardNo }" readonly="readonly"></input> 
						&nbsp;&nbsp;&nbsp;	| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							작성자 <input type=text name=writer
							value="${requestScope.rvo.writer }" readonly="readonly"></input>
					</b></td>
				</tr>

				<tr>
					<td>제목: <input type=text name=title id=title
						value="${requestScope.rvo.title }" size="68"></input>
					</td>
				</tr>
				 <tr>
               <td><input type="file" name="fileName" id ="fileName"></td>
            </tr>
            
				<tr>
					<td><textarea rows="15" cols="75" id=content name="content">${requestScope.rvo.content }</textarea>
					</td>
				</tr>
				<tr>
					<td valign="middle" align="right"><input type="submit" value="수정하기" class="btn btn-default btn-xs"></input>
								<input type="hidden" name="boardNo" value="${requestScope.rvo.boardNo }">
			<input type="hidden" name = "hidden" id = "hidden" value = "1">
						<input type="button" id="updateCancel" value="취소하기" class="btn btn-default btn-xs"></input></td>
				</tr>
			</table>
		</form>
	</div>
