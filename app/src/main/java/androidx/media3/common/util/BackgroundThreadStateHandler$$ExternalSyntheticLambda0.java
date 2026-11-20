package androidx.media3.common.util;

import androidx.compose.ui.node.RulerTrackingMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BackgroundThreadStateHandler$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ RulerTrackingMap f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ BackgroundThreadStateHandler$$ExternalSyntheticLambda0(RulerTrackingMap rulerTrackingMap, Object obj, byte b) {
        this.$r8$classId = b;
        this.f$0 = rulerTrackingMap;
        this.f$1 = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        Object obj = this.f$1;
        RulerTrackingMap rulerTrackingMap = this.f$0;
        switch (b) {
            case 0:
                if (rulerTrackingMap.size == 0) {
                    rulerTrackingMap.updateStateInForeground(obj);
                }
                break;
            default:
                int i = rulerTrackingMap.size - 1;
                rulerTrackingMap.size = i;
                if (i == 0) {
                    rulerTrackingMap.updateStateInForeground(obj);
                }
                break;
        }
    }
}
