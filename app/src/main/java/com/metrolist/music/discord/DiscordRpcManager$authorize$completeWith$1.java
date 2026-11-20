package com.metrolist.music.discord;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordRpcManager$authorize$completeWith$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Function1 $onComplete;
    public final /* synthetic */ byte $r8$classId = 1;
    public boolean $success;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscordRpcManager$authorize$completeWith$1(Function1 function1, boolean z, Continuation continuation) {
        super(2, continuation);
        this.$onComplete = function1;
        this.$success = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        byte b = this.$r8$classId;
        Function1 function1 = this.$onComplete;
        switch (b) {
            case 0:
                return new DiscordRpcManager$authorize$completeWith$1(function1, this.$success, continuation);
            default:
                return new DiscordRpcManager$authorize$completeWith$1(function1, continuation);
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
                ((DiscordRpcManager$authorize$completeWith$1) create(coroutineScope, continuation)).invokeSuspend(unit);
                return unit;
            default:
                return ((DiscordRpcManager$authorize$completeWith$1) create(coroutineScope, continuation)).invokeSuspend(unit);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        Unit unit = Unit.INSTANCE;
        Function1 function1 = this.$onComplete;
        switch (b) {
            case 0:
                ResultKt.throwOnFailure(obj);
                function1.invoke(Boolean.valueOf(this.$success));
                return unit;
            default:
                boolean z = this.$success;
                if (z) {
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                this.$success = true;
                Object objInvoke = function1.invoke(this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                return objInvoke == coroutineSingletons ? coroutineSingletons : unit;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscordRpcManager$authorize$completeWith$1(Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.$onComplete = function1;
    }
}
