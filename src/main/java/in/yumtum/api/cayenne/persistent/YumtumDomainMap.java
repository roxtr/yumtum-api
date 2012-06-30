package in.yumtum.api.cayenne.persistent;

import in.yumtum.api.cayenne.persistent.auto._YumtumDomainMap;

public class YumtumDomainMap extends _YumtumDomainMap {

    private static YumtumDomainMap instance;

    private YumtumDomainMap() {}

    public static YumtumDomainMap getInstance() {
        if(instance == null) {
            instance = new YumtumDomainMap();
        }

        return instance;
    }
}
