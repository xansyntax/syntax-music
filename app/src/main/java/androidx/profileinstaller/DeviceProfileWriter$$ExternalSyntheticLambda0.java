package androidx.profileinstaller;

import android.util.Pair;
import androidx.compose.foundation.text.TextDelegate;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.MediaSource$MediaPeriodId;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DeviceProfileWriter$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ byte f$1;
    public final /* synthetic */ Object f$2;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ DeviceProfileWriter$$ExternalSyntheticLambda0(TextDelegate textDelegate, int i, Object obj) {
        this.$r8$classId = (byte) 0;
        this.f$0 = textDelegate;
        this.f$1 = i;
        this.f$2 = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        byte b2 = this.f$1;
        Object obj = this.f$2;
        Object obj2 = this.f$0;
        switch (b) {
            case 0:
                ((ProfileInstaller$DiagnosticsCallback) ((TextDelegate) obj2).style).onResultReceived(b2, obj);
                break;
            case 1:
                Pair pair = (Pair) obj;
                ((MediaSourceList.ForwardingEventListener) obj2).this$0.eventListener.onDrmSessionAcquired(((Integer) pair.first).intValue(), (MediaSource$MediaPeriodId) pair.second, b2);
                break;
            default:
                DrmSessionEventListener.EventDispatcher eventDispatcher = (DrmSessionEventListener.EventDispatcher) obj2;
                ((DrmSessionEventListener) obj).onDrmSessionAcquired(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId, b2);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ DeviceProfileWriter$$ExternalSyntheticLambda0(Object obj, Object obj2, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$2 = obj2;
        this.f$1 = i;
    }
}
