package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ResolvingDataSource implements DataSource {
    public final Resolver resolver;
    public final DataSource upstreamDataSource;
    public boolean upstreamOpened;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Resolver {
        DataSpec resolveDataSpec(DataSpec dataSpec);
    }

    public ResolvingDataSource(DataSource dataSource, Resolver resolver) {
        this.upstreamDataSource = dataSource;
        this.resolver = resolver;
    }

    @Override // androidx.media3.datasource.DataSource
    public final void addTransferListener(DefaultBandwidthMeter defaultBandwidthMeter) {
        defaultBandwidthMeter.getClass();
        this.upstreamDataSource.addTransferListener(defaultBandwidthMeter);
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
        if (this.upstreamOpened) {
            this.upstreamOpened = false;
            this.upstreamDataSource.close();
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final Map getResponseHeaders() {
        return this.upstreamDataSource.getResponseHeaders();
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri getUri() {
        Uri uri = this.upstreamDataSource.getUri();
        if (uri == null) {
            return null;
        }
        return uri;
    }

    @Override // androidx.media3.datasource.DataSource
    public final long open(DataSpec dataSpec) {
        DataSpec dataSpecResolveDataSpec = this.resolver.resolveDataSpec(dataSpec);
        this.upstreamOpened = true;
        return this.upstreamDataSource.open(dataSpecResolveDataSpec);
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i, int i2) {
        return this.upstreamDataSource.read(bArr, i, i2);
    }
}
