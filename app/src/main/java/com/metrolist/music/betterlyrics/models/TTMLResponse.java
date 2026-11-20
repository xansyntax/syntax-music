package com.metrolist.music.betterlyrics.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/betterlyrics/models/TTMLResponse;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class TTMLResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final String ttml;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/betterlyrics/models/TTMLResponse$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/betterlyrics/models/TTMLResponse;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return TTMLResponse$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ TTMLResponse(int i, String str) {
        if ((i & 1) == 0) {
            this.ttml = null;
        } else {
            this.ttml = str;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TTMLResponse) && Intrinsics.areEqual(this.ttml, ((TTMLResponse) obj).ttml);
    }

    public final int hashCode() {
        String str = this.ttml;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m("TTMLResponse(ttml=", this.ttml, ")");
    }
}
