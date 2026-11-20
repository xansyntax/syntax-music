package com.metrolist.music.playback;

import com.metrolist.innertube.YouTube;
import com.metrolist.innertube.models.WatchEndpoint;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MusicService$startRadioSeamlessly$1$nextResult$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $currentMediaId;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicService$startRadioSeamlessly$1$nextResult$1(String str, Continuation continuation) {
        super(2, continuation);
        this.$currentMediaId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new MusicService$startRadioSeamlessly$1$nextResult$1(this.$currentMediaId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((MusicService$startRadioSeamlessly$1$nextResult$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM1024next0E7RQCE;
        boolean z = this.label;
        if (!z) {
            ResultKt.throwOnFailure(obj);
            YouTube youTube = YouTube.INSTANCE;
            WatchEndpoint watchEndpoint = new WatchEndpoint(62, this.$currentMediaId, null, null);
            this.label = true;
            objM1024next0E7RQCE = youTube.m1024next0E7RQCE(watchEndpoint, null, this);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objM1024next0E7RQCE == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (!z) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            objM1024next0E7RQCE = ((Result) obj).value;
        }
        if (objM1024next0E7RQCE instanceof Result.Failure) {
            return null;
        }
        return objM1024next0E7RQCE;
    }
}
