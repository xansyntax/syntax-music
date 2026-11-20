package com.metrolist.music.playback;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidAutoPageRequest {
    public final int limit;
    public final int offset;

    public AndroidAutoPageRequest(int i, int i2) {
        this.offset = i;
        this.limit = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidAutoPageRequest)) {
            return false;
        }
        AndroidAutoPageRequest androidAutoPageRequest = (AndroidAutoPageRequest) obj;
        return this.offset == androidAutoPageRequest.offset && this.limit == androidAutoPageRequest.limit;
    }

    public final int hashCode() {
        return Integer.hashCode(this.limit) + (Integer.hashCode(this.offset) * 31);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(this.offset, "AndroidAutoPageRequest(offset=", ", limit=", this.limit, ")");
    }
}
