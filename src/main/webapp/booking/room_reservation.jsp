<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
<meta charset="UTF-8">
<script src="script/inputCheck.js"></script>
<link href="css/booking.css" rel="stylesheet">
<title>Reservation</title>
</head>
<h1 class="page_title">객실 예약하기</h1>
<div id="wrap">
<form method="post" action="BookingServlet" name="frm">
	<input type="hidden" name="command" value="booking_confirm">
	<table align="center">
		<colgroup>
			<col width="120px" />
			<col width="200px"/>
			<col width="120px"/>
			<col width="200px"/>
		</colgroup>
		<tr>
			<td colspan="4" style="text-align:right;">
				<a href="BookingServlet?command=index">메인 메뉴로 가기</a>
			</td>
		</tr>
		<tr>
			<th colspan="2">날짜 및 객실 선택</th>
			<th colspan="2">옵션 선택</th>
		</tr>
		<tr>
			<td>체크인</td>
			<td><input type="date" name="checkin" id="checkin_date"></td>
			<td>성인 인원</td>
			<td><input type="number" name="adult" id="adult"></td>
		</tr>
		<tr>
			<td>체크아웃</td>
			<td><input type="date" name="checkout" id="checkout_date"></td>
			<td>어린이 인원</td>
			<td><input type="number" name="children"></td>
		</tr>
		<tr>
			<td>객실번호</td>
			<td>
				<select name="room_no" id="room_no">
					<option value="101">101</option>
					<option value="102">102</option>
					<option value="201">201</option>
					<option value="202">202</option>
					<option value="301">301</option>
					<option value="302">302</option>
				</select>
			</td>
			<td>조식여부</td>
			<td>
				<select name="breakfast_yn" id="breakfast_yn">
					<option value="y">예</option>
					<option value="n">아니오</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>예약자명</td>
			<td><input type="text" name="name" id="name" width="80px"></td>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td>연락처</td>
			<td><input type="text" name="phone" id="phone" width="80px"></td>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td colspan="4" style="text-align:center;">
				<br>
				<input type="submit" class="submit" value="확인" onclick="return bookingCheck();">
				<input type="button" class="list" value="예약 목록" onclick="location.href='BookingServlet?command=booking_list'">
			</td>
		</tr>	
	</table>
</form>
</div>
<%@ include file="../footer.jsp" %>