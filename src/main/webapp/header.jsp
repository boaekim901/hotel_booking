<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<head>
  <meta charset="UTF-8">
  <title>호텔 예약</title> 
  <link href="css/booking.css" rel="stylesheet">
</head>
<body>
<!--헤더파일 들어가는 곳 시작 -->
  <header>
    <!--로고 들어가는 곳 시작--->  
    <div id="logo">
      <a href="BookingServlet?command=index">
        <img src="images/hotel_logo.png" width="100" height="100" alt="oceanhill hotel">
      </a>  
    </div>
    <!--로고 들어가는 곳 끝--> 
    <nav id="main_title">
     <ul>    
       <li>
         <a href="BookingServlet?command=index">오션힐 호텔</a>
       </li>
     </ul>
    </nav>
    
    <nav id="top_menu">
      <ul>
        <li>
          <a href="BookingServlet?command=booking_form">예약 하기</a>
        </li>  
        <li>
          <a href="BookingServlet?command=booking_list">객실 예약현황</a>
        </li>  
      </ul>
    </nav>
    <div class="clear"></div>
    
  </header>
  <!--헤더파일 들어가는 곳 끝 -->
