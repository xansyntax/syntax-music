package com.valentinilk.shimmer;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.media3.common.Format$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;
import dev.chrisbanes.haze.HazeSourceNode;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ShimmerModifierKt {
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final Modifier shimmer(Modifier modifier, Composer composer, int i) {
        Rect rect;
        modifier.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        ShimmerTheme shimmerTheme = (ShimmerTheme) gapComposer.consume(ShimmerThemeKt.LocalShimmerTheme);
        shimmerTheme.getClass();
        StaticProvidableCompositionLocal staticProvidableCompositionLocal = CompositionLocalsKt.LocalDensity;
        float fMo81toPx0680j_4 = ((Density) gapComposer.consume(staticProvidableCompositionLocal)).mo81toPx0680j_4(shimmerTheme.shimmerWidth);
        boolean zChanged = gapComposer.changed(shimmerTheme);
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (zChanged || objRememberedValue == neverEqualPolicy) {
            ShimmerEffect shimmerEffect = new ShimmerEffect(shimmerTheme.animationSpec, shimmerTheme.blendMode, shimmerTheme.rotation, shimmerTheme.shaderColors, shimmerTheme.shaderColorStops, fMo81toPx0680j_4);
            gapComposer.updateRememberedValue(shimmerEffect);
            objRememberedValue = shimmerEffect;
        }
        ShimmerEffect shimmerEffect2 = (ShimmerEffect) objRememberedValue;
        boolean zChangedInstance = gapComposer.changedInstance(shimmerEffect2);
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = new HazeSourceNode.AnonymousClass1(shimmerEffect2, null, (byte) 7);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        Stack.LaunchedEffect(gapComposer, shimmerEffect2, (Function2) objRememberedValue2);
        Object obj = ShimmerBounds$Custom.INSTANCE;
        ShimmerBounds$View shimmerBounds$View = ShimmerBounds$View.INSTANCE;
        if (shimmerBounds$View.equals(obj)) {
            gapComposer.startReplaceGroup(741788154);
            gapComposer.end(false);
            rect = Rect.Zero;
        } else if (shimmerBounds$View.equals(shimmerBounds$View)) {
            gapComposer.startReplaceGroup(1520631015);
            gapComposer.end(false);
            rect = null;
        } else {
            if (!shimmerBounds$View.equals(ShimmerBounds$Window.INSTANCE)) {
                throw Format$$ExternalSyntheticOutline0.m(gapComposer, 741786390, false);
            }
            gapComposer.startReplaceGroup(741790476);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
                Rect rect2 = new Rect(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, displayMetrics.widthPixels, displayMetrics.heightPixels);
                gapComposer.updateRememberedValue(rect2);
                objRememberedValue3 = rect2;
            }
            rect = (Rect) objRememberedValue3;
            gapComposer.end(false);
        }
        boolean zChanged2 = gapComposer.changed(shimmerTheme) | gapComposer.changed(shimmerEffect2);
        Object objRememberedValue4 = gapComposer.rememberedValue();
        if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
            objRememberedValue4 = new Shimmer(shimmerTheme, shimmerEffect2, rect);
            gapComposer.updateRememberedValue(objRememberedValue4);
        }
        Shimmer shimmer = (Shimmer) objRememberedValue4;
        shimmer.boundsFlow.setValue(rect);
        GapComposer gapComposer2 = (GapComposer) composer;
        Density density = (Density) gapComposer2.consume(staticProvidableCompositionLocal);
        ShimmerTheme shimmerTheme2 = shimmer.theme;
        float f = shimmerTheme2.rotation;
        float fMo81toPx0680j_5 = density.mo81toPx0680j_4(shimmerTheme2.shimmerWidth);
        boolean zChanged3 = gapComposer2.changed(fMo81toPx0680j_5) | gapComposer2.changed(f);
        Object objRememberedValue5 = gapComposer2.rememberedValue();
        if (zChanged3 || objRememberedValue5 == neverEqualPolicy) {
            objRememberedValue5 = new ShimmerArea(fMo81toPx0680j_5, f);
            gapComposer2.updateRememberedValue(objRememberedValue5);
        }
        ShimmerArea shimmerArea = (ShimmerArea) objRememberedValue5;
        boolean zChangedInstance2 = gapComposer2.changedInstance(shimmer) | gapComposer2.changedInstance(shimmerArea);
        Object objRememberedValue6 = gapComposer2.rememberedValue();
        if (zChangedInstance2 || objRememberedValue6 == neverEqualPolicy) {
            objRememberedValue6 = new ShimmerModifierKt$shimmer$1$1(shimmer, shimmerArea, (Continuation) null, (byte) 0);
            gapComposer2.updateRememberedValue(objRememberedValue6);
        }
        Stack.LaunchedEffect(shimmerArea, shimmer, (Function2) objRememberedValue6, gapComposer2);
        ShimmerEffect shimmerEffect3 = shimmer.effect;
        shimmerArea.getClass();
        shimmerEffect3.getClass();
        ShimmerElement shimmerElement = new ShimmerElement();
        shimmerElement.area = shimmerArea;
        shimmerElement.effect = shimmerEffect3;
        return modifier.then(shimmerElement);
    }
}
