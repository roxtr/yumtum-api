package in.yumtum.api.cayenne.persistent.auto;

import org.apache.cayenne.CayenneDataObject;

/**
 * Class _YtHCusines was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _YtHCusines extends CayenneDataObject {

    public static final String CUSINE_ID_PROPERTY = "cusineId";
    public static final String CUSINE_NAME_PROPERTY = "cusineName";

    public static final String CUSINE_ID_PK_COLUMN = "cusine_id";

    public void setCusineId(Integer cusineId) {
        writeProperty("cusineId", cusineId);
    }
    public Integer getCusineId() {
        return (Integer)readProperty("cusineId");
    }

    public void setCusineName(String cusineName) {
        writeProperty("cusineName", cusineName);
    }
    public String getCusineName() {
        return (String)readProperty("cusineName");
    }

}
