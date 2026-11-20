package com.metrolist.music.ui.screens.equalizer.wizard;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class WizardStep {
    public static final /* synthetic */ WizardStep[] $VALUES;
    public static final WizardStep MODEL_SELECTION;
    public static final WizardStep VARIANT_SELECTION;

    static {
        WizardStep wizardStep = new WizardStep("MODEL_SELECTION", 0);
        MODEL_SELECTION = wizardStep;
        WizardStep wizardStep2 = new WizardStep("VARIANT_SELECTION", 1);
        VARIANT_SELECTION = wizardStep2;
        $VALUES = new WizardStep[]{wizardStep, wizardStep2};
    }

    public static WizardStep valueOf(String str) {
        return (WizardStep) Enum.valueOf(WizardStep.class, str);
    }

    public static WizardStep[] values() {
        return (WizardStep[]) $VALUES.clone();
    }
}
