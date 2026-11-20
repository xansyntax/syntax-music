package androidx.compose.material3;

import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.material3.internal.ChildSemanticsNodeElement;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerElement;
import androidx.compose.ui.graphics.LayerOutsets;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SurfaceKt {
    public static final StaticProvidableCompositionLocal LocalAbsoluteTonalElevation = new StaticProvidableCompositionLocal(new TextKt$$ExternalSyntheticLambda3((byte) 9), (byte) 1);

    /* JADX INFO: renamed from: Surface-T9BRK9s, reason: not valid java name */
    public static final void m337SurfaceT9BRK9s(Modifier modifier, Shape shape, long j, long j2, float f, float f2, BorderStroke borderStroke, final ComposableLambdaImpl composableLambdaImpl, Composer composer, int i, int i2) {
        if ((i2 & 1) != 0) {
            modifier = Modifier.Companion.$$INSTANCE;
        }
        if ((i2 & 2) != 0) {
            shape = ColorKt.RectangleShape;
        }
        if ((i2 & 4) != 0) {
            j = ((MaterialTheme$Values) ((GapComposer) composer).consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surface;
        }
        if ((i2 & 8) != 0) {
            j2 = ColorSchemeKt.m282contentColorForek8zF_U(j, composer);
        }
        if ((i2 & 16) != 0) {
            f = 0.0f;
        }
        if ((i2 & 32) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 64) != 0) {
            borderStroke = null;
        }
        GapComposer gapComposer = (GapComposer) composer;
        StaticProvidableCompositionLocal staticProvidableCompositionLocal = LocalAbsoluteTonalElevation;
        final float f3 = ((Dp) gapComposer.consume(staticProvidableCompositionLocal)).value + f + CropImageView.DEFAULT_ASPECT_RATIO;
        ProvidedValue[] providedValueArr = {Fragment$5$$ExternalSyntheticOutline0.m(j2, ContentColorKt.LocalContentColor), staticProvidableCompositionLocal.defaultProvidedValue$runtime(new Dp(f3))};
        final long j3 = j;
        final Shape shape2 = shape;
        final BorderStroke borderStroke2 = borderStroke;
        final float f4 = f2;
        final Modifier modifier2 = modifier;
        Stack.CompositionLocalProvider(providedValueArr, Expect_jvmKt.rememberComposableLambda(421772006, new Function2() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Composer composer2 = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) composer2;
                boolean zShouldExecute = gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2);
                Unit unit = Unit.INSTANCE;
                if (!zShouldExecute) {
                    gapComposer2.skipToGroupEnd();
                    return unit;
                }
                Modifier modifierM340surfaceXOJAsU = SurfaceKt.m340surfaceXOJAsU(modifier2, shape2, SurfaceKt.m341surfaceColorAtElevationCLU3JFs(j3, f3, gapComposer2), borderStroke2, ((Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity)).mo81toPx0680j_4(f4));
                Object objRememberedValue = gapComposer2.rememberedValue();
                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 5);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierM340surfaceXOJAsU, false, (Function1) objRememberedValue);
                Object objRememberedValue2 = gapComposer2.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = SurfaceKt$Surface$1$3$1.INSTANCE;
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierSemantics, unit, (PointerInputEventHandler) objRememberedValue2);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
                int iHashCode = Long.hashCode(gapComposer2.compositeKeyHashCode);
                PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer2, modifierPointerInput);
                ComposeUiNode.Companion.getClass();
                gapComposer2.startReusableNode();
                if (gapComposer2.inserting) {
                    gapComposer2.createNode(LayoutNode.Constructor);
                } else {
                    gapComposer2.useNode();
                }
                Stack.m390setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Stack.m390setimpl(gapComposer2, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                Stack.m390setimpl(gapComposer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                Stack.m389reconcileimpl(gapComposer2);
                Stack.m390setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                Fragment$5$$ExternalSyntheticOutline0.m(0, composableLambdaImpl, gapComposer2, true);
                return unit;
            }
        }, gapComposer), gapComposer, 56);
    }

    /* JADX INFO: renamed from: Surface-d85dljk, reason: not valid java name */
    public static final void m338Surfaced85dljk(boolean z, Function0 function0, Modifier modifier, boolean z2, Shape shape, long j, long j2, float f, BorderStroke borderStroke, MutableInteractionSourceImpl mutableInteractionSourceImpl, ComposableLambdaImpl composableLambdaImpl, Composer composer, int i, int i2) {
        boolean z3 = (i2 & 8) != 0 ? true : z2;
        long jM282contentColorForek8zF_U = (i2 & 64) != 0 ? ColorSchemeKt.m282contentColorForek8zF_U(j, composer) : j2;
        float f2 = (i2 & 256) != 0 ? 0.0f : f;
        MutableInteractionSourceImpl mutableInteractionSourceImpl2 = (i2 & 1024) != 0 ? null : mutableInteractionSourceImpl;
        if (mutableInteractionSourceImpl2 == null) {
            GapComposer gapComposer = (GapComposer) composer;
            gapComposer.startReplaceGroup(1528105640);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
            }
            gapComposer.end(false);
            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
        } else {
            GapComposer gapComposer2 = (GapComposer) composer;
            gapComposer2.startReplaceGroup(-227801585);
            gapComposer2.end(false);
        }
        GapComposer gapComposer3 = (GapComposer) composer;
        StaticProvidableCompositionLocal staticProvidableCompositionLocal = LocalAbsoluteTonalElevation;
        float f3 = ((Dp) gapComposer3.consume(staticProvidableCompositionLocal)).value + CropImageView.DEFAULT_ASPECT_RATIO + CropImageView.DEFAULT_ASPECT_RATIO;
        Stack.CompositionLocalProvider(new ProvidedValue[]{Fragment$5$$ExternalSyntheticOutline0.m(jM282contentColorForek8zF_U, ContentColorKt.LocalContentColor), staticProvidableCompositionLocal.defaultProvidedValue$runtime(new Dp(f3))}, Expect_jvmKt.rememberComposableLambda(1508735219, new SurfaceKt$$ExternalSyntheticLambda0(modifier, mutableInteractionSourceImpl2, shape, j, f3, borderStroke, z, z3, function0, f2, composableLambdaImpl, (byte) 0), gapComposer3), gapComposer3, 56);
    }

    /* JADX INFO: renamed from: Surface-o_FOJdg, reason: not valid java name */
    public static final void m339Surfaceo_FOJdg(final Function0 function0, final Modifier modifier, boolean z, final Shape shape, final long j, long j2, float f, float f2, BorderStroke borderStroke, MutableInteractionSourceImpl mutableInteractionSourceImpl, final Function2 function2, Composer composer, int i, int i2) {
        final boolean z2 = (i2 & 4) != 0 ? true : z;
        long jM282contentColorForek8zF_U = (i2 & 32) != 0 ? ColorSchemeKt.m282contentColorForek8zF_U(j, composer) : j2;
        float f3 = (i2 & 64) != 0 ? 0.0f : f;
        final float f4 = (i2 & 128) != 0 ? 0.0f : f2;
        final BorderStroke borderStroke2 = (i2 & 256) != 0 ? null : borderStroke;
        MutableInteractionSourceImpl mutableInteractionSourceImpl2 = (i2 & 512) == 0 ? mutableInteractionSourceImpl : null;
        GapComposer gapComposer = (GapComposer) composer;
        if (mutableInteractionSourceImpl2 == null) {
            gapComposer.startReplaceGroup(-1701074900);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = IntIntPair$$ExternalSyntheticOutline0.m(gapComposer);
            }
            mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue;
        } else {
            gapComposer.startReplaceGroup(2023335947);
        }
        gapComposer.end(false);
        GapComposer gapComposer2 = (GapComposer) composer;
        StaticProvidableCompositionLocal staticProvidableCompositionLocal = LocalAbsoluteTonalElevation;
        final float f5 = ((Dp) gapComposer2.consume(staticProvidableCompositionLocal)).value + f3 + CropImageView.DEFAULT_ASPECT_RATIO;
        final MutableInteractionSourceImpl mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
        Stack.CompositionLocalProvider(new ProvidedValue[]{Fragment$5$$ExternalSyntheticOutline0.m(jM282contentColorForek8zF_U, ContentColorKt.LocalContentColor), staticProvidableCompositionLocal.defaultProvidedValue$runtime(new Dp(f5))}, Expect_jvmKt.rememberComposableLambda(849208527, new Function2() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Composer composer2 = (Composer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) composer2;
                if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    HorizontalAlignmentLine horizontalAlignmentLine = InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine;
                    Modifier modifierThen = modifier.then(MinimumInteractiveModifier.INSTANCE);
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = RippleKt.LocalRippleThemeConfiguration;
                    ((RippleThemeConfiguration) gapComposer3.consume(staticProvidableCompositionLocal2)).getClass();
                    Modifier modifierThen2 = modifierThen.then(Modifier.Companion.$$INSTANCE);
                    long jM341surfaceColorAtElevationCLU3JFs = SurfaceKt.m341surfaceColorAtElevationCLU3JFs(j, f5, gapComposer3);
                    float fMo81toPx0680j_4 = ((Density) gapComposer3.consume(CompositionLocalsKt.LocalDensity)).mo81toPx0680j_4(f4);
                    Shape shape2 = shape;
                    Modifier modifierM340surfaceXOJAsU = SurfaceKt.m340surfaceXOJAsU(modifierThen2, shape2, jM341surfaceColorAtElevationCLU3JFs, borderStroke2, fMo81toPx0680j_4);
                    ((RippleThemeConfiguration) gapComposer3.consume(staticProvidableCompositionLocal2)).getClass();
                    Modifier modifierThen3 = ImageKt.m45clickableO2vRcR0$default(modifierM340surfaceXOJAsU, mutableInteractionSourceImpl3, RippleKt.m313rippleOu1YvPQ$default(false, CropImageView.DEFAULT_ASPECT_RATIO, 0L, shape2, 215), z2, null, function0, 24).then(new ChildSemanticsNodeElement(new TextKt$$ExternalSyntheticLambda0((byte) 21)));
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
                    int iHashCode = Long.hashCode(gapComposer3.compositeKeyHashCode);
                    PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer3, modifierThen3);
                    ComposeUiNode.Companion.getClass();
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(LayoutNode.Constructor);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m390setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m390setimpl(gapComposer3, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m390setimpl(gapComposer3, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m389reconcileimpl(gapComposer3);
                    Stack.m390setimpl(gapComposer3, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    function2.invoke(gapComposer3, 0);
                    gapComposer3.end(true);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            }
        }, gapComposer2), gapComposer2, 56);
    }

    /* JADX INFO: renamed from: surface-XO-JAsU, reason: not valid java name */
    public static final Modifier m340surfaceXOJAsU(Modifier modifier, Shape shape, long j, BorderStroke borderStroke, float f) {
        Shape shape2;
        Modifier modifierThen;
        Modifier modifierM43borderziNgDLE = Modifier.Companion.$$INSTANCE;
        if (f > CropImageView.DEFAULT_ASPECT_RATIO) {
            shape2 = shape;
            modifierThen = modifierM43borderziNgDLE.then(new GraphicsLayerElement((1048319 & 1) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 2) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 4) != 0 ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO, (1048319 & 32) != 0 ? 0.0f : f, (1048319 & 256) != 0 ? 0.0f : CropImageView.DEFAULT_ASPECT_RATIO, ColorKt.TransformOrigin(0.5f, 0.5f), (1048319 & 2048) != 0 ? ColorKt.RectangleShape : shape2, (1048319 & 4096) != 0 ? false : false, LayerOutsets.Zero));
        } else {
            shape2 = shape;
            modifierThen = modifierM43borderziNgDLE;
        }
        Modifier modifierThen2 = modifier.then(modifierThen);
        if (borderStroke != null) {
            modifierM43borderziNgDLE = ImageKt.m43borderziNgDLE(modifierM43borderziNgDLE, borderStroke.width, borderStroke.brush, shape2);
        }
        return ClipKt.clip(ImageKt.m39backgroundbw27NRU(modifierThen2.then(modifierM43borderziNgDLE), j, shape2), shape2);
    }

    /* JADX INFO: renamed from: surfaceColorAtElevation-CLU3JFs, reason: not valid java name */
    public static final long m341surfaceColorAtElevationCLU3JFs(long j, float f, GapComposer gapComposer) {
        ColorScheme colorScheme = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme;
        boolean zBooleanValue = ((Boolean) gapComposer.consume(ColorSchemeKt.LocalTonalElevationEnabled)).booleanValue();
        long j2 = colorScheme.surface;
        if (!ULong.m1869equalsimpl0(j, j2) || !zBooleanValue) {
            return j;
        }
        if (Dp.m796equalsimpl0(f, CropImageView.DEFAULT_ASPECT_RATIO)) {
            return j2;
        }
        float fLog = ((((float) Math.log(f + 1.0f)) * 4.5f) + 2.0f) / 100.0f;
        long j3 = colorScheme.surfaceTint;
        return ColorKt.m489compositeOverOWjLjI(ColorKt.Color(Color.m485getRedimpl(j3), Color.m484getGreenimpl(j3), Color.m482getBlueimpl(j3), fLog, Color.m483getColorSpaceimpl(j3)), j2);
    }
}
