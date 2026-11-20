package io.ktor.http;

import io.ktor.sse.ServerSentEventKt;
import java.net.URI;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007\u001a\u0011\u0010\t\u001a\u00020\u0001*\u00020\b¢\u0006\u0004\b\t\u0010\n\u001a\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/http/URLBuilder;", "Ljava/net/URI;", "uri", "takeFrom", "(Lio/ktor/http/URLBuilder;Ljava/net/URI;)Lio/ktor/http/URLBuilder;", "Ljava/net/URL;", "url", "(Lio/ktor/http/URLBuilder;Ljava/net/URL;)Lio/ktor/http/URLBuilder;", "Lio/ktor/http/Url;", "toURI", "(Lio/ktor/http/Url;)Ljava/net/URI;", "Url", "(Ljava/net/URI;)Lio/ktor/http/Url;", "ktor-http"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class URLUtilsJvmKt {
    public static final Url Url(URI uri) {
        uri.getClass();
        return takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), uri).build();
    }

    public static final URLBuilder takeFrom(URLBuilder uRLBuilder, URI uri) {
        uRLBuilder.getClass();
        uri.getClass();
        String scheme = uri.getScheme();
        if (scheme != null) {
            uRLBuilder.setProtocol(URLProtocol.INSTANCE.createOrDefault(scheme));
            uRLBuilder.setPort(uRLBuilder.getProtocol().getDefaultPort());
        }
        if (uri.getPort() > 0) {
            uRLBuilder.setPort(uri.getPort());
        } else {
            String scheme2 = uri.getScheme();
            if (Intrinsics.areEqual(scheme2, "http")) {
                uRLBuilder.setPort(80);
            } else if (Intrinsics.areEqual(scheme2, "https")) {
                uRLBuilder.setPort(443);
            }
        }
        if (uri.getRawUserInfo() != null) {
            String rawUserInfo = uri.getRawUserInfo();
            rawUserInfo.getClass();
            if (rawUserInfo.length() > 0) {
                String rawUserInfo2 = uri.getRawUserInfo();
                rawUserInfo2.getClass();
                List listSplit$default = StringsKt.split$default(rawUserInfo2, new String[]{ServerSentEventKt.COLON}, 0, 6);
                uRLBuilder.setEncodedUser((String) CollectionsKt.first(listSplit$default));
                uRLBuilder.setEncodedPassword((String) CollectionsKt.getOrNull(1, listSplit$default));
            }
        }
        String host = uri.getHost();
        if (host != null) {
            uRLBuilder.setHost(host);
        }
        String rawPath = uri.getRawPath();
        rawPath.getClass();
        URLBuilderKt.setEncodedPath(uRLBuilder, rawPath);
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null) {
            ParametersBuilder parametersBuilderParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
            parametersBuilderParametersBuilder$default.appendAll(QueryKt.parseQueryString$default(rawQuery, 0, 0, false, 6, null));
            uRLBuilder.setEncodedParameters(parametersBuilderParametersBuilder$default);
        }
        String query = uri.getQuery();
        if (query != null && query.length() == 0) {
            uRLBuilder.setTrailingQuery(true);
        }
        String rawFragment = uri.getRawFragment();
        if (rawFragment != null) {
            uRLBuilder.setEncodedFragment(rawFragment);
        }
        return uRLBuilder;
    }

    public static final URI toURI(Url url) {
        url.getClass();
        return new URI(url.getUrlString());
    }

    public static final URLBuilder takeFrom(URLBuilder uRLBuilder, URL url) {
        uRLBuilder.getClass();
        url.getClass();
        String host = url.getHost();
        host.getClass();
        if (StringsKt.contains$default(host, '_')) {
            String string = url.toString();
            string.getClass();
            return URLParserKt.takeFrom(uRLBuilder, string);
        }
        URI uri = url.toURI();
        uri.getClass();
        return takeFrom(uRLBuilder, uri);
    }
}
