package io.ktor.http.header;

import io.ktor.http.HeaderValueParam;
import io.ktor.http.HeaderValueWithParameters;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0082\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u00020\u0016H\u0096\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lio/ktor/http/header/AcceptEncoding;", "Lio/ktor/http/HeaderValueWithParameters;", "", "acceptEncoding", "", "Lio/ktor/http/HeaderValueParam;", "parameters", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "", "qValue", "(Ljava/lang/String;D)V", "withQValue", "(D)Lio/ktor/http/header/AcceptEncoding;", "pattern", "", "match", "(Lio/ktor/http/header/AcceptEncoding;)Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getAcceptEncoding", "()Ljava/lang/String;", "Companion", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AcceptEncoding extends HeaderValueWithParameters {
    private static final AcceptEncoding All;
    private static final AcceptEncoding Br;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AcceptEncoding Compress;
    private static final AcceptEncoding Deflate;
    private static final AcceptEncoding Gzip;
    private static final AcceptEncoding Identity;
    private static final AcceptEncoding Zstd;
    private final String acceptEncoding;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i = 2;
        Gzip = new AcceptEncoding("gzip", 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        Compress = new AcceptEncoding("compress", 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        Deflate = new AcceptEncoding("deflate", 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        Br = new AcceptEncoding("br", 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        Zstd = new AcceptEncoding("zstd", 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        Identity = new AcceptEncoding("identity", 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        All = new AcceptEncoding("*", 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AcceptEncoding(String str, double d) {
        this(str, (List<HeaderValueParam>) CollectionsKt__IterablesKt.listOf(new HeaderValueParam("q", String.valueOf(d))));
        str.getClass();
    }

    public boolean equals(Object other) {
        if (!(other instanceof AcceptEncoding)) {
            return false;
        }
        AcceptEncoding acceptEncoding = (AcceptEncoding) other;
        return StringsKt__StringsJVMKt.equals(this.acceptEncoding, acceptEncoding.acceptEncoding, true) && Intrinsics.areEqual(getParameters(), acceptEncoding.getParameters());
    }

    public final String getAcceptEncoding() {
        return this.acceptEncoding;
    }

    public int hashCode() {
        String lowerCase = this.acceptEncoding.toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        return (getParameters().hashCode() * 31) + lowerCase.hashCode();
    }

    public final boolean match(AcceptEncoding pattern) {
        boolean zEquals;
        pattern.getClass();
        if (!Intrinsics.areEqual(pattern.acceptEncoding, "*") && !StringsKt__StringsJVMKt.equals(pattern.acceptEncoding, this.acceptEncoding, true)) {
            return false;
        }
        for (HeaderValueParam headerValueParam : pattern.getParameters()) {
            String name = headerValueParam.getName();
            String value = headerValueParam.getValue();
            if (!Intrinsics.areEqual(name, "*")) {
                String strParameter = parameter(name);
                zEquals = Intrinsics.areEqual(value, "*") ? strParameter != null : StringsKt__StringsJVMKt.equals(strParameter, value, true);
            } else if (!Intrinsics.areEqual(value, "*")) {
                List<HeaderValueParam> parameters = getParameters();
                if (parameters == null || !parameters.isEmpty()) {
                    Iterator<T> it = parameters.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (StringsKt__StringsJVMKt.equals(((HeaderValueParam) it.next()).getValue(), value, true)) {
                            }
                        }
                    }
                }
            }
            if (!zEquals) {
                return false;
            }
        }
        return true;
    }

    public final AcceptEncoding withQValue(double qValue) {
        return Intrinsics.areEqual(String.valueOf(qValue), parameter("q")) ? this : new AcceptEncoding(this.acceptEncoding, qValue);
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u0018\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\r¨\u0006\u001a"}, d2 = {"Lio/ktor/http/header/AcceptEncoding$Companion;", "", "<init>", "()V", "", "Lio/ktor/http/header/AcceptEncoding;", "encodings", "", "mergeAcceptEncodings", "([Lio/ktor/http/header/AcceptEncoding;)Ljava/lang/String;", "Gzip", "Lio/ktor/http/header/AcceptEncoding;", "getGzip", "()Lio/ktor/http/header/AcceptEncoding;", "Compress", "getCompress", "Deflate", "getDeflate", "Br", "getBr", "Zstd", "getZstd", "Identity", "getIdentity", "All", "getAll", "ktor-http"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AcceptEncoding getAll() {
            return AcceptEncoding.All;
        }

        public final AcceptEncoding getBr() {
            return AcceptEncoding.Br;
        }

        public final AcceptEncoding getCompress() {
            return AcceptEncoding.Compress;
        }

        public final AcceptEncoding getDeflate() {
            return AcceptEncoding.Deflate;
        }

        public final AcceptEncoding getGzip() {
            return AcceptEncoding.Gzip;
        }

        public final AcceptEncoding getIdentity() {
            return AcceptEncoding.Identity;
        }

        public final AcceptEncoding getZstd() {
            return AcceptEncoding.Zstd;
        }

        public final String mergeAcceptEncodings(AcceptEncoding... encodings) {
            encodings.getClass();
            return ArraysKt.joinToString$default(encodings, ", ", 62);
        }

        private Companion() {
        }
    }

    public /* synthetic */ AcceptEncoding(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (List<HeaderValueParam>) ((i & 2) != 0 ? EmptyList.INSTANCE : list));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcceptEncoding(String str, List<HeaderValueParam> list) {
        super(str, list);
        str.getClass();
        list.getClass();
        this.acceptEncoding = str;
    }
}
