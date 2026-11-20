package androidx.media3.extractor.metadata.id3;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BinaryFrame extends Id3Frame {
    public final byte[] data;

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.data = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BinaryFrame.class != obj.getClass()) {
            return false;
        }
        BinaryFrame binaryFrame = (BinaryFrame) obj;
        return this.id.equals(binaryFrame.id) && Arrays.equals(this.data, binaryFrame.data);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.data) + Fragment$5$$ExternalSyntheticOutline0.m(527, 31, this.id);
    }
}
