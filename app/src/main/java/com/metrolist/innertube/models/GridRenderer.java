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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0004\u0003\u0004\u0005\u0002¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/GridRenderer;", "", "Companion", "Header", "Item", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class GridRenderer {
    public static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final List continuations;
    public final Header header;
    public final List items;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/GridRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/GridRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return GridRenderer$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/GridRenderer$Header;", "", "Companion", "GridHeaderRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Header {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final GridHeaderRenderer gridHeaderRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/GridRenderer$Header$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/GridRenderer$Header;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return GridRenderer$Header$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/GridRenderer$Header$GridHeaderRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class GridHeaderRenderer {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final Runs title;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/GridRenderer$Header$GridHeaderRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/GridRenderer$Header$GridHeaderRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return GridRenderer$Header$GridHeaderRenderer$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ GridHeaderRenderer(int i, Runs runs) {
                if (1 == (i & 1)) {
                    this.title = runs;
                } else {
                    EnumsKt.throwMissingFieldException(GridRenderer$Header$GridHeaderRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
                    throw null;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof GridHeaderRenderer) && Intrinsics.areEqual(this.title, ((GridHeaderRenderer) obj).title);
            }

            public final int hashCode() {
                return this.title.hashCode();
            }

            public final String toString() {
                return "GridHeaderRenderer(title=" + this.title + ")";
            }
        }

        public /* synthetic */ Header(int i, GridHeaderRenderer gridHeaderRenderer) {
            if (1 == (i & 1)) {
                this.gridHeaderRenderer = gridHeaderRenderer;
            } else {
                EnumsKt.throwMissingFieldException(GridRenderer$Header$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Header) && Intrinsics.areEqual(this.gridHeaderRenderer, ((Header) obj).gridHeaderRenderer);
        }

        public final int hashCode() {
            return this.gridHeaderRenderer.title.hashCode();
        }

        public final String toString() {
            return "Header(gridHeaderRenderer=" + this.gridHeaderRenderer + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/GridRenderer$Item;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Item {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final MusicNavigationButtonRenderer musicNavigationButtonRenderer;
        public final MusicTwoRowItemRenderer musicTwoRowItemRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/GridRenderer$Item$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/GridRenderer$Item;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return GridRenderer$Item$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Item(int i, MusicNavigationButtonRenderer musicNavigationButtonRenderer, MusicTwoRowItemRenderer musicTwoRowItemRenderer) {
            if (3 != (i & 3)) {
                EnumsKt.throwMissingFieldException(GridRenderer$Item$$serializer.INSTANCE.getDescriptor(), i, 3);
                throw null;
            }
            this.musicNavigationButtonRenderer = musicNavigationButtonRenderer;
            this.musicTwoRowItemRenderer = musicTwoRowItemRenderer;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return Intrinsics.areEqual(this.musicNavigationButtonRenderer, item.musicNavigationButtonRenderer) && Intrinsics.areEqual(this.musicTwoRowItemRenderer, item.musicTwoRowItemRenderer);
        }

        public final int hashCode() {
            MusicNavigationButtonRenderer musicNavigationButtonRenderer = this.musicNavigationButtonRenderer;
            int iHashCode = (musicNavigationButtonRenderer == null ? 0 : musicNavigationButtonRenderer.hashCode()) * 31;
            MusicTwoRowItemRenderer musicTwoRowItemRenderer = this.musicTwoRowItemRenderer;
            return iHashCode + (musicTwoRowItemRenderer != null ? musicTwoRowItemRenderer.hashCode() : 0);
        }

        public final String toString() {
            return "Item(musicNavigationButtonRenderer=" + this.musicNavigationButtonRenderer + ", musicTwoRowItemRenderer=" + this.musicTwoRowItemRenderer + ")";
        }
    }

    static {
        Runs$$ExternalSyntheticLambda0 runs$$ExternalSyntheticLambda0 = new Runs$$ExternalSyntheticLambda0((byte) 1);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, ResultKt.lazy(lazyThreadSafetyMode, runs$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new Runs$$ExternalSyntheticLambda0((byte) 2))};
    }

    public /* synthetic */ GridRenderer(int i, Header header, List list, List list2) {
        if (7 != (i & 7)) {
            EnumsKt.throwMissingFieldException(GridRenderer$$serializer.INSTANCE.getDescriptor(), i, 7);
            throw null;
        }
        this.header = header;
        this.items = list;
        this.continuations = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GridRenderer)) {
            return false;
        }
        GridRenderer gridRenderer = (GridRenderer) obj;
        return Intrinsics.areEqual(this.header, gridRenderer.header) && Intrinsics.areEqual(this.items, gridRenderer.items) && Intrinsics.areEqual(this.continuations, gridRenderer.continuations);
    }

    public final int hashCode() {
        Header header = this.header;
        int iM = Fragment$5$$ExternalSyntheticOutline0.m((header == null ? 0 : header.hashCode()) * 31, 31, this.items);
        List list = this.continuations;
        return iM + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "GridRenderer(header=" + this.header + ", items=" + this.items + ", continuations=" + this.continuations + ")";
    }
}
