package coil3.network;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import coil3.Extras;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NetworkRequest {
    public final Extras extras;
    public final NetworkHeaders headers;
    public final String method;
    public final String url;

    public NetworkRequest(String str, String str2, NetworkHeaders networkHeaders, Extras extras) {
        this.url = str;
        this.method = str2;
        this.headers = networkHeaders;
        this.extras = extras;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkRequest)) {
            return false;
        }
        NetworkRequest networkRequest = (NetworkRequest) obj;
        return this.url.equals(networkRequest.url) && Intrinsics.areEqual(this.method, networkRequest.method) && this.headers.equals(networkRequest.headers) && Intrinsics.areEqual(this.extras, networkRequest.extras);
    }

    public final int hashCode() {
        return this.extras.data.hashCode() + ((this.headers.data.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(this.url.hashCode() * 31, 31, this.method)) * 961);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("NetworkRequest(url=", this.url, ", method=", this.method, ", headers=");
        sbM.append(this.headers);
        sbM.append(", body=null, extras=");
        sbM.append(this.extras);
        sbM.append(")");
        return sbM.toString();
    }
}
