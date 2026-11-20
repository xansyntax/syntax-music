package com.metrolist.paxsenix.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.shazamkit.Shazam$$ExternalSyntheticLambda0;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/paxsenix/models/LyricsResponse;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class LyricsResponse {
    public final List content;
    public final String elrc;
    public final String elrcMultiPerson;
    public final LyricsMetadata metadata;
    public final String plain;
    public final String ttmlContent;
    public final String type;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Shazam$$ExternalSyntheticLambda0((byte) 5)), null, null, null, null};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/paxsenix/models/LyricsResponse$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/paxsenix/models/LyricsResponse;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return LyricsResponse$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ LyricsResponse(int i, String str, LyricsMetadata lyricsMetadata, List list, String str2, String str3, String str4, String str5) {
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
            this.content = EmptyList.INSTANCE;
        } else {
            this.content = list;
        }
        if ((i & 8) == 0) {
            this.elrc = null;
        } else {
            this.elrc = str2;
        }
        if ((i & 16) == 0) {
            this.elrcMultiPerson = null;
        } else {
            this.elrcMultiPerson = str3;
        }
        if ((i & 32) == 0) {
            this.ttmlContent = null;
        } else {
            this.ttmlContent = str4;
        }
        if ((i & 64) == 0) {
            this.plain = null;
        } else {
            this.plain = str5;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LyricsResponse)) {
            return false;
        }
        LyricsResponse lyricsResponse = (LyricsResponse) obj;
        return Intrinsics.areEqual(this.type, lyricsResponse.type) && Intrinsics.areEqual(this.metadata, lyricsResponse.metadata) && Intrinsics.areEqual(this.content, lyricsResponse.content) && Intrinsics.areEqual(this.elrc, lyricsResponse.elrc) && Intrinsics.areEqual(this.elrcMultiPerson, lyricsResponse.elrcMultiPerson) && Intrinsics.areEqual(this.ttmlContent, lyricsResponse.ttmlContent) && Intrinsics.areEqual(this.plain, lyricsResponse.plain);
    }

    public final int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        LyricsMetadata lyricsMetadata = this.metadata;
        int iM = Fragment$5$$ExternalSyntheticOutline0.m((iHashCode + (lyricsMetadata == null ? 0 : lyricsMetadata.songwriters.hashCode())) * 31, 31, this.content);
        String str2 = this.elrc;
        int iHashCode2 = (iM + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.elrcMultiPerson;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.ttmlContent;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.plain;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LyricsResponse(type=");
        sb.append(this.type);
        sb.append(", metadata=");
        sb.append(this.metadata);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", elrc=");
        sb.append(this.elrc);
        sb.append(", elrcMultiPerson=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, this.elrcMultiPerson, ", ttmlContent=", this.ttmlContent, ", plain=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.plain, ")");
    }
}
