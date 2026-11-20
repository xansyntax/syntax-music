package com.metrolist.music.ui.screens.settings;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.graphics.shapes.RoundedPolygon;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class Contributor {
    public final String avatarUrl;
    public final String favoriteSongVideoId;
    public final String githubHandle;
    public final String githubUrl;
    public final String name;
    public final RoundedPolygon polygon;
    public final int roleRes;
    public final String sponsorUrl;

    public Contributor(String str, int i, String str2, String str3, RoundedPolygon roundedPolygon, String str4, int i2) {
        String strM = IntIntPair$$ExternalSyntheticOutline0.m("https://github.com/", str2, ".png");
        String strConcat = "https://github.com/".concat(str2);
        str3 = (i2 & 32) != 0 ? null : str3;
        this.name = str;
        this.roleRes = i;
        this.githubHandle = str2;
        this.avatarUrl = strM;
        this.githubUrl = strConcat;
        this.sponsorUrl = str3;
        this.polygon = roundedPolygon;
        this.favoriteSongVideoId = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Contributor)) {
            return false;
        }
        Contributor contributor = (Contributor) obj;
        return this.name.equals(contributor.name) && this.roleRes == contributor.roleRes && this.githubHandle.equals(contributor.githubHandle) && this.avatarUrl.equals(contributor.avatarUrl) && this.githubUrl.equals(contributor.githubUrl) && Intrinsics.areEqual(this.sponsorUrl, contributor.sponsorUrl) && this.polygon.equals(contributor.polygon) && this.favoriteSongVideoId.equals(contributor.favoriteSongVideoId);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(this.roleRes, this.name.hashCode() * 31, 31), 31, this.githubHandle), 31, this.avatarUrl), 31, this.githubUrl);
        String str = this.sponsorUrl;
        return this.favoriteSongVideoId.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m((iM + (str == null ? 0 : str.hashCode())) * 31, 31, this.polygon.features);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Contributor(name=");
        sb.append(this.name);
        sb.append(", roleRes=");
        sb.append(this.roleRes);
        sb.append(", githubHandle=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, this.githubHandle, ", avatarUrl=", this.avatarUrl, ", githubUrl=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, this.githubUrl, ", sponsorUrl=", this.sponsorUrl, ", polygon=");
        sb.append(this.polygon);
        sb.append(", favoriteSongVideoId=");
        sb.append(this.favoriteSongVideoId);
        sb.append(")");
        return sb.toString();
    }
}
