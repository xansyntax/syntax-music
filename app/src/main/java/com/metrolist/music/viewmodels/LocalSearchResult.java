package com.metrolist.music.viewmodels;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LocalSearchResult {
    public final LocalFilter filter;
    public final Map map;
    public final String query;

    public LocalSearchResult(String str, LocalFilter localFilter, Map map) {
        str.getClass();
        localFilter.getClass();
        this.query = str;
        this.filter = localFilter;
        this.map = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalSearchResult)) {
            return false;
        }
        LocalSearchResult localSearchResult = (LocalSearchResult) obj;
        return Intrinsics.areEqual(this.query, localSearchResult.query) && this.filter == localSearchResult.filter && this.map.equals(localSearchResult.map);
    }

    public final int hashCode() {
        return this.map.hashCode() + ((this.filter.hashCode() + (this.query.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "LocalSearchResult(query=" + this.query + ", filter=" + this.filter + ", map=" + this.map + ")";
    }
}
