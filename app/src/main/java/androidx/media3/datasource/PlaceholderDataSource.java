package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaceholderDataSource implements DataSource {
    public static final PlaceholderDataSource INSTANCE = new PlaceholderDataSource();

    @Override // androidx.media3.datasource.DataSource
    public final Uri getUri() {
        return null;
    }

    @Override // androidx.media3.datasource.DataSource
    public final long open(DataSpec dataSpec) throws IOException {
        throw new IOException("PlaceholderDataSource cannot be opened");
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() {
    }

    @Override // androidx.media3.datasource.DataSource
    public final void addTransferListener(DefaultBandwidthMeter defaultBandwidthMeter) {
    }
}
