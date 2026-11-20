package com.metrolist.innertubex.cipher;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTubeCipherService$processCanonicalFormats$2$1$NTask {
    public final int index;
    public final String nValue;
    public final String url;

    public YouTubeCipherService$processCanonicalFormats$2$1$NTask(int i, String str, String str2) {
        str.getClass();
        this.index = i;
        this.url = str;
        this.nValue = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YouTubeCipherService$processCanonicalFormats$2$1$NTask)) {
            return false;
        }
        YouTubeCipherService$processCanonicalFormats$2$1$NTask youTubeCipherService$processCanonicalFormats$2$1$NTask = (YouTubeCipherService$processCanonicalFormats$2$1$NTask) obj;
        return this.index == youTubeCipherService$processCanonicalFormats$2$1$NTask.index && Intrinsics.areEqual(this.url, youTubeCipherService$processCanonicalFormats$2$1$NTask.url) && this.nValue.equals(youTubeCipherService$processCanonicalFormats$2$1$NTask.nValue);
    }

    public final int hashCode() {
        return this.nValue.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(Integer.hashCode(this.index) * 31, 31, this.url);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NTask(index=");
        sb.append(this.index);
        sb.append(", url=");
        sb.append(this.url);
        sb.append(", nValue=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.nValue, ")");
    }
}
