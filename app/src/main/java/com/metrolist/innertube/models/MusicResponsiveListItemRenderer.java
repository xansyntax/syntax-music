package com.metrolist.innertube.models;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0002¨\u0006\u0007"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer;", "", "Companion", "FlexColumn", "PlaylistItemData", "Overlay", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class MusicResponsiveListItemRenderer {
    public static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final List badges;
    public final List fixedColumns;
    public final List flexColumns;
    public final Menu menu;
    public final NavigationEndpoint navigationEndpoint;
    public final Overlay overlay;
    public final PlaylistItemData playlistItemData;
    public final ThumbnailRenderer thumbnail;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return MusicResponsiveListItemRenderer$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$FlexColumn;", "", "Companion", "MusicResponsiveListItemFlexColumnRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class FlexColumn {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$FlexColumn$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$FlexColumn;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return MusicResponsiveListItemRenderer$FlexColumn$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$FlexColumn$MusicResponsiveListItemFlexColumnRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class MusicResponsiveListItemFlexColumnRenderer {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final Runs text;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$FlexColumn$MusicResponsiveListItemFlexColumnRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$FlexColumn$MusicResponsiveListItemFlexColumnRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return MusicResponsiveListItemRenderer$FlexColumn$MusicResponsiveListItemFlexColumnRenderer$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ MusicResponsiveListItemFlexColumnRenderer(int i, Runs runs) {
                if (1 == (i & 1)) {
                    this.text = runs;
                } else {
                    EnumsKt.throwMissingFieldException(MusicResponsiveListItemRenderer$FlexColumn$MusicResponsiveListItemFlexColumnRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
                    throw null;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof MusicResponsiveListItemFlexColumnRenderer) && Intrinsics.areEqual(this.text, ((MusicResponsiveListItemFlexColumnRenderer) obj).text);
            }

            public final int hashCode() {
                Runs runs = this.text;
                if (runs == null) {
                    return 0;
                }
                return runs.hashCode();
            }

            public final String toString() {
                return "MusicResponsiveListItemFlexColumnRenderer(text=" + this.text + ")";
            }
        }

        public /* synthetic */ FlexColumn(int i, MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer) {
            if (1 == (i & 1)) {
                this.musicResponsiveListItemFlexColumnRenderer = musicResponsiveListItemFlexColumnRenderer;
            } else {
                EnumsKt.throwMissingFieldException(MusicResponsiveListItemRenderer$FlexColumn$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FlexColumn) && Intrinsics.areEqual(this.musicResponsiveListItemFlexColumnRenderer, ((FlexColumn) obj).musicResponsiveListItemFlexColumnRenderer);
        }

        public final int hashCode() {
            return this.musicResponsiveListItemFlexColumnRenderer.hashCode();
        }

        public final String toString() {
            return "FlexColumn(musicResponsiveListItemFlexColumnRenderer=" + this.musicResponsiveListItemFlexColumnRenderer + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$Overlay;", "", "Companion", "MusicItemThumbnailOverlayRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Overlay {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$Overlay$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$Overlay;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return MusicResponsiveListItemRenderer$Overlay$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer;", "", "Companion", "Content", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class MusicItemThumbnailOverlayRenderer {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final Content content;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$$serializer.INSTANCE;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$Content;", "", "Companion", "MusicPlayButtonRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            @Serializable
            public static final /* data */ class Content {

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion();
                public final MusicPlayButtonRenderer musicPlayButtonRenderer;

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$Content$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$Content;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                public static final class Companion {
                    public final KSerializer serializer() {
                        return MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$Content$$serializer.INSTANCE;
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$Content$MusicPlayButtonRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                @Serializable
                public static final /* data */ class MusicPlayButtonRenderer {

                    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                    public static final Companion INSTANCE = new Companion();
                    public final NavigationEndpoint playNavigationEndpoint;

                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$Content$MusicPlayButtonRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$Content$MusicPlayButtonRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                    public static final class Companion {
                        public final KSerializer serializer() {
                            return MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$Content$MusicPlayButtonRenderer$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ MusicPlayButtonRenderer(int i, NavigationEndpoint navigationEndpoint) {
                        if (1 == (i & 1)) {
                            this.playNavigationEndpoint = navigationEndpoint;
                        } else {
                            EnumsKt.throwMissingFieldException(MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$Content$MusicPlayButtonRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
                            throw null;
                        }
                    }

                    public final boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return (obj instanceof MusicPlayButtonRenderer) && Intrinsics.areEqual(this.playNavigationEndpoint, ((MusicPlayButtonRenderer) obj).playNavigationEndpoint);
                    }

                    public final int hashCode() {
                        NavigationEndpoint navigationEndpoint = this.playNavigationEndpoint;
                        if (navigationEndpoint == null) {
                            return 0;
                        }
                        return navigationEndpoint.hashCode();
                    }

                    public final String toString() {
                        return "MusicPlayButtonRenderer(playNavigationEndpoint=" + this.playNavigationEndpoint + ")";
                    }
                }

                public /* synthetic */ Content(int i, MusicPlayButtonRenderer musicPlayButtonRenderer) {
                    if (1 == (i & 1)) {
                        this.musicPlayButtonRenderer = musicPlayButtonRenderer;
                    } else {
                        EnumsKt.throwMissingFieldException(MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$Content$$serializer.INSTANCE.getDescriptor(), i, 1);
                        throw null;
                    }
                }

                public final boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof Content) && Intrinsics.areEqual(this.musicPlayButtonRenderer, ((Content) obj).musicPlayButtonRenderer);
                }

                public final int hashCode() {
                    return this.musicPlayButtonRenderer.hashCode();
                }

                public final String toString() {
                    return "Content(musicPlayButtonRenderer=" + this.musicPlayButtonRenderer + ")";
                }
            }

            public /* synthetic */ MusicItemThumbnailOverlayRenderer(int i, Content content) {
                if (1 == (i & 1)) {
                    this.content = content;
                } else {
                    EnumsKt.throwMissingFieldException(MusicResponsiveListItemRenderer$Overlay$MusicItemThumbnailOverlayRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
                    throw null;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof MusicItemThumbnailOverlayRenderer) && Intrinsics.areEqual(this.content, ((MusicItemThumbnailOverlayRenderer) obj).content);
            }

            public final int hashCode() {
                return this.content.musicPlayButtonRenderer.hashCode();
            }

            public final String toString() {
                return "MusicItemThumbnailOverlayRenderer(content=" + this.content + ")";
            }
        }

        public /* synthetic */ Overlay(int i, MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer) {
            if (1 == (i & 1)) {
                this.musicItemThumbnailOverlayRenderer = musicItemThumbnailOverlayRenderer;
            } else {
                EnumsKt.throwMissingFieldException(MusicResponsiveListItemRenderer$Overlay$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Overlay) && Intrinsics.areEqual(this.musicItemThumbnailOverlayRenderer, ((Overlay) obj).musicItemThumbnailOverlayRenderer);
        }

        public final int hashCode() {
            return this.musicItemThumbnailOverlayRenderer.hashCode();
        }

        public final String toString() {
            return "Overlay(musicItemThumbnailOverlayRenderer=" + this.musicItemThumbnailOverlayRenderer + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$PlaylistItemData;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class PlaylistItemData {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final String playlistSetVideoId;
        public final String videoId;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$PlaylistItemData$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicResponsiveListItemRenderer$PlaylistItemData;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return MusicResponsiveListItemRenderer$PlaylistItemData$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ PlaylistItemData(int i, String str, String str2) {
            if (3 != (i & 3)) {
                EnumsKt.throwMissingFieldException(MusicResponsiveListItemRenderer$PlaylistItemData$$serializer.INSTANCE.getDescriptor(), i, 3);
                throw null;
            }
            this.playlistSetVideoId = str;
            this.videoId = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlaylistItemData)) {
                return false;
            }
            PlaylistItemData playlistItemData = (PlaylistItemData) obj;
            return Intrinsics.areEqual(this.playlistSetVideoId, playlistItemData.playlistSetVideoId) && Intrinsics.areEqual(this.videoId, playlistItemData.videoId);
        }

        public final int hashCode() {
            String str = this.playlistSetVideoId;
            return this.videoId.hashCode() + ((str == null ? 0 : str.hashCode()) * 31);
        }

        public final String toString() {
            return Fragment$5$$ExternalSyntheticOutline0.m("PlaylistItemData(playlistSetVideoId=", this.playlistSetVideoId, ", videoId=", this.videoId, ")");
        }
    }

    static {
        Runs$$ExternalSyntheticLambda0 runs$$ExternalSyntheticLambda0 = new Runs$$ExternalSyntheticLambda0((byte) 13);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{ResultKt.lazy(lazyThreadSafetyMode, runs$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new Runs$$ExternalSyntheticLambda0((byte) 14)), ResultKt.lazy(lazyThreadSafetyMode, new Runs$$ExternalSyntheticLambda0((byte) 15)), null, null, null, null, null};
    }

    public /* synthetic */ MusicResponsiveListItemRenderer(int i, List list, List list2, List list3, ThumbnailRenderer thumbnailRenderer, Menu menu, PlaylistItemData playlistItemData, Overlay overlay, NavigationEndpoint navigationEndpoint) {
        if (255 != (i & 255)) {
            EnumsKt.throwMissingFieldException(MusicResponsiveListItemRenderer$$serializer.INSTANCE.getDescriptor(), i, 255);
            throw null;
        }
        this.badges = list;
        this.fixedColumns = list2;
        this.flexColumns = list3;
        this.thumbnail = thumbnailRenderer;
        this.menu = menu;
        this.playlistItemData = playlistItemData;
        this.overlay = overlay;
        this.navigationEndpoint = navigationEndpoint;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicResponsiveListItemRenderer)) {
            return false;
        }
        MusicResponsiveListItemRenderer musicResponsiveListItemRenderer = (MusicResponsiveListItemRenderer) obj;
        return Intrinsics.areEqual(this.badges, musicResponsiveListItemRenderer.badges) && Intrinsics.areEqual(this.fixedColumns, musicResponsiveListItemRenderer.fixedColumns) && Intrinsics.areEqual(this.flexColumns, musicResponsiveListItemRenderer.flexColumns) && Intrinsics.areEqual(this.thumbnail, musicResponsiveListItemRenderer.thumbnail) && Intrinsics.areEqual(this.menu, musicResponsiveListItemRenderer.menu) && Intrinsics.areEqual(this.playlistItemData, musicResponsiveListItemRenderer.playlistItemData) && Intrinsics.areEqual(this.overlay, musicResponsiveListItemRenderer.overlay) && Intrinsics.areEqual(this.navigationEndpoint, musicResponsiveListItemRenderer.navigationEndpoint);
    }

    public final String getMusicVideoType() {
        Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer;
        Overlay.MusicItemThumbnailOverlayRenderer.Content content;
        Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer;
        NavigationEndpoint navigationEndpoint;
        String musicVideoType;
        Overlay overlay = this.overlay;
        if (overlay != null && (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) != null && (content = musicItemThumbnailOverlayRenderer.content) != null && (musicPlayButtonRenderer = content.musicPlayButtonRenderer) != null && (navigationEndpoint = musicPlayButtonRenderer.playNavigationEndpoint) != null && (musicVideoType = navigationEndpoint.getMusicVideoType()) != null) {
            return musicVideoType;
        }
        NavigationEndpoint navigationEndpoint2 = this.navigationEndpoint;
        if (navigationEndpoint2 != null) {
            return navigationEndpoint2.getMusicVideoType();
        }
        return null;
    }

    public final String getPlaylistSetVideoId() {
        Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer;
        Overlay.MusicItemThumbnailOverlayRenderer.Content content;
        Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer;
        NavigationEndpoint navigationEndpoint;
        WatchEndpoint watchEndpoint;
        String str;
        PlaylistItemData playlistItemData = this.playlistItemData;
        if (playlistItemData != null && (str = playlistItemData.playlistSetVideoId) != null) {
            return str;
        }
        Overlay overlay = this.overlay;
        if (overlay == null || (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) == null || (content = musicItemThumbnailOverlayRenderer.content) == null || (musicPlayButtonRenderer = content.musicPlayButtonRenderer) == null || (navigationEndpoint = musicPlayButtonRenderer.playNavigationEndpoint) == null || (watchEndpoint = navigationEndpoint.watchEndpoint) == null) {
            return null;
        }
        return watchEndpoint.playlistSetVideoId;
    }

    public final String getVideoId() {
        Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer;
        Overlay.MusicItemThumbnailOverlayRenderer.Content content;
        Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer;
        NavigationEndpoint navigationEndpoint;
        WatchEndpoint watchEndpoint;
        FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer;
        Runs runs;
        List list;
        Run run;
        NavigationEndpoint navigationEndpoint2;
        WatchEndpoint watchEndpoint2;
        String str;
        PlaylistItemData playlistItemData = this.playlistItemData;
        if (playlistItemData != null && (str = playlistItemData.videoId) != null) {
            return str;
        }
        FlexColumn flexColumn = (FlexColumn) CollectionsKt.firstOrNull(this.flexColumns);
        String str2 = (flexColumn == null || (musicResponsiveListItemFlexColumnRenderer = flexColumn.musicResponsiveListItemFlexColumnRenderer) == null || (runs = musicResponsiveListItemFlexColumnRenderer.text) == null || (list = runs.runs) == null || (run = (Run) CollectionsKt.firstOrNull(list)) == null || (navigationEndpoint2 = run.navigationEndpoint) == null || (watchEndpoint2 = navigationEndpoint2.watchEndpoint) == null) ? null : watchEndpoint2.videoId;
        if (str2 != null) {
            return str2;
        }
        Overlay overlay = this.overlay;
        if (overlay == null || (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) == null || (content = musicItemThumbnailOverlayRenderer.content) == null || (musicPlayButtonRenderer = content.musicPlayButtonRenderer) == null || (navigationEndpoint = musicPlayButtonRenderer.playNavigationEndpoint) == null || (watchEndpoint = navigationEndpoint.watchEndpoint) == null) {
            return null;
        }
        return watchEndpoint.videoId;
    }

    public final int hashCode() {
        List list = this.badges;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List list2 = this.fixedColumns;
        int iM = Fragment$5$$ExternalSyntheticOutline0.m((iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31, 31, this.flexColumns);
        ThumbnailRenderer thumbnailRenderer = this.thumbnail;
        int iHashCode2 = (iM + (thumbnailRenderer == null ? 0 : thumbnailRenderer.hashCode())) * 31;
        Menu menu = this.menu;
        int iHashCode3 = (iHashCode2 + (menu == null ? 0 : menu.menuRenderer.hashCode())) * 31;
        PlaylistItemData playlistItemData = this.playlistItemData;
        int iHashCode4 = (iHashCode3 + (playlistItemData == null ? 0 : playlistItemData.hashCode())) * 31;
        Overlay overlay = this.overlay;
        int iHashCode5 = (iHashCode4 + (overlay == null ? 0 : overlay.musicItemThumbnailOverlayRenderer.hashCode())) * 31;
        NavigationEndpoint navigationEndpoint = this.navigationEndpoint;
        return iHashCode5 + (navigationEndpoint != null ? navigationEndpoint.hashCode() : 0);
    }

    public final boolean isAlbum() {
        BrowseEndpoint browseEndpoint;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig;
        BrowseEndpoint browseEndpoint2;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs2;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig2;
        String str = null;
        NavigationEndpoint navigationEndpoint = this.navigationEndpoint;
        if (Intrinsics.areEqual((navigationEndpoint == null || (browseEndpoint2 = navigationEndpoint.browseEndpoint) == null || (browseEndpointContextSupportedConfigs2 = browseEndpoint2.browseEndpointContextSupportedConfigs) == null || (browseEndpointContextMusicConfig2 = browseEndpointContextSupportedConfigs2.browseEndpointContextMusicConfig) == null) ? null : browseEndpointContextMusicConfig2.pageType, "MUSIC_PAGE_TYPE_ALBUM")) {
            return true;
        }
        if (navigationEndpoint != null && (browseEndpoint = navigationEndpoint.browseEndpoint) != null && (browseEndpointContextSupportedConfigs = browseEndpoint.browseEndpointContextSupportedConfigs) != null && (browseEndpointContextMusicConfig = browseEndpointContextSupportedConfigs.browseEndpointContextMusicConfig) != null) {
            str = browseEndpointContextMusicConfig.pageType;
        }
        return Intrinsics.areEqual(str, "MUSIC_PAGE_TYPE_AUDIOBOOK");
    }

    public final boolean isArtist() {
        BrowseEndpoint browseEndpoint;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig;
        BrowseEndpoint browseEndpoint2;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs2;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig2;
        String str = null;
        NavigationEndpoint navigationEndpoint = this.navigationEndpoint;
        if (Intrinsics.areEqual((navigationEndpoint == null || (browseEndpoint2 = navigationEndpoint.browseEndpoint) == null || (browseEndpointContextSupportedConfigs2 = browseEndpoint2.browseEndpointContextSupportedConfigs) == null || (browseEndpointContextMusicConfig2 = browseEndpointContextSupportedConfigs2.browseEndpointContextMusicConfig) == null) ? null : browseEndpointContextMusicConfig2.pageType, "MUSIC_PAGE_TYPE_ARTIST")) {
            return true;
        }
        if (navigationEndpoint != null && (browseEndpoint = navigationEndpoint.browseEndpoint) != null && (browseEndpointContextSupportedConfigs = browseEndpoint.browseEndpointContextSupportedConfigs) != null && (browseEndpointContextMusicConfig = browseEndpointContextSupportedConfigs.browseEndpointContextMusicConfig) != null) {
            str = browseEndpointContextMusicConfig.pageType;
        }
        return Intrinsics.areEqual(str, "MUSIC_PAGE_TYPE_LIBRARY_ARTIST");
    }

    public final boolean isEpisode() {
        boolean z;
        FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer;
        Runs runs;
        List list;
        BrowseEndpoint browseEndpoint;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig;
        FlexColumn.MusicResponsiveListItemFlexColumnRenderer musicResponsiveListItemFlexColumnRenderer2;
        Runs runs2;
        List list2;
        Run run;
        BrowseEndpoint browseEndpoint2;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs2;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig2;
        NavigationEndpoint navigationEndpoint = this.navigationEndpoint;
        if (Intrinsics.areEqual((navigationEndpoint == null || (browseEndpoint2 = navigationEndpoint.browseEndpoint) == null || (browseEndpointContextSupportedConfigs2 = browseEndpoint2.browseEndpointContextSupportedConfigs) == null || (browseEndpointContextMusicConfig2 = browseEndpointContextSupportedConfigs2.browseEndpointContextMusicConfig) == null) ? null : browseEndpointContextMusicConfig2.pageType, "MUSIC_PAGE_TYPE_NON_MUSIC_AUDIO_TRACK_PAGE")) {
            return true;
        }
        List list3 = this.flexColumns;
        FlexColumn flexColumn = (FlexColumn) CollectionsKt.getOrNull(1, list3);
        if (Intrinsics.areEqual((flexColumn == null || (musicResponsiveListItemFlexColumnRenderer2 = flexColumn.musicResponsiveListItemFlexColumnRenderer) == null || (runs2 = musicResponsiveListItemFlexColumnRenderer2.text) == null || (list2 = runs2.runs) == null || (run = (Run) CollectionsKt.firstOrNull(list2)) == null) ? null : run.text, "Episode")) {
            return true;
        }
        FlexColumn flexColumn2 = (FlexColumn) CollectionsKt.getOrNull(1, list3);
        if (flexColumn2 != null && (musicResponsiveListItemFlexColumnRenderer = flexColumn2.musicResponsiveListItemFlexColumnRenderer) != null && (runs = musicResponsiveListItemFlexColumnRenderer.text) != null && (list = runs.runs) != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                NavigationEndpoint navigationEndpoint2 = ((Run) it.next()).navigationEndpoint;
                if (Intrinsics.areEqual((navigationEndpoint2 == null || (browseEndpoint = navigationEndpoint2.browseEndpoint) == null || (browseEndpointContextSupportedConfigs = browseEndpoint.browseEndpointContextSupportedConfigs) == null || (browseEndpointContextMusicConfig = browseEndpointContextSupportedConfigs.browseEndpointContextMusicConfig) == null) ? null : browseEndpointContextMusicConfig.pageType, "MUSIC_PAGE_TYPE_PODCAST_SHOW_DETAIL_PAGE")) {
                    z = true;
                    break;
                }
            }
        } else {
            z = false;
            break;
        }
        return z && (getVideoId() != null);
    }

    public final boolean isPodcast() {
        BrowseEndpoint browseEndpoint;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig;
        NavigationEndpoint navigationEndpoint = this.navigationEndpoint;
        return Intrinsics.areEqual((navigationEndpoint == null || (browseEndpoint = navigationEndpoint.browseEndpoint) == null || (browseEndpointContextSupportedConfigs = browseEndpoint.browseEndpointContextSupportedConfigs) == null || (browseEndpointContextMusicConfig = browseEndpointContextSupportedConfigs.browseEndpointContextMusicConfig) == null) ? null : browseEndpointContextMusicConfig.pageType, "MUSIC_PAGE_TYPE_PODCAST_SHOW_DETAIL_PAGE");
    }

    public final boolean isSong() {
        Overlay.MusicItemThumbnailOverlayRenderer musicItemThumbnailOverlayRenderer;
        Overlay.MusicItemThumbnailOverlayRenderer.Content content;
        Overlay.MusicItemThumbnailOverlayRenderer.Content.MusicPlayButtonRenderer musicPlayButtonRenderer;
        NavigationEndpoint navigationEndpoint;
        NavigationEndpoint navigationEndpoint2 = this.navigationEndpoint;
        if (navigationEndpoint2 == null || navigationEndpoint2.watchEndpoint != null || navigationEndpoint2.watchPlaylistEndpoint != null) {
            return true;
        }
        Overlay overlay = this.overlay;
        return ((overlay == null || (musicItemThumbnailOverlayRenderer = overlay.musicItemThumbnailOverlayRenderer) == null || (content = musicItemThumbnailOverlayRenderer.content) == null || (musicPlayButtonRenderer = content.musicPlayButtonRenderer) == null || (navigationEndpoint = musicPlayButtonRenderer.playNavigationEndpoint) == null) ? null : navigationEndpoint.watchEndpoint) != null;
    }

    public final boolean isUserChannel() {
        BrowseEndpoint browseEndpoint;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs browseEndpointContextSupportedConfigs;
        BrowseEndpoint.BrowseEndpointContextSupportedConfigs.BrowseEndpointContextMusicConfig browseEndpointContextMusicConfig;
        NavigationEndpoint navigationEndpoint = this.navigationEndpoint;
        return Intrinsics.areEqual((navigationEndpoint == null || (browseEndpoint = navigationEndpoint.browseEndpoint) == null || (browseEndpointContextSupportedConfigs = browseEndpoint.browseEndpointContextSupportedConfigs) == null || (browseEndpointContextMusicConfig = browseEndpointContextSupportedConfigs.browseEndpointContextMusicConfig) == null) ? null : browseEndpointContextMusicConfig.pageType, "MUSIC_PAGE_TYPE_USER_CHANNEL");
    }

    public final String toString() {
        return "MusicResponsiveListItemRenderer(badges=" + this.badges + ", fixedColumns=" + this.fixedColumns + ", flexColumns=" + this.flexColumns + ", thumbnail=" + this.thumbnail + ", menu=" + this.menu + ", playlistItemData=" + this.playlistItemData + ", overlay=" + this.overlay + ", navigationEndpoint=" + this.navigationEndpoint + ")";
    }
}
