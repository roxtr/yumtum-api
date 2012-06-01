/**
 * 
 */
package in.yumtum.api.interfaces;

import in.yumtum.api.vo.Restaurant;
import in.yumtum.api.vo.Result;

/**
 * @author hmakam
 *
 */
public interface RestaurantService {

	public Result createRestaurant();
	public Result updateRestaurant();
	public Result deactivateRestaurant();
	public Restaurant getRestaurantDetails(String id);
	
}
