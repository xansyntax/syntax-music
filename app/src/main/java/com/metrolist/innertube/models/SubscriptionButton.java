package com.metrolist.innertube.models;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/SubscriptionButton;", "", "Companion", "SubscribeButtonRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class SubscriptionButton {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final SubscribeButtonRenderer subscribeButtonRenderer;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/SubscriptionButton$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/SubscriptionButton;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return SubscriptionButton$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/SubscriptionButton$SubscribeButtonRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class SubscribeButtonRenderer {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String channelId;
        public final Runs longSubscriberCountText;
        public final Runs shortSubscriberCountText;
        public final boolean subscribed;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/SubscriptionButton$SubscribeButtonRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/SubscriptionButton$SubscribeButtonRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return SubscriptionButton$SubscribeButtonRenderer$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ SubscribeButtonRenderer(int i, boolean z, String str, Runs runs, Runs runs2) {
            if (3 != (i & 3)) {
                EnumsKt.throwMissingFieldException(SubscriptionButton$SubscribeButtonRenderer$$serializer.INSTANCE.getDescriptor(), i, 3);
                throw null;
            }
            this.subscribed = z;
            this.channelId = str;
            if ((i & 4) == 0) {
                this.longSubscriberCountText = null;
            } else {
                this.longSubscriberCountText = runs;
            }
            if ((i & 8) == 0) {
                this.shortSubscriberCountText = null;
            } else {
                this.shortSubscriberCountText = runs2;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubscribeButtonRenderer)) {
                return false;
            }
            SubscribeButtonRenderer subscribeButtonRenderer = (SubscribeButtonRenderer) obj;
            return this.subscribed == subscribeButtonRenderer.subscribed && Intrinsics.areEqual(this.channelId, subscribeButtonRenderer.channelId) && Intrinsics.areEqual(this.longSubscriberCountText, subscribeButtonRenderer.longSubscriberCountText) && Intrinsics.areEqual(this.shortSubscriberCountText, subscribeButtonRenderer.shortSubscriberCountText);
        }

        public final int hashCode() {
            int iM = Fragment$5$$ExternalSyntheticOutline0.m(Boolean.hashCode(this.subscribed) * 31, 31, this.channelId);
            Runs runs = this.longSubscriberCountText;
            int iHashCode = (iM + (runs == null ? 0 : runs.hashCode())) * 31;
            Runs runs2 = this.shortSubscriberCountText;
            return iHashCode + (runs2 != null ? runs2.hashCode() : 0);
        }

        public final String toString() {
            return "SubscribeButtonRenderer(subscribed=" + this.subscribed + ", channelId=" + this.channelId + ", longSubscriberCountText=" + this.longSubscriberCountText + ", shortSubscriberCountText=" + this.shortSubscriberCountText + ")";
        }
    }

    public /* synthetic */ SubscriptionButton(int i, SubscribeButtonRenderer subscribeButtonRenderer) {
        if (1 == (i & 1)) {
            this.subscribeButtonRenderer = subscribeButtonRenderer;
        } else {
            EnumsKt.throwMissingFieldException(SubscriptionButton$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SubscriptionButton) && Intrinsics.areEqual(this.subscribeButtonRenderer, ((SubscriptionButton) obj).subscribeButtonRenderer);
    }

    public final int hashCode() {
        return this.subscribeButtonRenderer.hashCode();
    }

    public final String toString() {
        return "SubscriptionButton(subscribeButtonRenderer=" + this.subscribeButtonRenderer + ")";
    }
}
