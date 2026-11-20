package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0004\u0003\u0004\u0005\u0002¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/ThumbnailRenderer;", "", "Companion", "MusicThumbnailRenderer", "MusicAnimatedThumbnailRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class ThumbnailRenderer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final MusicThumbnailRenderer croppedSquareThumbnailRenderer;
    public final MusicAnimatedThumbnailRenderer musicAnimatedThumbnailRenderer;
    public final MusicThumbnailRenderer musicThumbnailRenderer;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/ThumbnailRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/ThumbnailRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return ThumbnailRenderer$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/ThumbnailRenderer$MusicAnimatedThumbnailRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class MusicAnimatedThumbnailRenderer {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final Thumbnails animatedThumbnail;
        public final MusicThumbnailRenderer backupRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/ThumbnailRenderer$MusicAnimatedThumbnailRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/ThumbnailRenderer$MusicAnimatedThumbnailRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return ThumbnailRenderer$MusicAnimatedThumbnailRenderer$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ MusicAnimatedThumbnailRenderer(int i, Thumbnails thumbnails, MusicThumbnailRenderer musicThumbnailRenderer) {
            if (3 != (i & 3)) {
                EnumsKt.throwMissingFieldException(ThumbnailRenderer$MusicAnimatedThumbnailRenderer$$serializer.INSTANCE.getDescriptor(), i, 3);
                throw null;
            }
            this.animatedThumbnail = thumbnails;
            this.backupRenderer = musicThumbnailRenderer;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MusicAnimatedThumbnailRenderer)) {
                return false;
            }
            MusicAnimatedThumbnailRenderer musicAnimatedThumbnailRenderer = (MusicAnimatedThumbnailRenderer) obj;
            return Intrinsics.areEqual(this.animatedThumbnail, musicAnimatedThumbnailRenderer.animatedThumbnail) && Intrinsics.areEqual(this.backupRenderer, musicAnimatedThumbnailRenderer.backupRenderer);
        }

        public final int hashCode() {
            return this.backupRenderer.hashCode() + (this.animatedThumbnail.thumbnails.hashCode() * 31);
        }

        public final String toString() {
            return "MusicAnimatedThumbnailRenderer(animatedThumbnail=" + this.animatedThumbnail + ", backupRenderer=" + this.backupRenderer + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/ThumbnailRenderer$MusicThumbnailRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class MusicThumbnailRenderer {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final Thumbnails thumbnail;
        public final String thumbnailCrop;
        public final String thumbnailScale;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/ThumbnailRenderer$MusicThumbnailRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/ThumbnailRenderer$MusicThumbnailRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return ThumbnailRenderer$MusicThumbnailRenderer$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ MusicThumbnailRenderer(int i, Thumbnails thumbnails, String str, String str2) {
            if (7 != (i & 7)) {
                EnumsKt.throwMissingFieldException(ThumbnailRenderer$MusicThumbnailRenderer$$serializer.INSTANCE.getDescriptor(), i, 7);
                throw null;
            }
            this.thumbnail = thumbnails;
            this.thumbnailCrop = str;
            this.thumbnailScale = str2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MusicThumbnailRenderer)) {
                return false;
            }
            MusicThumbnailRenderer musicThumbnailRenderer = (MusicThumbnailRenderer) obj;
            return Intrinsics.areEqual(this.thumbnail, musicThumbnailRenderer.thumbnail) && Intrinsics.areEqual(this.thumbnailCrop, musicThumbnailRenderer.thumbnailCrop) && Intrinsics.areEqual(this.thumbnailScale, musicThumbnailRenderer.thumbnailScale);
        }

        public final String getThumbnailUrl() {
            Thumbnail thumbnail = (Thumbnail) CollectionsKt.lastOrNull(this.thumbnail.thumbnails);
            if (thumbnail != null) {
                return thumbnail.url;
            }
            return null;
        }

        public final int hashCode() {
            int iHashCode = this.thumbnail.thumbnails.hashCode() * 31;
            String str = this.thumbnailCrop;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.thumbnailScale;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("MusicThumbnailRenderer(thumbnail=");
            sb.append(this.thumbnail);
            sb.append(", thumbnailCrop=");
            sb.append(this.thumbnailCrop);
            sb.append(", thumbnailScale=");
            return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.thumbnailScale, ")");
        }
    }

    public /* synthetic */ ThumbnailRenderer(int i, MusicThumbnailRenderer musicThumbnailRenderer, MusicAnimatedThumbnailRenderer musicAnimatedThumbnailRenderer, MusicThumbnailRenderer musicThumbnailRenderer2) {
        if (7 != (i & 7)) {
            EnumsKt.throwMissingFieldException(ThumbnailRenderer$$serializer.INSTANCE.getDescriptor(), i, 7);
            throw null;
        }
        this.musicThumbnailRenderer = musicThumbnailRenderer;
        this.musicAnimatedThumbnailRenderer = musicAnimatedThumbnailRenderer;
        this.croppedSquareThumbnailRenderer = musicThumbnailRenderer2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThumbnailRenderer)) {
            return false;
        }
        ThumbnailRenderer thumbnailRenderer = (ThumbnailRenderer) obj;
        return Intrinsics.areEqual(this.musicThumbnailRenderer, thumbnailRenderer.musicThumbnailRenderer) && Intrinsics.areEqual(this.musicAnimatedThumbnailRenderer, thumbnailRenderer.musicAnimatedThumbnailRenderer) && Intrinsics.areEqual(this.croppedSquareThumbnailRenderer, thumbnailRenderer.croppedSquareThumbnailRenderer);
    }

    public final String getThumbnailUrl() {
        MusicThumbnailRenderer musicThumbnailRenderer;
        String thumbnailUrl;
        MusicThumbnailRenderer musicThumbnailRenderer2 = this.musicThumbnailRenderer;
        if (musicThumbnailRenderer2 != null && (thumbnailUrl = musicThumbnailRenderer2.getThumbnailUrl()) != null) {
            return thumbnailUrl;
        }
        MusicAnimatedThumbnailRenderer musicAnimatedThumbnailRenderer = this.musicAnimatedThumbnailRenderer;
        String thumbnailUrl2 = (musicAnimatedThumbnailRenderer == null || (musicThumbnailRenderer = musicAnimatedThumbnailRenderer.backupRenderer) == null) ? null : musicThumbnailRenderer.getThumbnailUrl();
        if (thumbnailUrl2 != null) {
            return thumbnailUrl2;
        }
        MusicThumbnailRenderer musicThumbnailRenderer3 = this.croppedSquareThumbnailRenderer;
        if (musicThumbnailRenderer3 != null) {
            return musicThumbnailRenderer3.getThumbnailUrl();
        }
        return null;
    }

    public final int hashCode() {
        MusicThumbnailRenderer musicThumbnailRenderer = this.musicThumbnailRenderer;
        int iHashCode = (musicThumbnailRenderer == null ? 0 : musicThumbnailRenderer.hashCode()) * 31;
        MusicAnimatedThumbnailRenderer musicAnimatedThumbnailRenderer = this.musicAnimatedThumbnailRenderer;
        int iHashCode2 = (iHashCode + (musicAnimatedThumbnailRenderer == null ? 0 : musicAnimatedThumbnailRenderer.hashCode())) * 31;
        MusicThumbnailRenderer musicThumbnailRenderer2 = this.croppedSquareThumbnailRenderer;
        return iHashCode2 + (musicThumbnailRenderer2 != null ? musicThumbnailRenderer2.hashCode() : 0);
    }

    public final String toString() {
        return "ThumbnailRenderer(musicThumbnailRenderer=" + this.musicThumbnailRenderer + ", musicAnimatedThumbnailRenderer=" + this.musicAnimatedThumbnailRenderer + ", croppedSquareThumbnailRenderer=" + this.croppedSquareThumbnailRenderer + ")";
    }
}
