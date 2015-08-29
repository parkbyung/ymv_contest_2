<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <meta http-equiv="refresh" content="3;url=home.ymv">
<h3 align="center">
<c:forEach items="${requestScope.list }" var="appOK" varStatus="i">
<c:choose>
	<c:when test="${i.index == 0}">
	${appOK}님
	</c:when>
	<c:otherwise>
	, ${appOK}님
	</c:otherwise>
</c:choose>

</c:forEach>
을 뽑았습니다.<br>
쪽지가 보내졌습니다.<br></h3>
<h4 align="center">3초후에 메인으로 이동됩니다. </h4>


