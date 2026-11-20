package com.metrolist.innertube.models;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/QueueAddEndpoint;", "Lcom/metrolist/innertube/models/Endpoint;", "Companion", "QueueTarget", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class QueueAddEndpoint extends Endpoint {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final String queueInsertPosition;
    public final QueueTarget queueTarget;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/QueueAddEndpoint$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/QueueAddEndpoint;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return QueueAddEndpoint$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/QueueAddEndpoint$QueueTarget;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class QueueTarget {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String playlistId;
        public final String videoId;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/QueueAddEndpoint$QueueTarget$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/QueueAddEndpoint$QueueTarget;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return QueueAddEndpoint$QueueTarget$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ QueueTarget(int i, String str, String str2) {
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
            if (!(obj instanceof QueueTarget)) {
                return false;
            }
            QueueTarget queueTarget = (QueueTarget) obj;
            return Intrinsics.areEqual(this.videoId, queueTarget.videoId) && Intrinsics.areEqual(this.playlistId, queueTarget.playlistId);
        }

        public final int hashCode() {
            String str = this.videoId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.playlistId;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("QueueTarget(videoId=", this.videoId, ", playlistId=", this.playlistId, ")");
        }
    }

    public /* synthetic */ QueueAddEndpoint(int i, String str, QueueTarget queueTarget) {
        if (3 != (i & 3)) {
            EnumsKt.throwMissingFieldException(QueueAddEndpoint$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.queueInsertPosition = str;
        this.queueTarget = queueTarget;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueueAddEndpoint)) {
            return false;
        }
        QueueAddEndpoint queueAddEndpoint = (QueueAddEndpoint) obj;
        return Intrinsics.areEqual(this.queueInsertPosition, queueAddEndpoint.queueInsertPosition) && Intrinsics.areEqual(this.queueTarget, queueAddEndpoint.queueTarget);
    }

    public final int hashCode() {
        return this.queueTarget.hashCode() + (this.queueInsertPosition.hashCode() * 31);
    }

    public final String toString() {
        return "QueueAddEndpoint(queueInsertPosition=" + this.queueInsertPosition + ", queueTarget=" + this.queueTarget + ")";
    }
}
