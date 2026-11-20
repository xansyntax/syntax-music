package com.metrolist.innertube.pages;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExplorePage {
    public final List moodAndGenres;
    public final List newReleaseAlbums;

    public ExplorePage(List list, List list2) {
        this.newReleaseAlbums = list;
        this.moodAndGenres = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExplorePage)) {
            return false;
        }
        ExplorePage explorePage = (ExplorePage) obj;
        return this.newReleaseAlbums.equals(explorePage.newReleaseAlbums) && this.moodAndGenres.equals(explorePage.moodAndGenres);
    }

    public final int hashCode() {
        return this.moodAndGenres.hashCode() + (this.newReleaseAlbums.hashCode() * 31);
    }

    public final String toString() {
        return "ExplorePage(newReleaseAlbums=" + this.newReleaseAlbums + ", moodAndGenres=" + this.moodAndGenres + ")";
    }
}
