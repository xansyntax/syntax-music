package androidx.media3.extractor.metadata.id3;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PrivFrame extends Id3Frame {
    public final String owner;
    public final byte[] privateData;

    public PrivFrame(String str, byte[] bArr) {
        super("PRIV");
        this.owner = str;
        this.privateData = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PrivFrame.class != obj.getClass()) {
            return false;
        }
        PrivFrame privFrame = (PrivFrame) obj;
        return this.owner.equals(privFrame.owner) && Arrays.equals(this.privateData, privFrame.privateData);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.privateData) + Fragment$5$$ExternalSyntheticOutline0.m(527, 31, this.owner);
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return this.id + ": owner=" + this.owner;
    }
}
