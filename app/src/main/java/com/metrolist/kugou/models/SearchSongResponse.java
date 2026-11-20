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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/kugou/models/SearchSongResponse;", "", "Companion", "Data", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class SearchSongResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final Data data;
    public final int errcode;
    public final String error;
    public final int status;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/kugou/models/SearchSongResponse$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/kugou/models/SearchSongResponse;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return SearchSongResponse$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/kugou/models/SearchSongResponse$Data;", "", "Companion", "Info", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Data {
        public final List info;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new LastFM$$ExternalSyntheticLambda1((byte) 14))};

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/kugou/models/SearchSongResponse$Data$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/kugou/models/SearchSongResponse$Data;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return SearchSongResponse$Data$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/kugou/models/SearchSongResponse$Data$Info;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class Info {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final int duration;
            public final String hash;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/kugou/models/SearchSongResponse$Data$Info$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/kugou/models/SearchSongResponse$Data$Info;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return SearchSongResponse$Data$Info$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ Info(int i, int i2, String str) {
                if (3 != (i & 3)) {
                    EnumsKt.throwMissingFieldException(SearchSongResponse$Data$Info$$serializer.INSTANCE.getDescriptor(), i, 3);
                    throw null;
                }
                this.duration = i2;
                this.hash = str;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Info)) {
                    return false;
                }
                Info info = (Info) obj;
                return this.duration == info.duration && Intrinsics.areEqual(this.hash, info.hash);
            }

            public final int hashCode() {
                return this.hash.hashCode() + (Integer.hashCode(this.duration) * 31);
            }

            public final String toString() {
                return "Info(duration=" + this.duration + ", hash=" + this.hash + ")";
            }
        }

        public /* synthetic */ Data(int i, List list) {
            if (1 == (i & 1)) {
                this.info = list;
            } else {
                EnumsKt.throwMissingFieldException(SearchSongResponse$Data$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Data) && Intrinsics.areEqual(this.info, ((Data) obj).info);
        }

        public final int hashCode() {
            return this.info.hashCode();
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("Data(info=", ")", this.info);
        }
    }

    public /* synthetic */ SearchSongResponse(int i, int i2, int i3, String str, Data data) {
        if (15 != (i & 15)) {
            EnumsKt.throwMissingFieldException(SearchSongResponse$$serializer.INSTANCE.getDescriptor(), i, 15);
            throw null;
        }
        this.status = i2;
        this.errcode = i3;
        this.error = str;
        this.data = data;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchSongResponse)) {
            return false;
        }
        SearchSongResponse searchSongResponse = (SearchSongResponse) obj;
        return this.status == searchSongResponse.status && this.errcode == searchSongResponse.errcode && Intrinsics.areEqual(this.error, searchSongResponse.error) && Intrinsics.areEqual(this.data, searchSongResponse.data);
    }

    public final int hashCode() {
        return this.data.info.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.errcode, Integer.hashCode(this.status) * 31, 31), 31, this.error);
    }

    public final String toString() {
        StringBuilder sbM3m = IntIntPair$$ExternalSyntheticOutline0.m3m(this.status, "SearchSongResponse(status=", ", errcode=", this.errcode, ", error=");
        sbM3m.append(this.error);
        sbM3m.append(", data=");
        sbM3m.append(this.data);
        sbM3m.append(")");
        return sbM3m.toString();
    }
}
