package androidx.media3.exoplayer;

import android.media.AudioManager;
import androidx.compose.ui.node.RulerTrackingMap;
import com.google.common.base.Function;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StreamVolumeManager$$ExternalSyntheticLambda3 implements Function {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ RulerTrackingMap f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ StreamVolumeManager$$ExternalSyntheticLambda3(RulerTrackingMap rulerTrackingMap, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = rulerTrackingMap;
        this.f$1 = i;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        byte b = this.$r8$classId;
        int i = this.f$1;
        RulerTrackingMap rulerTrackingMap = this.f$0;
        StreamVolumeManager$StreamVolumeState streamVolumeManager$StreamVolumeState = (StreamVolumeManager$StreamVolumeState) obj;
        switch (b) {
            case 0:
                int i2 = streamVolumeManager$StreamVolumeState.volume;
                int i3 = streamVolumeManager$StreamVolumeState.streamType;
                if (i2 <= streamVolumeManager$StreamVolumeState.minVolume) {
                    return streamVolumeManager$StreamVolumeState;
                }
                AudioManager audioManager = (AudioManager) rulerTrackingMap.layoutNodes;
                audioManager.getClass();
                audioManager.adjustStreamVolume(i3, -1, i);
                return rulerTrackingMap.generateState(i3);
            case 1:
                rulerTrackingMap.getClass();
                return streamVolumeManager$StreamVolumeState.streamType == i ? streamVolumeManager$StreamVolumeState : rulerTrackingMap.generateState(i);
            default:
                int i4 = streamVolumeManager$StreamVolumeState.volume;
                int i5 = streamVolumeManager$StreamVolumeState.streamType;
                if (i4 >= streamVolumeManager$StreamVolumeState.maxVolume) {
                    return streamVolumeManager$StreamVolumeState;
                }
                AudioManager audioManager2 = (AudioManager) rulerTrackingMap.layoutNodes;
                audioManager2.getClass();
                audioManager2.adjustStreamVolume(i5, 1, i);
                return rulerTrackingMap.generateState(i5);
        }
    }
}
