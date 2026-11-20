package io.ktor.client.statement;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedCallKt;
import io.ktor.client.plugins.DoubleReceivePluginKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.utils.io.ByteReadChannelKt;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobSupport;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J:\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH\u0086@¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\r\u001a\u00020\nH\u0086@¢\u0006\u0004\b\r\u0010\u000fJ\u0018\u0010\u0010\u001a\u00028\u0000\"\u0006\b\u0000\u0010\b\u0018\u0001H\u0086H¢\u0006\u0004\b\u0010\u0010\u000fJD\u0010\u0010\u001a\u00028\u0001\"\u0006\b\u0000\u0010\b\u0018\u0001\"\u0004\b\u0001\u0010\u00112$\b\u0004\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH\u0086H¢\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\nH\u0081@¢\u0006\u0004\b\u0012\u0010\u000fJ\u0010\u0010\u0013\u001a\u00020\nH\u0081@¢\u0006\u0004\b\u0013\u0010\u000fJ\u0014\u0010\u0015\u001a\u00020\u0014*\u00020\nH\u0081@¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u0015\u001a\u00020\u0014*\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0081@¢\u0006\u0004\b\u0015\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR \u0010\u0005\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u001e\u0012\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lio/ktor/client/statement/HttpStatement;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "builder", "Lio/ktor/client/HttpClient;", "client", "<init>", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/HttpClient;)V", "T", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/coroutines/Continuation;", "block", "execute", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "body", "R", "fetchStreamingResponse", "fetchResponse", "", "cleanup", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cause", "(Lio/ktor/client/statement/HttpResponse;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/HttpClient;", "getClient", "()Lio/ktor/client/HttpClient;", "getClient$annotations", "()V", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HttpStatement {
    private final HttpRequestBuilder builder;
    private final HttpClient client;

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpStatement$cleanup$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {243}, m = "cleanup", v = 1)
    public static final class AnonymousClass2 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.cleanup(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpStatement$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {68, 73, 77, 83, 83}, m = "execute", v = 1)
    public static final class AnonymousClass1<T> extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.execute(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpStatement$fetchResponse$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {205, 208, 209}, m = "fetchResponse", v = 1)
    public static final class C02951 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C02951(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.fetchResponse(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpStatement$fetchStreamingResponse$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", l = {193}, m = "fetchStreamingResponse", v = 1)
    public static final class C02961 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C02961(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.fetchStreamingResponse(this);
        }
    }

    public HttpStatement(HttpRequestBuilder httpRequestBuilder, HttpClient httpClient) {
        httpRequestBuilder.getClass();
        httpClient.getClass();
        this.builder = httpRequestBuilder;
        this.client = httpClient;
    }

    public final <T, R> Object body(Function2 function2, Continuation continuation) throws Throwable {
        try {
            HttpResponse httpResponse = (HttpResponse) fetchStreamingResponse(null);
            try {
                if (DispatcherSwitching_jvmKt.getUseEngineDispatcher()) {
                    httpResponse.getCoroutineContext().get(ContinuationInterceptor$Key.$$INSTANCE).getClass();
                    Intrinsics.throwUndefinedForReified();
                    throw null;
                }
                httpResponse.getCall();
                Intrinsics.throwUndefinedForReified();
                throw null;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    cleanup(httpResponse, th, null);
                    throw th2;
                }
            }
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object cleanup(HttpResponse httpResponse, Throwable th, Continuation continuation) {
        AnonymousClass2 anonymousClass2;
        if (continuation instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuation;
            int i = anonymousClass2.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(continuation);
            }
        } else {
            anonymousClass2 = new AnonymousClass2(continuation);
        }
        Object obj = anonymousClass2.result;
        int i2 = anonymousClass2.label;
        Unit unit = Unit.INSTANCE;
        if (i2 != 0) {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            return unit;
        }
        ResultKt.throwOnFailure(obj);
        Job job = (CompletableJob) AwaitKt.getJob(httpResponse.getCoroutineContext());
        if (th == null) {
            ((JobImpl) job).makeCompleting$kotlinx_coroutines_core(unit);
        } else if (th instanceof CancellationException) {
            ((JobSupport) job).cancelInternal((CancellationException) th);
        } else {
            ((JobSupport) job).cancelInternal(AwaitKt.CancellationException("Exception occurred during request execution", th));
        }
        if (!DoubleReceivePluginKt.isSaved(httpResponse)) {
            try {
                ByteReadChannelKt.cancel(httpResponse.getRawContent());
            } catch (Throwable unused) {
            }
        }
        anonymousClass2.L$0 = null;
        anonymousClass2.L$1 = null;
        anonymousClass2.L$2 = null;
        anonymousClass2.L$3 = job;
        anonymousClass2.L$4 = null;
        anonymousClass2.I$0 = 0;
        anonymousClass2.label = 1;
        Object objJoin = ((JobSupport) job).join(anonymousClass2);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return objJoin == coroutineSingletons ? coroutineSingletons : unit;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00ee A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d3, code lost:
    
        if (r12 == r8) goto L67;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [io.ktor.client.statement.HttpStatement] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v3, types: [io.ktor.client.statement.HttpStatement] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r12v1, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3, types: [int] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v3, types: [io.ktor.client.statement.HttpResponse, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [io.ktor.client.statement.HttpResponse] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v5, types: [io.ktor.client.statement.HttpResponse] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [io.ktor.client.statement.HttpResponse] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object execute(Function2 function2, Continuation continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        ?? r13;
        ?? r12;
        Object obj;
        ?? r1;
        Object objInvoke;
        Object obj2;
        int i;
        ?? r4;
        int i2;
        Throwable th;
        ?? r5;
        int i3;
        Object objCleanup;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i4 = anonymousClass1.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i4 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj3 = anonymousClass1.result;
        int i5 = anonymousClass1.label;
        int i6 = 1;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj3);
                    anonymousClass1.L$0 = function2;
                    r13 = 0;
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.I$1 = 0;
                    anonymousClass1.label = 1;
                    Object objFetchStreamingResponse = fetchStreamingResponse(anonymousClass1);
                    if (objFetchStreamingResponse != coroutineSingletons) {
                        i6 = 0;
                        obj = objFetchStreamingResponse;
                        r12 = function2;
                    }
                    return coroutineSingletons;
                }
                if (i5 == 1) {
                    int i7 = anonymousClass1.I$1;
                    int i8 = anonymousClass1.I$0;
                    Function2 function3 = (Function2) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    r13 = i7;
                    r12 = function3;
                    i6 = i8;
                    obj = obj3;
                } else {
                    if (i5 != 2 && i5 != 3) {
                        if (i5 == 4) {
                            Object obj4 = anonymousClass1.L$2;
                            ResultKt.throwOnFailure(obj3);
                            return obj4;
                        }
                        if (i5 != 5) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        Throwable th2 = (Throwable) anonymousClass1.L$3;
                        ResultKt.throwOnFailure(obj3);
                        throw th2;
                    }
                    i = anonymousClass1.I$1;
                    i3 = anonymousClass1.I$0;
                    r5 = (HttpResponse) anonymousClass1.L$1;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        i2 = i3;
                        r4 = r5;
                        obj2 = obj3;
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            anonymousClass1.L$0 = null;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.L$2 = null;
                            anonymousClass1.L$3 = th4;
                            anonymousClass1.I$0 = i3;
                            anonymousClass1.I$1 = i;
                            anonymousClass1.label = 5;
                            if (this.cleanup(r5, th, anonymousClass1) != coroutineSingletons) {
                                throw th4;
                            }
                        }
                    }
                }
                anonymousClass1.L$0 = null;
                anonymousClass1.L$1 = null;
                anonymousClass1.L$2 = obj2;
                anonymousClass1.I$0 = i2;
                anonymousClass1.I$1 = i;
                anonymousClass1.label = 4;
                objCleanup = cleanup(r4, null, anonymousClass1);
                r1 = i2;
                this = objCleanup;
                r13 = obj2;
                if (objCleanup != coroutineSingletons) {
                    return obj2;
                }
                r1 = r1;
                this = this;
                r13 = r13;
                return coroutineSingletons;
                if (DispatcherSwitching_jvmKt.getUseEngineDispatcher()) {
                    CoroutineContext.Element element = r1.getCoroutineContext().get(ContinuationInterceptor$Key.$$INSTANCE);
                    element.getClass();
                    HttpStatement$execute$2$1 httpStatement$execute$2$1 = new HttpStatement$execute$2$1(r12, r1, null);
                    anonymousClass1.L$0 = null;
                    anonymousClass1.L$1 = r1;
                    anonymousClass1.I$0 = i6;
                    anonymousClass1.I$1 = r13;
                    anonymousClass1.label = 2;
                    objInvoke = AwaitKt.withContext(element, httpStatement$execute$2$1, anonymousClass1);
                    if (objInvoke == coroutineSingletons) {
                        r1 = r1;
                        this = this;
                        r13 = r13;
                    } else {
                        r1 = r1;
                        this = this;
                        r13 = r13;
                        ?? r6 = r13;
                        obj2 = objInvoke;
                        i = r6 == true ? 1 : 0;
                        r4 = r1;
                        i2 = i6;
                        anonymousClass1.L$0 = null;
                        anonymousClass1.L$1 = null;
                        anonymousClass1.L$2 = obj2;
                        anonymousClass1.I$0 = i2;
                        anonymousClass1.I$1 = i;
                        anonymousClass1.label = 4;
                        objCleanup = cleanup(r4, null, anonymousClass1);
                        r1 = i2;
                        this = objCleanup;
                        r13 = obj2;
                        if (objCleanup != coroutineSingletons) {
                            return obj2;
                        }
                    }
                } else {
                    anonymousClass1.L$0 = null;
                    anonymousClass1.L$1 = r1;
                    anonymousClass1.I$0 = i6;
                    anonymousClass1.I$1 = r13;
                    anonymousClass1.label = 3;
                    objInvoke = r12.invoke(r1, anonymousClass1);
                }
                r1 = r1;
                this = this;
                r13 = r13;
                return coroutineSingletons;
            } catch (Throwable th5) {
                ?? r7 = r13;
                th = th5;
                i = r7 == true ? 1 : 0;
                r5 = r1;
                i3 = i6;
                throw th;
            }
            r1 = (HttpResponse) obj;
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00b2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object fetchResponse(Continuation continuation) throws Throwable {
        C02951 c02951;
        int i;
        int i2;
        HttpClientCall httpClientCall;
        int i3;
        HttpResponse response;
        HttpResponse response2;
        if (continuation instanceof C02951) {
            c02951 = (C02951) continuation;
            int i4 = c02951.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c02951.label = i4 - Integer.MIN_VALUE;
            } else {
                c02951 = new C02951(continuation);
            }
        } else {
            c02951 = new C02951(continuation);
        }
        Object objExecute$ktor_client_core = c02951.result;
        int i5 = c02951.label;
        Object obj = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i5 == 0) {
                ResultKt.throwOnFailure(objExecute$ktor_client_core);
                HttpRequestBuilder httpRequestBuilderTakeFromWithExecutionContext = new HttpRequestBuilder().takeFromWithExecutionContext(this.builder);
                HttpClient httpClient = this.client;
                c02951.L$0 = null;
                c02951.I$0 = 0;
                c02951.I$1 = 0;
                c02951.label = 1;
                objExecute$ktor_client_core = httpClient.execute$ktor_client_core(httpRequestBuilderTakeFromWithExecutionContext, c02951);
                if (objExecute$ktor_client_core != obj) {
                    i = 0;
                    i2 = 0;
                }
                return obj;
            }
            if (i5 == 1) {
                i = c02951.I$1;
                i2 = c02951.I$0;
                ResultKt.throwOnFailure(objExecute$ktor_client_core);
            } else {
                if (i5 != 2) {
                    if (i5 != 3) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    HttpResponse httpResponse = (HttpResponse) c02951.L$2;
                    ResultKt.throwOnFailure(objExecute$ktor_client_core);
                    return httpResponse;
                }
                i = c02951.I$1;
                i3 = c02951.I$0;
                httpClientCall = (HttpClientCall) c02951.L$1;
                ResultKt.throwOnFailure(objExecute$ktor_client_core);
            }
            response = ((HttpClientCall) objExecute$ktor_client_core).getResponse();
            response2 = httpClientCall.getResponse();
            c02951.L$0 = null;
            c02951.L$1 = null;
            c02951.L$2 = response;
            c02951.I$0 = i3;
            c02951.I$1 = i;
            c02951.label = 3;
            if (cleanup(response2, null, c02951) != obj) {
                return obj;
            }
            return response;
            HttpClientCall httpClientCall2 = (HttpClientCall) objExecute$ktor_client_core;
            c02951.L$0 = null;
            c02951.L$1 = httpClientCall2;
            c02951.I$0 = i2;
            c02951.I$1 = i;
            c02951.label = 2;
            Object objSave = SavedCallKt.save(httpClientCall2, c02951);
            if (objSave != obj) {
                int i6 = i2;
                httpClientCall = httpClientCall2;
                objExecute$ktor_client_core = objSave;
                i3 = i6;
                response = ((HttpClientCall) objExecute$ktor_client_core).getResponse();
                response2 = httpClientCall.getResponse();
                c02951.L$0 = null;
                c02951.L$1 = null;
                c02951.L$2 = response;
                c02951.I$0 = i3;
                c02951.I$1 = i;
                c02951.label = 3;
                if (cleanup(response2, null, c02951) != obj) {
                    return response;
                }
            }
            return obj;
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object fetchStreamingResponse(Continuation continuation) throws Throwable {
        C02961 c02961;
        if (continuation instanceof C02961) {
            c02961 = (C02961) continuation;
            int i = c02961.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c02961.label = i - Integer.MIN_VALUE;
            } else {
                c02961 = new C02961(continuation);
            }
        } else {
            c02961 = new C02961(continuation);
        }
        Object objExecute$ktor_client_core = c02961.result;
        int i2 = c02961.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objExecute$ktor_client_core);
                HttpRequestBuilder httpRequestBuilderTakeFromWithExecutionContext = new HttpRequestBuilder().takeFromWithExecutionContext(this.builder);
                DoubleReceivePluginKt.skipSaveBody(httpRequestBuilderTakeFromWithExecutionContext);
                HttpClient httpClient = this.client;
                c02961.L$0 = null;
                c02961.I$0 = 0;
                c02961.I$1 = 0;
                c02961.label = 1;
                objExecute$ktor_client_core = httpClient.execute$ktor_client_core(httpRequestBuilderTakeFromWithExecutionContext, c02961);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objExecute$ktor_client_core == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objExecute$ktor_client_core);
            }
            return ((HttpClientCall) objExecute$ktor_client_core).getResponse();
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    public final HttpClient getClient() {
        return this.client;
    }

    public String toString() {
        return "HttpStatement[" + this.builder.getUrl() + ']';
    }

    public static /* synthetic */ void getClient$annotations() {
    }

    public final <T> Object body(Continuation continuation) throws Throwable {
        try {
            HttpResponse httpResponse = (HttpResponse) fetchStreamingResponse(null);
            try {
                httpResponse.getCall();
                Intrinsics.throwUndefinedForReified();
                throw null;
            } catch (Throwable th) {
                HttpResponseKt.complete(httpResponse);
                throw th;
            }
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    @Deprecated
    public final Object cleanup(HttpResponse httpResponse, Continuation continuation) {
        Object objCleanup = cleanup(httpResponse, null, continuation);
        return objCleanup == CoroutineSingletons.COROUTINE_SUSPENDED ? objCleanup : Unit.INSTANCE;
    }

    public final Object execute(Continuation continuation) {
        return fetchResponse(continuation);
    }
}
