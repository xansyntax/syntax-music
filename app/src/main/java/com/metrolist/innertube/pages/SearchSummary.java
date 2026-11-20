package com.metrolist.innertube.pages;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SearchSummary {
    public final List items;
    public final String title;

    public SearchSummary(String str, List list) {
        str.getClass();
        this.title = str;
        this.items = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchSummary)) {
            return false;
        }
        SearchSummary searchSummary = (SearchSummary) obj;
        return Intrinsics.areEqual(this.title, searchSummary.title) && this.items.equals(searchSummary.items);
    }

    public final int hashCode() {
        return this.items.hashCode() + (this.title.hashCode() * 31);
    }

    public final String toString() {
        return "SearchSummary(title=" + this.title + ", items=" + this.items + ")";
    }
}
