package com.metrolist.innertubex.models.body;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.models.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0081\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/body/NextBody;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class NextBody {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final boolean contentCheckOk;
    public final Context context;
    public final String continuation;
    public final Integer index;
    public final String params;
    public final String playlistId;
    public final String playlistSetVideoId;
    public final boolean racyCheckOk;
    public final String videoId;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/body/NextBody$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/body/NextBody;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return NextBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ NextBody(int i, Context context, String str, String str2, String str3, Integer num, String str4, String str5, boolean z, boolean z2) {
        if (1 != (i & 1)) {
            EnumsKt.throwMissingFieldException(NextBody$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.context = context;
        if ((i & 2) == 0) {
            this.videoId = null;
        } else {
            this.videoId = str;
        }
        if ((i & 4) == 0) {
            this.playlistId = null;
        } else {
            this.playlistId = str2;
        }
        if ((i & 8) == 0) {
            this.playlistSetVideoId = null;
        } else {
            this.playlistSetVideoId = str3;
        }
        if ((i & 16) == 0) {
            this.index = null;
        } else {
            this.index = num;
        }
        if ((i & 32) == 0) {
            this.params = null;
        } else {
            this.params = str4;
        }
        if ((i & 64) == 0) {
            this.continuation = null;
        } else {
            this.continuation = str5;
        }
        if ((i & 128) == 0) {
            this.contentCheckOk = true;
        } else {
            this.contentCheckOk = z;
        }
        if ((i & 256) == 0) {
            this.racyCheckOk = true;
        } else {
            this.racyCheckOk = z2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NextBody)) {
            return false;
        }
        NextBody nextBody = (NextBody) obj;
        return Intrinsics.areEqual(this.context, nextBody.context) && Intrinsics.areEqual(this.videoId, nextBody.videoId) && Intrinsics.areEqual(this.playlistId, nextBody.playlistId) && Intrinsics.areEqual(this.playlistSetVideoId, nextBody.playlistSetVideoId) && Intrinsics.areEqual(this.index, nextBody.index) && Intrinsics.areEqual(this.params, nextBody.params) && Intrinsics.areEqual(this.continuation, nextBody.continuation) && this.contentCheckOk == nextBody.contentCheckOk && this.racyCheckOk == nextBody.racyCheckOk;
    }

    public final int hashCode() {
        int iHashCode = this.context.hashCode() * 31;
        String str = this.videoId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.playlistId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.playlistSetVideoId;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.index;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.params;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.continuation;
        return Boolean.hashCode(this.racyCheckOk) + IntIntPair$$ExternalSyntheticOutline0.m((iHashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31, this.contentCheckOk, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NextBody(context=");
        sb.append(this.context);
        sb.append(", videoId=");
        sb.append(this.videoId);
        sb.append(", playlistId=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, this.playlistId, ", playlistSetVideoId=", this.playlistSetVideoId, ", index=");
        sb.append(this.index);
        sb.append(", params=");
        sb.append(this.params);
        sb.append(", continuation=");
        sb.append(this.continuation);
        sb.append(", contentCheckOk=");
        sb.append(this.contentCheckOk);
        sb.append(", racyCheckOk=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.racyCheckOk, ")");
    }

    public NextBody(Context context, String str, String str2, String str3, Integer num, String str4, String str5) {
        this.context = context;
        this.videoId = str;
        this.playlistId = str2;
        this.playlistSetVideoId = str3;
        this.index = num;
        this.params = str4;
        this.continuation = str5;
        this.contentCheckOk = true;
        this.racyCheckOk = true;
    }
}
