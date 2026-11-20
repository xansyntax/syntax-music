package com.metrolist.music.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\tÊ\u0001\f\b\u000b\u0012\b\b\f\u0012\u0004\b\u0003\u0010\u0000¨\u0006\n"}, d2 = {"Lcom/metrolist/music/models/QueueData;", "Ljava/io/Serializable;", "<init>", "()V", "YouTubeData", "YouTubeAlbumRadioData", "LocalAlbumRadioData", "Lcom/metrolist/music/models/QueueData$LocalAlbumRadioData;", "Lcom/metrolist/music/models/QueueData$YouTubeAlbumRadioData;", "Lcom/metrolist/music/models/QueueData$YouTubeData;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public abstract class QueueData implements Serializable {
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LocalAlbumRadioData extends QueueData {
        public final String albumId;

        public LocalAlbumRadioData() {
            super(null);
            this.albumId = "local_album_radio";
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LocalAlbumRadioData) && Intrinsics.areEqual(this.albumId, ((LocalAlbumRadioData) obj).albumId);
        }

        public final int hashCode() {
            return Boolean.hashCode(false) + IntIntPair$$ExternalSyntheticOutline0.m(0, this.albumId.hashCode() * 31, 29791);
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("LocalAlbumRadioData(albumId=", this.albumId, ", startIndex=0, playlistId=null, continuation=null, firstTimeLoaded=false)");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class YouTubeAlbumRadioData extends QueueData {
        public final String playlistId;

        public YouTubeAlbumRadioData() {
            super(null);
            this.playlistId = "youtube_album_radio";
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof YouTubeAlbumRadioData) && Intrinsics.areEqual(this.playlistId, ((YouTubeAlbumRadioData) obj).playlistId);
        }

        public final int hashCode() {
            return Boolean.hashCode(false) + IntIntPair$$ExternalSyntheticOutline0.m(0, this.playlistId.hashCode() * 31, 961);
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("YouTubeAlbumRadioData(playlistId=", this.playlistId, ", albumSongCount=0, continuation=null, firstTimeLoaded=false)");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class YouTubeData extends QueueData {
        public final String endpoint;

        public YouTubeData() {
            super(null);
            this.endpoint = "youtube_queue";
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof YouTubeData) && Intrinsics.areEqual(this.endpoint, ((YouTubeData) obj).endpoint);
        }

        public final int hashCode() {
            return this.endpoint.hashCode() * 31;
        }

        public final String toString() {
            return IntIntPair$$ExternalSyntheticOutline0.m("YouTubeData(endpoint=", this.endpoint, ", continuation=null)");
        }
    }

    public /* synthetic */ QueueData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private QueueData() {
    }
}
