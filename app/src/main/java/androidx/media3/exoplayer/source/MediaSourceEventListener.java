package androidx.media3.exoplayer.source;

import androidx.compose.animation.core.FloatTweenSpec;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface MediaSourceEventListener {
    void onDownstreamFormatChanged(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, FloatTweenSpec floatTweenSpec);

    void onLoadCanceled(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, LoadEventInfo loadEventInfo, FloatTweenSpec floatTweenSpec);

    void onLoadCompleted(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, LoadEventInfo loadEventInfo, FloatTweenSpec floatTweenSpec);

    void onLoadError(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, LoadEventInfo loadEventInfo, FloatTweenSpec floatTweenSpec, IOException iOException, boolean z);

    void onLoadStarted(int i, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, LoadEventInfo loadEventInfo, FloatTweenSpec floatTweenSpec, int i2);
}
