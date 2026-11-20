package com.metrolist.music.playback;

import androidx.compose.foundation.BorderKt$$ExternalSyntheticLambda1;
import androidx.compose.runtime.Stack;
import androidx.datastore.preferences.core.MutablePreferences;
import com.metrolist.music.constants.PreferenceKeysKt;
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
public final class MusicService$onShuffleModeEnabledChanged$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId = 1;
    public boolean $shuffleModeEnabled;
    public /* synthetic */ Object L$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicService$onShuffleModeEnabledChanged$1$1(boolean z, Continuation continuation) {
        super(2, continuation);
        this.$shuffleModeEnabled = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                MusicService$onShuffleModeEnabledChanged$1$1 musicService$onShuffleModeEnabledChanged$1$1 = new MusicService$onShuffleModeEnabledChanged$1$1(this.$shuffleModeEnabled, continuation);
                musicService$onShuffleModeEnabledChanged$1$1.L$0 = obj;
                return musicService$onShuffleModeEnabledChanged$1$1;
            default:
                MusicService$onShuffleModeEnabledChanged$1$1 musicService$onShuffleModeEnabledChanged$1$2 = new MusicService$onShuffleModeEnabledChanged$1$1(2, continuation);
                musicService$onShuffleModeEnabledChanged$1$2.L$0 = obj;
                return musicService$onShuffleModeEnabledChanged$1$2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                ((MusicService$onShuffleModeEnabledChanged$1$1) create((MutablePreferences) obj, (Continuation) obj2)).invokeSuspend(unit);
                return unit;
            default:
                return ((MusicService$onShuffleModeEnabledChanged$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        switch (b) {
            case 0:
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutablePreferences.set(PreferenceKeysKt.ShuffleModeKey, Boolean.valueOf(this.$shuffleModeEnabled));
                return unit;
            default:
                boolean z = this.$shuffleModeEnabled;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = (CoroutineScope) this.L$0;
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                while (AwaitKt.isActive(coroutineScope.getCoroutineContext())) {
                    BorderKt$$ExternalSyntheticLambda1 borderKt$$ExternalSyntheticLambda1 = new BorderKt$$ExternalSyntheticLambda1((byte) 29);
                    this.L$0 = coroutineScope;
                    this.$shuffleModeEnabled = true;
                    Object objWithFrameNanos = Stack.getMonotonicFrameClock(getContext()).withFrameNanos(borderKt$$ExternalSyntheticLambda1, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objWithFrameNanos == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
                return unit;
        }
    }

    public /* synthetic */ MusicService$onShuffleModeEnabledChanged$1$1(int i, Continuation continuation) {
        super(i, continuation);
    }
}
