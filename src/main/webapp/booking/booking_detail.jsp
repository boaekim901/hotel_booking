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
<script src="script/inputCheck.js"></script>
<script>
	$(function() {
		$("#checkin_date").datepicker();
		$("#checkout_date").datepicker();
	});
</script>
</head>
<h1>예약 내역</h1>
<div id="wrap">
<article>
<form method="post" action="BookingServlet" name="frm">
	<input type="hidden" name="command" value="booking_update">
	<input type="hidden" name="resv_seq" value="${booking.resv_seq}">
	<input type="hidden" name="reserve_yn" value="${booking.reserve_yn}">
	<table align="center">
		<colgroup>
			<col width="200px" />
			<col width="200px"/>
		</colgroup>
		<tr>
			<td>예약자명</td>
			<td><input type="text" value="${booking.name}" name="name" readonly="readonly"></td>
		</tr>
		<tr>
			<td>체크인</td>
			<td>
				<fmt:formatDate value="${booking.check_in}" type="date" pattern="yyyy-MM-dd"
                	var="FormattedCheckin" />
				<input type="text" value="${FormattedCheckin}" id="checkin_date" name="checkin">
			</td>
		</tr>
		<tr>
			<td>체크아웃</td>
			<td>
				<fmt:formatDate value="${booking.check_out}" type="date" pattern="yyyy-MM-dd"
                	var="FormattedCheckout" />
				<input type="text" value="${FormattedCheckout}" id="checkout_date" name="checkout">
			</td>
		</tr>
		<tr>
			<td>객실번호</td>
			<td>
				<select name="room_no" style="width:160px;">
					<option value="101">101</option>
					<option value="102">102</option>
					<option value="201">201</option>
					<option value="202">202</option>
					<option value="301">301</option>
					<option value="302">302</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>성인 인원</td>
			<td><input type="number" value="${booking.adult}" name="adult"></td>
		</tr>
		<tr>
			<td>어린이 인원</td>
			<td><input type="number" value="${booking.children}" name="children"></td>
		</tr>
		<tr>
			<td>조식여부</td>
			<td>
				<select name="breakfast_yn" style="width:160px;">
					<option value="y">예</option>
					<option value="n">아니오</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>예약금액</td>
			<td><input type="text" value="${booking.price}" name="price" class="confirm" readonly="readonly">원</td>
		</tr>
		<tr>
			<td>연락처</td>
			<td><input type="text" value="${booking.phone}" name="phone"></td>
		</tr>
		<tr>
			<td colspan="4" style="text-align:center;">
				<br>
				<input type="submit" value="수정" onclick="return bookingCheck()">&nbsp;&nbsp;
				<input type="button" value="예약 취소" onclick="location.href='BookingServlet?command=booking_cancel&resv_seq=${booking.resv_seq}'">
			</td>
		</tr>	
	</table>
</form>
</article>
</div>
<%@ include file="../footer.jsp" %>