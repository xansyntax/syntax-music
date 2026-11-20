package com.metrolist.innertube.models;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Artist {
    public final String id;
    public final String name;

    public Artist(String str, String str2) {
        str.getClass();
        this.name = str;
        this.id = str2;
    }

    public static Artist copy$default(Artist artist, String str) {
        String str2 = artist.name;
        artist.getClass();
        str2.getClass();
        return new Artist(str2, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Artist)) {
            return false;
        }
        Artist artist = (Artist) obj;
        return Intrinsics.areEqual(this.name, artist.name) && Intrinsics.areEqual(this.id, artist.id);
    }

    public final int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.id;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("Artist(name=", this.name, ", id=", this.id, ")");
    }
}
