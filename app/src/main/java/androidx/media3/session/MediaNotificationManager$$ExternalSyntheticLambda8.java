package androidx.media3.session;

import android.util.SparseBooleanArray;
import java.util.List;
import okhttp3.internal.http.StatusLine;
import okio.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaNotificationManager$$ExternalSyntheticLambda8 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ MediaNotificationManager$$ExternalSyntheticLambda8(byte b, int i, Object obj, Object obj2, Object obj3) {
        this.$r8$classId = b;
        this.f$0 = obj;
        this.f$1 = i;
        this.f$2 = obj2;
        this.f$3 = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        Object obj = this.f$3;
        Object obj2 = this.f$2;
        int i = this.f$1;
        Object obj3 = this.f$0;
        switch (b) {
            case 0:
                MediaNotificationManager mediaNotificationManager = (MediaNotificationManager) obj3;
                MediaLibraryService.MediaLibrarySession mediaLibrarySession = (MediaLibraryService.MediaLibrarySession) obj2;
                PriorityQueue priorityQueue = (PriorityQueue) obj;
                if (i == mediaNotificationManager.totalNotificationCount) {
                    mediaNotificationManager.updateNotificationInternal(mediaLibrarySession, priorityQueue, mediaNotificationManager.shouldRunInForeground(false));
                }
                break;
            default:
                List list = (List) obj2;
                MediaSession$ControllerInfo mediaSession$ControllerInfo = (MediaSession$ControllerInfo) obj;
                MediaLibrarySessionImpl mediaLibrarySessionImpl = ((MediaSessionLegacyStub) ((StatusLine) obj3).message).sessionImpl;
                if (i == -1) {
                    mediaLibrarySessionImpl.playerWrapper.addMediaItems(list);
                } else {
                    mediaLibrarySessionImpl.playerWrapper.addMediaItems(i, list);
                }
                new SparseBooleanArray().append(20, true);
                mediaLibrarySessionImpl.onPlayerInteractionFinishedOnHandler(mediaSession$ControllerInfo);
                break;
        }
    }
}
