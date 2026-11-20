package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.cache.CacheDataSink;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class TeeDataSource implements DataSource {
    public long bytesRemaining;
    public final CacheDataSink dataSink;
    public boolean dataSinkNeedsClosing;
    public final DataSource upstream;

    public TeeDataSource(DataSource dataSource, CacheDataSink cacheDataSink) {
        dataSource.getClass();
        this.upstream = dataSource;
        cacheDataSink.getClass();
        this.dataSink = cacheDataSink;
    }

    @Override // androidx.media3.datasource.DataSource
    public final void addTransferListener(DefaultBandwidthMeter defaultBandwidthMeter) {
        defaultBandwidthMeter.getClass();
        this.upstream.addTransferListener(defaultBandwidthMeter);
    }

    @Override // androidx.media3.datasource.DataSource
    public final void close() throws CacheDataSink.CacheDataSinkException {
        CacheDataSink cacheDataSink = this.dataSink;
        try {
            this.upstream.close();
            if (this.dataSinkNeedsClosing) {
                this.dataSinkNeedsClosing = false;
                if (cacheDataSink.dataSpec == null) {
                    return;
                }
                try {
                    cacheDataSink.closeCurrentOutputStream();
                } catch (IOException e) {
                    throw new CacheDataSink.CacheDataSinkException(e);
                }
            }
        } catch (Throwable th) {
            if (this.dataSinkNeedsClosing) {
                this.dataSinkNeedsClosing = false;
                if (cacheDataSink.dataSpec != null) {
                    try {
                        cacheDataSink.closeCurrentOutputStream();
                    } catch (IOException e2) {
                        throw new CacheDataSink.CacheDataSinkException(e2);
                    }
                }
            }
            throw th;
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public final Map getResponseHeaders() {
        return this.upstream.getResponseHeaders();
    }

    @Override // androidx.media3.datasource.DataSource
    public final Uri getUri() {
        return this.upstream.getUri();
    }

    @Override // androidx.media3.datasource.DataSource
    public final long open(DataSpec dataSpec) throws CacheDataSink.CacheDataSinkException {
        long jOpen = this.upstream.open(dataSpec);
        this.bytesRemaining = jOpen;
        if (jOpen == 0) {
            return 0L;
        }
        if (dataSpec.length == -1 && jOpen != -1) {
            dataSpec = dataSpec.subrange(jOpen);
        }
        byte b = dataSpec.flags;
        this.dataSinkNeedsClosing = true;
        CacheDataSink cacheDataSink = this.dataSink;
        cacheDataSink.getClass();
        dataSpec.key.getClass();
        if (dataSpec.length == -1 && (b & 2) == 2) {
            cacheDataSink.dataSpec = null;
        } else {
            cacheDataSink.dataSpec = dataSpec;
            cacheDataSink.dataSpecFragmentSize = (b & 4) == 4 ? cacheDataSink.fragmentSize : Long.MAX_VALUE;
            cacheDataSink.dataSpecBytesWritten = 0L;
            try {
                cacheDataSink.openNextOutputStream(dataSpec);
            } catch (IOException e) {
                throw new CacheDataSink.CacheDataSinkException(e);
            }
        }
        return this.bytesRemaining;
    }

    @Override // androidx.media3.common.DataReader
    public final int read(byte[] bArr, int i, int i2) throws CacheDataSink.CacheDataSinkException {
        if (this.bytesRemaining == 0) {
            return -1;
        }
        int i3 = this.upstream.read(bArr, i, i2);
        if (i3 > 0) {
            CacheDataSink cacheDataSink = this.dataSink;
            DataSpec dataSpec = cacheDataSink.dataSpec;
            if (dataSpec != null) {
                int i4 = 0;
                while (i4 < i3) {
                    try {
                        if (cacheDataSink.outputStreamBytesWritten == cacheDataSink.dataSpecFragmentSize) {
                            cacheDataSink.closeCurrentOutputStream();
                            cacheDataSink.openNextOutputStream(dataSpec);
                        }
                        int iMin = (int) Math.min(i3 - i4, cacheDataSink.dataSpecFragmentSize - cacheDataSink.outputStreamBytesWritten);
                        OutputStream outputStream = cacheDataSink.outputStream;
                        String str = Util.DEVICE_DEBUG_INFO;
                        outputStream.write(bArr, i + i4, iMin);
                        i4 += iMin;
                        long j = iMin;
                        cacheDataSink.outputStreamBytesWritten += j;
                        cacheDataSink.dataSpecBytesWritten += j;
                    } catch (IOException e) {
                        throw new CacheDataSink.CacheDataSinkException(e);
                    }
                }
            }
            long j2 = this.bytesRemaining;
            if (j2 != -1) {
                this.bytesRemaining = j2 - ((long) i3);
            }
        }
        return i3;
    }
}
