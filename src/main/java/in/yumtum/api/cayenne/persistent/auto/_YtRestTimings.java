package in.yumtum.api.cayenne.persistent.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;

import in.yumtum.api.cayenne.persistent.YtRestBooking;
import in.yumtum.api.cayenne.persistent.YtRestUser;

/**
 * Class _YtRestTimings was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _YtRestTimings extends CayenneDataObject {

    public static final String AVAILABLE_SEATS_PROPERTY = "availableSeats";
    public static final String RESERVE_TIME_PROPERTY = "reserveTime";
    public static final String REST_ID_PROPERTY = "restId";
    public static final String TIME_OF_DAY_PROPERTY = "timeOfDay";
    public static final String TIMING_ID_PROPERTY = "timingId";
    public static final String TOTAL_SEATS_PROPERTY = "totalSeats";
    public static final String TO_YT_REST_USER_PROPERTY = "toYtRestUser";
    public static final String YT_REST_BOOKING_ARRAY_PROPERTY = "ytRestBookingArray";

    public static final String TIMING_ID_PK_COLUMN = "timing_id";

    public void setAvailableSeats(String availableSeats) {
        writeProperty("availableSeats", availableSeats);
    }
    public String getAvailableSeats() {
        return (String)readProperty("availableSeats");
    }

    public void setReserveTime(String reserveTime) {
        writeProperty("reserveTime", reserveTime);
    }
    public String getReserveTime() {
        return (String)readProperty("reserveTime");
    }

    public void setRestId(Integer restId) {
        writeProperty("restId", restId);
    }
    public Integer getRestId() {
        return (Integer)readProperty("restId");
    }

    public void setTimeOfDay(String timeOfDay) {
        writeProperty("timeOfDay", timeOfDay);
    }
    public String getTimeOfDay() {
        return (String)readProperty("timeOfDay");
    }

    public void setTimingId(Integer timingId) {
        writeProperty("timingId", timingId);
    }
    public Integer getTimingId() {
        return (Integer)readProperty("timingId");
    }

    public void setTotalSeats(String totalSeats) {
        writeProperty("totalSeats", totalSeats);
    }
    public String getTotalSeats() {
        return (String)readProperty("totalSeats");
    }

    public void setToYtRestUser(YtRestUser toYtRestUser) {
        setToOneTarget("toYtRestUser", toYtRestUser, true);
    }

    public YtRestUser getToYtRestUser() {
        return (YtRestUser)readProperty("toYtRestUser");
    }


    public void addToYtRestBookingArray(YtRestBooking obj) {
        addToManyTarget("ytRestBookingArray", obj, true);
    }
    public void removeFromYtRestBookingArray(YtRestBooking obj) {
        removeToManyTarget("ytRestBookingArray", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<YtRestBooking> getYtRestBookingArray() {
        return (List<YtRestBooking>)readProperty("ytRestBookingArray");
    }


}
