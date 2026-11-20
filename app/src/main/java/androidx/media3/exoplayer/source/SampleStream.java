package androidx.media3.exoplayer.source;

import androidx.compose.ui.platform.WeakCache;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface SampleStream {
    boolean isReady();

    void maybeThrowError();

    int readData(WeakCache weakCache, DecoderInputBuffer decoderInputBuffer, int i);

    int skipData(long j);
}
