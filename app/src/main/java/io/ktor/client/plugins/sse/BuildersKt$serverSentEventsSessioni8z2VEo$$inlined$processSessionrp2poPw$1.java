package io.ktor.client.plugins.sse;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.DispatcherSwitching_jvmKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import io.ktor.util.reflect.TypeInfo;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobSupport;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: renamed from: io.ktor.client.plugins.sse.BuildersKt$serverSentEventsSession-i8z2VEo$$inlined$processSession-rp2poPw$1, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "io/ktor/client/plugins/sse/BuildersKt$processSession$2"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.sse.BuildersKt$processSession$2", f = "builders.kt", l = {1270, 1274, 1280, 1300, 1300}, m = "invokeSuspend", v = 1)
public final class BuildersKt$serverSentEventsSessioni8z2VEo$$inlined$processSessionrp2poPw$1 extends SuspendLambda implements Function2 {
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

    /* JADX INFO: renamed from: io.ktor.client.plugins.sse.BuildersKt$serverSentEventsSession-i8z2VEo$$inlined$processSession-rp2poPw$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;", "io/ktor/client/statement/HttpStatement$body$4$1", "io/ktor/client/plugins/sse/BuildersKt$processSession$2$invokeSuspend$$inlined$body$1"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.sse.BuildersKt$serverSentEventsSession-i8z2VEo$$inlined$processSession-rp2poPw$1$1", f = "builders.kt", l = {250}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ HttpResponse $response;
        final /* synthetic */ CompletableDeferred $sessionDeferred$inlined;
        int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(HttpResponse httpResponse, Continuation continuation, CompletableDeferred completableDeferred) {
            super(2, continuation);
            this.$response = httpResponse;
            this.$sessionDeferred$inlined = completableDeferred;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$response, continuation, this.$sessionDeferred$inlined);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            TypeReference typeReferenceTypeOf;
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HttpClientCall call = this.$response.getCall();
                ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ClientSSESession.class);
                try {
                    typeReferenceTypeOf = Reflection.typeOf(ClientSSESession.class);
                } catch (Throwable unused) {
                    typeReferenceTypeOf = null;
                }
                TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
                this.L$0 = null;
                this.I$0 = 0;
                this.label = 1;
                obj = call.bodyNullable(typeInfo, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            if (obj == null) {
                PathKt$$ExternalSyntheticBUOutline0.m("null cannot be cast to non-null type io.ktor.client.plugins.sse.ClientSSESession");
                return null;
            }
            ((CompletableDeferredImpl) this.$sessionDeferred$inlined).makeCompleting$kotlinx_coroutines_core((ClientSSESession) obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuildersKt$serverSentEventsSessioni8z2VEo$$inlined$processSessionrp2poPw$1(HttpStatement httpStatement, CompletableDeferred completableDeferred, HttpClient httpClient, Continuation continuation) {
        super(2, continuation);
        this.$statement = httpStatement;
        this.$sessionDeferred = completableDeferred;
        this.$this_processSession = httpClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BuildersKt$serverSentEventsSessioni8z2VEo$$inlined$processSessionrp2poPw$1(this.$statement, this.$sessionDeferred, this.$this_processSession, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BuildersKt$serverSentEventsSessioni8z2VEo$$inlined$processSessionrp2poPw$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0132 A[Catch: all -> 0x006b, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x006b, blocks: (B:22:0x0064, B:56:0x0132, B:61:0x0154, B:62:0x015b, B:27:0x007f), top: B:79:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0154 A[Catch: all -> 0x006b, TRY_ENTER, TryCatch #5 {all -> 0x006b, blocks: (B:22:0x0064, B:56:0x0132, B:61:0x0154, B:62:0x015b, B:27:0x007f), top: B:79:0x000f }] */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0151, code lost:
    
        if (r0 == r10) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0175, code lost:
    
        if (r11.cleanup(r8, r3, r16) == r10) goto L67;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v3, types: [int] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7, types: [io.ktor.client.statement.HttpStatement] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [io.ktor.client.statement.HttpStatement] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [int] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [int] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v4, types: [io.ktor.client.statement.HttpResponse, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [io.ktor.client.statement.HttpResponse] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7, types: [io.ktor.client.statement.HttpResponse] */
    /* JADX WARN: Type inference failed for: r8v8 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        Object objFetchStreamingResponse;
        HttpStatement httpStatement;
        int i;
        int i2;
        CompletableDeferred completableDeferred;
        ?? r11;
        ?? r7;
        TypeReference typeReferenceTypeOf;
        Object objBodyNullable;
        ?? r8;
        ?? r5;
        int i3;
        int i4;
        HttpStatement httpStatement2;
        Object objWithContext;
        ?? r9;
        ?? r6;
        int i5;
        ?? r12;
        int i6 = this.label;
        Unit unit = Unit.INSTANCE;
        ?? r10 = 3;
        int i7 = 2;
        int i8 = 1;
        ?? r13 = 0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                try {
                    try {
                        try {
                            if (i6 == 0) {
                                ResultKt.throwOnFailure(obj);
                                HttpStatement httpStatement3 = this.$statement;
                                CompletableDeferred completableDeferred2 = this.$sessionDeferred;
                                this.L$0 = httpStatement3;
                                this.L$1 = completableDeferred2;
                                this.I$0 = 0;
                                this.I$1 = 0;
                                this.I$2 = 0;
                                this.label = 1;
                                objFetchStreamingResponse = httpStatement3.fetchStreamingResponse(this);
                                if (objFetchStreamingResponse != coroutineSingletons) {
                                    httpStatement = httpStatement3;
                                    i = 0;
                                    i2 = 0;
                                    completableDeferred = completableDeferred2;
                                    r11 = 0;
                                }
                                return coroutineSingletons;
                            }
                            if (i6 == 1) {
                                int i9 = this.I$2;
                                int i10 = this.I$1;
                                int i11 = this.I$0;
                                CompletableDeferred completableDeferred3 = (CompletableDeferred) this.L$1;
                                HttpStatement httpStatement4 = (HttpStatement) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                httpStatement = httpStatement4;
                                i2 = i11;
                                r11 = i9;
                                completableDeferred = completableDeferred3;
                                i = i10;
                                objFetchStreamingResponse = obj;
                            } else if (i6 == 2) {
                                int i12 = this.I$2;
                                i3 = this.I$1;
                                int i13 = this.I$0;
                                HttpResponse httpResponse = (HttpResponse) this.L$1;
                                HttpStatement httpStatement5 = (HttpStatement) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                objWithContext = obj;
                                r6 = i12;
                                i5 = i13;
                                r9 = httpResponse;
                                r12 = httpStatement5;
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = objWithContext;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.I$0 = i5;
                                this.I$1 = i3;
                                this.I$2 = r6;
                                this.label = 4;
                                Object objCleanup = r12.cleanup(r9, null, this);
                                r7 = i5;
                                r11 = r12;
                            } else if (i6 == 3) {
                                int i14 = this.I$2;
                                i3 = this.I$1;
                                int i15 = this.I$0;
                                HttpResponse httpResponse2 = (HttpResponse) this.L$2;
                                completableDeferred = (CompletableDeferred) this.L$1;
                                HttpStatement httpStatement6 = (HttpStatement) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                objBodyNullable = obj;
                                r5 = i14;
                                i4 = i15;
                                r8 = httpResponse2;
                                httpStatement2 = httpStatement6;
                                if (objBodyNullable != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.sse.ClientSSESession");
                                }
                                ((CompletableDeferredImpl) completableDeferred).makeCompleting$kotlinx_coroutines_core((ClientSSESession) objBodyNullable);
                                objWithContext = unit;
                                r6 = r5;
                                i5 = i4;
                                r9 = r8;
                                r12 = httpStatement2;
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = objWithContext;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.I$0 = i5;
                                this.I$1 = i3;
                                this.I$2 = r6;
                                this.label = 4;
                                Object objCleanup2 = r12.cleanup(r9, null, this);
                                r7 = i5;
                                r11 = r12;
                            } else {
                                if (i6 != 4) {
                                    if (i6 != 5) {
                                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                        return null;
                                    }
                                    th = (Throwable) this.L$3;
                                    ResultKt.throwOnFailure(obj);
                                    throw th;
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return unit;
                            if (DispatcherSwitching_jvmKt.getUseEngineDispatcher()) {
                                CoroutineContext.Element element = r7.getCoroutineContext().get(ContinuationInterceptor$Key.$$INSTANCE);
                                element.getClass();
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(r7, null, completableDeferred);
                                this.L$0 = httpStatement;
                                this.L$1 = r7;
                                this.I$0 = i2;
                                this.I$1 = i;
                                this.I$2 = r11;
                                this.label = 2;
                                objWithContext = AwaitKt.withContext(element, anonymousClass1, this);
                                if (objWithContext == coroutineSingletons) {
                                    r7 = r7;
                                    r11 = r11;
                                } else {
                                    r9 = r7;
                                    r6 = r11;
                                    i3 = i;
                                    i5 = i2;
                                    r12 = httpStatement;
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.L$2 = objWithContext;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.I$0 = i5;
                                    this.I$1 = i3;
                                    this.I$2 = r6;
                                    this.label = 4;
                                    Object objCleanup3 = r12.cleanup(r9, null, this);
                                    r7 = i5;
                                    r11 = r12;
                                }
                            } else {
                                HttpClientCall call = r7.getCall();
                                ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ClientSSESession.class);
                                try {
                                    typeReferenceTypeOf = Reflection.typeOf(ClientSSESession.class);
                                } catch (Throwable unused) {
                                    typeReferenceTypeOf = null;
                                }
                                TypeInfo typeInfo = new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf);
                                this.L$0 = httpStatement;
                                this.L$1 = completableDeferred;
                                this.L$2 = r7;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.I$0 = i2;
                                this.I$1 = i;
                                this.I$2 = r11;
                                this.I$3 = 0;
                                this.label = 3;
                                objBodyNullable = call.bodyNullable(typeInfo, this);
                                r7 = r7;
                                r11 = r11;
                                if (objBodyNullable != coroutineSingletons) {
                                    r8 = r7;
                                    r5 = r11;
                                    i3 = i;
                                    i4 = i2;
                                    httpStatement2 = httpStatement;
                                    if (objBodyNullable != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.sse.ClientSSESession");
                                    }
                                    ((CompletableDeferredImpl) completableDeferred).makeCompleting$kotlinx_coroutines_core((ClientSSESession) objBodyNullable);
                                    objWithContext = unit;
                                    r6 = r5;
                                    i5 = i4;
                                    r9 = r8;
                                    r12 = httpStatement2;
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.L$2 = objWithContext;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.I$0 = i5;
                                    this.I$1 = i3;
                                    this.I$2 = r6;
                                    this.label = 4;
                                    Object objCleanup4 = r12.cleanup(r9, null, this);
                                    r7 = i5;
                                    r11 = r12;
                                }
                            }
                            return coroutineSingletons;
                        } catch (Throwable th2) {
                            th = th2;
                            r13 = r7;
                            r10 = r11;
                            i7 = i;
                            i8 = i2;
                            ?? r14 = httpStatement;
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                th = th3;
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = th;
                                this.L$4 = null;
                                this.I$0 = i8;
                                this.I$1 = i7;
                                this.I$2 = r10;
                                this.label = 5;
                            }
                        }
                        r7 = (HttpResponse) objFetchStreamingResponse;
                    } catch (Throwable th4) {
                        ((CompletableDeferredImpl) this.$sessionDeferred).completeExceptionally(BuildersKt.mapToSSEException(this.$this_processSession, null, null, th4));
                    }
                } catch (CancellationException e) {
                    ((JobSupport) this.$sessionDeferred).cancelInternal(e);
                }
            } catch (CancellationException e2) {
                throw ExceptionUtilsJvmKt.unwrapCancellationException(e2);
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
