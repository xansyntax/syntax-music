package io.ktor.http;

import io.ktor.http.auth.HttpAuthHeader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\u000f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\r\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0010\u001a\u0019\u0010\u0013\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012*\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0013\u0010\u0015\u001a\u0004\u0018\u00010\n*\u00020\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001a*\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u001d¢\u0006\u0004\b\u0004\u0010\u001e\u001a\u0019\u0010\u0013\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012*\u00020\u001d¢\u0006\u0004\b\u0013\u0010\u001f\u001a\u0013\u0010\u0015\u001a\u0004\u0018\u00010\n*\u00020\u001d¢\u0006\u0004\b\u0015\u0010 \u001a\u0019\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u001d¢\u0006\u0004\b\u0018\u0010!\u001a\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001a*\u00020\u001d¢\u0006\u0004\b\u001b\u0010\"\u001a\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u0017*\u00020\u001d¢\u0006\u0004\b$\u0010!\u001a\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u0017*\u00020\u0000¢\u0006\u0004\b%\u0010\u0019\u001a\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0017*\u00020\u001d¢\u0006\u0004\b'\u0010!\u001a\u0019\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0\u0017*\u00020\nH\u0000¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lio/ktor/http/HttpMessageBuilder;", "Lio/ktor/http/ContentType;", LinkHeader.Parameters.Type, "", "contentType", "(Lio/ktor/http/HttpMessageBuilder;Lio/ktor/http/ContentType;)V", "", "seconds", "maxAge", "(Lio/ktor/http/HttpMessageBuilder;I)V", "", "value", "ifNoneMatch", "(Lio/ktor/http/HttpMessageBuilder;Ljava/lang/String;)V", "content", "userAgent", "(Lio/ktor/http/HttpMessageBuilder;)Lio/ktor/http/ContentType;", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "(Lio/ktor/http/HttpMessageBuilder;)Ljava/nio/charset/Charset;", "etag", "(Lio/ktor/http/HttpMessageBuilder;)Ljava/lang/String;", "", "vary", "(Lio/ktor/http/HttpMessageBuilder;)Ljava/util/List;", "", "contentLength", "(Lio/ktor/http/HttpMessageBuilder;)Ljava/lang/Long;", "Lio/ktor/http/HttpMessage;", "(Lio/ktor/http/HttpMessage;)Lio/ktor/http/ContentType;", "(Lio/ktor/http/HttpMessage;)Ljava/nio/charset/Charset;", "(Lio/ktor/http/HttpMessage;)Ljava/lang/String;", "(Lio/ktor/http/HttpMessage;)Ljava/util/List;", "(Lio/ktor/http/HttpMessage;)Ljava/lang/Long;", "Lio/ktor/http/Cookie;", "setCookie", "cookies", "Lio/ktor/http/HeaderValue;", "cacheControl", "splitSetCookieHeader", "(Ljava/lang/String;)Ljava/util/List;", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpMessagePropertiesKt {
    public static final List<HeaderValue> cacheControl(HttpMessage httpMessage) {
        List<HeaderValue> headerValue;
        httpMessage.getClass();
        String str = httpMessage.getHeaders().get(HttpHeaders.CacheControl);
        return (str == null || (headerValue = HttpHeaderValueParserKt.parseHeaderValue(str)) == null) ? EmptyList.INSTANCE : headerValue;
    }

    public static final Charset charset(HttpMessageBuilder httpMessageBuilder) {
        httpMessageBuilder.getClass();
        ContentType contentType = contentType(httpMessageBuilder);
        if (contentType != null) {
            return ContentTypesKt.charset(contentType);
        }
        return null;
    }

    public static final Long contentLength(HttpMessageBuilder httpMessageBuilder) {
        httpMessageBuilder.getClass();
        String str = httpMessageBuilder.getHeaders().get(HttpHeaders.ContentLength);
        if (str != null) {
            return StringsKt__StringsJVMKt.toLongOrNull(10, str);
        }
        return null;
    }

    public static final ContentType contentType(HttpMessageBuilder httpMessageBuilder) {
        httpMessageBuilder.getClass();
        String str = httpMessageBuilder.getHeaders().get(HttpHeaders.ContentType);
        if (str != null) {
            return ContentType.INSTANCE.parse(str);
        }
        return null;
    }

    public static final List<Cookie> cookies(HttpMessageBuilder httpMessageBuilder) {
        httpMessageBuilder.getClass();
        List<String> all = httpMessageBuilder.getHeaders().getAll(HttpHeaders.SetCookie);
        if (all == null) {
            return EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(all, 10));
        Iterator<T> it = all.iterator();
        while (it.hasNext()) {
            arrayList.add(CookieKt.parseServerSetCookieHeader((String) it.next()));
        }
        return arrayList;
    }

    public static final String etag(HttpMessageBuilder httpMessageBuilder) {
        httpMessageBuilder.getClass();
        return httpMessageBuilder.getHeaders().get(HttpHeaders.ETag);
    }

    public static final void ifNoneMatch(HttpMessageBuilder httpMessageBuilder, String str) {
        httpMessageBuilder.getClass();
        str.getClass();
        httpMessageBuilder.getHeaders().set(HttpHeaders.IfNoneMatch, str);
    }

    public static final void maxAge(HttpMessageBuilder httpMessageBuilder, int i) {
        httpMessageBuilder.getClass();
        httpMessageBuilder.getHeaders().append(HttpHeaders.CacheControl, "max-age=" + i);
    }

    public static final List<Cookie> setCookie(HttpMessage httpMessage) {
        httpMessage.getClass();
        List<String> all = httpMessage.getHeaders().getAll(HttpHeaders.SetCookie);
        if (all == null) {
            return EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = all.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(splitSetCookieHeader((String) it.next()), arrayList);
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            arrayList2.add(CookieKt.parseServerSetCookieHeader((String) obj));
        }
        return arrayList2;
    }

    public static final List<String> splitSetCookieHeader(String str) {
        int i;
        str.getClass();
        int i2 = 0;
        int iIndexOf$default = StringsKt.indexOf$default(str, ',', 0, 6);
        if (iIndexOf$default == -1) {
            return CollectionsKt__IterablesKt.listOf(str);
        }
        ArrayList arrayList = new ArrayList();
        int iIndexOf$default2 = StringsKt.indexOf$default(str, '=', iIndexOf$default, 4);
        int iIndexOf$default3 = StringsKt.indexOf$default(str, ';', iIndexOf$default, 4);
        while (i2 < str.length() && iIndexOf$default > 0) {
            if (iIndexOf$default2 < iIndexOf$default) {
                iIndexOf$default2 = StringsKt.indexOf$default(str, '=', iIndexOf$default, 4);
            }
            int iIndexOf$default4 = StringsKt.indexOf$default(str, ',', iIndexOf$default + 1, 4);
            while (true) {
                int i3 = iIndexOf$default4;
                i = iIndexOf$default;
                iIndexOf$default = i3;
                if (iIndexOf$default < 0 || iIndexOf$default >= iIndexOf$default2) {
                    break;
                }
                iIndexOf$default4 = StringsKt.indexOf$default(str, ',', iIndexOf$default + 1, 4);
            }
            if (iIndexOf$default3 < i) {
                iIndexOf$default3 = StringsKt.indexOf$default(str, ';', i, 4);
            }
            if (iIndexOf$default2 < 0) {
                arrayList.add(str.substring(i2));
                return arrayList;
            }
            if (iIndexOf$default3 == -1 || iIndexOf$default3 > iIndexOf$default2) {
                arrayList.add(str.substring(i2, i));
                i2 = i + 1;
            }
        }
        if (i2 < str.length()) {
            arrayList.add(str.substring(i2));
        }
        return arrayList;
    }

    public static final void userAgent(HttpMessageBuilder httpMessageBuilder, String str) {
        httpMessageBuilder.getClass();
        str.getClass();
        httpMessageBuilder.getHeaders().set(HttpHeaders.UserAgent, str);
    }

    public static final List<String> vary(HttpMessageBuilder httpMessageBuilder) {
        httpMessageBuilder.getClass();
        List<String> all = httpMessageBuilder.getHeaders().getAll(HttpHeaders.Vary);
        if (all == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = all.iterator();
        while (it.hasNext()) {
            List listSplit$default = StringsKt.split$default((String) it.next(), new String[]{","}, 0, 6);
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
            Iterator it2 = listSplit$default.iterator();
            while (it2.hasNext()) {
                arrayList2.add(StringsKt.trim((String) it2.next()).toString());
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, arrayList);
        }
        return arrayList;
    }

    public static final String etag(HttpMessage httpMessage) {
        httpMessage.getClass();
        return httpMessage.getHeaders().get(HttpHeaders.ETag);
    }

    public static final Charset charset(HttpMessage httpMessage) {
        httpMessage.getClass();
        ContentType contentType = contentType(httpMessage);
        if (contentType != null) {
            return ContentTypesKt.charset(contentType);
        }
        return null;
    }

    public static final Long contentLength(HttpMessage httpMessage) {
        httpMessage.getClass();
        String str = httpMessage.getHeaders().get(HttpHeaders.ContentLength);
        if (str != null) {
            return StringsKt__StringsJVMKt.toLongOrNull(10, str);
        }
        return null;
    }

    public static final void contentType(HttpMessageBuilder httpMessageBuilder, ContentType contentType) {
        httpMessageBuilder.getClass();
        contentType.getClass();
        httpMessageBuilder.getHeaders().set(HttpHeaders.ContentType, contentType.toString());
    }

    public static final ContentType contentType(HttpMessage httpMessage) {
        httpMessage.getClass();
        String str = httpMessage.getHeaders().get(HttpHeaders.ContentType);
        if (str != null) {
            return ContentType.INSTANCE.parse(str);
        }
        return null;
    }

    public static final List<String> vary(HttpMessage httpMessage) {
        httpMessage.getClass();
        List<String> all = httpMessage.getHeaders().getAll(HttpHeaders.Vary);
        if (all == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = all.iterator();
        while (it.hasNext()) {
            List listSplit$default = StringsKt.split$default((String) it.next(), new String[]{","}, 0, 6);
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
            Iterator it2 = listSplit$default.iterator();
            while (it2.hasNext()) {
                arrayList2.add(StringsKt.trim((String) it2.next()).toString());
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, arrayList);
        }
        return arrayList;
    }
}
