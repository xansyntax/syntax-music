package com.metrolist.innertube.models;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SearchSuggestions {
    public final List queries;
    public final List recommendedItems;

    public SearchSuggestions(List list, List list2) {
        this.queries = list;
        this.recommendedItems = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchSuggestions)) {
            return false;
        }
        SearchSuggestions searchSuggestions = (SearchSuggestions) obj;
        return this.queries.equals(searchSuggestions.queries) && this.recommendedItems.equals(searchSuggestions.recommendedItems);
    }

    public final int hashCode() {
        return this.recommendedItems.hashCode() + (this.queries.hashCode() * 31);
    }

    public final String toString() {
        return "SearchSuggestions(queries=" + this.queries + ", recommendedItems=" + this.recommendedItems + ")";
    }
}
