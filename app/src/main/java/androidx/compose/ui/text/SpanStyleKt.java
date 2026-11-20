package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BrushStyle;
import androidx.compose.ui.text.style.ColorStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.InlineClassHelperKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import coil3.util.LifecyclesKt;
import com.google.common.math.IntMath;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SpanStyleKt {
    public static final long DefaultFontSize = IntMath.getSp(14);
    public static final long DefaultLetterSpacing = IntMath.getSp(0);
    public static final TextForegroundStyle DefaultColorForegroundStyle = new ColorStyle(-72057594037927936L);

    /* JADX WARN: Code duplicated, block: B:102:0x016d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:103:0x016f  */
    /* JADX WARN: Code duplicated, block: B:106:0x0174 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:113:0x0184  */
    /* JADX WARN: Code duplicated, block: B:115:0x0189  */
    /* JADX WARN: Code duplicated, block: B:116:0x018c  */
    /* JADX WARN: Code duplicated, block: B:118:0x0190  */
    /* JADX WARN: Code duplicated, block: B:119:0x0193  */
    /* JADX WARN: Code duplicated, block: B:121:0x0197  */
    /* JADX WARN: Code duplicated, block: B:122:0x019a  */
    /* JADX WARN: Code duplicated, block: B:124:0x019d  */
    /* JADX WARN: Code duplicated, block: B:126:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:129:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:131:0x01af  */
    /* JADX WARN: Code duplicated, block: B:133:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:134:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:137:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:138:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:141:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:142:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:145:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:146:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:148:0x01da  */
    /* JADX WARN: Code duplicated, block: B:149:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:152:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:154:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:80:0x0110  */
    /* JADX WARN: Code duplicated, block: B:82:0x0114  */
    /* JADX WARN: Code duplicated, block: B:84:0x0123  */
    /* JADX WARN: Code duplicated, block: B:85:0x0129  */
    /* JADX WARN: Code duplicated, block: B:86:0x012b  */
    /* JADX WARN: Code duplicated, block: B:88:0x0131  */
    /* JADX WARN: Code duplicated, block: B:89:0x013b  */
    /* JADX WARN: Code duplicated, block: B:91:0x0140  */
    /* JADX WARN: Code duplicated, block: B:93:0x0144  */
    /* JADX WARN: Code duplicated, block: B:96:0x0152  */
    /* JADX INFO: renamed from: fastMerge-dSHsh3o, reason: not valid java name */
    public static final SpanStyle m734fastMergedSHsh3o(SpanStyle spanStyle, long j, Brush brush, float f, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        BaselineShift baselineShift2;
        Shadow shadow2;
        PlatformSpanStyle platformSpanStyle2;
        DrawStyle drawStyle2;
        TextForegroundStyle.Unspecified unspecified;
        TextForegroundStyle colorStyle;
        TextForegroundStyle textForegroundStyle;
        boolean z;
        long j5;
        FontWeight fontWeight2;
        FontStyle fontStyle2;
        TextGeometricTransform textGeometricTransform2;
        LocaleList localeList2;
        long j6;
        TextDecoration textDecoration2;
        Shadow shadow3;
        PlatformSpanStyle platformSpanStyle3;
        long jM901modulateDxMtmZc;
        FontSynthesis fontSynthesis2 = fontSynthesis;
        FontFamily fontFamily2 = fontFamily;
        String str2 = str;
        long j7 = j3;
        long j8 = j2 & 1095216660480L;
        if ((j8 == 0 || TextUnit.m812equalsimpl0(j2, spanStyle.fontSize)) && ((brush != null || j == 16 || ULong.m1869equalsimpl0(j, spanStyle.textForegroundStyle.mo768getColor0d7_KjU())) && ((fontStyle == null || fontStyle.equals(spanStyle.fontStyle)) && ((fontWeight == null || fontWeight.equals(spanStyle.fontWeight)) && ((fontFamily2 == null || fontFamily2 == spanStyle.fontFamily) && (((j7 & 1095216660480L) == 0 || TextUnit.m812equalsimpl0(j7, spanStyle.letterSpacing)) && ((textDecoration == null || textDecoration.equals(spanStyle.textDecoration)) && Intrinsics.areEqual(brush, spanStyle.textForegroundStyle.getBrush()) && ((brush == null || f == spanStyle.textForegroundStyle.getAlpha()) && ((fontSynthesis2 == null || fontSynthesis2.equals(spanStyle.fontSynthesis)) && (str2 == null || str2.equals(spanStyle.fontFeatureSettings))))))))))) {
            if (baselineShift != null) {
                baselineShift2 = baselineShift;
                if (baselineShift2.equals(spanStyle.baselineShift)) {
                }
                unspecified = TextForegroundStyle.Unspecified.INSTANCE;
                if (brush != null) {
                    if (brush instanceof SolidColor) {
                        jM901modulateDxMtmZc = IntMath.m901modulateDxMtmZc(((SolidColor) brush).value, f);
                        if (jM901modulateDxMtmZc != 16) {
                            colorStyle = new ColorStyle(jM901modulateDxMtmZc);
                        } else {
                            colorStyle = unspecified;
                        }
                    } else {
                        if (!(brush instanceof ShaderBrush)) {
                            PathKt$$ExternalSyntheticBUOutline0.m$1();
                            return null;
                        }
                        colorStyle = new BrushStyle((ShaderBrush) brush, f);
                    }
                } else if (j != 16) {
                    colorStyle = new ColorStyle(j);
                } else {
                    colorStyle = unspecified;
                }
                textForegroundStyle = spanStyle.textForegroundStyle;
                textForegroundStyle.getClass();
                z = colorStyle instanceof BrushStyle;
                if (!z && (textForegroundStyle instanceof BrushStyle)) {
                    BrushStyle brushStyle = (BrushStyle) colorStyle;
                    ShaderBrush shaderBrush = brushStyle.value;
                    float f2 = brushStyle.alpha;
                    if (Float.isNaN(f2)) {
                        f2 = ((BrushStyle) textForegroundStyle).alpha;
                    }
                    colorStyle = new BrushStyle(shaderBrush, f2);
                } else if ((z || (textForegroundStyle instanceof BrushStyle)) && ((!z && (textForegroundStyle instanceof BrushStyle)) || colorStyle.equals(unspecified))) {
                }
                if (fontFamily2 == null) {
                    fontFamily2 = spanStyle.fontFamily;
                }
                if (j8 == 0) {
                    j5 = spanStyle.fontSize;
                } else {
                    j5 = j2;
                }
                if (fontWeight == null) {
                    fontWeight2 = spanStyle.fontWeight;
                } else {
                    fontWeight2 = fontWeight;
                }
                if (fontStyle == null) {
                    fontStyle2 = spanStyle.fontStyle;
                } else {
                    fontStyle2 = fontStyle;
                }
                if (fontSynthesis2 == null) {
                    fontSynthesis2 = spanStyle.fontSynthesis;
                }
                if (str2 == null) {
                    str2 = spanStyle.fontFeatureSettings;
                }
                if ((j7 & 1095216660480L) == 0) {
                    j7 = spanStyle.letterSpacing;
                }
                if (baselineShift2 == null) {
                    baselineShift2 = spanStyle.baselineShift;
                }
                if (textGeometricTransform == null) {
                    textGeometricTransform2 = spanStyle.textGeometricTransform;
                } else {
                    textGeometricTransform2 = textGeometricTransform;
                }
                long j9 = j5;
                if (localeList == null) {
                    localeList2 = spanStyle.localeList;
                } else {
                    localeList2 = localeList;
                }
                if (j4 != 16) {
                    j6 = j4;
                } else {
                    j6 = spanStyle.background;
                }
                long j10 = j6;
                if (textDecoration == null) {
                    textDecoration2 = spanStyle.textDecoration;
                } else {
                    textDecoration2 = textDecoration;
                }
                if (shadow2 == null) {
                    shadow3 = spanStyle.shadow;
                } else {
                    shadow3 = shadow2;
                }
                platformSpanStyle3 = spanStyle.platformStyle;
                if (platformSpanStyle3 == null) {
                    platformSpanStyle3 = platformSpanStyle2;
                }
                if (drawStyle2 == null) {
                    drawStyle2 = spanStyle.drawStyle;
                }
                return new SpanStyle(colorStyle, j9, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str2, j7, baselineShift2, textGeometricTransform2, localeList2, j10, textDecoration2, shadow3, platformSpanStyle3, drawStyle2);
            }
            baselineShift2 = baselineShift;
            if (textGeometricTransform == null || textGeometricTransform.equals(spanStyle.textGeometricTransform)) {
                if (localeList == null || localeList.equals(spanStyle.localeList)) {
                    if (j4 == 16 || ULong.m1869equalsimpl0(j4, spanStyle.background)) {
                        shadow2 = shadow;
                        if (shadow2 == null || shadow2.equals(spanStyle.shadow)) {
                            platformSpanStyle2 = platformSpanStyle;
                            if (platformSpanStyle2 == null || platformSpanStyle2.equals(spanStyle.platformStyle)) {
                                drawStyle2 = drawStyle;
                                if (drawStyle2 == null || drawStyle2.equals(spanStyle.drawStyle)) {
                                    return spanStyle;
                                }
                            }
                        }
                        drawStyle2 = drawStyle;
                    }
                    platformSpanStyle2 = platformSpanStyle;
                    drawStyle2 = drawStyle;
                }
            }
            unspecified = TextForegroundStyle.Unspecified.INSTANCE;
            if (brush != null) {
                if (brush instanceof SolidColor) {
                    jM901modulateDxMtmZc = IntMath.m901modulateDxMtmZc(((SolidColor) brush).value, f);
                    if (jM901modulateDxMtmZc != 16) {
                        colorStyle = new ColorStyle(jM901modulateDxMtmZc);
                    } else {
                        colorStyle = unspecified;
                    }
                } else {
                    if (!(brush instanceof ShaderBrush)) {
                        PathKt$$ExternalSyntheticBUOutline0.m$1();
                        return null;
                    }
                    colorStyle = new BrushStyle((ShaderBrush) brush, f);
                }
            } else if (j != 16) {
                colorStyle = new ColorStyle(j);
            } else {
                colorStyle = unspecified;
            }
            textForegroundStyle = spanStyle.textForegroundStyle;
            textForegroundStyle.getClass();
            z = colorStyle instanceof BrushStyle;
            if (!z) {
                colorStyle = z ? textForegroundStyle : textForegroundStyle;
            } else if (z) {
            }
            if (fontFamily2 == null) {
                fontFamily2 = spanStyle.fontFamily;
            }
            if (j8 == 0) {
                j5 = spanStyle.fontSize;
            } else {
                j5 = j2;
            }
            if (fontWeight == null) {
                fontWeight2 = spanStyle.fontWeight;
            } else {
                fontWeight2 = fontWeight;
            }
            if (fontStyle == null) {
                fontStyle2 = spanStyle.fontStyle;
            } else {
                fontStyle2 = fontStyle;
            }
            if (fontSynthesis2 == null) {
                fontSynthesis2 = spanStyle.fontSynthesis;
            }
            if (str2 == null) {
                str2 = spanStyle.fontFeatureSettings;
            }
            if ((j7 & 1095216660480L) == 0) {
                j7 = spanStyle.letterSpacing;
            }
            if (baselineShift2 == null) {
                baselineShift2 = spanStyle.baselineShift;
            }
            if (textGeometricTransform == null) {
                textGeometricTransform2 = spanStyle.textGeometricTransform;
            } else {
                textGeometricTransform2 = textGeometricTransform;
            }
            long j11 = j5;
            if (localeList == null) {
                localeList2 = spanStyle.localeList;
            } else {
                localeList2 = localeList;
            }
            if (j4 != 16) {
                j6 = j4;
            } else {
                j6 = spanStyle.background;
            }
            long j12 = j6;
            if (textDecoration == null) {
                textDecoration2 = spanStyle.textDecoration;
            } else {
                textDecoration2 = textDecoration;
            }
            if (shadow2 == null) {
                shadow3 = spanStyle.shadow;
            } else {
                shadow3 = shadow2;
            }
            platformSpanStyle3 = spanStyle.platformStyle;
            if (platformSpanStyle3 == null) {
                platformSpanStyle3 = platformSpanStyle2;
            }
            if (drawStyle2 == null) {
                drawStyle2 = spanStyle.drawStyle;
            }
            return new SpanStyle(colorStyle, j11, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str2, j7, baselineShift2, textGeometricTransform2, localeList2, j12, textDecoration2, shadow3, platformSpanStyle3, drawStyle2);
        }
        baselineShift2 = baselineShift;
        shadow2 = shadow;
        platformSpanStyle2 = platformSpanStyle;
        drawStyle2 = drawStyle;
        unspecified = TextForegroundStyle.Unspecified.INSTANCE;
        if (brush != null) {
            if (brush instanceof SolidColor) {
                jM901modulateDxMtmZc = IntMath.m901modulateDxMtmZc(((SolidColor) brush).value, f);
                if (jM901modulateDxMtmZc != 16) {
                    colorStyle = new ColorStyle(jM901modulateDxMtmZc);
                } else {
                    colorStyle = unspecified;
                }
            } else {
                if (!(brush instanceof ShaderBrush)) {
                    PathKt$$ExternalSyntheticBUOutline0.m$1();
                    return null;
                }
                colorStyle = new BrushStyle((ShaderBrush) brush, f);
            }
        } else if (j != 16) {
            colorStyle = new ColorStyle(j);
        } else {
            colorStyle = unspecified;
        }
        textForegroundStyle = spanStyle.textForegroundStyle;
        textForegroundStyle.getClass();
        z = colorStyle instanceof BrushStyle;
        if (!z) {
            if (z) {
            }
        } else if (z) {
        }
        if (fontFamily2 == null) {
            fontFamily2 = spanStyle.fontFamily;
        }
        if (j8 == 0) {
            j5 = spanStyle.fontSize;
        } else {
            j5 = j2;
        }
        if (fontWeight == null) {
            fontWeight2 = spanStyle.fontWeight;
        } else {
            fontWeight2 = fontWeight;
        }
        if (fontStyle == null) {
            fontStyle2 = spanStyle.fontStyle;
        } else {
            fontStyle2 = fontStyle;
        }
        if (fontSynthesis2 == null) {
            fontSynthesis2 = spanStyle.fontSynthesis;
        }
        if (str2 == null) {
            str2 = spanStyle.fontFeatureSettings;
        }
        if ((j7 & 1095216660480L) == 0) {
            j7 = spanStyle.letterSpacing;
        }
        if (baselineShift2 == null) {
            baselineShift2 = spanStyle.baselineShift;
        }
        if (textGeometricTransform == null) {
            textGeometricTransform2 = spanStyle.textGeometricTransform;
        } else {
            textGeometricTransform2 = textGeometricTransform;
        }
        long j13 = j5;
        if (localeList == null) {
            localeList2 = spanStyle.localeList;
        } else {
            localeList2 = localeList;
        }
        if (j4 != 16) {
            j6 = j4;
        } else {
            j6 = spanStyle.background;
        }
        long j14 = j6;
        if (textDecoration == null) {
            textDecoration2 = spanStyle.textDecoration;
        } else {
            textDecoration2 = textDecoration;
        }
        if (shadow2 == null) {
            shadow3 = spanStyle.shadow;
        } else {
            shadow3 = shadow2;
        }
        platformSpanStyle3 = spanStyle.platformStyle;
        if (platformSpanStyle3 == null) {
            platformSpanStyle3 = platformSpanStyle2;
        }
        if (drawStyle2 == null) {
            drawStyle2 = spanStyle.drawStyle;
        }
        return new SpanStyle(colorStyle, j13, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str2, j7, baselineShift2, textGeometricTransform2, localeList2, j14, textDecoration2, shadow3, platformSpanStyle3, drawStyle2);
    }

    public static final Object lerpDiscrete(Object obj, Object obj2, float f) {
        return ((double) f) < 0.5d ? obj : obj2;
    }

    /* JADX INFO: renamed from: lerpTextUnitInheritable-C3pnCVY, reason: not valid java name */
    public static final long m735lerpTextUnitInheritableC3pnCVY(long j, long j2, float f) {
        long j3 = j & 1095216660480L;
        if (j3 != 0) {
            long j4 = 1095216660480L & j2;
            if (j4 != 0) {
                if (j3 == 0 || j4 == 0) {
                    InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for Unspecified type.");
                }
                if (!TextUnitType.m816equalsimpl0(TextUnit.m813getTypeUIouoOA(j), TextUnit.m813getTypeUIouoOA(j2))) {
                    InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for " + TextUnitType.m817toStringimpl(TextUnit.m813getTypeUIouoOA(j)) + " and " + TextUnitType.m817toStringimpl(TextUnit.m813getTypeUIouoOA(j2)));
                }
                return IntMath.pack(j3, LifecyclesKt.lerp(TextUnit.m814getValueimpl(j), TextUnit.m814getValueimpl(j2), f));
            }
        }
        return ((TextUnit) lerpDiscrete(new TextUnit(j), new TextUnit(j2), f)).packedValue;
    }
}
