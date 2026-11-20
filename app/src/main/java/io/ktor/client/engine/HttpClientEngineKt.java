package io.ktor.client.engine;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.HttpHeaders;
import io.ktor.http.UnsafeHeaderException;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001c\u0010\f\u001a\u00020\u000b*\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0080@¢\u0006\u0004\b\f\u0010\r\u001a\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\"\u001a\u0010\u0013\u001a\u00020\u00128\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"$\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lio/ktor/client/engine/HttpClientEngineConfig;", "T", "Lio/ktor/client/engine/HttpClientEngineFactory;", "Lkotlin/Function1;", "", "nested", "config", "(Lio/ktor/client/engine/HttpClientEngineFactory;Lkotlin/jvm/functions/Function1;)Lio/ktor/client/engine/HttpClientEngineFactory;", "Lio/ktor/client/engine/HttpClientEngine;", "Lkotlinx/coroutines/Job;", "parentJob", "Lkotlin/coroutines/CoroutineContext;", "createCallContext", "(Lio/ktor/client/engine/HttpClientEngine;Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/request/HttpRequestData;", "request", "validateHeaders", "(Lio/ktor/client/request/HttpRequestData;)V", "Lkotlinx/coroutines/CoroutineName;", "CALL_COROUTINE", "Lkotlinx/coroutines/CoroutineName;", "getCALL_COROUTINE", "()Lkotlinx/coroutines/CoroutineName;", "Lio/ktor/util/AttributeKey;", "Lio/ktor/client/HttpClientConfig;", "CLIENT_CONFIG", "Lio/ktor/util/AttributeKey;", "getCLIENT_CONFIG", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpClientEngineKt {
    private static final CoroutineName CALL_COROUTINE = new CoroutineName("call-context");
    private static final AttributeKey<HttpClientConfig<?>> CLIENT_CONFIG;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: io.ktor.client.engine.HttpClientEngineKt$config$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"io/ktor/client/engine/HttpClientEngineKt$config$1", "Lio/ktor/client/engine/HttpClientEngineFactory;", "Lkotlin/Function1;", "", "block", "Lio/ktor/client/engine/HttpClientEngine;", "create", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/engine/HttpClientEngine;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1<T> implements HttpClientEngineFactory<T> {
        final /* synthetic */ Function1 $nested;
        final /* synthetic */ HttpClientEngineFactory<T> $parent;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(HttpClientEngineFactory<? extends T> httpClientEngineFactory, Function1 function1) {
            this.$parent = httpClientEngineFactory;
            this.$nested = function1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit create$lambda$0(Function1 function1, Function1 function2, HttpClientEngineConfig httpClientEngineConfig) {
            httpClientEngineConfig.getClass();
            function1.invoke(httpClientEngineConfig);
            function2.invoke(httpClientEngineConfig);
            return Unit.INSTANCE;
        }

        @Override // io.ktor.client.engine.HttpClientEngineFactory
        public HttpClientEngine create(Function1 block) {
            block.getClass();
            return this.$parent.create(new UtilsKt$$ExternalSyntheticLambda0(this.$nested, block, (byte) 2));
        }
    }

    static {
        TypeReference typeReferenceTypeOf;
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(HttpClientConfig.class);
        try {
            typeReferenceTypeOf = Reflection.typeOf(HttpClientConfig.class, KTypeProjection.INSTANCE.getSTAR());
        } catch (Throwable unused) {
            typeReferenceTypeOf = null;
        }
        CLIENT_CONFIG = new AttributeKey<>("client-config", new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf));
    }

    public static final <T extends HttpClientEngineConfig> HttpClientEngineFactory<T> config(HttpClientEngineFactory<? extends T> httpClientEngineFactory, Function1 function1) {
        httpClientEngineFactory.getClass();
        function1.getClass();
        return new AnonymousClass1(httpClientEngineFactory, function1);
    }

    public static final Object createCallContext(HttpClientEngine httpClientEngine, Job job, Continuation continuation) {
        JobImpl jobImpl = new JobImpl(job);
        CoroutineContext coroutineContextPlus = httpClientEngine.getCoroutineContext().plus(jobImpl).plus(CALL_COROUTINE);
        Job job2 = (Job) continuation.getContext().get(Job.Key.$$INSTANCE);
        if (job2 == null) {
            return coroutineContextPlus;
        }
        jobImpl.invokeOnCompletion(new UtilsKt.AnonymousClass2(job2.invokeOnCompletion(true, true, new UtilsKt$attachToUserJob$cleanupHandler$1(jobImpl))));
        return coroutineContextPlus;
    }

    public static final CoroutineName getCALL_COROUTINE() {
        return CALL_COROUTINE;
    }

    public static final AttributeKey<HttpClientConfig<?>> getCLIENT_CONFIG() {
        return CLIENT_CONFIG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateHeaders(HttpRequestData httpRequestData) {
        Set<String> setNames = httpRequestData.getHeaders().names();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setNames) {
            if (HttpHeaders.INSTANCE.getUnsafeHeadersList().contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            throw new UnsafeHeaderException(arrayList.toString());
        }
    }
}
