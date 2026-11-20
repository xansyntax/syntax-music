package com.metrolist.music.db.entities;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/db/entities/CachedArtistItem;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class CachedArtistItem {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public final String channelId;
    public final String id;
    public final boolean isProfile;
    public final String thumbnail;
    public final String title;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/db/entities/CachedArtistItem$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/db/entities/CachedArtistItem;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return CachedArtistItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CachedArtistItem(int i, String str, String str2, String str3, String str4, boolean z) {
        if (3 != (i & 3)) {
            EnumsKt.throwMissingFieldException(CachedArtistItem$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.id = str;
        this.title = str2;
        if ((i & 4) == 0) {
            this.thumbnail = null;
        } else {
            this.thumbnail = str3;
        }
        if ((i & 8) == 0) {
            this.channelId = null;
        } else {
            this.channelId = str4;
        }
        if ((i & 16) == 0) {
            this.isProfile = false;
        } else {
            this.isProfile = z;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CachedArtistItem)) {
            return false;
        }
        CachedArtistItem cachedArtistItem = (CachedArtistItem) obj;
        return Intrinsics.areEqual(this.id, cachedArtistItem.id) && Intrinsics.areEqual(this.title, cachedArtistItem.title) && Intrinsics.areEqual(this.thumbnail, cachedArtistItem.thumbnail) && Intrinsics.areEqual(this.channelId, cachedArtistItem.channelId) && this.isProfile == cachedArtistItem.isProfile;
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.title);
        String str = this.thumbnail;
        int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.channelId;
        return Boolean.hashCode(this.isProfile) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("CachedArtistItem(id=", this.id, ", title=", this.title, ", thumbnail=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.thumbnail, ", channelId=", this.channelId, ", isProfile=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.isProfile, ")");
    }

    public CachedArtistItem(String str, String str2, String str3, String str4, boolean z) {
        str.getClass();
        str2.getClass();
        this.id = str;
        this.title = str2;
        this.thumbnail = str3;
        this.channelId = str4;
        this.isProfile = z;
    }
}
