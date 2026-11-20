package androidx.media3.extractor.metadata.id3;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class GeobFrame extends Id3Frame {
    public final byte[] data;
    public final String description;
    public final String filename;
    public final String mimeType;

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.mimeType = str;
        this.filename = str2;
        this.description = str3;
        this.data = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GeobFrame.class != obj.getClass()) {
            return false;
        }
        GeobFrame geobFrame = (GeobFrame) obj;
        return Objects.equals(this.mimeType, geobFrame.mimeType) && this.filename.equals(geobFrame.filename) && this.description.equals(geobFrame.description) && Arrays.equals(this.data, geobFrame.data);
    }

    public final int hashCode() {
        String str = this.mimeType;
        return Arrays.hashCode(this.data) + Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m((527 + (str != null ? str.hashCode() : 0)) * 31, 31, this.filename), 31, this.description);
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return this.id + ": mimeType=" + this.mimeType + ", filename=" + this.filename + ", description=" + this.description;
    }
}
