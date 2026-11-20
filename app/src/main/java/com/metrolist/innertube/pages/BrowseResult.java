package com.metrolist.innertube.pages;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BrowseResult {
    public final List items;
    public final String title;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Item {
        public final List items;
        public final String title;

        public Item(String str, List list) {
            this.title = str;
            this.items = list;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return Intrinsics.areEqual(this.title, item.title) && this.items.equals(item.items);
        }

        public final int hashCode() {
            String str = this.title;
            return this.items.hashCode() + ((str == null ? 0 : str.hashCode()) * 31);
        }

        public final String toString() {
            return "Item(title=" + this.title + ", items=" + this.items + ")";
        }
    }

    public BrowseResult(String str, List list) {
        this.title = str;
        this.items = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrowseResult)) {
            return false;
        }
        BrowseResult browseResult = (BrowseResult) obj;
        return Intrinsics.areEqual(this.title, browseResult.title) && this.items.equals(browseResult.items);
    }

    public final int hashCode() {
        String str = this.title;
        return this.items.hashCode() + ((str == null ? 0 : str.hashCode()) * 31);
    }

    public final String toString() {
        return "BrowseResult(title=" + this.title + ", items=" + this.items + ")";
    }
}
