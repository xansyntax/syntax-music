package androidx.media3.datasource;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class HttpDataSource$InvalidResponseCodeException extends HttpDataSource$HttpDataSourceException {
    public final Map headerFields;
    public final int responseCode;

    public HttpDataSource$InvalidResponseCodeException(int i, DataSourceException dataSourceException, Map map) {
        super(IntIntPair$$ExternalSyntheticOutline0.m(i, "Response code: "), dataSourceException, 2004);
        this.responseCode = i;
        this.headerFields = map;
    }
}
