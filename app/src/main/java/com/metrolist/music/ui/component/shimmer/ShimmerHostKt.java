package com.metrolist.music.ui.component.shimmer;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.Arrangement$Top$1;
import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import com.valentinilk.shimmer.ShimmerModifierKt;
import com.valentinilk.shimmer.ShimmerTheme;
import com.valentinilk.shimmer.ShimmerThemeKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ShimmerHostKt {
    public static final ShimmerTheme ShimmerTheme;

    static {
        ShimmerTheme shimmerTheme = ShimmerThemeKt.defaultShimmerTheme;
        InfiniteRepeatableSpec infiniteRepeatableSpecM19infiniteRepeatable9IiC70o$default = ArcSplineKt.m19infiniteRepeatable9IiC70o$default(new TweenSpec(800, 250, EasingKt.LinearEasing), RepeatMode.Restart, 0L, 4);
        Rgb rgb = ColorSpaces.Unspecified;
        long jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        Color color = new Color(ColorKt.Color(Color.m485getRedimpl(jColor), Color.m484getGreenimpl(jColor), Color.m482getBlueimpl(jColor), 0.25f, Color.m483getColorSpaceimpl(jColor)));
        long jColor2 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        Color color2 = new Color(ColorKt.Color(Color.m485getRedimpl(jColor2), Color.m484getGreenimpl(jColor2), Color.m482getBlueimpl(jColor2), 0.5f, Color.m483getColorSpaceimpl(jColor2)));
        long jColor3 = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, rgb);
        ShimmerTheme = new ShimmerTheme(infiniteRepeatableSpecM19infiniteRepeatable9IiC70o$default, shimmerTheme.blendMode, shimmerTheme.rotation, CollectionsKt__IterablesKt.listOf((Object[]) new Color[]{color, color2, new Color(ColorKt.Color(Color.m485getRedimpl(jColor3), Color.m484getGreenimpl(jColor3), Color.m482getBlueimpl(jColor3), 0.25f, Color.m483getColorSpaceimpl(jColor3)))}), shimmerTheme.shaderColorStops, shimmerTheme.shimmerWidth);
    }

    public static final void ShimmerHost(Modifier modifier, Alignment.Horizontal horizontal, Arrangement$Vertical arrangement$Vertical, boolean z, Function3 function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Function3 function4;
        final Alignment.Horizontal horizontal2;
        final Arrangement$Vertical arrangement$Vertical2;
        final boolean z2;
        final Modifier modifier3;
        function3.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1536436264);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = i | (gapComposer.changed(modifier2) ? 4 : 2);
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i5 = i3 | 432;
        if (gapComposer.shouldExecute(i5 & 1, (i5 & 8339) != 8338)) {
            Modifier modifier4 = i4 != 0 ? Modifier.Companion.$$INSTANCE : modifier2;
            BiasAlignment.Horizontal horizontal3 = Alignment.Companion.Start;
            Arrangement$Top$1 arrangement$Top$1 = OffsetKt.Top;
            boolean z3 = (i2 & 8) != 0 ? true : z;
            Modifier modifierShimmer = ShimmerModifierKt.shimmer(modifier4, gapComposer, i5 & 14);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal3, gapComposer, 54);
            int iHashCode = Long.hashCode(gapComposer.compositeKeyHashCode);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = ZIndexModifierKt.materializeModifier(gapComposer, modifierShimmer);
            ComposeUiNode.Companion.getClass();
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(LayoutNode.Constructor);
            } else {
                gapComposer.useNode();
            }
            Stack.m390setimpl(gapComposer, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m390setimpl(gapComposer, persistentCompositionLocalHashMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m390setimpl(gapComposer, Integer.valueOf(iHashCode), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m389reconcileimpl(gapComposer);
            Stack.m390setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            function4 = function3;
            function4.invoke(ColumnScopeInstance.INSTANCE, gapComposer, 54);
            gapComposer.end(true);
            modifier3 = modifier4;
            horizontal2 = horizontal3;
            arrangement$Vertical2 = arrangement$Top$1;
            z2 = z3;
        } else {
            function4 = function3;
            gapComposer.skipToGroupEnd();
            horizontal2 = horizontal;
            arrangement$Vertical2 = arrangement$Vertical;
            z2 = z;
            modifier3 = modifier2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.metrolist.music.ui.component.shimmer.ShimmerHostKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    ShimmerHostKt.ShimmerHost(modifier3, horizontal2, arrangement$Vertical2, z2, function4, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
