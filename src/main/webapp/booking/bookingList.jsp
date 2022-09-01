<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<head>
<meta charset="UTF-8">
<title>Reservation</title>
<link href="css/booking.css" rel="stylesheet">
</head>

<h1>객실 예약 현황</h1>
<table id="bookingList">
	<colgroup>
		<col width="90px" />
		<col width="90px" />
		<col width="90px" />
		<col width="90px" />
		<col width="90px" />
		<col width="90px" />
		<col width="90px" />
		<col width="90px" />
		<col width="90px" />
		<col width="90px" />
		<col width="90px" />
	</colgroup>
	<tr>
		<td colspan="11" style="text-align:right; right-margin: 20px;">
			<a href="BookingServlet?command=index">메인 메뉴로 가기</a>
		</td>
	</tr>
	<tr>
		<th>예약번호</th>
		<th>객실번호</th>
		<th>예약자명</th>
		<th>연락 전화번호</th>
		<th>체크인</th>
		<th>체크아웃</th>
		<th>성인인원</th>
		<th>어린이인원</th>
		<th>예약상태</th>
		<th>가격</th>
		<th>조식여부</th>
	</tr>
	<c:forEach var="item" items="${bookingList}">
	<tr>
		<td>${item.resv_seq}</td>
		<td>${item.room_no}</td>
		<td>${item.name}</td>
		<td>${item.phone}</td>
		<td><fmt:formatDate value="${item.check_in}" type="date"/></td>
		<td><fmt:formatDate value="${item.check_out}" type="date"/></td>
		<td>${item.adult}</td>
		<td>${item.children}</td>
		<td>
			<c:if test="${item.reserve_yn=='1'}">
			<a style="color:#feff00" href="BookingServlet?command=booking_detail&resv_seq=${item.resv_seq}">예약중</a>
			</c:if>
			<c:if test="${item.reserve_yn=='2'}">
			체크아웃
			</c:if>
		</td>
		<td>${item.price}</td>
		<td>${item.breakfast_yn}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>