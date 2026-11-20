package androidx.media3.exoplayer.source;

import androidx.compose.animation.core.FloatTweenSpec;
import androidx.media3.common.util.Consumer;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda2 implements Consumer {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ StatusLine f$0;
    public final /* synthetic */ LoadEventInfo f$1;
    public final /* synthetic */ FloatTweenSpec f$2;

    public /* synthetic */ MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda2(StatusLine statusLine, LoadEventInfo loadEventInfo, FloatTweenSpec floatTweenSpec, byte b) {
        this.$r8$classId = b;
        this.f$0 = statusLine;
        this.f$1 = loadEventInfo;
        this.f$2 = floatTweenSpec;
    }

    @Override // androidx.media3.common.util.Consumer
    public final void accept(Object obj) {
        byte b = this.$r8$classId;
        FloatTweenSpec floatTweenSpec = this.f$2;
        LoadEventInfo loadEventInfo = this.f$1;
        StatusLine statusLine = this.f$0;
        MediaSourceEventListener mediaSourceEventListener = (MediaSourceEventListener) obj;
        switch (b) {
            case 0:
                mediaSourceEventListener.onLoadCompleted(statusLine.code, (MediaSource$MediaPeriodId) statusLine.protocol, loadEventInfo, floatTweenSpec);
                break;
            default:
                mediaSourceEventListener.onLoadCanceled(statusLine.code, (MediaSource$MediaPeriodId) statusLine.protocol, loadEventInfo, floatTweenSpec);
                break;
        }
    }
}
