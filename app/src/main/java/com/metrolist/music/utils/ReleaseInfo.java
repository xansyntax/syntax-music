package com.metrolist.music.utils;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ReleaseInfo {
    public final ArrayList assets;
    public final String description;
    public final String releaseDate;
    public final String tagName;
    public final String versionName;

    public ReleaseInfo(String str, String str2, String str3, String str4, ArrayList arrayList) {
        this.tagName = str;
        this.versionName = str2;
        this.description = str3;
        this.releaseDate = str4;
        this.assets = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReleaseInfo)) {
            return false;
        }
        ReleaseInfo releaseInfo = (ReleaseInfo) obj;
        return this.tagName.equals(releaseInfo.tagName) && this.versionName.equals(releaseInfo.versionName) && this.description.equals(releaseInfo.description) && this.releaseDate.equals(releaseInfo.releaseDate) && this.assets.equals(releaseInfo.assets);
    }

    public final int hashCode() {
        return this.assets.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.tagName.hashCode() * 31, 31, this.versionName), 31, this.description), 31, this.releaseDate);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("ReleaseInfo(tagName=", this.tagName, ", versionName=", this.versionName, ", description=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.description, ", releaseDate=", this.releaseDate, ", assets=");
        sbM.append(this.assets);
        sbM.append(")");
        return sbM.toString();
    }
}
