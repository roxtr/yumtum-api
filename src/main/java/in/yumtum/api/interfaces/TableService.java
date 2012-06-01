package in.yumtum.api.interfaces;

import in.yumtum.api.vo.ResultVO;

public interface TableService {

	public ResultVO getTableInfo();
	public ResultVO bookTable();
	public ResultVO deleteReservation();
	
}
