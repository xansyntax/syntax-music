package androidx.media3.extractor.metadata.dvbsi;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Metadata;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AppInfoTable implements Metadata.Entry {
    public final int controlCode;
    public final String url;

    public AppInfoTable(int i, String str) {
        this.controlCode = i;
        this.url = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Ait(controlCode=");
        sb.append(this.controlCode);
        sb.append(",url=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.url, ")");
    }
}
