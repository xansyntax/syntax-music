package com.metrolist.music.ui.player;

import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import com.metrolist.music.playback.MusicService;
import com.metrolist.music.playback.PlayerConnection;
import com.metrolist.music.playback.SleepTimer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class QueueKt$Queue$3$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ PlayerConnection $playerConnection;
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ boolean $sleepTimerEnabled;
    public final /* synthetic */ ParcelableSnapshotMutableLongState $sleepTimerTimeLeft$delegate;
    public /* synthetic */ Object L$0;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QueueKt$Queue$3$1(boolean z, PlayerConnection playerConnection, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.$sleepTimerEnabled = z;
        this.$playerConnection = playerConnection;
        this.$sleepTimerTimeLeft$delegate = parcelableSnapshotMutableLongState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                QueueKt$Queue$3$1 queueKt$Queue$3$1 = new QueueKt$Queue$3$1(this.$sleepTimerEnabled, this.$playerConnection, this.$sleepTimerTimeLeft$delegate, continuation, (byte) 0);
                queueKt$Queue$3$1.L$0 = obj;
                return queueKt$Queue$3$1;
            default:
                QueueKt$Queue$3$1 queueKt$Queue$3$2 = new QueueKt$Queue$3$1(this.$sleepTimerEnabled, this.$playerConnection, this.$sleepTimerTimeLeft$delegate, continuation, (byte) 1);
                queueKt$Queue$3$2.L$0 = obj;
                return queueKt$Queue$3$2;
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
        return ((QueueKt$Queue$3$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long longValue;
        long jCurrentTimeMillis;
        long longValue2;
        long jCurrentTimeMillis2;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = this.$sleepTimerTimeLeft$delegate;
        boolean z = this.$sleepTimerEnabled;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        PlayerConnection playerConnection = this.$playerConnection;
        switch (b) {
            case 0:
                MusicService musicService = playerConnection.service;
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    if (!z) {
                        return unit;
                    }
                } else {
                    if (!z2) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                while (AwaitKt.isActive(coroutineScope)) {
                    SleepTimer sleepTimer = musicService.sleepTimer;
                    if (sleepTimer == null || !sleepTimer.getPauseWhenSongEnd()) {
                        SleepTimer sleepTimer2 = musicService.sleepTimer;
                        longValue = sleepTimer2 != null ? sleepTimer2.triggerTime$delegate.getLongValue() : 0L;
                        jCurrentTimeMillis = System.currentTimeMillis();
                    } else {
                        longValue = playerConnection.getPlayerSafe().getDuration();
                        jCurrentTimeMillis = playerConnection.getPlayerSafe().getCurrentPosition();
                    }
                    parcelableSnapshotMutableLongState.setLongValue(longValue - jCurrentTimeMillis);
                    this.L$0 = coroutineScope;
                    this.label = true;
                    if (AwaitKt.delay(1000L, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return unit;
            default:
                MusicService musicService2 = playerConnection.service;
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                boolean z3 = this.label;
                if (!z3) {
                    ResultKt.throwOnFailure(obj);
                    if (!z) {
                        return unit;
                    }
                } else {
                    if (!z3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                while (AwaitKt.isActive(coroutineScope2)) {
                    SleepTimer sleepTimer3 = musicService2.sleepTimer;
                    if (sleepTimer3 == null || !sleepTimer3.getPauseWhenSongEnd()) {
                        SleepTimer sleepTimer4 = musicService2.sleepTimer;
                        longValue2 = sleepTimer4 != null ? sleepTimer4.triggerTime$delegate.getLongValue() : 0L;
                        jCurrentTimeMillis2 = System.currentTimeMillis();
                    } else {
                        longValue2 = playerConnection.getPlayerSafe().getDuration();
                        jCurrentTimeMillis2 = playerConnection.getPlayerSafe().getCurrentPosition();
                    }
                    parcelableSnapshotMutableLongState.setLongValue(longValue2 - jCurrentTimeMillis2);
                    this.L$0 = coroutineScope2;
                    this.label = true;
                    if (AwaitKt.delay(1000L, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return unit;
        }
    }
}
