package com.ezen.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.BookingDao;
import com.ezen.dto.BookingVO;

public class BookingListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "booking/bookingList.jsp";
		
		BookingDao bookingDao = BookingDao.getInstance();
		
		List<BookingVO> bookingList = bookingDao.getBookingList();
		
		/*
		System.out.println("<<<<<예약자 목록>>>>>");
		for(BookingVO vo : bookingList) {
			System.out.println(vo.getCname());
			System.out.println(vo.getPhone());
			System.out.println(vo.getCheck_in());
			System.out.println(vo.getCheck_out());
			System.out.println(vo.getRoom_no());
			System.out.println(vo.getReserve_yn());
			System.out.println();
		}
		*/
		
		request.setAttribute("bookingList", bookingList);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
