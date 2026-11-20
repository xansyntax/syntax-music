package androidx.compose.animation;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.LinkedHashMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EnterTransitionImpl {
    public static final EnterTransitionImpl None = new EnterTransitionImpl(new EnterExitTransitionConfig((FadeConfig) null, (SlideConfig) null, (ChangeSizeConfig) null, (ScaleConfig) null, (VeilConfig) null, (LinkedHashMap) null, 127));
    public final EnterExitTransitionConfig config;

    public EnterTransitionImpl(EnterExitTransitionConfig enterExitTransitionConfig) {
        this.config = enterExitTransitionConfig;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof EnterTransitionImpl) && ((EnterTransitionImpl) obj).config.equals(this.config);
    }

    public final int hashCode() {
        return this.config.hashCode();
    }

    public final EnterTransitionImpl plus(EnterTransitionImpl enterTransitionImpl) {
        EnterTransitionImpl enterTransitionImpl2 = None;
        if (equals(enterTransitionImpl2)) {
            return enterTransitionImpl;
        }
        if (Intrinsics.areEqual(enterTransitionImpl, enterTransitionImpl2)) {
            return this;
        }
        EnterExitTransitionConfig enterExitTransitionConfig = enterTransitionImpl.config;
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
        return new EnterTransitionImpl(new EnterExitTransitionConfig(fadeConfig, slideConfig, changeSizeConfig, scaleConfig, veilConfig, MapsKt__MapsKt.plus(enterExitTransitionConfig2.effectsMap, enterExitTransitionConfig.effectsMap), 32));
    }

    public final String toString() {
        if (equals(None)) {
            return "EnterTransition.None";
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
        StringBuilder sbM = IntIntPair$$ExternalSyntheticOutline0.m("EnterTransition: Fade - ", string, ", Slide - ", string2, ", Shrink - ");
        IntIntPair$$ExternalSyntheticOutline0.m6m(sbM, string3, ", Scale - ", string4, ", Veil - ");
        sbM.append(string5);
        return sbM.toString();
    }
}
