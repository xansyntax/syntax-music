package com.metrolist.music.ui.screens.equalizer.wizard;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class WizardState {
    public final WizardStep currentStep;
    public final String error;
    public final boolean isComplete;
    public final boolean isDatabaseReady;
    public final boolean isLoading;
    public final String modelSearchQuery;
    public final List models;
    public final DeviceModel selectedModel;
    public final Set selectedVariantIds;
    public final List variants;

    public WizardState(WizardStep wizardStep, String str, List list, DeviceModel deviceModel, List list2, Set set, boolean z, boolean z2, String str2, boolean z3) {
        wizardStep.getClass();
        list.getClass();
        list2.getClass();
        set.getClass();
        this.currentStep = wizardStep;
        this.modelSearchQuery = str;
        this.models = list;
        this.selectedModel = deviceModel;
        this.variants = list2;
        this.selectedVariantIds = set;
        this.isDatabaseReady = z;
        this.isLoading = z2;
        this.error = str2;
        this.isComplete = z3;
    }

    public static WizardState copy$default(WizardState wizardState, WizardStep wizardStep, String str, List list, DeviceModel deviceModel, List list2, Set set, boolean z, String str2, int i) {
        if ((i & 1) != 0) {
            wizardStep = wizardState.currentStep;
        }
        WizardStep wizardStep2 = wizardStep;
        if ((i & 2) != 0) {
            str = wizardState.modelSearchQuery;
        }
        String str3 = str;
        List list3 = (i & 4) != 0 ? wizardState.models : list;
        DeviceModel deviceModel2 = (i & 8) != 0 ? wizardState.selectedModel : deviceModel;
        List list4 = (i & 16) != 0 ? wizardState.variants : list2;
        Set set2 = (i & 32) != 0 ? wizardState.selectedVariantIds : set;
        boolean z2 = (i & 64) != 0 ? wizardState.isDatabaseReady : true;
        boolean z3 = (i & 128) != 0 ? wizardState.isLoading : z;
        String str4 = (i & 256) != 0 ? wizardState.error : str2;
        boolean z4 = (i & 512) != 0 ? wizardState.isComplete : true;
        wizardState.getClass();
        wizardStep2.getClass();
        list3.getClass();
        list4.getClass();
        set2.getClass();
        return new WizardState(wizardStep2, str3, list3, deviceModel2, list4, set2, z2, z3, str4, z4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WizardState)) {
            return false;
        }
        WizardState wizardState = (WizardState) obj;
        return this.currentStep == wizardState.currentStep && this.modelSearchQuery.equals(wizardState.modelSearchQuery) && Intrinsics.areEqual(this.models, wizardState.models) && Intrinsics.areEqual(this.selectedModel, wizardState.selectedModel) && Intrinsics.areEqual(this.variants, wizardState.variants) && Intrinsics.areEqual(this.selectedVariantIds, wizardState.selectedVariantIds) && this.isDatabaseReady == wizardState.isDatabaseReady && this.isLoading == wizardState.isLoading && Intrinsics.areEqual(this.error, wizardState.error) && this.isComplete == wizardState.isComplete;
    }

    public final int hashCode() {
        int iM = Fragment$5$$ExternalSyntheticOutline0.m(Fragment$5$$ExternalSyntheticOutline0.m(this.currentStep.hashCode() * 31, 31, this.modelSearchQuery), 31, this.models);
        DeviceModel deviceModel = this.selectedModel;
        int iM2 = IntIntPair$$ExternalSyntheticOutline0.m(IntIntPair$$ExternalSyntheticOutline0.m((this.selectedVariantIds.hashCode() + Fragment$5$$ExternalSyntheticOutline0.m((iM + (deviceModel == null ? 0 : deviceModel.hashCode())) * 31, 31, this.variants)) * 31, this.isDatabaseReady, 31), this.isLoading, 31);
        String str = this.error;
        return Boolean.hashCode(this.isComplete) + ((iM2 + (str != null ? str.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("WizardState(currentStep=");
        sb.append(this.currentStep);
        sb.append(", modelSearchQuery=");
        sb.append(this.modelSearchQuery);
        sb.append(", models=");
        sb.append(this.models);
        sb.append(", selectedModel=");
        sb.append(this.selectedModel);
        sb.append(", variants=");
        sb.append(this.variants);
        sb.append(", selectedVariantIds=");
        sb.append(this.selectedVariantIds);
        sb.append(", isDatabaseReady=");
        Fragment$5$$ExternalSyntheticOutline0.m(sb, this.isDatabaseReady, ", isLoading=", this.isLoading, ", error=");
        sb.append(this.error);
        sb.append(", isComplete=");
        sb.append(this.isComplete);
        sb.append(")");
        return sb.toString();
    }
}
