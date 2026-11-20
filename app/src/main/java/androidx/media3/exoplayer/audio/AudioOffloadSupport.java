package androidx.media3.exoplayer.audio;

import androidx.media3.extractor.mp4.BoxParser;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AudioOffloadSupport {
    public static final AudioOffloadSupport DEFAULT_UNSUPPORTED = new BoxParser.StriData().build();
    public final boolean isFormatSupported;
    public final boolean isGaplessSupported;
    public final boolean isSpeedChangeSupported;

    public AudioOffloadSupport(BoxParser.StriData striData) {
        this.isFormatSupported = striData.hasLeftEyeView;
        this.isGaplessSupported = striData.hasRightEyeView;
        this.isSpeedChangeSupported = striData.eyeViewsReversed;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AudioOffloadSupport.class != obj.getClass()) {
            return false;
        }
        AudioOffloadSupport audioOffloadSupport = (AudioOffloadSupport) obj;
        return this.isFormatSupported == audioOffloadSupport.isFormatSupported && this.isGaplessSupported == audioOffloadSupport.isGaplessSupported && this.isSpeedChangeSupported == audioOffloadSupport.isSpeedChangeSupported;
    }

    public final int hashCode() {
        return ((this.isFormatSupported ? 1 : 0) << 2) + ((this.isGaplessSupported ? 1 : 0) << 1) + (this.isSpeedChangeSupported ? 1 : 0);
    }
}
