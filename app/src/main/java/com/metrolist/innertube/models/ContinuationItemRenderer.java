package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/ContinuationItemRenderer;", "", "Companion", "ContinuationEndpoint", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class ContinuationItemRenderer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final ContinuationEndpoint continuationEndpoint;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/ContinuationItemRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/ContinuationItemRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return ContinuationItemRenderer$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/ContinuationItemRenderer$ContinuationEndpoint;", "", "Companion", "ContinuationCommand", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ContinuationEndpoint {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final ContinuationCommand continuationCommand;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/ContinuationItemRenderer$ContinuationEndpoint$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/ContinuationItemRenderer$ContinuationEndpoint;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return ContinuationItemRenderer$ContinuationEndpoint$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class ContinuationCommand {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final String token;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ ContinuationCommand(int i, String str) {
                if (1 == (i & 1)) {
                    this.token = str;
                } else {
                    EnumsKt.throwMissingFieldException(ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand$$serializer.INSTANCE.getDescriptor(), i, 1);
                    throw null;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ContinuationCommand) && Intrinsics.areEqual(this.token, ((ContinuationCommand) obj).token);
            }

            public final int hashCode() {
                String str = this.token;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public final String toString() {
                return IntIntPair$$ExternalSyntheticOutline0.m("ContinuationCommand(token=", this.token, ")");
            }
        }

        public /* synthetic */ ContinuationEndpoint(int i, ContinuationCommand continuationCommand) {
            if (1 == (i & 1)) {
                this.continuationCommand = continuationCommand;
            } else {
                EnumsKt.throwMissingFieldException(ContinuationItemRenderer$ContinuationEndpoint$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ContinuationEndpoint) && Intrinsics.areEqual(this.continuationCommand, ((ContinuationEndpoint) obj).continuationCommand);
        }

        public final int hashCode() {
            ContinuationCommand continuationCommand = this.continuationCommand;
            if (continuationCommand == null) {
                return 0;
            }
            return continuationCommand.hashCode();
        }

        public final String toString() {
            return "ContinuationEndpoint(continuationCommand=" + this.continuationCommand + ")";
        }
    }

    public /* synthetic */ ContinuationItemRenderer(int i, ContinuationEndpoint continuationEndpoint) {
        if (1 == (i & 1)) {
            this.continuationEndpoint = continuationEndpoint;
        } else {
            EnumsKt.throwMissingFieldException(ContinuationItemRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ContinuationItemRenderer) && Intrinsics.areEqual(this.continuationEndpoint, ((ContinuationItemRenderer) obj).continuationEndpoint);
    }

    public final int hashCode() {
        ContinuationEndpoint continuationEndpoint = this.continuationEndpoint;
        if (continuationEndpoint == null) {
            return 0;
        }
        return continuationEndpoint.hashCode();
    }

    public final String toString() {
        return "ContinuationItemRenderer(continuationEndpoint=" + this.continuationEndpoint + ")";
    }
}
