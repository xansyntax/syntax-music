package com.metrolist.innertube.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0004\u0003\u0004\u0005\u0002¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicEditablePlaylistDetailHeaderRenderer;", "", "Companion", "Header", "EditHeader", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class MusicEditablePlaylistDetailHeaderRenderer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final EditHeader editHeader;
    public final Header header;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicEditablePlaylistDetailHeaderRenderer$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicEditablePlaylistDetailHeaderRenderer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return MusicEditablePlaylistDetailHeaderRenderer$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/MusicEditablePlaylistDetailHeaderRenderer$EditHeader;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class EditHeader {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final MusicPlaylistEditHeaderRenderer musicPlaylistEditHeaderRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicEditablePlaylistDetailHeaderRenderer$EditHeader$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicEditablePlaylistDetailHeaderRenderer$EditHeader;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return MusicEditablePlaylistDetailHeaderRenderer$EditHeader$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ EditHeader(int i, MusicPlaylistEditHeaderRenderer musicPlaylistEditHeaderRenderer) {
            if (1 == (i & 1)) {
                this.musicPlaylistEditHeaderRenderer = musicPlaylistEditHeaderRenderer;
            } else {
                EnumsKt.throwMissingFieldException(MusicEditablePlaylistDetailHeaderRenderer$EditHeader$$serializer.INSTANCE.getDescriptor(), i, 1);
                throw null;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof EditHeader) && Intrinsics.areEqual(this.musicPlaylistEditHeaderRenderer, ((EditHeader) obj).musicPlaylistEditHeaderRenderer);
        }

        public final int hashCode() {
            MusicPlaylistEditHeaderRenderer musicPlaylistEditHeaderRenderer = this.musicPlaylistEditHeaderRenderer;
            if (musicPlaylistEditHeaderRenderer == null) {
                return 0;
            }
            return musicPlaylistEditHeaderRenderer.hashCode();
        }

        public final String toString() {
            return "EditHeader(musicPlaylistEditHeaderRenderer=" + this.musicPlaylistEditHeaderRenderer + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/innertube/models/MusicEditablePlaylistDetailHeaderRenderer$Header;", "", "Companion", "$serializer", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Header {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion();
        public final MusicDetailHeaderRenderer musicDetailHeaderRenderer;
        public final MusicResponsiveHeaderRenderer musicResponsiveHeaderRenderer;

        /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/innertube/models/MusicEditablePlaylistDetailHeaderRenderer$Header$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/innertube/models/MusicEditablePlaylistDetailHeaderRenderer$Header;", "serializer", "()Lkotlinx/serialization/KSerializer;", "innertube"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final class Companion {
            public final KSerializer serializer() {
                return MusicEditablePlaylistDetailHeaderRenderer$Header$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Header(int i, MusicDetailHeaderRenderer musicDetailHeaderRenderer, MusicResponsiveHeaderRenderer musicResponsiveHeaderRenderer) {
            if (3 != (i & 3)) {
                EnumsKt.throwMissingFieldException(MusicEditablePlaylistDetailHeaderRenderer$Header$$serializer.INSTANCE.getDescriptor(), i, 3);
                throw null;
            }
            this.musicDetailHeaderRenderer = musicDetailHeaderRenderer;
            this.musicResponsiveHeaderRenderer = musicResponsiveHeaderRenderer;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Header)) {
                return false;
            }
            Header header = (Header) obj;
            return Intrinsics.areEqual(this.musicDetailHeaderRenderer, header.musicDetailHeaderRenderer) && Intrinsics.areEqual(this.musicResponsiveHeaderRenderer, header.musicResponsiveHeaderRenderer);
        }

        public final int hashCode() {
            MusicDetailHeaderRenderer musicDetailHeaderRenderer = this.musicDetailHeaderRenderer;
            int iHashCode = (musicDetailHeaderRenderer == null ? 0 : musicDetailHeaderRenderer.hashCode()) * 31;
            MusicResponsiveHeaderRenderer musicResponsiveHeaderRenderer = this.musicResponsiveHeaderRenderer;
            return iHashCode + (musicResponsiveHeaderRenderer != null ? musicResponsiveHeaderRenderer.hashCode() : 0);
        }

        public final String toString() {
            return "Header(musicDetailHeaderRenderer=" + this.musicDetailHeaderRenderer + ", musicResponsiveHeaderRenderer=" + this.musicResponsiveHeaderRenderer + ")";
        }
    }

    public /* synthetic */ MusicEditablePlaylistDetailHeaderRenderer(int i, Header header, EditHeader editHeader) {
        if (3 != (i & 3)) {
            EnumsKt.throwMissingFieldException(MusicEditablePlaylistDetailHeaderRenderer$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.header = header;
        this.editHeader = editHeader;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicEditablePlaylistDetailHeaderRenderer)) {
            return false;
        }
        MusicEditablePlaylistDetailHeaderRenderer musicEditablePlaylistDetailHeaderRenderer = (MusicEditablePlaylistDetailHeaderRenderer) obj;
        return Intrinsics.areEqual(this.header, musicEditablePlaylistDetailHeaderRenderer.header) && Intrinsics.areEqual(this.editHeader, musicEditablePlaylistDetailHeaderRenderer.editHeader);
    }

    public final int hashCode() {
        return this.editHeader.hashCode() + (this.header.hashCode() * 31);
    }

    public final String toString() {
        return "MusicEditablePlaylistDetailHeaderRenderer(header=" + this.header + ", editHeader=" + this.editHeader + ")";
    }
}
