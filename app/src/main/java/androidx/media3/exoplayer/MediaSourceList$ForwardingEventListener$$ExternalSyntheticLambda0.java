package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.compose.animation.core.FloatTweenSpec;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSourceList$ForwardingEventListener$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f$0;
    public final /* synthetic */ Pair f$1;
    public final /* synthetic */ LoadEventInfo f$2;
    public final /* synthetic */ FloatTweenSpec f$3;

    public /* synthetic */ MediaSourceList$ForwardingEventListener$$ExternalSyntheticLambda0(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, LoadEventInfo loadEventInfo, FloatTweenSpec floatTweenSpec, byte b) {
        this.$r8$classId = b;
        this.f$0 = forwardingEventListener;
        this.f$1 = pair;
        this.f$2 = loadEventInfo;
        this.f$3 = floatTweenSpec;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        FloatTweenSpec floatTweenSpec = this.f$3;
        LoadEventInfo loadEventInfo = this.f$2;
        Pair pair = this.f$1;
        MediaSourceList.ForwardingEventListener forwardingEventListener = this.f$0;
        switch (b) {
            case 0:
                forwardingEventListener.this$0.eventListener.onLoadCanceled(((Integer) pair.first).intValue(), (MediaSource$MediaPeriodId) pair.second, loadEventInfo, floatTweenSpec);
                break;
            default:
                forwardingEventListener.this$0.eventListener.onLoadCompleted(((Integer) pair.first).intValue(), (MediaSource$MediaPeriodId) pair.second, loadEventInfo, floatTweenSpec);
                break;
        }
    }
}
