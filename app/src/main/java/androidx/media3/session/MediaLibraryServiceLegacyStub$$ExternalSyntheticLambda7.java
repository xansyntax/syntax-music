package androidx.media3.session;

import androidx.media3.common.util.Log;
import androidx.media3.session.legacy.MediaBrowserCompat;
import androidx.media3.session.legacy.MediaBrowserServiceCompat$Result;
import com.google.common.util.concurrent.SettableFuture;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda7 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ SettableFuture f$0;
    public final /* synthetic */ MediaBrowserServiceCompat$Result f$1;

    public /* synthetic */ MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda7(SettableFuture settableFuture, MediaBrowserServiceCompat$Result mediaBrowserServiceCompat$Result, byte b) {
        this.$r8$classId = b;
        this.f$0 = settableFuture;
        this.f$1 = mediaBrowserServiceCompat$Result;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte b = this.$r8$classId;
        MediaBrowserServiceCompat$Result mediaBrowserServiceCompat$Result = this.f$1;
        SettableFuture settableFuture = this.f$0;
        switch (b) {
            case 0:
                try {
                    mediaBrowserServiceCompat$Result.sendResult((MediaBrowserCompat.MediaItem) settableFuture.get());
                } catch (InterruptedException | CancellationException | ExecutionException e) {
                    Log.w("MLSLegacyStub", "Library operation failed", e);
                    mediaBrowserServiceCompat$Result.sendResult(null);
                }
                break;
            default:
                try {
                    List list = (List) settableFuture.get();
                    mediaBrowserServiceCompat$Result.sendResult(list == null ? null : MediaUtils.truncateListBySize(list));
                } catch (InterruptedException | CancellationException | ExecutionException e2) {
                    Log.w("MLSLegacyStub", "Library operation failed", e2);
                    mediaBrowserServiceCompat$Result.sendResult(null);
                    return;
                }
                break;
        }
    }
}
