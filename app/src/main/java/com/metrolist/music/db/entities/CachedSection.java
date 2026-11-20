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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/db/entities/CachedSection;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class CachedSection {
    public final List items;
    public final String moreBrowseId;
    public final String moreParams;
    public final String title;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new CachedItem$$ExternalSyntheticLambda0((byte) 5)), null, null};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/db/entities/CachedSection$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/db/entities/CachedSection;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return CachedSection$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CachedSection(int i, String str, List list, String str2, String str3) {
        if (3 != (i & 3)) {
            EnumsKt.throwMissingFieldException(CachedSection$$serializer.INSTANCE.getDescriptor(), i, 3);
            throw null;
        }
        this.title = str;
        this.items = list;
        if ((i & 4) == 0) {
            this.moreBrowseId = null;
        } else {
            this.moreBrowseId = str2;
        }
        if ((i & 8) == 0) {
            this.moreParams = null;
        } else {
            this.moreParams = str3;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CachedSection)) {
            return false;
        }
        CachedSection cachedSection = (CachedSection) obj;
        return Intrinsics.areEqual(this.title, cachedSection.title) && Intrinsics.areEqual(this.items, cachedSection.items) && Intrinsics.areEqual(this.moreBrowseId, cachedSection.moreBrowseId) && Intrinsics.areEqual(this.moreParams, cachedSection.moreParams);
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(this.title.hashCode() * 31, 31, this.items);
        String str = this.moreBrowseId;
        int iHashCode = (iM + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.moreParams;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CachedSection(title=");
        sb.append(this.title);
        sb.append(", items=");
        sb.append(this.items);
        sb.append(", moreBrowseId=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sb, this.moreBrowseId, ", moreParams=", this.moreParams, ")");
    }

    public CachedSection(String str, ArrayList arrayList, String str2, String str3) {
        str.getClass();
        this.title = str;
        this.items = arrayList;
        this.moreBrowseId = str2;
        this.moreParams = str3;
    }
}
