/**
 * 
 */
package in.yumtum.api.interfaces;

import in.yumtum.api.vo.RestaurantVO;
import in.yumtum.api.vo.ResultVO;

/**
 * @author hmakam
 *
 */
public interface RestaurantService {

	public ResultVO createRestaurant();
	public ResultVO updateRestaurant();
	public ResultVO deactivateRestaurant();
	public RestaurantVO getRestaurantDetails(String id);
	
}
