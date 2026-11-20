package com.metrolist.music.lyrics;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/lyrics/Translation;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
final /* data */ class Translation {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final String lang;
    public final String text;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/lyrics/Translation$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/lyrics/Translation;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return Translation$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Translation(int i, String str, String str2) {
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
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Translation)) {
            return false;
        }
        Translation translation = (Translation) obj;
        return Intrinsics.areEqual(this.lang, translation.lang) && Intrinsics.areEqual(this.text, translation.text);
    }

    public final int hashCode() {
        String str = this.lang;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.text;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("Translation(lang=", this.lang, ", text=", this.text, ")");
    }
}
