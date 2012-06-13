package in.yumtum.api.service;

import in.yumtum.api.vo.ResultVO;

public interface TableService {

	public ResultVO getTableInfo();
	public ResultVO bookTable();
	public ResultVO deleteReservation();
	
}
