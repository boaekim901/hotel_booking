package com.ezen.controller.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dto.BookingVO;
import com.ezen.dao.BookingDao;


public class BookingWriteAction implements Action {
	public static final String IN_RESEVATION = "1";
	public static final String DONE = "2";
	public static final String CHECKOUT = "3";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookingVO bVo = new BookingVO();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		bVo.setName(request.getParameter("name"));
		bVo.setPhone(request.getParameter("phone"));
		System.out.println("체크인 날짜: " + request.getParameter("checkin"));
		System.out.println("체크아웃 날짜: " + request.getParameter("checkout"));
		try {
			// 문자열을 날짜로 변환
			Date checkin_date = sdf.parse(request.getParameter("checkin"));
			Date checkout_date = sdf.parse(request.getParameter("checkout"));
			bVo.setCheck_in(checkin_date);
			bVo.setCheck_out(checkout_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bVo.setRoom_no(request.getParameter("room_no"));
		bVo.setAdult(Integer.parseInt(request.getParameter("adult")));
		bVo.setChildren(Integer.parseInt(request.getParameter("children")));
		bVo.setReserve_yn(IN_RESEVATION);
		bVo.setPrice(Integer.parseInt(request.getParameter("price")));
		bVo.setBreakfast_yn(request.getParameter("breakfast_yn"));
		
		BookingDao bDao = BookingDao.getInstance();
		
		bDao.insertBooking(bVo);
		
		new BookingListAction().execute(request, response);
	}

}
