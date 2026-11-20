package com.metrolist.innertube.models;

import coil3.disk.UtilsKt$$ExternalSyntheticLambda0;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/DefaultServiceEndpoint;", "Lcom/metrolist/innertube/models/Endpoint;", "Companion", "SubscribeEndpoint", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class DefaultServiceEndpoint extends Endpoint {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public FeedbackEndpoint feedbackEndpoint;
    public SubscribeEndpoint subscribeEndpoint;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/DefaultServiceEndpoint$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/DefaultServiceEndpoint;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return DefaultServiceEndpoint$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/DefaultServiceEndpoint$SubscribeEndpoint;", "Lcom/metrolist/innertube/models/Endpoint;", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class SubscribeEndpoint extends Endpoint {
        public final List channelIds;
        public final String params;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new UtilsKt$$ExternalSyntheticLambda0((byte) 28)), null};

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/DefaultServiceEndpoint$SubscribeEndpoint$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/DefaultServiceEndpoint$SubscribeEndpoint;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return DefaultServiceEndpoint$SubscribeEndpoint$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ SubscribeEndpoint(String str, int i, List list) {
            if (1 != (i & 1)) {
                EnumsKt.throwMissingFieldException(DefaultServiceEndpoint$SubscribeEndpoint$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
            this.channelIds = list;
            if ((i & 2) == 0) {
                this.params = null;
            } else {
                this.params = str;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubscribeEndpoint)) {
                return false;
            }
            SubscribeEndpoint subscribeEndpoint = (SubscribeEndpoint) obj;
            return Intrinsics.areEqual(this.channelIds, subscribeEndpoint.channelIds) && Intrinsics.areEqual(this.params, subscribeEndpoint.params);
        }

        public final int hashCode() {
            int iHashCode = this.channelIds.hashCode() * 31;
            String str = this.params;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            return "SubscribeEndpoint(channelIds=" + this.channelIds + ", params=" + this.params + ")";
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DefaultServiceEndpoint)) {
            return false;
        }
        DefaultServiceEndpoint defaultServiceEndpoint = (DefaultServiceEndpoint) obj;
        return Intrinsics.areEqual(this.subscribeEndpoint, defaultServiceEndpoint.subscribeEndpoint) && Intrinsics.areEqual(this.feedbackEndpoint, defaultServiceEndpoint.feedbackEndpoint);
    }

    public final int hashCode() {
        SubscribeEndpoint subscribeEndpoint = this.subscribeEndpoint;
        int iHashCode = (subscribeEndpoint == null ? 0 : subscribeEndpoint.hashCode()) * 31;
        FeedbackEndpoint feedbackEndpoint = this.feedbackEndpoint;
        return iHashCode + (feedbackEndpoint != null ? feedbackEndpoint.feedbackToken.hashCode() : 0);
    }

    public final String toString() {
        return "DefaultServiceEndpoint(subscribeEndpoint=" + this.subscribeEndpoint + ", feedbackEndpoint=" + this.feedbackEndpoint + ")";
    }
}
