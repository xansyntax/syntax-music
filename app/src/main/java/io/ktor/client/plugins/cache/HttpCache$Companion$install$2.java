package io.ktor.client.plugins.cache;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.cache.storage.CachedResponseData;
import io.ktor.client.plugins.cache.storage.HttpCacheStorageKt;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.HttpStatusCodeKt;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", "response"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache$Companion$install$2", f = "HttpCache.kt", l = {245, 251, 258, 265, 272}, m = "invokeSuspend", v = 1)
public final class HttpCache$Companion$install$2 extends SuspendLambda implements Function3 {
    final /* synthetic */ HttpCache $plugin;
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCache$Companion$install$2(HttpCache httpCache, HttpClient httpClient, Continuation continuation) {
        super(3, continuation);
        this.$plugin = httpCache;
        this.$scope = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation continuation) {
        HttpCache$Companion$install$2 httpCache$Companion$install$2 = new HttpCache$Companion$install$2(this.$plugin, this.$scope, continuation);
        httpCache$Companion$install$2.L$0 = pipelineContext;
        httpCache$Companion$install$2.L$1 = httpResponse;
        return httpCache$Companion$install$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:41:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:43:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:47:0x013b A[PHI: r12
      0x013b: PHI (r12v22 java.lang.Object) = (r12v18 java.lang.Object), (r12v0 java.lang.Object) binds: [B:45:0x0138, B:12:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Instruction removed from duplicated block: B:43:0x00fd, please report this as an issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Logger logger;
        CachedResponseData cachedResponseData;
        HttpResponse httpResponseCreateResponse;
        HttpResponse httpResponse;
        PipelineContext pipelineContext = (PipelineContext) this.L$0;
        HttpResponse httpResponse2 = (HttpResponse) this.L$1;
        int i = this.label;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return unit;
            }
            if (i != 2) {
                if (i == 3) {
                    ResultKt.throwOnFailure(obj);
                    return unit;
                }
                if (i == 4) {
                    ResultKt.throwOnFailure(obj);
                    httpResponse = (HttpResponse) obj;
                    this.$scope.getMonitor().raise(HttpCache.INSTANCE.getHttpResponseFromCache(), httpResponse);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 5;
                    if (pipelineContext.proceedWith(httpResponse, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 5) {
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return unit;
            }
            ResultKt.throwOnFailure(obj);
            cachedResponseData = (CachedResponseData) obj;
            if (cachedResponseData != null) {
                if (Intrinsics.areEqual(httpResponse2.getStatus(), HttpStatusCode.INSTANCE.getNotModified())) {
                    logger = HttpCacheKt.getLOGGER();
                    if (LoggerJvmKt.isTraceEnabled(logger)) {
                        logger.trace("Not modified response for " + httpResponse2.getCall().getRequest().getUrl() + ", replying from cache");
                    }
                    HttpRequest request = httpResponse2.getCall().getRequest();
                    HttpCache$Companion$install$2$responseFromCache$1 httpCache$Companion$install$2$responseFromCache$1 = new HttpCache$Companion$install$2$responseFromCache$1(this.$plugin);
                    this.L$0 = pipelineContext;
                    this.L$1 = null;
                    this.label = 4;
                    obj = HttpCacheValidationKt.refreshNotModifiedResponse(request, httpResponse2, httpCache$Companion$install$2$responseFromCache$1, this);
                    if (obj != coroutineSingletons) {
                        httpResponse = (HttpResponse) obj;
                        this.$scope.getMonitor().raise(HttpCache.INSTANCE.getHttpResponseFromCache(), httpResponse);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 5;
                        if (pipelineContext.proceedWith(httpResponse, this) == coroutineSingletons) {
                        }
                    }
                }
                return unit;
            }
            httpResponseCreateResponse = HttpCacheStorageKt.createResponse(cachedResponseData, this.$scope, HttpResponseKt.getRequest(httpResponse2), httpResponse2.getCoroutineContext());
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 3;
            if (pipelineContext.proceedWith(httpResponseCreateResponse, this) == coroutineSingletons) {
                return unit;
            }
            return coroutineSingletons;
        }
        ResultKt.throwOnFailure(obj);
        if (!Intrinsics.areEqual(httpResponse2.getCall().getRequest().getMethod(), HttpMethod.Get)) {
            return unit;
        }
        if (this.$plugin.useOldStorage) {
            HttpCache httpCache = this.$plugin;
            HttpClient httpClient = this.$scope;
            this.L$0 = null;
            this.L$1 = null;
            this.label = 1;
            if (HttpCacheLegacyKt.interceptReceiveLegacy(pipelineContext, httpResponse2, httpCache, httpClient, this) != coroutineSingletons) {
                return unit;
            }
        } else {
            if (!HttpStatusCodeKt.isSuccess(httpResponse2.getStatus())) {
                if (Intrinsics.areEqual(httpResponse2.getStatus(), HttpStatusCode.INSTANCE.getNotModified())) {
                    logger = HttpCacheKt.getLOGGER();
                    if (LoggerJvmKt.isTraceEnabled(logger)) {
                        logger.trace("Not modified response for " + httpResponse2.getCall().getRequest().getUrl() + ", replying from cache");
                    }
                    HttpRequest request2 = httpResponse2.getCall().getRequest();
                    HttpCache$Companion$install$2$responseFromCache$1 httpCache$Companion$install$2$responseFromCache$2 = new HttpCache$Companion$install$2$responseFromCache$1(this.$plugin);
                    this.L$0 = pipelineContext;
                    this.L$1 = null;
                    this.label = 4;
                    obj = HttpCacheValidationKt.refreshNotModifiedResponse(request2, httpResponse2, httpCache$Companion$install$2$responseFromCache$2, this);
                    if (obj != coroutineSingletons) {
                        httpResponse = (HttpResponse) obj;
                        this.$scope.getMonitor().raise(HttpCache.INSTANCE.getHttpResponseFromCache(), httpResponse);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 5;
                        if (pipelineContext.proceedWith(httpResponse, this) == coroutineSingletons) {
                        }
                    }
                }
                return unit;
            }
            Logger logger2 = HttpCacheKt.getLOGGER();
            if (LoggerJvmKt.isTraceEnabled(logger2)) {
                logger2.trace("Caching response for " + httpResponse2.getCall().getRequest().getUrl());
            }
            HttpCache httpCache2 = this.$plugin;
            this.L$0 = pipelineContext;
            this.L$1 = httpResponse2;
            this.label = 2;
            obj = httpCache2.cacheResponse(httpResponse2, this);
            if (obj != coroutineSingletons) {
                cachedResponseData = (CachedResponseData) obj;
                if (cachedResponseData != null) {
                    if (Intrinsics.areEqual(httpResponse2.getStatus(), HttpStatusCode.INSTANCE.getNotModified())) {
                        logger = HttpCacheKt.getLOGGER();
                        if (LoggerJvmKt.isTraceEnabled(logger)) {
                            logger.trace("Not modified response for " + httpResponse2.getCall().getRequest().getUrl() + ", replying from cache");
                        }
                        HttpRequest request3 = httpResponse2.getCall().getRequest();
                        HttpCache$Companion$install$2$responseFromCache$1 httpCache$Companion$install$2$responseFromCache$3 = new HttpCache$Companion$install$2$responseFromCache$1(this.$plugin);
                        this.L$0 = pipelineContext;
                        this.L$1 = null;
                        this.label = 4;
                        obj = HttpCacheValidationKt.refreshNotModifiedResponse(request3, httpResponse2, httpCache$Companion$install$2$responseFromCache$3, this);
                        if (obj != coroutineSingletons) {
                            httpResponse = (HttpResponse) obj;
                            this.$scope.getMonitor().raise(HttpCache.INSTANCE.getHttpResponseFromCache(), httpResponse);
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.label = 5;
                            if (pipelineContext.proceedWith(httpResponse, this) == coroutineSingletons) {
                            }
                        }
                    }
                    return unit;
                }
                httpResponseCreateResponse = HttpCacheStorageKt.createResponse(cachedResponseData, this.$scope, HttpResponseKt.getRequest(httpResponse2), httpResponse2.getCoroutineContext());
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 3;
                if (pipelineContext.proceedWith(httpResponseCreateResponse, this) == coroutineSingletons) {
                    return unit;
                }
            }
        }
        return coroutineSingletons;
    }
}
