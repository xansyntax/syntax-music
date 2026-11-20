package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathParserKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class IconKt {
    public static final Modifier DefaultIconSizeModifier = SizeKt.m151size3ABfNKs(Modifier.Companion.$$INSTANCE, 24.0f);

    /* JADX WARN: Code duplicated, block: B:100:0x0178  */
    /* JADX WARN: Code duplicated, block: B:103:0x0183  */
    /* JADX WARN: Code duplicated, block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x005b  */
    /* JADX WARN: Code duplicated, block: B:38:0x0069  */
    /* JADX WARN: Code duplicated, block: B:40:0x006d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x0077  */
    /* JADX WARN: Code duplicated, block: B:47:0x0080  */
    /* JADX WARN: Code duplicated, block: B:56:0x009f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:74:0x00de  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:83:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:89:0x0107  */
    /* JADX WARN: Code duplicated, block: B:91:0x011b  */
    /* JADX WARN: Code duplicated, block: B:94:0x0139  */
    /* JADX WARN: Code duplicated, block: B:98:0x015b  */
    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m290Iconww6aTOc(Painter painter, String str, Modifier modifier, long j, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        long j2;
        boolean z;
        Modifier modifier3;
        long j3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i4;
        Modifier modifier4;
        long j4;
        boolean z2;
        Object objRememberedValue;
        BlendModeColorFilter blendModeColorFilter;
        Modifier modifier5;
        long jMo573getIntrinsicSizeNHjbRc;
        boolean z3;
        boolean z4;
        Object obj;
        int i5;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-2142239481);
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? gapComposer.changed(painter) : gapComposer.changedInstance(painter) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer.changed(str) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= gapComposer.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                j2 = j;
                if ((i2 & 8) == 0 || !gapComposer.changed(j2)) {
                    i5 = 1024;
                } else {
                    i5 = 2048;
                }
                i3 |= i5;
            } else {
                j2 = j;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i3 & 1, z)) {
                gapComposer.startDefaults();
                i4 = i & 1;
                modifier4 = Modifier.Companion.$$INSTANCE;
                if (i4 != 0 || gapComposer.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        modifier2 = modifier4;
                    }
                    if ((i2 & 8) != 0) {
                        j2 = ((Color) gapComposer.consume(ContentColorKt.LocalContentColor)).value;
                        i3 &= -7169;
                    }
                } else {
                    gapComposer.skipToGroupEnd();
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                }
                j4 = j2;
                Modifier modifier6 = modifier2;
                gapComposer.endDefaults();
                z2 = (((i3 & 7168) ^ 3072) <= 2048 && gapComposer.changed(j4)) || (i3 & 3072) == 2048;
                objRememberedValue = gapComposer.rememberedValue();
                NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
                if (z2 || objRememberedValue == neverEqualPolicy) {
                    if (ULong.m1869equalsimpl0(j4, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified))) {
                        blendModeColorFilter = null;
                    } else {
                        blendModeColorFilter = new BlendModeColorFilter(j4, 5);
                    }
                    objRememberedValue = blendModeColorFilter;
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                BlendModeColorFilter blendModeColorFilter2 = (BlendModeColorFilter) objRememberedValue;
                if (str != null) {
                    gapComposer.startReplaceGroup(-537002883);
                    if ((i3 & 112) == 32) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (!z3 || objRememberedValue2 == neverEqualPolicy) {
                        z4 = false;
                        IconKt$$ExternalSyntheticLambda1 iconKt$$ExternalSyntheticLambda1 = new IconKt$$ExternalSyntheticLambda1(str, false ? 1 : 0);
                        gapComposer.updateRememberedValue(iconKt$$ExternalSyntheticLambda1);
                        obj = iconKt$$ExternalSyntheticLambda1;
                    } else {
                        z4 = false;
                        obj = objRememberedValue2;
                    }
                    Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier4, z4, (Function1) obj);
                    gapComposer.end(z4);
                    modifier5 = modifierSemantics;
                } else {
                    gapComposer.startReplaceGroup(-536844101);
                    gapComposer.end(false);
                    modifier5 = modifier4;
                }
                if (Size.m447equalsimpl0(painter.mo573getIntrinsicSizeNHjbRc(), 9205357640488583168L)) {
                    modifier4 = DefaultIconSizeModifier;
                } else {
                    jMo573getIntrinsicSizeNHjbRc = painter.mo573getIntrinsicSizeNHjbRc();
                    if (Float.isInfinite(Float.intBitsToFloat((int) (jMo573getIntrinsicSizeNHjbRc >> 32))) && Float.isInfinite(Float.intBitsToFloat((int) (jMo573getIntrinsicSizeNHjbRc & 4294967295L)))) {
                        modifier4 = DefaultIconSizeModifier;
                    }
                }
                BoxKt.Box(ClipKt.paint$default(modifier6.then(modifier4), painter, ContentScale.Companion.Fit, CropImageView.DEFAULT_ASPECT_RATIO, blendModeColorFilter2, 22).then(modifier5), gapComposer, 0);
                modifier3 = modifier6;
                j3 = j4;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = j2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new IconKt$$ExternalSyntheticLambda2(painter, str, modifier3, j3, i, i2);
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            j2 = j;
            if ((i2 & 8) == 0) {
                i5 = 1024;
            } else {
                i5 = 1024;
            }
            i3 |= i5;
        } else {
            j2 = j;
        }
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer.shouldExecute(i3 & 1, z)) {
            gapComposer.startDefaults();
            i4 = i & 1;
            modifier4 = Modifier.Companion.$$INSTANCE;
            if (i4 != 0) {
                if (i6 != 0) {
                    modifier2 = modifier4;
                }
                if ((i2 & 8) != 0) {
                    j2 = ((Color) gapComposer.consume(ContentColorKt.LocalContentColor)).value;
                    i3 &= -7169;
                }
            } else {
                if (i6 != 0) {
                    modifier2 = modifier4;
                }
                if ((i2 & 8) != 0) {
                    j2 = ((Color) gapComposer.consume(ContentColorKt.LocalContentColor)).value;
                    i3 &= -7169;
                }
            }
            j4 = j2;
            Modifier modifier7 = modifier2;
            gapComposer.endDefaults();
            if (((i3 & 7168) ^ 3072) <= 2048) {
            }
            objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy2 = Composer.Companion.Empty;
            if (z2) {
                if (ULong.m1869equalsimpl0(j4, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified))) {
                    blendModeColorFilter = null;
                } else {
                    blendModeColorFilter = new BlendModeColorFilter(j4, 5);
                }
                objRememberedValue = blendModeColorFilter;
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                if (ULong.m1869equalsimpl0(j4, ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified))) {
                    blendModeColorFilter = null;
                } else {
                    blendModeColorFilter = new BlendModeColorFilter(j4, 5);
                }
                objRememberedValue = blendModeColorFilter;
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            BlendModeColorFilter blendModeColorFilter3 = (BlendModeColorFilter) objRememberedValue;
            if (str != null) {
                gapComposer.startReplaceGroup(-537002883);
                if ((i3 & 112) == 32) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (z3) {
                    z4 = false;
                    IconKt$$ExternalSyntheticLambda1 iconKt$$ExternalSyntheticLambda2 = new IconKt$$ExternalSyntheticLambda1(str, false ? 1 : 0);
                    gapComposer.updateRememberedValue(iconKt$$ExternalSyntheticLambda2);
                    obj = iconKt$$ExternalSyntheticLambda2;
                } else {
                    z4 = false;
                    IconKt$$ExternalSyntheticLambda1 iconKt$$ExternalSyntheticLambda3 = new IconKt$$ExternalSyntheticLambda1(str, false ? 1 : 0);
                    gapComposer.updateRememberedValue(iconKt$$ExternalSyntheticLambda3);
                    obj = iconKt$$ExternalSyntheticLambda3;
                }
                Modifier modifierSemantics2 = SemanticsModifierKt.semantics(modifier4, z4, (Function1) obj);
                gapComposer.end(z4);
                modifier5 = modifierSemantics2;
            } else {
                gapComposer.startReplaceGroup(-536844101);
                gapComposer.end(false);
                modifier5 = modifier4;
            }
            if (Size.m447equalsimpl0(painter.mo573getIntrinsicSizeNHjbRc(), 9205357640488583168L)) {
                jMo573getIntrinsicSizeNHjbRc = painter.mo573getIntrinsicSizeNHjbRc();
                if (Float.isInfinite(Float.intBitsToFloat((int) (jMo573getIntrinsicSizeNHjbRc >> 32)))) {
                    modifier4 = DefaultIconSizeModifier;
                }
            } else {
                modifier4 = DefaultIconSizeModifier;
            }
            BoxKt.Box(ClipKt.paint$default(modifier7.then(modifier4), painter, ContentScale.Companion.Fit, CropImageView.DEFAULT_ASPECT_RATIO, blendModeColorFilter3, 22).then(modifier5), gapComposer, 0);
            modifier3 = modifier7;
            j3 = j4;
        } else {
            gapComposer.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = j2;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new IconKt$$ExternalSyntheticLambda2(painter, str, modifier3, j3, i, i2);
        }
    }

    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m291Iconww6aTOc(final ImageVector imageVector, String str, Modifier modifier, long j, Composer composer, final int i, final int i2) {
        int i3;
        String str2;
        final long j2;
        final Modifier modifier2;
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-126890956);
        int i4 = (gapComposer.changed(imageVector) ? 4 : 2) | i;
        if ((i & 48) == 0) {
            i4 |= gapComposer.changed(str) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 = i4 | 384;
        } else {
            i3 = i4 | (gapComposer.changed(modifier) ? 256 : 128);
        }
        int i6 = i3 | 1024;
        if (gapComposer.shouldExecute(i6 & 1, (i6 & 1171) != 1170)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0 && !gapComposer.getDefaultsInvalid()) {
                gapComposer.skipToGroupEnd();
            } else {
                if (i5 != 0) {
                    modifier = Modifier.Companion.$$INSTANCE;
                }
                j = ((Color) gapComposer.consume(ContentColorKt.LocalContentColor)).value;
            }
            int i7 = i6 & (-7169);
            Modifier modifier3 = modifier;
            long j3 = j;
            gapComposer.endDefaults();
            str2 = str;
            m290Iconww6aTOc(PathParserKt.rememberVectorPainter(imageVector, gapComposer), str2, modifier3, j3, gapComposer, (i7 & 112) | 8 | (i7 & 896), 0);
            modifier2 = modifier3;
            j2 = j3;
        } else {
            str2 = str;
            gapComposer.skipToGroupEnd();
            j2 = j;
            modifier2 = modifier;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final String str3 = str2;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.IconKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    IconKt.m291Iconww6aTOc(imageVector, str3, modifier2, j2, (Composer) obj, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
