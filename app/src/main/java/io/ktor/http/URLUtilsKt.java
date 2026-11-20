package io.ktor.http;

import io.ktor.util.StringValuesKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007\u001a!\u0010\u000b\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\r\u0010\u0004\u001a\u0015\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0015\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0011\u001a\u0015\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u0012\u001a\u0019\u0010\u0013\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0019\u0010\u0013\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0015\u001a/\u0010\u001c\u001a\u00020\t*\u00060\u0016j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a-\u0010\u001c\u001a\u00020\t*\u00060\u0016j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010 \u001a+\u0010%\u001a\u00020\t*\u00060!j\u0002`\"2\b\u0010#\u001a\u0004\u0018\u00010\u00002\b\u0010$\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b%\u0010&\"\u0015\u0010)\u001a\u00020\u0000*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b'\u0010(\"\u0015\u0010+\u001a\u00020\u0000*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b*\u0010(\"\u0015\u0010-\u001a\u00020\u0000*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b,\u0010(\"\u0015\u0010.\u001a\u00020\u001a*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b.\u0010/\"\u0015\u00100\u001a\u00020\u001a*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b0\u0010/\"\u0015\u0010.\u001a\u00020\u001a*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b.\u00101\"\u0015\u00100\u001a\u00020\u001a*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00062"}, d2 = {"", "urlString", "Lio/ktor/http/Url;", "Url", "(Ljava/lang/String;)Lio/ktor/http/Url;", "Lio/ktor/http/URLBuilder;", "builder", "(Lio/ktor/http/URLBuilder;)Lio/ktor/http/Url;", "Lkotlin/Function1;", "", "block", "buildUrl", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/http/Url;", "parseUrl", "URLBuilder", "(Ljava/lang/String;)Lio/ktor/http/URLBuilder;", "url", "(Lio/ktor/http/Url;)Lio/ktor/http/URLBuilder;", "(Lio/ktor/http/URLBuilder;)Lio/ktor/http/URLBuilder;", "takeFrom", "(Lio/ktor/http/URLBuilder;Lio/ktor/http/URLBuilder;)Lio/ktor/http/URLBuilder;", "(Lio/ktor/http/URLBuilder;Lio/ktor/http/Url;)Lio/ktor/http/URLBuilder;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "encodedPath", "encodedQuery", "", "trailingQuery", "appendUrlFullPath", "(Ljava/lang/Appendable;Ljava/lang/String;Ljava/lang/String;Z)V", "Lio/ktor/http/ParametersBuilder;", "encodedQueryParameters", "(Ljava/lang/Appendable;Ljava/lang/String;Lio/ktor/http/ParametersBuilder;Z)V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "encodedUser", "encodedPassword", "appendUserAndPassword", "(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V", "getFullPath", "(Lio/ktor/http/Url;)Ljava/lang/String;", "fullPath", "getHostWithPort", "hostWithPort", "getHostWithPortIfSpecified", "hostWithPortIfSpecified", "isAbsolutePath", "(Lio/ktor/http/Url;)Z", "isRelativePath", "(Lio/ktor/http/URLBuilder;)Z", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class URLUtilsKt {
    public static final URLBuilder URLBuilder(String str) {
        str.getClass();
        return URLParserKt.takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), str);
    }

    public static final Url Url(URLBuilder uRLBuilder) {
        uRLBuilder.getClass();
        return takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), uRLBuilder).build();
    }

    public static final void appendUrlFullPath(Appendable appendable, String str, ParametersBuilder parametersBuilder, boolean z) {
        List listListOf;
        appendable.getClass();
        str.getClass();
        parametersBuilder.getClass();
        byte b = 0;
        if (!StringsKt.isBlank(str) && !StringsKt__StringsJVMKt.startsWith(str, "/", false)) {
            appendable.append('/');
        }
        appendable.append(str);
        if (!parametersBuilder.isEmpty() || z) {
            appendable.append("?");
        }
        Set<Map.Entry<String, List<String>>> setEntries = parametersBuilder.entries();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntries.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str2 = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (list.isEmpty()) {
                listListOf = CollectionsKt__IterablesKt.listOf(new Pair(str2, null));
            } else {
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new Pair(str2, (String) it2.next()));
                }
                listListOf = arrayList2;
            }
            CollectionsKt__MutableCollectionsKt.addAll(listListOf, arrayList);
        }
        CollectionsKt.joinTo$default(arrayList, appendable, "&", new URLUtilsKt$$ExternalSyntheticLambda0(b), 60);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence appendUrlFullPath$lambda$1(Pair pair) {
        pair.getClass();
        String str = (String) pair.first;
        Object obj = pair.second;
        if (obj == null) {
            return str;
        }
        return str + '=' + String.valueOf(obj);
    }

    public static final void appendUserAndPassword(StringBuilder sb, String str, String str2) {
        sb.getClass();
        if (str == null) {
            return;
        }
        sb.append(str);
        if (str2 != null) {
            sb.append(':');
            sb.append(str2);
        }
        sb.append("@");
    }

    public static final Url buildUrl(Function1 function1) {
        function1.getClass();
        URLBuilder uRLBuilder = new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null);
        function1.invoke(uRLBuilder);
        return uRLBuilder.build();
    }

    public static final String getFullPath(Url url) throws IOException {
        url.getClass();
        StringBuilder sb = new StringBuilder();
        appendUrlFullPath(sb, url.getEncodedPath(), url.getEncodedQuery(), url.getTrailingQuery());
        return sb.toString();
    }

    public static final String getHostWithPort(Url url) {
        url.getClass();
        return url.getHost() + ':' + url.getPort();
    }

    public static final String getHostWithPortIfSpecified(Url url) {
        url.getClass();
        int specifiedPort = url.getSpecifiedPort();
        return (specifiedPort == 0 || specifiedPort == url.getProtocol().getDefaultPort()) ? url.getHost() : getHostWithPort(url);
    }

    public static final boolean isAbsolutePath(Url url) {
        url.getClass();
        return Intrinsics.areEqual(CollectionsKt.firstOrNull((List) url.getRawSegments()), "");
    }

    public static final boolean isRelativePath(Url url) {
        url.getClass();
        return !isAbsolutePath(url);
    }

    public static final Url parseUrl(String str) {
        str.getClass();
        try {
            URLBuilder URLBuilder = URLBuilder(str);
            if (URLBuilder.getHost().length() <= 0) {
                URLBuilder = null;
            }
            if (URLBuilder != null) {
                return URLBuilder.build();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static final URLBuilder takeFrom(URLBuilder uRLBuilder, Url url) {
        uRLBuilder.getClass();
        url.getClass();
        uRLBuilder.setProtocolOrNull(url.getProtocolOrNull());
        uRLBuilder.setHost(url.getHost());
        uRLBuilder.setPort(url.getPort());
        URLBuilderKt.setEncodedPath(uRLBuilder, url.getEncodedPath());
        uRLBuilder.setEncodedUser(url.getEncodedUser());
        uRLBuilder.setEncodedPassword(url.getEncodedPassword());
        ParametersBuilder parametersBuilderParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
        parametersBuilderParametersBuilder$default.appendAll(QueryKt.parseQueryString$default(url.getEncodedQuery(), 0, 0, false, 6, null));
        uRLBuilder.setEncodedParameters(parametersBuilderParametersBuilder$default);
        uRLBuilder.setEncodedFragment(url.getEncodedFragment());
        uRLBuilder.setTrailingQuery(url.getTrailingQuery());
        return uRLBuilder;
    }

    public static final boolean isRelativePath(URLBuilder uRLBuilder) {
        uRLBuilder.getClass();
        return !isAbsolutePath(uRLBuilder);
    }

    public static final boolean isAbsolutePath(URLBuilder uRLBuilder) {
        uRLBuilder.getClass();
        return Intrinsics.areEqual(CollectionsKt.firstOrNull((List) uRLBuilder.getPathSegments()), "");
    }

    public static final URLBuilder URLBuilder(Url url) {
        url.getClass();
        return takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), url);
    }

    public static final URLBuilder URLBuilder(URLBuilder uRLBuilder) {
        uRLBuilder.getClass();
        return takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), uRLBuilder);
    }

    public static final Url Url(String str) {
        str.getClass();
        return URLBuilder(str).build();
    }

    public static final URLBuilder takeFrom(URLBuilder uRLBuilder, URLBuilder uRLBuilder2) {
        uRLBuilder.getClass();
        uRLBuilder2.getClass();
        uRLBuilder.setProtocolOrNull(uRLBuilder2.getProtocolOrNull());
        uRLBuilder.setHost(uRLBuilder2.getHost());
        uRLBuilder.setPort(uRLBuilder2.getPort());
        uRLBuilder.setEncodedPathSegments(uRLBuilder2.getEncodedPathSegments());
        uRLBuilder.setEncodedUser(uRLBuilder2.getEncodedUser());
        uRLBuilder.setEncodedPassword(uRLBuilder2.getEncodedPassword());
        ParametersBuilder parametersBuilderParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
        StringValuesKt.appendAll(parametersBuilderParametersBuilder$default, uRLBuilder2.getEncodedParameters());
        uRLBuilder.setEncodedParameters(parametersBuilderParametersBuilder$default);
        uRLBuilder.setEncodedFragment(uRLBuilder2.getEncodedFragment());
        uRLBuilder.setTrailingQuery(uRLBuilder2.getTrailingQuery());
        return uRLBuilder;
    }

    public static final void appendUrlFullPath(Appendable appendable, String str, String str2, boolean z) throws IOException {
        appendable.getClass();
        str.getClass();
        str2.getClass();
        if (!StringsKt.isBlank(str) && !StringsKt__StringsJVMKt.startsWith(str, "/", false)) {
            appendable.append('/');
        }
        appendable.append(str);
        if (str2.length() > 0 || z) {
            appendable.append("?");
        }
        appendable.append(str2);
    }
}
