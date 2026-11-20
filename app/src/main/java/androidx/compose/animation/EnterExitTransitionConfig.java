package androidx.compose.animation;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.EmptyMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class EnterExitTransitionConfig {
    public final ChangeSizeConfig changeSize;
    public final Map effectsMap;
    public final FadeConfig fade;
    public final boolean hold;
    public final ScaleConfig scale;
    public final SlideConfig slide;
    public final VeilConfig veil;

    public /* synthetic */ EnterExitTransitionConfig(FadeConfig fadeConfig, SlideConfig slideConfig, ChangeSizeConfig changeSizeConfig, ScaleConfig scaleConfig, VeilConfig veilConfig, LinkedHashMap linkedHashMap, int i) {
        this((i & 1) != 0 ? null : fadeConfig, (i & 2) != 0 ? null : slideConfig, (i & 4) != 0 ? null : changeSizeConfig, (i & 8) != 0 ? null : scaleConfig, (i & 16) != 0 ? null : veilConfig, (i & 32) == 0, (i & 64) != 0 ? EmptyMap.INSTANCE : linkedHashMap);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EnterExitTransitionConfig)) {
            return false;
        }
        EnterExitTransitionConfig enterExitTransitionConfig = (EnterExitTransitionConfig) obj;
        return Intrinsics.areEqual(this.fade, enterExitTransitionConfig.fade) && Intrinsics.areEqual(this.slide, enterExitTransitionConfig.slide) && Intrinsics.areEqual(this.changeSize, enterExitTransitionConfig.changeSize) && Intrinsics.areEqual(this.scale, enterExitTransitionConfig.scale) && Intrinsics.areEqual(this.veil, enterExitTransitionConfig.veil) && this.hold == enterExitTransitionConfig.hold && Intrinsics.areEqual(this.effectsMap, enterExitTransitionConfig.effectsMap);
    }

    public final int hashCode() {
        FadeConfig fadeConfig = this.fade;
        int iHashCode = (fadeConfig != null ? fadeConfig.hashCode() : 0) * 31;
        SlideConfig slideConfig = this.slide;
        int iHashCode2 = (iHashCode + (slideConfig != null ? slideConfig.hashCode() : 0)) * 31;
        ChangeSizeConfig changeSizeConfig = this.changeSize;
        int iHashCode3 = (iHashCode2 + (changeSizeConfig != null ? changeSizeConfig.hashCode() : 0)) * 31;
        ScaleConfig scaleConfig = this.scale;
        int iHashCode4 = (iHashCode3 + (scaleConfig != null ? scaleConfig.hashCode() : 0)) * 31;
        VeilConfig veilConfig = this.veil;
        return this.effectsMap.hashCode() + IntIntPair$$ExternalSyntheticOutline0.m((iHashCode4 + (veilConfig != null ? veilConfig.hashCode() : 0)) * 31, this.hold, 31);
    }

    public final String toString() {
        return "EnterExitTransitionConfig(fade=" + this.fade + ", slide=" + this.slide + ", changeSize=" + this.changeSize + ", scale=" + this.scale + ", veil=" + this.veil + ", hold=" + this.hold + ", effectsMap=" + this.effectsMap + ")";
    }

    public EnterExitTransitionConfig(FadeConfig fadeConfig, SlideConfig slideConfig, ChangeSizeConfig changeSizeConfig, ScaleConfig scaleConfig, VeilConfig veilConfig, boolean z, Map map) {
        this.fade = fadeConfig;
        this.slide = slideConfig;
        this.changeSize = changeSizeConfig;
        this.scale = scaleConfig;
        this.veil = veilConfig;
        this.hold = z;
        this.effectsMap = map;
    }
}
