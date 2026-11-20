package com.metrolist.music.ui.component;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class LinkSegment {
    public final String text;
    public final String url;

    public LinkSegment(String str, String str2) {
        str.getClass();
        this.text = str;
        this.url = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinkSegment)) {
            return false;
        }
        LinkSegment linkSegment = (LinkSegment) obj;
        return Intrinsics.areEqual(this.text, linkSegment.text) && Intrinsics.areEqual(this.url, linkSegment.url);
    }

    public final int hashCode() {
        int iHashCode = this.text.hashCode() * 31;
        String str = this.url;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("LinkSegment(text=", this.text, ", url=", this.url, ")");
    }
}
