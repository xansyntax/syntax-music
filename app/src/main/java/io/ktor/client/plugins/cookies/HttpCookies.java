package io.ktor.client.plugins.cookies;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.Cookie;
import io.ktor.http.CookieEncoding;
import io.ktor.http.CookieKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.Url;
import io.ktor.util.AttributeKey;
import io.ktor.util.date.GMTDate;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.KtorDsl;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00060\u0001j\u0002`\u0002:\u0002'&B;\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012(\u0010\n\u001a$\u0012 \u0012\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00060\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0080@¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0080@¢\u0006\u0004\b\u0017\u0010\u0015J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0080@¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010 R6\u0010\n\u001a$\u0012 \u0012\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010!R\u001a\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b#\u0010$\u0012\u0004\b%\u0010\u001f¨\u0006("}, d2 = {"Lio/ktor/client/plugins/cookies/HttpCookies;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "storage", "", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "defaults", "<init>", "(Lio/ktor/client/plugins/cookies/CookiesStorage;Ljava/util/List;)V", "Lio/ktor/http/Url;", "requestUrl", "Lio/ktor/http/Cookie;", "get", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/request/HttpRequestBuilder;", "builder", "captureHeaderCookies$ktor_client_core", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "captureHeaderCookies", "sendCookiesWith$ktor_client_core", "sendCookiesWith", "Lio/ktor/client/statement/HttpResponse;", "response", "saveCookiesFrom$ktor_client_core", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveCookiesFrom", "close", "()V", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "Ljava/util/List;", "Lkotlinx/coroutines/Job;", "initializer", "Lkotlinx/coroutines/Job;", "getInitializer$annotations", "Companion", "Config", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HttpCookies implements Closeable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(0 == true ? 1 : 0);
    private static final AttributeKey<HttpCookies> key;
    private final List<Function2> defaults;
    private final Job initializer;
    private final CookiesStorage storage;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @KtorDsl
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\t\u001a\u00020\u00072\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\f\u0010\rR6\u0010\u0010\u001a$\u0012 \u0012\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lio/ktor/client/plugins/cookies/HttpCookies$Config;", "", "<init>", "()V", "Lkotlin/Function2;", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "Lkotlin/coroutines/Continuation;", "", "block", "default", "(Lkotlin/jvm/functions/Function2;)V", "Lio/ktor/client/plugins/cookies/HttpCookies;", "build$ktor_client_core", "()Lio/ktor/client/plugins/cookies/HttpCookies;", "build", "", "defaults", "Ljava/util/List;", "storage", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "getStorage", "()Lio/ktor/client/plugins/cookies/CookiesStorage;", "setStorage", "(Lio/ktor/client/plugins/cookies/CookiesStorage;)V", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Config {
        private final List<Function2> defaults = new ArrayList();
        private CookiesStorage storage = new AcceptAllCookiesStorage(null, 1, 0 == true ? 1 : 0);

        public final HttpCookies build$ktor_client_core() {
            return new HttpCookies(this.storage, this.defaults);
        }

        /* JADX INFO: renamed from: default, reason: not valid java name */
        public final void m1586default(Function2 block) {
            block.getClass();
            this.defaults.add(block);
        }

        public final CookiesStorage getStorage() {
            return this.storage;
        }

        public final void setStorage(CookiesStorage cookiesStorage) {
            cookiesStorage.getClass();
            this.storage = cookiesStorage;
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cookies.HttpCookies$get$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookies", f = "HttpCookies.kt", l = {43, 44}, m = "get", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCookies.this.get(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        TypeReference typeReferenceTypeOf = null;
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(HttpCookies.class);
        try {
            typeReferenceTypeOf = Reflection.typeOf(HttpCookies.class);
        } catch (Throwable unused) {
        }
        key = new AttributeKey<>("HttpCookies", new TypeInfo((KClass<?>) orCreateKotlinClass, false, (KType) typeReferenceTypeOf));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpCookies(CookiesStorage cookiesStorage, List<? extends Function2> list) {
        cookiesStorage.getClass();
        list.getClass();
        this.storage = cookiesStorage;
        this.defaults = list;
        this.initializer = AwaitKt.launch$default(GlobalScope.INSTANCE, Dispatchers.Unconfined, null, new HttpCookies$initializer$1(this, null), 2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object captureHeaderCookies$ktor_client_core(HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        HttpCookies$captureHeaderCookies$1 httpCookies$captureHeaderCookies$1;
        ArrayList arrayList;
        Url url;
        Iterator it;
        int i;
        int i2;
        if (continuation instanceof HttpCookies$captureHeaderCookies$1) {
            httpCookies$captureHeaderCookies$1 = (HttpCookies$captureHeaderCookies$1) continuation;
            int i3 = httpCookies$captureHeaderCookies$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                httpCookies$captureHeaderCookies$1.label = i3 - Integer.MIN_VALUE;
            } else {
                httpCookies$captureHeaderCookies$1 = new HttpCookies$captureHeaderCookies$1(this, continuation);
            }
        } else {
            httpCookies$captureHeaderCookies$1 = new HttpCookies$captureHeaderCookies$1(this, continuation);
        }
        Object obj = httpCookies$captureHeaderCookies$1.result;
        int i4 = httpCookies$captureHeaderCookies$1.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            Url urlBuild = URLBuilderKt.clone(httpRequestBuilder.getUrl()).build();
            String str = httpRequestBuilder.getHeaders().get(HttpHeaders.Cookie);
            if (str != null) {
                Logger logger = HttpCookiesKt.LOGGER;
                if (LoggerJvmKt.isTraceEnabled(logger)) {
                    StringBuilder sbM4m = IntIntPair$$ExternalSyntheticOutline0.m4m("Saving cookie ", str, " for ");
                    sbM4m.append(httpRequestBuilder.getUrl());
                    logger.trace(sbM4m.toString());
                }
                Map clientCookiesHeader$default = CookieKt.parseClientCookiesHeader$default(str, false, 2, null);
                arrayList = new ArrayList(clientCookiesHeader$default.size());
                for (Map.Entry entry : clientCookiesHeader$default.entrySet()) {
                    arrayList.add(new Cookie((String) entry.getKey(), (String) entry.getValue(), CookieEncoding.RAW, (Integer) null, (GMTDate) null, (String) null, (String) null, false, false, (Map) null, 1016, (DefaultConstructorMarker) null));
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                url = urlBuild;
                it = arrayList.iterator();
                i = 0;
                i2 = 0;
            }
            return Unit.INSTANCE;
        }
        if (i4 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        i = httpCookies$captureHeaderCookies$1.I$1;
        i2 = httpCookies$captureHeaderCookies$1.I$0;
        it = (Iterator) httpCookies$captureHeaderCookies$1.L$4;
        url = (Url) httpCookies$captureHeaderCookies$1.L$2;
        ResultKt.throwOnFailure(obj);
        while (it.hasNext()) {
            Cookie cookie = (Cookie) it.next();
            CookiesStorage cookiesStorage = this.storage;
            httpCookies$captureHeaderCookies$1.L$0 = null;
            httpCookies$captureHeaderCookies$1.L$1 = null;
            httpCookies$captureHeaderCookies$1.L$2 = url;
            httpCookies$captureHeaderCookies$1.L$3 = null;
            httpCookies$captureHeaderCookies$1.L$4 = it;
            httpCookies$captureHeaderCookies$1.L$5 = null;
            httpCookies$captureHeaderCookies$1.L$6 = null;
            httpCookies$captureHeaderCookies$1.L$7 = null;
            httpCookies$captureHeaderCookies$1.I$0 = i2;
            httpCookies$captureHeaderCookies$1.I$1 = i;
            httpCookies$captureHeaderCookies$1.I$2 = 0;
            httpCookies$captureHeaderCookies$1.label = 1;
            Object objAddCookie = cookiesStorage.addCookie(url, cookie, httpCookies$captureHeaderCookies$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAddCookie == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.storage.close();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object get(Url url, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Job job = this.initializer;
            anonymousClass1.L$0 = url;
            anonymousClass1.label = 1;
            if (job.join(anonymousClass1) != coroutineSingletons) {
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        url = (Url) anonymousClass1.L$0;
        ResultKt.throwOnFailure(obj);
        CookiesStorage cookiesStorage = this.storage;
        anonymousClass1.L$0 = null;
        anonymousClass1.label = 2;
        Object obj2 = cookiesStorage.get(url, anonymousClass1);
        return obj2 == coroutineSingletons ? coroutineSingletons : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object saveCookiesFrom$ktor_client_core(HttpResponse httpResponse, Continuation continuation) {
        HttpCookies$saveCookiesFrom$1 httpCookies$saveCookiesFrom$1;
        Iterator it;
        Url url;
        int i;
        if (continuation instanceof HttpCookies$saveCookiesFrom$1) {
            httpCookies$saveCookiesFrom$1 = (HttpCookies$saveCookiesFrom$1) continuation;
            int i2 = httpCookies$saveCookiesFrom$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                httpCookies$saveCookiesFrom$1.label = i2 - Integer.MIN_VALUE;
            } else {
                httpCookies$saveCookiesFrom$1 = new HttpCookies$saveCookiesFrom$1(this, continuation);
            }
        } else {
            httpCookies$saveCookiesFrom$1 = new HttpCookies$saveCookiesFrom$1(this, continuation);
        }
        Object obj = httpCookies$saveCookiesFrom$1.result;
        int i3 = httpCookies$saveCookiesFrom$1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Url url2 = HttpResponseKt.getRequest(httpResponse).getUrl();
            List<String> all = httpResponse.getHeaders().getAll(HttpHeaders.SetCookie);
            if (all != null) {
                for (String str : all) {
                    Logger logger = HttpCookiesKt.LOGGER;
                    if (LoggerJvmKt.isTraceEnabled(logger)) {
                        StringBuilder sbM4m = IntIntPair$$ExternalSyntheticOutline0.m4m("Received cookie ", str, " in response for ");
                        sbM4m.append(httpResponse.getCall().getRequest().getUrl());
                        logger.trace(sbM4m.toString());
                    }
                }
            }
            it = HttpMessagePropertiesKt.setCookie(httpResponse).iterator();
            url = url2;
            i = 0;
        } else {
            if (i3 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i = httpCookies$saveCookiesFrom$1.I$0;
            it = (Iterator) httpCookies$saveCookiesFrom$1.L$3;
            url = (Url) httpCookies$saveCookiesFrom$1.L$1;
            ResultKt.throwOnFailure(obj);
        }
        while (it.hasNext()) {
            Cookie cookie = (Cookie) it.next();
            CookiesStorage cookiesStorage = this.storage;
            httpCookies$saveCookiesFrom$1.L$0 = null;
            httpCookies$saveCookiesFrom$1.L$1 = url;
            httpCookies$saveCookiesFrom$1.L$2 = null;
            httpCookies$saveCookiesFrom$1.L$3 = it;
            httpCookies$saveCookiesFrom$1.L$4 = null;
            httpCookies$saveCookiesFrom$1.L$5 = null;
            httpCookies$saveCookiesFrom$1.I$0 = i;
            httpCookies$saveCookiesFrom$1.I$1 = 0;
            httpCookies$saveCookiesFrom$1.label = 1;
            Object objAddCookie = cookiesStorage.addCookie(url, cookie, httpCookies$saveCookiesFrom$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objAddCookie == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object sendCookiesWith$ktor_client_core(HttpRequestBuilder httpRequestBuilder, Continuation continuation) {
        HttpCookies$sendCookiesWith$1 httpCookies$sendCookiesWith$1;
        if (continuation instanceof HttpCookies$sendCookiesWith$1) {
            httpCookies$sendCookiesWith$1 = (HttpCookies$sendCookiesWith$1) continuation;
            int i = httpCookies$sendCookiesWith$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                httpCookies$sendCookiesWith$1.label = i - Integer.MIN_VALUE;
            } else {
                httpCookies$sendCookiesWith$1 = new HttpCookies$sendCookiesWith$1(this, continuation);
            }
        } else {
            httpCookies$sendCookiesWith$1 = new HttpCookies$sendCookiesWith$1(this, continuation);
        }
        Object obj = httpCookies$sendCookiesWith$1.result;
        int i2 = httpCookies$sendCookiesWith$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Url urlBuild = URLBuilderKt.clone(httpRequestBuilder.getUrl()).build();
            httpCookies$sendCookiesWith$1.L$0 = httpRequestBuilder;
            httpCookies$sendCookiesWith$1.label = 1;
            obj = get(urlBuild, httpCookies$sendCookiesWith$1);
            Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (obj == obj2) {
                return obj2;
            }
        } else {
            if (i2 != 1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            httpRequestBuilder = (HttpRequestBuilder) httpCookies$sendCookiesWith$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        List list = (List) obj;
        if (list.isEmpty()) {
            httpRequestBuilder.getHeaders().remove(HttpHeaders.Cookie);
        } else {
            String strRenderClientCookies = HttpCookiesKt.renderClientCookies(list);
            httpRequestBuilder.getHeaders().set(HttpHeaders.Cookie, strRenderClientCookies);
            Logger logger = HttpCookiesKt.LOGGER;
            if (LoggerJvmKt.isTraceEnabled(logger)) {
                StringBuilder sbM4m = IntIntPair$$ExternalSyntheticOutline0.m4m("Sending cookie ", strRenderClientCookies, " for ");
                sbM4m.append(httpRequestBuilder.getUrl());
                logger.trace(sbM4m.toString());
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\t\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/client/plugins/cookies/HttpCookies$Companion;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/cookies/HttpCookies$Config;", "Lio/ktor/client/plugins/cookies/HttpCookies;", "<init>", "()V", "Lkotlin/Function1;", "", "block", "prepare", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/cookies/HttpCookies;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "install", "(Lio/ktor/client/plugins/cookies/HttpCookies;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion implements HttpClientPlugin<Config, HttpCookies> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<HttpCookies> getKey() {
            return HttpCookies.key;
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(HttpCookies plugin, HttpClient scope) {
            plugin.getClass();
            scope.getClass();
            scope.getRequestPipeline().intercept(HttpRequestPipeline.INSTANCE.getState(), new HttpCookies$Companion$install$1(plugin, null));
            scope.getSendPipeline().intercept(HttpSendPipeline.INSTANCE.getState(), new HttpCookies$Companion$install$2(plugin, null));
            scope.getReceivePipeline().intercept(HttpReceivePipeline.INSTANCE.getState(), new HttpCookies$Companion$install$3(plugin, null));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public HttpCookies prepare(Function1 block) {
            block.getClass();
            Config config = new Config();
            block.invoke(config);
            return config.build$ktor_client_core();
        }

        private Companion() {
        }
    }

    private static /* synthetic */ void getInitializer$annotations() {
    }
}
