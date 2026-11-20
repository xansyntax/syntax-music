package com.metrolist.music.playback.queues;

import androidx.media3.common.MediaItem;
import com.metrolist.music.models.MediaMetadata;
import io.ktor.http.LinkHeader;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u000e\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010\u001bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018Ê\u0001\f\b!\u0012\b\b\"\u0012\u0004\b\u0003\u0010\u0000¨\u0006 "}, d2 = {"Lcom/metrolist/music/playback/queues/ListQueue;", "Lcom/metrolist/music/playback/queues/Queue;", LinkHeader.Parameters.Title, "", "items", "", "Landroidx/media3/common/MediaItem;", "startIndex", "", "position", "", "<init>", "(Ljava/lang/String;Ljava/util/List;IJ)V", "getTitle", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "getStartIndex", "()I", "getPosition", "()J", "preloadItem", "Lcom/metrolist/music/models/MediaMetadata;", "getPreloadItem", "()Lcom/metrolist/music/models/MediaMetadata;", "getInitialStatus", "Lcom/metrolist/music/playback/queues/Queue$Status;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextPage", "", "nextPage", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class ListQueue implements Queue {
    public static final int $stable = 8;
    private final List<MediaItem> items;
    private final long position;
    private final MediaMetadata preloadItem;
    private final int startIndex;
    private final String title;

    public /* synthetic */ ListQueue(String str, List list, int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, list, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? 0L : j);
    }

    @Override // com.metrolist.music.playback.queues.Queue
    public Object getInitialStatus(Continuation continuation) {
        return new Queue.Status(this.title, this.items, this.startIndex, this.position);
    }

    public final List<MediaItem> getItems() {
        return this.items;
    }

    public final long getPosition() {
        return this.position;
    }

    @Override // com.metrolist.music.playback.queues.Queue
    public MediaMetadata getPreloadItem() {
        return this.preloadItem;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // com.metrolist.music.playback.queues.Queue
    public boolean hasNextPage() {
        return false;
    }

    @Override // com.metrolist.music.playback.queues.Queue
    public Object nextPage(Continuation continuation) {
        throw new UnsupportedOperationException();
    }

    public ListQueue(String str, List<MediaItem> list, int i, long j) {
        list.getClass();
        this.title = str;
        this.items = list;
        this.startIndex = i;
        this.position = j;
    }
}
