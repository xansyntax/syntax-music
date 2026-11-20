package io.ktor.client.plugins.cookies;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.http.ContentDisposition;
import io.ktor.http.Cookie;
import io.ktor.http.CookieKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\u0002\u0010\t\u001a\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\u00020\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0002\u0010\u000b\u001a$\u0010\r\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\f\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\r\u0010\u000e\"\u0018\u0010\u0011\u001a\u00060\u000fj\u0002`\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"", "Lio/ktor/http/Cookie;", "cookies", "", "renderClientCookies", "(Ljava/util/List;)Ljava/lang/String;", "Lio/ktor/client/HttpClient;", "Lio/ktor/http/Url;", "url", "(Lio/ktor/client/HttpClient;Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urlString", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ContentDisposition.Parameters.Name, "get", "(Ljava/util/List;Ljava/lang/String;)Lio/ktor/http/Cookie;", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpCookiesKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpCookies");

    /* JADX INFO: renamed from: io.ktor.client.plugins.cookies.HttpCookiesKt$cookies$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookiesKt", f = "HttpCookies.kt", l = {150}, m = "cookies", v = 1)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCookiesKt.cookies((HttpClient) null, (Url) null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cookies.HttpCookiesKt$cookies$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookiesKt", f = "HttpCookies.kt", l = {158}, m = "cookies", v = 1)
    public static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCookiesKt.cookies((HttpClient) null, (String) null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.plugins.cookies.HttpCookiesKt$renderClientCookies$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class C02541 extends FunctionReferenceImpl implements Function1 {
        public static final C02541 INSTANCE = new C02541();

        public C02541() {
            super(1, CookieKt.class, "renderCookieHeader", "renderCookieHeader(Lio/ktor/http/Cookie;)Ljava/lang/String;", 1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(Cookie cookie) {
            cookie.getClass();
            return CookieKt.renderCookieHeader(cookie);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object cookies(HttpClient httpClient, String str, Continuation continuation) {
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
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            HttpCookies httpCookies = (HttpCookies) HttpClientPluginKt.pluginOrNull(httpClient, HttpCookies.INSTANCE);
            if (httpCookies != null) {
                Url Url = URLUtilsKt.Url(str);
                anonymousClass2.L$0 = null;
                anonymousClass2.L$1 = null;
                anonymousClass2.label = 1;
                obj = httpCookies.get(Url, anonymousClass2);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return EmptyList.INSTANCE;
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        List list = (List) obj;
        if (list != null) {
            return list;
        }
        return EmptyList.INSTANCE;
    }

    public static final Cookie get(List<Cookie> list, String str) {
        Object next;
        list.getClass();
        str.getClass();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.areEqual(((Cookie) next).getName(), str)) {
                return (Cookie) next;
            }
        }
        next = null;
        return (Cookie) next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String renderClientCookies(List<Cookie> list) {
        return CollectionsKt.joinToString$default(list, "; ", null, null, C02541.INSTANCE, 30);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object cookies(HttpClient httpClient, Url url, Continuation continuation) {
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
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            HttpCookies httpCookies = (HttpCookies) HttpClientPluginKt.pluginOrNull(httpClient, HttpCookies.INSTANCE);
            if (httpCookies != null) {
                anonymousClass1.L$0 = null;
                anonymousClass1.L$1 = null;
                anonymousClass1.label = 1;
                obj = httpCookies.get(url, anonymousClass1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return EmptyList.INSTANCE;
        }
        if (i2 != 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        List list = (List) obj;
        if (list != null) {
            return list;
        }
        return EmptyList.INSTANCE;
    }
}
