package io.ktor.http;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u00020\u000fHÖ\u0081\u0004¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0015"}, d2 = {"Lio/ktor/http/HttpMethod;", "", "", "value", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "component1", "copy", "(Ljava/lang/String;)Lio/ktor/http/HttpMethod;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getValue", "Companion", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class HttpMethod {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final List<HttpMethod> DefaultMethods;
    public static final HttpMethod Delete;
    public static final HttpMethod Get;
    public static final HttpMethod Head;
    public static final HttpMethod Options;
    public static final HttpMethod Patch;
    public static final HttpMethod Post;
    public static final HttpMethod Put;
    public static final HttpMethod Query;
    public static final HttpMethod Trace;
    private final String value;

    static {
        HttpMethod httpMethod = new HttpMethod("GET");
        Get = httpMethod;
        HttpMethod httpMethod2 = new HttpMethod("POST");
        Post = httpMethod2;
        HttpMethod httpMethod3 = new HttpMethod("PUT");
        Put = httpMethod3;
        HttpMethod httpMethod4 = new HttpMethod("PATCH");
        Patch = httpMethod4;
        HttpMethod httpMethod5 = new HttpMethod("DELETE");
        Delete = httpMethod5;
        HttpMethod httpMethod6 = new HttpMethod("HEAD");
        Head = httpMethod6;
        HttpMethod httpMethod7 = new HttpMethod("OPTIONS");
        Options = httpMethod7;
        Trace = new HttpMethod("TRACE");
        Query = new HttpMethod("QUERY");
        DefaultMethods = CollectionsKt__IterablesKt.listOf((Object[]) new HttpMethod[]{httpMethod, httpMethod2, httpMethod3, httpMethod4, httpMethod5, httpMethod6, httpMethod7});
    }

    public HttpMethod(String str) {
        str.getClass();
        this.value = str;
    }

    public static /* synthetic */ HttpMethod copy$default(HttpMethod httpMethod, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = httpMethod.value;
        }
        return httpMethod.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final HttpMethod copy(String value) {
        value.getClass();
        return new HttpMethod(value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof HttpMethod) && Intrinsics.areEqual(this.value, ((HttpMethod) other).value);
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return this.value;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\nJ\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u0014\u0010\u001c\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0016R\u0014\u0010\u001e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00128\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lio/ktor/http/HttpMethod$Companion;", "", "<init>", "()V", "", "method", "Lio/ktor/http/HttpMethod;", "parse", "(Ljava/lang/String;)Lio/ktor/http/HttpMethod;", "getGet", "()Lio/ktor/http/HttpMethod;", "getPost", "getPut", "getPatch", "getDelete", "getHead", "getOptions", "getTrace", "", "getDefaultMethods", "()Ljava/util/List;", "Get", "Lio/ktor/http/HttpMethod;", "Post", "Put", "Patch", "Delete", "Head", "Options", "Trace", "Query", "DefaultMethods", "Ljava/util/List;", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated
        public final List<HttpMethod> getDefaultMethods() {
            return HttpMethod.DefaultMethods;
        }

        @Deprecated
        public final HttpMethod getDelete() {
            return HttpMethod.Delete;
        }

        @Deprecated
        public final HttpMethod getGet() {
            return HttpMethod.Get;
        }

        @Deprecated
        public final HttpMethod getHead() {
            return HttpMethod.Head;
        }

        @Deprecated
        public final HttpMethod getOptions() {
            return HttpMethod.Options;
        }

        @Deprecated
        public final HttpMethod getPatch() {
            return HttpMethod.Patch;
        }

        @Deprecated
        public final HttpMethod getPost() {
            return HttpMethod.Post;
        }

        @Deprecated
        public final HttpMethod getPut() {
            return HttpMethod.Put;
        }

        @Deprecated
        public final HttpMethod getTrace() {
            return HttpMethod.Trace;
        }

        public final HttpMethod parse(String method) {
            method.getClass();
            HttpMethod httpMethod = HttpMethod.Get;
            if (method.equals(httpMethod.getValue())) {
                return httpMethod;
            }
            HttpMethod httpMethod2 = HttpMethod.Post;
            if (method.equals(httpMethod2.getValue())) {
                return httpMethod2;
            }
            HttpMethod httpMethod3 = HttpMethod.Put;
            if (method.equals(httpMethod3.getValue())) {
                return httpMethod3;
            }
            HttpMethod httpMethod4 = HttpMethod.Patch;
            if (method.equals(httpMethod4.getValue())) {
                return httpMethod4;
            }
            HttpMethod httpMethod5 = HttpMethod.Trace;
            if (method.equals(httpMethod5.getValue())) {
                return httpMethod5;
            }
            HttpMethod httpMethod6 = HttpMethod.Delete;
            if (method.equals(httpMethod6.getValue())) {
                return httpMethod6;
            }
            HttpMethod httpMethod7 = HttpMethod.Head;
            if (method.equals(httpMethod7.getValue())) {
                return httpMethod7;
            }
            HttpMethod httpMethod8 = HttpMethod.Query;
            if (method.equals(httpMethod8.getValue())) {
                return httpMethod8;
            }
            HttpMethod httpMethod9 = HttpMethod.Options;
            return method.equals(httpMethod9.getValue()) ? httpMethod9 : new HttpMethod(method);
        }

        private Companion() {
        }
    }
}
