package androidx.media3.exoplayer;

import androidx.compose.ui.node.RulerTrackingMap;
import com.google.common.base.Function;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StreamVolumeManager$$ExternalSyntheticLambda6 implements Function {
    public final /* synthetic */ RulerTrackingMap f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ StreamVolumeManager$$ExternalSyntheticLambda6(RulerTrackingMap rulerTrackingMap, boolean z) {
        this.f$0 = rulerTrackingMap;
        this.f$1 = z;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        int i;
        StreamVolumeManager$StreamVolumeState streamVolumeManager$StreamVolumeState = (StreamVolumeManager$StreamVolumeState) obj;
        int i2 = streamVolumeManager$StreamVolumeState.streamType;
        boolean z = streamVolumeManager$StreamVolumeState.muted;
        boolean z2 = this.f$1;
        if (z == z2) {
            i = streamVolumeManager$StreamVolumeState.volume;
        } else {
            i = z2 ? 0 : this.f$0.size;
        }
        return new StreamVolumeManager$StreamVolumeState(z2, i2, i, streamVolumeManager$StreamVolumeState.minVolume, streamVolumeManager$StreamVolumeState.maxVolume);
    }
}
