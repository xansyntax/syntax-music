package androidx.media3.exoplayer.source;

import androidx.compose.animation.core.FloatTweenSpec;
import androidx.media3.common.util.Consumer;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda1 implements Consumer {
    public final /* synthetic */ StatusLine f$0;
    public final /* synthetic */ LoadEventInfo f$1;
    public final /* synthetic */ FloatTweenSpec f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda1(StatusLine statusLine, LoadEventInfo loadEventInfo, FloatTweenSpec floatTweenSpec, int i) {
        this.f$0 = statusLine;
        this.f$1 = loadEventInfo;
        this.f$2 = floatTweenSpec;
        this.f$3 = i;
    }

    @Override // androidx.media3.common.util.Consumer
    public final void accept(Object obj) {
        MediaSourceEventListener mediaSourceEventListener = (MediaSourceEventListener) obj;
        StatusLine statusLine = this.f$0;
        mediaSourceEventListener.onLoadStarted(statusLine.code, (MediaSource$MediaPeriodId) statusLine.protocol, this.f$1, this.f$2, this.f$3);
    }
}
