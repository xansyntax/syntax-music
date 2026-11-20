package io.ktor.client.plugins.sse;

import io.ktor.client.HttpClient;
import io.ktor.client.statement.DispatcherSwitching_jvmKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobSupport;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.sse.BuildersKt$processSession$2", f = "builders.kt", l = {1270, 1274, 1280, 1300, 1300}, m = "invokeSuspend", v = 1)
public final class BuildersKt$processSession$2 extends SuspendLambda implements Function2 {
    final /* synthetic */ CompletableDeferred $sessionDeferred;
    final /* synthetic */ HttpStatement $statement;
    final /* synthetic */ HttpClient $this_processSession;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuildersKt$processSession$2(HttpStatement httpStatement, CompletableDeferred completableDeferred, HttpClient httpClient, Continuation continuation) {
        super(2, continuation);
        this.$statement = httpStatement;
        this.$sessionDeferred = completableDeferred;
        this.$this_processSession = httpClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BuildersKt$processSession$2(this.$statement, this.$sessionDeferred, this.$this_processSession, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BuildersKt$processSession$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00d3 A[Catch: all -> 0x0065, TryCatch #2 {all -> 0x0065, blocks: (B:24:0x005e, B:25:0x0064, B:45:0x00cd, B:47:0x00d3, B:48:0x00e3, B:49:0x00e4, B:50:0x00ea), top: B:66:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00e4 A[Catch: all -> 0x0065, TryCatch #2 {all -> 0x0065, blocks: (B:24:0x005e, B:25:0x0064, B:45:0x00cd, B:47:0x00d3, B:48:0x00e3, B:49:0x00e4, B:50:0x00ea), top: B:66:0x0007 }] */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008f, code lost:
    
        if (r8.cleanup(r7, null, r9) == r4) goto L55;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Throwable {
        HttpResponse httpResponse;
        int i = this.label;
        int i2 = 1;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                try {
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            HttpStatement httpStatement = this.$statement;
                            CompletableDeferred completableDeferred = this.$sessionDeferred;
                            this.L$0 = httpStatement;
                            this.L$1 = completableDeferred;
                            this.I$0 = 0;
                            this.I$1 = 0;
                            this.I$2 = 0;
                            this.label = 1;
                            Object objFetchStreamingResponse = httpStatement.fetchStreamingResponse(this);
                            if (objFetchStreamingResponse == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            obj = objFetchStreamingResponse;
                            httpResponse = (HttpResponse) obj;
                            if (DispatcherSwitching_jvmKt.getUseEngineDispatcher()) {
                                httpResponse.getCoroutineContext().get(ContinuationInterceptor$Key.$$INSTANCE).getClass();
                                Intrinsics.throwUndefinedForReified();
                                throw null;
                            }
                            httpResponse.getCall();
                            Intrinsics.throwUndefinedForReified();
                            throw null;
                        }
                        if (i == 1) {
                            int i3 = this.I$2;
                            int i4 = this.I$1;
                            int i5 = this.I$0;
                            ResultKt.throwOnFailure(obj);
                            httpResponse = (HttpResponse) obj;
                            if (DispatcherSwitching_jvmKt.getUseEngineDispatcher()) {
                                httpResponse.getCoroutineContext().get(ContinuationInterceptor$Key.$$INSTANCE).getClass();
                                Intrinsics.throwUndefinedForReified();
                                throw null;
                            }
                            httpResponse.getCall();
                            Intrinsics.throwUndefinedForReified();
                            throw null;
                        }
                        if (i == 2) {
                            i = this.I$2;
                            i2 = this.I$1;
                            int i6 = this.I$0;
                            HttpResponse httpResponse2 = (HttpResponse) this.L$1;
                            HttpStatement httpStatement2 = (HttpStatement) this.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = obj;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.I$0 = i6;
                                this.I$1 = i2;
                                this.I$2 = i;
                                this.label = 4;
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.L$3 = th2;
                                    this.L$4 = null;
                                    this.I$0 = i6;
                                    this.I$1 = i2;
                                    this.I$2 = i;
                                    this.label = 5;
                                    if (httpStatement2.cleanup(httpResponse2, th, this) != coroutineSingletons) {
                                        throw th2;
                                    }
                                }
                            }
                        } else {
                            if (i == 3) {
                                int i7 = this.I$2;
                                int i8 = this.I$1;
                                int i9 = this.I$0;
                                ResultKt.throwOnFailure(obj);
                                Intrinsics.throwUndefinedForReified();
                                throw null;
                            }
                            if (i != 4) {
                                if (i != 5) {
                                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                    return null;
                                }
                                Throwable th3 = (Throwable) this.L$3;
                                ResultKt.throwOnFailure(obj);
                                throw th3;
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th4) {
                        ((CompletableDeferredImpl) this.$sessionDeferred).completeExceptionally(BuildersKt.mapToSSEException(this.$this_processSession, null, null, th4));
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (CancellationException e) {
                ((JobSupport) this.$sessionDeferred).cancelInternal(e);
            }
        } catch (CancellationException e2) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e2);
        }
    }
}
