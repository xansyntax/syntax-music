package androidx.media3.exoplayer.drm;

import android.net.Uri;
import androidx.media3.datasource.DataSpec;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaDrmCallbackException extends IOException {
    public final long bytesLoaded;
    public final DataSpec dataSpec;
    public final Map responseHeaders;
    public final Uri uriAfterRedirects;

    public MediaDrmCallbackException(DataSpec dataSpec, Uri uri, Map map, long j, Exception exc) {
        super(exc);
        this.dataSpec = dataSpec;
        this.uriAfterRedirects = uri;
        this.responseHeaders = map;
        this.bytesLoaded = j;
    }
}
