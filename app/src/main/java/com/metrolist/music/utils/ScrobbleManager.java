package com.metrolist.music.utils;

import com.metrolist.music.models.MediaMetadata;
import io.ktor.client.utils.CIOKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.internal.ContextScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrobbleManager {
    public int minSongDuration;
    public final CoroutineScope scope;
    public float scrobbleDelayPercent;
    public int scrobbleDelaySeconds;
    public StandaloneCoroutine scrobbleJob;
    public long scrobbleRemainingMillis;
    public long scrobbleTimerStartedAt;
    public boolean songStarted;
    public long songStartedAt;
    public boolean useNowPlaying;

    public ScrobbleManager(ContextScope contextScope, int i, float f, int i2) {
        contextScope.getClass();
        this.scope = contextScope;
        this.minSongDuration = i;
        this.scrobbleDelayPercent = f;
        this.scrobbleDelaySeconds = i2;
        this.useNowPlaying = true;
    }

    public final void onSongStart(MediaMetadata mediaMetadata, Long l) {
        if (mediaMetadata == null) {
            return;
        }
        this.songStartedAt = System.currentTimeMillis() / 1000;
        this.songStarted = true;
        StandaloneCoroutine standaloneCoroutine = this.scrobbleJob;
        Continuation continuation = null;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        int iLongValue = ((int) l.longValue()) / CIOKt.DEFAULT_HTTP_POOL_SIZE;
        int i = this.minSongDuration;
        CoroutineScope coroutineScope = this.scope;
        if (iLongValue > i) {
            long jMin = Math.min((long) (((long) iLongValue) * 1000 * this.scrobbleDelayPercent), ((long) this.scrobbleDelaySeconds) * 1000);
            this.scrobbleRemainingMillis = jMin;
            if (jMin <= 0) {
                AwaitKt.launch$default(coroutineScope, null, null, new ScrobbleManager$scrobbleSong$1(mediaMetadata, this, null), 3);
            } else {
                this.scrobbleTimerStartedAt = System.currentTimeMillis();
                this.scrobbleJob = AwaitKt.launch$default(coroutineScope, null, null, new ScrobbleManager$scrobbleSong$1(this, mediaMetadata, continuation, (byte) 2), 3);
            }
        }
        if (this.useNowPlaying) {
            AwaitKt.launch$default(coroutineScope, null, null, new SyncUtils.AnonymousClass2(mediaMetadata, continuation, (byte) 28), 3);
        }
    }
}
