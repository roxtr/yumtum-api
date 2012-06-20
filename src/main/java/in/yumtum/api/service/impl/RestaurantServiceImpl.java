package in.yumtum.api.service.impl;

import in.yumtum.api.service.RestaurantService;
import in.yumtum.api.vo.RestaurantVO;
import in.yumtum.api.vo.ResultVO;

public class RestaurantServiceImpl implements RestaurantService {

	public ResultVO createRestaurant(RestaurantVO restVO) {
		
		ResultVO result = checkRestaurant(restVO);
		
		return result;
	}

	public ResultVO deactivateRestaurant() {
		// TODO Auto-generated method stub
		return null;
	}

	public RestaurantVO getRestaurantDetails(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultVO updateRestaurant(RestaurantVO restVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultVO checkRestaurant(RestaurantVO restVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
