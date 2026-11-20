package com.metrolist.music.lyrics;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/lyrics/Transliteration;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
final /* data */ class Transliteration {
    public final String lang;
    public final List syllabus;
    public final String text;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new LyricLine$$ExternalSyntheticLambda0((byte) 6))};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/lyrics/Transliteration$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/lyrics/Transliteration;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return Transliteration$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Transliteration(int i, String str, String str2, List list) {
        if ((i & 1) == 0) {
            this.lang = null;
        } else {
            this.lang = str;
        }
        if ((i & 2) == 0) {
            this.text = null;
        } else {
            this.text = str2;
        }
        if ((i & 4) == 0) {
            this.syllabus = null;
        } else {
            this.syllabus = list;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Transliteration)) {
            return false;
        }
        Transliteration transliteration = (Transliteration) obj;
        return Intrinsics.areEqual(this.lang, transliteration.lang) && Intrinsics.areEqual(this.text, transliteration.text) && Intrinsics.areEqual(this.syllabus, transliteration.syllabus);
    }

    public final int hashCode() {
        String str = this.lang;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.text;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List list = this.syllabus;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("Transliteration(lang=", this.lang, ", text=", this.text, ", syllabus=");
        sbM.append(this.syllabus);
        sbM.append(")");
        return sbM.toString();
    }
}
