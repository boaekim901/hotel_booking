package com.ezen.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.BookingDao;
import com.ezen.dto.BookingVO;

public class BookingDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "booking/booking_detail.jsp";
		int resv_seq = Integer.parseInt(request.getParameter("resv_seq"));
		
		BookingDao bookingDao = BookingDao.getInstance();
		
		BookingVO vo = bookingDao.getBookingBySeq(resv_seq);
		
		request.setAttribute("booking", vo);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
