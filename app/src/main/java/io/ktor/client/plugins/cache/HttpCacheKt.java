package io.ktor.client.plugins.cache;

import io.ktor.client.engine.UtilsKt;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.URLProtocol;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aU\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00050\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\u000b\u001a\u00020\n*\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\f\"\u001e\u0010\u000f\u001a\u00060\rj\u0002`\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/http/content/OutgoingContent;", "content", "Lkotlin/Function1;", "", "headerExtractor", "", "allHeadersExtractor", "mergedHeadersLookup", "(Lio/ktor/http/content/OutgoingContent;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "Lio/ktor/http/URLProtocol;", "", "canStore", "(Lio/ktor/http/URLProtocol;)Z", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "getLOGGER", "()Lorg/slf4j/Logger;", "ktor-client-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class HttpCacheKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpCache");

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean canStore(URLProtocol uRLProtocol) {
        return Intrinsics.areEqual(uRLProtocol.getName(), "http") || Intrinsics.areEqual(uRLProtocol.getName(), "https");
    }

    public static final Logger getLOGGER() {
        return LOGGER;
    }

    public static final Function1 mergedHeadersLookup(OutgoingContent outgoingContent, Function1 function1, Function1 function2) {
        outgoingContent.getClass();
        function1.getClass();
        function2.getClass();
        return new HttpCacheKt$$ExternalSyntheticLambda0(outgoingContent, function1, function2, (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String mergedHeadersLookup$lambda$0(OutgoingContent outgoingContent, Function1 function1, Function1 function2, String str) {
        String string;
        String strValueOf;
        str.getClass();
        int iHashCode = str.hashCode();
        if (iHashCode != -1844712829) {
            if (iHashCode != 949037134) {
                if (iHashCode == 1244061434 && str.equals(HttpHeaders.ContentLength)) {
                    Long contentLength = outgoingContent.getContentLength();
                    return (contentLength == null || (strValueOf = String.valueOf(contentLength.longValue())) == null) ? "" : strValueOf;
                }
            } else if (str.equals(HttpHeaders.ContentType)) {
                ContentType contentType = outgoingContent.getContentType();
                return (contentType == null || (string = contentType.toString()) == null) ? "" : string;
            }
        } else if (str.equals(HttpHeaders.UserAgent)) {
            String str2 = outgoingContent.getHeaders().get(HttpHeaders.UserAgent);
            if (str2 != null) {
                return str2;
            }
            String str3 = (String) function1.invoke(HttpHeaders.UserAgent);
            return str3 == null ? UtilsKt.getKTOR_DEFAULT_USER_AGENT() : str3;
        }
        List<String> all = outgoingContent.getHeaders().getAll(str);
        if (all == null) {
            all = (List) function2.invoke(str);
        }
        return HttpCacheEntryKt.joinHeaderValues(all);
    }
}
