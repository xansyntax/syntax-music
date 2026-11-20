package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.utils.io.KtorDsl;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.AwaitKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@KtorDsl
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J'\u0010\n\u001a\u00020\u00042\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\f2\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u000e¢\u0006\u0004\b\u0013\u0010\u0014J7\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\f2\u001e\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00120\u000e¢\u0006\u0004\b\u0016\u0010\u0014J!\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u001bJ1\u0010 \u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u00122\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001f0\u0006¢\u0006\u0004\b \u0010!J+\u0010$\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u001f2\b\b\u0002\u0010#\u001a\u00020\u001f2\b\b\u0002\u0010\u001d\u001a\u00020\u0012¢\u0006\u0004\b$\u0010%J?\u0010*\u001a\u00020\u00042\b\b\u0002\u0010'\u001a\u00020&2\b\b\u0002\u0010(\u001a\u00020\u001f2\b\b\u0002\u0010)\u001a\u00020\u001f2\b\b\u0002\u0010#\u001a\u00020\u001f2\b\b\u0002\u0010\u001d\u001a\u00020\u0012¢\u0006\u0004\b*\u0010+J1\u0010-\u001a\u00020\u00042\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040,\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\u0004\b-\u0010\u000bJ\u0017\u0010.\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001fH\u0002¢\u0006\u0004\b.\u0010/R:\u00100\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u000e8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R:\u00106\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00120\u000e8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b6\u00101\u001a\u0004\b7\u00103\"\u0004\b8\u00105R4\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001f0\u00068\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b \u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010\u000bR>\u0010-\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040,\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b-\u00109\u001a\u0004\b=\u0010;\"\u0004\b>\u0010\u000bRH\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00062\u0018\u0010?\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\n\u00109\u001a\u0004\b@\u0010;R\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010\u001bR+\u0010\u0013\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\bE\u00103R+\u0010\u0016\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\bF\u00103¨\u0006G"}, d2 = {"Lio/ktor/client/plugins/HttpRequestRetryConfig;", "", "<init>", "()V", "", "noRetry", "Lkotlin/Function2;", "Lio/ktor/client/plugins/HttpRetryModifyRequestContext;", "Lio/ktor/client/request/HttpRequestBuilder;", "block", "modifyRequest", "(Lkotlin/jvm/functions/Function2;)V", "", "maxRetries", "Lkotlin/Function3;", "Lio/ktor/client/plugins/HttpRetryShouldRetryContext;", "Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/statement/HttpResponse;", "", "retryIf", "(ILkotlin/jvm/functions/Function3;)V", "", "retryOnExceptionIf", "retryOnTimeout", "retryOnException", "(IZ)V", "retryOnServerErrors", "(I)V", "retryOnExceptionOrServerErrors", "respectRetryAfterHeader", "Lio/ktor/client/plugins/HttpRetryDelayContext;", "", "delayMillis", "(ZLkotlin/jvm/functions/Function2;)V", "millis", "randomizationMs", "constantDelay", "(JJZ)V", "", "base", "baseDelayMs", "maxDelayMs", "exponentialDelay", "(DJJJZ)V", "Lkotlin/coroutines/Continuation;", "delay", "randomMs", "(J)J", "shouldRetry", "Lkotlin/jvm/functions/Function3;", "getShouldRetry$ktor_client_core", "()Lkotlin/jvm/functions/Function3;", "setShouldRetry$ktor_client_core", "(Lkotlin/jvm/functions/Function3;)V", "shouldRetryOnException", "getShouldRetryOnException$ktor_client_core", "setShouldRetryOnException$ktor_client_core", "Lkotlin/jvm/functions/Function2;", "getDelayMillis$ktor_client_core", "()Lkotlin/jvm/functions/Function2;", "setDelayMillis$ktor_client_core", "getDelay$ktor_client_core", "setDelay$ktor_client_core", "value", "getModifyRequest", "I", "getMaxRetries", "()I", "setMaxRetries", "getRetryIf", "getRetryOnExceptionIf", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HttpRequestRetryConfig {
    public Function2 delayMillis;
    private int maxRetries;
    public Function3 shouldRetry;
    public Function3 shouldRetryOnException;
    private Function2 delay = new AnonymousClass1(null);
    private Function2 modifyRequest = new HttpRequestRetryConfig$$ExternalSyntheticLambda3();

    public HttpRequestRetryConfig() {
        retryOnExceptionOrServerErrors(3);
        exponentialDelay$default(this, 0.0d, 0L, 0L, 0L, false, 31, null);
    }

    public static /* synthetic */ void constantDelay$default(HttpRequestRetryConfig httpRequestRetryConfig, long j, long j2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 1000;
        }
        if ((i & 2) != 0) {
            j2 = 1000;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        httpRequestRetryConfig.constantDelay(j, j2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long constantDelay$lambda$0(long j, HttpRequestRetryConfig httpRequestRetryConfig, long j2, HttpRetryDelayContext httpRetryDelayContext, int i) {
        httpRetryDelayContext.getClass();
        return j + httpRequestRetryConfig.randomMs(j2);
    }

    public static /* synthetic */ void delayMillis$default(HttpRequestRetryConfig httpRequestRetryConfig, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        httpRequestRetryConfig.delayMillis(z, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long delayMillis$lambda$0(boolean z, Function2 function2, HttpRetryDelayContext httpRetryDelayContext, int i) {
        Headers headers;
        String str;
        Long longOrNull;
        httpRetryDelayContext.getClass();
        if (!z) {
            return ((Number) function2.invoke(httpRetryDelayContext, Integer.valueOf(i))).longValue();
        }
        HttpResponse response = httpRetryDelayContext.getResponse();
        Long lValueOf = (response == null || (headers = response.getHeaders()) == null || (str = headers.get(HttpHeaders.RetryAfter)) == null || (longOrNull = StringsKt__StringsJVMKt.toLongOrNull(10, str)) == null) ? null : Long.valueOf(longOrNull.longValue() * 1000);
        return Math.max(((Number) function2.invoke(httpRetryDelayContext, Integer.valueOf(i))).longValue(), lValueOf != null ? lValueOf.longValue() : 0L);
    }

    public static /* synthetic */ void exponentialDelay$default(HttpRequestRetryConfig httpRequestRetryConfig, double d, long j, long j2, long j3, boolean z, int i, Object obj) {
        httpRequestRetryConfig.exponentialDelay((i & 1) != 0 ? 2.0d : d, (i & 2) != 0 ? 1000L : j, (i & 4) != 0 ? 60000L : j2, (i & 8) == 0 ? j3 : 1000L, (i & 16) != 0 ? true : z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long exponentialDelay$lambda$0(double d, long j, long j2, HttpRequestRetryConfig httpRequestRetryConfig, long j3, HttpRetryDelayContext httpRetryDelayContext, int i) {
        httpRetryDelayContext.getClass();
        return Math.min((long) (Math.pow(d, i - 1) * j), j2) + httpRequestRetryConfig.randomMs(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit modifyRequest$lambda$0(HttpRetryModifyRequestContext httpRetryModifyRequestContext, HttpRequestBuilder httpRequestBuilder) {
        httpRetryModifyRequestContext.getClass();
        httpRequestBuilder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean noRetry$lambda$0(HttpRetryShouldRetryContext httpRetryShouldRetryContext, HttpRequest httpRequest, HttpResponse httpResponse) {
        httpRetryShouldRetryContext.getClass();
        httpRequest.getClass();
        httpResponse.getClass();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean noRetry$lambda$1(HttpRetryShouldRetryContext httpRetryShouldRetryContext, HttpRequestBuilder httpRequestBuilder, Throwable th) {
        httpRetryShouldRetryContext.getClass();
        httpRequestBuilder.getClass();
        th.getClass();
        return false;
    }

    private final long randomMs(long randomizationMs) {
        if (randomizationMs == 0) {
            return 0L;
        }
        return Random.defaultRandom.nextLong(randomizationMs);
    }

    public static /* synthetic */ void retryIf$default(HttpRequestRetryConfig httpRequestRetryConfig, int i, Function3 function3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        httpRequestRetryConfig.retryIf(i, function3);
    }

    public static /* synthetic */ void retryOnException$default(HttpRequestRetryConfig httpRequestRetryConfig, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        httpRequestRetryConfig.retryOnException(i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean retryOnException$lambda$0(boolean z, HttpRetryShouldRetryContext httpRetryShouldRetryContext, HttpRequestBuilder httpRequestBuilder, Throwable th) {
        httpRetryShouldRetryContext.getClass();
        httpRequestBuilder.getClass();
        th.getClass();
        if (HttpRequestRetryKt.isTimeoutException(th)) {
            return z;
        }
        return !(th instanceof CancellationException);
    }

    public static /* synthetic */ void retryOnExceptionIf$default(HttpRequestRetryConfig httpRequestRetryConfig, int i, Function3 function3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        httpRequestRetryConfig.retryOnExceptionIf(i, function3);
    }

    public static /* synthetic */ void retryOnExceptionOrServerErrors$default(HttpRequestRetryConfig httpRequestRetryConfig, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        httpRequestRetryConfig.retryOnExceptionOrServerErrors(i);
    }

    public static /* synthetic */ void retryOnServerErrors$default(HttpRequestRetryConfig httpRequestRetryConfig, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        httpRequestRetryConfig.retryOnServerErrors(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean retryOnServerErrors$lambda$0(HttpRetryShouldRetryContext httpRetryShouldRetryContext, HttpRequest httpRequest, HttpResponse httpResponse) {
        httpRetryShouldRetryContext.getClass();
        httpRequest.getClass();
        httpResponse.getClass();
        int value = httpResponse.getStatus().getValue();
        return 500 <= value && value < 600;
    }

    public final void constantDelay(long millis, long randomizationMs, boolean respectRetryAfterHeader) {
        if (millis <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
        } else if (randomizationMs >= 0) {
            delayMillis(respectRetryAfterHeader, new HttpRequestRetryConfig$$ExternalSyntheticLambda4(millis, this, randomizationMs));
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
        }
    }

    public final void delay(Function2 block) {
        block.getClass();
        this.delay = block;
    }

    public final void delayMillis(boolean respectRetryAfterHeader, Function2 block) {
        block.getClass();
        setDelayMillis$ktor_client_core(new HttpRequestRetryConfig$$ExternalSyntheticLambda5(respectRetryAfterHeader, block));
    }

    public final void exponentialDelay(final double base, final long baseDelayMs, final long maxDelayMs, final long randomizationMs, boolean respectRetryAfterHeader) {
        if (base <= 0.0d) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
            return;
        }
        if (baseDelayMs <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
            return;
        }
        if (maxDelayMs <= 0) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
        } else if (randomizationMs >= 0) {
            delayMillis(respectRetryAfterHeader, new Function2() { // from class: io.ktor.client.plugins.HttpRequestRetryConfig$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    int iIntValue = ((Integer) obj2).intValue();
                    return Long.valueOf(HttpRequestRetryConfig.exponentialDelay$lambda$0(base, baseDelayMs, maxDelayMs, this, randomizationMs, (HttpRetryDelayContext) obj, iIntValue));
                }
            });
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Check failed.");
        }
    }

    /* JADX INFO: renamed from: getDelay$ktor_client_core, reason: from getter */
    public final Function2 getDelay() {
        return this.delay;
    }

    public final Function2 getDelayMillis$ktor_client_core() {
        Function2 function2 = this.delayMillis;
        if (function2 != null) {
            return function2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("delayMillis");
        throw null;
    }

    public final int getMaxRetries() {
        return this.maxRetries;
    }

    public final Function2 getModifyRequest() {
        return this.modifyRequest;
    }

    public final Function3 getRetryIf() {
        if (this.shouldRetry != null) {
            return getShouldRetry$ktor_client_core();
        }
        return null;
    }

    public final Function3 getRetryOnExceptionIf() {
        if (this.shouldRetryOnException != null) {
            return getShouldRetryOnException$ktor_client_core();
        }
        return null;
    }

    public final Function3 getShouldRetry$ktor_client_core() {
        Function3 function3 = this.shouldRetry;
        if (function3 != null) {
            return function3;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shouldRetry");
        throw null;
    }

    public final Function3 getShouldRetryOnException$ktor_client_core() {
        Function3 function3 = this.shouldRetryOnException;
        if (function3 != null) {
            return function3;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shouldRetryOnException");
        throw null;
    }

    public final void modifyRequest(Function2 block) {
        block.getClass();
        this.modifyRequest = block;
    }

    public final void noRetry() {
        this.maxRetries = 0;
        setShouldRetry$ktor_client_core(new HttpRequestRetryConfig$$ExternalSyntheticLambda1((byte) 0));
        setShouldRetryOnException$ktor_client_core(new HttpRequestRetryConfig$$ExternalSyntheticLambda1((byte) 1));
    }

    public final void retryIf(int maxRetries, Function3 block) {
        block.getClass();
        if (maxRetries != -1) {
            this.maxRetries = maxRetries;
        }
        setShouldRetry$ktor_client_core(block);
    }

    public final void retryOnException(int maxRetries, final boolean retryOnTimeout) {
        retryOnExceptionIf(maxRetries, new Function3() { // from class: io.ktor.client.plugins.HttpRequestRetryConfig$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return Boolean.valueOf(HttpRequestRetryConfig.retryOnException$lambda$0(retryOnTimeout, (HttpRetryShouldRetryContext) obj, (HttpRequestBuilder) obj2, (Throwable) obj3));
            }
        });
    }

    public final void retryOnExceptionIf(int maxRetries, Function3 block) {
        block.getClass();
        if (maxRetries != -1) {
            this.maxRetries = maxRetries;
        }
        setShouldRetryOnException$ktor_client_core(block);
    }

    public final void retryOnExceptionOrServerErrors(int maxRetries) {
        retryOnServerErrors(maxRetries);
        retryOnException$default(this, maxRetries, false, 2, null);
    }

    public final void retryOnServerErrors(int maxRetries) {
        retryIf(maxRetries, new HttpRequestRetryConfig$$ExternalSyntheticLambda1((byte) 2));
    }

    public final void setDelay$ktor_client_core(Function2 function2) {
        function2.getClass();
        this.delay = function2;
    }

    public final void setDelayMillis$ktor_client_core(Function2 function2) {
        function2.getClass();
        this.delayMillis = function2;
    }

    public final void setMaxRetries(int i) {
        this.maxRetries = i;
    }

    public final void setShouldRetry$ktor_client_core(Function3 function3) {
        function3.getClass();
        this.shouldRetry = function3;
    }

    public final void setShouldRetryOnException$ktor_client_core(Function3 function3) {
        function3.getClass();
        this.shouldRetryOnException = function3;
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.HttpRequestRetryConfig$delay$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.HttpRequestRetryConfig$delay$1", f = "HttpRequestRetry.kt", l = {42}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        /* synthetic */ long J$0;
        int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.J$0 = ((Number) obj).longValue();
            return anonymousClass1;
        }

        public final Object invoke(long j, Continuation continuation) {
            return ((AnonymousClass1) create(Long.valueOf(j), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            long j = this.J$0;
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.J$0 = j;
                this.label = 1;
                Object objDelay = AwaitKt.delay(j, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objDelay == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Number) obj).longValue(), (Continuation) obj2);
        }
    }
}
