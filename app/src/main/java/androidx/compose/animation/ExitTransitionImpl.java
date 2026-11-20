package androidx.compose.animation;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.LinkedHashMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ExitTransitionImpl {
    public static final ExitTransitionImpl KeepUntilTransitionsFinished;
    public static final ExitTransitionImpl None;
    public final EnterExitTransitionConfig config;

    static {
        LinkedHashMap linkedHashMap = null;
        FadeConfig fadeConfig = null;
        SlideConfig slideConfig = null;
        ChangeSizeConfig changeSizeConfig = null;
        ScaleConfig scaleConfig = null;
        VeilConfig veilConfig = null;
        None = new ExitTransitionImpl(new EnterExitTransitionConfig(fadeConfig, slideConfig, changeSizeConfig, scaleConfig, veilConfig, linkedHashMap, 127));
        KeepUntilTransitionsFinished = new ExitTransitionImpl(new EnterExitTransitionConfig(fadeConfig, slideConfig, changeSizeConfig, scaleConfig, veilConfig, linkedHashMap, 95));
    }

    public ExitTransitionImpl(EnterExitTransitionConfig enterExitTransitionConfig) {
        this.config = enterExitTransitionConfig;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ExitTransitionImpl) && ((ExitTransitionImpl) obj).config.equals(this.config);
    }

    public final int hashCode() {
        return this.config.hashCode();
    }

    public final ExitTransitionImpl plus(ExitTransitionImpl exitTransitionImpl) {
        ExitTransitionImpl exitTransitionImpl2 = None;
        if (equals(exitTransitionImpl2)) {
            return exitTransitionImpl;
        }
        if (Intrinsics.areEqual(exitTransitionImpl, exitTransitionImpl2)) {
            return this;
        }
        EnterExitTransitionConfig enterExitTransitionConfig = exitTransitionImpl.config;
        FadeConfig fadeConfig = enterExitTransitionConfig.fade;
        EnterExitTransitionConfig enterExitTransitionConfig2 = this.config;
        if (fadeConfig == null) {
            fadeConfig = enterExitTransitionConfig2.fade;
        }
        SlideConfig slideConfig = enterExitTransitionConfig.slide;
        if (slideConfig == null) {
            slideConfig = enterExitTransitionConfig2.slide;
        }
        ChangeSizeConfig changeSizeConfig = enterExitTransitionConfig.changeSize;
        if (changeSizeConfig == null) {
            changeSizeConfig = enterExitTransitionConfig2.changeSize;
        }
        ScaleConfig scaleConfig = enterExitTransitionConfig.scale;
        if (scaleConfig == null) {
            scaleConfig = enterExitTransitionConfig2.scale;
        }
        VeilConfig veilConfig = enterExitTransitionConfig.veil;
        if (veilConfig == null) {
            veilConfig = enterExitTransitionConfig2.veil;
        }
        return new ExitTransitionImpl(new EnterExitTransitionConfig(fadeConfig, slideConfig, changeSizeConfig, scaleConfig, veilConfig, enterExitTransitionConfig.hold || enterExitTransitionConfig2.hold, MapsKt__MapsKt.plus(enterExitTransitionConfig2.effectsMap, enterExitTransitionConfig.effectsMap)));
    }

    public final String toString() {
        if (equals(None)) {
            return "ExitTransition.None";
        }
        if (equals(KeepUntilTransitionsFinished)) {
            return "ExitTransition.KeepUntilTransitionsFinished";
        }
        EnterExitTransitionConfig enterExitTransitionConfig = this.config;
        FadeConfig fadeConfig = enterExitTransitionConfig.fade;
        String string = fadeConfig != null ? fadeConfig.toString() : null;
        SlideConfig slideConfig = enterExitTransitionConfig.slide;
        String string2 = slideConfig != null ? slideConfig.toString() : null;
        ChangeSizeConfig changeSizeConfig = enterExitTransitionConfig.changeSize;
        String string3 = changeSizeConfig != null ? changeSizeConfig.toString() : null;
        ScaleConfig scaleConfig = enterExitTransitionConfig.scale;
        String string4 = scaleConfig != null ? scaleConfig.toString() : null;
        VeilConfig veilConfig = enterExitTransitionConfig.veil;
        String string5 = veilConfig != null ? veilConfig.toString() : null;
        boolean z = enterExitTransitionConfig.hold;
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("ExitTransition:  Fade - ", string, ",  Slide - ", string2, ",  Shrink - ");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, string3, ",  Scale - ", string4, ",  Veil - ");
        sbM.append(string5);
        sbM.append(",  KeepUntilTransitionsFinished - ");
        sbM.append(z);
        return sbM.toString();
    }
}
