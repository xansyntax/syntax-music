package com.metrolist.music.viewmodels;

import com.metrolist.innertube.models.BrowseEndpoint;
import com.metrolist.innertube.models.SongItem;
import com.metrolist.music.db.entities.Song;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DailyDiscoverItem {
    public final SongItem recommendation;
    public final BrowseEndpoint relatedEndpoint;
    public final Song seed;

    public DailyDiscoverItem(Song song, SongItem songItem, BrowseEndpoint browseEndpoint) {
        song.getClass();
        this.seed = song;
        this.recommendation = songItem;
        this.relatedEndpoint = browseEndpoint;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DailyDiscoverItem)) {
            return false;
        }
        DailyDiscoverItem dailyDiscoverItem = (DailyDiscoverItem) obj;
        return Intrinsics.areEqual(this.seed, dailyDiscoverItem.seed) && this.recommendation.equals(dailyDiscoverItem.recommendation) && Intrinsics.areEqual(this.relatedEndpoint, dailyDiscoverItem.relatedEndpoint);
    }

    public final int hashCode() {
        int iHashCode = (this.recommendation.hashCode() + (this.seed.hashCode() * 31)) * 31;
        BrowseEndpoint browseEndpoint = this.relatedEndpoint;
        return iHashCode + (browseEndpoint == null ? 0 : browseEndpoint.hashCode());
    }

    public final String toString() {
        return "DailyDiscoverItem(seed=" + this.seed + ", recommendation=" + this.recommendation + ", relatedEndpoint=" + this.relatedEndpoint + ")";
    }
}
