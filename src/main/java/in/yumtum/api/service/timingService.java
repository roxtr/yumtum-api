package in.yumtum.api.service;

import in.yumtum.api.vo.ResultVO;
import in.yumtum.api.vo.TimingVO;

public interface timingService {
	
	public ResultVO addRestaurantTiming(TimingVO timingVO);
	public ResultVO deleteRestaurantTiming(Integer timingId);
    public ResultVO updateRestaurantTiming(TimingVO timingVO);
    public ResultVO checkRestaurantTiming(TimingVO timingVO);
    public ResultVO getRestaurantTimings(TimingVO timingVO);
}
