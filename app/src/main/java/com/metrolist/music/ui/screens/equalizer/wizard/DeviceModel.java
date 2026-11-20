package com.metrolist.music.ui.screens.equalizer.wizard;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DeviceModel {
    public final boolean hasMultipleVariants;
    public final String id;
    public final String name;

    public DeviceModel(String str, String str2, boolean z) {
        this.id = str;
        this.name = str2;
        this.hasMultipleVariants = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceModel)) {
            return false;
        }
        DeviceModel deviceModel = (DeviceModel) obj;
        return this.id.equals(deviceModel.id) && this.name.equals(deviceModel.name) && this.hasMultipleVariants == deviceModel.hasMultipleVariants;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.hasMultipleVariants) + Fragment$5$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 961, this.name);
    }

    public final String toString() {
        return IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m("DeviceModel(id=", this.id, ", name=", this.name, ", imageUrl=null, hasMultipleVariants="), this.hasMultipleVariants, ")");
    }
}
