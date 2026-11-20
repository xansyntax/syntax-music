package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StatsDataSource implements DataSource {
    public long bytesRead;
    public final DataSource dataSource;
    public Uri lastOpenedUri;
    public Map lastResponseHeaders;

    public StatsDataSource(DataSource dataSource) {
        dataSource.getClass();
        this.dataSource = dataSource;
        this.lastOpenedUri = Uri.EMPTY;
        this.lastResponseHeaders = Collections.EMPTY_MAP;
    }

    @Override // androidx.media3.datasource.DataSource
    public final void addTransferListener(DefaultBandwidthMeter defaultBandwidthMeter) {
        defaultBandwidthMeter.getClass();
        this.dataSource.addTransferListener(defaultBandwidthMeter);
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        this.dataSource.close();
    }

    @Override // androidx.media3.datasource.DataSource
    public final Map getResponseHeaders() {
        return this.dataSource.getResponseHeaders();
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri getUri() {
        return this.dataSource.getUri();
    }

    @Override // androidx.media3.datasource.DataSource
    public final long open(DataSpec dataSpec) {
        DataSource dataSource = this.dataSource;
        this.lastOpenedUri = dataSpec.uri;
        this.lastResponseHeaders = Collections.EMPTY_MAP;
        try {
            return dataSource.open(dataSpec);
        } finally {
            Uri uri = dataSource.getUri();
            if (uri != null) {
                this.lastOpenedUri = uri;
            }
            this.lastResponseHeaders = dataSource.getResponseHeaders();
        }
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i, int i2) {
        int i3 = this.dataSource.read(bArr, i, i2);
        if (i3 != -1) {
            this.bytesRead += (long) i3;
        }
        return i3;
    }
}
