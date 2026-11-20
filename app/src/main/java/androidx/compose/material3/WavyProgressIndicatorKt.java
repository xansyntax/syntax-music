package androidx.compose.material3;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AccessibilityUtilKt;
import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.websocket.WebSocketDeflateExtensionKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WavyProgressIndicatorKt {
    public static final TweenSpec IncreasingAmplitudeAnimationSpec = ArcSplineKt.tween$default(CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, 0, new CubicBezierEasing(0.2f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f), 2);
    public static final TweenSpec DecreasingAmplitudeAnimationSpec = ArcSplineKt.tween$default(CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, 0, new CubicBezierEasing(0.3f, CropImageView.DEFAULT_ASPECT_RATIO, 0.8f, 0.15f), 2);

    /* JADX WARN: Code duplicated, block: B:101:0x0137  */
    /* JADX WARN: Code duplicated, block: B:104:0x0145  */
    /* JADX WARN: Code duplicated, block: B:107:0x0155  */
    /* JADX WARN: Code duplicated, block: B:110:0x0178  */
    /* JADX WARN: Code duplicated, block: B:113:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:114:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:117:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:118:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:122:0x01df  */
    /* JADX WARN: Code duplicated, block: B:127:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:129:0x0218  */
    /* JADX WARN: Code duplicated, block: B:132:0x0230  */
    /* JADX WARN: Code duplicated, block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:19:0x003c  */
    /* JADX WARN: Code duplicated, block: B:21:0x0040  */
    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:24:0x004b  */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Code duplicated, block: B:30:0x0057  */
    /* JADX WARN: Code duplicated, block: B:32:0x005d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x0068  */
    /* JADX WARN: Code duplicated, block: B:36:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0072  */
    /* JADX WARN: Code duplicated, block: B:41:0x0077  */
    /* JADX WARN: Code duplicated, block: B:42:0x007c  */
    /* JADX WARN: Code duplicated, block: B:44:0x0082  */
    /* JADX WARN: Code duplicated, block: B:45:0x0085  */
    /* JADX WARN: Code duplicated, block: B:48:0x0090  */
    /* JADX WARN: Code duplicated, block: B:50:0x0094  */
    /* JADX WARN: Code duplicated, block: B:52:0x009c  */
    /* JADX WARN: Code duplicated, block: B:53:0x009f  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:74:0x00da  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f3  */
    /* JADX INFO: renamed from: LinearWavyProgressIndicator-1YwxWKA, reason: not valid java name */
    public static final void m364LinearWavyProgressIndicator1YwxWKA(final Function0 function0, Modifier modifier, long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, Function1 function1, float f3, float f4, Composer composer, final int i, final int i2) {
        int i3;
        long value;
        int i4;
        long value2;
        int i5;
        int i6;
        int i7;
        Function1 function2;
        float f5;
        boolean z;
        Modifier modifier2;
        final long j3;
        final long j4;
        final Function1 function3;
        final float f6;
        final float f7;
        final float f8;
        final Stroke stroke3;
        final Stroke stroke4;
        final float f9;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i8;
        Function1 function4;
        float f10;
        float f11;
        float f12;
        Function1 function5;
        long j5;
        boolean z2;
        Object objRememberedValue;
        int i9;
        boolean zChangedInstance;
        boolean zChangedInstance2;
        Stroke stroke5 = stroke;
        Stroke stroke6 = stroke2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(2019304030);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 4) == 0) {
            value = j;
            int i10 = gapComposer.changed(value) ? 256 : 128;
            i4 = i3 | i10;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    value2 = j2;
                    int i11 = gapComposer.changed(value2) ? 2048 : 1024;
                    i4 |= i11;
                } else {
                    value2 = j2;
                }
                i4 |= i11;
            } else {
                value2 = j2;
            }
            if ((i2 & 16) != 0) {
                i5 = 8192;
            } else {
                if ((32768 & i) == 0) {
                    zChangedInstance2 = gapComposer.changed(stroke5);
                } else {
                    zChangedInstance2 = gapComposer.changedInstance(stroke5);
                }
                if (zChangedInstance2) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
            }
            int i12 = i4 | i5;
            if ((i2 & 32) != 0) {
                i6 = 65536;
            } else {
                if ((262144 & i) == 0) {
                    zChangedInstance = gapComposer.changed(stroke6);
                } else {
                    zChangedInstance = gapComposer.changedInstance(stroke6);
                }
                if (zChangedInstance) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
            }
            i7 = i12 | i6 | 4718592;
            if ((100663296 & i) == 0) {
                if ((i2 & 256) == 0) {
                    function2 = function1;
                    int i13 = gapComposer.changedInstance(function2) ? 67108864 : 33554432;
                    i7 |= i13;
                } else {
                    function2 = function1;
                }
                i7 |= i13;
            } else {
                function2 = function1;
            }
            if ((805306368 & i) == 0) {
                if ((i2 & 512) == 0) {
                    f5 = f3;
                    if (gapComposer.changed(f5)) {
                        i9 = 536870912;
                    }
                    i7 |= i9;
                } else {
                    f5 = f3;
                }
                i9 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
                i7 |= i9;
            } else {
                f5 = f3;
            }
            if ((306783379 & i7) == 306783378) {
                z = false;
            } else {
                z = true;
            }
            if (gapComposer.shouldExecute(i7 & 1, z)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                    if ((i2 & 4) != 0) {
                        float f13 = WavyProgressIndicatorDefaults.LinearDeterminateWavelength;
                        value = ColorSchemeKt.getValue(25, gapComposer);
                        i7 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        float f14 = WavyProgressIndicatorDefaults.LinearDeterminateWavelength;
                        value2 = ColorSchemeKt.getValue(31, gapComposer);
                        i7 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        float f15 = WavyProgressIndicatorDefaults.LinearDeterminateWavelength;
                        i7 &= -57345;
                        stroke5 = new Stroke(((Density) gapComposer.consume(CompositionLocalsKt.LocalDensity)).mo81toPx0680j_4(4.0f), CropImageView.DEFAULT_ASPECT_RATIO, 1, 0, 26);
                    }
                    if ((i2 & 32) != 0) {
                        float f16 = WavyProgressIndicatorDefaults.LinearDeterminateWavelength;
                        stroke6 = new Stroke(((Density) gapComposer.consume(CompositionLocalsKt.LocalDensity)).mo81toPx0680j_4(4.0f), CropImageView.DEFAULT_ASPECT_RATIO, 1, 0, 26);
                        i7 &= -458753;
                    }
                    float f17 = WavyProgressIndicatorDefaults.LinearIndicatorTrackGapSize;
                    float f18 = WavyProgressIndicatorDefaults.LinearTrackStopIndicatorSize;
                    i8 = i7 & (-33030145);
                    if ((i2 & 256) != 0) {
                        function4 = WavyProgressIndicatorDefaults.indicatorAmplitude;
                        i8 = i7 & (-267911169);
                    } else {
                        function4 = function2;
                    }
                    if ((i2 & 512) != 0) {
                        f10 = WavyProgressIndicatorDefaults.LinearDeterminateWavelength;
                        i8 &= -1879048193;
                    } else {
                        f10 = f5;
                    }
                    f7 = f17;
                    f8 = f18;
                    f11 = f10;
                    f12 = f11;
                    stroke4 = stroke6;
                    function5 = function4;
                    j5 = value;
                    j4 = value2;
                } else {
                    gapComposer.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i7 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i7 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        i7 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i7 &= -458753;
                    }
                    int i14 = i7 & (-33030145);
                    if ((i2 & 256) != 0) {
                        i14 = i7 & (-267911169);
                    }
                    if ((i2 & 512) != 0) {
                        i14 &= -1879048193;
                    }
                    f12 = f4;
                    j5 = value;
                    j4 = value2;
                    i8 = i14;
                    stroke4 = stroke6;
                    function5 = function2;
                    f11 = f5;
                    f7 = f;
                    f8 = f2;
                }
                stroke3 = stroke5;
                gapComposer.endDefaults();
                modifier2 = modifier;
                Modifier modifierThen = modifier2.then(AccessibilityUtilKt.IncreaseVerticalSemanticsBounds);
                Function1 function6 = function5;
                long j6 = j5;
                z2 = (i8 & 14) == 4;
                objRememberedValue = gapComposer.rememberedValue();
                if (z2 || objRememberedValue == Composer.Companion.Empty) {
                    objRememberedValue = new AppBarKt$$ExternalSyntheticLambda8(function0, (byte) 8);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                j3 = j6;
                OffsetKt.Spacer(gapComposer, Icons$Filled.m374linearWavyProgressIndicatorbMBChCs(ClipKt.clipToBounds(SizeKt.m152sizeVpY3zN4(SemanticsModifierKt.semantics(modifierThen, true, (Function1) objRememberedValue), WavyProgressIndicatorDefaults.LinearContainerWidth, WavyProgressIndicatorDefaults.LinearContainerHeight)), function0, function6, j3, j4, stroke3, stroke4, f7, f8, f11, f12));
                f9 = f12;
                f6 = f11;
                function3 = function6;
            } else {
                modifier2 = modifier;
                gapComposer.skipToGroupEnd();
                j3 = value;
                j4 = value2;
                function3 = function2;
                f6 = f5;
                f7 = f;
                f8 = f2;
                stroke3 = stroke5;
                stroke4 = stroke6;
                f9 = f4;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                final Modifier modifier3 = modifier2;
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                        WavyProgressIndicatorKt.m364LinearWavyProgressIndicator1YwxWKA(function0, modifier3, j3, j4, stroke3, stroke4, f7, f8, function3, f6, f9, (Composer) obj, iUpdateChangedFlags, i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        value = j;
        i4 = i3 | i10;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                value2 = j2;
                if (gapComposer.changed(value2)) {
                }
                i4 |= i11;
            } else {
                value2 = j2;
            }
            i4 |= i11;
        } else {
            value2 = j2;
        }
        if ((i2 & 16) != 0) {
            i5 = 8192;
        } else {
            if ((32768 & i) == 0) {
                zChangedInstance2 = gapComposer.changed(stroke5);
            } else {
                zChangedInstance2 = gapComposer.changedInstance(stroke5);
            }
            if (zChangedInstance2) {
                i5 = 16384;
            } else {
                i5 = 8192;
            }
        }
        int i15 = i4 | i5;
        if ((i2 & 32) != 0) {
            i6 = 65536;
        } else {
            if ((262144 & i) == 0) {
                zChangedInstance = gapComposer.changed(stroke6);
            } else {
                zChangedInstance = gapComposer.changedInstance(stroke6);
            }
            if (zChangedInstance) {
                i6 = 131072;
            } else {
                i6 = 65536;
            }
        }
        i7 = i15 | i6 | 4718592;
        if ((100663296 & i) == 0) {
            if ((i2 & 256) == 0) {
                function2 = function1;
                if (gapComposer.changedInstance(function2)) {
                }
                i7 |= i13;
            } else {
                function2 = function1;
            }
            i7 |= i13;
        } else {
            function2 = function1;
        }
        if ((805306368 & i) == 0) {
            if ((i2 & 512) == 0) {
                f5 = f3;
                if (gapComposer.changed(f5)) {
                    i9 = 536870912;
                }
                i7 |= i9;
            } else {
                f5 = f3;
            }
            i9 = WebSocketDeflateExtensionKt.MAX_INFLATED_FRAME_SIZE;
            i7 |= i9;
        } else {
            f5 = f3;
        }
        if ((306783379 & i7) == 306783378) {
            z = false;
        } else {
            z = true;
        }
        if (gapComposer.shouldExecute(i7 & 1, z)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0) {
                if ((i2 & 4) != 0) {
                    float f19 = WavyProgressIndicatorDefaults.LinearDeterminateWavelength;
                    value = ColorSchemeKt.getValue(25, gapComposer);
                    i7 &= -897;
                }
                if ((i2 & 8) != 0) {
                    float f110 = WavyProgressIndicatorDefaults.LinearDeterminateWavelength;
                    value2 = ColorSchemeKt.getValue(31, gapComposer);
                    i7 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    float f111 = WavyProgressIndicatorDefaults.LinearDeterminateWavelength;
                    i7 &= -57345;
                    stroke5 = new Stroke(((Density) gapComposer.consume(CompositionLocalsKt.LocalDensity)).mo81toPx0680j_4(4.0f), CropImageView.DEFAULT_ASPECT_RATIO, 1, 0, 26);
                }
                if ((i2 & 32) != 0) {
                    float f112 = WavyProgressIndicatorDefaults.LinearDeterminateWavelength;
                    stroke6 = new Stroke(((Density) gapComposer.consume(CompositionLocalsKt.LocalDensity)).mo81toPx0680j_4(4.0f), CropImageView.DEFAULT_ASPECT_RATIO, 1, 0, 26);
                    i7 &= -458753;
                }
                float f113 = WavyProgressIndicatorDefaults.LinearIndicatorTrackGapSize;
                float f114 = WavyProgressIndicatorDefaults.LinearTrackStopIndicatorSize;
                i8 = i7 & (-33030145);
                if ((i2 & 256) != 0) {
                    function4 = WavyProgressIndicatorDefaults.indicatorAmplitude;
                    i8 = i7 & (-267911169);
                } else {
                    function4 = function2;
                }
                if ((i2 & 512) != 0) {
                    f10 = WavyProgressIndicatorDefaults.LinearDeterminateWavelength;
                    i8 &= -1879048193;
                } else {
                    f10 = f5;
                }
                f7 = f113;
                f8 = f114;
                f11 = f10;
                f12 = f11;
                stroke4 = stroke6;
                function5 = function4;
                j5 = value;
                j4 = value2;
            } else {
                if ((i2 & 4) != 0) {
                    float f115 = WavyProgressIndicatorDefaults.LinearDeterminateWavelength;
                    value = ColorSchemeKt.getValue(25, gapComposer);
                    i7 &= -897;
                }
                if ((i2 & 8) != 0) {
                    float f116 = WavyProgressIndicatorDefaults.LinearDeterminateWavelength;
                    value2 = ColorSchemeKt.getValue(31, gapComposer);
                    i7 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    float f117 = WavyProgressIndicatorDefaults.LinearDeterminateWavelength;
                    i7 &= -57345;
                    stroke5 = new Stroke(((Density) gapComposer.consume(CompositionLocalsKt.LocalDensity)).mo81toPx0680j_4(4.0f), CropImageView.DEFAULT_ASPECT_RATIO, 1, 0, 26);
                }
                if ((i2 & 32) != 0) {
                    float f118 = WavyProgressIndicatorDefaults.LinearDeterminateWavelength;
                    stroke6 = new Stroke(((Density) gapComposer.consume(CompositionLocalsKt.LocalDensity)).mo81toPx0680j_4(4.0f), CropImageView.DEFAULT_ASPECT_RATIO, 1, 0, 26);
                    i7 &= -458753;
                }
                float f119 = WavyProgressIndicatorDefaults.LinearIndicatorTrackGapSize;
                float f1110 = WavyProgressIndicatorDefaults.LinearTrackStopIndicatorSize;
                i8 = i7 & (-33030145);
                if ((i2 & 256) != 0) {
                    function4 = WavyProgressIndicatorDefaults.indicatorAmplitude;
                    i8 = i7 & (-267911169);
                } else {
                    function4 = function2;
                }
                if ((i2 & 512) != 0) {
                    f10 = WavyProgressIndicatorDefaults.LinearDeterminateWavelength;
                    i8 &= -1879048193;
                } else {
                    f10 = f5;
                }
                f7 = f119;
                f8 = f1110;
                f11 = f10;
                f12 = f11;
                stroke4 = stroke6;
                function5 = function4;
                j5 = value;
                j4 = value2;
            }
            stroke3 = stroke5;
            gapComposer.endDefaults();
            modifier2 = modifier;
            Modifier modifierThen2 = modifier2.then(AccessibilityUtilKt.IncreaseVerticalSemanticsBounds);
            Function1 function7 = function5;
            long j7 = j5;
            if ((i8 & 14) == 4) {
            }
            objRememberedValue = gapComposer.rememberedValue();
            if (z2) {
                objRememberedValue = new AppBarKt$$ExternalSyntheticLambda8(function0, (byte) 8);
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new AppBarKt$$ExternalSyntheticLambda8(function0, (byte) 8);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            j3 = j7;
            OffsetKt.Spacer(gapComposer, Icons$Filled.m374linearWavyProgressIndicatorbMBChCs(ClipKt.clipToBounds(SizeKt.m152sizeVpY3zN4(SemanticsModifierKt.semantics(modifierThen2, true, (Function1) objRememberedValue), WavyProgressIndicatorDefaults.LinearContainerWidth, WavyProgressIndicatorDefaults.LinearContainerHeight)), function0, function7, j3, j4, stroke3, stroke4, f7, f8, f11, f12));
            f9 = f12;
            f6 = f11;
            function3 = function7;
        } else {
            modifier2 = modifier;
            gapComposer.skipToGroupEnd();
            j3 = value;
            j4 = value2;
            function3 = function2;
            f6 = f5;
            f7 = f;
            f8 = f2;
            stroke3 = stroke5;
            stroke4 = stroke6;
            f9 = f4;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    WavyProgressIndicatorKt.m364LinearWavyProgressIndicator1YwxWKA(function0, modifier4, j3, j4, stroke3, stroke4, f7, f8, function3, f6, f9, (Composer) obj, iUpdateChangedFlags, i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
