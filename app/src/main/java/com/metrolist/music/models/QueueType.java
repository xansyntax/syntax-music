package com.metrolist.music.models;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000bÊ\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0000¨\u0006\f"}, d2 = {"Lcom/metrolist/music/models/QueueType;", "Ljava/io/Serializable;", "<init>", "()V", "LIST", "YOUTUBE", "YOUTUBE_ALBUM_RADIO", "LOCAL_ALBUM_RADIO", "Lcom/metrolist/music/models/QueueType$LIST;", "Lcom/metrolist/music/models/QueueType$LOCAL_ALBUM_RADIO;", "Lcom/metrolist/music/models/QueueType$YOUTUBE;", "Lcom/metrolist/music/models/QueueType$YOUTUBE_ALBUM_RADIO;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
public abstract class QueueType implements Serializable {
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LIST extends QueueType {
        public static final LIST INSTANCE = new LIST(null);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LOCAL_ALBUM_RADIO extends QueueType {
        public static final LOCAL_ALBUM_RADIO INSTANCE = new LOCAL_ALBUM_RADIO(null);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class YOUTUBE extends QueueType {
        public static final YOUTUBE INSTANCE = new YOUTUBE(null);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class YOUTUBE_ALBUM_RADIO extends QueueType {
        public static final YOUTUBE_ALBUM_RADIO INSTANCE = new YOUTUBE_ALBUM_RADIO(null);
    }

    public /* synthetic */ QueueType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private QueueType() {
    }
}
