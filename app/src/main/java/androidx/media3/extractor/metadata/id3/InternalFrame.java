package androidx.media3.extractor.metadata.id3;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class InternalFrame extends Id3Frame {
    public final String description;
    public final String domain;
    public final String text;

    public InternalFrame(String str, String str2, String str3) {
        super("----");
        this.domain = str;
        this.description = str2;
        this.text = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || InternalFrame.class != obj.getClass()) {
            return false;
        }
        InternalFrame internalFrame = (InternalFrame) obj;
        return this.description.equals(internalFrame.description) && this.domain.equals(internalFrame.domain) && this.text.equals(internalFrame.text);
    }

    public final int hashCode() {
        return this.text.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(527, 31, this.domain), 31, this.description);
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return this.id + ": domain=" + this.domain + ", description=" + this.description;
    }
}
