package coil3.network;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NetworkResponse {
    public final SourceResponseBody body;
    public final int code;
    public final Object delegate;
    public final NetworkHeaders headers;
    public final long requestMillis;
    public final long responseMillis;

    public NetworkResponse(int i, long j, long j2, NetworkHeaders networkHeaders, SourceResponseBody sourceResponseBody, Object obj) {
        this.code = i;
        this.requestMillis = j;
        this.responseMillis = j2;
        this.headers = networkHeaders;
        this.body = sourceResponseBody;
        this.delegate = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkResponse)) {
            return false;
        }
        NetworkResponse networkResponse = (NetworkResponse) obj;
        return this.code == networkResponse.code && this.requestMillis == networkResponse.requestMillis && this.responseMillis == networkResponse.responseMillis && Intrinsics.areEqual(this.headers, networkResponse.headers) && Intrinsics.areEqual(this.body, networkResponse.body) && Intrinsics.areEqual(this.delegate, networkResponse.delegate);
    }

    public final int hashCode() {
        int iHashCode = (this.headers.data.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.code * 31, 31, this.requestMillis), 31, this.responseMillis)) * 31;
        SourceResponseBody sourceResponseBody = this.body;
        int iHashCode2 = (iHashCode + (sourceResponseBody == null ? 0 : sourceResponseBody.source.hashCode())) * 31;
        Object obj = this.delegate;
        return iHashCode2 + (obj != null ? obj.hashCode() : 0);
    }

    public final String toString() {
        return "NetworkResponse(code=" + this.code + ", requestMillis=" + this.requestMillis + ", responseMillis=" + this.responseMillis + ", headers=" + this.headers + ", body=" + this.body + ", delegate=" + this.delegate + ")";
    }
}
