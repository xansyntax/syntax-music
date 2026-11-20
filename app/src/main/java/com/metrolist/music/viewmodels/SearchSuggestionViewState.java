package com.metrolist.music.viewmodels;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertube.models.YTItem;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SearchSuggestionViewState {
    public final List history;
    public final boolean isUrlQuery;
    public final List items;
    public final YTItem parsedUrlItem;
    public final List suggestions;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SearchSuggestionViewState(List list, List list2, List list3, int i) {
        int i2 = i & 1;
        EmptyList emptyList = EmptyList.INSTANCE;
        this(i2 != 0 ? emptyList : list, (i & 2) != 0 ? emptyList : list2, (i & 4) != 0 ? emptyList : list3, null, false);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchSuggestionViewState)) {
            return false;
        }
        SearchSuggestionViewState searchSuggestionViewState = (SearchSuggestionViewState) obj;
        return Intrinsics.areEqual(this.history, searchSuggestionViewState.history) && Intrinsics.areEqual(this.suggestions, searchSuggestionViewState.suggestions) && Intrinsics.areEqual(this.items, searchSuggestionViewState.items) && Intrinsics.areEqual(this.parsedUrlItem, searchSuggestionViewState.parsedUrlItem) && this.isUrlQuery == searchSuggestionViewState.isUrlQuery;
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.history.hashCode() * 31, 31, this.suggestions), 31, this.items);
        YTItem yTItem = this.parsedUrlItem;
        return Boolean.hashCode(this.isUrlQuery) + ((iM + (yTItem == null ? 0 : yTItem.hashCode())) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SearchSuggestionViewState(history=");
        sb.append(this.history);
        sb.append(", suggestions=");
        sb.append(this.suggestions);
        sb.append(", items=");
        sb.append(this.items);
        sb.append(", parsedUrlItem=");
        sb.append(this.parsedUrlItem);
        sb.append(", isUrlQuery=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.isUrlQuery, ")");
    }

    public SearchSuggestionViewState(List list, List list2, List list3, YTItem yTItem, boolean z) {
        list.getClass();
        list2.getClass();
        list3.getClass();
        this.history = list;
        this.suggestions = list2;
        this.items = list3;
        this.parsedUrlItem = yTItem;
        this.isUrlQuery = z;
    }
}
