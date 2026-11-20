package androidx.media3.session;

import android.os.Bundle;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.media3.common.Player;
import androidx.media3.common.util.Util;
import coil3.util.UtilsKt;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SessionPositionInfo {
    public static final SessionPositionInfo DEFAULT;
    public static final Player.PositionInfo DEFAULT_POSITION_INFO;
    public static final String FIELD_BUFFERED_PERCENTAGE;
    public static final String FIELD_BUFFERED_POSITION_MS;
    public static final String FIELD_CONTENT_BUFFERED_POSITION_MS;
    public static final String FIELD_CONTENT_DURATION_MS;
    public static final String FIELD_CURRENT_LIVE_OFFSET_MS;
    public static final String FIELD_DURATION_MS;
    public static final String FIELD_EVENT_TIME_MS;
    public static final String FIELD_IS_PLAYING_AD;
    public static final String FIELD_POSITION_INFO;
    public static final String FIELD_TOTAL_BUFFERED_DURATION_MS;
    public final int bufferedPercentage;
    public final long bufferedPositionMs;
    public final long contentBufferedPositionMs;
    public final long contentDurationMs;
    public final long currentLiveOffsetMs;
    public final long durationMs;
    public final long eventTimeMs;
    public final boolean isPlayingAd;
    public final Player.PositionInfo positionInfo;
    public final long totalBufferedDurationMs;

    static {
        Player.PositionInfo positionInfo = new Player.PositionInfo(null, 0, null, null, 0, 0L, 0L, -1, -1);
        DEFAULT_POSITION_INFO = positionInfo;
        DEFAULT = new SessionPositionInfo(positionInfo, false, -9223372036854775807L, -9223372036854775807L, 0L, 0, 0L, -9223372036854775807L, -9223372036854775807L, 0L);
        String str = Util.DEVICE_DEBUG_INFO;
        FIELD_POSITION_INFO = Integer.toString(0, 36);
        FIELD_IS_PLAYING_AD = Integer.toString(1, 36);
        FIELD_EVENT_TIME_MS = Integer.toString(2, 36);
        FIELD_DURATION_MS = Integer.toString(3, 36);
        FIELD_BUFFERED_POSITION_MS = Integer.toString(4, 36);
        FIELD_BUFFERED_PERCENTAGE = Integer.toString(5, 36);
        FIELD_TOTAL_BUFFERED_DURATION_MS = Integer.toString(6, 36);
        FIELD_CURRENT_LIVE_OFFSET_MS = Integer.toString(7, 36);
        FIELD_CONTENT_DURATION_MS = Integer.toString(8, 36);
        FIELD_CONTENT_BUFFERED_POSITION_MS = Integer.toString(9, 36);
    }

    public SessionPositionInfo(Player.PositionInfo positionInfo, boolean z, long j, long j2, long j3, int i, long j4, long j5, long j6, long j7) {
        UtilsKt.checkArgument(z == (positionInfo.adGroupIndex != -1));
        this.positionInfo = positionInfo;
        this.isPlayingAd = z;
        this.eventTimeMs = j;
        this.durationMs = j2;
        this.bufferedPositionMs = j3;
        this.bufferedPercentage = i;
        this.totalBufferedDurationMs = j4;
        this.currentLiveOffsetMs = j5;
        this.contentDurationMs = j6;
        this.contentBufferedPositionMs = j7;
    }

    public static SessionPositionInfo fromBundle(int i, Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(FIELD_POSITION_INFO);
        return new SessionPositionInfo(bundle2 == null ? DEFAULT_POSITION_INFO : Player.PositionInfo.fromBundle(i, bundle2), bundle.getBoolean(FIELD_IS_PLAYING_AD, false), bundle.getLong(FIELD_EVENT_TIME_MS, -9223372036854775807L), bundle.getLong(FIELD_DURATION_MS, -9223372036854775807L), bundle.getLong(FIELD_BUFFERED_POSITION_MS, 0L), bundle.getInt(FIELD_BUFFERED_PERCENTAGE, 0), bundle.getLong(FIELD_TOTAL_BUFFERED_DURATION_MS, 0L), bundle.getLong(FIELD_CURRENT_LIVE_OFFSET_MS, -9223372036854775807L), bundle.getLong(FIELD_CONTENT_DURATION_MS, -9223372036854775807L), bundle.getLong(FIELD_CONTENT_BUFFERED_POSITION_MS, 0L));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SessionPositionInfo.class == obj.getClass()) {
            SessionPositionInfo sessionPositionInfo = (SessionPositionInfo) obj;
            if (this.eventTimeMs == sessionPositionInfo.eventTimeMs && this.positionInfo.equals(sessionPositionInfo.positionInfo) && this.isPlayingAd == sessionPositionInfo.isPlayingAd && this.durationMs == sessionPositionInfo.durationMs && this.bufferedPositionMs == sessionPositionInfo.bufferedPositionMs && this.bufferedPercentage == sessionPositionInfo.bufferedPercentage && this.totalBufferedDurationMs == sessionPositionInfo.totalBufferedDurationMs && this.currentLiveOffsetMs == sessionPositionInfo.currentLiveOffsetMs && this.contentDurationMs == sessionPositionInfo.contentDurationMs && this.contentBufferedPositionMs == sessionPositionInfo.contentBufferedPositionMs) {
                return true;
            }
        }
        return false;
    }

    public final SessionPositionInfo filterByAvailableCommands(boolean z, boolean z2) {
        if (z && z2) {
            return this;
        }
        return new SessionPositionInfo(this.positionInfo.filterByAvailableCommands(z, z2), z && this.isPlayingAd, this.eventTimeMs, z ? this.durationMs : -9223372036854775807L, z ? this.bufferedPositionMs : 0L, z ? this.bufferedPercentage : 0, z ? this.totalBufferedDurationMs : 0L, z ? this.currentLiveOffsetMs : -9223372036854775807L, z ? this.contentDurationMs : -9223372036854775807L, z ? this.contentBufferedPositionMs : 0L);
    }

    public final int hashCode() {
        return Objects.hash(this.positionInfo, Boolean.valueOf(this.isPlayingAd));
    }

    public final Bundle toBundle(int i) {
        Bundle bundle = new Bundle();
        Player.PositionInfo positionInfo = this.positionInfo;
        if (i < 3 || !DEFAULT_POSITION_INFO.equalsForBundling(positionInfo)) {
            bundle.putBundle(FIELD_POSITION_INFO, positionInfo.toBundle(i));
        }
        boolean z = this.isPlayingAd;
        if (z) {
            bundle.putBoolean(FIELD_IS_PLAYING_AD, z);
        }
        long j = this.eventTimeMs;
        if (j != -9223372036854775807L) {
            bundle.putLong(FIELD_EVENT_TIME_MS, j);
        }
        long j2 = this.durationMs;
        if (j2 != -9223372036854775807L) {
            bundle.putLong(FIELD_DURATION_MS, j2);
        }
        long j3 = this.bufferedPositionMs;
        if (i < 3 || j3 != 0) {
            bundle.putLong(FIELD_BUFFERED_POSITION_MS, j3);
        }
        int i2 = this.bufferedPercentage;
        if (i2 != 0) {
            bundle.putInt(FIELD_BUFFERED_PERCENTAGE, i2);
        }
        long j4 = this.totalBufferedDurationMs;
        if (j4 != 0) {
            bundle.putLong(FIELD_TOTAL_BUFFERED_DURATION_MS, j4);
        }
        long j5 = this.currentLiveOffsetMs;
        if (j5 != -9223372036854775807L) {
            bundle.putLong(FIELD_CURRENT_LIVE_OFFSET_MS, j5);
        }
        long j6 = this.contentDurationMs;
        if (j6 != -9223372036854775807L) {
            bundle.putLong(FIELD_CONTENT_DURATION_MS, j6);
        }
        long j7 = this.contentBufferedPositionMs;
        if (i >= 3 && j7 == 0) {
            return bundle;
        }
        bundle.putLong(FIELD_CONTENT_BUFFERED_POSITION_MS, j7);
        return bundle;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SessionPositionInfo {PositionInfo {mediaItemIndex=");
        Player.PositionInfo positionInfo = this.positionInfo;
        sb.append(positionInfo.mediaItemIndex);
        sb.append(", periodIndex=");
        sb.append(positionInfo.periodIndex);
        sb.append(", positionMs=");
        sb.append(positionInfo.positionMs);
        sb.append(", contentPositionMs=");
        sb.append(positionInfo.contentPositionMs);
        sb.append(", adGroupIndex=");
        sb.append(positionInfo.adGroupIndex);
        sb.append(", adIndexInAdGroup=");
        sb.append(positionInfo.adIndexInAdGroup);
        sb.append("}, isPlayingAd=");
        sb.append(this.isPlayingAd);
        sb.append(", eventTimeMs=");
        sb.append(this.eventTimeMs);
        sb.append(", durationMs=");
        sb.append(this.durationMs);
        sb.append(", bufferedPositionMs=");
        sb.append(this.bufferedPositionMs);
        sb.append(", bufferedPercentage=");
        sb.append(this.bufferedPercentage);
        sb.append(", totalBufferedDurationMs=");
        sb.append(this.totalBufferedDurationMs);
        sb.append(", currentLiveOffsetMs=");
        sb.append(this.currentLiveOffsetMs);
        sb.append(", contentDurationMs=");
        sb.append(this.contentDurationMs);
        sb.append(", contentBufferedPositionMs=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.contentBufferedPositionMs, "}");
    }
}
