package com.metrolist.innertube.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0004\u0003\u0004\u0005\u0002¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicQueueRenderer;", "", "Companion", "Content", "Header", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class MusicQueueRenderer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final Content content;
    public final Header header;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicQueueRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicQueueRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return MusicQueueRenderer$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/MusicQueueRenderer$Content;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Content {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final PlaylistPanelRenderer playlistPanelRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicQueueRenderer$Content$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicQueueRenderer$Content;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return MusicQueueRenderer$Content$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Content(int i, PlaylistPanelRenderer playlistPanelRenderer) {
            if (1 == (i & 1)) {
                this.playlistPanelRenderer = playlistPanelRenderer;
            } else {
                EnumsKt.throwMissingFieldException(MusicQueueRenderer$Content$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Content) && Intrinsics.areEqual(this.playlistPanelRenderer, ((Content) obj).playlistPanelRenderer);
        }

        public final int hashCode() {
            return this.playlistPanelRenderer.hashCode();
        }

        public final String toString() {
            return "Content(playlistPanelRenderer=" + this.playlistPanelRenderer + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0003\u0003\u0004\u0002¨\u0006\u0005"}, d2 = {"Lcom/metrolist/innertube/models/MusicQueueRenderer$Header;", "", "Companion", "MusicQueueHeaderRenderer", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Header {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final MusicQueueHeaderRenderer musicQueueHeaderRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicQueueRenderer$Header$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicQueueRenderer$Header;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return MusicQueueRenderer$Header$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/MusicQueueRenderer$Header$MusicQueueHeaderRenderer;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @Serializable
        public static final /* data */ class MusicQueueHeaderRenderer {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion();
            public final Runs subtitle;
            public final Runs title;

            /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicQueueRenderer$Header$MusicQueueHeaderRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicQueueRenderer$Header$MusicQueueHeaderRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final class Companion {
                public final KSerializer serializer() {
                    return MusicQueueRenderer$Header$MusicQueueHeaderRenderer$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ MusicQueueHeaderRenderer(int i, Runs runs, Runs runs2) {
                if (3 != (i & 3)) {
                    EnumsKt.throwMissingFieldException(MusicQueueRenderer$Header$MusicQueueHeaderRenderer$$serializer.INSTANCE.getDescriptor(), i, 3);
                    throw null;
                }
                this.title = runs;
                this.subtitle = runs2;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MusicQueueHeaderRenderer)) {
                    return false;
                }
                MusicQueueHeaderRenderer musicQueueHeaderRenderer = (MusicQueueHeaderRenderer) obj;
                return Intrinsics.areEqual(this.title, musicQueueHeaderRenderer.title) && Intrinsics.areEqual(this.subtitle, musicQueueHeaderRenderer.subtitle);
            }

            public final int hashCode() {
                Runs runs = this.title;
                int iHashCode = (runs == null ? 0 : runs.hashCode()) * 31;
                Runs runs2 = this.subtitle;
                return iHashCode + (runs2 != null ? runs2.hashCode() : 0);
            }

            public final String toString() {
                return "MusicQueueHeaderRenderer(title=" + this.title + ", subtitle=" + this.subtitle + ")";
            }
        }

        public /* synthetic */ Header(int i, MusicQueueHeaderRenderer musicQueueHeaderRenderer) {
            if (1 == (i & 1)) {
                this.musicQueueHeaderRenderer = musicQueueHeaderRenderer;
            } else {
                EnumsKt.throwMissingFieldException(MusicQueueRenderer$Header$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Header) && Intrinsics.areEqual(this.musicQueueHeaderRenderer, ((Header) obj).musicQueueHeaderRenderer);
        }

        public final int hashCode() {
            MusicQueueHeaderRenderer musicQueueHeaderRenderer = this.musicQueueHeaderRenderer;
            if (musicQueueHeaderRenderer == null) {
                return 0;
            }
            return musicQueueHeaderRenderer.hashCode();
        }

        public final String toString() {
            return "Header(musicQueueHeaderRenderer=" + this.musicQueueHeaderRenderer + ")";
        }
    }

    public /* synthetic */ MusicQueueRenderer(int i, Content content, Header header) {
        if (3 != (i & 3)) {
            EnumsKt.throwMissingFieldException(MusicQueueRenderer$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.content = content;
        this.header = header;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicQueueRenderer)) {
            return false;
        }
        MusicQueueRenderer musicQueueRenderer = (MusicQueueRenderer) obj;
        return Intrinsics.areEqual(this.content, musicQueueRenderer.content) && Intrinsics.areEqual(this.header, musicQueueRenderer.header);
    }

    public final int hashCode() {
        Content content = this.content;
        int iHashCode = (content == null ? 0 : content.playlistPanelRenderer.hashCode()) * 31;
        Header header = this.header;
        return iHashCode + (header != null ? header.hashCode() : 0);
    }

    public final String toString() {
        return "MusicQueueRenderer(content=" + this.content + ", header=" + this.header + ")";
    }
}
