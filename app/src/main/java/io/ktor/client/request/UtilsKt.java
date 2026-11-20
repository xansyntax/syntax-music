package io.ktor.client.request;

import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.Cookie;
import io.ktor.http.CookieEncoding;
import io.ktor.http.CookieKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.util.date.GMTDate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptyMap;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a{\u0010\u0014\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015\u001a#\u0010\u0017\u001a\u00020\u0005*\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0019\u0010\u001b\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001c\u001a!\u0010\u001f\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001¢\u0006\u0004\b\u001f\u0010 \u001a\u0019\u0010\"\u001a\u00020\u0005*\u00020\u00002\u0006\u0010!\u001a\u00020\u0001¢\u0006\u0004\b\"\u0010#\"(\u0010(\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\"(\u0010-\u001a\u00020\t*\u00020\u00162\u0006\u0010\u0004\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006."}, d2 = {"Lio/ktor/http/HttpMessageBuilder;", "", "key", "", "value", "", "header", "(Lio/ktor/http/HttpMessageBuilder;Ljava/lang/String;Ljava/lang/Object;)V", ContentDisposition.Parameters.Name, "", "maxAge", "Lio/ktor/util/date/GMTDate;", "expires", "domain", "path", "", "secure", "httpOnly", "", "extensions", "cookie", "(Lio/ktor/http/HttpMessageBuilder;Ljava/lang/String;Ljava/lang/String;ILio/ktor/util/date/GMTDate;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;)V", "Lio/ktor/client/request/HttpRequestBuilder;", "parameter", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/String;Ljava/lang/Object;)V", "Lio/ktor/http/ContentType;", "contentType", "accept", "(Lio/ktor/http/HttpMessageBuilder;Lio/ktor/http/ContentType;)V", "username", "password", "basicAuth", "(Lio/ktor/http/HttpMessageBuilder;Ljava/lang/String;Ljava/lang/String;)V", "token", "bearerAuth", "(Lio/ktor/http/HttpMessageBuilder;Ljava/lang/String;)V", "getHost", "(Lio/ktor/client/request/HttpRequestBuilder;)Ljava/lang/String;", "setHost", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/String;)V", "host", "getPort", "(Lio/ktor/client/request/HttpRequestBuilder;)I", "setPort", "(Lio/ktor/client/request/HttpRequestBuilder;I)V", "port", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class UtilsKt {
    public static final void accept(HttpMessageBuilder httpMessageBuilder, ContentType contentType) {
        httpMessageBuilder.getClass();
        contentType.getClass();
        httpMessageBuilder.getHeaders().append(HttpHeaders.Accept, contentType.toString());
    }

    public static final void basicAuth(HttpMessageBuilder httpMessageBuilder, String str, String str2) {
        httpMessageBuilder.getClass();
        str.getClass();
        str2.getClass();
        header(httpMessageBuilder, HttpHeaders.Authorization, "Basic ".concat(Base64.encode$default(Base64.Default, StringsKt__StringsJVMKt.encodeToByteArray(str + ':' + str2))));
    }

    public static final void bearerAuth(HttpMessageBuilder httpMessageBuilder, String str) {
        httpMessageBuilder.getClass();
        str.getClass();
        header(httpMessageBuilder, HttpHeaders.Authorization, "Bearer ".concat(str));
    }

    public static final void cookie(HttpMessageBuilder httpMessageBuilder, String str, String str2, int i, GMTDate gMTDate, String str3, String str4, boolean z, boolean z2, Map<String, String> map) {
        httpMessageBuilder.getClass();
        str.getClass();
        str2.getClass();
        map.getClass();
        String strRenderCookieHeader = CookieKt.renderCookieHeader(new Cookie(str, str2, (CookieEncoding) null, Integer.valueOf(i), gMTDate, str3, str4, z, z2, map, 4, (DefaultConstructorMarker) null));
        if (!httpMessageBuilder.getHeaders().contains(HttpHeaders.Cookie)) {
            httpMessageBuilder.getHeaders().append(HttpHeaders.Cookie, strRenderCookieHeader);
            return;
        }
        httpMessageBuilder.getHeaders().set(HttpHeaders.Cookie, httpMessageBuilder.getHeaders().get(HttpHeaders.Cookie) + "; " + strRenderCookieHeader);
    }

    public static /* synthetic */ void cookie$default(HttpMessageBuilder httpMessageBuilder, String str, String str2, int i, GMTDate gMTDate, String str3, String str4, boolean z, boolean z2, Map map, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        if ((i2 & 8) != 0) {
            gMTDate = null;
        }
        if ((i2 & 16) != 0) {
            str3 = null;
        }
        if ((i2 & 32) != 0) {
            str4 = null;
        }
        if ((i2 & 64) != 0) {
            z = false;
        }
        if ((i2 & 128) != 0) {
            z2 = false;
        }
        if ((i2 & 256) != 0) {
            map = EmptyMap.INSTANCE;
        }
        cookie(httpMessageBuilder, str, str2, i, gMTDate, str3, str4, z, z2, map);
    }

    public static final String getHost(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return httpRequestBuilder.getUrl().getHost();
    }

    public static final int getPort(HttpRequestBuilder httpRequestBuilder) {
        httpRequestBuilder.getClass();
        return httpRequestBuilder.getUrl().getPort();
    }

    public static final void header(HttpMessageBuilder httpMessageBuilder, String str, Object obj) {
        httpMessageBuilder.getClass();
        str.getClass();
        if (obj != null) {
            httpMessageBuilder.getHeaders().append(str, obj.toString());
        }
    }

    public static final void parameter(HttpRequestBuilder httpRequestBuilder, String str, Object obj) {
        httpRequestBuilder.getClass();
        str.getClass();
        if (obj != null) {
            httpRequestBuilder.getUrl().getParameters().append(str, obj.toString());
        }
    }

    public static final void setHost(HttpRequestBuilder httpRequestBuilder, String str) {
        httpRequestBuilder.getClass();
        str.getClass();
        httpRequestBuilder.getUrl().setHost(str);
    }

    public static final void setPort(HttpRequestBuilder httpRequestBuilder, int i) {
        httpRequestBuilder.getClass();
        httpRequestBuilder.getUrl().setPort(i);
    }
}
