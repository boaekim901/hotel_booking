package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ezen.dto.BookingVO;

import util.DBManager;

public class BookingDao {
	private BookingDao() {
		
	}
	
	private static BookingDao instance = new BookingDao();
	
	public static BookingDao getInstance() {
		return instance;
	}
	
	/*
	 * reseve_yn(예약상태):
	 * 		'1' - 예약중
	 *      '2' - 체크아웃
	 */
	public int insertBooking(BookingVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO booking values(" +
				"booking_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int result = -1;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setDate(3, convertDate(vo.getCheck_in()));
			pstmt.setDate(4, convertDate(vo.getCheck_out()));
			pstmt.setString(5,  vo.getRoom_no());
			pstmt.setInt(6, vo.getAdult());
			pstmt.setInt(7, vo.getChildren());
			pstmt.setString(8, vo.getReserve_yn());
			pstmt.setInt(9, vo.getPrice());
			pstmt.setString(10, vo.getBreakfast_yn());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int updateBooking(BookingVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE booking SET name=?, phone=?, check_in=?, check_out=?, room_no=?, " +
							"adult=?, children=?, reserve_yn=?, price=?, breakfast_yn=? " +
					  "WHERE resv_seq=?";
		int result = -1;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setDate(3, convertDate(vo.getCheck_in()));
			pstmt.setDate(4, convertDate(vo.getCheck_out()));
			pstmt.setString(5,  vo.getRoom_no());
			pstmt.setInt(6, vo.getAdult());
			pstmt.setInt(7, vo.getChildren());
			pstmt.setString(8, vo.getReserve_yn());
			pstmt.setInt(9, vo.getPrice());
			pstmt.setString(10, vo.getBreakfast_yn());
			pstmt.setInt(11, vo.getResv_seq());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int deleteBooking(int resv_seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM booking WHERE resv_seq=?";
		int result = -1;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, resv_seq);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	public List<BookingVO> getBookingList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BookingVO> bookingList = new ArrayList<BookingVO>();
		String sql = "SELECT * FROM booking ORDER BY resv_seq";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookingVO vo = new BookingVO();
				
				vo.setResv_seq(rs.getInt("resv_seq"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
				vo.setCheck_in(rs.getDate("check_in"));
				vo.setCheck_out(rs.getDate("check_out"));
				vo.setRoom_no(rs.getString("room_no"));
				vo.setAdult(rs.getInt("adult"));
				vo.setChildren(rs.getInt("children"));
				vo.setReserve_yn(rs.getString("reserve_yn"));
				vo.setPrice(rs.getInt("price"));
				vo.setBreakfast_yn(rs.getString("breakfast_yn"));
				
				bookingList.add(vo);
			}
			
			return bookingList;
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
	public BookingVO getBookingBySeq(int seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM booking WHERE resv_seq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				BookingVO vo = new BookingVO();
				
				vo.setResv_seq(rs.getInt("resv_seq"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
				vo.setCheck_in(rs.getDate("check_in"));
				vo.setCheck_out(rs.getDate("check_out"));
				vo.setRoom_no(rs.getString("room_no"));
				vo.setAdult(rs.getInt("adult"));
				vo.setChildren(rs.getInt("children"));
				vo.setReserve_yn(rs.getString("reserve_yn"));
				vo.setPrice(rs.getInt("price"));
				vo.setBreakfast_yn(rs.getString("breakfast_yn"));
				
				return vo;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
	private static java.sql.Date convertDate(java.util.Date uDate) {
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;
	}

}
