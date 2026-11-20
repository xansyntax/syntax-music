package com.metrolist.music.models;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ItemsPage {
    public final String continuation;
    public final List items;

    public ItemsPage(List list, String str) {
        this.items = list;
        this.continuation = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ItemsPage)) {
            return false;
        }
        ItemsPage itemsPage = (ItemsPage) obj;
        return this.items.equals(itemsPage.items) && Intrinsics.areEqual(this.continuation, itemsPage.continuation);
    }

    public final int hashCode() {
        int iHashCode = this.items.hashCode() * 31;
        String str = this.continuation;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "ItemsPage(items=" + this.items + ", continuation=" + this.continuation + ")";
    }
}
