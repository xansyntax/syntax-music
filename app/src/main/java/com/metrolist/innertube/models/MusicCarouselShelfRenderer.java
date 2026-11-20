package com.metrolist.innertube.models;

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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0004\u0003\u0004\u0005\u0002¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicCarouselShelfRenderer;", "", "Companion", "Header", "Content", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class MusicCarouselShelfRenderer {
    public final List contents;
    public final Header header;
    public final String itemSize;
    public final Integer numItemsPerColumn;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Runs$$ExternalSyntheticLambda0(9)), null, null};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicCarouselShelfRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicCarouselShelfRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return MusicCarouselShelfRenderer$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/MusicCarouselShelfRenderer$Content;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Content {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final MusicMultiRowListItemRenderer musicMultiRowListItemRenderer;
        public final MusicNavigationButtonRenderer musicNavigationButtonRenderer;
        public final MusicResponsiveListItemRenderer musicResponsiveListItemRenderer;
        public final MusicTwoRowItemRenderer musicTwoRowItemRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicCarouselShelfRenderer$Content$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicCarouselShelfRenderer$Content;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return MusicCarouselShelfRenderer$Content$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Content(int i, MusicTwoRowItemRenderer musicTwoRowItemRenderer, MusicResponsiveListItemRenderer musicResponsiveListItemRenderer, MusicMultiRowListItemRenderer musicMultiRowListItemRenderer, MusicNavigationButtonRenderer musicNavigationButtonRenderer) {
            if (15 != (i & 15)) {
                EnumsKt.throwMissingFieldException(MusicCarouselShelfRenderer$Content$$serializer.INSTANCE.getDescriptor(), i, 15);
                throw null;
            }
            this.musicTwoRowItemRenderer = musicTwoRowItemRenderer;
            this.musicResponsiveListItemRenderer = musicResponsiveListItemRenderer;
            this.musicMultiRowListItemRenderer = musicMultiRowListItemRenderer;
            this.musicNavigationButtonRenderer = musicNavigationButtonRenderer;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Content)) {
                return false;
            }
            Content content = (Content) obj;
            return Intrinsics.areEqual(this.musicTwoRowItemRenderer, content.musicTwoRowItemRenderer) && Intrinsics.areEqual(this.musicResponsiveListItemRenderer, content.musicResponsiveListItemRenderer) && Intrinsics.areEqual(this.musicMultiRowListItemRenderer, content.musicMultiRowListItemRenderer) && Intrinsics.areEqual(this.musicNavigationButtonRenderer, content.musicNavigationButtonRenderer);
        }

        public final int hashCode() {
            MusicTwoRowItemRenderer musicTwoRowItemRenderer = this.musicTwoRowItemRenderer;
            int iHashCode = (musicTwoRowItemRenderer == null ? 0 : musicTwoRowItemRenderer.hashCode()) * 31;
            MusicResponsiveListItemRenderer musicResponsiveListItemRenderer = this.musicResponsiveListItemRenderer;
            int iHashCode2 = (iHashCode + (musicResponsiveListItemRenderer == null ? 0 : musicResponsiveListItemRenderer.hashCode())) * 31;
            MusicMultiRowListItemRenderer musicMultiRowListItemRenderer = this.musicMultiRowListItemRenderer;
            int iHashCode3 = (iHashCode2 + (musicMultiRowListItemRenderer == null ? 0 : musicMultiRowListItemRenderer.hashCode())) * 31;
            MusicNavigationButtonRenderer musicNavigationButtonRenderer = this.musicNavigationButtonRenderer;
            return iHashCode3 + (musicNavigationButtonRenderer != null ? musicNavigationButtonRenderer.hashCode() : 0);
        }

        public final String toString() {
            return "Content(musicTwoRowItemRenderer=" + this.musicTwoRowItemRenderer + ", musicResponsiveListItemRenderer=" + this.musicResponsiveListItemRenderer + ", musicMultiRowListItemRenderer=" + this.musicMultiRowListItemRenderer + ", musicNavigationButtonRenderer=" + this.musicNavigationButtonRenderer + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/MusicCarouselShelfRenderer$Header;", "", "Companion", "MusicCarouselShelfBasicHeaderRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Header {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final MusicCarouselShelfBasicHeaderRenderer musicCarouselShelfBasicHeaderRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicCarouselShelfRenderer$Header$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicCarouselShelfRenderer$Header;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return MusicCarouselShelfRenderer$Header$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/MusicCarouselShelfRenderer$Header$MusicCarouselShelfBasicHeaderRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class MusicCarouselShelfBasicHeaderRenderer {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final Button moreContentButton;
            public final Runs strapline;
            public final ThumbnailRenderer thumbnail;
            public final Runs title;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicCarouselShelfRenderer$Header$MusicCarouselShelfBasicHeaderRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicCarouselShelfRenderer$Header$MusicCarouselShelfBasicHeaderRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return MusicCarouselShelfRenderer$Header$MusicCarouselShelfBasicHeaderRenderer$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ MusicCarouselShelfBasicHeaderRenderer(int i, Runs runs, Runs runs2, ThumbnailRenderer thumbnailRenderer, Button button) {
                if (15 != (i & 15)) {
                    EnumsKt.throwMissingFieldException(MusicCarouselShelfRenderer$Header$MusicCarouselShelfBasicHeaderRenderer$$serializer.INSTANCE.getDescriptor(), i, 15);
                    throw null;
                }
                this.strapline = runs;
                this.title = runs2;
                this.thumbnail = thumbnailRenderer;
                this.moreContentButton = button;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MusicCarouselShelfBasicHeaderRenderer)) {
                    return false;
                }
                MusicCarouselShelfBasicHeaderRenderer musicCarouselShelfBasicHeaderRenderer = (MusicCarouselShelfBasicHeaderRenderer) obj;
                return Intrinsics.areEqual(this.strapline, musicCarouselShelfBasicHeaderRenderer.strapline) && Intrinsics.areEqual(this.title, musicCarouselShelfBasicHeaderRenderer.title) && Intrinsics.areEqual(this.thumbnail, musicCarouselShelfBasicHeaderRenderer.thumbnail) && Intrinsics.areEqual(this.moreContentButton, musicCarouselShelfBasicHeaderRenderer.moreContentButton);
            }

            public final int hashCode() {
                Runs runs = this.strapline;
                int iHashCode = (this.title.hashCode() + ((runs == null ? 0 : runs.hashCode()) * 31)) * 31;
                ThumbnailRenderer thumbnailRenderer = this.thumbnail;
                int iHashCode2 = (iHashCode + (thumbnailRenderer == null ? 0 : thumbnailRenderer.hashCode())) * 31;
                Button button = this.moreContentButton;
                return iHashCode2 + (button != null ? button.buttonRenderer.hashCode() : 0);
            }

            public final String toString() {
                return "MusicCarouselShelfBasicHeaderRenderer(strapline=" + this.strapline + ", title=" + this.title + ", thumbnail=" + this.thumbnail + ", moreContentButton=" + this.moreContentButton + ")";
            }
        }

        public /* synthetic */ Header(int i, MusicCarouselShelfBasicHeaderRenderer musicCarouselShelfBasicHeaderRenderer) {
            if (1 == (i & 1)) {
                this.musicCarouselShelfBasicHeaderRenderer = musicCarouselShelfBasicHeaderRenderer;
            } else {
                EnumsKt.throwMissingFieldException(MusicCarouselShelfRenderer$Header$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Header) && Intrinsics.areEqual(this.musicCarouselShelfBasicHeaderRenderer, ((Header) obj).musicCarouselShelfBasicHeaderRenderer);
        }

        public final int hashCode() {
            return this.musicCarouselShelfBasicHeaderRenderer.hashCode();
        }

        public final String toString() {
            return "Header(musicCarouselShelfBasicHeaderRenderer=" + this.musicCarouselShelfBasicHeaderRenderer + ")";
        }
    }

    public /* synthetic */ MusicCarouselShelfRenderer(int i, Header header, List list, String str, Integer num) {
        if (15 != (i & 15)) {
            EnumsKt.throwMissingFieldException(MusicCarouselShelfRenderer$$serializer.INSTANCE.getDescriptor(), i, 15);
            throw null;
        }
        this.header = header;
        this.contents = list;
        this.itemSize = str;
        this.numItemsPerColumn = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicCarouselShelfRenderer)) {
            return false;
        }
        MusicCarouselShelfRenderer musicCarouselShelfRenderer = (MusicCarouselShelfRenderer) obj;
        return Intrinsics.areEqual(this.header, musicCarouselShelfRenderer.header) && Intrinsics.areEqual(this.contents, musicCarouselShelfRenderer.contents) && Intrinsics.areEqual(this.itemSize, musicCarouselShelfRenderer.itemSize) && Intrinsics.areEqual(this.numItemsPerColumn, musicCarouselShelfRenderer.numItemsPerColumn);
    }

    public final int hashCode() {
        Header header = this.header;
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m((header == null ? 0 : header.musicCarouselShelfBasicHeaderRenderer.hashCode()) * 31, 31, this.contents), 31, this.itemSize);
        Integer num = this.numItemsPerColumn;
        return iM + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        return "MusicCarouselShelfRenderer(header=" + this.header + ", contents=" + this.contents + ", itemSize=" + this.itemSize + ", numItemsPerColumn=" + this.numItemsPerColumn + ")";
    }
}
