package com.metrolist.innertubex.extraction;

import com.metrolist.innertubex.InnerTube;
import java.util.concurrent.CancellationException;
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
public final class InnerTubeExtractor$prewarm$2$tokenWarmup$3$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ byte $r8$classId;
    public final /* synthetic */ InnerTube.SessionSnapshot $session;
    public final /* synthetic */ String $visitorData;
    public boolean label;
    public final /* synthetic */ InnerTubeExtractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InnerTubeExtractor$prewarm$2$tokenWarmup$3$1(InnerTubeExtractor innerTubeExtractor, String str, InnerTube.SessionSnapshot sessionSnapshot, Continuation continuation, byte b) {
        super(2, continuation);
        this.$r8$classId = b;
        this.this$0 = innerTubeExtractor;
        this.$visitorData = str;
        this.$session = sessionSnapshot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new InnerTubeExtractor$prewarm$2$tokenWarmup$3$1(this.this$0, this.$visitorData, this.$session, continuation, (byte) 0);
            case 1:
                return new InnerTubeExtractor$prewarm$2$tokenWarmup$3$1(this.this$0, this.$visitorData, this.$session, continuation, (byte) 1);
            case 2:
                return new InnerTubeExtractor$prewarm$2$tokenWarmup$3$1(this.this$0, this.$visitorData, this.$session, continuation, (byte) 2);
            default:
                return new InnerTubeExtractor$prewarm$2$tokenWarmup$3$1(this.this$0, this.$visitorData, this.$session, continuation, (byte) 3);
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
            case 1:
                break;
            case 2:
                break;
        }
        return ((InnerTubeExtractor$prewarm$2$tokenWarmup$3$1) create(coroutineScope, continuation)).invokeSuspend(unit);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte b = this.$r8$classId;
        String str = this.$visitorData;
        InnerTubeExtractor innerTubeExtractor = this.this$0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (b) {
            case 0:
                boolean z = this.label;
                if (z) {
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                long j = InnerTubeExtractor.PO_TOKEN_PREFETCH_TIMEOUT;
                InnerTubeExtractor$prewarm$2$tokenWarmup$3$1 innerTubeExtractor$prewarm$2$tokenWarmup$3$1 = new InnerTubeExtractor$prewarm$2$tokenWarmup$3$1(this.this$0, this.$visitorData, this.$session, null, (byte) 3);
                this.label = true;
                Object objM1899withTimeoutOrNullKLykuaI = AwaitKt.m1899withTimeoutOrNullKLykuaI(j, innerTubeExtractor$prewarm$2$tokenWarmup$3$1, this);
                return objM1899withTimeoutOrNullKLykuaI == coroutineSingletons ? coroutineSingletons : objM1899withTimeoutOrNullKLykuaI;
            case 1:
                boolean z2 = this.label;
                try {
                    if (!z2) {
                        ResultKt.throwOnFailure(obj);
                        TokenProvider tokenProvider = innerTubeExtractor.tokenProvider;
                        String str2 = this.$session.visitorData;
                        this.label = true;
                        obj = tokenProvider.getPoToken(str, str2, this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z2) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return (PoTokenResult) obj;
                } catch (CancellationException e) {
                    throw e;
                } catch (Exception unused) {
                }
                break;
            case 2:
                boolean z3 = this.label;
                if (z3) {
                    if (z3) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                long j2 = InnerTubeExtractor.PO_TOKEN_PREFETCH_TIMEOUT;
                InnerTubeExtractor$prewarm$2$tokenWarmup$3$1 innerTubeExtractor$prewarm$2$tokenWarmup$3$2 = new InnerTubeExtractor$prewarm$2$tokenWarmup$3$1(this.this$0, this.$visitorData, this.$session, null, (byte) 1);
                this.label = true;
                Object objM1899withTimeoutOrNullKLykuaI2 = AwaitKt.m1899withTimeoutOrNullKLykuaI(j2, innerTubeExtractor$prewarm$2$tokenWarmup$3$2, this);
                return objM1899withTimeoutOrNullKLykuaI2 == coroutineSingletons ? coroutineSingletons : objM1899withTimeoutOrNullKLykuaI2;
            default:
                boolean z4 = this.label;
                try {
                    if (!z4) {
                        ResultKt.throwOnFailure(obj);
                        TokenProvider tokenProvider2 = innerTubeExtractor.tokenProvider;
                        this.label = true;
                        obj = tokenProvider2.getPoToken("dQw4w9WgXcQ", str, this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (!z4) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return (PoTokenResult) obj;
                } catch (CancellationException e2) {
                    throw e2;
                } catch (Exception unused2) {
                }
                break;
        }
    }
}
