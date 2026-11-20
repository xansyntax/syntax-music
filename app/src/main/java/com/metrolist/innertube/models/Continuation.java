package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/Continuation;", "", "Companion", "NextContinuationData", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class Continuation {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final NextContinuationData nextContinuationData;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/Continuation$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/Continuation;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return Continuation$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/Continuation$NextContinuationData;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class NextContinuationData {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String continuation;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/Continuation$NextContinuationData$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/Continuation$NextContinuationData;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return Continuation$NextContinuationData$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ NextContinuationData(int i, String str) {
            if (1 == (i & 1)) {
                this.continuation = str;
            } else {
                EnumsKt.throwMissingFieldException(Continuation$NextContinuationData$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NextContinuationData) && Intrinsics.areEqual(this.continuation, ((NextContinuationData) obj).continuation);
        }

        public final int hashCode() {
            return this.continuation.hashCode();
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("NextContinuationData(continuation=", this.continuation, ")");
        }
    }

    public /* synthetic */ Continuation(int i, NextContinuationData nextContinuationData) {
        if (1 == (i & 1)) {
            this.nextContinuationData = nextContinuationData;
        } else {
            EnumsKt.throwMissingFieldException(Continuation$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Continuation) && Intrinsics.areEqual(this.nextContinuationData, ((Continuation) obj).nextContinuationData);
    }

    public final int hashCode() {
        NextContinuationData nextContinuationData = this.nextContinuationData;
        if (nextContinuationData == null) {
            return 0;
        }
        return nextContinuationData.continuation.hashCode();
    }

    public final String toString() {
        return "Continuation(nextContinuationData=" + this.nextContinuationData + ")";
    }
}
