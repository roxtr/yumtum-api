/**
 * 
 */
package in.yumtum.api.vo;

import in.yumtum.api.cayenne.persistent.YtRestUser;

/**
 * @author hmakam
 *
 */
public class RestaurantVO {

    private String acceptCC;
    private boolean active;
    private String address;
    private String avgCostForTwo;
    private String city;
    private String cusines;
    private boolean hasAC;
    private boolean hasWifi;
    private boolean isVeg;
    private String latitude;
    private String locality;
    private String longitude;
    private String name;
    private String nfsPhone;
    private String phones;
    private String restId;
    private String timings;
    private YtRestUser toYtRestUser;
    
	public String getAcceptCC() {
		return acceptCC;
	}
	public void setAcceptCC(String acceptCC) {
		this.acceptCC = acceptCC;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAvgCostForTwo() {
		return avgCostForTwo;
	}
	public void setAvgCostForTwo(String avgCostForTwo) {
		this.avgCostForTwo = avgCostForTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCusines() {
		return cusines;
	}
	public void setCusines(String cusines) {
		this.cusines = cusines;
	}
	public boolean isHasAC() {
		return hasAC;
	}
	public void setHasAC(boolean hasAC) {
		this.hasAC = hasAC;
	}
	public boolean isHasWifi() {
		return hasWifi;
	}
	public void setHasWifi(boolean hasWifi) {
		this.hasWifi = hasWifi;
	}
	public boolean isVeg() {
		return isVeg;
	}
	public void setVeg(boolean isVeg) {
		this.isVeg = isVeg;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNfsPhone() {
		return nfsPhone;
	}
	public void setNfsPhone(String nfsPhone) {
		this.nfsPhone = nfsPhone;
	}
	public String getPhones() {
		return phones;
	}
	public void setPhones(String phones) {
		this.phones = phones;
	}
	public String getRestId() {
		return restId;
	}
	public void setRestId(String restId) {
		this.restId = restId;
	}
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
	}
	public YtRestUser getToYtRestUser() {
		return toYtRestUser;
	}
	public void setToYtRestUser(YtRestUser toYtRestUser) {
		this.toYtRestUser = toYtRestUser;
	}
	
}
