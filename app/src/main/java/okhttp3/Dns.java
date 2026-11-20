package okhttp3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.List;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.dns.LookupDnsCall;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public interface Dns {
    public static final Dns$Companion$SYSTEM$1 SYSTEM = new Dns$Companion$SYSTEM$1();

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Request {
        public final String hostname;
        public final int port;

        public Request(String str, int i) {
            String canonicalHost = _HostnamesCommonKt.toCanonicalHost(str);
            if (canonicalHost == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("unexpected hostname: ".concat(str));
                throw null;
            }
            this.hostname = canonicalHost;
            if (i == -1) {
                i = 443;
            } else if (1 > i || i >= 65536) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(i, "unexpected port: "));
                throw null;
            }
            this.port = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Request)) {
                return false;
            }
            Request request = (Request) obj;
            return request.hostname.equals(this.hostname) && request.port == this.port;
        }

        public final int hashCode() {
            return (this.hostname.hashCode() * 31) + this.port;
        }

        public final String toString() {
            int i = this.port;
            String str = this.hostname;
            if (i == 443) {
                return str;
            }
            return str + ':' + i;
        }
    }

    List lookup(String str);

    default LookupDnsCall newCall(Request request) {
        return new LookupDnsCall(TaskRunner.INSTANCE, this, request);
    }
}
