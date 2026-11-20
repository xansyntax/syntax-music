package com.metrolist.innertubex.models.body;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.models.Context;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0081\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/body/CreatePlaylistBody;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class CreatePlaylistBody {
    public final Context context;
    public final String privacyStatus;
    public final String title;
    public final List videoIds;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {null, null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new LastFM$$ExternalSyntheticLambda1((byte) 5))};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/body/CreatePlaylistBody$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/body/CreatePlaylistBody;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return CreatePlaylistBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CreatePlaylistBody(int i, Context context, String str, String str2, List list) {
        if (7 != (i & 7)) {
            EnumsKt.throwMissingFieldException(CreatePlaylistBody$$serializer.INSTANCE.getDescriptor(), i, 7);
            throw null;
        }
        this.context = context;
        this.title = str;
        this.privacyStatus = str2;
        if ((i & 8) == 0) {
            this.videoIds = null;
        } else {
            this.videoIds = list;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreatePlaylistBody)) {
            return false;
        }
        CreatePlaylistBody createPlaylistBody = (CreatePlaylistBody) obj;
        return Intrinsics.areEqual(this.context, createPlaylistBody.context) && Intrinsics.areEqual(this.title, createPlaylistBody.title) && Intrinsics.areEqual(this.privacyStatus, createPlaylistBody.privacyStatus) && Intrinsics.areEqual(this.videoIds, createPlaylistBody.videoIds);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.context.hashCode() * 31, 31, this.title), 31, this.privacyStatus);
        List list = this.videoIds;
        return iM + (list == null ? 0 : list.hashCode());
    }

    public final String toString() {
        return "CreatePlaylistBody(context=" + this.context + ", title=" + this.title + ", privacyStatus=" + this.privacyStatus + ", videoIds=" + this.videoIds + ")";
    }

    public CreatePlaylistBody(Context context, String str) {
        str.getClass();
        this.context = context;
        this.title = str;
        this.privacyStatus = "PRIVATE";
        this.videoIds = null;
    }
}
