package com.ezen.controller.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.BookingDao;
import com.ezen.dto.BookingVO;

import util.Constant;

public class BookingUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookingVO bVo = new BookingVO();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		bVo.setResv_seq(Integer.parseInt(request.getParameter("resv_seq")));
		bVo.setName(request.getParameter("name"));
		bVo.setPhone(request.getParameter("phone"));
		System.out.println("체크인 날짜: " + request.getParameter("checkin"));
		System.out.println("체크아웃 날짜: " + request.getParameter("checkout"));
		try {
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
		bVo.setReserve_yn(request.getParameter("reserve_yn"));
		bVo.setBreakfast_yn(request.getParameter("breakfast_yn"));
		
		// 객실요금 계산
		int adult = bVo.getAdult();
		int kids = bVo.getChildren();
		int people = adult + kids;
		int extra_fee = 0;
		if (people > Constant.CAPACITY) {
			if (adult < Constant.CAPACITY) {
				extra_fee = kids * Constant.CHILD_CHARGE;
			} else {
				extra_fee = (adult-Constant.CAPACITY) * Constant.ADULT_CHARGE +
							kids * Constant.CHILD_CHARGE;
			}
		}
		int total = Constant.BASE_PRICE + extra_fee;
		bVo.setPrice(total);
		
		
		System.out.println("예약 업데이트>>>>>");
		System.out.println("순번:"+bVo.getResv_seq());
		System.out.println("예약자명:"+bVo.getName());
		System.out.println("연락처:"+bVo.getPhone());
		System.out.println("체크인:"+bVo.getCheck_in());
		System.out.println("체크아웃:"+bVo.getCheck_out());
		System.out.println("방번호:"+bVo.getRoom_no());
		System.out.println("성인:"+bVo.getAdult());
		System.out.println("자녀:"+bVo.getChildren());
		System.out.println("예약상태:"+bVo.getReserve_yn());
		System.out.println("조식:"+bVo.getBreakfast_yn());
		System.out.println("결제금액:"+bVo.getPrice());
		System.out.println();
		
		BookingDao bDao = BookingDao.getInstance();
		
		bDao.updateBooking(bVo);
		
		new BookingListAction().execute(request, response);

	}

}
