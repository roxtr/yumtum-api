package in.yumtum.api.service;

import in.yumtum.api.vo.BookingVO;
import in.yumtum.api.vo.ResultVO;

public interface BookingService {
	public ResultVO createBooking(BookingVO bookingVO);
	public ResultVO updateBooking(BookingVO bookingVO);
	public ResultVO deleteBooking(Integer bookingId);
	public ResultVO checkBooking(BookingVO bookingVO);
	public boolean checkAvailability(BookingVO bookingVO);
}