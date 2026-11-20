package com.materialkolor;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.Shapes;
import androidx.compose.material3.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.ui.graphics.Color;
import com.materialkolor.dynamiccolor.ColorSpec$SpecVersion;
import com.materialkolor.ktx.ColorKt;
import com.materialkolor.ktx.ColorSchemeKt;
import com.materialkolor.scheme.DynamicScheme;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a×\u0001\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00022\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001aË\u0001\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00022\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0007¢\u0006\u0004\b \u0010!\u001aS\u0010\u001f\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\"2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00022\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0007¢\u0006\u0004\b\u001f\u0010$¨\u0006%"}, d2 = {"Landroidx/compose/ui/graphics/Color;", "seedColor", "", "isDark", "isAmoled", "primary", "secondary", "tertiary", "neutral", "neutralVariant", "error", "Lcom/materialkolor/PaletteStyle;", "style", "", "contrastLevel", "Lcom/materialkolor/dynamiccolor/ColorSpec$SpecVersion;", "specVersion", "Lcom/materialkolor/scheme/DynamicScheme$Platform;", "platform", "Landroidx/compose/material3/Shapes;", "shapes", "Landroidx/compose/material3/Typography;", "typography", "animate", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "animationSpec", "Lkotlin/Function0;", "", "content", "DynamicMaterialTheme-bLGS3X0", "(JZZLandroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Lcom/materialkolor/PaletteStyle;DLcom/materialkolor/dynamiccolor/ColorSpec$SpecVersion;Lcom/materialkolor/scheme/DynamicScheme$Platform;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;ZLandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "DynamicMaterialTheme", "DynamicMaterialTheme-0OstJqQ", "(JZZLandroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Lcom/materialkolor/PaletteStyle;DLcom/materialkolor/dynamiccolor/ColorSpec$SpecVersion;Lcom/materialkolor/scheme/DynamicScheme$Platform;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;ZLandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Lcom/materialkolor/DynamicMaterialThemeState;", "state", "(Lcom/materialkolor/DynamicMaterialThemeState;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;ZLandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "MaterialKolor:material-kolor"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class DynamicMaterialThemeKt {
    /* JADX WARN: Code duplicated, block: B:102:0x016a  */
    /* JADX WARN: Code duplicated, block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x006d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0071  */
    /* JADX WARN: Code duplicated, block: B:45:0x0077  */
    /* JADX WARN: Code duplicated, block: B:46:0x007c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0082  */
    /* JADX WARN: Code duplicated, block: B:49:0x0085  */
    /* JADX WARN: Code duplicated, block: B:53:0x008d  */
    /* JADX WARN: Code duplicated, block: B:55:0x0093  */
    /* JADX WARN: Code duplicated, block: B:56:0x0096  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:81:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:91:0x0103  */
    /* JADX WARN: Code duplicated, block: B:95:0x0117  */
    /* JADX WARN: Code duplicated, block: B:97:0x0121  */
    /* JADX WARN: Code duplicated, block: B:99:0x015c  */
    public static final void DynamicMaterialTheme(final DynamicMaterialThemeState dynamicMaterialThemeState, Shapes shapes, Typography typography, boolean z, FiniteAnimationSpec finiteAnimationSpec, final Function2 function2, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        boolean z3;
        final Shapes shapes2;
        final FiniteAnimationSpec finiteAnimationSpec2;
        final boolean z4;
        final Typography typography2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Shapes shapes3;
        Typography typography3;
        FiniteAnimationSpec finiteAnimationSpec3;
        Typography typography4;
        boolean z5;
        Shapes shapes4;
        ColorScheme colorScheme;
        int i4;
        int i5;
        boolean zChangedInstance;
        FiniteAnimationSpec defaultColorSpring = finiteAnimationSpec;
        dynamicMaterialThemeState.getClass();
        function2.getClass();
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(1163357137);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changed(dynamicMaterialThemeState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= ((i2 & 2) == 0 && gapComposer.changed(shapes)) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= ((i2 & 4) == 0 && gapComposer.changed(typography)) ? 256 : 128;
        }
        int i6 = i2 & 8;
        if (i6 == 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                i3 |= gapComposer.changed(z2) ? 2048 : 1024;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) != 0) {
                    i5 = 8192;
                } else {
                    if ((32768 & i) == 0) {
                        zChangedInstance = gapComposer.changed(defaultColorSpring);
                    } else {
                        zChangedInstance = gapComposer.changedInstance(defaultColorSpring);
                    }
                    if (zChangedInstance) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                }
                i3 |= i5;
            }
            if ((196608 & i) == 0) {
                if (gapComposer.changedInstance(function2)) {
                    i4 = 131072;
                } else {
                    i4 = 65536;
                }
                i3 |= i4;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (gapComposer.shouldExecute(i3 & 1, z3)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                    if ((i2 & 2) != 0) {
                        shapes3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        i3 &= -113;
                    } else {
                        shapes3 = shapes;
                    }
                    if ((i2 & 4) != 0) {
                        typography3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography;
                        i3 &= -897;
                    } else {
                        typography3 = typography;
                    }
                    if (i6 != 0) {
                        z2 = false;
                    }
                    if ((i2 & 16) != 0) {
                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                        i3 &= -57345;
                    }
                    finiteAnimationSpec3 = defaultColorSpring;
                    typography4 = typography3;
                    z5 = z2;
                    shapes4 = shapes3;
                } else {
                    gapComposer.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    typography4 = typography;
                    finiteAnimationSpec3 = defaultColorSpring;
                    z5 = z2;
                    shapes4 = shapes;
                }
                gapComposer.endDefaults();
                colorScheme = dynamicMaterialThemeState.getColorScheme(i3 & 14, gapComposer);
                if (z5) {
                    gapComposer.startReplaceGroup(1481777801);
                    colorScheme = ColorSchemeKt.animateColorScheme(colorScheme, new DynamicMaterialThemeKt$$ExternalSyntheticLambda0(finiteAnimationSpec3, (byte) 0), null, gapComposer, 0, 4);
                } else {
                    gapComposer.startReplaceGroup(1481734990);
                }
                gapComposer.end(false);
                Stack.CompositionLocalProvider(LocalDynamicMaterialThemeSeedKt.getLocalDynamicMaterialThemeSeed().defaultProvidedValue$runtime(new Color(dynamicMaterialThemeState.m933getSeedColor0d7_KjU())), Expect_jvmKt.rememberComposableLambda(-809648367, new DynamicMaterialThemeKt$$ExternalSyntheticLambda1(colorScheme, shapes4, typography4, function2), gapComposer), gapComposer, 56);
                shapes2 = shapes4;
                typography2 = typography4;
                z4 = z5;
                finiteAnimationSpec2 = finiteAnimationSpec3;
            } else {
                gapComposer.skipToGroupEnd();
                shapes2 = shapes;
                finiteAnimationSpec2 = defaultColorSpring;
                z4 = z2;
                typography2 = typography;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        DynamicMaterialThemeKt.DynamicMaterialTheme(dynamicMaterialThemeState, shapes2, typography2, z4, finiteAnimationSpec2, function2, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i3 |= 3072;
        z2 = z;
        if ((i & 24576) == 0) {
            if ((i2 & 16) != 0) {
                i5 = 8192;
            } else {
                if ((32768 & i) == 0) {
                    zChangedInstance = gapComposer.changed(defaultColorSpring);
                } else {
                    zChangedInstance = gapComposer.changedInstance(defaultColorSpring);
                }
                if (zChangedInstance) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
            }
            i3 |= i5;
        }
        if ((196608 & i) == 0) {
            if (gapComposer.changedInstance(function2)) {
                i4 = 131072;
            } else {
                i4 = 65536;
            }
            i3 |= i4;
        }
        if ((74899 & i3) != 74898) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (gapComposer.shouldExecute(i3 & 1, z3)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0) {
                if ((i2 & 2) != 0) {
                    shapes3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                    i3 &= -113;
                } else {
                    shapes3 = shapes;
                }
                if ((i2 & 4) != 0) {
                    typography3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography;
                    i3 &= -897;
                } else {
                    typography3 = typography;
                }
                if (i6 != 0) {
                    z2 = false;
                }
                if ((i2 & 16) != 0) {
                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                    i3 &= -57345;
                }
                finiteAnimationSpec3 = defaultColorSpring;
                typography4 = typography3;
                z5 = z2;
                shapes4 = shapes3;
            } else {
                if ((i2 & 2) != 0) {
                    shapes3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                    i3 &= -113;
                } else {
                    shapes3 = shapes;
                }
                if ((i2 & 4) != 0) {
                    typography3 = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography;
                    i3 &= -897;
                } else {
                    typography3 = typography;
                }
                if (i6 != 0) {
                    z2 = false;
                }
                if ((i2 & 16) != 0) {
                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                    i3 &= -57345;
                }
                finiteAnimationSpec3 = defaultColorSpring;
                typography4 = typography3;
                z5 = z2;
                shapes4 = shapes3;
            }
            gapComposer.endDefaults();
            colorScheme = dynamicMaterialThemeState.getColorScheme(i3 & 14, gapComposer);
            if (z5) {
                gapComposer.startReplaceGroup(1481734990);
            } else {
                gapComposer.startReplaceGroup(1481777801);
                colorScheme = ColorSchemeKt.animateColorScheme(colorScheme, new DynamicMaterialThemeKt$$ExternalSyntheticLambda0(finiteAnimationSpec3, (byte) 0), null, gapComposer, 0, 4);
            }
            gapComposer.end(false);
            Stack.CompositionLocalProvider(LocalDynamicMaterialThemeSeedKt.getLocalDynamicMaterialThemeSeed().defaultProvidedValue$runtime(new Color(dynamicMaterialThemeState.m933getSeedColor0d7_KjU())), Expect_jvmKt.rememberComposableLambda(-809648367, new DynamicMaterialThemeKt$$ExternalSyntheticLambda1(colorScheme, shapes4, typography4, function2), gapComposer), gapComposer, 56);
            shapes2 = shapes4;
            typography2 = typography4;
            z4 = z5;
            finiteAnimationSpec2 = finiteAnimationSpec3;
        } else {
            gapComposer.skipToGroupEnd();
            shapes2 = shapes;
            finiteAnimationSpec2 = defaultColorSpring;
            z4 = z2;
            typography2 = typography;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    DynamicMaterialThemeKt.DynamicMaterialTheme(dynamicMaterialThemeState, shapes2, typography2, z4, finiteAnimationSpec2, function2, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0132  */
    /* JADX WARN: Code duplicated, block: B:102:0x0136  */
    /* JADX WARN: Code duplicated, block: B:104:0x013f  */
    /* JADX WARN: Code duplicated, block: B:105:0x0142  */
    /* JADX WARN: Code duplicated, block: B:108:0x014a  */
    /* JADX WARN: Code duplicated, block: B:111:0x0151  */
    /* JADX WARN: Code duplicated, block: B:113:0x0157 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:114:0x0159  */
    /* JADX WARN: Code duplicated, block: B:115:0x015c  */
    /* JADX WARN: Code duplicated, block: B:118:0x0166  */
    /* JADX WARN: Code duplicated, block: B:119:0x0169  */
    /* JADX WARN: Code duplicated, block: B:121:0x016e  */
    /* JADX WARN: Code duplicated, block: B:124:0x0175  */
    /* JADX WARN: Code duplicated, block: B:126:0x017b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:128:0x0180  */
    /* JADX WARN: Code duplicated, block: B:131:0x018b  */
    /* JADX WARN: Code duplicated, block: B:132:0x018e  */
    /* JADX WARN: Code duplicated, block: B:134:0x0193  */
    /* JADX WARN: Code duplicated, block: B:137:0x019b  */
    /* JADX WARN: Code duplicated, block: B:139:0x019f  */
    /* JADX WARN: Code duplicated, block: B:142:0x01aa A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:145:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:148:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:150:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:153:0x01c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:156:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:159:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:161:0x01db  */
    /* JADX WARN: Code duplicated, block: B:163:0x01df  */
    /* JADX WARN: Code duplicated, block: B:166:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:170:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:172:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:174:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:175:0x0202  */
    /* JADX WARN: Code duplicated, block: B:177:0x0208  */
    /* JADX WARN: Code duplicated, block: B:181:0x0212  */
    /* JADX WARN: Code duplicated, block: B:183:0x0218  */
    /* JADX WARN: Code duplicated, block: B:187:0x022a  */
    /* JADX WARN: Code duplicated, block: B:191:0x0238  */
    /* JADX WARN: Code duplicated, block: B:194:0x0241  */
    /* JADX WARN: Code duplicated, block: B:196:0x024e  */
    /* JADX WARN: Code duplicated, block: B:223:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:225:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:227:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:228:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:231:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:233:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:235:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:237:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:240:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:242:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:243:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:246:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:247:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:250:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:251:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:254:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:255:0x0305  */
    /* JADX WARN: Code duplicated, block: B:258:0x030f  */
    /* JADX WARN: Code duplicated, block: B:259:0x031c  */
    /* JADX WARN: Code duplicated, block: B:262:0x0324  */
    /* JADX WARN: Code duplicated, block: B:263:0x0331  */
    /* JADX WARN: Code duplicated, block: B:266:0x0336  */
    /* JADX WARN: Code duplicated, block: B:269:0x033c  */
    /* JADX WARN: Code duplicated, block: B:271:0x035c  */
    /* JADX WARN: Code duplicated, block: B:273:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:276:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:278:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    /* JADX WARN: Code duplicated, block: B:36:0x006b  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0077  */
    /* JADX WARN: Code duplicated, block: B:41:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0086  */
    /* JADX WARN: Code duplicated, block: B:47:0x008b  */
    /* JADX WARN: Code duplicated, block: B:49:0x008f  */
    /* JADX WARN: Code duplicated, block: B:51:0x0097  */
    /* JADX WARN: Code duplicated, block: B:52:0x009a  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:67:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00db  */
    /* JADX WARN: Code duplicated, block: B:72:0x00de  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:77:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:82:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:86:0x0108  */
    /* JADX WARN: Code duplicated, block: B:88:0x010d  */
    /* JADX WARN: Code duplicated, block: B:90:0x0111 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x0113  */
    /* JADX WARN: Code duplicated, block: B:92:0x0118  */
    /* JADX WARN: Code duplicated, block: B:95:0x0126  */
    /* JADX WARN: Code duplicated, block: B:96:0x0129  */
    /* JADX INFO: renamed from: DynamicMaterialTheme-0OstJqQ, reason: not valid java name */
    public static final void m931DynamicMaterialTheme0OstJqQ(final long j, boolean z, boolean z2, Color color, Color color2, Color color3, Color color4, Color color5, PaletteStyle paletteStyle, double d, ColorSpec$SpecVersion colorSpec$SpecVersion, DynamicScheme.Platform platform, Shapes shapes, Typography typography, boolean z3, FiniteAnimationSpec finiteAnimationSpec, final Function2 function2, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        boolean zIsSystemInDarkTheme;
        int i5;
        int i6;
        Color color6;
        int i7;
        int i8;
        Color color7;
        int i9;
        int i10;
        int i11;
        Color color8;
        int i12;
        int i13;
        Color color9;
        int i14;
        int i15;
        int i16;
        int i17;
        int iOrdinal;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        boolean z4;
        int i25;
        boolean z5;
        GapComposer gapComposer;
        final boolean z6;
        final Color color10;
        PaletteStyle paletteStyle2;
        ColorSpec$SpecVersion colorSpec$SpecVersion2;
        final Shapes shapes2;
        Typography typography2;
        final FiniteAnimationSpec finiteAnimationSpec2;
        final boolean z7;
        final Color color11;
        final Color color12;
        final Color color13;
        final Color color14;
        final double d2;
        final DynamicScheme.Platform platform2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        boolean z8;
        Color color15;
        double d3;
        int i26;
        boolean z9;
        int i27;
        int i28;
        int i29;
        DynamicScheme.Platform platform3;
        int i30;
        Shapes shapes3;
        boolean z10;
        FiniteAnimationSpec defaultColorSpring;
        int i31;
        Shapes shapes4;
        boolean zChangedInstance;
        int i32;
        int i33;
        int iOrdinal2;
        int i34;
        int i35;
        function2.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1930890550);
        if ((i & 6) == 0) {
            i4 = (gapComposer2.changed(j) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            if ((i3 & 2) == 0) {
                zIsSystemInDarkTheme = z;
                int i36 = gapComposer2.changed(zIsSystemInDarkTheme) ? 32 : 16;
                i4 |= i36;
            } else {
                zIsSystemInDarkTheme = z;
            }
            i4 |= i36;
        } else {
            zIsSystemInDarkTheme = z;
        }
        int i37 = i3 & 4;
        if (i37 == 0) {
            if ((i & 384) == 0) {
                i4 |= gapComposer2.changed(z2) ? 256 : 128;
            }
            i5 = i3 & 8;
            i6 = 1024;
            if (i5 != 0) {
                if ((i & 3072) == 0) {
                    color6 = color;
                    if (gapComposer2.changed(color6)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i4 |= i7;
                }
                i8 = i3 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        color7 = color2;
                        if (gapComposer2.changed(color7)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i4 |= i9;
                    }
                    i10 = i3 & 32;
                    i11 = 65536;
                    if (i10 != 0) {
                        i4 |= 196608;
                        color8 = color3;
                    } else {
                        color8 = color3;
                        if ((i & 196608) == 0) {
                            if (gapComposer2.changed(color8)) {
                                i12 = 131072;
                            } else {
                                i12 = 65536;
                            }
                            i4 |= i12;
                        }
                    }
                    i13 = i3 & 64;
                    if (i13 != 0) {
                        i4 |= 1572864;
                        color9 = color4;
                    } else {
                        color9 = color4;
                        if ((i & 1572864) == 0) {
                            if (gapComposer2.changed(color9)) {
                                i14 = 1048576;
                            } else {
                                i14 = 524288;
                            }
                            i4 |= i14;
                        }
                    }
                    i15 = i3 & 128;
                    if (i15 != 0) {
                        i4 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (gapComposer2.changed(color5)) {
                            i16 = 8388608;
                        } else {
                            i16 = 4194304;
                        }
                        i4 |= i16;
                    }
                    i17 = i3 & 256;
                    if (i17 != 0) {
                        if ((i & 100663296) == 0) {
                            if (paletteStyle == null) {
                                iOrdinal = -1;
                            } else {
                                iOrdinal = paletteStyle.ordinal();
                            }
                            if (gapComposer2.changed(iOrdinal)) {
                                i18 = 67108864;
                            } else {
                                i18 = 33554432;
                            }
                            i4 |= i18;
                        }
                        if ((i & 805306368) == 0) {
                            if ((i3 & 512) == 0) {
                                i34 = i4;
                                if (gapComposer2.changed(d)) {
                                    i35 = 536870912;
                                }
                                i19 = i34 | i35;
                            } else {
                                i34 = i4;
                            }
                            i35 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                            i19 = i34 | i35;
                        } else {
                            i19 = i4;
                        }
                        if ((i2 & 6) == 0) {
                            if ((i3 & 1024) != 0) {
                                i33 = 2;
                            } else {
                                if (colorSpec$SpecVersion == null) {
                                    iOrdinal2 = -1;
                                } else {
                                    iOrdinal2 = colorSpec$SpecVersion.ordinal();
                                }
                                if (gapComposer2.changed(iOrdinal2)) {
                                    i33 = 4;
                                } else {
                                    i33 = 2;
                                }
                            }
                            i20 = i2 | i33;
                        } else {
                            i20 = i2;
                        }
                        if ((i2 & 48) == 0) {
                            int i38 = i20;
                            if ((i3 & 2048) != 0) {
                                i32 = 16;
                            } else {
                                if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                                    i32 = 32;
                                } else {
                                    i32 = 16;
                                }
                            }
                            i20 = i38 | i32;
                        }
                        i21 = i20;
                        if ((i2 & 384) == 0) {
                            i22 = i21 | (((i3 & 4096) == 0 || !gapComposer2.changed(shapes)) ? 128 : 256);
                        } else {
                            i22 = i21;
                        }
                        if ((i2 & 3072) != 0) {
                            if ((i3 & 8192) == 0 && gapComposer2.changed(typography)) {
                                i6 = 2048;
                            }
                            i22 |= i6;
                        }
                        i23 = i22;
                        i24 = i3 & 16384;
                        if (i24 != 0) {
                            if ((i2 & 24576) == 0) {
                                z4 = z3;
                                i23 |= gapComposer2.changed(z4) ? 16384 : 8192;
                            }
                            if ((i2 & 196608) == 0) {
                                if ((i3 & 32768) == 0) {
                                    if ((i2 & 262144) == 0) {
                                        zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                                    } else {
                                        zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                                    }
                                    if (zChangedInstance) {
                                        i11 = 131072;
                                    }
                                }
                                i23 |= i11;
                            }
                            if ((i2 & 1572864) == 0) {
                                i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                            }
                            i25 = i23;
                            if ((i19 & 306783379) == 306783378 || (i25 & 599187) != 599186) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                                gapComposer2.startDefaults();
                                if ((i & 1) != 0 || gapComposer2.getDefaultsInvalid()) {
                                    if ((i3 & 2) != 0) {
                                        i19 &= -113;
                                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                    }
                                    if (i37 != 0) {
                                        z8 = false;
                                    } else {
                                        z8 = z2;
                                    }
                                    if (i5 != 0) {
                                        color6 = null;
                                    }
                                    if (i8 != 0) {
                                        color7 = null;
                                    }
                                    if (i10 != 0) {
                                        color8 = null;
                                    }
                                    if (i13 != 0) {
                                        color9 = null;
                                    }
                                    color15 = i15 == 0 ? color5 : null;
                                    if (i17 != 0) {
                                        paletteStyle2 = PaletteStyle.TonalSpot;
                                    } else {
                                        paletteStyle2 = paletteStyle;
                                    }
                                    if ((i3 & 512) != 0) {
                                        i26 = i19 & (-1879048193);
                                        d3 = 0.0d;
                                    } else {
                                        d3 = d;
                                        i26 = i19;
                                    }
                                    z9 = z8;
                                    if ((i3 & 1024) != 0) {
                                        ColorSpec$SpecVersion.Companion.getClass();
                                        i27 = i25 & (-15);
                                        colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                                    } else {
                                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                        i27 = i25;
                                    }
                                    i28 = i27;
                                    if ((i3 & 2048) != 0) {
                                        DynamicScheme.Platform.Companion.getClass();
                                        i29 = i28 & (-113);
                                        platform3 = DynamicScheme.Platform.Default;
                                    } else {
                                        i29 = i28;
                                        platform3 = platform;
                                    }
                                    i30 = i26;
                                    if ((i3 & 4096) != 0) {
                                        shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                        i29 &= -897;
                                    } else {
                                        shapes3 = shapes;
                                    }
                                    Shapes shapes5 = shapes3;
                                    if ((i3 & 8192) != 0) {
                                        typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                        i29 &= -7169;
                                    } else {
                                        typography2 = typography;
                                    }
                                    z10 = i24 == 0 ? z4 : false;
                                    if ((i3 & 32768) != 0) {
                                        i31 = i29 & (-458753);
                                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                                    } else {
                                        defaultColorSpring = finiteAnimationSpec;
                                        i31 = i29;
                                    }
                                    shapes4 = shapes5;
                                } else {
                                    gapComposer2.skipToGroupEnd();
                                    int i39 = (i3 & 2) != 0 ? i19 & (-113) : i19;
                                    if ((i3 & 512) != 0) {
                                        i39 &= -1879048193;
                                    }
                                    int i40 = (i3 & 1024) != 0 ? i25 & (-15) : i25;
                                    if ((i3 & 2048) != 0) {
                                        i40 &= -113;
                                    }
                                    if ((i3 & 4096) != 0) {
                                        i40 &= -897;
                                    }
                                    if ((i3 & 8192) != 0) {
                                        i40 &= -7169;
                                    }
                                    if ((i3 & 32768) != 0) {
                                        i40 &= -458753;
                                    }
                                    paletteStyle2 = paletteStyle;
                                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                    platform3 = platform;
                                    typography2 = typography;
                                    defaultColorSpring = finiteAnimationSpec;
                                    i31 = i40;
                                    z10 = z4;
                                    color6 = color6;
                                    zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                                    color7 = color7;
                                    color8 = color8;
                                    color9 = color9;
                                    z9 = z2;
                                    color15 = color5;
                                    d3 = d;
                                    i30 = i39;
                                    shapes4 = shapes;
                                }
                                gapComposer2.endDefaults();
                                gapComposer = gapComposer2;
                                boolean z11 = z10;
                                FiniteAnimationSpec finiteAnimationSpec3 = defaultColorSpring;
                                DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z11, finiteAnimationSpec3, function2, gapComposer, (i31 >> 3) & 524272, 0);
                                finiteAnimationSpec2 = finiteAnimationSpec3;
                                color11 = color6;
                                color14 = color9;
                                double d4 = d3;
                                shapes2 = shapes4;
                                platform2 = platform3;
                                z7 = z11;
                                z6 = z9;
                                color13 = color8;
                                zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                                color12 = color7;
                                color10 = color15;
                                d2 = d4;
                            } else {
                                gapComposer = gapComposer2;
                                gapComposer.skipToGroupEnd();
                                z6 = z2;
                                color10 = color5;
                                paletteStyle2 = paletteStyle;
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                shapes2 = shapes;
                                typography2 = typography;
                                finiteAnimationSpec2 = finiteAnimationSpec;
                                z7 = z4;
                                color11 = color6;
                                color12 = color7;
                                color13 = color8;
                                color14 = color9;
                                d2 = d;
                                platform2 = platform;
                            }
                            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                            if (recomposeScopeImplEndRestartGroup != null) {
                                final boolean z12 = zIsSystemInDarkTheme;
                                final PaletteStyle paletteStyle3 = paletteStyle2;
                                final ColorSpec$SpecVersion colorSpec$SpecVersion3 = colorSpec$SpecVersion2;
                                final Typography typography3 = typography2;
                                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        ((Integer) obj2).getClass();
                                        int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                                        DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z12, z6, color11, color12, color13, color14, color10, paletteStyle3, d2, colorSpec$SpecVersion3, platform2, shapes2, typography3, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                                        return Unit.INSTANCE;
                                    }
                                };
                            }
                        }
                        i23 |= 24576;
                        z4 = z3;
                        if ((i2 & 196608) == 0) {
                            if ((i3 & 32768) == 0) {
                                if ((i2 & 262144) == 0) {
                                    zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                                } else {
                                    zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                                }
                                if (zChangedInstance) {
                                    i11 = 131072;
                                }
                            }
                            i23 |= i11;
                        }
                        if ((i2 & 1572864) == 0) {
                            i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                        }
                        i25 = i23;
                        if ((i19 & 306783379) == 306783378) {
                            z5 = true;
                        } else {
                            z5 = true;
                        }
                        if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                            gapComposer2.startDefaults();
                            if ((i & 1) != 0) {
                                if ((i3 & 2) != 0) {
                                    i19 &= -113;
                                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                }
                                if (i37 != 0) {
                                    z8 = false;
                                } else {
                                    z8 = z2;
                                }
                                if (i5 != 0) {
                                    color6 = null;
                                }
                                if (i8 != 0) {
                                    color7 = null;
                                }
                                if (i10 != 0) {
                                    color8 = null;
                                }
                                if (i13 != 0) {
                                    color9 = null;
                                }
                                if (i15 == 0) {
                                }
                                if (i17 != 0) {
                                    paletteStyle2 = PaletteStyle.TonalSpot;
                                } else {
                                    paletteStyle2 = paletteStyle;
                                }
                                if ((i3 & 512) != 0) {
                                    i26 = i19 & (-1879048193);
                                    d3 = 0.0d;
                                } else {
                                    d3 = d;
                                    i26 = i19;
                                }
                                z9 = z8;
                                if ((i3 & 1024) != 0) {
                                    ColorSpec$SpecVersion.Companion.getClass();
                                    i27 = i25 & (-15);
                                    colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                                } else {
                                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                    i27 = i25;
                                }
                                i28 = i27;
                                if ((i3 & 2048) != 0) {
                                    DynamicScheme.Platform.Companion.getClass();
                                    i29 = i28 & (-113);
                                    platform3 = DynamicScheme.Platform.Default;
                                } else {
                                    i29 = i28;
                                    platform3 = platform;
                                }
                                i30 = i26;
                                if ((i3 & 4096) != 0) {
                                    shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                    i29 &= -897;
                                } else {
                                    shapes3 = shapes;
                                }
                                Shapes shapes6 = shapes3;
                                if ((i3 & 8192) != 0) {
                                    typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                    i29 &= -7169;
                                } else {
                                    typography2 = typography;
                                }
                                if (i24 == 0) {
                                }
                                if ((i3 & 32768) != 0) {
                                    i31 = i29 & (-458753);
                                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                                } else {
                                    defaultColorSpring = finiteAnimationSpec;
                                    i31 = i29;
                                }
                                shapes4 = shapes6;
                            } else {
                                if ((i3 & 2) != 0) {
                                    i19 &= -113;
                                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                }
                                if (i37 != 0) {
                                    z8 = false;
                                } else {
                                    z8 = z2;
                                }
                                if (i5 != 0) {
                                    color6 = null;
                                }
                                if (i8 != 0) {
                                    color7 = null;
                                }
                                if (i10 != 0) {
                                    color8 = null;
                                }
                                if (i13 != 0) {
                                    color9 = null;
                                }
                                if (i15 == 0) {
                                }
                                if (i17 != 0) {
                                    paletteStyle2 = PaletteStyle.TonalSpot;
                                } else {
                                    paletteStyle2 = paletteStyle;
                                }
                                if ((i3 & 512) != 0) {
                                    i26 = i19 & (-1879048193);
                                    d3 = 0.0d;
                                } else {
                                    d3 = d;
                                    i26 = i19;
                                }
                                z9 = z8;
                                if ((i3 & 1024) != 0) {
                                    ColorSpec$SpecVersion.Companion.getClass();
                                    i27 = i25 & (-15);
                                    colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                                } else {
                                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                    i27 = i25;
                                }
                                i28 = i27;
                                if ((i3 & 2048) != 0) {
                                    DynamicScheme.Platform.Companion.getClass();
                                    i29 = i28 & (-113);
                                    platform3 = DynamicScheme.Platform.Default;
                                } else {
                                    i29 = i28;
                                    platform3 = platform;
                                }
                                i30 = i26;
                                if ((i3 & 4096) != 0) {
                                    shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                    i29 &= -897;
                                } else {
                                    shapes3 = shapes;
                                }
                                Shapes shapes7 = shapes3;
                                if ((i3 & 8192) != 0) {
                                    typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                    i29 &= -7169;
                                } else {
                                    typography2 = typography;
                                }
                                if (i24 == 0) {
                                }
                                if ((i3 & 32768) != 0) {
                                    i31 = i29 & (-458753);
                                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                                } else {
                                    defaultColorSpring = finiteAnimationSpec;
                                    i31 = i29;
                                }
                                shapes4 = shapes7;
                            }
                            gapComposer2.endDefaults();
                            gapComposer = gapComposer2;
                            boolean z13 = z10;
                            FiniteAnimationSpec finiteAnimationSpec4 = defaultColorSpring;
                            DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z13, finiteAnimationSpec4, function2, gapComposer, (i31 >> 3) & 524272, 0);
                            finiteAnimationSpec2 = finiteAnimationSpec4;
                            color11 = color6;
                            color14 = color9;
                            double d5 = d3;
                            shapes2 = shapes4;
                            platform2 = platform3;
                            z7 = z13;
                            z6 = z9;
                            color13 = color8;
                            zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                            color12 = color7;
                            color10 = color15;
                            d2 = d5;
                        } else {
                            gapComposer = gapComposer2;
                            gapComposer.skipToGroupEnd();
                            z6 = z2;
                            color10 = color5;
                            paletteStyle2 = paletteStyle;
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            shapes2 = shapes;
                            typography2 = typography;
                            finiteAnimationSpec2 = finiteAnimationSpec;
                            z7 = z4;
                            color11 = color6;
                            color12 = color7;
                            color13 = color8;
                            color14 = color9;
                            d2 = d;
                            platform2 = platform;
                        }
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            final boolean z14 = zIsSystemInDarkTheme;
                            final PaletteStyle paletteStyle4 = paletteStyle2;
                            final ColorSpec$SpecVersion colorSpec$SpecVersion4 = colorSpec$SpecVersion2;
                            final Typography typography4 = typography2;
                            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    ((Integer) obj2).getClass();
                                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                                    DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z14, z6, color11, color12, color13, color14, color10, paletteStyle4, d2, colorSpec$SpecVersion4, platform2, shapes2, typography4, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                    }
                    i4 |= 100663296;
                    i17 = i17;
                    if ((i & 805306368) == 0) {
                        if ((i3 & 512) == 0) {
                            i34 = i4;
                            if (gapComposer2.changed(d)) {
                                i35 = 536870912;
                            }
                            i19 = i34 | i35;
                        } else {
                            i34 = i4;
                        }
                        i35 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                        i19 = i34 | i35;
                    } else {
                        i19 = i4;
                    }
                    if ((i2 & 6) == 0) {
                        if ((i3 & 1024) != 0) {
                            i33 = 2;
                        } else {
                            if (colorSpec$SpecVersion == null) {
                                iOrdinal2 = -1;
                            } else {
                                iOrdinal2 = colorSpec$SpecVersion.ordinal();
                            }
                            if (gapComposer2.changed(iOrdinal2)) {
                                i33 = 4;
                            } else {
                                i33 = 2;
                            }
                        }
                        i20 = i2 | i33;
                    } else {
                        i20 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        int i310 = i20;
                        if ((i3 & 2048) != 0) {
                            i32 = 16;
                        } else {
                            if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                                i32 = 32;
                            } else {
                                i32 = 16;
                            }
                        }
                        i20 = i310 | i32;
                    }
                    i21 = i20;
                    if ((i2 & 384) == 0) {
                        i22 = i21 | (((i3 & 4096) == 0 || !gapComposer2.changed(shapes)) ? 128 : 256);
                    } else {
                        i22 = i21;
                    }
                    if ((i2 & 3072) != 0) {
                        if ((i3 & 8192) == 0) {
                            i6 = 2048;
                        }
                        i22 |= i6;
                    }
                    i23 = i22;
                    i24 = i3 & 16384;
                    if (i24 != 0) {
                        if ((i2 & 24576) == 0) {
                            z4 = z3;
                            i23 |= gapComposer2.changed(z4) ? 16384 : 8192;
                        }
                        if ((i2 & 196608) == 0) {
                            if ((i3 & 32768) == 0) {
                                if ((i2 & 262144) == 0) {
                                    zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                                } else {
                                    zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                                }
                                if (zChangedInstance) {
                                    i11 = 131072;
                                }
                            }
                            i23 |= i11;
                        }
                        if ((i2 & 1572864) == 0) {
                            i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                        }
                        i25 = i23;
                        if ((i19 & 306783379) == 306783378) {
                            z5 = true;
                        } else {
                            z5 = true;
                        }
                        if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                            gapComposer2.startDefaults();
                            if ((i & 1) != 0) {
                                if ((i3 & 2) != 0) {
                                    i19 &= -113;
                                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                }
                                if (i37 != 0) {
                                    z8 = false;
                                } else {
                                    z8 = z2;
                                }
                                if (i5 != 0) {
                                    color6 = null;
                                }
                                if (i8 != 0) {
                                    color7 = null;
                                }
                                if (i10 != 0) {
                                    color8 = null;
                                }
                                if (i13 != 0) {
                                    color9 = null;
                                }
                                if (i15 == 0) {
                                }
                                if (i17 != 0) {
                                    paletteStyle2 = PaletteStyle.TonalSpot;
                                } else {
                                    paletteStyle2 = paletteStyle;
                                }
                                if ((i3 & 512) != 0) {
                                    i26 = i19 & (-1879048193);
                                    d3 = 0.0d;
                                } else {
                                    d3 = d;
                                    i26 = i19;
                                }
                                z9 = z8;
                                if ((i3 & 1024) != 0) {
                                    ColorSpec$SpecVersion.Companion.getClass();
                                    i27 = i25 & (-15);
                                    colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                                } else {
                                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                    i27 = i25;
                                }
                                i28 = i27;
                                if ((i3 & 2048) != 0) {
                                    DynamicScheme.Platform.Companion.getClass();
                                    i29 = i28 & (-113);
                                    platform3 = DynamicScheme.Platform.Default;
                                } else {
                                    i29 = i28;
                                    platform3 = platform;
                                }
                                i30 = i26;
                                if ((i3 & 4096) != 0) {
                                    shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                    i29 &= -897;
                                } else {
                                    shapes3 = shapes;
                                }
                                Shapes shapes8 = shapes3;
                                if ((i3 & 8192) != 0) {
                                    typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                    i29 &= -7169;
                                } else {
                                    typography2 = typography;
                                }
                                if (i24 == 0) {
                                }
                                if ((i3 & 32768) != 0) {
                                    i31 = i29 & (-458753);
                                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                                } else {
                                    defaultColorSpring = finiteAnimationSpec;
                                    i31 = i29;
                                }
                                shapes4 = shapes8;
                            } else {
                                if ((i3 & 2) != 0) {
                                    i19 &= -113;
                                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                }
                                if (i37 != 0) {
                                    z8 = false;
                                } else {
                                    z8 = z2;
                                }
                                if (i5 != 0) {
                                    color6 = null;
                                }
                                if (i8 != 0) {
                                    color7 = null;
                                }
                                if (i10 != 0) {
                                    color8 = null;
                                }
                                if (i13 != 0) {
                                    color9 = null;
                                }
                                if (i15 == 0) {
                                }
                                if (i17 != 0) {
                                    paletteStyle2 = PaletteStyle.TonalSpot;
                                } else {
                                    paletteStyle2 = paletteStyle;
                                }
                                if ((i3 & 512) != 0) {
                                    i26 = i19 & (-1879048193);
                                    d3 = 0.0d;
                                } else {
                                    d3 = d;
                                    i26 = i19;
                                }
                                z9 = z8;
                                if ((i3 & 1024) != 0) {
                                    ColorSpec$SpecVersion.Companion.getClass();
                                    i27 = i25 & (-15);
                                    colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                                } else {
                                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                    i27 = i25;
                                }
                                i28 = i27;
                                if ((i3 & 2048) != 0) {
                                    DynamicScheme.Platform.Companion.getClass();
                                    i29 = i28 & (-113);
                                    platform3 = DynamicScheme.Platform.Default;
                                } else {
                                    i29 = i28;
                                    platform3 = platform;
                                }
                                i30 = i26;
                                if ((i3 & 4096) != 0) {
                                    shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                    i29 &= -897;
                                } else {
                                    shapes3 = shapes;
                                }
                                Shapes shapes9 = shapes3;
                                if ((i3 & 8192) != 0) {
                                    typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                    i29 &= -7169;
                                } else {
                                    typography2 = typography;
                                }
                                if (i24 == 0) {
                                }
                                if ((i3 & 32768) != 0) {
                                    i31 = i29 & (-458753);
                                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                                } else {
                                    defaultColorSpring = finiteAnimationSpec;
                                    i31 = i29;
                                }
                                shapes4 = shapes9;
                            }
                            gapComposer2.endDefaults();
                            gapComposer = gapComposer2;
                            boolean z15 = z10;
                            FiniteAnimationSpec finiteAnimationSpec5 = defaultColorSpring;
                            DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z15, finiteAnimationSpec5, function2, gapComposer, (i31 >> 3) & 524272, 0);
                            finiteAnimationSpec2 = finiteAnimationSpec5;
                            color11 = color6;
                            color14 = color9;
                            double d6 = d3;
                            shapes2 = shapes4;
                            platform2 = platform3;
                            z7 = z15;
                            z6 = z9;
                            color13 = color8;
                            zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                            color12 = color7;
                            color10 = color15;
                            d2 = d6;
                        } else {
                            gapComposer = gapComposer2;
                            gapComposer.skipToGroupEnd();
                            z6 = z2;
                            color10 = color5;
                            paletteStyle2 = paletteStyle;
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            shapes2 = shapes;
                            typography2 = typography;
                            finiteAnimationSpec2 = finiteAnimationSpec;
                            z7 = z4;
                            color11 = color6;
                            color12 = color7;
                            color13 = color8;
                            color14 = color9;
                            d2 = d;
                            platform2 = platform;
                        }
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            final boolean z16 = zIsSystemInDarkTheme;
                            final PaletteStyle paletteStyle5 = paletteStyle2;
                            final ColorSpec$SpecVersion colorSpec$SpecVersion5 = colorSpec$SpecVersion2;
                            final Typography typography5 = typography2;
                            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    ((Integer) obj2).getClass();
                                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                                    DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z16, z6, color11, color12, color13, color14, color10, paletteStyle5, d2, colorSpec$SpecVersion5, platform2, shapes2, typography5, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                    }
                    i23 |= 24576;
                    z4 = z3;
                    if ((i2 & 196608) == 0) {
                        if ((i3 & 32768) == 0) {
                            if ((i2 & 262144) == 0) {
                                zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                            } else {
                                zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                            }
                            if (zChangedInstance) {
                                i11 = 131072;
                            }
                        }
                        i23 |= i11;
                    }
                    if ((i2 & 1572864) == 0) {
                        i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                    }
                    i25 = i23;
                    if ((i19 & 306783379) == 306783378) {
                        z5 = true;
                    } else {
                        z5 = true;
                    }
                    if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                        gapComposer2.startDefaults();
                        if ((i & 1) != 0) {
                            if ((i3 & 2) != 0) {
                                i19 &= -113;
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            }
                            if (i37 != 0) {
                                z8 = false;
                            } else {
                                z8 = z2;
                            }
                            if (i5 != 0) {
                                color6 = null;
                            }
                            if (i8 != 0) {
                                color7 = null;
                            }
                            if (i10 != 0) {
                                color8 = null;
                            }
                            if (i13 != 0) {
                                color9 = null;
                            }
                            if (i15 == 0) {
                            }
                            if (i17 != 0) {
                                paletteStyle2 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle2 = paletteStyle;
                            }
                            if ((i3 & 512) != 0) {
                                i26 = i19 & (-1879048193);
                                d3 = 0.0d;
                            } else {
                                d3 = d;
                                i26 = i19;
                            }
                            z9 = z8;
                            if ((i3 & 1024) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i27 = i25 & (-15);
                                colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                i27 = i25;
                            }
                            i28 = i27;
                            if ((i3 & 2048) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i29 = i28 & (-113);
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                i29 = i28;
                                platform3 = platform;
                            }
                            i30 = i26;
                            if ((i3 & 4096) != 0) {
                                shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i29 &= -897;
                            } else {
                                shapes3 = shapes;
                            }
                            Shapes shapes10 = shapes3;
                            if ((i3 & 8192) != 0) {
                                typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i29 &= -7169;
                            } else {
                                typography2 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 32768) != 0) {
                                i31 = i29 & (-458753);
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                                i31 = i29;
                            }
                            shapes4 = shapes10;
                        } else {
                            if ((i3 & 2) != 0) {
                                i19 &= -113;
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            }
                            if (i37 != 0) {
                                z8 = false;
                            } else {
                                z8 = z2;
                            }
                            if (i5 != 0) {
                                color6 = null;
                            }
                            if (i8 != 0) {
                                color7 = null;
                            }
                            if (i10 != 0) {
                                color8 = null;
                            }
                            if (i13 != 0) {
                                color9 = null;
                            }
                            if (i15 == 0) {
                            }
                            if (i17 != 0) {
                                paletteStyle2 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle2 = paletteStyle;
                            }
                            if ((i3 & 512) != 0) {
                                i26 = i19 & (-1879048193);
                                d3 = 0.0d;
                            } else {
                                d3 = d;
                                i26 = i19;
                            }
                            z9 = z8;
                            if ((i3 & 1024) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i27 = i25 & (-15);
                                colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                i27 = i25;
                            }
                            i28 = i27;
                            if ((i3 & 2048) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i29 = i28 & (-113);
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                i29 = i28;
                                platform3 = platform;
                            }
                            i30 = i26;
                            if ((i3 & 4096) != 0) {
                                shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i29 &= -897;
                            } else {
                                shapes3 = shapes;
                            }
                            Shapes shapes11 = shapes3;
                            if ((i3 & 8192) != 0) {
                                typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i29 &= -7169;
                            } else {
                                typography2 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 32768) != 0) {
                                i31 = i29 & (-458753);
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                                i31 = i29;
                            }
                            shapes4 = shapes11;
                        }
                        gapComposer2.endDefaults();
                        gapComposer = gapComposer2;
                        boolean z17 = z10;
                        FiniteAnimationSpec finiteAnimationSpec6 = defaultColorSpring;
                        DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z17, finiteAnimationSpec6, function2, gapComposer, (i31 >> 3) & 524272, 0);
                        finiteAnimationSpec2 = finiteAnimationSpec6;
                        color11 = color6;
                        color14 = color9;
                        double d7 = d3;
                        shapes2 = shapes4;
                        platform2 = platform3;
                        z7 = z17;
                        z6 = z9;
                        color13 = color8;
                        zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                        color12 = color7;
                        color10 = color15;
                        d2 = d7;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        z6 = z2;
                        color10 = color5;
                        paletteStyle2 = paletteStyle;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        shapes2 = shapes;
                        typography2 = typography;
                        finiteAnimationSpec2 = finiteAnimationSpec;
                        z7 = z4;
                        color11 = color6;
                        color12 = color7;
                        color13 = color8;
                        color14 = color9;
                        d2 = d;
                        platform2 = platform;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        final boolean z18 = zIsSystemInDarkTheme;
                        final PaletteStyle paletteStyle6 = paletteStyle2;
                        final ColorSpec$SpecVersion colorSpec$SpecVersion6 = colorSpec$SpecVersion2;
                        final Typography typography6 = typography2;
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                                DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z18, z6, color11, color12, color13, color14, color10, paletteStyle6, d2, colorSpec$SpecVersion6, platform2, shapes2, typography6, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i4 |= 24576;
                color7 = color2;
                i10 = i3 & 32;
                i11 = 65536;
                if (i10 != 0) {
                    i4 |= 196608;
                    color8 = color3;
                } else {
                    color8 = color3;
                    if ((i & 196608) == 0) {
                        if (gapComposer2.changed(color8)) {
                            i12 = 131072;
                        } else {
                            i12 = 65536;
                        }
                        i4 |= i12;
                    }
                }
                i13 = i3 & 64;
                if (i13 != 0) {
                    i4 |= 1572864;
                    color9 = color4;
                } else {
                    color9 = color4;
                    if ((i & 1572864) == 0) {
                        if (gapComposer2.changed(color9)) {
                            i14 = 1048576;
                        } else {
                            i14 = 524288;
                        }
                        i4 |= i14;
                    }
                }
                i15 = i3 & 128;
                if (i15 != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (gapComposer2.changed(color5)) {
                        i16 = 8388608;
                    } else {
                        i16 = 4194304;
                    }
                    i4 |= i16;
                }
                i17 = i3 & 256;
                if (i17 != 0) {
                    if ((i & 100663296) == 0) {
                        if (paletteStyle == null) {
                            iOrdinal = -1;
                        } else {
                            iOrdinal = paletteStyle.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal)) {
                            i18 = 67108864;
                        } else {
                            i18 = 33554432;
                        }
                        i4 |= i18;
                    }
                    if ((i & 805306368) == 0) {
                        if ((i3 & 512) == 0) {
                            i34 = i4;
                            if (gapComposer2.changed(d)) {
                                i35 = 536870912;
                            }
                            i19 = i34 | i35;
                        } else {
                            i34 = i4;
                        }
                        i35 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                        i19 = i34 | i35;
                    } else {
                        i19 = i4;
                    }
                    if ((i2 & 6) == 0) {
                        if ((i3 & 1024) != 0) {
                            i33 = 2;
                        } else {
                            if (colorSpec$SpecVersion == null) {
                                iOrdinal2 = -1;
                            } else {
                                iOrdinal2 = colorSpec$SpecVersion.ordinal();
                            }
                            if (gapComposer2.changed(iOrdinal2)) {
                                i33 = 4;
                            } else {
                                i33 = 2;
                            }
                        }
                        i20 = i2 | i33;
                    } else {
                        i20 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        int i311 = i20;
                        if ((i3 & 2048) != 0) {
                            i32 = 16;
                        } else {
                            if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                                i32 = 32;
                            } else {
                                i32 = 16;
                            }
                        }
                        i20 = i311 | i32;
                    }
                    i21 = i20;
                    if ((i2 & 384) == 0) {
                        i22 = i21 | (((i3 & 4096) == 0 || !gapComposer2.changed(shapes)) ? 128 : 256);
                    } else {
                        i22 = i21;
                    }
                    if ((i2 & 3072) != 0) {
                        if ((i3 & 8192) == 0) {
                            i6 = 2048;
                        }
                        i22 |= i6;
                    }
                    i23 = i22;
                    i24 = i3 & 16384;
                    if (i24 != 0) {
                        if ((i2 & 24576) == 0) {
                            z4 = z3;
                            i23 |= gapComposer2.changed(z4) ? 16384 : 8192;
                        }
                        if ((i2 & 196608) == 0) {
                            if ((i3 & 32768) == 0) {
                                if ((i2 & 262144) == 0) {
                                    zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                                } else {
                                    zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                                }
                                if (zChangedInstance) {
                                    i11 = 131072;
                                }
                            }
                            i23 |= i11;
                        }
                        if ((i2 & 1572864) == 0) {
                            i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                        }
                        i25 = i23;
                        if ((i19 & 306783379) == 306783378) {
                            z5 = true;
                        } else {
                            z5 = true;
                        }
                        if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                            gapComposer2.startDefaults();
                            if ((i & 1) != 0) {
                                if ((i3 & 2) != 0) {
                                    i19 &= -113;
                                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                }
                                if (i37 != 0) {
                                    z8 = false;
                                } else {
                                    z8 = z2;
                                }
                                if (i5 != 0) {
                                    color6 = null;
                                }
                                if (i8 != 0) {
                                    color7 = null;
                                }
                                if (i10 != 0) {
                                    color8 = null;
                                }
                                if (i13 != 0) {
                                    color9 = null;
                                }
                                if (i15 == 0) {
                                }
                                if (i17 != 0) {
                                    paletteStyle2 = PaletteStyle.TonalSpot;
                                } else {
                                    paletteStyle2 = paletteStyle;
                                }
                                if ((i3 & 512) != 0) {
                                    i26 = i19 & (-1879048193);
                                    d3 = 0.0d;
                                } else {
                                    d3 = d;
                                    i26 = i19;
                                }
                                z9 = z8;
                                if ((i3 & 1024) != 0) {
                                    ColorSpec$SpecVersion.Companion.getClass();
                                    i27 = i25 & (-15);
                                    colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                                } else {
                                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                    i27 = i25;
                                }
                                i28 = i27;
                                if ((i3 & 2048) != 0) {
                                    DynamicScheme.Platform.Companion.getClass();
                                    i29 = i28 & (-113);
                                    platform3 = DynamicScheme.Platform.Default;
                                } else {
                                    i29 = i28;
                                    platform3 = platform;
                                }
                                i30 = i26;
                                if ((i3 & 4096) != 0) {
                                    shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                    i29 &= -897;
                                } else {
                                    shapes3 = shapes;
                                }
                                Shapes shapes12 = shapes3;
                                if ((i3 & 8192) != 0) {
                                    typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                    i29 &= -7169;
                                } else {
                                    typography2 = typography;
                                }
                                if (i24 == 0) {
                                }
                                if ((i3 & 32768) != 0) {
                                    i31 = i29 & (-458753);
                                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                                } else {
                                    defaultColorSpring = finiteAnimationSpec;
                                    i31 = i29;
                                }
                                shapes4 = shapes12;
                            } else {
                                if ((i3 & 2) != 0) {
                                    i19 &= -113;
                                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                }
                                if (i37 != 0) {
                                    z8 = false;
                                } else {
                                    z8 = z2;
                                }
                                if (i5 != 0) {
                                    color6 = null;
                                }
                                if (i8 != 0) {
                                    color7 = null;
                                }
                                if (i10 != 0) {
                                    color8 = null;
                                }
                                if (i13 != 0) {
                                    color9 = null;
                                }
                                if (i15 == 0) {
                                }
                                if (i17 != 0) {
                                    paletteStyle2 = PaletteStyle.TonalSpot;
                                } else {
                                    paletteStyle2 = paletteStyle;
                                }
                                if ((i3 & 512) != 0) {
                                    i26 = i19 & (-1879048193);
                                    d3 = 0.0d;
                                } else {
                                    d3 = d;
                                    i26 = i19;
                                }
                                z9 = z8;
                                if ((i3 & 1024) != 0) {
                                    ColorSpec$SpecVersion.Companion.getClass();
                                    i27 = i25 & (-15);
                                    colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                                } else {
                                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                    i27 = i25;
                                }
                                i28 = i27;
                                if ((i3 & 2048) != 0) {
                                    DynamicScheme.Platform.Companion.getClass();
                                    i29 = i28 & (-113);
                                    platform3 = DynamicScheme.Platform.Default;
                                } else {
                                    i29 = i28;
                                    platform3 = platform;
                                }
                                i30 = i26;
                                if ((i3 & 4096) != 0) {
                                    shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                    i29 &= -897;
                                } else {
                                    shapes3 = shapes;
                                }
                                Shapes shapes13 = shapes3;
                                if ((i3 & 8192) != 0) {
                                    typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                    i29 &= -7169;
                                } else {
                                    typography2 = typography;
                                }
                                if (i24 == 0) {
                                }
                                if ((i3 & 32768) != 0) {
                                    i31 = i29 & (-458753);
                                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                                } else {
                                    defaultColorSpring = finiteAnimationSpec;
                                    i31 = i29;
                                }
                                shapes4 = shapes13;
                            }
                            gapComposer2.endDefaults();
                            gapComposer = gapComposer2;
                            boolean z19 = z10;
                            FiniteAnimationSpec finiteAnimationSpec7 = defaultColorSpring;
                            DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z19, finiteAnimationSpec7, function2, gapComposer, (i31 >> 3) & 524272, 0);
                            finiteAnimationSpec2 = finiteAnimationSpec7;
                            color11 = color6;
                            color14 = color9;
                            double d8 = d3;
                            shapes2 = shapes4;
                            platform2 = platform3;
                            z7 = z19;
                            z6 = z9;
                            color13 = color8;
                            zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                            color12 = color7;
                            color10 = color15;
                            d2 = d8;
                        } else {
                            gapComposer = gapComposer2;
                            gapComposer.skipToGroupEnd();
                            z6 = z2;
                            color10 = color5;
                            paletteStyle2 = paletteStyle;
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            shapes2 = shapes;
                            typography2 = typography;
                            finiteAnimationSpec2 = finiteAnimationSpec;
                            z7 = z4;
                            color11 = color6;
                            color12 = color7;
                            color13 = color8;
                            color14 = color9;
                            d2 = d;
                            platform2 = platform;
                        }
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            final boolean z110 = zIsSystemInDarkTheme;
                            final PaletteStyle paletteStyle7 = paletteStyle2;
                            final ColorSpec$SpecVersion colorSpec$SpecVersion7 = colorSpec$SpecVersion2;
                            final Typography typography7 = typography2;
                            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    ((Integer) obj2).getClass();
                                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                                    DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z110, z6, color11, color12, color13, color14, color10, paletteStyle7, d2, colorSpec$SpecVersion7, platform2, shapes2, typography7, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                    }
                    i23 |= 24576;
                    z4 = z3;
                    if ((i2 & 196608) == 0) {
                        if ((i3 & 32768) == 0) {
                            if ((i2 & 262144) == 0) {
                                zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                            } else {
                                zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                            }
                            if (zChangedInstance) {
                                i11 = 131072;
                            }
                        }
                        i23 |= i11;
                    }
                    if ((i2 & 1572864) == 0) {
                        i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                    }
                    i25 = i23;
                    if ((i19 & 306783379) == 306783378) {
                        z5 = true;
                    } else {
                        z5 = true;
                    }
                    if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                        gapComposer2.startDefaults();
                        if ((i & 1) != 0) {
                            if ((i3 & 2) != 0) {
                                i19 &= -113;
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            }
                            if (i37 != 0) {
                                z8 = false;
                            } else {
                                z8 = z2;
                            }
                            if (i5 != 0) {
                                color6 = null;
                            }
                            if (i8 != 0) {
                                color7 = null;
                            }
                            if (i10 != 0) {
                                color8 = null;
                            }
                            if (i13 != 0) {
                                color9 = null;
                            }
                            if (i15 == 0) {
                            }
                            if (i17 != 0) {
                                paletteStyle2 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle2 = paletteStyle;
                            }
                            if ((i3 & 512) != 0) {
                                i26 = i19 & (-1879048193);
                                d3 = 0.0d;
                            } else {
                                d3 = d;
                                i26 = i19;
                            }
                            z9 = z8;
                            if ((i3 & 1024) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i27 = i25 & (-15);
                                colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                i27 = i25;
                            }
                            i28 = i27;
                            if ((i3 & 2048) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i29 = i28 & (-113);
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                i29 = i28;
                                platform3 = platform;
                            }
                            i30 = i26;
                            if ((i3 & 4096) != 0) {
                                shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i29 &= -897;
                            } else {
                                shapes3 = shapes;
                            }
                            Shapes shapes14 = shapes3;
                            if ((i3 & 8192) != 0) {
                                typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i29 &= -7169;
                            } else {
                                typography2 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 32768) != 0) {
                                i31 = i29 & (-458753);
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                                i31 = i29;
                            }
                            shapes4 = shapes14;
                        } else {
                            if ((i3 & 2) != 0) {
                                i19 &= -113;
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            }
                            if (i37 != 0) {
                                z8 = false;
                            } else {
                                z8 = z2;
                            }
                            if (i5 != 0) {
                                color6 = null;
                            }
                            if (i8 != 0) {
                                color7 = null;
                            }
                            if (i10 != 0) {
                                color8 = null;
                            }
                            if (i13 != 0) {
                                color9 = null;
                            }
                            if (i15 == 0) {
                            }
                            if (i17 != 0) {
                                paletteStyle2 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle2 = paletteStyle;
                            }
                            if ((i3 & 512) != 0) {
                                i26 = i19 & (-1879048193);
                                d3 = 0.0d;
                            } else {
                                d3 = d;
                                i26 = i19;
                            }
                            z9 = z8;
                            if ((i3 & 1024) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i27 = i25 & (-15);
                                colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                i27 = i25;
                            }
                            i28 = i27;
                            if ((i3 & 2048) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i29 = i28 & (-113);
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                i29 = i28;
                                platform3 = platform;
                            }
                            i30 = i26;
                            if ((i3 & 4096) != 0) {
                                shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i29 &= -897;
                            } else {
                                shapes3 = shapes;
                            }
                            Shapes shapes15 = shapes3;
                            if ((i3 & 8192) != 0) {
                                typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i29 &= -7169;
                            } else {
                                typography2 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 32768) != 0) {
                                i31 = i29 & (-458753);
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                                i31 = i29;
                            }
                            shapes4 = shapes15;
                        }
                        gapComposer2.endDefaults();
                        gapComposer = gapComposer2;
                        boolean z111 = z10;
                        FiniteAnimationSpec finiteAnimationSpec8 = defaultColorSpring;
                        DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z111, finiteAnimationSpec8, function2, gapComposer, (i31 >> 3) & 524272, 0);
                        finiteAnimationSpec2 = finiteAnimationSpec8;
                        color11 = color6;
                        color14 = color9;
                        double d9 = d3;
                        shapes2 = shapes4;
                        platform2 = platform3;
                        z7 = z111;
                        z6 = z9;
                        color13 = color8;
                        zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                        color12 = color7;
                        color10 = color15;
                        d2 = d9;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        z6 = z2;
                        color10 = color5;
                        paletteStyle2 = paletteStyle;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        shapes2 = shapes;
                        typography2 = typography;
                        finiteAnimationSpec2 = finiteAnimationSpec;
                        z7 = z4;
                        color11 = color6;
                        color12 = color7;
                        color13 = color8;
                        color14 = color9;
                        d2 = d;
                        platform2 = platform;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        final boolean z112 = zIsSystemInDarkTheme;
                        final PaletteStyle paletteStyle8 = paletteStyle2;
                        final ColorSpec$SpecVersion colorSpec$SpecVersion8 = colorSpec$SpecVersion2;
                        final Typography typography8 = typography2;
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                                DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z112, z6, color11, color12, color13, color14, color10, paletteStyle8, d2, colorSpec$SpecVersion8, platform2, shapes2, typography8, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i4 |= 100663296;
                i17 = i17;
                if ((i & 805306368) == 0) {
                    if ((i3 & 512) == 0) {
                        i34 = i4;
                        if (gapComposer2.changed(d)) {
                            i35 = 536870912;
                        }
                        i19 = i34 | i35;
                    } else {
                        i34 = i4;
                    }
                    i35 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                    i19 = i34 | i35;
                } else {
                    i19 = i4;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) != 0) {
                        i33 = 2;
                    } else {
                        if (colorSpec$SpecVersion == null) {
                            iOrdinal2 = -1;
                        } else {
                            iOrdinal2 = colorSpec$SpecVersion.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal2)) {
                            i33 = 4;
                        } else {
                            i33 = 2;
                        }
                    }
                    i20 = i2 | i33;
                } else {
                    i20 = i2;
                }
                if ((i2 & 48) == 0) {
                    int i312 = i20;
                    if ((i3 & 2048) != 0) {
                        i32 = 16;
                    } else {
                        if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                            i32 = 32;
                        } else {
                            i32 = 16;
                        }
                    }
                    i20 = i312 | i32;
                }
                i21 = i20;
                if ((i2 & 384) == 0) {
                    i22 = i21 | (((i3 & 4096) == 0 || !gapComposer2.changed(shapes)) ? 128 : 256);
                } else {
                    i22 = i21;
                }
                if ((i2 & 3072) != 0) {
                    if ((i3 & 8192) == 0) {
                        i6 = 2048;
                    }
                    i22 |= i6;
                }
                i23 = i22;
                i24 = i3 & 16384;
                if (i24 != 0) {
                    if ((i2 & 24576) == 0) {
                        z4 = z3;
                        i23 |= gapComposer2.changed(z4) ? 16384 : 8192;
                    }
                    if ((i2 & 196608) == 0) {
                        if ((i3 & 32768) == 0) {
                            if ((i2 & 262144) == 0) {
                                zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                            } else {
                                zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                            }
                            if (zChangedInstance) {
                                i11 = 131072;
                            }
                        }
                        i23 |= i11;
                    }
                    if ((i2 & 1572864) == 0) {
                        i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                    }
                    i25 = i23;
                    if ((i19 & 306783379) == 306783378) {
                        z5 = true;
                    } else {
                        z5 = true;
                    }
                    if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                        gapComposer2.startDefaults();
                        if ((i & 1) != 0) {
                            if ((i3 & 2) != 0) {
                                i19 &= -113;
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            }
                            if (i37 != 0) {
                                z8 = false;
                            } else {
                                z8 = z2;
                            }
                            if (i5 != 0) {
                                color6 = null;
                            }
                            if (i8 != 0) {
                                color7 = null;
                            }
                            if (i10 != 0) {
                                color8 = null;
                            }
                            if (i13 != 0) {
                                color9 = null;
                            }
                            if (i15 == 0) {
                            }
                            if (i17 != 0) {
                                paletteStyle2 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle2 = paletteStyle;
                            }
                            if ((i3 & 512) != 0) {
                                i26 = i19 & (-1879048193);
                                d3 = 0.0d;
                            } else {
                                d3 = d;
                                i26 = i19;
                            }
                            z9 = z8;
                            if ((i3 & 1024) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i27 = i25 & (-15);
                                colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                i27 = i25;
                            }
                            i28 = i27;
                            if ((i3 & 2048) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i29 = i28 & (-113);
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                i29 = i28;
                                platform3 = platform;
                            }
                            i30 = i26;
                            if ((i3 & 4096) != 0) {
                                shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i29 &= -897;
                            } else {
                                shapes3 = shapes;
                            }
                            Shapes shapes16 = shapes3;
                            if ((i3 & 8192) != 0) {
                                typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i29 &= -7169;
                            } else {
                                typography2 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 32768) != 0) {
                                i31 = i29 & (-458753);
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                                i31 = i29;
                            }
                            shapes4 = shapes16;
                        } else {
                            if ((i3 & 2) != 0) {
                                i19 &= -113;
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            }
                            if (i37 != 0) {
                                z8 = false;
                            } else {
                                z8 = z2;
                            }
                            if (i5 != 0) {
                                color6 = null;
                            }
                            if (i8 != 0) {
                                color7 = null;
                            }
                            if (i10 != 0) {
                                color8 = null;
                            }
                            if (i13 != 0) {
                                color9 = null;
                            }
                            if (i15 == 0) {
                            }
                            if (i17 != 0) {
                                paletteStyle2 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle2 = paletteStyle;
                            }
                            if ((i3 & 512) != 0) {
                                i26 = i19 & (-1879048193);
                                d3 = 0.0d;
                            } else {
                                d3 = d;
                                i26 = i19;
                            }
                            z9 = z8;
                            if ((i3 & 1024) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i27 = i25 & (-15);
                                colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                i27 = i25;
                            }
                            i28 = i27;
                            if ((i3 & 2048) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i29 = i28 & (-113);
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                i29 = i28;
                                platform3 = platform;
                            }
                            i30 = i26;
                            if ((i3 & 4096) != 0) {
                                shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i29 &= -897;
                            } else {
                                shapes3 = shapes;
                            }
                            Shapes shapes17 = shapes3;
                            if ((i3 & 8192) != 0) {
                                typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i29 &= -7169;
                            } else {
                                typography2 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 32768) != 0) {
                                i31 = i29 & (-458753);
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                                i31 = i29;
                            }
                            shapes4 = shapes17;
                        }
                        gapComposer2.endDefaults();
                        gapComposer = gapComposer2;
                        boolean z113 = z10;
                        FiniteAnimationSpec finiteAnimationSpec9 = defaultColorSpring;
                        DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z113, finiteAnimationSpec9, function2, gapComposer, (i31 >> 3) & 524272, 0);
                        finiteAnimationSpec2 = finiteAnimationSpec9;
                        color11 = color6;
                        color14 = color9;
                        double d10 = d3;
                        shapes2 = shapes4;
                        platform2 = platform3;
                        z7 = z113;
                        z6 = z9;
                        color13 = color8;
                        zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                        color12 = color7;
                        color10 = color15;
                        d2 = d10;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        z6 = z2;
                        color10 = color5;
                        paletteStyle2 = paletteStyle;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        shapes2 = shapes;
                        typography2 = typography;
                        finiteAnimationSpec2 = finiteAnimationSpec;
                        z7 = z4;
                        color11 = color6;
                        color12 = color7;
                        color13 = color8;
                        color14 = color9;
                        d2 = d;
                        platform2 = platform;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        final boolean z114 = zIsSystemInDarkTheme;
                        final PaletteStyle paletteStyle9 = paletteStyle2;
                        final ColorSpec$SpecVersion colorSpec$SpecVersion9 = colorSpec$SpecVersion2;
                        final Typography typography9 = typography2;
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                                DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z114, z6, color11, color12, color13, color14, color10, paletteStyle9, d2, colorSpec$SpecVersion9, platform2, shapes2, typography9, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i23 |= 24576;
                z4 = z3;
                if ((i2 & 196608) == 0) {
                    if ((i3 & 32768) == 0) {
                        if ((i2 & 262144) == 0) {
                            zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                        } else {
                            zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                        }
                        if (zChangedInstance) {
                            i11 = 131072;
                        }
                    }
                    i23 |= i11;
                }
                if ((i2 & 1572864) == 0) {
                    i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                }
                i25 = i23;
                if ((i19 & 306783379) == 306783378) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0) {
                        if ((i3 & 2) != 0) {
                            i19 &= -113;
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        }
                        if (i37 != 0) {
                            z8 = false;
                        } else {
                            z8 = z2;
                        }
                        if (i5 != 0) {
                            color6 = null;
                        }
                        if (i8 != 0) {
                            color7 = null;
                        }
                        if (i10 != 0) {
                            color8 = null;
                        }
                        if (i13 != 0) {
                            color9 = null;
                        }
                        if (i15 == 0) {
                        }
                        if (i17 != 0) {
                            paletteStyle2 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle2 = paletteStyle;
                        }
                        if ((i3 & 512) != 0) {
                            i26 = i19 & (-1879048193);
                            d3 = 0.0d;
                        } else {
                            d3 = d;
                            i26 = i19;
                        }
                        z9 = z8;
                        if ((i3 & 1024) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i27 = i25 & (-15);
                            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            i27 = i25;
                        }
                        i28 = i27;
                        if ((i3 & 2048) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i29 = i28 & (-113);
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            i29 = i28;
                            platform3 = platform;
                        }
                        i30 = i26;
                        if ((i3 & 4096) != 0) {
                            shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i29 &= -897;
                        } else {
                            shapes3 = shapes;
                        }
                        Shapes shapes18 = shapes3;
                        if ((i3 & 8192) != 0) {
                            typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i29 &= -7169;
                        } else {
                            typography2 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 32768) != 0) {
                            i31 = i29 & (-458753);
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                            i31 = i29;
                        }
                        shapes4 = shapes18;
                    } else {
                        if ((i3 & 2) != 0) {
                            i19 &= -113;
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        }
                        if (i37 != 0) {
                            z8 = false;
                        } else {
                            z8 = z2;
                        }
                        if (i5 != 0) {
                            color6 = null;
                        }
                        if (i8 != 0) {
                            color7 = null;
                        }
                        if (i10 != 0) {
                            color8 = null;
                        }
                        if (i13 != 0) {
                            color9 = null;
                        }
                        if (i15 == 0) {
                        }
                        if (i17 != 0) {
                            paletteStyle2 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle2 = paletteStyle;
                        }
                        if ((i3 & 512) != 0) {
                            i26 = i19 & (-1879048193);
                            d3 = 0.0d;
                        } else {
                            d3 = d;
                            i26 = i19;
                        }
                        z9 = z8;
                        if ((i3 & 1024) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i27 = i25 & (-15);
                            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            i27 = i25;
                        }
                        i28 = i27;
                        if ((i3 & 2048) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i29 = i28 & (-113);
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            i29 = i28;
                            platform3 = platform;
                        }
                        i30 = i26;
                        if ((i3 & 4096) != 0) {
                            shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i29 &= -897;
                        } else {
                            shapes3 = shapes;
                        }
                        Shapes shapes19 = shapes3;
                        if ((i3 & 8192) != 0) {
                            typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i29 &= -7169;
                        } else {
                            typography2 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 32768) != 0) {
                            i31 = i29 & (-458753);
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                            i31 = i29;
                        }
                        shapes4 = shapes19;
                    }
                    gapComposer2.endDefaults();
                    gapComposer = gapComposer2;
                    boolean z115 = z10;
                    FiniteAnimationSpec finiteAnimationSpec10 = defaultColorSpring;
                    DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z115, finiteAnimationSpec10, function2, gapComposer, (i31 >> 3) & 524272, 0);
                    finiteAnimationSpec2 = finiteAnimationSpec10;
                    color11 = color6;
                    color14 = color9;
                    double d11 = d3;
                    shapes2 = shapes4;
                    platform2 = platform3;
                    z7 = z115;
                    z6 = z9;
                    color13 = color8;
                    zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                    color12 = color7;
                    color10 = color15;
                    d2 = d11;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z6 = z2;
                    color10 = color5;
                    paletteStyle2 = paletteStyle;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    shapes2 = shapes;
                    typography2 = typography;
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    z7 = z4;
                    color11 = color6;
                    color12 = color7;
                    color13 = color8;
                    color14 = color9;
                    d2 = d;
                    platform2 = platform;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final boolean z116 = zIsSystemInDarkTheme;
                    final PaletteStyle paletteStyle10 = paletteStyle2;
                    final ColorSpec$SpecVersion colorSpec$SpecVersion10 = colorSpec$SpecVersion2;
                    final Typography typography10 = typography2;
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                            DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z116, z6, color11, color12, color13, color14, color10, paletteStyle10, d2, colorSpec$SpecVersion10, platform2, shapes2, typography10, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i4 |= 3072;
            color6 = color;
            i8 = i3 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    color7 = color2;
                    if (gapComposer2.changed(color7)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i4 |= i9;
                }
                i10 = i3 & 32;
                i11 = 65536;
                if (i10 != 0) {
                    i4 |= 196608;
                    color8 = color3;
                } else {
                    color8 = color3;
                    if ((i & 196608) == 0) {
                        if (gapComposer2.changed(color8)) {
                            i12 = 131072;
                        } else {
                            i12 = 65536;
                        }
                        i4 |= i12;
                    }
                }
                i13 = i3 & 64;
                if (i13 != 0) {
                    i4 |= 1572864;
                    color9 = color4;
                } else {
                    color9 = color4;
                    if ((i & 1572864) == 0) {
                        if (gapComposer2.changed(color9)) {
                            i14 = 1048576;
                        } else {
                            i14 = 524288;
                        }
                        i4 |= i14;
                    }
                }
                i15 = i3 & 128;
                if (i15 != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (gapComposer2.changed(color5)) {
                        i16 = 8388608;
                    } else {
                        i16 = 4194304;
                    }
                    i4 |= i16;
                }
                i17 = i3 & 256;
                if (i17 != 0) {
                    if ((i & 100663296) == 0) {
                        if (paletteStyle == null) {
                            iOrdinal = -1;
                        } else {
                            iOrdinal = paletteStyle.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal)) {
                            i18 = 67108864;
                        } else {
                            i18 = 33554432;
                        }
                        i4 |= i18;
                    }
                    if ((i & 805306368) == 0) {
                        if ((i3 & 512) == 0) {
                            i34 = i4;
                            if (gapComposer2.changed(d)) {
                                i35 = 536870912;
                            }
                            i19 = i34 | i35;
                        } else {
                            i34 = i4;
                        }
                        i35 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                        i19 = i34 | i35;
                    } else {
                        i19 = i4;
                    }
                    if ((i2 & 6) == 0) {
                        if ((i3 & 1024) != 0) {
                            i33 = 2;
                        } else {
                            if (colorSpec$SpecVersion == null) {
                                iOrdinal2 = -1;
                            } else {
                                iOrdinal2 = colorSpec$SpecVersion.ordinal();
                            }
                            if (gapComposer2.changed(iOrdinal2)) {
                                i33 = 4;
                            } else {
                                i33 = 2;
                            }
                        }
                        i20 = i2 | i33;
                    } else {
                        i20 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        int i313 = i20;
                        if ((i3 & 2048) != 0) {
                            i32 = 16;
                        } else {
                            if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                                i32 = 32;
                            } else {
                                i32 = 16;
                            }
                        }
                        i20 = i313 | i32;
                    }
                    i21 = i20;
                    if ((i2 & 384) == 0) {
                        i22 = i21 | (((i3 & 4096) == 0 || !gapComposer2.changed(shapes)) ? 128 : 256);
                    } else {
                        i22 = i21;
                    }
                    if ((i2 & 3072) != 0) {
                        if ((i3 & 8192) == 0) {
                            i6 = 2048;
                        }
                        i22 |= i6;
                    }
                    i23 = i22;
                    i24 = i3 & 16384;
                    if (i24 != 0) {
                        if ((i2 & 24576) == 0) {
                            z4 = z3;
                            i23 |= gapComposer2.changed(z4) ? 16384 : 8192;
                        }
                        if ((i2 & 196608) == 0) {
                            if ((i3 & 32768) == 0) {
                                if ((i2 & 262144) == 0) {
                                    zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                                } else {
                                    zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                                }
                                if (zChangedInstance) {
                                    i11 = 131072;
                                }
                            }
                            i23 |= i11;
                        }
                        if ((i2 & 1572864) == 0) {
                            i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                        }
                        i25 = i23;
                        if ((i19 & 306783379) == 306783378) {
                            z5 = true;
                        } else {
                            z5 = true;
                        }
                        if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                            gapComposer2.startDefaults();
                            if ((i & 1) != 0) {
                                if ((i3 & 2) != 0) {
                                    i19 &= -113;
                                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                }
                                if (i37 != 0) {
                                    z8 = false;
                                } else {
                                    z8 = z2;
                                }
                                if (i5 != 0) {
                                    color6 = null;
                                }
                                if (i8 != 0) {
                                    color7 = null;
                                }
                                if (i10 != 0) {
                                    color8 = null;
                                }
                                if (i13 != 0) {
                                    color9 = null;
                                }
                                if (i15 == 0) {
                                }
                                if (i17 != 0) {
                                    paletteStyle2 = PaletteStyle.TonalSpot;
                                } else {
                                    paletteStyle2 = paletteStyle;
                                }
                                if ((i3 & 512) != 0) {
                                    i26 = i19 & (-1879048193);
                                    d3 = 0.0d;
                                } else {
                                    d3 = d;
                                    i26 = i19;
                                }
                                z9 = z8;
                                if ((i3 & 1024) != 0) {
                                    ColorSpec$SpecVersion.Companion.getClass();
                                    i27 = i25 & (-15);
                                    colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                                } else {
                                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                    i27 = i25;
                                }
                                i28 = i27;
                                if ((i3 & 2048) != 0) {
                                    DynamicScheme.Platform.Companion.getClass();
                                    i29 = i28 & (-113);
                                    platform3 = DynamicScheme.Platform.Default;
                                } else {
                                    i29 = i28;
                                    platform3 = platform;
                                }
                                i30 = i26;
                                if ((i3 & 4096) != 0) {
                                    shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                    i29 &= -897;
                                } else {
                                    shapes3 = shapes;
                                }
                                Shapes shapes110 = shapes3;
                                if ((i3 & 8192) != 0) {
                                    typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                    i29 &= -7169;
                                } else {
                                    typography2 = typography;
                                }
                                if (i24 == 0) {
                                }
                                if ((i3 & 32768) != 0) {
                                    i31 = i29 & (-458753);
                                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                                } else {
                                    defaultColorSpring = finiteAnimationSpec;
                                    i31 = i29;
                                }
                                shapes4 = shapes110;
                            } else {
                                if ((i3 & 2) != 0) {
                                    i19 &= -113;
                                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                }
                                if (i37 != 0) {
                                    z8 = false;
                                } else {
                                    z8 = z2;
                                }
                                if (i5 != 0) {
                                    color6 = null;
                                }
                                if (i8 != 0) {
                                    color7 = null;
                                }
                                if (i10 != 0) {
                                    color8 = null;
                                }
                                if (i13 != 0) {
                                    color9 = null;
                                }
                                if (i15 == 0) {
                                }
                                if (i17 != 0) {
                                    paletteStyle2 = PaletteStyle.TonalSpot;
                                } else {
                                    paletteStyle2 = paletteStyle;
                                }
                                if ((i3 & 512) != 0) {
                                    i26 = i19 & (-1879048193);
                                    d3 = 0.0d;
                                } else {
                                    d3 = d;
                                    i26 = i19;
                                }
                                z9 = z8;
                                if ((i3 & 1024) != 0) {
                                    ColorSpec$SpecVersion.Companion.getClass();
                                    i27 = i25 & (-15);
                                    colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                                } else {
                                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                    i27 = i25;
                                }
                                i28 = i27;
                                if ((i3 & 2048) != 0) {
                                    DynamicScheme.Platform.Companion.getClass();
                                    i29 = i28 & (-113);
                                    platform3 = DynamicScheme.Platform.Default;
                                } else {
                                    i29 = i28;
                                    platform3 = platform;
                                }
                                i30 = i26;
                                if ((i3 & 4096) != 0) {
                                    shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                    i29 &= -897;
                                } else {
                                    shapes3 = shapes;
                                }
                                Shapes shapes111 = shapes3;
                                if ((i3 & 8192) != 0) {
                                    typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                    i29 &= -7169;
                                } else {
                                    typography2 = typography;
                                }
                                if (i24 == 0) {
                                }
                                if ((i3 & 32768) != 0) {
                                    i31 = i29 & (-458753);
                                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                                } else {
                                    defaultColorSpring = finiteAnimationSpec;
                                    i31 = i29;
                                }
                                shapes4 = shapes111;
                            }
                            gapComposer2.endDefaults();
                            gapComposer = gapComposer2;
                            boolean z117 = z10;
                            FiniteAnimationSpec finiteAnimationSpec11 = defaultColorSpring;
                            DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z117, finiteAnimationSpec11, function2, gapComposer, (i31 >> 3) & 524272, 0);
                            finiteAnimationSpec2 = finiteAnimationSpec11;
                            color11 = color6;
                            color14 = color9;
                            double d12 = d3;
                            shapes2 = shapes4;
                            platform2 = platform3;
                            z7 = z117;
                            z6 = z9;
                            color13 = color8;
                            zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                            color12 = color7;
                            color10 = color15;
                            d2 = d12;
                        } else {
                            gapComposer = gapComposer2;
                            gapComposer.skipToGroupEnd();
                            z6 = z2;
                            color10 = color5;
                            paletteStyle2 = paletteStyle;
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            shapes2 = shapes;
                            typography2 = typography;
                            finiteAnimationSpec2 = finiteAnimationSpec;
                            z7 = z4;
                            color11 = color6;
                            color12 = color7;
                            color13 = color8;
                            color14 = color9;
                            d2 = d;
                            platform2 = platform;
                        }
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            final boolean z118 = zIsSystemInDarkTheme;
                            final PaletteStyle paletteStyle11 = paletteStyle2;
                            final ColorSpec$SpecVersion colorSpec$SpecVersion11 = colorSpec$SpecVersion2;
                            final Typography typography11 = typography2;
                            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    ((Integer) obj2).getClass();
                                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                                    DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z118, z6, color11, color12, color13, color14, color10, paletteStyle11, d2, colorSpec$SpecVersion11, platform2, shapes2, typography11, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                    }
                    i23 |= 24576;
                    z4 = z3;
                    if ((i2 & 196608) == 0) {
                        if ((i3 & 32768) == 0) {
                            if ((i2 & 262144) == 0) {
                                zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                            } else {
                                zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                            }
                            if (zChangedInstance) {
                                i11 = 131072;
                            }
                        }
                        i23 |= i11;
                    }
                    if ((i2 & 1572864) == 0) {
                        i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                    }
                    i25 = i23;
                    if ((i19 & 306783379) == 306783378) {
                        z5 = true;
                    } else {
                        z5 = true;
                    }
                    if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                        gapComposer2.startDefaults();
                        if ((i & 1) != 0) {
                            if ((i3 & 2) != 0) {
                                i19 &= -113;
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            }
                            if (i37 != 0) {
                                z8 = false;
                            } else {
                                z8 = z2;
                            }
                            if (i5 != 0) {
                                color6 = null;
                            }
                            if (i8 != 0) {
                                color7 = null;
                            }
                            if (i10 != 0) {
                                color8 = null;
                            }
                            if (i13 != 0) {
                                color9 = null;
                            }
                            if (i15 == 0) {
                            }
                            if (i17 != 0) {
                                paletteStyle2 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle2 = paletteStyle;
                            }
                            if ((i3 & 512) != 0) {
                                i26 = i19 & (-1879048193);
                                d3 = 0.0d;
                            } else {
                                d3 = d;
                                i26 = i19;
                            }
                            z9 = z8;
                            if ((i3 & 1024) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i27 = i25 & (-15);
                                colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                i27 = i25;
                            }
                            i28 = i27;
                            if ((i3 & 2048) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i29 = i28 & (-113);
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                i29 = i28;
                                platform3 = platform;
                            }
                            i30 = i26;
                            if ((i3 & 4096) != 0) {
                                shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i29 &= -897;
                            } else {
                                shapes3 = shapes;
                            }
                            Shapes shapes112 = shapes3;
                            if ((i3 & 8192) != 0) {
                                typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i29 &= -7169;
                            } else {
                                typography2 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 32768) != 0) {
                                i31 = i29 & (-458753);
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                                i31 = i29;
                            }
                            shapes4 = shapes112;
                        } else {
                            if ((i3 & 2) != 0) {
                                i19 &= -113;
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            }
                            if (i37 != 0) {
                                z8 = false;
                            } else {
                                z8 = z2;
                            }
                            if (i5 != 0) {
                                color6 = null;
                            }
                            if (i8 != 0) {
                                color7 = null;
                            }
                            if (i10 != 0) {
                                color8 = null;
                            }
                            if (i13 != 0) {
                                color9 = null;
                            }
                            if (i15 == 0) {
                            }
                            if (i17 != 0) {
                                paletteStyle2 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle2 = paletteStyle;
                            }
                            if ((i3 & 512) != 0) {
                                i26 = i19 & (-1879048193);
                                d3 = 0.0d;
                            } else {
                                d3 = d;
                                i26 = i19;
                            }
                            z9 = z8;
                            if ((i3 & 1024) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i27 = i25 & (-15);
                                colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                i27 = i25;
                            }
                            i28 = i27;
                            if ((i3 & 2048) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i29 = i28 & (-113);
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                i29 = i28;
                                platform3 = platform;
                            }
                            i30 = i26;
                            if ((i3 & 4096) != 0) {
                                shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i29 &= -897;
                            } else {
                                shapes3 = shapes;
                            }
                            Shapes shapes113 = shapes3;
                            if ((i3 & 8192) != 0) {
                                typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i29 &= -7169;
                            } else {
                                typography2 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 32768) != 0) {
                                i31 = i29 & (-458753);
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                                i31 = i29;
                            }
                            shapes4 = shapes113;
                        }
                        gapComposer2.endDefaults();
                        gapComposer = gapComposer2;
                        boolean z119 = z10;
                        FiniteAnimationSpec finiteAnimationSpec12 = defaultColorSpring;
                        DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z119, finiteAnimationSpec12, function2, gapComposer, (i31 >> 3) & 524272, 0);
                        finiteAnimationSpec2 = finiteAnimationSpec12;
                        color11 = color6;
                        color14 = color9;
                        double d13 = d3;
                        shapes2 = shapes4;
                        platform2 = platform3;
                        z7 = z119;
                        z6 = z9;
                        color13 = color8;
                        zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                        color12 = color7;
                        color10 = color15;
                        d2 = d13;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        z6 = z2;
                        color10 = color5;
                        paletteStyle2 = paletteStyle;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        shapes2 = shapes;
                        typography2 = typography;
                        finiteAnimationSpec2 = finiteAnimationSpec;
                        z7 = z4;
                        color11 = color6;
                        color12 = color7;
                        color13 = color8;
                        color14 = color9;
                        d2 = d;
                        platform2 = platform;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        final boolean z1110 = zIsSystemInDarkTheme;
                        final PaletteStyle paletteStyle12 = paletteStyle2;
                        final ColorSpec$SpecVersion colorSpec$SpecVersion12 = colorSpec$SpecVersion2;
                        final Typography typography12 = typography2;
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                                DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z1110, z6, color11, color12, color13, color14, color10, paletteStyle12, d2, colorSpec$SpecVersion12, platform2, shapes2, typography12, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i4 |= 100663296;
                i17 = i17;
                if ((i & 805306368) == 0) {
                    if ((i3 & 512) == 0) {
                        i34 = i4;
                        if (gapComposer2.changed(d)) {
                            i35 = 536870912;
                        }
                        i19 = i34 | i35;
                    } else {
                        i34 = i4;
                    }
                    i35 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                    i19 = i34 | i35;
                } else {
                    i19 = i4;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) != 0) {
                        i33 = 2;
                    } else {
                        if (colorSpec$SpecVersion == null) {
                            iOrdinal2 = -1;
                        } else {
                            iOrdinal2 = colorSpec$SpecVersion.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal2)) {
                            i33 = 4;
                        } else {
                            i33 = 2;
                        }
                    }
                    i20 = i2 | i33;
                } else {
                    i20 = i2;
                }
                if ((i2 & 48) == 0) {
                    int i314 = i20;
                    if ((i3 & 2048) != 0) {
                        i32 = 16;
                    } else {
                        if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                            i32 = 32;
                        } else {
                            i32 = 16;
                        }
                    }
                    i20 = i314 | i32;
                }
                i21 = i20;
                if ((i2 & 384) == 0) {
                    i22 = i21 | (((i3 & 4096) == 0 || !gapComposer2.changed(shapes)) ? 128 : 256);
                } else {
                    i22 = i21;
                }
                if ((i2 & 3072) != 0) {
                    if ((i3 & 8192) == 0) {
                        i6 = 2048;
                    }
                    i22 |= i6;
                }
                i23 = i22;
                i24 = i3 & 16384;
                if (i24 != 0) {
                    if ((i2 & 24576) == 0) {
                        z4 = z3;
                        i23 |= gapComposer2.changed(z4) ? 16384 : 8192;
                    }
                    if ((i2 & 196608) == 0) {
                        if ((i3 & 32768) == 0) {
                            if ((i2 & 262144) == 0) {
                                zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                            } else {
                                zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                            }
                            if (zChangedInstance) {
                                i11 = 131072;
                            }
                        }
                        i23 |= i11;
                    }
                    if ((i2 & 1572864) == 0) {
                        i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                    }
                    i25 = i23;
                    if ((i19 & 306783379) == 306783378) {
                        z5 = true;
                    } else {
                        z5 = true;
                    }
                    if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                        gapComposer2.startDefaults();
                        if ((i & 1) != 0) {
                            if ((i3 & 2) != 0) {
                                i19 &= -113;
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            }
                            if (i37 != 0) {
                                z8 = false;
                            } else {
                                z8 = z2;
                            }
                            if (i5 != 0) {
                                color6 = null;
                            }
                            if (i8 != 0) {
                                color7 = null;
                            }
                            if (i10 != 0) {
                                color8 = null;
                            }
                            if (i13 != 0) {
                                color9 = null;
                            }
                            if (i15 == 0) {
                            }
                            if (i17 != 0) {
                                paletteStyle2 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle2 = paletteStyle;
                            }
                            if ((i3 & 512) != 0) {
                                i26 = i19 & (-1879048193);
                                d3 = 0.0d;
                            } else {
                                d3 = d;
                                i26 = i19;
                            }
                            z9 = z8;
                            if ((i3 & 1024) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i27 = i25 & (-15);
                                colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                i27 = i25;
                            }
                            i28 = i27;
                            if ((i3 & 2048) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i29 = i28 & (-113);
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                i29 = i28;
                                platform3 = platform;
                            }
                            i30 = i26;
                            if ((i3 & 4096) != 0) {
                                shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i29 &= -897;
                            } else {
                                shapes3 = shapes;
                            }
                            Shapes shapes114 = shapes3;
                            if ((i3 & 8192) != 0) {
                                typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i29 &= -7169;
                            } else {
                                typography2 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 32768) != 0) {
                                i31 = i29 & (-458753);
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                                i31 = i29;
                            }
                            shapes4 = shapes114;
                        } else {
                            if ((i3 & 2) != 0) {
                                i19 &= -113;
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            }
                            if (i37 != 0) {
                                z8 = false;
                            } else {
                                z8 = z2;
                            }
                            if (i5 != 0) {
                                color6 = null;
                            }
                            if (i8 != 0) {
                                color7 = null;
                            }
                            if (i10 != 0) {
                                color8 = null;
                            }
                            if (i13 != 0) {
                                color9 = null;
                            }
                            if (i15 == 0) {
                            }
                            if (i17 != 0) {
                                paletteStyle2 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle2 = paletteStyle;
                            }
                            if ((i3 & 512) != 0) {
                                i26 = i19 & (-1879048193);
                                d3 = 0.0d;
                            } else {
                                d3 = d;
                                i26 = i19;
                            }
                            z9 = z8;
                            if ((i3 & 1024) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i27 = i25 & (-15);
                                colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                i27 = i25;
                            }
                            i28 = i27;
                            if ((i3 & 2048) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i29 = i28 & (-113);
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                i29 = i28;
                                platform3 = platform;
                            }
                            i30 = i26;
                            if ((i3 & 4096) != 0) {
                                shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i29 &= -897;
                            } else {
                                shapes3 = shapes;
                            }
                            Shapes shapes115 = shapes3;
                            if ((i3 & 8192) != 0) {
                                typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i29 &= -7169;
                            } else {
                                typography2 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 32768) != 0) {
                                i31 = i29 & (-458753);
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                                i31 = i29;
                            }
                            shapes4 = shapes115;
                        }
                        gapComposer2.endDefaults();
                        gapComposer = gapComposer2;
                        boolean z1111 = z10;
                        FiniteAnimationSpec finiteAnimationSpec13 = defaultColorSpring;
                        DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z1111, finiteAnimationSpec13, function2, gapComposer, (i31 >> 3) & 524272, 0);
                        finiteAnimationSpec2 = finiteAnimationSpec13;
                        color11 = color6;
                        color14 = color9;
                        double d14 = d3;
                        shapes2 = shapes4;
                        platform2 = platform3;
                        z7 = z1111;
                        z6 = z9;
                        color13 = color8;
                        zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                        color12 = color7;
                        color10 = color15;
                        d2 = d14;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        z6 = z2;
                        color10 = color5;
                        paletteStyle2 = paletteStyle;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        shapes2 = shapes;
                        typography2 = typography;
                        finiteAnimationSpec2 = finiteAnimationSpec;
                        z7 = z4;
                        color11 = color6;
                        color12 = color7;
                        color13 = color8;
                        color14 = color9;
                        d2 = d;
                        platform2 = platform;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        final boolean z1112 = zIsSystemInDarkTheme;
                        final PaletteStyle paletteStyle13 = paletteStyle2;
                        final ColorSpec$SpecVersion colorSpec$SpecVersion13 = colorSpec$SpecVersion2;
                        final Typography typography13 = typography2;
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                                DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z1112, z6, color11, color12, color13, color14, color10, paletteStyle13, d2, colorSpec$SpecVersion13, platform2, shapes2, typography13, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i23 |= 24576;
                z4 = z3;
                if ((i2 & 196608) == 0) {
                    if ((i3 & 32768) == 0) {
                        if ((i2 & 262144) == 0) {
                            zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                        } else {
                            zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                        }
                        if (zChangedInstance) {
                            i11 = 131072;
                        }
                    }
                    i23 |= i11;
                }
                if ((i2 & 1572864) == 0) {
                    i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                }
                i25 = i23;
                if ((i19 & 306783379) == 306783378) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0) {
                        if ((i3 & 2) != 0) {
                            i19 &= -113;
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        }
                        if (i37 != 0) {
                            z8 = false;
                        } else {
                            z8 = z2;
                        }
                        if (i5 != 0) {
                            color6 = null;
                        }
                        if (i8 != 0) {
                            color7 = null;
                        }
                        if (i10 != 0) {
                            color8 = null;
                        }
                        if (i13 != 0) {
                            color9 = null;
                        }
                        if (i15 == 0) {
                        }
                        if (i17 != 0) {
                            paletteStyle2 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle2 = paletteStyle;
                        }
                        if ((i3 & 512) != 0) {
                            i26 = i19 & (-1879048193);
                            d3 = 0.0d;
                        } else {
                            d3 = d;
                            i26 = i19;
                        }
                        z9 = z8;
                        if ((i3 & 1024) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i27 = i25 & (-15);
                            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            i27 = i25;
                        }
                        i28 = i27;
                        if ((i3 & 2048) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i29 = i28 & (-113);
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            i29 = i28;
                            platform3 = platform;
                        }
                        i30 = i26;
                        if ((i3 & 4096) != 0) {
                            shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i29 &= -897;
                        } else {
                            shapes3 = shapes;
                        }
                        Shapes shapes116 = shapes3;
                        if ((i3 & 8192) != 0) {
                            typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i29 &= -7169;
                        } else {
                            typography2 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 32768) != 0) {
                            i31 = i29 & (-458753);
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                            i31 = i29;
                        }
                        shapes4 = shapes116;
                    } else {
                        if ((i3 & 2) != 0) {
                            i19 &= -113;
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        }
                        if (i37 != 0) {
                            z8 = false;
                        } else {
                            z8 = z2;
                        }
                        if (i5 != 0) {
                            color6 = null;
                        }
                        if (i8 != 0) {
                            color7 = null;
                        }
                        if (i10 != 0) {
                            color8 = null;
                        }
                        if (i13 != 0) {
                            color9 = null;
                        }
                        if (i15 == 0) {
                        }
                        if (i17 != 0) {
                            paletteStyle2 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle2 = paletteStyle;
                        }
                        if ((i3 & 512) != 0) {
                            i26 = i19 & (-1879048193);
                            d3 = 0.0d;
                        } else {
                            d3 = d;
                            i26 = i19;
                        }
                        z9 = z8;
                        if ((i3 & 1024) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i27 = i25 & (-15);
                            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            i27 = i25;
                        }
                        i28 = i27;
                        if ((i3 & 2048) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i29 = i28 & (-113);
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            i29 = i28;
                            platform3 = platform;
                        }
                        i30 = i26;
                        if ((i3 & 4096) != 0) {
                            shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i29 &= -897;
                        } else {
                            shapes3 = shapes;
                        }
                        Shapes shapes117 = shapes3;
                        if ((i3 & 8192) != 0) {
                            typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i29 &= -7169;
                        } else {
                            typography2 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 32768) != 0) {
                            i31 = i29 & (-458753);
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                            i31 = i29;
                        }
                        shapes4 = shapes117;
                    }
                    gapComposer2.endDefaults();
                    gapComposer = gapComposer2;
                    boolean z1113 = z10;
                    FiniteAnimationSpec finiteAnimationSpec14 = defaultColorSpring;
                    DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z1113, finiteAnimationSpec14, function2, gapComposer, (i31 >> 3) & 524272, 0);
                    finiteAnimationSpec2 = finiteAnimationSpec14;
                    color11 = color6;
                    color14 = color9;
                    double d15 = d3;
                    shapes2 = shapes4;
                    platform2 = platform3;
                    z7 = z1113;
                    z6 = z9;
                    color13 = color8;
                    zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                    color12 = color7;
                    color10 = color15;
                    d2 = d15;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z6 = z2;
                    color10 = color5;
                    paletteStyle2 = paletteStyle;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    shapes2 = shapes;
                    typography2 = typography;
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    z7 = z4;
                    color11 = color6;
                    color12 = color7;
                    color13 = color8;
                    color14 = color9;
                    d2 = d;
                    platform2 = platform;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final boolean z1114 = zIsSystemInDarkTheme;
                    final PaletteStyle paletteStyle14 = paletteStyle2;
                    final ColorSpec$SpecVersion colorSpec$SpecVersion14 = colorSpec$SpecVersion2;
                    final Typography typography14 = typography2;
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                            DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z1114, z6, color11, color12, color13, color14, color10, paletteStyle14, d2, colorSpec$SpecVersion14, platform2, shapes2, typography14, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i4 |= 24576;
            color7 = color2;
            i10 = i3 & 32;
            i11 = 65536;
            if (i10 != 0) {
                i4 |= 196608;
                color8 = color3;
            } else {
                color8 = color3;
                if ((i & 196608) == 0) {
                    if (gapComposer2.changed(color8)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i4 |= i12;
                }
            }
            i13 = i3 & 64;
            if (i13 != 0) {
                i4 |= 1572864;
                color9 = color4;
            } else {
                color9 = color4;
                if ((i & 1572864) == 0) {
                    if (gapComposer2.changed(color9)) {
                        i14 = 1048576;
                    } else {
                        i14 = 524288;
                    }
                    i4 |= i14;
                }
            }
            i15 = i3 & 128;
            if (i15 != 0) {
                i4 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (gapComposer2.changed(color5)) {
                    i16 = 8388608;
                } else {
                    i16 = 4194304;
                }
                i4 |= i16;
            }
            i17 = i3 & 256;
            if (i17 != 0) {
                if ((i & 100663296) == 0) {
                    if (paletteStyle == null) {
                        iOrdinal = -1;
                    } else {
                        iOrdinal = paletteStyle.ordinal();
                    }
                    if (gapComposer2.changed(iOrdinal)) {
                        i18 = 67108864;
                    } else {
                        i18 = 33554432;
                    }
                    i4 |= i18;
                }
                if ((i & 805306368) == 0) {
                    if ((i3 & 512) == 0) {
                        i34 = i4;
                        if (gapComposer2.changed(d)) {
                            i35 = 536870912;
                        }
                        i19 = i34 | i35;
                    } else {
                        i34 = i4;
                    }
                    i35 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                    i19 = i34 | i35;
                } else {
                    i19 = i4;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) != 0) {
                        i33 = 2;
                    } else {
                        if (colorSpec$SpecVersion == null) {
                            iOrdinal2 = -1;
                        } else {
                            iOrdinal2 = colorSpec$SpecVersion.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal2)) {
                            i33 = 4;
                        } else {
                            i33 = 2;
                        }
                    }
                    i20 = i2 | i33;
                } else {
                    i20 = i2;
                }
                if ((i2 & 48) == 0) {
                    int i315 = i20;
                    if ((i3 & 2048) != 0) {
                        i32 = 16;
                    } else {
                        if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                            i32 = 32;
                        } else {
                            i32 = 16;
                        }
                    }
                    i20 = i315 | i32;
                }
                i21 = i20;
                if ((i2 & 384) == 0) {
                    i22 = i21 | (((i3 & 4096) == 0 || !gapComposer2.changed(shapes)) ? 128 : 256);
                } else {
                    i22 = i21;
                }
                if ((i2 & 3072) != 0) {
                    if ((i3 & 8192) == 0) {
                        i6 = 2048;
                    }
                    i22 |= i6;
                }
                i23 = i22;
                i24 = i3 & 16384;
                if (i24 != 0) {
                    if ((i2 & 24576) == 0) {
                        z4 = z3;
                        i23 |= gapComposer2.changed(z4) ? 16384 : 8192;
                    }
                    if ((i2 & 196608) == 0) {
                        if ((i3 & 32768) == 0) {
                            if ((i2 & 262144) == 0) {
                                zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                            } else {
                                zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                            }
                            if (zChangedInstance) {
                                i11 = 131072;
                            }
                        }
                        i23 |= i11;
                    }
                    if ((i2 & 1572864) == 0) {
                        i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                    }
                    i25 = i23;
                    if ((i19 & 306783379) == 306783378) {
                        z5 = true;
                    } else {
                        z5 = true;
                    }
                    if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                        gapComposer2.startDefaults();
                        if ((i & 1) != 0) {
                            if ((i3 & 2) != 0) {
                                i19 &= -113;
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            }
                            if (i37 != 0) {
                                z8 = false;
                            } else {
                                z8 = z2;
                            }
                            if (i5 != 0) {
                                color6 = null;
                            }
                            if (i8 != 0) {
                                color7 = null;
                            }
                            if (i10 != 0) {
                                color8 = null;
                            }
                            if (i13 != 0) {
                                color9 = null;
                            }
                            if (i15 == 0) {
                            }
                            if (i17 != 0) {
                                paletteStyle2 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle2 = paletteStyle;
                            }
                            if ((i3 & 512) != 0) {
                                i26 = i19 & (-1879048193);
                                d3 = 0.0d;
                            } else {
                                d3 = d;
                                i26 = i19;
                            }
                            z9 = z8;
                            if ((i3 & 1024) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i27 = i25 & (-15);
                                colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                i27 = i25;
                            }
                            i28 = i27;
                            if ((i3 & 2048) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i29 = i28 & (-113);
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                i29 = i28;
                                platform3 = platform;
                            }
                            i30 = i26;
                            if ((i3 & 4096) != 0) {
                                shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i29 &= -897;
                            } else {
                                shapes3 = shapes;
                            }
                            Shapes shapes118 = shapes3;
                            if ((i3 & 8192) != 0) {
                                typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i29 &= -7169;
                            } else {
                                typography2 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 32768) != 0) {
                                i31 = i29 & (-458753);
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                                i31 = i29;
                            }
                            shapes4 = shapes118;
                        } else {
                            if ((i3 & 2) != 0) {
                                i19 &= -113;
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            }
                            if (i37 != 0) {
                                z8 = false;
                            } else {
                                z8 = z2;
                            }
                            if (i5 != 0) {
                                color6 = null;
                            }
                            if (i8 != 0) {
                                color7 = null;
                            }
                            if (i10 != 0) {
                                color8 = null;
                            }
                            if (i13 != 0) {
                                color9 = null;
                            }
                            if (i15 == 0) {
                            }
                            if (i17 != 0) {
                                paletteStyle2 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle2 = paletteStyle;
                            }
                            if ((i3 & 512) != 0) {
                                i26 = i19 & (-1879048193);
                                d3 = 0.0d;
                            } else {
                                d3 = d;
                                i26 = i19;
                            }
                            z9 = z8;
                            if ((i3 & 1024) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i27 = i25 & (-15);
                                colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                i27 = i25;
                            }
                            i28 = i27;
                            if ((i3 & 2048) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i29 = i28 & (-113);
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                i29 = i28;
                                platform3 = platform;
                            }
                            i30 = i26;
                            if ((i3 & 4096) != 0) {
                                shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i29 &= -897;
                            } else {
                                shapes3 = shapes;
                            }
                            Shapes shapes119 = shapes3;
                            if ((i3 & 8192) != 0) {
                                typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i29 &= -7169;
                            } else {
                                typography2 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 32768) != 0) {
                                i31 = i29 & (-458753);
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                                i31 = i29;
                            }
                            shapes4 = shapes119;
                        }
                        gapComposer2.endDefaults();
                        gapComposer = gapComposer2;
                        boolean z1115 = z10;
                        FiniteAnimationSpec finiteAnimationSpec15 = defaultColorSpring;
                        DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z1115, finiteAnimationSpec15, function2, gapComposer, (i31 >> 3) & 524272, 0);
                        finiteAnimationSpec2 = finiteAnimationSpec15;
                        color11 = color6;
                        color14 = color9;
                        double d16 = d3;
                        shapes2 = shapes4;
                        platform2 = platform3;
                        z7 = z1115;
                        z6 = z9;
                        color13 = color8;
                        zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                        color12 = color7;
                        color10 = color15;
                        d2 = d16;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        z6 = z2;
                        color10 = color5;
                        paletteStyle2 = paletteStyle;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        shapes2 = shapes;
                        typography2 = typography;
                        finiteAnimationSpec2 = finiteAnimationSpec;
                        z7 = z4;
                        color11 = color6;
                        color12 = color7;
                        color13 = color8;
                        color14 = color9;
                        d2 = d;
                        platform2 = platform;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        final boolean z1116 = zIsSystemInDarkTheme;
                        final PaletteStyle paletteStyle15 = paletteStyle2;
                        final ColorSpec$SpecVersion colorSpec$SpecVersion15 = colorSpec$SpecVersion2;
                        final Typography typography15 = typography2;
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                                DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z1116, z6, color11, color12, color13, color14, color10, paletteStyle15, d2, colorSpec$SpecVersion15, platform2, shapes2, typography15, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i23 |= 24576;
                z4 = z3;
                if ((i2 & 196608) == 0) {
                    if ((i3 & 32768) == 0) {
                        if ((i2 & 262144) == 0) {
                            zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                        } else {
                            zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                        }
                        if (zChangedInstance) {
                            i11 = 131072;
                        }
                    }
                    i23 |= i11;
                }
                if ((i2 & 1572864) == 0) {
                    i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                }
                i25 = i23;
                if ((i19 & 306783379) == 306783378) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0) {
                        if ((i3 & 2) != 0) {
                            i19 &= -113;
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        }
                        if (i37 != 0) {
                            z8 = false;
                        } else {
                            z8 = z2;
                        }
                        if (i5 != 0) {
                            color6 = null;
                        }
                        if (i8 != 0) {
                            color7 = null;
                        }
                        if (i10 != 0) {
                            color8 = null;
                        }
                        if (i13 != 0) {
                            color9 = null;
                        }
                        if (i15 == 0) {
                        }
                        if (i17 != 0) {
                            paletteStyle2 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle2 = paletteStyle;
                        }
                        if ((i3 & 512) != 0) {
                            i26 = i19 & (-1879048193);
                            d3 = 0.0d;
                        } else {
                            d3 = d;
                            i26 = i19;
                        }
                        z9 = z8;
                        if ((i3 & 1024) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i27 = i25 & (-15);
                            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            i27 = i25;
                        }
                        i28 = i27;
                        if ((i3 & 2048) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i29 = i28 & (-113);
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            i29 = i28;
                            platform3 = platform;
                        }
                        i30 = i26;
                        if ((i3 & 4096) != 0) {
                            shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i29 &= -897;
                        } else {
                            shapes3 = shapes;
                        }
                        Shapes shapes1110 = shapes3;
                        if ((i3 & 8192) != 0) {
                            typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i29 &= -7169;
                        } else {
                            typography2 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 32768) != 0) {
                            i31 = i29 & (-458753);
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                            i31 = i29;
                        }
                        shapes4 = shapes1110;
                    } else {
                        if ((i3 & 2) != 0) {
                            i19 &= -113;
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        }
                        if (i37 != 0) {
                            z8 = false;
                        } else {
                            z8 = z2;
                        }
                        if (i5 != 0) {
                            color6 = null;
                        }
                        if (i8 != 0) {
                            color7 = null;
                        }
                        if (i10 != 0) {
                            color8 = null;
                        }
                        if (i13 != 0) {
                            color9 = null;
                        }
                        if (i15 == 0) {
                        }
                        if (i17 != 0) {
                            paletteStyle2 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle2 = paletteStyle;
                        }
                        if ((i3 & 512) != 0) {
                            i26 = i19 & (-1879048193);
                            d3 = 0.0d;
                        } else {
                            d3 = d;
                            i26 = i19;
                        }
                        z9 = z8;
                        if ((i3 & 1024) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i27 = i25 & (-15);
                            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            i27 = i25;
                        }
                        i28 = i27;
                        if ((i3 & 2048) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i29 = i28 & (-113);
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            i29 = i28;
                            platform3 = platform;
                        }
                        i30 = i26;
                        if ((i3 & 4096) != 0) {
                            shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i29 &= -897;
                        } else {
                            shapes3 = shapes;
                        }
                        Shapes shapes1111 = shapes3;
                        if ((i3 & 8192) != 0) {
                            typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i29 &= -7169;
                        } else {
                            typography2 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 32768) != 0) {
                            i31 = i29 & (-458753);
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                            i31 = i29;
                        }
                        shapes4 = shapes1111;
                    }
                    gapComposer2.endDefaults();
                    gapComposer = gapComposer2;
                    boolean z1117 = z10;
                    FiniteAnimationSpec finiteAnimationSpec16 = defaultColorSpring;
                    DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z1117, finiteAnimationSpec16, function2, gapComposer, (i31 >> 3) & 524272, 0);
                    finiteAnimationSpec2 = finiteAnimationSpec16;
                    color11 = color6;
                    color14 = color9;
                    double d17 = d3;
                    shapes2 = shapes4;
                    platform2 = platform3;
                    z7 = z1117;
                    z6 = z9;
                    color13 = color8;
                    zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                    color12 = color7;
                    color10 = color15;
                    d2 = d17;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z6 = z2;
                    color10 = color5;
                    paletteStyle2 = paletteStyle;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    shapes2 = shapes;
                    typography2 = typography;
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    z7 = z4;
                    color11 = color6;
                    color12 = color7;
                    color13 = color8;
                    color14 = color9;
                    d2 = d;
                    platform2 = platform;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final boolean z1118 = zIsSystemInDarkTheme;
                    final PaletteStyle paletteStyle16 = paletteStyle2;
                    final ColorSpec$SpecVersion colorSpec$SpecVersion16 = colorSpec$SpecVersion2;
                    final Typography typography16 = typography2;
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                            DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z1118, z6, color11, color12, color13, color14, color10, paletteStyle16, d2, colorSpec$SpecVersion16, platform2, shapes2, typography16, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i4 |= 100663296;
            i17 = i17;
            if ((i & 805306368) == 0) {
                if ((i3 & 512) == 0) {
                    i34 = i4;
                    if (gapComposer2.changed(d)) {
                        i35 = 536870912;
                    }
                    i19 = i34 | i35;
                } else {
                    i34 = i4;
                }
                i35 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                i19 = i34 | i35;
            } else {
                i19 = i4;
            }
            if ((i2 & 6) == 0) {
                if ((i3 & 1024) != 0) {
                    i33 = 2;
                } else {
                    if (colorSpec$SpecVersion == null) {
                        iOrdinal2 = -1;
                    } else {
                        iOrdinal2 = colorSpec$SpecVersion.ordinal();
                    }
                    if (gapComposer2.changed(iOrdinal2)) {
                        i33 = 4;
                    } else {
                        i33 = 2;
                    }
                }
                i20 = i2 | i33;
            } else {
                i20 = i2;
            }
            if ((i2 & 48) == 0) {
                int i316 = i20;
                if ((i3 & 2048) != 0) {
                    i32 = 16;
                } else {
                    if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                        i32 = 32;
                    } else {
                        i32 = 16;
                    }
                }
                i20 = i316 | i32;
            }
            i21 = i20;
            if ((i2 & 384) == 0) {
                i22 = i21 | (((i3 & 4096) == 0 || !gapComposer2.changed(shapes)) ? 128 : 256);
            } else {
                i22 = i21;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8192) == 0) {
                    i6 = 2048;
                }
                i22 |= i6;
            }
            i23 = i22;
            i24 = i3 & 16384;
            if (i24 != 0) {
                if ((i2 & 24576) == 0) {
                    z4 = z3;
                    i23 |= gapComposer2.changed(z4) ? 16384 : 8192;
                }
                if ((i2 & 196608) == 0) {
                    if ((i3 & 32768) == 0) {
                        if ((i2 & 262144) == 0) {
                            zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                        } else {
                            zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                        }
                        if (zChangedInstance) {
                            i11 = 131072;
                        }
                    }
                    i23 |= i11;
                }
                if ((i2 & 1572864) == 0) {
                    i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                }
                i25 = i23;
                if ((i19 & 306783379) == 306783378) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0) {
                        if ((i3 & 2) != 0) {
                            i19 &= -113;
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        }
                        if (i37 != 0) {
                            z8 = false;
                        } else {
                            z8 = z2;
                        }
                        if (i5 != 0) {
                            color6 = null;
                        }
                        if (i8 != 0) {
                            color7 = null;
                        }
                        if (i10 != 0) {
                            color8 = null;
                        }
                        if (i13 != 0) {
                            color9 = null;
                        }
                        if (i15 == 0) {
                        }
                        if (i17 != 0) {
                            paletteStyle2 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle2 = paletteStyle;
                        }
                        if ((i3 & 512) != 0) {
                            i26 = i19 & (-1879048193);
                            d3 = 0.0d;
                        } else {
                            d3 = d;
                            i26 = i19;
                        }
                        z9 = z8;
                        if ((i3 & 1024) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i27 = i25 & (-15);
                            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            i27 = i25;
                        }
                        i28 = i27;
                        if ((i3 & 2048) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i29 = i28 & (-113);
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            i29 = i28;
                            platform3 = platform;
                        }
                        i30 = i26;
                        if ((i3 & 4096) != 0) {
                            shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i29 &= -897;
                        } else {
                            shapes3 = shapes;
                        }
                        Shapes shapes1112 = shapes3;
                        if ((i3 & 8192) != 0) {
                            typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i29 &= -7169;
                        } else {
                            typography2 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 32768) != 0) {
                            i31 = i29 & (-458753);
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                            i31 = i29;
                        }
                        shapes4 = shapes1112;
                    } else {
                        if ((i3 & 2) != 0) {
                            i19 &= -113;
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        }
                        if (i37 != 0) {
                            z8 = false;
                        } else {
                            z8 = z2;
                        }
                        if (i5 != 0) {
                            color6 = null;
                        }
                        if (i8 != 0) {
                            color7 = null;
                        }
                        if (i10 != 0) {
                            color8 = null;
                        }
                        if (i13 != 0) {
                            color9 = null;
                        }
                        if (i15 == 0) {
                        }
                        if (i17 != 0) {
                            paletteStyle2 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle2 = paletteStyle;
                        }
                        if ((i3 & 512) != 0) {
                            i26 = i19 & (-1879048193);
                            d3 = 0.0d;
                        } else {
                            d3 = d;
                            i26 = i19;
                        }
                        z9 = z8;
                        if ((i3 & 1024) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i27 = i25 & (-15);
                            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            i27 = i25;
                        }
                        i28 = i27;
                        if ((i3 & 2048) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i29 = i28 & (-113);
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            i29 = i28;
                            platform3 = platform;
                        }
                        i30 = i26;
                        if ((i3 & 4096) != 0) {
                            shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i29 &= -897;
                        } else {
                            shapes3 = shapes;
                        }
                        Shapes shapes1113 = shapes3;
                        if ((i3 & 8192) != 0) {
                            typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i29 &= -7169;
                        } else {
                            typography2 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 32768) != 0) {
                            i31 = i29 & (-458753);
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                            i31 = i29;
                        }
                        shapes4 = shapes1113;
                    }
                    gapComposer2.endDefaults();
                    gapComposer = gapComposer2;
                    boolean z1119 = z10;
                    FiniteAnimationSpec finiteAnimationSpec17 = defaultColorSpring;
                    DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z1119, finiteAnimationSpec17, function2, gapComposer, (i31 >> 3) & 524272, 0);
                    finiteAnimationSpec2 = finiteAnimationSpec17;
                    color11 = color6;
                    color14 = color9;
                    double d18 = d3;
                    shapes2 = shapes4;
                    platform2 = platform3;
                    z7 = z1119;
                    z6 = z9;
                    color13 = color8;
                    zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                    color12 = color7;
                    color10 = color15;
                    d2 = d18;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z6 = z2;
                    color10 = color5;
                    paletteStyle2 = paletteStyle;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    shapes2 = shapes;
                    typography2 = typography;
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    z7 = z4;
                    color11 = color6;
                    color12 = color7;
                    color13 = color8;
                    color14 = color9;
                    d2 = d;
                    platform2 = platform;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final boolean z11110 = zIsSystemInDarkTheme;
                    final PaletteStyle paletteStyle17 = paletteStyle2;
                    final ColorSpec$SpecVersion colorSpec$SpecVersion17 = colorSpec$SpecVersion2;
                    final Typography typography17 = typography2;
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                            DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z11110, z6, color11, color12, color13, color14, color10, paletteStyle17, d2, colorSpec$SpecVersion17, platform2, shapes2, typography17, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i23 |= 24576;
            z4 = z3;
            if ((i2 & 196608) == 0) {
                if ((i3 & 32768) == 0) {
                    if ((i2 & 262144) == 0) {
                        zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                    } else {
                        zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                    }
                    if (zChangedInstance) {
                        i11 = 131072;
                    }
                }
                i23 |= i11;
            }
            if ((i2 & 1572864) == 0) {
                i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
            }
            i25 = i23;
            if ((i19 & 306783379) == 306783378) {
                z5 = true;
            } else {
                z5 = true;
            }
            if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                gapComposer2.startDefaults();
                if ((i & 1) != 0) {
                    if ((i3 & 2) != 0) {
                        i19 &= -113;
                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                    }
                    if (i37 != 0) {
                        z8 = false;
                    } else {
                        z8 = z2;
                    }
                    if (i5 != 0) {
                        color6 = null;
                    }
                    if (i8 != 0) {
                        color7 = null;
                    }
                    if (i10 != 0) {
                        color8 = null;
                    }
                    if (i13 != 0) {
                        color9 = null;
                    }
                    if (i15 == 0) {
                    }
                    if (i17 != 0) {
                        paletteStyle2 = PaletteStyle.TonalSpot;
                    } else {
                        paletteStyle2 = paletteStyle;
                    }
                    if ((i3 & 512) != 0) {
                        i26 = i19 & (-1879048193);
                        d3 = 0.0d;
                    } else {
                        d3 = d;
                        i26 = i19;
                    }
                    z9 = z8;
                    if ((i3 & 1024) != 0) {
                        ColorSpec$SpecVersion.Companion.getClass();
                        i27 = i25 & (-15);
                        colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                    } else {
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        i27 = i25;
                    }
                    i28 = i27;
                    if ((i3 & 2048) != 0) {
                        DynamicScheme.Platform.Companion.getClass();
                        i29 = i28 & (-113);
                        platform3 = DynamicScheme.Platform.Default;
                    } else {
                        i29 = i28;
                        platform3 = platform;
                    }
                    i30 = i26;
                    if ((i3 & 4096) != 0) {
                        shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        i29 &= -897;
                    } else {
                        shapes3 = shapes;
                    }
                    Shapes shapes1114 = shapes3;
                    if ((i3 & 8192) != 0) {
                        typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                        i29 &= -7169;
                    } else {
                        typography2 = typography;
                    }
                    if (i24 == 0) {
                    }
                    if ((i3 & 32768) != 0) {
                        i31 = i29 & (-458753);
                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                    } else {
                        defaultColorSpring = finiteAnimationSpec;
                        i31 = i29;
                    }
                    shapes4 = shapes1114;
                } else {
                    if ((i3 & 2) != 0) {
                        i19 &= -113;
                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                    }
                    if (i37 != 0) {
                        z8 = false;
                    } else {
                        z8 = z2;
                    }
                    if (i5 != 0) {
                        color6 = null;
                    }
                    if (i8 != 0) {
                        color7 = null;
                    }
                    if (i10 != 0) {
                        color8 = null;
                    }
                    if (i13 != 0) {
                        color9 = null;
                    }
                    if (i15 == 0) {
                    }
                    if (i17 != 0) {
                        paletteStyle2 = PaletteStyle.TonalSpot;
                    } else {
                        paletteStyle2 = paletteStyle;
                    }
                    if ((i3 & 512) != 0) {
                        i26 = i19 & (-1879048193);
                        d3 = 0.0d;
                    } else {
                        d3 = d;
                        i26 = i19;
                    }
                    z9 = z8;
                    if ((i3 & 1024) != 0) {
                        ColorSpec$SpecVersion.Companion.getClass();
                        i27 = i25 & (-15);
                        colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                    } else {
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        i27 = i25;
                    }
                    i28 = i27;
                    if ((i3 & 2048) != 0) {
                        DynamicScheme.Platform.Companion.getClass();
                        i29 = i28 & (-113);
                        platform3 = DynamicScheme.Platform.Default;
                    } else {
                        i29 = i28;
                        platform3 = platform;
                    }
                    i30 = i26;
                    if ((i3 & 4096) != 0) {
                        shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        i29 &= -897;
                    } else {
                        shapes3 = shapes;
                    }
                    Shapes shapes1115 = shapes3;
                    if ((i3 & 8192) != 0) {
                        typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                        i29 &= -7169;
                    } else {
                        typography2 = typography;
                    }
                    if (i24 == 0) {
                    }
                    if ((i3 & 32768) != 0) {
                        i31 = i29 & (-458753);
                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                    } else {
                        defaultColorSpring = finiteAnimationSpec;
                        i31 = i29;
                    }
                    shapes4 = shapes1115;
                }
                gapComposer2.endDefaults();
                gapComposer = gapComposer2;
                boolean z11111 = z10;
                FiniteAnimationSpec finiteAnimationSpec18 = defaultColorSpring;
                DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z11111, finiteAnimationSpec18, function2, gapComposer, (i31 >> 3) & 524272, 0);
                finiteAnimationSpec2 = finiteAnimationSpec18;
                color11 = color6;
                color14 = color9;
                double d19 = d3;
                shapes2 = shapes4;
                platform2 = platform3;
                z7 = z11111;
                z6 = z9;
                color13 = color8;
                zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                color12 = color7;
                color10 = color15;
                d2 = d19;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                z6 = z2;
                color10 = color5;
                paletteStyle2 = paletteStyle;
                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                shapes2 = shapes;
                typography2 = typography;
                finiteAnimationSpec2 = finiteAnimationSpec;
                z7 = z4;
                color11 = color6;
                color12 = color7;
                color13 = color8;
                color14 = color9;
                d2 = d;
                platform2 = platform;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                final boolean z11112 = zIsSystemInDarkTheme;
                final PaletteStyle paletteStyle18 = paletteStyle2;
                final ColorSpec$SpecVersion colorSpec$SpecVersion18 = colorSpec$SpecVersion2;
                final Typography typography18 = typography2;
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                        DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z11112, z6, color11, color12, color13, color14, color10, paletteStyle18, d2, colorSpec$SpecVersion18, platform2, shapes2, typography18, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i4 |= 384;
        i5 = i3 & 8;
        i6 = 1024;
        if (i5 != 0) {
            if ((i & 3072) == 0) {
                color6 = color;
                if (gapComposer2.changed(color6)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i4 |= i7;
            }
            i8 = i3 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    color7 = color2;
                    if (gapComposer2.changed(color7)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i4 |= i9;
                }
                i10 = i3 & 32;
                i11 = 65536;
                if (i10 != 0) {
                    i4 |= 196608;
                    color8 = color3;
                } else {
                    color8 = color3;
                    if ((i & 196608) == 0) {
                        if (gapComposer2.changed(color8)) {
                            i12 = 131072;
                        } else {
                            i12 = 65536;
                        }
                        i4 |= i12;
                    }
                }
                i13 = i3 & 64;
                if (i13 != 0) {
                    i4 |= 1572864;
                    color9 = color4;
                } else {
                    color9 = color4;
                    if ((i & 1572864) == 0) {
                        if (gapComposer2.changed(color9)) {
                            i14 = 1048576;
                        } else {
                            i14 = 524288;
                        }
                        i4 |= i14;
                    }
                }
                i15 = i3 & 128;
                if (i15 != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (gapComposer2.changed(color5)) {
                        i16 = 8388608;
                    } else {
                        i16 = 4194304;
                    }
                    i4 |= i16;
                }
                i17 = i3 & 256;
                if (i17 != 0) {
                    if ((i & 100663296) == 0) {
                        if (paletteStyle == null) {
                            iOrdinal = -1;
                        } else {
                            iOrdinal = paletteStyle.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal)) {
                            i18 = 67108864;
                        } else {
                            i18 = 33554432;
                        }
                        i4 |= i18;
                    }
                    if ((i & 805306368) == 0) {
                        if ((i3 & 512) == 0) {
                            i34 = i4;
                            if (gapComposer2.changed(d)) {
                                i35 = 536870912;
                            }
                            i19 = i34 | i35;
                        } else {
                            i34 = i4;
                        }
                        i35 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                        i19 = i34 | i35;
                    } else {
                        i19 = i4;
                    }
                    if ((i2 & 6) == 0) {
                        if ((i3 & 1024) != 0) {
                            i33 = 2;
                        } else {
                            if (colorSpec$SpecVersion == null) {
                                iOrdinal2 = -1;
                            } else {
                                iOrdinal2 = colorSpec$SpecVersion.ordinal();
                            }
                            if (gapComposer2.changed(iOrdinal2)) {
                                i33 = 4;
                            } else {
                                i33 = 2;
                            }
                        }
                        i20 = i2 | i33;
                    } else {
                        i20 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        int i317 = i20;
                        if ((i3 & 2048) != 0) {
                            i32 = 16;
                        } else {
                            if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                                i32 = 32;
                            } else {
                                i32 = 16;
                            }
                        }
                        i20 = i317 | i32;
                    }
                    i21 = i20;
                    if ((i2 & 384) == 0) {
                        i22 = i21 | (((i3 & 4096) == 0 || !gapComposer2.changed(shapes)) ? 128 : 256);
                    } else {
                        i22 = i21;
                    }
                    if ((i2 & 3072) != 0) {
                        if ((i3 & 8192) == 0) {
                            i6 = 2048;
                        }
                        i22 |= i6;
                    }
                    i23 = i22;
                    i24 = i3 & 16384;
                    if (i24 != 0) {
                        if ((i2 & 24576) == 0) {
                            z4 = z3;
                            i23 |= gapComposer2.changed(z4) ? 16384 : 8192;
                        }
                        if ((i2 & 196608) == 0) {
                            if ((i3 & 32768) == 0) {
                                if ((i2 & 262144) == 0) {
                                    zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                                } else {
                                    zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                                }
                                if (zChangedInstance) {
                                    i11 = 131072;
                                }
                            }
                            i23 |= i11;
                        }
                        if ((i2 & 1572864) == 0) {
                            i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                        }
                        i25 = i23;
                        if ((i19 & 306783379) == 306783378) {
                            z5 = true;
                        } else {
                            z5 = true;
                        }
                        if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                            gapComposer2.startDefaults();
                            if ((i & 1) != 0) {
                                if ((i3 & 2) != 0) {
                                    i19 &= -113;
                                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                }
                                if (i37 != 0) {
                                    z8 = false;
                                } else {
                                    z8 = z2;
                                }
                                if (i5 != 0) {
                                    color6 = null;
                                }
                                if (i8 != 0) {
                                    color7 = null;
                                }
                                if (i10 != 0) {
                                    color8 = null;
                                }
                                if (i13 != 0) {
                                    color9 = null;
                                }
                                if (i15 == 0) {
                                }
                                if (i17 != 0) {
                                    paletteStyle2 = PaletteStyle.TonalSpot;
                                } else {
                                    paletteStyle2 = paletteStyle;
                                }
                                if ((i3 & 512) != 0) {
                                    i26 = i19 & (-1879048193);
                                    d3 = 0.0d;
                                } else {
                                    d3 = d;
                                    i26 = i19;
                                }
                                z9 = z8;
                                if ((i3 & 1024) != 0) {
                                    ColorSpec$SpecVersion.Companion.getClass();
                                    i27 = i25 & (-15);
                                    colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                                } else {
                                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                    i27 = i25;
                                }
                                i28 = i27;
                                if ((i3 & 2048) != 0) {
                                    DynamicScheme.Platform.Companion.getClass();
                                    i29 = i28 & (-113);
                                    platform3 = DynamicScheme.Platform.Default;
                                } else {
                                    i29 = i28;
                                    platform3 = platform;
                                }
                                i30 = i26;
                                if ((i3 & 4096) != 0) {
                                    shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                    i29 &= -897;
                                } else {
                                    shapes3 = shapes;
                                }
                                Shapes shapes1116 = shapes3;
                                if ((i3 & 8192) != 0) {
                                    typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                    i29 &= -7169;
                                } else {
                                    typography2 = typography;
                                }
                                if (i24 == 0) {
                                }
                                if ((i3 & 32768) != 0) {
                                    i31 = i29 & (-458753);
                                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                                } else {
                                    defaultColorSpring = finiteAnimationSpec;
                                    i31 = i29;
                                }
                                shapes4 = shapes1116;
                            } else {
                                if ((i3 & 2) != 0) {
                                    i19 &= -113;
                                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                }
                                if (i37 != 0) {
                                    z8 = false;
                                } else {
                                    z8 = z2;
                                }
                                if (i5 != 0) {
                                    color6 = null;
                                }
                                if (i8 != 0) {
                                    color7 = null;
                                }
                                if (i10 != 0) {
                                    color8 = null;
                                }
                                if (i13 != 0) {
                                    color9 = null;
                                }
                                if (i15 == 0) {
                                }
                                if (i17 != 0) {
                                    paletteStyle2 = PaletteStyle.TonalSpot;
                                } else {
                                    paletteStyle2 = paletteStyle;
                                }
                                if ((i3 & 512) != 0) {
                                    i26 = i19 & (-1879048193);
                                    d3 = 0.0d;
                                } else {
                                    d3 = d;
                                    i26 = i19;
                                }
                                z9 = z8;
                                if ((i3 & 1024) != 0) {
                                    ColorSpec$SpecVersion.Companion.getClass();
                                    i27 = i25 & (-15);
                                    colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                                } else {
                                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                    i27 = i25;
                                }
                                i28 = i27;
                                if ((i3 & 2048) != 0) {
                                    DynamicScheme.Platform.Companion.getClass();
                                    i29 = i28 & (-113);
                                    platform3 = DynamicScheme.Platform.Default;
                                } else {
                                    i29 = i28;
                                    platform3 = platform;
                                }
                                i30 = i26;
                                if ((i3 & 4096) != 0) {
                                    shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                    i29 &= -897;
                                } else {
                                    shapes3 = shapes;
                                }
                                Shapes shapes1117 = shapes3;
                                if ((i3 & 8192) != 0) {
                                    typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                    i29 &= -7169;
                                } else {
                                    typography2 = typography;
                                }
                                if (i24 == 0) {
                                }
                                if ((i3 & 32768) != 0) {
                                    i31 = i29 & (-458753);
                                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                                } else {
                                    defaultColorSpring = finiteAnimationSpec;
                                    i31 = i29;
                                }
                                shapes4 = shapes1117;
                            }
                            gapComposer2.endDefaults();
                            gapComposer = gapComposer2;
                            boolean z11113 = z10;
                            FiniteAnimationSpec finiteAnimationSpec19 = defaultColorSpring;
                            DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z11113, finiteAnimationSpec19, function2, gapComposer, (i31 >> 3) & 524272, 0);
                            finiteAnimationSpec2 = finiteAnimationSpec19;
                            color11 = color6;
                            color14 = color9;
                            double d110 = d3;
                            shapes2 = shapes4;
                            platform2 = platform3;
                            z7 = z11113;
                            z6 = z9;
                            color13 = color8;
                            zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                            color12 = color7;
                            color10 = color15;
                            d2 = d110;
                        } else {
                            gapComposer = gapComposer2;
                            gapComposer.skipToGroupEnd();
                            z6 = z2;
                            color10 = color5;
                            paletteStyle2 = paletteStyle;
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            shapes2 = shapes;
                            typography2 = typography;
                            finiteAnimationSpec2 = finiteAnimationSpec;
                            z7 = z4;
                            color11 = color6;
                            color12 = color7;
                            color13 = color8;
                            color14 = color9;
                            d2 = d;
                            platform2 = platform;
                        }
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            final boolean z11114 = zIsSystemInDarkTheme;
                            final PaletteStyle paletteStyle19 = paletteStyle2;
                            final ColorSpec$SpecVersion colorSpec$SpecVersion19 = colorSpec$SpecVersion2;
                            final Typography typography19 = typography2;
                            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    ((Integer) obj2).getClass();
                                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                                    DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z11114, z6, color11, color12, color13, color14, color10, paletteStyle19, d2, colorSpec$SpecVersion19, platform2, shapes2, typography19, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                    }
                    i23 |= 24576;
                    z4 = z3;
                    if ((i2 & 196608) == 0) {
                        if ((i3 & 32768) == 0) {
                            if ((i2 & 262144) == 0) {
                                zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                            } else {
                                zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                            }
                            if (zChangedInstance) {
                                i11 = 131072;
                            }
                        }
                        i23 |= i11;
                    }
                    if ((i2 & 1572864) == 0) {
                        i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                    }
                    i25 = i23;
                    if ((i19 & 306783379) == 306783378) {
                        z5 = true;
                    } else {
                        z5 = true;
                    }
                    if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                        gapComposer2.startDefaults();
                        if ((i & 1) != 0) {
                            if ((i3 & 2) != 0) {
                                i19 &= -113;
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            }
                            if (i37 != 0) {
                                z8 = false;
                            } else {
                                z8 = z2;
                            }
                            if (i5 != 0) {
                                color6 = null;
                            }
                            if (i8 != 0) {
                                color7 = null;
                            }
                            if (i10 != 0) {
                                color8 = null;
                            }
                            if (i13 != 0) {
                                color9 = null;
                            }
                            if (i15 == 0) {
                            }
                            if (i17 != 0) {
                                paletteStyle2 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle2 = paletteStyle;
                            }
                            if ((i3 & 512) != 0) {
                                i26 = i19 & (-1879048193);
                                d3 = 0.0d;
                            } else {
                                d3 = d;
                                i26 = i19;
                            }
                            z9 = z8;
                            if ((i3 & 1024) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i27 = i25 & (-15);
                                colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                i27 = i25;
                            }
                            i28 = i27;
                            if ((i3 & 2048) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i29 = i28 & (-113);
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                i29 = i28;
                                platform3 = platform;
                            }
                            i30 = i26;
                            if ((i3 & 4096) != 0) {
                                shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i29 &= -897;
                            } else {
                                shapes3 = shapes;
                            }
                            Shapes shapes1118 = shapes3;
                            if ((i3 & 8192) != 0) {
                                typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i29 &= -7169;
                            } else {
                                typography2 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 32768) != 0) {
                                i31 = i29 & (-458753);
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                                i31 = i29;
                            }
                            shapes4 = shapes1118;
                        } else {
                            if ((i3 & 2) != 0) {
                                i19 &= -113;
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            }
                            if (i37 != 0) {
                                z8 = false;
                            } else {
                                z8 = z2;
                            }
                            if (i5 != 0) {
                                color6 = null;
                            }
                            if (i8 != 0) {
                                color7 = null;
                            }
                            if (i10 != 0) {
                                color8 = null;
                            }
                            if (i13 != 0) {
                                color9 = null;
                            }
                            if (i15 == 0) {
                            }
                            if (i17 != 0) {
                                paletteStyle2 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle2 = paletteStyle;
                            }
                            if ((i3 & 512) != 0) {
                                i26 = i19 & (-1879048193);
                                d3 = 0.0d;
                            } else {
                                d3 = d;
                                i26 = i19;
                            }
                            z9 = z8;
                            if ((i3 & 1024) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i27 = i25 & (-15);
                                colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                i27 = i25;
                            }
                            i28 = i27;
                            if ((i3 & 2048) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i29 = i28 & (-113);
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                i29 = i28;
                                platform3 = platform;
                            }
                            i30 = i26;
                            if ((i3 & 4096) != 0) {
                                shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i29 &= -897;
                            } else {
                                shapes3 = shapes;
                            }
                            Shapes shapes1119 = shapes3;
                            if ((i3 & 8192) != 0) {
                                typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i29 &= -7169;
                            } else {
                                typography2 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 32768) != 0) {
                                i31 = i29 & (-458753);
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                                i31 = i29;
                            }
                            shapes4 = shapes1119;
                        }
                        gapComposer2.endDefaults();
                        gapComposer = gapComposer2;
                        boolean z11115 = z10;
                        FiniteAnimationSpec finiteAnimationSpec110 = defaultColorSpring;
                        DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z11115, finiteAnimationSpec110, function2, gapComposer, (i31 >> 3) & 524272, 0);
                        finiteAnimationSpec2 = finiteAnimationSpec110;
                        color11 = color6;
                        color14 = color9;
                        double d111 = d3;
                        shapes2 = shapes4;
                        platform2 = platform3;
                        z7 = z11115;
                        z6 = z9;
                        color13 = color8;
                        zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                        color12 = color7;
                        color10 = color15;
                        d2 = d111;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        z6 = z2;
                        color10 = color5;
                        paletteStyle2 = paletteStyle;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        shapes2 = shapes;
                        typography2 = typography;
                        finiteAnimationSpec2 = finiteAnimationSpec;
                        z7 = z4;
                        color11 = color6;
                        color12 = color7;
                        color13 = color8;
                        color14 = color9;
                        d2 = d;
                        platform2 = platform;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        final boolean z11116 = zIsSystemInDarkTheme;
                        final PaletteStyle paletteStyle110 = paletteStyle2;
                        final ColorSpec$SpecVersion colorSpec$SpecVersion110 = colorSpec$SpecVersion2;
                        final Typography typography110 = typography2;
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                                DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z11116, z6, color11, color12, color13, color14, color10, paletteStyle110, d2, colorSpec$SpecVersion110, platform2, shapes2, typography110, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i4 |= 100663296;
                i17 = i17;
                if ((i & 805306368) == 0) {
                    if ((i3 & 512) == 0) {
                        i34 = i4;
                        if (gapComposer2.changed(d)) {
                            i35 = 536870912;
                        }
                        i19 = i34 | i35;
                    } else {
                        i34 = i4;
                    }
                    i35 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                    i19 = i34 | i35;
                } else {
                    i19 = i4;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) != 0) {
                        i33 = 2;
                    } else {
                        if (colorSpec$SpecVersion == null) {
                            iOrdinal2 = -1;
                        } else {
                            iOrdinal2 = colorSpec$SpecVersion.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal2)) {
                            i33 = 4;
                        } else {
                            i33 = 2;
                        }
                    }
                    i20 = i2 | i33;
                } else {
                    i20 = i2;
                }
                if ((i2 & 48) == 0) {
                    int i318 = i20;
                    if ((i3 & 2048) != 0) {
                        i32 = 16;
                    } else {
                        if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                            i32 = 32;
                        } else {
                            i32 = 16;
                        }
                    }
                    i20 = i318 | i32;
                }
                i21 = i20;
                if ((i2 & 384) == 0) {
                    i22 = i21 | (((i3 & 4096) == 0 || !gapComposer2.changed(shapes)) ? 128 : 256);
                } else {
                    i22 = i21;
                }
                if ((i2 & 3072) != 0) {
                    if ((i3 & 8192) == 0) {
                        i6 = 2048;
                    }
                    i22 |= i6;
                }
                i23 = i22;
                i24 = i3 & 16384;
                if (i24 != 0) {
                    if ((i2 & 24576) == 0) {
                        z4 = z3;
                        i23 |= gapComposer2.changed(z4) ? 16384 : 8192;
                    }
                    if ((i2 & 196608) == 0) {
                        if ((i3 & 32768) == 0) {
                            if ((i2 & 262144) == 0) {
                                zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                            } else {
                                zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                            }
                            if (zChangedInstance) {
                                i11 = 131072;
                            }
                        }
                        i23 |= i11;
                    }
                    if ((i2 & 1572864) == 0) {
                        i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                    }
                    i25 = i23;
                    if ((i19 & 306783379) == 306783378) {
                        z5 = true;
                    } else {
                        z5 = true;
                    }
                    if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                        gapComposer2.startDefaults();
                        if ((i & 1) != 0) {
                            if ((i3 & 2) != 0) {
                                i19 &= -113;
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            }
                            if (i37 != 0) {
                                z8 = false;
                            } else {
                                z8 = z2;
                            }
                            if (i5 != 0) {
                                color6 = null;
                            }
                            if (i8 != 0) {
                                color7 = null;
                            }
                            if (i10 != 0) {
                                color8 = null;
                            }
                            if (i13 != 0) {
                                color9 = null;
                            }
                            if (i15 == 0) {
                            }
                            if (i17 != 0) {
                                paletteStyle2 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle2 = paletteStyle;
                            }
                            if ((i3 & 512) != 0) {
                                i26 = i19 & (-1879048193);
                                d3 = 0.0d;
                            } else {
                                d3 = d;
                                i26 = i19;
                            }
                            z9 = z8;
                            if ((i3 & 1024) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i27 = i25 & (-15);
                                colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                i27 = i25;
                            }
                            i28 = i27;
                            if ((i3 & 2048) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i29 = i28 & (-113);
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                i29 = i28;
                                platform3 = platform;
                            }
                            i30 = i26;
                            if ((i3 & 4096) != 0) {
                                shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i29 &= -897;
                            } else {
                                shapes3 = shapes;
                            }
                            Shapes shapes11110 = shapes3;
                            if ((i3 & 8192) != 0) {
                                typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i29 &= -7169;
                            } else {
                                typography2 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 32768) != 0) {
                                i31 = i29 & (-458753);
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                                i31 = i29;
                            }
                            shapes4 = shapes11110;
                        } else {
                            if ((i3 & 2) != 0) {
                                i19 &= -113;
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            }
                            if (i37 != 0) {
                                z8 = false;
                            } else {
                                z8 = z2;
                            }
                            if (i5 != 0) {
                                color6 = null;
                            }
                            if (i8 != 0) {
                                color7 = null;
                            }
                            if (i10 != 0) {
                                color8 = null;
                            }
                            if (i13 != 0) {
                                color9 = null;
                            }
                            if (i15 == 0) {
                            }
                            if (i17 != 0) {
                                paletteStyle2 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle2 = paletteStyle;
                            }
                            if ((i3 & 512) != 0) {
                                i26 = i19 & (-1879048193);
                                d3 = 0.0d;
                            } else {
                                d3 = d;
                                i26 = i19;
                            }
                            z9 = z8;
                            if ((i3 & 1024) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i27 = i25 & (-15);
                                colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                i27 = i25;
                            }
                            i28 = i27;
                            if ((i3 & 2048) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i29 = i28 & (-113);
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                i29 = i28;
                                platform3 = platform;
                            }
                            i30 = i26;
                            if ((i3 & 4096) != 0) {
                                shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i29 &= -897;
                            } else {
                                shapes3 = shapes;
                            }
                            Shapes shapes11111 = shapes3;
                            if ((i3 & 8192) != 0) {
                                typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i29 &= -7169;
                            } else {
                                typography2 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 32768) != 0) {
                                i31 = i29 & (-458753);
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                                i31 = i29;
                            }
                            shapes4 = shapes11111;
                        }
                        gapComposer2.endDefaults();
                        gapComposer = gapComposer2;
                        boolean z11117 = z10;
                        FiniteAnimationSpec finiteAnimationSpec111 = defaultColorSpring;
                        DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z11117, finiteAnimationSpec111, function2, gapComposer, (i31 >> 3) & 524272, 0);
                        finiteAnimationSpec2 = finiteAnimationSpec111;
                        color11 = color6;
                        color14 = color9;
                        double d112 = d3;
                        shapes2 = shapes4;
                        platform2 = platform3;
                        z7 = z11117;
                        z6 = z9;
                        color13 = color8;
                        zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                        color12 = color7;
                        color10 = color15;
                        d2 = d112;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        z6 = z2;
                        color10 = color5;
                        paletteStyle2 = paletteStyle;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        shapes2 = shapes;
                        typography2 = typography;
                        finiteAnimationSpec2 = finiteAnimationSpec;
                        z7 = z4;
                        color11 = color6;
                        color12 = color7;
                        color13 = color8;
                        color14 = color9;
                        d2 = d;
                        platform2 = platform;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        final boolean z11118 = zIsSystemInDarkTheme;
                        final PaletteStyle paletteStyle111 = paletteStyle2;
                        final ColorSpec$SpecVersion colorSpec$SpecVersion111 = colorSpec$SpecVersion2;
                        final Typography typography111 = typography2;
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                                DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z11118, z6, color11, color12, color13, color14, color10, paletteStyle111, d2, colorSpec$SpecVersion111, platform2, shapes2, typography111, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i23 |= 24576;
                z4 = z3;
                if ((i2 & 196608) == 0) {
                    if ((i3 & 32768) == 0) {
                        if ((i2 & 262144) == 0) {
                            zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                        } else {
                            zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                        }
                        if (zChangedInstance) {
                            i11 = 131072;
                        }
                    }
                    i23 |= i11;
                }
                if ((i2 & 1572864) == 0) {
                    i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                }
                i25 = i23;
                if ((i19 & 306783379) == 306783378) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0) {
                        if ((i3 & 2) != 0) {
                            i19 &= -113;
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        }
                        if (i37 != 0) {
                            z8 = false;
                        } else {
                            z8 = z2;
                        }
                        if (i5 != 0) {
                            color6 = null;
                        }
                        if (i8 != 0) {
                            color7 = null;
                        }
                        if (i10 != 0) {
                            color8 = null;
                        }
                        if (i13 != 0) {
                            color9 = null;
                        }
                        if (i15 == 0) {
                        }
                        if (i17 != 0) {
                            paletteStyle2 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle2 = paletteStyle;
                        }
                        if ((i3 & 512) != 0) {
                            i26 = i19 & (-1879048193);
                            d3 = 0.0d;
                        } else {
                            d3 = d;
                            i26 = i19;
                        }
                        z9 = z8;
                        if ((i3 & 1024) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i27 = i25 & (-15);
                            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            i27 = i25;
                        }
                        i28 = i27;
                        if ((i3 & 2048) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i29 = i28 & (-113);
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            i29 = i28;
                            platform3 = platform;
                        }
                        i30 = i26;
                        if ((i3 & 4096) != 0) {
                            shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i29 &= -897;
                        } else {
                            shapes3 = shapes;
                        }
                        Shapes shapes11112 = shapes3;
                        if ((i3 & 8192) != 0) {
                            typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i29 &= -7169;
                        } else {
                            typography2 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 32768) != 0) {
                            i31 = i29 & (-458753);
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                            i31 = i29;
                        }
                        shapes4 = shapes11112;
                    } else {
                        if ((i3 & 2) != 0) {
                            i19 &= -113;
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        }
                        if (i37 != 0) {
                            z8 = false;
                        } else {
                            z8 = z2;
                        }
                        if (i5 != 0) {
                            color6 = null;
                        }
                        if (i8 != 0) {
                            color7 = null;
                        }
                        if (i10 != 0) {
                            color8 = null;
                        }
                        if (i13 != 0) {
                            color9 = null;
                        }
                        if (i15 == 0) {
                        }
                        if (i17 != 0) {
                            paletteStyle2 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle2 = paletteStyle;
                        }
                        if ((i3 & 512) != 0) {
                            i26 = i19 & (-1879048193);
                            d3 = 0.0d;
                        } else {
                            d3 = d;
                            i26 = i19;
                        }
                        z9 = z8;
                        if ((i3 & 1024) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i27 = i25 & (-15);
                            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            i27 = i25;
                        }
                        i28 = i27;
                        if ((i3 & 2048) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i29 = i28 & (-113);
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            i29 = i28;
                            platform3 = platform;
                        }
                        i30 = i26;
                        if ((i3 & 4096) != 0) {
                            shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i29 &= -897;
                        } else {
                            shapes3 = shapes;
                        }
                        Shapes shapes11113 = shapes3;
                        if ((i3 & 8192) != 0) {
                            typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i29 &= -7169;
                        } else {
                            typography2 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 32768) != 0) {
                            i31 = i29 & (-458753);
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                            i31 = i29;
                        }
                        shapes4 = shapes11113;
                    }
                    gapComposer2.endDefaults();
                    gapComposer = gapComposer2;
                    boolean z11119 = z10;
                    FiniteAnimationSpec finiteAnimationSpec112 = defaultColorSpring;
                    DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z11119, finiteAnimationSpec112, function2, gapComposer, (i31 >> 3) & 524272, 0);
                    finiteAnimationSpec2 = finiteAnimationSpec112;
                    color11 = color6;
                    color14 = color9;
                    double d113 = d3;
                    shapes2 = shapes4;
                    platform2 = platform3;
                    z7 = z11119;
                    z6 = z9;
                    color13 = color8;
                    zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                    color12 = color7;
                    color10 = color15;
                    d2 = d113;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z6 = z2;
                    color10 = color5;
                    paletteStyle2 = paletteStyle;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    shapes2 = shapes;
                    typography2 = typography;
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    z7 = z4;
                    color11 = color6;
                    color12 = color7;
                    color13 = color8;
                    color14 = color9;
                    d2 = d;
                    platform2 = platform;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final boolean z111110 = zIsSystemInDarkTheme;
                    final PaletteStyle paletteStyle112 = paletteStyle2;
                    final ColorSpec$SpecVersion colorSpec$SpecVersion112 = colorSpec$SpecVersion2;
                    final Typography typography112 = typography2;
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                            DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z111110, z6, color11, color12, color13, color14, color10, paletteStyle112, d2, colorSpec$SpecVersion112, platform2, shapes2, typography112, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i4 |= 24576;
            color7 = color2;
            i10 = i3 & 32;
            i11 = 65536;
            if (i10 != 0) {
                i4 |= 196608;
                color8 = color3;
            } else {
                color8 = color3;
                if ((i & 196608) == 0) {
                    if (gapComposer2.changed(color8)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i4 |= i12;
                }
            }
            i13 = i3 & 64;
            if (i13 != 0) {
                i4 |= 1572864;
                color9 = color4;
            } else {
                color9 = color4;
                if ((i & 1572864) == 0) {
                    if (gapComposer2.changed(color9)) {
                        i14 = 1048576;
                    } else {
                        i14 = 524288;
                    }
                    i4 |= i14;
                }
            }
            i15 = i3 & 128;
            if (i15 != 0) {
                i4 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (gapComposer2.changed(color5)) {
                    i16 = 8388608;
                } else {
                    i16 = 4194304;
                }
                i4 |= i16;
            }
            i17 = i3 & 256;
            if (i17 != 0) {
                if ((i & 100663296) == 0) {
                    if (paletteStyle == null) {
                        iOrdinal = -1;
                    } else {
                        iOrdinal = paletteStyle.ordinal();
                    }
                    if (gapComposer2.changed(iOrdinal)) {
                        i18 = 67108864;
                    } else {
                        i18 = 33554432;
                    }
                    i4 |= i18;
                }
                if ((i & 805306368) == 0) {
                    if ((i3 & 512) == 0) {
                        i34 = i4;
                        if (gapComposer2.changed(d)) {
                            i35 = 536870912;
                        }
                        i19 = i34 | i35;
                    } else {
                        i34 = i4;
                    }
                    i35 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                    i19 = i34 | i35;
                } else {
                    i19 = i4;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) != 0) {
                        i33 = 2;
                    } else {
                        if (colorSpec$SpecVersion == null) {
                            iOrdinal2 = -1;
                        } else {
                            iOrdinal2 = colorSpec$SpecVersion.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal2)) {
                            i33 = 4;
                        } else {
                            i33 = 2;
                        }
                    }
                    i20 = i2 | i33;
                } else {
                    i20 = i2;
                }
                if ((i2 & 48) == 0) {
                    int i319 = i20;
                    if ((i3 & 2048) != 0) {
                        i32 = 16;
                    } else {
                        if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                            i32 = 32;
                        } else {
                            i32 = 16;
                        }
                    }
                    i20 = i319 | i32;
                }
                i21 = i20;
                if ((i2 & 384) == 0) {
                    i22 = i21 | (((i3 & 4096) == 0 || !gapComposer2.changed(shapes)) ? 128 : 256);
                } else {
                    i22 = i21;
                }
                if ((i2 & 3072) != 0) {
                    if ((i3 & 8192) == 0) {
                        i6 = 2048;
                    }
                    i22 |= i6;
                }
                i23 = i22;
                i24 = i3 & 16384;
                if (i24 != 0) {
                    if ((i2 & 24576) == 0) {
                        z4 = z3;
                        i23 |= gapComposer2.changed(z4) ? 16384 : 8192;
                    }
                    if ((i2 & 196608) == 0) {
                        if ((i3 & 32768) == 0) {
                            if ((i2 & 262144) == 0) {
                                zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                            } else {
                                zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                            }
                            if (zChangedInstance) {
                                i11 = 131072;
                            }
                        }
                        i23 |= i11;
                    }
                    if ((i2 & 1572864) == 0) {
                        i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                    }
                    i25 = i23;
                    if ((i19 & 306783379) == 306783378) {
                        z5 = true;
                    } else {
                        z5 = true;
                    }
                    if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                        gapComposer2.startDefaults();
                        if ((i & 1) != 0) {
                            if ((i3 & 2) != 0) {
                                i19 &= -113;
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            }
                            if (i37 != 0) {
                                z8 = false;
                            } else {
                                z8 = z2;
                            }
                            if (i5 != 0) {
                                color6 = null;
                            }
                            if (i8 != 0) {
                                color7 = null;
                            }
                            if (i10 != 0) {
                                color8 = null;
                            }
                            if (i13 != 0) {
                                color9 = null;
                            }
                            if (i15 == 0) {
                            }
                            if (i17 != 0) {
                                paletteStyle2 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle2 = paletteStyle;
                            }
                            if ((i3 & 512) != 0) {
                                i26 = i19 & (-1879048193);
                                d3 = 0.0d;
                            } else {
                                d3 = d;
                                i26 = i19;
                            }
                            z9 = z8;
                            if ((i3 & 1024) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i27 = i25 & (-15);
                                colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                i27 = i25;
                            }
                            i28 = i27;
                            if ((i3 & 2048) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i29 = i28 & (-113);
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                i29 = i28;
                                platform3 = platform;
                            }
                            i30 = i26;
                            if ((i3 & 4096) != 0) {
                                shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i29 &= -897;
                            } else {
                                shapes3 = shapes;
                            }
                            Shapes shapes11114 = shapes3;
                            if ((i3 & 8192) != 0) {
                                typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i29 &= -7169;
                            } else {
                                typography2 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 32768) != 0) {
                                i31 = i29 & (-458753);
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                                i31 = i29;
                            }
                            shapes4 = shapes11114;
                        } else {
                            if ((i3 & 2) != 0) {
                                i19 &= -113;
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            }
                            if (i37 != 0) {
                                z8 = false;
                            } else {
                                z8 = z2;
                            }
                            if (i5 != 0) {
                                color6 = null;
                            }
                            if (i8 != 0) {
                                color7 = null;
                            }
                            if (i10 != 0) {
                                color8 = null;
                            }
                            if (i13 != 0) {
                                color9 = null;
                            }
                            if (i15 == 0) {
                            }
                            if (i17 != 0) {
                                paletteStyle2 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle2 = paletteStyle;
                            }
                            if ((i3 & 512) != 0) {
                                i26 = i19 & (-1879048193);
                                d3 = 0.0d;
                            } else {
                                d3 = d;
                                i26 = i19;
                            }
                            z9 = z8;
                            if ((i3 & 1024) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i27 = i25 & (-15);
                                colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                i27 = i25;
                            }
                            i28 = i27;
                            if ((i3 & 2048) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i29 = i28 & (-113);
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                i29 = i28;
                                platform3 = platform;
                            }
                            i30 = i26;
                            if ((i3 & 4096) != 0) {
                                shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i29 &= -897;
                            } else {
                                shapes3 = shapes;
                            }
                            Shapes shapes11115 = shapes3;
                            if ((i3 & 8192) != 0) {
                                typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i29 &= -7169;
                            } else {
                                typography2 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 32768) != 0) {
                                i31 = i29 & (-458753);
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                                i31 = i29;
                            }
                            shapes4 = shapes11115;
                        }
                        gapComposer2.endDefaults();
                        gapComposer = gapComposer2;
                        boolean z111111 = z10;
                        FiniteAnimationSpec finiteAnimationSpec113 = defaultColorSpring;
                        DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z111111, finiteAnimationSpec113, function2, gapComposer, (i31 >> 3) & 524272, 0);
                        finiteAnimationSpec2 = finiteAnimationSpec113;
                        color11 = color6;
                        color14 = color9;
                        double d114 = d3;
                        shapes2 = shapes4;
                        platform2 = platform3;
                        z7 = z111111;
                        z6 = z9;
                        color13 = color8;
                        zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                        color12 = color7;
                        color10 = color15;
                        d2 = d114;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        z6 = z2;
                        color10 = color5;
                        paletteStyle2 = paletteStyle;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        shapes2 = shapes;
                        typography2 = typography;
                        finiteAnimationSpec2 = finiteAnimationSpec;
                        z7 = z4;
                        color11 = color6;
                        color12 = color7;
                        color13 = color8;
                        color14 = color9;
                        d2 = d;
                        platform2 = platform;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        final boolean z111112 = zIsSystemInDarkTheme;
                        final PaletteStyle paletteStyle113 = paletteStyle2;
                        final ColorSpec$SpecVersion colorSpec$SpecVersion113 = colorSpec$SpecVersion2;
                        final Typography typography113 = typography2;
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                                DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z111112, z6, color11, color12, color13, color14, color10, paletteStyle113, d2, colorSpec$SpecVersion113, platform2, shapes2, typography113, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i23 |= 24576;
                z4 = z3;
                if ((i2 & 196608) == 0) {
                    if ((i3 & 32768) == 0) {
                        if ((i2 & 262144) == 0) {
                            zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                        } else {
                            zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                        }
                        if (zChangedInstance) {
                            i11 = 131072;
                        }
                    }
                    i23 |= i11;
                }
                if ((i2 & 1572864) == 0) {
                    i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                }
                i25 = i23;
                if ((i19 & 306783379) == 306783378) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0) {
                        if ((i3 & 2) != 0) {
                            i19 &= -113;
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        }
                        if (i37 != 0) {
                            z8 = false;
                        } else {
                            z8 = z2;
                        }
                        if (i5 != 0) {
                            color6 = null;
                        }
                        if (i8 != 0) {
                            color7 = null;
                        }
                        if (i10 != 0) {
                            color8 = null;
                        }
                        if (i13 != 0) {
                            color9 = null;
                        }
                        if (i15 == 0) {
                        }
                        if (i17 != 0) {
                            paletteStyle2 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle2 = paletteStyle;
                        }
                        if ((i3 & 512) != 0) {
                            i26 = i19 & (-1879048193);
                            d3 = 0.0d;
                        } else {
                            d3 = d;
                            i26 = i19;
                        }
                        z9 = z8;
                        if ((i3 & 1024) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i27 = i25 & (-15);
                            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            i27 = i25;
                        }
                        i28 = i27;
                        if ((i3 & 2048) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i29 = i28 & (-113);
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            i29 = i28;
                            platform3 = platform;
                        }
                        i30 = i26;
                        if ((i3 & 4096) != 0) {
                            shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i29 &= -897;
                        } else {
                            shapes3 = shapes;
                        }
                        Shapes shapes11116 = shapes3;
                        if ((i3 & 8192) != 0) {
                            typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i29 &= -7169;
                        } else {
                            typography2 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 32768) != 0) {
                            i31 = i29 & (-458753);
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                            i31 = i29;
                        }
                        shapes4 = shapes11116;
                    } else {
                        if ((i3 & 2) != 0) {
                            i19 &= -113;
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        }
                        if (i37 != 0) {
                            z8 = false;
                        } else {
                            z8 = z2;
                        }
                        if (i5 != 0) {
                            color6 = null;
                        }
                        if (i8 != 0) {
                            color7 = null;
                        }
                        if (i10 != 0) {
                            color8 = null;
                        }
                        if (i13 != 0) {
                            color9 = null;
                        }
                        if (i15 == 0) {
                        }
                        if (i17 != 0) {
                            paletteStyle2 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle2 = paletteStyle;
                        }
                        if ((i3 & 512) != 0) {
                            i26 = i19 & (-1879048193);
                            d3 = 0.0d;
                        } else {
                            d3 = d;
                            i26 = i19;
                        }
                        z9 = z8;
                        if ((i3 & 1024) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i27 = i25 & (-15);
                            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            i27 = i25;
                        }
                        i28 = i27;
                        if ((i3 & 2048) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i29 = i28 & (-113);
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            i29 = i28;
                            platform3 = platform;
                        }
                        i30 = i26;
                        if ((i3 & 4096) != 0) {
                            shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i29 &= -897;
                        } else {
                            shapes3 = shapes;
                        }
                        Shapes shapes11117 = shapes3;
                        if ((i3 & 8192) != 0) {
                            typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i29 &= -7169;
                        } else {
                            typography2 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 32768) != 0) {
                            i31 = i29 & (-458753);
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                            i31 = i29;
                        }
                        shapes4 = shapes11117;
                    }
                    gapComposer2.endDefaults();
                    gapComposer = gapComposer2;
                    boolean z111113 = z10;
                    FiniteAnimationSpec finiteAnimationSpec114 = defaultColorSpring;
                    DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z111113, finiteAnimationSpec114, function2, gapComposer, (i31 >> 3) & 524272, 0);
                    finiteAnimationSpec2 = finiteAnimationSpec114;
                    color11 = color6;
                    color14 = color9;
                    double d115 = d3;
                    shapes2 = shapes4;
                    platform2 = platform3;
                    z7 = z111113;
                    z6 = z9;
                    color13 = color8;
                    zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                    color12 = color7;
                    color10 = color15;
                    d2 = d115;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z6 = z2;
                    color10 = color5;
                    paletteStyle2 = paletteStyle;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    shapes2 = shapes;
                    typography2 = typography;
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    z7 = z4;
                    color11 = color6;
                    color12 = color7;
                    color13 = color8;
                    color14 = color9;
                    d2 = d;
                    platform2 = platform;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final boolean z111114 = zIsSystemInDarkTheme;
                    final PaletteStyle paletteStyle114 = paletteStyle2;
                    final ColorSpec$SpecVersion colorSpec$SpecVersion114 = colorSpec$SpecVersion2;
                    final Typography typography114 = typography2;
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                            DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z111114, z6, color11, color12, color13, color14, color10, paletteStyle114, d2, colorSpec$SpecVersion114, platform2, shapes2, typography114, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i4 |= 100663296;
            i17 = i17;
            if ((i & 805306368) == 0) {
                if ((i3 & 512) == 0) {
                    i34 = i4;
                    if (gapComposer2.changed(d)) {
                        i35 = 536870912;
                    }
                    i19 = i34 | i35;
                } else {
                    i34 = i4;
                }
                i35 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                i19 = i34 | i35;
            } else {
                i19 = i4;
            }
            if ((i2 & 6) == 0) {
                if ((i3 & 1024) != 0) {
                    i33 = 2;
                } else {
                    if (colorSpec$SpecVersion == null) {
                        iOrdinal2 = -1;
                    } else {
                        iOrdinal2 = colorSpec$SpecVersion.ordinal();
                    }
                    if (gapComposer2.changed(iOrdinal2)) {
                        i33 = 4;
                    } else {
                        i33 = 2;
                    }
                }
                i20 = i2 | i33;
            } else {
                i20 = i2;
            }
            if ((i2 & 48) == 0) {
                int i3110 = i20;
                if ((i3 & 2048) != 0) {
                    i32 = 16;
                } else {
                    if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                        i32 = 32;
                    } else {
                        i32 = 16;
                    }
                }
                i20 = i3110 | i32;
            }
            i21 = i20;
            if ((i2 & 384) == 0) {
                i22 = i21 | (((i3 & 4096) == 0 || !gapComposer2.changed(shapes)) ? 128 : 256);
            } else {
                i22 = i21;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8192) == 0) {
                    i6 = 2048;
                }
                i22 |= i6;
            }
            i23 = i22;
            i24 = i3 & 16384;
            if (i24 != 0) {
                if ((i2 & 24576) == 0) {
                    z4 = z3;
                    i23 |= gapComposer2.changed(z4) ? 16384 : 8192;
                }
                if ((i2 & 196608) == 0) {
                    if ((i3 & 32768) == 0) {
                        if ((i2 & 262144) == 0) {
                            zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                        } else {
                            zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                        }
                        if (zChangedInstance) {
                            i11 = 131072;
                        }
                    }
                    i23 |= i11;
                }
                if ((i2 & 1572864) == 0) {
                    i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                }
                i25 = i23;
                if ((i19 & 306783379) == 306783378) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0) {
                        if ((i3 & 2) != 0) {
                            i19 &= -113;
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        }
                        if (i37 != 0) {
                            z8 = false;
                        } else {
                            z8 = z2;
                        }
                        if (i5 != 0) {
                            color6 = null;
                        }
                        if (i8 != 0) {
                            color7 = null;
                        }
                        if (i10 != 0) {
                            color8 = null;
                        }
                        if (i13 != 0) {
                            color9 = null;
                        }
                        if (i15 == 0) {
                        }
                        if (i17 != 0) {
                            paletteStyle2 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle2 = paletteStyle;
                        }
                        if ((i3 & 512) != 0) {
                            i26 = i19 & (-1879048193);
                            d3 = 0.0d;
                        } else {
                            d3 = d;
                            i26 = i19;
                        }
                        z9 = z8;
                        if ((i3 & 1024) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i27 = i25 & (-15);
                            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            i27 = i25;
                        }
                        i28 = i27;
                        if ((i3 & 2048) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i29 = i28 & (-113);
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            i29 = i28;
                            platform3 = platform;
                        }
                        i30 = i26;
                        if ((i3 & 4096) != 0) {
                            shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i29 &= -897;
                        } else {
                            shapes3 = shapes;
                        }
                        Shapes shapes11118 = shapes3;
                        if ((i3 & 8192) != 0) {
                            typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i29 &= -7169;
                        } else {
                            typography2 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 32768) != 0) {
                            i31 = i29 & (-458753);
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                            i31 = i29;
                        }
                        shapes4 = shapes11118;
                    } else {
                        if ((i3 & 2) != 0) {
                            i19 &= -113;
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        }
                        if (i37 != 0) {
                            z8 = false;
                        } else {
                            z8 = z2;
                        }
                        if (i5 != 0) {
                            color6 = null;
                        }
                        if (i8 != 0) {
                            color7 = null;
                        }
                        if (i10 != 0) {
                            color8 = null;
                        }
                        if (i13 != 0) {
                            color9 = null;
                        }
                        if (i15 == 0) {
                        }
                        if (i17 != 0) {
                            paletteStyle2 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle2 = paletteStyle;
                        }
                        if ((i3 & 512) != 0) {
                            i26 = i19 & (-1879048193);
                            d3 = 0.0d;
                        } else {
                            d3 = d;
                            i26 = i19;
                        }
                        z9 = z8;
                        if ((i3 & 1024) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i27 = i25 & (-15);
                            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            i27 = i25;
                        }
                        i28 = i27;
                        if ((i3 & 2048) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i29 = i28 & (-113);
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            i29 = i28;
                            platform3 = platform;
                        }
                        i30 = i26;
                        if ((i3 & 4096) != 0) {
                            shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i29 &= -897;
                        } else {
                            shapes3 = shapes;
                        }
                        Shapes shapes11119 = shapes3;
                        if ((i3 & 8192) != 0) {
                            typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i29 &= -7169;
                        } else {
                            typography2 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 32768) != 0) {
                            i31 = i29 & (-458753);
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                            i31 = i29;
                        }
                        shapes4 = shapes11119;
                    }
                    gapComposer2.endDefaults();
                    gapComposer = gapComposer2;
                    boolean z111115 = z10;
                    FiniteAnimationSpec finiteAnimationSpec115 = defaultColorSpring;
                    DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z111115, finiteAnimationSpec115, function2, gapComposer, (i31 >> 3) & 524272, 0);
                    finiteAnimationSpec2 = finiteAnimationSpec115;
                    color11 = color6;
                    color14 = color9;
                    double d116 = d3;
                    shapes2 = shapes4;
                    platform2 = platform3;
                    z7 = z111115;
                    z6 = z9;
                    color13 = color8;
                    zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                    color12 = color7;
                    color10 = color15;
                    d2 = d116;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z6 = z2;
                    color10 = color5;
                    paletteStyle2 = paletteStyle;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    shapes2 = shapes;
                    typography2 = typography;
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    z7 = z4;
                    color11 = color6;
                    color12 = color7;
                    color13 = color8;
                    color14 = color9;
                    d2 = d;
                    platform2 = platform;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final boolean z111116 = zIsSystemInDarkTheme;
                    final PaletteStyle paletteStyle115 = paletteStyle2;
                    final ColorSpec$SpecVersion colorSpec$SpecVersion115 = colorSpec$SpecVersion2;
                    final Typography typography115 = typography2;
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                            DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z111116, z6, color11, color12, color13, color14, color10, paletteStyle115, d2, colorSpec$SpecVersion115, platform2, shapes2, typography115, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i23 |= 24576;
            z4 = z3;
            if ((i2 & 196608) == 0) {
                if ((i3 & 32768) == 0) {
                    if ((i2 & 262144) == 0) {
                        zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                    } else {
                        zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                    }
                    if (zChangedInstance) {
                        i11 = 131072;
                    }
                }
                i23 |= i11;
            }
            if ((i2 & 1572864) == 0) {
                i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
            }
            i25 = i23;
            if ((i19 & 306783379) == 306783378) {
                z5 = true;
            } else {
                z5 = true;
            }
            if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                gapComposer2.startDefaults();
                if ((i & 1) != 0) {
                    if ((i3 & 2) != 0) {
                        i19 &= -113;
                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                    }
                    if (i37 != 0) {
                        z8 = false;
                    } else {
                        z8 = z2;
                    }
                    if (i5 != 0) {
                        color6 = null;
                    }
                    if (i8 != 0) {
                        color7 = null;
                    }
                    if (i10 != 0) {
                        color8 = null;
                    }
                    if (i13 != 0) {
                        color9 = null;
                    }
                    if (i15 == 0) {
                    }
                    if (i17 != 0) {
                        paletteStyle2 = PaletteStyle.TonalSpot;
                    } else {
                        paletteStyle2 = paletteStyle;
                    }
                    if ((i3 & 512) != 0) {
                        i26 = i19 & (-1879048193);
                        d3 = 0.0d;
                    } else {
                        d3 = d;
                        i26 = i19;
                    }
                    z9 = z8;
                    if ((i3 & 1024) != 0) {
                        ColorSpec$SpecVersion.Companion.getClass();
                        i27 = i25 & (-15);
                        colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                    } else {
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        i27 = i25;
                    }
                    i28 = i27;
                    if ((i3 & 2048) != 0) {
                        DynamicScheme.Platform.Companion.getClass();
                        i29 = i28 & (-113);
                        platform3 = DynamicScheme.Platform.Default;
                    } else {
                        i29 = i28;
                        platform3 = platform;
                    }
                    i30 = i26;
                    if ((i3 & 4096) != 0) {
                        shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        i29 &= -897;
                    } else {
                        shapes3 = shapes;
                    }
                    Shapes shapes111110 = shapes3;
                    if ((i3 & 8192) != 0) {
                        typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                        i29 &= -7169;
                    } else {
                        typography2 = typography;
                    }
                    if (i24 == 0) {
                    }
                    if ((i3 & 32768) != 0) {
                        i31 = i29 & (-458753);
                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                    } else {
                        defaultColorSpring = finiteAnimationSpec;
                        i31 = i29;
                    }
                    shapes4 = shapes111110;
                } else {
                    if ((i3 & 2) != 0) {
                        i19 &= -113;
                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                    }
                    if (i37 != 0) {
                        z8 = false;
                    } else {
                        z8 = z2;
                    }
                    if (i5 != 0) {
                        color6 = null;
                    }
                    if (i8 != 0) {
                        color7 = null;
                    }
                    if (i10 != 0) {
                        color8 = null;
                    }
                    if (i13 != 0) {
                        color9 = null;
                    }
                    if (i15 == 0) {
                    }
                    if (i17 != 0) {
                        paletteStyle2 = PaletteStyle.TonalSpot;
                    } else {
                        paletteStyle2 = paletteStyle;
                    }
                    if ((i3 & 512) != 0) {
                        i26 = i19 & (-1879048193);
                        d3 = 0.0d;
                    } else {
                        d3 = d;
                        i26 = i19;
                    }
                    z9 = z8;
                    if ((i3 & 1024) != 0) {
                        ColorSpec$SpecVersion.Companion.getClass();
                        i27 = i25 & (-15);
                        colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                    } else {
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        i27 = i25;
                    }
                    i28 = i27;
                    if ((i3 & 2048) != 0) {
                        DynamicScheme.Platform.Companion.getClass();
                        i29 = i28 & (-113);
                        platform3 = DynamicScheme.Platform.Default;
                    } else {
                        i29 = i28;
                        platform3 = platform;
                    }
                    i30 = i26;
                    if ((i3 & 4096) != 0) {
                        shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        i29 &= -897;
                    } else {
                        shapes3 = shapes;
                    }
                    Shapes shapes111111 = shapes3;
                    if ((i3 & 8192) != 0) {
                        typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                        i29 &= -7169;
                    } else {
                        typography2 = typography;
                    }
                    if (i24 == 0) {
                    }
                    if ((i3 & 32768) != 0) {
                        i31 = i29 & (-458753);
                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                    } else {
                        defaultColorSpring = finiteAnimationSpec;
                        i31 = i29;
                    }
                    shapes4 = shapes111111;
                }
                gapComposer2.endDefaults();
                gapComposer = gapComposer2;
                boolean z111117 = z10;
                FiniteAnimationSpec finiteAnimationSpec116 = defaultColorSpring;
                DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z111117, finiteAnimationSpec116, function2, gapComposer, (i31 >> 3) & 524272, 0);
                finiteAnimationSpec2 = finiteAnimationSpec116;
                color11 = color6;
                color14 = color9;
                double d117 = d3;
                shapes2 = shapes4;
                platform2 = platform3;
                z7 = z111117;
                z6 = z9;
                color13 = color8;
                zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                color12 = color7;
                color10 = color15;
                d2 = d117;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                z6 = z2;
                color10 = color5;
                paletteStyle2 = paletteStyle;
                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                shapes2 = shapes;
                typography2 = typography;
                finiteAnimationSpec2 = finiteAnimationSpec;
                z7 = z4;
                color11 = color6;
                color12 = color7;
                color13 = color8;
                color14 = color9;
                d2 = d;
                platform2 = platform;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                final boolean z111118 = zIsSystemInDarkTheme;
                final PaletteStyle paletteStyle116 = paletteStyle2;
                final ColorSpec$SpecVersion colorSpec$SpecVersion116 = colorSpec$SpecVersion2;
                final Typography typography116 = typography2;
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                        DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z111118, z6, color11, color12, color13, color14, color10, paletteStyle116, d2, colorSpec$SpecVersion116, platform2, shapes2, typography116, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i4 |= 3072;
        color6 = color;
        i8 = i3 & 16;
        if (i8 != 0) {
            if ((i & 24576) == 0) {
                color7 = color2;
                if (gapComposer2.changed(color7)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i4 |= i9;
            }
            i10 = i3 & 32;
            i11 = 65536;
            if (i10 != 0) {
                i4 |= 196608;
                color8 = color3;
            } else {
                color8 = color3;
                if ((i & 196608) == 0) {
                    if (gapComposer2.changed(color8)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i4 |= i12;
                }
            }
            i13 = i3 & 64;
            if (i13 != 0) {
                i4 |= 1572864;
                color9 = color4;
            } else {
                color9 = color4;
                if ((i & 1572864) == 0) {
                    if (gapComposer2.changed(color9)) {
                        i14 = 1048576;
                    } else {
                        i14 = 524288;
                    }
                    i4 |= i14;
                }
            }
            i15 = i3 & 128;
            if (i15 != 0) {
                i4 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (gapComposer2.changed(color5)) {
                    i16 = 8388608;
                } else {
                    i16 = 4194304;
                }
                i4 |= i16;
            }
            i17 = i3 & 256;
            if (i17 != 0) {
                if ((i & 100663296) == 0) {
                    if (paletteStyle == null) {
                        iOrdinal = -1;
                    } else {
                        iOrdinal = paletteStyle.ordinal();
                    }
                    if (gapComposer2.changed(iOrdinal)) {
                        i18 = 67108864;
                    } else {
                        i18 = 33554432;
                    }
                    i4 |= i18;
                }
                if ((i & 805306368) == 0) {
                    if ((i3 & 512) == 0) {
                        i34 = i4;
                        if (gapComposer2.changed(d)) {
                            i35 = 536870912;
                        }
                        i19 = i34 | i35;
                    } else {
                        i34 = i4;
                    }
                    i35 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                    i19 = i34 | i35;
                } else {
                    i19 = i4;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) != 0) {
                        i33 = 2;
                    } else {
                        if (colorSpec$SpecVersion == null) {
                            iOrdinal2 = -1;
                        } else {
                            iOrdinal2 = colorSpec$SpecVersion.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal2)) {
                            i33 = 4;
                        } else {
                            i33 = 2;
                        }
                    }
                    i20 = i2 | i33;
                } else {
                    i20 = i2;
                }
                if ((i2 & 48) == 0) {
                    int i3111 = i20;
                    if ((i3 & 2048) != 0) {
                        i32 = 16;
                    } else {
                        if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                            i32 = 32;
                        } else {
                            i32 = 16;
                        }
                    }
                    i20 = i3111 | i32;
                }
                i21 = i20;
                if ((i2 & 384) == 0) {
                    i22 = i21 | (((i3 & 4096) == 0 || !gapComposer2.changed(shapes)) ? 128 : 256);
                } else {
                    i22 = i21;
                }
                if ((i2 & 3072) != 0) {
                    if ((i3 & 8192) == 0) {
                        i6 = 2048;
                    }
                    i22 |= i6;
                }
                i23 = i22;
                i24 = i3 & 16384;
                if (i24 != 0) {
                    if ((i2 & 24576) == 0) {
                        z4 = z3;
                        i23 |= gapComposer2.changed(z4) ? 16384 : 8192;
                    }
                    if ((i2 & 196608) == 0) {
                        if ((i3 & 32768) == 0) {
                            if ((i2 & 262144) == 0) {
                                zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                            } else {
                                zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                            }
                            if (zChangedInstance) {
                                i11 = 131072;
                            }
                        }
                        i23 |= i11;
                    }
                    if ((i2 & 1572864) == 0) {
                        i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                    }
                    i25 = i23;
                    if ((i19 & 306783379) == 306783378) {
                        z5 = true;
                    } else {
                        z5 = true;
                    }
                    if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                        gapComposer2.startDefaults();
                        if ((i & 1) != 0) {
                            if ((i3 & 2) != 0) {
                                i19 &= -113;
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            }
                            if (i37 != 0) {
                                z8 = false;
                            } else {
                                z8 = z2;
                            }
                            if (i5 != 0) {
                                color6 = null;
                            }
                            if (i8 != 0) {
                                color7 = null;
                            }
                            if (i10 != 0) {
                                color8 = null;
                            }
                            if (i13 != 0) {
                                color9 = null;
                            }
                            if (i15 == 0) {
                            }
                            if (i17 != 0) {
                                paletteStyle2 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle2 = paletteStyle;
                            }
                            if ((i3 & 512) != 0) {
                                i26 = i19 & (-1879048193);
                                d3 = 0.0d;
                            } else {
                                d3 = d;
                                i26 = i19;
                            }
                            z9 = z8;
                            if ((i3 & 1024) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i27 = i25 & (-15);
                                colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                i27 = i25;
                            }
                            i28 = i27;
                            if ((i3 & 2048) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i29 = i28 & (-113);
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                i29 = i28;
                                platform3 = platform;
                            }
                            i30 = i26;
                            if ((i3 & 4096) != 0) {
                                shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i29 &= -897;
                            } else {
                                shapes3 = shapes;
                            }
                            Shapes shapes111112 = shapes3;
                            if ((i3 & 8192) != 0) {
                                typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i29 &= -7169;
                            } else {
                                typography2 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 32768) != 0) {
                                i31 = i29 & (-458753);
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                                i31 = i29;
                            }
                            shapes4 = shapes111112;
                        } else {
                            if ((i3 & 2) != 0) {
                                i19 &= -113;
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            }
                            if (i37 != 0) {
                                z8 = false;
                            } else {
                                z8 = z2;
                            }
                            if (i5 != 0) {
                                color6 = null;
                            }
                            if (i8 != 0) {
                                color7 = null;
                            }
                            if (i10 != 0) {
                                color8 = null;
                            }
                            if (i13 != 0) {
                                color9 = null;
                            }
                            if (i15 == 0) {
                            }
                            if (i17 != 0) {
                                paletteStyle2 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle2 = paletteStyle;
                            }
                            if ((i3 & 512) != 0) {
                                i26 = i19 & (-1879048193);
                                d3 = 0.0d;
                            } else {
                                d3 = d;
                                i26 = i19;
                            }
                            z9 = z8;
                            if ((i3 & 1024) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i27 = i25 & (-15);
                                colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                                i27 = i25;
                            }
                            i28 = i27;
                            if ((i3 & 2048) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i29 = i28 & (-113);
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                i29 = i28;
                                platform3 = platform;
                            }
                            i30 = i26;
                            if ((i3 & 4096) != 0) {
                                shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i29 &= -897;
                            } else {
                                shapes3 = shapes;
                            }
                            Shapes shapes111113 = shapes3;
                            if ((i3 & 8192) != 0) {
                                typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i29 &= -7169;
                            } else {
                                typography2 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 32768) != 0) {
                                i31 = i29 & (-458753);
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                                i31 = i29;
                            }
                            shapes4 = shapes111113;
                        }
                        gapComposer2.endDefaults();
                        gapComposer = gapComposer2;
                        boolean z111119 = z10;
                        FiniteAnimationSpec finiteAnimationSpec117 = defaultColorSpring;
                        DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z111119, finiteAnimationSpec117, function2, gapComposer, (i31 >> 3) & 524272, 0);
                        finiteAnimationSpec2 = finiteAnimationSpec117;
                        color11 = color6;
                        color14 = color9;
                        double d118 = d3;
                        shapes2 = shapes4;
                        platform2 = platform3;
                        z7 = z111119;
                        z6 = z9;
                        color13 = color8;
                        zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                        color12 = color7;
                        color10 = color15;
                        d2 = d118;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        z6 = z2;
                        color10 = color5;
                        paletteStyle2 = paletteStyle;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        shapes2 = shapes;
                        typography2 = typography;
                        finiteAnimationSpec2 = finiteAnimationSpec;
                        z7 = z4;
                        color11 = color6;
                        color12 = color7;
                        color13 = color8;
                        color14 = color9;
                        d2 = d;
                        platform2 = platform;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        final boolean z1111110 = zIsSystemInDarkTheme;
                        final PaletteStyle paletteStyle117 = paletteStyle2;
                        final ColorSpec$SpecVersion colorSpec$SpecVersion117 = colorSpec$SpecVersion2;
                        final Typography typography117 = typography2;
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                                DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z1111110, z6, color11, color12, color13, color14, color10, paletteStyle117, d2, colorSpec$SpecVersion117, platform2, shapes2, typography117, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i23 |= 24576;
                z4 = z3;
                if ((i2 & 196608) == 0) {
                    if ((i3 & 32768) == 0) {
                        if ((i2 & 262144) == 0) {
                            zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                        } else {
                            zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                        }
                        if (zChangedInstance) {
                            i11 = 131072;
                        }
                    }
                    i23 |= i11;
                }
                if ((i2 & 1572864) == 0) {
                    i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                }
                i25 = i23;
                if ((i19 & 306783379) == 306783378) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0) {
                        if ((i3 & 2) != 0) {
                            i19 &= -113;
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        }
                        if (i37 != 0) {
                            z8 = false;
                        } else {
                            z8 = z2;
                        }
                        if (i5 != 0) {
                            color6 = null;
                        }
                        if (i8 != 0) {
                            color7 = null;
                        }
                        if (i10 != 0) {
                            color8 = null;
                        }
                        if (i13 != 0) {
                            color9 = null;
                        }
                        if (i15 == 0) {
                        }
                        if (i17 != 0) {
                            paletteStyle2 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle2 = paletteStyle;
                        }
                        if ((i3 & 512) != 0) {
                            i26 = i19 & (-1879048193);
                            d3 = 0.0d;
                        } else {
                            d3 = d;
                            i26 = i19;
                        }
                        z9 = z8;
                        if ((i3 & 1024) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i27 = i25 & (-15);
                            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            i27 = i25;
                        }
                        i28 = i27;
                        if ((i3 & 2048) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i29 = i28 & (-113);
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            i29 = i28;
                            platform3 = platform;
                        }
                        i30 = i26;
                        if ((i3 & 4096) != 0) {
                            shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i29 &= -897;
                        } else {
                            shapes3 = shapes;
                        }
                        Shapes shapes111114 = shapes3;
                        if ((i3 & 8192) != 0) {
                            typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i29 &= -7169;
                        } else {
                            typography2 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 32768) != 0) {
                            i31 = i29 & (-458753);
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                            i31 = i29;
                        }
                        shapes4 = shapes111114;
                    } else {
                        if ((i3 & 2) != 0) {
                            i19 &= -113;
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        }
                        if (i37 != 0) {
                            z8 = false;
                        } else {
                            z8 = z2;
                        }
                        if (i5 != 0) {
                            color6 = null;
                        }
                        if (i8 != 0) {
                            color7 = null;
                        }
                        if (i10 != 0) {
                            color8 = null;
                        }
                        if (i13 != 0) {
                            color9 = null;
                        }
                        if (i15 == 0) {
                        }
                        if (i17 != 0) {
                            paletteStyle2 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle2 = paletteStyle;
                        }
                        if ((i3 & 512) != 0) {
                            i26 = i19 & (-1879048193);
                            d3 = 0.0d;
                        } else {
                            d3 = d;
                            i26 = i19;
                        }
                        z9 = z8;
                        if ((i3 & 1024) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i27 = i25 & (-15);
                            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            i27 = i25;
                        }
                        i28 = i27;
                        if ((i3 & 2048) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i29 = i28 & (-113);
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            i29 = i28;
                            platform3 = platform;
                        }
                        i30 = i26;
                        if ((i3 & 4096) != 0) {
                            shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i29 &= -897;
                        } else {
                            shapes3 = shapes;
                        }
                        Shapes shapes111115 = shapes3;
                        if ((i3 & 8192) != 0) {
                            typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i29 &= -7169;
                        } else {
                            typography2 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 32768) != 0) {
                            i31 = i29 & (-458753);
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                            i31 = i29;
                        }
                        shapes4 = shapes111115;
                    }
                    gapComposer2.endDefaults();
                    gapComposer = gapComposer2;
                    boolean z1111111 = z10;
                    FiniteAnimationSpec finiteAnimationSpec118 = defaultColorSpring;
                    DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z1111111, finiteAnimationSpec118, function2, gapComposer, (i31 >> 3) & 524272, 0);
                    finiteAnimationSpec2 = finiteAnimationSpec118;
                    color11 = color6;
                    color14 = color9;
                    double d119 = d3;
                    shapes2 = shapes4;
                    platform2 = platform3;
                    z7 = z1111111;
                    z6 = z9;
                    color13 = color8;
                    zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                    color12 = color7;
                    color10 = color15;
                    d2 = d119;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z6 = z2;
                    color10 = color5;
                    paletteStyle2 = paletteStyle;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    shapes2 = shapes;
                    typography2 = typography;
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    z7 = z4;
                    color11 = color6;
                    color12 = color7;
                    color13 = color8;
                    color14 = color9;
                    d2 = d;
                    platform2 = platform;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final boolean z1111112 = zIsSystemInDarkTheme;
                    final PaletteStyle paletteStyle118 = paletteStyle2;
                    final ColorSpec$SpecVersion colorSpec$SpecVersion118 = colorSpec$SpecVersion2;
                    final Typography typography118 = typography2;
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                            DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z1111112, z6, color11, color12, color13, color14, color10, paletteStyle118, d2, colorSpec$SpecVersion118, platform2, shapes2, typography118, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i4 |= 100663296;
            i17 = i17;
            if ((i & 805306368) == 0) {
                if ((i3 & 512) == 0) {
                    i34 = i4;
                    if (gapComposer2.changed(d)) {
                        i35 = 536870912;
                    }
                    i19 = i34 | i35;
                } else {
                    i34 = i4;
                }
                i35 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                i19 = i34 | i35;
            } else {
                i19 = i4;
            }
            if ((i2 & 6) == 0) {
                if ((i3 & 1024) != 0) {
                    i33 = 2;
                } else {
                    if (colorSpec$SpecVersion == null) {
                        iOrdinal2 = -1;
                    } else {
                        iOrdinal2 = colorSpec$SpecVersion.ordinal();
                    }
                    if (gapComposer2.changed(iOrdinal2)) {
                        i33 = 4;
                    } else {
                        i33 = 2;
                    }
                }
                i20 = i2 | i33;
            } else {
                i20 = i2;
            }
            if ((i2 & 48) == 0) {
                int i3112 = i20;
                if ((i3 & 2048) != 0) {
                    i32 = 16;
                } else {
                    if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                        i32 = 32;
                    } else {
                        i32 = 16;
                    }
                }
                i20 = i3112 | i32;
            }
            i21 = i20;
            if ((i2 & 384) == 0) {
                i22 = i21 | (((i3 & 4096) == 0 || !gapComposer2.changed(shapes)) ? 128 : 256);
            } else {
                i22 = i21;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8192) == 0) {
                    i6 = 2048;
                }
                i22 |= i6;
            }
            i23 = i22;
            i24 = i3 & 16384;
            if (i24 != 0) {
                if ((i2 & 24576) == 0) {
                    z4 = z3;
                    i23 |= gapComposer2.changed(z4) ? 16384 : 8192;
                }
                if ((i2 & 196608) == 0) {
                    if ((i3 & 32768) == 0) {
                        if ((i2 & 262144) == 0) {
                            zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                        } else {
                            zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                        }
                        if (zChangedInstance) {
                            i11 = 131072;
                        }
                    }
                    i23 |= i11;
                }
                if ((i2 & 1572864) == 0) {
                    i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                }
                i25 = i23;
                if ((i19 & 306783379) == 306783378) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0) {
                        if ((i3 & 2) != 0) {
                            i19 &= -113;
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        }
                        if (i37 != 0) {
                            z8 = false;
                        } else {
                            z8 = z2;
                        }
                        if (i5 != 0) {
                            color6 = null;
                        }
                        if (i8 != 0) {
                            color7 = null;
                        }
                        if (i10 != 0) {
                            color8 = null;
                        }
                        if (i13 != 0) {
                            color9 = null;
                        }
                        if (i15 == 0) {
                        }
                        if (i17 != 0) {
                            paletteStyle2 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle2 = paletteStyle;
                        }
                        if ((i3 & 512) != 0) {
                            i26 = i19 & (-1879048193);
                            d3 = 0.0d;
                        } else {
                            d3 = d;
                            i26 = i19;
                        }
                        z9 = z8;
                        if ((i3 & 1024) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i27 = i25 & (-15);
                            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            i27 = i25;
                        }
                        i28 = i27;
                        if ((i3 & 2048) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i29 = i28 & (-113);
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            i29 = i28;
                            platform3 = platform;
                        }
                        i30 = i26;
                        if ((i3 & 4096) != 0) {
                            shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i29 &= -897;
                        } else {
                            shapes3 = shapes;
                        }
                        Shapes shapes111116 = shapes3;
                        if ((i3 & 8192) != 0) {
                            typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i29 &= -7169;
                        } else {
                            typography2 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 32768) != 0) {
                            i31 = i29 & (-458753);
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                            i31 = i29;
                        }
                        shapes4 = shapes111116;
                    } else {
                        if ((i3 & 2) != 0) {
                            i19 &= -113;
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        }
                        if (i37 != 0) {
                            z8 = false;
                        } else {
                            z8 = z2;
                        }
                        if (i5 != 0) {
                            color6 = null;
                        }
                        if (i8 != 0) {
                            color7 = null;
                        }
                        if (i10 != 0) {
                            color8 = null;
                        }
                        if (i13 != 0) {
                            color9 = null;
                        }
                        if (i15 == 0) {
                        }
                        if (i17 != 0) {
                            paletteStyle2 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle2 = paletteStyle;
                        }
                        if ((i3 & 512) != 0) {
                            i26 = i19 & (-1879048193);
                            d3 = 0.0d;
                        } else {
                            d3 = d;
                            i26 = i19;
                        }
                        z9 = z8;
                        if ((i3 & 1024) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i27 = i25 & (-15);
                            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            i27 = i25;
                        }
                        i28 = i27;
                        if ((i3 & 2048) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i29 = i28 & (-113);
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            i29 = i28;
                            platform3 = platform;
                        }
                        i30 = i26;
                        if ((i3 & 4096) != 0) {
                            shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i29 &= -897;
                        } else {
                            shapes3 = shapes;
                        }
                        Shapes shapes111117 = shapes3;
                        if ((i3 & 8192) != 0) {
                            typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i29 &= -7169;
                        } else {
                            typography2 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 32768) != 0) {
                            i31 = i29 & (-458753);
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                            i31 = i29;
                        }
                        shapes4 = shapes111117;
                    }
                    gapComposer2.endDefaults();
                    gapComposer = gapComposer2;
                    boolean z1111113 = z10;
                    FiniteAnimationSpec finiteAnimationSpec119 = defaultColorSpring;
                    DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z1111113, finiteAnimationSpec119, function2, gapComposer, (i31 >> 3) & 524272, 0);
                    finiteAnimationSpec2 = finiteAnimationSpec119;
                    color11 = color6;
                    color14 = color9;
                    double d1110 = d3;
                    shapes2 = shapes4;
                    platform2 = platform3;
                    z7 = z1111113;
                    z6 = z9;
                    color13 = color8;
                    zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                    color12 = color7;
                    color10 = color15;
                    d2 = d1110;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z6 = z2;
                    color10 = color5;
                    paletteStyle2 = paletteStyle;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    shapes2 = shapes;
                    typography2 = typography;
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    z7 = z4;
                    color11 = color6;
                    color12 = color7;
                    color13 = color8;
                    color14 = color9;
                    d2 = d;
                    platform2 = platform;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final boolean z1111114 = zIsSystemInDarkTheme;
                    final PaletteStyle paletteStyle119 = paletteStyle2;
                    final ColorSpec$SpecVersion colorSpec$SpecVersion119 = colorSpec$SpecVersion2;
                    final Typography typography119 = typography2;
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                            DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z1111114, z6, color11, color12, color13, color14, color10, paletteStyle119, d2, colorSpec$SpecVersion119, platform2, shapes2, typography119, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i23 |= 24576;
            z4 = z3;
            if ((i2 & 196608) == 0) {
                if ((i3 & 32768) == 0) {
                    if ((i2 & 262144) == 0) {
                        zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                    } else {
                        zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                    }
                    if (zChangedInstance) {
                        i11 = 131072;
                    }
                }
                i23 |= i11;
            }
            if ((i2 & 1572864) == 0) {
                i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
            }
            i25 = i23;
            if ((i19 & 306783379) == 306783378) {
                z5 = true;
            } else {
                z5 = true;
            }
            if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                gapComposer2.startDefaults();
                if ((i & 1) != 0) {
                    if ((i3 & 2) != 0) {
                        i19 &= -113;
                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                    }
                    if (i37 != 0) {
                        z8 = false;
                    } else {
                        z8 = z2;
                    }
                    if (i5 != 0) {
                        color6 = null;
                    }
                    if (i8 != 0) {
                        color7 = null;
                    }
                    if (i10 != 0) {
                        color8 = null;
                    }
                    if (i13 != 0) {
                        color9 = null;
                    }
                    if (i15 == 0) {
                    }
                    if (i17 != 0) {
                        paletteStyle2 = PaletteStyle.TonalSpot;
                    } else {
                        paletteStyle2 = paletteStyle;
                    }
                    if ((i3 & 512) != 0) {
                        i26 = i19 & (-1879048193);
                        d3 = 0.0d;
                    } else {
                        d3 = d;
                        i26 = i19;
                    }
                    z9 = z8;
                    if ((i3 & 1024) != 0) {
                        ColorSpec$SpecVersion.Companion.getClass();
                        i27 = i25 & (-15);
                        colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                    } else {
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        i27 = i25;
                    }
                    i28 = i27;
                    if ((i3 & 2048) != 0) {
                        DynamicScheme.Platform.Companion.getClass();
                        i29 = i28 & (-113);
                        platform3 = DynamicScheme.Platform.Default;
                    } else {
                        i29 = i28;
                        platform3 = platform;
                    }
                    i30 = i26;
                    if ((i3 & 4096) != 0) {
                        shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        i29 &= -897;
                    } else {
                        shapes3 = shapes;
                    }
                    Shapes shapes111118 = shapes3;
                    if ((i3 & 8192) != 0) {
                        typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                        i29 &= -7169;
                    } else {
                        typography2 = typography;
                    }
                    if (i24 == 0) {
                    }
                    if ((i3 & 32768) != 0) {
                        i31 = i29 & (-458753);
                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                    } else {
                        defaultColorSpring = finiteAnimationSpec;
                        i31 = i29;
                    }
                    shapes4 = shapes111118;
                } else {
                    if ((i3 & 2) != 0) {
                        i19 &= -113;
                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                    }
                    if (i37 != 0) {
                        z8 = false;
                    } else {
                        z8 = z2;
                    }
                    if (i5 != 0) {
                        color6 = null;
                    }
                    if (i8 != 0) {
                        color7 = null;
                    }
                    if (i10 != 0) {
                        color8 = null;
                    }
                    if (i13 != 0) {
                        color9 = null;
                    }
                    if (i15 == 0) {
                    }
                    if (i17 != 0) {
                        paletteStyle2 = PaletteStyle.TonalSpot;
                    } else {
                        paletteStyle2 = paletteStyle;
                    }
                    if ((i3 & 512) != 0) {
                        i26 = i19 & (-1879048193);
                        d3 = 0.0d;
                    } else {
                        d3 = d;
                        i26 = i19;
                    }
                    z9 = z8;
                    if ((i3 & 1024) != 0) {
                        ColorSpec$SpecVersion.Companion.getClass();
                        i27 = i25 & (-15);
                        colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                    } else {
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        i27 = i25;
                    }
                    i28 = i27;
                    if ((i3 & 2048) != 0) {
                        DynamicScheme.Platform.Companion.getClass();
                        i29 = i28 & (-113);
                        platform3 = DynamicScheme.Platform.Default;
                    } else {
                        i29 = i28;
                        platform3 = platform;
                    }
                    i30 = i26;
                    if ((i3 & 4096) != 0) {
                        shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        i29 &= -897;
                    } else {
                        shapes3 = shapes;
                    }
                    Shapes shapes111119 = shapes3;
                    if ((i3 & 8192) != 0) {
                        typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                        i29 &= -7169;
                    } else {
                        typography2 = typography;
                    }
                    if (i24 == 0) {
                    }
                    if ((i3 & 32768) != 0) {
                        i31 = i29 & (-458753);
                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                    } else {
                        defaultColorSpring = finiteAnimationSpec;
                        i31 = i29;
                    }
                    shapes4 = shapes111119;
                }
                gapComposer2.endDefaults();
                gapComposer = gapComposer2;
                boolean z1111115 = z10;
                FiniteAnimationSpec finiteAnimationSpec1110 = defaultColorSpring;
                DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z1111115, finiteAnimationSpec1110, function2, gapComposer, (i31 >> 3) & 524272, 0);
                finiteAnimationSpec2 = finiteAnimationSpec1110;
                color11 = color6;
                color14 = color9;
                double d1111 = d3;
                shapes2 = shapes4;
                platform2 = platform3;
                z7 = z1111115;
                z6 = z9;
                color13 = color8;
                zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                color12 = color7;
                color10 = color15;
                d2 = d1111;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                z6 = z2;
                color10 = color5;
                paletteStyle2 = paletteStyle;
                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                shapes2 = shapes;
                typography2 = typography;
                finiteAnimationSpec2 = finiteAnimationSpec;
                z7 = z4;
                color11 = color6;
                color12 = color7;
                color13 = color8;
                color14 = color9;
                d2 = d;
                platform2 = platform;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                final boolean z1111116 = zIsSystemInDarkTheme;
                final PaletteStyle paletteStyle1110 = paletteStyle2;
                final ColorSpec$SpecVersion colorSpec$SpecVersion1110 = colorSpec$SpecVersion2;
                final Typography typography1110 = typography2;
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                        DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z1111116, z6, color11, color12, color13, color14, color10, paletteStyle1110, d2, colorSpec$SpecVersion1110, platform2, shapes2, typography1110, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i4 |= 24576;
        color7 = color2;
        i10 = i3 & 32;
        i11 = 65536;
        if (i10 != 0) {
            i4 |= 196608;
            color8 = color3;
        } else {
            color8 = color3;
            if ((i & 196608) == 0) {
                if (gapComposer2.changed(color8)) {
                    i12 = 131072;
                } else {
                    i12 = 65536;
                }
                i4 |= i12;
            }
        }
        i13 = i3 & 64;
        if (i13 != 0) {
            i4 |= 1572864;
            color9 = color4;
        } else {
            color9 = color4;
            if ((i & 1572864) == 0) {
                if (gapComposer2.changed(color9)) {
                    i14 = 1048576;
                } else {
                    i14 = 524288;
                }
                i4 |= i14;
            }
        }
        i15 = i3 & 128;
        if (i15 != 0) {
            i4 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (gapComposer2.changed(color5)) {
                i16 = 8388608;
            } else {
                i16 = 4194304;
            }
            i4 |= i16;
        }
        i17 = i3 & 256;
        if (i17 != 0) {
            if ((i & 100663296) == 0) {
                if (paletteStyle == null) {
                    iOrdinal = -1;
                } else {
                    iOrdinal = paletteStyle.ordinal();
                }
                if (gapComposer2.changed(iOrdinal)) {
                    i18 = 67108864;
                } else {
                    i18 = 33554432;
                }
                i4 |= i18;
            }
            if ((i & 805306368) == 0) {
                if ((i3 & 512) == 0) {
                    i34 = i4;
                    if (gapComposer2.changed(d)) {
                        i35 = 536870912;
                    }
                    i19 = i34 | i35;
                } else {
                    i34 = i4;
                }
                i35 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                i19 = i34 | i35;
            } else {
                i19 = i4;
            }
            if ((i2 & 6) == 0) {
                if ((i3 & 1024) != 0) {
                    i33 = 2;
                } else {
                    if (colorSpec$SpecVersion == null) {
                        iOrdinal2 = -1;
                    } else {
                        iOrdinal2 = colorSpec$SpecVersion.ordinal();
                    }
                    if (gapComposer2.changed(iOrdinal2)) {
                        i33 = 4;
                    } else {
                        i33 = 2;
                    }
                }
                i20 = i2 | i33;
            } else {
                i20 = i2;
            }
            if ((i2 & 48) == 0) {
                int i3113 = i20;
                if ((i3 & 2048) != 0) {
                    i32 = 16;
                } else {
                    if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                        i32 = 32;
                    } else {
                        i32 = 16;
                    }
                }
                i20 = i3113 | i32;
            }
            i21 = i20;
            if ((i2 & 384) == 0) {
                i22 = i21 | (((i3 & 4096) == 0 || !gapComposer2.changed(shapes)) ? 128 : 256);
            } else {
                i22 = i21;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8192) == 0) {
                    i6 = 2048;
                }
                i22 |= i6;
            }
            i23 = i22;
            i24 = i3 & 16384;
            if (i24 != 0) {
                if ((i2 & 24576) == 0) {
                    z4 = z3;
                    i23 |= gapComposer2.changed(z4) ? 16384 : 8192;
                }
                if ((i2 & 196608) == 0) {
                    if ((i3 & 32768) == 0) {
                        if ((i2 & 262144) == 0) {
                            zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                        } else {
                            zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                        }
                        if (zChangedInstance) {
                            i11 = 131072;
                        }
                    }
                    i23 |= i11;
                }
                if ((i2 & 1572864) == 0) {
                    i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
                }
                i25 = i23;
                if ((i19 & 306783379) == 306783378) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0) {
                        if ((i3 & 2) != 0) {
                            i19 &= -113;
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        }
                        if (i37 != 0) {
                            z8 = false;
                        } else {
                            z8 = z2;
                        }
                        if (i5 != 0) {
                            color6 = null;
                        }
                        if (i8 != 0) {
                            color7 = null;
                        }
                        if (i10 != 0) {
                            color8 = null;
                        }
                        if (i13 != 0) {
                            color9 = null;
                        }
                        if (i15 == 0) {
                        }
                        if (i17 != 0) {
                            paletteStyle2 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle2 = paletteStyle;
                        }
                        if ((i3 & 512) != 0) {
                            i26 = i19 & (-1879048193);
                            d3 = 0.0d;
                        } else {
                            d3 = d;
                            i26 = i19;
                        }
                        z9 = z8;
                        if ((i3 & 1024) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i27 = i25 & (-15);
                            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            i27 = i25;
                        }
                        i28 = i27;
                        if ((i3 & 2048) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i29 = i28 & (-113);
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            i29 = i28;
                            platform3 = platform;
                        }
                        i30 = i26;
                        if ((i3 & 4096) != 0) {
                            shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i29 &= -897;
                        } else {
                            shapes3 = shapes;
                        }
                        Shapes shapes1111110 = shapes3;
                        if ((i3 & 8192) != 0) {
                            typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i29 &= -7169;
                        } else {
                            typography2 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 32768) != 0) {
                            i31 = i29 & (-458753);
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                            i31 = i29;
                        }
                        shapes4 = shapes1111110;
                    } else {
                        if ((i3 & 2) != 0) {
                            i19 &= -113;
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        }
                        if (i37 != 0) {
                            z8 = false;
                        } else {
                            z8 = z2;
                        }
                        if (i5 != 0) {
                            color6 = null;
                        }
                        if (i8 != 0) {
                            color7 = null;
                        }
                        if (i10 != 0) {
                            color8 = null;
                        }
                        if (i13 != 0) {
                            color9 = null;
                        }
                        if (i15 == 0) {
                        }
                        if (i17 != 0) {
                            paletteStyle2 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle2 = paletteStyle;
                        }
                        if ((i3 & 512) != 0) {
                            i26 = i19 & (-1879048193);
                            d3 = 0.0d;
                        } else {
                            d3 = d;
                            i26 = i19;
                        }
                        z9 = z8;
                        if ((i3 & 1024) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i27 = i25 & (-15);
                            colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            i27 = i25;
                        }
                        i28 = i27;
                        if ((i3 & 2048) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i29 = i28 & (-113);
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            i29 = i28;
                            platform3 = platform;
                        }
                        i30 = i26;
                        if ((i3 & 4096) != 0) {
                            shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i29 &= -897;
                        } else {
                            shapes3 = shapes;
                        }
                        Shapes shapes1111111 = shapes3;
                        if ((i3 & 8192) != 0) {
                            typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i29 &= -7169;
                        } else {
                            typography2 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 32768) != 0) {
                            i31 = i29 & (-458753);
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                            i31 = i29;
                        }
                        shapes4 = shapes1111111;
                    }
                    gapComposer2.endDefaults();
                    gapComposer = gapComposer2;
                    boolean z1111117 = z10;
                    FiniteAnimationSpec finiteAnimationSpec1111 = defaultColorSpring;
                    DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z1111117, finiteAnimationSpec1111, function2, gapComposer, (i31 >> 3) & 524272, 0);
                    finiteAnimationSpec2 = finiteAnimationSpec1111;
                    color11 = color6;
                    color14 = color9;
                    double d1112 = d3;
                    shapes2 = shapes4;
                    platform2 = platform3;
                    z7 = z1111117;
                    z6 = z9;
                    color13 = color8;
                    zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                    color12 = color7;
                    color10 = color15;
                    d2 = d1112;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z6 = z2;
                    color10 = color5;
                    paletteStyle2 = paletteStyle;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    shapes2 = shapes;
                    typography2 = typography;
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    z7 = z4;
                    color11 = color6;
                    color12 = color7;
                    color13 = color8;
                    color14 = color9;
                    d2 = d;
                    platform2 = platform;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final boolean z1111118 = zIsSystemInDarkTheme;
                    final PaletteStyle paletteStyle1111 = paletteStyle2;
                    final ColorSpec$SpecVersion colorSpec$SpecVersion1111 = colorSpec$SpecVersion2;
                    final Typography typography1111 = typography2;
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                            DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z1111118, z6, color11, color12, color13, color14, color10, paletteStyle1111, d2, colorSpec$SpecVersion1111, platform2, shapes2, typography1111, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i23 |= 24576;
            z4 = z3;
            if ((i2 & 196608) == 0) {
                if ((i3 & 32768) == 0) {
                    if ((i2 & 262144) == 0) {
                        zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                    } else {
                        zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                    }
                    if (zChangedInstance) {
                        i11 = 131072;
                    }
                }
                i23 |= i11;
            }
            if ((i2 & 1572864) == 0) {
                i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
            }
            i25 = i23;
            if ((i19 & 306783379) == 306783378) {
                z5 = true;
            } else {
                z5 = true;
            }
            if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                gapComposer2.startDefaults();
                if ((i & 1) != 0) {
                    if ((i3 & 2) != 0) {
                        i19 &= -113;
                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                    }
                    if (i37 != 0) {
                        z8 = false;
                    } else {
                        z8 = z2;
                    }
                    if (i5 != 0) {
                        color6 = null;
                    }
                    if (i8 != 0) {
                        color7 = null;
                    }
                    if (i10 != 0) {
                        color8 = null;
                    }
                    if (i13 != 0) {
                        color9 = null;
                    }
                    if (i15 == 0) {
                    }
                    if (i17 != 0) {
                        paletteStyle2 = PaletteStyle.TonalSpot;
                    } else {
                        paletteStyle2 = paletteStyle;
                    }
                    if ((i3 & 512) != 0) {
                        i26 = i19 & (-1879048193);
                        d3 = 0.0d;
                    } else {
                        d3 = d;
                        i26 = i19;
                    }
                    z9 = z8;
                    if ((i3 & 1024) != 0) {
                        ColorSpec$SpecVersion.Companion.getClass();
                        i27 = i25 & (-15);
                        colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                    } else {
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        i27 = i25;
                    }
                    i28 = i27;
                    if ((i3 & 2048) != 0) {
                        DynamicScheme.Platform.Companion.getClass();
                        i29 = i28 & (-113);
                        platform3 = DynamicScheme.Platform.Default;
                    } else {
                        i29 = i28;
                        platform3 = platform;
                    }
                    i30 = i26;
                    if ((i3 & 4096) != 0) {
                        shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        i29 &= -897;
                    } else {
                        shapes3 = shapes;
                    }
                    Shapes shapes1111112 = shapes3;
                    if ((i3 & 8192) != 0) {
                        typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                        i29 &= -7169;
                    } else {
                        typography2 = typography;
                    }
                    if (i24 == 0) {
                    }
                    if ((i3 & 32768) != 0) {
                        i31 = i29 & (-458753);
                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                    } else {
                        defaultColorSpring = finiteAnimationSpec;
                        i31 = i29;
                    }
                    shapes4 = shapes1111112;
                } else {
                    if ((i3 & 2) != 0) {
                        i19 &= -113;
                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                    }
                    if (i37 != 0) {
                        z8 = false;
                    } else {
                        z8 = z2;
                    }
                    if (i5 != 0) {
                        color6 = null;
                    }
                    if (i8 != 0) {
                        color7 = null;
                    }
                    if (i10 != 0) {
                        color8 = null;
                    }
                    if (i13 != 0) {
                        color9 = null;
                    }
                    if (i15 == 0) {
                    }
                    if (i17 != 0) {
                        paletteStyle2 = PaletteStyle.TonalSpot;
                    } else {
                        paletteStyle2 = paletteStyle;
                    }
                    if ((i3 & 512) != 0) {
                        i26 = i19 & (-1879048193);
                        d3 = 0.0d;
                    } else {
                        d3 = d;
                        i26 = i19;
                    }
                    z9 = z8;
                    if ((i3 & 1024) != 0) {
                        ColorSpec$SpecVersion.Companion.getClass();
                        i27 = i25 & (-15);
                        colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                    } else {
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        i27 = i25;
                    }
                    i28 = i27;
                    if ((i3 & 2048) != 0) {
                        DynamicScheme.Platform.Companion.getClass();
                        i29 = i28 & (-113);
                        platform3 = DynamicScheme.Platform.Default;
                    } else {
                        i29 = i28;
                        platform3 = platform;
                    }
                    i30 = i26;
                    if ((i3 & 4096) != 0) {
                        shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        i29 &= -897;
                    } else {
                        shapes3 = shapes;
                    }
                    Shapes shapes1111113 = shapes3;
                    if ((i3 & 8192) != 0) {
                        typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                        i29 &= -7169;
                    } else {
                        typography2 = typography;
                    }
                    if (i24 == 0) {
                    }
                    if ((i3 & 32768) != 0) {
                        i31 = i29 & (-458753);
                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                    } else {
                        defaultColorSpring = finiteAnimationSpec;
                        i31 = i29;
                    }
                    shapes4 = shapes1111113;
                }
                gapComposer2.endDefaults();
                gapComposer = gapComposer2;
                boolean z1111119 = z10;
                FiniteAnimationSpec finiteAnimationSpec1112 = defaultColorSpring;
                DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z1111119, finiteAnimationSpec1112, function2, gapComposer, (i31 >> 3) & 524272, 0);
                finiteAnimationSpec2 = finiteAnimationSpec1112;
                color11 = color6;
                color14 = color9;
                double d1113 = d3;
                shapes2 = shapes4;
                platform2 = platform3;
                z7 = z1111119;
                z6 = z9;
                color13 = color8;
                zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                color12 = color7;
                color10 = color15;
                d2 = d1113;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                z6 = z2;
                color10 = color5;
                paletteStyle2 = paletteStyle;
                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                shapes2 = shapes;
                typography2 = typography;
                finiteAnimationSpec2 = finiteAnimationSpec;
                z7 = z4;
                color11 = color6;
                color12 = color7;
                color13 = color8;
                color14 = color9;
                d2 = d;
                platform2 = platform;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                final boolean z11111110 = zIsSystemInDarkTheme;
                final PaletteStyle paletteStyle1112 = paletteStyle2;
                final ColorSpec$SpecVersion colorSpec$SpecVersion1112 = colorSpec$SpecVersion2;
                final Typography typography1112 = typography2;
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                        DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z11111110, z6, color11, color12, color13, color14, color10, paletteStyle1112, d2, colorSpec$SpecVersion1112, platform2, shapes2, typography1112, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i4 |= 100663296;
        i17 = i17;
        if ((i & 805306368) == 0) {
            if ((i3 & 512) == 0) {
                i34 = i4;
                if (gapComposer2.changed(d)) {
                    i35 = 536870912;
                }
                i19 = i34 | i35;
            } else {
                i34 = i4;
            }
            i35 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
            i19 = i34 | i35;
        } else {
            i19 = i4;
        }
        if ((i2 & 6) == 0) {
            if ((i3 & 1024) != 0) {
                i33 = 2;
            } else {
                if (colorSpec$SpecVersion == null) {
                    iOrdinal2 = -1;
                } else {
                    iOrdinal2 = colorSpec$SpecVersion.ordinal();
                }
                if (gapComposer2.changed(iOrdinal2)) {
                    i33 = 4;
                } else {
                    i33 = 2;
                }
            }
            i20 = i2 | i33;
        } else {
            i20 = i2;
        }
        if ((i2 & 48) == 0) {
            int i3114 = i20;
            if ((i3 & 2048) != 0) {
                i32 = 16;
            } else {
                if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                    i32 = 32;
                } else {
                    i32 = 16;
                }
            }
            i20 = i3114 | i32;
        }
        i21 = i20;
        if ((i2 & 384) == 0) {
            i22 = i21 | (((i3 & 4096) == 0 || !gapComposer2.changed(shapes)) ? 128 : 256);
        } else {
            i22 = i21;
        }
        if ((i2 & 3072) != 0) {
            if ((i3 & 8192) == 0) {
                i6 = 2048;
            }
            i22 |= i6;
        }
        i23 = i22;
        i24 = i3 & 16384;
        if (i24 != 0) {
            if ((i2 & 24576) == 0) {
                z4 = z3;
                i23 |= gapComposer2.changed(z4) ? 16384 : 8192;
            }
            if ((i2 & 196608) == 0) {
                if ((i3 & 32768) == 0) {
                    if ((i2 & 262144) == 0) {
                        zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                    } else {
                        zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                    }
                    if (zChangedInstance) {
                        i11 = 131072;
                    }
                }
                i23 |= i11;
            }
            if ((i2 & 1572864) == 0) {
                i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
            }
            i25 = i23;
            if ((i19 & 306783379) == 306783378) {
                z5 = true;
            } else {
                z5 = true;
            }
            if (gapComposer2.shouldExecute(i19 & 1, z5)) {
                gapComposer2.startDefaults();
                if ((i & 1) != 0) {
                    if ((i3 & 2) != 0) {
                        i19 &= -113;
                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                    }
                    if (i37 != 0) {
                        z8 = false;
                    } else {
                        z8 = z2;
                    }
                    if (i5 != 0) {
                        color6 = null;
                    }
                    if (i8 != 0) {
                        color7 = null;
                    }
                    if (i10 != 0) {
                        color8 = null;
                    }
                    if (i13 != 0) {
                        color9 = null;
                    }
                    if (i15 == 0) {
                    }
                    if (i17 != 0) {
                        paletteStyle2 = PaletteStyle.TonalSpot;
                    } else {
                        paletteStyle2 = paletteStyle;
                    }
                    if ((i3 & 512) != 0) {
                        i26 = i19 & (-1879048193);
                        d3 = 0.0d;
                    } else {
                        d3 = d;
                        i26 = i19;
                    }
                    z9 = z8;
                    if ((i3 & 1024) != 0) {
                        ColorSpec$SpecVersion.Companion.getClass();
                        i27 = i25 & (-15);
                        colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                    } else {
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        i27 = i25;
                    }
                    i28 = i27;
                    if ((i3 & 2048) != 0) {
                        DynamicScheme.Platform.Companion.getClass();
                        i29 = i28 & (-113);
                        platform3 = DynamicScheme.Platform.Default;
                    } else {
                        i29 = i28;
                        platform3 = platform;
                    }
                    i30 = i26;
                    if ((i3 & 4096) != 0) {
                        shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        i29 &= -897;
                    } else {
                        shapes3 = shapes;
                    }
                    Shapes shapes1111114 = shapes3;
                    if ((i3 & 8192) != 0) {
                        typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                        i29 &= -7169;
                    } else {
                        typography2 = typography;
                    }
                    if (i24 == 0) {
                    }
                    if ((i3 & 32768) != 0) {
                        i31 = i29 & (-458753);
                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                    } else {
                        defaultColorSpring = finiteAnimationSpec;
                        i31 = i29;
                    }
                    shapes4 = shapes1111114;
                } else {
                    if ((i3 & 2) != 0) {
                        i19 &= -113;
                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                    }
                    if (i37 != 0) {
                        z8 = false;
                    } else {
                        z8 = z2;
                    }
                    if (i5 != 0) {
                        color6 = null;
                    }
                    if (i8 != 0) {
                        color7 = null;
                    }
                    if (i10 != 0) {
                        color8 = null;
                    }
                    if (i13 != 0) {
                        color9 = null;
                    }
                    if (i15 == 0) {
                    }
                    if (i17 != 0) {
                        paletteStyle2 = PaletteStyle.TonalSpot;
                    } else {
                        paletteStyle2 = paletteStyle;
                    }
                    if ((i3 & 512) != 0) {
                        i26 = i19 & (-1879048193);
                        d3 = 0.0d;
                    } else {
                        d3 = d;
                        i26 = i19;
                    }
                    z9 = z8;
                    if ((i3 & 1024) != 0) {
                        ColorSpec$SpecVersion.Companion.getClass();
                        i27 = i25 & (-15);
                        colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                    } else {
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        i27 = i25;
                    }
                    i28 = i27;
                    if ((i3 & 2048) != 0) {
                        DynamicScheme.Platform.Companion.getClass();
                        i29 = i28 & (-113);
                        platform3 = DynamicScheme.Platform.Default;
                    } else {
                        i29 = i28;
                        platform3 = platform;
                    }
                    i30 = i26;
                    if ((i3 & 4096) != 0) {
                        shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        i29 &= -897;
                    } else {
                        shapes3 = shapes;
                    }
                    Shapes shapes1111115 = shapes3;
                    if ((i3 & 8192) != 0) {
                        typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                        i29 &= -7169;
                    } else {
                        typography2 = typography;
                    }
                    if (i24 == 0) {
                    }
                    if ((i3 & 32768) != 0) {
                        i31 = i29 & (-458753);
                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                    } else {
                        defaultColorSpring = finiteAnimationSpec;
                        i31 = i29;
                    }
                    shapes4 = shapes1111115;
                }
                gapComposer2.endDefaults();
                gapComposer = gapComposer2;
                boolean z11111111 = z10;
                FiniteAnimationSpec finiteAnimationSpec1113 = defaultColorSpring;
                DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z11111111, finiteAnimationSpec1113, function2, gapComposer, (i31 >> 3) & 524272, 0);
                finiteAnimationSpec2 = finiteAnimationSpec1113;
                color11 = color6;
                color14 = color9;
                double d1114 = d3;
                shapes2 = shapes4;
                platform2 = platform3;
                z7 = z11111111;
                z6 = z9;
                color13 = color8;
                zIsSystemInDarkTheme = zIsSystemInDarkTheme;
                color12 = color7;
                color10 = color15;
                d2 = d1114;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                z6 = z2;
                color10 = color5;
                paletteStyle2 = paletteStyle;
                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                shapes2 = shapes;
                typography2 = typography;
                finiteAnimationSpec2 = finiteAnimationSpec;
                z7 = z4;
                color11 = color6;
                color12 = color7;
                color13 = color8;
                color14 = color9;
                d2 = d;
                platform2 = platform;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                final boolean z11111112 = zIsSystemInDarkTheme;
                final PaletteStyle paletteStyle1113 = paletteStyle2;
                final ColorSpec$SpecVersion colorSpec$SpecVersion1113 = colorSpec$SpecVersion2;
                final Typography typography1113 = typography2;
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                        DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z11111112, z6, color11, color12, color13, color14, color10, paletteStyle1113, d2, colorSpec$SpecVersion1113, platform2, shapes2, typography1113, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i23 |= 24576;
        z4 = z3;
        if ((i2 & 196608) == 0) {
            if ((i3 & 32768) == 0) {
                if ((i2 & 262144) == 0) {
                    zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                } else {
                    zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                }
                if (zChangedInstance) {
                    i11 = 131072;
                }
            }
            i23 |= i11;
        }
        if ((i2 & 1572864) == 0) {
            i23 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
        }
        i25 = i23;
        if ((i19 & 306783379) == 306783378) {
            z5 = true;
        } else {
            z5 = true;
        }
        if (gapComposer2.shouldExecute(i19 & 1, z5)) {
            gapComposer2.startDefaults();
            if ((i & 1) != 0) {
                if ((i3 & 2) != 0) {
                    i19 &= -113;
                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                }
                if (i37 != 0) {
                    z8 = false;
                } else {
                    z8 = z2;
                }
                if (i5 != 0) {
                    color6 = null;
                }
                if (i8 != 0) {
                    color7 = null;
                }
                if (i10 != 0) {
                    color8 = null;
                }
                if (i13 != 0) {
                    color9 = null;
                }
                if (i15 == 0) {
                }
                if (i17 != 0) {
                    paletteStyle2 = PaletteStyle.TonalSpot;
                } else {
                    paletteStyle2 = paletteStyle;
                }
                if ((i3 & 512) != 0) {
                    i26 = i19 & (-1879048193);
                    d3 = 0.0d;
                } else {
                    d3 = d;
                    i26 = i19;
                }
                z9 = z8;
                if ((i3 & 1024) != 0) {
                    ColorSpec$SpecVersion.Companion.getClass();
                    i27 = i25 & (-15);
                    colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                } else {
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    i27 = i25;
                }
                i28 = i27;
                if ((i3 & 2048) != 0) {
                    DynamicScheme.Platform.Companion.getClass();
                    i29 = i28 & (-113);
                    platform3 = DynamicScheme.Platform.Default;
                } else {
                    i29 = i28;
                    platform3 = platform;
                }
                i30 = i26;
                if ((i3 & 4096) != 0) {
                    shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                    i29 &= -897;
                } else {
                    shapes3 = shapes;
                }
                Shapes shapes1111116 = shapes3;
                if ((i3 & 8192) != 0) {
                    typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                    i29 &= -7169;
                } else {
                    typography2 = typography;
                }
                if (i24 == 0) {
                }
                if ((i3 & 32768) != 0) {
                    i31 = i29 & (-458753);
                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                } else {
                    defaultColorSpring = finiteAnimationSpec;
                    i31 = i29;
                }
                shapes4 = shapes1111116;
            } else {
                if ((i3 & 2) != 0) {
                    i19 &= -113;
                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                }
                if (i37 != 0) {
                    z8 = false;
                } else {
                    z8 = z2;
                }
                if (i5 != 0) {
                    color6 = null;
                }
                if (i8 != 0) {
                    color7 = null;
                }
                if (i10 != 0) {
                    color8 = null;
                }
                if (i13 != 0) {
                    color9 = null;
                }
                if (i15 == 0) {
                }
                if (i17 != 0) {
                    paletteStyle2 = PaletteStyle.TonalSpot;
                } else {
                    paletteStyle2 = paletteStyle;
                }
                if ((i3 & 512) != 0) {
                    i26 = i19 & (-1879048193);
                    d3 = 0.0d;
                } else {
                    d3 = d;
                    i26 = i19;
                }
                z9 = z8;
                if ((i3 & 1024) != 0) {
                    ColorSpec$SpecVersion.Companion.getClass();
                    i27 = i25 & (-15);
                    colorSpec$SpecVersion2 = ColorSpec$SpecVersion.Default;
                } else {
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    i27 = i25;
                }
                i28 = i27;
                if ((i3 & 2048) != 0) {
                    DynamicScheme.Platform.Companion.getClass();
                    i29 = i28 & (-113);
                    platform3 = DynamicScheme.Platform.Default;
                } else {
                    i29 = i28;
                    platform3 = platform;
                }
                i30 = i26;
                if ((i3 & 4096) != 0) {
                    shapes3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                    i29 &= -897;
                } else {
                    shapes3 = shapes;
                }
                Shapes shapes1111117 = shapes3;
                if ((i3 & 8192) != 0) {
                    typography2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                    i29 &= -7169;
                } else {
                    typography2 = typography;
                }
                if (i24 == 0) {
                }
                if ((i3 & 32768) != 0) {
                    i31 = i29 & (-458753);
                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                } else {
                    defaultColorSpring = finiteAnimationSpec;
                    i31 = i29;
                }
                shapes4 = shapes1111117;
            }
            gapComposer2.endDefaults();
            gapComposer = gapComposer2;
            boolean z11111113 = z10;
            FiniteAnimationSpec finiteAnimationSpec1114 = defaultColorSpring;
            DynamicMaterialTheme(DynamicMaterialThemeStateKt.m934rememberDynamicMaterialThemeStateCdFbwI(j, zIsSystemInDarkTheme, z9, color6, color7, color8, color9, color15, paletteStyle2, d3, colorSpec$SpecVersion2, platform3, null, gapComposer, i30 & 2147483646, i31 & 126, 4096), shapes4, typography2, z11111113, finiteAnimationSpec1114, function2, gapComposer, (i31 >> 3) & 524272, 0);
            finiteAnimationSpec2 = finiteAnimationSpec1114;
            color11 = color6;
            color14 = color9;
            double d1115 = d3;
            shapes2 = shapes4;
            platform2 = platform3;
            z7 = z11111113;
            z6 = z9;
            color13 = color8;
            zIsSystemInDarkTheme = zIsSystemInDarkTheme;
            color12 = color7;
            color10 = color15;
            d2 = d1115;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            z6 = z2;
            color10 = color5;
            paletteStyle2 = paletteStyle;
            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
            shapes2 = shapes;
            typography2 = typography;
            finiteAnimationSpec2 = finiteAnimationSpec;
            z7 = z4;
            color11 = color6;
            color12 = color7;
            color13 = color8;
            color14 = color9;
            d2 = d;
            platform2 = platform;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final boolean z11111114 = zIsSystemInDarkTheme;
            final PaletteStyle paletteStyle1114 = paletteStyle2;
            final ColorSpec$SpecVersion colorSpec$SpecVersion1114 = colorSpec$SpecVersion2;
            final Typography typography1114 = typography2;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.materialkolor.DynamicMaterialThemeKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                    DynamicMaterialThemeKt.m931DynamicMaterialTheme0OstJqQ(j, z11111114, z6, color11, color12, color13, color14, color10, paletteStyle1114, d2, colorSpec$SpecVersion1114, platform2, shapes2, typography1114, z7, finiteAnimationSpec2, function2, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0137 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x0139  */
    /* JADX WARN: Code duplicated, block: B:103:0x013e  */
    /* JADX WARN: Code duplicated, block: B:106:0x014c  */
    /* JADX WARN: Code duplicated, block: B:107:0x014f  */
    /* JADX WARN: Code duplicated, block: B:111:0x0156  */
    /* JADX WARN: Code duplicated, block: B:113:0x015a  */
    /* JADX WARN: Code duplicated, block: B:115:0x0163  */
    /* JADX WARN: Code duplicated, block: B:116:0x0166  */
    /* JADX WARN: Code duplicated, block: B:119:0x016e  */
    /* JADX WARN: Code duplicated, block: B:122:0x0177  */
    /* JADX WARN: Code duplicated, block: B:124:0x017d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:125:0x017f  */
    /* JADX WARN: Code duplicated, block: B:126:0x0182  */
    /* JADX WARN: Code duplicated, block: B:129:0x018c  */
    /* JADX WARN: Code duplicated, block: B:130:0x018f  */
    /* JADX WARN: Code duplicated, block: B:132:0x0194  */
    /* JADX WARN: Code duplicated, block: B:135:0x019a  */
    /* JADX WARN: Code duplicated, block: B:137:0x019e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:139:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:142:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:143:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:147:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:149:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:152:0x01c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:154:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:157:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:159:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:162:0x01e2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:164:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:167:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:168:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:170:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:173:0x0202  */
    /* JADX WARN: Code duplicated, block: B:177:0x020a  */
    /* JADX WARN: Code duplicated, block: B:179:0x020e  */
    /* JADX WARN: Code duplicated, block: B:181:0x0214  */
    /* JADX WARN: Code duplicated, block: B:182:0x0219  */
    /* JADX WARN: Code duplicated, block: B:184:0x021f  */
    /* JADX WARN: Code duplicated, block: B:188:0x0229  */
    /* JADX WARN: Code duplicated, block: B:190:0x022f  */
    /* JADX WARN: Code duplicated, block: B:194:0x023f  */
    /* JADX WARN: Code duplicated, block: B:198:0x024d  */
    /* JADX WARN: Code duplicated, block: B:201:0x0256  */
    /* JADX WARN: Code duplicated, block: B:203:0x0263  */
    /* JADX WARN: Code duplicated, block: B:229:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:231:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:232:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:234:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:235:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:238:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:240:0x02da  */
    /* JADX WARN: Code duplicated, block: B:242:0x02de  */
    /* JADX WARN: Code duplicated, block: B:244:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:246:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:247:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:250:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:252:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:253:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:256:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:259:0x0305  */
    /* JADX WARN: Code duplicated, block: B:261:0x0313  */
    /* JADX WARN: Code duplicated, block: B:264:0x031c  */
    /* JADX WARN: Code duplicated, block: B:265:0x0326  */
    /* JADX WARN: Code duplicated, block: B:268:0x032e  */
    /* JADX WARN: Code duplicated, block: B:269:0x033b  */
    /* JADX WARN: Code duplicated, block: B:272:0x0343  */
    /* JADX WARN: Code duplicated, block: B:273:0x0350  */
    /* JADX WARN: Code duplicated, block: B:276:0x0357  */
    /* JADX WARN: Code duplicated, block: B:279:0x035d  */
    /* JADX WARN: Code duplicated, block: B:281:0x0381  */
    /* JADX WARN: Code duplicated, block: B:283:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:286:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:288:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    /* JADX WARN: Code duplicated, block: B:36:0x006b  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0077  */
    /* JADX WARN: Code duplicated, block: B:41:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0086  */
    /* JADX WARN: Code duplicated, block: B:47:0x008b  */
    /* JADX WARN: Code duplicated, block: B:49:0x008f  */
    /* JADX WARN: Code duplicated, block: B:51:0x0097  */
    /* JADX WARN: Code duplicated, block: B:52:0x009a  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:67:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00db  */
    /* JADX WARN: Code duplicated, block: B:72:0x00de  */
    /* JADX WARN: Code duplicated, block: B:76:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:81:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:82:0x0100  */
    /* JADX WARN: Code duplicated, block: B:86:0x010a  */
    /* JADX WARN: Code duplicated, block: B:88:0x0111  */
    /* JADX WARN: Code duplicated, block: B:90:0x0115  */
    /* JADX WARN: Code duplicated, block: B:92:0x011f  */
    /* JADX WARN: Code duplicated, block: B:93:0x0122  */
    /* JADX WARN: Code duplicated, block: B:97:0x012e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0133  */
    /* JADX INFO: renamed from: DynamicMaterialTheme-bLGS3X0, reason: not valid java name */
    public static final void m932DynamicMaterialThemebLGS3X0(long j, boolean z, boolean z2, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, PaletteStyle paletteStyle, double d, ColorSpec$SpecVersion colorSpec$SpecVersion, DynamicScheme.Platform platform, Shapes shapes, Typography typography, boolean z3, FiniteAnimationSpec finiteAnimationSpec, Function2 function2, Composer composer, int i, int i2, int i3) {
        int i4;
        boolean zIsSystemInDarkTheme;
        int i5;
        int i6;
        Color color7;
        int i7;
        int i8;
        int i9;
        Color color8;
        int i10;
        int i11;
        Color color9;
        int i12;
        int i13;
        int i14;
        Color color10;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int iOrdinal;
        int i21;
        int i22;
        double d2;
        int i23;
        int i24;
        boolean z4;
        GapComposer gapComposer;
        boolean z5;
        Color color11;
        Color color12;
        DynamicScheme.Platform platform2;
        Shapes shapes2;
        Typography typography2;
        boolean z6;
        FiniteAnimationSpec finiteAnimationSpec2;
        double d3;
        Color color13;
        Color color14;
        Color color15;
        Color color16;
        PaletteStyle paletteStyle2;
        ColorSpec$SpecVersion colorSpec$SpecVersion2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i25;
        boolean z7;
        Color color17;
        PaletteStyle paletteStyle3;
        ColorSpec$SpecVersion colorSpec$SpecVersion3;
        int i26;
        ColorSpec$SpecVersion colorSpec$SpecVersion4;
        DynamicScheme.Platform platform3;
        int i27;
        int i28;
        Typography typography3;
        boolean z8;
        FiniteAnimationSpec defaultColorSpring;
        Typography typography4;
        int i29;
        int i30;
        boolean z9;
        Color color18;
        Color color19;
        boolean zChangedInstance;
        int i31;
        int i32;
        int iOrdinal2;
        function2.getClass();
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1812772991);
        if ((i & 6) == 0) {
            i4 = (gapComposer2.changed(j) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            if ((i3 & 2) == 0) {
                zIsSystemInDarkTheme = z;
                int i33 = gapComposer2.changed(zIsSystemInDarkTheme) ? 32 : 16;
                i4 |= i33;
            } else {
                zIsSystemInDarkTheme = z;
            }
            i4 |= i33;
        } else {
            zIsSystemInDarkTheme = z;
        }
        int i34 = i3 & 4;
        if (i34 == 0) {
            if ((i & 384) == 0) {
                i4 |= gapComposer2.changed(z2) ? 256 : 128;
            }
            i5 = i3 & 8;
            i6 = 1024;
            if (i5 != 0) {
                if ((i & 3072) == 0) {
                    color7 = color;
                    if (gapComposer2.changed(color7)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i4 |= i7;
                }
                i8 = i3 & 16;
                i9 = 8192;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        color8 = color2;
                        if (gapComposer2.changed(color8)) {
                            i10 = 16384;
                        } else {
                            i10 = 8192;
                        }
                        i4 |= i10;
                    }
                    i11 = i3 & 32;
                    if (i11 != 0) {
                        i4 |= 196608;
                        color9 = color3;
                    } else {
                        color9 = color3;
                        if ((i & 196608) == 0) {
                            if (gapComposer2.changed(color9)) {
                                i12 = 131072;
                            } else {
                                i12 = 65536;
                            }
                            i4 |= i12;
                        }
                    }
                    i13 = i3 & 64;
                    i14 = 524288;
                    if (i13 != 0) {
                        i4 |= 1572864;
                        color10 = color4;
                    } else {
                        color10 = color4;
                        if ((i & 1572864) == 0) {
                            if (gapComposer2.changed(color10)) {
                                i15 = 1048576;
                            } else {
                                i15 = 524288;
                            }
                            i4 |= i15;
                        }
                    }
                    i16 = i3 & 128;
                    if (i16 != 0) {
                        i4 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (gapComposer2.changed(color5)) {
                            i17 = 8388608;
                        } else {
                            i17 = 4194304;
                        }
                        i4 |= i17;
                    }
                    i18 = i3 & 256;
                    if (i18 != 0) {
                        if ((i & 100663296) == 0) {
                            if (gapComposer2.changed(color6)) {
                                i19 = 67108864;
                            } else {
                                i19 = 33554432;
                            }
                            i4 |= i19;
                        }
                        i20 = i3 & 512;
                        if (i20 != 0) {
                            if ((i & 805306368) == 0) {
                                if (paletteStyle == null) {
                                    iOrdinal = -1;
                                } else {
                                    iOrdinal = paletteStyle.ordinal();
                                }
                                if (gapComposer2.changed(iOrdinal)) {
                                    i21 = 536870912;
                                } else {
                                    i21 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                                }
                                i4 |= i21;
                            }
                            if ((i2 & 6) == 0) {
                                if ((i3 & 1024) == 0) {
                                    i22 = i4;
                                    d2 = d;
                                    int i35 = gapComposer2.changed(d2) ? 4 : 2;
                                    i23 = i2 | i35;
                                } else {
                                    i22 = i4;
                                    d2 = d;
                                }
                                i23 = i2 | i35;
                            } else {
                                i22 = i4;
                                d2 = d;
                                i23 = i2;
                            }
                            if ((i2 & 48) != 0) {
                                if ((i3 & 2048) != 0) {
                                    i32 = 16;
                                } else {
                                    if (colorSpec$SpecVersion == null) {
                                        iOrdinal2 = -1;
                                    } else {
                                        iOrdinal2 = colorSpec$SpecVersion.ordinal();
                                    }
                                    if (gapComposer2.changed(iOrdinal2)) {
                                        i32 = 32;
                                    } else {
                                        i32 = 16;
                                    }
                                }
                                i23 |= i32;
                            }
                            if ((i2 & 384) == 0) {
                                if ((i3 & 4096) != 0) {
                                    i31 = 128;
                                } else {
                                    if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                                        i31 = 256;
                                    } else {
                                        i31 = 128;
                                    }
                                }
                                i23 |= i31;
                            }
                            if ((i2 & 3072) != 0) {
                                if ((i3 & 8192) == 0 && gapComposer2.changed(shapes)) {
                                    i6 = 2048;
                                }
                                i23 |= i6;
                            }
                            if ((i2 & 24576) != 0) {
                                if ((i3 & 16384) == 0 && gapComposer2.changed(typography)) {
                                    i9 = 16384;
                                }
                                i23 |= i9;
                            }
                            i24 = i3 & 32768;
                            if (i24 != 0) {
                                i23 |= 196608;
                            } else if ((i2 & 196608) == 0) {
                                i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                            }
                            if ((i2 & 1572864) == 0) {
                                if ((i3 & 65536) == 0) {
                                    if ((i2 & 2097152) == 0) {
                                        zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                                    } else {
                                        zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                                    }
                                    if (zChangedInstance) {
                                        i14 = 1048576;
                                    }
                                }
                                i23 |= i14;
                            }
                            if ((i2 & 12582912) == 0) {
                                i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                            }
                            if ((i22 & 306783379) == 306783378 || (i23 & 4793491) != 4793490) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                                gapComposer2.startDefaults();
                                if ((i & 1) != 0 || gapComposer2.getDefaultsInvalid()) {
                                    if ((i3 & 2) != 0) {
                                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                        i25 = i22 & (-113);
                                    } else {
                                        i25 = i22;
                                    }
                                    if (i34 != 0) {
                                        z7 = false;
                                    } else {
                                        z7 = z2;
                                    }
                                    if (i5 != 0) {
                                        color7 = null;
                                    }
                                    if (i8 != 0) {
                                        color8 = null;
                                    }
                                    if (i11 != 0) {
                                        color9 = null;
                                    }
                                    if (i13 != 0) {
                                        color10 = null;
                                    }
                                    if (i16 != 0) {
                                        color17 = null;
                                    } else {
                                        color17 = color5;
                                    }
                                    color12 = i18 == 0 ? color6 : null;
                                    if (i20 != 0) {
                                        paletteStyle3 = PaletteStyle.TonalSpot;
                                    } else {
                                        paletteStyle3 = paletteStyle;
                                    }
                                    if ((i3 & 1024) != 0) {
                                        i23 &= -15;
                                        d2 = 0.0d;
                                    }
                                    if ((i3 & 2048) != 0) {
                                        ColorSpec$SpecVersion.Companion.getClass();
                                        i23 &= -113;
                                        colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                                    } else {
                                        colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                                    }
                                    int i36 = i25;
                                    i26 = i23;
                                    colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                                    if ((i3 & 4096) != 0) {
                                        DynamicScheme.Platform.Companion.getClass();
                                        i26 &= -897;
                                        platform3 = DynamicScheme.Platform.Default;
                                    } else {
                                        platform3 = platform;
                                    }
                                    DynamicScheme.Platform platform4 = platform3;
                                    if ((i3 & 8192) != 0) {
                                        shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                        i26 &= -7169;
                                    } else {
                                        shapes2 = shapes;
                                    }
                                    i27 = i26;
                                    if ((i3 & 16384) != 0) {
                                        typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                        i28 = i27 & (-57345);
                                    } else {
                                        i28 = i27;
                                        typography3 = typography;
                                    }
                                    z8 = i24 == 0 ? z3 : false;
                                    if ((i3 & 65536) != 0) {
                                        i28 &= -3670017;
                                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                                    } else {
                                        defaultColorSpring = finiteAnimationSpec;
                                    }
                                    platform2 = platform4;
                                    typography4 = typography3;
                                    i29 = i28;
                                    double d4 = d2;
                                    i30 = i36;
                                    z9 = zIsSystemInDarkTheme;
                                    color18 = color9;
                                    color19 = color17;
                                    d3 = d4;
                                } else {
                                    gapComposer2.skipToGroupEnd();
                                    int i37 = (i3 & 2) != 0 ? i22 & (-113) : i22;
                                    if ((i3 & 1024) != 0) {
                                        i23 &= -15;
                                    }
                                    if ((i3 & 2048) != 0) {
                                        i23 &= -113;
                                    }
                                    int i38 = i23;
                                    if ((i3 & 4096) != 0) {
                                        i38 &= -897;
                                    }
                                    if ((i3 & 8192) != 0) {
                                        i38 &= -7169;
                                    }
                                    if ((i3 & 16384) != 0) {
                                        i38 &= -57345;
                                    }
                                    if ((i3 & 65536) != 0) {
                                        i38 &= -3670017;
                                    }
                                    colorSpec$SpecVersion4 = colorSpec$SpecVersion;
                                    platform2 = platform;
                                    shapes2 = shapes;
                                    typography4 = typography;
                                    z8 = z3;
                                    defaultColorSpring = finiteAnimationSpec;
                                    d3 = d2;
                                    color7 = color7;
                                    z9 = zIsSystemInDarkTheme;
                                    color8 = color8;
                                    color18 = color9;
                                    color10 = color10;
                                    z7 = z2;
                                    color19 = color5;
                                    paletteStyle3 = paletteStyle;
                                    i30 = i37;
                                    i29 = i38;
                                    color12 = color6;
                                }
                                gapComposer2.endDefaults();
                                gapComposer = gapComposer2;
                                boolean z10 = z8;
                                FiniteAnimationSpec finiteAnimationSpec3 = defaultColorSpring;
                                DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z10, finiteAnimationSpec3, function2, gapComposer, (i29 >> 6) & 524272, 0);
                                finiteAnimationSpec2 = finiteAnimationSpec3;
                                color13 = color7;
                                color16 = color10;
                                paletteStyle2 = paletteStyle3;
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                                typography2 = typography4;
                                z6 = z10;
                                z5 = z7;
                                color15 = color18;
                                zIsSystemInDarkTheme = z9;
                                color14 = color8;
                                color11 = color19;
                            } else {
                                gapComposer = gapComposer2;
                                gapComposer.skipToGroupEnd();
                                z5 = z2;
                                color11 = color5;
                                color12 = color6;
                                platform2 = platform;
                                shapes2 = shapes;
                                typography2 = typography;
                                z6 = z3;
                                finiteAnimationSpec2 = finiteAnimationSpec;
                                d3 = d2;
                                color13 = color7;
                                color14 = color8;
                                color15 = color9;
                                color16 = color10;
                                paletteStyle2 = paletteStyle;
                                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                            }
                            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                            if (recomposeScopeImplEndRestartGroup != null) {
                                recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                            }
                        }
                        i4 |= 805306368;
                        i20 = i20;
                        if ((i2 & 6) == 0) {
                            if ((i3 & 1024) == 0) {
                                i22 = i4;
                                d2 = d;
                                if (gapComposer2.changed(d2)) {
                                }
                                i23 = i2 | i35;
                            } else {
                                i22 = i4;
                                d2 = d;
                            }
                            i23 = i2 | i35;
                        } else {
                            i22 = i4;
                            d2 = d;
                            i23 = i2;
                        }
                        if ((i2 & 48) != 0) {
                            if ((i3 & 2048) != 0) {
                                i32 = 16;
                            } else {
                                if (colorSpec$SpecVersion == null) {
                                    iOrdinal2 = -1;
                                } else {
                                    iOrdinal2 = colorSpec$SpecVersion.ordinal();
                                }
                                if (gapComposer2.changed(iOrdinal2)) {
                                    i32 = 32;
                                } else {
                                    i32 = 16;
                                }
                            }
                            i23 |= i32;
                        }
                        if ((i2 & 384) == 0) {
                            if ((i3 & 4096) != 0) {
                                i31 = 128;
                            } else {
                                if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                                    i31 = 256;
                                } else {
                                    i31 = 128;
                                }
                            }
                            i23 |= i31;
                        }
                        if ((i2 & 3072) != 0) {
                            if ((i3 & 8192) == 0) {
                                i6 = 2048;
                            }
                            i23 |= i6;
                        }
                        if ((i2 & 24576) != 0) {
                            if ((i3 & 16384) == 0) {
                                i9 = 16384;
                            }
                            i23 |= i9;
                        }
                        i24 = i3 & 32768;
                        if (i24 != 0) {
                            i23 |= 196608;
                        } else if ((i2 & 196608) == 0) {
                            i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                        }
                        if ((i2 & 1572864) == 0) {
                            if ((i3 & 65536) == 0) {
                                if ((i2 & 2097152) == 0) {
                                    zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                                } else {
                                    zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                                }
                                if (zChangedInstance) {
                                    i14 = 1048576;
                                }
                            }
                            i23 |= i14;
                        }
                        if ((i2 & 12582912) == 0) {
                            i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                        }
                        if ((i22 & 306783379) == 306783378) {
                            z4 = true;
                        } else {
                            z4 = true;
                        }
                        if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                            gapComposer2.startDefaults();
                            if ((i & 1) != 0) {
                                if ((i3 & 2) != 0) {
                                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                    i25 = i22 & (-113);
                                } else {
                                    i25 = i22;
                                }
                                if (i34 != 0) {
                                    z7 = false;
                                } else {
                                    z7 = z2;
                                }
                                if (i5 != 0) {
                                    color7 = null;
                                }
                                if (i8 != 0) {
                                    color8 = null;
                                }
                                if (i11 != 0) {
                                    color9 = null;
                                }
                                if (i13 != 0) {
                                    color10 = null;
                                }
                                if (i16 != 0) {
                                    color17 = null;
                                } else {
                                    color17 = color5;
                                }
                                if (i18 == 0) {
                                }
                                if (i20 != 0) {
                                    paletteStyle3 = PaletteStyle.TonalSpot;
                                } else {
                                    paletteStyle3 = paletteStyle;
                                }
                                if ((i3 & 1024) != 0) {
                                    i23 &= -15;
                                    d2 = 0.0d;
                                }
                                if ((i3 & 2048) != 0) {
                                    ColorSpec$SpecVersion.Companion.getClass();
                                    i23 &= -113;
                                    colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                                } else {
                                    colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                                }
                                int i39 = i25;
                                i26 = i23;
                                colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                                if ((i3 & 4096) != 0) {
                                    DynamicScheme.Platform.Companion.getClass();
                                    i26 &= -897;
                                    platform3 = DynamicScheme.Platform.Default;
                                } else {
                                    platform3 = platform;
                                }
                                DynamicScheme.Platform platform5 = platform3;
                                if ((i3 & 8192) != 0) {
                                    shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                    i26 &= -7169;
                                } else {
                                    shapes2 = shapes;
                                }
                                i27 = i26;
                                if ((i3 & 16384) != 0) {
                                    typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                    i28 = i27 & (-57345);
                                } else {
                                    i28 = i27;
                                    typography3 = typography;
                                }
                                if (i24 == 0) {
                                }
                                if ((i3 & 65536) != 0) {
                                    i28 &= -3670017;
                                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                                } else {
                                    defaultColorSpring = finiteAnimationSpec;
                                }
                                platform2 = platform5;
                                typography4 = typography3;
                                i29 = i28;
                                double d5 = d2;
                                i30 = i39;
                                z9 = zIsSystemInDarkTheme;
                                color18 = color9;
                                color19 = color17;
                                d3 = d5;
                            } else {
                                if ((i3 & 2) != 0) {
                                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                    i25 = i22 & (-113);
                                } else {
                                    i25 = i22;
                                }
                                if (i34 != 0) {
                                    z7 = false;
                                } else {
                                    z7 = z2;
                                }
                                if (i5 != 0) {
                                    color7 = null;
                                }
                                if (i8 != 0) {
                                    color8 = null;
                                }
                                if (i11 != 0) {
                                    color9 = null;
                                }
                                if (i13 != 0) {
                                    color10 = null;
                                }
                                if (i16 != 0) {
                                    color17 = null;
                                } else {
                                    color17 = color5;
                                }
                                if (i18 == 0) {
                                }
                                if (i20 != 0) {
                                    paletteStyle3 = PaletteStyle.TonalSpot;
                                } else {
                                    paletteStyle3 = paletteStyle;
                                }
                                if ((i3 & 1024) != 0) {
                                    i23 &= -15;
                                    d2 = 0.0d;
                                }
                                if ((i3 & 2048) != 0) {
                                    ColorSpec$SpecVersion.Companion.getClass();
                                    i23 &= -113;
                                    colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                                } else {
                                    colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                                }
                                int i310 = i25;
                                i26 = i23;
                                colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                                if ((i3 & 4096) != 0) {
                                    DynamicScheme.Platform.Companion.getClass();
                                    i26 &= -897;
                                    platform3 = DynamicScheme.Platform.Default;
                                } else {
                                    platform3 = platform;
                                }
                                DynamicScheme.Platform platform6 = platform3;
                                if ((i3 & 8192) != 0) {
                                    shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                    i26 &= -7169;
                                } else {
                                    shapes2 = shapes;
                                }
                                i27 = i26;
                                if ((i3 & 16384) != 0) {
                                    typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                    i28 = i27 & (-57345);
                                } else {
                                    i28 = i27;
                                    typography3 = typography;
                                }
                                if (i24 == 0) {
                                }
                                if ((i3 & 65536) != 0) {
                                    i28 &= -3670017;
                                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                                } else {
                                    defaultColorSpring = finiteAnimationSpec;
                                }
                                platform2 = platform6;
                                typography4 = typography3;
                                i29 = i28;
                                double d6 = d2;
                                i30 = i310;
                                z9 = zIsSystemInDarkTheme;
                                color18 = color9;
                                color19 = color17;
                                d3 = d6;
                            }
                            gapComposer2.endDefaults();
                            gapComposer = gapComposer2;
                            boolean z11 = z8;
                            FiniteAnimationSpec finiteAnimationSpec4 = defaultColorSpring;
                            DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z11, finiteAnimationSpec4, function2, gapComposer, (i29 >> 6) & 524272, 0);
                            finiteAnimationSpec2 = finiteAnimationSpec4;
                            color13 = color7;
                            color16 = color10;
                            paletteStyle2 = paletteStyle3;
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                            typography2 = typography4;
                            z6 = z11;
                            z5 = z7;
                            color15 = color18;
                            zIsSystemInDarkTheme = z9;
                            color14 = color8;
                            color11 = color19;
                        } else {
                            gapComposer = gapComposer2;
                            gapComposer.skipToGroupEnd();
                            z5 = z2;
                            color11 = color5;
                            color12 = color6;
                            platform2 = platform;
                            shapes2 = shapes;
                            typography2 = typography;
                            z6 = z3;
                            finiteAnimationSpec2 = finiteAnimationSpec;
                            d3 = d2;
                            color13 = color7;
                            color14 = color8;
                            color15 = color9;
                            color16 = color10;
                            paletteStyle2 = paletteStyle;
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        }
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                        }
                    }
                    i4 |= 100663296;
                    i20 = i3 & 512;
                    if (i20 != 0) {
                        if ((i & 805306368) == 0) {
                            if (paletteStyle == null) {
                                iOrdinal = -1;
                            } else {
                                iOrdinal = paletteStyle.ordinal();
                            }
                            if (gapComposer2.changed(iOrdinal)) {
                                i21 = 536870912;
                            } else {
                                i21 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                            }
                            i4 |= i21;
                        }
                        if ((i2 & 6) == 0) {
                            if ((i3 & 1024) == 0) {
                                i22 = i4;
                                d2 = d;
                                if (gapComposer2.changed(d2)) {
                                }
                                i23 = i2 | i35;
                            } else {
                                i22 = i4;
                                d2 = d;
                            }
                            i23 = i2 | i35;
                        } else {
                            i22 = i4;
                            d2 = d;
                            i23 = i2;
                        }
                        if ((i2 & 48) != 0) {
                            if ((i3 & 2048) != 0) {
                                i32 = 16;
                            } else {
                                if (colorSpec$SpecVersion == null) {
                                    iOrdinal2 = -1;
                                } else {
                                    iOrdinal2 = colorSpec$SpecVersion.ordinal();
                                }
                                if (gapComposer2.changed(iOrdinal2)) {
                                    i32 = 32;
                                } else {
                                    i32 = 16;
                                }
                            }
                            i23 |= i32;
                        }
                        if ((i2 & 384) == 0) {
                            if ((i3 & 4096) != 0) {
                                i31 = 128;
                            } else {
                                if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                                    i31 = 256;
                                } else {
                                    i31 = 128;
                                }
                            }
                            i23 |= i31;
                        }
                        if ((i2 & 3072) != 0) {
                            if ((i3 & 8192) == 0) {
                                i6 = 2048;
                            }
                            i23 |= i6;
                        }
                        if ((i2 & 24576) != 0) {
                            if ((i3 & 16384) == 0) {
                                i9 = 16384;
                            }
                            i23 |= i9;
                        }
                        i24 = i3 & 32768;
                        if (i24 != 0) {
                            i23 |= 196608;
                        } else if ((i2 & 196608) == 0) {
                            i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                        }
                        if ((i2 & 1572864) == 0) {
                            if ((i3 & 65536) == 0) {
                                if ((i2 & 2097152) == 0) {
                                    zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                                } else {
                                    zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                                }
                                if (zChangedInstance) {
                                    i14 = 1048576;
                                }
                            }
                            i23 |= i14;
                        }
                        if ((i2 & 12582912) == 0) {
                            i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                        }
                        if ((i22 & 306783379) == 306783378) {
                            z4 = true;
                        } else {
                            z4 = true;
                        }
                        if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                            gapComposer2.startDefaults();
                            if ((i & 1) != 0) {
                                if ((i3 & 2) != 0) {
                                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                    i25 = i22 & (-113);
                                } else {
                                    i25 = i22;
                                }
                                if (i34 != 0) {
                                    z7 = false;
                                } else {
                                    z7 = z2;
                                }
                                if (i5 != 0) {
                                    color7 = null;
                                }
                                if (i8 != 0) {
                                    color8 = null;
                                }
                                if (i11 != 0) {
                                    color9 = null;
                                }
                                if (i13 != 0) {
                                    color10 = null;
                                }
                                if (i16 != 0) {
                                    color17 = null;
                                } else {
                                    color17 = color5;
                                }
                                if (i18 == 0) {
                                }
                                if (i20 != 0) {
                                    paletteStyle3 = PaletteStyle.TonalSpot;
                                } else {
                                    paletteStyle3 = paletteStyle;
                                }
                                if ((i3 & 1024) != 0) {
                                    i23 &= -15;
                                    d2 = 0.0d;
                                }
                                if ((i3 & 2048) != 0) {
                                    ColorSpec$SpecVersion.Companion.getClass();
                                    i23 &= -113;
                                    colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                                } else {
                                    colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                                }
                                int i311 = i25;
                                i26 = i23;
                                colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                                if ((i3 & 4096) != 0) {
                                    DynamicScheme.Platform.Companion.getClass();
                                    i26 &= -897;
                                    platform3 = DynamicScheme.Platform.Default;
                                } else {
                                    platform3 = platform;
                                }
                                DynamicScheme.Platform platform7 = platform3;
                                if ((i3 & 8192) != 0) {
                                    shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                    i26 &= -7169;
                                } else {
                                    shapes2 = shapes;
                                }
                                i27 = i26;
                                if ((i3 & 16384) != 0) {
                                    typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                    i28 = i27 & (-57345);
                                } else {
                                    i28 = i27;
                                    typography3 = typography;
                                }
                                if (i24 == 0) {
                                }
                                if ((i3 & 65536) != 0) {
                                    i28 &= -3670017;
                                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                                } else {
                                    defaultColorSpring = finiteAnimationSpec;
                                }
                                platform2 = platform7;
                                typography4 = typography3;
                                i29 = i28;
                                double d7 = d2;
                                i30 = i311;
                                z9 = zIsSystemInDarkTheme;
                                color18 = color9;
                                color19 = color17;
                                d3 = d7;
                            } else {
                                if ((i3 & 2) != 0) {
                                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                    i25 = i22 & (-113);
                                } else {
                                    i25 = i22;
                                }
                                if (i34 != 0) {
                                    z7 = false;
                                } else {
                                    z7 = z2;
                                }
                                if (i5 != 0) {
                                    color7 = null;
                                }
                                if (i8 != 0) {
                                    color8 = null;
                                }
                                if (i11 != 0) {
                                    color9 = null;
                                }
                                if (i13 != 0) {
                                    color10 = null;
                                }
                                if (i16 != 0) {
                                    color17 = null;
                                } else {
                                    color17 = color5;
                                }
                                if (i18 == 0) {
                                }
                                if (i20 != 0) {
                                    paletteStyle3 = PaletteStyle.TonalSpot;
                                } else {
                                    paletteStyle3 = paletteStyle;
                                }
                                if ((i3 & 1024) != 0) {
                                    i23 &= -15;
                                    d2 = 0.0d;
                                }
                                if ((i3 & 2048) != 0) {
                                    ColorSpec$SpecVersion.Companion.getClass();
                                    i23 &= -113;
                                    colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                                } else {
                                    colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                                }
                                int i312 = i25;
                                i26 = i23;
                                colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                                if ((i3 & 4096) != 0) {
                                    DynamicScheme.Platform.Companion.getClass();
                                    i26 &= -897;
                                    platform3 = DynamicScheme.Platform.Default;
                                } else {
                                    platform3 = platform;
                                }
                                DynamicScheme.Platform platform8 = platform3;
                                if ((i3 & 8192) != 0) {
                                    shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                    i26 &= -7169;
                                } else {
                                    shapes2 = shapes;
                                }
                                i27 = i26;
                                if ((i3 & 16384) != 0) {
                                    typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                    i28 = i27 & (-57345);
                                } else {
                                    i28 = i27;
                                    typography3 = typography;
                                }
                                if (i24 == 0) {
                                }
                                if ((i3 & 65536) != 0) {
                                    i28 &= -3670017;
                                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                                } else {
                                    defaultColorSpring = finiteAnimationSpec;
                                }
                                platform2 = platform8;
                                typography4 = typography3;
                                i29 = i28;
                                double d8 = d2;
                                i30 = i312;
                                z9 = zIsSystemInDarkTheme;
                                color18 = color9;
                                color19 = color17;
                                d3 = d8;
                            }
                            gapComposer2.endDefaults();
                            gapComposer = gapComposer2;
                            boolean z12 = z8;
                            FiniteAnimationSpec finiteAnimationSpec5 = defaultColorSpring;
                            DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z12, finiteAnimationSpec5, function2, gapComposer, (i29 >> 6) & 524272, 0);
                            finiteAnimationSpec2 = finiteAnimationSpec5;
                            color13 = color7;
                            color16 = color10;
                            paletteStyle2 = paletteStyle3;
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                            typography2 = typography4;
                            z6 = z12;
                            z5 = z7;
                            color15 = color18;
                            zIsSystemInDarkTheme = z9;
                            color14 = color8;
                            color11 = color19;
                        } else {
                            gapComposer = gapComposer2;
                            gapComposer.skipToGroupEnd();
                            z5 = z2;
                            color11 = color5;
                            color12 = color6;
                            platform2 = platform;
                            shapes2 = shapes;
                            typography2 = typography;
                            z6 = z3;
                            finiteAnimationSpec2 = finiteAnimationSpec;
                            d3 = d2;
                            color13 = color7;
                            color14 = color8;
                            color15 = color9;
                            color16 = color10;
                            paletteStyle2 = paletteStyle;
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        }
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                        }
                    }
                    i4 |= 805306368;
                    i20 = i20;
                    if ((i2 & 6) == 0) {
                        if ((i3 & 1024) == 0) {
                            i22 = i4;
                            d2 = d;
                            if (gapComposer2.changed(d2)) {
                            }
                            i23 = i2 | i35;
                        } else {
                            i22 = i4;
                            d2 = d;
                        }
                        i23 = i2 | i35;
                    } else {
                        i22 = i4;
                        d2 = d;
                        i23 = i2;
                    }
                    if ((i2 & 48) != 0) {
                        if ((i3 & 2048) != 0) {
                            i32 = 16;
                        } else {
                            if (colorSpec$SpecVersion == null) {
                                iOrdinal2 = -1;
                            } else {
                                iOrdinal2 = colorSpec$SpecVersion.ordinal();
                            }
                            if (gapComposer2.changed(iOrdinal2)) {
                                i32 = 32;
                            } else {
                                i32 = 16;
                            }
                        }
                        i23 |= i32;
                    }
                    if ((i2 & 384) == 0) {
                        if ((i3 & 4096) != 0) {
                            i31 = 128;
                        } else {
                            if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                                i31 = 256;
                            } else {
                                i31 = 128;
                            }
                        }
                        i23 |= i31;
                    }
                    if ((i2 & 3072) != 0) {
                        if ((i3 & 8192) == 0) {
                            i6 = 2048;
                        }
                        i23 |= i6;
                    }
                    if ((i2 & 24576) != 0) {
                        if ((i3 & 16384) == 0) {
                            i9 = 16384;
                        }
                        i23 |= i9;
                    }
                    i24 = i3 & 32768;
                    if (i24 != 0) {
                        i23 |= 196608;
                    } else if ((i2 & 196608) == 0) {
                        i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                    }
                    if ((i2 & 1572864) == 0) {
                        if ((i3 & 65536) == 0) {
                            if ((i2 & 2097152) == 0) {
                                zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                            } else {
                                zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                            }
                            if (zChangedInstance) {
                                i14 = 1048576;
                            }
                        }
                        i23 |= i14;
                    }
                    if ((i2 & 12582912) == 0) {
                        i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                    }
                    if ((i22 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                        gapComposer2.startDefaults();
                        if ((i & 1) != 0) {
                            if ((i3 & 2) != 0) {
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                i25 = i22 & (-113);
                            } else {
                                i25 = i22;
                            }
                            if (i34 != 0) {
                                z7 = false;
                            } else {
                                z7 = z2;
                            }
                            if (i5 != 0) {
                                color7 = null;
                            }
                            if (i8 != 0) {
                                color8 = null;
                            }
                            if (i11 != 0) {
                                color9 = null;
                            }
                            if (i13 != 0) {
                                color10 = null;
                            }
                            if (i16 != 0) {
                                color17 = null;
                            } else {
                                color17 = color5;
                            }
                            if (i18 == 0) {
                            }
                            if (i20 != 0) {
                                paletteStyle3 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle3 = paletteStyle;
                            }
                            if ((i3 & 1024) != 0) {
                                i23 &= -15;
                                d2 = 0.0d;
                            }
                            if ((i3 & 2048) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i23 &= -113;
                                colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                            }
                            int i313 = i25;
                            i26 = i23;
                            colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                            if ((i3 & 4096) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i26 &= -897;
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                platform3 = platform;
                            }
                            DynamicScheme.Platform platform9 = platform3;
                            if ((i3 & 8192) != 0) {
                                shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i26 &= -7169;
                            } else {
                                shapes2 = shapes;
                            }
                            i27 = i26;
                            if ((i3 & 16384) != 0) {
                                typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i28 = i27 & (-57345);
                            } else {
                                i28 = i27;
                                typography3 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 65536) != 0) {
                                i28 &= -3670017;
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                            }
                            platform2 = platform9;
                            typography4 = typography3;
                            i29 = i28;
                            double d9 = d2;
                            i30 = i313;
                            z9 = zIsSystemInDarkTheme;
                            color18 = color9;
                            color19 = color17;
                            d3 = d9;
                        } else {
                            if ((i3 & 2) != 0) {
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                i25 = i22 & (-113);
                            } else {
                                i25 = i22;
                            }
                            if (i34 != 0) {
                                z7 = false;
                            } else {
                                z7 = z2;
                            }
                            if (i5 != 0) {
                                color7 = null;
                            }
                            if (i8 != 0) {
                                color8 = null;
                            }
                            if (i11 != 0) {
                                color9 = null;
                            }
                            if (i13 != 0) {
                                color10 = null;
                            }
                            if (i16 != 0) {
                                color17 = null;
                            } else {
                                color17 = color5;
                            }
                            if (i18 == 0) {
                            }
                            if (i20 != 0) {
                                paletteStyle3 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle3 = paletteStyle;
                            }
                            if ((i3 & 1024) != 0) {
                                i23 &= -15;
                                d2 = 0.0d;
                            }
                            if ((i3 & 2048) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i23 &= -113;
                                colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                            }
                            int i314 = i25;
                            i26 = i23;
                            colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                            if ((i3 & 4096) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i26 &= -897;
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                platform3 = platform;
                            }
                            DynamicScheme.Platform platform10 = platform3;
                            if ((i3 & 8192) != 0) {
                                shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i26 &= -7169;
                            } else {
                                shapes2 = shapes;
                            }
                            i27 = i26;
                            if ((i3 & 16384) != 0) {
                                typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i28 = i27 & (-57345);
                            } else {
                                i28 = i27;
                                typography3 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 65536) != 0) {
                                i28 &= -3670017;
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                            }
                            platform2 = platform10;
                            typography4 = typography3;
                            i29 = i28;
                            double d10 = d2;
                            i30 = i314;
                            z9 = zIsSystemInDarkTheme;
                            color18 = color9;
                            color19 = color17;
                            d3 = d10;
                        }
                        gapComposer2.endDefaults();
                        gapComposer = gapComposer2;
                        boolean z13 = z8;
                        FiniteAnimationSpec finiteAnimationSpec6 = defaultColorSpring;
                        DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z13, finiteAnimationSpec6, function2, gapComposer, (i29 >> 6) & 524272, 0);
                        finiteAnimationSpec2 = finiteAnimationSpec6;
                        color13 = color7;
                        color16 = color10;
                        paletteStyle2 = paletteStyle3;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                        typography2 = typography4;
                        z6 = z13;
                        z5 = z7;
                        color15 = color18;
                        zIsSystemInDarkTheme = z9;
                        color14 = color8;
                        color11 = color19;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        z5 = z2;
                        color11 = color5;
                        color12 = color6;
                        platform2 = platform;
                        shapes2 = shapes;
                        typography2 = typography;
                        z6 = z3;
                        finiteAnimationSpec2 = finiteAnimationSpec;
                        d3 = d2;
                        color13 = color7;
                        color14 = color8;
                        color15 = color9;
                        color16 = color10;
                        paletteStyle2 = paletteStyle;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                    }
                }
                i4 |= 24576;
                color8 = color2;
                i11 = i3 & 32;
                if (i11 != 0) {
                    i4 |= 196608;
                    color9 = color3;
                } else {
                    color9 = color3;
                    if ((i & 196608) == 0) {
                        if (gapComposer2.changed(color9)) {
                            i12 = 131072;
                        } else {
                            i12 = 65536;
                        }
                        i4 |= i12;
                    }
                }
                i13 = i3 & 64;
                i14 = 524288;
                if (i13 != 0) {
                    i4 |= 1572864;
                    color10 = color4;
                } else {
                    color10 = color4;
                    if ((i & 1572864) == 0) {
                        if (gapComposer2.changed(color10)) {
                            i15 = 1048576;
                        } else {
                            i15 = 524288;
                        }
                        i4 |= i15;
                    }
                }
                i16 = i3 & 128;
                if (i16 != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (gapComposer2.changed(color5)) {
                        i17 = 8388608;
                    } else {
                        i17 = 4194304;
                    }
                    i4 |= i17;
                }
                i18 = i3 & 256;
                if (i18 != 0) {
                    if ((i & 100663296) == 0) {
                        if (gapComposer2.changed(color6)) {
                            i19 = 67108864;
                        } else {
                            i19 = 33554432;
                        }
                        i4 |= i19;
                    }
                    i20 = i3 & 512;
                    if (i20 != 0) {
                        if ((i & 805306368) == 0) {
                            if (paletteStyle == null) {
                                iOrdinal = -1;
                            } else {
                                iOrdinal = paletteStyle.ordinal();
                            }
                            if (gapComposer2.changed(iOrdinal)) {
                                i21 = 536870912;
                            } else {
                                i21 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                            }
                            i4 |= i21;
                        }
                        if ((i2 & 6) == 0) {
                            if ((i3 & 1024) == 0) {
                                i22 = i4;
                                d2 = d;
                                if (gapComposer2.changed(d2)) {
                                }
                                i23 = i2 | i35;
                            } else {
                                i22 = i4;
                                d2 = d;
                            }
                            i23 = i2 | i35;
                        } else {
                            i22 = i4;
                            d2 = d;
                            i23 = i2;
                        }
                        if ((i2 & 48) != 0) {
                            if ((i3 & 2048) != 0) {
                                i32 = 16;
                            } else {
                                if (colorSpec$SpecVersion == null) {
                                    iOrdinal2 = -1;
                                } else {
                                    iOrdinal2 = colorSpec$SpecVersion.ordinal();
                                }
                                if (gapComposer2.changed(iOrdinal2)) {
                                    i32 = 32;
                                } else {
                                    i32 = 16;
                                }
                            }
                            i23 |= i32;
                        }
                        if ((i2 & 384) == 0) {
                            if ((i3 & 4096) != 0) {
                                i31 = 128;
                            } else {
                                if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                                    i31 = 256;
                                } else {
                                    i31 = 128;
                                }
                            }
                            i23 |= i31;
                        }
                        if ((i2 & 3072) != 0) {
                            if ((i3 & 8192) == 0) {
                                i6 = 2048;
                            }
                            i23 |= i6;
                        }
                        if ((i2 & 24576) != 0) {
                            if ((i3 & 16384) == 0) {
                                i9 = 16384;
                            }
                            i23 |= i9;
                        }
                        i24 = i3 & 32768;
                        if (i24 != 0) {
                            i23 |= 196608;
                        } else if ((i2 & 196608) == 0) {
                            i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                        }
                        if ((i2 & 1572864) == 0) {
                            if ((i3 & 65536) == 0) {
                                if ((i2 & 2097152) == 0) {
                                    zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                                } else {
                                    zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                                }
                                if (zChangedInstance) {
                                    i14 = 1048576;
                                }
                            }
                            i23 |= i14;
                        }
                        if ((i2 & 12582912) == 0) {
                            i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                        }
                        if ((i22 & 306783379) == 306783378) {
                            z4 = true;
                        } else {
                            z4 = true;
                        }
                        if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                            gapComposer2.startDefaults();
                            if ((i & 1) != 0) {
                                if ((i3 & 2) != 0) {
                                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                    i25 = i22 & (-113);
                                } else {
                                    i25 = i22;
                                }
                                if (i34 != 0) {
                                    z7 = false;
                                } else {
                                    z7 = z2;
                                }
                                if (i5 != 0) {
                                    color7 = null;
                                }
                                if (i8 != 0) {
                                    color8 = null;
                                }
                                if (i11 != 0) {
                                    color9 = null;
                                }
                                if (i13 != 0) {
                                    color10 = null;
                                }
                                if (i16 != 0) {
                                    color17 = null;
                                } else {
                                    color17 = color5;
                                }
                                if (i18 == 0) {
                                }
                                if (i20 != 0) {
                                    paletteStyle3 = PaletteStyle.TonalSpot;
                                } else {
                                    paletteStyle3 = paletteStyle;
                                }
                                if ((i3 & 1024) != 0) {
                                    i23 &= -15;
                                    d2 = 0.0d;
                                }
                                if ((i3 & 2048) != 0) {
                                    ColorSpec$SpecVersion.Companion.getClass();
                                    i23 &= -113;
                                    colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                                } else {
                                    colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                                }
                                int i315 = i25;
                                i26 = i23;
                                colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                                if ((i3 & 4096) != 0) {
                                    DynamicScheme.Platform.Companion.getClass();
                                    i26 &= -897;
                                    platform3 = DynamicScheme.Platform.Default;
                                } else {
                                    platform3 = platform;
                                }
                                DynamicScheme.Platform platform11 = platform3;
                                if ((i3 & 8192) != 0) {
                                    shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                    i26 &= -7169;
                                } else {
                                    shapes2 = shapes;
                                }
                                i27 = i26;
                                if ((i3 & 16384) != 0) {
                                    typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                    i28 = i27 & (-57345);
                                } else {
                                    i28 = i27;
                                    typography3 = typography;
                                }
                                if (i24 == 0) {
                                }
                                if ((i3 & 65536) != 0) {
                                    i28 &= -3670017;
                                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                                } else {
                                    defaultColorSpring = finiteAnimationSpec;
                                }
                                platform2 = platform11;
                                typography4 = typography3;
                                i29 = i28;
                                double d11 = d2;
                                i30 = i315;
                                z9 = zIsSystemInDarkTheme;
                                color18 = color9;
                                color19 = color17;
                                d3 = d11;
                            } else {
                                if ((i3 & 2) != 0) {
                                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                    i25 = i22 & (-113);
                                } else {
                                    i25 = i22;
                                }
                                if (i34 != 0) {
                                    z7 = false;
                                } else {
                                    z7 = z2;
                                }
                                if (i5 != 0) {
                                    color7 = null;
                                }
                                if (i8 != 0) {
                                    color8 = null;
                                }
                                if (i11 != 0) {
                                    color9 = null;
                                }
                                if (i13 != 0) {
                                    color10 = null;
                                }
                                if (i16 != 0) {
                                    color17 = null;
                                } else {
                                    color17 = color5;
                                }
                                if (i18 == 0) {
                                }
                                if (i20 != 0) {
                                    paletteStyle3 = PaletteStyle.TonalSpot;
                                } else {
                                    paletteStyle3 = paletteStyle;
                                }
                                if ((i3 & 1024) != 0) {
                                    i23 &= -15;
                                    d2 = 0.0d;
                                }
                                if ((i3 & 2048) != 0) {
                                    ColorSpec$SpecVersion.Companion.getClass();
                                    i23 &= -113;
                                    colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                                } else {
                                    colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                                }
                                int i316 = i25;
                                i26 = i23;
                                colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                                if ((i3 & 4096) != 0) {
                                    DynamicScheme.Platform.Companion.getClass();
                                    i26 &= -897;
                                    platform3 = DynamicScheme.Platform.Default;
                                } else {
                                    platform3 = platform;
                                }
                                DynamicScheme.Platform platform12 = platform3;
                                if ((i3 & 8192) != 0) {
                                    shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                    i26 &= -7169;
                                } else {
                                    shapes2 = shapes;
                                }
                                i27 = i26;
                                if ((i3 & 16384) != 0) {
                                    typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                    i28 = i27 & (-57345);
                                } else {
                                    i28 = i27;
                                    typography3 = typography;
                                }
                                if (i24 == 0) {
                                }
                                if ((i3 & 65536) != 0) {
                                    i28 &= -3670017;
                                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                                } else {
                                    defaultColorSpring = finiteAnimationSpec;
                                }
                                platform2 = platform12;
                                typography4 = typography3;
                                i29 = i28;
                                double d12 = d2;
                                i30 = i316;
                                z9 = zIsSystemInDarkTheme;
                                color18 = color9;
                                color19 = color17;
                                d3 = d12;
                            }
                            gapComposer2.endDefaults();
                            gapComposer = gapComposer2;
                            boolean z14 = z8;
                            FiniteAnimationSpec finiteAnimationSpec7 = defaultColorSpring;
                            DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z14, finiteAnimationSpec7, function2, gapComposer, (i29 >> 6) & 524272, 0);
                            finiteAnimationSpec2 = finiteAnimationSpec7;
                            color13 = color7;
                            color16 = color10;
                            paletteStyle2 = paletteStyle3;
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                            typography2 = typography4;
                            z6 = z14;
                            z5 = z7;
                            color15 = color18;
                            zIsSystemInDarkTheme = z9;
                            color14 = color8;
                            color11 = color19;
                        } else {
                            gapComposer = gapComposer2;
                            gapComposer.skipToGroupEnd();
                            z5 = z2;
                            color11 = color5;
                            color12 = color6;
                            platform2 = platform;
                            shapes2 = shapes;
                            typography2 = typography;
                            z6 = z3;
                            finiteAnimationSpec2 = finiteAnimationSpec;
                            d3 = d2;
                            color13 = color7;
                            color14 = color8;
                            color15 = color9;
                            color16 = color10;
                            paletteStyle2 = paletteStyle;
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        }
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                        }
                    }
                    i4 |= 805306368;
                    i20 = i20;
                    if ((i2 & 6) == 0) {
                        if ((i3 & 1024) == 0) {
                            i22 = i4;
                            d2 = d;
                            if (gapComposer2.changed(d2)) {
                            }
                            i23 = i2 | i35;
                        } else {
                            i22 = i4;
                            d2 = d;
                        }
                        i23 = i2 | i35;
                    } else {
                        i22 = i4;
                        d2 = d;
                        i23 = i2;
                    }
                    if ((i2 & 48) != 0) {
                        if ((i3 & 2048) != 0) {
                            i32 = 16;
                        } else {
                            if (colorSpec$SpecVersion == null) {
                                iOrdinal2 = -1;
                            } else {
                                iOrdinal2 = colorSpec$SpecVersion.ordinal();
                            }
                            if (gapComposer2.changed(iOrdinal2)) {
                                i32 = 32;
                            } else {
                                i32 = 16;
                            }
                        }
                        i23 |= i32;
                    }
                    if ((i2 & 384) == 0) {
                        if ((i3 & 4096) != 0) {
                            i31 = 128;
                        } else {
                            if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                                i31 = 256;
                            } else {
                                i31 = 128;
                            }
                        }
                        i23 |= i31;
                    }
                    if ((i2 & 3072) != 0) {
                        if ((i3 & 8192) == 0) {
                            i6 = 2048;
                        }
                        i23 |= i6;
                    }
                    if ((i2 & 24576) != 0) {
                        if ((i3 & 16384) == 0) {
                            i9 = 16384;
                        }
                        i23 |= i9;
                    }
                    i24 = i3 & 32768;
                    if (i24 != 0) {
                        i23 |= 196608;
                    } else if ((i2 & 196608) == 0) {
                        i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                    }
                    if ((i2 & 1572864) == 0) {
                        if ((i3 & 65536) == 0) {
                            if ((i2 & 2097152) == 0) {
                                zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                            } else {
                                zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                            }
                            if (zChangedInstance) {
                                i14 = 1048576;
                            }
                        }
                        i23 |= i14;
                    }
                    if ((i2 & 12582912) == 0) {
                        i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                    }
                    if ((i22 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                        gapComposer2.startDefaults();
                        if ((i & 1) != 0) {
                            if ((i3 & 2) != 0) {
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                i25 = i22 & (-113);
                            } else {
                                i25 = i22;
                            }
                            if (i34 != 0) {
                                z7 = false;
                            } else {
                                z7 = z2;
                            }
                            if (i5 != 0) {
                                color7 = null;
                            }
                            if (i8 != 0) {
                                color8 = null;
                            }
                            if (i11 != 0) {
                                color9 = null;
                            }
                            if (i13 != 0) {
                                color10 = null;
                            }
                            if (i16 != 0) {
                                color17 = null;
                            } else {
                                color17 = color5;
                            }
                            if (i18 == 0) {
                            }
                            if (i20 != 0) {
                                paletteStyle3 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle3 = paletteStyle;
                            }
                            if ((i3 & 1024) != 0) {
                                i23 &= -15;
                                d2 = 0.0d;
                            }
                            if ((i3 & 2048) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i23 &= -113;
                                colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                            }
                            int i317 = i25;
                            i26 = i23;
                            colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                            if ((i3 & 4096) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i26 &= -897;
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                platform3 = platform;
                            }
                            DynamicScheme.Platform platform13 = platform3;
                            if ((i3 & 8192) != 0) {
                                shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i26 &= -7169;
                            } else {
                                shapes2 = shapes;
                            }
                            i27 = i26;
                            if ((i3 & 16384) != 0) {
                                typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i28 = i27 & (-57345);
                            } else {
                                i28 = i27;
                                typography3 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 65536) != 0) {
                                i28 &= -3670017;
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                            }
                            platform2 = platform13;
                            typography4 = typography3;
                            i29 = i28;
                            double d13 = d2;
                            i30 = i317;
                            z9 = zIsSystemInDarkTheme;
                            color18 = color9;
                            color19 = color17;
                            d3 = d13;
                        } else {
                            if ((i3 & 2) != 0) {
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                i25 = i22 & (-113);
                            } else {
                                i25 = i22;
                            }
                            if (i34 != 0) {
                                z7 = false;
                            } else {
                                z7 = z2;
                            }
                            if (i5 != 0) {
                                color7 = null;
                            }
                            if (i8 != 0) {
                                color8 = null;
                            }
                            if (i11 != 0) {
                                color9 = null;
                            }
                            if (i13 != 0) {
                                color10 = null;
                            }
                            if (i16 != 0) {
                                color17 = null;
                            } else {
                                color17 = color5;
                            }
                            if (i18 == 0) {
                            }
                            if (i20 != 0) {
                                paletteStyle3 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle3 = paletteStyle;
                            }
                            if ((i3 & 1024) != 0) {
                                i23 &= -15;
                                d2 = 0.0d;
                            }
                            if ((i3 & 2048) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i23 &= -113;
                                colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                            }
                            int i318 = i25;
                            i26 = i23;
                            colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                            if ((i3 & 4096) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i26 &= -897;
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                platform3 = platform;
                            }
                            DynamicScheme.Platform platform14 = platform3;
                            if ((i3 & 8192) != 0) {
                                shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i26 &= -7169;
                            } else {
                                shapes2 = shapes;
                            }
                            i27 = i26;
                            if ((i3 & 16384) != 0) {
                                typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i28 = i27 & (-57345);
                            } else {
                                i28 = i27;
                                typography3 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 65536) != 0) {
                                i28 &= -3670017;
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                            }
                            platform2 = platform14;
                            typography4 = typography3;
                            i29 = i28;
                            double d14 = d2;
                            i30 = i318;
                            z9 = zIsSystemInDarkTheme;
                            color18 = color9;
                            color19 = color17;
                            d3 = d14;
                        }
                        gapComposer2.endDefaults();
                        gapComposer = gapComposer2;
                        boolean z15 = z8;
                        FiniteAnimationSpec finiteAnimationSpec8 = defaultColorSpring;
                        DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z15, finiteAnimationSpec8, function2, gapComposer, (i29 >> 6) & 524272, 0);
                        finiteAnimationSpec2 = finiteAnimationSpec8;
                        color13 = color7;
                        color16 = color10;
                        paletteStyle2 = paletteStyle3;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                        typography2 = typography4;
                        z6 = z15;
                        z5 = z7;
                        color15 = color18;
                        zIsSystemInDarkTheme = z9;
                        color14 = color8;
                        color11 = color19;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        z5 = z2;
                        color11 = color5;
                        color12 = color6;
                        platform2 = platform;
                        shapes2 = shapes;
                        typography2 = typography;
                        z6 = z3;
                        finiteAnimationSpec2 = finiteAnimationSpec;
                        d3 = d2;
                        color13 = color7;
                        color14 = color8;
                        color15 = color9;
                        color16 = color10;
                        paletteStyle2 = paletteStyle;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                    }
                }
                i4 |= 100663296;
                i20 = i3 & 512;
                if (i20 != 0) {
                    if ((i & 805306368) == 0) {
                        if (paletteStyle == null) {
                            iOrdinal = -1;
                        } else {
                            iOrdinal = paletteStyle.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal)) {
                            i21 = 536870912;
                        } else {
                            i21 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                        }
                        i4 |= i21;
                    }
                    if ((i2 & 6) == 0) {
                        if ((i3 & 1024) == 0) {
                            i22 = i4;
                            d2 = d;
                            if (gapComposer2.changed(d2)) {
                            }
                            i23 = i2 | i35;
                        } else {
                            i22 = i4;
                            d2 = d;
                        }
                        i23 = i2 | i35;
                    } else {
                        i22 = i4;
                        d2 = d;
                        i23 = i2;
                    }
                    if ((i2 & 48) != 0) {
                        if ((i3 & 2048) != 0) {
                            i32 = 16;
                        } else {
                            if (colorSpec$SpecVersion == null) {
                                iOrdinal2 = -1;
                            } else {
                                iOrdinal2 = colorSpec$SpecVersion.ordinal();
                            }
                            if (gapComposer2.changed(iOrdinal2)) {
                                i32 = 32;
                            } else {
                                i32 = 16;
                            }
                        }
                        i23 |= i32;
                    }
                    if ((i2 & 384) == 0) {
                        if ((i3 & 4096) != 0) {
                            i31 = 128;
                        } else {
                            if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                                i31 = 256;
                            } else {
                                i31 = 128;
                            }
                        }
                        i23 |= i31;
                    }
                    if ((i2 & 3072) != 0) {
                        if ((i3 & 8192) == 0) {
                            i6 = 2048;
                        }
                        i23 |= i6;
                    }
                    if ((i2 & 24576) != 0) {
                        if ((i3 & 16384) == 0) {
                            i9 = 16384;
                        }
                        i23 |= i9;
                    }
                    i24 = i3 & 32768;
                    if (i24 != 0) {
                        i23 |= 196608;
                    } else if ((i2 & 196608) == 0) {
                        i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                    }
                    if ((i2 & 1572864) == 0) {
                        if ((i3 & 65536) == 0) {
                            if ((i2 & 2097152) == 0) {
                                zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                            } else {
                                zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                            }
                            if (zChangedInstance) {
                                i14 = 1048576;
                            }
                        }
                        i23 |= i14;
                    }
                    if ((i2 & 12582912) == 0) {
                        i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                    }
                    if ((i22 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                        gapComposer2.startDefaults();
                        if ((i & 1) != 0) {
                            if ((i3 & 2) != 0) {
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                i25 = i22 & (-113);
                            } else {
                                i25 = i22;
                            }
                            if (i34 != 0) {
                                z7 = false;
                            } else {
                                z7 = z2;
                            }
                            if (i5 != 0) {
                                color7 = null;
                            }
                            if (i8 != 0) {
                                color8 = null;
                            }
                            if (i11 != 0) {
                                color9 = null;
                            }
                            if (i13 != 0) {
                                color10 = null;
                            }
                            if (i16 != 0) {
                                color17 = null;
                            } else {
                                color17 = color5;
                            }
                            if (i18 == 0) {
                            }
                            if (i20 != 0) {
                                paletteStyle3 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle3 = paletteStyle;
                            }
                            if ((i3 & 1024) != 0) {
                                i23 &= -15;
                                d2 = 0.0d;
                            }
                            if ((i3 & 2048) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i23 &= -113;
                                colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                            }
                            int i319 = i25;
                            i26 = i23;
                            colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                            if ((i3 & 4096) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i26 &= -897;
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                platform3 = platform;
                            }
                            DynamicScheme.Platform platform15 = platform3;
                            if ((i3 & 8192) != 0) {
                                shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i26 &= -7169;
                            } else {
                                shapes2 = shapes;
                            }
                            i27 = i26;
                            if ((i3 & 16384) != 0) {
                                typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i28 = i27 & (-57345);
                            } else {
                                i28 = i27;
                                typography3 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 65536) != 0) {
                                i28 &= -3670017;
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                            }
                            platform2 = platform15;
                            typography4 = typography3;
                            i29 = i28;
                            double d15 = d2;
                            i30 = i319;
                            z9 = zIsSystemInDarkTheme;
                            color18 = color9;
                            color19 = color17;
                            d3 = d15;
                        } else {
                            if ((i3 & 2) != 0) {
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                i25 = i22 & (-113);
                            } else {
                                i25 = i22;
                            }
                            if (i34 != 0) {
                                z7 = false;
                            } else {
                                z7 = z2;
                            }
                            if (i5 != 0) {
                                color7 = null;
                            }
                            if (i8 != 0) {
                                color8 = null;
                            }
                            if (i11 != 0) {
                                color9 = null;
                            }
                            if (i13 != 0) {
                                color10 = null;
                            }
                            if (i16 != 0) {
                                color17 = null;
                            } else {
                                color17 = color5;
                            }
                            if (i18 == 0) {
                            }
                            if (i20 != 0) {
                                paletteStyle3 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle3 = paletteStyle;
                            }
                            if ((i3 & 1024) != 0) {
                                i23 &= -15;
                                d2 = 0.0d;
                            }
                            if ((i3 & 2048) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i23 &= -113;
                                colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                            }
                            int i3110 = i25;
                            i26 = i23;
                            colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                            if ((i3 & 4096) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i26 &= -897;
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                platform3 = platform;
                            }
                            DynamicScheme.Platform platform16 = platform3;
                            if ((i3 & 8192) != 0) {
                                shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i26 &= -7169;
                            } else {
                                shapes2 = shapes;
                            }
                            i27 = i26;
                            if ((i3 & 16384) != 0) {
                                typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i28 = i27 & (-57345);
                            } else {
                                i28 = i27;
                                typography3 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 65536) != 0) {
                                i28 &= -3670017;
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                            }
                            platform2 = platform16;
                            typography4 = typography3;
                            i29 = i28;
                            double d16 = d2;
                            i30 = i3110;
                            z9 = zIsSystemInDarkTheme;
                            color18 = color9;
                            color19 = color17;
                            d3 = d16;
                        }
                        gapComposer2.endDefaults();
                        gapComposer = gapComposer2;
                        boolean z16 = z8;
                        FiniteAnimationSpec finiteAnimationSpec9 = defaultColorSpring;
                        DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z16, finiteAnimationSpec9, function2, gapComposer, (i29 >> 6) & 524272, 0);
                        finiteAnimationSpec2 = finiteAnimationSpec9;
                        color13 = color7;
                        color16 = color10;
                        paletteStyle2 = paletteStyle3;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                        typography2 = typography4;
                        z6 = z16;
                        z5 = z7;
                        color15 = color18;
                        zIsSystemInDarkTheme = z9;
                        color14 = color8;
                        color11 = color19;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        z5 = z2;
                        color11 = color5;
                        color12 = color6;
                        platform2 = platform;
                        shapes2 = shapes;
                        typography2 = typography;
                        z6 = z3;
                        finiteAnimationSpec2 = finiteAnimationSpec;
                        d3 = d2;
                        color13 = color7;
                        color14 = color8;
                        color15 = color9;
                        color16 = color10;
                        paletteStyle2 = paletteStyle;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                    }
                }
                i4 |= 805306368;
                i20 = i20;
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) == 0) {
                        i22 = i4;
                        d2 = d;
                        if (gapComposer2.changed(d2)) {
                        }
                        i23 = i2 | i35;
                    } else {
                        i22 = i4;
                        d2 = d;
                    }
                    i23 = i2 | i35;
                } else {
                    i22 = i4;
                    d2 = d;
                    i23 = i2;
                }
                if ((i2 & 48) != 0) {
                    if ((i3 & 2048) != 0) {
                        i32 = 16;
                    } else {
                        if (colorSpec$SpecVersion == null) {
                            iOrdinal2 = -1;
                        } else {
                            iOrdinal2 = colorSpec$SpecVersion.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal2)) {
                            i32 = 32;
                        } else {
                            i32 = 16;
                        }
                    }
                    i23 |= i32;
                }
                if ((i2 & 384) == 0) {
                    if ((i3 & 4096) != 0) {
                        i31 = 128;
                    } else {
                        if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                            i31 = 256;
                        } else {
                            i31 = 128;
                        }
                    }
                    i23 |= i31;
                }
                if ((i2 & 3072) != 0) {
                    if ((i3 & 8192) == 0) {
                        i6 = 2048;
                    }
                    i23 |= i6;
                }
                if ((i2 & 24576) != 0) {
                    if ((i3 & 16384) == 0) {
                        i9 = 16384;
                    }
                    i23 |= i9;
                }
                i24 = i3 & 32768;
                if (i24 != 0) {
                    i23 |= 196608;
                } else if ((i2 & 196608) == 0) {
                    i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                }
                if ((i2 & 1572864) == 0) {
                    if ((i3 & 65536) == 0) {
                        if ((i2 & 2097152) == 0) {
                            zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                        } else {
                            zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                        }
                        if (zChangedInstance) {
                            i14 = 1048576;
                        }
                    }
                    i23 |= i14;
                }
                if ((i2 & 12582912) == 0) {
                    i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                }
                if ((i22 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0) {
                        if ((i3 & 2) != 0) {
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            i25 = i22 & (-113);
                        } else {
                            i25 = i22;
                        }
                        if (i34 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (i5 != 0) {
                            color7 = null;
                        }
                        if (i8 != 0) {
                            color8 = null;
                        }
                        if (i11 != 0) {
                            color9 = null;
                        }
                        if (i13 != 0) {
                            color10 = null;
                        }
                        if (i16 != 0) {
                            color17 = null;
                        } else {
                            color17 = color5;
                        }
                        if (i18 == 0) {
                        }
                        if (i20 != 0) {
                            paletteStyle3 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle3 = paletteStyle;
                        }
                        if ((i3 & 1024) != 0) {
                            i23 &= -15;
                            d2 = 0.0d;
                        }
                        if ((i3 & 2048) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i23 &= -113;
                            colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                        }
                        int i3111 = i25;
                        i26 = i23;
                        colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                        if ((i3 & 4096) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i26 &= -897;
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            platform3 = platform;
                        }
                        DynamicScheme.Platform platform17 = platform3;
                        if ((i3 & 8192) != 0) {
                            shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i26 &= -7169;
                        } else {
                            shapes2 = shapes;
                        }
                        i27 = i26;
                        if ((i3 & 16384) != 0) {
                            typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i28 = i27 & (-57345);
                        } else {
                            i28 = i27;
                            typography3 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 65536) != 0) {
                            i28 &= -3670017;
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                        }
                        platform2 = platform17;
                        typography4 = typography3;
                        i29 = i28;
                        double d17 = d2;
                        i30 = i3111;
                        z9 = zIsSystemInDarkTheme;
                        color18 = color9;
                        color19 = color17;
                        d3 = d17;
                    } else {
                        if ((i3 & 2) != 0) {
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            i25 = i22 & (-113);
                        } else {
                            i25 = i22;
                        }
                        if (i34 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (i5 != 0) {
                            color7 = null;
                        }
                        if (i8 != 0) {
                            color8 = null;
                        }
                        if (i11 != 0) {
                            color9 = null;
                        }
                        if (i13 != 0) {
                            color10 = null;
                        }
                        if (i16 != 0) {
                            color17 = null;
                        } else {
                            color17 = color5;
                        }
                        if (i18 == 0) {
                        }
                        if (i20 != 0) {
                            paletteStyle3 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle3 = paletteStyle;
                        }
                        if ((i3 & 1024) != 0) {
                            i23 &= -15;
                            d2 = 0.0d;
                        }
                        if ((i3 & 2048) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i23 &= -113;
                            colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                        }
                        int i3112 = i25;
                        i26 = i23;
                        colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                        if ((i3 & 4096) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i26 &= -897;
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            platform3 = platform;
                        }
                        DynamicScheme.Platform platform18 = platform3;
                        if ((i3 & 8192) != 0) {
                            shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i26 &= -7169;
                        } else {
                            shapes2 = shapes;
                        }
                        i27 = i26;
                        if ((i3 & 16384) != 0) {
                            typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i28 = i27 & (-57345);
                        } else {
                            i28 = i27;
                            typography3 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 65536) != 0) {
                            i28 &= -3670017;
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                        }
                        platform2 = platform18;
                        typography4 = typography3;
                        i29 = i28;
                        double d18 = d2;
                        i30 = i3112;
                        z9 = zIsSystemInDarkTheme;
                        color18 = color9;
                        color19 = color17;
                        d3 = d18;
                    }
                    gapComposer2.endDefaults();
                    gapComposer = gapComposer2;
                    boolean z17 = z8;
                    FiniteAnimationSpec finiteAnimationSpec10 = defaultColorSpring;
                    DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z17, finiteAnimationSpec10, function2, gapComposer, (i29 >> 6) & 524272, 0);
                    finiteAnimationSpec2 = finiteAnimationSpec10;
                    color13 = color7;
                    color16 = color10;
                    paletteStyle2 = paletteStyle3;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                    typography2 = typography4;
                    z6 = z17;
                    z5 = z7;
                    color15 = color18;
                    zIsSystemInDarkTheme = z9;
                    color14 = color8;
                    color11 = color19;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z5 = z2;
                    color11 = color5;
                    color12 = color6;
                    platform2 = platform;
                    shapes2 = shapes;
                    typography2 = typography;
                    z6 = z3;
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    d3 = d2;
                    color13 = color7;
                    color14 = color8;
                    color15 = color9;
                    color16 = color10;
                    paletteStyle2 = paletteStyle;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                }
            }
            i4 |= 3072;
            color7 = color;
            i8 = i3 & 16;
            i9 = 8192;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    color8 = color2;
                    if (gapComposer2.changed(color8)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 32;
                if (i11 != 0) {
                    i4 |= 196608;
                    color9 = color3;
                } else {
                    color9 = color3;
                    if ((i & 196608) == 0) {
                        if (gapComposer2.changed(color9)) {
                            i12 = 131072;
                        } else {
                            i12 = 65536;
                        }
                        i4 |= i12;
                    }
                }
                i13 = i3 & 64;
                i14 = 524288;
                if (i13 != 0) {
                    i4 |= 1572864;
                    color10 = color4;
                } else {
                    color10 = color4;
                    if ((i & 1572864) == 0) {
                        if (gapComposer2.changed(color10)) {
                            i15 = 1048576;
                        } else {
                            i15 = 524288;
                        }
                        i4 |= i15;
                    }
                }
                i16 = i3 & 128;
                if (i16 != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (gapComposer2.changed(color5)) {
                        i17 = 8388608;
                    } else {
                        i17 = 4194304;
                    }
                    i4 |= i17;
                }
                i18 = i3 & 256;
                if (i18 != 0) {
                    if ((i & 100663296) == 0) {
                        if (gapComposer2.changed(color6)) {
                            i19 = 67108864;
                        } else {
                            i19 = 33554432;
                        }
                        i4 |= i19;
                    }
                    i20 = i3 & 512;
                    if (i20 != 0) {
                        if ((i & 805306368) == 0) {
                            if (paletteStyle == null) {
                                iOrdinal = -1;
                            } else {
                                iOrdinal = paletteStyle.ordinal();
                            }
                            if (gapComposer2.changed(iOrdinal)) {
                                i21 = 536870912;
                            } else {
                                i21 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                            }
                            i4 |= i21;
                        }
                        if ((i2 & 6) == 0) {
                            if ((i3 & 1024) == 0) {
                                i22 = i4;
                                d2 = d;
                                if (gapComposer2.changed(d2)) {
                                }
                                i23 = i2 | i35;
                            } else {
                                i22 = i4;
                                d2 = d;
                            }
                            i23 = i2 | i35;
                        } else {
                            i22 = i4;
                            d2 = d;
                            i23 = i2;
                        }
                        if ((i2 & 48) != 0) {
                            if ((i3 & 2048) != 0) {
                                i32 = 16;
                            } else {
                                if (colorSpec$SpecVersion == null) {
                                    iOrdinal2 = -1;
                                } else {
                                    iOrdinal2 = colorSpec$SpecVersion.ordinal();
                                }
                                if (gapComposer2.changed(iOrdinal2)) {
                                    i32 = 32;
                                } else {
                                    i32 = 16;
                                }
                            }
                            i23 |= i32;
                        }
                        if ((i2 & 384) == 0) {
                            if ((i3 & 4096) != 0) {
                                i31 = 128;
                            } else {
                                if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                                    i31 = 256;
                                } else {
                                    i31 = 128;
                                }
                            }
                            i23 |= i31;
                        }
                        if ((i2 & 3072) != 0) {
                            if ((i3 & 8192) == 0) {
                                i6 = 2048;
                            }
                            i23 |= i6;
                        }
                        if ((i2 & 24576) != 0) {
                            if ((i3 & 16384) == 0) {
                                i9 = 16384;
                            }
                            i23 |= i9;
                        }
                        i24 = i3 & 32768;
                        if (i24 != 0) {
                            i23 |= 196608;
                        } else if ((i2 & 196608) == 0) {
                            i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                        }
                        if ((i2 & 1572864) == 0) {
                            if ((i3 & 65536) == 0) {
                                if ((i2 & 2097152) == 0) {
                                    zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                                } else {
                                    zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                                }
                                if (zChangedInstance) {
                                    i14 = 1048576;
                                }
                            }
                            i23 |= i14;
                        }
                        if ((i2 & 12582912) == 0) {
                            i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                        }
                        if ((i22 & 306783379) == 306783378) {
                            z4 = true;
                        } else {
                            z4 = true;
                        }
                        if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                            gapComposer2.startDefaults();
                            if ((i & 1) != 0) {
                                if ((i3 & 2) != 0) {
                                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                    i25 = i22 & (-113);
                                } else {
                                    i25 = i22;
                                }
                                if (i34 != 0) {
                                    z7 = false;
                                } else {
                                    z7 = z2;
                                }
                                if (i5 != 0) {
                                    color7 = null;
                                }
                                if (i8 != 0) {
                                    color8 = null;
                                }
                                if (i11 != 0) {
                                    color9 = null;
                                }
                                if (i13 != 0) {
                                    color10 = null;
                                }
                                if (i16 != 0) {
                                    color17 = null;
                                } else {
                                    color17 = color5;
                                }
                                if (i18 == 0) {
                                }
                                if (i20 != 0) {
                                    paletteStyle3 = PaletteStyle.TonalSpot;
                                } else {
                                    paletteStyle3 = paletteStyle;
                                }
                                if ((i3 & 1024) != 0) {
                                    i23 &= -15;
                                    d2 = 0.0d;
                                }
                                if ((i3 & 2048) != 0) {
                                    ColorSpec$SpecVersion.Companion.getClass();
                                    i23 &= -113;
                                    colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                                } else {
                                    colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                                }
                                int i3113 = i25;
                                i26 = i23;
                                colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                                if ((i3 & 4096) != 0) {
                                    DynamicScheme.Platform.Companion.getClass();
                                    i26 &= -897;
                                    platform3 = DynamicScheme.Platform.Default;
                                } else {
                                    platform3 = platform;
                                }
                                DynamicScheme.Platform platform19 = platform3;
                                if ((i3 & 8192) != 0) {
                                    shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                    i26 &= -7169;
                                } else {
                                    shapes2 = shapes;
                                }
                                i27 = i26;
                                if ((i3 & 16384) != 0) {
                                    typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                    i28 = i27 & (-57345);
                                } else {
                                    i28 = i27;
                                    typography3 = typography;
                                }
                                if (i24 == 0) {
                                }
                                if ((i3 & 65536) != 0) {
                                    i28 &= -3670017;
                                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                                } else {
                                    defaultColorSpring = finiteAnimationSpec;
                                }
                                platform2 = platform19;
                                typography4 = typography3;
                                i29 = i28;
                                double d19 = d2;
                                i30 = i3113;
                                z9 = zIsSystemInDarkTheme;
                                color18 = color9;
                                color19 = color17;
                                d3 = d19;
                            } else {
                                if ((i3 & 2) != 0) {
                                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                    i25 = i22 & (-113);
                                } else {
                                    i25 = i22;
                                }
                                if (i34 != 0) {
                                    z7 = false;
                                } else {
                                    z7 = z2;
                                }
                                if (i5 != 0) {
                                    color7 = null;
                                }
                                if (i8 != 0) {
                                    color8 = null;
                                }
                                if (i11 != 0) {
                                    color9 = null;
                                }
                                if (i13 != 0) {
                                    color10 = null;
                                }
                                if (i16 != 0) {
                                    color17 = null;
                                } else {
                                    color17 = color5;
                                }
                                if (i18 == 0) {
                                }
                                if (i20 != 0) {
                                    paletteStyle3 = PaletteStyle.TonalSpot;
                                } else {
                                    paletteStyle3 = paletteStyle;
                                }
                                if ((i3 & 1024) != 0) {
                                    i23 &= -15;
                                    d2 = 0.0d;
                                }
                                if ((i3 & 2048) != 0) {
                                    ColorSpec$SpecVersion.Companion.getClass();
                                    i23 &= -113;
                                    colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                                } else {
                                    colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                                }
                                int i3114 = i25;
                                i26 = i23;
                                colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                                if ((i3 & 4096) != 0) {
                                    DynamicScheme.Platform.Companion.getClass();
                                    i26 &= -897;
                                    platform3 = DynamicScheme.Platform.Default;
                                } else {
                                    platform3 = platform;
                                }
                                DynamicScheme.Platform platform110 = platform3;
                                if ((i3 & 8192) != 0) {
                                    shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                    i26 &= -7169;
                                } else {
                                    shapes2 = shapes;
                                }
                                i27 = i26;
                                if ((i3 & 16384) != 0) {
                                    typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                    i28 = i27 & (-57345);
                                } else {
                                    i28 = i27;
                                    typography3 = typography;
                                }
                                if (i24 == 0) {
                                }
                                if ((i3 & 65536) != 0) {
                                    i28 &= -3670017;
                                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                                } else {
                                    defaultColorSpring = finiteAnimationSpec;
                                }
                                platform2 = platform110;
                                typography4 = typography3;
                                i29 = i28;
                                double d110 = d2;
                                i30 = i3114;
                                z9 = zIsSystemInDarkTheme;
                                color18 = color9;
                                color19 = color17;
                                d3 = d110;
                            }
                            gapComposer2.endDefaults();
                            gapComposer = gapComposer2;
                            boolean z18 = z8;
                            FiniteAnimationSpec finiteAnimationSpec11 = defaultColorSpring;
                            DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z18, finiteAnimationSpec11, function2, gapComposer, (i29 >> 6) & 524272, 0);
                            finiteAnimationSpec2 = finiteAnimationSpec11;
                            color13 = color7;
                            color16 = color10;
                            paletteStyle2 = paletteStyle3;
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                            typography2 = typography4;
                            z6 = z18;
                            z5 = z7;
                            color15 = color18;
                            zIsSystemInDarkTheme = z9;
                            color14 = color8;
                            color11 = color19;
                        } else {
                            gapComposer = gapComposer2;
                            gapComposer.skipToGroupEnd();
                            z5 = z2;
                            color11 = color5;
                            color12 = color6;
                            platform2 = platform;
                            shapes2 = shapes;
                            typography2 = typography;
                            z6 = z3;
                            finiteAnimationSpec2 = finiteAnimationSpec;
                            d3 = d2;
                            color13 = color7;
                            color14 = color8;
                            color15 = color9;
                            color16 = color10;
                            paletteStyle2 = paletteStyle;
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        }
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                        }
                    }
                    i4 |= 805306368;
                    i20 = i20;
                    if ((i2 & 6) == 0) {
                        if ((i3 & 1024) == 0) {
                            i22 = i4;
                            d2 = d;
                            if (gapComposer2.changed(d2)) {
                            }
                            i23 = i2 | i35;
                        } else {
                            i22 = i4;
                            d2 = d;
                        }
                        i23 = i2 | i35;
                    } else {
                        i22 = i4;
                        d2 = d;
                        i23 = i2;
                    }
                    if ((i2 & 48) != 0) {
                        if ((i3 & 2048) != 0) {
                            i32 = 16;
                        } else {
                            if (colorSpec$SpecVersion == null) {
                                iOrdinal2 = -1;
                            } else {
                                iOrdinal2 = colorSpec$SpecVersion.ordinal();
                            }
                            if (gapComposer2.changed(iOrdinal2)) {
                                i32 = 32;
                            } else {
                                i32 = 16;
                            }
                        }
                        i23 |= i32;
                    }
                    if ((i2 & 384) == 0) {
                        if ((i3 & 4096) != 0) {
                            i31 = 128;
                        } else {
                            if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                                i31 = 256;
                            } else {
                                i31 = 128;
                            }
                        }
                        i23 |= i31;
                    }
                    if ((i2 & 3072) != 0) {
                        if ((i3 & 8192) == 0) {
                            i6 = 2048;
                        }
                        i23 |= i6;
                    }
                    if ((i2 & 24576) != 0) {
                        if ((i3 & 16384) == 0) {
                            i9 = 16384;
                        }
                        i23 |= i9;
                    }
                    i24 = i3 & 32768;
                    if (i24 != 0) {
                        i23 |= 196608;
                    } else if ((i2 & 196608) == 0) {
                        i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                    }
                    if ((i2 & 1572864) == 0) {
                        if ((i3 & 65536) == 0) {
                            if ((i2 & 2097152) == 0) {
                                zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                            } else {
                                zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                            }
                            if (zChangedInstance) {
                                i14 = 1048576;
                            }
                        }
                        i23 |= i14;
                    }
                    if ((i2 & 12582912) == 0) {
                        i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                    }
                    if ((i22 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                        gapComposer2.startDefaults();
                        if ((i & 1) != 0) {
                            if ((i3 & 2) != 0) {
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                i25 = i22 & (-113);
                            } else {
                                i25 = i22;
                            }
                            if (i34 != 0) {
                                z7 = false;
                            } else {
                                z7 = z2;
                            }
                            if (i5 != 0) {
                                color7 = null;
                            }
                            if (i8 != 0) {
                                color8 = null;
                            }
                            if (i11 != 0) {
                                color9 = null;
                            }
                            if (i13 != 0) {
                                color10 = null;
                            }
                            if (i16 != 0) {
                                color17 = null;
                            } else {
                                color17 = color5;
                            }
                            if (i18 == 0) {
                            }
                            if (i20 != 0) {
                                paletteStyle3 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle3 = paletteStyle;
                            }
                            if ((i3 & 1024) != 0) {
                                i23 &= -15;
                                d2 = 0.0d;
                            }
                            if ((i3 & 2048) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i23 &= -113;
                                colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                            }
                            int i3115 = i25;
                            i26 = i23;
                            colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                            if ((i3 & 4096) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i26 &= -897;
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                platform3 = platform;
                            }
                            DynamicScheme.Platform platform111 = platform3;
                            if ((i3 & 8192) != 0) {
                                shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i26 &= -7169;
                            } else {
                                shapes2 = shapes;
                            }
                            i27 = i26;
                            if ((i3 & 16384) != 0) {
                                typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i28 = i27 & (-57345);
                            } else {
                                i28 = i27;
                                typography3 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 65536) != 0) {
                                i28 &= -3670017;
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                            }
                            platform2 = platform111;
                            typography4 = typography3;
                            i29 = i28;
                            double d111 = d2;
                            i30 = i3115;
                            z9 = zIsSystemInDarkTheme;
                            color18 = color9;
                            color19 = color17;
                            d3 = d111;
                        } else {
                            if ((i3 & 2) != 0) {
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                i25 = i22 & (-113);
                            } else {
                                i25 = i22;
                            }
                            if (i34 != 0) {
                                z7 = false;
                            } else {
                                z7 = z2;
                            }
                            if (i5 != 0) {
                                color7 = null;
                            }
                            if (i8 != 0) {
                                color8 = null;
                            }
                            if (i11 != 0) {
                                color9 = null;
                            }
                            if (i13 != 0) {
                                color10 = null;
                            }
                            if (i16 != 0) {
                                color17 = null;
                            } else {
                                color17 = color5;
                            }
                            if (i18 == 0) {
                            }
                            if (i20 != 0) {
                                paletteStyle3 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle3 = paletteStyle;
                            }
                            if ((i3 & 1024) != 0) {
                                i23 &= -15;
                                d2 = 0.0d;
                            }
                            if ((i3 & 2048) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i23 &= -113;
                                colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                            }
                            int i3116 = i25;
                            i26 = i23;
                            colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                            if ((i3 & 4096) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i26 &= -897;
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                platform3 = platform;
                            }
                            DynamicScheme.Platform platform112 = platform3;
                            if ((i3 & 8192) != 0) {
                                shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i26 &= -7169;
                            } else {
                                shapes2 = shapes;
                            }
                            i27 = i26;
                            if ((i3 & 16384) != 0) {
                                typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i28 = i27 & (-57345);
                            } else {
                                i28 = i27;
                                typography3 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 65536) != 0) {
                                i28 &= -3670017;
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                            }
                            platform2 = platform112;
                            typography4 = typography3;
                            i29 = i28;
                            double d112 = d2;
                            i30 = i3116;
                            z9 = zIsSystemInDarkTheme;
                            color18 = color9;
                            color19 = color17;
                            d3 = d112;
                        }
                        gapComposer2.endDefaults();
                        gapComposer = gapComposer2;
                        boolean z19 = z8;
                        FiniteAnimationSpec finiteAnimationSpec12 = defaultColorSpring;
                        DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z19, finiteAnimationSpec12, function2, gapComposer, (i29 >> 6) & 524272, 0);
                        finiteAnimationSpec2 = finiteAnimationSpec12;
                        color13 = color7;
                        color16 = color10;
                        paletteStyle2 = paletteStyle3;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                        typography2 = typography4;
                        z6 = z19;
                        z5 = z7;
                        color15 = color18;
                        zIsSystemInDarkTheme = z9;
                        color14 = color8;
                        color11 = color19;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        z5 = z2;
                        color11 = color5;
                        color12 = color6;
                        platform2 = platform;
                        shapes2 = shapes;
                        typography2 = typography;
                        z6 = z3;
                        finiteAnimationSpec2 = finiteAnimationSpec;
                        d3 = d2;
                        color13 = color7;
                        color14 = color8;
                        color15 = color9;
                        color16 = color10;
                        paletteStyle2 = paletteStyle;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                    }
                }
                i4 |= 100663296;
                i20 = i3 & 512;
                if (i20 != 0) {
                    if ((i & 805306368) == 0) {
                        if (paletteStyle == null) {
                            iOrdinal = -1;
                        } else {
                            iOrdinal = paletteStyle.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal)) {
                            i21 = 536870912;
                        } else {
                            i21 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                        }
                        i4 |= i21;
                    }
                    if ((i2 & 6) == 0) {
                        if ((i3 & 1024) == 0) {
                            i22 = i4;
                            d2 = d;
                            if (gapComposer2.changed(d2)) {
                            }
                            i23 = i2 | i35;
                        } else {
                            i22 = i4;
                            d2 = d;
                        }
                        i23 = i2 | i35;
                    } else {
                        i22 = i4;
                        d2 = d;
                        i23 = i2;
                    }
                    if ((i2 & 48) != 0) {
                        if ((i3 & 2048) != 0) {
                            i32 = 16;
                        } else {
                            if (colorSpec$SpecVersion == null) {
                                iOrdinal2 = -1;
                            } else {
                                iOrdinal2 = colorSpec$SpecVersion.ordinal();
                            }
                            if (gapComposer2.changed(iOrdinal2)) {
                                i32 = 32;
                            } else {
                                i32 = 16;
                            }
                        }
                        i23 |= i32;
                    }
                    if ((i2 & 384) == 0) {
                        if ((i3 & 4096) != 0) {
                            i31 = 128;
                        } else {
                            if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                                i31 = 256;
                            } else {
                                i31 = 128;
                            }
                        }
                        i23 |= i31;
                    }
                    if ((i2 & 3072) != 0) {
                        if ((i3 & 8192) == 0) {
                            i6 = 2048;
                        }
                        i23 |= i6;
                    }
                    if ((i2 & 24576) != 0) {
                        if ((i3 & 16384) == 0) {
                            i9 = 16384;
                        }
                        i23 |= i9;
                    }
                    i24 = i3 & 32768;
                    if (i24 != 0) {
                        i23 |= 196608;
                    } else if ((i2 & 196608) == 0) {
                        i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                    }
                    if ((i2 & 1572864) == 0) {
                        if ((i3 & 65536) == 0) {
                            if ((i2 & 2097152) == 0) {
                                zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                            } else {
                                zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                            }
                            if (zChangedInstance) {
                                i14 = 1048576;
                            }
                        }
                        i23 |= i14;
                    }
                    if ((i2 & 12582912) == 0) {
                        i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                    }
                    if ((i22 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                        gapComposer2.startDefaults();
                        if ((i & 1) != 0) {
                            if ((i3 & 2) != 0) {
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                i25 = i22 & (-113);
                            } else {
                                i25 = i22;
                            }
                            if (i34 != 0) {
                                z7 = false;
                            } else {
                                z7 = z2;
                            }
                            if (i5 != 0) {
                                color7 = null;
                            }
                            if (i8 != 0) {
                                color8 = null;
                            }
                            if (i11 != 0) {
                                color9 = null;
                            }
                            if (i13 != 0) {
                                color10 = null;
                            }
                            if (i16 != 0) {
                                color17 = null;
                            } else {
                                color17 = color5;
                            }
                            if (i18 == 0) {
                            }
                            if (i20 != 0) {
                                paletteStyle3 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle3 = paletteStyle;
                            }
                            if ((i3 & 1024) != 0) {
                                i23 &= -15;
                                d2 = 0.0d;
                            }
                            if ((i3 & 2048) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i23 &= -113;
                                colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                            }
                            int i3117 = i25;
                            i26 = i23;
                            colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                            if ((i3 & 4096) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i26 &= -897;
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                platform3 = platform;
                            }
                            DynamicScheme.Platform platform113 = platform3;
                            if ((i3 & 8192) != 0) {
                                shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i26 &= -7169;
                            } else {
                                shapes2 = shapes;
                            }
                            i27 = i26;
                            if ((i3 & 16384) != 0) {
                                typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i28 = i27 & (-57345);
                            } else {
                                i28 = i27;
                                typography3 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 65536) != 0) {
                                i28 &= -3670017;
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                            }
                            platform2 = platform113;
                            typography4 = typography3;
                            i29 = i28;
                            double d113 = d2;
                            i30 = i3117;
                            z9 = zIsSystemInDarkTheme;
                            color18 = color9;
                            color19 = color17;
                            d3 = d113;
                        } else {
                            if ((i3 & 2) != 0) {
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                i25 = i22 & (-113);
                            } else {
                                i25 = i22;
                            }
                            if (i34 != 0) {
                                z7 = false;
                            } else {
                                z7 = z2;
                            }
                            if (i5 != 0) {
                                color7 = null;
                            }
                            if (i8 != 0) {
                                color8 = null;
                            }
                            if (i11 != 0) {
                                color9 = null;
                            }
                            if (i13 != 0) {
                                color10 = null;
                            }
                            if (i16 != 0) {
                                color17 = null;
                            } else {
                                color17 = color5;
                            }
                            if (i18 == 0) {
                            }
                            if (i20 != 0) {
                                paletteStyle3 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle3 = paletteStyle;
                            }
                            if ((i3 & 1024) != 0) {
                                i23 &= -15;
                                d2 = 0.0d;
                            }
                            if ((i3 & 2048) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i23 &= -113;
                                colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                            }
                            int i3118 = i25;
                            i26 = i23;
                            colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                            if ((i3 & 4096) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i26 &= -897;
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                platform3 = platform;
                            }
                            DynamicScheme.Platform platform114 = platform3;
                            if ((i3 & 8192) != 0) {
                                shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i26 &= -7169;
                            } else {
                                shapes2 = shapes;
                            }
                            i27 = i26;
                            if ((i3 & 16384) != 0) {
                                typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i28 = i27 & (-57345);
                            } else {
                                i28 = i27;
                                typography3 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 65536) != 0) {
                                i28 &= -3670017;
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                            }
                            platform2 = platform114;
                            typography4 = typography3;
                            i29 = i28;
                            double d114 = d2;
                            i30 = i3118;
                            z9 = zIsSystemInDarkTheme;
                            color18 = color9;
                            color19 = color17;
                            d3 = d114;
                        }
                        gapComposer2.endDefaults();
                        gapComposer = gapComposer2;
                        boolean z110 = z8;
                        FiniteAnimationSpec finiteAnimationSpec13 = defaultColorSpring;
                        DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z110, finiteAnimationSpec13, function2, gapComposer, (i29 >> 6) & 524272, 0);
                        finiteAnimationSpec2 = finiteAnimationSpec13;
                        color13 = color7;
                        color16 = color10;
                        paletteStyle2 = paletteStyle3;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                        typography2 = typography4;
                        z6 = z110;
                        z5 = z7;
                        color15 = color18;
                        zIsSystemInDarkTheme = z9;
                        color14 = color8;
                        color11 = color19;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        z5 = z2;
                        color11 = color5;
                        color12 = color6;
                        platform2 = platform;
                        shapes2 = shapes;
                        typography2 = typography;
                        z6 = z3;
                        finiteAnimationSpec2 = finiteAnimationSpec;
                        d3 = d2;
                        color13 = color7;
                        color14 = color8;
                        color15 = color9;
                        color16 = color10;
                        paletteStyle2 = paletteStyle;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                    }
                }
                i4 |= 805306368;
                i20 = i20;
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) == 0) {
                        i22 = i4;
                        d2 = d;
                        if (gapComposer2.changed(d2)) {
                        }
                        i23 = i2 | i35;
                    } else {
                        i22 = i4;
                        d2 = d;
                    }
                    i23 = i2 | i35;
                } else {
                    i22 = i4;
                    d2 = d;
                    i23 = i2;
                }
                if ((i2 & 48) != 0) {
                    if ((i3 & 2048) != 0) {
                        i32 = 16;
                    } else {
                        if (colorSpec$SpecVersion == null) {
                            iOrdinal2 = -1;
                        } else {
                            iOrdinal2 = colorSpec$SpecVersion.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal2)) {
                            i32 = 32;
                        } else {
                            i32 = 16;
                        }
                    }
                    i23 |= i32;
                }
                if ((i2 & 384) == 0) {
                    if ((i3 & 4096) != 0) {
                        i31 = 128;
                    } else {
                        if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                            i31 = 256;
                        } else {
                            i31 = 128;
                        }
                    }
                    i23 |= i31;
                }
                if ((i2 & 3072) != 0) {
                    if ((i3 & 8192) == 0) {
                        i6 = 2048;
                    }
                    i23 |= i6;
                }
                if ((i2 & 24576) != 0) {
                    if ((i3 & 16384) == 0) {
                        i9 = 16384;
                    }
                    i23 |= i9;
                }
                i24 = i3 & 32768;
                if (i24 != 0) {
                    i23 |= 196608;
                } else if ((i2 & 196608) == 0) {
                    i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                }
                if ((i2 & 1572864) == 0) {
                    if ((i3 & 65536) == 0) {
                        if ((i2 & 2097152) == 0) {
                            zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                        } else {
                            zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                        }
                        if (zChangedInstance) {
                            i14 = 1048576;
                        }
                    }
                    i23 |= i14;
                }
                if ((i2 & 12582912) == 0) {
                    i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                }
                if ((i22 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0) {
                        if ((i3 & 2) != 0) {
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            i25 = i22 & (-113);
                        } else {
                            i25 = i22;
                        }
                        if (i34 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (i5 != 0) {
                            color7 = null;
                        }
                        if (i8 != 0) {
                            color8 = null;
                        }
                        if (i11 != 0) {
                            color9 = null;
                        }
                        if (i13 != 0) {
                            color10 = null;
                        }
                        if (i16 != 0) {
                            color17 = null;
                        } else {
                            color17 = color5;
                        }
                        if (i18 == 0) {
                        }
                        if (i20 != 0) {
                            paletteStyle3 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle3 = paletteStyle;
                        }
                        if ((i3 & 1024) != 0) {
                            i23 &= -15;
                            d2 = 0.0d;
                        }
                        if ((i3 & 2048) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i23 &= -113;
                            colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                        }
                        int i3119 = i25;
                        i26 = i23;
                        colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                        if ((i3 & 4096) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i26 &= -897;
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            platform3 = platform;
                        }
                        DynamicScheme.Platform platform115 = platform3;
                        if ((i3 & 8192) != 0) {
                            shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i26 &= -7169;
                        } else {
                            shapes2 = shapes;
                        }
                        i27 = i26;
                        if ((i3 & 16384) != 0) {
                            typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i28 = i27 & (-57345);
                        } else {
                            i28 = i27;
                            typography3 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 65536) != 0) {
                            i28 &= -3670017;
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                        }
                        platform2 = platform115;
                        typography4 = typography3;
                        i29 = i28;
                        double d115 = d2;
                        i30 = i3119;
                        z9 = zIsSystemInDarkTheme;
                        color18 = color9;
                        color19 = color17;
                        d3 = d115;
                    } else {
                        if ((i3 & 2) != 0) {
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            i25 = i22 & (-113);
                        } else {
                            i25 = i22;
                        }
                        if (i34 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (i5 != 0) {
                            color7 = null;
                        }
                        if (i8 != 0) {
                            color8 = null;
                        }
                        if (i11 != 0) {
                            color9 = null;
                        }
                        if (i13 != 0) {
                            color10 = null;
                        }
                        if (i16 != 0) {
                            color17 = null;
                        } else {
                            color17 = color5;
                        }
                        if (i18 == 0) {
                        }
                        if (i20 != 0) {
                            paletteStyle3 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle3 = paletteStyle;
                        }
                        if ((i3 & 1024) != 0) {
                            i23 &= -15;
                            d2 = 0.0d;
                        }
                        if ((i3 & 2048) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i23 &= -113;
                            colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                        }
                        int i31110 = i25;
                        i26 = i23;
                        colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                        if ((i3 & 4096) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i26 &= -897;
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            platform3 = platform;
                        }
                        DynamicScheme.Platform platform116 = platform3;
                        if ((i3 & 8192) != 0) {
                            shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i26 &= -7169;
                        } else {
                            shapes2 = shapes;
                        }
                        i27 = i26;
                        if ((i3 & 16384) != 0) {
                            typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i28 = i27 & (-57345);
                        } else {
                            i28 = i27;
                            typography3 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 65536) != 0) {
                            i28 &= -3670017;
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                        }
                        platform2 = platform116;
                        typography4 = typography3;
                        i29 = i28;
                        double d116 = d2;
                        i30 = i31110;
                        z9 = zIsSystemInDarkTheme;
                        color18 = color9;
                        color19 = color17;
                        d3 = d116;
                    }
                    gapComposer2.endDefaults();
                    gapComposer = gapComposer2;
                    boolean z111 = z8;
                    FiniteAnimationSpec finiteAnimationSpec14 = defaultColorSpring;
                    DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z111, finiteAnimationSpec14, function2, gapComposer, (i29 >> 6) & 524272, 0);
                    finiteAnimationSpec2 = finiteAnimationSpec14;
                    color13 = color7;
                    color16 = color10;
                    paletteStyle2 = paletteStyle3;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                    typography2 = typography4;
                    z6 = z111;
                    z5 = z7;
                    color15 = color18;
                    zIsSystemInDarkTheme = z9;
                    color14 = color8;
                    color11 = color19;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z5 = z2;
                    color11 = color5;
                    color12 = color6;
                    platform2 = platform;
                    shapes2 = shapes;
                    typography2 = typography;
                    z6 = z3;
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    d3 = d2;
                    color13 = color7;
                    color14 = color8;
                    color15 = color9;
                    color16 = color10;
                    paletteStyle2 = paletteStyle;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                }
            }
            i4 |= 24576;
            color8 = color2;
            i11 = i3 & 32;
            if (i11 != 0) {
                i4 |= 196608;
                color9 = color3;
            } else {
                color9 = color3;
                if ((i & 196608) == 0) {
                    if (gapComposer2.changed(color9)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i4 |= i12;
                }
            }
            i13 = i3 & 64;
            i14 = 524288;
            if (i13 != 0) {
                i4 |= 1572864;
                color10 = color4;
            } else {
                color10 = color4;
                if ((i & 1572864) == 0) {
                    if (gapComposer2.changed(color10)) {
                        i15 = 1048576;
                    } else {
                        i15 = 524288;
                    }
                    i4 |= i15;
                }
            }
            i16 = i3 & 128;
            if (i16 != 0) {
                i4 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (gapComposer2.changed(color5)) {
                    i17 = 8388608;
                } else {
                    i17 = 4194304;
                }
                i4 |= i17;
            }
            i18 = i3 & 256;
            if (i18 != 0) {
                if ((i & 100663296) == 0) {
                    if (gapComposer2.changed(color6)) {
                        i19 = 67108864;
                    } else {
                        i19 = 33554432;
                    }
                    i4 |= i19;
                }
                i20 = i3 & 512;
                if (i20 != 0) {
                    if ((i & 805306368) == 0) {
                        if (paletteStyle == null) {
                            iOrdinal = -1;
                        } else {
                            iOrdinal = paletteStyle.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal)) {
                            i21 = 536870912;
                        } else {
                            i21 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                        }
                        i4 |= i21;
                    }
                    if ((i2 & 6) == 0) {
                        if ((i3 & 1024) == 0) {
                            i22 = i4;
                            d2 = d;
                            if (gapComposer2.changed(d2)) {
                            }
                            i23 = i2 | i35;
                        } else {
                            i22 = i4;
                            d2 = d;
                        }
                        i23 = i2 | i35;
                    } else {
                        i22 = i4;
                        d2 = d;
                        i23 = i2;
                    }
                    if ((i2 & 48) != 0) {
                        if ((i3 & 2048) != 0) {
                            i32 = 16;
                        } else {
                            if (colorSpec$SpecVersion == null) {
                                iOrdinal2 = -1;
                            } else {
                                iOrdinal2 = colorSpec$SpecVersion.ordinal();
                            }
                            if (gapComposer2.changed(iOrdinal2)) {
                                i32 = 32;
                            } else {
                                i32 = 16;
                            }
                        }
                        i23 |= i32;
                    }
                    if ((i2 & 384) == 0) {
                        if ((i3 & 4096) != 0) {
                            i31 = 128;
                        } else {
                            if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                                i31 = 256;
                            } else {
                                i31 = 128;
                            }
                        }
                        i23 |= i31;
                    }
                    if ((i2 & 3072) != 0) {
                        if ((i3 & 8192) == 0) {
                            i6 = 2048;
                        }
                        i23 |= i6;
                    }
                    if ((i2 & 24576) != 0) {
                        if ((i3 & 16384) == 0) {
                            i9 = 16384;
                        }
                        i23 |= i9;
                    }
                    i24 = i3 & 32768;
                    if (i24 != 0) {
                        i23 |= 196608;
                    } else if ((i2 & 196608) == 0) {
                        i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                    }
                    if ((i2 & 1572864) == 0) {
                        if ((i3 & 65536) == 0) {
                            if ((i2 & 2097152) == 0) {
                                zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                            } else {
                                zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                            }
                            if (zChangedInstance) {
                                i14 = 1048576;
                            }
                        }
                        i23 |= i14;
                    }
                    if ((i2 & 12582912) == 0) {
                        i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                    }
                    if ((i22 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                        gapComposer2.startDefaults();
                        if ((i & 1) != 0) {
                            if ((i3 & 2) != 0) {
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                i25 = i22 & (-113);
                            } else {
                                i25 = i22;
                            }
                            if (i34 != 0) {
                                z7 = false;
                            } else {
                                z7 = z2;
                            }
                            if (i5 != 0) {
                                color7 = null;
                            }
                            if (i8 != 0) {
                                color8 = null;
                            }
                            if (i11 != 0) {
                                color9 = null;
                            }
                            if (i13 != 0) {
                                color10 = null;
                            }
                            if (i16 != 0) {
                                color17 = null;
                            } else {
                                color17 = color5;
                            }
                            if (i18 == 0) {
                            }
                            if (i20 != 0) {
                                paletteStyle3 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle3 = paletteStyle;
                            }
                            if ((i3 & 1024) != 0) {
                                i23 &= -15;
                                d2 = 0.0d;
                            }
                            if ((i3 & 2048) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i23 &= -113;
                                colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                            }
                            int i31111 = i25;
                            i26 = i23;
                            colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                            if ((i3 & 4096) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i26 &= -897;
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                platform3 = platform;
                            }
                            DynamicScheme.Platform platform117 = platform3;
                            if ((i3 & 8192) != 0) {
                                shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i26 &= -7169;
                            } else {
                                shapes2 = shapes;
                            }
                            i27 = i26;
                            if ((i3 & 16384) != 0) {
                                typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i28 = i27 & (-57345);
                            } else {
                                i28 = i27;
                                typography3 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 65536) != 0) {
                                i28 &= -3670017;
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                            }
                            platform2 = platform117;
                            typography4 = typography3;
                            i29 = i28;
                            double d117 = d2;
                            i30 = i31111;
                            z9 = zIsSystemInDarkTheme;
                            color18 = color9;
                            color19 = color17;
                            d3 = d117;
                        } else {
                            if ((i3 & 2) != 0) {
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                i25 = i22 & (-113);
                            } else {
                                i25 = i22;
                            }
                            if (i34 != 0) {
                                z7 = false;
                            } else {
                                z7 = z2;
                            }
                            if (i5 != 0) {
                                color7 = null;
                            }
                            if (i8 != 0) {
                                color8 = null;
                            }
                            if (i11 != 0) {
                                color9 = null;
                            }
                            if (i13 != 0) {
                                color10 = null;
                            }
                            if (i16 != 0) {
                                color17 = null;
                            } else {
                                color17 = color5;
                            }
                            if (i18 == 0) {
                            }
                            if (i20 != 0) {
                                paletteStyle3 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle3 = paletteStyle;
                            }
                            if ((i3 & 1024) != 0) {
                                i23 &= -15;
                                d2 = 0.0d;
                            }
                            if ((i3 & 2048) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i23 &= -113;
                                colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                            }
                            int i31112 = i25;
                            i26 = i23;
                            colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                            if ((i3 & 4096) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i26 &= -897;
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                platform3 = platform;
                            }
                            DynamicScheme.Platform platform118 = platform3;
                            if ((i3 & 8192) != 0) {
                                shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i26 &= -7169;
                            } else {
                                shapes2 = shapes;
                            }
                            i27 = i26;
                            if ((i3 & 16384) != 0) {
                                typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i28 = i27 & (-57345);
                            } else {
                                i28 = i27;
                                typography3 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 65536) != 0) {
                                i28 &= -3670017;
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                            }
                            platform2 = platform118;
                            typography4 = typography3;
                            i29 = i28;
                            double d118 = d2;
                            i30 = i31112;
                            z9 = zIsSystemInDarkTheme;
                            color18 = color9;
                            color19 = color17;
                            d3 = d118;
                        }
                        gapComposer2.endDefaults();
                        gapComposer = gapComposer2;
                        boolean z112 = z8;
                        FiniteAnimationSpec finiteAnimationSpec15 = defaultColorSpring;
                        DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z112, finiteAnimationSpec15, function2, gapComposer, (i29 >> 6) & 524272, 0);
                        finiteAnimationSpec2 = finiteAnimationSpec15;
                        color13 = color7;
                        color16 = color10;
                        paletteStyle2 = paletteStyle3;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                        typography2 = typography4;
                        z6 = z112;
                        z5 = z7;
                        color15 = color18;
                        zIsSystemInDarkTheme = z9;
                        color14 = color8;
                        color11 = color19;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        z5 = z2;
                        color11 = color5;
                        color12 = color6;
                        platform2 = platform;
                        shapes2 = shapes;
                        typography2 = typography;
                        z6 = z3;
                        finiteAnimationSpec2 = finiteAnimationSpec;
                        d3 = d2;
                        color13 = color7;
                        color14 = color8;
                        color15 = color9;
                        color16 = color10;
                        paletteStyle2 = paletteStyle;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                    }
                }
                i4 |= 805306368;
                i20 = i20;
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) == 0) {
                        i22 = i4;
                        d2 = d;
                        if (gapComposer2.changed(d2)) {
                        }
                        i23 = i2 | i35;
                    } else {
                        i22 = i4;
                        d2 = d;
                    }
                    i23 = i2 | i35;
                } else {
                    i22 = i4;
                    d2 = d;
                    i23 = i2;
                }
                if ((i2 & 48) != 0) {
                    if ((i3 & 2048) != 0) {
                        i32 = 16;
                    } else {
                        if (colorSpec$SpecVersion == null) {
                            iOrdinal2 = -1;
                        } else {
                            iOrdinal2 = colorSpec$SpecVersion.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal2)) {
                            i32 = 32;
                        } else {
                            i32 = 16;
                        }
                    }
                    i23 |= i32;
                }
                if ((i2 & 384) == 0) {
                    if ((i3 & 4096) != 0) {
                        i31 = 128;
                    } else {
                        if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                            i31 = 256;
                        } else {
                            i31 = 128;
                        }
                    }
                    i23 |= i31;
                }
                if ((i2 & 3072) != 0) {
                    if ((i3 & 8192) == 0) {
                        i6 = 2048;
                    }
                    i23 |= i6;
                }
                if ((i2 & 24576) != 0) {
                    if ((i3 & 16384) == 0) {
                        i9 = 16384;
                    }
                    i23 |= i9;
                }
                i24 = i3 & 32768;
                if (i24 != 0) {
                    i23 |= 196608;
                } else if ((i2 & 196608) == 0) {
                    i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                }
                if ((i2 & 1572864) == 0) {
                    if ((i3 & 65536) == 0) {
                        if ((i2 & 2097152) == 0) {
                            zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                        } else {
                            zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                        }
                        if (zChangedInstance) {
                            i14 = 1048576;
                        }
                    }
                    i23 |= i14;
                }
                if ((i2 & 12582912) == 0) {
                    i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                }
                if ((i22 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0) {
                        if ((i3 & 2) != 0) {
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            i25 = i22 & (-113);
                        } else {
                            i25 = i22;
                        }
                        if (i34 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (i5 != 0) {
                            color7 = null;
                        }
                        if (i8 != 0) {
                            color8 = null;
                        }
                        if (i11 != 0) {
                            color9 = null;
                        }
                        if (i13 != 0) {
                            color10 = null;
                        }
                        if (i16 != 0) {
                            color17 = null;
                        } else {
                            color17 = color5;
                        }
                        if (i18 == 0) {
                        }
                        if (i20 != 0) {
                            paletteStyle3 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle3 = paletteStyle;
                        }
                        if ((i3 & 1024) != 0) {
                            i23 &= -15;
                            d2 = 0.0d;
                        }
                        if ((i3 & 2048) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i23 &= -113;
                            colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                        }
                        int i31113 = i25;
                        i26 = i23;
                        colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                        if ((i3 & 4096) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i26 &= -897;
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            platform3 = platform;
                        }
                        DynamicScheme.Platform platform119 = platform3;
                        if ((i3 & 8192) != 0) {
                            shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i26 &= -7169;
                        } else {
                            shapes2 = shapes;
                        }
                        i27 = i26;
                        if ((i3 & 16384) != 0) {
                            typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i28 = i27 & (-57345);
                        } else {
                            i28 = i27;
                            typography3 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 65536) != 0) {
                            i28 &= -3670017;
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                        }
                        platform2 = platform119;
                        typography4 = typography3;
                        i29 = i28;
                        double d119 = d2;
                        i30 = i31113;
                        z9 = zIsSystemInDarkTheme;
                        color18 = color9;
                        color19 = color17;
                        d3 = d119;
                    } else {
                        if ((i3 & 2) != 0) {
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            i25 = i22 & (-113);
                        } else {
                            i25 = i22;
                        }
                        if (i34 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (i5 != 0) {
                            color7 = null;
                        }
                        if (i8 != 0) {
                            color8 = null;
                        }
                        if (i11 != 0) {
                            color9 = null;
                        }
                        if (i13 != 0) {
                            color10 = null;
                        }
                        if (i16 != 0) {
                            color17 = null;
                        } else {
                            color17 = color5;
                        }
                        if (i18 == 0) {
                        }
                        if (i20 != 0) {
                            paletteStyle3 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle3 = paletteStyle;
                        }
                        if ((i3 & 1024) != 0) {
                            i23 &= -15;
                            d2 = 0.0d;
                        }
                        if ((i3 & 2048) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i23 &= -113;
                            colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                        }
                        int i31114 = i25;
                        i26 = i23;
                        colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                        if ((i3 & 4096) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i26 &= -897;
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            platform3 = platform;
                        }
                        DynamicScheme.Platform platform1110 = platform3;
                        if ((i3 & 8192) != 0) {
                            shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i26 &= -7169;
                        } else {
                            shapes2 = shapes;
                        }
                        i27 = i26;
                        if ((i3 & 16384) != 0) {
                            typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i28 = i27 & (-57345);
                        } else {
                            i28 = i27;
                            typography3 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 65536) != 0) {
                            i28 &= -3670017;
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                        }
                        platform2 = platform1110;
                        typography4 = typography3;
                        i29 = i28;
                        double d1110 = d2;
                        i30 = i31114;
                        z9 = zIsSystemInDarkTheme;
                        color18 = color9;
                        color19 = color17;
                        d3 = d1110;
                    }
                    gapComposer2.endDefaults();
                    gapComposer = gapComposer2;
                    boolean z113 = z8;
                    FiniteAnimationSpec finiteAnimationSpec16 = defaultColorSpring;
                    DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z113, finiteAnimationSpec16, function2, gapComposer, (i29 >> 6) & 524272, 0);
                    finiteAnimationSpec2 = finiteAnimationSpec16;
                    color13 = color7;
                    color16 = color10;
                    paletteStyle2 = paletteStyle3;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                    typography2 = typography4;
                    z6 = z113;
                    z5 = z7;
                    color15 = color18;
                    zIsSystemInDarkTheme = z9;
                    color14 = color8;
                    color11 = color19;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z5 = z2;
                    color11 = color5;
                    color12 = color6;
                    platform2 = platform;
                    shapes2 = shapes;
                    typography2 = typography;
                    z6 = z3;
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    d3 = d2;
                    color13 = color7;
                    color14 = color8;
                    color15 = color9;
                    color16 = color10;
                    paletteStyle2 = paletteStyle;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                }
            }
            i4 |= 100663296;
            i20 = i3 & 512;
            if (i20 != 0) {
                if ((i & 805306368) == 0) {
                    if (paletteStyle == null) {
                        iOrdinal = -1;
                    } else {
                        iOrdinal = paletteStyle.ordinal();
                    }
                    if (gapComposer2.changed(iOrdinal)) {
                        i21 = 536870912;
                    } else {
                        i21 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                    }
                    i4 |= i21;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) == 0) {
                        i22 = i4;
                        d2 = d;
                        if (gapComposer2.changed(d2)) {
                        }
                        i23 = i2 | i35;
                    } else {
                        i22 = i4;
                        d2 = d;
                    }
                    i23 = i2 | i35;
                } else {
                    i22 = i4;
                    d2 = d;
                    i23 = i2;
                }
                if ((i2 & 48) != 0) {
                    if ((i3 & 2048) != 0) {
                        i32 = 16;
                    } else {
                        if (colorSpec$SpecVersion == null) {
                            iOrdinal2 = -1;
                        } else {
                            iOrdinal2 = colorSpec$SpecVersion.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal2)) {
                            i32 = 32;
                        } else {
                            i32 = 16;
                        }
                    }
                    i23 |= i32;
                }
                if ((i2 & 384) == 0) {
                    if ((i3 & 4096) != 0) {
                        i31 = 128;
                    } else {
                        if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                            i31 = 256;
                        } else {
                            i31 = 128;
                        }
                    }
                    i23 |= i31;
                }
                if ((i2 & 3072) != 0) {
                    if ((i3 & 8192) == 0) {
                        i6 = 2048;
                    }
                    i23 |= i6;
                }
                if ((i2 & 24576) != 0) {
                    if ((i3 & 16384) == 0) {
                        i9 = 16384;
                    }
                    i23 |= i9;
                }
                i24 = i3 & 32768;
                if (i24 != 0) {
                    i23 |= 196608;
                } else if ((i2 & 196608) == 0) {
                    i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                }
                if ((i2 & 1572864) == 0) {
                    if ((i3 & 65536) == 0) {
                        if ((i2 & 2097152) == 0) {
                            zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                        } else {
                            zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                        }
                        if (zChangedInstance) {
                            i14 = 1048576;
                        }
                    }
                    i23 |= i14;
                }
                if ((i2 & 12582912) == 0) {
                    i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                }
                if ((i22 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0) {
                        if ((i3 & 2) != 0) {
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            i25 = i22 & (-113);
                        } else {
                            i25 = i22;
                        }
                        if (i34 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (i5 != 0) {
                            color7 = null;
                        }
                        if (i8 != 0) {
                            color8 = null;
                        }
                        if (i11 != 0) {
                            color9 = null;
                        }
                        if (i13 != 0) {
                            color10 = null;
                        }
                        if (i16 != 0) {
                            color17 = null;
                        } else {
                            color17 = color5;
                        }
                        if (i18 == 0) {
                        }
                        if (i20 != 0) {
                            paletteStyle3 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle3 = paletteStyle;
                        }
                        if ((i3 & 1024) != 0) {
                            i23 &= -15;
                            d2 = 0.0d;
                        }
                        if ((i3 & 2048) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i23 &= -113;
                            colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                        }
                        int i31115 = i25;
                        i26 = i23;
                        colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                        if ((i3 & 4096) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i26 &= -897;
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            platform3 = platform;
                        }
                        DynamicScheme.Platform platform1111 = platform3;
                        if ((i3 & 8192) != 0) {
                            shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i26 &= -7169;
                        } else {
                            shapes2 = shapes;
                        }
                        i27 = i26;
                        if ((i3 & 16384) != 0) {
                            typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i28 = i27 & (-57345);
                        } else {
                            i28 = i27;
                            typography3 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 65536) != 0) {
                            i28 &= -3670017;
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                        }
                        platform2 = platform1111;
                        typography4 = typography3;
                        i29 = i28;
                        double d1111 = d2;
                        i30 = i31115;
                        z9 = zIsSystemInDarkTheme;
                        color18 = color9;
                        color19 = color17;
                        d3 = d1111;
                    } else {
                        if ((i3 & 2) != 0) {
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            i25 = i22 & (-113);
                        } else {
                            i25 = i22;
                        }
                        if (i34 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (i5 != 0) {
                            color7 = null;
                        }
                        if (i8 != 0) {
                            color8 = null;
                        }
                        if (i11 != 0) {
                            color9 = null;
                        }
                        if (i13 != 0) {
                            color10 = null;
                        }
                        if (i16 != 0) {
                            color17 = null;
                        } else {
                            color17 = color5;
                        }
                        if (i18 == 0) {
                        }
                        if (i20 != 0) {
                            paletteStyle3 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle3 = paletteStyle;
                        }
                        if ((i3 & 1024) != 0) {
                            i23 &= -15;
                            d2 = 0.0d;
                        }
                        if ((i3 & 2048) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i23 &= -113;
                            colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                        }
                        int i31116 = i25;
                        i26 = i23;
                        colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                        if ((i3 & 4096) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i26 &= -897;
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            platform3 = platform;
                        }
                        DynamicScheme.Platform platform1112 = platform3;
                        if ((i3 & 8192) != 0) {
                            shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i26 &= -7169;
                        } else {
                            shapes2 = shapes;
                        }
                        i27 = i26;
                        if ((i3 & 16384) != 0) {
                            typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i28 = i27 & (-57345);
                        } else {
                            i28 = i27;
                            typography3 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 65536) != 0) {
                            i28 &= -3670017;
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                        }
                        platform2 = platform1112;
                        typography4 = typography3;
                        i29 = i28;
                        double d1112 = d2;
                        i30 = i31116;
                        z9 = zIsSystemInDarkTheme;
                        color18 = color9;
                        color19 = color17;
                        d3 = d1112;
                    }
                    gapComposer2.endDefaults();
                    gapComposer = gapComposer2;
                    boolean z114 = z8;
                    FiniteAnimationSpec finiteAnimationSpec17 = defaultColorSpring;
                    DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z114, finiteAnimationSpec17, function2, gapComposer, (i29 >> 6) & 524272, 0);
                    finiteAnimationSpec2 = finiteAnimationSpec17;
                    color13 = color7;
                    color16 = color10;
                    paletteStyle2 = paletteStyle3;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                    typography2 = typography4;
                    z6 = z114;
                    z5 = z7;
                    color15 = color18;
                    zIsSystemInDarkTheme = z9;
                    color14 = color8;
                    color11 = color19;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z5 = z2;
                    color11 = color5;
                    color12 = color6;
                    platform2 = platform;
                    shapes2 = shapes;
                    typography2 = typography;
                    z6 = z3;
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    d3 = d2;
                    color13 = color7;
                    color14 = color8;
                    color15 = color9;
                    color16 = color10;
                    paletteStyle2 = paletteStyle;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                }
            }
            i4 |= 805306368;
            i20 = i20;
            if ((i2 & 6) == 0) {
                if ((i3 & 1024) == 0) {
                    i22 = i4;
                    d2 = d;
                    if (gapComposer2.changed(d2)) {
                    }
                    i23 = i2 | i35;
                } else {
                    i22 = i4;
                    d2 = d;
                }
                i23 = i2 | i35;
            } else {
                i22 = i4;
                d2 = d;
                i23 = i2;
            }
            if ((i2 & 48) != 0) {
                if ((i3 & 2048) != 0) {
                    i32 = 16;
                } else {
                    if (colorSpec$SpecVersion == null) {
                        iOrdinal2 = -1;
                    } else {
                        iOrdinal2 = colorSpec$SpecVersion.ordinal();
                    }
                    if (gapComposer2.changed(iOrdinal2)) {
                        i32 = 32;
                    } else {
                        i32 = 16;
                    }
                }
                i23 |= i32;
            }
            if ((i2 & 384) == 0) {
                if ((i3 & 4096) != 0) {
                    i31 = 128;
                } else {
                    if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                        i31 = 256;
                    } else {
                        i31 = 128;
                    }
                }
                i23 |= i31;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8192) == 0) {
                    i6 = 2048;
                }
                i23 |= i6;
            }
            if ((i2 & 24576) != 0) {
                if ((i3 & 16384) == 0) {
                    i9 = 16384;
                }
                i23 |= i9;
            }
            i24 = i3 & 32768;
            if (i24 != 0) {
                i23 |= 196608;
            } else if ((i2 & 196608) == 0) {
                i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
            }
            if ((i2 & 1572864) == 0) {
                if ((i3 & 65536) == 0) {
                    if ((i2 & 2097152) == 0) {
                        zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                    } else {
                        zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                    }
                    if (zChangedInstance) {
                        i14 = 1048576;
                    }
                }
                i23 |= i14;
            }
            if ((i2 & 12582912) == 0) {
                i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
            }
            if ((i22 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                gapComposer2.startDefaults();
                if ((i & 1) != 0) {
                    if ((i3 & 2) != 0) {
                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        i25 = i22 & (-113);
                    } else {
                        i25 = i22;
                    }
                    if (i34 != 0) {
                        z7 = false;
                    } else {
                        z7 = z2;
                    }
                    if (i5 != 0) {
                        color7 = null;
                    }
                    if (i8 != 0) {
                        color8 = null;
                    }
                    if (i11 != 0) {
                        color9 = null;
                    }
                    if (i13 != 0) {
                        color10 = null;
                    }
                    if (i16 != 0) {
                        color17 = null;
                    } else {
                        color17 = color5;
                    }
                    if (i18 == 0) {
                    }
                    if (i20 != 0) {
                        paletteStyle3 = PaletteStyle.TonalSpot;
                    } else {
                        paletteStyle3 = paletteStyle;
                    }
                    if ((i3 & 1024) != 0) {
                        i23 &= -15;
                        d2 = 0.0d;
                    }
                    if ((i3 & 2048) != 0) {
                        ColorSpec$SpecVersion.Companion.getClass();
                        i23 &= -113;
                        colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                    } else {
                        colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                    }
                    int i31117 = i25;
                    i26 = i23;
                    colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                    if ((i3 & 4096) != 0) {
                        DynamicScheme.Platform.Companion.getClass();
                        i26 &= -897;
                        platform3 = DynamicScheme.Platform.Default;
                    } else {
                        platform3 = platform;
                    }
                    DynamicScheme.Platform platform1113 = platform3;
                    if ((i3 & 8192) != 0) {
                        shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        i26 &= -7169;
                    } else {
                        shapes2 = shapes;
                    }
                    i27 = i26;
                    if ((i3 & 16384) != 0) {
                        typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                        i28 = i27 & (-57345);
                    } else {
                        i28 = i27;
                        typography3 = typography;
                    }
                    if (i24 == 0) {
                    }
                    if ((i3 & 65536) != 0) {
                        i28 &= -3670017;
                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                    } else {
                        defaultColorSpring = finiteAnimationSpec;
                    }
                    platform2 = platform1113;
                    typography4 = typography3;
                    i29 = i28;
                    double d1113 = d2;
                    i30 = i31117;
                    z9 = zIsSystemInDarkTheme;
                    color18 = color9;
                    color19 = color17;
                    d3 = d1113;
                } else {
                    if ((i3 & 2) != 0) {
                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        i25 = i22 & (-113);
                    } else {
                        i25 = i22;
                    }
                    if (i34 != 0) {
                        z7 = false;
                    } else {
                        z7 = z2;
                    }
                    if (i5 != 0) {
                        color7 = null;
                    }
                    if (i8 != 0) {
                        color8 = null;
                    }
                    if (i11 != 0) {
                        color9 = null;
                    }
                    if (i13 != 0) {
                        color10 = null;
                    }
                    if (i16 != 0) {
                        color17 = null;
                    } else {
                        color17 = color5;
                    }
                    if (i18 == 0) {
                    }
                    if (i20 != 0) {
                        paletteStyle3 = PaletteStyle.TonalSpot;
                    } else {
                        paletteStyle3 = paletteStyle;
                    }
                    if ((i3 & 1024) != 0) {
                        i23 &= -15;
                        d2 = 0.0d;
                    }
                    if ((i3 & 2048) != 0) {
                        ColorSpec$SpecVersion.Companion.getClass();
                        i23 &= -113;
                        colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                    } else {
                        colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                    }
                    int i31118 = i25;
                    i26 = i23;
                    colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                    if ((i3 & 4096) != 0) {
                        DynamicScheme.Platform.Companion.getClass();
                        i26 &= -897;
                        platform3 = DynamicScheme.Platform.Default;
                    } else {
                        platform3 = platform;
                    }
                    DynamicScheme.Platform platform1114 = platform3;
                    if ((i3 & 8192) != 0) {
                        shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        i26 &= -7169;
                    } else {
                        shapes2 = shapes;
                    }
                    i27 = i26;
                    if ((i3 & 16384) != 0) {
                        typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                        i28 = i27 & (-57345);
                    } else {
                        i28 = i27;
                        typography3 = typography;
                    }
                    if (i24 == 0) {
                    }
                    if ((i3 & 65536) != 0) {
                        i28 &= -3670017;
                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                    } else {
                        defaultColorSpring = finiteAnimationSpec;
                    }
                    platform2 = platform1114;
                    typography4 = typography3;
                    i29 = i28;
                    double d1114 = d2;
                    i30 = i31118;
                    z9 = zIsSystemInDarkTheme;
                    color18 = color9;
                    color19 = color17;
                    d3 = d1114;
                }
                gapComposer2.endDefaults();
                gapComposer = gapComposer2;
                boolean z115 = z8;
                FiniteAnimationSpec finiteAnimationSpec18 = defaultColorSpring;
                DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z115, finiteAnimationSpec18, function2, gapComposer, (i29 >> 6) & 524272, 0);
                finiteAnimationSpec2 = finiteAnimationSpec18;
                color13 = color7;
                color16 = color10;
                paletteStyle2 = paletteStyle3;
                colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                typography2 = typography4;
                z6 = z115;
                z5 = z7;
                color15 = color18;
                zIsSystemInDarkTheme = z9;
                color14 = color8;
                color11 = color19;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                z5 = z2;
                color11 = color5;
                color12 = color6;
                platform2 = platform;
                shapes2 = shapes;
                typography2 = typography;
                z6 = z3;
                finiteAnimationSpec2 = finiteAnimationSpec;
                d3 = d2;
                color13 = color7;
                color14 = color8;
                color15 = color9;
                color16 = color10;
                paletteStyle2 = paletteStyle;
                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
            }
        }
        i4 |= 384;
        i5 = i3 & 8;
        i6 = 1024;
        if (i5 != 0) {
            if ((i & 3072) == 0) {
                color7 = color;
                if (gapComposer2.changed(color7)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i4 |= i7;
            }
            i8 = i3 & 16;
            i9 = 8192;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    color8 = color2;
                    if (gapComposer2.changed(color8)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 32;
                if (i11 != 0) {
                    i4 |= 196608;
                    color9 = color3;
                } else {
                    color9 = color3;
                    if ((i & 196608) == 0) {
                        if (gapComposer2.changed(color9)) {
                            i12 = 131072;
                        } else {
                            i12 = 65536;
                        }
                        i4 |= i12;
                    }
                }
                i13 = i3 & 64;
                i14 = 524288;
                if (i13 != 0) {
                    i4 |= 1572864;
                    color10 = color4;
                } else {
                    color10 = color4;
                    if ((i & 1572864) == 0) {
                        if (gapComposer2.changed(color10)) {
                            i15 = 1048576;
                        } else {
                            i15 = 524288;
                        }
                        i4 |= i15;
                    }
                }
                i16 = i3 & 128;
                if (i16 != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (gapComposer2.changed(color5)) {
                        i17 = 8388608;
                    } else {
                        i17 = 4194304;
                    }
                    i4 |= i17;
                }
                i18 = i3 & 256;
                if (i18 != 0) {
                    if ((i & 100663296) == 0) {
                        if (gapComposer2.changed(color6)) {
                            i19 = 67108864;
                        } else {
                            i19 = 33554432;
                        }
                        i4 |= i19;
                    }
                    i20 = i3 & 512;
                    if (i20 != 0) {
                        if ((i & 805306368) == 0) {
                            if (paletteStyle == null) {
                                iOrdinal = -1;
                            } else {
                                iOrdinal = paletteStyle.ordinal();
                            }
                            if (gapComposer2.changed(iOrdinal)) {
                                i21 = 536870912;
                            } else {
                                i21 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                            }
                            i4 |= i21;
                        }
                        if ((i2 & 6) == 0) {
                            if ((i3 & 1024) == 0) {
                                i22 = i4;
                                d2 = d;
                                if (gapComposer2.changed(d2)) {
                                }
                                i23 = i2 | i35;
                            } else {
                                i22 = i4;
                                d2 = d;
                            }
                            i23 = i2 | i35;
                        } else {
                            i22 = i4;
                            d2 = d;
                            i23 = i2;
                        }
                        if ((i2 & 48) != 0) {
                            if ((i3 & 2048) != 0) {
                                i32 = 16;
                            } else {
                                if (colorSpec$SpecVersion == null) {
                                    iOrdinal2 = -1;
                                } else {
                                    iOrdinal2 = colorSpec$SpecVersion.ordinal();
                                }
                                if (gapComposer2.changed(iOrdinal2)) {
                                    i32 = 32;
                                } else {
                                    i32 = 16;
                                }
                            }
                            i23 |= i32;
                        }
                        if ((i2 & 384) == 0) {
                            if ((i3 & 4096) != 0) {
                                i31 = 128;
                            } else {
                                if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                                    i31 = 256;
                                } else {
                                    i31 = 128;
                                }
                            }
                            i23 |= i31;
                        }
                        if ((i2 & 3072) != 0) {
                            if ((i3 & 8192) == 0) {
                                i6 = 2048;
                            }
                            i23 |= i6;
                        }
                        if ((i2 & 24576) != 0) {
                            if ((i3 & 16384) == 0) {
                                i9 = 16384;
                            }
                            i23 |= i9;
                        }
                        i24 = i3 & 32768;
                        if (i24 != 0) {
                            i23 |= 196608;
                        } else if ((i2 & 196608) == 0) {
                            i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                        }
                        if ((i2 & 1572864) == 0) {
                            if ((i3 & 65536) == 0) {
                                if ((i2 & 2097152) == 0) {
                                    zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                                } else {
                                    zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                                }
                                if (zChangedInstance) {
                                    i14 = 1048576;
                                }
                            }
                            i23 |= i14;
                        }
                        if ((i2 & 12582912) == 0) {
                            i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                        }
                        if ((i22 & 306783379) == 306783378) {
                            z4 = true;
                        } else {
                            z4 = true;
                        }
                        if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                            gapComposer2.startDefaults();
                            if ((i & 1) != 0) {
                                if ((i3 & 2) != 0) {
                                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                    i25 = i22 & (-113);
                                } else {
                                    i25 = i22;
                                }
                                if (i34 != 0) {
                                    z7 = false;
                                } else {
                                    z7 = z2;
                                }
                                if (i5 != 0) {
                                    color7 = null;
                                }
                                if (i8 != 0) {
                                    color8 = null;
                                }
                                if (i11 != 0) {
                                    color9 = null;
                                }
                                if (i13 != 0) {
                                    color10 = null;
                                }
                                if (i16 != 0) {
                                    color17 = null;
                                } else {
                                    color17 = color5;
                                }
                                if (i18 == 0) {
                                }
                                if (i20 != 0) {
                                    paletteStyle3 = PaletteStyle.TonalSpot;
                                } else {
                                    paletteStyle3 = paletteStyle;
                                }
                                if ((i3 & 1024) != 0) {
                                    i23 &= -15;
                                    d2 = 0.0d;
                                }
                                if ((i3 & 2048) != 0) {
                                    ColorSpec$SpecVersion.Companion.getClass();
                                    i23 &= -113;
                                    colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                                } else {
                                    colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                                }
                                int i31119 = i25;
                                i26 = i23;
                                colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                                if ((i3 & 4096) != 0) {
                                    DynamicScheme.Platform.Companion.getClass();
                                    i26 &= -897;
                                    platform3 = DynamicScheme.Platform.Default;
                                } else {
                                    platform3 = platform;
                                }
                                DynamicScheme.Platform platform1115 = platform3;
                                if ((i3 & 8192) != 0) {
                                    shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                    i26 &= -7169;
                                } else {
                                    shapes2 = shapes;
                                }
                                i27 = i26;
                                if ((i3 & 16384) != 0) {
                                    typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                    i28 = i27 & (-57345);
                                } else {
                                    i28 = i27;
                                    typography3 = typography;
                                }
                                if (i24 == 0) {
                                }
                                if ((i3 & 65536) != 0) {
                                    i28 &= -3670017;
                                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                                } else {
                                    defaultColorSpring = finiteAnimationSpec;
                                }
                                platform2 = platform1115;
                                typography4 = typography3;
                                i29 = i28;
                                double d1115 = d2;
                                i30 = i31119;
                                z9 = zIsSystemInDarkTheme;
                                color18 = color9;
                                color19 = color17;
                                d3 = d1115;
                            } else {
                                if ((i3 & 2) != 0) {
                                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                    i25 = i22 & (-113);
                                } else {
                                    i25 = i22;
                                }
                                if (i34 != 0) {
                                    z7 = false;
                                } else {
                                    z7 = z2;
                                }
                                if (i5 != 0) {
                                    color7 = null;
                                }
                                if (i8 != 0) {
                                    color8 = null;
                                }
                                if (i11 != 0) {
                                    color9 = null;
                                }
                                if (i13 != 0) {
                                    color10 = null;
                                }
                                if (i16 != 0) {
                                    color17 = null;
                                } else {
                                    color17 = color5;
                                }
                                if (i18 == 0) {
                                }
                                if (i20 != 0) {
                                    paletteStyle3 = PaletteStyle.TonalSpot;
                                } else {
                                    paletteStyle3 = paletteStyle;
                                }
                                if ((i3 & 1024) != 0) {
                                    i23 &= -15;
                                    d2 = 0.0d;
                                }
                                if ((i3 & 2048) != 0) {
                                    ColorSpec$SpecVersion.Companion.getClass();
                                    i23 &= -113;
                                    colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                                } else {
                                    colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                                }
                                int i311110 = i25;
                                i26 = i23;
                                colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                                if ((i3 & 4096) != 0) {
                                    DynamicScheme.Platform.Companion.getClass();
                                    i26 &= -897;
                                    platform3 = DynamicScheme.Platform.Default;
                                } else {
                                    platform3 = platform;
                                }
                                DynamicScheme.Platform platform1116 = platform3;
                                if ((i3 & 8192) != 0) {
                                    shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                    i26 &= -7169;
                                } else {
                                    shapes2 = shapes;
                                }
                                i27 = i26;
                                if ((i3 & 16384) != 0) {
                                    typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                    i28 = i27 & (-57345);
                                } else {
                                    i28 = i27;
                                    typography3 = typography;
                                }
                                if (i24 == 0) {
                                }
                                if ((i3 & 65536) != 0) {
                                    i28 &= -3670017;
                                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                                } else {
                                    defaultColorSpring = finiteAnimationSpec;
                                }
                                platform2 = platform1116;
                                typography4 = typography3;
                                i29 = i28;
                                double d1116 = d2;
                                i30 = i311110;
                                z9 = zIsSystemInDarkTheme;
                                color18 = color9;
                                color19 = color17;
                                d3 = d1116;
                            }
                            gapComposer2.endDefaults();
                            gapComposer = gapComposer2;
                            boolean z116 = z8;
                            FiniteAnimationSpec finiteAnimationSpec19 = defaultColorSpring;
                            DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z116, finiteAnimationSpec19, function2, gapComposer, (i29 >> 6) & 524272, 0);
                            finiteAnimationSpec2 = finiteAnimationSpec19;
                            color13 = color7;
                            color16 = color10;
                            paletteStyle2 = paletteStyle3;
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                            typography2 = typography4;
                            z6 = z116;
                            z5 = z7;
                            color15 = color18;
                            zIsSystemInDarkTheme = z9;
                            color14 = color8;
                            color11 = color19;
                        } else {
                            gapComposer = gapComposer2;
                            gapComposer.skipToGroupEnd();
                            z5 = z2;
                            color11 = color5;
                            color12 = color6;
                            platform2 = platform;
                            shapes2 = shapes;
                            typography2 = typography;
                            z6 = z3;
                            finiteAnimationSpec2 = finiteAnimationSpec;
                            d3 = d2;
                            color13 = color7;
                            color14 = color8;
                            color15 = color9;
                            color16 = color10;
                            paletteStyle2 = paletteStyle;
                            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                        }
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                        }
                    }
                    i4 |= 805306368;
                    i20 = i20;
                    if ((i2 & 6) == 0) {
                        if ((i3 & 1024) == 0) {
                            i22 = i4;
                            d2 = d;
                            if (gapComposer2.changed(d2)) {
                            }
                            i23 = i2 | i35;
                        } else {
                            i22 = i4;
                            d2 = d;
                        }
                        i23 = i2 | i35;
                    } else {
                        i22 = i4;
                        d2 = d;
                        i23 = i2;
                    }
                    if ((i2 & 48) != 0) {
                        if ((i3 & 2048) != 0) {
                            i32 = 16;
                        } else {
                            if (colorSpec$SpecVersion == null) {
                                iOrdinal2 = -1;
                            } else {
                                iOrdinal2 = colorSpec$SpecVersion.ordinal();
                            }
                            if (gapComposer2.changed(iOrdinal2)) {
                                i32 = 32;
                            } else {
                                i32 = 16;
                            }
                        }
                        i23 |= i32;
                    }
                    if ((i2 & 384) == 0) {
                        if ((i3 & 4096) != 0) {
                            i31 = 128;
                        } else {
                            if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                                i31 = 256;
                            } else {
                                i31 = 128;
                            }
                        }
                        i23 |= i31;
                    }
                    if ((i2 & 3072) != 0) {
                        if ((i3 & 8192) == 0) {
                            i6 = 2048;
                        }
                        i23 |= i6;
                    }
                    if ((i2 & 24576) != 0) {
                        if ((i3 & 16384) == 0) {
                            i9 = 16384;
                        }
                        i23 |= i9;
                    }
                    i24 = i3 & 32768;
                    if (i24 != 0) {
                        i23 |= 196608;
                    } else if ((i2 & 196608) == 0) {
                        i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                    }
                    if ((i2 & 1572864) == 0) {
                        if ((i3 & 65536) == 0) {
                            if ((i2 & 2097152) == 0) {
                                zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                            } else {
                                zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                            }
                            if (zChangedInstance) {
                                i14 = 1048576;
                            }
                        }
                        i23 |= i14;
                    }
                    if ((i2 & 12582912) == 0) {
                        i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                    }
                    if ((i22 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                        gapComposer2.startDefaults();
                        if ((i & 1) != 0) {
                            if ((i3 & 2) != 0) {
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                i25 = i22 & (-113);
                            } else {
                                i25 = i22;
                            }
                            if (i34 != 0) {
                                z7 = false;
                            } else {
                                z7 = z2;
                            }
                            if (i5 != 0) {
                                color7 = null;
                            }
                            if (i8 != 0) {
                                color8 = null;
                            }
                            if (i11 != 0) {
                                color9 = null;
                            }
                            if (i13 != 0) {
                                color10 = null;
                            }
                            if (i16 != 0) {
                                color17 = null;
                            } else {
                                color17 = color5;
                            }
                            if (i18 == 0) {
                            }
                            if (i20 != 0) {
                                paletteStyle3 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle3 = paletteStyle;
                            }
                            if ((i3 & 1024) != 0) {
                                i23 &= -15;
                                d2 = 0.0d;
                            }
                            if ((i3 & 2048) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i23 &= -113;
                                colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                            }
                            int i311111 = i25;
                            i26 = i23;
                            colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                            if ((i3 & 4096) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i26 &= -897;
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                platform3 = platform;
                            }
                            DynamicScheme.Platform platform1117 = platform3;
                            if ((i3 & 8192) != 0) {
                                shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i26 &= -7169;
                            } else {
                                shapes2 = shapes;
                            }
                            i27 = i26;
                            if ((i3 & 16384) != 0) {
                                typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i28 = i27 & (-57345);
                            } else {
                                i28 = i27;
                                typography3 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 65536) != 0) {
                                i28 &= -3670017;
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                            }
                            platform2 = platform1117;
                            typography4 = typography3;
                            i29 = i28;
                            double d1117 = d2;
                            i30 = i311111;
                            z9 = zIsSystemInDarkTheme;
                            color18 = color9;
                            color19 = color17;
                            d3 = d1117;
                        } else {
                            if ((i3 & 2) != 0) {
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                i25 = i22 & (-113);
                            } else {
                                i25 = i22;
                            }
                            if (i34 != 0) {
                                z7 = false;
                            } else {
                                z7 = z2;
                            }
                            if (i5 != 0) {
                                color7 = null;
                            }
                            if (i8 != 0) {
                                color8 = null;
                            }
                            if (i11 != 0) {
                                color9 = null;
                            }
                            if (i13 != 0) {
                                color10 = null;
                            }
                            if (i16 != 0) {
                                color17 = null;
                            } else {
                                color17 = color5;
                            }
                            if (i18 == 0) {
                            }
                            if (i20 != 0) {
                                paletteStyle3 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle3 = paletteStyle;
                            }
                            if ((i3 & 1024) != 0) {
                                i23 &= -15;
                                d2 = 0.0d;
                            }
                            if ((i3 & 2048) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i23 &= -113;
                                colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                            }
                            int i311112 = i25;
                            i26 = i23;
                            colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                            if ((i3 & 4096) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i26 &= -897;
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                platform3 = platform;
                            }
                            DynamicScheme.Platform platform1118 = platform3;
                            if ((i3 & 8192) != 0) {
                                shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i26 &= -7169;
                            } else {
                                shapes2 = shapes;
                            }
                            i27 = i26;
                            if ((i3 & 16384) != 0) {
                                typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i28 = i27 & (-57345);
                            } else {
                                i28 = i27;
                                typography3 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 65536) != 0) {
                                i28 &= -3670017;
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                            }
                            platform2 = platform1118;
                            typography4 = typography3;
                            i29 = i28;
                            double d1118 = d2;
                            i30 = i311112;
                            z9 = zIsSystemInDarkTheme;
                            color18 = color9;
                            color19 = color17;
                            d3 = d1118;
                        }
                        gapComposer2.endDefaults();
                        gapComposer = gapComposer2;
                        boolean z117 = z8;
                        FiniteAnimationSpec finiteAnimationSpec110 = defaultColorSpring;
                        DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z117, finiteAnimationSpec110, function2, gapComposer, (i29 >> 6) & 524272, 0);
                        finiteAnimationSpec2 = finiteAnimationSpec110;
                        color13 = color7;
                        color16 = color10;
                        paletteStyle2 = paletteStyle3;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                        typography2 = typography4;
                        z6 = z117;
                        z5 = z7;
                        color15 = color18;
                        zIsSystemInDarkTheme = z9;
                        color14 = color8;
                        color11 = color19;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        z5 = z2;
                        color11 = color5;
                        color12 = color6;
                        platform2 = platform;
                        shapes2 = shapes;
                        typography2 = typography;
                        z6 = z3;
                        finiteAnimationSpec2 = finiteAnimationSpec;
                        d3 = d2;
                        color13 = color7;
                        color14 = color8;
                        color15 = color9;
                        color16 = color10;
                        paletteStyle2 = paletteStyle;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                    }
                }
                i4 |= 100663296;
                i20 = i3 & 512;
                if (i20 != 0) {
                    if ((i & 805306368) == 0) {
                        if (paletteStyle == null) {
                            iOrdinal = -1;
                        } else {
                            iOrdinal = paletteStyle.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal)) {
                            i21 = 536870912;
                        } else {
                            i21 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                        }
                        i4 |= i21;
                    }
                    if ((i2 & 6) == 0) {
                        if ((i3 & 1024) == 0) {
                            i22 = i4;
                            d2 = d;
                            if (gapComposer2.changed(d2)) {
                            }
                            i23 = i2 | i35;
                        } else {
                            i22 = i4;
                            d2 = d;
                        }
                        i23 = i2 | i35;
                    } else {
                        i22 = i4;
                        d2 = d;
                        i23 = i2;
                    }
                    if ((i2 & 48) != 0) {
                        if ((i3 & 2048) != 0) {
                            i32 = 16;
                        } else {
                            if (colorSpec$SpecVersion == null) {
                                iOrdinal2 = -1;
                            } else {
                                iOrdinal2 = colorSpec$SpecVersion.ordinal();
                            }
                            if (gapComposer2.changed(iOrdinal2)) {
                                i32 = 32;
                            } else {
                                i32 = 16;
                            }
                        }
                        i23 |= i32;
                    }
                    if ((i2 & 384) == 0) {
                        if ((i3 & 4096) != 0) {
                            i31 = 128;
                        } else {
                            if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                                i31 = 256;
                            } else {
                                i31 = 128;
                            }
                        }
                        i23 |= i31;
                    }
                    if ((i2 & 3072) != 0) {
                        if ((i3 & 8192) == 0) {
                            i6 = 2048;
                        }
                        i23 |= i6;
                    }
                    if ((i2 & 24576) != 0) {
                        if ((i3 & 16384) == 0) {
                            i9 = 16384;
                        }
                        i23 |= i9;
                    }
                    i24 = i3 & 32768;
                    if (i24 != 0) {
                        i23 |= 196608;
                    } else if ((i2 & 196608) == 0) {
                        i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                    }
                    if ((i2 & 1572864) == 0) {
                        if ((i3 & 65536) == 0) {
                            if ((i2 & 2097152) == 0) {
                                zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                            } else {
                                zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                            }
                            if (zChangedInstance) {
                                i14 = 1048576;
                            }
                        }
                        i23 |= i14;
                    }
                    if ((i2 & 12582912) == 0) {
                        i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                    }
                    if ((i22 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                        gapComposer2.startDefaults();
                        if ((i & 1) != 0) {
                            if ((i3 & 2) != 0) {
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                i25 = i22 & (-113);
                            } else {
                                i25 = i22;
                            }
                            if (i34 != 0) {
                                z7 = false;
                            } else {
                                z7 = z2;
                            }
                            if (i5 != 0) {
                                color7 = null;
                            }
                            if (i8 != 0) {
                                color8 = null;
                            }
                            if (i11 != 0) {
                                color9 = null;
                            }
                            if (i13 != 0) {
                                color10 = null;
                            }
                            if (i16 != 0) {
                                color17 = null;
                            } else {
                                color17 = color5;
                            }
                            if (i18 == 0) {
                            }
                            if (i20 != 0) {
                                paletteStyle3 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle3 = paletteStyle;
                            }
                            if ((i3 & 1024) != 0) {
                                i23 &= -15;
                                d2 = 0.0d;
                            }
                            if ((i3 & 2048) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i23 &= -113;
                                colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                            }
                            int i311113 = i25;
                            i26 = i23;
                            colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                            if ((i3 & 4096) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i26 &= -897;
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                platform3 = platform;
                            }
                            DynamicScheme.Platform platform1119 = platform3;
                            if ((i3 & 8192) != 0) {
                                shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i26 &= -7169;
                            } else {
                                shapes2 = shapes;
                            }
                            i27 = i26;
                            if ((i3 & 16384) != 0) {
                                typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i28 = i27 & (-57345);
                            } else {
                                i28 = i27;
                                typography3 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 65536) != 0) {
                                i28 &= -3670017;
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                            }
                            platform2 = platform1119;
                            typography4 = typography3;
                            i29 = i28;
                            double d1119 = d2;
                            i30 = i311113;
                            z9 = zIsSystemInDarkTheme;
                            color18 = color9;
                            color19 = color17;
                            d3 = d1119;
                        } else {
                            if ((i3 & 2) != 0) {
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                i25 = i22 & (-113);
                            } else {
                                i25 = i22;
                            }
                            if (i34 != 0) {
                                z7 = false;
                            } else {
                                z7 = z2;
                            }
                            if (i5 != 0) {
                                color7 = null;
                            }
                            if (i8 != 0) {
                                color8 = null;
                            }
                            if (i11 != 0) {
                                color9 = null;
                            }
                            if (i13 != 0) {
                                color10 = null;
                            }
                            if (i16 != 0) {
                                color17 = null;
                            } else {
                                color17 = color5;
                            }
                            if (i18 == 0) {
                            }
                            if (i20 != 0) {
                                paletteStyle3 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle3 = paletteStyle;
                            }
                            if ((i3 & 1024) != 0) {
                                i23 &= -15;
                                d2 = 0.0d;
                            }
                            if ((i3 & 2048) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i23 &= -113;
                                colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                            }
                            int i311114 = i25;
                            i26 = i23;
                            colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                            if ((i3 & 4096) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i26 &= -897;
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                platform3 = platform;
                            }
                            DynamicScheme.Platform platform11110 = platform3;
                            if ((i3 & 8192) != 0) {
                                shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i26 &= -7169;
                            } else {
                                shapes2 = shapes;
                            }
                            i27 = i26;
                            if ((i3 & 16384) != 0) {
                                typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i28 = i27 & (-57345);
                            } else {
                                i28 = i27;
                                typography3 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 65536) != 0) {
                                i28 &= -3670017;
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                            }
                            platform2 = platform11110;
                            typography4 = typography3;
                            i29 = i28;
                            double d11110 = d2;
                            i30 = i311114;
                            z9 = zIsSystemInDarkTheme;
                            color18 = color9;
                            color19 = color17;
                            d3 = d11110;
                        }
                        gapComposer2.endDefaults();
                        gapComposer = gapComposer2;
                        boolean z118 = z8;
                        FiniteAnimationSpec finiteAnimationSpec111 = defaultColorSpring;
                        DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z118, finiteAnimationSpec111, function2, gapComposer, (i29 >> 6) & 524272, 0);
                        finiteAnimationSpec2 = finiteAnimationSpec111;
                        color13 = color7;
                        color16 = color10;
                        paletteStyle2 = paletteStyle3;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                        typography2 = typography4;
                        z6 = z118;
                        z5 = z7;
                        color15 = color18;
                        zIsSystemInDarkTheme = z9;
                        color14 = color8;
                        color11 = color19;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        z5 = z2;
                        color11 = color5;
                        color12 = color6;
                        platform2 = platform;
                        shapes2 = shapes;
                        typography2 = typography;
                        z6 = z3;
                        finiteAnimationSpec2 = finiteAnimationSpec;
                        d3 = d2;
                        color13 = color7;
                        color14 = color8;
                        color15 = color9;
                        color16 = color10;
                        paletteStyle2 = paletteStyle;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                    }
                }
                i4 |= 805306368;
                i20 = i20;
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) == 0) {
                        i22 = i4;
                        d2 = d;
                        if (gapComposer2.changed(d2)) {
                        }
                        i23 = i2 | i35;
                    } else {
                        i22 = i4;
                        d2 = d;
                    }
                    i23 = i2 | i35;
                } else {
                    i22 = i4;
                    d2 = d;
                    i23 = i2;
                }
                if ((i2 & 48) != 0) {
                    if ((i3 & 2048) != 0) {
                        i32 = 16;
                    } else {
                        if (colorSpec$SpecVersion == null) {
                            iOrdinal2 = -1;
                        } else {
                            iOrdinal2 = colorSpec$SpecVersion.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal2)) {
                            i32 = 32;
                        } else {
                            i32 = 16;
                        }
                    }
                    i23 |= i32;
                }
                if ((i2 & 384) == 0) {
                    if ((i3 & 4096) != 0) {
                        i31 = 128;
                    } else {
                        if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                            i31 = 256;
                        } else {
                            i31 = 128;
                        }
                    }
                    i23 |= i31;
                }
                if ((i2 & 3072) != 0) {
                    if ((i3 & 8192) == 0) {
                        i6 = 2048;
                    }
                    i23 |= i6;
                }
                if ((i2 & 24576) != 0) {
                    if ((i3 & 16384) == 0) {
                        i9 = 16384;
                    }
                    i23 |= i9;
                }
                i24 = i3 & 32768;
                if (i24 != 0) {
                    i23 |= 196608;
                } else if ((i2 & 196608) == 0) {
                    i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                }
                if ((i2 & 1572864) == 0) {
                    if ((i3 & 65536) == 0) {
                        if ((i2 & 2097152) == 0) {
                            zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                        } else {
                            zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                        }
                        if (zChangedInstance) {
                            i14 = 1048576;
                        }
                    }
                    i23 |= i14;
                }
                if ((i2 & 12582912) == 0) {
                    i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                }
                if ((i22 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0) {
                        if ((i3 & 2) != 0) {
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            i25 = i22 & (-113);
                        } else {
                            i25 = i22;
                        }
                        if (i34 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (i5 != 0) {
                            color7 = null;
                        }
                        if (i8 != 0) {
                            color8 = null;
                        }
                        if (i11 != 0) {
                            color9 = null;
                        }
                        if (i13 != 0) {
                            color10 = null;
                        }
                        if (i16 != 0) {
                            color17 = null;
                        } else {
                            color17 = color5;
                        }
                        if (i18 == 0) {
                        }
                        if (i20 != 0) {
                            paletteStyle3 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle3 = paletteStyle;
                        }
                        if ((i3 & 1024) != 0) {
                            i23 &= -15;
                            d2 = 0.0d;
                        }
                        if ((i3 & 2048) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i23 &= -113;
                            colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                        }
                        int i311115 = i25;
                        i26 = i23;
                        colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                        if ((i3 & 4096) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i26 &= -897;
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            platform3 = platform;
                        }
                        DynamicScheme.Platform platform11111 = platform3;
                        if ((i3 & 8192) != 0) {
                            shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i26 &= -7169;
                        } else {
                            shapes2 = shapes;
                        }
                        i27 = i26;
                        if ((i3 & 16384) != 0) {
                            typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i28 = i27 & (-57345);
                        } else {
                            i28 = i27;
                            typography3 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 65536) != 0) {
                            i28 &= -3670017;
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                        }
                        platform2 = platform11111;
                        typography4 = typography3;
                        i29 = i28;
                        double d11111 = d2;
                        i30 = i311115;
                        z9 = zIsSystemInDarkTheme;
                        color18 = color9;
                        color19 = color17;
                        d3 = d11111;
                    } else {
                        if ((i3 & 2) != 0) {
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            i25 = i22 & (-113);
                        } else {
                            i25 = i22;
                        }
                        if (i34 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (i5 != 0) {
                            color7 = null;
                        }
                        if (i8 != 0) {
                            color8 = null;
                        }
                        if (i11 != 0) {
                            color9 = null;
                        }
                        if (i13 != 0) {
                            color10 = null;
                        }
                        if (i16 != 0) {
                            color17 = null;
                        } else {
                            color17 = color5;
                        }
                        if (i18 == 0) {
                        }
                        if (i20 != 0) {
                            paletteStyle3 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle3 = paletteStyle;
                        }
                        if ((i3 & 1024) != 0) {
                            i23 &= -15;
                            d2 = 0.0d;
                        }
                        if ((i3 & 2048) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i23 &= -113;
                            colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                        }
                        int i311116 = i25;
                        i26 = i23;
                        colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                        if ((i3 & 4096) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i26 &= -897;
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            platform3 = platform;
                        }
                        DynamicScheme.Platform platform11112 = platform3;
                        if ((i3 & 8192) != 0) {
                            shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i26 &= -7169;
                        } else {
                            shapes2 = shapes;
                        }
                        i27 = i26;
                        if ((i3 & 16384) != 0) {
                            typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i28 = i27 & (-57345);
                        } else {
                            i28 = i27;
                            typography3 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 65536) != 0) {
                            i28 &= -3670017;
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                        }
                        platform2 = platform11112;
                        typography4 = typography3;
                        i29 = i28;
                        double d11112 = d2;
                        i30 = i311116;
                        z9 = zIsSystemInDarkTheme;
                        color18 = color9;
                        color19 = color17;
                        d3 = d11112;
                    }
                    gapComposer2.endDefaults();
                    gapComposer = gapComposer2;
                    boolean z119 = z8;
                    FiniteAnimationSpec finiteAnimationSpec112 = defaultColorSpring;
                    DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z119, finiteAnimationSpec112, function2, gapComposer, (i29 >> 6) & 524272, 0);
                    finiteAnimationSpec2 = finiteAnimationSpec112;
                    color13 = color7;
                    color16 = color10;
                    paletteStyle2 = paletteStyle3;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                    typography2 = typography4;
                    z6 = z119;
                    z5 = z7;
                    color15 = color18;
                    zIsSystemInDarkTheme = z9;
                    color14 = color8;
                    color11 = color19;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z5 = z2;
                    color11 = color5;
                    color12 = color6;
                    platform2 = platform;
                    shapes2 = shapes;
                    typography2 = typography;
                    z6 = z3;
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    d3 = d2;
                    color13 = color7;
                    color14 = color8;
                    color15 = color9;
                    color16 = color10;
                    paletteStyle2 = paletteStyle;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                }
            }
            i4 |= 24576;
            color8 = color2;
            i11 = i3 & 32;
            if (i11 != 0) {
                i4 |= 196608;
                color9 = color3;
            } else {
                color9 = color3;
                if ((i & 196608) == 0) {
                    if (gapComposer2.changed(color9)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i4 |= i12;
                }
            }
            i13 = i3 & 64;
            i14 = 524288;
            if (i13 != 0) {
                i4 |= 1572864;
                color10 = color4;
            } else {
                color10 = color4;
                if ((i & 1572864) == 0) {
                    if (gapComposer2.changed(color10)) {
                        i15 = 1048576;
                    } else {
                        i15 = 524288;
                    }
                    i4 |= i15;
                }
            }
            i16 = i3 & 128;
            if (i16 != 0) {
                i4 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (gapComposer2.changed(color5)) {
                    i17 = 8388608;
                } else {
                    i17 = 4194304;
                }
                i4 |= i17;
            }
            i18 = i3 & 256;
            if (i18 != 0) {
                if ((i & 100663296) == 0) {
                    if (gapComposer2.changed(color6)) {
                        i19 = 67108864;
                    } else {
                        i19 = 33554432;
                    }
                    i4 |= i19;
                }
                i20 = i3 & 512;
                if (i20 != 0) {
                    if ((i & 805306368) == 0) {
                        if (paletteStyle == null) {
                            iOrdinal = -1;
                        } else {
                            iOrdinal = paletteStyle.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal)) {
                            i21 = 536870912;
                        } else {
                            i21 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                        }
                        i4 |= i21;
                    }
                    if ((i2 & 6) == 0) {
                        if ((i3 & 1024) == 0) {
                            i22 = i4;
                            d2 = d;
                            if (gapComposer2.changed(d2)) {
                            }
                            i23 = i2 | i35;
                        } else {
                            i22 = i4;
                            d2 = d;
                        }
                        i23 = i2 | i35;
                    } else {
                        i22 = i4;
                        d2 = d;
                        i23 = i2;
                    }
                    if ((i2 & 48) != 0) {
                        if ((i3 & 2048) != 0) {
                            i32 = 16;
                        } else {
                            if (colorSpec$SpecVersion == null) {
                                iOrdinal2 = -1;
                            } else {
                                iOrdinal2 = colorSpec$SpecVersion.ordinal();
                            }
                            if (gapComposer2.changed(iOrdinal2)) {
                                i32 = 32;
                            } else {
                                i32 = 16;
                            }
                        }
                        i23 |= i32;
                    }
                    if ((i2 & 384) == 0) {
                        if ((i3 & 4096) != 0) {
                            i31 = 128;
                        } else {
                            if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                                i31 = 256;
                            } else {
                                i31 = 128;
                            }
                        }
                        i23 |= i31;
                    }
                    if ((i2 & 3072) != 0) {
                        if ((i3 & 8192) == 0) {
                            i6 = 2048;
                        }
                        i23 |= i6;
                    }
                    if ((i2 & 24576) != 0) {
                        if ((i3 & 16384) == 0) {
                            i9 = 16384;
                        }
                        i23 |= i9;
                    }
                    i24 = i3 & 32768;
                    if (i24 != 0) {
                        i23 |= 196608;
                    } else if ((i2 & 196608) == 0) {
                        i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                    }
                    if ((i2 & 1572864) == 0) {
                        if ((i3 & 65536) == 0) {
                            if ((i2 & 2097152) == 0) {
                                zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                            } else {
                                zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                            }
                            if (zChangedInstance) {
                                i14 = 1048576;
                            }
                        }
                        i23 |= i14;
                    }
                    if ((i2 & 12582912) == 0) {
                        i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                    }
                    if ((i22 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                        gapComposer2.startDefaults();
                        if ((i & 1) != 0) {
                            if ((i3 & 2) != 0) {
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                i25 = i22 & (-113);
                            } else {
                                i25 = i22;
                            }
                            if (i34 != 0) {
                                z7 = false;
                            } else {
                                z7 = z2;
                            }
                            if (i5 != 0) {
                                color7 = null;
                            }
                            if (i8 != 0) {
                                color8 = null;
                            }
                            if (i11 != 0) {
                                color9 = null;
                            }
                            if (i13 != 0) {
                                color10 = null;
                            }
                            if (i16 != 0) {
                                color17 = null;
                            } else {
                                color17 = color5;
                            }
                            if (i18 == 0) {
                            }
                            if (i20 != 0) {
                                paletteStyle3 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle3 = paletteStyle;
                            }
                            if ((i3 & 1024) != 0) {
                                i23 &= -15;
                                d2 = 0.0d;
                            }
                            if ((i3 & 2048) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i23 &= -113;
                                colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                            }
                            int i311117 = i25;
                            i26 = i23;
                            colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                            if ((i3 & 4096) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i26 &= -897;
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                platform3 = platform;
                            }
                            DynamicScheme.Platform platform11113 = platform3;
                            if ((i3 & 8192) != 0) {
                                shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i26 &= -7169;
                            } else {
                                shapes2 = shapes;
                            }
                            i27 = i26;
                            if ((i3 & 16384) != 0) {
                                typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i28 = i27 & (-57345);
                            } else {
                                i28 = i27;
                                typography3 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 65536) != 0) {
                                i28 &= -3670017;
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                            }
                            platform2 = platform11113;
                            typography4 = typography3;
                            i29 = i28;
                            double d11113 = d2;
                            i30 = i311117;
                            z9 = zIsSystemInDarkTheme;
                            color18 = color9;
                            color19 = color17;
                            d3 = d11113;
                        } else {
                            if ((i3 & 2) != 0) {
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                i25 = i22 & (-113);
                            } else {
                                i25 = i22;
                            }
                            if (i34 != 0) {
                                z7 = false;
                            } else {
                                z7 = z2;
                            }
                            if (i5 != 0) {
                                color7 = null;
                            }
                            if (i8 != 0) {
                                color8 = null;
                            }
                            if (i11 != 0) {
                                color9 = null;
                            }
                            if (i13 != 0) {
                                color10 = null;
                            }
                            if (i16 != 0) {
                                color17 = null;
                            } else {
                                color17 = color5;
                            }
                            if (i18 == 0) {
                            }
                            if (i20 != 0) {
                                paletteStyle3 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle3 = paletteStyle;
                            }
                            if ((i3 & 1024) != 0) {
                                i23 &= -15;
                                d2 = 0.0d;
                            }
                            if ((i3 & 2048) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i23 &= -113;
                                colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                            }
                            int i311118 = i25;
                            i26 = i23;
                            colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                            if ((i3 & 4096) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i26 &= -897;
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                platform3 = platform;
                            }
                            DynamicScheme.Platform platform11114 = platform3;
                            if ((i3 & 8192) != 0) {
                                shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i26 &= -7169;
                            } else {
                                shapes2 = shapes;
                            }
                            i27 = i26;
                            if ((i3 & 16384) != 0) {
                                typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i28 = i27 & (-57345);
                            } else {
                                i28 = i27;
                                typography3 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 65536) != 0) {
                                i28 &= -3670017;
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                            }
                            platform2 = platform11114;
                            typography4 = typography3;
                            i29 = i28;
                            double d11114 = d2;
                            i30 = i311118;
                            z9 = zIsSystemInDarkTheme;
                            color18 = color9;
                            color19 = color17;
                            d3 = d11114;
                        }
                        gapComposer2.endDefaults();
                        gapComposer = gapComposer2;
                        boolean z1110 = z8;
                        FiniteAnimationSpec finiteAnimationSpec113 = defaultColorSpring;
                        DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z1110, finiteAnimationSpec113, function2, gapComposer, (i29 >> 6) & 524272, 0);
                        finiteAnimationSpec2 = finiteAnimationSpec113;
                        color13 = color7;
                        color16 = color10;
                        paletteStyle2 = paletteStyle3;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                        typography2 = typography4;
                        z6 = z1110;
                        z5 = z7;
                        color15 = color18;
                        zIsSystemInDarkTheme = z9;
                        color14 = color8;
                        color11 = color19;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        z5 = z2;
                        color11 = color5;
                        color12 = color6;
                        platform2 = platform;
                        shapes2 = shapes;
                        typography2 = typography;
                        z6 = z3;
                        finiteAnimationSpec2 = finiteAnimationSpec;
                        d3 = d2;
                        color13 = color7;
                        color14 = color8;
                        color15 = color9;
                        color16 = color10;
                        paletteStyle2 = paletteStyle;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                    }
                }
                i4 |= 805306368;
                i20 = i20;
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) == 0) {
                        i22 = i4;
                        d2 = d;
                        if (gapComposer2.changed(d2)) {
                        }
                        i23 = i2 | i35;
                    } else {
                        i22 = i4;
                        d2 = d;
                    }
                    i23 = i2 | i35;
                } else {
                    i22 = i4;
                    d2 = d;
                    i23 = i2;
                }
                if ((i2 & 48) != 0) {
                    if ((i3 & 2048) != 0) {
                        i32 = 16;
                    } else {
                        if (colorSpec$SpecVersion == null) {
                            iOrdinal2 = -1;
                        } else {
                            iOrdinal2 = colorSpec$SpecVersion.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal2)) {
                            i32 = 32;
                        } else {
                            i32 = 16;
                        }
                    }
                    i23 |= i32;
                }
                if ((i2 & 384) == 0) {
                    if ((i3 & 4096) != 0) {
                        i31 = 128;
                    } else {
                        if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                            i31 = 256;
                        } else {
                            i31 = 128;
                        }
                    }
                    i23 |= i31;
                }
                if ((i2 & 3072) != 0) {
                    if ((i3 & 8192) == 0) {
                        i6 = 2048;
                    }
                    i23 |= i6;
                }
                if ((i2 & 24576) != 0) {
                    if ((i3 & 16384) == 0) {
                        i9 = 16384;
                    }
                    i23 |= i9;
                }
                i24 = i3 & 32768;
                if (i24 != 0) {
                    i23 |= 196608;
                } else if ((i2 & 196608) == 0) {
                    i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                }
                if ((i2 & 1572864) == 0) {
                    if ((i3 & 65536) == 0) {
                        if ((i2 & 2097152) == 0) {
                            zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                        } else {
                            zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                        }
                        if (zChangedInstance) {
                            i14 = 1048576;
                        }
                    }
                    i23 |= i14;
                }
                if ((i2 & 12582912) == 0) {
                    i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                }
                if ((i22 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0) {
                        if ((i3 & 2) != 0) {
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            i25 = i22 & (-113);
                        } else {
                            i25 = i22;
                        }
                        if (i34 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (i5 != 0) {
                            color7 = null;
                        }
                        if (i8 != 0) {
                            color8 = null;
                        }
                        if (i11 != 0) {
                            color9 = null;
                        }
                        if (i13 != 0) {
                            color10 = null;
                        }
                        if (i16 != 0) {
                            color17 = null;
                        } else {
                            color17 = color5;
                        }
                        if (i18 == 0) {
                        }
                        if (i20 != 0) {
                            paletteStyle3 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle3 = paletteStyle;
                        }
                        if ((i3 & 1024) != 0) {
                            i23 &= -15;
                            d2 = 0.0d;
                        }
                        if ((i3 & 2048) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i23 &= -113;
                            colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                        }
                        int i311119 = i25;
                        i26 = i23;
                        colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                        if ((i3 & 4096) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i26 &= -897;
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            platform3 = platform;
                        }
                        DynamicScheme.Platform platform11115 = platform3;
                        if ((i3 & 8192) != 0) {
                            shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i26 &= -7169;
                        } else {
                            shapes2 = shapes;
                        }
                        i27 = i26;
                        if ((i3 & 16384) != 0) {
                            typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i28 = i27 & (-57345);
                        } else {
                            i28 = i27;
                            typography3 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 65536) != 0) {
                            i28 &= -3670017;
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                        }
                        platform2 = platform11115;
                        typography4 = typography3;
                        i29 = i28;
                        double d11115 = d2;
                        i30 = i311119;
                        z9 = zIsSystemInDarkTheme;
                        color18 = color9;
                        color19 = color17;
                        d3 = d11115;
                    } else {
                        if ((i3 & 2) != 0) {
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            i25 = i22 & (-113);
                        } else {
                            i25 = i22;
                        }
                        if (i34 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (i5 != 0) {
                            color7 = null;
                        }
                        if (i8 != 0) {
                            color8 = null;
                        }
                        if (i11 != 0) {
                            color9 = null;
                        }
                        if (i13 != 0) {
                            color10 = null;
                        }
                        if (i16 != 0) {
                            color17 = null;
                        } else {
                            color17 = color5;
                        }
                        if (i18 == 0) {
                        }
                        if (i20 != 0) {
                            paletteStyle3 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle3 = paletteStyle;
                        }
                        if ((i3 & 1024) != 0) {
                            i23 &= -15;
                            d2 = 0.0d;
                        }
                        if ((i3 & 2048) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i23 &= -113;
                            colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                        }
                        int i3111110 = i25;
                        i26 = i23;
                        colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                        if ((i3 & 4096) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i26 &= -897;
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            platform3 = platform;
                        }
                        DynamicScheme.Platform platform11116 = platform3;
                        if ((i3 & 8192) != 0) {
                            shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i26 &= -7169;
                        } else {
                            shapes2 = shapes;
                        }
                        i27 = i26;
                        if ((i3 & 16384) != 0) {
                            typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i28 = i27 & (-57345);
                        } else {
                            i28 = i27;
                            typography3 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 65536) != 0) {
                            i28 &= -3670017;
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                        }
                        platform2 = platform11116;
                        typography4 = typography3;
                        i29 = i28;
                        double d11116 = d2;
                        i30 = i3111110;
                        z9 = zIsSystemInDarkTheme;
                        color18 = color9;
                        color19 = color17;
                        d3 = d11116;
                    }
                    gapComposer2.endDefaults();
                    gapComposer = gapComposer2;
                    boolean z1111 = z8;
                    FiniteAnimationSpec finiteAnimationSpec114 = defaultColorSpring;
                    DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z1111, finiteAnimationSpec114, function2, gapComposer, (i29 >> 6) & 524272, 0);
                    finiteAnimationSpec2 = finiteAnimationSpec114;
                    color13 = color7;
                    color16 = color10;
                    paletteStyle2 = paletteStyle3;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                    typography2 = typography4;
                    z6 = z1111;
                    z5 = z7;
                    color15 = color18;
                    zIsSystemInDarkTheme = z9;
                    color14 = color8;
                    color11 = color19;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z5 = z2;
                    color11 = color5;
                    color12 = color6;
                    platform2 = platform;
                    shapes2 = shapes;
                    typography2 = typography;
                    z6 = z3;
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    d3 = d2;
                    color13 = color7;
                    color14 = color8;
                    color15 = color9;
                    color16 = color10;
                    paletteStyle2 = paletteStyle;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                }
            }
            i4 |= 100663296;
            i20 = i3 & 512;
            if (i20 != 0) {
                if ((i & 805306368) == 0) {
                    if (paletteStyle == null) {
                        iOrdinal = -1;
                    } else {
                        iOrdinal = paletteStyle.ordinal();
                    }
                    if (gapComposer2.changed(iOrdinal)) {
                        i21 = 536870912;
                    } else {
                        i21 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                    }
                    i4 |= i21;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) == 0) {
                        i22 = i4;
                        d2 = d;
                        if (gapComposer2.changed(d2)) {
                        }
                        i23 = i2 | i35;
                    } else {
                        i22 = i4;
                        d2 = d;
                    }
                    i23 = i2 | i35;
                } else {
                    i22 = i4;
                    d2 = d;
                    i23 = i2;
                }
                if ((i2 & 48) != 0) {
                    if ((i3 & 2048) != 0) {
                        i32 = 16;
                    } else {
                        if (colorSpec$SpecVersion == null) {
                            iOrdinal2 = -1;
                        } else {
                            iOrdinal2 = colorSpec$SpecVersion.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal2)) {
                            i32 = 32;
                        } else {
                            i32 = 16;
                        }
                    }
                    i23 |= i32;
                }
                if ((i2 & 384) == 0) {
                    if ((i3 & 4096) != 0) {
                        i31 = 128;
                    } else {
                        if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                            i31 = 256;
                        } else {
                            i31 = 128;
                        }
                    }
                    i23 |= i31;
                }
                if ((i2 & 3072) != 0) {
                    if ((i3 & 8192) == 0) {
                        i6 = 2048;
                    }
                    i23 |= i6;
                }
                if ((i2 & 24576) != 0) {
                    if ((i3 & 16384) == 0) {
                        i9 = 16384;
                    }
                    i23 |= i9;
                }
                i24 = i3 & 32768;
                if (i24 != 0) {
                    i23 |= 196608;
                } else if ((i2 & 196608) == 0) {
                    i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                }
                if ((i2 & 1572864) == 0) {
                    if ((i3 & 65536) == 0) {
                        if ((i2 & 2097152) == 0) {
                            zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                        } else {
                            zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                        }
                        if (zChangedInstance) {
                            i14 = 1048576;
                        }
                    }
                    i23 |= i14;
                }
                if ((i2 & 12582912) == 0) {
                    i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                }
                if ((i22 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0) {
                        if ((i3 & 2) != 0) {
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            i25 = i22 & (-113);
                        } else {
                            i25 = i22;
                        }
                        if (i34 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (i5 != 0) {
                            color7 = null;
                        }
                        if (i8 != 0) {
                            color8 = null;
                        }
                        if (i11 != 0) {
                            color9 = null;
                        }
                        if (i13 != 0) {
                            color10 = null;
                        }
                        if (i16 != 0) {
                            color17 = null;
                        } else {
                            color17 = color5;
                        }
                        if (i18 == 0) {
                        }
                        if (i20 != 0) {
                            paletteStyle3 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle3 = paletteStyle;
                        }
                        if ((i3 & 1024) != 0) {
                            i23 &= -15;
                            d2 = 0.0d;
                        }
                        if ((i3 & 2048) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i23 &= -113;
                            colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                        }
                        int i3111111 = i25;
                        i26 = i23;
                        colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                        if ((i3 & 4096) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i26 &= -897;
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            platform3 = platform;
                        }
                        DynamicScheme.Platform platform11117 = platform3;
                        if ((i3 & 8192) != 0) {
                            shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i26 &= -7169;
                        } else {
                            shapes2 = shapes;
                        }
                        i27 = i26;
                        if ((i3 & 16384) != 0) {
                            typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i28 = i27 & (-57345);
                        } else {
                            i28 = i27;
                            typography3 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 65536) != 0) {
                            i28 &= -3670017;
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                        }
                        platform2 = platform11117;
                        typography4 = typography3;
                        i29 = i28;
                        double d11117 = d2;
                        i30 = i3111111;
                        z9 = zIsSystemInDarkTheme;
                        color18 = color9;
                        color19 = color17;
                        d3 = d11117;
                    } else {
                        if ((i3 & 2) != 0) {
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            i25 = i22 & (-113);
                        } else {
                            i25 = i22;
                        }
                        if (i34 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (i5 != 0) {
                            color7 = null;
                        }
                        if (i8 != 0) {
                            color8 = null;
                        }
                        if (i11 != 0) {
                            color9 = null;
                        }
                        if (i13 != 0) {
                            color10 = null;
                        }
                        if (i16 != 0) {
                            color17 = null;
                        } else {
                            color17 = color5;
                        }
                        if (i18 == 0) {
                        }
                        if (i20 != 0) {
                            paletteStyle3 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle3 = paletteStyle;
                        }
                        if ((i3 & 1024) != 0) {
                            i23 &= -15;
                            d2 = 0.0d;
                        }
                        if ((i3 & 2048) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i23 &= -113;
                            colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                        }
                        int i3111112 = i25;
                        i26 = i23;
                        colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                        if ((i3 & 4096) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i26 &= -897;
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            platform3 = platform;
                        }
                        DynamicScheme.Platform platform11118 = platform3;
                        if ((i3 & 8192) != 0) {
                            shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i26 &= -7169;
                        } else {
                            shapes2 = shapes;
                        }
                        i27 = i26;
                        if ((i3 & 16384) != 0) {
                            typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i28 = i27 & (-57345);
                        } else {
                            i28 = i27;
                            typography3 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 65536) != 0) {
                            i28 &= -3670017;
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                        }
                        platform2 = platform11118;
                        typography4 = typography3;
                        i29 = i28;
                        double d11118 = d2;
                        i30 = i3111112;
                        z9 = zIsSystemInDarkTheme;
                        color18 = color9;
                        color19 = color17;
                        d3 = d11118;
                    }
                    gapComposer2.endDefaults();
                    gapComposer = gapComposer2;
                    boolean z1112 = z8;
                    FiniteAnimationSpec finiteAnimationSpec115 = defaultColorSpring;
                    DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z1112, finiteAnimationSpec115, function2, gapComposer, (i29 >> 6) & 524272, 0);
                    finiteAnimationSpec2 = finiteAnimationSpec115;
                    color13 = color7;
                    color16 = color10;
                    paletteStyle2 = paletteStyle3;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                    typography2 = typography4;
                    z6 = z1112;
                    z5 = z7;
                    color15 = color18;
                    zIsSystemInDarkTheme = z9;
                    color14 = color8;
                    color11 = color19;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z5 = z2;
                    color11 = color5;
                    color12 = color6;
                    platform2 = platform;
                    shapes2 = shapes;
                    typography2 = typography;
                    z6 = z3;
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    d3 = d2;
                    color13 = color7;
                    color14 = color8;
                    color15 = color9;
                    color16 = color10;
                    paletteStyle2 = paletteStyle;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                }
            }
            i4 |= 805306368;
            i20 = i20;
            if ((i2 & 6) == 0) {
                if ((i3 & 1024) == 0) {
                    i22 = i4;
                    d2 = d;
                    if (gapComposer2.changed(d2)) {
                    }
                    i23 = i2 | i35;
                } else {
                    i22 = i4;
                    d2 = d;
                }
                i23 = i2 | i35;
            } else {
                i22 = i4;
                d2 = d;
                i23 = i2;
            }
            if ((i2 & 48) != 0) {
                if ((i3 & 2048) != 0) {
                    i32 = 16;
                } else {
                    if (colorSpec$SpecVersion == null) {
                        iOrdinal2 = -1;
                    } else {
                        iOrdinal2 = colorSpec$SpecVersion.ordinal();
                    }
                    if (gapComposer2.changed(iOrdinal2)) {
                        i32 = 32;
                    } else {
                        i32 = 16;
                    }
                }
                i23 |= i32;
            }
            if ((i2 & 384) == 0) {
                if ((i3 & 4096) != 0) {
                    i31 = 128;
                } else {
                    if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                        i31 = 256;
                    } else {
                        i31 = 128;
                    }
                }
                i23 |= i31;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8192) == 0) {
                    i6 = 2048;
                }
                i23 |= i6;
            }
            if ((i2 & 24576) != 0) {
                if ((i3 & 16384) == 0) {
                    i9 = 16384;
                }
                i23 |= i9;
            }
            i24 = i3 & 32768;
            if (i24 != 0) {
                i23 |= 196608;
            } else if ((i2 & 196608) == 0) {
                i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
            }
            if ((i2 & 1572864) == 0) {
                if ((i3 & 65536) == 0) {
                    if ((i2 & 2097152) == 0) {
                        zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                    } else {
                        zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                    }
                    if (zChangedInstance) {
                        i14 = 1048576;
                    }
                }
                i23 |= i14;
            }
            if ((i2 & 12582912) == 0) {
                i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
            }
            if ((i22 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                gapComposer2.startDefaults();
                if ((i & 1) != 0) {
                    if ((i3 & 2) != 0) {
                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        i25 = i22 & (-113);
                    } else {
                        i25 = i22;
                    }
                    if (i34 != 0) {
                        z7 = false;
                    } else {
                        z7 = z2;
                    }
                    if (i5 != 0) {
                        color7 = null;
                    }
                    if (i8 != 0) {
                        color8 = null;
                    }
                    if (i11 != 0) {
                        color9 = null;
                    }
                    if (i13 != 0) {
                        color10 = null;
                    }
                    if (i16 != 0) {
                        color17 = null;
                    } else {
                        color17 = color5;
                    }
                    if (i18 == 0) {
                    }
                    if (i20 != 0) {
                        paletteStyle3 = PaletteStyle.TonalSpot;
                    } else {
                        paletteStyle3 = paletteStyle;
                    }
                    if ((i3 & 1024) != 0) {
                        i23 &= -15;
                        d2 = 0.0d;
                    }
                    if ((i3 & 2048) != 0) {
                        ColorSpec$SpecVersion.Companion.getClass();
                        i23 &= -113;
                        colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                    } else {
                        colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                    }
                    int i3111113 = i25;
                    i26 = i23;
                    colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                    if ((i3 & 4096) != 0) {
                        DynamicScheme.Platform.Companion.getClass();
                        i26 &= -897;
                        platform3 = DynamicScheme.Platform.Default;
                    } else {
                        platform3 = platform;
                    }
                    DynamicScheme.Platform platform11119 = platform3;
                    if ((i3 & 8192) != 0) {
                        shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        i26 &= -7169;
                    } else {
                        shapes2 = shapes;
                    }
                    i27 = i26;
                    if ((i3 & 16384) != 0) {
                        typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                        i28 = i27 & (-57345);
                    } else {
                        i28 = i27;
                        typography3 = typography;
                    }
                    if (i24 == 0) {
                    }
                    if ((i3 & 65536) != 0) {
                        i28 &= -3670017;
                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                    } else {
                        defaultColorSpring = finiteAnimationSpec;
                    }
                    platform2 = platform11119;
                    typography4 = typography3;
                    i29 = i28;
                    double d11119 = d2;
                    i30 = i3111113;
                    z9 = zIsSystemInDarkTheme;
                    color18 = color9;
                    color19 = color17;
                    d3 = d11119;
                } else {
                    if ((i3 & 2) != 0) {
                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        i25 = i22 & (-113);
                    } else {
                        i25 = i22;
                    }
                    if (i34 != 0) {
                        z7 = false;
                    } else {
                        z7 = z2;
                    }
                    if (i5 != 0) {
                        color7 = null;
                    }
                    if (i8 != 0) {
                        color8 = null;
                    }
                    if (i11 != 0) {
                        color9 = null;
                    }
                    if (i13 != 0) {
                        color10 = null;
                    }
                    if (i16 != 0) {
                        color17 = null;
                    } else {
                        color17 = color5;
                    }
                    if (i18 == 0) {
                    }
                    if (i20 != 0) {
                        paletteStyle3 = PaletteStyle.TonalSpot;
                    } else {
                        paletteStyle3 = paletteStyle;
                    }
                    if ((i3 & 1024) != 0) {
                        i23 &= -15;
                        d2 = 0.0d;
                    }
                    if ((i3 & 2048) != 0) {
                        ColorSpec$SpecVersion.Companion.getClass();
                        i23 &= -113;
                        colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                    } else {
                        colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                    }
                    int i3111114 = i25;
                    i26 = i23;
                    colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                    if ((i3 & 4096) != 0) {
                        DynamicScheme.Platform.Companion.getClass();
                        i26 &= -897;
                        platform3 = DynamicScheme.Platform.Default;
                    } else {
                        platform3 = platform;
                    }
                    DynamicScheme.Platform platform111110 = platform3;
                    if ((i3 & 8192) != 0) {
                        shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        i26 &= -7169;
                    } else {
                        shapes2 = shapes;
                    }
                    i27 = i26;
                    if ((i3 & 16384) != 0) {
                        typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                        i28 = i27 & (-57345);
                    } else {
                        i28 = i27;
                        typography3 = typography;
                    }
                    if (i24 == 0) {
                    }
                    if ((i3 & 65536) != 0) {
                        i28 &= -3670017;
                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                    } else {
                        defaultColorSpring = finiteAnimationSpec;
                    }
                    platform2 = platform111110;
                    typography4 = typography3;
                    i29 = i28;
                    double d111110 = d2;
                    i30 = i3111114;
                    z9 = zIsSystemInDarkTheme;
                    color18 = color9;
                    color19 = color17;
                    d3 = d111110;
                }
                gapComposer2.endDefaults();
                gapComposer = gapComposer2;
                boolean z1113 = z8;
                FiniteAnimationSpec finiteAnimationSpec116 = defaultColorSpring;
                DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z1113, finiteAnimationSpec116, function2, gapComposer, (i29 >> 6) & 524272, 0);
                finiteAnimationSpec2 = finiteAnimationSpec116;
                color13 = color7;
                color16 = color10;
                paletteStyle2 = paletteStyle3;
                colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                typography2 = typography4;
                z6 = z1113;
                z5 = z7;
                color15 = color18;
                zIsSystemInDarkTheme = z9;
                color14 = color8;
                color11 = color19;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                z5 = z2;
                color11 = color5;
                color12 = color6;
                platform2 = platform;
                shapes2 = shapes;
                typography2 = typography;
                z6 = z3;
                finiteAnimationSpec2 = finiteAnimationSpec;
                d3 = d2;
                color13 = color7;
                color14 = color8;
                color15 = color9;
                color16 = color10;
                paletteStyle2 = paletteStyle;
                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
            }
        }
        i4 |= 3072;
        color7 = color;
        i8 = i3 & 16;
        i9 = 8192;
        if (i8 != 0) {
            if ((i & 24576) == 0) {
                color8 = color2;
                if (gapComposer2.changed(color8)) {
                    i10 = 16384;
                } else {
                    i10 = 8192;
                }
                i4 |= i10;
            }
            i11 = i3 & 32;
            if (i11 != 0) {
                i4 |= 196608;
                color9 = color3;
            } else {
                color9 = color3;
                if ((i & 196608) == 0) {
                    if (gapComposer2.changed(color9)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i4 |= i12;
                }
            }
            i13 = i3 & 64;
            i14 = 524288;
            if (i13 != 0) {
                i4 |= 1572864;
                color10 = color4;
            } else {
                color10 = color4;
                if ((i & 1572864) == 0) {
                    if (gapComposer2.changed(color10)) {
                        i15 = 1048576;
                    } else {
                        i15 = 524288;
                    }
                    i4 |= i15;
                }
            }
            i16 = i3 & 128;
            if (i16 != 0) {
                i4 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (gapComposer2.changed(color5)) {
                    i17 = 8388608;
                } else {
                    i17 = 4194304;
                }
                i4 |= i17;
            }
            i18 = i3 & 256;
            if (i18 != 0) {
                if ((i & 100663296) == 0) {
                    if (gapComposer2.changed(color6)) {
                        i19 = 67108864;
                    } else {
                        i19 = 33554432;
                    }
                    i4 |= i19;
                }
                i20 = i3 & 512;
                if (i20 != 0) {
                    if ((i & 805306368) == 0) {
                        if (paletteStyle == null) {
                            iOrdinal = -1;
                        } else {
                            iOrdinal = paletteStyle.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal)) {
                            i21 = 536870912;
                        } else {
                            i21 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                        }
                        i4 |= i21;
                    }
                    if ((i2 & 6) == 0) {
                        if ((i3 & 1024) == 0) {
                            i22 = i4;
                            d2 = d;
                            if (gapComposer2.changed(d2)) {
                            }
                            i23 = i2 | i35;
                        } else {
                            i22 = i4;
                            d2 = d;
                        }
                        i23 = i2 | i35;
                    } else {
                        i22 = i4;
                        d2 = d;
                        i23 = i2;
                    }
                    if ((i2 & 48) != 0) {
                        if ((i3 & 2048) != 0) {
                            i32 = 16;
                        } else {
                            if (colorSpec$SpecVersion == null) {
                                iOrdinal2 = -1;
                            } else {
                                iOrdinal2 = colorSpec$SpecVersion.ordinal();
                            }
                            if (gapComposer2.changed(iOrdinal2)) {
                                i32 = 32;
                            } else {
                                i32 = 16;
                            }
                        }
                        i23 |= i32;
                    }
                    if ((i2 & 384) == 0) {
                        if ((i3 & 4096) != 0) {
                            i31 = 128;
                        } else {
                            if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                                i31 = 256;
                            } else {
                                i31 = 128;
                            }
                        }
                        i23 |= i31;
                    }
                    if ((i2 & 3072) != 0) {
                        if ((i3 & 8192) == 0) {
                            i6 = 2048;
                        }
                        i23 |= i6;
                    }
                    if ((i2 & 24576) != 0) {
                        if ((i3 & 16384) == 0) {
                            i9 = 16384;
                        }
                        i23 |= i9;
                    }
                    i24 = i3 & 32768;
                    if (i24 != 0) {
                        i23 |= 196608;
                    } else if ((i2 & 196608) == 0) {
                        i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                    }
                    if ((i2 & 1572864) == 0) {
                        if ((i3 & 65536) == 0) {
                            if ((i2 & 2097152) == 0) {
                                zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                            } else {
                                zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                            }
                            if (zChangedInstance) {
                                i14 = 1048576;
                            }
                        }
                        i23 |= i14;
                    }
                    if ((i2 & 12582912) == 0) {
                        i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                    }
                    if ((i22 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                        gapComposer2.startDefaults();
                        if ((i & 1) != 0) {
                            if ((i3 & 2) != 0) {
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                i25 = i22 & (-113);
                            } else {
                                i25 = i22;
                            }
                            if (i34 != 0) {
                                z7 = false;
                            } else {
                                z7 = z2;
                            }
                            if (i5 != 0) {
                                color7 = null;
                            }
                            if (i8 != 0) {
                                color8 = null;
                            }
                            if (i11 != 0) {
                                color9 = null;
                            }
                            if (i13 != 0) {
                                color10 = null;
                            }
                            if (i16 != 0) {
                                color17 = null;
                            } else {
                                color17 = color5;
                            }
                            if (i18 == 0) {
                            }
                            if (i20 != 0) {
                                paletteStyle3 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle3 = paletteStyle;
                            }
                            if ((i3 & 1024) != 0) {
                                i23 &= -15;
                                d2 = 0.0d;
                            }
                            if ((i3 & 2048) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i23 &= -113;
                                colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                            }
                            int i3111115 = i25;
                            i26 = i23;
                            colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                            if ((i3 & 4096) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i26 &= -897;
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                platform3 = platform;
                            }
                            DynamicScheme.Platform platform111111 = platform3;
                            if ((i3 & 8192) != 0) {
                                shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i26 &= -7169;
                            } else {
                                shapes2 = shapes;
                            }
                            i27 = i26;
                            if ((i3 & 16384) != 0) {
                                typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i28 = i27 & (-57345);
                            } else {
                                i28 = i27;
                                typography3 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 65536) != 0) {
                                i28 &= -3670017;
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                            }
                            platform2 = platform111111;
                            typography4 = typography3;
                            i29 = i28;
                            double d111111 = d2;
                            i30 = i3111115;
                            z9 = zIsSystemInDarkTheme;
                            color18 = color9;
                            color19 = color17;
                            d3 = d111111;
                        } else {
                            if ((i3 & 2) != 0) {
                                zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                                i25 = i22 & (-113);
                            } else {
                                i25 = i22;
                            }
                            if (i34 != 0) {
                                z7 = false;
                            } else {
                                z7 = z2;
                            }
                            if (i5 != 0) {
                                color7 = null;
                            }
                            if (i8 != 0) {
                                color8 = null;
                            }
                            if (i11 != 0) {
                                color9 = null;
                            }
                            if (i13 != 0) {
                                color10 = null;
                            }
                            if (i16 != 0) {
                                color17 = null;
                            } else {
                                color17 = color5;
                            }
                            if (i18 == 0) {
                            }
                            if (i20 != 0) {
                                paletteStyle3 = PaletteStyle.TonalSpot;
                            } else {
                                paletteStyle3 = paletteStyle;
                            }
                            if ((i3 & 1024) != 0) {
                                i23 &= -15;
                                d2 = 0.0d;
                            }
                            if ((i3 & 2048) != 0) {
                                ColorSpec$SpecVersion.Companion.getClass();
                                i23 &= -113;
                                colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                            } else {
                                colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                            }
                            int i3111116 = i25;
                            i26 = i23;
                            colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                            if ((i3 & 4096) != 0) {
                                DynamicScheme.Platform.Companion.getClass();
                                i26 &= -897;
                                platform3 = DynamicScheme.Platform.Default;
                            } else {
                                platform3 = platform;
                            }
                            DynamicScheme.Platform platform111112 = platform3;
                            if ((i3 & 8192) != 0) {
                                shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                                i26 &= -7169;
                            } else {
                                shapes2 = shapes;
                            }
                            i27 = i26;
                            if ((i3 & 16384) != 0) {
                                typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                                i28 = i27 & (-57345);
                            } else {
                                i28 = i27;
                                typography3 = typography;
                            }
                            if (i24 == 0) {
                            }
                            if ((i3 & 65536) != 0) {
                                i28 &= -3670017;
                                defaultColorSpring = ColorKt.getDefaultColorSpring();
                            } else {
                                defaultColorSpring = finiteAnimationSpec;
                            }
                            platform2 = platform111112;
                            typography4 = typography3;
                            i29 = i28;
                            double d111112 = d2;
                            i30 = i3111116;
                            z9 = zIsSystemInDarkTheme;
                            color18 = color9;
                            color19 = color17;
                            d3 = d111112;
                        }
                        gapComposer2.endDefaults();
                        gapComposer = gapComposer2;
                        boolean z1114 = z8;
                        FiniteAnimationSpec finiteAnimationSpec117 = defaultColorSpring;
                        DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z1114, finiteAnimationSpec117, function2, gapComposer, (i29 >> 6) & 524272, 0);
                        finiteAnimationSpec2 = finiteAnimationSpec117;
                        color13 = color7;
                        color16 = color10;
                        paletteStyle2 = paletteStyle3;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                        typography2 = typography4;
                        z6 = z1114;
                        z5 = z7;
                        color15 = color18;
                        zIsSystemInDarkTheme = z9;
                        color14 = color8;
                        color11 = color19;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        z5 = z2;
                        color11 = color5;
                        color12 = color6;
                        platform2 = platform;
                        shapes2 = shapes;
                        typography2 = typography;
                        z6 = z3;
                        finiteAnimationSpec2 = finiteAnimationSpec;
                        d3 = d2;
                        color13 = color7;
                        color14 = color8;
                        color15 = color9;
                        color16 = color10;
                        paletteStyle2 = paletteStyle;
                        colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                    }
                }
                i4 |= 805306368;
                i20 = i20;
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) == 0) {
                        i22 = i4;
                        d2 = d;
                        if (gapComposer2.changed(d2)) {
                        }
                        i23 = i2 | i35;
                    } else {
                        i22 = i4;
                        d2 = d;
                    }
                    i23 = i2 | i35;
                } else {
                    i22 = i4;
                    d2 = d;
                    i23 = i2;
                }
                if ((i2 & 48) != 0) {
                    if ((i3 & 2048) != 0) {
                        i32 = 16;
                    } else {
                        if (colorSpec$SpecVersion == null) {
                            iOrdinal2 = -1;
                        } else {
                            iOrdinal2 = colorSpec$SpecVersion.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal2)) {
                            i32 = 32;
                        } else {
                            i32 = 16;
                        }
                    }
                    i23 |= i32;
                }
                if ((i2 & 384) == 0) {
                    if ((i3 & 4096) != 0) {
                        i31 = 128;
                    } else {
                        if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                            i31 = 256;
                        } else {
                            i31 = 128;
                        }
                    }
                    i23 |= i31;
                }
                if ((i2 & 3072) != 0) {
                    if ((i3 & 8192) == 0) {
                        i6 = 2048;
                    }
                    i23 |= i6;
                }
                if ((i2 & 24576) != 0) {
                    if ((i3 & 16384) == 0) {
                        i9 = 16384;
                    }
                    i23 |= i9;
                }
                i24 = i3 & 32768;
                if (i24 != 0) {
                    i23 |= 196608;
                } else if ((i2 & 196608) == 0) {
                    i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                }
                if ((i2 & 1572864) == 0) {
                    if ((i3 & 65536) == 0) {
                        if ((i2 & 2097152) == 0) {
                            zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                        } else {
                            zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                        }
                        if (zChangedInstance) {
                            i14 = 1048576;
                        }
                    }
                    i23 |= i14;
                }
                if ((i2 & 12582912) == 0) {
                    i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                }
                if ((i22 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0) {
                        if ((i3 & 2) != 0) {
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            i25 = i22 & (-113);
                        } else {
                            i25 = i22;
                        }
                        if (i34 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (i5 != 0) {
                            color7 = null;
                        }
                        if (i8 != 0) {
                            color8 = null;
                        }
                        if (i11 != 0) {
                            color9 = null;
                        }
                        if (i13 != 0) {
                            color10 = null;
                        }
                        if (i16 != 0) {
                            color17 = null;
                        } else {
                            color17 = color5;
                        }
                        if (i18 == 0) {
                        }
                        if (i20 != 0) {
                            paletteStyle3 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle3 = paletteStyle;
                        }
                        if ((i3 & 1024) != 0) {
                            i23 &= -15;
                            d2 = 0.0d;
                        }
                        if ((i3 & 2048) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i23 &= -113;
                            colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                        }
                        int i3111117 = i25;
                        i26 = i23;
                        colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                        if ((i3 & 4096) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i26 &= -897;
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            platform3 = platform;
                        }
                        DynamicScheme.Platform platform111113 = platform3;
                        if ((i3 & 8192) != 0) {
                            shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i26 &= -7169;
                        } else {
                            shapes2 = shapes;
                        }
                        i27 = i26;
                        if ((i3 & 16384) != 0) {
                            typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i28 = i27 & (-57345);
                        } else {
                            i28 = i27;
                            typography3 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 65536) != 0) {
                            i28 &= -3670017;
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                        }
                        platform2 = platform111113;
                        typography4 = typography3;
                        i29 = i28;
                        double d111113 = d2;
                        i30 = i3111117;
                        z9 = zIsSystemInDarkTheme;
                        color18 = color9;
                        color19 = color17;
                        d3 = d111113;
                    } else {
                        if ((i3 & 2) != 0) {
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            i25 = i22 & (-113);
                        } else {
                            i25 = i22;
                        }
                        if (i34 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (i5 != 0) {
                            color7 = null;
                        }
                        if (i8 != 0) {
                            color8 = null;
                        }
                        if (i11 != 0) {
                            color9 = null;
                        }
                        if (i13 != 0) {
                            color10 = null;
                        }
                        if (i16 != 0) {
                            color17 = null;
                        } else {
                            color17 = color5;
                        }
                        if (i18 == 0) {
                        }
                        if (i20 != 0) {
                            paletteStyle3 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle3 = paletteStyle;
                        }
                        if ((i3 & 1024) != 0) {
                            i23 &= -15;
                            d2 = 0.0d;
                        }
                        if ((i3 & 2048) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i23 &= -113;
                            colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                        }
                        int i3111118 = i25;
                        i26 = i23;
                        colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                        if ((i3 & 4096) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i26 &= -897;
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            platform3 = platform;
                        }
                        DynamicScheme.Platform platform111114 = platform3;
                        if ((i3 & 8192) != 0) {
                            shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i26 &= -7169;
                        } else {
                            shapes2 = shapes;
                        }
                        i27 = i26;
                        if ((i3 & 16384) != 0) {
                            typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i28 = i27 & (-57345);
                        } else {
                            i28 = i27;
                            typography3 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 65536) != 0) {
                            i28 &= -3670017;
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                        }
                        platform2 = platform111114;
                        typography4 = typography3;
                        i29 = i28;
                        double d111114 = d2;
                        i30 = i3111118;
                        z9 = zIsSystemInDarkTheme;
                        color18 = color9;
                        color19 = color17;
                        d3 = d111114;
                    }
                    gapComposer2.endDefaults();
                    gapComposer = gapComposer2;
                    boolean z1115 = z8;
                    FiniteAnimationSpec finiteAnimationSpec118 = defaultColorSpring;
                    DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z1115, finiteAnimationSpec118, function2, gapComposer, (i29 >> 6) & 524272, 0);
                    finiteAnimationSpec2 = finiteAnimationSpec118;
                    color13 = color7;
                    color16 = color10;
                    paletteStyle2 = paletteStyle3;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                    typography2 = typography4;
                    z6 = z1115;
                    z5 = z7;
                    color15 = color18;
                    zIsSystemInDarkTheme = z9;
                    color14 = color8;
                    color11 = color19;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z5 = z2;
                    color11 = color5;
                    color12 = color6;
                    platform2 = platform;
                    shapes2 = shapes;
                    typography2 = typography;
                    z6 = z3;
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    d3 = d2;
                    color13 = color7;
                    color14 = color8;
                    color15 = color9;
                    color16 = color10;
                    paletteStyle2 = paletteStyle;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                }
            }
            i4 |= 100663296;
            i20 = i3 & 512;
            if (i20 != 0) {
                if ((i & 805306368) == 0) {
                    if (paletteStyle == null) {
                        iOrdinal = -1;
                    } else {
                        iOrdinal = paletteStyle.ordinal();
                    }
                    if (gapComposer2.changed(iOrdinal)) {
                        i21 = 536870912;
                    } else {
                        i21 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                    }
                    i4 |= i21;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) == 0) {
                        i22 = i4;
                        d2 = d;
                        if (gapComposer2.changed(d2)) {
                        }
                        i23 = i2 | i35;
                    } else {
                        i22 = i4;
                        d2 = d;
                    }
                    i23 = i2 | i35;
                } else {
                    i22 = i4;
                    d2 = d;
                    i23 = i2;
                }
                if ((i2 & 48) != 0) {
                    if ((i3 & 2048) != 0) {
                        i32 = 16;
                    } else {
                        if (colorSpec$SpecVersion == null) {
                            iOrdinal2 = -1;
                        } else {
                            iOrdinal2 = colorSpec$SpecVersion.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal2)) {
                            i32 = 32;
                        } else {
                            i32 = 16;
                        }
                    }
                    i23 |= i32;
                }
                if ((i2 & 384) == 0) {
                    if ((i3 & 4096) != 0) {
                        i31 = 128;
                    } else {
                        if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                            i31 = 256;
                        } else {
                            i31 = 128;
                        }
                    }
                    i23 |= i31;
                }
                if ((i2 & 3072) != 0) {
                    if ((i3 & 8192) == 0) {
                        i6 = 2048;
                    }
                    i23 |= i6;
                }
                if ((i2 & 24576) != 0) {
                    if ((i3 & 16384) == 0) {
                        i9 = 16384;
                    }
                    i23 |= i9;
                }
                i24 = i3 & 32768;
                if (i24 != 0) {
                    i23 |= 196608;
                } else if ((i2 & 196608) == 0) {
                    i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                }
                if ((i2 & 1572864) == 0) {
                    if ((i3 & 65536) == 0) {
                        if ((i2 & 2097152) == 0) {
                            zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                        } else {
                            zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                        }
                        if (zChangedInstance) {
                            i14 = 1048576;
                        }
                    }
                    i23 |= i14;
                }
                if ((i2 & 12582912) == 0) {
                    i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                }
                if ((i22 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0) {
                        if ((i3 & 2) != 0) {
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            i25 = i22 & (-113);
                        } else {
                            i25 = i22;
                        }
                        if (i34 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (i5 != 0) {
                            color7 = null;
                        }
                        if (i8 != 0) {
                            color8 = null;
                        }
                        if (i11 != 0) {
                            color9 = null;
                        }
                        if (i13 != 0) {
                            color10 = null;
                        }
                        if (i16 != 0) {
                            color17 = null;
                        } else {
                            color17 = color5;
                        }
                        if (i18 == 0) {
                        }
                        if (i20 != 0) {
                            paletteStyle3 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle3 = paletteStyle;
                        }
                        if ((i3 & 1024) != 0) {
                            i23 &= -15;
                            d2 = 0.0d;
                        }
                        if ((i3 & 2048) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i23 &= -113;
                            colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                        }
                        int i3111119 = i25;
                        i26 = i23;
                        colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                        if ((i3 & 4096) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i26 &= -897;
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            platform3 = platform;
                        }
                        DynamicScheme.Platform platform111115 = platform3;
                        if ((i3 & 8192) != 0) {
                            shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i26 &= -7169;
                        } else {
                            shapes2 = shapes;
                        }
                        i27 = i26;
                        if ((i3 & 16384) != 0) {
                            typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i28 = i27 & (-57345);
                        } else {
                            i28 = i27;
                            typography3 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 65536) != 0) {
                            i28 &= -3670017;
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                        }
                        platform2 = platform111115;
                        typography4 = typography3;
                        i29 = i28;
                        double d111115 = d2;
                        i30 = i3111119;
                        z9 = zIsSystemInDarkTheme;
                        color18 = color9;
                        color19 = color17;
                        d3 = d111115;
                    } else {
                        if ((i3 & 2) != 0) {
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            i25 = i22 & (-113);
                        } else {
                            i25 = i22;
                        }
                        if (i34 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (i5 != 0) {
                            color7 = null;
                        }
                        if (i8 != 0) {
                            color8 = null;
                        }
                        if (i11 != 0) {
                            color9 = null;
                        }
                        if (i13 != 0) {
                            color10 = null;
                        }
                        if (i16 != 0) {
                            color17 = null;
                        } else {
                            color17 = color5;
                        }
                        if (i18 == 0) {
                        }
                        if (i20 != 0) {
                            paletteStyle3 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle3 = paletteStyle;
                        }
                        if ((i3 & 1024) != 0) {
                            i23 &= -15;
                            d2 = 0.0d;
                        }
                        if ((i3 & 2048) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i23 &= -113;
                            colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                        }
                        int i31111110 = i25;
                        i26 = i23;
                        colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                        if ((i3 & 4096) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i26 &= -897;
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            platform3 = platform;
                        }
                        DynamicScheme.Platform platform111116 = platform3;
                        if ((i3 & 8192) != 0) {
                            shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i26 &= -7169;
                        } else {
                            shapes2 = shapes;
                        }
                        i27 = i26;
                        if ((i3 & 16384) != 0) {
                            typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i28 = i27 & (-57345);
                        } else {
                            i28 = i27;
                            typography3 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 65536) != 0) {
                            i28 &= -3670017;
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                        }
                        platform2 = platform111116;
                        typography4 = typography3;
                        i29 = i28;
                        double d111116 = d2;
                        i30 = i31111110;
                        z9 = zIsSystemInDarkTheme;
                        color18 = color9;
                        color19 = color17;
                        d3 = d111116;
                    }
                    gapComposer2.endDefaults();
                    gapComposer = gapComposer2;
                    boolean z1116 = z8;
                    FiniteAnimationSpec finiteAnimationSpec119 = defaultColorSpring;
                    DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z1116, finiteAnimationSpec119, function2, gapComposer, (i29 >> 6) & 524272, 0);
                    finiteAnimationSpec2 = finiteAnimationSpec119;
                    color13 = color7;
                    color16 = color10;
                    paletteStyle2 = paletteStyle3;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                    typography2 = typography4;
                    z6 = z1116;
                    z5 = z7;
                    color15 = color18;
                    zIsSystemInDarkTheme = z9;
                    color14 = color8;
                    color11 = color19;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z5 = z2;
                    color11 = color5;
                    color12 = color6;
                    platform2 = platform;
                    shapes2 = shapes;
                    typography2 = typography;
                    z6 = z3;
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    d3 = d2;
                    color13 = color7;
                    color14 = color8;
                    color15 = color9;
                    color16 = color10;
                    paletteStyle2 = paletteStyle;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                }
            }
            i4 |= 805306368;
            i20 = i20;
            if ((i2 & 6) == 0) {
                if ((i3 & 1024) == 0) {
                    i22 = i4;
                    d2 = d;
                    if (gapComposer2.changed(d2)) {
                    }
                    i23 = i2 | i35;
                } else {
                    i22 = i4;
                    d2 = d;
                }
                i23 = i2 | i35;
            } else {
                i22 = i4;
                d2 = d;
                i23 = i2;
            }
            if ((i2 & 48) != 0) {
                if ((i3 & 2048) != 0) {
                    i32 = 16;
                } else {
                    if (colorSpec$SpecVersion == null) {
                        iOrdinal2 = -1;
                    } else {
                        iOrdinal2 = colorSpec$SpecVersion.ordinal();
                    }
                    if (gapComposer2.changed(iOrdinal2)) {
                        i32 = 32;
                    } else {
                        i32 = 16;
                    }
                }
                i23 |= i32;
            }
            if ((i2 & 384) == 0) {
                if ((i3 & 4096) != 0) {
                    i31 = 128;
                } else {
                    if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                        i31 = 256;
                    } else {
                        i31 = 128;
                    }
                }
                i23 |= i31;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8192) == 0) {
                    i6 = 2048;
                }
                i23 |= i6;
            }
            if ((i2 & 24576) != 0) {
                if ((i3 & 16384) == 0) {
                    i9 = 16384;
                }
                i23 |= i9;
            }
            i24 = i3 & 32768;
            if (i24 != 0) {
                i23 |= 196608;
            } else if ((i2 & 196608) == 0) {
                i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
            }
            if ((i2 & 1572864) == 0) {
                if ((i3 & 65536) == 0) {
                    if ((i2 & 2097152) == 0) {
                        zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                    } else {
                        zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                    }
                    if (zChangedInstance) {
                        i14 = 1048576;
                    }
                }
                i23 |= i14;
            }
            if ((i2 & 12582912) == 0) {
                i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
            }
            if ((i22 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                gapComposer2.startDefaults();
                if ((i & 1) != 0) {
                    if ((i3 & 2) != 0) {
                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        i25 = i22 & (-113);
                    } else {
                        i25 = i22;
                    }
                    if (i34 != 0) {
                        z7 = false;
                    } else {
                        z7 = z2;
                    }
                    if (i5 != 0) {
                        color7 = null;
                    }
                    if (i8 != 0) {
                        color8 = null;
                    }
                    if (i11 != 0) {
                        color9 = null;
                    }
                    if (i13 != 0) {
                        color10 = null;
                    }
                    if (i16 != 0) {
                        color17 = null;
                    } else {
                        color17 = color5;
                    }
                    if (i18 == 0) {
                    }
                    if (i20 != 0) {
                        paletteStyle3 = PaletteStyle.TonalSpot;
                    } else {
                        paletteStyle3 = paletteStyle;
                    }
                    if ((i3 & 1024) != 0) {
                        i23 &= -15;
                        d2 = 0.0d;
                    }
                    if ((i3 & 2048) != 0) {
                        ColorSpec$SpecVersion.Companion.getClass();
                        i23 &= -113;
                        colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                    } else {
                        colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                    }
                    int i31111111 = i25;
                    i26 = i23;
                    colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                    if ((i3 & 4096) != 0) {
                        DynamicScheme.Platform.Companion.getClass();
                        i26 &= -897;
                        platform3 = DynamicScheme.Platform.Default;
                    } else {
                        platform3 = platform;
                    }
                    DynamicScheme.Platform platform111117 = platform3;
                    if ((i3 & 8192) != 0) {
                        shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        i26 &= -7169;
                    } else {
                        shapes2 = shapes;
                    }
                    i27 = i26;
                    if ((i3 & 16384) != 0) {
                        typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                        i28 = i27 & (-57345);
                    } else {
                        i28 = i27;
                        typography3 = typography;
                    }
                    if (i24 == 0) {
                    }
                    if ((i3 & 65536) != 0) {
                        i28 &= -3670017;
                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                    } else {
                        defaultColorSpring = finiteAnimationSpec;
                    }
                    platform2 = platform111117;
                    typography4 = typography3;
                    i29 = i28;
                    double d111117 = d2;
                    i30 = i31111111;
                    z9 = zIsSystemInDarkTheme;
                    color18 = color9;
                    color19 = color17;
                    d3 = d111117;
                } else {
                    if ((i3 & 2) != 0) {
                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        i25 = i22 & (-113);
                    } else {
                        i25 = i22;
                    }
                    if (i34 != 0) {
                        z7 = false;
                    } else {
                        z7 = z2;
                    }
                    if (i5 != 0) {
                        color7 = null;
                    }
                    if (i8 != 0) {
                        color8 = null;
                    }
                    if (i11 != 0) {
                        color9 = null;
                    }
                    if (i13 != 0) {
                        color10 = null;
                    }
                    if (i16 != 0) {
                        color17 = null;
                    } else {
                        color17 = color5;
                    }
                    if (i18 == 0) {
                    }
                    if (i20 != 0) {
                        paletteStyle3 = PaletteStyle.TonalSpot;
                    } else {
                        paletteStyle3 = paletteStyle;
                    }
                    if ((i3 & 1024) != 0) {
                        i23 &= -15;
                        d2 = 0.0d;
                    }
                    if ((i3 & 2048) != 0) {
                        ColorSpec$SpecVersion.Companion.getClass();
                        i23 &= -113;
                        colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                    } else {
                        colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                    }
                    int i31111112 = i25;
                    i26 = i23;
                    colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                    if ((i3 & 4096) != 0) {
                        DynamicScheme.Platform.Companion.getClass();
                        i26 &= -897;
                        platform3 = DynamicScheme.Platform.Default;
                    } else {
                        platform3 = platform;
                    }
                    DynamicScheme.Platform platform111118 = platform3;
                    if ((i3 & 8192) != 0) {
                        shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        i26 &= -7169;
                    } else {
                        shapes2 = shapes;
                    }
                    i27 = i26;
                    if ((i3 & 16384) != 0) {
                        typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                        i28 = i27 & (-57345);
                    } else {
                        i28 = i27;
                        typography3 = typography;
                    }
                    if (i24 == 0) {
                    }
                    if ((i3 & 65536) != 0) {
                        i28 &= -3670017;
                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                    } else {
                        defaultColorSpring = finiteAnimationSpec;
                    }
                    platform2 = platform111118;
                    typography4 = typography3;
                    i29 = i28;
                    double d111118 = d2;
                    i30 = i31111112;
                    z9 = zIsSystemInDarkTheme;
                    color18 = color9;
                    color19 = color17;
                    d3 = d111118;
                }
                gapComposer2.endDefaults();
                gapComposer = gapComposer2;
                boolean z1117 = z8;
                FiniteAnimationSpec finiteAnimationSpec1110 = defaultColorSpring;
                DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z1117, finiteAnimationSpec1110, function2, gapComposer, (i29 >> 6) & 524272, 0);
                finiteAnimationSpec2 = finiteAnimationSpec1110;
                color13 = color7;
                color16 = color10;
                paletteStyle2 = paletteStyle3;
                colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                typography2 = typography4;
                z6 = z1117;
                z5 = z7;
                color15 = color18;
                zIsSystemInDarkTheme = z9;
                color14 = color8;
                color11 = color19;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                z5 = z2;
                color11 = color5;
                color12 = color6;
                platform2 = platform;
                shapes2 = shapes;
                typography2 = typography;
                z6 = z3;
                finiteAnimationSpec2 = finiteAnimationSpec;
                d3 = d2;
                color13 = color7;
                color14 = color8;
                color15 = color9;
                color16 = color10;
                paletteStyle2 = paletteStyle;
                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
            }
        }
        i4 |= 24576;
        color8 = color2;
        i11 = i3 & 32;
        if (i11 != 0) {
            i4 |= 196608;
            color9 = color3;
        } else {
            color9 = color3;
            if ((i & 196608) == 0) {
                if (gapComposer2.changed(color9)) {
                    i12 = 131072;
                } else {
                    i12 = 65536;
                }
                i4 |= i12;
            }
        }
        i13 = i3 & 64;
        i14 = 524288;
        if (i13 != 0) {
            i4 |= 1572864;
            color10 = color4;
        } else {
            color10 = color4;
            if ((i & 1572864) == 0) {
                if (gapComposer2.changed(color10)) {
                    i15 = 1048576;
                } else {
                    i15 = 524288;
                }
                i4 |= i15;
            }
        }
        i16 = i3 & 128;
        if (i16 != 0) {
            i4 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (gapComposer2.changed(color5)) {
                i17 = 8388608;
            } else {
                i17 = 4194304;
            }
            i4 |= i17;
        }
        i18 = i3 & 256;
        if (i18 != 0) {
            if ((i & 100663296) == 0) {
                if (gapComposer2.changed(color6)) {
                    i19 = 67108864;
                } else {
                    i19 = 33554432;
                }
                i4 |= i19;
            }
            i20 = i3 & 512;
            if (i20 != 0) {
                if ((i & 805306368) == 0) {
                    if (paletteStyle == null) {
                        iOrdinal = -1;
                    } else {
                        iOrdinal = paletteStyle.ordinal();
                    }
                    if (gapComposer2.changed(iOrdinal)) {
                        i21 = 536870912;
                    } else {
                        i21 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                    }
                    i4 |= i21;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) == 0) {
                        i22 = i4;
                        d2 = d;
                        if (gapComposer2.changed(d2)) {
                        }
                        i23 = i2 | i35;
                    } else {
                        i22 = i4;
                        d2 = d;
                    }
                    i23 = i2 | i35;
                } else {
                    i22 = i4;
                    d2 = d;
                    i23 = i2;
                }
                if ((i2 & 48) != 0) {
                    if ((i3 & 2048) != 0) {
                        i32 = 16;
                    } else {
                        if (colorSpec$SpecVersion == null) {
                            iOrdinal2 = -1;
                        } else {
                            iOrdinal2 = colorSpec$SpecVersion.ordinal();
                        }
                        if (gapComposer2.changed(iOrdinal2)) {
                            i32 = 32;
                        } else {
                            i32 = 16;
                        }
                    }
                    i23 |= i32;
                }
                if ((i2 & 384) == 0) {
                    if ((i3 & 4096) != 0) {
                        i31 = 128;
                    } else {
                        if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                            i31 = 256;
                        } else {
                            i31 = 128;
                        }
                    }
                    i23 |= i31;
                }
                if ((i2 & 3072) != 0) {
                    if ((i3 & 8192) == 0) {
                        i6 = 2048;
                    }
                    i23 |= i6;
                }
                if ((i2 & 24576) != 0) {
                    if ((i3 & 16384) == 0) {
                        i9 = 16384;
                    }
                    i23 |= i9;
                }
                i24 = i3 & 32768;
                if (i24 != 0) {
                    i23 |= 196608;
                } else if ((i2 & 196608) == 0) {
                    i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
                }
                if ((i2 & 1572864) == 0) {
                    if ((i3 & 65536) == 0) {
                        if ((i2 & 2097152) == 0) {
                            zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                        } else {
                            zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                        }
                        if (zChangedInstance) {
                            i14 = 1048576;
                        }
                    }
                    i23 |= i14;
                }
                if ((i2 & 12582912) == 0) {
                    i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
                }
                if ((i22 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                    gapComposer2.startDefaults();
                    if ((i & 1) != 0) {
                        if ((i3 & 2) != 0) {
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            i25 = i22 & (-113);
                        } else {
                            i25 = i22;
                        }
                        if (i34 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (i5 != 0) {
                            color7 = null;
                        }
                        if (i8 != 0) {
                            color8 = null;
                        }
                        if (i11 != 0) {
                            color9 = null;
                        }
                        if (i13 != 0) {
                            color10 = null;
                        }
                        if (i16 != 0) {
                            color17 = null;
                        } else {
                            color17 = color5;
                        }
                        if (i18 == 0) {
                        }
                        if (i20 != 0) {
                            paletteStyle3 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle3 = paletteStyle;
                        }
                        if ((i3 & 1024) != 0) {
                            i23 &= -15;
                            d2 = 0.0d;
                        }
                        if ((i3 & 2048) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i23 &= -113;
                            colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                        }
                        int i31111113 = i25;
                        i26 = i23;
                        colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                        if ((i3 & 4096) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i26 &= -897;
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            platform3 = platform;
                        }
                        DynamicScheme.Platform platform111119 = platform3;
                        if ((i3 & 8192) != 0) {
                            shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i26 &= -7169;
                        } else {
                            shapes2 = shapes;
                        }
                        i27 = i26;
                        if ((i3 & 16384) != 0) {
                            typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i28 = i27 & (-57345);
                        } else {
                            i28 = i27;
                            typography3 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 65536) != 0) {
                            i28 &= -3670017;
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                        }
                        platform2 = platform111119;
                        typography4 = typography3;
                        i29 = i28;
                        double d111119 = d2;
                        i30 = i31111113;
                        z9 = zIsSystemInDarkTheme;
                        color18 = color9;
                        color19 = color17;
                        d3 = d111119;
                    } else {
                        if ((i3 & 2) != 0) {
                            zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                            i25 = i22 & (-113);
                        } else {
                            i25 = i22;
                        }
                        if (i34 != 0) {
                            z7 = false;
                        } else {
                            z7 = z2;
                        }
                        if (i5 != 0) {
                            color7 = null;
                        }
                        if (i8 != 0) {
                            color8 = null;
                        }
                        if (i11 != 0) {
                            color9 = null;
                        }
                        if (i13 != 0) {
                            color10 = null;
                        }
                        if (i16 != 0) {
                            color17 = null;
                        } else {
                            color17 = color5;
                        }
                        if (i18 == 0) {
                        }
                        if (i20 != 0) {
                            paletteStyle3 = PaletteStyle.TonalSpot;
                        } else {
                            paletteStyle3 = paletteStyle;
                        }
                        if ((i3 & 1024) != 0) {
                            i23 &= -15;
                            d2 = 0.0d;
                        }
                        if ((i3 & 2048) != 0) {
                            ColorSpec$SpecVersion.Companion.getClass();
                            i23 &= -113;
                            colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                        } else {
                            colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                        }
                        int i31111114 = i25;
                        i26 = i23;
                        colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                        if ((i3 & 4096) != 0) {
                            DynamicScheme.Platform.Companion.getClass();
                            i26 &= -897;
                            platform3 = DynamicScheme.Platform.Default;
                        } else {
                            platform3 = platform;
                        }
                        DynamicScheme.Platform platform1111110 = platform3;
                        if ((i3 & 8192) != 0) {
                            shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                            i26 &= -7169;
                        } else {
                            shapes2 = shapes;
                        }
                        i27 = i26;
                        if ((i3 & 16384) != 0) {
                            typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                            i28 = i27 & (-57345);
                        } else {
                            i28 = i27;
                            typography3 = typography;
                        }
                        if (i24 == 0) {
                        }
                        if ((i3 & 65536) != 0) {
                            i28 &= -3670017;
                            defaultColorSpring = ColorKt.getDefaultColorSpring();
                        } else {
                            defaultColorSpring = finiteAnimationSpec;
                        }
                        platform2 = platform1111110;
                        typography4 = typography3;
                        i29 = i28;
                        double d1111110 = d2;
                        i30 = i31111114;
                        z9 = zIsSystemInDarkTheme;
                        color18 = color9;
                        color19 = color17;
                        d3 = d1111110;
                    }
                    gapComposer2.endDefaults();
                    gapComposer = gapComposer2;
                    boolean z1118 = z8;
                    FiniteAnimationSpec finiteAnimationSpec1111 = defaultColorSpring;
                    DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z1118, finiteAnimationSpec1111, function2, gapComposer, (i29 >> 6) & 524272, 0);
                    finiteAnimationSpec2 = finiteAnimationSpec1111;
                    color13 = color7;
                    color16 = color10;
                    paletteStyle2 = paletteStyle3;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                    typography2 = typography4;
                    z6 = z1118;
                    z5 = z7;
                    color15 = color18;
                    zIsSystemInDarkTheme = z9;
                    color14 = color8;
                    color11 = color19;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    z5 = z2;
                    color11 = color5;
                    color12 = color6;
                    platform2 = platform;
                    shapes2 = shapes;
                    typography2 = typography;
                    z6 = z3;
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    d3 = d2;
                    color13 = color7;
                    color14 = color8;
                    color15 = color9;
                    color16 = color10;
                    paletteStyle2 = paletteStyle;
                    colorSpec$SpecVersion2 = colorSpec$SpecVersion;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
                }
            }
            i4 |= 805306368;
            i20 = i20;
            if ((i2 & 6) == 0) {
                if ((i3 & 1024) == 0) {
                    i22 = i4;
                    d2 = d;
                    if (gapComposer2.changed(d2)) {
                    }
                    i23 = i2 | i35;
                } else {
                    i22 = i4;
                    d2 = d;
                }
                i23 = i2 | i35;
            } else {
                i22 = i4;
                d2 = d;
                i23 = i2;
            }
            if ((i2 & 48) != 0) {
                if ((i3 & 2048) != 0) {
                    i32 = 16;
                } else {
                    if (colorSpec$SpecVersion == null) {
                        iOrdinal2 = -1;
                    } else {
                        iOrdinal2 = colorSpec$SpecVersion.ordinal();
                    }
                    if (gapComposer2.changed(iOrdinal2)) {
                        i32 = 32;
                    } else {
                        i32 = 16;
                    }
                }
                i23 |= i32;
            }
            if ((i2 & 384) == 0) {
                if ((i3 & 4096) != 0) {
                    i31 = 128;
                } else {
                    if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                        i31 = 256;
                    } else {
                        i31 = 128;
                    }
                }
                i23 |= i31;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8192) == 0) {
                    i6 = 2048;
                }
                i23 |= i6;
            }
            if ((i2 & 24576) != 0) {
                if ((i3 & 16384) == 0) {
                    i9 = 16384;
                }
                i23 |= i9;
            }
            i24 = i3 & 32768;
            if (i24 != 0) {
                i23 |= 196608;
            } else if ((i2 & 196608) == 0) {
                i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
            }
            if ((i2 & 1572864) == 0) {
                if ((i3 & 65536) == 0) {
                    if ((i2 & 2097152) == 0) {
                        zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                    } else {
                        zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                    }
                    if (zChangedInstance) {
                        i14 = 1048576;
                    }
                }
                i23 |= i14;
            }
            if ((i2 & 12582912) == 0) {
                i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
            }
            if ((i22 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                gapComposer2.startDefaults();
                if ((i & 1) != 0) {
                    if ((i3 & 2) != 0) {
                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        i25 = i22 & (-113);
                    } else {
                        i25 = i22;
                    }
                    if (i34 != 0) {
                        z7 = false;
                    } else {
                        z7 = z2;
                    }
                    if (i5 != 0) {
                        color7 = null;
                    }
                    if (i8 != 0) {
                        color8 = null;
                    }
                    if (i11 != 0) {
                        color9 = null;
                    }
                    if (i13 != 0) {
                        color10 = null;
                    }
                    if (i16 != 0) {
                        color17 = null;
                    } else {
                        color17 = color5;
                    }
                    if (i18 == 0) {
                    }
                    if (i20 != 0) {
                        paletteStyle3 = PaletteStyle.TonalSpot;
                    } else {
                        paletteStyle3 = paletteStyle;
                    }
                    if ((i3 & 1024) != 0) {
                        i23 &= -15;
                        d2 = 0.0d;
                    }
                    if ((i3 & 2048) != 0) {
                        ColorSpec$SpecVersion.Companion.getClass();
                        i23 &= -113;
                        colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                    } else {
                        colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                    }
                    int i31111115 = i25;
                    i26 = i23;
                    colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                    if ((i3 & 4096) != 0) {
                        DynamicScheme.Platform.Companion.getClass();
                        i26 &= -897;
                        platform3 = DynamicScheme.Platform.Default;
                    } else {
                        platform3 = platform;
                    }
                    DynamicScheme.Platform platform1111111 = platform3;
                    if ((i3 & 8192) != 0) {
                        shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        i26 &= -7169;
                    } else {
                        shapes2 = shapes;
                    }
                    i27 = i26;
                    if ((i3 & 16384) != 0) {
                        typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                        i28 = i27 & (-57345);
                    } else {
                        i28 = i27;
                        typography3 = typography;
                    }
                    if (i24 == 0) {
                    }
                    if ((i3 & 65536) != 0) {
                        i28 &= -3670017;
                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                    } else {
                        defaultColorSpring = finiteAnimationSpec;
                    }
                    platform2 = platform1111111;
                    typography4 = typography3;
                    i29 = i28;
                    double d1111111 = d2;
                    i30 = i31111115;
                    z9 = zIsSystemInDarkTheme;
                    color18 = color9;
                    color19 = color17;
                    d3 = d1111111;
                } else {
                    if ((i3 & 2) != 0) {
                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        i25 = i22 & (-113);
                    } else {
                        i25 = i22;
                    }
                    if (i34 != 0) {
                        z7 = false;
                    } else {
                        z7 = z2;
                    }
                    if (i5 != 0) {
                        color7 = null;
                    }
                    if (i8 != 0) {
                        color8 = null;
                    }
                    if (i11 != 0) {
                        color9 = null;
                    }
                    if (i13 != 0) {
                        color10 = null;
                    }
                    if (i16 != 0) {
                        color17 = null;
                    } else {
                        color17 = color5;
                    }
                    if (i18 == 0) {
                    }
                    if (i20 != 0) {
                        paletteStyle3 = PaletteStyle.TonalSpot;
                    } else {
                        paletteStyle3 = paletteStyle;
                    }
                    if ((i3 & 1024) != 0) {
                        i23 &= -15;
                        d2 = 0.0d;
                    }
                    if ((i3 & 2048) != 0) {
                        ColorSpec$SpecVersion.Companion.getClass();
                        i23 &= -113;
                        colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                    } else {
                        colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                    }
                    int i31111116 = i25;
                    i26 = i23;
                    colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                    if ((i3 & 4096) != 0) {
                        DynamicScheme.Platform.Companion.getClass();
                        i26 &= -897;
                        platform3 = DynamicScheme.Platform.Default;
                    } else {
                        platform3 = platform;
                    }
                    DynamicScheme.Platform platform1111112 = platform3;
                    if ((i3 & 8192) != 0) {
                        shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        i26 &= -7169;
                    } else {
                        shapes2 = shapes;
                    }
                    i27 = i26;
                    if ((i3 & 16384) != 0) {
                        typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                        i28 = i27 & (-57345);
                    } else {
                        i28 = i27;
                        typography3 = typography;
                    }
                    if (i24 == 0) {
                    }
                    if ((i3 & 65536) != 0) {
                        i28 &= -3670017;
                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                    } else {
                        defaultColorSpring = finiteAnimationSpec;
                    }
                    platform2 = platform1111112;
                    typography4 = typography3;
                    i29 = i28;
                    double d1111112 = d2;
                    i30 = i31111116;
                    z9 = zIsSystemInDarkTheme;
                    color18 = color9;
                    color19 = color17;
                    d3 = d1111112;
                }
                gapComposer2.endDefaults();
                gapComposer = gapComposer2;
                boolean z1119 = z8;
                FiniteAnimationSpec finiteAnimationSpec1112 = defaultColorSpring;
                DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z1119, finiteAnimationSpec1112, function2, gapComposer, (i29 >> 6) & 524272, 0);
                finiteAnimationSpec2 = finiteAnimationSpec1112;
                color13 = color7;
                color16 = color10;
                paletteStyle2 = paletteStyle3;
                colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                typography2 = typography4;
                z6 = z1119;
                z5 = z7;
                color15 = color18;
                zIsSystemInDarkTheme = z9;
                color14 = color8;
                color11 = color19;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                z5 = z2;
                color11 = color5;
                color12 = color6;
                platform2 = platform;
                shapes2 = shapes;
                typography2 = typography;
                z6 = z3;
                finiteAnimationSpec2 = finiteAnimationSpec;
                d3 = d2;
                color13 = color7;
                color14 = color8;
                color15 = color9;
                color16 = color10;
                paletteStyle2 = paletteStyle;
                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
            }
        }
        i4 |= 100663296;
        i20 = i3 & 512;
        if (i20 != 0) {
            if ((i & 805306368) == 0) {
                if (paletteStyle == null) {
                    iOrdinal = -1;
                } else {
                    iOrdinal = paletteStyle.ordinal();
                }
                if (gapComposer2.changed(iOrdinal)) {
                    i21 = 536870912;
                } else {
                    i21 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                }
                i4 |= i21;
            }
            if ((i2 & 6) == 0) {
                if ((i3 & 1024) == 0) {
                    i22 = i4;
                    d2 = d;
                    if (gapComposer2.changed(d2)) {
                    }
                    i23 = i2 | i35;
                } else {
                    i22 = i4;
                    d2 = d;
                }
                i23 = i2 | i35;
            } else {
                i22 = i4;
                d2 = d;
                i23 = i2;
            }
            if ((i2 & 48) != 0) {
                if ((i3 & 2048) != 0) {
                    i32 = 16;
                } else {
                    if (colorSpec$SpecVersion == null) {
                        iOrdinal2 = -1;
                    } else {
                        iOrdinal2 = colorSpec$SpecVersion.ordinal();
                    }
                    if (gapComposer2.changed(iOrdinal2)) {
                        i32 = 32;
                    } else {
                        i32 = 16;
                    }
                }
                i23 |= i32;
            }
            if ((i2 & 384) == 0) {
                if ((i3 & 4096) != 0) {
                    i31 = 128;
                } else {
                    if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                        i31 = 256;
                    } else {
                        i31 = 128;
                    }
                }
                i23 |= i31;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8192) == 0) {
                    i6 = 2048;
                }
                i23 |= i6;
            }
            if ((i2 & 24576) != 0) {
                if ((i3 & 16384) == 0) {
                    i9 = 16384;
                }
                i23 |= i9;
            }
            i24 = i3 & 32768;
            if (i24 != 0) {
                i23 |= 196608;
            } else if ((i2 & 196608) == 0) {
                i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
            }
            if ((i2 & 1572864) == 0) {
                if ((i3 & 65536) == 0) {
                    if ((i2 & 2097152) == 0) {
                        zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                    } else {
                        zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                    }
                    if (zChangedInstance) {
                        i14 = 1048576;
                    }
                }
                i23 |= i14;
            }
            if ((i2 & 12582912) == 0) {
                i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
            }
            if ((i22 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (gapComposer2.shouldExecute(i22 & 1, z4)) {
                gapComposer2.startDefaults();
                if ((i & 1) != 0) {
                    if ((i3 & 2) != 0) {
                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        i25 = i22 & (-113);
                    } else {
                        i25 = i22;
                    }
                    if (i34 != 0) {
                        z7 = false;
                    } else {
                        z7 = z2;
                    }
                    if (i5 != 0) {
                        color7 = null;
                    }
                    if (i8 != 0) {
                        color8 = null;
                    }
                    if (i11 != 0) {
                        color9 = null;
                    }
                    if (i13 != 0) {
                        color10 = null;
                    }
                    if (i16 != 0) {
                        color17 = null;
                    } else {
                        color17 = color5;
                    }
                    if (i18 == 0) {
                    }
                    if (i20 != 0) {
                        paletteStyle3 = PaletteStyle.TonalSpot;
                    } else {
                        paletteStyle3 = paletteStyle;
                    }
                    if ((i3 & 1024) != 0) {
                        i23 &= -15;
                        d2 = 0.0d;
                    }
                    if ((i3 & 2048) != 0) {
                        ColorSpec$SpecVersion.Companion.getClass();
                        i23 &= -113;
                        colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                    } else {
                        colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                    }
                    int i31111117 = i25;
                    i26 = i23;
                    colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                    if ((i3 & 4096) != 0) {
                        DynamicScheme.Platform.Companion.getClass();
                        i26 &= -897;
                        platform3 = DynamicScheme.Platform.Default;
                    } else {
                        platform3 = platform;
                    }
                    DynamicScheme.Platform platform1111113 = platform3;
                    if ((i3 & 8192) != 0) {
                        shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        i26 &= -7169;
                    } else {
                        shapes2 = shapes;
                    }
                    i27 = i26;
                    if ((i3 & 16384) != 0) {
                        typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                        i28 = i27 & (-57345);
                    } else {
                        i28 = i27;
                        typography3 = typography;
                    }
                    if (i24 == 0) {
                    }
                    if ((i3 & 65536) != 0) {
                        i28 &= -3670017;
                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                    } else {
                        defaultColorSpring = finiteAnimationSpec;
                    }
                    platform2 = platform1111113;
                    typography4 = typography3;
                    i29 = i28;
                    double d1111113 = d2;
                    i30 = i31111117;
                    z9 = zIsSystemInDarkTheme;
                    color18 = color9;
                    color19 = color17;
                    d3 = d1111113;
                } else {
                    if ((i3 & 2) != 0) {
                        zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                        i25 = i22 & (-113);
                    } else {
                        i25 = i22;
                    }
                    if (i34 != 0) {
                        z7 = false;
                    } else {
                        z7 = z2;
                    }
                    if (i5 != 0) {
                        color7 = null;
                    }
                    if (i8 != 0) {
                        color8 = null;
                    }
                    if (i11 != 0) {
                        color9 = null;
                    }
                    if (i13 != 0) {
                        color10 = null;
                    }
                    if (i16 != 0) {
                        color17 = null;
                    } else {
                        color17 = color5;
                    }
                    if (i18 == 0) {
                    }
                    if (i20 != 0) {
                        paletteStyle3 = PaletteStyle.TonalSpot;
                    } else {
                        paletteStyle3 = paletteStyle;
                    }
                    if ((i3 & 1024) != 0) {
                        i23 &= -15;
                        d2 = 0.0d;
                    }
                    if ((i3 & 2048) != 0) {
                        ColorSpec$SpecVersion.Companion.getClass();
                        i23 &= -113;
                        colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                    } else {
                        colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                    }
                    int i31111118 = i25;
                    i26 = i23;
                    colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                    if ((i3 & 4096) != 0) {
                        DynamicScheme.Platform.Companion.getClass();
                        i26 &= -897;
                        platform3 = DynamicScheme.Platform.Default;
                    } else {
                        platform3 = platform;
                    }
                    DynamicScheme.Platform platform1111114 = platform3;
                    if ((i3 & 8192) != 0) {
                        shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                        i26 &= -7169;
                    } else {
                        shapes2 = shapes;
                    }
                    i27 = i26;
                    if ((i3 & 16384) != 0) {
                        typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                        i28 = i27 & (-57345);
                    } else {
                        i28 = i27;
                        typography3 = typography;
                    }
                    if (i24 == 0) {
                    }
                    if ((i3 & 65536) != 0) {
                        i28 &= -3670017;
                        defaultColorSpring = ColorKt.getDefaultColorSpring();
                    } else {
                        defaultColorSpring = finiteAnimationSpec;
                    }
                    platform2 = platform1111114;
                    typography4 = typography3;
                    i29 = i28;
                    double d1111114 = d2;
                    i30 = i31111118;
                    z9 = zIsSystemInDarkTheme;
                    color18 = color9;
                    color19 = color17;
                    d3 = d1111114;
                }
                gapComposer2.endDefaults();
                gapComposer = gapComposer2;
                boolean z11110 = z8;
                FiniteAnimationSpec finiteAnimationSpec1113 = defaultColorSpring;
                DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z11110, finiteAnimationSpec1113, function2, gapComposer, (i29 >> 6) & 524272, 0);
                finiteAnimationSpec2 = finiteAnimationSpec1113;
                color13 = color7;
                color16 = color10;
                paletteStyle2 = paletteStyle3;
                colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
                typography2 = typography4;
                z6 = z11110;
                z5 = z7;
                color15 = color18;
                zIsSystemInDarkTheme = z9;
                color14 = color8;
                color11 = color19;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                z5 = z2;
                color11 = color5;
                color12 = color6;
                platform2 = platform;
                shapes2 = shapes;
                typography2 = typography;
                z6 = z3;
                finiteAnimationSpec2 = finiteAnimationSpec;
                d3 = d2;
                color13 = color7;
                color14 = color8;
                color15 = color9;
                color16 = color10;
                paletteStyle2 = paletteStyle;
                colorSpec$SpecVersion2 = colorSpec$SpecVersion;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
            }
        }
        i4 |= 805306368;
        i20 = i20;
        if ((i2 & 6) == 0) {
            if ((i3 & 1024) == 0) {
                i22 = i4;
                d2 = d;
                if (gapComposer2.changed(d2)) {
                }
                i23 = i2 | i35;
            } else {
                i22 = i4;
                d2 = d;
            }
            i23 = i2 | i35;
        } else {
            i22 = i4;
            d2 = d;
            i23 = i2;
        }
        if ((i2 & 48) != 0) {
            if ((i3 & 2048) != 0) {
                i32 = 16;
            } else {
                if (colorSpec$SpecVersion == null) {
                    iOrdinal2 = -1;
                } else {
                    iOrdinal2 = colorSpec$SpecVersion.ordinal();
                }
                if (gapComposer2.changed(iOrdinal2)) {
                    i32 = 32;
                } else {
                    i32 = 16;
                }
            }
            i23 |= i32;
        }
        if ((i2 & 384) == 0) {
            if ((i3 & 4096) != 0) {
                i31 = 128;
            } else {
                if (gapComposer2.changed(platform != null ? platform.ordinal() : -1)) {
                    i31 = 256;
                } else {
                    i31 = 128;
                }
            }
            i23 |= i31;
        }
        if ((i2 & 3072) != 0) {
            if ((i3 & 8192) == 0) {
                i6 = 2048;
            }
            i23 |= i6;
        }
        if ((i2 & 24576) != 0) {
            if ((i3 & 16384) == 0) {
                i9 = 16384;
            }
            i23 |= i9;
        }
        i24 = i3 & 32768;
        if (i24 != 0) {
            i23 |= 196608;
        } else if ((i2 & 196608) == 0) {
            i23 |= gapComposer2.changed(z3) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            if ((i3 & 65536) == 0) {
                if ((i2 & 2097152) == 0) {
                    zChangedInstance = gapComposer2.changed(finiteAnimationSpec);
                } else {
                    zChangedInstance = gapComposer2.changedInstance(finiteAnimationSpec);
                }
                if (zChangedInstance) {
                    i14 = 1048576;
                }
            }
            i23 |= i14;
        }
        if ((i2 & 12582912) == 0) {
            i23 |= gapComposer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((i22 & 306783379) == 306783378) {
            z4 = true;
        } else {
            z4 = true;
        }
        if (gapComposer2.shouldExecute(i22 & 1, z4)) {
            gapComposer2.startDefaults();
            if ((i & 1) != 0) {
                if ((i3 & 2) != 0) {
                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                    i25 = i22 & (-113);
                } else {
                    i25 = i22;
                }
                if (i34 != 0) {
                    z7 = false;
                } else {
                    z7 = z2;
                }
                if (i5 != 0) {
                    color7 = null;
                }
                if (i8 != 0) {
                    color8 = null;
                }
                if (i11 != 0) {
                    color9 = null;
                }
                if (i13 != 0) {
                    color10 = null;
                }
                if (i16 != 0) {
                    color17 = null;
                } else {
                    color17 = color5;
                }
                if (i18 == 0) {
                }
                if (i20 != 0) {
                    paletteStyle3 = PaletteStyle.TonalSpot;
                } else {
                    paletteStyle3 = paletteStyle;
                }
                if ((i3 & 1024) != 0) {
                    i23 &= -15;
                    d2 = 0.0d;
                }
                if ((i3 & 2048) != 0) {
                    ColorSpec$SpecVersion.Companion.getClass();
                    i23 &= -113;
                    colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                } else {
                    colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                }
                int i31111119 = i25;
                i26 = i23;
                colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                if ((i3 & 4096) != 0) {
                    DynamicScheme.Platform.Companion.getClass();
                    i26 &= -897;
                    platform3 = DynamicScheme.Platform.Default;
                } else {
                    platform3 = platform;
                }
                DynamicScheme.Platform platform1111115 = platform3;
                if ((i3 & 8192) != 0) {
                    shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                    i26 &= -7169;
                } else {
                    shapes2 = shapes;
                }
                i27 = i26;
                if ((i3 & 16384) != 0) {
                    typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                    i28 = i27 & (-57345);
                } else {
                    i28 = i27;
                    typography3 = typography;
                }
                if (i24 == 0) {
                }
                if ((i3 & 65536) != 0) {
                    i28 &= -3670017;
                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                } else {
                    defaultColorSpring = finiteAnimationSpec;
                }
                platform2 = platform1111115;
                typography4 = typography3;
                i29 = i28;
                double d1111115 = d2;
                i30 = i31111119;
                z9 = zIsSystemInDarkTheme;
                color18 = color9;
                color19 = color17;
                d3 = d1111115;
            } else {
                if ((i3 & 2) != 0) {
                    zIsSystemInDarkTheme = ImageKt.isSystemInDarkTheme(gapComposer2);
                    i25 = i22 & (-113);
                } else {
                    i25 = i22;
                }
                if (i34 != 0) {
                    z7 = false;
                } else {
                    z7 = z2;
                }
                if (i5 != 0) {
                    color7 = null;
                }
                if (i8 != 0) {
                    color8 = null;
                }
                if (i11 != 0) {
                    color9 = null;
                }
                if (i13 != 0) {
                    color10 = null;
                }
                if (i16 != 0) {
                    color17 = null;
                } else {
                    color17 = color5;
                }
                if (i18 == 0) {
                }
                if (i20 != 0) {
                    paletteStyle3 = PaletteStyle.TonalSpot;
                } else {
                    paletteStyle3 = paletteStyle;
                }
                if ((i3 & 1024) != 0) {
                    i23 &= -15;
                    d2 = 0.0d;
                }
                if ((i3 & 2048) != 0) {
                    ColorSpec$SpecVersion.Companion.getClass();
                    i23 &= -113;
                    colorSpec$SpecVersion3 = ColorSpec$SpecVersion.Default;
                } else {
                    colorSpec$SpecVersion3 = colorSpec$SpecVersion;
                }
                int i311111110 = i25;
                i26 = i23;
                colorSpec$SpecVersion4 = colorSpec$SpecVersion3;
                if ((i3 & 4096) != 0) {
                    DynamicScheme.Platform.Companion.getClass();
                    i26 &= -897;
                    platform3 = DynamicScheme.Platform.Default;
                } else {
                    platform3 = platform;
                }
                DynamicScheme.Platform platform1111116 = platform3;
                if ((i3 & 8192) != 0) {
                    shapes2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).shapes;
                    i26 &= -7169;
                } else {
                    shapes2 = shapes;
                }
                i27 = i26;
                if ((i3 & 16384) != 0) {
                    typography3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography;
                    i28 = i27 & (-57345);
                } else {
                    i28 = i27;
                    typography3 = typography;
                }
                if (i24 == 0) {
                }
                if ((i3 & 65536) != 0) {
                    i28 &= -3670017;
                    defaultColorSpring = ColorKt.getDefaultColorSpring();
                } else {
                    defaultColorSpring = finiteAnimationSpec;
                }
                platform2 = platform1111116;
                typography4 = typography3;
                i29 = i28;
                double d1111116 = d2;
                i30 = i311111110;
                z9 = zIsSystemInDarkTheme;
                color18 = color9;
                color19 = color17;
                d3 = d1111116;
            }
            gapComposer2.endDefaults();
            gapComposer = gapComposer2;
            boolean z11111 = z8;
            FiniteAnimationSpec finiteAnimationSpec1114 = defaultColorSpring;
            DynamicMaterialTheme(DynamicMaterialThemeStateKt.m935rememberDynamicMaterialThemeStateUQznLDA(j, z9, z7, color7, color8, color18, color10, color19, color12, paletteStyle3, d3, colorSpec$SpecVersion4, platform2, null, gapComposer, i30 & 2147483646, i29 & 1022, 8192), shapes2, typography4, z11111, finiteAnimationSpec1114, function2, gapComposer, (i29 >> 6) & 524272, 0);
            finiteAnimationSpec2 = finiteAnimationSpec1114;
            color13 = color7;
            color16 = color10;
            paletteStyle2 = paletteStyle3;
            colorSpec$SpecVersion2 = colorSpec$SpecVersion4;
            typography2 = typography4;
            z6 = z11111;
            z5 = z7;
            color15 = color18;
            zIsSystemInDarkTheme = z9;
            color14 = color8;
            color11 = color19;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            z5 = z2;
            color11 = color5;
            color12 = color6;
            platform2 = platform;
            shapes2 = shapes;
            typography2 = typography;
            z6 = z3;
            finiteAnimationSpec2 = finiteAnimationSpec;
            d3 = d2;
            color13 = color7;
            color14 = color8;
            color15 = color9;
            color16 = color10;
            paletteStyle2 = paletteStyle;
            colorSpec$SpecVersion2 = colorSpec$SpecVersion;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new DynamicMaterialThemeKt$$ExternalSyntheticLambda4(j, zIsSystemInDarkTheme, z5, color13, color14, color15, color16, color11, color12, paletteStyle2, d3, colorSpec$SpecVersion2, platform2, shapes2, typography2, z6, finiteAnimationSpec2, function2, i, i2, i3);
        }
    }
}
