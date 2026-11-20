package io.ktor.client.plugins.cache;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.cache.storage.CachedResponseData;
import io.ktor.client.plugins.cache.storage.HttpCacheStorageKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.UtilsKt;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.http.content.OutgoingContent;
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
import kotlinx.coroutines.Job;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "content"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache$Companion$install$1", f = "HttpCache.kt", l = {200, 204, 210, 219, 224}, m = "invokeSuspend", v = 1)
public final class HttpCache$Companion$install$1 extends SuspendLambda implements Function3 {
    final /* synthetic */ HttpCache $plugin;
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCache$Companion$install$1(HttpCache httpCache, HttpClient httpClient, Continuation continuation) {
        super(3, continuation);
        this.$plugin = httpCache;
        this.$scope = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation continuation) {
        HttpCache$Companion$install$1 httpCache$Companion$install$1 = new HttpCache$Companion$install$1(this.$plugin, this.$scope, continuation);
        httpCache$Companion$install$1.L$0 = pipelineContext;
        httpCache$Companion$install$1.L$1 = obj;
        return httpCache$Companion$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00db  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:45:0x0125  */
    /* JADX WARN: Code duplicated, block: B:47:0x012f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0161  */
    /* JADX WARN: Code duplicated, block: B:54:0x0177  */
    /* JADX WARN: Code duplicated, block: B:57:0x01b1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:60:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:63:0x01d7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:64:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:66:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:68:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:72:0x0222  */
    /* JADX WARN: Code duplicated, block: B:74:0x022c  */
    /* JADX WARN: Instruction removed from duplicated block: B:42:0x00e5, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:47:0x012f, please report this as an issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CachedResponseData cachedResponseData;
        ValidateStatus validateStatusShouldValidate;
        String str;
        String str2;
        Logger logger;
        Logger logger2;
        HttpCache.Companion companion;
        HttpClient httpClient;
        Job executionContext;
        HttpClientCall call;
        HttpCache.Companion companion2;
        HttpClient httpClient2;
        Logger logger3;
        Logger logger4;
        HttpCache.Companion companion3;
        HttpClient httpClient3;
        PipelineContext<Object, HttpRequestBuilder> pipelineContext = (PipelineContext) this.L$0;
        Object obj2 = this.L$1;
        int i = this.label;
        Unit unit = Unit.INSTANCE;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!(obj2 instanceof OutgoingContent.NoContent) || !Intrinsics.areEqual(pipelineContext.getContext().getMethod(), HttpMethod.Get) || !HttpCacheKt.canStore(pipelineContext.getContext().getUrl().getProtocol()) || (this.$plugin.getIsSharedClient() && pipelineContext.getContext().getHeaders().contains(HttpHeaders.Authorization))) {
                return unit;
            }
            boolean z = this.$plugin.useOldStorage;
            HttpCache httpCache = this.$plugin;
            if (z) {
                HttpClient httpClient4 = this.$scope;
                this.L$0 = null;
                this.L$1 = null;
                this.label = 1;
                if (HttpCacheLegacyKt.interceptSendLegacy(pipelineContext, httpCache, (OutgoingContent) obj2, httpClient4, this) != coroutineSingletons) {
                    return unit;
                }
            } else {
                this.L$0 = pipelineContext;
                this.L$1 = null;
                this.label = 2;
                obj = httpCache.findResponse(pipelineContext.getContext(), (OutgoingContent) obj2, this);
                if (obj != coroutineSingletons) {
                    cachedResponseData = (CachedResponseData) obj;
                    if (cachedResponseData == null) {
                        logger3 = HttpCacheKt.getLOGGER();
                        if (LoggerJvmKt.isTraceEnabled(logger3)) {
                            logger3.trace("No cached response for " + pipelineContext.getContext().getUrl() + " found");
                        }
                        if (HttpHeaderValueParserKt.parseHeaderValue(pipelineContext.getContext().getHeaders().get(HttpHeaders.CacheControl)).contains(CacheControl.INSTANCE.getONLY_IF_CACHED$ktor_client_core())) {
                            logger4 = HttpCacheKt.getLOGGER();
                            if (LoggerJvmKt.isTraceEnabled(logger4)) {
                                logger4.trace("No cache found and \"only-if-cached\" set for " + pipelineContext.getContext().getUrl());
                            }
                            companion3 = HttpCache.INSTANCE;
                            httpClient3 = this.$scope;
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 3;
                            if (companion3.proceedWithMissingCache$ktor_client_core(pipelineContext, httpClient3, this) == coroutineSingletons) {
                            }
                        }
                        return unit;
                    }
                    validateStatusShouldValidate = HttpCacheEntryKt.shouldValidate(cachedResponseData.getExpires(), cachedResponseData.getHeaders(), pipelineContext.getContext());
                    if (validateStatusShouldValidate == ValidateStatus.ShouldNotValidate) {
                        call = HttpCacheStorageKt.createResponse(cachedResponseData, this.$scope, new RequestForCache(pipelineContext.getContext().build()), pipelineContext.getContext().getExecutionContext()).getCall();
                        companion2 = HttpCache.INSTANCE;
                        httpClient2 = this.$scope;
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.label = 4;
                        if (companion2.proceedWithCache$ktor_client_core(pipelineContext, httpClient2, call, this) == coroutineSingletons) {
                            return unit;
                        }
                    } else {
                        if (validateStatusShouldValidate == ValidateStatus.ShouldWarn) {
                            str = cachedResponseData.getHeaders().get(HttpHeaders.ETag);
                            if (str != null) {
                                logger2 = HttpCacheKt.getLOGGER();
                                if (LoggerJvmKt.isTraceEnabled(logger2)) {
                                    StringBuilder sbM4m = IntIntPair$$ExternalSyntheticOutline0.m4m("Adding If-None-Match=", str, " for ");
                                    sbM4m.append(pipelineContext.getContext().getUrl());
                                    logger2.trace(sbM4m.toString());
                                }
                                UtilsKt.header(pipelineContext.getContext(), HttpHeaders.IfNoneMatch, str);
                            }
                            str2 = cachedResponseData.getHeaders().get(HttpHeaders.LastModified);
                            if (str2 != null) {
                                logger = HttpCacheKt.getLOGGER();
                                if (LoggerJvmKt.isTraceEnabled(logger)) {
                                    StringBuilder sbM4m2 = IntIntPair$$ExternalSyntheticOutline0.m4m("Adding If-Modified-Since=", str2, " for ");
                                    sbM4m2.append(pipelineContext.getContext().getUrl());
                                    logger.trace(sbM4m2.toString());
                                }
                                UtilsKt.header(pipelineContext.getContext(), HttpHeaders.IfModifiedSince, str2);
                            }
                            return unit;
                        }
                        companion = HttpCache.INSTANCE;
                        httpClient = this.$scope;
                        executionContext = pipelineContext.getContext().getExecutionContext();
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 5;
                        if (companion.proceedWithWarning(pipelineContext, cachedResponseData, httpClient, executionContext, this) == coroutineSingletons) {
                            return unit;
                        }
                    }
                }
            }
            return coroutineSingletons;
        }
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
                return unit;
            }
            if (i != 5) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            return unit;
        }
        ResultKt.throwOnFailure(obj);
        cachedResponseData = (CachedResponseData) obj;
        if (cachedResponseData == null) {
            logger3 = HttpCacheKt.getLOGGER();
            if (LoggerJvmKt.isTraceEnabled(logger3)) {
                logger3.trace("No cached response for " + pipelineContext.getContext().getUrl() + " found");
            }
            if (HttpHeaderValueParserKt.parseHeaderValue(pipelineContext.getContext().getHeaders().get(HttpHeaders.CacheControl)).contains(CacheControl.INSTANCE.getONLY_IF_CACHED$ktor_client_core())) {
                logger4 = HttpCacheKt.getLOGGER();
                if (LoggerJvmKt.isTraceEnabled(logger4)) {
                    logger4.trace("No cache found and \"only-if-cached\" set for " + pipelineContext.getContext().getUrl());
                }
                companion3 = HttpCache.INSTANCE;
                httpClient3 = this.$scope;
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 3;
                if (companion3.proceedWithMissingCache$ktor_client_core(pipelineContext, httpClient3, this) == coroutineSingletons) {
                }
            }
            return unit;
        }
        validateStatusShouldValidate = HttpCacheEntryKt.shouldValidate(cachedResponseData.getExpires(), cachedResponseData.getHeaders(), pipelineContext.getContext());
        if (validateStatusShouldValidate == ValidateStatus.ShouldNotValidate) {
            call = HttpCacheStorageKt.createResponse(cachedResponseData, this.$scope, new RequestForCache(pipelineContext.getContext().build()), pipelineContext.getContext().getExecutionContext()).getCall();
            companion2 = HttpCache.INSTANCE;
            httpClient2 = this.$scope;
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.L$4 = null;
            this.label = 4;
            if (companion2.proceedWithCache$ktor_client_core(pipelineContext, httpClient2, call, this) == coroutineSingletons) {
                return unit;
            }
        } else {
            if (validateStatusShouldValidate == ValidateStatus.ShouldWarn) {
                str = cachedResponseData.getHeaders().get(HttpHeaders.ETag);
                if (str != null) {
                    logger2 = HttpCacheKt.getLOGGER();
                    if (LoggerJvmKt.isTraceEnabled(logger2)) {
                        StringBuilder sbM4m3 = IntIntPair$$ExternalSyntheticOutline0.m4m("Adding If-None-Match=", str, " for ");
                        sbM4m3.append(pipelineContext.getContext().getUrl());
                        logger2.trace(sbM4m3.toString());
                    }
                    UtilsKt.header(pipelineContext.getContext(), HttpHeaders.IfNoneMatch, str);
                }
                str2 = cachedResponseData.getHeaders().get(HttpHeaders.LastModified);
                if (str2 != null) {
                    logger = HttpCacheKt.getLOGGER();
                    if (LoggerJvmKt.isTraceEnabled(logger)) {
                        StringBuilder sbM4m4 = IntIntPair$$ExternalSyntheticOutline0.m4m("Adding If-Modified-Since=", str2, " for ");
                        sbM4m4.append(pipelineContext.getContext().getUrl());
                        logger.trace(sbM4m4.toString());
                    }
                    UtilsKt.header(pipelineContext.getContext(), HttpHeaders.IfModifiedSince, str2);
                }
                return unit;
            }
            companion = HttpCache.INSTANCE;
            httpClient = this.$scope;
            executionContext = pipelineContext.getContext().getExecutionContext();
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 5;
            if (companion.proceedWithWarning(pipelineContext, cachedResponseData, httpClient, executionContext, this) == coroutineSingletons) {
                return unit;
            }
        }
        return coroutineSingletons;
    }
}
