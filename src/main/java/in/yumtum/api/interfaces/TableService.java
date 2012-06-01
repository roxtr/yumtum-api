package in.yumtum.api.interfaces;

import in.yumtum.api.vo.Result;

public interface TableService {

	public Result getTableInfo();
	public Result bookTable();
	public Result deleteReservation();
	
}
