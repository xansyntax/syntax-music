package com.metrolist.music.ui.player;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaItemsData {
    public final int currentIndex;
    public final ArrayList items;

    public MediaItemsData(int i, ArrayList arrayList) {
        this.items = arrayList;
        this.currentIndex = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaItemsData)) {
            return false;
        }
        MediaItemsData mediaItemsData = (MediaItemsData) obj;
        return this.items.equals(mediaItemsData.items) && this.currentIndex == mediaItemsData.currentIndex;
    }

    public final int hashCode() {
        return Integer.hashCode(this.currentIndex) + (this.items.hashCode() * 31);
    }

    public final String toString() {
        return "MediaItemsData(items=" + this.items + ", currentIndex=" + this.currentIndex + ")";
    }
}
