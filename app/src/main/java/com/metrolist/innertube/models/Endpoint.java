package com.metrolist.innertube.models;

import coil3.disk.UtilsKt$$ExternalSyntheticLambda0;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u0082\u0001\t\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/metrolist/innertube/models/Endpoint;", "", "Companion", "Lcom/metrolist/innertube/models/BrowseEndpoint;", "Lcom/metrolist/innertube/models/DefaultServiceEndpoint;", "Lcom/metrolist/innertube/models/DefaultServiceEndpoint$SubscribeEndpoint;", "Lcom/metrolist/innertube/models/FeedbackEndpoint;", "Lcom/metrolist/innertube/models/QueueAddEndpoint;", "Lcom/metrolist/innertube/models/SearchEndpoint;", "Lcom/metrolist/innertube/models/ShareEntityEndpoint;", "Lcom/metrolist/innertube/models/ToggledServiceEndpoint;", "Lcom/metrolist/innertube/models/WatchEndpoint;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public abstract class Endpoint {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy $cachedSerializer$delegate = ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new UtilsKt$$ExternalSyntheticLambda0(29));

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/Endpoint$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/Endpoint;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return (KSerializer) Endpoint.$cachedSerializer$delegate.getValue();
        }
    }
}
