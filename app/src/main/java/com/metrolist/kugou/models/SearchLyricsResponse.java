package com.metrolist.kugou.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.lastfm.LastFM$$ExternalSyntheticLambda1;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/kugou/models/SearchLyricsResponse;", "", "Companion", "Candidate", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class SearchLyricsResponse {
    public final List candidates;
    public final int errcode;
    public final String errmsg;
    public final int expire;
    public final String info;
    public final int status;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {null, null, null, null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new LastFM$$ExternalSyntheticLambda1((byte) 13))};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/kugou/models/SearchLyricsResponse$Candidate;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Candidate {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String accesskey;
        public final long duration;
        public final long id;
        public final String productFrom;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/kugou/models/SearchLyricsResponse$Candidate$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/kugou/models/SearchLyricsResponse$Candidate;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return SearchLyricsResponse$Candidate$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Candidate(int i, long j, String str, long j2, String str2) {
            if (15 != (i & 15)) {
                EnumsKt.throwMissingFieldException(SearchLyricsResponse$Candidate$$serializer.INSTANCE.getDescriptor(), i, 15);
                throw null;
            }
            this.id = j;
            this.productFrom = str;
            this.duration = j2;
            this.accesskey = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Candidate)) {
                return false;
            }
            Candidate candidate = (Candidate) obj;
            return this.id == candidate.id && Intrinsics.areEqual(this.productFrom, candidate.productFrom) && this.duration == candidate.duration && Intrinsics.areEqual(this.accesskey, candidate.accesskey);
        }

        public final int hashCode() {
            return this.accesskey.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Long.hashCode(this.id) * 31, 31, this.productFrom), 31, this.duration);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Candidate(id=");
            sb.append(this.id);
            sb.append(", productFrom=");
            sb.append(this.productFrom);
            sb.append(", duration=");
            sb.append(this.duration);
            sb.append(", accesskey=");
            return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.accesskey, ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/kugou/models/SearchLyricsResponse$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/kugou/models/SearchLyricsResponse;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return SearchLyricsResponse$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SearchLyricsResponse(int i, int i2, String str, int i3, String str2, int i4, List list) {
        if (63 != (i & 63)) {
            EnumsKt.throwMissingFieldException(SearchLyricsResponse$$serializer.INSTANCE.getDescriptor(), i, 63);
            throw null;
        }
        this.status = i2;
        this.info = str;
        this.errcode = i3;
        this.errmsg = str2;
        this.expire = i4;
        this.candidates = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchLyricsResponse)) {
            return false;
        }
        SearchLyricsResponse searchLyricsResponse = (SearchLyricsResponse) obj;
        return this.status == searchLyricsResponse.status && Intrinsics.areEqual(this.info, searchLyricsResponse.info) && this.errcode == searchLyricsResponse.errcode && Intrinsics.areEqual(this.errmsg, searchLyricsResponse.errmsg) && this.expire == searchLyricsResponse.expire && Intrinsics.areEqual(this.candidates, searchLyricsResponse.candidates);
    }

    public final int hashCode() {
        return this.candidates.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(this.expire, Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.errcode, Fragment$5$$ExternalSyntheticOutline0.m(Integer.hashCode(this.status) * 31, 31, this.info), 31), 31, this.errmsg), 31);
    }

    public final String toString() {
        return "SearchLyricsResponse(status=" + this.status + ", info=" + this.info + ", errcode=" + this.errcode + ", errmsg=" + this.errmsg + ", expire=" + this.expire + ", candidates=" + this.candidates + ")";
    }
}
