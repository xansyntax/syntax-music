package com.metrolist.music.playback.queues;

import androidx.media3.common.MediaItem;
import com.metrolist.music.models.MediaMetadata;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.uuid.UuidKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¨\u0006\u0007"}, d2 = {"filterExplicit", "", "Landroidx/media3/common/MediaItem;", "enabled", "", "filterVideoSongs", "disableVideos", "app"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class QueueKt {
    public static final List<MediaItem> filterExplicit(List<MediaItem> list, boolean z) {
        list.getClass();
        if (!z) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            MediaMetadata metadata = UuidKt.getMetadata((MediaItem) obj);
            if (metadata == null || !metadata.explicit) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ List filterExplicit$default(List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return filterExplicit(list, z);
    }

    public static final List<MediaItem> filterVideoSongs(List<MediaItem> list, boolean z) {
        list.getClass();
        if (!z) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            MediaMetadata metadata = UuidKt.getMetadata((MediaItem) obj);
            if (metadata == null || !metadata.isVideoSong()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ List filterVideoSongs$default(List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return filterVideoSongs(list, z);
    }
}
