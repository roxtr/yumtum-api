/**
 * 
 */
package in.yumtum.api.service;

import in.yumtum.api.vo.RestaurantVO;
import in.yumtum.api.vo.ResultVO;

/**
 * @author hmakam
 *
 */
public interface RestaurantService {

	public ResultVO createRestaurant(RestaurantVO restVO);
	public ResultVO updateRestaurant(RestaurantVO restVO);
	public ResultVO checkRestaurant(RestaurantVO restVO);
	public ResultVO getRestaurantDetails(int restId);
	
}
