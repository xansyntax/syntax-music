package com.metrolist.innertube.models.response;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse;", "", "Companion", "Action", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class GetTranscriptResponse {
    public final List actions;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BrowseResponse$$ExternalSyntheticLambda0((byte) 20))};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action;", "", "Companion", "UpdateEngagementPanelAction", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Action {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final UpdateEngagementPanelAction updateEngagementPanelAction;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return GetTranscriptResponse$Action$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction;", "", "Companion", "Content", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class UpdateEngagementPanelAction {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final Content content;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return GetTranscriptResponse$Action$UpdateEngagementPanelAction$$serializer.INSTANCE;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content;", "", "Companion", "TranscriptRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            @Serializable
            public static final /* data */ class Content {

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion();
                public final TranscriptRenderer transcriptRenderer;

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                public static final class Companion {
                    public final KSerializer serializer() {
                        return GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$$serializer.INSTANCE;
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer;", "", "Companion", "Body", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                @Serializable
                public static final /* data */ class TranscriptRenderer {

                    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                    public static final Companion INSTANCE = new Companion();
                    public final Body body;

                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body;", "", "Companion", "TranscriptBodyRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                    @Serializable
                    public static final /* data */ class Body {

                        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                        public static final Companion INSTANCE = new Companion();
                        public final TranscriptBodyRenderer transcriptBodyRenderer;

                        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                        public static final class Companion {
                            public final KSerializer serializer() {
                                return GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$$serializer.INSTANCE;
                            }
                        }

                        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer;", "", "Companion", "CueGroup", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                        @Serializable
                        public static final /* data */ class TranscriptBodyRenderer {
                            public final List cueGroups;

                            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                            public static final Companion INSTANCE = new Companion();
                            public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BrowseResponse$$ExternalSyntheticLambda0((byte) 21))};

                            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                            public static final class Companion {
                                public final KSerializer serializer() {
                                    return GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$$serializer.INSTANCE;
                                }
                            }

                            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup;", "", "Companion", "TranscriptCueGroupRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                            @Serializable
                            public static final /* data */ class CueGroup {

                                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                                public static final Companion INSTANCE = new Companion();
                                public final TranscriptCueGroupRenderer transcriptCueGroupRenderer;

                                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                                public static final class Companion {
                                    public final KSerializer serializer() {
                                        return GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$$serializer.INSTANCE;
                                    }
                                }

                                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer;", "", "Companion", "Cue", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                                @Serializable
                                public static final /* data */ class TranscriptCueGroupRenderer {
                                    public final List cues;

                                    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                                    public static final Companion INSTANCE = new Companion();
                                    public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BrowseResponse$$ExternalSyntheticLambda0((byte) 22))};

                                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                                    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                                    public static final class Companion {
                                        public final KSerializer serializer() {
                                            return GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$$serializer.INSTANCE;
                                        }
                                    }

                                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue;", "", "Companion", "TranscriptCueRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                                    @Serializable
                                    public static final /* data */ class Cue {

                                        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                                        public static final Companion INSTANCE = new Companion();
                                        public final TranscriptCueRenderer transcriptCueRenderer;

                                        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                                        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                                        public static final class Companion {
                                            public final KSerializer serializer() {
                                                return GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$$serializer.INSTANCE;
                                            }
                                        }

                                        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                                        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$TranscriptCueRenderer;", "", "Companion", "SimpleText", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                                        @Serializable
                                        public static final /* data */ class TranscriptCueRenderer {

                                            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                                            public static final Companion INSTANCE = new Companion();
                                            public final SimpleText cue;
                                            public final long durationMs;
                                            public final long startOffsetMs;

                                            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                                            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$TranscriptCueRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$TranscriptCueRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                                            public static final class Companion {
                                                public final KSerializer serializer() {
                                                    return GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$TranscriptCueRenderer$$serializer.INSTANCE;
                                                }
                                            }

                                            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                                            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$TranscriptCueRenderer$SimpleText;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                                            @Serializable
                                            public static final /* data */ class SimpleText {

                                                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                                                public static final Companion INSTANCE = new Companion();
                                                public final String simpleText;

                                                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                                                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$TranscriptCueRenderer$SimpleText$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$TranscriptCueRenderer$SimpleText;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                                                public static final class Companion {
                                                    public final KSerializer serializer() {
                                                        return GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$TranscriptCueRenderer$SimpleText$$serializer.INSTANCE;
                                                    }
                                                }

                                                public /* synthetic */ SimpleText(int i, String str) {
                                                    if (1 == (i & 1)) {
                                                        this.simpleText = str;
                                                    } else {
                                                        EnumsKt.throwMissingFieldException(GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$TranscriptCueRenderer$SimpleText$$serializer.INSTANCE.getDescriptor(), i, 1);
                                                        throw null;
                                                    }
                                                }

                                                public final boolean equals(Object obj) {
                                                    if (this == obj) {
                                                        return true;
                                                    }
                                                    return (obj instanceof SimpleText) && Intrinsics.areEqual(this.simpleText, ((SimpleText) obj).simpleText);
                                                }

                                                public final int hashCode() {
                                                    return this.simpleText.hashCode();
                                                }

                                                public final String toString() {
                                                    return IntIntPair$$ExternalSyntheticOutline0.m("SimpleText(simpleText=", this.simpleText, ")");
                                                }
                                            }

                                            public /* synthetic */ TranscriptCueRenderer(int i, SimpleText simpleText, long j, long j2) {
                                                if (7 != (i & 7)) {
                                                    EnumsKt.throwMissingFieldException(GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$TranscriptCueRenderer$$serializer.INSTANCE.getDescriptor(), i, 7);
                                                    throw null;
                                                }
                                                this.cue = simpleText;
                                                this.startOffsetMs = j;
                                                this.durationMs = j2;
                                            }

                                            public final boolean equals(Object obj) {
                                                if (this == obj) {
                                                    return true;
                                                }
                                                if (!(obj instanceof TranscriptCueRenderer)) {
                                                    return false;
                                                }
                                                TranscriptCueRenderer transcriptCueRenderer = (TranscriptCueRenderer) obj;
                                                return Intrinsics.areEqual(this.cue, transcriptCueRenderer.cue) && this.startOffsetMs == transcriptCueRenderer.startOffsetMs && this.durationMs == transcriptCueRenderer.durationMs;
                                            }

                                            public final int hashCode() {
                                                return Long.hashCode(this.durationMs) + IntIntPair$$ExternalSyntheticOutline0.m(this.cue.simpleText.hashCode() * 31, 31, this.startOffsetMs);
                                            }

                                            public final String toString() {
                                                return "TranscriptCueRenderer(cue=" + this.cue + ", startOffsetMs=" + this.startOffsetMs + ", durationMs=" + this.durationMs + ")";
                                            }
                                        }

                                        public /* synthetic */ Cue(int i, TranscriptCueRenderer transcriptCueRenderer) {
                                            if (1 == (i & 1)) {
                                                this.transcriptCueRenderer = transcriptCueRenderer;
                                            } else {
                                                EnumsKt.throwMissingFieldException(GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$Cue$$serializer.INSTANCE.getDescriptor(), i, 1);
                                                throw null;
                                            }
                                        }

                                        public final boolean equals(Object obj) {
                                            if (this == obj) {
                                                return true;
                                            }
                                            return (obj instanceof Cue) && Intrinsics.areEqual(this.transcriptCueRenderer, ((Cue) obj).transcriptCueRenderer);
                                        }

                                        public final int hashCode() {
                                            return this.transcriptCueRenderer.hashCode();
                                        }

                                        public final String toString() {
                                            return "Cue(transcriptCueRenderer=" + this.transcriptCueRenderer + ")";
                                        }
                                    }

                                    public /* synthetic */ TranscriptCueGroupRenderer(int i, List list) {
                                        if (1 == (i & 1)) {
                                            this.cues = list;
                                        } else {
                                            EnumsKt.throwMissingFieldException(GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$TranscriptCueGroupRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
                                            throw null;
                                        }
                                    }

                                    public final boolean equals(Object obj) {
                                        if (this == obj) {
                                            return true;
                                        }
                                        return (obj instanceof TranscriptCueGroupRenderer) && Intrinsics.areEqual(this.cues, ((TranscriptCueGroupRenderer) obj).cues);
                                    }

                                    public final int hashCode() {
                                        return this.cues.hashCode();
                                    }

                                    public final String toString() {
                                        return Fragment$5$$ExternalSyntheticOutline0.m("TranscriptCueGroupRenderer(cues=", ")", this.cues);
                                    }
                                }

                                public /* synthetic */ CueGroup(int i, TranscriptCueGroupRenderer transcriptCueGroupRenderer) {
                                    if (1 == (i & 1)) {
                                        this.transcriptCueGroupRenderer = transcriptCueGroupRenderer;
                                    } else {
                                        EnumsKt.throwMissingFieldException(GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$CueGroup$$serializer.INSTANCE.getDescriptor(), i, 1);
                                        throw null;
                                    }
                                }

                                public final boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    return (obj instanceof CueGroup) && Intrinsics.areEqual(this.transcriptCueGroupRenderer, ((CueGroup) obj).transcriptCueGroupRenderer);
                                }

                                public final int hashCode() {
                                    return this.transcriptCueGroupRenderer.cues.hashCode();
                                }

                                public final String toString() {
                                    return "CueGroup(transcriptCueGroupRenderer=" + this.transcriptCueGroupRenderer + ")";
                                }
                            }

                            public /* synthetic */ TranscriptBodyRenderer(int i, List list) {
                                if (1 == (i & 1)) {
                                    this.cueGroups = list;
                                } else {
                                    EnumsKt.throwMissingFieldException(GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$TranscriptBodyRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
                                    throw null;
                                }
                            }

                            public final boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return (obj instanceof TranscriptBodyRenderer) && Intrinsics.areEqual(this.cueGroups, ((TranscriptBodyRenderer) obj).cueGroups);
                            }

                            public final int hashCode() {
                                return this.cueGroups.hashCode();
                            }

                            public final String toString() {
                                return Fragment$5$$ExternalSyntheticOutline0.m("TranscriptBodyRenderer(cueGroups=", ")", this.cueGroups);
                            }
                        }

                        public /* synthetic */ Body(int i, TranscriptBodyRenderer transcriptBodyRenderer) {
                            if (1 == (i & 1)) {
                                this.transcriptBodyRenderer = transcriptBodyRenderer;
                            } else {
                                EnumsKt.throwMissingFieldException(GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Body$$serializer.INSTANCE.getDescriptor(), i, 1);
                                throw null;
                            }
                        }

                        public final boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return (obj instanceof Body) && Intrinsics.areEqual(this.transcriptBodyRenderer, ((Body) obj).transcriptBodyRenderer);
                        }

                        public final int hashCode() {
                            return this.transcriptBodyRenderer.cueGroups.hashCode();
                        }

                        public final String toString() {
                            return "Body(transcriptBodyRenderer=" + this.transcriptBodyRenderer + ")";
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                    public static final class Companion {
                        public final KSerializer serializer() {
                            return GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ TranscriptRenderer(int i, Body body) {
                        if (1 == (i & 1)) {
                            this.body = body;
                        } else {
                            EnumsKt.throwMissingFieldException(GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$TranscriptRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
                            throw null;
                        }
                    }

                    public final boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return (obj instanceof TranscriptRenderer) && Intrinsics.areEqual(this.body, ((TranscriptRenderer) obj).body);
                    }

                    public final int hashCode() {
                        return this.body.hashCode();
                    }

                    public final String toString() {
                        return "TranscriptRenderer(body=" + this.body + ")";
                    }
                }

                public /* synthetic */ Content(int i, TranscriptRenderer transcriptRenderer) {
                    if (1 == (i & 1)) {
                        this.transcriptRenderer = transcriptRenderer;
                    } else {
                        EnumsKt.throwMissingFieldException(GetTranscriptResponse$Action$UpdateEngagementPanelAction$Content$$serializer.INSTANCE.getDescriptor(), i, 1);
                        throw null;
                    }
                }

                public final boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof Content) && Intrinsics.areEqual(this.transcriptRenderer, ((Content) obj).transcriptRenderer);
                }

                public final int hashCode() {
                    return this.transcriptRenderer.body.hashCode();
                }

                public final String toString() {
                    return "Content(transcriptRenderer=" + this.transcriptRenderer + ")";
                }
            }

            public /* synthetic */ UpdateEngagementPanelAction(int i, Content content) {
                if (1 == (i & 1)) {
                    this.content = content;
                } else {
                    EnumsKt.throwMissingFieldException(GetTranscriptResponse$Action$UpdateEngagementPanelAction$$serializer.INSTANCE.getDescriptor(), i, 1);
                    throw null;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof UpdateEngagementPanelAction) && Intrinsics.areEqual(this.content, ((UpdateEngagementPanelAction) obj).content);
            }

            public final int hashCode() {
                return this.content.hashCode();
            }

            public final String toString() {
                return "UpdateEngagementPanelAction(content=" + this.content + ")";
            }
        }

        public /* synthetic */ Action(int i, UpdateEngagementPanelAction updateEngagementPanelAction) {
            if (1 == (i & 1)) {
                this.updateEngagementPanelAction = updateEngagementPanelAction;
            } else {
                EnumsKt.throwMissingFieldException(GetTranscriptResponse$Action$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Action) && Intrinsics.areEqual(this.updateEngagementPanelAction, ((Action) obj).updateEngagementPanelAction);
        }

        public final int hashCode() {
            return this.updateEngagementPanelAction.content.hashCode();
        }

        public final String toString() {
            return "Action(updateEngagementPanelAction=" + this.updateEngagementPanelAction + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/response/GetTranscriptResponse$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/response/GetTranscriptResponse;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return GetTranscriptResponse$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ GetTranscriptResponse(int i, List list) {
        if (1 == (i & 1)) {
            this.actions = list;
        } else {
            EnumsKt.throwMissingFieldException(GetTranscriptResponse$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetTranscriptResponse) && Intrinsics.areEqual(this.actions, ((GetTranscriptResponse) obj).actions);
    }

    public final int hashCode() {
        List list = this.actions;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("GetTranscriptResponse(actions=", ")", this.actions);
    }
}
