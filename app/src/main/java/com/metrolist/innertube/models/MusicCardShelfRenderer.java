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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0004\u0003\u0004\u0005\u0002¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicCardShelfRenderer;", "", "Companion", "Header", "Content", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class MusicCardShelfRenderer {
    public static final Lazy[] $childSerializers;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final List buttons;
    public final List contents;
    public final Header header;
    public final NavigationEndpoint onTap;
    public final Runs subtitle;
    public final List subtitleBadges;
    public final ThumbnailRenderer thumbnail;
    public final Runs title;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicCardShelfRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicCardShelfRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return MusicCardShelfRenderer$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/MusicCardShelfRenderer$Content;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Content {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final MusicResponsiveListItemRenderer musicResponsiveListItemRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicCardShelfRenderer$Content$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicCardShelfRenderer$Content;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return MusicCardShelfRenderer$Content$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Content(int i, MusicResponsiveListItemRenderer musicResponsiveListItemRenderer) {
            if (1 == (i & 1)) {
                this.musicResponsiveListItemRenderer = musicResponsiveListItemRenderer;
            } else {
                EnumsKt.throwMissingFieldException(MusicCardShelfRenderer$Content$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Content) && Intrinsics.areEqual(this.musicResponsiveListItemRenderer, ((Content) obj).musicResponsiveListItemRenderer);
        }

        public final int hashCode() {
            MusicResponsiveListItemRenderer musicResponsiveListItemRenderer = this.musicResponsiveListItemRenderer;
            if (musicResponsiveListItemRenderer == null) {
                return 0;
            }
            return musicResponsiveListItemRenderer.hashCode();
        }

        public final String toString() {
            return "Content(musicResponsiveListItemRenderer=" + this.musicResponsiveListItemRenderer + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/MusicCardShelfRenderer$Header;", "", "Companion", "MusicCardShelfHeaderBasicRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Header {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final MusicCardShelfHeaderBasicRenderer musicCardShelfHeaderBasicRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicCardShelfRenderer$Header$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicCardShelfRenderer$Header;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return MusicCardShelfRenderer$Header$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/MusicCardShelfRenderer$Header$MusicCardShelfHeaderBasicRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class MusicCardShelfHeaderBasicRenderer {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final Runs title;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicCardShelfRenderer$Header$MusicCardShelfHeaderBasicRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicCardShelfRenderer$Header$MusicCardShelfHeaderBasicRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return MusicCardShelfRenderer$Header$MusicCardShelfHeaderBasicRenderer$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ MusicCardShelfHeaderBasicRenderer(int i, Runs runs) {
                if (1 == (i & 1)) {
                    this.title = runs;
                } else {
                    EnumsKt.throwMissingFieldException(MusicCardShelfRenderer$Header$MusicCardShelfHeaderBasicRenderer$$serializer.INSTANCE.getDescriptor(), i, 1);
                    throw null;
                }
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof MusicCardShelfHeaderBasicRenderer) && Intrinsics.areEqual(this.title, ((MusicCardShelfHeaderBasicRenderer) obj).title);
            }

            public final int hashCode() {
                return this.title.hashCode();
            }

            public final String toString() {
                return "MusicCardShelfHeaderBasicRenderer(title=" + this.title + ")";
            }
        }

        public /* synthetic */ Header(int i, MusicCardShelfHeaderBasicRenderer musicCardShelfHeaderBasicRenderer) {
            if (1 == (i & 1)) {
                this.musicCardShelfHeaderBasicRenderer = musicCardShelfHeaderBasicRenderer;
            } else {
                EnumsKt.throwMissingFieldException(MusicCardShelfRenderer$Header$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Header) && Intrinsics.areEqual(this.musicCardShelfHeaderBasicRenderer, ((Header) obj).musicCardShelfHeaderBasicRenderer);
        }

        public final int hashCode() {
            return this.musicCardShelfHeaderBasicRenderer.title.hashCode();
        }

        public final String toString() {
            return "Header(musicCardShelfHeaderBasicRenderer=" + this.musicCardShelfHeaderBasicRenderer + ")";
        }
    }

    static {
        Runs$$ExternalSyntheticLambda0 runs$$ExternalSyntheticLambda0 = new Runs$$ExternalSyntheticLambda0((byte) 6);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, null, null, ResultKt.lazy(lazyThreadSafetyMode, runs$$ExternalSyntheticLambda0), ResultKt.lazy(lazyThreadSafetyMode, new Runs$$ExternalSyntheticLambda0((byte) 7)), null, ResultKt.lazy(lazyThreadSafetyMode, new Runs$$ExternalSyntheticLambda0((byte) 8))};
    }

    public /* synthetic */ MusicCardShelfRenderer(int i, Runs runs, Runs runs2, ThumbnailRenderer thumbnailRenderer, Header header, List list, List list2, NavigationEndpoint navigationEndpoint, List list3) {
        if (255 != (i & 255)) {
            EnumsKt.throwMissingFieldException(MusicCardShelfRenderer$$serializer.INSTANCE.getDescriptor(), i, 255);
            throw null;
        }
        this.title = runs;
        this.subtitle = runs2;
        this.thumbnail = thumbnailRenderer;
        this.header = header;
        this.contents = list;
        this.buttons = list2;
        this.onTap = navigationEndpoint;
        this.subtitleBadges = list3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicCardShelfRenderer)) {
            return false;
        }
        MusicCardShelfRenderer musicCardShelfRenderer = (MusicCardShelfRenderer) obj;
        return Intrinsics.areEqual(this.title, musicCardShelfRenderer.title) && Intrinsics.areEqual(this.subtitle, musicCardShelfRenderer.subtitle) && Intrinsics.areEqual(this.thumbnail, musicCardShelfRenderer.thumbnail) && Intrinsics.areEqual(this.header, musicCardShelfRenderer.header) && Intrinsics.areEqual(this.contents, musicCardShelfRenderer.contents) && Intrinsics.areEqual(this.buttons, musicCardShelfRenderer.buttons) && Intrinsics.areEqual(this.onTap, musicCardShelfRenderer.onTap) && Intrinsics.areEqual(this.subtitleBadges, musicCardShelfRenderer.subtitleBadges);
    }

    public final int hashCode() {
        int iHashCode = (this.thumbnail.hashCode() + ((this.subtitle.hashCode() + (this.title.hashCode() * 31)) * 31)) * 31;
        Header header = this.header;
        int iHashCode2 = (iHashCode + (header == null ? 0 : header.hashCode())) * 31;
        List list = this.contents;
        int iHashCode3 = (this.onTap.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m((iHashCode2 + (list == null ? 0 : list.hashCode())) * 31, 31, this.buttons)) * 31;
        List list2 = this.subtitleBadges;
        return iHashCode3 + (list2 != null ? list2.hashCode() : 0);
    }

    public final String toString() {
        return "MusicCardShelfRenderer(title=" + this.title + ", subtitle=" + this.subtitle + ", thumbnail=" + this.thumbnail + ", header=" + this.header + ", contents=" + this.contents + ", buttons=" + this.buttons + ", onTap=" + this.onTap + ", subtitleBadges=" + this.subtitleBadges + ")";
    }
}
