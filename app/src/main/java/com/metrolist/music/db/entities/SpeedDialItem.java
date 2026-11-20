package com.metrolist.music.db.entities;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SpeedDialItem {
    public final String albumId;
    public final String albumName;
    public final long createDate;
    public final boolean explicit;
    public final String id;
    public final String secondaryId;
    public final String subtitle;
    public final String subtitleIds;
    public final String thumbnailUrl;
    public final String title;
    public final String type;

    public /* synthetic */ SpeedDialItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, String str8, String str9, int i) {
        this(str, (i & 2) != 0 ? null : str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, str6, str7, (i & 128) != 0 ? false : z, System.currentTimeMillis(), (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : str9);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpeedDialItem)) {
            return false;
        }
        SpeedDialItem speedDialItem = (SpeedDialItem) obj;
        return Intrinsics.areEqual(this.id, speedDialItem.id) && Intrinsics.areEqual(this.secondaryId, speedDialItem.secondaryId) && Intrinsics.areEqual(this.title, speedDialItem.title) && Intrinsics.areEqual(this.subtitle, speedDialItem.subtitle) && Intrinsics.areEqual(this.subtitleIds, speedDialItem.subtitleIds) && Intrinsics.areEqual(this.thumbnailUrl, speedDialItem.thumbnailUrl) && Intrinsics.areEqual(this.type, speedDialItem.type) && this.explicit == speedDialItem.explicit && this.createDate == speedDialItem.createDate && Intrinsics.areEqual(this.albumId, speedDialItem.albumId) && Intrinsics.areEqual(this.albumName, speedDialItem.albumName);
    }

    public final int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.secondaryId;
        int iM = Fragment$5$$ExternalSyntheticOutline0.m((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.title);
        String str2 = this.subtitle;
        int iHashCode2 = (iM + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subtitleIds;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.thumbnailUrl;
        int iM2 = IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m((iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31, 31, this.type), this.explicit, 31), 31, this.createDate);
        String str5 = this.albumId;
        int iHashCode4 = (iM2 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.albumName;
        return iHashCode4 + (str6 != null ? str6.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("SpeedDialItem(id=", this.id, ", secondaryId=", this.secondaryId, ", title=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.title, ", subtitle=", this.subtitle, ", subtitleIds=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.subtitleIds, ", thumbnailUrl=", this.thumbnailUrl, ", type=");
        sbM.append(this.type);
        sbM.append(", explicit=");
        sbM.append(this.explicit);
        sbM.append(", createDate=");
        sbM.append(this.createDate);
        sbM.append(", albumId=");
        sbM.append(this.albumId);
        sbM.append(", albumName=");
        sbM.append(this.albumName);
        sbM.append(")");
        return sbM.toString();
    }

    public SpeedDialItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, long j, String str8, String str9) {
        str.getClass();
        str3.getClass();
        str7.getClass();
        this.id = str;
        this.secondaryId = str2;
        this.title = str3;
        this.subtitle = str4;
        this.subtitleIds = str5;
        this.thumbnailUrl = str6;
        this.type = str7;
        this.explicit = z;
        this.createDate = j;
        this.albumId = str8;
        this.albumName = str9;
    }
}
