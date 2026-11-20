package com.metrolist.innertube.utils;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class YouTubeUrlParser$ParsedUrl$Album extends Okio__OkioKt {
    public final String id;

    public YouTubeUrlParser$ParsedUrl$Album(String str) {
        super((byte) 3);
        this.id = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof YouTubeUrlParser$ParsedUrl$Album) && this.id.equals(((YouTubeUrlParser$ParsedUrl$Album) obj).id);
    }

    @Override // okio.Okio__OkioKt
    public final int hashCode() {
        return this.id.hashCode();
    }

    @Override // okio.Okio__OkioKt
    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m("Album(id=", this.id, ")");
    }
}
