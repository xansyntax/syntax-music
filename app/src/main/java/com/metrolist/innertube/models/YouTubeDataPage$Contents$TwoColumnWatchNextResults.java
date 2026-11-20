package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertube.models.response.BrowseResponse$$ExternalSyntheticLambda0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"com/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults", "", "Companion", "Results", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class YouTubeDataPage$Contents$TwoColumnWatchNextResults {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final Results results;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return YouTubeDataPage$Contents$TwoColumnWatchNextResults$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results;", "", "Companion", "Results", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Results {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final C0002Results results;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results;", "", "Companion", "Content", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class C0002Results {
            public final List content;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BrowseResponse$$ExternalSyntheticLambda0((byte) 1))};

            /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Companion, reason: from kotlin metadata */
            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$$serializer.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content */
            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0002¨\u0006\u0007"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content;", "", "Companion", "ItemSectionRenderer", "VideoPrimaryInfoRenderer", "VideoSecondaryInfoRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            @Serializable
            public static final /* data */ class Content {

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion();
                public final ItemSectionRenderer itemSectionRenderer;
                public final VideoPrimaryInfoRenderer videoPrimaryInfoRenderer;
                public final VideoSecondaryInfoRenderer videoSecondaryInfoRenderer;

                /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$Companion, reason: from kotlin metadata */
                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                public static final class Companion {
                    public final KSerializer serializer() {
                        return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$$serializer.INSTANCE;
                    }
                }

                /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer */
                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer;", "", "Companion", "Content", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                @Serializable
                public static final /* data */ class ItemSectionRenderer {
                    public final List contents;

                    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                    public static final Companion INSTANCE = new Companion();
                    public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BrowseResponse$$ExternalSyntheticLambda0((byte) 2))};

                    /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Companion, reason: from kotlin metadata */
                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                    public static final class Companion {
                        public final KSerializer serializer() {
                            return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$$serializer.INSTANCE;
                        }
                    }

                    /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content, reason: collision with other inner class name */
                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content;", "", "Companion", "ContinuationItemRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                    @Serializable
                    public static final /* data */ class C0003Content {

                        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                        public static final Companion INSTANCE = new Companion();
                        public final ContinuationItemRenderer continuationItemRenderer;

                        /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$Companion, reason: from kotlin metadata */
                        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                        public static final class Companion {
                            public final KSerializer serializer() {
                                return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$$serializer.INSTANCE;
                            }
                        }

                        /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer */
                        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer;", "", "Companion", "ContinuationEndpoint", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                        @Serializable
                        public static final /* data */ class ContinuationItemRenderer {

                            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                            public static final Companion INSTANCE = new Companion();
                            public final ContinuationEndpoint continuationEndpoint;
                            public final String trigger;

                            /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$Companion, reason: from kotlin metadata */
                            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                            public static final class Companion {
                                public final KSerializer serializer() {
                                    return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$$serializer.INSTANCE;
                                }
                            }

                            /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint */
                            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint;", "", "Companion", "ContinuationCommand", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                            @Serializable
                            public static final /* data */ class ContinuationEndpoint {

                                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                                public static final Companion INSTANCE = new Companion();
                                public final String clickTrackingParams;
                                public final ContinuationCommand continuationCommand;

                                /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$Companion, reason: from kotlin metadata */
                                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                                public static final class Companion {
                                    public final KSerializer serializer() {
                                        return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$$serializer.INSTANCE;
                                    }
                                }

                                /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand */
                                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                                @Serializable
                                public static final /* data */ class ContinuationCommand {

                                    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                                    public static final Companion INSTANCE = new Companion();
                                    public final String request;
                                    public final String token;

                                    /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand$Companion, reason: from kotlin metadata */
                                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                                    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                                    public static final class Companion {
                                        public final KSerializer serializer() {
                                            return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$ItemSectionRenderer$Content$ContinuationItemRenderer$ContinuationEndpoint$ContinuationCommand$$serializer.INSTANCE;
                                        }
                                    }

                                    public /* synthetic */ ContinuationCommand(int i, String str, String str2) {
                                        if ((i & 1) == 0) {
                                            this.token = null;
                                        } else {
                                            this.token = str;
                                        }
                                        if ((i & 2) == 0) {
                                            this.request = null;
                                        } else {
                                            this.request = str2;
                                        }
                                    }

                                    public final boolean equals(Object obj) {
                                        if (this == obj) {
                                            return true;
                                        }
                                        if (!(obj instanceof ContinuationCommand)) {
                                            return false;
                                        }
                                        ContinuationCommand continuationCommand = (ContinuationCommand) obj;
                                        return Intrinsics.areEqual(this.token, continuationCommand.token) && Intrinsics.areEqual(this.request, continuationCommand.request);
                                    }

                                    public final int hashCode() {
                                        String str = this.token;
                                        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                                        String str2 = this.request;
                                        return iHashCode + (str2 != null ? str2.hashCode() : 0);
                                    }

                                    public final String toString() {
                                        return Fragment$5$$ExternalSyntheticOutline0.m("ContinuationCommand(token=", this.token, ", request=", this.request, ")");
                                    }
                                }

                                public /* synthetic */ ContinuationEndpoint(int i, String str, ContinuationCommand continuationCommand) {
                                    if ((i & 1) == 0) {
                                        this.clickTrackingParams = null;
                                    } else {
                                        this.clickTrackingParams = str;
                                    }
                                    if ((i & 2) == 0) {
                                        this.continuationCommand = null;
                                    } else {
                                        this.continuationCommand = continuationCommand;
                                    }
                                }

                                public final boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (!(obj instanceof ContinuationEndpoint)) {
                                        return false;
                                    }
                                    ContinuationEndpoint continuationEndpoint = (ContinuationEndpoint) obj;
                                    return Intrinsics.areEqual(this.clickTrackingParams, continuationEndpoint.clickTrackingParams) && Intrinsics.areEqual(this.continuationCommand, continuationEndpoint.continuationCommand);
                                }

                                public final int hashCode() {
                                    String str = this.clickTrackingParams;
                                    int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                                    ContinuationCommand continuationCommand = this.continuationCommand;
                                    return iHashCode + (continuationCommand != null ? continuationCommand.hashCode() : 0);
                                }

                                public final String toString() {
                                    return "ContinuationEndpoint(clickTrackingParams=" + this.clickTrackingParams + ", continuationCommand=" + this.continuationCommand + ")";
                                }
                            }

                            public /* synthetic */ ContinuationItemRenderer(int i, String str, ContinuationEndpoint continuationEndpoint) {
                                if ((i & 1) == 0) {
                                    this.trigger = null;
                                } else {
                                    this.trigger = str;
                                }
                                if ((i & 2) == 0) {
                                    this.continuationEndpoint = null;
                                } else {
                                    this.continuationEndpoint = continuationEndpoint;
                                }
                            }

                            public final boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (!(obj instanceof ContinuationItemRenderer)) {
                                    return false;
                                }
                                ContinuationItemRenderer continuationItemRenderer = (ContinuationItemRenderer) obj;
                                return Intrinsics.areEqual(this.trigger, continuationItemRenderer.trigger) && Intrinsics.areEqual(this.continuationEndpoint, continuationItemRenderer.continuationEndpoint);
                            }

                            public final int hashCode() {
                                String str = this.trigger;
                                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                                ContinuationEndpoint continuationEndpoint = this.continuationEndpoint;
                                return iHashCode + (continuationEndpoint != null ? continuationEndpoint.hashCode() : 0);
                            }

                            public final String toString() {
                                return "ContinuationItemRenderer(trigger=" + this.trigger + ", continuationEndpoint=" + this.continuationEndpoint + ")";
                            }
                        }

                        public /* synthetic */ C0003Content(int i, ContinuationItemRenderer continuationItemRenderer) {
                            if ((i & 1) == 0) {
                                this.continuationItemRenderer = null;
                            } else {
                                this.continuationItemRenderer = continuationItemRenderer;
                            }
                        }

                        public final boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return (obj instanceof C0003Content) && Intrinsics.areEqual(this.continuationItemRenderer, ((C0003Content) obj).continuationItemRenderer);
                        }

                        public final int hashCode() {
                            ContinuationItemRenderer continuationItemRenderer = this.continuationItemRenderer;
                            if (continuationItemRenderer == null) {
                                return 0;
                            }
                            return continuationItemRenderer.hashCode();
                        }

                        public final String toString() {
                            return "Content(continuationItemRenderer=" + this.continuationItemRenderer + ")";
                        }
                    }

                    public /* synthetic */ ItemSectionRenderer(int i, List list) {
                        if ((i & 1) == 0) {
                            this.contents = null;
                        } else {
                            this.contents = list;
                        }
                    }

                    public final boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return (obj instanceof ItemSectionRenderer) && Intrinsics.areEqual(this.contents, ((ItemSectionRenderer) obj).contents);
                    }

                    public final int hashCode() {
                        List list = this.contents;
                        if (list == null) {
                            return 0;
                        }
                        return list.hashCode();
                    }

                    public final String toString() {
                        return Fragment$5$$ExternalSyntheticOutline0.m("ItemSectionRenderer(contents=", ")", this.contents);
                    }
                }

                /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer */
                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0002¨\u0006\u0007"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer;", "", "Companion", "Title", "ViewCount", "DateText", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                @Serializable
                public static final /* data */ class VideoPrimaryInfoRenderer {

                    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                    public static final Companion INSTANCE = new Companion();
                    public final DateText dateText;
                    public final Title title;
                    public final ViewCount viewCount;

                    /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$Companion, reason: from kotlin metadata */
                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                    public static final class Companion {
                        public final KSerializer serializer() {
                            return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$$serializer.INSTANCE;
                        }
                    }

                    /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$DateText */
                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$DateText;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                    @Serializable
                    public static final /* data */ class DateText {

                        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                        public static final Companion INSTANCE = new Companion();
                        public final String simpleText;

                        /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$DateText$Companion, reason: from kotlin metadata */
                        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$DateText$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$DateText;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                        public static final class Companion {
                            public final KSerializer serializer() {
                                return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$DateText$$serializer.INSTANCE;
                            }
                        }

                        public /* synthetic */ DateText(int i, String str) {
                            if ((i & 1) == 0) {
                                this.simpleText = null;
                            } else {
                                this.simpleText = str;
                            }
                        }

                        public final boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return (obj instanceof DateText) && Intrinsics.areEqual(this.simpleText, ((DateText) obj).simpleText);
                        }

                        public final int hashCode() {
                            String str = this.simpleText;
                            if (str == null) {
                                return 0;
                            }
                            return str.hashCode();
                        }

                        public final String toString() {
                            return IntIntPair$$ExternalSyntheticOutline0.m("DateText(simpleText=", this.simpleText, ")");
                        }
                    }

                    /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$Title */
                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$Title;", "", "Companion", "Run", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                    @Serializable
                    public static final /* data */ class Title {
                        public final List runs;

                        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                        public static final Companion INSTANCE = new Companion();
                        public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BrowseResponse$$ExternalSyntheticLambda0((byte) 3))};

                        /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$Title$Companion, reason: from kotlin metadata */
                        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$Title$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$Title;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                        public static final class Companion {
                            public final KSerializer serializer() {
                                return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$Title$$serializer.INSTANCE;
                            }
                        }

                        /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$Title$Run */
                        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$Title$Run;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                        @Serializable
                        public static final /* data */ class Run {

                            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                            public static final Companion INSTANCE = new Companion();
                            public final String text;

                            /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$Title$Run$Companion, reason: from kotlin metadata */
                            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$Title$Run$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$Title$Run;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                            public static final class Companion {
                                public final KSerializer serializer() {
                                    return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$Title$Run$$serializer.INSTANCE;
                                }
                            }

                            public /* synthetic */ Run(int i, String str) {
                                if ((i & 1) == 0) {
                                    this.text = null;
                                } else {
                                    this.text = str;
                                }
                            }

                            public final boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return (obj instanceof Run) && Intrinsics.areEqual(this.text, ((Run) obj).text);
                            }

                            public final int hashCode() {
                                String str = this.text;
                                if (str == null) {
                                    return 0;
                                }
                                return str.hashCode();
                            }

                            public final String toString() {
                                return IntIntPair$$ExternalSyntheticOutline0.m("Run(text=", this.text, ")");
                            }
                        }

                        public /* synthetic */ Title(int i, List list) {
                            if ((i & 1) == 0) {
                                this.runs = null;
                            } else {
                                this.runs = list;
                            }
                        }

                        public final boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return (obj instanceof Title) && Intrinsics.areEqual(this.runs, ((Title) obj).runs);
                        }

                        public final int hashCode() {
                            List list = this.runs;
                            if (list == null) {
                                return 0;
                            }
                            return list.hashCode();
                        }

                        public final String toString() {
                            return Fragment$5$$ExternalSyntheticOutline0.m("Title(runs=", ")", this.runs);
                        }
                    }

                    /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount */
                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount;", "", "Companion", "VideoViewCountRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                    @Serializable
                    public static final /* data */ class ViewCount {

                        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                        public static final Companion INSTANCE = new Companion();
                        public final VideoViewCountRenderer videoViewCountRenderer;

                        /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount$Companion, reason: from kotlin metadata */
                        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                        public static final class Companion {
                            public final KSerializer serializer() {
                                return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount$$serializer.INSTANCE;
                            }
                        }

                        /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount$VideoViewCountRenderer */
                        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount$VideoViewCountRenderer;", "", "Companion", "ViewCount", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                        @Serializable
                        public static final /* data */ class VideoViewCountRenderer {

                            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                            public static final Companion INSTANCE = new Companion();
                            public final C0004ViewCount viewCount;

                            /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount$VideoViewCountRenderer$Companion, reason: from kotlin metadata */
                            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount$VideoViewCountRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount$VideoViewCountRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                            public static final class Companion {
                                public final KSerializer serializer() {
                                    return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount$VideoViewCountRenderer$$serializer.INSTANCE;
                                }
                            }

                            /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount$VideoViewCountRenderer$ViewCount, reason: collision with other inner class name */
                            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount$VideoViewCountRenderer$ViewCount;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                            @Serializable
                            public static final /* data */ class C0004ViewCount {

                                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                                public static final Companion INSTANCE = new Companion();
                                public final String simpleText;

                                /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount$VideoViewCountRenderer$ViewCount$Companion, reason: from kotlin metadata */
                                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount$VideoViewCountRenderer$ViewCount$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount$VideoViewCountRenderer$ViewCount;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                                public static final class Companion {
                                    public final KSerializer serializer() {
                                        return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoPrimaryInfoRenderer$ViewCount$VideoViewCountRenderer$ViewCount$$serializer.INSTANCE;
                                    }
                                }

                                public /* synthetic */ C0004ViewCount(int i, String str) {
                                    if ((i & 1) == 0) {
                                        this.simpleText = null;
                                    } else {
                                        this.simpleText = str;
                                    }
                                }

                                public final boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    return (obj instanceof C0004ViewCount) && Intrinsics.areEqual(this.simpleText, ((C0004ViewCount) obj).simpleText);
                                }

                                public final int hashCode() {
                                    String str = this.simpleText;
                                    if (str == null) {
                                        return 0;
                                    }
                                    return str.hashCode();
                                }

                                public final String toString() {
                                    return IntIntPair$$ExternalSyntheticOutline0.m("ViewCount(simpleText=", this.simpleText, ")");
                                }
                            }

                            public /* synthetic */ VideoViewCountRenderer(int i, C0004ViewCount c0004ViewCount) {
                                if ((i & 1) == 0) {
                                    this.viewCount = null;
                                } else {
                                    this.viewCount = c0004ViewCount;
                                }
                            }

                            public final boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return (obj instanceof VideoViewCountRenderer) && Intrinsics.areEqual(this.viewCount, ((VideoViewCountRenderer) obj).viewCount);
                            }

                            public final int hashCode() {
                                C0004ViewCount c0004ViewCount = this.viewCount;
                                if (c0004ViewCount == null) {
                                    return 0;
                                }
                                return c0004ViewCount.hashCode();
                            }

                            public final String toString() {
                                return "VideoViewCountRenderer(viewCount=" + this.viewCount + ")";
                            }
                        }

                        public /* synthetic */ ViewCount(int i, VideoViewCountRenderer videoViewCountRenderer) {
                            if ((i & 1) == 0) {
                                this.videoViewCountRenderer = null;
                            } else {
                                this.videoViewCountRenderer = videoViewCountRenderer;
                            }
                        }

                        public final boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return (obj instanceof ViewCount) && Intrinsics.areEqual(this.videoViewCountRenderer, ((ViewCount) obj).videoViewCountRenderer);
                        }

                        public final int hashCode() {
                            VideoViewCountRenderer videoViewCountRenderer = this.videoViewCountRenderer;
                            if (videoViewCountRenderer == null) {
                                return 0;
                            }
                            return videoViewCountRenderer.hashCode();
                        }

                        public final String toString() {
                            return "ViewCount(videoViewCountRenderer=" + this.videoViewCountRenderer + ")";
                        }
                    }

                    public /* synthetic */ VideoPrimaryInfoRenderer(int i, Title title, ViewCount viewCount, DateText dateText) {
                        if ((i & 1) == 0) {
                            this.title = null;
                        } else {
                            this.title = title;
                        }
                        if ((i & 2) == 0) {
                            this.viewCount = null;
                        } else {
                            this.viewCount = viewCount;
                        }
                        if ((i & 4) == 0) {
                            this.dateText = null;
                        } else {
                            this.dateText = dateText;
                        }
                    }

                    public final boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof VideoPrimaryInfoRenderer)) {
                            return false;
                        }
                        VideoPrimaryInfoRenderer videoPrimaryInfoRenderer = (VideoPrimaryInfoRenderer) obj;
                        return Intrinsics.areEqual(this.title, videoPrimaryInfoRenderer.title) && Intrinsics.areEqual(this.viewCount, videoPrimaryInfoRenderer.viewCount) && Intrinsics.areEqual(this.dateText, videoPrimaryInfoRenderer.dateText);
                    }

                    public final int hashCode() {
                        Title title = this.title;
                        int iHashCode = (title == null ? 0 : title.hashCode()) * 31;
                        ViewCount viewCount = this.viewCount;
                        int iHashCode2 = (iHashCode + (viewCount == null ? 0 : viewCount.hashCode())) * 31;
                        DateText dateText = this.dateText;
                        return iHashCode2 + (dateText != null ? dateText.hashCode() : 0);
                    }

                    public final String toString() {
                        return "VideoPrimaryInfoRenderer(title=" + this.title + ", viewCount=" + this.viewCount + ", dateText=" + this.dateText + ")";
                    }
                }

                /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer */
                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0004\u0003\u0004\u0005\u0002¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer;", "", "Companion", "AttributedDescription", "Owner", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                @Serializable
                public static final /* data */ class VideoSecondaryInfoRenderer {

                    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                    public static final Companion INSTANCE = new Companion();
                    public final AttributedDescription attributedDescription;
                    public final Owner owner;

                    /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$AttributedDescription */
                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$AttributedDescription;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                    @Serializable
                    public static final /* data */ class AttributedDescription {

                        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                        public static final Companion INSTANCE = new Companion();
                        public final String content;

                        /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$AttributedDescription$Companion, reason: from kotlin metadata */
                        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$AttributedDescription$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$AttributedDescription;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                        public static final class Companion {
                            public final KSerializer serializer() {
                                return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$AttributedDescription$$serializer.INSTANCE;
                            }
                        }

                        public /* synthetic */ AttributedDescription(int i, String str) {
                            if ((i & 1) == 0) {
                                this.content = null;
                            } else {
                                this.content = str;
                            }
                        }

                        public final boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return (obj instanceof AttributedDescription) && Intrinsics.areEqual(this.content, ((AttributedDescription) obj).content);
                        }

                        public final int hashCode() {
                            String str = this.content;
                            if (str == null) {
                                return 0;
                            }
                            return str.hashCode();
                        }

                        public final String toString() {
                            return IntIntPair$$ExternalSyntheticOutline0.m("AttributedDescription(content=", this.content, ")");
                        }
                    }

                    /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Companion, reason: from kotlin metadata */
                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                    public static final class Companion {
                        public final KSerializer serializer() {
                            return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$$serializer.INSTANCE;
                        }
                    }

                    /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner */
                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner;", "", "Companion", "VideoOwnerRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                    @Serializable
                    public static final /* data */ class Owner {

                        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                        public static final Companion INSTANCE = new Companion();
                        public final VideoOwnerRenderer videoOwnerRenderer;

                        /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$Companion, reason: from kotlin metadata */
                        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                        public static final class Companion {
                            public final KSerializer serializer() {
                                return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$$serializer.INSTANCE;
                            }
                        }

                        /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer */
                        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0002¨\u0006\u0007"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer;", "", "Companion", "Thumbnail", "SubscriberCountText", "Title", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                        @Serializable
                        public static final /* data */ class VideoOwnerRenderer {

                            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                            public static final Companion INSTANCE = new Companion();
                            public final NavigationEndpoint navigationEndpoint;
                            public final SubscriberCountText subscriberCountText;
                            public final Thumbnail thumbnail;
                            public final Title title;

                            /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Companion, reason: from kotlin metadata */
                            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                            public static final class Companion {
                                public final KSerializer serializer() {
                                    return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$$serializer.INSTANCE;
                                }
                            }

                            /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$SubscriberCountText */
                            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$SubscriberCountText;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                            @Serializable
                            public static final /* data */ class SubscriberCountText {

                                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                                public static final Companion INSTANCE = new Companion();
                                public final String simpleText;

                                /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$SubscriberCountText$Companion, reason: from kotlin metadata */
                                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$SubscriberCountText$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$SubscriberCountText;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                                public static final class Companion {
                                    public final KSerializer serializer() {
                                        return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$SubscriberCountText$$serializer.INSTANCE;
                                    }
                                }

                                public /* synthetic */ SubscriberCountText(int i, String str) {
                                    if ((i & 1) == 0) {
                                        this.simpleText = null;
                                    } else {
                                        this.simpleText = str;
                                    }
                                }

                                public final boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    return (obj instanceof SubscriberCountText) && Intrinsics.areEqual(this.simpleText, ((SubscriberCountText) obj).simpleText);
                                }

                                public final int hashCode() {
                                    String str = this.simpleText;
                                    if (str == null) {
                                        return 0;
                                    }
                                    return str.hashCode();
                                }

                                public final String toString() {
                                    return IntIntPair$$ExternalSyntheticOutline0.m("SubscriberCountText(simpleText=", this.simpleText, ")");
                                }
                            }

                            /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Thumbnail */
                            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Thumbnail;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                            @Serializable
                            public static final /* data */ class Thumbnail {
                                public final List thumbnails;

                                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                                public static final Companion INSTANCE = new Companion();
                                public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BrowseResponse$$ExternalSyntheticLambda0((byte) 4))};

                                /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Thumbnail$Companion, reason: from kotlin metadata */
                                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Thumbnail$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Thumbnail;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                                public static final class Companion {
                                    public final KSerializer serializer() {
                                        return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Thumbnail$$serializer.INSTANCE;
                                    }
                                }

                                public /* synthetic */ Thumbnail(int i, List list) {
                                    if ((i & 1) == 0) {
                                        this.thumbnails = null;
                                    } else {
                                        this.thumbnails = list;
                                    }
                                }

                                public final boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    return (obj instanceof Thumbnail) && Intrinsics.areEqual(this.thumbnails, ((Thumbnail) obj).thumbnails);
                                }

                                public final int hashCode() {
                                    List list = this.thumbnails;
                                    if (list == null) {
                                        return 0;
                                    }
                                    return list.hashCode();
                                }

                                public final String toString() {
                                    return Fragment$5$$ExternalSyntheticOutline0.m("Thumbnail(thumbnails=", ")", this.thumbnails);
                                }
                            }

                            /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Title */
                            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Title;", "", "Companion", "Run", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                            @Serializable
                            public static final /* data */ class Title {
                                public final List runs;

                                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                                public static final Companion INSTANCE = new Companion();
                                public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BrowseResponse$$ExternalSyntheticLambda0((byte) 5))};

                                /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Title$Companion, reason: from kotlin metadata */
                                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Title$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Title;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                                public static final class Companion {
                                    public final KSerializer serializer() {
                                        return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Title$$serializer.INSTANCE;
                                    }
                                }

                                /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Title$Run */
                                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Title$Run;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                                @Serializable
                                public static final /* data */ class Run {

                                    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                                    public static final Companion INSTANCE = new Companion();
                                    public final String text;

                                    /* JADX INFO: renamed from: com.metrolist.innertube.models.YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Title$Run$Companion, reason: from kotlin metadata */
                                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                                    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Title$Run$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Title$Run;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                                    public static final class Companion {
                                        public final KSerializer serializer() {
                                            return YouTubeDataPage$Contents$TwoColumnWatchNextResults$Results$Results$Content$VideoSecondaryInfoRenderer$Owner$VideoOwnerRenderer$Title$Run$$serializer.INSTANCE;
                                        }
                                    }

                                    public /* synthetic */ Run(int i, String str) {
                                        if ((i & 1) == 0) {
                                            this.text = null;
                                        } else {
                                            this.text = str;
                                        }
                                    }

                                    public final boolean equals(Object obj) {
                                        if (this == obj) {
                                            return true;
                                        }
                                        return (obj instanceof Run) && Intrinsics.areEqual(this.text, ((Run) obj).text);
                                    }

                                    public final int hashCode() {
                                        String str = this.text;
                                        if (str == null) {
                                            return 0;
                                        }
                                        return str.hashCode();
                                    }

                                    public final String toString() {
                                        return IntIntPair$$ExternalSyntheticOutline0.m("Run(text=", this.text, ")");
                                    }
                                }

                                public /* synthetic */ Title(int i, List list) {
                                    if ((i & 1) == 0) {
                                        this.runs = null;
                                    } else {
                                        this.runs = list;
                                    }
                                }

                                public final boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    return (obj instanceof Title) && Intrinsics.areEqual(this.runs, ((Title) obj).runs);
                                }

                                public final int hashCode() {
                                    List list = this.runs;
                                    if (list == null) {
                                        return 0;
                                    }
                                    return list.hashCode();
                                }

                                public final String toString() {
                                    return Fragment$5$$ExternalSyntheticOutline0.m("Title(runs=", ")", this.runs);
                                }
                            }

                            public /* synthetic */ VideoOwnerRenderer(int i, Thumbnail thumbnail, SubscriberCountText subscriberCountText, Title title, NavigationEndpoint navigationEndpoint) {
                                if ((i & 1) == 0) {
                                    this.thumbnail = null;
                                } else {
                                    this.thumbnail = thumbnail;
                                }
                                if ((i & 2) == 0) {
                                    this.subscriberCountText = null;
                                } else {
                                    this.subscriberCountText = subscriberCountText;
                                }
                                if ((i & 4) == 0) {
                                    this.title = null;
                                } else {
                                    this.title = title;
                                }
                                if ((i & 8) == 0) {
                                    this.navigationEndpoint = null;
                                } else {
                                    this.navigationEndpoint = navigationEndpoint;
                                }
                            }

                            public final boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (!(obj instanceof VideoOwnerRenderer)) {
                                    return false;
                                }
                                VideoOwnerRenderer videoOwnerRenderer = (VideoOwnerRenderer) obj;
                                return Intrinsics.areEqual(this.thumbnail, videoOwnerRenderer.thumbnail) && Intrinsics.areEqual(this.subscriberCountText, videoOwnerRenderer.subscriberCountText) && Intrinsics.areEqual(this.title, videoOwnerRenderer.title) && Intrinsics.areEqual(this.navigationEndpoint, videoOwnerRenderer.navigationEndpoint);
                            }

                            public final int hashCode() {
                                Thumbnail thumbnail = this.thumbnail;
                                int iHashCode = (thumbnail == null ? 0 : thumbnail.hashCode()) * 31;
                                SubscriberCountText subscriberCountText = this.subscriberCountText;
                                int iHashCode2 = (iHashCode + (subscriberCountText == null ? 0 : subscriberCountText.hashCode())) * 31;
                                Title title = this.title;
                                int iHashCode3 = (iHashCode2 + (title == null ? 0 : title.hashCode())) * 31;
                                NavigationEndpoint navigationEndpoint = this.navigationEndpoint;
                                return iHashCode3 + (navigationEndpoint != null ? navigationEndpoint.hashCode() : 0);
                            }

                            public final String toString() {
                                return "VideoOwnerRenderer(thumbnail=" + this.thumbnail + ", subscriberCountText=" + this.subscriberCountText + ", title=" + this.title + ", navigationEndpoint=" + this.navigationEndpoint + ")";
                            }
                        }

                        public /* synthetic */ Owner(int i, VideoOwnerRenderer videoOwnerRenderer) {
                            if ((i & 1) == 0) {
                                this.videoOwnerRenderer = null;
                            } else {
                                this.videoOwnerRenderer = videoOwnerRenderer;
                            }
                        }

                        public final boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return (obj instanceof Owner) && Intrinsics.areEqual(this.videoOwnerRenderer, ((Owner) obj).videoOwnerRenderer);
                        }

                        public final int hashCode() {
                            VideoOwnerRenderer videoOwnerRenderer = this.videoOwnerRenderer;
                            if (videoOwnerRenderer == null) {
                                return 0;
                            }
                            return videoOwnerRenderer.hashCode();
                        }

                        public final String toString() {
                            return "Owner(videoOwnerRenderer=" + this.videoOwnerRenderer + ")";
                        }
                    }

                    public /* synthetic */ VideoSecondaryInfoRenderer(int i, Owner owner, AttributedDescription attributedDescription) {
                        if ((i & 1) == 0) {
                            this.owner = null;
                        } else {
                            this.owner = owner;
                        }
                        if ((i & 2) == 0) {
                            this.attributedDescription = null;
                        } else {
                            this.attributedDescription = attributedDescription;
                        }
                    }

                    public final boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof VideoSecondaryInfoRenderer)) {
                            return false;
                        }
                        VideoSecondaryInfoRenderer videoSecondaryInfoRenderer = (VideoSecondaryInfoRenderer) obj;
                        return Intrinsics.areEqual(this.owner, videoSecondaryInfoRenderer.owner) && Intrinsics.areEqual(this.attributedDescription, videoSecondaryInfoRenderer.attributedDescription);
                    }

                    public final int hashCode() {
                        Owner owner = this.owner;
                        int iHashCode = (owner == null ? 0 : owner.hashCode()) * 31;
                        AttributedDescription attributedDescription = this.attributedDescription;
                        return iHashCode + (attributedDescription != null ? attributedDescription.hashCode() : 0);
                    }

                    public final String toString() {
                        return "VideoSecondaryInfoRenderer(owner=" + this.owner + ", attributedDescription=" + this.attributedDescription + ")";
                    }
                }

                public /* synthetic */ Content(int i, VideoPrimaryInfoRenderer videoPrimaryInfoRenderer, VideoSecondaryInfoRenderer videoSecondaryInfoRenderer, ItemSectionRenderer itemSectionRenderer) {
                    if ((i & 1) == 0) {
                        this.videoPrimaryInfoRenderer = null;
                    } else {
                        this.videoPrimaryInfoRenderer = videoPrimaryInfoRenderer;
                    }
                    if ((i & 2) == 0) {
                        this.videoSecondaryInfoRenderer = null;
                    } else {
                        this.videoSecondaryInfoRenderer = videoSecondaryInfoRenderer;
                    }
                    if ((i & 4) == 0) {
                        this.itemSectionRenderer = null;
                    } else {
                        this.itemSectionRenderer = itemSectionRenderer;
                    }
                }

                public final boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Content)) {
                        return false;
                    }
                    Content content = (Content) obj;
                    return Intrinsics.areEqual(this.videoPrimaryInfoRenderer, content.videoPrimaryInfoRenderer) && Intrinsics.areEqual(this.videoSecondaryInfoRenderer, content.videoSecondaryInfoRenderer) && Intrinsics.areEqual(this.itemSectionRenderer, content.itemSectionRenderer);
                }

                public final int hashCode() {
                    VideoPrimaryInfoRenderer videoPrimaryInfoRenderer = this.videoPrimaryInfoRenderer;
                    int iHashCode = (videoPrimaryInfoRenderer == null ? 0 : videoPrimaryInfoRenderer.hashCode()) * 31;
                    VideoSecondaryInfoRenderer videoSecondaryInfoRenderer = this.videoSecondaryInfoRenderer;
                    int iHashCode2 = (iHashCode + (videoSecondaryInfoRenderer == null ? 0 : videoSecondaryInfoRenderer.hashCode())) * 31;
                    ItemSectionRenderer itemSectionRenderer = this.itemSectionRenderer;
                    return iHashCode2 + (itemSectionRenderer != null ? itemSectionRenderer.hashCode() : 0);
                }

                public final String toString() {
                    return "Content(videoPrimaryInfoRenderer=" + this.videoPrimaryInfoRenderer + ", videoSecondaryInfoRenderer=" + this.videoSecondaryInfoRenderer + ", itemSectionRenderer=" + this.itemSectionRenderer + ")";
                }
            }

            public /* synthetic */ C0002Results(int i, List list) {
                if ((i & 1) == 0) {
                    this.content = null;
                } else {
                    this.content = list;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0002Results) && Intrinsics.areEqual(this.content, ((C0002Results) obj).content);
            }

            public final int hashCode() {
                List list = this.content;
                if (list == null) {
                    return 0;
                }
                return list.hashCode();
            }

            public final String toString() {
                return Fragment$5$$ExternalSyntheticOutline0.m("Results(content=", ")", this.content);
            }
        }

        public /* synthetic */ Results(int i, C0002Results c0002Results) {
            if ((i & 1) == 0) {
                this.results = null;
            } else {
                this.results = c0002Results;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Results) && Intrinsics.areEqual(this.results, ((Results) obj).results);
        }

        public final int hashCode() {
            C0002Results c0002Results = this.results;
            if (c0002Results == null) {
                return 0;
            }
            return c0002Results.hashCode();
        }

        public final String toString() {
            return "Results(results=" + this.results + ")";
        }
    }

    public /* synthetic */ YouTubeDataPage$Contents$TwoColumnWatchNextResults(int i, Results results) {
        if ((i & 1) == 0) {
            this.results = null;
        } else {
            this.results = results;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof YouTubeDataPage$Contents$TwoColumnWatchNextResults) && Intrinsics.areEqual(this.results, ((YouTubeDataPage$Contents$TwoColumnWatchNextResults) obj).results);
    }

    public final int hashCode() {
        Results results = this.results;
        if (results == null) {
            return 0;
        }
        return results.hashCode();
    }

    public final String toString() {
        return "TwoColumnWatchNextResults(results=" + this.results + ")";
    }
}
