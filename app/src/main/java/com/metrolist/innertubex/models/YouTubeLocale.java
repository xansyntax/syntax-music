package com.metrolist.innertubex.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/YouTubeLocale;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class YouTubeLocale {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final String gl;
    public final String hl;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/YouTubeLocale$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/YouTubeLocale;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return YouTubeLocale$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ YouTubeLocale(int i, String str, String str2) {
        if (3 != (i & 3)) {
            EnumsKt.throwMissingFieldException(YouTubeLocale$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.gl = str;
        this.hl = str2;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0020  */
    public final String acceptLanguageHeader$com_github_MetrolistGroup_innertubex() {
        String strM;
        String strReplace$default = StringsKt__StringsJVMKt.replace$default(this.hl, '_', '-');
        if (StringsKt.contains$default(strReplace$default, '-')) {
            strM = strReplace$default;
        } else {
            String str = this.gl;
            if (str.length() == 0) {
                strM = strReplace$default;
            } else {
                strM = IntIntPair$$ExternalSyntheticOutline0.m(strReplace$default, "-", str);
            }
        }
        String strSubstringBefore$default = StringsKt.substringBefore$default(strReplace$default, '-');
        if (strM.equals(strSubstringBefore$default)) {
            return strM;
        }
        return strM + "," + strSubstringBefore$default + ";q=0.9";
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YouTubeLocale)) {
            return false;
        }
        YouTubeLocale youTubeLocale = (YouTubeLocale) obj;
        return Intrinsics.areEqual(this.gl, youTubeLocale.gl) && Intrinsics.areEqual(this.hl, youTubeLocale.hl);
    }

    public final int hashCode() {
        return this.hl.hashCode() + (this.gl.hashCode() * 31);
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("YouTubeLocale(gl=", this.gl, ", hl=", this.hl, ")");
    }

    public YouTubeLocale(String str, String str2) {
        this.gl = str;
        this.hl = str2;
    }
}
