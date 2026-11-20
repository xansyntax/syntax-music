package com.metrolist.innertube.pages;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.metrolist.innertube.models.BrowseEndpoint;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArtistSection {
    public final List items;
    public final BrowseEndpoint moreEndpoint;
    public final String title;

    public ArtistSection(String str, List list, BrowseEndpoint browseEndpoint) {
        str.getClass();
        this.title = str;
        this.items = list;
        this.moreEndpoint = browseEndpoint;
    }

    public static ArtistSection copy$default(ArtistSection artistSection, List list) {
        String str = artistSection.title;
        BrowseEndpoint browseEndpoint = artistSection.moreEndpoint;
        artistSection.getClass();
        str.getClass();
        return new ArtistSection(str, list, browseEndpoint);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArtistSection)) {
            return false;
        }
        ArtistSection artistSection = (ArtistSection) obj;
        return Intrinsics.areEqual(this.title, artistSection.title) && this.items.equals(artistSection.items) && Intrinsics.areEqual(this.moreEndpoint, artistSection.moreEndpoint);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(this.title.hashCode() * 31, 31, this.items);
        BrowseEndpoint browseEndpoint = this.moreEndpoint;
        return iM + (browseEndpoint == null ? 0 : browseEndpoint.hashCode());
    }

    public final String toString() {
        return "ArtistSection(title=" + this.title + ", items=" + this.items + ", moreEndpoint=" + this.moreEndpoint + ")";
    }
}
