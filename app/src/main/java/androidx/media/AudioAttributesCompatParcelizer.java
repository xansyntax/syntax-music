package androidx.media;

import androidx.versionedparcelable.VersionedParcel;
import androidx.versionedparcelable.VersionedParcelable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(VersionedParcel versionedParcel) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        VersionedParcelable versionedParcelable = audioAttributesCompat.mImpl;
        if (versionedParcel.readField(1)) {
            versionedParcelable = versionedParcel.readVersionedParcelable();
        }
        audioAttributesCompat.mImpl = (AudioAttributesImpl) versionedParcelable;
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, VersionedParcel versionedParcel) {
        versionedParcel.getClass();
        AudioAttributesImpl audioAttributesImpl = audioAttributesCompat.mImpl;
        versionedParcel.setOutputField(1);
        versionedParcel.writeVersionedParcelable$1(audioAttributesImpl);
    }
}
