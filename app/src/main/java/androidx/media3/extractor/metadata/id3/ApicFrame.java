package androidx.media3.extractor.metadata.id3;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.MediaMetadata;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ApicFrame extends Id3Frame {
    public final String description;
    public final String mimeType;
    public final byte[] pictureData;
    public final int pictureType;

    public ApicFrame(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.mimeType = str;
        this.description = str2;
        this.pictureType = i;
        this.pictureData = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ApicFrame.class != obj.getClass()) {
            return false;
        }
        ApicFrame apicFrame = (ApicFrame) obj;
        return this.pictureType == apicFrame.pictureType && this.mimeType.equals(apicFrame.mimeType) && Objects.equals(this.description, apicFrame.description) && Arrays.equals(this.pictureData, apicFrame.pictureData);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m((527 + this.pictureType) * 31, 31, this.mimeType);
        String str = this.description;
        return Arrays.hashCode(this.pictureData) + ((iM + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // androidx.media3.common.Metadata.Entry
    public final void populateMediaMetadata(MediaMetadata.Builder builder) {
        builder.maybeSetArtworkData(this.pictureData, this.pictureType);
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return this.id + ": mimeType=" + this.mimeType + ", description=" + this.description;
    }
}
