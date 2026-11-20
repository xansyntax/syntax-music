package com.metrolist.music.ui.screens.equalizer.wizard;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EQProfileVariant {
    public final String description;
    public final String id;
    public final boolean isANC;
    public final boolean isPadModified;
    public final String modelId;
    public final String name;
    public final String rig;
    public final String source;
    public final String variant;

    public EQProfileVariant(String str, String str2, String str3, String str4, boolean z, boolean z2, String str5, String str6, String str7) {
        str3.getClass();
        str6.getClass();
        str7.getClass();
        this.id = str;
        this.modelId = str2;
        this.name = str3;
        this.variant = str4;
        this.isANC = z;
        this.isPadModified = z2;
        this.description = str5;
        this.source = str6;
        this.rig = str7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EQProfileVariant)) {
            return false;
        }
        EQProfileVariant eQProfileVariant = (EQProfileVariant) obj;
        return this.id.equals(eQProfileVariant.id) && this.modelId.equals(eQProfileVariant.modelId) && Intrinsics.areEqual(this.name, eQProfileVariant.name) && Intrinsics.areEqual(this.variant, eQProfileVariant.variant) && this.isANC == eQProfileVariant.isANC && this.isPadModified == eQProfileVariant.isPadModified && this.description.equals(eQProfileVariant.description) && Intrinsics.areEqual(this.source, eQProfileVariant.source) && Intrinsics.areEqual(this.rig, eQProfileVariant.rig);
    }

    public final String getRigDisplay() {
        String str = this.rig;
        return !Intrinsics.areEqual(str, "unknown") ? Fragment$5$$ExternalSyntheticOutline0.m("Rig: ", str) : "";
    }

    public final String getSourceDisplay() {
        String str = this.source;
        return !Intrinsics.areEqual(str, "unknown") ? Fragment$5$$ExternalSyntheticOutline0.m("Source: ", str) : "";
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.modelId), 31, this.name);
        String str = this.variant;
        return this.rig.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((iM + (str == null ? 0 : str.hashCode())) * 31, this.isANC, 31), this.isPadModified, 31), 31, this.description), 31, this.source);
    }

    public final String toString() {
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("EQProfileVariant(id=", this.id, ", modelId=", this.modelId, ", name=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.name, ", variant=", this.variant, ", isANC=");
        Fragment$5$$ExternalSyntheticOutline0.m(sbM, this.isANC, ", isPadModified=", this.isPadModified, ", description=");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, this.description, ", source=", this.source, ", rig=");
        return IntIntPair$$ExternalSyntheticOutline0.m(sbM, this.rig, ")");
    }
}
