package androidx.media3.datasource;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class DataSourceException extends IOException {
    public final int reason;

    public DataSourceException(int i) {
        this.reason = i;
    }

    public DataSourceException(Exception exc, int i) {
        super(exc);
        this.reason = i;
    }

    public DataSourceException(String str, int i) {
        super(str);
        this.reason = i;
    }

    public DataSourceException(String str, Exception exc, int i) {
        super(str, exc);
        this.reason = i;
    }
}
