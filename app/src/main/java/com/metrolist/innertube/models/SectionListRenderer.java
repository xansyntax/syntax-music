package com.metrolist.innertube.models;

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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0004\u0003\u0004\u0005\u0002¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/SectionListRenderer;", "", "Companion", "Header", "Content", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class SectionListRenderer {
    public static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final List contents;
    public final List continuations;
    public final Header header;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/SectionListRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/SectionListRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return SectionListRenderer$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/SectionListRenderer$Header;", "", "Companion", "ChipCloudRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Header {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final ChipCloudRenderer chipCloudRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/SectionListRenderer$Header$ChipCloudRenderer;", "", "Companion", "Chip", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class ChipCloudRenderer {
            public final List chips;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Runs$$ExternalSyntheticLambda0(27))};

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/SectionListRenderer$Header$ChipCloudRenderer$Chip;", "", "Companion", "ChipCloudChipRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            @Serializable
            public static final /* data */ class Chip {

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion();
                public final ChipCloudChipRenderer chipCloudChipRenderer;

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/SectionListRenderer$Header$ChipCloudRenderer$Chip$ChipCloudChipRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                @Serializable
                public static final /* data */ class ChipCloudChipRenderer {

                    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                    public static final Companion INSTANCE = new Companion();
                    public final boolean isSelected;
                    public final NavigationEndpoint navigationEndpoint;
                    public final NavigationEndpoint onDeselectedCommand;
                    public final Runs text;
                    public final String uniqueId;

                    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/SectionListRenderer$Header$ChipCloudRenderer$Chip$ChipCloudChipRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/SectionListRenderer$Header$ChipCloudRenderer$Chip$ChipCloudChipRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                    public static final class Companion {
                        public final KSerializer serializer() {
                            return SectionListRenderer$Header$ChipCloudRenderer$Chip$ChipCloudChipRenderer$$serializer.INSTANCE;
                        }
                    }

                    public /* synthetic */ ChipCloudChipRenderer(int i, boolean z, NavigationEndpoint navigationEndpoint, NavigationEndpoint navigationEndpoint2, Runs runs, String str) {
                        if (24 != (i & 24)) {
                            EnumsKt.throwMissingFieldException(SectionListRenderer$Header$ChipCloudRenderer$Chip$ChipCloudChipRenderer$$serializer.INSTANCE.getDescriptor(), i, 24);
                            throw null;
                        }
                        this.isSelected = (i & 1) == 0 ? false : z;
                        if ((i & 2) == 0) {
                            this.navigationEndpoint = null;
                        } else {
                            this.navigationEndpoint = navigationEndpoint;
                        }
                        if ((i & 4) == 0) {
                            this.onDeselectedCommand = null;
                        } else {
                            this.onDeselectedCommand = navigationEndpoint2;
                        }
                        this.text = runs;
                        this.uniqueId = str;
                    }

                    public final boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof ChipCloudChipRenderer)) {
                            return false;
                        }
                        ChipCloudChipRenderer chipCloudChipRenderer = (ChipCloudChipRenderer) obj;
                        return this.isSelected == chipCloudChipRenderer.isSelected && Intrinsics.areEqual(this.navigationEndpoint, chipCloudChipRenderer.navigationEndpoint) && Intrinsics.areEqual(this.onDeselectedCommand, chipCloudChipRenderer.onDeselectedCommand) && Intrinsics.areEqual(this.text, chipCloudChipRenderer.text) && Intrinsics.areEqual(this.uniqueId, chipCloudChipRenderer.uniqueId);
                    }

                    public final int hashCode() {
                        int iHashCode = Boolean.hashCode(this.isSelected) * 31;
                        NavigationEndpoint navigationEndpoint = this.navigationEndpoint;
                        int iHashCode2 = (iHashCode + (navigationEndpoint == null ? 0 : navigationEndpoint.hashCode())) * 31;
                        NavigationEndpoint navigationEndpoint2 = this.onDeselectedCommand;
                        int iHashCode3 = (iHashCode2 + (navigationEndpoint2 == null ? 0 : navigationEndpoint2.hashCode())) * 31;
                        Runs runs = this.text;
                        int iHashCode4 = (iHashCode3 + (runs == null ? 0 : runs.hashCode())) * 31;
                        String str = this.uniqueId;
                        return iHashCode4 + (str != null ? str.hashCode() : 0);
                    }

                    public final String toString() {
                        StringBuilder sb = new StringBuilder("ChipCloudChipRenderer(isSelected=");
                        sb.append(this.isSelected);
                        sb.append(", navigationEndpoint=");
                        sb.append(this.navigationEndpoint);
                        sb.append(", onDeselectedCommand=");
                        sb.append(this.onDeselectedCommand);
                        sb.append(", text=");
                        sb.append(this.text);
                        sb.append(", uniqueId=");
                        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.uniqueId, ")");
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/SectionListRenderer$Header$ChipCloudRenderer$Chip$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/SectionListRenderer$Header$ChipCloudRenderer$Chip;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
                public static final class Companion {
                    public final KSerializer serializer() {
                        return SectionListRenderer$Header$ChipCloudRenderer$Chip$$serializer.INSTANCE;
                    }
                }

                public /* synthetic */ Chip(int i, ChipCloudChipRenderer chipCloudChipRenderer) {
                    if (1 == (i & 1)) {
                        this.chipCloudChipRenderer = chipCloudChipRenderer;
                    } else {
                        EnumsKt.throwMissingFieldException(SectionListRenderer$Header$ChipCloudRenderer$Chip$$serializer.INSTANCE.getDescriptor(), i, 1);
                        throw null;
                    }
                }

                public final boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof Chip) && Intrinsics.areEqual(this.chipCloudChipRenderer, ((Chip) obj).chipCloudChipRenderer);
                }

                public final int hashCode() {
                    return this.chipCloudChipRenderer.hashCode();
                }

                public final String toString() {
                    return "Chip(chipCloudChipRenderer=" + this.chipCloudChipRenderer + ")";
                }
            }

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/SectionListRenderer$Header$ChipCloudRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/SectionListRenderer$Header$ChipCloudRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return SectionListRenderer$Header$ChipCloudRenderer$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ ChipCloudRenderer(int i, List list) {
                if (1 == (i & 1)) {
                    this.chips = list;
                } else {
                    EnumsKt.throwMissingFieldException(SectionListRenderer$Header$ChipCloudRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
                    throw null;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ChipCloudRenderer) && Intrinsics.areEqual(this.chips, ((ChipCloudRenderer) obj).chips);
            }

            public final int hashCode() {
                return this.chips.hashCode();
            }

            public final String toString() {
                return Fragment$5$$ExternalSyntheticOutline0.m("ChipCloudRenderer(chips=", ")", this.chips);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/SectionListRenderer$Header$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/SectionListRenderer$Header;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return SectionListRenderer$Header$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Header(int i, ChipCloudRenderer chipCloudRenderer) {
            if (1 == (i & 1)) {
                this.chipCloudRenderer = chipCloudRenderer;
            } else {
                EnumsKt.throwMissingFieldException(SectionListRenderer$Header$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Header) && Intrinsics.areEqual(this.chipCloudRenderer, ((Header) obj).chipCloudRenderer);
        }

        public final int hashCode() {
            ChipCloudRenderer chipCloudRenderer = this.chipCloudRenderer;
            if (chipCloudRenderer == null) {
                return 0;
            }
            return chipCloudRenderer.chips.hashCode();
        }

        public final String toString() {
            return "Header(chipCloudRenderer=" + this.chipCloudRenderer + ")";
        }
    }

    static {
        Runs$$ExternalSyntheticLambda0 runs$$ExternalSyntheticLambda0 = new Runs$$ExternalSyntheticLambda0((byte) 25);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, ResultKt.lazy(lazyThreadSafetyMode, runs$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new Runs$$ExternalSyntheticLambda0((byte) 26))};
    }

    public /* synthetic */ SectionListRenderer(int i, Header header, List list, List list2) {
        if (7 != (i & 7)) {
            EnumsKt.throwMissingFieldException(SectionListRenderer$$serializer.INSTANCE.getDescriptor(), i, 7);
            throw null;
        }
        this.header = header;
        this.contents = list;
        this.continuations = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SectionListRenderer)) {
            return false;
        }
        SectionListRenderer sectionListRenderer = (SectionListRenderer) obj;
        return Intrinsics.areEqual(this.header, sectionListRenderer.header) && Intrinsics.areEqual(this.contents, sectionListRenderer.contents) && Intrinsics.areEqual(this.continuations, sectionListRenderer.continuations);
    }

    public final int hashCode() {
        Header header = this.header;
        int iHashCode = (header == null ? 0 : header.hashCode()) * 31;
        List list = this.contents;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List list2 = this.continuations;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public final String toString() {
        return "SectionListRenderer(header=" + this.header + ", contents=" + this.contents + ", continuations=" + this.continuations + ")";
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/SectionListRenderer$Content;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Content {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final GridRenderer gridRenderer;
        public final ItemSectionRenderer itemSectionRenderer;
        public final MusicCardShelfRenderer musicCardShelfRenderer;
        public final MusicCarouselShelfRenderer musicCarouselShelfRenderer;
        public final MusicDescriptionShelfRenderer musicDescriptionShelfRenderer;
        public final MusicEditablePlaylistDetailHeaderRenderer musicEditablePlaylistDetailHeaderRenderer;
        public final MusicPlaylistShelfRenderer musicPlaylistShelfRenderer;
        public final MusicResponsiveHeaderRenderer musicResponsiveHeaderRenderer;
        public final MusicShelfRenderer musicShelfRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/SectionListRenderer$Content$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/SectionListRenderer$Content;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return SectionListRenderer$Content$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Content(int i, MusicCarouselShelfRenderer musicCarouselShelfRenderer, MusicShelfRenderer musicShelfRenderer, MusicCardShelfRenderer musicCardShelfRenderer, MusicPlaylistShelfRenderer musicPlaylistShelfRenderer, MusicDescriptionShelfRenderer musicDescriptionShelfRenderer, MusicResponsiveHeaderRenderer musicResponsiveHeaderRenderer, MusicEditablePlaylistDetailHeaderRenderer musicEditablePlaylistDetailHeaderRenderer, GridRenderer gridRenderer, ItemSectionRenderer itemSectionRenderer) {
            if (511 != (i & 511)) {
                EnumsKt.throwMissingFieldException(SectionListRenderer$Content$$serializer.INSTANCE.getDescriptor(), i, 511);
                throw null;
            }
            this.musicCarouselShelfRenderer = musicCarouselShelfRenderer;
            this.musicShelfRenderer = musicShelfRenderer;
            this.musicCardShelfRenderer = musicCardShelfRenderer;
            this.musicPlaylistShelfRenderer = musicPlaylistShelfRenderer;
            this.musicDescriptionShelfRenderer = musicDescriptionShelfRenderer;
            this.musicResponsiveHeaderRenderer = musicResponsiveHeaderRenderer;
            this.musicEditablePlaylistDetailHeaderRenderer = musicEditablePlaylistDetailHeaderRenderer;
            this.gridRenderer = gridRenderer;
            this.itemSectionRenderer = itemSectionRenderer;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Content)) {
                return false;
            }
            Content content = (Content) obj;
            return Intrinsics.areEqual(this.musicCarouselShelfRenderer, content.musicCarouselShelfRenderer) && Intrinsics.areEqual(this.musicShelfRenderer, content.musicShelfRenderer) && Intrinsics.areEqual(this.musicCardShelfRenderer, content.musicCardShelfRenderer) && Intrinsics.areEqual(this.musicPlaylistShelfRenderer, content.musicPlaylistShelfRenderer) && Intrinsics.areEqual(this.musicDescriptionShelfRenderer, content.musicDescriptionShelfRenderer) && Intrinsics.areEqual(this.musicResponsiveHeaderRenderer, content.musicResponsiveHeaderRenderer) && Intrinsics.areEqual(this.musicEditablePlaylistDetailHeaderRenderer, content.musicEditablePlaylistDetailHeaderRenderer) && Intrinsics.areEqual(this.gridRenderer, content.gridRenderer) && Intrinsics.areEqual(this.itemSectionRenderer, content.itemSectionRenderer);
        }

        public final int hashCode() {
            MusicCarouselShelfRenderer musicCarouselShelfRenderer = this.musicCarouselShelfRenderer;
            int iHashCode = (musicCarouselShelfRenderer == null ? 0 : musicCarouselShelfRenderer.hashCode()) * 31;
            MusicShelfRenderer musicShelfRenderer = this.musicShelfRenderer;
            int iHashCode2 = (iHashCode + (musicShelfRenderer == null ? 0 : musicShelfRenderer.hashCode())) * 31;
            MusicCardShelfRenderer musicCardShelfRenderer = this.musicCardShelfRenderer;
            int iHashCode3 = (iHashCode2 + (musicCardShelfRenderer == null ? 0 : musicCardShelfRenderer.hashCode())) * 31;
            MusicPlaylistShelfRenderer musicPlaylistShelfRenderer = this.musicPlaylistShelfRenderer;
            int iHashCode4 = (iHashCode3 + (musicPlaylistShelfRenderer == null ? 0 : musicPlaylistShelfRenderer.hashCode())) * 31;
            MusicDescriptionShelfRenderer musicDescriptionShelfRenderer = this.musicDescriptionShelfRenderer;
            int iHashCode5 = (iHashCode4 + (musicDescriptionShelfRenderer == null ? 0 : musicDescriptionShelfRenderer.hashCode())) * 31;
            MusicResponsiveHeaderRenderer musicResponsiveHeaderRenderer = this.musicResponsiveHeaderRenderer;
            int iHashCode6 = (iHashCode5 + (musicResponsiveHeaderRenderer == null ? 0 : musicResponsiveHeaderRenderer.hashCode())) * 31;
            MusicEditablePlaylistDetailHeaderRenderer musicEditablePlaylistDetailHeaderRenderer = this.musicEditablePlaylistDetailHeaderRenderer;
            int iHashCode7 = (iHashCode6 + (musicEditablePlaylistDetailHeaderRenderer == null ? 0 : musicEditablePlaylistDetailHeaderRenderer.hashCode())) * 31;
            GridRenderer gridRenderer = this.gridRenderer;
            int iHashCode8 = (iHashCode7 + (gridRenderer == null ? 0 : gridRenderer.hashCode())) * 31;
            ItemSectionRenderer itemSectionRenderer = this.itemSectionRenderer;
            return iHashCode8 + (itemSectionRenderer != null ? itemSectionRenderer.hashCode() : 0);
        }

        public final String toString() {
            return "Content(musicCarouselShelfRenderer=" + this.musicCarouselShelfRenderer + ", musicShelfRenderer=" + this.musicShelfRenderer + ", musicCardShelfRenderer=" + this.musicCardShelfRenderer + ", musicPlaylistShelfRenderer=" + this.musicPlaylistShelfRenderer + ", musicDescriptionShelfRenderer=" + this.musicDescriptionShelfRenderer + ", musicResponsiveHeaderRenderer=" + this.musicResponsiveHeaderRenderer + ", musicEditablePlaylistDetailHeaderRenderer=" + this.musicEditablePlaylistDetailHeaderRenderer + ", gridRenderer=" + this.gridRenderer + ", itemSectionRenderer=" + this.itemSectionRenderer + ")";
        }

        public Content(MusicShelfRenderer musicShelfRenderer, MusicPlaylistShelfRenderer musicPlaylistShelfRenderer) {
            this.musicCarouselShelfRenderer = null;
            this.musicShelfRenderer = musicShelfRenderer;
            this.musicCardShelfRenderer = null;
            this.musicPlaylistShelfRenderer = musicPlaylistShelfRenderer;
            this.musicDescriptionShelfRenderer = null;
            this.musicResponsiveHeaderRenderer = null;
            this.musicEditablePlaylistDetailHeaderRenderer = null;
            this.gridRenderer = null;
            this.itemSectionRenderer = null;
        }
    }
}
