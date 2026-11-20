package com.metrolist.music.eq.data;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00022\u00020\u0001:\u0002\u0003\u0002¨\u0006\u0004"}, d2 = {"Lcom/metrolist/music/eq/data/SavedEQProfile;", "", "Companion", "$serializer", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
public final /* data */ class SavedEQProfile {
    public final long addedTimestamp;
    public final List bands;
    public final String deviceModel;
    public final String id;
    public final boolean isActive;
    public final boolean isCustom;
    public final String name;
    public final double preamp;
    public final String rig;
    public final String source;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Lazy[] $childSerializers = {null, null, null, ResultKt.lazy(LazyThreadSafetyMode.PUBLICATION, new FilterType$$ExternalSyntheticLambda0(5)), null, null, null, null, null, null};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/metrolist/music/eq/data/SavedEQProfile$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/metrolist/music/eq/data/SavedEQProfile;", "serializer", "()Lkotlinx/serialization/KSerializer;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public final KSerializer serializer() {
            return SavedEQProfile$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SavedEQProfile(int i, String str, String str2, String str3, List list, double d, String str4, String str5, boolean z, boolean z2, long j) {
        if (15 != (i & 15)) {
            EnumsKt.throwMissingFieldException(SavedEQProfile$$serializer.INSTANCE.getDescriptor(), i, 15);
            throw null;
        }
        this.id = str;
        this.name = str2;
        this.deviceModel = str3;
        this.bands = list;
        if ((i & 16) == 0) {
            this.preamp = 0.0d;
        } else {
            this.preamp = d;
        }
        if ((i & 32) == 0) {
            this.source = "unknown";
        } else {
            this.source = str4;
        }
        if ((i & 64) == 0) {
            this.rig = "unknown";
        } else {
            this.rig = str5;
        }
        if ((i & 128) == 0) {
            this.isCustom = false;
        } else {
            this.isCustom = z;
        }
        if ((i & 256) == 0) {
            this.isActive = false;
        } else {
            this.isActive = z2;
        }
        if ((i & 512) == 0) {
            this.addedTimestamp = System.currentTimeMillis();
        } else {
            this.addedTimestamp = j;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SavedEQProfile)) {
            return false;
        }
        SavedEQProfile savedEQProfile = (SavedEQProfile) obj;
        return Intrinsics.areEqual(this.id, savedEQProfile.id) && Intrinsics.areEqual(this.name, savedEQProfile.name) && Intrinsics.areEqual(this.deviceModel, savedEQProfile.deviceModel) && Intrinsics.areEqual(this.bands, savedEQProfile.bands) && Double.compare(this.preamp, savedEQProfile.preamp) == 0 && Intrinsics.areEqual(this.source, savedEQProfile.source) && Intrinsics.areEqual(this.rig, savedEQProfile.rig) && this.isCustom == savedEQProfile.isCustom && this.isActive == savedEQProfile.isActive && this.addedTimestamp == savedEQProfile.addedTimestamp;
    }

    public final int hashCode() {
        return Long.hashCode(this.addedTimestamp) + IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.preamp, Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.name), 31, this.deviceModel), 31, this.bands), 31), 31, this.source), 31, this.rig), this.isCustom, 31), this.isActive, 31);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("SavedEQProfile(id=", this.id, ", name=", this.name, ", deviceModel=");
        sbM.append(this.deviceModel);
        sbM.append(", bands=");
        sbM.append(this.bands);
        sbM.append(", preamp=");
        sbM.append(this.preamp);
        sbM.append(", source=");
        sbM.append(this.source);
        sbM.append(", rig=");
        sbM.append(this.rig);
        sbM.append(", isCustom=");
        sbM.append(this.isCustom);
        sbM.append(", isActive=");
        sbM.append(this.isActive);
        sbM.append(", addedTimestamp=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.addedTimestamp, ")");
    }

    public SavedEQProfile(String str, String str2, String str3, List list, double d, String str4, String str5, int i) {
        str4 = (i & 32) != 0 ? "unknown" : str4;
        str5 = (i & 64) != 0 ? "unknown" : str5;
        long jCurrentTimeMillis = System.currentTimeMillis();
        str2.getClass();
        str3.getClass();
        list.getClass();
        str4.getClass();
        str5.getClass();
        this.id = str;
        this.name = str2;
        this.deviceModel = str3;
        this.bands = list;
        this.preamp = d;
        this.source = str4;
        this.rig = str5;
        this.isCustom = true;
        this.isActive = false;
        this.addedTimestamp = jCurrentTimeMillis;
    }
}
