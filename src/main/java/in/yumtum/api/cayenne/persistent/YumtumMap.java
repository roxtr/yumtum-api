package in.yumtum.api.cayenne.persistent;

import in.yumtum.api.cayenne.persistent.auto._YumtumMap;

public class YumtumMap extends _YumtumMap {

    private static YumtumMap instance;

    private YumtumMap() {}

    public static YumtumMap getInstance() {
        if(instance == null) {
            instance = new YumtumMap();
        }

        return instance;
    }
}
