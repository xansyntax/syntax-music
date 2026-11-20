package com.metrolist.innertubex.cipher;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import io.ktor.http.Headers;
import io.ktor.http.HttpStatusCode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class RestrictedTextResponse {
    public final String body;
    public final Headers headers;
    public final HttpStatusCode status;

    public RestrictedTextResponse(HttpStatusCode httpStatusCode, Headers headers, String str) {
        httpStatusCode.getClass();
        headers.getClass();
        this.status = httpStatusCode;
        this.headers = headers;
        this.body = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RestrictedTextResponse)) {
            return false;
        }
        RestrictedTextResponse restrictedTextResponse = (RestrictedTextResponse) obj;
        return Intrinsics.areEqual(this.status, restrictedTextResponse.status) && Intrinsics.areEqual(this.headers, restrictedTextResponse.headers) && Intrinsics.areEqual(this.body, restrictedTextResponse.body);
    }

    public final int hashCode() {
        int iHashCode = (this.headers.hashCode() + (this.status.hashCode() * 31)) * 31;
        String str = this.body;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RestrictedTextResponse(status=");
        sb.append(this.status);
        sb.append(", headers=");
        sb.append(this.headers);
        sb.append(", body=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.body, ")");
    }
}
