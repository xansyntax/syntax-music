package androidx.media3.session;

import android.os.Bundle;
import androidx.core.provider.CallbackWrapper;
import com.google.common.collect.ImmutableList;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface MediaNotification$Provider {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface Callback {
        void onNotificationChanged(PriorityQueue priorityQueue);
    }

    PriorityQueue createNotification(MediaLibraryService.MediaLibrarySession mediaLibrarySession, ImmutableList immutableList, DefaultActionFactory defaultActionFactory, Callback callback);

    CallbackWrapper getNotificationChannelInfo();

    void handleCustomCommand(MediaLibraryService.MediaLibrarySession mediaLibrarySession, String str, Bundle bundle);
}
