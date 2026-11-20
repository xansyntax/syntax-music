package com.metrolist.music.db.entities;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SearchHistory {
    public final long id;
    public final String query;

    public SearchHistory(long j, String str) {
        str.getClass();
        this.id = j;
        this.query = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchHistory)) {
            return false;
        }
        SearchHistory searchHistory = (SearchHistory) obj;
        return this.id == searchHistory.id && Intrinsics.areEqual(this.query, searchHistory.query);
    }

    public final int hashCode() {
        return this.query.hashCode() + (Long.hashCode(this.id) * 31);
    }

    public final String toString() {
        return "SearchHistory(id=" + this.id + ", query=" + this.query + ")";
    }
}
