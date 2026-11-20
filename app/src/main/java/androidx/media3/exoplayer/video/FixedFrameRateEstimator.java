package androidx.media3.exoplayer.video;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FixedFrameRateEstimator {
    public Matcher candidateMatcher;
    public boolean candidateMatcherActive;
    public Matcher currentMatcher;
    public int framesWithoutSyncCount;
    public long lastFramePresentationTimeNs;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Matcher {
        public long firstFrameDurationNs;
        public long firstFramePresentationTimeNs;
        public long frameCount;
        public long lastFramePresentationTimeNs;
        public long matchingFrameCount;
        public long matchingFrameDurationSumNs;
        public int recentFrameOutlierCount;
        public final boolean[] recentFrameOutlierFlags = new boolean[15];

        public final boolean isSynced() {
            return this.frameCount > 15 && this.recentFrameOutlierCount == 0;
        }

        public final void onNextFrame(long j) {
            long j2 = this.frameCount;
            if (j2 == 0) {
                this.firstFramePresentationTimeNs = j;
            } else if (j2 == 1) {
                long j3 = j - this.firstFramePresentationTimeNs;
                this.firstFrameDurationNs = j3;
                this.matchingFrameDurationSumNs = j3;
                this.matchingFrameCount = 1L;
            } else {
                long j4 = j - this.lastFramePresentationTimeNs;
                int i = (int) (j2 % 15);
                long jAbs = Math.abs(j4 - this.firstFrameDurationNs);
                boolean[] zArr = this.recentFrameOutlierFlags;
                if (jAbs <= 1000000) {
                    this.matchingFrameCount++;
                    this.matchingFrameDurationSumNs += j4;
                    if (zArr[i]) {
                        zArr[i] = false;
                        this.recentFrameOutlierCount--;
                    }
                } else if (!zArr[i]) {
                    zArr[i] = true;
                    this.recentFrameOutlierCount++;
                }
            }
            this.frameCount++;
            this.lastFramePresentationTimeNs = j;
        }

        public final void reset() {
            this.frameCount = 0L;
            this.matchingFrameCount = 0L;
            this.matchingFrameDurationSumNs = 0L;
            this.recentFrameOutlierCount = 0;
            Arrays.fill(this.recentFrameOutlierFlags, false);
        }
    }
}
