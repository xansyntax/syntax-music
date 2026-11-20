package com.metrolist.music.lyrics;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0083\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/lyrics/LyricsMetadata;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
final /* data */ class LyricsMetadata {
    public static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final Map agents;
    public final String language;
    public final List songParts;
    public final List songWriters;
    public final String title;
    public final String totalDuration;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/lyrics/LyricsMetadata$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/lyrics/LyricsMetadata;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return LyricsMetadata$$serializer.INSTANCE;
        }
    }

    static {
        LyricLine$$ExternalSyntheticLambda0 lyricLine$$ExternalSyntheticLambda0 = new LyricLine$$ExternalSyntheticLambda0((byte) 2);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{ResultKt.lazy(lazyThreadSafetyMode, lyricLine$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new LyricLine$$ExternalSyntheticLambda0((byte) 3)), ResultKt.lazy(lazyThreadSafetyMode, new LyricLine$$ExternalSyntheticLambda0((byte) 4)), null, null, null};
    }

    public /* synthetic */ LyricsMetadata(int i, Map map, List list, List list2, String str, String str2, String str3) {
        if ((i & 1) == 0) {
            this.agents = null;
        } else {
            this.agents = map;
        }
        if ((i & 2) == 0) {
            this.songParts = null;
        } else {
            this.songParts = list;
        }
        if ((i & 4) == 0) {
            this.songWriters = null;
        } else {
            this.songWriters = list2;
        }
        if ((i & 8) == 0) {
            this.title = null;
        } else {
            this.title = str;
        }
        if ((i & 16) == 0) {
            this.language = null;
        } else {
            this.language = str2;
        }
        if ((i & 32) == 0) {
            this.totalDuration = null;
        } else {
            this.totalDuration = str3;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LyricsMetadata)) {
            return false;
        }
        LyricsMetadata lyricsMetadata = (LyricsMetadata) obj;
        return Intrinsics.areEqual(this.agents, lyricsMetadata.agents) && Intrinsics.areEqual(this.songParts, lyricsMetadata.songParts) && Intrinsics.areEqual(this.songWriters, lyricsMetadata.songWriters) && Intrinsics.areEqual(this.title, lyricsMetadata.title) && Intrinsics.areEqual(this.language, lyricsMetadata.language) && Intrinsics.areEqual(this.totalDuration, lyricsMetadata.totalDuration);
    }

    public final int hashCode() {
        Map map = this.agents;
        int iHashCode = (map == null ? 0 : map.hashCode()) * 31;
        List list = this.songParts;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List list2 = this.songWriters;
        int iHashCode3 = (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str = this.title;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.language;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.totalDuration;
        return iHashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LyricsMetadata(agents=");
        sb.append(this.agents);
        sb.append(", songParts=");
        sb.append(this.songParts);
        sb.append(", songWriters=");
        sb.append(this.songWriters);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", language=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.language, ", totalDuration=", this.totalDuration, ")");
    }
}
