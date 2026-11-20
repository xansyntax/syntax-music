package androidx.media3.exoplayer;

import android.media.AudioManager;
import androidx.compose.ui.node.RulerTrackingMap;
import com.google.common.base.Function;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StreamVolumeManager$$ExternalSyntheticLambda7 implements Function {
    public final /* synthetic */ RulerTrackingMap f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ StreamVolumeManager$$ExternalSyntheticLambda7(RulerTrackingMap rulerTrackingMap, boolean z, int i) {
        this.f$0 = rulerTrackingMap;
        this.f$1 = z;
        this.f$2 = i;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        StreamVolumeManager$StreamVolumeState streamVolumeManager$StreamVolumeState = (StreamVolumeManager$StreamVolumeState) obj;
        boolean z = streamVolumeManager$StreamVolumeState.muted;
        int i = streamVolumeManager$StreamVolumeState.streamType;
        boolean z2 = this.f$1;
        if (z == z2) {
            return streamVolumeManager$StreamVolumeState;
        }
        RulerTrackingMap rulerTrackingMap = this.f$0;
        ((AudioManager) rulerTrackingMap.layoutNodes).getClass();
        ((AudioManager) rulerTrackingMap.layoutNodes).adjustStreamVolume(i, z2 ? -100 : 100, this.f$2);
        return rulerTrackingMap.generateState(i);
    }
}
