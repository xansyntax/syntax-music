package com.metrolist.innertube.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/MusicMultiRowListItemRenderer;", "", "Companion", "PlaybackProgress", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class MusicMultiRowListItemRenderer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final String displayStyle;
    public final Menu menu;
    public final NavigationEndpoint onTap;
    public final PlaybackProgress playbackProgress;
    public final Runs secondSubtitle;
    public final Runs secondarySubtitle;
    public final Runs subtitle;
    public final ThumbnailRenderer thumbnail;
    public final Runs title;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicMultiRowListItemRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicMultiRowListItemRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return MusicMultiRowListItemRenderer$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/MusicMultiRowListItemRenderer$PlaybackProgress;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class PlaybackProgress {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final Float value;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicMultiRowListItemRenderer$PlaybackProgress$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicMultiRowListItemRenderer$PlaybackProgress;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return MusicMultiRowListItemRenderer$PlaybackProgress$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ PlaybackProgress(int i, Float f) {
            if ((i & 1) == 0) {
                this.value = null;
            } else {
                this.value = f;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PlaybackProgress) && Intrinsics.areEqual(this.value, ((PlaybackProgress) obj).value);
        }

        public final int hashCode() {
            Float f = this.value;
            if (f == null) {
                return 0;
            }
            return f.hashCode();
        }

        public final String toString() {
            return "PlaybackProgress(value=" + this.value + ")";
        }
    }

    public /* synthetic */ MusicMultiRowListItemRenderer(int i, Runs runs, Runs runs2, Runs runs3, Runs runs4, ThumbnailRenderer thumbnailRenderer, NavigationEndpoint navigationEndpoint, PlaybackProgress playbackProgress, String str, Menu menu) {
        if (499 != (i & 499)) {
            EnumsKt.throwMissingFieldException(MusicMultiRowListItemRenderer$$serializer.INSTANCE.getDescriptor(), i, 499);
            throw null;
        }
        this.title = runs;
        this.subtitle = runs2;
        if ((i & 4) == 0) {
            this.secondSubtitle = null;
        } else {
            this.secondSubtitle = runs3;
        }
        if ((i & 8) == 0) {
            this.secondarySubtitle = null;
        } else {
            this.secondarySubtitle = runs4;
        }
        this.thumbnail = thumbnailRenderer;
        this.onTap = navigationEndpoint;
        this.playbackProgress = playbackProgress;
        this.displayStyle = str;
        this.menu = menu;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicMultiRowListItemRenderer)) {
            return false;
        }
        MusicMultiRowListItemRenderer musicMultiRowListItemRenderer = (MusicMultiRowListItemRenderer) obj;
        return Intrinsics.areEqual(this.title, musicMultiRowListItemRenderer.title) && Intrinsics.areEqual(this.subtitle, musicMultiRowListItemRenderer.subtitle) && Intrinsics.areEqual(this.secondSubtitle, musicMultiRowListItemRenderer.secondSubtitle) && Intrinsics.areEqual(this.secondarySubtitle, musicMultiRowListItemRenderer.secondarySubtitle) && Intrinsics.areEqual(this.thumbnail, musicMultiRowListItemRenderer.thumbnail) && Intrinsics.areEqual(this.onTap, musicMultiRowListItemRenderer.onTap) && Intrinsics.areEqual(this.playbackProgress, musicMultiRowListItemRenderer.playbackProgress) && Intrinsics.areEqual(this.displayStyle, musicMultiRowListItemRenderer.displayStyle) && Intrinsics.areEqual(this.menu, musicMultiRowListItemRenderer.menu);
    }

    public final int hashCode() {
        Runs runs = this.title;
        int iHashCode = (runs == null ? 0 : runs.hashCode()) * 31;
        Runs runs2 = this.subtitle;
        int iHashCode2 = (iHashCode + (runs2 == null ? 0 : runs2.hashCode())) * 31;
        Runs runs3 = this.secondSubtitle;
        int iHashCode3 = (iHashCode2 + (runs3 == null ? 0 : runs3.hashCode())) * 31;
        Runs runs4 = this.secondarySubtitle;
        int iHashCode4 = (iHashCode3 + (runs4 == null ? 0 : runs4.hashCode())) * 31;
        ThumbnailRenderer thumbnailRenderer = this.thumbnail;
        int iHashCode5 = (iHashCode4 + (thumbnailRenderer == null ? 0 : thumbnailRenderer.hashCode())) * 31;
        NavigationEndpoint navigationEndpoint = this.onTap;
        int iHashCode6 = (iHashCode5 + (navigationEndpoint == null ? 0 : navigationEndpoint.hashCode())) * 31;
        PlaybackProgress playbackProgress = this.playbackProgress;
        int iHashCode7 = (iHashCode6 + (playbackProgress == null ? 0 : playbackProgress.hashCode())) * 31;
        String str = this.displayStyle;
        int iHashCode8 = (iHashCode7 + (str == null ? 0 : str.hashCode())) * 31;
        Menu menu = this.menu;
        return iHashCode8 + (menu != null ? menu.menuRenderer.hashCode() : 0);
    }

    public final String toString() {
        return "MusicMultiRowListItemRenderer(title=" + this.title + ", subtitle=" + this.subtitle + ", secondSubtitle=" + this.secondSubtitle + ", secondarySubtitle=" + this.secondarySubtitle + ", thumbnail=" + this.thumbnail + ", onTap=" + this.onTap + ", playbackProgress=" + this.playbackProgress + ", displayStyle=" + this.displayStyle + ", menu=" + this.menu + ")";
    }
}
