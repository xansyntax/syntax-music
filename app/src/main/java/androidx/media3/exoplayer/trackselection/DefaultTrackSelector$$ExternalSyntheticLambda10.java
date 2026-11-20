package androidx.media3.exoplayer.trackselection;

import android.os.Build;
import androidx.media3.common.Format;
import androidx.media3.exoplayer.util.SpatializerWrapper;
import com.google.common.base.Predicate;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DefaultTrackSelector$$ExternalSyntheticLambda10 implements Predicate {
    public final /* synthetic */ DefaultTrackSelector f$0;
    public final /* synthetic */ DefaultTrackSelector.Parameters f$1;

    public /* synthetic */ DefaultTrackSelector$$ExternalSyntheticLambda10(DefaultTrackSelector defaultTrackSelector, DefaultTrackSelector.Parameters parameters) {
        this.f$0 = defaultTrackSelector;
        this.f$1 = parameters;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x006b A[FALL_THROUGH] */
    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        Boolean bool;
        SpatializerWrapper spatializerWrapper;
        SpatializerWrapper spatializerWrapper2;
        Format format = (Format) obj;
        DefaultTrackSelector defaultTrackSelector = this.f$0;
        defaultTrackSelector.getClass();
        if (this.f$1.constrainAudioChannelCountToDeviceCapabilities && ((bool = defaultTrackSelector.deviceIsTV) == null || !bool.booleanValue())) {
            int i = format.channelCount;
            if (i != -1 && i > 2) {
                String str = format.sampleMimeType;
                if (str != null) {
                    switch (str) {
                        case "audio/eac3-joc":
                        case "audio/ac3":
                        case "audio/ac4":
                        case "audio/eac3":
                            if (Build.VERSION.SDK_INT >= 32 && (spatializerWrapper2 = defaultTrackSelector.spatializer) != null && spatializerWrapper2.spatializationSupported) {
                            }
                        default:
                            if (Build.VERSION.SDK_INT >= 32) {
                                break;
                            }
                            return false;
                    }
                } else if (Build.VERSION.SDK_INT >= 32 || (spatializerWrapper = defaultTrackSelector.spatializer) == null || !spatializerWrapper.spatializationSupported || !spatializerWrapper.isAvailable() || !defaultTrackSelector.spatializer.isEnabled() || !defaultTrackSelector.spatializer.canBeSpatialized(defaultTrackSelector.audioAttributes, format)) {
                    return false;
                }
            }
        }
        return true;
    }
}
