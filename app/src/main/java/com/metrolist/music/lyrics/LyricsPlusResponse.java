package com.metrolist.music.lyrics;

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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/lyrics/LyricsPlusResponse;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
final /* data */ class LyricsPlusResponse {
    public final String cached;
    public final List lyrics;
    public final LyricsMetadata metadata;
    public final String type;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new LyricLine$$ExternalSyntheticLambda0((byte) 5)), null};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/lyrics/LyricsPlusResponse$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/lyrics/LyricsPlusResponse;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return LyricsPlusResponse$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ LyricsPlusResponse(int i, String str, LyricsMetadata lyricsMetadata, List list, String str2) {
        if ((i & 1) == 0) {
            this.type = null;
        } else {
            this.type = str;
        }
        if ((i & 2) == 0) {
            this.metadata = null;
        } else {
            this.metadata = lyricsMetadata;
        }
        if ((i & 4) == 0) {
            this.lyrics = null;
        } else {
            this.lyrics = list;
        }
        if ((i & 8) == 0) {
            this.cached = null;
        } else {
            this.cached = str2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LyricsPlusResponse)) {
            return false;
        }
        LyricsPlusResponse lyricsPlusResponse = (LyricsPlusResponse) obj;
        return Intrinsics.areEqual(this.type, lyricsPlusResponse.type) && Intrinsics.areEqual(this.metadata, lyricsPlusResponse.metadata) && Intrinsics.areEqual(this.lyrics, lyricsPlusResponse.lyrics) && Intrinsics.areEqual(this.cached, lyricsPlusResponse.cached);
    }

    public final int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        LyricsMetadata lyricsMetadata = this.metadata;
        int iHashCode2 = (iHashCode + (lyricsMetadata == null ? 0 : lyricsMetadata.hashCode())) * 31;
        List list = this.lyrics;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.cached;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return "LyricsPlusResponse(type=" + this.type + ", metadata=" + this.metadata + ", lyrics=" + this.lyrics + ", cached=" + this.cached + ")";
    }
}
