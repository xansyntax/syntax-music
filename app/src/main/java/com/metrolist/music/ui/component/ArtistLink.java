package com.metrolist.music.ui.component;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ArtistLink {
    public final String id;
    public final String name;

    public ArtistLink(String str, String str2) {
        str2.getClass();
        this.id = str;
        this.name = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ArtistLink)) {
            return false;
        }
        ArtistLink artistLink = (ArtistLink) obj;
        return Intrinsics.areEqual(this.id, artistLink.id) && Intrinsics.areEqual(this.name, artistLink.name);
    }

    public final int hashCode() {
        String str = this.id;
        return this.name.hashCode() + ((str == null ? 0 : str.hashCode()) * 31);
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("ArtistLink(id=", this.id, ", name=", this.name, ")");
    }
}
