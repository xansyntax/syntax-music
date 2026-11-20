package io.ktor.client.plugins.observer;

import com.yalantis.ucrop.UCrop;
import io.ktor.client.plugins.DoubleReceivePluginKt;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.ByteChannelsKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/observer/AfterReceiveHook$Context;", "response", "Lio/ktor/client/statement/HttpResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$2$1", f = "ResponseObserver.kt", l = {UCrop.REQUEST_CROP, UCrop.REQUEST_CROP, 72, 82, 87}, m = "invokeSuspend", v = 1)
public final class ResponseObserverKt$ResponseObserver$2$1 extends SuspendLambda implements Function3 {
    final /* synthetic */ Function1 $filter;
    final /* synthetic */ Function2 $responseHandler;
    final /* synthetic */ ClientPluginBuilder<ResponseObserverConfig> $this_createClientPlugin;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX INFO: renamed from: io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$2$1$1", f = "ResponseObserver.kt", l = {70}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ HttpResponse $response;
        final /* synthetic */ Function2 $responseHandler;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function2 function2, HttpResponse httpResponse, Continuation continuation) {
            super(2, continuation);
            this.$responseHandler = function2;
            this.$response = httpResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$responseHandler, this.$response, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object failure;
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function2 function2 = this.$responseHandler;
                    HttpResponse httpResponse = this.$response;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.I$0 = 0;
                    this.label = 1;
                    Object objInvoke = function2.invoke(httpResponse, this);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objInvoke == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                failure = Unit.INSTANCE;
            } catch (Throwable th) {
                failure = new Result.Failure(th);
            }
            return new Result(failure);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$2$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$2$1$2", f = "ResponseObserver.kt", l = {83, 84}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function2 $responseHandler;
        final /* synthetic */ HttpResponse $sideResponse;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function2 function2, HttpResponse httpResponse, Continuation continuation) {
            super(2, continuation);
            this.$responseHandler = function2;
            this.$sideResponse = httpResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$responseHandler, this.$sideResponse, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
        
            if (r14.invoke(r1, r13) == r6) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:
        
            if (r14 == r6) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
        
            return r6;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            int i = this.label;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            try {
                try {
                    if (i != 0) {
                        if (i == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            if (i != 2) {
                                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        Boxing.boxLong(((Number) obj).longValue());
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    Function2 function2 = this.$responseHandler;
                    HttpResponse httpResponse = this.$sideResponse;
                    this.L$0 = coroutineScope;
                    this.L$1 = null;
                    this.I$0 = 0;
                    this.label = 1;
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
            }
            ByteReadChannel rawContent = this.$sideResponse.getRawContent();
            this.L$0 = null;
            this.L$1 = null;
            this.I$0 = 0;
            this.label = 2;
            obj = ByteReadChannelOperationsKt.discard$default(rawContent, 0L, this, 1, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseObserverKt$ResponseObserver$2$1(Function1 function1, ClientPluginBuilder<ResponseObserverConfig> clientPluginBuilder, Function2 function2, Continuation continuation) {
        super(3, continuation);
        this.$filter = function1;
        this.$this_createClientPlugin = clientPluginBuilder;
        this.$responseHandler = function2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(AfterReceiveHook.Context context, HttpResponse httpResponse, Continuation continuation) {
        ResponseObserverKt$ResponseObserver$2$1 responseObserverKt$ResponseObserver$2$1 = new ResponseObserverKt$ResponseObserver$2$1(this.$filter, this.$this_createClientPlugin, this.$responseHandler, continuation);
        responseObserverKt$ResponseObserver$2$1.L$0 = context;
        responseObserverKt$ResponseObserver$2$1.L$1 = httpResponse;
        return responseObserverKt$ResponseObserver$2$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0125 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x0126 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HttpResponse response;
        CoroutineScope client;
        HttpResponse httpResponse;
        AnonymousClass1 anonymousClass1;
        AfterReceiveHook.Context context = (AfterReceiveHook.Context) this.L$0;
        HttpResponse httpResponse2 = (HttpResponse) this.L$1;
        int i = this.label;
        byte b = 2;
        Unit unit = Unit.INSTANCE;
        byte b2 = 1;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                anonymousClass1 = new AnonymousClass1(this.$responseHandler, httpResponse2, null);
                this.L$0 = context;
                this.L$1 = httpResponse2;
                this.label = 2;
                if (AwaitKt.withContext((CoroutineContext) obj, anonymousClass1, this) != coroutineSingletons) {
                }
                return coroutineSingletons;
            }
            if (i != 2) {
                if (i == 3) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                if (i != 4) {
                    if (i != 5) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                client = (CoroutineScope) this.L$6;
                response = (HttpResponse) this.L$5;
                httpResponse = (HttpResponse) this.L$4;
                ResultKt.throwOnFailure(obj);
                AwaitKt.launch$default(client, (CoroutineContext) obj, null, new AnonymousClass2(this.$responseHandler, response, null), 2);
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.L$5 = null;
                this.L$6 = null;
                this.label = 5;
                if (context.proceedWith(httpResponse, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                return unit;
            }
            ResultKt.throwOnFailure(obj);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 3;
            if (context.proceedWith(httpResponse2, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            return unit;
        }
        ResultKt.throwOnFailure(obj);
        Function1 function1 = this.$filter;
        if (function1 == null || ((Boolean) function1.invoke(httpResponse2.getCall())).booleanValue()) {
            if (DoubleReceivePluginKt.isSaved(httpResponse2)) {
                this.L$0 = context;
                this.L$1 = httpResponse2;
                this.label = 1;
                obj = ResponseObserverContextJvmKt.getResponseObserverContext(this);
                if (obj != coroutineSingletons) {
                    anonymousClass1 = new AnonymousClass1(this.$responseHandler, httpResponse2, null);
                    this.L$0 = context;
                    this.L$1 = httpResponse2;
                    this.label = 2;
                    if (AwaitKt.withContext((CoroutineContext) obj, anonymousClass1, this) != coroutineSingletons) {
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 3;
                        if (context.proceedWith(httpResponse2, this) == coroutineSingletons) {
                        }
                    }
                }
            } else {
                Pair pairSplit = ByteChannelsKt.split(httpResponse2.getRawContent(), httpResponse2);
                ByteReadChannel byteReadChannel = (ByteReadChannel) pairSplit.first;
                HttpResponse response2 = io.ktor.client.call.DelegatedCallKt.replaceResponse$default(httpResponse2.getCall(), null, new DelegatedCallKt$$ExternalSyntheticLambda1((ByteReadChannel) pairSplit.second, b2), 1, null).getResponse();
                response = io.ktor.client.call.DelegatedCallKt.replaceResponse$default(httpResponse2.getCall(), null, new DelegatedCallKt$$ExternalSyntheticLambda1(byteReadChannel, b), 1, null).getResponse();
                client = this.$this_createClientPlugin.getClient();
                this.L$0 = context;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = response2;
                this.L$5 = response;
                this.L$6 = client;
                this.label = 4;
                Object responseObserverContext = ResponseObserverContextJvmKt.getResponseObserverContext(this);
                if (responseObserverContext != coroutineSingletons) {
                    httpResponse = response2;
                    obj = responseObserverContext;
                    AwaitKt.launch$default(client, (CoroutineContext) obj, null, new AnonymousClass2(this.$responseHandler, response, null), 2);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.L$6 = null;
                    this.label = 5;
                    if (context.proceedWith(httpResponse, this) == coroutineSingletons) {
                    }
                }
            }
            return coroutineSingletons;
        }
        return unit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel invokeSuspend$lambda$0(ByteReadChannel byteReadChannel, HttpResponse httpResponse) {
        return byteReadChannel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel invokeSuspend$lambda$1(ByteReadChannel byteReadChannel, HttpResponse httpResponse) {
        return byteReadChannel;
    }
}
