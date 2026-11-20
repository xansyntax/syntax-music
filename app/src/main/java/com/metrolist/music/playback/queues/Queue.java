package com.metrolist.music.playback.queues;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.media3.common.MediaItem;
import com.metrolist.music.models.MediaMetadata;
import com.metrolist.music.ui.menu.AlbumMenuKt$$ExternalSyntheticLambda13;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\u000e\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH&J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH¦@¢\u0006\u0002\u0010\bR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/metrolist/music/playback/queues/Queue;", "", "preloadItem", "Lcom/metrolist/music/models/MediaMetadata;", "getPreloadItem", "()Lcom/metrolist/music/models/MediaMetadata;", "getInitialStatus", "Lcom/metrolist/music/playback/queues/Queue$Status;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextPage", "", "nextPage", "", "Landroidx/media3/common/MediaItem;", "Status", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface Queue {
    Object getInitialStatus(Continuation continuation);

    MediaMetadata getPreloadItem();

    boolean hasNextPage();

    Object nextPage(Continuation continuation);

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u0017J\u001c\u0010\u001a\u001a\u00020\u00002\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00170\u001cH\u0002J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J9\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0014\u0010\"\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\bHÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\f\b'\u0012\b\b(\u0012\u0004\b\u0003\u0010\u0000¨\u0006&"}, d2 = {"Lcom/metrolist/music/playback/queues/Queue$Status;", "", LinkHeader.Parameters.Title, "", "items", "", "Landroidx/media3/common/MediaItem;", "mediaItemIndex", "", "position", "", "<init>", "(Ljava/lang/String;Ljava/util/List;IJ)V", "getTitle", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "getMediaItemIndex", "()I", "getPosition", "()J", "filterExplicit", "enabled", "", "filterVideoSongs", "disableVideos", "filterItems", "keep", "Lkotlin/Function1;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Status {
        public static final int $stable = 8;
        private final List<MediaItem> items;
        private final int mediaItemIndex;
        private final long position;
        private final String title;

        public Status(String str, List<MediaItem> list, int i, long j) {
            list.getClass();
            this.title = str;
            this.items = list;
            this.mediaItemIndex = i;
            this.position = j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Status copy$default(Status status, String str, List list, int i, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = status.title;
            }
            if ((i2 & 2) != 0) {
                list = status.items;
            }
            if ((i2 & 4) != 0) {
                i = status.mediaItemIndex;
            }
            if ((i2 & 8) != 0) {
                j = status.position;
            }
            int i3 = i;
            return status.copy(str, list, i3, j);
        }

        public static /* synthetic */ Status filterExplicit$default(Status status, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = true;
            }
            return status.filterExplicit(z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean filterExplicit$lambda$0(MediaItem mediaItem) {
            mediaItem.getClass();
            MediaMetadata metadata = UuidKt.getMetadata(mediaItem);
            boolean z = false;
            if (metadata != null && metadata.explicit) {
                z = true;
            }
            return !z;
        }

        private final Status filterItems(Function1 keep) {
            int i;
            List<MediaItem> list = this.items;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((Boolean) keep.invoke(obj)).booleanValue()) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.size() == this.items.size()) {
                return this;
            }
            MediaItem mediaItem = (MediaItem) CollectionsKt.getOrNull(this.mediaItemIndex, this.items);
            List<MediaItem> list2 = this.items;
            int i2 = this.mediaItemIndex;
            if (i2 < 0) {
                i2 = 0;
            }
            List listTake = CollectionsKt.take(list2, i2);
            if (listTake.isEmpty()) {
                i = 0;
            } else {
                Iterator it = listTake.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (((Boolean) keep.invoke(it.next())).booleanValue() && (i = i + 1) < 0) {
                        CollectionsKt__IterablesKt.throwCountOverflow();
                        throw null;
                    }
                }
            }
            int size = arrayList.size() - 1;
            int i3 = size >= 0 ? size : 0;
            if (i <= i3) {
                i3 = i;
            }
            return copy$default(this, null, arrayList, i3, (mediaItem == null || !((Boolean) keep.invoke(mediaItem)).booleanValue()) ? 0L : this.position, 1, null);
        }

        public static /* synthetic */ Status filterVideoSongs$default(Status status, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return status.filterVideoSongs(z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean filterVideoSongs$lambda$0(MediaItem mediaItem) {
            mediaItem.getClass();
            MediaMetadata metadata = UuidKt.getMetadata(mediaItem);
            boolean z = false;
            if (metadata != null && metadata.isVideoSong()) {
                z = true;
            }
            return !z;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public final List<MediaItem> component2() {
            return this.items;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getMediaItemIndex() {
            return this.mediaItemIndex;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getPosition() {
            return this.position;
        }

        public final Status copy(String title, List<MediaItem> items, int mediaItemIndex, long position) {
            items.getClass();
            return new Status(title, items, mediaItemIndex, position);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Status)) {
                return false;
            }
            Status status = (Status) other;
            return Intrinsics.areEqual(this.title, status.title) && Intrinsics.areEqual(this.items, status.items) && this.mediaItemIndex == status.mediaItemIndex && this.position == status.position;
        }

        public final Status filterExplicit(boolean enabled) {
            return enabled ? filterItems(new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 4)) : this;
        }

        public final Status filterVideoSongs(boolean disableVideos) {
            return disableVideos ? filterItems(new AlbumMenuKt$$ExternalSyntheticLambda13((byte) 3)) : this;
        }

        public final List<MediaItem> getItems() {
            return this.items;
        }

        public final int getMediaItemIndex() {
            return this.mediaItemIndex;
        }

        public final long getPosition() {
            return this.position;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String str = this.title;
            return Long.hashCode(this.position) + IntIntPair$$ExternalSyntheticOutline0.m(this.mediaItemIndex, Fragment$5$$ExternalSyntheticOutline0.m((str == null ? 0 : str.hashCode()) * 31, 31, this.items), 31);
        }

        public String toString() {
            return "Status(title=" + this.title + ", items=" + this.items + ", mediaItemIndex=" + this.mediaItemIndex + ", position=" + this.position + ")";
        }

        public /* synthetic */ Status(String str, List list, int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, list, i, (i2 & 8) != 0 ? 0L : j);
        }
    }
}
