package com.metrolist.innertube.models;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AlbumItem extends YTItem {
    public final List artists;
    public final String browseId;
    public final boolean explicit;
    public final String id;
    public final String playlistId;
    public final String thumbnail;
    public final String title;
    public final Integer year;

    public AlbumItem(Integer num, String str, String str2, String str3, String str4, String str5, List list, boolean z) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        this.browseId = str;
        this.playlistId = str2;
        this.id = str3;
        this.title = str4;
        this.artists = list;
        this.year = num;
        this.thumbnail = str5;
        this.explicit = z;
    }

    public static AlbumItem copy$default(AlbumItem albumItem, List list) {
        String str = albumItem.browseId;
        String str2 = albumItem.playlistId;
        String str3 = albumItem.id;
        String str4 = albumItem.title;
        Integer num = albumItem.year;
        String str5 = albumItem.thumbnail;
        boolean z = albumItem.explicit;
        albumItem.getClass();
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        return new AlbumItem(num, str, str2, str3, str4, str5, list, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlbumItem)) {
            return false;
        }
        AlbumItem albumItem = (AlbumItem) obj;
        return Intrinsics.areEqual(this.browseId, albumItem.browseId) && Intrinsics.areEqual(this.playlistId, albumItem.playlistId) && Intrinsics.areEqual(this.id, albumItem.id) && Intrinsics.areEqual(this.title, albumItem.title) && Intrinsics.areEqual(this.artists, albumItem.artists) && Intrinsics.areEqual(this.year, albumItem.year) && Intrinsics.areEqual(this.thumbnail, albumItem.thumbnail) && this.explicit == albumItem.explicit;
    }

    @Override // com.metrolist.innertube.models.YTItem
    public final boolean getExplicit() {
        return this.explicit;
    }

    @Override // com.metrolist.innertube.models.YTItem
    public final String getId() {
        return this.id;
    }

    @Override // com.metrolist.innertube.models.YTItem
    public final String getThumbnail() {
        return this.thumbnail;
    }

    @Override // com.metrolist.innertube.models.YTItem
    public final String getTitle() {
        return this.title;
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.browseId.hashCode() * 31, 31, this.playlistId), 31, this.id), 31, this.title);
        List list = this.artists;
        int iHashCode = (iM + (list == null ? 0 : list.hashCode())) * 31;
        Integer num = this.year;
        return Boolean.hashCode(this.explicit) + Fragment$5$$ExternalSyntheticOutline0.m((iHashCode + (num != null ? num.hashCode() : 0)) * 31, 31, this.thumbnail);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("AlbumItem(browseId=", this.browseId, ", playlistId=", this.playlistId, ", id=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.id, ", title=", this.title, ", artists=");
        sbM.append(this.artists);
        sbM.append(", year=");
        sbM.append(this.year);
        sbM.append(", thumbnail=");
        sbM.append(this.thumbnail);
        sbM.append(", explicit=");
        sbM.append(this.explicit);
        sbM.append(")");
        return sbM.toString();
    }

    public /* synthetic */ AlbumItem(String str, String str2, String str3, List list, Integer num, String str4, boolean z, int i) {
        this((i & 32) != 0 ? null : num, str, str2, str, str3, str4, list, (i & 128) != 0 ? false : z);
    }
}
