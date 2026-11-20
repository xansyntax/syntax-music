package androidx.media3.common.util;

import androidx.compose.ui.node.NodeChain;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.ExoPlayerImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StuckPlayerDetector$StuckSuppressedDetector {
    public boolean isSuppressed;
    public long startRealtimeMs;
    public int suppressionReason;
    public final /* synthetic */ NodeChain this$0;

    public StuckPlayerDetector$StuckSuppressedDetector(NodeChain nodeChain) {
        this.this$0 = nodeChain;
    }

    public final void update() {
        NodeChain nodeChain = this.this$0;
        SystemHandlerWrapper systemHandlerWrapper = (SystemHandlerWrapper) nodeChain.head;
        ExoPlayerImpl exoPlayerImpl = (ExoPlayerImpl) nodeChain.layoutNode;
        int playbackSuppressionReason = exoPlayerImpl.getPlaybackSuppressionReason();
        if (!exoPlayerImpl.getPlayWhenReady() || exoPlayerImpl.getPlaybackState() == 1 || exoPlayerImpl.getPlaybackState() == 4 || playbackSuppressionReason == 0 || playbackSuppressionReason == 1) {
            if (this.isSuppressed) {
                systemHandlerWrapper.removeMessages(4);
            }
            this.isSuppressed = false;
            return;
        }
        ((SystemClock) nodeChain.outerCoordinator).getClass();
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        if (this.isSuppressed && this.suppressionReason == playbackSuppressionReason) {
            if (jElapsedRealtime - this.startRealtimeMs >= 600000) {
                ExoPlayerImpl.this.stopInternal(new ExoPlaybackException(2, new StuckPlayerException(4, 600000), 1003));
                return;
            }
            return;
        }
        this.isSuppressed = true;
        this.startRealtimeMs = jElapsedRealtime;
        this.suppressionReason = playbackSuppressionReason;
        systemHandlerWrapper.removeMessages(4);
        systemHandlerWrapper.handler.sendEmptyMessageDelayed(4, 600000L);
    }
}
