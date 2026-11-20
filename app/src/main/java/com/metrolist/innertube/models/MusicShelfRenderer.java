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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/MusicShelfRenderer;", "", "Companion", "Content", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class MusicShelfRenderer {
    public static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final NavigationEndpoint bottomEndpoint;
    public final List contents;
    public final List continuations;
    public final Button moreContentButton;
    public final Runs title;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicShelfRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicShelfRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return MusicShelfRenderer$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/MusicShelfRenderer$Content;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Content {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final ContinuationItemRenderer continuationItemRenderer;
        public final MusicMultiRowListItemRenderer musicMultiRowListItemRenderer;
        public final MusicResponsiveListItemRenderer musicResponsiveListItemRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicShelfRenderer$Content$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicShelfRenderer$Content;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return MusicShelfRenderer$Content$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Content(int i, MusicResponsiveListItemRenderer musicResponsiveListItemRenderer, MusicMultiRowListItemRenderer musicMultiRowListItemRenderer, ContinuationItemRenderer continuationItemRenderer) {
            if (7 != (i & 7)) {
                EnumsKt.throwMissingFieldException(MusicShelfRenderer$Content$$serializer.INSTANCE.getDescriptor(), i, 7);
                throw null;
            }
            this.musicResponsiveListItemRenderer = musicResponsiveListItemRenderer;
            this.musicMultiRowListItemRenderer = musicMultiRowListItemRenderer;
            this.continuationItemRenderer = continuationItemRenderer;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Content)) {
                return false;
            }
            Content content = (Content) obj;
            return Intrinsics.areEqual(this.musicResponsiveListItemRenderer, content.musicResponsiveListItemRenderer) && Intrinsics.areEqual(this.musicMultiRowListItemRenderer, content.musicMultiRowListItemRenderer) && Intrinsics.areEqual(this.continuationItemRenderer, content.continuationItemRenderer);
        }

        public final int hashCode() {
            MusicResponsiveListItemRenderer musicResponsiveListItemRenderer = this.musicResponsiveListItemRenderer;
            int iHashCode = (musicResponsiveListItemRenderer == null ? 0 : musicResponsiveListItemRenderer.hashCode()) * 31;
            MusicMultiRowListItemRenderer musicMultiRowListItemRenderer = this.musicMultiRowListItemRenderer;
            int iHashCode2 = (iHashCode + (musicMultiRowListItemRenderer == null ? 0 : musicMultiRowListItemRenderer.hashCode())) * 31;
            ContinuationItemRenderer continuationItemRenderer = this.continuationItemRenderer;
            return iHashCode2 + (continuationItemRenderer != null ? continuationItemRenderer.hashCode() : 0);
        }

        public final String toString() {
            return "Content(musicResponsiveListItemRenderer=" + this.musicResponsiveListItemRenderer + ", musicMultiRowListItemRenderer=" + this.musicMultiRowListItemRenderer + ", continuationItemRenderer=" + this.continuationItemRenderer + ")";
        }
    }

    static {
        Runs$$ExternalSyntheticLambda0 runs$$ExternalSyntheticLambda0 = new Runs$$ExternalSyntheticLambda0((byte) 16);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, ResultKt.lazy(lazyThreadSafetyMode, runs$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new Runs$$ExternalSyntheticLambda0((byte) 17)), null, null};
    }

    public /* synthetic */ MusicShelfRenderer(int i, Runs runs, List list, List list2, NavigationEndpoint navigationEndpoint, Button button) {
        if (31 != (i & 31)) {
            EnumsKt.throwMissingFieldException(MusicShelfRenderer$$serializer.INSTANCE.getDescriptor(), i, 31);
            throw null;
        }
        this.title = runs;
        this.contents = list;
        this.continuations = list2;
        this.bottomEndpoint = navigationEndpoint;
        this.moreContentButton = button;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicShelfRenderer)) {
            return false;
        }
        MusicShelfRenderer musicShelfRenderer = (MusicShelfRenderer) obj;
        return Intrinsics.areEqual(this.title, musicShelfRenderer.title) && Intrinsics.areEqual(this.contents, musicShelfRenderer.contents) && Intrinsics.areEqual(this.continuations, musicShelfRenderer.continuations) && Intrinsics.areEqual(this.bottomEndpoint, musicShelfRenderer.bottomEndpoint) && Intrinsics.areEqual(this.moreContentButton, musicShelfRenderer.moreContentButton);
    }

    public final int hashCode() {
        Runs runs = this.title;
        int iHashCode = (runs == null ? 0 : runs.hashCode()) * 31;
        List list = this.contents;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List list2 = this.continuations;
        int iHashCode3 = (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        NavigationEndpoint navigationEndpoint = this.bottomEndpoint;
        int iHashCode4 = (iHashCode3 + (navigationEndpoint == null ? 0 : navigationEndpoint.hashCode())) * 31;
        Button button = this.moreContentButton;
        return iHashCode4 + (button != null ? button.buttonRenderer.hashCode() : 0);
    }

    public final String toString() {
        return "MusicShelfRenderer(title=" + this.title + ", contents=" + this.contents + ", continuations=" + this.continuations + ", bottomEndpoint=" + this.bottomEndpoint + ", moreContentButton=" + this.moreContentButton + ")";
    }
}
