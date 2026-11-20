package androidx.media3.session;

import androidx.compose.ui.node.NodeChain;
import androidx.media3.exoplayer.video.VideoFrameReleaseHelper;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.utils.potoken.PoTokenWebView;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaSessionService$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ MediaSessionService$$ExternalSyntheticLambda3(byte b, Object obj) {
        this.$r8$classId = b;
        this.f$0 = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConnectionPool connectionPool;
        byte b = this.$r8$classId;
        Object obj = this.f$0;
        switch (b) {
            case 0:
                MediaSessionService mediaSessionService = (MediaSessionService) obj;
                int i = MediaSessionService.$r8$clinit;
                synchronized (mediaSessionService.lock) {
                    connectionPool = mediaSessionService.listener;
                    break;
                }
                if (connectionPool != null) {
                    MusicService musicService = (MusicService) connectionPool.delegate;
                    boolean z = MusicService.isRunning;
                    musicService.handleForegroundServiceStartNotAllowed(null);
                    return;
                }
                return;
            case 1:
                ((VideoFrameReleaseHelper.VSyncSamplerV33) obj).lambda$onVsync$0();
                return;
            case 2:
                ((MediaController) obj).release();
                return;
            case 3:
                ((NodeChain.Differ) obj).release();
                return;
            default:
                ((PoTokenWebView) obj).destroyWebView();
                return;
        }
    }
}
