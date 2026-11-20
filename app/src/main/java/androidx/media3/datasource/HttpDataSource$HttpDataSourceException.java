package androidx.media3.datasource;

import coil3.util.LifecyclesKt;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class HttpDataSource$HttpDataSourceException extends DataSourceException {
    public final byte type;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public HttpDataSource$HttpDataSourceException(IOException iOException, int i, int i2) {
        if (i == 2000 && i2 == 1) {
            i = 2001;
        }
        super(iOException, i);
        this.type = i2;
    }

    public static HttpDataSource$HttpDataSourceException createForIOException(IOException iOException, int i) {
        int i2;
        String message = iOException.getMessage();
        if (iOException instanceof SocketTimeoutException) {
            i2 = 2002;
        } else if (iOException instanceof InterruptedIOException) {
            i2 = 1004;
        } else {
            i2 = (message == null || !LifecyclesKt.toLowerCase(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        }
        return i2 == 2007 ? new HttpDataSource$CleartextNotPermittedException("Cleartext HTTP traffic not permitted. See https://developer.android.com/guide/topics/media/issues/cleartext-not-permitted", iOException, 2007) : new HttpDataSource$HttpDataSourceException(iOException, i2, i);
    }

    public HttpDataSource$HttpDataSourceException(String str, int i) {
        super(str, i == 2000 ? 2001 : i);
        this.type = (byte) 1;
    }

    public HttpDataSource$HttpDataSourceException(int i) {
        super(i == 2000 ? 2001 : i);
        this.type = (byte) 1;
    }

    public HttpDataSource$HttpDataSourceException(String str, IOException iOException, int i) {
        super(str, iOException, i == 2000 ? 2001 : i);
        this.type = (byte) 1;
    }
}
