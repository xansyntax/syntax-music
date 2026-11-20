package com.metrolist.innertube.models;

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
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/MusicPlaylistShelfRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class MusicPlaylistShelfRenderer {
    public static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final Integer collapsedItemCount;
    public final List contents;
    public final List continuations;
    public final String playlistId;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicPlaylistShelfRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicPlaylistShelfRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return MusicPlaylistShelfRenderer$$serializer.INSTANCE;
        }
    }

    static {
        Runs$$ExternalSyntheticLambda0 runs$$ExternalSyntheticLambda0 = new Runs$$ExternalSyntheticLambda0((byte) 10);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, ResultKt.lazy(lazyThreadSafetyMode, runs$$ExternalSyntheticLambda0), null, ResultKt.lazy(lazyThreadSafetyMode, new Runs$$ExternalSyntheticLambda0((byte) 11))};
    }

    public /* synthetic */ MusicPlaylistShelfRenderer(int i, String str, List list, Integer num, List list2) {
        if (1 != (i & 1)) {
            EnumsKt.throwMissingFieldException(MusicPlaylistShelfRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.playlistId = str;
        if ((i & 2) == 0) {
            this.contents = EmptyList.INSTANCE;
        } else {
            this.contents = list;
        }
        if ((i & 4) == 0) {
            this.collapsedItemCount = null;
        } else {
            this.collapsedItemCount = num;
        }
        if ((i & 8) == 0) {
            this.continuations = null;
        } else {
            this.continuations = list2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicPlaylistShelfRenderer)) {
            return false;
        }
        MusicPlaylistShelfRenderer musicPlaylistShelfRenderer = (MusicPlaylistShelfRenderer) obj;
        return Intrinsics.areEqual(this.playlistId, musicPlaylistShelfRenderer.playlistId) && Intrinsics.areEqual(this.contents, musicPlaylistShelfRenderer.contents) && Intrinsics.areEqual(this.collapsedItemCount, musicPlaylistShelfRenderer.collapsedItemCount) && Intrinsics.areEqual(this.continuations, musicPlaylistShelfRenderer.continuations);
    }

    public final int hashCode() {
        String str = this.playlistId;
        int iM = Fragment$5$$ExternalSyntheticOutline0.m((str == null ? 0 : str.hashCode()) * 31, 31, this.contents);
        Integer num = this.collapsedItemCount;
        int iHashCode = (iM + (num == null ? 0 : num.hashCode())) * 31;
        List list = this.continuations;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "MusicPlaylistShelfRenderer(playlistId=" + this.playlistId + ", contents=" + this.contents + ", collapsedItemCount=" + this.collapsedItemCount + ", continuations=" + this.continuations + ")";
    }
}
