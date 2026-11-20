package okhttp3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import dagger.hilt.EntryPoints;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.UIntArray;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.EmptyTags;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class Request {
    public final RequestBody body;
    public final Headers headers;
    public CacheControl lazyCacheControl;
    public final String method;
    public final EmptyTags tags;
    public final HttpUrl url;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Builder {
        public RequestBody body;
        public HttpUrl url;
        public EmptyTags tags = EmptyTags.INSTANCE;
        public String method = "GET";
        public Headers.Builder headers = new Headers.Builder((byte) 0);

        public final void addHeader(String str, String str2) {
            str2.getClass();
            Headers.Builder builder = this.headers;
            builder.getClass();
            EntryPoints.headersCheckName(str);
            EntryPoints.headersCheckValue(str2, str);
            EntryPoints.commonAddLenient(builder, str, str2);
        }

        public final void header(String str, String str2) {
            str.getClass();
            str2.getClass();
            Headers.Builder builder = this.headers;
            builder.getClass();
            EntryPoints.headersCheckName(str);
            EntryPoints.headersCheckValue(str2, str);
            builder.removeAll(str);
            EntryPoints.commonAddLenient(builder, str, str2);
        }

        public final void method(String str, RequestBody requestBody) {
            str.getClass();
            if (str.length() <= 0) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("method.isEmpty() == true");
                return;
            }
            if (requestBody == null) {
                if (str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("QUERY") || str.equals("REPORT")) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m("method ", str, " must have a request body."));
                    return;
                }
            } else if (!Okio__OkioKt.permitsRequestBody(str)) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1((Object) IntIntPair$$ExternalSyntheticOutline0.m("method ", str, " must not have a request body."));
                return;
            }
            this.method = str;
            this.body = requestBody;
        }

        public final void url(String str) {
            str.getClass();
            if (StringsKt__StringsJVMKt.startsWith(str, "ws:", true)) {
                str = "http:".concat(str.substring(3));
            } else if (StringsKt__StringsJVMKt.startsWith(str, "wss:", true)) {
                str = "https:".concat(str.substring(4));
            }
            HttpUrl.Builder builder = new HttpUrl.Builder();
            builder.parse$okhttp(null, str);
            this.url = builder.build();
        }
    }

    public Request(Builder builder) {
        builder.getClass();
        HttpUrl httpUrl = builder.url;
        if (httpUrl == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("url == null");
            throw null;
        }
        this.url = httpUrl;
        this.method = builder.method;
        Headers.Builder builder2 = builder.headers;
        builder2.getClass();
        this.headers = EntryPoints.commonBuild(builder2);
        this.body = builder.body;
        this.tags = builder.tags;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.url = this.url;
        builder.method = this.method;
        builder.body = this.body;
        builder.tags = this.tags;
        builder.headers = EntryPoints.commonNewBuilder(this.headers);
        return builder;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        Headers headers = this.headers;
        if (headers.size() != 0) {
            sb.append(", headers=[");
            Iterator it = headers.iterator();
            int i = 0;
            while (true) {
                UIntArray.Iterator iterator = (UIntArray.Iterator) it;
                if (!iterator.hasNext()) {
                    sb.append(']');
                    break;
                }
                Object next = iterator.next();
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__IterablesKt.throwIndexOverflow();
                    throw null;
                }
                Pair pair = (Pair) next;
                String str = (String) pair.first;
                String str2 = (String) pair.second;
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append(':');
                if (_UtilCommonKt.isSensitiveHeader(str)) {
                    str2 = "██";
                }
                sb.append(str2);
                i = i2;
            }
        }
        EmptyTags emptyTags = EmptyTags.INSTANCE;
        EmptyTags emptyTags2 = this.tags;
        if (!Intrinsics.areEqual(emptyTags2, emptyTags)) {
            sb.append(", tags=");
            sb.append(emptyTags2);
        }
        sb.append('}');
        return sb.toString();
    }
}
