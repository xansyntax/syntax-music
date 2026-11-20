package com.metrolist.innertube.pages;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LibraryContinuationPage {
    public final String continuation;
    public final ArrayList items;

    public LibraryContinuationPage(String str, ArrayList arrayList) {
        this.items = arrayList;
        this.continuation = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LibraryContinuationPage)) {
            return false;
        }
        LibraryContinuationPage libraryContinuationPage = (LibraryContinuationPage) obj;
        return this.items.equals(libraryContinuationPage.items) && Intrinsics.areEqual(this.continuation, libraryContinuationPage.continuation);
    }

    public final int hashCode() {
        int iHashCode = this.items.hashCode() * 31;
        String str = this.continuation;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "LibraryContinuationPage(items=" + this.items + ", continuation=" + this.continuation + ")";
    }
}
