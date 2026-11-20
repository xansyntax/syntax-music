package com.metrolist.music.utils;

import androidx.compose.material3.TooltipStateImpl;
import androidx.datastore.core.DataStoreImpl$transformAndWrite$2;
import com.metrolist.innertube.YouTube;
import com.metrolist.innertubex.cipher.EjsChallengeSolver;
import com.metrolist.music.db.entities.SongEntity;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.serialization.json.JsonImpl;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SyncUtils$executeLikeSong$2$1 extends SuspendLambda implements Function1 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ Object $s;
    public boolean label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SyncUtils$executeLikeSong$2$1(Object obj, Continuation continuation, byte b) {
        super(1, continuation);
        this.$r8$classId = b;
        this.$s = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        byte b = this.$r8$classId;
        Object obj = this.$s;
        switch (b) {
            case 0:
                return new SyncUtils$executeLikeSong$2$1((SongEntity) obj, continuation, (byte) 0);
            case 1:
                return new SyncUtils$executeLikeSong$2$1((TooltipStateImpl) obj, continuation, (byte) 1);
            case 2:
                return new SyncUtils$executeLikeSong$2$1((DataStoreImpl$transformAndWrite$2) obj, continuation, (byte) 2);
            case 3:
                return new SyncUtils$executeLikeSong$2$1((EjsChallengeSolver) obj, continuation, (byte) 3);
            default:
                return new SyncUtils$executeLikeSong$2$1((String) obj, continuation, (byte) 4);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Continuation continuation = (Continuation) obj;
        switch (b) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
        return ((SyncUtils$executeLikeSong$2$1) create(continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM1016likeVideo0E7RQCE;
        Object objM993addEpisodeToSavedEpisodesgIAlus;
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Object obj2 = this.$s;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    YouTube youTube = YouTube.INSTANCE;
                    SongEntity songEntity = (SongEntity) obj2;
                    String str = songEntity.id;
                    boolean z2 = songEntity.liked;
                    this.label = true;
                    objM1016likeVideo0E7RQCE = youTube.m1016likeVideo0E7RQCE(str, z2, this);
                    if (objM1016likeVideo0E7RQCE == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM1016likeVideo0E7RQCE = ((Result) obj).value;
                }
                return new Result(objM1016likeVideo0E7RQCE);
            case 1:
                boolean z3 = this.label;
                if (z3) {
                    if (z3) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                TooltipStateImpl tooltipStateImpl = (TooltipStateImpl) obj2;
                this.label = true;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Okio__OkioKt.intercepted(this));
                cancellableContinuationImpl.initCancellability();
                tooltipStateImpl.transition.targetState$delegate.setValue(Boolean.TRUE);
                tooltipStateImpl.job = cancellableContinuationImpl;
                return cancellableContinuationImpl.getResult() == coroutineSingletons ? coroutineSingletons : unit;
            case 2:
                boolean z4 = this.label;
                if (!z4) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    Object objInvoke = ((DataStoreImpl$transformAndWrite$2) obj2).invoke(this);
                    return objInvoke == coroutineSingletons ? coroutineSingletons : objInvoke;
                }
                if (z4) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 3:
                boolean z5 = this.label;
                if (!z5) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    JsonImpl jsonImpl = EjsChallengeSolver.payloadJson;
                    return ((EjsChallengeSolver) obj2).ensureBootstrapped(this) == coroutineSingletons ? coroutineSingletons : unit;
                }
                if (z5) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                boolean z6 = this.label;
                if (!z6) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    objM993addEpisodeToSavedEpisodesgIAlus = YouTube.INSTANCE.m993addEpisodeToSavedEpisodesgIAlus((String) obj2, this);
                    if (objM993addEpisodeToSavedEpisodesgIAlus == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (!z6) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    objM993addEpisodeToSavedEpisodesgIAlus = ((Result) obj).value;
                }
                return new Result(objM993addEpisodeToSavedEpisodesgIAlus);
        }
    }
}
