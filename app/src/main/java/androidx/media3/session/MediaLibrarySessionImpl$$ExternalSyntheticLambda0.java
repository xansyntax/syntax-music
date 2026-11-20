package androidx.media3.session;

import com.google.common.util.concurrent.ListenableFuture;
import kotlinx.coroutines.guava.JobListenableFuture;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaLibrarySessionImpl$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaLibrarySessionImpl f$0;
    public final /* synthetic */ ListenableFuture f$1;
    public final /* synthetic */ MediaSession$ControllerInfo f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ MediaLibrarySessionImpl$$ExternalSyntheticLambda0(MediaLibrarySessionImpl mediaLibrarySessionImpl, JobListenableFuture jobListenableFuture, MediaSession$ControllerInfo mediaSession$ControllerInfo, int i, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaLibrarySessionImpl;
        this.f$1 = jobListenableFuture;
        this.f$2 = mediaSession$ControllerInfo;
        this.f$3 = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        int i = this.f$3;
        MediaSession$ControllerInfo mediaSession$ControllerInfo = this.f$2;
        ListenableFuture listenableFuture = this.f$1;
        MediaLibrarySessionImpl mediaLibrarySessionImpl = this.f$0;
        mediaLibrarySessionImpl.getClass();
        switch (b) {
            case 0:
                LibraryResult libraryResult = (LibraryResult) MediaLibrarySessionImpl.tryGetFutureResult(listenableFuture);
                if (libraryResult != null) {
                    mediaLibrarySessionImpl.maybeUpdateLegacyErrorState(mediaSession$ControllerInfo, libraryResult);
                    MediaLibrarySessionImpl.verifyResultItems(i, libraryResult);
                }
                break;
            default:
                LibraryResult libraryResult2 = (LibraryResult) MediaLibrarySessionImpl.tryGetFutureResult(listenableFuture);
                if (libraryResult2 != null) {
                    mediaLibrarySessionImpl.maybeUpdateLegacyErrorState(mediaSession$ControllerInfo, libraryResult2);
                    MediaLibrarySessionImpl.verifyResultItems(i, libraryResult2);
                }
                break;
        }
    }
}
