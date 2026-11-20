package com.metrolist.music.playback.queues;

import com.metrolist.music.models.MediaMetadata;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0096@¢\u0006\u0002\u0010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0010"}, d2 = {"Lcom/metrolist/music/playback/queues/EmptyQueue;", "Lcom/metrolist/music/playback/queues/Queue;", "<init>", "()V", "preloadItem", "Lcom/metrolist/music/models/MediaMetadata;", "getPreloadItem", "()Lcom/metrolist/music/models/MediaMetadata;", "getInitialStatus", "Lcom/metrolist/music/playback/queues/Queue$Status;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextPage", "", "nextPage", "", "Landroidx/media3/common/MediaItem;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class EmptyQueue implements Queue {
    public static final int $stable = 0;
    public static final EmptyQueue INSTANCE = new EmptyQueue();
    private static final MediaMetadata preloadItem = null;

    private EmptyQueue() {
    }

    @Override // com.metrolist.music.playback.queues.Queue
    public Object getInitialStatus(Continuation continuation) {
        return new Queue.Status(null, EmptyList.INSTANCE, -1, 0L, 8, null);
    }

    @Override // com.metrolist.music.playback.queues.Queue
    public MediaMetadata getPreloadItem() {
        return preloadItem;
    }

    @Override // com.metrolist.music.playback.queues.Queue
    public boolean hasNextPage() {
        return false;
    }

    @Override // com.metrolist.music.playback.queues.Queue
    public Object nextPage(Continuation continuation) {
        return EmptyList.INSTANCE;
    }
}
