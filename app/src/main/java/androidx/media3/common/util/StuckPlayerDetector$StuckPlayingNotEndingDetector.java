package androidx.media3.common.util;

import androidx.compose.ui.node.NodeChain;
import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.ExoPlayerImpl;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StuckPlayerDetector$StuckPlayingNotEndingDetector {
    public int adGroupIndex;
    public int adIndexInAdGroup;
    public boolean isPlayingAndReachedDuration;
    public Object periodUid;
    public long startRealtimeMs;
    public final int stuckPlayingNotEndingTimeoutMs;
    public final /* synthetic */ NodeChain this$0;

    public StuckPlayerDetector$StuckPlayingNotEndingDetector(NodeChain nodeChain, int i) {
        this.this$0 = nodeChain;
        this.stuckPlayingNotEndingTimeoutMs = i;
    }

    public final void update() {
        long duration;
        NodeChain nodeChain = this.this$0;
        Timeline.Period period = (Timeline.Period) nodeChain.tail;
        SystemHandlerWrapper systemHandlerWrapper = (SystemHandlerWrapper) nodeChain.head;
        ExoPlayerImpl exoPlayerImpl = (ExoPlayerImpl) nodeChain.layoutNode;
        Timeline currentTimeline = exoPlayerImpl.getCurrentTimeline();
        Object uidOfPeriod = currentTimeline.isEmpty() ? null : currentTimeline.getUidOfPeriod(exoPlayerImpl.getCurrentPeriodIndex());
        int currentAdGroupIndex = exoPlayerImpl.getCurrentAdGroupIndex();
        int currentAdIndexInAdGroup = exoPlayerImpl.getCurrentAdIndexInAdGroup();
        long currentPosition = exoPlayerImpl.getCurrentPosition();
        if (uidOfPeriod == null || currentAdGroupIndex != -1) {
            duration = currentAdGroupIndex != -1 ? exoPlayerImpl.getDuration() : -9223372036854775807L;
        } else {
            currentTimeline.getPeriodByUid(uidOfPeriod, period);
            currentPosition -= Util.usToMs(period.positionInWindowUs);
            duration = Util.usToMs(period.durationUs);
        }
        boolean zIsPlaying = exoPlayerImpl.isPlaying();
        if (!zIsPlaying || duration == -9223372036854775807L || currentPosition < duration) {
            systemHandlerWrapper.removeMessages(3);
            if (zIsPlaying && duration != -9223372036854775807L) {
                systemHandlerWrapper.handler.sendEmptyMessageDelayed(3, (int) Math.ceil((duration - currentPosition) / exoPlayerImpl.getPlaybackParameters().speed));
            }
            this.isPlayingAndReachedDuration = false;
            return;
        }
        ((SystemClock) nodeChain.outerCoordinator).getClass();
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        boolean z = this.isPlayingAndReachedDuration;
        int i = this.stuckPlayingNotEndingTimeoutMs;
        if (z && Objects.equals(uidOfPeriod, this.periodUid) && currentAdGroupIndex == this.adGroupIndex && currentAdIndexInAdGroup == this.adIndexInAdGroup) {
            if (jElapsedRealtime - this.startRealtimeMs >= i) {
                ExoPlayerImpl.this.stopInternal(new ExoPlaybackException(2, new StuckPlayerException(3, i), 1003));
                return;
            }
            return;
        }
        this.isPlayingAndReachedDuration = true;
        this.startRealtimeMs = jElapsedRealtime;
        this.periodUid = uidOfPeriod;
        this.adGroupIndex = currentAdGroupIndex;
        this.adIndexInAdGroup = currentAdIndexInAdGroup;
        systemHandlerWrapper.removeMessages(3);
        systemHandlerWrapper.handler.sendEmptyMessageDelayed(3, i);
    }
}
