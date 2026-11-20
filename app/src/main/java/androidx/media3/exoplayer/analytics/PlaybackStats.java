package androidx.media3.exoplayer.analytics;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaybackStats {
    public static final PlaybackStats EMPTY = merge(new PlaybackStats[0]);
    public final int abandonedBeforeReadyCount;
    public final int adPlaybackCount;
    public final int backgroundJoiningCount;
    public final int endedCount;
    public final int fatalErrorCount;
    public final int fatalErrorPlaybackCount;
    public final long firstReportedTimeMs;
    public final int foregroundPlaybackCount;
    public final int initialAudioFormatBitrateCount;
    public final int initialVideoFormatBitrateCount;
    public final int initialVideoFormatHeightCount;
    public final long maxRebufferTimeMs;
    public final int nonFatalErrorCount;
    public final int playbackCount;
    public final long[] playbackStateDurationsMs;
    public final long totalAudioFormatBitrateTimeProduct;
    public final long totalAudioFormatTimeMs;
    public final long totalAudioUnderruns;
    public final long totalBandwidthBytes;
    public final long totalBandwidthTimeMs;
    public final long totalDroppedFrames;
    public final long totalInitialAudioFormatBitrate;
    public final long totalInitialVideoFormatBitrate;
    public final int totalInitialVideoFormatHeight;
    public final int totalPauseBufferCount;
    public final int totalPauseCount;
    public final int totalRebufferCount;
    public final int totalSeekCount;
    public final long totalValidJoinTimeMs;
    public final long totalVideoFormatBitrateTimeMs;
    public final long totalVideoFormatBitrateTimeProduct;
    public final long totalVideoFormatHeightTimeMs;
    public final long totalVideoFormatHeightTimeProduct;
    public final int validJoinTimeCount;

    public PlaybackStats(int i, long[] jArr, List list, List list2, long j, int i2, int i3, int i4, int i5, long j2, int i6, int i7, int i8, int i9, int i10, long j3, int i11, List list3, List list4, long j4, long j5, long j6, long j7, long j8, long j9, int i12, int i13, int i14, long j10, int i15, long j11, long j12, long j13, long j14, long j15, int i16, int i17, int i18, List list5, List list6) {
        this.playbackCount = i;
        this.playbackStateDurationsMs = jArr;
        Collections.unmodifiableList(list);
        Collections.unmodifiableList(list2);
        this.firstReportedTimeMs = j;
        this.foregroundPlaybackCount = i2;
        this.abandonedBeforeReadyCount = i3;
        this.endedCount = i4;
        this.backgroundJoiningCount = i5;
        this.totalValidJoinTimeMs = j2;
        this.validJoinTimeCount = i6;
        this.totalPauseCount = i7;
        this.totalPauseBufferCount = i8;
        this.totalSeekCount = i9;
        this.totalRebufferCount = i10;
        this.maxRebufferTimeMs = j3;
        this.adPlaybackCount = i11;
        Collections.unmodifiableList(list3);
        Collections.unmodifiableList(list4);
        this.totalVideoFormatHeightTimeMs = j4;
        this.totalVideoFormatHeightTimeProduct = j5;
        this.totalVideoFormatBitrateTimeMs = j6;
        this.totalVideoFormatBitrateTimeProduct = j7;
        this.totalAudioFormatTimeMs = j8;
        this.totalAudioFormatBitrateTimeProduct = j9;
        this.initialVideoFormatHeightCount = i12;
        this.initialVideoFormatBitrateCount = i13;
        this.totalInitialVideoFormatHeight = i14;
        this.totalInitialVideoFormatBitrate = j10;
        this.initialAudioFormatBitrateCount = i15;
        this.totalInitialAudioFormatBitrate = j11;
        this.totalBandwidthTimeMs = j12;
        this.totalBandwidthBytes = j13;
        this.totalDroppedFrames = j14;
        this.totalAudioUnderruns = j15;
        this.fatalErrorPlaybackCount = i16;
        this.fatalErrorCount = i17;
        this.nonFatalErrorCount = i18;
        Collections.unmodifiableList(list5);
        Collections.unmodifiableList(list6);
    }

    public static PlaybackStats merge(PlaybackStats... playbackStatsArr) {
        PlaybackStats[] playbackStatsArr2 = playbackStatsArr;
        long[] jArr = new long[16];
        int length = playbackStatsArr2.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        long j11 = -1;
        long j12 = -1;
        long jMax = -9223372036854775807L;
        long jMin = -9223372036854775807L;
        long j13 = -9223372036854775807L;
        int i15 = -1;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i16 < length) {
            PlaybackStats playbackStats = playbackStatsArr2[i16];
            int i20 = i + playbackStats.playbackCount;
            for (int i21 = 0; i21 < 16; i21++) {
                jArr[i21] = jArr[i21] + playbackStats.playbackStateDurationsMs[i21];
            }
            long j14 = playbackStats.firstReportedTimeMs;
            if (jMin == -9223372036854775807L) {
                jMin = j14;
            } else if (j14 != -9223372036854775807L) {
                jMin = Math.min(jMin, j14);
            }
            i17 += playbackStats.foregroundPlaybackCount;
            i18 += playbackStats.abandonedBeforeReadyCount;
            i19 += playbackStats.endedCount;
            i2 += playbackStats.backgroundJoiningCount;
            long j15 = playbackStats.totalValidJoinTimeMs;
            if (j13 == -9223372036854775807L) {
                j13 = j15;
            } else if (j15 != -9223372036854775807L) {
                j13 += j15;
            }
            i3 += playbackStats.validJoinTimeCount;
            i4 += playbackStats.totalPauseCount;
            i5 += playbackStats.totalPauseBufferCount;
            i6 += playbackStats.totalSeekCount;
            i7 += playbackStats.totalRebufferCount;
            long j16 = playbackStats.maxRebufferTimeMs;
            if (jMax == -9223372036854775807L) {
                jMax = j16;
            } else if (j16 != -9223372036854775807L) {
                jMax = Math.max(jMax, j16);
            }
            i8 += playbackStats.adPlaybackCount;
            j += playbackStats.totalVideoFormatHeightTimeMs;
            j2 += playbackStats.totalVideoFormatHeightTimeProduct;
            j3 += playbackStats.totalVideoFormatBitrateTimeMs;
            j4 += playbackStats.totalVideoFormatBitrateTimeProduct;
            j5 += playbackStats.totalAudioFormatTimeMs;
            j6 += playbackStats.totalAudioFormatBitrateTimeProduct;
            i9 += playbackStats.initialVideoFormatHeightCount;
            i10 += playbackStats.initialVideoFormatBitrateCount;
            int i22 = playbackStats.totalInitialVideoFormatHeight;
            int i23 = i15;
            int i24 = length;
            if (i23 != -1) {
                i22 = i22 != -1 ? i22 + i23 : i23;
            }
            long j17 = playbackStats.totalInitialVideoFormatBitrate;
            if (j11 == -1) {
                j11 = j17;
            } else if (j17 != -1) {
                j11 += j17;
            }
            i11 += playbackStats.initialAudioFormatBitrateCount;
            long j18 = playbackStats.totalInitialAudioFormatBitrate;
            if (j12 == -1) {
                j12 = j18;
            } else if (j18 != -1) {
                j12 += j18;
            }
            j7 += playbackStats.totalBandwidthTimeMs;
            j8 += playbackStats.totalBandwidthBytes;
            j9 += playbackStats.totalDroppedFrames;
            j10 += playbackStats.totalAudioUnderruns;
            i12 += playbackStats.fatalErrorPlaybackCount;
            i13 += playbackStats.fatalErrorCount;
            i14 += playbackStats.nonFatalErrorCount;
            i16++;
            length = i24;
            i = i20;
            i15 = i22;
            playbackStatsArr2 = playbackStatsArr;
        }
        int i25 = i17;
        long j19 = jMin;
        int i26 = i2;
        long j20 = j13;
        int i27 = i3;
        int i28 = i4;
        int i29 = i5;
        int i30 = i6;
        int i31 = i7;
        long j21 = jMax;
        List list = Collections.EMPTY_LIST;
        return new PlaybackStats(i, jArr, list, list, j19, i25, i18, i19, i26, j20, i27, i28, i29, i30, i31, j21, i8, list, list, j, j2, j3, j4, j5, j6, i9, i10, i15, j11, i11, j12, j7, j8, j9, j10, i12, i13, i14, list, list);
    }
}
