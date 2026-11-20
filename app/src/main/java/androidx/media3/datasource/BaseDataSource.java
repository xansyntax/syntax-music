package androidx.media3.datasource;

import android.os.SystemClock;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import coil3.util.UtilsKt;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseDataSource implements DataSource {
    public DataSpec dataSpec;
    public final boolean isNetwork;
    public int listenerCount;
    public final ArrayList listeners = new ArrayList(1);

    public BaseDataSource(boolean z) {
        this.isNetwork = z;
    }

    @Override // androidx.media3.datasource.DataSource
    public final void addTransferListener(DefaultBandwidthMeter defaultBandwidthMeter) {
        defaultBandwidthMeter.getClass();
        ArrayList arrayList = this.listeners;
        if (arrayList.contains(defaultBandwidthMeter)) {
            return;
        }
        arrayList.add(defaultBandwidthMeter);
        this.listenerCount++;
    }

    public final void bytesTransferred(int i) {
        boolean z;
        DataSpec dataSpec = this.dataSpec;
        String str = Util.DEVICE_DEBUG_INFO;
        for (int i2 = 0; i2 < this.listenerCount; i2++) {
            DefaultBandwidthMeter defaultBandwidthMeter = (DefaultBandwidthMeter) this.listeners.get(i2);
            boolean z2 = this.isNetwork;
            synchronized (defaultBandwidthMeter) {
                RegularImmutableList regularImmutableList = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI;
                if (z2) {
                    byte b = dataSpec.flags;
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    defaultBandwidthMeter.sampleBytesTransferred += (long) i;
                }
            }
        }
    }

    public final void transferEnded() {
        boolean z;
        DataSpec dataSpec = this.dataSpec;
        String str = Util.DEVICE_DEBUG_INFO;
        for (int i = 0; i < this.listenerCount; i++) {
            DefaultBandwidthMeter defaultBandwidthMeter = (DefaultBandwidthMeter) this.listeners.get(i);
            boolean z2 = this.isNetwork;
            synchronized (defaultBandwidthMeter) {
                try {
                    RegularImmutableList regularImmutableList = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI;
                    if (z2) {
                        byte b = dataSpec.flags;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        UtilsKt.checkState(defaultBandwidthMeter.streamCount > 0);
                        defaultBandwidthMeter.clock.getClass();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        int i2 = (int) (jElapsedRealtime - defaultBandwidthMeter.sampleStartTimeMs);
                        defaultBandwidthMeter.totalElapsedTimeMs += (long) i2;
                        long j = defaultBandwidthMeter.totalBytesTransferred;
                        long j2 = defaultBandwidthMeter.sampleBytesTransferred;
                        defaultBandwidthMeter.totalBytesTransferred = j + j2;
                        if (i2 > 0) {
                            defaultBandwidthMeter.slidingPercentile.addSample((int) Math.sqrt(j2), (j2 * 8000.0f) / i2);
                            if (defaultBandwidthMeter.totalElapsedTimeMs >= 2000 || defaultBandwidthMeter.totalBytesTransferred >= 524288) {
                                defaultBandwidthMeter.bitrateEstimate = (long) defaultBandwidthMeter.slidingPercentile.getPercentile();
                            }
                            defaultBandwidthMeter.maybeNotifyBandwidthSample(i2, defaultBandwidthMeter.sampleBytesTransferred, defaultBandwidthMeter.bitrateEstimate);
                            defaultBandwidthMeter.sampleStartTimeMs = jElapsedRealtime;
                            defaultBandwidthMeter.sampleBytesTransferred = 0L;
                        }
                        defaultBandwidthMeter.streamCount--;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.dataSpec = null;
    }

    public final void transferInitializing() {
        for (int i = 0; i < this.listenerCount; i++) {
            ((DefaultBandwidthMeter) this.listeners.get(i)).getClass();
        }
    }

    public final void transferStarted(DataSpec dataSpec) {
        boolean z;
        this.dataSpec = dataSpec;
        for (int i = 0; i < this.listenerCount; i++) {
            DefaultBandwidthMeter defaultBandwidthMeter = (DefaultBandwidthMeter) this.listeners.get(i);
            boolean z2 = this.isNetwork;
            synchronized (defaultBandwidthMeter) {
                try {
                    RegularImmutableList regularImmutableList = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI;
                    if (z2) {
                        byte b = dataSpec.flags;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (defaultBandwidthMeter.streamCount == 0) {
                            defaultBandwidthMeter.clock.getClass();
                            defaultBandwidthMeter.sampleStartTimeMs = SystemClock.elapsedRealtime();
                        }
                        defaultBandwidthMeter.streamCount++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
