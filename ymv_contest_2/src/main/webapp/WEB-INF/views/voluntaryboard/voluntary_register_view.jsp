<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(document).ready(function() {
		$("#recruitForm").submit(function() {
			if ($("#title").val() == "") {
				alert("제목을 입력해주세요");
				return false;
			} else if ($("#field").val() == "") {
				alert("분야를 선택해 주세요");
				return false;
			} else if ($("#location").val() == "") {
				alert("지역을 선택해 주세요");
				return false;
			} else if ($("# :radio[name=age]:checked").val() == ""||$("# :radio[name=age]:checked").val() == null) {
				alert("봉사 가능한 나이를 선택해 주세요");
				return false;
			} else if ($("#startTime").val() == "") {
				alert("시작시간을 입력해 주세요");
				return false;
			} else if ($("#endTime").val() == "") {
				alert("끝시간을 입력해 주세요");
				return false;
			} else if ($("#content").val() == "") {
				alert("상세정보를 입력해 주세요");
				return false;
			}
		});
	});
</script>

<!-- 달력을 쓰기위해 import -->
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" media="all" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"
	type="text/javascript"></script>

<script type="text/javascript">
$(document).ready(function () {
    $.datepicker.regional['ko'] = {
        closeText: '닫기',
        prevText: '이전달',
        nextText: '다음달',
        currentText: '오늘',
        monthNames: ['1월(JAN)','2월(FEB)','3월(MAR)','4월(APR)','5월(MAY)','6월(JUN)',
        '7월(JUL)','8월(AUG)','9월(SEP)','10월(OCT)','11월(NOV)','12월(DEC)'],
        monthNamesShort: ['1월','2월','3월','4월','5월','6월',
        '7월','8월','9월','10월','11월','12월'],
        dayNames: ['일','월','화','수','목','금','토'],
        dayNamesShort: ['일','월','화','수','목','금','토'],
        dayNamesMin: ['일','월','화','수','목','금','토'],
        weekHeader: 'Wk',
        dateFormat: 'yy-mm-dd',
        firstDay: 0,
        isRTL: false,
        showMonthAfterYear: true,
        yearSuffix: '',
        showOn: 'both',
        buttonText: "달력",
        changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        yearRange: 'c-99:c+99',
        minDate: "+0D"
    };
    $.datepicker.setDefaults($.datepicker.regional['ko']);
 
    $('#datepicker1').datepicker();
    $('#datepicker1').datepicker("option", "maxDate", $("#datepicker2").val());
    $('#datepicker1').datepicker("option", "onClose", function ( selectedDate ) {
        $("#datepicker2").datepicker( "option", "minDate", selectedDate );
    });
 
    $('#datepicker2').datepicker();
    $('#datepicker2').datepicker("option", "minDate", $("#datepicker1").val());
    $('#datepicker2').datepicker("option", "onClose", function ( selectedDate ) {
        $("#datepicker1").datepicker( "option", "maxDate", selectedDate );
    });
    
    $('#datepicker3').datepicker();
    $('#datepicker3').datepicker("option", "maxDate", $("#datepicker4").val());
    $('#datepicker3').datepicker("option", "onClose", function ( selectedDate ) {
        $("#datepicker4").datepicker( "option", "minDate", selectedDate );
    });
 
    $('#datepicker4').datepicker();
    $('#datepicker4').datepicker("option", "minDate", $("#datepicker3").val());
    $('#datepicker4').datepicker("option", "onClose", function ( selectedDate ) {
        $("#datepicker3").datepicker( "option", "maxDate", selectedDate );
    });
});</script>

  

	<div class="col-md-10 col-sm-offset-1">
		<h2>봉사 등록</h2>
		<form id="recruitForm"
			action="volunteer_register.ymv?memberNo=${sessionScope.mvo.memberNo }"
			method="post">
			<table class="table table-striped table-hover">
				<tr>
					<th class="info"><h4 class="text-center">제목</h4></th>
					<td><input type="text" name="title" id="title" size="70"></td>
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">분야</h4></th>
					<td><select id="field" name="field">
							<option value="">-분야-</option>
							<c:forEach items="${requestScope.fieldlist }" var="f">
								<option value="${f.field }">${f.field }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">지역</h4></th>
					<td><select id="location" name="location">
							<option value="">-지역-</option>
							<c:forEach items="${requestScope.locationlist }" var="l">
								<option value="${l.location }">${l.location }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">나이</h4></th>
					<td>
						<input type="radio"
						name="age" value="전체">전체 <input type="radio" name="age"
						value="학생">학생 <input type="radio" name="age" value="성인">성인
						<!-- 전체, 학생, 성인으로 나눠서 -->
					</td>
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">모집 시작/끝 기간</h4></th>
					<td><input type="text" id="datepicker1" name="recruitingStart"
						placeholder="모집 시작 기간">&nbsp;&nbsp;  ~	&nbsp; &nbsp; <input type="text" id="datepicker2" name="recruitingEnd" placeholder="모집 종료 기간">	</td>
				</tr>
				<tr>
					<th class="info"><h4 class="text-center">봉사 활동 시작/끝 기간</h4></th>
					<td><input type="text" id="datepicker3" name="volunteeringStartDate" placeholder="봉사 시작 기간"> 
					&nbsp;&nbsp;  ~	&nbsp; &nbsp;<input type="text" id="datepicker4" name="volunteeringEndDate" placeholder="봉사 종료 기간"> 
					</td>
				</tr>
	
				<tr>
					<th class="info"><h4 class="text-center">봉사 시작/끝 시간</h4></th>
					<td> 
						<select id="volunteeringStartTime" name="volunteeringStartTime">
							<!-- 한시간 단위로 하기 -->
							<option value="">-시작시간-</option>
							<option value="06:00">06:00</option>
							<option value="07:00">07:00</option>
							<option value="08:00">08:00</option>
							<option value="09:00">09:00</option>
							<option value="10:00">10:00</option>
							<option value="11:00">11:00</option>
							<option value="12:00">12:00</option>
							<option value="13:00">13:00</option>
							<option value="14:00">14:00</option>
							<option value="15:00">15:00</option>
							<option value="16:00">16:00</option>
							<option value="17:00">17:00</option>
							<option value="18:00">18:00</option>
							<option value="19:00">19:00</option>
							<option value="20:00">20:00</option>
							<option value="21:00">21:00</option>
							<option value="22:00">22:00</option>
							<option value="23:00">23:00</option>
							<option value="00:00">00:00</option>
					</select>
					&nbsp;&nbsp;  ~	&nbsp; &nbsp; 
					<select id="volunteeringEndTime" name="volunteeringEndTime">
							<!-- 한시간 단위로 하기 -->
							<option value="">-끝시간-</option>
							<option value="06:00">06:00</option>
							<option value="07:00">07:00</option>
							<option value="08:00">08:00</option>
							<option value="09:00">09:00</option>
							<option value="10:00">10:00</option>
							<option value="11:00">11:00</option>
							<option value="12:00">12:00</option>
							<option value="13:00">13:00</option>
							<option value="14:00">14:00</option>
							<option value="15:00">15:00</option>
							<option value="16:00">16:00</option>
							<option value="17:00">17:00</option>
							<option value="18:00">18:00</option>
							<option value="19:00">19:00</option>
							<option value="20:00">20:00</option>
							<option value="21:00">21:00</option>
							<option value="22:00">22:00</option>
							<option value="23:00">23:00</option>
							<option value="00:00">00:00</option>
					</select>
					</td>
				</tr>				
			<tr>
				<th class="info"><h4 class="text-center">상세정보</h4></th>
				<td><textarea rows="10" cols="80" id="content" name="content"></textarea></td>
			</tr>
		</table>
			<br> <div class = "col-sm-2 col-sm-offset-10">
			<input type="submit" class = "btn btn-primary"value="글 등록"><br><br></div>
			  
		</form>
		<br><br>
					</div>
