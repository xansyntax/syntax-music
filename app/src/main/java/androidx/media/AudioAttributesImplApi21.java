package androidx.media;

import android.media.AudioAttributes;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {
    public AudioAttributes mAudioAttributes;
    public int mLegacyStreamType = -1;

    public final boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.mAudioAttributes.equals(((AudioAttributesImplApi21) obj).mAudioAttributes);
        }
        return false;
    }

    public final int hashCode() {
        return this.mAudioAttributes.hashCode();
    }

    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.mAudioAttributes;
    }
}
