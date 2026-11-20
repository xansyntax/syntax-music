package androidx.media3.session;

import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSession$MediaItemsWithStartPosition {
    public final ImmutableList mediaItems;
    public final int startIndex;
    public final long startPositionMs;

    public MediaSession$MediaItemsWithStartPosition(List list, int i, long j) {
        this.mediaItems = ImmutableList.copyOf((Collection) list);
        this.startIndex = i;
        this.startPositionMs = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSession$MediaItemsWithStartPosition)) {
            return false;
        }
        MediaSession$MediaItemsWithStartPosition mediaSession$MediaItemsWithStartPosition = (MediaSession$MediaItemsWithStartPosition) obj;
        return this.mediaItems.equals(mediaSession$MediaItemsWithStartPosition.mediaItems) && this.startIndex == mediaSession$MediaItemsWithStartPosition.startIndex && this.startPositionMs == mediaSession$MediaItemsWithStartPosition.startPositionMs;
    }

    public final int hashCode() {
        return Long.hashCode(this.startPositionMs) + (((this.mediaItems.hashCode() * 31) + this.startIndex) * 31);
    }
}
