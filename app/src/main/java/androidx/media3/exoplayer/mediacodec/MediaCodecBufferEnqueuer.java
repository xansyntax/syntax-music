package androidx.media3.exoplayer.mediacodec;

import android.os.Bundle;
import androidx.media3.decoder.CryptoInfo;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface MediaCodecBufferEnqueuer {
    void flush();

    void maybeThrowException();

    void queueInputBuffer(int i, int i2, int i3, long j);

    void queueSecureInputBuffer(int i, CryptoInfo cryptoInfo, long j, int i2);

    void setParameters(Bundle bundle);

    void shutdown();

    void start();
}
