package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt$$ExternalSyntheticLambda4;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda1;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MaterialThemeKt {
    public static final StaticProvidableCompositionLocal LocalUsingExpressiveTheme = new StaticProvidableCompositionLocal(new TextKt$$ExternalSyntheticLambda3((byte) 4), (byte) 0);
    public static final StaticProvidableCompositionLocal _localMaterialTheme = new StaticProvidableCompositionLocal(new TextKt$$ExternalSyntheticLambda3((byte) 5), (byte) 0);

    public static final void MaterialExpressiveTheme(ColorScheme colorScheme, MotionScheme motionScheme, Shapes shapes, Typography typography, Function2 function2, Composer composer, int i) {
        ColorScheme colorScheme2;
        MotionScheme motionScheme2;
        Typography typography2;
        Shapes shapes2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1317329884);
        int i2 = i | (gapComposer.changed(colorScheme) ? 4 : 2) | (gapComposer.changed(motionScheme) ? 32 : 16) | (gapComposer.changed(shapes) ? 256 : 128) | (gapComposer.changed(typography) ? 2048 : 1024) | (gapComposer.changedInstance(function2) ? 16384 : 8192);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 9363) != 9362)) {
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = LocalUsingExpressiveTheme;
            if (((Boolean) gapComposer.consume(staticProvidableCompositionLocal)).booleanValue()) {
                gapComposer.startReplaceGroup(1458663246);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = _localMaterialTheme;
                if (colorScheme == null) {
                    gapComposer.startReplaceGroup(-1061323065);
                    colorScheme2 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).colorScheme;
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(-1061323964);
                    gapComposer.end(false);
                    colorScheme2 = colorScheme;
                }
                if (motionScheme == null) {
                    gapComposer.startReplaceGroup(-1061320824);
                    motionScheme2 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).motionScheme;
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceGroup(-1061321754);
                    gapComposer.end(false);
                    motionScheme2 = motionScheme;
                }
                if (typography == null) {
                    gapComposer.startReplaceGroup(-1061318682);
                    Typography typography3 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).typography;
                    gapComposer.end(false);
                    typography2 = typography3;
                } else {
                    gapComposer.startReplaceGroup(-1061319550);
                    gapComposer.end(false);
                    typography2 = typography;
                }
                if (shapes == null) {
                    gapComposer.startReplaceGroup(-1061316862);
                    Shapes shapes3 = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal2)).shapes;
                    gapComposer.end(false);
                    shapes2 = shapes3;
                } else {
                    gapComposer.startReplaceGroup(-1061317606);
                    gapComposer.end(false);
                    shapes2 = shapes;
                }
                MaterialTheme(colorScheme2, motionScheme2, shapes2, typography2, function2, gapComposer, i2 & 57344);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1458990389);
                Stack.CompositionLocalProvider(staticProvidableCompositionLocal.defaultProvidedValue$runtime(Boolean.TRUE), Expect_jvmKt.rememberComposableLambda(1535649272, new MaterialThemeKt$$ExternalSyntheticLambda3(colorScheme, motionScheme, shapes, typography, function2, (byte) 0), gapComposer), gapComposer, 56);
                gapComposer.end(false);
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MaterialThemeKt$$ExternalSyntheticLambda3(colorScheme, motionScheme, shapes, typography, function2, i);
        }
    }

    public static final void MaterialTheme(ColorScheme colorScheme, MotionScheme motionScheme, Shapes shapes, Typography typography, Function2 function2, Composer composer, int i) {
        int i2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(904511636);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(colorScheme) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(motionScheme) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(shapes) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(typography) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 16384 : 8192;
        }
        byte b = 0;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 9363) != 9362)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0 && !gapComposer.getDefaultsInvalid()) {
                gapComposer.skipToGroupEnd();
            }
            gapComposer.endDefaults();
            MaterialTheme$Values materialTheme$Values = new MaterialTheme$Values(colorScheme, typography, shapes, motionScheme);
            RippleNodeFactory rippleNodeFactoryM313rippleOu1YvPQ$default = RippleKt.m313rippleOu1YvPQ$default(false, CropImageView.DEFAULT_ASPECT_RATIO, 0L, null, 255);
            long j = colorScheme.primary;
            boolean zChanged = gapComposer.changed(j);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.Empty) {
                objRememberedValue = new TextSelectionColors(j, ColorKt.Color(Color.m485getRedimpl(j), Color.m484getGreenimpl(j), Color.m482getBlueimpl(j), 0.4f, Color.m483getColorSpaceimpl(j)));
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Stack.CompositionLocalProvider(new ProvidedValue[]{_localMaterialTheme.defaultProvidedValue$runtime(materialTheme$Values), IndicationKt.LocalIndication.defaultProvidedValue$runtime(rippleNodeFactoryM313rippleOu1YvPQ$default), TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime((TextSelectionColors) objRememberedValue)}, Expect_jvmKt.rememberComposableLambda(-1750539308, new MaterialThemeKt$$ExternalSyntheticLambda5(typography, function2, b), gapComposer), gapComposer, 56);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CrossfadeKt$$ExternalSyntheticLambda4((Object) colorScheme, (Object) motionScheme, (Object) shapes, (Object) typography, function2, i, (byte) 3);
        }
    }

    public static final void MaterialTheme(ColorScheme colorScheme, Shapes shapes, Typography typography, Function2 function2, Composer composer, int i) {
        Function2 function3;
        Typography typography2;
        Shapes shapes2;
        ColorScheme colorScheme2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-449719819);
        int i2 = (gapComposer.changed(colorScheme) ? 4 : 2) | i | (gapComposer.changed(shapes) ? 32 : 16) | (gapComposer.changed(typography) ? 256 : 128) | (gapComposer.changedInstance(function2) ? 2048 : 1024);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0 && !gapComposer.getDefaultsInvalid()) {
                gapComposer.skipToGroupEnd();
            }
            gapComposer.endDefaults();
            int i3 = i2 & 14;
            int i4 = i2 << 3;
            MaterialTheme(colorScheme, ((MaterialTheme$Values) gapComposer.consume(_localMaterialTheme)).motionScheme, shapes, typography, function2, gapComposer, i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344));
            colorScheme2 = colorScheme;
            shapes2 = shapes;
            typography2 = typography;
            function3 = function2;
        } else {
            function3 = function2;
            typography2 = typography;
            shapes2 = shapes;
            colorScheme2 = colorScheme;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda1(colorScheme2, shapes2, typography2, function3, i);
        }
    }
}
