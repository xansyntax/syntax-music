package com.metrolist.music.playback;

import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationUnit;
import kotlin.time.InstantKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.internal.ContextScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SleepTimer implements Player.Listener {
    public final ParcelableSnapshotMutableState fadeOutEnabled$delegate;
    public final DiskLruCache$$ExternalSyntheticLambda0 onVolumeMultiplierChanged;
    public final ParcelableSnapshotMutableState pauseWhenSongEnd$delegate;
    public Player player;
    public final CoroutineScope scope;
    public StandaloneCoroutine sleepTimerJob;
    public final ParcelableSnapshotMutableState stopAfterCurrentSongOnTimeout$delegate;
    public final ParcelableSnapshotMutableLongState triggerTime$delegate;

    /* JADX INFO: renamed from: com.metrolist.music.playback.SleepTimer$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public boolean label;
        public final /* synthetic */ SleepTimer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(SleepTimer sleepTimer, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = sleepTimer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            SleepTimer sleepTimer = this.this$0;
            switch (b) {
                case 0:
                    return new AnonymousClass1(sleepTimer, continuation, (byte) 0);
                default:
                    return new AnonymousClass1(sleepTimer, continuation, (byte) 1);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    break;
            }
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(unit);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            SleepTimer sleepTimer = this.this$0;
            switch (b) {
                case 0:
                    boolean z = this.label;
                    if (z && !z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    while (sleepTimer.isActive()) {
                        sleepTimer.updateVolumeMultiplierForCurrentSong();
                        this.label = true;
                        if (AwaitKt.delay(1000L, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return unit;
                default:
                    ParcelableSnapshotMutableState parcelableSnapshotMutableState = sleepTimer.stopAfterCurrentSongOnTimeout$delegate;
                    ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = sleepTimer.fadeOutEnabled$delegate;
                    ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = sleepTimer.triggerTime$delegate;
                    boolean z2 = this.label;
                    if (z2 && !z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    while (sleepTimer.isActive()) {
                        if (parcelableSnapshotMutableLongState.getLongValue() != -1) {
                            long longValue = parcelableSnapshotMutableLongState.getLongValue() - System.currentTimeMillis();
                            if (longValue <= 0) {
                                parcelableSnapshotMutableLongState.setLongValue(-1L);
                                if (!((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
                                    sleepTimer.completeTimerAndPause();
                                    return unit;
                                }
                                sleepTimer.setPauseWhenSongEnd(true);
                                sleepTimer.setStopAfterCurrentSongOnTimeout(false);
                                if (!((Boolean) parcelableSnapshotMutableState2.getValue()).booleanValue()) {
                                    return unit;
                                }
                            } else if (((Boolean) parcelableSnapshotMutableState2.getValue()).booleanValue() && !((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
                                sleepTimer.onVolumeMultiplierChanged.invoke(Float.valueOf(longValue < 60000 ? UuidKt.coerceIn(longValue / 60000.0f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f) : 1.0f));
                            }
                        } else if (sleepTimer.getPauseWhenSongEnd() && ((Boolean) parcelableSnapshotMutableState2.getValue()).booleanValue()) {
                            sleepTimer.updateVolumeMultiplierForCurrentSong();
                        }
                        this.label = true;
                        if (AwaitKt.delay(1000L, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return unit;
            }
        }
    }

    public SleepTimer(ContextScope contextScope, Player player, DiskLruCache$$ExternalSyntheticLambda0 diskLruCache$$ExternalSyntheticLambda0) {
        contextScope.getClass();
        player.getClass();
        this.scope = contextScope;
        this.player = player;
        this.onVolumeMultiplierChanged = diskLruCache$$ExternalSyntheticLambda0;
        this.triggerTime$delegate = new ParcelableSnapshotMutableLongState(-1L);
        Boolean bool = Boolean.FALSE;
        this.pauseWhenSongEnd$delegate = Stack.mutableStateOf$default(bool);
        this.stopAfterCurrentSongOnTimeout$delegate = Stack.mutableStateOf$default(bool);
        this.fadeOutEnabled$delegate = Stack.mutableStateOf$default(bool);
    }

    public final void completeTimerAndPause() {
        StandaloneCoroutine standaloneCoroutine = this.sleepTimerJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.sleepTimerJob = null;
        setPauseWhenSongEnd(false);
        setStopAfterCurrentSongOnTimeout(false);
        this.fadeOutEnabled$delegate.setValue(Boolean.FALSE);
        this.triggerTime$delegate.setLongValue(-1L);
        this.onVolumeMultiplierChanged.invoke(Float.valueOf(1.0f));
        this.player.pause();
    }

    public final boolean getPauseWhenSongEnd() {
        return ((Boolean) this.pauseWhenSongEnd$delegate.getValue()).booleanValue();
    }

    public final boolean isActive() {
        return this.triggerTime$delegate.getLongValue() != -1 || getPauseWhenSongEnd();
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onMediaItemTransition(int i, MediaItem mediaItem) {
        if (getPauseWhenSongEnd()) {
            completeTimerAndPause();
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public final void onPlaybackStateChanged(int i) {
        if (i == 4 && getPauseWhenSongEnd()) {
            completeTimerAndPause();
        }
    }

    public final void setPauseWhenSongEnd(boolean z) {
        this.pauseWhenSongEnd$delegate.setValue(Boolean.valueOf(z));
    }

    public final void setStopAfterCurrentSongOnTimeout(boolean z) {
        this.stopAfterCurrentSongOnTimeout$delegate.setValue(Boolean.valueOf(z));
    }

    public final void start(int i, boolean z, boolean z2) {
        StandaloneCoroutine standaloneCoroutine = this.sleepTimerJob;
        Continuation continuation = null;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel(null);
        }
        this.sleepTimerJob = null;
        this.onVolumeMultiplierChanged.invoke(Float.valueOf(1.0f));
        Boolean boolValueOf = Boolean.valueOf(z2);
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.fadeOutEnabled$delegate;
        parcelableSnapshotMutableState.setValue(boolValueOf);
        CoroutineScope coroutineScope = this.scope;
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = this.triggerTime$delegate;
        byte b = 0;
        byte b2 = 1;
        if (i == -1) {
            setPauseWhenSongEnd(true);
            setStopAfterCurrentSongOnTimeout(false);
            parcelableSnapshotMutableLongState.setLongValue(-1L);
            if (((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
                this.sleepTimerJob = AwaitKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this, continuation, b), 3);
                return;
            }
            return;
        }
        setPauseWhenSongEnd(false);
        setStopAfterCurrentSongOnTimeout(z);
        long jCurrentTimeMillis = System.currentTimeMillis();
        Path.Companion companion = Duration.Companion;
        parcelableSnapshotMutableLongState.setLongValue(Duration.m1887getInWholeMillisecondsimpl(InstantKt.toDuration(i, DurationUnit.MINUTES)) + jCurrentTimeMillis);
        this.sleepTimerJob = AwaitKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this, continuation, b2), 3);
    }

    public final void updateVolumeMultiplierForCurrentSong() {
        long duration = this.player.getDuration();
        DiskLruCache$$ExternalSyntheticLambda0 diskLruCache$$ExternalSyntheticLambda0 = this.onVolumeMultiplierChanged;
        if (duration != -9223372036854775807L) {
            if (duration > 0) {
                long currentPosition = duration - this.player.getCurrentPosition();
                long j = currentPosition >= 0 ? currentPosition : 0L;
                diskLruCache$$ExternalSyntheticLambda0.invoke(Float.valueOf(j < 60000 ? UuidKt.coerceIn(j / 60000.0f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f) : 1.0f));
                return;
            }
        }
        diskLruCache$$ExternalSyntheticLambda0.invoke(Float.valueOf(1.0f));
    }
}
