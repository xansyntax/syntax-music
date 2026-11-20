package androidx.media3.extractor.metadata.id3;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class UrlLinkFrame extends Id3Frame {
    public final String description;
    public final String url;

    public UrlLinkFrame(String str, String str2, String str3) {
        super(str);
        this.description = str2;
        this.url = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UrlLinkFrame.class != obj.getClass()) {
            return false;
        }
        UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
        return this.id.equals(urlLinkFrame.id) && Objects.equals(this.description, urlLinkFrame.description) && this.url.equals(urlLinkFrame.url);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(527, 31, this.id);
        String str = this.description;
        return this.url.hashCode() + ((iM + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return this.id + ": url=" + this.url;
    }
}
