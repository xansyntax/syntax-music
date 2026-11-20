package androidx.media3.exoplayer;

import android.text.TextUtils;
import androidx.compose.ui.text.input.GapBuffer;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.sqlite.SQLite;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultLoadControl {
    public static final RegularImmutableList LOCAL_PLAYBACK_SCHEMES;
    public final GapBuffer allocator;
    public final long backBufferDurationUs;
    public final long bufferForPlaybackAfterRebufferForLocalPlaybackUs;
    public final long bufferForPlaybackAfterRebufferUs;
    public final long bufferForPlaybackForLocalPlaybackUs;
    public final long bufferForPlaybackUs;
    public final ConcurrentHashMap loadingStates;
    public final long maxBufferForLocalPlaybackUs;
    public final long maxBufferUs;
    public final long minBufferForLocalPlaybackUs;
    public final long minBufferUs;
    public final Timeline.Period period;
    public final ImmutableMap playerTargetBufferBytesOverwrites;
    public final boolean prioritizeTimeOverSizeThresholdsForLocalPlayback;
    public long threadId;
    public final Timeline.Window window;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PlayerLoadingState {
        public int allocatedCounts;
        public boolean isLoading;
        public int referenceCount;
        public int targetBufferBytes;
    }

    static {
        ImmutableList.Itr itr = ImmutableList.EMPTY_ITR;
        Object[] objArr = {"file", "content", "data", "android.resource", "rawresource", "asset"};
        Maps.checkElementsNotNull(6, objArr);
        LOCAL_PLAYBACK_SCHEMES = ImmutableList.asImmutableList(6, objArr);
    }

    public DefaultLoadControl(GapBuffer gapBuffer, int i, int i2, int i3, int i4, boolean z, Map map) {
        assertGreaterOrEqual(i2, 0, "bufferForPlaybackMs", "0");
        assertGreaterOrEqual(i3, 0, "bufferForPlaybackForLocalPlaybackMs", "0");
        assertGreaterOrEqual(2000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        assertGreaterOrEqual(i4, 0, "bufferForPlaybackAfterRebufferForLocalPlaybackMs", "0");
        assertGreaterOrEqual(50000, i2, "minBufferMs", "bufferForPlaybackMs");
        assertGreaterOrEqual(i, i3, "minBufferForLocalPlaybackMs", "bufferForPlaybackForLocalPlaybackMs");
        assertGreaterOrEqual(50000, 2000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        assertGreaterOrEqual(i, i4, "minBufferForLocalPlaybackMs", "bufferForPlaybackAfterRebufferForLocalPlaybackMs");
        assertGreaterOrEqual(50000, 50000, "maxBufferMs", "minBufferMs");
        assertGreaterOrEqual(50000, i, "maxBufferForLocalPlaybackMs", "minBufferForLocalPlaybackMs");
        assertGreaterOrEqual(0, 0, "backBufferDurationMs", "0");
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        this.allocator = gapBuffer;
        long jMsToUs = Util.msToUs(50000L);
        this.minBufferUs = jMsToUs;
        this.minBufferForLocalPlaybackUs = Util.msToUs(i);
        this.maxBufferUs = jMsToUs;
        this.maxBufferForLocalPlaybackUs = jMsToUs;
        this.bufferForPlaybackUs = Util.msToUs(i2);
        this.bufferForPlaybackForLocalPlaybackUs = Util.msToUs(i3);
        this.bufferForPlaybackAfterRebufferUs = Util.msToUs(2000L);
        this.bufferForPlaybackAfterRebufferForLocalPlaybackUs = Util.msToUs(i4);
        this.prioritizeTimeOverSizeThresholdsForLocalPlayback = z;
        this.backBufferDurationUs = Util.msToUs(0L);
        this.loadingStates = new ConcurrentHashMap();
        this.playerTargetBufferBytesOverwrites = ImmutableMap.copyOf(map);
        this.threadId = -1L;
    }

    public static void assertGreaterOrEqual(int i, int i2, String str, String str2) {
        if (i >= i2) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$1(SQLite.lenientFormat("%s cannot be less than %s", str, str2));
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0072  */
    public final boolean shouldContinueLoading(LoadControl$Parameters loadControl$Parameters) {
        int i;
        boolean z;
        PlayerId playerId = loadControl$Parameters.playerId;
        long j = loadControl$Parameters.bufferedDurationUs;
        PlayerLoadingState playerLoadingState = (PlayerLoadingState) this.loadingStates.get(playerId);
        playerLoadingState.getClass();
        PlayerLoadingState playerLoadingState2 = (PlayerLoadingState) this.loadingStates.get(playerId);
        playerLoadingState2.getClass();
        synchronized (playerLoadingState2) {
            i = playerLoadingState2.allocatedCounts;
        }
        int i2 = i * 65536;
        PlayerLoadingState playerLoadingState3 = (PlayerLoadingState) this.loadingStates.get(playerId);
        playerLoadingState3.getClass();
        boolean z2 = i2 >= playerLoadingState3.targetBufferBytes;
        if (playerId.equals(PlayerId.PRELOAD)) {
            return !z2;
        }
        Timeline timeline = loadControl$Parameters.timeline;
        MediaItem.LocalConfiguration localConfiguration = timeline.getWindow(timeline.getPeriodByUid(loadControl$Parameters.mediaPeriodId.periodUid, this.period).windowIndex, this.window, 0L).mediaItem.localConfiguration;
        if (localConfiguration == null) {
            z = false;
        } else {
            String scheme = localConfiguration.uri.getScheme();
            if (TextUtils.isEmpty(scheme) || LOCAL_PLAYBACK_SCHEMES.contains(scheme)) {
                z = true;
            } else {
                z = false;
            }
        }
        long jMin = z ? this.minBufferForLocalPlaybackUs : this.minBufferUs;
        long j2 = z ? this.maxBufferForLocalPlaybackUs : this.maxBufferUs;
        float f = loadControl$Parameters.playbackSpeed;
        if (f > 1.0f) {
            jMin = Math.min(Util.getMediaDurationForPlayoutDuration(jMin, f), j2);
        }
        if (j < Math.max(jMin, 500000L)) {
            boolean z3 = (z ? this.prioritizeTimeOverSizeThresholdsForLocalPlayback : false) || !z2;
            playerLoadingState.isLoading = z3;
            if (!z3 && j < 500000) {
                Log.w("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j >= j2 || z2) {
            playerLoadingState.isLoading = false;
        }
        return playerLoadingState.isLoading;
    }

    public final void updateAllocator() {
        boolean zIsEmpty = this.loadingStates.isEmpty();
        GapBuffer gapBuffer = this.allocator;
        int i = 0;
        if (zIsEmpty) {
            synchronized (gapBuffer) {
                gapBuffer.setTargetBufferSize(0);
            }
        } else {
            Iterator it = this.loadingStates.values().iterator();
            while (it.hasNext()) {
                i += ((PlayerLoadingState) it.next()).targetBufferBytes;
            }
            gapBuffer.setTargetBufferSize(i);
        }
    }
}
