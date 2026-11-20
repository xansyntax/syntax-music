package androidx.media3.common.util;

import androidx.compose.ui.node.NodeChain;
import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.ExoPlayerImpl;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class StuckPlayerDetector$StuckBufferingDetector {
    public int adGroupIndex;
    public int adIndexInAdGroup;
    public long bufferedDurationInOtherPeriodsMs;
    public long bufferedPositionInPeriodMs;
    public boolean isBuffering;
    public Object periodUid;
    public long startRealtimeMs;
    public final /* synthetic */ NodeChain this$0;

    public StuckPlayerDetector$StuckBufferingDetector(NodeChain nodeChain) {
        this.this$0 = nodeChain;
    }

    public final void update() {
        long j;
        NodeChain nodeChain = this.this$0;
        SystemHandlerWrapper systemHandlerWrapper = (SystemHandlerWrapper) nodeChain.head;
        ExoPlayerImpl exoPlayerImpl = (ExoPlayerImpl) nodeChain.layoutNode;
        if (exoPlayerImpl.getPlaybackState() != 2 || !exoPlayerImpl.getPlayWhenReady() || exoPlayerImpl.getPlaybackSuppressionReason() != 0) {
            if (this.isBuffering) {
                systemHandlerWrapper.removeMessages(1);
            }
            this.isBuffering = false;
            return;
        }
        Timeline currentTimeline = exoPlayerImpl.getCurrentTimeline();
        Object uidOfPeriod = currentTimeline.isEmpty() ? null : currentTimeline.getUidOfPeriod(exoPlayerImpl.getCurrentPeriodIndex());
        int currentAdGroupIndex = exoPlayerImpl.getCurrentAdGroupIndex();
        int currentAdIndexInAdGroup = exoPlayerImpl.getCurrentAdIndexInAdGroup();
        long bufferedPosition = exoPlayerImpl.getBufferedPosition();
        long jMax = Math.max(0L, exoPlayerImpl.getTotalBufferedDuration() - Math.max(0L, bufferedPosition - exoPlayerImpl.getCurrentPosition()));
        if (uidOfPeriod != null && currentAdGroupIndex == -1) {
            bufferedPosition -= Util.usToMs(currentTimeline.getPeriodByUid(uidOfPeriod, (Timeline.Period) nodeChain.tail).positionInWindowUs);
        }
        ((SystemClock) nodeChain.outerCoordinator).getClass();
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        if (this.isBuffering && Objects.equals(uidOfPeriod, this.periodUid) && currentAdGroupIndex == this.adGroupIndex && currentAdIndexInAdGroup == this.adIndexInAdGroup) {
            j = 600000;
            if (bufferedPosition == this.bufferedPositionInPeriodMs && jMax == this.bufferedDurationInOtherPeriodsMs) {
                if (jElapsedRealtime - this.startRealtimeMs >= 600000) {
                    ExoPlayerImpl.this.stopInternal(new ExoPlaybackException(2, new StuckPlayerException(1, 600000), 1003));
                    return;
                }
                return;
            }
        } else {
            j = 600000;
        }
        this.isBuffering = true;
        this.startRealtimeMs = jElapsedRealtime;
        this.periodUid = uidOfPeriod;
        this.adGroupIndex = currentAdGroupIndex;
        this.adIndexInAdGroup = currentAdIndexInAdGroup;
        this.bufferedPositionInPeriodMs = bufferedPosition;
        this.bufferedDurationInOtherPeriodsMs = jMax;
        systemHandlerWrapper.removeMessages(1);
        systemHandlerWrapper.handler.sendEmptyMessageDelayed(1, j);
    }
}
