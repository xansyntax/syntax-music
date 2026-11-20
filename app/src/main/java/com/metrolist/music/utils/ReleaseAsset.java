package com.metrolist.music.utils;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ReleaseAsset {
    public final String architecture;
    public final String downloadUrl;
    public final String name;
    public final long size;
    public final String variant;

    public ReleaseAsset(String str, String str2, long j, String str3, String str4) {
        this.name = str;
        this.downloadUrl = str2;
        this.size = j;
        this.architecture = str3;
        this.variant = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReleaseAsset)) {
            return false;
        }
        ReleaseAsset releaseAsset = (ReleaseAsset) obj;
        return this.name.equals(releaseAsset.name) && this.downloadUrl.equals(releaseAsset.downloadUrl) && this.size == releaseAsset.size && this.architecture.equals(releaseAsset.architecture) && this.variant.equals(releaseAsset.variant);
    }

    public final int hashCode() {
        return this.variant.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.name.hashCode() * 31, 31, this.downloadUrl), 31, this.size), 31, this.architecture);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("ReleaseAsset(name=", this.name, ", downloadUrl=", this.downloadUrl, ", size=");
        sbM.append(this.size);
        sbM.append(", architecture=");
        sbM.append(this.architecture);
        sbM.append(", variant=");
        sbM.append(this.variant);
        sbM.append(")");
        return sbM.toString();
    }
}
