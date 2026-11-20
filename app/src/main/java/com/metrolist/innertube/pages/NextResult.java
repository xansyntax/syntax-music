package com.metrolist.innertube.pages;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.WatchEndpoint;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class NextResult {
    public final String continuation;
    public final Integer currentIndex;
    public final WatchEndpoint endpoint;
    public final List items;
    public final BrowseEndpoint lyricsEndpoint;
    public final BrowseEndpoint relatedEndpoint;
    public final String title;

    public NextResult(String str, List list, Integer num, BrowseEndpoint browseEndpoint, BrowseEndpoint browseEndpoint2, String str2, WatchEndpoint watchEndpoint) {
        watchEndpoint.getClass();
        this.title = str;
        this.items = list;
        this.currentIndex = num;
        this.lyricsEndpoint = browseEndpoint;
        this.relatedEndpoint = browseEndpoint2;
        this.continuation = str2;
        this.endpoint = watchEndpoint;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NextResult)) {
            return false;
        }
        NextResult nextResult = (NextResult) obj;
        return Intrinsics.areEqual(this.title, nextResult.title) && this.items.equals(nextResult.items) && Intrinsics.areEqual(this.currentIndex, nextResult.currentIndex) && Intrinsics.areEqual(this.lyricsEndpoint, nextResult.lyricsEndpoint) && Intrinsics.areEqual(this.relatedEndpoint, nextResult.relatedEndpoint) && Intrinsics.areEqual(this.continuation, nextResult.continuation) && Intrinsics.areEqual(this.endpoint, nextResult.endpoint);
    }

    public final int hashCode() {
        String str = this.title;
        int iM = Fragment$5$$ExternalSyntheticOutline0.m((str == null ? 0 : str.hashCode()) * 31, 31, this.items);
        Integer num = this.currentIndex;
        int iHashCode = (iM + (num == null ? 0 : num.hashCode())) * 31;
        BrowseEndpoint browseEndpoint = this.lyricsEndpoint;
        int iHashCode2 = (iHashCode + (browseEndpoint == null ? 0 : browseEndpoint.hashCode())) * 31;
        BrowseEndpoint browseEndpoint2 = this.relatedEndpoint;
        int iHashCode3 = (iHashCode2 + (browseEndpoint2 == null ? 0 : browseEndpoint2.hashCode())) * 31;
        String str2 = this.continuation;
        return this.endpoint.hashCode() + ((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "NextResult(title=" + this.title + ", items=" + this.items + ", currentIndex=" + this.currentIndex + ", lyricsEndpoint=" + this.lyricsEndpoint + ", relatedEndpoint=" + this.relatedEndpoint + ", continuation=" + this.continuation + ", endpoint=" + this.endpoint + ")";
    }
}
