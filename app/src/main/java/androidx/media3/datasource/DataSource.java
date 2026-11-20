package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.DataReader;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface DataSource extends DataReader {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Factory {
        DataSource createDataSource();
    }

    void addTransferListener(DefaultBandwidthMeter defaultBandwidthMeter);

    void close();

    default Map getResponseHeaders() {
        return Collections.EMPTY_MAP;
    }

    Uri getUri();

    long open(DataSpec dataSpec);
}
