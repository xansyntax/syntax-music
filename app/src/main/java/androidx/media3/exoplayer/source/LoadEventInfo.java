package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.datasource.DataSpec;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LoadEventInfo {
    public static final AtomicLong idSource = new AtomicLong();
    public final long bytesLoaded;
    public final DataSpec dataSpec;
    public final long elapsedRealtimeMs;
    public final Map responseHeaders;
    public final Uri uri;

    public LoadEventInfo(DataSpec dataSpec, Uri uri, Map map, long j, long j2) {
        this.dataSpec = dataSpec;
        this.uri = uri;
        this.responseHeaders = map;
        this.elapsedRealtimeMs = j;
        this.bytesLoaded = j2;
    }

    public LoadEventInfo(DataSpec dataSpec, long j) {
        this(dataSpec, dataSpec.uri, Collections.EMPTY_MAP, j, 0L);
    }
}
