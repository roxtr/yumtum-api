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

    private Integer acceptCC;
    private Integer active;
    private String address;
    private Integer avgCostForTwo;
    private String city;
    private String cusines;
    private Integer hasAC;
    private Integer hasWifi;
    private Integer isVeg;
    private String latitude;
    private String locality;
    private String longitude;
    private String name;
    private String nfsPhone;
    private String phones;
    private Integer restId;
    private String timings;
    private Integer rest_createdBy;
    
	public Integer getAcceptCC() {
		return acceptCC;
	}
	public void setAcceptCC(Integer acceptCC) {
		this.acceptCC = acceptCC;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getAvgCostForTwo() {
		return avgCostForTwo;
	}
	public void setAvgCostForTwo(Integer avgCostForTwo) {
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
	public Integer getHasAC() {
		return hasAC;
	}
	public void setHasAC(Integer hasAC) {
		this.hasAC = hasAC;
	}
	public Integer getHasWifi() {
		return hasWifi;
	}
	public void setHasWifi(Integer hasWifi) {
		this.hasWifi = hasWifi;
	}
	public Integer getIsVeg() {
		return isVeg;
	}
	public void setVeg(Integer isVeg) {
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
	public Integer getRestId() {
		return restId;
	}
	public void setRestId(Integer restId) {
		this.restId = restId;
	}
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
	}
	public Integer getRest_createdBy() {
		return rest_createdBy;
	}
	public void setRest_createdBy(Integer rest_createdBy) {
		this.rest_createdBy = rest_createdBy;
	}
	
}
