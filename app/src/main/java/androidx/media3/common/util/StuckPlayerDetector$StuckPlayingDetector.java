package androidx.media3.common.util;

import androidx.compose.ui.node.NodeChain;
import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.ExoPlayerImpl;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StuckPlayerDetector$StuckPlayingDetector {
    public int adGroupIndex;
    public int adIndexInAdGroup;
    public long currentPositionInPeriodMs;
    public boolean isPlaying;
    public Object periodUid;
    public long startRealtimeMs;
    public final int stuckPlayingTimeoutMs;
    public final /* synthetic */ NodeChain this$0;

    public StuckPlayerDetector$StuckPlayingDetector(NodeChain nodeChain, int i) {
        this.this$0 = nodeChain;
        this.stuckPlayingTimeoutMs = i;
    }

    public final void update() {
        NodeChain nodeChain = this.this$0;
        SystemHandlerWrapper systemHandlerWrapper = (SystemHandlerWrapper) nodeChain.head;
        ExoPlayerImpl exoPlayerImpl = (ExoPlayerImpl) nodeChain.layoutNode;
        if (!exoPlayerImpl.isPlaying()) {
            if (this.isPlaying) {
                systemHandlerWrapper.removeMessages(2);
            }
            this.isPlaying = false;
            return;
        }
        Timeline currentTimeline = exoPlayerImpl.getCurrentTimeline();
        Object uidOfPeriod = currentTimeline.isEmpty() ? null : currentTimeline.getUidOfPeriod(exoPlayerImpl.getCurrentPeriodIndex());
        int currentAdGroupIndex = exoPlayerImpl.getCurrentAdGroupIndex();
        int currentAdIndexInAdGroup = exoPlayerImpl.getCurrentAdIndexInAdGroup();
        long currentPosition = exoPlayerImpl.getCurrentPosition();
        if (uidOfPeriod != null && currentAdGroupIndex == -1) {
            currentPosition -= Util.usToMs(currentTimeline.getPeriodByUid(uidOfPeriod, (Timeline.Period) nodeChain.tail).positionInWindowUs);
        }
        ((SystemClock) nodeChain.outerCoordinator).getClass();
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        boolean z = this.isPlaying;
        int i = this.stuckPlayingTimeoutMs;
        if (z && Objects.equals(uidOfPeriod, this.periodUid) && currentAdGroupIndex == this.adGroupIndex && currentAdIndexInAdGroup == this.adIndexInAdGroup && currentPosition == this.currentPositionInPeriodMs) {
            if (jElapsedRealtime - this.startRealtimeMs >= i) {
                ExoPlayerImpl.this.stopInternal(new ExoPlaybackException(2, new StuckPlayerException(2, i), 1003));
                return;
            }
            return;
        }
        this.isPlaying = true;
        this.startRealtimeMs = jElapsedRealtime;
        this.periodUid = uidOfPeriod;
        this.adGroupIndex = currentAdGroupIndex;
        this.adIndexInAdGroup = currentAdIndexInAdGroup;
        this.currentPositionInPeriodMs = currentPosition;
        systemHandlerWrapper.removeMessages(2);
        systemHandlerWrapper.handler.sendEmptyMessageDelayed(2, i);
    }
}
