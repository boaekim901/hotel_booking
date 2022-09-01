<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/booking.css" rel="stylesheet">
</head>
<h1>예약 확인</h1>
<div id="wrap">
<article>
<form method="post" action="BookingServlet" name="frm">
	<input type="hidden" name="command" value="booking_write">
	<table align="center">
		<colgroup>
			<col width="150px" />
			<col width="200px"/>
		</colgroup>
		<tr>
			<td>예약자명</td>
			<td><input type="text" value="${booking.name}" name="name" class="confirm" readonly="readonly"></td>
		</tr>
		<tr>
			<td>체크인</td>
			<td>
				<fmt:formatDate value="${booking.check_in}" type="date" pattern="yyyy-MM-dd"
                	var="FormattedCheckin" />
				<input type="text" value="${FormattedCheckin}" name="checkin" readonly>
			</td>
		</tr>
		<tr>
			<td>체크아웃</td>
			<td>
				<fmt:formatDate value="${booking.check_out}" type="date" pattern="yyyy-MM-dd"
                	var="FormattedCheckout" />
				<input type="text" value="${FormattedCheckout}" name="checkout" readonly>
			</td>
		</tr>
		<tr>
			<td>객실번호</td>
			<td><input type="text" value="${booking.room_no}" name="room_no" class="confirm" readonly="readonly">호</td>
		</tr>
		<tr>
			<td>성인 인원</td>
			<td><input type="text" value="${booking.adult}" name="adult" class="confirm" readonly="readonly">명</td>
		</tr>
		<tr>
			<td>어린이 인원</td>
			<td><input type="text" value="${booking.children}" name="children" class="confirm" readonly="readonly">명</td>
		</tr>
		<tr>
			<td>조식여부</td>
			<td>
			<input type="hidden" value="${booking.breakfast_yn}" name="breakfast_yn">
			<c:choose>
				<c:when test="${booking.breakfast_yn} == 'y'">
				예
				</c:when>
				<c:otherwise>
				아니오
				</c:otherwise>
			</c:choose>
			</td>
		</tr>
		<tr>
			<td>예약금액</td>
			<td><input type="text" value="${booking.price}" name="price" class="confirm" readonly="readonly">원</td>
		</tr>
		<tr>
			<td>연락처</td>
			<td><input type="text" value="${booking.phone}" name="phone" class="confirm" readonly="readonly"></td>
		</tr>
		<tr>
			<td colspan="4" style="text-align:center;">
				<br>
				<input type="submit" value="예약"">
				<input type="button" value="입력으로 돌아가기" onclick="location.href='BookingServlet?command=booking_form'">
			</td>
		</tr>	
	</table>
</form>
</article>
</div>
<%@ include file="../footer.jsp" %>