package com.metrolist.music.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import io.ktor.http.LinkHeader;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000eHÆ\u0003JO\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0014\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0083\u0004J\n\u0010(\u001a\u00020\bHÖ\u0081\u0004J\n\u0010)\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cÊ\u0001\f\b+\u0012\b\b,\u0012\u0004\b\u0003\u0010\u0002¨\u0006*"}, d2 = {"Lcom/metrolist/music/models/PersistQueue;", "Ljava/io/Serializable;", LinkHeader.Parameters.Title, "", "items", "", "Lcom/metrolist/music/models/MediaMetadata;", "mediaItemIndex", "", "position", "", "queueType", "Lcom/metrolist/music/models/QueueType;", "queueData", "Lcom/metrolist/music/models/QueueData;", "<init>", "(Ljava/lang/String;Ljava/util/List;IJLcom/metrolist/music/models/QueueType;Lcom/metrolist/music/models/QueueData;)V", "getTitle", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "getMediaItemIndex", "()I", "getPosition", "()J", "getQueueType", "()Lcom/metrolist/music/models/QueueType;", "getQueueData", "()Lcom/metrolist/music/models/QueueData;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class PersistQueue implements Serializable {
    public static final int $stable = 0;
    private final List<MediaMetadata> items;
    private final int mediaItemIndex;
    private final long position;
    private final QueueData queueData;
    private final QueueType queueType;
    private final String title;

    public /* synthetic */ PersistQueue(String str, List list, int i, long j, QueueType queueType, QueueData queueData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, i, j, (i2 & 16) != 0 ? QueueType.LIST.INSTANCE : queueType, (i2 & 32) != 0 ? null : queueData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PersistQueue copy$default(PersistQueue persistQueue, String str, List list, int i, long j, QueueType queueType, QueueData queueData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = persistQueue.title;
        }
        if ((i2 & 2) != 0) {
            list = persistQueue.items;
        }
        if ((i2 & 4) != 0) {
            i = persistQueue.mediaItemIndex;
        }
        if ((i2 & 8) != 0) {
            j = persistQueue.position;
        }
        if ((i2 & 16) != 0) {
            queueType = persistQueue.queueType;
        }
        if ((i2 & 32) != 0) {
            queueData = persistQueue.queueData;
        }
        long j2 = j;
        int i3 = i;
        return persistQueue.copy(str, list, i3, j2, queueType, queueData);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final List<MediaMetadata> component2() {
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

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final QueueType getQueueType() {
        return this.queueType;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final QueueData getQueueData() {
        return this.queueData;
    }

    public final PersistQueue copy(String title, List<MediaMetadata> items, int mediaItemIndex, long position, QueueType queueType, QueueData queueData) {
        items.getClass();
        queueType.getClass();
        return new PersistQueue(title, items, mediaItemIndex, position, queueType, queueData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PersistQueue)) {
            return false;
        }
        PersistQueue persistQueue = (PersistQueue) other;
        return Intrinsics.areEqual(this.title, persistQueue.title) && Intrinsics.areEqual(this.items, persistQueue.items) && this.mediaItemIndex == persistQueue.mediaItemIndex && this.position == persistQueue.position && Intrinsics.areEqual(this.queueType, persistQueue.queueType) && Intrinsics.areEqual(this.queueData, persistQueue.queueData);
    }

    public final List<MediaMetadata> getItems() {
        return this.items;
    }

    public final int getMediaItemIndex() {
        return this.mediaItemIndex;
    }

    public final long getPosition() {
        return this.position;
    }

    public final QueueData getQueueData() {
        return this.queueData;
    }

    public final QueueType getQueueType() {
        return this.queueType;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (this.queueType.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.mediaItemIndex, Fragment$5$$ExternalSyntheticOutline0.m((str == null ? 0 : str.hashCode()) * 31, 31, this.items), 31), 31, this.position)) * 31;
        QueueData queueData = this.queueData;
        return iHashCode + (queueData != null ? queueData.hashCode() : 0);
    }

    public String toString() {
        return "PersistQueue(title=" + this.title + ", items=" + this.items + ", mediaItemIndex=" + this.mediaItemIndex + ", position=" + this.position + ", queueType=" + this.queueType + ", queueData=" + this.queueData + ")";
    }

    public PersistQueue(String str, List<MediaMetadata> list, int i, long j, QueueType queueType, QueueData queueData) {
        list.getClass();
        queueType.getClass();
        this.title = str;
        this.items = list;
        this.mediaItemIndex = i;
        this.position = j;
        this.queueType = queueType;
        this.queueData = queueData;
    }
}
