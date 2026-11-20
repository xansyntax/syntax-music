package androidx.media3.session;

import androidx.media3.common.util.Util;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionImpl$$ExternalSyntheticLambda18 implements Executor {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ MediaLibrarySessionImpl f$0;

    public /* synthetic */ MediaSessionImpl$$ExternalSyntheticLambda18(MediaLibrarySessionImpl mediaLibrarySessionImpl, byte b) {
        this.$r8$classId = b;
        this.f$0 = mediaLibrarySessionImpl;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        byte b = this.$r8$classId;
        MediaLibrarySessionImpl mediaLibrarySessionImpl = this.f$0;
        switch (b) {
            case 0:
                Util.postOrRun(mediaLibrarySessionImpl.applicationHandler, runnable);
                break;
            case 1:
                mediaLibrarySessionImpl.postOrRunOnApplicationHandler(runnable);
                break;
            default:
                mediaLibrarySessionImpl.postOrRunOnApplicationHandler(runnable);
                break;
        }
    }
}
