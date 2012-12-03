package in.yumtum.api.cayenne.persistent.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;

import in.yumtum.api.cayenne.persistent.YtRestTimings;
import in.yumtum.api.cayenne.persistent.YtRestaurants;

/**
 * Class _YtRestUser was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _YtRestUser extends CayenneDataObject {

    public static final String ADDRESS_PROPERTY = "address";
    public static final String ADMIN_PROPERTY = "admin";
    public static final String CITY_PROPERTY = "city";
    public static final String EMAIL_PROPERTY = "email";
    public static final String F_NAME_PROPERTY = "fName";
    public static final String L_NAME_PROPERTY = "lName";
    public static final String LOCALITY_PROPERTY = "locality";
    public static final String NAME_PROPERTY = "name";
    public static final String PASSWORD_PROPERTY = "password";
    public static final String PHONE_PROPERTY = "phone";
    public static final String RESTAURANT_CREATE_PROPERTY = "restaurantCreate";
    public static final String RESTAURANTS_ACCESS_PROPERTY = "restaurantsAccess";
    public static final String RESTAURANTS_OWNED_PROPERTY = "restaurantsOwned";
    public static final String USER_ID_PROPERTY = "userId";
    public static final String YT_REST_TIMINGS_ARRAY_PROPERTY = "ytRestTimingsArray";
    public static final String YT_RESTAURANTS_ARRAY_PROPERTY = "ytRestaurantsArray";

    public static final String USER_ID_PK_COLUMN = "user_id";

    public void setAddress(String address) {
        writeProperty("address", address);
    }
    public String getAddress() {
        return (String)readProperty("address");
    }

    public void setAdmin(Boolean admin) {
        writeProperty("admin", admin);
    }
    public Boolean getAdmin() {
        return (Boolean)readProperty("admin");
    }

    public void setCity(String city) {
        writeProperty("city", city);
    }
    public String getCity() {
        return (String)readProperty("city");
    }

    public void setEmail(String email) {
        writeProperty("email", email);
    }
    public String getEmail() {
        return (String)readProperty("email");
    }

    public void setFName(String fName) {
        writeProperty("fName", fName);
    }
    public String getFName() {
        return (String)readProperty("fName");
    }

    public void setLName(String lName) {
        writeProperty("lName", lName);
    }
    public String getLName() {
        return (String)readProperty("lName");
    }

    public void setLocality(String locality) {
        writeProperty("locality", locality);
    }
    public String getLocality() {
        return (String)readProperty("locality");
    }

    public void setName(String name) {
        writeProperty("name", name);
    }
    public String getName() {
        return (String)readProperty("name");
    }

    public void setPassword(String password) {
        writeProperty("password", password);
    }
    public String getPassword() {
        return (String)readProperty("password");
    }

    public void setPhone(String phone) {
        writeProperty("phone", phone);
    }
    public String getPhone() {
        return (String)readProperty("phone");
    }

    public void setRestaurantCreate(Boolean restaurantCreate) {
        writeProperty("restaurantCreate", restaurantCreate);
    }
    public Boolean getRestaurantCreate() {
        return (Boolean)readProperty("restaurantCreate");
    }

    public void setRestaurantsAccess(String restaurantsAccess) {
        writeProperty("restaurantsAccess", restaurantsAccess);
    }
    public String getRestaurantsAccess() {
        return (String)readProperty("restaurantsAccess");
    }

    public void setRestaurantsOwned(String restaurantsOwned) {
        writeProperty("restaurantsOwned", restaurantsOwned);
    }
    public String getRestaurantsOwned() {
        return (String)readProperty("restaurantsOwned");
    }

    public void setUserId(Integer userId) {
        writeProperty("userId", userId);
    }
    public Integer getUserId() {
        return (Integer)readProperty("userId");
    }

    public void addToYtRestTimingsArray(YtRestTimings obj) {
        addToManyTarget("ytRestTimingsArray", obj, true);
    }
    public void removeFromYtRestTimingsArray(YtRestTimings obj) {
        removeToManyTarget("ytRestTimingsArray", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<YtRestTimings> getYtRestTimingsArray() {
        return (List<YtRestTimings>)readProperty("ytRestTimingsArray");
    }


    public void addToYtRestaurantsArray(YtRestaurants obj) {
        addToManyTarget("ytRestaurantsArray", obj, true);
    }
    public void removeFromYtRestaurantsArray(YtRestaurants obj) {
        removeToManyTarget("ytRestaurantsArray", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<YtRestaurants> getYtRestaurantsArray() {
        return (List<YtRestaurants>)readProperty("ytRestaurantsArray");
    }


}
