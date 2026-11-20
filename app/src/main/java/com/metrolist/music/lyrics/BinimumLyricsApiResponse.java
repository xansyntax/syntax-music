package com.metrolist.music.lyrics;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/lyrics/BinimumLyricsApiResponse;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
final /* data */ class BinimumLyricsApiResponse {
    public final String error;
    public final List results;
    public final String source;
    public final Integer total;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new LyricLine$$ExternalSyntheticLambda0((byte) 1)), null};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/lyrics/BinimumLyricsApiResponse$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/lyrics/BinimumLyricsApiResponse;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return BinimumLyricsApiResponse$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ BinimumLyricsApiResponse(int i, Integer num, String str, List list, String str2) {
        if ((i & 1) == 0) {
            this.total = null;
        } else {
            this.total = num;
        }
        if ((i & 2) == 0) {
            this.source = null;
        } else {
            this.source = str;
        }
        if ((i & 4) == 0) {
            this.results = EmptyList.INSTANCE;
        } else {
            this.results = list;
        }
        if ((i & 8) == 0) {
            this.error = null;
        } else {
            this.error = str2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BinimumLyricsApiResponse)) {
            return false;
        }
        BinimumLyricsApiResponse binimumLyricsApiResponse = (BinimumLyricsApiResponse) obj;
        return Intrinsics.areEqual(this.total, binimumLyricsApiResponse.total) && Intrinsics.areEqual(this.source, binimumLyricsApiResponse.source) && Intrinsics.areEqual(this.results, binimumLyricsApiResponse.results) && Intrinsics.areEqual(this.error, binimumLyricsApiResponse.error);
    }

    public final int hashCode() {
        Integer num = this.total;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.source;
        int iM = Fragment$5$$ExternalSyntheticOutline0.m((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.results);
        String str2 = this.error;
        return iM + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return "BinimumLyricsApiResponse(total=" + this.total + ", source=" + this.source + ", results=" + this.results + ", error=" + this.error + ")";
    }
}
