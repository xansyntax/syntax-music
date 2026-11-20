package com.metrolist.music.ui.component;

import androidx.compose.runtime.MonotonicFrameClockKt$withFrameMillis$2;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.Stack;
import com.metrolist.music.playback.PlayerConnection;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$LongRef;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LyricsLineKt$WordLevelLyrics$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ boolean $isActiveLine;
    public final /* synthetic */ long $lyricsOffset;
    public final /* synthetic */ PlayerConnection $playerConnection;
    public final /* synthetic */ ParcelableSnapshotMutableLongState $smoothPosition$delegate;
    public /* synthetic */ Object L$0;
    public Ref$LongRef L$1;
    public Ref$LongRef L$2;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LyricsLineKt$WordLevelLyrics$1$1(boolean z, PlayerConnection playerConnection, long j, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState, Continuation continuation) {
        super(2, continuation);
        this.$isActiveLine = z;
        this.$playerConnection = playerConnection;
        this.$lyricsOffset = j;
        this.$smoothPosition$delegate = parcelableSnapshotMutableLongState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LyricsLineKt$WordLevelLyrics$1$1 lyricsLineKt$WordLevelLyrics$1$1 = new LyricsLineKt$WordLevelLyrics$1$1(this.$isActiveLine, this.$playerConnection, this.$lyricsOffset, this.$smoothPosition$delegate, continuation);
        lyricsLineKt$WordLevelLyrics$1$1.L$0 = obj;
        return lyricsLineKt$WordLevelLyrics$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((LyricsLineKt$WordLevelLyrics$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final Ref$LongRef ref$LongRef;
        final Ref$LongRef ref$LongRef2;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        boolean z = this.label;
        final PlayerConnection playerConnection = this.$playerConnection;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            if (this.$isActiveLine) {
                Ref$LongRef ref$LongRef3 = new Ref$LongRef();
                ref$LongRef3.element = playerConnection.getPlayerSafe().getCurrentPosition();
                Ref$LongRef ref$LongRef4 = new Ref$LongRef();
                ref$LongRef4.element = System.currentTimeMillis();
                ref$LongRef = ref$LongRef3;
                ref$LongRef2 = ref$LongRef4;
            }
            return Unit.INSTANCE;
        }
        if (!z) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        Ref$LongRef ref$LongRef5 = this.L$2;
        Ref$LongRef ref$LongRef6 = this.L$1;
        ResultKt.throwOnFailure(obj);
        ref$LongRef2 = ref$LongRef5;
        ref$LongRef = ref$LongRef6;
        while (AwaitKt.isActive(coroutineScope)) {
            final long j = this.$lyricsOffset;
            final ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = this.$smoothPosition$delegate;
            Function1 function1 = new Function1() { // from class: com.metrolist.music.ui.component.LyricsLineKt$WordLevelLyrics$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    ((Long) obj2).getClass();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    PlayerConnection playerConnection2 = playerConnection;
                    long currentPosition = playerConnection2.getPlayerSafe().getCurrentPosition();
                    Ref$LongRef ref$LongRef7 = ref$LongRef;
                    long j2 = ref$LongRef7.element;
                    Ref$LongRef ref$LongRef8 = ref$LongRef2;
                    if (currentPosition != j2) {
                        ref$LongRef7.element = currentPosition;
                        ref$LongRef8.element = jCurrentTimeMillis;
                    }
                    long j3 = jCurrentTimeMillis - ref$LongRef8.element;
                    long j4 = ref$LongRef7.element + j;
                    if (!playerConnection2.getPlayerSafe().isPlaying()) {
                        j3 = 0;
                    }
                    parcelableSnapshotMutableLongState.setLongValue(j4 + j3);
                    return Unit.INSTANCE;
                }
            };
            this.L$0 = coroutineScope;
            this.L$1 = ref$LongRef;
            this.L$2 = ref$LongRef2;
            this.label = true;
            Object objWithFrameNanos = Stack.getMonotonicFrameClock(getContext()).withFrameNanos(new MonotonicFrameClockKt$withFrameMillis$2(function1, (byte) 0), this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithFrameNanos == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
