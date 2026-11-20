package com.metrolist.innertubex.cipher;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTubeCipherService$processCanonicalFormats$2$1$SigTask {
    public final int index;
    public final LinkedHashMap params;
    public final boolean useSignatureCipherField;

    public YouTubeCipherService$processCanonicalFormats$2$1$SigTask(int i, LinkedHashMap linkedHashMap, boolean z) {
        this.index = i;
        this.params = linkedHashMap;
        this.useSignatureCipherField = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YouTubeCipherService$processCanonicalFormats$2$1$SigTask)) {
            return false;
        }
        YouTubeCipherService$processCanonicalFormats$2$1$SigTask youTubeCipherService$processCanonicalFormats$2$1$SigTask = (YouTubeCipherService$processCanonicalFormats$2$1$SigTask) obj;
        return this.index == youTubeCipherService$processCanonicalFormats$2$1$SigTask.index && this.params.equals(youTubeCipherService$processCanonicalFormats$2$1$SigTask.params) && this.useSignatureCipherField == youTubeCipherService$processCanonicalFormats$2$1$SigTask.useSignatureCipherField;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.useSignatureCipherField) + ((this.params.hashCode() + (Integer.hashCode(this.index) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SigTask(index=");
        sb.append(this.index);
        sb.append(", params=");
        sb.append(this.params);
        sb.append(", useSignatureCipherField=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.useSignatureCipherField, ")");
    }
}
