package androidx.media3.exoplayer;

import android.media.AudioManager;
import androidx.compose.ui.node.RulerTrackingMap;
import com.google.common.base.Function;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StreamVolumeManager$$ExternalSyntheticLambda5 implements Function {
    public final /* synthetic */ RulerTrackingMap f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ StreamVolumeManager$$ExternalSyntheticLambda5(RulerTrackingMap rulerTrackingMap, int i, int i2) {
        this.f$0 = rulerTrackingMap;
        this.f$1 = i;
        this.f$2 = i2;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        StreamVolumeManager$StreamVolumeState streamVolumeManager$StreamVolumeState = (StreamVolumeManager$StreamVolumeState) obj;
        int i = streamVolumeManager$StreamVolumeState.volume;
        int i2 = streamVolumeManager$StreamVolumeState.streamType;
        int i3 = this.f$1;
        if (i3 == i || i3 < streamVolumeManager$StreamVolumeState.minVolume || i3 > streamVolumeManager$StreamVolumeState.maxVolume) {
            return streamVolumeManager$StreamVolumeState;
        }
        RulerTrackingMap rulerTrackingMap = this.f$0;
        AudioManager audioManager = (AudioManager) rulerTrackingMap.layoutNodes;
        audioManager.getClass();
        audioManager.setStreamVolume(i2, i3, this.f$2);
        return rulerTrackingMap.generateState(i2);
    }
}
