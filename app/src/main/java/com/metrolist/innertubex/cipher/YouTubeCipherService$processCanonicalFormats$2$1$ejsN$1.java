package com.metrolist.innertubex.cipher;

import java.io.IOException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTubeCipherService$processCanonicalFormats$2$1$ejsN$1 extends SuspendLambda implements Function1 {
    public final /* synthetic */ Ref$ObjectRef $playerCodeFailed;
    public final /* synthetic */ Ref$ObjectRef $playerCodeResult;
    public final /* synthetic */ String $playerUrl;
    public final /* synthetic */ byte $r8$classId;
    public boolean label;
    public final /* synthetic */ YouTubeCipherService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ YouTubeCipherService$processCanonicalFormats$2$1$ejsN$1(Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, YouTubeCipherService youTubeCipherService, String str, Continuation continuation, byte b) {
        super(1, continuation);
        this.$r8$classId = b;
        this.$playerCodeResult = ref$ObjectRef;
        this.$playerCodeFailed = ref$ObjectRef2;
        this.this$0 = youTubeCipherService;
        this.$playerUrl = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new YouTubeCipherService$processCanonicalFormats$2$1$ejsN$1(this.$playerCodeResult, this.$playerCodeFailed, this.this$0, this.$playerUrl, continuation, (byte) 0);
            default:
                return new YouTubeCipherService$processCanonicalFormats$2$1$ejsN$1(this.$playerCodeResult, this.$playerCodeFailed, this.this$0, this.$playerUrl, continuation, (byte) 1);
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
        }
        return ((YouTubeCipherService$processCanonicalFormats$2$1$ejsN$1) create(continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        byte b = this.$r8$classId;
        String str = this.$playerUrl;
        YouTubeCipherService youTubeCipherService = this.this$0;
        Ref$ObjectRef ref$ObjectRef = this.$playerCodeFailed;
        Ref$ObjectRef ref$ObjectRef2 = this.$playerCodeResult;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (!z) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    Object objInvokeSuspend$lambda$0$playerCode = YouTubeCipherService$processCanonicalFormats$2.invokeSuspend$lambda$0$playerCode(ref$ObjectRef2, ref$ObjectRef, youTubeCipherService, str, this);
                    return objInvokeSuspend$lambda$0$playerCode == coroutineSingletons ? coroutineSingletons : objInvokeSuspend$lambda$0$playerCode;
                }
                if (z) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                boolean z2 = this.label;
                if (!z2) {
                    ResultKt.throwOnFailure(obj);
                    this.label = true;
                    Object objInvokeSuspend$lambda$0$playerCode2 = YouTubeCipherService$processCanonicalFormats$2.invokeSuspend$lambda$0$playerCode(ref$ObjectRef2, ref$ObjectRef, youTubeCipherService, str, this);
                    return objInvokeSuspend$lambda$0$playerCode2 == coroutineSingletons ? coroutineSingletons : objInvokeSuspend$lambda$0$playerCode2;
                }
                if (z2) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }
}
