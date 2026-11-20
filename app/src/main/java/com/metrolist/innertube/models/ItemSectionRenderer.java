package com.metrolist.innertube.models;

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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0002¨\u0006\u0007"}, d2 = {"Lcom/metrolist/innertube/models/ItemSectionRenderer;", "", "Companion", "Content", "Header", "ItemSectionTabbedHeaderRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class ItemSectionRenderer {
    public final List contents;
    public final Header header;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Runs$$ExternalSyntheticLambda0(3)), null};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/ItemSectionRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/ItemSectionRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return ItemSectionRenderer$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/ItemSectionRenderer$Content;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Content {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final GridRenderer gridRenderer;
        public final MusicPlaylistShelfRenderer musicPlaylistShelfRenderer;
        public final MusicResponsiveListItemRenderer musicResponsiveListItemRenderer;
        public final MusicShelfRenderer musicShelfRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/ItemSectionRenderer$Content$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/ItemSectionRenderer$Content;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return ItemSectionRenderer$Content$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Content(int i, MusicResponsiveListItemRenderer musicResponsiveListItemRenderer, MusicShelfRenderer musicShelfRenderer, MusicPlaylistShelfRenderer musicPlaylistShelfRenderer, GridRenderer gridRenderer) {
            if ((i & 1) == 0) {
                this.musicResponsiveListItemRenderer = null;
            } else {
                this.musicResponsiveListItemRenderer = musicResponsiveListItemRenderer;
            }
            if ((i & 2) == 0) {
                this.musicShelfRenderer = null;
            } else {
                this.musicShelfRenderer = musicShelfRenderer;
            }
            if ((i & 4) == 0) {
                this.musicPlaylistShelfRenderer = null;
            } else {
                this.musicPlaylistShelfRenderer = musicPlaylistShelfRenderer;
            }
            if ((i & 8) == 0) {
                this.gridRenderer = null;
            } else {
                this.gridRenderer = gridRenderer;
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
            return Intrinsics.areEqual(this.musicResponsiveListItemRenderer, content.musicResponsiveListItemRenderer) && Intrinsics.areEqual(this.musicShelfRenderer, content.musicShelfRenderer) && Intrinsics.areEqual(this.musicPlaylistShelfRenderer, content.musicPlaylistShelfRenderer) && Intrinsics.areEqual(this.gridRenderer, content.gridRenderer);
        }

        public final int hashCode() {
            MusicResponsiveListItemRenderer musicResponsiveListItemRenderer = this.musicResponsiveListItemRenderer;
            int iHashCode = (musicResponsiveListItemRenderer == null ? 0 : musicResponsiveListItemRenderer.hashCode()) * 31;
            MusicShelfRenderer musicShelfRenderer = this.musicShelfRenderer;
            int iHashCode2 = (iHashCode + (musicShelfRenderer == null ? 0 : musicShelfRenderer.hashCode())) * 31;
            MusicPlaylistShelfRenderer musicPlaylistShelfRenderer = this.musicPlaylistShelfRenderer;
            int iHashCode3 = (iHashCode2 + (musicPlaylistShelfRenderer == null ? 0 : musicPlaylistShelfRenderer.hashCode())) * 31;
            GridRenderer gridRenderer = this.gridRenderer;
            return iHashCode3 + (gridRenderer != null ? gridRenderer.hashCode() : 0);
        }

        public final String toString() {
            return "Content(musicResponsiveListItemRenderer=" + this.musicResponsiveListItemRenderer + ", musicShelfRenderer=" + this.musicShelfRenderer + ", musicPlaylistShelfRenderer=" + this.musicPlaylistShelfRenderer + ", gridRenderer=" + this.gridRenderer + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/ItemSectionRenderer$Header;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Header {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final ItemSectionTabbedHeaderRenderer itemSectionTabbedHeaderRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/ItemSectionRenderer$Header$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/ItemSectionRenderer$Header;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return ItemSectionRenderer$Header$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Header(int i, ItemSectionTabbedHeaderRenderer itemSectionTabbedHeaderRenderer) {
            if (1 == (i & 1)) {
                this.itemSectionTabbedHeaderRenderer = itemSectionTabbedHeaderRenderer;
            } else {
                EnumsKt.throwMissingFieldException(ItemSectionRenderer$Header$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Header) && Intrinsics.areEqual(this.itemSectionTabbedHeaderRenderer, ((Header) obj).itemSectionTabbedHeaderRenderer);
        }

        public final int hashCode() {
            ItemSectionTabbedHeaderRenderer itemSectionTabbedHeaderRenderer = this.itemSectionTabbedHeaderRenderer;
            if (itemSectionTabbedHeaderRenderer == null) {
                return 0;
            }
            return itemSectionTabbedHeaderRenderer.hashCode();
        }

        public final String toString() {
            return "Header(itemSectionTabbedHeaderRenderer=" + this.itemSectionTabbedHeaderRenderer + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/ItemSectionRenderer$ItemSectionTabbedHeaderRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ItemSectionTabbedHeaderRenderer {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final Runs title;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/ItemSectionRenderer$ItemSectionTabbedHeaderRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/ItemSectionRenderer$ItemSectionTabbedHeaderRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return ItemSectionRenderer$ItemSectionTabbedHeaderRenderer$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ ItemSectionTabbedHeaderRenderer(int i, Runs runs) {
            if (1 == (i & 1)) {
                this.title = runs;
            } else {
                EnumsKt.throwMissingFieldException(ItemSectionRenderer$ItemSectionTabbedHeaderRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ItemSectionTabbedHeaderRenderer) && Intrinsics.areEqual(this.title, ((ItemSectionTabbedHeaderRenderer) obj).title);
        }

        public final int hashCode() {
            Runs runs = this.title;
            if (runs == null) {
                return 0;
            }
            return runs.hashCode();
        }

        public final String toString() {
            return "ItemSectionTabbedHeaderRenderer(title=" + this.title + ")";
        }
    }

    public /* synthetic */ ItemSectionRenderer(int i, List list, Header header) {
        if (1 != (i & 1)) {
            EnumsKt.throwMissingFieldException(ItemSectionRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
            throw null;
        }
        this.contents = list;
        if ((i & 2) == 0) {
            this.header = null;
        } else {
            this.header = header;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ItemSectionRenderer)) {
            return false;
        }
        ItemSectionRenderer itemSectionRenderer = (ItemSectionRenderer) obj;
        return Intrinsics.areEqual(this.contents, itemSectionRenderer.contents) && Intrinsics.areEqual(this.header, itemSectionRenderer.header);
    }

    public final int hashCode() {
        List list = this.contents;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        Header header = this.header;
        return iHashCode + (header != null ? header.hashCode() : 0);
    }

    public final String toString() {
        return "ItemSectionRenderer(contents=" + this.contents + ", header=" + this.header + ")";
    }
}
