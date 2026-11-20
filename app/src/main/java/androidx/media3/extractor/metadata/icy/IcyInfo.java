package androidx.media3.extractor.metadata.icy;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class IcyInfo implements Metadata.Entry {
    public final byte[] rawMetadata;
    public final String title;
    public final String url;

    public IcyInfo(String str, String str2, byte[] bArr) {
        this.rawMetadata = bArr;
        this.title = str;
        this.url = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IcyInfo.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.rawMetadata, ((IcyInfo) obj).rawMetadata);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.rawMetadata);
    }

    @Override // androidx.media3.common.Metadata.Entry
    public final void populateMediaMetadata(MediaMetadata.Builder builder) {
        String str = this.title;
        if (str != null) {
            builder.title = str;
        }
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("ICY: title=\"", this.title, "\", url=\"", this.url, "\", rawMetadata.length=\""), this.rawMetadata.length, "\"");
    }
}
