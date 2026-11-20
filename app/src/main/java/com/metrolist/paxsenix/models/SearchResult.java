package com.metrolist.paxsenix.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/paxsenix/models/SearchResult;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class SearchResult {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final String albumName;
    public final String artistName;
    public final String artwork;
    public final Integer duration;
    public final String id;
    public final String songName;
    public final String trackName;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/paxsenix/models/SearchResult$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/paxsenix/models/SearchResult;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return SearchResult$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SearchResult(int i, String str, String str2, String str3, String str4, String str5, Integer num, String str6) {
        if (1 != (i & 1)) {
            EnumsKt.throwMissingFieldException(SearchResult$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.id = str;
        if ((i & 2) == 0) {
            this.songName = null;
        } else {
            this.songName = str2;
        }
        if ((i & 4) == 0) {
            this.trackName = null;
        } else {
            this.trackName = str3;
        }
        if ((i & 8) == 0) {
            this.artistName = null;
        } else {
            this.artistName = str4;
        }
        if ((i & 16) == 0) {
            this.albumName = null;
        } else {
            this.albumName = str5;
        }
        if ((i & 32) == 0) {
            this.duration = null;
        } else {
            this.duration = num;
        }
        if ((i & 64) == 0) {
            this.artwork = null;
        } else {
            this.artwork = str6;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchResult)) {
            return false;
        }
        SearchResult searchResult = (SearchResult) obj;
        return Intrinsics.areEqual(this.id, searchResult.id) && Intrinsics.areEqual(this.songName, searchResult.songName) && Intrinsics.areEqual(this.trackName, searchResult.trackName) && Intrinsics.areEqual(this.artistName, searchResult.artistName) && Intrinsics.areEqual(this.albumName, searchResult.albumName) && Intrinsics.areEqual(this.duration, searchResult.duration) && Intrinsics.areEqual(this.artwork, searchResult.artwork);
    }

    public final int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.songName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.trackName;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.artistName;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.albumName;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.duration;
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.artwork;
        return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("SearchResult(id=", this.id, ", songName=", this.songName, ", trackName=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.trackName, ", artistName=", this.artistName, ", albumName=");
        sbM.append(this.albumName);
        sbM.append(", duration=");
        sbM.append(this.duration);
        sbM.append(", artwork=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.artwork, ")");
    }

    public SearchResult(String str, String str2, String str3, String str4, Integer num, String str5) {
        str.getClass();
        this.id = str;
        this.songName = null;
        this.trackName = str2;
        this.artistName = str3;
        this.albumName = str4;
        this.duration = num;
        this.artwork = str5;
    }
}
