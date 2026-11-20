package com.metrolist.innertube.pages;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SearchResult {
    public final String continuation;
    public final List items;

    public SearchResult(List list, String str) {
        this.items = list;
        this.continuation = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchResult)) {
            return false;
        }
        SearchResult searchResult = (SearchResult) obj;
        return this.items.equals(searchResult.items) && Intrinsics.areEqual(this.continuation, searchResult.continuation);
    }

    public final int hashCode() {
        int iHashCode = this.items.hashCode() * 31;
        String str = this.continuation;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "SearchResult(items=" + this.items + ", continuation=" + this.continuation + ")";
    }
}
