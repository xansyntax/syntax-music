package com.metrolist.innertubex.models.body;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertubex.models.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0081\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertubex/models/body/LikeBody;", "", "Companion", "Target", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class LikeBody {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final Context context;
    public final Target target;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/body/LikeBody$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/body/LikeBody;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return LikeBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ LikeBody(int i, Context context, Target target) {
        if (3 != (i & 3)) {
            EnumsKt.throwMissingFieldException(LikeBody$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.context = context;
        this.target = target;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LikeBody)) {
            return false;
        }
        LikeBody likeBody = (LikeBody) obj;
        return Intrinsics.areEqual(this.context, likeBody.context) && Intrinsics.areEqual(this.target, likeBody.target);
    }

    public final int hashCode() {
        return this.target.hashCode() + (this.context.hashCode() * 31);
    }

    public final String toString() {
        return "LikeBody(context=" + this.context + ", target=" + this.target + ")";
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertubex/models/body/LikeBody$Target;", "", "Companion", "$serializer", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Target {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String playlistId;
        public final String videoId;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertubex/models/body/LikeBody$Target$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertubex/models/body/LikeBody$Target;", "serializer", "()Lkotlinx/serialization/KSerializer;", "com.github.MetrolistGroup:innertubex"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return LikeBody$Target$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Target(int i, String str, String str2) {
            if ((i & 1) == 0) {
                this.videoId = null;
            } else {
                this.videoId = str;
            }
            if ((i & 2) == 0) {
                this.playlistId = null;
            } else {
                this.playlistId = str2;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Target)) {
                return false;
            }
            Target target = (Target) obj;
            return Intrinsics.areEqual(this.videoId, target.videoId) && Intrinsics.areEqual(this.playlistId, target.playlistId);
        }

        public final int hashCode() {
            String str = this.videoId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.playlistId;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("Target(videoId=", this.videoId, ", playlistId=", this.playlistId, ")");
        }

        public Target(String str, String str2, int i) {
            str = (i & 1) != 0 ? null : str;
            str2 = (i & 2) != 0 ? null : str2;
            this.videoId = str;
            this.playlistId = str2;
        }
    }

    public LikeBody(Context context, Target target) {
        this.context = context;
        this.target = target;
    }
}
