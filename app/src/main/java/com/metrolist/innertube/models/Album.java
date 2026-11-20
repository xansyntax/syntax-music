package com.metrolist.innertube.models;

import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Album {
    public final String id;
    public final String name;

    public Album(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.name = str;
        this.id = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Album)) {
            return false;
        }
        Album album = (Album) obj;
        return Intrinsics.areEqual(this.name, album.name) && Intrinsics.areEqual(this.id, album.id);
    }

    public final int hashCode() {
        return this.id.hashCode() + (this.name.hashCode() * 31);
    }

    public final String toString() {
        return Fragment$5$$ExternalSyntheticOutline0.m("Album(name=", this.name, ", id=", this.id, ")");
    }
}
