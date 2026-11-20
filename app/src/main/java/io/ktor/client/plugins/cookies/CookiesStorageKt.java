package io.ktor.client.plugins.cookies;

import io.ktor.http.Cookie;
import io.ktor.http.IpParserKt;
import io.ktor.http.URLProtocolKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.TextKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a$\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\u000b\u001a\u00020\n*\u00020\u00032\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\r\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/cookies/CookiesStorage;", "", "urlString", "Lio/ktor/http/Cookie;", "cookie", "", "addCookie", "(Lio/ktor/client/plugins/cookies/CookiesStorage;Ljava/lang/String;Lio/ktor/http/Cookie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/Url;", "requestUrl", "", "matches", "(Lio/ktor/http/Cookie;Lio/ktor/http/Url;)Z", "fillDefaults", "(Lio/ktor/http/Cookie;Lio/ktor/http/Url;)Lio/ktor/http/Cookie;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class CookiesStorageKt {
    public static final Object addCookie(CookiesStorage cookiesStorage, String str, Cookie cookie, Continuation continuation) {
        Object objAddCookie = cookiesStorage.addCookie(URLUtilsKt.Url(str), cookie, continuation);
        return objAddCookie == CoroutineSingletons.COROUTINE_SUSPENDED ? objAddCookie : Unit.INSTANCE;
    }

    public static final Cookie fillDefaults(Cookie cookie, Url url) {
        cookie.getClass();
        url.getClass();
        String path = cookie.getPath();
        if (path == null || !StringsKt__StringsJVMKt.startsWith(path, "/", false)) {
            cookie = Cookie.copy$default(cookie, null, null, null, null, null, null, url.getEncodedPath(), false, false, null, 959, null);
        }
        Cookie cookie2 = cookie;
        String domain = cookie2.getDomain();
        return (domain == null || StringsKt.isBlank(domain)) ? Cookie.copy$default(cookie2, null, null, null, null, null, url.getHost(), null, false, false, null, 991, null) : cookie2;
    }

    public static final boolean matches(Cookie cookie, Url url) {
        String lowerCasePreservingASCIIRules;
        CharSequence charSequenceSubSequence;
        cookie.getClass();
        url.getClass();
        String domain = cookie.getDomain();
        if (domain != null && (lowerCasePreservingASCIIRules = TextKt.toLowerCasePreservingASCIIRules(domain)) != null) {
            char[] cArr = {'.'};
            int length = lowerCasePreservingASCIIRules.length();
            int i = 0;
            while (true) {
                if (i >= length) {
                    charSequenceSubSequence = "";
                    break;
                }
                if (!ArraysKt.contains(cArr, lowerCasePreservingASCIIRules.charAt(i))) {
                    charSequenceSubSequence = lowerCasePreservingASCIIRules.subSequence(i, lowerCasePreservingASCIIRules.length());
                    break;
                }
                i++;
            }
            String string = charSequenceSubSequence.toString();
            if (string != null) {
                cookie.getPath();
                String path = cookie.getPath();
                if (path == null) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Path field should have the default value");
                    return false;
                }
                if (!StringsKt.endsWith$default((CharSequence) path, '/')) {
                    path = cookie.getPath() + '/';
                }
                String lowerCasePreservingASCIIRules2 = TextKt.toLowerCasePreservingASCIIRules(url.getHost());
                String encodedPath = url.getEncodedPath();
                if (!StringsKt.endsWith$default((CharSequence) encodedPath, '/')) {
                    encodedPath = encodedPath.concat("/");
                }
                return (Intrinsics.areEqual(lowerCasePreservingASCIIRules2, string) || (!IpParserKt.hostIsIp(lowerCasePreservingASCIIRules2) && StringsKt__StringsJVMKt.endsWith(lowerCasePreservingASCIIRules2, ".".concat(string), false))) && (path.equals("/") || encodedPath.equals(path) || StringsKt__StringsJVMKt.startsWith(encodedPath, path, false)) && (!cookie.getSecure() || URLProtocolKt.isSecure(url.getProtocol()));
            }
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Domain field should have the default value");
        return false;
    }
}
