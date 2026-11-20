package com.metrolist.music.db.entities;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/db/entities/CachedArtistPage;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class CachedArtistPage {
    public final CachedArtistItem artist;
    public final String description;
    public final boolean isSubscribed;
    public final String monthlyListenerCount;
    public final List sections;
    public final String subscriberCountText;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new CachedItem$$ExternalSyntheticLambda0((byte) 2)), null, null, null, null};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/db/entities/CachedArtistPage$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/db/entities/CachedArtistPage;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return CachedArtistPage$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CachedArtistPage(int i, CachedArtistItem cachedArtistItem, List list, String str, String str2, String str3, boolean z) {
        if (2 != (i & 2)) {
            EnumsKt.throwMissingFieldException(CachedArtistPage$$serializer.INSTANCE.getDescriptor(), i, 2);
            throw null;
        }
        if ((i & 1) == 0) {
            this.artist = null;
        } else {
            this.artist = cachedArtistItem;
        }
        this.sections = list;
        if ((i & 4) == 0) {
            this.description = null;
        } else {
            this.description = str;
        }
        if ((i & 8) == 0) {
            this.subscriberCountText = null;
        } else {
            this.subscriberCountText = str2;
        }
        if ((i & 16) == 0) {
            this.monthlyListenerCount = null;
        } else {
            this.monthlyListenerCount = str3;
        }
        if ((i & 32) == 0) {
            this.isSubscribed = false;
        } else {
            this.isSubscribed = z;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CachedArtistPage)) {
            return false;
        }
        CachedArtistPage cachedArtistPage = (CachedArtistPage) obj;
        return Intrinsics.areEqual(this.artist, cachedArtistPage.artist) && Intrinsics.areEqual(this.sections, cachedArtistPage.sections) && Intrinsics.areEqual(this.description, cachedArtistPage.description) && Intrinsics.areEqual(this.subscriberCountText, cachedArtistPage.subscriberCountText) && Intrinsics.areEqual(this.monthlyListenerCount, cachedArtistPage.monthlyListenerCount) && this.isSubscribed == cachedArtistPage.isSubscribed;
    }

    public final int hashCode() {
        CachedArtistItem cachedArtistItem = this.artist;
        int iM = Fragment$5$$ExternalSyntheticOutline0.m((cachedArtistItem == null ? 0 : cachedArtistItem.hashCode()) * 31, 31, this.sections);
        String str = this.description;
        int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.subscriberCountText;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.monthlyListenerCount;
        return Boolean.hashCode(this.isSubscribed) + ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CachedArtistPage(artist=");
        sb.append(this.artist);
        sb.append(", sections=");
        sb.append(this.sections);
        sb.append(", description=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sb, this.description, ", subscriberCountText=", this.subscriberCountText, ", monthlyListenerCount=");
        sb.append(this.monthlyListenerCount);
        sb.append(", isSubscribed=");
        sb.append(this.isSubscribed);
        sb.append(")");
        return sb.toString();
    }

    public CachedArtistPage(CachedArtistItem cachedArtistItem, ArrayList arrayList, String str, String str2, String str3, boolean z) {
        this.artist = cachedArtistItem;
        this.sections = arrayList;
        this.description = str;
        this.subscriberCountText = str2;
        this.monthlyListenerCount = str3;
        this.isSubscribed = z;
    }
}
