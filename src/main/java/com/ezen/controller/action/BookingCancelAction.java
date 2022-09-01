package com.ezen.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.BookingDao;

public class BookingCancelAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int resv_seq = Integer.parseInt(request.getParameter("resv_seq"));
		
		BookingDao bookingDao = BookingDao.getInstance();
		
		bookingDao.deleteBooking(resv_seq);

		new BookingListAction().execute(request, response);
	}

}
