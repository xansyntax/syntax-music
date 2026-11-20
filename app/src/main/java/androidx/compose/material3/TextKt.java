package androidx.compose.material3;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import com.google.common.math.IntMath;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.utils.io.ByteChannelKt;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TextKt {
    public static final StaticProvidableCompositionLocal LocalTextStyle = new StaticProvidableCompositionLocal(new TextKt$$ExternalSyntheticLambda3((byte) 0), (byte) 1);

    public static final void ProvideTextStyle(final TextStyle textStyle, final Function2 function2, Composer composer, final int i) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(15327438);
        int i2 = (gapComposer.changed(textStyle) ? 4 : 2) | i;
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 32 : 16;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = LocalTextStyle;
            Stack.CompositionLocalProvider(staticProvidableCompositionLocal.defaultProvidedValue$runtime(((TextStyle) gapComposer.consume(staticProvidableCompositionLocal)).merge(textStyle)), function2, gapComposer, (i2 & 112) | 8);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    TextKt.ProvideTextStyle(textStyle, function2, (Composer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x013a  */
    /* JADX WARN: Code duplicated, block: B:102:0x013f  */
    /* JADX WARN: Code duplicated, block: B:104:0x0143  */
    /* JADX WARN: Code duplicated, block: B:106:0x014b  */
    /* JADX WARN: Code duplicated, block: B:107:0x014e  */
    /* JADX WARN: Code duplicated, block: B:111:0x0158  */
    /* JADX WARN: Code duplicated, block: B:112:0x015b  */
    /* JADX WARN: Code duplicated, block: B:114:0x0161  */
    /* JADX WARN: Code duplicated, block: B:116:0x0169  */
    /* JADX WARN: Code duplicated, block: B:117:0x016c  */
    /* JADX WARN: Code duplicated, block: B:120:0x0173  */
    /* JADX WARN: Code duplicated, block: B:123:0x017c  */
    /* JADX WARN: Code duplicated, block: B:125:0x0183  */
    /* JADX WARN: Code duplicated, block: B:127:0x0189  */
    /* JADX WARN: Code duplicated, block: B:129:0x0191  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:138:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:142:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:145:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:147:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:154:0x01fd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:155:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:156:0x0202  */
    /* JADX WARN: Code duplicated, block: B:158:0x0206  */
    /* JADX WARN: Code duplicated, block: B:159:0x020e  */
    /* JADX WARN: Code duplicated, block: B:162:0x0217  */
    /* JADX WARN: Code duplicated, block: B:165:0x021f  */
    /* JADX WARN: Code duplicated, block: B:167:0x0223  */
    /* JADX WARN: Code duplicated, block: B:169:0x0227  */
    /* JADX WARN: Code duplicated, block: B:171:0x022b  */
    /* JADX WARN: Code duplicated, block: B:172:0x0230  */
    /* JADX WARN: Code duplicated, block: B:175:0x0235  */
    /* JADX WARN: Code duplicated, block: B:177:0x0239  */
    /* JADX WARN: Code duplicated, block: B:178:0x023e  */
    /* JADX WARN: Code duplicated, block: B:180:0x0242  */
    /* JADX WARN: Code duplicated, block: B:182:0x0246  */
    /* JADX WARN: Code duplicated, block: B:183:0x0249  */
    /* JADX WARN: Code duplicated, block: B:185:0x024d  */
    /* JADX WARN: Code duplicated, block: B:186:0x0251  */
    /* JADX WARN: Code duplicated, block: B:189:0x0257  */
    /* JADX WARN: Code duplicated, block: B:191:0x026b  */
    /* JADX WARN: Code duplicated, block: B:194:0x027d  */
    /* JADX WARN: Code duplicated, block: B:195:0x0283  */
    /* JADX WARN: Code duplicated, block: B:197:0x0291  */
    /* JADX WARN: Code duplicated, block: B:199:0x0295  */
    /* JADX WARN: Code duplicated, block: B:203:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:205:0x0322  */
    /* JADX WARN: Code duplicated, block: B:208:0x0342  */
    /* JADX WARN: Code duplicated, block: B:210:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0043  */
    /* JADX WARN: Code duplicated, block: B:24:0x0048  */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:29:0x0057  */
    /* JADX WARN: Code duplicated, block: B:33:0x0065  */
    /* JADX WARN: Code duplicated, block: B:34:0x006a  */
    /* JADX WARN: Code duplicated, block: B:36:0x0070  */
    /* JADX WARN: Code duplicated, block: B:38:0x0076  */
    /* JADX WARN: Code duplicated, block: B:39:0x0079  */
    /* JADX WARN: Code duplicated, block: B:43:0x0085  */
    /* JADX WARN: Code duplicated, block: B:44:0x008a  */
    /* JADX WARN: Code duplicated, block: B:46:0x0090  */
    /* JADX WARN: Code duplicated, block: B:48:0x0096  */
    /* JADX WARN: Code duplicated, block: B:49:0x0099  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:83:0x0101  */
    /* JADX WARN: Code duplicated, block: B:84:0x0108  */
    /* JADX WARN: Code duplicated, block: B:86:0x0112  */
    /* JADX WARN: Code duplicated, block: B:87:0x0115  */
    /* JADX WARN: Code duplicated, block: B:91:0x011d  */
    /* JADX WARN: Code duplicated, block: B:93:0x0126  */
    /* JADX WARN: Code duplicated, block: B:95:0x012e  */
    /* JADX WARN: Code duplicated, block: B:96:0x0131  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r46v1 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX INFO: renamed from: Text-Nvy7gAk, reason: not valid java name */
    public static final void m352TextNvy7gAk(final String str, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j3, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, TextStyle textStyle, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        long jPack;
        int i12;
        int i13;
        final FontStyle fontStyle2;
        int i14;
        int i15;
        FontWeight fontWeight2;
        int i16;
        int i17;
        int i18;
        FontFamily fontFamily2;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        int i40;
        boolean z2;
        final Modifier modifier2;
        final long j5;
        final TextAlign textAlign2;
        final boolean z3;
        final int i41;
        final int i42;
        final TextStyle textStyle2;
        final FontWeight fontWeight3;
        final FontFamily fontFamily3;
        final long j6;
        final int i43;
        final long j7;
        final long j8;
        GapComposer gapComposer;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Modifier modifier3;
        long jColor;
        long jPack2;
        long jPack3;
        boolean z4;
        int i44;
        TextStyle textStyle3;
        int i45;
        int i46;
        long j9;
        TextAlign textAlign3;
        long jM752getColor0d7_KjU;
        boolean z5;
        ?? r4;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(1809465675);
        if ((i4 & 6) == 0) {
            i7 = (gapComposer2.changed(str) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i47 = i6 & 2;
        if (i47 == 0) {
            if ((i4 & 48) == 0) {
                i7 |= gapComposer2.changed(modifier) ? 32 : 16;
            }
            i8 = i6 & 4;
            if (i8 != 0) {
                i7 |= 384;
            } else if ((i4 & 384) == 0) {
                if (gapComposer2.changed(j)) {
                    i9 = 256;
                } else {
                    i9 = 128;
                }
                i7 |= i9;
            }
            i10 = i7 | 3072;
            i11 = i6 & 16;
            if (i11 != 0) {
                i10 = i7 | 27648;
                jPack = j2;
            } else {
                jPack = j2;
                if ((i4 & 24576) == 0) {
                    if (gapComposer2.changed(jPack)) {
                        i12 = 16384;
                    } else {
                        i12 = 8192;
                    }
                    i10 |= i12;
                }
            }
            i13 = i6 & 32;
            if (i13 != 0) {
                i10 |= 196608;
                fontStyle2 = fontStyle;
            } else {
                fontStyle2 = fontStyle;
                if ((i4 & 196608) == 0) {
                    if (gapComposer2.changed(fontStyle2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i10 |= i14;
                }
            }
            i15 = i6 & 64;
            if (i15 != 0) {
                i10 |= 1572864;
                fontWeight2 = fontWeight;
            } else {
                fontWeight2 = fontWeight;
                if ((i4 & 1572864) == 0) {
                    if (gapComposer2.changed(fontWeight2)) {
                        i16 = ByteChannelKt.CHANNEL_MAX_SIZE;
                    } else {
                        i16 = 524288;
                    }
                    i10 |= i16;
                }
            }
            i17 = i6 & 128;
            i18 = 4194304;
            if (i17 != 0) {
                i10 |= 12582912;
                fontFamily2 = fontFamily;
            } else {
                fontFamily2 = fontFamily;
                if ((i4 & 12582912) == 0) {
                    if (gapComposer2.changed(fontFamily2)) {
                        i19 = 8388608;
                    } else {
                        i19 = 4194304;
                    }
                    i10 |= i19;
                }
            }
            i20 = i6 & 256;
            if (i20 != 0) {
                i10 |= 100663296;
            } else if ((i4 & 100663296) == 0) {
                if (gapComposer2.changed(j3)) {
                    i21 = 67108864;
                } else {
                    i21 = 33554432;
                }
                i10 |= i21;
            }
            i22 = 805306368 | i10;
            i23 = i6 & 1024;
            if (i23 != 0) {
                i25 = i5 | 6;
            } else {
                if (gapComposer2.changed(textAlign)) {
                    i24 = 4;
                } else {
                    i24 = 2;
                }
                i25 = i5 | i24;
            }
            i26 = i6 & 2048;
            if (i26 != 0) {
                i28 = i25 | 48;
            } else {
                if (gapComposer2.changed(j4)) {
                    i27 = 32;
                } else {
                    i27 = 16;
                }
                i28 = i25 | i27;
            }
            i29 = i28;
            i30 = i6 & 4096;
            if (i30 != 0) {
                if ((i5 & 384) == 0) {
                    i31 = i;
                    if (gapComposer2.changed(i31)) {
                        i32 = 256;
                    } else {
                        i32 = 128;
                    }
                    i29 |= i32;
                }
                i33 = i6 & 8192;
                if (i33 != 0) {
                    i35 = i29 | 3072;
                } else {
                    i34 = i29;
                    if ((i5 & 3072) != 0) {
                        if (gapComposer2.changed(z)) {
                            i36 = 2048;
                        } else {
                            i36 = 1024;
                        }
                        i34 |= i36;
                    }
                    i35 = i34;
                }
                i37 = i6 & 16384;
                if (i37 != 0) {
                    i38 = i35;
                    if ((i5 & 24576) == 0) {
                        i38 |= gapComposer2.changed(i2) ? 16384 : 8192;
                    }
                    int i48 = i38 | 1769472;
                    if ((i6 & 131072) == 0 && gapComposer2.changed(textStyle)) {
                        i18 = 8388608;
                    }
                    i39 = i48 | i18;
                    i40 = 1;
                    if ((i22 & 306783379) == 306783378 || (i39 & 4793491) != 4793490) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (gapComposer2.shouldExecute(i22 & 1, z2)) {
                        gapComposer2.startDefaults();
                        if ((i4 & 1) != 0 || gapComposer2.getDefaultsInvalid()) {
                            if (i47 != 0) {
                                modifier3 = Modifier.Companion.$$INSTANCE;
                            } else {
                                modifier3 = modifier;
                            }
                            if (i8 != 0) {
                                jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                            } else {
                                jColor = j;
                            }
                            if (i11 != 0) {
                                jPack = IntMath.pack(0L, Float.NaN);
                            }
                            if (i13 != 0) {
                                fontStyle2 = null;
                            }
                            if (i15 != 0) {
                                fontWeight2 = null;
                            }
                            if (i17 != 0) {
                                fontFamily2 = null;
                            }
                            if (i20 != 0) {
                                jPack2 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack2 = j3;
                            }
                            TextAlign textAlign4 = i23 == 0 ? textAlign : null;
                            if (i26 != 0) {
                                jPack3 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack3 = j4;
                            }
                            if (i30 != 0) {
                                i31 = 1;
                            }
                            if (i33 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i37 != 0) {
                                i44 = Integer.MAX_VALUE;
                            } else {
                                i44 = i2;
                            }
                            if ((i6 & 131072) != 0) {
                                i39 &= -29360129;
                                textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                            } else {
                                textStyle3 = textStyle;
                            }
                            i45 = i44;
                            i46 = i31;
                            j9 = jPack3;
                            textAlign3 = textAlign4;
                        } else {
                            gapComposer2.skipToGroupEnd();
                            if ((i6 & 131072) != 0) {
                                i39 &= -29360129;
                            }
                            modifier3 = modifier;
                            jColor = j;
                            jPack2 = j3;
                            textAlign3 = textAlign;
                            z4 = z;
                            i45 = i2;
                            i40 = i3;
                            textStyle3 = textStyle;
                            i46 = i31;
                            j9 = j4;
                        }
                        gapComposer2.endDefaults();
                        gapComposer2.startReplaceGroup(-565217490);
                        if (jColor != 16) {
                            j9 = j9;
                            jM752getColor0d7_KjU = jColor;
                            z5 = false;
                        } else {
                            gapComposer2.startReplaceGroup(-565216717);
                            jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                            if (jM752getColor0d7_KjU != 16) {
                                jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                            }
                            z5 = false;
                            gapComposer2.end(false);
                        }
                        gapComposer2.end(z5);
                        r4 = z5;
                        if (textAlign3 != null) {
                            r4 = textAlign3.value;
                        }
                        TextStyle textStyle4 = textStyle3;
                        int i49 = i39 << 6;
                        Modifier modifier4 = modifier3;
                        int i50 = i46;
                        int i51 = i45;
                        BasicTextKt.m187BasicTextRWo7tUw(str, modifier4, TextStyle.m751mergedA7vx0o$default(textStyle4, jM752getColor0d7_KjU, jPack, fontWeight2, fontStyle2, fontFamily2, jPack2, r4 == true ? 1 : 0, j9, 16609104), i50, z4, i51, i40, gapComposer2, ((i22 << 18) & 1879048192) | (i22 & 126) | 3072 | (i49 & 57344) | (i49 & 458752) | (i49 & 3670016) | 12582912, 256);
                        modifier2 = modifier4;
                        gapComposer = gapComposer2;
                        z3 = z4;
                        fontWeight3 = fontWeight2;
                        j6 = j9;
                        textAlign2 = textAlign3;
                        i41 = i51;
                        fontFamily3 = fontFamily2;
                        i42 = i40;
                        i43 = i50;
                        textStyle2 = textStyle4;
                        j7 = jPack;
                        j5 = jColor;
                        j8 = jPack2;
                    } else {
                        GapComposer gapComposer3 = gapComposer2;
                        gapComposer3.skipToGroupEnd();
                        modifier2 = modifier;
                        j5 = j;
                        textAlign2 = textAlign;
                        z3 = z;
                        i41 = i2;
                        i42 = i3;
                        textStyle2 = textStyle;
                        fontWeight3 = fontWeight2;
                        fontFamily3 = fontFamily2;
                        j6 = j4;
                        i43 = i31;
                        j7 = jPack;
                        j8 = j3;
                        gapComposer = gapComposer3;
                    }
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                                String str2 = str;
                                Modifier modifier5 = modifier2;
                                long j10 = j5;
                                long j11 = j7;
                                FontStyle fontStyle3 = fontStyle2;
                                FontWeight fontWeight4 = fontWeight3;
                                FontFamily fontFamily4 = fontFamily3;
                                long j12 = j8;
                                TextAlign textAlign5 = textAlign2;
                                long j13 = j6;
                                byte b = i43;
                                boolean z6 = z3;
                                int i52 = i41;
                                boolean z7 = i42;
                                TextStyle textStyle5 = textStyle2;
                                int i53 = i6;
                                TextKt.m352TextNvy7gAk(str2, modifier5, j10, j11, fontStyle3, fontWeight4, fontFamily4, j12, textAlign5, j13, b, z6, i52, z7 ? 1 : 0, textStyle5, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i53);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i38 = i35 | 24576;
                int i410 = i38 | 1769472;
                if ((i6 & 131072) == 0) {
                    i18 = 8388608;
                }
                i39 = i410 | i18;
                i40 = 1;
                if ((i22 & 306783379) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (gapComposer2.shouldExecute(i22 & 1, z2)) {
                    gapComposer2.startDefaults();
                    if ((i4 & 1) != 0) {
                        if (i47 != 0) {
                            modifier3 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i8 != 0) {
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        } else {
                            jColor = j;
                        }
                        if (i11 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i13 != 0) {
                            fontStyle2 = null;
                        }
                        if (i15 != 0) {
                            fontWeight2 = null;
                        }
                        if (i17 != 0) {
                            fontFamily2 = null;
                        }
                        if (i20 != 0) {
                            jPack2 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack2 = j3;
                        }
                        if (i23 == 0) {
                        }
                        if (i26 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j4;
                        }
                        if (i30 != 0) {
                            i31 = 1;
                        }
                        if (i33 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i37 != 0) {
                            i44 = Integer.MAX_VALUE;
                        } else {
                            i44 = i2;
                        }
                        if ((i6 & 131072) != 0) {
                            i39 &= -29360129;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        i45 = i44;
                        i46 = i31;
                        j9 = jPack3;
                        textAlign3 = textAlign4;
                    } else {
                        if (i47 != 0) {
                            modifier3 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i8 != 0) {
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        } else {
                            jColor = j;
                        }
                        if (i11 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i13 != 0) {
                            fontStyle2 = null;
                        }
                        if (i15 != 0) {
                            fontWeight2 = null;
                        }
                        if (i17 != 0) {
                            fontFamily2 = null;
                        }
                        if (i20 != 0) {
                            jPack2 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack2 = j3;
                        }
                        if (i23 == 0) {
                        }
                        if (i26 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j4;
                        }
                        if (i30 != 0) {
                            i31 = 1;
                        }
                        if (i33 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i37 != 0) {
                            i44 = Integer.MAX_VALUE;
                        } else {
                            i44 = i2;
                        }
                        if ((i6 & 131072) != 0) {
                            i39 &= -29360129;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        i45 = i44;
                        i46 = i31;
                        j9 = jPack3;
                        textAlign3 = textAlign4;
                    }
                    gapComposer2.endDefaults();
                    gapComposer2.startReplaceGroup(-565217490);
                    if (jColor != 16) {
                        j9 = j9;
                        jM752getColor0d7_KjU = jColor;
                        z5 = false;
                    } else {
                        gapComposer2.startReplaceGroup(-565216717);
                        jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                        if (jM752getColor0d7_KjU != 16) {
                            jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                        }
                        z5 = false;
                        gapComposer2.end(false);
                    }
                    gapComposer2.end(z5);
                    r4 = z5;
                    if (textAlign3 != null) {
                        r4 = textAlign3.value;
                    }
                    TextStyle textStyle5 = textStyle3;
                    int i411 = i39 << 6;
                    Modifier modifier5 = modifier3;
                    int i52 = i46;
                    int i53 = i45;
                    BasicTextKt.m187BasicTextRWo7tUw(str, modifier5, TextStyle.m751mergedA7vx0o$default(textStyle5, jM752getColor0d7_KjU, jPack, fontWeight2, fontStyle2, fontFamily2, jPack2, r4 == true ? 1 : 0, j9, 16609104), i52, z4, i53, i40, gapComposer2, ((i22 << 18) & 1879048192) | (i22 & 126) | 3072 | (i411 & 57344) | (i411 & 458752) | (i411 & 3670016) | 12582912, 256);
                    modifier2 = modifier5;
                    gapComposer = gapComposer2;
                    z3 = z4;
                    fontWeight3 = fontWeight2;
                    j6 = j9;
                    textAlign2 = textAlign3;
                    i41 = i53;
                    fontFamily3 = fontFamily2;
                    i42 = i40;
                    i43 = i52;
                    textStyle2 = textStyle5;
                    j7 = jPack;
                    j5 = jColor;
                    j8 = jPack2;
                } else {
                    GapComposer gapComposer4 = gapComposer2;
                    gapComposer4.skipToGroupEnd();
                    modifier2 = modifier;
                    j5 = j;
                    textAlign2 = textAlign;
                    z3 = z;
                    i41 = i2;
                    i42 = i3;
                    textStyle2 = textStyle;
                    fontWeight3 = fontWeight2;
                    fontFamily3 = fontFamily2;
                    j6 = j4;
                    i43 = i31;
                    j7 = jPack;
                    j8 = j3;
                    gapComposer = gapComposer4;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                            String str2 = str;
                            Modifier modifier6 = modifier2;
                            long j10 = j5;
                            long j11 = j7;
                            FontStyle fontStyle3 = fontStyle2;
                            FontWeight fontWeight4 = fontWeight3;
                            FontFamily fontFamily4 = fontFamily3;
                            long j12 = j8;
                            TextAlign textAlign5 = textAlign2;
                            long j13 = j6;
                            byte b = i43;
                            boolean z6 = z3;
                            int i54 = i41;
                            boolean z7 = i42;
                            TextStyle textStyle6 = textStyle2;
                            int i55 = i6;
                            TextKt.m352TextNvy7gAk(str2, modifier6, j10, j11, fontStyle3, fontWeight4, fontFamily4, j12, textAlign5, j13, b, z6, i54, z7 ? 1 : 0, textStyle6, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i55);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i29 |= 384;
            i31 = i;
            i33 = i6 & 8192;
            if (i33 != 0) {
                i35 = i29 | 3072;
            } else {
                i34 = i29;
                if ((i5 & 3072) != 0) {
                    if (gapComposer2.changed(z)) {
                        i36 = 2048;
                    } else {
                        i36 = 1024;
                    }
                    i34 |= i36;
                }
                i35 = i34;
            }
            i37 = i6 & 16384;
            if (i37 != 0) {
                i38 = i35;
                if ((i5 & 24576) == 0) {
                    i38 |= gapComposer2.changed(i2) ? 16384 : 8192;
                }
                int i412 = i38 | 1769472;
                if ((i6 & 131072) == 0) {
                    i18 = 8388608;
                }
                i39 = i412 | i18;
                i40 = 1;
                if ((i22 & 306783379) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (gapComposer2.shouldExecute(i22 & 1, z2)) {
                    gapComposer2.startDefaults();
                    if ((i4 & 1) != 0) {
                        if (i47 != 0) {
                            modifier3 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i8 != 0) {
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        } else {
                            jColor = j;
                        }
                        if (i11 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i13 != 0) {
                            fontStyle2 = null;
                        }
                        if (i15 != 0) {
                            fontWeight2 = null;
                        }
                        if (i17 != 0) {
                            fontFamily2 = null;
                        }
                        if (i20 != 0) {
                            jPack2 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack2 = j3;
                        }
                        if (i23 == 0) {
                        }
                        if (i26 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j4;
                        }
                        if (i30 != 0) {
                            i31 = 1;
                        }
                        if (i33 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i37 != 0) {
                            i44 = Integer.MAX_VALUE;
                        } else {
                            i44 = i2;
                        }
                        if ((i6 & 131072) != 0) {
                            i39 &= -29360129;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        i45 = i44;
                        i46 = i31;
                        j9 = jPack3;
                        textAlign3 = textAlign4;
                    } else {
                        if (i47 != 0) {
                            modifier3 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i8 != 0) {
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        } else {
                            jColor = j;
                        }
                        if (i11 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i13 != 0) {
                            fontStyle2 = null;
                        }
                        if (i15 != 0) {
                            fontWeight2 = null;
                        }
                        if (i17 != 0) {
                            fontFamily2 = null;
                        }
                        if (i20 != 0) {
                            jPack2 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack2 = j3;
                        }
                        if (i23 == 0) {
                        }
                        if (i26 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j4;
                        }
                        if (i30 != 0) {
                            i31 = 1;
                        }
                        if (i33 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i37 != 0) {
                            i44 = Integer.MAX_VALUE;
                        } else {
                            i44 = i2;
                        }
                        if ((i6 & 131072) != 0) {
                            i39 &= -29360129;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        i45 = i44;
                        i46 = i31;
                        j9 = jPack3;
                        textAlign3 = textAlign4;
                    }
                    gapComposer2.endDefaults();
                    gapComposer2.startReplaceGroup(-565217490);
                    if (jColor != 16) {
                        j9 = j9;
                        jM752getColor0d7_KjU = jColor;
                        z5 = false;
                    } else {
                        gapComposer2.startReplaceGroup(-565216717);
                        jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                        if (jM752getColor0d7_KjU != 16) {
                            jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                        }
                        z5 = false;
                        gapComposer2.end(false);
                    }
                    gapComposer2.end(z5);
                    r4 = z5;
                    if (textAlign3 != null) {
                        r4 = textAlign3.value;
                    }
                    TextStyle textStyle6 = textStyle3;
                    int i413 = i39 << 6;
                    Modifier modifier6 = modifier3;
                    int i54 = i46;
                    int i55 = i45;
                    BasicTextKt.m187BasicTextRWo7tUw(str, modifier6, TextStyle.m751mergedA7vx0o$default(textStyle6, jM752getColor0d7_KjU, jPack, fontWeight2, fontStyle2, fontFamily2, jPack2, r4 == true ? 1 : 0, j9, 16609104), i54, z4, i55, i40, gapComposer2, ((i22 << 18) & 1879048192) | (i22 & 126) | 3072 | (i413 & 57344) | (i413 & 458752) | (i413 & 3670016) | 12582912, 256);
                    modifier2 = modifier6;
                    gapComposer = gapComposer2;
                    z3 = z4;
                    fontWeight3 = fontWeight2;
                    j6 = j9;
                    textAlign2 = textAlign3;
                    i41 = i55;
                    fontFamily3 = fontFamily2;
                    i42 = i40;
                    i43 = i54;
                    textStyle2 = textStyle6;
                    j7 = jPack;
                    j5 = jColor;
                    j8 = jPack2;
                } else {
                    GapComposer gapComposer5 = gapComposer2;
                    gapComposer5.skipToGroupEnd();
                    modifier2 = modifier;
                    j5 = j;
                    textAlign2 = textAlign;
                    z3 = z;
                    i41 = i2;
                    i42 = i3;
                    textStyle2 = textStyle;
                    fontWeight3 = fontWeight2;
                    fontFamily3 = fontFamily2;
                    j6 = j4;
                    i43 = i31;
                    j7 = jPack;
                    j8 = j3;
                    gapComposer = gapComposer5;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                            String str2 = str;
                            Modifier modifier7 = modifier2;
                            long j10 = j5;
                            long j11 = j7;
                            FontStyle fontStyle3 = fontStyle2;
                            FontWeight fontWeight4 = fontWeight3;
                            FontFamily fontFamily4 = fontFamily3;
                            long j12 = j8;
                            TextAlign textAlign5 = textAlign2;
                            long j13 = j6;
                            byte b = i43;
                            boolean z6 = z3;
                            int i56 = i41;
                            boolean z7 = i42;
                            TextStyle textStyle7 = textStyle2;
                            int i57 = i6;
                            TextKt.m352TextNvy7gAk(str2, modifier7, j10, j11, fontStyle3, fontWeight4, fontFamily4, j12, textAlign5, j13, b, z6, i56, z7 ? 1 : 0, textStyle7, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i57);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i38 = i35 | 24576;
            int i414 = i38 | 1769472;
            if ((i6 & 131072) == 0) {
                i18 = 8388608;
            }
            i39 = i414 | i18;
            i40 = 1;
            if ((i22 & 306783379) == 306783378) {
                z2 = true;
            } else {
                z2 = true;
            }
            if (gapComposer2.shouldExecute(i22 & 1, z2)) {
                gapComposer2.startDefaults();
                if ((i4 & 1) != 0) {
                    if (i47 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i8 != 0) {
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                    } else {
                        jColor = j;
                    }
                    if (i11 != 0) {
                        jPack = IntMath.pack(0L, Float.NaN);
                    }
                    if (i13 != 0) {
                        fontStyle2 = null;
                    }
                    if (i15 != 0) {
                        fontWeight2 = null;
                    }
                    if (i17 != 0) {
                        fontFamily2 = null;
                    }
                    if (i20 != 0) {
                        jPack2 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack2 = j3;
                    }
                    if (i23 == 0) {
                    }
                    if (i26 != 0) {
                        jPack3 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack3 = j4;
                    }
                    if (i30 != 0) {
                        i31 = 1;
                    }
                    if (i33 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i37 != 0) {
                        i44 = Integer.MAX_VALUE;
                    } else {
                        i44 = i2;
                    }
                    if ((i6 & 131072) != 0) {
                        i39 &= -29360129;
                        textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                    } else {
                        textStyle3 = textStyle;
                    }
                    i45 = i44;
                    i46 = i31;
                    j9 = jPack3;
                    textAlign3 = textAlign4;
                } else {
                    if (i47 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i8 != 0) {
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                    } else {
                        jColor = j;
                    }
                    if (i11 != 0) {
                        jPack = IntMath.pack(0L, Float.NaN);
                    }
                    if (i13 != 0) {
                        fontStyle2 = null;
                    }
                    if (i15 != 0) {
                        fontWeight2 = null;
                    }
                    if (i17 != 0) {
                        fontFamily2 = null;
                    }
                    if (i20 != 0) {
                        jPack2 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack2 = j3;
                    }
                    if (i23 == 0) {
                    }
                    if (i26 != 0) {
                        jPack3 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack3 = j4;
                    }
                    if (i30 != 0) {
                        i31 = 1;
                    }
                    if (i33 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i37 != 0) {
                        i44 = Integer.MAX_VALUE;
                    } else {
                        i44 = i2;
                    }
                    if ((i6 & 131072) != 0) {
                        i39 &= -29360129;
                        textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                    } else {
                        textStyle3 = textStyle;
                    }
                    i45 = i44;
                    i46 = i31;
                    j9 = jPack3;
                    textAlign3 = textAlign4;
                }
                gapComposer2.endDefaults();
                gapComposer2.startReplaceGroup(-565217490);
                if (jColor != 16) {
                    j9 = j9;
                    jM752getColor0d7_KjU = jColor;
                    z5 = false;
                } else {
                    gapComposer2.startReplaceGroup(-565216717);
                    jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                    if (jM752getColor0d7_KjU != 16) {
                        jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                    }
                    z5 = false;
                    gapComposer2.end(false);
                }
                gapComposer2.end(z5);
                r4 = z5;
                if (textAlign3 != null) {
                    r4 = textAlign3.value;
                }
                TextStyle textStyle7 = textStyle3;
                int i415 = i39 << 6;
                Modifier modifier7 = modifier3;
                int i56 = i46;
                int i57 = i45;
                BasicTextKt.m187BasicTextRWo7tUw(str, modifier7, TextStyle.m751mergedA7vx0o$default(textStyle7, jM752getColor0d7_KjU, jPack, fontWeight2, fontStyle2, fontFamily2, jPack2, r4 == true ? 1 : 0, j9, 16609104), i56, z4, i57, i40, gapComposer2, ((i22 << 18) & 1879048192) | (i22 & 126) | 3072 | (i415 & 57344) | (i415 & 458752) | (i415 & 3670016) | 12582912, 256);
                modifier2 = modifier7;
                gapComposer = gapComposer2;
                z3 = z4;
                fontWeight3 = fontWeight2;
                j6 = j9;
                textAlign2 = textAlign3;
                i41 = i57;
                fontFamily3 = fontFamily2;
                i42 = i40;
                i43 = i56;
                textStyle2 = textStyle7;
                j7 = jPack;
                j5 = jColor;
                j8 = jPack2;
            } else {
                GapComposer gapComposer6 = gapComposer2;
                gapComposer6.skipToGroupEnd();
                modifier2 = modifier;
                j5 = j;
                textAlign2 = textAlign;
                z3 = z;
                i41 = i2;
                i42 = i3;
                textStyle2 = textStyle;
                fontWeight3 = fontWeight2;
                fontFamily3 = fontFamily2;
                j6 = j4;
                i43 = i31;
                j7 = jPack;
                j8 = j3;
                gapComposer = gapComposer6;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                        String str2 = str;
                        Modifier modifier8 = modifier2;
                        long j10 = j5;
                        long j11 = j7;
                        FontStyle fontStyle3 = fontStyle2;
                        FontWeight fontWeight4 = fontWeight3;
                        FontFamily fontFamily4 = fontFamily3;
                        long j12 = j8;
                        TextAlign textAlign5 = textAlign2;
                        long j13 = j6;
                        byte b = i43;
                        boolean z6 = z3;
                        int i58 = i41;
                        boolean z7 = i42;
                        TextStyle textStyle8 = textStyle2;
                        int i59 = i6;
                        TextKt.m352TextNvy7gAk(str2, modifier8, j10, j11, fontStyle3, fontWeight4, fontFamily4, j12, textAlign5, j13, b, z6, i58, z7 ? 1 : 0, textStyle8, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i59);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i7 |= 48;
        i8 = i6 & 4;
        if (i8 != 0) {
            i7 |= 384;
        } else if ((i4 & 384) == 0) {
            if (gapComposer2.changed(j)) {
                i9 = 256;
            } else {
                i9 = 128;
            }
            i7 |= i9;
        }
        i10 = i7 | 3072;
        i11 = i6 & 16;
        if (i11 != 0) {
            i10 = i7 | 27648;
            jPack = j2;
        } else {
            jPack = j2;
            if ((i4 & 24576) == 0) {
                if (gapComposer2.changed(jPack)) {
                    i12 = 16384;
                } else {
                    i12 = 8192;
                }
                i10 |= i12;
            }
        }
        i13 = i6 & 32;
        if (i13 != 0) {
            i10 |= 196608;
            fontStyle2 = fontStyle;
        } else {
            fontStyle2 = fontStyle;
            if ((i4 & 196608) == 0) {
                if (gapComposer2.changed(fontStyle2)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i10 |= i14;
            }
        }
        i15 = i6 & 64;
        if (i15 != 0) {
            i10 |= 1572864;
            fontWeight2 = fontWeight;
        } else {
            fontWeight2 = fontWeight;
            if ((i4 & 1572864) == 0) {
                if (gapComposer2.changed(fontWeight2)) {
                    i16 = ByteChannelKt.CHANNEL_MAX_SIZE;
                } else {
                    i16 = 524288;
                }
                i10 |= i16;
            }
        }
        i17 = i6 & 128;
        i18 = 4194304;
        if (i17 != 0) {
            i10 |= 12582912;
            fontFamily2 = fontFamily;
        } else {
            fontFamily2 = fontFamily;
            if ((i4 & 12582912) == 0) {
                if (gapComposer2.changed(fontFamily2)) {
                    i19 = 8388608;
                } else {
                    i19 = 4194304;
                }
                i10 |= i19;
            }
        }
        i20 = i6 & 256;
        if (i20 != 0) {
            i10 |= 100663296;
        } else if ((i4 & 100663296) == 0) {
            if (gapComposer2.changed(j3)) {
                i21 = 67108864;
            } else {
                i21 = 33554432;
            }
            i10 |= i21;
        }
        i22 = 805306368 | i10;
        i23 = i6 & 1024;
        if (i23 != 0) {
            i25 = i5 | 6;
        } else {
            if (gapComposer2.changed(textAlign)) {
                i24 = 4;
            } else {
                i24 = 2;
            }
            i25 = i5 | i24;
        }
        i26 = i6 & 2048;
        if (i26 != 0) {
            i28 = i25 | 48;
        } else {
            if (gapComposer2.changed(j4)) {
                i27 = 32;
            } else {
                i27 = 16;
            }
            i28 = i25 | i27;
        }
        i29 = i28;
        i30 = i6 & 4096;
        if (i30 != 0) {
            if ((i5 & 384) == 0) {
                i31 = i;
                if (gapComposer2.changed(i31)) {
                    i32 = 256;
                } else {
                    i32 = 128;
                }
                i29 |= i32;
            }
            i33 = i6 & 8192;
            if (i33 != 0) {
                i35 = i29 | 3072;
            } else {
                i34 = i29;
                if ((i5 & 3072) != 0) {
                    if (gapComposer2.changed(z)) {
                        i36 = 2048;
                    } else {
                        i36 = 1024;
                    }
                    i34 |= i36;
                }
                i35 = i34;
            }
            i37 = i6 & 16384;
            if (i37 != 0) {
                i38 = i35;
                if ((i5 & 24576) == 0) {
                    i38 |= gapComposer2.changed(i2) ? 16384 : 8192;
                }
                int i416 = i38 | 1769472;
                if ((i6 & 131072) == 0) {
                    i18 = 8388608;
                }
                i39 = i416 | i18;
                i40 = 1;
                if ((i22 & 306783379) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (gapComposer2.shouldExecute(i22 & 1, z2)) {
                    gapComposer2.startDefaults();
                    if ((i4 & 1) != 0) {
                        if (i47 != 0) {
                            modifier3 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i8 != 0) {
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        } else {
                            jColor = j;
                        }
                        if (i11 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i13 != 0) {
                            fontStyle2 = null;
                        }
                        if (i15 != 0) {
                            fontWeight2 = null;
                        }
                        if (i17 != 0) {
                            fontFamily2 = null;
                        }
                        if (i20 != 0) {
                            jPack2 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack2 = j3;
                        }
                        if (i23 == 0) {
                        }
                        if (i26 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j4;
                        }
                        if (i30 != 0) {
                            i31 = 1;
                        }
                        if (i33 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i37 != 0) {
                            i44 = Integer.MAX_VALUE;
                        } else {
                            i44 = i2;
                        }
                        if ((i6 & 131072) != 0) {
                            i39 &= -29360129;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        i45 = i44;
                        i46 = i31;
                        j9 = jPack3;
                        textAlign3 = textAlign4;
                    } else {
                        if (i47 != 0) {
                            modifier3 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier3 = modifier;
                        }
                        if (i8 != 0) {
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        } else {
                            jColor = j;
                        }
                        if (i11 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i13 != 0) {
                            fontStyle2 = null;
                        }
                        if (i15 != 0) {
                            fontWeight2 = null;
                        }
                        if (i17 != 0) {
                            fontFamily2 = null;
                        }
                        if (i20 != 0) {
                            jPack2 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack2 = j3;
                        }
                        if (i23 == 0) {
                        }
                        if (i26 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j4;
                        }
                        if (i30 != 0) {
                            i31 = 1;
                        }
                        if (i33 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i37 != 0) {
                            i44 = Integer.MAX_VALUE;
                        } else {
                            i44 = i2;
                        }
                        if ((i6 & 131072) != 0) {
                            i39 &= -29360129;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        i45 = i44;
                        i46 = i31;
                        j9 = jPack3;
                        textAlign3 = textAlign4;
                    }
                    gapComposer2.endDefaults();
                    gapComposer2.startReplaceGroup(-565217490);
                    if (jColor != 16) {
                        j9 = j9;
                        jM752getColor0d7_KjU = jColor;
                        z5 = false;
                    } else {
                        gapComposer2.startReplaceGroup(-565216717);
                        jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                        if (jM752getColor0d7_KjU != 16) {
                            jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                        }
                        z5 = false;
                        gapComposer2.end(false);
                    }
                    gapComposer2.end(z5);
                    r4 = z5;
                    if (textAlign3 != null) {
                        r4 = textAlign3.value;
                    }
                    TextStyle textStyle8 = textStyle3;
                    int i417 = i39 << 6;
                    Modifier modifier8 = modifier3;
                    int i58 = i46;
                    int i59 = i45;
                    BasicTextKt.m187BasicTextRWo7tUw(str, modifier8, TextStyle.m751mergedA7vx0o$default(textStyle8, jM752getColor0d7_KjU, jPack, fontWeight2, fontStyle2, fontFamily2, jPack2, r4 == true ? 1 : 0, j9, 16609104), i58, z4, i59, i40, gapComposer2, ((i22 << 18) & 1879048192) | (i22 & 126) | 3072 | (i417 & 57344) | (i417 & 458752) | (i417 & 3670016) | 12582912, 256);
                    modifier2 = modifier8;
                    gapComposer = gapComposer2;
                    z3 = z4;
                    fontWeight3 = fontWeight2;
                    j6 = j9;
                    textAlign2 = textAlign3;
                    i41 = i59;
                    fontFamily3 = fontFamily2;
                    i42 = i40;
                    i43 = i58;
                    textStyle2 = textStyle8;
                    j7 = jPack;
                    j5 = jColor;
                    j8 = jPack2;
                } else {
                    GapComposer gapComposer7 = gapComposer2;
                    gapComposer7.skipToGroupEnd();
                    modifier2 = modifier;
                    j5 = j;
                    textAlign2 = textAlign;
                    z3 = z;
                    i41 = i2;
                    i42 = i3;
                    textStyle2 = textStyle;
                    fontWeight3 = fontWeight2;
                    fontFamily3 = fontFamily2;
                    j6 = j4;
                    i43 = i31;
                    j7 = jPack;
                    j8 = j3;
                    gapComposer = gapComposer7;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                            String str2 = str;
                            Modifier modifier9 = modifier2;
                            long j10 = j5;
                            long j11 = j7;
                            FontStyle fontStyle3 = fontStyle2;
                            FontWeight fontWeight4 = fontWeight3;
                            FontFamily fontFamily4 = fontFamily3;
                            long j12 = j8;
                            TextAlign textAlign5 = textAlign2;
                            long j13 = j6;
                            byte b = i43;
                            boolean z6 = z3;
                            int i510 = i41;
                            boolean z7 = i42;
                            TextStyle textStyle9 = textStyle2;
                            int i511 = i6;
                            TextKt.m352TextNvy7gAk(str2, modifier9, j10, j11, fontStyle3, fontWeight4, fontFamily4, j12, textAlign5, j13, b, z6, i510, z7 ? 1 : 0, textStyle9, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i511);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i38 = i35 | 24576;
            int i418 = i38 | 1769472;
            if ((i6 & 131072) == 0) {
                i18 = 8388608;
            }
            i39 = i418 | i18;
            i40 = 1;
            if ((i22 & 306783379) == 306783378) {
                z2 = true;
            } else {
                z2 = true;
            }
            if (gapComposer2.shouldExecute(i22 & 1, z2)) {
                gapComposer2.startDefaults();
                if ((i4 & 1) != 0) {
                    if (i47 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i8 != 0) {
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                    } else {
                        jColor = j;
                    }
                    if (i11 != 0) {
                        jPack = IntMath.pack(0L, Float.NaN);
                    }
                    if (i13 != 0) {
                        fontStyle2 = null;
                    }
                    if (i15 != 0) {
                        fontWeight2 = null;
                    }
                    if (i17 != 0) {
                        fontFamily2 = null;
                    }
                    if (i20 != 0) {
                        jPack2 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack2 = j3;
                    }
                    if (i23 == 0) {
                    }
                    if (i26 != 0) {
                        jPack3 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack3 = j4;
                    }
                    if (i30 != 0) {
                        i31 = 1;
                    }
                    if (i33 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i37 != 0) {
                        i44 = Integer.MAX_VALUE;
                    } else {
                        i44 = i2;
                    }
                    if ((i6 & 131072) != 0) {
                        i39 &= -29360129;
                        textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                    } else {
                        textStyle3 = textStyle;
                    }
                    i45 = i44;
                    i46 = i31;
                    j9 = jPack3;
                    textAlign3 = textAlign4;
                } else {
                    if (i47 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i8 != 0) {
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                    } else {
                        jColor = j;
                    }
                    if (i11 != 0) {
                        jPack = IntMath.pack(0L, Float.NaN);
                    }
                    if (i13 != 0) {
                        fontStyle2 = null;
                    }
                    if (i15 != 0) {
                        fontWeight2 = null;
                    }
                    if (i17 != 0) {
                        fontFamily2 = null;
                    }
                    if (i20 != 0) {
                        jPack2 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack2 = j3;
                    }
                    if (i23 == 0) {
                    }
                    if (i26 != 0) {
                        jPack3 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack3 = j4;
                    }
                    if (i30 != 0) {
                        i31 = 1;
                    }
                    if (i33 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i37 != 0) {
                        i44 = Integer.MAX_VALUE;
                    } else {
                        i44 = i2;
                    }
                    if ((i6 & 131072) != 0) {
                        i39 &= -29360129;
                        textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                    } else {
                        textStyle3 = textStyle;
                    }
                    i45 = i44;
                    i46 = i31;
                    j9 = jPack3;
                    textAlign3 = textAlign4;
                }
                gapComposer2.endDefaults();
                gapComposer2.startReplaceGroup(-565217490);
                if (jColor != 16) {
                    j9 = j9;
                    jM752getColor0d7_KjU = jColor;
                    z5 = false;
                } else {
                    gapComposer2.startReplaceGroup(-565216717);
                    jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                    if (jM752getColor0d7_KjU != 16) {
                        jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                    }
                    z5 = false;
                    gapComposer2.end(false);
                }
                gapComposer2.end(z5);
                r4 = z5;
                if (textAlign3 != null) {
                    r4 = textAlign3.value;
                }
                TextStyle textStyle9 = textStyle3;
                int i419 = i39 << 6;
                Modifier modifier9 = modifier3;
                int i510 = i46;
                int i511 = i45;
                BasicTextKt.m187BasicTextRWo7tUw(str, modifier9, TextStyle.m751mergedA7vx0o$default(textStyle9, jM752getColor0d7_KjU, jPack, fontWeight2, fontStyle2, fontFamily2, jPack2, r4 == true ? 1 : 0, j9, 16609104), i510, z4, i511, i40, gapComposer2, ((i22 << 18) & 1879048192) | (i22 & 126) | 3072 | (i419 & 57344) | (i419 & 458752) | (i419 & 3670016) | 12582912, 256);
                modifier2 = modifier9;
                gapComposer = gapComposer2;
                z3 = z4;
                fontWeight3 = fontWeight2;
                j6 = j9;
                textAlign2 = textAlign3;
                i41 = i511;
                fontFamily3 = fontFamily2;
                i42 = i40;
                i43 = i510;
                textStyle2 = textStyle9;
                j7 = jPack;
                j5 = jColor;
                j8 = jPack2;
            } else {
                GapComposer gapComposer8 = gapComposer2;
                gapComposer8.skipToGroupEnd();
                modifier2 = modifier;
                j5 = j;
                textAlign2 = textAlign;
                z3 = z;
                i41 = i2;
                i42 = i3;
                textStyle2 = textStyle;
                fontWeight3 = fontWeight2;
                fontFamily3 = fontFamily2;
                j6 = j4;
                i43 = i31;
                j7 = jPack;
                j8 = j3;
                gapComposer = gapComposer8;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                        String str2 = str;
                        Modifier modifier10 = modifier2;
                        long j10 = j5;
                        long j11 = j7;
                        FontStyle fontStyle3 = fontStyle2;
                        FontWeight fontWeight4 = fontWeight3;
                        FontFamily fontFamily4 = fontFamily3;
                        long j12 = j8;
                        TextAlign textAlign5 = textAlign2;
                        long j13 = j6;
                        byte b = i43;
                        boolean z6 = z3;
                        int i512 = i41;
                        boolean z7 = i42;
                        TextStyle textStyle10 = textStyle2;
                        int i513 = i6;
                        TextKt.m352TextNvy7gAk(str2, modifier10, j10, j11, fontStyle3, fontWeight4, fontFamily4, j12, textAlign5, j13, b, z6, i512, z7 ? 1 : 0, textStyle10, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i513);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i29 |= 384;
        i31 = i;
        i33 = i6 & 8192;
        if (i33 != 0) {
            i35 = i29 | 3072;
        } else {
            i34 = i29;
            if ((i5 & 3072) != 0) {
                if (gapComposer2.changed(z)) {
                    i36 = 2048;
                } else {
                    i36 = 1024;
                }
                i34 |= i36;
            }
            i35 = i34;
        }
        i37 = i6 & 16384;
        if (i37 != 0) {
            i38 = i35;
            if ((i5 & 24576) == 0) {
                i38 |= gapComposer2.changed(i2) ? 16384 : 8192;
            }
            int i4110 = i38 | 1769472;
            if ((i6 & 131072) == 0) {
                i18 = 8388608;
            }
            i39 = i4110 | i18;
            i40 = 1;
            if ((i22 & 306783379) == 306783378) {
                z2 = true;
            } else {
                z2 = true;
            }
            if (gapComposer2.shouldExecute(i22 & 1, z2)) {
                gapComposer2.startDefaults();
                if ((i4 & 1) != 0) {
                    if (i47 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i8 != 0) {
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                    } else {
                        jColor = j;
                    }
                    if (i11 != 0) {
                        jPack = IntMath.pack(0L, Float.NaN);
                    }
                    if (i13 != 0) {
                        fontStyle2 = null;
                    }
                    if (i15 != 0) {
                        fontWeight2 = null;
                    }
                    if (i17 != 0) {
                        fontFamily2 = null;
                    }
                    if (i20 != 0) {
                        jPack2 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack2 = j3;
                    }
                    if (i23 == 0) {
                    }
                    if (i26 != 0) {
                        jPack3 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack3 = j4;
                    }
                    if (i30 != 0) {
                        i31 = 1;
                    }
                    if (i33 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i37 != 0) {
                        i44 = Integer.MAX_VALUE;
                    } else {
                        i44 = i2;
                    }
                    if ((i6 & 131072) != 0) {
                        i39 &= -29360129;
                        textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                    } else {
                        textStyle3 = textStyle;
                    }
                    i45 = i44;
                    i46 = i31;
                    j9 = jPack3;
                    textAlign3 = textAlign4;
                } else {
                    if (i47 != 0) {
                        modifier3 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier3 = modifier;
                    }
                    if (i8 != 0) {
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                    } else {
                        jColor = j;
                    }
                    if (i11 != 0) {
                        jPack = IntMath.pack(0L, Float.NaN);
                    }
                    if (i13 != 0) {
                        fontStyle2 = null;
                    }
                    if (i15 != 0) {
                        fontWeight2 = null;
                    }
                    if (i17 != 0) {
                        fontFamily2 = null;
                    }
                    if (i20 != 0) {
                        jPack2 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack2 = j3;
                    }
                    if (i23 == 0) {
                    }
                    if (i26 != 0) {
                        jPack3 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack3 = j4;
                    }
                    if (i30 != 0) {
                        i31 = 1;
                    }
                    if (i33 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i37 != 0) {
                        i44 = Integer.MAX_VALUE;
                    } else {
                        i44 = i2;
                    }
                    if ((i6 & 131072) != 0) {
                        i39 &= -29360129;
                        textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                    } else {
                        textStyle3 = textStyle;
                    }
                    i45 = i44;
                    i46 = i31;
                    j9 = jPack3;
                    textAlign3 = textAlign4;
                }
                gapComposer2.endDefaults();
                gapComposer2.startReplaceGroup(-565217490);
                if (jColor != 16) {
                    j9 = j9;
                    jM752getColor0d7_KjU = jColor;
                    z5 = false;
                } else {
                    gapComposer2.startReplaceGroup(-565216717);
                    jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                    if (jM752getColor0d7_KjU != 16) {
                        jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                    }
                    z5 = false;
                    gapComposer2.end(false);
                }
                gapComposer2.end(z5);
                r4 = z5;
                if (textAlign3 != null) {
                    r4 = textAlign3.value;
                }
                TextStyle textStyle10 = textStyle3;
                int i4111 = i39 << 6;
                Modifier modifier10 = modifier3;
                int i512 = i46;
                int i513 = i45;
                BasicTextKt.m187BasicTextRWo7tUw(str, modifier10, TextStyle.m751mergedA7vx0o$default(textStyle10, jM752getColor0d7_KjU, jPack, fontWeight2, fontStyle2, fontFamily2, jPack2, r4 == true ? 1 : 0, j9, 16609104), i512, z4, i513, i40, gapComposer2, ((i22 << 18) & 1879048192) | (i22 & 126) | 3072 | (i4111 & 57344) | (i4111 & 458752) | (i4111 & 3670016) | 12582912, 256);
                modifier2 = modifier10;
                gapComposer = gapComposer2;
                z3 = z4;
                fontWeight3 = fontWeight2;
                j6 = j9;
                textAlign2 = textAlign3;
                i41 = i513;
                fontFamily3 = fontFamily2;
                i42 = i40;
                i43 = i512;
                textStyle2 = textStyle10;
                j7 = jPack;
                j5 = jColor;
                j8 = jPack2;
            } else {
                GapComposer gapComposer9 = gapComposer2;
                gapComposer9.skipToGroupEnd();
                modifier2 = modifier;
                j5 = j;
                textAlign2 = textAlign;
                z3 = z;
                i41 = i2;
                i42 = i3;
                textStyle2 = textStyle;
                fontWeight3 = fontWeight2;
                fontFamily3 = fontFamily2;
                j6 = j4;
                i43 = i31;
                j7 = jPack;
                j8 = j3;
                gapComposer = gapComposer9;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                        String str2 = str;
                        Modifier modifier11 = modifier2;
                        long j10 = j5;
                        long j11 = j7;
                        FontStyle fontStyle3 = fontStyle2;
                        FontWeight fontWeight4 = fontWeight3;
                        FontFamily fontFamily4 = fontFamily3;
                        long j12 = j8;
                        TextAlign textAlign5 = textAlign2;
                        long j13 = j6;
                        byte b = i43;
                        boolean z6 = z3;
                        int i514 = i41;
                        boolean z7 = i42;
                        TextStyle textStyle11 = textStyle2;
                        int i515 = i6;
                        TextKt.m352TextNvy7gAk(str2, modifier11, j10, j11, fontStyle3, fontWeight4, fontFamily4, j12, textAlign5, j13, b, z6, i514, z7 ? 1 : 0, textStyle11, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i515);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i38 = i35 | 24576;
        int i4112 = i38 | 1769472;
        if ((i6 & 131072) == 0) {
            i18 = 8388608;
        }
        i39 = i4112 | i18;
        i40 = 1;
        if ((i22 & 306783379) == 306783378) {
            z2 = true;
        } else {
            z2 = true;
        }
        if (gapComposer2.shouldExecute(i22 & 1, z2)) {
            gapComposer2.startDefaults();
            if ((i4 & 1) != 0) {
                if (i47 != 0) {
                    modifier3 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier3 = modifier;
                }
                if (i8 != 0) {
                    jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                } else {
                    jColor = j;
                }
                if (i11 != 0) {
                    jPack = IntMath.pack(0L, Float.NaN);
                }
                if (i13 != 0) {
                    fontStyle2 = null;
                }
                if (i15 != 0) {
                    fontWeight2 = null;
                }
                if (i17 != 0) {
                    fontFamily2 = null;
                }
                if (i20 != 0) {
                    jPack2 = IntMath.pack(0L, Float.NaN);
                } else {
                    jPack2 = j3;
                }
                if (i23 == 0) {
                }
                if (i26 != 0) {
                    jPack3 = IntMath.pack(0L, Float.NaN);
                } else {
                    jPack3 = j4;
                }
                if (i30 != 0) {
                    i31 = 1;
                }
                if (i33 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i37 != 0) {
                    i44 = Integer.MAX_VALUE;
                } else {
                    i44 = i2;
                }
                if ((i6 & 131072) != 0) {
                    i39 &= -29360129;
                    textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                } else {
                    textStyle3 = textStyle;
                }
                i45 = i44;
                i46 = i31;
                j9 = jPack3;
                textAlign3 = textAlign4;
            } else {
                if (i47 != 0) {
                    modifier3 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier3 = modifier;
                }
                if (i8 != 0) {
                    jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                } else {
                    jColor = j;
                }
                if (i11 != 0) {
                    jPack = IntMath.pack(0L, Float.NaN);
                }
                if (i13 != 0) {
                    fontStyle2 = null;
                }
                if (i15 != 0) {
                    fontWeight2 = null;
                }
                if (i17 != 0) {
                    fontFamily2 = null;
                }
                if (i20 != 0) {
                    jPack2 = IntMath.pack(0L, Float.NaN);
                } else {
                    jPack2 = j3;
                }
                if (i23 == 0) {
                }
                if (i26 != 0) {
                    jPack3 = IntMath.pack(0L, Float.NaN);
                } else {
                    jPack3 = j4;
                }
                if (i30 != 0) {
                    i31 = 1;
                }
                if (i33 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i37 != 0) {
                    i44 = Integer.MAX_VALUE;
                } else {
                    i44 = i2;
                }
                if ((i6 & 131072) != 0) {
                    i39 &= -29360129;
                    textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                } else {
                    textStyle3 = textStyle;
                }
                i45 = i44;
                i46 = i31;
                j9 = jPack3;
                textAlign3 = textAlign4;
            }
            gapComposer2.endDefaults();
            gapComposer2.startReplaceGroup(-565217490);
            if (jColor != 16) {
                j9 = j9;
                jM752getColor0d7_KjU = jColor;
                z5 = false;
            } else {
                gapComposer2.startReplaceGroup(-565216717);
                jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                if (jM752getColor0d7_KjU != 16) {
                    jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                }
                z5 = false;
                gapComposer2.end(false);
            }
            gapComposer2.end(z5);
            r4 = z5;
            if (textAlign3 != null) {
                r4 = textAlign3.value;
            }
            TextStyle textStyle11 = textStyle3;
            int i4113 = i39 << 6;
            Modifier modifier11 = modifier3;
            int i514 = i46;
            int i515 = i45;
            BasicTextKt.m187BasicTextRWo7tUw(str, modifier11, TextStyle.m751mergedA7vx0o$default(textStyle11, jM752getColor0d7_KjU, jPack, fontWeight2, fontStyle2, fontFamily2, jPack2, r4 == true ? 1 : 0, j9, 16609104), i514, z4, i515, i40, gapComposer2, ((i22 << 18) & 1879048192) | (i22 & 126) | 3072 | (i4113 & 57344) | (i4113 & 458752) | (i4113 & 3670016) | 12582912, 256);
            modifier2 = modifier11;
            gapComposer = gapComposer2;
            z3 = z4;
            fontWeight3 = fontWeight2;
            j6 = j9;
            textAlign2 = textAlign3;
            i41 = i515;
            fontFamily3 = fontFamily2;
            i42 = i40;
            i43 = i514;
            textStyle2 = textStyle11;
            j7 = jPack;
            j5 = jColor;
            j8 = jPack2;
        } else {
            GapComposer gapComposer10 = gapComposer2;
            gapComposer10.skipToGroupEnd();
            modifier2 = modifier;
            j5 = j;
            textAlign2 = textAlign;
            z3 = z;
            i41 = i2;
            i42 = i3;
            textStyle2 = textStyle;
            fontWeight3 = fontWeight2;
            fontFamily3 = fontFamily2;
            j6 = j4;
            i43 = i31;
            j7 = jPack;
            j8 = j3;
            gapComposer = gapComposer10;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                    String str2 = str;
                    Modifier modifier12 = modifier2;
                    long j10 = j5;
                    long j11 = j7;
                    FontStyle fontStyle3 = fontStyle2;
                    FontWeight fontWeight4 = fontWeight3;
                    FontFamily fontFamily4 = fontFamily3;
                    long j12 = j8;
                    TextAlign textAlign5 = textAlign2;
                    long j13 = j6;
                    byte b = i43;
                    boolean z6 = z3;
                    int i516 = i41;
                    boolean z7 = i42;
                    TextStyle textStyle12 = textStyle2;
                    int i517 = i6;
                    TextKt.m352TextNvy7gAk(str2, modifier12, j10, j11, fontStyle3, fontWeight4, fontFamily4, j12, textAlign5, j13, b, z6, i516, z7 ? 1 : 0, textStyle12, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i517);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x013f  */
    /* JADX WARN: Code duplicated, block: B:104:0x0148  */
    /* JADX WARN: Code duplicated, block: B:106:0x014d  */
    /* JADX WARN: Code duplicated, block: B:109:0x015b  */
    /* JADX WARN: Code duplicated, block: B:113:0x0168  */
    /* JADX WARN: Code duplicated, block: B:116:0x0172  */
    /* JADX WARN: Code duplicated, block: B:118:0x017e  */
    /* JADX WARN: Code duplicated, block: B:125:0x01a2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:126:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:129:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:131:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:134:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:135:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:137:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:138:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:140:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:141:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:143:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:145:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:147:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:149:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:152:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:154:0x0208  */
    /* JADX WARN: Code duplicated, block: B:157:0x021d  */
    /* JADX WARN: Code duplicated, block: B:158:0x0223  */
    /* JADX WARN: Code duplicated, block: B:160:0x0231  */
    /* JADX WARN: Code duplicated, block: B:162:0x0235  */
    /* JADX WARN: Code duplicated, block: B:166:0x0262 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:167:0x0264  */
    /* JADX WARN: Code duplicated, block: B:171:0x029b  */
    /* JADX WARN: Code duplicated, block: B:174:0x02a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:177:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:180:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:181:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:184:0x034f  */
    /* JADX WARN: Code duplicated, block: B:187:0x0371  */
    /* JADX WARN: Code duplicated, block: B:189:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0043  */
    /* JADX WARN: Code duplicated, block: B:24:0x0048  */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:29:0x0057  */
    /* JADX WARN: Code duplicated, block: B:33:0x0065  */
    /* JADX WARN: Code duplicated, block: B:35:0x006a  */
    /* JADX WARN: Code duplicated, block: B:37:0x006f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0077  */
    /* JADX WARN: Code duplicated, block: B:40:0x007a  */
    /* JADX WARN: Code duplicated, block: B:44:0x0086  */
    /* JADX WARN: Code duplicated, block: B:45:0x008d  */
    /* JADX WARN: Code duplicated, block: B:47:0x0093  */
    /* JADX WARN: Code duplicated, block: B:49:0x0099  */
    /* JADX WARN: Code duplicated, block: B:50:0x009c  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:60:0x00be  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:77:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:81:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:83:0x0102  */
    /* JADX WARN: Code duplicated, block: B:84:0x0105  */
    /* JADX WARN: Code duplicated, block: B:88:0x0111  */
    /* JADX WARN: Code duplicated, block: B:90:0x011a  */
    /* JADX WARN: Code duplicated, block: B:92:0x0120  */
    /* JADX WARN: Code duplicated, block: B:94:0x012a  */
    /* JADX WARN: Code duplicated, block: B:95:0x012d  */
    /* JADX WARN: Code duplicated, block: B:99:0x0139  */
    /* JADX INFO: renamed from: Text-Z58ophY, reason: not valid java name */
    public static final void m353TextZ58ophY(final AnnotatedString annotatedString, Modifier modifier, long j, long j2, FontWeight fontWeight, long j3, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, Map map, Function1 function1, TextStyle textStyle, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        int i9;
        long jPack;
        int i10;
        int i11;
        int i12;
        FontWeight fontWeight2;
        int i13;
        int i14;
        int i15;
        TextAlign textAlign2;
        int i16;
        int i17;
        int i18;
        long j5;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        final int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        boolean z2;
        GapComposer gapComposer;
        final long j6;
        final int i31;
        final boolean z3;
        final int i32;
        final Map map2;
        final Function1 function2;
        final TextStyle textStyle2;
        final long j7;
        final TextAlign textAlign3;
        long j8;
        final long j9;
        final Modifier modifier3;
        final FontWeight fontWeight3;
        final long j10;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i33;
        NeverEqualPolicy neverEqualPolicy;
        long jColor;
        long jPack2;
        TextAlign textAlign4;
        long jPack3;
        int i34;
        Function1 function3;
        int i35;
        Map map3;
        TextStyle textStyle3;
        boolean z4;
        int i36;
        Object objRememberedValue;
        long jM752getColor0d7_KjU;
        boolean z5;
        long j11;
        boolean zChanged;
        Object objRememberedValue2;
        TextLinkStyles textLinkStyles;
        boolean zChanged2;
        Object objRememberedValue3;
        byte b;
        int i37;
        int i38;
        GapComposer gapComposer2 = (GapComposer) composer;
        gapComposer2.startRestartGroup(292247417);
        if ((i4 & 6) == 0) {
            i7 = (gapComposer2.changed(annotatedString) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i39 = i6 & 2;
        if (i39 == 0) {
            if ((i4 & 48) == 0) {
                modifier2 = modifier;
                i7 |= gapComposer2.changed(modifier2) ? 32 : 16;
            }
            i8 = i7 | 3456;
            i9 = i6 & 16;
            if (i9 != 0) {
                i8 = i7 | 28032;
                jPack = j2;
            } else {
                jPack = j2;
                if ((i4 & 24576) == 0) {
                    if (gapComposer2.changed(jPack)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i8 |= i10;
                }
            }
            i11 = i8 | 196608;
            i12 = i6 & 64;
            if (i12 != 0) {
                if ((1572864 & i4) == 0) {
                    fontWeight2 = fontWeight;
                    if (gapComposer2.changed(fontWeight2)) {
                        i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                    } else {
                        i13 = 524288;
                    }
                    i11 |= i13;
                }
                i14 = i11 | 918552576;
                i15 = i6 & 1024;
                if (i15 != 0) {
                    i16 = i5 | 6;
                    textAlign2 = textAlign;
                } else {
                    textAlign2 = textAlign;
                    if ((i5 & 6) == 0) {
                        if (gapComposer2.changed(textAlign2)) {
                            i17 = 4;
                        } else {
                            i17 = 2;
                        }
                        i16 = i5 | i17;
                    } else {
                        i16 = i5;
                    }
                }
                i18 = i6 & 2048;
                if (i18 != 0) {
                    i19 = i16 | 48;
                    j5 = j4;
                } else {
                    j5 = j4;
                    if ((i5 & 48) == 0) {
                        if (gapComposer2.changed(j5)) {
                            i20 = 32;
                        } else {
                            i20 = 16;
                        }
                        i16 |= i20;
                    }
                    i19 = i16;
                }
                i21 = i6 & 4096;
                if (i21 != 0) {
                    i22 = i21;
                    if ((i5 & 384) == 0) {
                        if (gapComposer2.changed(i)) {
                            i23 = 256;
                        } else {
                            i23 = 128;
                        }
                        i19 |= i23;
                    }
                    i24 = i19 | 3072;
                    i25 = i6 & 16384;
                    if (i25 != 0) {
                        if ((i5 & 24576) == 0) {
                            i26 = i2;
                            if (gapComposer2.changed(i26)) {
                                i27 = 16384;
                            } else {
                                i27 = 8192;
                            }
                            i24 |= i27;
                        }
                        i28 = i24 | 1769472;
                        i29 = i6 & 131072;
                        if (i29 != 0) {
                            if ((i5 & 12582912) == 0) {
                                if (gapComposer2.changedInstance(function1)) {
                                    i30 = 8388608;
                                } else {
                                    i30 = 4194304;
                                }
                                i28 |= i30;
                            }
                            if ((i5 & 100663296) != 0) {
                                if ((i6 & 262144) == 0 || !gapComposer2.changed(textStyle)) {
                                    i38 = 33554432;
                                } else {
                                    i38 = 67108864;
                                }
                                i28 |= i38;
                            }
                            if ((i14 & 306783379) == 306783378 || (i28 & 38347923) != 38347922) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                                gapComposer2.startDefaults();
                                i33 = i4 & 1;
                                neverEqualPolicy = Composer.Companion.Empty;
                                if (i33 != 0 || gapComposer2.getDefaultsInvalid()) {
                                    if (i39 != 0) {
                                        modifier2 = Modifier.Companion.$$INSTANCE;
                                    }
                                    jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                                    if (i9 != 0) {
                                        jPack = IntMath.pack(0L, Float.NaN);
                                    }
                                    if (i12 != 0) {
                                        fontWeight2 = null;
                                    }
                                    jPack2 = IntMath.pack(0L, Float.NaN);
                                    if (i15 != 0) {
                                        textAlign4 = null;
                                    } else {
                                        textAlign4 = textAlign;
                                    }
                                    if (i18 != 0) {
                                        jPack3 = IntMath.pack(0L, Float.NaN);
                                    } else {
                                        jPack3 = j5;
                                    }
                                    if (i22 != 0) {
                                        i34 = 1;
                                    } else {
                                        i34 = i;
                                    }
                                    if (i25 != 0) {
                                        i26 = Integer.MAX_VALUE;
                                    }
                                    if (i29 != 0) {
                                        objRememberedValue = gapComposer2.rememberedValue();
                                        if (objRememberedValue == neverEqualPolicy) {
                                            objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                            gapComposer2.updateRememberedValue(objRememberedValue);
                                        }
                                        function3 = (Function1) objRememberedValue;
                                    } else {
                                        function3 = function1;
                                    }
                                    i35 = i6 & 262144;
                                    map3 = EmptyMap.INSTANCE;
                                    if (i35 != 0) {
                                        i28 &= -234881025;
                                        textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                                    } else {
                                        textStyle3 = textStyle;
                                    }
                                    z4 = true;
                                    i36 = 1;
                                } else {
                                    gapComposer2.skipToGroupEnd();
                                    if ((i6 & 262144) != 0) {
                                        i28 &= -234881025;
                                    }
                                    jColor = j;
                                    jPack2 = j3;
                                    i34 = i;
                                    map3 = map;
                                    function3 = function1;
                                    textStyle3 = textStyle;
                                    textAlign4 = textAlign2;
                                    jPack3 = j5;
                                    z4 = z;
                                    i36 = i3;
                                }
                                gapComposer2.endDefaults();
                                int i40 = i34;
                                gapComposer2.startReplaceGroup(1676919260);
                                if (jColor != 16) {
                                    jPack3 = jPack3;
                                    jM752getColor0d7_KjU = jColor;
                                    z5 = false;
                                } else {
                                    gapComposer2.startReplaceGroup(1676920033);
                                    jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                                    if (jM752getColor0d7_KjU != 16) {
                                        jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                                    }
                                    z5 = false;
                                    gapComposer2.end(false);
                                }
                                gapComposer2.end(z5);
                                j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                                zChanged = gapComposer2.changed(j11);
                                objRememberedValue2 = gapComposer2.rememberedValue();
                                if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                                    objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                                    gapComposer2.updateRememberedValue(objRememberedValue2);
                                }
                                textLinkStyles = (TextLinkStyles) objRememberedValue2;
                                zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                                objRememberedValue3 = gapComposer2.rememberedValue();
                                if (!zChanged2 || objRememberedValue3 == neverEqualPolicy) {
                                    b = 0;
                                    objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                                    gapComposer2.updateRememberedValue(objRememberedValue3);
                                } else {
                                    b = 0;
                                }
                                AnnotatedString annotatedString2 = (AnnotatedString) objRememberedValue3;
                                if (textAlign4 != null) {
                                    i37 = textAlign4.value;
                                } else {
                                    i37 = b;
                                }
                                TextStyle textStyle4 = textStyle3;
                                int i41 = i28 << 6;
                                boolean z6 = z4;
                                int i42 = i36;
                                Function1 function4 = function3;
                                int i43 = i26;
                                BasicTextKt.m186BasicTextCL7eQgs(annotatedString2, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle4, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function4, i40, z6, i43, i42, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i41 & 57344) | (i41 & 458752) | (i41 & 3670016) | (i41 & 29360128) | (i41 & 234881024), (i14 >> 9) & 14, 512);
                                gapComposer = gapComposer2;
                                i32 = i42;
                                function2 = function4;
                                j7 = jPack;
                                map2 = map3;
                                z3 = z6;
                                j9 = jPack2;
                                textAlign3 = textAlign4;
                                i31 = i40;
                                j6 = jColor;
                                j8 = jPack3;
                                textStyle2 = textStyle4;
                                fontWeight3 = fontWeight2;
                                modifier3 = modifier2;
                            } else {
                                gapComposer = gapComposer2;
                                gapComposer.skipToGroupEnd();
                                j6 = j;
                                i31 = i;
                                z3 = z;
                                i32 = i3;
                                map2 = map;
                                function2 = function1;
                                textStyle2 = textStyle;
                                j7 = jPack;
                                textAlign3 = textAlign;
                                j8 = j5;
                                j9 = j3;
                                modifier3 = modifier2;
                                fontWeight3 = fontWeight2;
                            }
                            j10 = j8;
                            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                            if (recomposeScopeImplEndRestartGroup != null) {
                                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        ((Integer) obj2).getClass();
                                        int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                                        AnnotatedString annotatedString3 = annotatedString;
                                        Modifier modifier4 = modifier3;
                                        long j12 = j6;
                                        long j13 = j7;
                                        FontWeight fontWeight4 = fontWeight3;
                                        long j14 = j9;
                                        TextAlign textAlign5 = textAlign3;
                                        long j15 = j10;
                                        byte b2 = i31;
                                        boolean z7 = z3;
                                        int i44 = i26;
                                        boolean z8 = i32;
                                        Map map4 = map2;
                                        Function1 function5 = function2;
                                        TextStyle textStyle5 = textStyle2;
                                        int i45 = i6;
                                        TextKt.m353TextZ58ophY(annotatedString3, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z7, i44, z8 ? 1 : 0, map4, function5, textStyle5, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i45);
                                        return Unit.INSTANCE;
                                    }
                                };
                            }
                        }
                        i28 = i24 | 14352384;
                        if ((i5 & 100663296) != 0) {
                            if ((i6 & 262144) == 0) {
                                i38 = 33554432;
                            } else {
                                i38 = 33554432;
                            }
                            i28 |= i38;
                        }
                        if ((i14 & 306783379) == 306783378) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                            gapComposer2.startDefaults();
                            i33 = i4 & 1;
                            neverEqualPolicy = Composer.Companion.Empty;
                            if (i33 != 0) {
                                if (i39 != 0) {
                                    modifier2 = Modifier.Companion.$$INSTANCE;
                                }
                                jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                                if (i9 != 0) {
                                    jPack = IntMath.pack(0L, Float.NaN);
                                }
                                if (i12 != 0) {
                                    fontWeight2 = null;
                                }
                                jPack2 = IntMath.pack(0L, Float.NaN);
                                if (i15 != 0) {
                                    textAlign4 = null;
                                } else {
                                    textAlign4 = textAlign;
                                }
                                if (i18 != 0) {
                                    jPack3 = IntMath.pack(0L, Float.NaN);
                                } else {
                                    jPack3 = j5;
                                }
                                if (i22 != 0) {
                                    i34 = 1;
                                } else {
                                    i34 = i;
                                }
                                if (i25 != 0) {
                                    i26 = Integer.MAX_VALUE;
                                }
                                if (i29 != 0) {
                                    objRememberedValue = gapComposer2.rememberedValue();
                                    if (objRememberedValue == neverEqualPolicy) {
                                        objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                        gapComposer2.updateRememberedValue(objRememberedValue);
                                    }
                                    function3 = (Function1) objRememberedValue;
                                } else {
                                    function3 = function1;
                                }
                                i35 = i6 & 262144;
                                map3 = EmptyMap.INSTANCE;
                                if (i35 != 0) {
                                    i28 &= -234881025;
                                    textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                                } else {
                                    textStyle3 = textStyle;
                                }
                                z4 = true;
                                i36 = 1;
                            } else {
                                if (i39 != 0) {
                                    modifier2 = Modifier.Companion.$$INSTANCE;
                                }
                                jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                                if (i9 != 0) {
                                    jPack = IntMath.pack(0L, Float.NaN);
                                }
                                if (i12 != 0) {
                                    fontWeight2 = null;
                                }
                                jPack2 = IntMath.pack(0L, Float.NaN);
                                if (i15 != 0) {
                                    textAlign4 = null;
                                } else {
                                    textAlign4 = textAlign;
                                }
                                if (i18 != 0) {
                                    jPack3 = IntMath.pack(0L, Float.NaN);
                                } else {
                                    jPack3 = j5;
                                }
                                if (i22 != 0) {
                                    i34 = 1;
                                } else {
                                    i34 = i;
                                }
                                if (i25 != 0) {
                                    i26 = Integer.MAX_VALUE;
                                }
                                if (i29 != 0) {
                                    objRememberedValue = gapComposer2.rememberedValue();
                                    if (objRememberedValue == neverEqualPolicy) {
                                        objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                        gapComposer2.updateRememberedValue(objRememberedValue);
                                    }
                                    function3 = (Function1) objRememberedValue;
                                } else {
                                    function3 = function1;
                                }
                                i35 = i6 & 262144;
                                map3 = EmptyMap.INSTANCE;
                                if (i35 != 0) {
                                    i28 &= -234881025;
                                    textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                                } else {
                                    textStyle3 = textStyle;
                                }
                                z4 = true;
                                i36 = 1;
                            }
                            gapComposer2.endDefaults();
                            int i44 = i34;
                            gapComposer2.startReplaceGroup(1676919260);
                            if (jColor != 16) {
                                jPack3 = jPack3;
                                jM752getColor0d7_KjU = jColor;
                                z5 = false;
                            } else {
                                gapComposer2.startReplaceGroup(1676920033);
                                jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                                if (jM752getColor0d7_KjU != 16) {
                                    jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                                }
                                z5 = false;
                                gapComposer2.end(false);
                            }
                            gapComposer2.end(z5);
                            j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                            zChanged = gapComposer2.changed(j11);
                            objRememberedValue2 = gapComposer2.rememberedValue();
                            if (zChanged) {
                                objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                                gapComposer2.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                                gapComposer2.updateRememberedValue(objRememberedValue2);
                            }
                            textLinkStyles = (TextLinkStyles) objRememberedValue2;
                            zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                            objRememberedValue3 = gapComposer2.rememberedValue();
                            if (zChanged2) {
                                b = 0;
                                objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                                gapComposer2.updateRememberedValue(objRememberedValue3);
                            } else {
                                b = 0;
                                objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                                gapComposer2.updateRememberedValue(objRememberedValue3);
                            }
                            AnnotatedString annotatedString3 = (AnnotatedString) objRememberedValue3;
                            if (textAlign4 != null) {
                                i37 = textAlign4.value;
                            } else {
                                i37 = b;
                            }
                            TextStyle textStyle5 = textStyle3;
                            int i45 = i28 << 6;
                            boolean z7 = z4;
                            int i46 = i36;
                            Function1 function5 = function3;
                            int i47 = i26;
                            BasicTextKt.m186BasicTextCL7eQgs(annotatedString3, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle5, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function5, i44, z7, i47, i46, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i45 & 57344) | (i45 & 458752) | (i45 & 3670016) | (i45 & 29360128) | (i45 & 234881024), (i14 >> 9) & 14, 512);
                            gapComposer = gapComposer2;
                            i32 = i46;
                            function2 = function5;
                            j7 = jPack;
                            map2 = map3;
                            z3 = z7;
                            j9 = jPack2;
                            textAlign3 = textAlign4;
                            i31 = i44;
                            j6 = jColor;
                            j8 = jPack3;
                            textStyle2 = textStyle5;
                            fontWeight3 = fontWeight2;
                            modifier3 = modifier2;
                        } else {
                            gapComposer = gapComposer2;
                            gapComposer.skipToGroupEnd();
                            j6 = j;
                            i31 = i;
                            z3 = z;
                            i32 = i3;
                            map2 = map;
                            function2 = function1;
                            textStyle2 = textStyle;
                            j7 = jPack;
                            textAlign3 = textAlign;
                            j8 = j5;
                            j9 = j3;
                            modifier3 = modifier2;
                            fontWeight3 = fontWeight2;
                        }
                        j10 = j8;
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    ((Integer) obj2).getClass();
                                    int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                                    AnnotatedString annotatedString4 = annotatedString;
                                    Modifier modifier4 = modifier3;
                                    long j12 = j6;
                                    long j13 = j7;
                                    FontWeight fontWeight4 = fontWeight3;
                                    long j14 = j9;
                                    TextAlign textAlign5 = textAlign3;
                                    long j15 = j10;
                                    byte b2 = i31;
                                    boolean z8 = z3;
                                    int i48 = i26;
                                    boolean z9 = i32;
                                    Map map4 = map2;
                                    Function1 function6 = function2;
                                    TextStyle textStyle6 = textStyle2;
                                    int i49 = i6;
                                    TextKt.m353TextZ58ophY(annotatedString4, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z8, i48, z9 ? 1 : 0, map4, function6, textStyle6, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i49);
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                    }
                    i24 = i19 | 27648;
                    i26 = i2;
                    i28 = i24 | 1769472;
                    i29 = i6 & 131072;
                    if (i29 != 0) {
                        if ((i5 & 12582912) == 0) {
                            if (gapComposer2.changedInstance(function1)) {
                                i30 = 8388608;
                            } else {
                                i30 = 4194304;
                            }
                            i28 |= i30;
                        }
                        if ((i5 & 100663296) != 0) {
                            if ((i6 & 262144) == 0) {
                                i38 = 33554432;
                            } else {
                                i38 = 33554432;
                            }
                            i28 |= i38;
                        }
                        if ((i14 & 306783379) == 306783378) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                            gapComposer2.startDefaults();
                            i33 = i4 & 1;
                            neverEqualPolicy = Composer.Companion.Empty;
                            if (i33 != 0) {
                                if (i39 != 0) {
                                    modifier2 = Modifier.Companion.$$INSTANCE;
                                }
                                jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                                if (i9 != 0) {
                                    jPack = IntMath.pack(0L, Float.NaN);
                                }
                                if (i12 != 0) {
                                    fontWeight2 = null;
                                }
                                jPack2 = IntMath.pack(0L, Float.NaN);
                                if (i15 != 0) {
                                    textAlign4 = null;
                                } else {
                                    textAlign4 = textAlign;
                                }
                                if (i18 != 0) {
                                    jPack3 = IntMath.pack(0L, Float.NaN);
                                } else {
                                    jPack3 = j5;
                                }
                                if (i22 != 0) {
                                    i34 = 1;
                                } else {
                                    i34 = i;
                                }
                                if (i25 != 0) {
                                    i26 = Integer.MAX_VALUE;
                                }
                                if (i29 != 0) {
                                    objRememberedValue = gapComposer2.rememberedValue();
                                    if (objRememberedValue == neverEqualPolicy) {
                                        objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                        gapComposer2.updateRememberedValue(objRememberedValue);
                                    }
                                    function3 = (Function1) objRememberedValue;
                                } else {
                                    function3 = function1;
                                }
                                i35 = i6 & 262144;
                                map3 = EmptyMap.INSTANCE;
                                if (i35 != 0) {
                                    i28 &= -234881025;
                                    textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                                } else {
                                    textStyle3 = textStyle;
                                }
                                z4 = true;
                                i36 = 1;
                            } else {
                                if (i39 != 0) {
                                    modifier2 = Modifier.Companion.$$INSTANCE;
                                }
                                jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                                if (i9 != 0) {
                                    jPack = IntMath.pack(0L, Float.NaN);
                                }
                                if (i12 != 0) {
                                    fontWeight2 = null;
                                }
                                jPack2 = IntMath.pack(0L, Float.NaN);
                                if (i15 != 0) {
                                    textAlign4 = null;
                                } else {
                                    textAlign4 = textAlign;
                                }
                                if (i18 != 0) {
                                    jPack3 = IntMath.pack(0L, Float.NaN);
                                } else {
                                    jPack3 = j5;
                                }
                                if (i22 != 0) {
                                    i34 = 1;
                                } else {
                                    i34 = i;
                                }
                                if (i25 != 0) {
                                    i26 = Integer.MAX_VALUE;
                                }
                                if (i29 != 0) {
                                    objRememberedValue = gapComposer2.rememberedValue();
                                    if (objRememberedValue == neverEqualPolicy) {
                                        objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                        gapComposer2.updateRememberedValue(objRememberedValue);
                                    }
                                    function3 = (Function1) objRememberedValue;
                                } else {
                                    function3 = function1;
                                }
                                i35 = i6 & 262144;
                                map3 = EmptyMap.INSTANCE;
                                if (i35 != 0) {
                                    i28 &= -234881025;
                                    textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                                } else {
                                    textStyle3 = textStyle;
                                }
                                z4 = true;
                                i36 = 1;
                            }
                            gapComposer2.endDefaults();
                            int i48 = i34;
                            gapComposer2.startReplaceGroup(1676919260);
                            if (jColor != 16) {
                                jPack3 = jPack3;
                                jM752getColor0d7_KjU = jColor;
                                z5 = false;
                            } else {
                                gapComposer2.startReplaceGroup(1676920033);
                                jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                                if (jM752getColor0d7_KjU != 16) {
                                    jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                                }
                                z5 = false;
                                gapComposer2.end(false);
                            }
                            gapComposer2.end(z5);
                            j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                            zChanged = gapComposer2.changed(j11);
                            objRememberedValue2 = gapComposer2.rememberedValue();
                            if (zChanged) {
                                objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                                gapComposer2.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                                gapComposer2.updateRememberedValue(objRememberedValue2);
                            }
                            textLinkStyles = (TextLinkStyles) objRememberedValue2;
                            zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                            objRememberedValue3 = gapComposer2.rememberedValue();
                            if (zChanged2) {
                                b = 0;
                                objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                                gapComposer2.updateRememberedValue(objRememberedValue3);
                            } else {
                                b = 0;
                                objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                                gapComposer2.updateRememberedValue(objRememberedValue3);
                            }
                            AnnotatedString annotatedString4 = (AnnotatedString) objRememberedValue3;
                            if (textAlign4 != null) {
                                i37 = textAlign4.value;
                            } else {
                                i37 = b;
                            }
                            TextStyle textStyle6 = textStyle3;
                            int i49 = i28 << 6;
                            boolean z8 = z4;
                            int i410 = i36;
                            Function1 function6 = function3;
                            int i411 = i26;
                            BasicTextKt.m186BasicTextCL7eQgs(annotatedString4, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle6, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function6, i48, z8, i411, i410, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i49 & 57344) | (i49 & 458752) | (i49 & 3670016) | (i49 & 29360128) | (i49 & 234881024), (i14 >> 9) & 14, 512);
                            gapComposer = gapComposer2;
                            i32 = i410;
                            function2 = function6;
                            j7 = jPack;
                            map2 = map3;
                            z3 = z8;
                            j9 = jPack2;
                            textAlign3 = textAlign4;
                            i31 = i48;
                            j6 = jColor;
                            j8 = jPack3;
                            textStyle2 = textStyle6;
                            fontWeight3 = fontWeight2;
                            modifier3 = modifier2;
                        } else {
                            gapComposer = gapComposer2;
                            gapComposer.skipToGroupEnd();
                            j6 = j;
                            i31 = i;
                            z3 = z;
                            i32 = i3;
                            map2 = map;
                            function2 = function1;
                            textStyle2 = textStyle;
                            j7 = jPack;
                            textAlign3 = textAlign;
                            j8 = j5;
                            j9 = j3;
                            modifier3 = modifier2;
                            fontWeight3 = fontWeight2;
                        }
                        j10 = j8;
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    ((Integer) obj2).getClass();
                                    int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                                    AnnotatedString annotatedString5 = annotatedString;
                                    Modifier modifier4 = modifier3;
                                    long j12 = j6;
                                    long j13 = j7;
                                    FontWeight fontWeight4 = fontWeight3;
                                    long j14 = j9;
                                    TextAlign textAlign5 = textAlign3;
                                    long j15 = j10;
                                    byte b2 = i31;
                                    boolean z9 = z3;
                                    int i412 = i26;
                                    boolean z10 = i32;
                                    Map map4 = map2;
                                    Function1 function7 = function2;
                                    TextStyle textStyle7 = textStyle2;
                                    int i413 = i6;
                                    TextKt.m353TextZ58ophY(annotatedString5, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z9, i412, z10 ? 1 : 0, map4, function7, textStyle7, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i413);
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                    }
                    i28 = i24 | 14352384;
                    if ((i5 & 100663296) != 0) {
                        if ((i6 & 262144) == 0) {
                            i38 = 33554432;
                        } else {
                            i38 = 33554432;
                        }
                        i28 |= i38;
                    }
                    if ((i14 & 306783379) == 306783378) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                        gapComposer2.startDefaults();
                        i33 = i4 & 1;
                        neverEqualPolicy = Composer.Companion.Empty;
                        if (i33 != 0) {
                            if (i39 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                            if (i9 != 0) {
                                jPack = IntMath.pack(0L, Float.NaN);
                            }
                            if (i12 != 0) {
                                fontWeight2 = null;
                            }
                            jPack2 = IntMath.pack(0L, Float.NaN);
                            if (i15 != 0) {
                                textAlign4 = null;
                            } else {
                                textAlign4 = textAlign;
                            }
                            if (i18 != 0) {
                                jPack3 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack3 = j5;
                            }
                            if (i22 != 0) {
                                i34 = 1;
                            } else {
                                i34 = i;
                            }
                            if (i25 != 0) {
                                i26 = Integer.MAX_VALUE;
                            }
                            if (i29 != 0) {
                                objRememberedValue = gapComposer2.rememberedValue();
                                if (objRememberedValue == neverEqualPolicy) {
                                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                function3 = (Function1) objRememberedValue;
                            } else {
                                function3 = function1;
                            }
                            i35 = i6 & 262144;
                            map3 = EmptyMap.INSTANCE;
                            if (i35 != 0) {
                                i28 &= -234881025;
                                textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                            } else {
                                textStyle3 = textStyle;
                            }
                            z4 = true;
                            i36 = 1;
                        } else {
                            if (i39 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                            if (i9 != 0) {
                                jPack = IntMath.pack(0L, Float.NaN);
                            }
                            if (i12 != 0) {
                                fontWeight2 = null;
                            }
                            jPack2 = IntMath.pack(0L, Float.NaN);
                            if (i15 != 0) {
                                textAlign4 = null;
                            } else {
                                textAlign4 = textAlign;
                            }
                            if (i18 != 0) {
                                jPack3 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack3 = j5;
                            }
                            if (i22 != 0) {
                                i34 = 1;
                            } else {
                                i34 = i;
                            }
                            if (i25 != 0) {
                                i26 = Integer.MAX_VALUE;
                            }
                            if (i29 != 0) {
                                objRememberedValue = gapComposer2.rememberedValue();
                                if (objRememberedValue == neverEqualPolicy) {
                                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                function3 = (Function1) objRememberedValue;
                            } else {
                                function3 = function1;
                            }
                            i35 = i6 & 262144;
                            map3 = EmptyMap.INSTANCE;
                            if (i35 != 0) {
                                i28 &= -234881025;
                                textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                            } else {
                                textStyle3 = textStyle;
                            }
                            z4 = true;
                            i36 = 1;
                        }
                        gapComposer2.endDefaults();
                        int i412 = i34;
                        gapComposer2.startReplaceGroup(1676919260);
                        if (jColor != 16) {
                            jPack3 = jPack3;
                            jM752getColor0d7_KjU = jColor;
                            z5 = false;
                        } else {
                            gapComposer2.startReplaceGroup(1676920033);
                            jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                            if (jM752getColor0d7_KjU != 16) {
                                jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                            }
                            z5 = false;
                            gapComposer2.end(false);
                        }
                        gapComposer2.end(z5);
                        j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                        zChanged = gapComposer2.changed(j11);
                        objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        textLinkStyles = (TextLinkStyles) objRememberedValue2;
                        zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                        objRememberedValue3 = gapComposer2.rememberedValue();
                        if (zChanged2) {
                            b = 0;
                            objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        } else {
                            b = 0;
                            objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        AnnotatedString annotatedString5 = (AnnotatedString) objRememberedValue3;
                        if (textAlign4 != null) {
                            i37 = textAlign4.value;
                        } else {
                            i37 = b;
                        }
                        TextStyle textStyle7 = textStyle3;
                        int i413 = i28 << 6;
                        boolean z9 = z4;
                        int i414 = i36;
                        Function1 function7 = function3;
                        int i415 = i26;
                        BasicTextKt.m186BasicTextCL7eQgs(annotatedString5, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle7, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function7, i412, z9, i415, i414, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i413 & 57344) | (i413 & 458752) | (i413 & 3670016) | (i413 & 29360128) | (i413 & 234881024), (i14 >> 9) & 14, 512);
                        gapComposer = gapComposer2;
                        i32 = i414;
                        function2 = function7;
                        j7 = jPack;
                        map2 = map3;
                        z3 = z9;
                        j9 = jPack2;
                        textAlign3 = textAlign4;
                        i31 = i412;
                        j6 = jColor;
                        j8 = jPack3;
                        textStyle2 = textStyle7;
                        fontWeight3 = fontWeight2;
                        modifier3 = modifier2;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        j6 = j;
                        i31 = i;
                        z3 = z;
                        i32 = i3;
                        map2 = map;
                        function2 = function1;
                        textStyle2 = textStyle;
                        j7 = jPack;
                        textAlign3 = textAlign;
                        j8 = j5;
                        j9 = j3;
                        modifier3 = modifier2;
                        fontWeight3 = fontWeight2;
                    }
                    j10 = j8;
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                                AnnotatedString annotatedString6 = annotatedString;
                                Modifier modifier4 = modifier3;
                                long j12 = j6;
                                long j13 = j7;
                                FontWeight fontWeight4 = fontWeight3;
                                long j14 = j9;
                                TextAlign textAlign5 = textAlign3;
                                long j15 = j10;
                                byte b2 = i31;
                                boolean z10 = z3;
                                int i416 = i26;
                                boolean z11 = i32;
                                Map map4 = map2;
                                Function1 function8 = function2;
                                TextStyle textStyle8 = textStyle2;
                                int i417 = i6;
                                TextKt.m353TextZ58ophY(annotatedString6, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z10, i416, z11 ? 1 : 0, map4, function8, textStyle8, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i417);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i19 |= 384;
                i22 = i21;
                i24 = i19 | 3072;
                i25 = i6 & 16384;
                if (i25 != 0) {
                    if ((i5 & 24576) == 0) {
                        i26 = i2;
                        if (gapComposer2.changed(i26)) {
                            i27 = 16384;
                        } else {
                            i27 = 8192;
                        }
                        i24 |= i27;
                    }
                    i28 = i24 | 1769472;
                    i29 = i6 & 131072;
                    if (i29 != 0) {
                        if ((i5 & 12582912) == 0) {
                            if (gapComposer2.changedInstance(function1)) {
                                i30 = 8388608;
                            } else {
                                i30 = 4194304;
                            }
                            i28 |= i30;
                        }
                        if ((i5 & 100663296) != 0) {
                            if ((i6 & 262144) == 0) {
                                i38 = 33554432;
                            } else {
                                i38 = 33554432;
                            }
                            i28 |= i38;
                        }
                        if ((i14 & 306783379) == 306783378) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                            gapComposer2.startDefaults();
                            i33 = i4 & 1;
                            neverEqualPolicy = Composer.Companion.Empty;
                            if (i33 != 0) {
                                if (i39 != 0) {
                                    modifier2 = Modifier.Companion.$$INSTANCE;
                                }
                                jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                                if (i9 != 0) {
                                    jPack = IntMath.pack(0L, Float.NaN);
                                }
                                if (i12 != 0) {
                                    fontWeight2 = null;
                                }
                                jPack2 = IntMath.pack(0L, Float.NaN);
                                if (i15 != 0) {
                                    textAlign4 = null;
                                } else {
                                    textAlign4 = textAlign;
                                }
                                if (i18 != 0) {
                                    jPack3 = IntMath.pack(0L, Float.NaN);
                                } else {
                                    jPack3 = j5;
                                }
                                if (i22 != 0) {
                                    i34 = 1;
                                } else {
                                    i34 = i;
                                }
                                if (i25 != 0) {
                                    i26 = Integer.MAX_VALUE;
                                }
                                if (i29 != 0) {
                                    objRememberedValue = gapComposer2.rememberedValue();
                                    if (objRememberedValue == neverEqualPolicy) {
                                        objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                        gapComposer2.updateRememberedValue(objRememberedValue);
                                    }
                                    function3 = (Function1) objRememberedValue;
                                } else {
                                    function3 = function1;
                                }
                                i35 = i6 & 262144;
                                map3 = EmptyMap.INSTANCE;
                                if (i35 != 0) {
                                    i28 &= -234881025;
                                    textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                                } else {
                                    textStyle3 = textStyle;
                                }
                                z4 = true;
                                i36 = 1;
                            } else {
                                if (i39 != 0) {
                                    modifier2 = Modifier.Companion.$$INSTANCE;
                                }
                                jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                                if (i9 != 0) {
                                    jPack = IntMath.pack(0L, Float.NaN);
                                }
                                if (i12 != 0) {
                                    fontWeight2 = null;
                                }
                                jPack2 = IntMath.pack(0L, Float.NaN);
                                if (i15 != 0) {
                                    textAlign4 = null;
                                } else {
                                    textAlign4 = textAlign;
                                }
                                if (i18 != 0) {
                                    jPack3 = IntMath.pack(0L, Float.NaN);
                                } else {
                                    jPack3 = j5;
                                }
                                if (i22 != 0) {
                                    i34 = 1;
                                } else {
                                    i34 = i;
                                }
                                if (i25 != 0) {
                                    i26 = Integer.MAX_VALUE;
                                }
                                if (i29 != 0) {
                                    objRememberedValue = gapComposer2.rememberedValue();
                                    if (objRememberedValue == neverEqualPolicy) {
                                        objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                        gapComposer2.updateRememberedValue(objRememberedValue);
                                    }
                                    function3 = (Function1) objRememberedValue;
                                } else {
                                    function3 = function1;
                                }
                                i35 = i6 & 262144;
                                map3 = EmptyMap.INSTANCE;
                                if (i35 != 0) {
                                    i28 &= -234881025;
                                    textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                                } else {
                                    textStyle3 = textStyle;
                                }
                                z4 = true;
                                i36 = 1;
                            }
                            gapComposer2.endDefaults();
                            int i416 = i34;
                            gapComposer2.startReplaceGroup(1676919260);
                            if (jColor != 16) {
                                jPack3 = jPack3;
                                jM752getColor0d7_KjU = jColor;
                                z5 = false;
                            } else {
                                gapComposer2.startReplaceGroup(1676920033);
                                jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                                if (jM752getColor0d7_KjU != 16) {
                                    jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                                }
                                z5 = false;
                                gapComposer2.end(false);
                            }
                            gapComposer2.end(z5);
                            j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                            zChanged = gapComposer2.changed(j11);
                            objRememberedValue2 = gapComposer2.rememberedValue();
                            if (zChanged) {
                                objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                                gapComposer2.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                                gapComposer2.updateRememberedValue(objRememberedValue2);
                            }
                            textLinkStyles = (TextLinkStyles) objRememberedValue2;
                            zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                            objRememberedValue3 = gapComposer2.rememberedValue();
                            if (zChanged2) {
                                b = 0;
                                objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                                gapComposer2.updateRememberedValue(objRememberedValue3);
                            } else {
                                b = 0;
                                objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                                gapComposer2.updateRememberedValue(objRememberedValue3);
                            }
                            AnnotatedString annotatedString6 = (AnnotatedString) objRememberedValue3;
                            if (textAlign4 != null) {
                                i37 = textAlign4.value;
                            } else {
                                i37 = b;
                            }
                            TextStyle textStyle8 = textStyle3;
                            int i417 = i28 << 6;
                            boolean z10 = z4;
                            int i418 = i36;
                            Function1 function8 = function3;
                            int i419 = i26;
                            BasicTextKt.m186BasicTextCL7eQgs(annotatedString6, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle8, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function8, i416, z10, i419, i418, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i417 & 57344) | (i417 & 458752) | (i417 & 3670016) | (i417 & 29360128) | (i417 & 234881024), (i14 >> 9) & 14, 512);
                            gapComposer = gapComposer2;
                            i32 = i418;
                            function2 = function8;
                            j7 = jPack;
                            map2 = map3;
                            z3 = z10;
                            j9 = jPack2;
                            textAlign3 = textAlign4;
                            i31 = i416;
                            j6 = jColor;
                            j8 = jPack3;
                            textStyle2 = textStyle8;
                            fontWeight3 = fontWeight2;
                            modifier3 = modifier2;
                        } else {
                            gapComposer = gapComposer2;
                            gapComposer.skipToGroupEnd();
                            j6 = j;
                            i31 = i;
                            z3 = z;
                            i32 = i3;
                            map2 = map;
                            function2 = function1;
                            textStyle2 = textStyle;
                            j7 = jPack;
                            textAlign3 = textAlign;
                            j8 = j5;
                            j9 = j3;
                            modifier3 = modifier2;
                            fontWeight3 = fontWeight2;
                        }
                        j10 = j8;
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    ((Integer) obj2).getClass();
                                    int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                                    AnnotatedString annotatedString7 = annotatedString;
                                    Modifier modifier4 = modifier3;
                                    long j12 = j6;
                                    long j13 = j7;
                                    FontWeight fontWeight4 = fontWeight3;
                                    long j14 = j9;
                                    TextAlign textAlign5 = textAlign3;
                                    long j15 = j10;
                                    byte b2 = i31;
                                    boolean z11 = z3;
                                    int i4110 = i26;
                                    boolean z12 = i32;
                                    Map map4 = map2;
                                    Function1 function9 = function2;
                                    TextStyle textStyle9 = textStyle2;
                                    int i4111 = i6;
                                    TextKt.m353TextZ58ophY(annotatedString7, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z11, i4110, z12 ? 1 : 0, map4, function9, textStyle9, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i4111);
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                    }
                    i28 = i24 | 14352384;
                    if ((i5 & 100663296) != 0) {
                        if ((i6 & 262144) == 0) {
                            i38 = 33554432;
                        } else {
                            i38 = 33554432;
                        }
                        i28 |= i38;
                    }
                    if ((i14 & 306783379) == 306783378) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                        gapComposer2.startDefaults();
                        i33 = i4 & 1;
                        neverEqualPolicy = Composer.Companion.Empty;
                        if (i33 != 0) {
                            if (i39 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                            if (i9 != 0) {
                                jPack = IntMath.pack(0L, Float.NaN);
                            }
                            if (i12 != 0) {
                                fontWeight2 = null;
                            }
                            jPack2 = IntMath.pack(0L, Float.NaN);
                            if (i15 != 0) {
                                textAlign4 = null;
                            } else {
                                textAlign4 = textAlign;
                            }
                            if (i18 != 0) {
                                jPack3 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack3 = j5;
                            }
                            if (i22 != 0) {
                                i34 = 1;
                            } else {
                                i34 = i;
                            }
                            if (i25 != 0) {
                                i26 = Integer.MAX_VALUE;
                            }
                            if (i29 != 0) {
                                objRememberedValue = gapComposer2.rememberedValue();
                                if (objRememberedValue == neverEqualPolicy) {
                                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                function3 = (Function1) objRememberedValue;
                            } else {
                                function3 = function1;
                            }
                            i35 = i6 & 262144;
                            map3 = EmptyMap.INSTANCE;
                            if (i35 != 0) {
                                i28 &= -234881025;
                                textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                            } else {
                                textStyle3 = textStyle;
                            }
                            z4 = true;
                            i36 = 1;
                        } else {
                            if (i39 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                            if (i9 != 0) {
                                jPack = IntMath.pack(0L, Float.NaN);
                            }
                            if (i12 != 0) {
                                fontWeight2 = null;
                            }
                            jPack2 = IntMath.pack(0L, Float.NaN);
                            if (i15 != 0) {
                                textAlign4 = null;
                            } else {
                                textAlign4 = textAlign;
                            }
                            if (i18 != 0) {
                                jPack3 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack3 = j5;
                            }
                            if (i22 != 0) {
                                i34 = 1;
                            } else {
                                i34 = i;
                            }
                            if (i25 != 0) {
                                i26 = Integer.MAX_VALUE;
                            }
                            if (i29 != 0) {
                                objRememberedValue = gapComposer2.rememberedValue();
                                if (objRememberedValue == neverEqualPolicy) {
                                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                function3 = (Function1) objRememberedValue;
                            } else {
                                function3 = function1;
                            }
                            i35 = i6 & 262144;
                            map3 = EmptyMap.INSTANCE;
                            if (i35 != 0) {
                                i28 &= -234881025;
                                textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                            } else {
                                textStyle3 = textStyle;
                            }
                            z4 = true;
                            i36 = 1;
                        }
                        gapComposer2.endDefaults();
                        int i4110 = i34;
                        gapComposer2.startReplaceGroup(1676919260);
                        if (jColor != 16) {
                            jPack3 = jPack3;
                            jM752getColor0d7_KjU = jColor;
                            z5 = false;
                        } else {
                            gapComposer2.startReplaceGroup(1676920033);
                            jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                            if (jM752getColor0d7_KjU != 16) {
                                jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                            }
                            z5 = false;
                            gapComposer2.end(false);
                        }
                        gapComposer2.end(z5);
                        j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                        zChanged = gapComposer2.changed(j11);
                        objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        textLinkStyles = (TextLinkStyles) objRememberedValue2;
                        zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                        objRememberedValue3 = gapComposer2.rememberedValue();
                        if (zChanged2) {
                            b = 0;
                            objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        } else {
                            b = 0;
                            objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        AnnotatedString annotatedString7 = (AnnotatedString) objRememberedValue3;
                        if (textAlign4 != null) {
                            i37 = textAlign4.value;
                        } else {
                            i37 = b;
                        }
                        TextStyle textStyle9 = textStyle3;
                        int i4111 = i28 << 6;
                        boolean z11 = z4;
                        int i4112 = i36;
                        Function1 function9 = function3;
                        int i4113 = i26;
                        BasicTextKt.m186BasicTextCL7eQgs(annotatedString7, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle9, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function9, i4110, z11, i4113, i4112, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i4111 & 57344) | (i4111 & 458752) | (i4111 & 3670016) | (i4111 & 29360128) | (i4111 & 234881024), (i14 >> 9) & 14, 512);
                        gapComposer = gapComposer2;
                        i32 = i4112;
                        function2 = function9;
                        j7 = jPack;
                        map2 = map3;
                        z3 = z11;
                        j9 = jPack2;
                        textAlign3 = textAlign4;
                        i31 = i4110;
                        j6 = jColor;
                        j8 = jPack3;
                        textStyle2 = textStyle9;
                        fontWeight3 = fontWeight2;
                        modifier3 = modifier2;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        j6 = j;
                        i31 = i;
                        z3 = z;
                        i32 = i3;
                        map2 = map;
                        function2 = function1;
                        textStyle2 = textStyle;
                        j7 = jPack;
                        textAlign3 = textAlign;
                        j8 = j5;
                        j9 = j3;
                        modifier3 = modifier2;
                        fontWeight3 = fontWeight2;
                    }
                    j10 = j8;
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                                AnnotatedString annotatedString8 = annotatedString;
                                Modifier modifier4 = modifier3;
                                long j12 = j6;
                                long j13 = j7;
                                FontWeight fontWeight4 = fontWeight3;
                                long j14 = j9;
                                TextAlign textAlign5 = textAlign3;
                                long j15 = j10;
                                byte b2 = i31;
                                boolean z12 = z3;
                                int i4114 = i26;
                                boolean z13 = i32;
                                Map map4 = map2;
                                Function1 function10 = function2;
                                TextStyle textStyle10 = textStyle2;
                                int i4115 = i6;
                                TextKt.m353TextZ58ophY(annotatedString8, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z12, i4114, z13 ? 1 : 0, map4, function10, textStyle10, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i4115);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i24 = i19 | 27648;
                i26 = i2;
                i28 = i24 | 1769472;
                i29 = i6 & 131072;
                if (i29 != 0) {
                    if ((i5 & 12582912) == 0) {
                        if (gapComposer2.changedInstance(function1)) {
                            i30 = 8388608;
                        } else {
                            i30 = 4194304;
                        }
                        i28 |= i30;
                    }
                    if ((i5 & 100663296) != 0) {
                        if ((i6 & 262144) == 0) {
                            i38 = 33554432;
                        } else {
                            i38 = 33554432;
                        }
                        i28 |= i38;
                    }
                    if ((i14 & 306783379) == 306783378) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                        gapComposer2.startDefaults();
                        i33 = i4 & 1;
                        neverEqualPolicy = Composer.Companion.Empty;
                        if (i33 != 0) {
                            if (i39 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                            if (i9 != 0) {
                                jPack = IntMath.pack(0L, Float.NaN);
                            }
                            if (i12 != 0) {
                                fontWeight2 = null;
                            }
                            jPack2 = IntMath.pack(0L, Float.NaN);
                            if (i15 != 0) {
                                textAlign4 = null;
                            } else {
                                textAlign4 = textAlign;
                            }
                            if (i18 != 0) {
                                jPack3 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack3 = j5;
                            }
                            if (i22 != 0) {
                                i34 = 1;
                            } else {
                                i34 = i;
                            }
                            if (i25 != 0) {
                                i26 = Integer.MAX_VALUE;
                            }
                            if (i29 != 0) {
                                objRememberedValue = gapComposer2.rememberedValue();
                                if (objRememberedValue == neverEqualPolicy) {
                                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                function3 = (Function1) objRememberedValue;
                            } else {
                                function3 = function1;
                            }
                            i35 = i6 & 262144;
                            map3 = EmptyMap.INSTANCE;
                            if (i35 != 0) {
                                i28 &= -234881025;
                                textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                            } else {
                                textStyle3 = textStyle;
                            }
                            z4 = true;
                            i36 = 1;
                        } else {
                            if (i39 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                            if (i9 != 0) {
                                jPack = IntMath.pack(0L, Float.NaN);
                            }
                            if (i12 != 0) {
                                fontWeight2 = null;
                            }
                            jPack2 = IntMath.pack(0L, Float.NaN);
                            if (i15 != 0) {
                                textAlign4 = null;
                            } else {
                                textAlign4 = textAlign;
                            }
                            if (i18 != 0) {
                                jPack3 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack3 = j5;
                            }
                            if (i22 != 0) {
                                i34 = 1;
                            } else {
                                i34 = i;
                            }
                            if (i25 != 0) {
                                i26 = Integer.MAX_VALUE;
                            }
                            if (i29 != 0) {
                                objRememberedValue = gapComposer2.rememberedValue();
                                if (objRememberedValue == neverEqualPolicy) {
                                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                function3 = (Function1) objRememberedValue;
                            } else {
                                function3 = function1;
                            }
                            i35 = i6 & 262144;
                            map3 = EmptyMap.INSTANCE;
                            if (i35 != 0) {
                                i28 &= -234881025;
                                textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                            } else {
                                textStyle3 = textStyle;
                            }
                            z4 = true;
                            i36 = 1;
                        }
                        gapComposer2.endDefaults();
                        int i4114 = i34;
                        gapComposer2.startReplaceGroup(1676919260);
                        if (jColor != 16) {
                            jPack3 = jPack3;
                            jM752getColor0d7_KjU = jColor;
                            z5 = false;
                        } else {
                            gapComposer2.startReplaceGroup(1676920033);
                            jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                            if (jM752getColor0d7_KjU != 16) {
                                jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                            }
                            z5 = false;
                            gapComposer2.end(false);
                        }
                        gapComposer2.end(z5);
                        j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                        zChanged = gapComposer2.changed(j11);
                        objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        textLinkStyles = (TextLinkStyles) objRememberedValue2;
                        zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                        objRememberedValue3 = gapComposer2.rememberedValue();
                        if (zChanged2) {
                            b = 0;
                            objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        } else {
                            b = 0;
                            objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        AnnotatedString annotatedString8 = (AnnotatedString) objRememberedValue3;
                        if (textAlign4 != null) {
                            i37 = textAlign4.value;
                        } else {
                            i37 = b;
                        }
                        TextStyle textStyle10 = textStyle3;
                        int i4115 = i28 << 6;
                        boolean z12 = z4;
                        int i4116 = i36;
                        Function1 function10 = function3;
                        int i4117 = i26;
                        BasicTextKt.m186BasicTextCL7eQgs(annotatedString8, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle10, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function10, i4114, z12, i4117, i4116, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i4115 & 57344) | (i4115 & 458752) | (i4115 & 3670016) | (i4115 & 29360128) | (i4115 & 234881024), (i14 >> 9) & 14, 512);
                        gapComposer = gapComposer2;
                        i32 = i4116;
                        function2 = function10;
                        j7 = jPack;
                        map2 = map3;
                        z3 = z12;
                        j9 = jPack2;
                        textAlign3 = textAlign4;
                        i31 = i4114;
                        j6 = jColor;
                        j8 = jPack3;
                        textStyle2 = textStyle10;
                        fontWeight3 = fontWeight2;
                        modifier3 = modifier2;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        j6 = j;
                        i31 = i;
                        z3 = z;
                        i32 = i3;
                        map2 = map;
                        function2 = function1;
                        textStyle2 = textStyle;
                        j7 = jPack;
                        textAlign3 = textAlign;
                        j8 = j5;
                        j9 = j3;
                        modifier3 = modifier2;
                        fontWeight3 = fontWeight2;
                    }
                    j10 = j8;
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                                AnnotatedString annotatedString9 = annotatedString;
                                Modifier modifier4 = modifier3;
                                long j12 = j6;
                                long j13 = j7;
                                FontWeight fontWeight4 = fontWeight3;
                                long j14 = j9;
                                TextAlign textAlign5 = textAlign3;
                                long j15 = j10;
                                byte b2 = i31;
                                boolean z13 = z3;
                                int i4118 = i26;
                                boolean z14 = i32;
                                Map map4 = map2;
                                Function1 function11 = function2;
                                TextStyle textStyle11 = textStyle2;
                                int i4119 = i6;
                                TextKt.m353TextZ58ophY(annotatedString9, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z13, i4118, z14 ? 1 : 0, map4, function11, textStyle11, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i4119);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i28 = i24 | 14352384;
                if ((i5 & 100663296) != 0) {
                    if ((i6 & 262144) == 0) {
                        i38 = 33554432;
                    } else {
                        i38 = 33554432;
                    }
                    i28 |= i38;
                }
                if ((i14 & 306783379) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                    gapComposer2.startDefaults();
                    i33 = i4 & 1;
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (i33 != 0) {
                        if (i39 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        if (i9 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i12 != 0) {
                            fontWeight2 = null;
                        }
                        jPack2 = IntMath.pack(0L, Float.NaN);
                        if (i15 != 0) {
                            textAlign4 = null;
                        } else {
                            textAlign4 = textAlign;
                        }
                        if (i18 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j5;
                        }
                        if (i22 != 0) {
                            i34 = 1;
                        } else {
                            i34 = i;
                        }
                        if (i25 != 0) {
                            i26 = Integer.MAX_VALUE;
                        }
                        if (i29 != 0) {
                            objRememberedValue = gapComposer2.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            function3 = (Function1) objRememberedValue;
                        } else {
                            function3 = function1;
                        }
                        i35 = i6 & 262144;
                        map3 = EmptyMap.INSTANCE;
                        if (i35 != 0) {
                            i28 &= -234881025;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        z4 = true;
                        i36 = 1;
                    } else {
                        if (i39 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        if (i9 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i12 != 0) {
                            fontWeight2 = null;
                        }
                        jPack2 = IntMath.pack(0L, Float.NaN);
                        if (i15 != 0) {
                            textAlign4 = null;
                        } else {
                            textAlign4 = textAlign;
                        }
                        if (i18 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j5;
                        }
                        if (i22 != 0) {
                            i34 = 1;
                        } else {
                            i34 = i;
                        }
                        if (i25 != 0) {
                            i26 = Integer.MAX_VALUE;
                        }
                        if (i29 != 0) {
                            objRememberedValue = gapComposer2.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            function3 = (Function1) objRememberedValue;
                        } else {
                            function3 = function1;
                        }
                        i35 = i6 & 262144;
                        map3 = EmptyMap.INSTANCE;
                        if (i35 != 0) {
                            i28 &= -234881025;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        z4 = true;
                        i36 = 1;
                    }
                    gapComposer2.endDefaults();
                    int i4118 = i34;
                    gapComposer2.startReplaceGroup(1676919260);
                    if (jColor != 16) {
                        jPack3 = jPack3;
                        jM752getColor0d7_KjU = jColor;
                        z5 = false;
                    } else {
                        gapComposer2.startReplaceGroup(1676920033);
                        jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                        if (jM752getColor0d7_KjU != 16) {
                            jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                        }
                        z5 = false;
                        gapComposer2.end(false);
                    }
                    gapComposer2.end(z5);
                    j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                    zChanged = gapComposer2.changed(j11);
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    textLinkStyles = (TextLinkStyles) objRememberedValue2;
                    zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                    objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged2) {
                        b = 0;
                        objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        b = 0;
                        objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    AnnotatedString annotatedString9 = (AnnotatedString) objRememberedValue3;
                    if (textAlign4 != null) {
                        i37 = textAlign4.value;
                    } else {
                        i37 = b;
                    }
                    TextStyle textStyle11 = textStyle3;
                    int i4119 = i28 << 6;
                    boolean z13 = z4;
                    int i41110 = i36;
                    Function1 function11 = function3;
                    int i41111 = i26;
                    BasicTextKt.m186BasicTextCL7eQgs(annotatedString9, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle11, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function11, i4118, z13, i41111, i41110, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i4119 & 57344) | (i4119 & 458752) | (i4119 & 3670016) | (i4119 & 29360128) | (i4119 & 234881024), (i14 >> 9) & 14, 512);
                    gapComposer = gapComposer2;
                    i32 = i41110;
                    function2 = function11;
                    j7 = jPack;
                    map2 = map3;
                    z3 = z13;
                    j9 = jPack2;
                    textAlign3 = textAlign4;
                    i31 = i4118;
                    j6 = jColor;
                    j8 = jPack3;
                    textStyle2 = textStyle11;
                    fontWeight3 = fontWeight2;
                    modifier3 = modifier2;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    j6 = j;
                    i31 = i;
                    z3 = z;
                    i32 = i3;
                    map2 = map;
                    function2 = function1;
                    textStyle2 = textStyle;
                    j7 = jPack;
                    textAlign3 = textAlign;
                    j8 = j5;
                    j9 = j3;
                    modifier3 = modifier2;
                    fontWeight3 = fontWeight2;
                }
                j10 = j8;
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                            AnnotatedString annotatedString10 = annotatedString;
                            Modifier modifier4 = modifier3;
                            long j12 = j6;
                            long j13 = j7;
                            FontWeight fontWeight4 = fontWeight3;
                            long j14 = j9;
                            TextAlign textAlign5 = textAlign3;
                            long j15 = j10;
                            byte b2 = i31;
                            boolean z14 = z3;
                            int i41112 = i26;
                            boolean z15 = i32;
                            Map map4 = map2;
                            Function1 function12 = function2;
                            TextStyle textStyle12 = textStyle2;
                            int i41113 = i6;
                            TextKt.m353TextZ58ophY(annotatedString10, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z14, i41112, z15 ? 1 : 0, map4, function12, textStyle12, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i41113);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i11 = i8 | 1769472;
            fontWeight2 = fontWeight;
            i14 = i11 | 918552576;
            i15 = i6 & 1024;
            if (i15 != 0) {
                i16 = i5 | 6;
                textAlign2 = textAlign;
            } else {
                textAlign2 = textAlign;
                if ((i5 & 6) == 0) {
                    if (gapComposer2.changed(textAlign2)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i16 = i5 | i17;
                } else {
                    i16 = i5;
                }
            }
            i18 = i6 & 2048;
            if (i18 != 0) {
                i19 = i16 | 48;
                j5 = j4;
            } else {
                j5 = j4;
                if ((i5 & 48) == 0) {
                    if (gapComposer2.changed(j5)) {
                        i20 = 32;
                    } else {
                        i20 = 16;
                    }
                    i16 |= i20;
                }
                i19 = i16;
            }
            i21 = i6 & 4096;
            if (i21 != 0) {
                i22 = i21;
                if ((i5 & 384) == 0) {
                    if (gapComposer2.changed(i)) {
                        i23 = 256;
                    } else {
                        i23 = 128;
                    }
                    i19 |= i23;
                }
                i24 = i19 | 3072;
                i25 = i6 & 16384;
                if (i25 != 0) {
                    if ((i5 & 24576) == 0) {
                        i26 = i2;
                        if (gapComposer2.changed(i26)) {
                            i27 = 16384;
                        } else {
                            i27 = 8192;
                        }
                        i24 |= i27;
                    }
                    i28 = i24 | 1769472;
                    i29 = i6 & 131072;
                    if (i29 != 0) {
                        if ((i5 & 12582912) == 0) {
                            if (gapComposer2.changedInstance(function1)) {
                                i30 = 8388608;
                            } else {
                                i30 = 4194304;
                            }
                            i28 |= i30;
                        }
                        if ((i5 & 100663296) != 0) {
                            if ((i6 & 262144) == 0) {
                                i38 = 33554432;
                            } else {
                                i38 = 33554432;
                            }
                            i28 |= i38;
                        }
                        if ((i14 & 306783379) == 306783378) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                            gapComposer2.startDefaults();
                            i33 = i4 & 1;
                            neverEqualPolicy = Composer.Companion.Empty;
                            if (i33 != 0) {
                                if (i39 != 0) {
                                    modifier2 = Modifier.Companion.$$INSTANCE;
                                }
                                jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                                if (i9 != 0) {
                                    jPack = IntMath.pack(0L, Float.NaN);
                                }
                                if (i12 != 0) {
                                    fontWeight2 = null;
                                }
                                jPack2 = IntMath.pack(0L, Float.NaN);
                                if (i15 != 0) {
                                    textAlign4 = null;
                                } else {
                                    textAlign4 = textAlign;
                                }
                                if (i18 != 0) {
                                    jPack3 = IntMath.pack(0L, Float.NaN);
                                } else {
                                    jPack3 = j5;
                                }
                                if (i22 != 0) {
                                    i34 = 1;
                                } else {
                                    i34 = i;
                                }
                                if (i25 != 0) {
                                    i26 = Integer.MAX_VALUE;
                                }
                                if (i29 != 0) {
                                    objRememberedValue = gapComposer2.rememberedValue();
                                    if (objRememberedValue == neverEqualPolicy) {
                                        objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                        gapComposer2.updateRememberedValue(objRememberedValue);
                                    }
                                    function3 = (Function1) objRememberedValue;
                                } else {
                                    function3 = function1;
                                }
                                i35 = i6 & 262144;
                                map3 = EmptyMap.INSTANCE;
                                if (i35 != 0) {
                                    i28 &= -234881025;
                                    textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                                } else {
                                    textStyle3 = textStyle;
                                }
                                z4 = true;
                                i36 = 1;
                            } else {
                                if (i39 != 0) {
                                    modifier2 = Modifier.Companion.$$INSTANCE;
                                }
                                jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                                if (i9 != 0) {
                                    jPack = IntMath.pack(0L, Float.NaN);
                                }
                                if (i12 != 0) {
                                    fontWeight2 = null;
                                }
                                jPack2 = IntMath.pack(0L, Float.NaN);
                                if (i15 != 0) {
                                    textAlign4 = null;
                                } else {
                                    textAlign4 = textAlign;
                                }
                                if (i18 != 0) {
                                    jPack3 = IntMath.pack(0L, Float.NaN);
                                } else {
                                    jPack3 = j5;
                                }
                                if (i22 != 0) {
                                    i34 = 1;
                                } else {
                                    i34 = i;
                                }
                                if (i25 != 0) {
                                    i26 = Integer.MAX_VALUE;
                                }
                                if (i29 != 0) {
                                    objRememberedValue = gapComposer2.rememberedValue();
                                    if (objRememberedValue == neverEqualPolicy) {
                                        objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                        gapComposer2.updateRememberedValue(objRememberedValue);
                                    }
                                    function3 = (Function1) objRememberedValue;
                                } else {
                                    function3 = function1;
                                }
                                i35 = i6 & 262144;
                                map3 = EmptyMap.INSTANCE;
                                if (i35 != 0) {
                                    i28 &= -234881025;
                                    textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                                } else {
                                    textStyle3 = textStyle;
                                }
                                z4 = true;
                                i36 = 1;
                            }
                            gapComposer2.endDefaults();
                            int i41112 = i34;
                            gapComposer2.startReplaceGroup(1676919260);
                            if (jColor != 16) {
                                jPack3 = jPack3;
                                jM752getColor0d7_KjU = jColor;
                                z5 = false;
                            } else {
                                gapComposer2.startReplaceGroup(1676920033);
                                jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                                if (jM752getColor0d7_KjU != 16) {
                                    jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                                }
                                z5 = false;
                                gapComposer2.end(false);
                            }
                            gapComposer2.end(z5);
                            j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                            zChanged = gapComposer2.changed(j11);
                            objRememberedValue2 = gapComposer2.rememberedValue();
                            if (zChanged) {
                                objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                                gapComposer2.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                                gapComposer2.updateRememberedValue(objRememberedValue2);
                            }
                            textLinkStyles = (TextLinkStyles) objRememberedValue2;
                            zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                            objRememberedValue3 = gapComposer2.rememberedValue();
                            if (zChanged2) {
                                b = 0;
                                objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                                gapComposer2.updateRememberedValue(objRememberedValue3);
                            } else {
                                b = 0;
                                objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                                gapComposer2.updateRememberedValue(objRememberedValue3);
                            }
                            AnnotatedString annotatedString10 = (AnnotatedString) objRememberedValue3;
                            if (textAlign4 != null) {
                                i37 = textAlign4.value;
                            } else {
                                i37 = b;
                            }
                            TextStyle textStyle12 = textStyle3;
                            int i41113 = i28 << 6;
                            boolean z14 = z4;
                            int i41114 = i36;
                            Function1 function12 = function3;
                            int i41115 = i26;
                            BasicTextKt.m186BasicTextCL7eQgs(annotatedString10, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle12, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function12, i41112, z14, i41115, i41114, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i41113 & 57344) | (i41113 & 458752) | (i41113 & 3670016) | (i41113 & 29360128) | (i41113 & 234881024), (i14 >> 9) & 14, 512);
                            gapComposer = gapComposer2;
                            i32 = i41114;
                            function2 = function12;
                            j7 = jPack;
                            map2 = map3;
                            z3 = z14;
                            j9 = jPack2;
                            textAlign3 = textAlign4;
                            i31 = i41112;
                            j6 = jColor;
                            j8 = jPack3;
                            textStyle2 = textStyle12;
                            fontWeight3 = fontWeight2;
                            modifier3 = modifier2;
                        } else {
                            gapComposer = gapComposer2;
                            gapComposer.skipToGroupEnd();
                            j6 = j;
                            i31 = i;
                            z3 = z;
                            i32 = i3;
                            map2 = map;
                            function2 = function1;
                            textStyle2 = textStyle;
                            j7 = jPack;
                            textAlign3 = textAlign;
                            j8 = j5;
                            j9 = j3;
                            modifier3 = modifier2;
                            fontWeight3 = fontWeight2;
                        }
                        j10 = j8;
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    ((Integer) obj2).getClass();
                                    int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                                    AnnotatedString annotatedString11 = annotatedString;
                                    Modifier modifier4 = modifier3;
                                    long j12 = j6;
                                    long j13 = j7;
                                    FontWeight fontWeight4 = fontWeight3;
                                    long j14 = j9;
                                    TextAlign textAlign5 = textAlign3;
                                    long j15 = j10;
                                    byte b2 = i31;
                                    boolean z15 = z3;
                                    int i41116 = i26;
                                    boolean z16 = i32;
                                    Map map4 = map2;
                                    Function1 function13 = function2;
                                    TextStyle textStyle13 = textStyle2;
                                    int i41117 = i6;
                                    TextKt.m353TextZ58ophY(annotatedString11, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z15, i41116, z16 ? 1 : 0, map4, function13, textStyle13, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i41117);
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                    }
                    i28 = i24 | 14352384;
                    if ((i5 & 100663296) != 0) {
                        if ((i6 & 262144) == 0) {
                            i38 = 33554432;
                        } else {
                            i38 = 33554432;
                        }
                        i28 |= i38;
                    }
                    if ((i14 & 306783379) == 306783378) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                        gapComposer2.startDefaults();
                        i33 = i4 & 1;
                        neverEqualPolicy = Composer.Companion.Empty;
                        if (i33 != 0) {
                            if (i39 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                            if (i9 != 0) {
                                jPack = IntMath.pack(0L, Float.NaN);
                            }
                            if (i12 != 0) {
                                fontWeight2 = null;
                            }
                            jPack2 = IntMath.pack(0L, Float.NaN);
                            if (i15 != 0) {
                                textAlign4 = null;
                            } else {
                                textAlign4 = textAlign;
                            }
                            if (i18 != 0) {
                                jPack3 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack3 = j5;
                            }
                            if (i22 != 0) {
                                i34 = 1;
                            } else {
                                i34 = i;
                            }
                            if (i25 != 0) {
                                i26 = Integer.MAX_VALUE;
                            }
                            if (i29 != 0) {
                                objRememberedValue = gapComposer2.rememberedValue();
                                if (objRememberedValue == neverEqualPolicy) {
                                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                function3 = (Function1) objRememberedValue;
                            } else {
                                function3 = function1;
                            }
                            i35 = i6 & 262144;
                            map3 = EmptyMap.INSTANCE;
                            if (i35 != 0) {
                                i28 &= -234881025;
                                textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                            } else {
                                textStyle3 = textStyle;
                            }
                            z4 = true;
                            i36 = 1;
                        } else {
                            if (i39 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                            if (i9 != 0) {
                                jPack = IntMath.pack(0L, Float.NaN);
                            }
                            if (i12 != 0) {
                                fontWeight2 = null;
                            }
                            jPack2 = IntMath.pack(0L, Float.NaN);
                            if (i15 != 0) {
                                textAlign4 = null;
                            } else {
                                textAlign4 = textAlign;
                            }
                            if (i18 != 0) {
                                jPack3 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack3 = j5;
                            }
                            if (i22 != 0) {
                                i34 = 1;
                            } else {
                                i34 = i;
                            }
                            if (i25 != 0) {
                                i26 = Integer.MAX_VALUE;
                            }
                            if (i29 != 0) {
                                objRememberedValue = gapComposer2.rememberedValue();
                                if (objRememberedValue == neverEqualPolicy) {
                                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                function3 = (Function1) objRememberedValue;
                            } else {
                                function3 = function1;
                            }
                            i35 = i6 & 262144;
                            map3 = EmptyMap.INSTANCE;
                            if (i35 != 0) {
                                i28 &= -234881025;
                                textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                            } else {
                                textStyle3 = textStyle;
                            }
                            z4 = true;
                            i36 = 1;
                        }
                        gapComposer2.endDefaults();
                        int i41116 = i34;
                        gapComposer2.startReplaceGroup(1676919260);
                        if (jColor != 16) {
                            jPack3 = jPack3;
                            jM752getColor0d7_KjU = jColor;
                            z5 = false;
                        } else {
                            gapComposer2.startReplaceGroup(1676920033);
                            jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                            if (jM752getColor0d7_KjU != 16) {
                                jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                            }
                            z5 = false;
                            gapComposer2.end(false);
                        }
                        gapComposer2.end(z5);
                        j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                        zChanged = gapComposer2.changed(j11);
                        objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        textLinkStyles = (TextLinkStyles) objRememberedValue2;
                        zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                        objRememberedValue3 = gapComposer2.rememberedValue();
                        if (zChanged2) {
                            b = 0;
                            objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        } else {
                            b = 0;
                            objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        AnnotatedString annotatedString11 = (AnnotatedString) objRememberedValue3;
                        if (textAlign4 != null) {
                            i37 = textAlign4.value;
                        } else {
                            i37 = b;
                        }
                        TextStyle textStyle13 = textStyle3;
                        int i41117 = i28 << 6;
                        boolean z15 = z4;
                        int i41118 = i36;
                        Function1 function13 = function3;
                        int i41119 = i26;
                        BasicTextKt.m186BasicTextCL7eQgs(annotatedString11, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle13, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function13, i41116, z15, i41119, i41118, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i41117 & 57344) | (i41117 & 458752) | (i41117 & 3670016) | (i41117 & 29360128) | (i41117 & 234881024), (i14 >> 9) & 14, 512);
                        gapComposer = gapComposer2;
                        i32 = i41118;
                        function2 = function13;
                        j7 = jPack;
                        map2 = map3;
                        z3 = z15;
                        j9 = jPack2;
                        textAlign3 = textAlign4;
                        i31 = i41116;
                        j6 = jColor;
                        j8 = jPack3;
                        textStyle2 = textStyle13;
                        fontWeight3 = fontWeight2;
                        modifier3 = modifier2;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        j6 = j;
                        i31 = i;
                        z3 = z;
                        i32 = i3;
                        map2 = map;
                        function2 = function1;
                        textStyle2 = textStyle;
                        j7 = jPack;
                        textAlign3 = textAlign;
                        j8 = j5;
                        j9 = j3;
                        modifier3 = modifier2;
                        fontWeight3 = fontWeight2;
                    }
                    j10 = j8;
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                                AnnotatedString annotatedString12 = annotatedString;
                                Modifier modifier4 = modifier3;
                                long j12 = j6;
                                long j13 = j7;
                                FontWeight fontWeight4 = fontWeight3;
                                long j14 = j9;
                                TextAlign textAlign5 = textAlign3;
                                long j15 = j10;
                                byte b2 = i31;
                                boolean z16 = z3;
                                int i411110 = i26;
                                boolean z17 = i32;
                                Map map4 = map2;
                                Function1 function14 = function2;
                                TextStyle textStyle14 = textStyle2;
                                int i411111 = i6;
                                TextKt.m353TextZ58ophY(annotatedString12, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z16, i411110, z17 ? 1 : 0, map4, function14, textStyle14, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i411111);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i24 = i19 | 27648;
                i26 = i2;
                i28 = i24 | 1769472;
                i29 = i6 & 131072;
                if (i29 != 0) {
                    if ((i5 & 12582912) == 0) {
                        if (gapComposer2.changedInstance(function1)) {
                            i30 = 8388608;
                        } else {
                            i30 = 4194304;
                        }
                        i28 |= i30;
                    }
                    if ((i5 & 100663296) != 0) {
                        if ((i6 & 262144) == 0) {
                            i38 = 33554432;
                        } else {
                            i38 = 33554432;
                        }
                        i28 |= i38;
                    }
                    if ((i14 & 306783379) == 306783378) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                        gapComposer2.startDefaults();
                        i33 = i4 & 1;
                        neverEqualPolicy = Composer.Companion.Empty;
                        if (i33 != 0) {
                            if (i39 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                            if (i9 != 0) {
                                jPack = IntMath.pack(0L, Float.NaN);
                            }
                            if (i12 != 0) {
                                fontWeight2 = null;
                            }
                            jPack2 = IntMath.pack(0L, Float.NaN);
                            if (i15 != 0) {
                                textAlign4 = null;
                            } else {
                                textAlign4 = textAlign;
                            }
                            if (i18 != 0) {
                                jPack3 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack3 = j5;
                            }
                            if (i22 != 0) {
                                i34 = 1;
                            } else {
                                i34 = i;
                            }
                            if (i25 != 0) {
                                i26 = Integer.MAX_VALUE;
                            }
                            if (i29 != 0) {
                                objRememberedValue = gapComposer2.rememberedValue();
                                if (objRememberedValue == neverEqualPolicy) {
                                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                function3 = (Function1) objRememberedValue;
                            } else {
                                function3 = function1;
                            }
                            i35 = i6 & 262144;
                            map3 = EmptyMap.INSTANCE;
                            if (i35 != 0) {
                                i28 &= -234881025;
                                textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                            } else {
                                textStyle3 = textStyle;
                            }
                            z4 = true;
                            i36 = 1;
                        } else {
                            if (i39 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                            if (i9 != 0) {
                                jPack = IntMath.pack(0L, Float.NaN);
                            }
                            if (i12 != 0) {
                                fontWeight2 = null;
                            }
                            jPack2 = IntMath.pack(0L, Float.NaN);
                            if (i15 != 0) {
                                textAlign4 = null;
                            } else {
                                textAlign4 = textAlign;
                            }
                            if (i18 != 0) {
                                jPack3 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack3 = j5;
                            }
                            if (i22 != 0) {
                                i34 = 1;
                            } else {
                                i34 = i;
                            }
                            if (i25 != 0) {
                                i26 = Integer.MAX_VALUE;
                            }
                            if (i29 != 0) {
                                objRememberedValue = gapComposer2.rememberedValue();
                                if (objRememberedValue == neverEqualPolicy) {
                                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                function3 = (Function1) objRememberedValue;
                            } else {
                                function3 = function1;
                            }
                            i35 = i6 & 262144;
                            map3 = EmptyMap.INSTANCE;
                            if (i35 != 0) {
                                i28 &= -234881025;
                                textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                            } else {
                                textStyle3 = textStyle;
                            }
                            z4 = true;
                            i36 = 1;
                        }
                        gapComposer2.endDefaults();
                        int i411110 = i34;
                        gapComposer2.startReplaceGroup(1676919260);
                        if (jColor != 16) {
                            jPack3 = jPack3;
                            jM752getColor0d7_KjU = jColor;
                            z5 = false;
                        } else {
                            gapComposer2.startReplaceGroup(1676920033);
                            jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                            if (jM752getColor0d7_KjU != 16) {
                                jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                            }
                            z5 = false;
                            gapComposer2.end(false);
                        }
                        gapComposer2.end(z5);
                        j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                        zChanged = gapComposer2.changed(j11);
                        objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        textLinkStyles = (TextLinkStyles) objRememberedValue2;
                        zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                        objRememberedValue3 = gapComposer2.rememberedValue();
                        if (zChanged2) {
                            b = 0;
                            objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        } else {
                            b = 0;
                            objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        AnnotatedString annotatedString12 = (AnnotatedString) objRememberedValue3;
                        if (textAlign4 != null) {
                            i37 = textAlign4.value;
                        } else {
                            i37 = b;
                        }
                        TextStyle textStyle14 = textStyle3;
                        int i411111 = i28 << 6;
                        boolean z16 = z4;
                        int i411112 = i36;
                        Function1 function14 = function3;
                        int i411113 = i26;
                        BasicTextKt.m186BasicTextCL7eQgs(annotatedString12, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle14, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function14, i411110, z16, i411113, i411112, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i411111 & 57344) | (i411111 & 458752) | (i411111 & 3670016) | (i411111 & 29360128) | (i411111 & 234881024), (i14 >> 9) & 14, 512);
                        gapComposer = gapComposer2;
                        i32 = i411112;
                        function2 = function14;
                        j7 = jPack;
                        map2 = map3;
                        z3 = z16;
                        j9 = jPack2;
                        textAlign3 = textAlign4;
                        i31 = i411110;
                        j6 = jColor;
                        j8 = jPack3;
                        textStyle2 = textStyle14;
                        fontWeight3 = fontWeight2;
                        modifier3 = modifier2;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        j6 = j;
                        i31 = i;
                        z3 = z;
                        i32 = i3;
                        map2 = map;
                        function2 = function1;
                        textStyle2 = textStyle;
                        j7 = jPack;
                        textAlign3 = textAlign;
                        j8 = j5;
                        j9 = j3;
                        modifier3 = modifier2;
                        fontWeight3 = fontWeight2;
                    }
                    j10 = j8;
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                                AnnotatedString annotatedString13 = annotatedString;
                                Modifier modifier4 = modifier3;
                                long j12 = j6;
                                long j13 = j7;
                                FontWeight fontWeight4 = fontWeight3;
                                long j14 = j9;
                                TextAlign textAlign5 = textAlign3;
                                long j15 = j10;
                                byte b2 = i31;
                                boolean z17 = z3;
                                int i411114 = i26;
                                boolean z18 = i32;
                                Map map4 = map2;
                                Function1 function15 = function2;
                                TextStyle textStyle15 = textStyle2;
                                int i411115 = i6;
                                TextKt.m353TextZ58ophY(annotatedString13, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z17, i411114, z18 ? 1 : 0, map4, function15, textStyle15, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i411115);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i28 = i24 | 14352384;
                if ((i5 & 100663296) != 0) {
                    if ((i6 & 262144) == 0) {
                        i38 = 33554432;
                    } else {
                        i38 = 33554432;
                    }
                    i28 |= i38;
                }
                if ((i14 & 306783379) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                    gapComposer2.startDefaults();
                    i33 = i4 & 1;
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (i33 != 0) {
                        if (i39 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        if (i9 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i12 != 0) {
                            fontWeight2 = null;
                        }
                        jPack2 = IntMath.pack(0L, Float.NaN);
                        if (i15 != 0) {
                            textAlign4 = null;
                        } else {
                            textAlign4 = textAlign;
                        }
                        if (i18 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j5;
                        }
                        if (i22 != 0) {
                            i34 = 1;
                        } else {
                            i34 = i;
                        }
                        if (i25 != 0) {
                            i26 = Integer.MAX_VALUE;
                        }
                        if (i29 != 0) {
                            objRememberedValue = gapComposer2.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            function3 = (Function1) objRememberedValue;
                        } else {
                            function3 = function1;
                        }
                        i35 = i6 & 262144;
                        map3 = EmptyMap.INSTANCE;
                        if (i35 != 0) {
                            i28 &= -234881025;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        z4 = true;
                        i36 = 1;
                    } else {
                        if (i39 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        if (i9 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i12 != 0) {
                            fontWeight2 = null;
                        }
                        jPack2 = IntMath.pack(0L, Float.NaN);
                        if (i15 != 0) {
                            textAlign4 = null;
                        } else {
                            textAlign4 = textAlign;
                        }
                        if (i18 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j5;
                        }
                        if (i22 != 0) {
                            i34 = 1;
                        } else {
                            i34 = i;
                        }
                        if (i25 != 0) {
                            i26 = Integer.MAX_VALUE;
                        }
                        if (i29 != 0) {
                            objRememberedValue = gapComposer2.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            function3 = (Function1) objRememberedValue;
                        } else {
                            function3 = function1;
                        }
                        i35 = i6 & 262144;
                        map3 = EmptyMap.INSTANCE;
                        if (i35 != 0) {
                            i28 &= -234881025;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        z4 = true;
                        i36 = 1;
                    }
                    gapComposer2.endDefaults();
                    int i411114 = i34;
                    gapComposer2.startReplaceGroup(1676919260);
                    if (jColor != 16) {
                        jPack3 = jPack3;
                        jM752getColor0d7_KjU = jColor;
                        z5 = false;
                    } else {
                        gapComposer2.startReplaceGroup(1676920033);
                        jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                        if (jM752getColor0d7_KjU != 16) {
                            jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                        }
                        z5 = false;
                        gapComposer2.end(false);
                    }
                    gapComposer2.end(z5);
                    j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                    zChanged = gapComposer2.changed(j11);
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    textLinkStyles = (TextLinkStyles) objRememberedValue2;
                    zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                    objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged2) {
                        b = 0;
                        objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        b = 0;
                        objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    AnnotatedString annotatedString13 = (AnnotatedString) objRememberedValue3;
                    if (textAlign4 != null) {
                        i37 = textAlign4.value;
                    } else {
                        i37 = b;
                    }
                    TextStyle textStyle15 = textStyle3;
                    int i411115 = i28 << 6;
                    boolean z17 = z4;
                    int i411116 = i36;
                    Function1 function15 = function3;
                    int i411117 = i26;
                    BasicTextKt.m186BasicTextCL7eQgs(annotatedString13, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle15, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function15, i411114, z17, i411117, i411116, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i411115 & 57344) | (i411115 & 458752) | (i411115 & 3670016) | (i411115 & 29360128) | (i411115 & 234881024), (i14 >> 9) & 14, 512);
                    gapComposer = gapComposer2;
                    i32 = i411116;
                    function2 = function15;
                    j7 = jPack;
                    map2 = map3;
                    z3 = z17;
                    j9 = jPack2;
                    textAlign3 = textAlign4;
                    i31 = i411114;
                    j6 = jColor;
                    j8 = jPack3;
                    textStyle2 = textStyle15;
                    fontWeight3 = fontWeight2;
                    modifier3 = modifier2;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    j6 = j;
                    i31 = i;
                    z3 = z;
                    i32 = i3;
                    map2 = map;
                    function2 = function1;
                    textStyle2 = textStyle;
                    j7 = jPack;
                    textAlign3 = textAlign;
                    j8 = j5;
                    j9 = j3;
                    modifier3 = modifier2;
                    fontWeight3 = fontWeight2;
                }
                j10 = j8;
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                            AnnotatedString annotatedString14 = annotatedString;
                            Modifier modifier4 = modifier3;
                            long j12 = j6;
                            long j13 = j7;
                            FontWeight fontWeight4 = fontWeight3;
                            long j14 = j9;
                            TextAlign textAlign5 = textAlign3;
                            long j15 = j10;
                            byte b2 = i31;
                            boolean z18 = z3;
                            int i411118 = i26;
                            boolean z19 = i32;
                            Map map4 = map2;
                            Function1 function16 = function2;
                            TextStyle textStyle16 = textStyle2;
                            int i411119 = i6;
                            TextKt.m353TextZ58ophY(annotatedString14, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z18, i411118, z19 ? 1 : 0, map4, function16, textStyle16, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i411119);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i19 |= 384;
            i22 = i21;
            i24 = i19 | 3072;
            i25 = i6 & 16384;
            if (i25 != 0) {
                if ((i5 & 24576) == 0) {
                    i26 = i2;
                    if (gapComposer2.changed(i26)) {
                        i27 = 16384;
                    } else {
                        i27 = 8192;
                    }
                    i24 |= i27;
                }
                i28 = i24 | 1769472;
                i29 = i6 & 131072;
                if (i29 != 0) {
                    if ((i5 & 12582912) == 0) {
                        if (gapComposer2.changedInstance(function1)) {
                            i30 = 8388608;
                        } else {
                            i30 = 4194304;
                        }
                        i28 |= i30;
                    }
                    if ((i5 & 100663296) != 0) {
                        if ((i6 & 262144) == 0) {
                            i38 = 33554432;
                        } else {
                            i38 = 33554432;
                        }
                        i28 |= i38;
                    }
                    if ((i14 & 306783379) == 306783378) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                        gapComposer2.startDefaults();
                        i33 = i4 & 1;
                        neverEqualPolicy = Composer.Companion.Empty;
                        if (i33 != 0) {
                            if (i39 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                            if (i9 != 0) {
                                jPack = IntMath.pack(0L, Float.NaN);
                            }
                            if (i12 != 0) {
                                fontWeight2 = null;
                            }
                            jPack2 = IntMath.pack(0L, Float.NaN);
                            if (i15 != 0) {
                                textAlign4 = null;
                            } else {
                                textAlign4 = textAlign;
                            }
                            if (i18 != 0) {
                                jPack3 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack3 = j5;
                            }
                            if (i22 != 0) {
                                i34 = 1;
                            } else {
                                i34 = i;
                            }
                            if (i25 != 0) {
                                i26 = Integer.MAX_VALUE;
                            }
                            if (i29 != 0) {
                                objRememberedValue = gapComposer2.rememberedValue();
                                if (objRememberedValue == neverEqualPolicy) {
                                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                function3 = (Function1) objRememberedValue;
                            } else {
                                function3 = function1;
                            }
                            i35 = i6 & 262144;
                            map3 = EmptyMap.INSTANCE;
                            if (i35 != 0) {
                                i28 &= -234881025;
                                textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                            } else {
                                textStyle3 = textStyle;
                            }
                            z4 = true;
                            i36 = 1;
                        } else {
                            if (i39 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                            if (i9 != 0) {
                                jPack = IntMath.pack(0L, Float.NaN);
                            }
                            if (i12 != 0) {
                                fontWeight2 = null;
                            }
                            jPack2 = IntMath.pack(0L, Float.NaN);
                            if (i15 != 0) {
                                textAlign4 = null;
                            } else {
                                textAlign4 = textAlign;
                            }
                            if (i18 != 0) {
                                jPack3 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack3 = j5;
                            }
                            if (i22 != 0) {
                                i34 = 1;
                            } else {
                                i34 = i;
                            }
                            if (i25 != 0) {
                                i26 = Integer.MAX_VALUE;
                            }
                            if (i29 != 0) {
                                objRememberedValue = gapComposer2.rememberedValue();
                                if (objRememberedValue == neverEqualPolicy) {
                                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                function3 = (Function1) objRememberedValue;
                            } else {
                                function3 = function1;
                            }
                            i35 = i6 & 262144;
                            map3 = EmptyMap.INSTANCE;
                            if (i35 != 0) {
                                i28 &= -234881025;
                                textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                            } else {
                                textStyle3 = textStyle;
                            }
                            z4 = true;
                            i36 = 1;
                        }
                        gapComposer2.endDefaults();
                        int i411118 = i34;
                        gapComposer2.startReplaceGroup(1676919260);
                        if (jColor != 16) {
                            jPack3 = jPack3;
                            jM752getColor0d7_KjU = jColor;
                            z5 = false;
                        } else {
                            gapComposer2.startReplaceGroup(1676920033);
                            jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                            if (jM752getColor0d7_KjU != 16) {
                                jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                            }
                            z5 = false;
                            gapComposer2.end(false);
                        }
                        gapComposer2.end(z5);
                        j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                        zChanged = gapComposer2.changed(j11);
                        objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        textLinkStyles = (TextLinkStyles) objRememberedValue2;
                        zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                        objRememberedValue3 = gapComposer2.rememberedValue();
                        if (zChanged2) {
                            b = 0;
                            objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        } else {
                            b = 0;
                            objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        AnnotatedString annotatedString14 = (AnnotatedString) objRememberedValue3;
                        if (textAlign4 != null) {
                            i37 = textAlign4.value;
                        } else {
                            i37 = b;
                        }
                        TextStyle textStyle16 = textStyle3;
                        int i411119 = i28 << 6;
                        boolean z18 = z4;
                        int i4111110 = i36;
                        Function1 function16 = function3;
                        int i4111111 = i26;
                        BasicTextKt.m186BasicTextCL7eQgs(annotatedString14, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle16, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function16, i411118, z18, i4111111, i4111110, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i411119 & 57344) | (i411119 & 458752) | (i411119 & 3670016) | (i411119 & 29360128) | (i411119 & 234881024), (i14 >> 9) & 14, 512);
                        gapComposer = gapComposer2;
                        i32 = i4111110;
                        function2 = function16;
                        j7 = jPack;
                        map2 = map3;
                        z3 = z18;
                        j9 = jPack2;
                        textAlign3 = textAlign4;
                        i31 = i411118;
                        j6 = jColor;
                        j8 = jPack3;
                        textStyle2 = textStyle16;
                        fontWeight3 = fontWeight2;
                        modifier3 = modifier2;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        j6 = j;
                        i31 = i;
                        z3 = z;
                        i32 = i3;
                        map2 = map;
                        function2 = function1;
                        textStyle2 = textStyle;
                        j7 = jPack;
                        textAlign3 = textAlign;
                        j8 = j5;
                        j9 = j3;
                        modifier3 = modifier2;
                        fontWeight3 = fontWeight2;
                    }
                    j10 = j8;
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                                AnnotatedString annotatedString15 = annotatedString;
                                Modifier modifier4 = modifier3;
                                long j12 = j6;
                                long j13 = j7;
                                FontWeight fontWeight4 = fontWeight3;
                                long j14 = j9;
                                TextAlign textAlign5 = textAlign3;
                                long j15 = j10;
                                byte b2 = i31;
                                boolean z19 = z3;
                                int i4111112 = i26;
                                boolean z110 = i32;
                                Map map4 = map2;
                                Function1 function17 = function2;
                                TextStyle textStyle17 = textStyle2;
                                int i4111113 = i6;
                                TextKt.m353TextZ58ophY(annotatedString15, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z19, i4111112, z110 ? 1 : 0, map4, function17, textStyle17, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i4111113);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i28 = i24 | 14352384;
                if ((i5 & 100663296) != 0) {
                    if ((i6 & 262144) == 0) {
                        i38 = 33554432;
                    } else {
                        i38 = 33554432;
                    }
                    i28 |= i38;
                }
                if ((i14 & 306783379) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                    gapComposer2.startDefaults();
                    i33 = i4 & 1;
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (i33 != 0) {
                        if (i39 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        if (i9 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i12 != 0) {
                            fontWeight2 = null;
                        }
                        jPack2 = IntMath.pack(0L, Float.NaN);
                        if (i15 != 0) {
                            textAlign4 = null;
                        } else {
                            textAlign4 = textAlign;
                        }
                        if (i18 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j5;
                        }
                        if (i22 != 0) {
                            i34 = 1;
                        } else {
                            i34 = i;
                        }
                        if (i25 != 0) {
                            i26 = Integer.MAX_VALUE;
                        }
                        if (i29 != 0) {
                            objRememberedValue = gapComposer2.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            function3 = (Function1) objRememberedValue;
                        } else {
                            function3 = function1;
                        }
                        i35 = i6 & 262144;
                        map3 = EmptyMap.INSTANCE;
                        if (i35 != 0) {
                            i28 &= -234881025;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        z4 = true;
                        i36 = 1;
                    } else {
                        if (i39 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        if (i9 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i12 != 0) {
                            fontWeight2 = null;
                        }
                        jPack2 = IntMath.pack(0L, Float.NaN);
                        if (i15 != 0) {
                            textAlign4 = null;
                        } else {
                            textAlign4 = textAlign;
                        }
                        if (i18 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j5;
                        }
                        if (i22 != 0) {
                            i34 = 1;
                        } else {
                            i34 = i;
                        }
                        if (i25 != 0) {
                            i26 = Integer.MAX_VALUE;
                        }
                        if (i29 != 0) {
                            objRememberedValue = gapComposer2.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            function3 = (Function1) objRememberedValue;
                        } else {
                            function3 = function1;
                        }
                        i35 = i6 & 262144;
                        map3 = EmptyMap.INSTANCE;
                        if (i35 != 0) {
                            i28 &= -234881025;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        z4 = true;
                        i36 = 1;
                    }
                    gapComposer2.endDefaults();
                    int i4111112 = i34;
                    gapComposer2.startReplaceGroup(1676919260);
                    if (jColor != 16) {
                        jPack3 = jPack3;
                        jM752getColor0d7_KjU = jColor;
                        z5 = false;
                    } else {
                        gapComposer2.startReplaceGroup(1676920033);
                        jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                        if (jM752getColor0d7_KjU != 16) {
                            jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                        }
                        z5 = false;
                        gapComposer2.end(false);
                    }
                    gapComposer2.end(z5);
                    j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                    zChanged = gapComposer2.changed(j11);
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    textLinkStyles = (TextLinkStyles) objRememberedValue2;
                    zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                    objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged2) {
                        b = 0;
                        objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        b = 0;
                        objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    AnnotatedString annotatedString15 = (AnnotatedString) objRememberedValue3;
                    if (textAlign4 != null) {
                        i37 = textAlign4.value;
                    } else {
                        i37 = b;
                    }
                    TextStyle textStyle17 = textStyle3;
                    int i4111113 = i28 << 6;
                    boolean z19 = z4;
                    int i4111114 = i36;
                    Function1 function17 = function3;
                    int i4111115 = i26;
                    BasicTextKt.m186BasicTextCL7eQgs(annotatedString15, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle17, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function17, i4111112, z19, i4111115, i4111114, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i4111113 & 57344) | (i4111113 & 458752) | (i4111113 & 3670016) | (i4111113 & 29360128) | (i4111113 & 234881024), (i14 >> 9) & 14, 512);
                    gapComposer = gapComposer2;
                    i32 = i4111114;
                    function2 = function17;
                    j7 = jPack;
                    map2 = map3;
                    z3 = z19;
                    j9 = jPack2;
                    textAlign3 = textAlign4;
                    i31 = i4111112;
                    j6 = jColor;
                    j8 = jPack3;
                    textStyle2 = textStyle17;
                    fontWeight3 = fontWeight2;
                    modifier3 = modifier2;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    j6 = j;
                    i31 = i;
                    z3 = z;
                    i32 = i3;
                    map2 = map;
                    function2 = function1;
                    textStyle2 = textStyle;
                    j7 = jPack;
                    textAlign3 = textAlign;
                    j8 = j5;
                    j9 = j3;
                    modifier3 = modifier2;
                    fontWeight3 = fontWeight2;
                }
                j10 = j8;
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                            AnnotatedString annotatedString16 = annotatedString;
                            Modifier modifier4 = modifier3;
                            long j12 = j6;
                            long j13 = j7;
                            FontWeight fontWeight4 = fontWeight3;
                            long j14 = j9;
                            TextAlign textAlign5 = textAlign3;
                            long j15 = j10;
                            byte b2 = i31;
                            boolean z110 = z3;
                            int i4111116 = i26;
                            boolean z111 = i32;
                            Map map4 = map2;
                            Function1 function18 = function2;
                            TextStyle textStyle18 = textStyle2;
                            int i4111117 = i6;
                            TextKt.m353TextZ58ophY(annotatedString16, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z110, i4111116, z111 ? 1 : 0, map4, function18, textStyle18, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i4111117);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i24 = i19 | 27648;
            i26 = i2;
            i28 = i24 | 1769472;
            i29 = i6 & 131072;
            if (i29 != 0) {
                if ((i5 & 12582912) == 0) {
                    if (gapComposer2.changedInstance(function1)) {
                        i30 = 8388608;
                    } else {
                        i30 = 4194304;
                    }
                    i28 |= i30;
                }
                if ((i5 & 100663296) != 0) {
                    if ((i6 & 262144) == 0) {
                        i38 = 33554432;
                    } else {
                        i38 = 33554432;
                    }
                    i28 |= i38;
                }
                if ((i14 & 306783379) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                    gapComposer2.startDefaults();
                    i33 = i4 & 1;
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (i33 != 0) {
                        if (i39 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        if (i9 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i12 != 0) {
                            fontWeight2 = null;
                        }
                        jPack2 = IntMath.pack(0L, Float.NaN);
                        if (i15 != 0) {
                            textAlign4 = null;
                        } else {
                            textAlign4 = textAlign;
                        }
                        if (i18 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j5;
                        }
                        if (i22 != 0) {
                            i34 = 1;
                        } else {
                            i34 = i;
                        }
                        if (i25 != 0) {
                            i26 = Integer.MAX_VALUE;
                        }
                        if (i29 != 0) {
                            objRememberedValue = gapComposer2.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            function3 = (Function1) objRememberedValue;
                        } else {
                            function3 = function1;
                        }
                        i35 = i6 & 262144;
                        map3 = EmptyMap.INSTANCE;
                        if (i35 != 0) {
                            i28 &= -234881025;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        z4 = true;
                        i36 = 1;
                    } else {
                        if (i39 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        if (i9 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i12 != 0) {
                            fontWeight2 = null;
                        }
                        jPack2 = IntMath.pack(0L, Float.NaN);
                        if (i15 != 0) {
                            textAlign4 = null;
                        } else {
                            textAlign4 = textAlign;
                        }
                        if (i18 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j5;
                        }
                        if (i22 != 0) {
                            i34 = 1;
                        } else {
                            i34 = i;
                        }
                        if (i25 != 0) {
                            i26 = Integer.MAX_VALUE;
                        }
                        if (i29 != 0) {
                            objRememberedValue = gapComposer2.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            function3 = (Function1) objRememberedValue;
                        } else {
                            function3 = function1;
                        }
                        i35 = i6 & 262144;
                        map3 = EmptyMap.INSTANCE;
                        if (i35 != 0) {
                            i28 &= -234881025;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        z4 = true;
                        i36 = 1;
                    }
                    gapComposer2.endDefaults();
                    int i4111116 = i34;
                    gapComposer2.startReplaceGroup(1676919260);
                    if (jColor != 16) {
                        jPack3 = jPack3;
                        jM752getColor0d7_KjU = jColor;
                        z5 = false;
                    } else {
                        gapComposer2.startReplaceGroup(1676920033);
                        jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                        if (jM752getColor0d7_KjU != 16) {
                            jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                        }
                        z5 = false;
                        gapComposer2.end(false);
                    }
                    gapComposer2.end(z5);
                    j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                    zChanged = gapComposer2.changed(j11);
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    textLinkStyles = (TextLinkStyles) objRememberedValue2;
                    zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                    objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged2) {
                        b = 0;
                        objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        b = 0;
                        objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    AnnotatedString annotatedString16 = (AnnotatedString) objRememberedValue3;
                    if (textAlign4 != null) {
                        i37 = textAlign4.value;
                    } else {
                        i37 = b;
                    }
                    TextStyle textStyle18 = textStyle3;
                    int i4111117 = i28 << 6;
                    boolean z110 = z4;
                    int i4111118 = i36;
                    Function1 function18 = function3;
                    int i4111119 = i26;
                    BasicTextKt.m186BasicTextCL7eQgs(annotatedString16, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle18, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function18, i4111116, z110, i4111119, i4111118, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i4111117 & 57344) | (i4111117 & 458752) | (i4111117 & 3670016) | (i4111117 & 29360128) | (i4111117 & 234881024), (i14 >> 9) & 14, 512);
                    gapComposer = gapComposer2;
                    i32 = i4111118;
                    function2 = function18;
                    j7 = jPack;
                    map2 = map3;
                    z3 = z110;
                    j9 = jPack2;
                    textAlign3 = textAlign4;
                    i31 = i4111116;
                    j6 = jColor;
                    j8 = jPack3;
                    textStyle2 = textStyle18;
                    fontWeight3 = fontWeight2;
                    modifier3 = modifier2;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    j6 = j;
                    i31 = i;
                    z3 = z;
                    i32 = i3;
                    map2 = map;
                    function2 = function1;
                    textStyle2 = textStyle;
                    j7 = jPack;
                    textAlign3 = textAlign;
                    j8 = j5;
                    j9 = j3;
                    modifier3 = modifier2;
                    fontWeight3 = fontWeight2;
                }
                j10 = j8;
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                            AnnotatedString annotatedString17 = annotatedString;
                            Modifier modifier4 = modifier3;
                            long j12 = j6;
                            long j13 = j7;
                            FontWeight fontWeight4 = fontWeight3;
                            long j14 = j9;
                            TextAlign textAlign5 = textAlign3;
                            long j15 = j10;
                            byte b2 = i31;
                            boolean z111 = z3;
                            int i41111110 = i26;
                            boolean z112 = i32;
                            Map map4 = map2;
                            Function1 function19 = function2;
                            TextStyle textStyle19 = textStyle2;
                            int i41111111 = i6;
                            TextKt.m353TextZ58ophY(annotatedString17, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z111, i41111110, z112 ? 1 : 0, map4, function19, textStyle19, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i41111111);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i28 = i24 | 14352384;
            if ((i5 & 100663296) != 0) {
                if ((i6 & 262144) == 0) {
                    i38 = 33554432;
                } else {
                    i38 = 33554432;
                }
                i28 |= i38;
            }
            if ((i14 & 306783379) == 306783378) {
                z2 = true;
            } else {
                z2 = true;
            }
            if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                gapComposer2.startDefaults();
                i33 = i4 & 1;
                neverEqualPolicy = Composer.Companion.Empty;
                if (i33 != 0) {
                    if (i39 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                    if (i9 != 0) {
                        jPack = IntMath.pack(0L, Float.NaN);
                    }
                    if (i12 != 0) {
                        fontWeight2 = null;
                    }
                    jPack2 = IntMath.pack(0L, Float.NaN);
                    if (i15 != 0) {
                        textAlign4 = null;
                    } else {
                        textAlign4 = textAlign;
                    }
                    if (i18 != 0) {
                        jPack3 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack3 = j5;
                    }
                    if (i22 != 0) {
                        i34 = 1;
                    } else {
                        i34 = i;
                    }
                    if (i25 != 0) {
                        i26 = Integer.MAX_VALUE;
                    }
                    if (i29 != 0) {
                        objRememberedValue = gapComposer2.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        function3 = (Function1) objRememberedValue;
                    } else {
                        function3 = function1;
                    }
                    i35 = i6 & 262144;
                    map3 = EmptyMap.INSTANCE;
                    if (i35 != 0) {
                        i28 &= -234881025;
                        textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                    } else {
                        textStyle3 = textStyle;
                    }
                    z4 = true;
                    i36 = 1;
                } else {
                    if (i39 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                    if (i9 != 0) {
                        jPack = IntMath.pack(0L, Float.NaN);
                    }
                    if (i12 != 0) {
                        fontWeight2 = null;
                    }
                    jPack2 = IntMath.pack(0L, Float.NaN);
                    if (i15 != 0) {
                        textAlign4 = null;
                    } else {
                        textAlign4 = textAlign;
                    }
                    if (i18 != 0) {
                        jPack3 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack3 = j5;
                    }
                    if (i22 != 0) {
                        i34 = 1;
                    } else {
                        i34 = i;
                    }
                    if (i25 != 0) {
                        i26 = Integer.MAX_VALUE;
                    }
                    if (i29 != 0) {
                        objRememberedValue = gapComposer2.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        function3 = (Function1) objRememberedValue;
                    } else {
                        function3 = function1;
                    }
                    i35 = i6 & 262144;
                    map3 = EmptyMap.INSTANCE;
                    if (i35 != 0) {
                        i28 &= -234881025;
                        textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                    } else {
                        textStyle3 = textStyle;
                    }
                    z4 = true;
                    i36 = 1;
                }
                gapComposer2.endDefaults();
                int i41111110 = i34;
                gapComposer2.startReplaceGroup(1676919260);
                if (jColor != 16) {
                    jPack3 = jPack3;
                    jM752getColor0d7_KjU = jColor;
                    z5 = false;
                } else {
                    gapComposer2.startReplaceGroup(1676920033);
                    jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                    if (jM752getColor0d7_KjU != 16) {
                        jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                    }
                    z5 = false;
                    gapComposer2.end(false);
                }
                gapComposer2.end(z5);
                j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                zChanged = gapComposer2.changed(j11);
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                textLinkStyles = (TextLinkStyles) objRememberedValue2;
                zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                objRememberedValue3 = gapComposer2.rememberedValue();
                if (zChanged2) {
                    b = 0;
                    objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                } else {
                    b = 0;
                    objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                AnnotatedString annotatedString17 = (AnnotatedString) objRememberedValue3;
                if (textAlign4 != null) {
                    i37 = textAlign4.value;
                } else {
                    i37 = b;
                }
                TextStyle textStyle19 = textStyle3;
                int i41111111 = i28 << 6;
                boolean z111 = z4;
                int i41111112 = i36;
                Function1 function19 = function3;
                int i41111113 = i26;
                BasicTextKt.m186BasicTextCL7eQgs(annotatedString17, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle19, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function19, i41111110, z111, i41111113, i41111112, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i41111111 & 57344) | (i41111111 & 458752) | (i41111111 & 3670016) | (i41111111 & 29360128) | (i41111111 & 234881024), (i14 >> 9) & 14, 512);
                gapComposer = gapComposer2;
                i32 = i41111112;
                function2 = function19;
                j7 = jPack;
                map2 = map3;
                z3 = z111;
                j9 = jPack2;
                textAlign3 = textAlign4;
                i31 = i41111110;
                j6 = jColor;
                j8 = jPack3;
                textStyle2 = textStyle19;
                fontWeight3 = fontWeight2;
                modifier3 = modifier2;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                j6 = j;
                i31 = i;
                z3 = z;
                i32 = i3;
                map2 = map;
                function2 = function1;
                textStyle2 = textStyle;
                j7 = jPack;
                textAlign3 = textAlign;
                j8 = j5;
                j9 = j3;
                modifier3 = modifier2;
                fontWeight3 = fontWeight2;
            }
            j10 = j8;
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                        AnnotatedString annotatedString18 = annotatedString;
                        Modifier modifier4 = modifier3;
                        long j12 = j6;
                        long j13 = j7;
                        FontWeight fontWeight4 = fontWeight3;
                        long j14 = j9;
                        TextAlign textAlign5 = textAlign3;
                        long j15 = j10;
                        byte b2 = i31;
                        boolean z112 = z3;
                        int i41111114 = i26;
                        boolean z113 = i32;
                        Map map4 = map2;
                        Function1 function110 = function2;
                        TextStyle textStyle110 = textStyle2;
                        int i41111115 = i6;
                        TextKt.m353TextZ58ophY(annotatedString18, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z112, i41111114, z113 ? 1 : 0, map4, function110, textStyle110, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i41111115);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i7 |= 48;
        modifier2 = modifier;
        i8 = i7 | 3456;
        i9 = i6 & 16;
        if (i9 != 0) {
            i8 = i7 | 28032;
            jPack = j2;
        } else {
            jPack = j2;
            if ((i4 & 24576) == 0) {
                if (gapComposer2.changed(jPack)) {
                    i10 = 16384;
                } else {
                    i10 = 8192;
                }
                i8 |= i10;
            }
        }
        i11 = i8 | 196608;
        i12 = i6 & 64;
        if (i12 != 0) {
            if ((1572864 & i4) == 0) {
                fontWeight2 = fontWeight;
                if (gapComposer2.changed(fontWeight2)) {
                    i13 = ByteChannelKt.CHANNEL_MAX_SIZE;
                } else {
                    i13 = 524288;
                }
                i11 |= i13;
            }
            i14 = i11 | 918552576;
            i15 = i6 & 1024;
            if (i15 != 0) {
                i16 = i5 | 6;
                textAlign2 = textAlign;
            } else {
                textAlign2 = textAlign;
                if ((i5 & 6) == 0) {
                    if (gapComposer2.changed(textAlign2)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i16 = i5 | i17;
                } else {
                    i16 = i5;
                }
            }
            i18 = i6 & 2048;
            if (i18 != 0) {
                i19 = i16 | 48;
                j5 = j4;
            } else {
                j5 = j4;
                if ((i5 & 48) == 0) {
                    if (gapComposer2.changed(j5)) {
                        i20 = 32;
                    } else {
                        i20 = 16;
                    }
                    i16 |= i20;
                }
                i19 = i16;
            }
            i21 = i6 & 4096;
            if (i21 != 0) {
                i22 = i21;
                if ((i5 & 384) == 0) {
                    if (gapComposer2.changed(i)) {
                        i23 = 256;
                    } else {
                        i23 = 128;
                    }
                    i19 |= i23;
                }
                i24 = i19 | 3072;
                i25 = i6 & 16384;
                if (i25 != 0) {
                    if ((i5 & 24576) == 0) {
                        i26 = i2;
                        if (gapComposer2.changed(i26)) {
                            i27 = 16384;
                        } else {
                            i27 = 8192;
                        }
                        i24 |= i27;
                    }
                    i28 = i24 | 1769472;
                    i29 = i6 & 131072;
                    if (i29 != 0) {
                        if ((i5 & 12582912) == 0) {
                            if (gapComposer2.changedInstance(function1)) {
                                i30 = 8388608;
                            } else {
                                i30 = 4194304;
                            }
                            i28 |= i30;
                        }
                        if ((i5 & 100663296) != 0) {
                            if ((i6 & 262144) == 0) {
                                i38 = 33554432;
                            } else {
                                i38 = 33554432;
                            }
                            i28 |= i38;
                        }
                        if ((i14 & 306783379) == 306783378) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                            gapComposer2.startDefaults();
                            i33 = i4 & 1;
                            neverEqualPolicy = Composer.Companion.Empty;
                            if (i33 != 0) {
                                if (i39 != 0) {
                                    modifier2 = Modifier.Companion.$$INSTANCE;
                                }
                                jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                                if (i9 != 0) {
                                    jPack = IntMath.pack(0L, Float.NaN);
                                }
                                if (i12 != 0) {
                                    fontWeight2 = null;
                                }
                                jPack2 = IntMath.pack(0L, Float.NaN);
                                if (i15 != 0) {
                                    textAlign4 = null;
                                } else {
                                    textAlign4 = textAlign;
                                }
                                if (i18 != 0) {
                                    jPack3 = IntMath.pack(0L, Float.NaN);
                                } else {
                                    jPack3 = j5;
                                }
                                if (i22 != 0) {
                                    i34 = 1;
                                } else {
                                    i34 = i;
                                }
                                if (i25 != 0) {
                                    i26 = Integer.MAX_VALUE;
                                }
                                if (i29 != 0) {
                                    objRememberedValue = gapComposer2.rememberedValue();
                                    if (objRememberedValue == neverEqualPolicy) {
                                        objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                        gapComposer2.updateRememberedValue(objRememberedValue);
                                    }
                                    function3 = (Function1) objRememberedValue;
                                } else {
                                    function3 = function1;
                                }
                                i35 = i6 & 262144;
                                map3 = EmptyMap.INSTANCE;
                                if (i35 != 0) {
                                    i28 &= -234881025;
                                    textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                                } else {
                                    textStyle3 = textStyle;
                                }
                                z4 = true;
                                i36 = 1;
                            } else {
                                if (i39 != 0) {
                                    modifier2 = Modifier.Companion.$$INSTANCE;
                                }
                                jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                                if (i9 != 0) {
                                    jPack = IntMath.pack(0L, Float.NaN);
                                }
                                if (i12 != 0) {
                                    fontWeight2 = null;
                                }
                                jPack2 = IntMath.pack(0L, Float.NaN);
                                if (i15 != 0) {
                                    textAlign4 = null;
                                } else {
                                    textAlign4 = textAlign;
                                }
                                if (i18 != 0) {
                                    jPack3 = IntMath.pack(0L, Float.NaN);
                                } else {
                                    jPack3 = j5;
                                }
                                if (i22 != 0) {
                                    i34 = 1;
                                } else {
                                    i34 = i;
                                }
                                if (i25 != 0) {
                                    i26 = Integer.MAX_VALUE;
                                }
                                if (i29 != 0) {
                                    objRememberedValue = gapComposer2.rememberedValue();
                                    if (objRememberedValue == neverEqualPolicy) {
                                        objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                        gapComposer2.updateRememberedValue(objRememberedValue);
                                    }
                                    function3 = (Function1) objRememberedValue;
                                } else {
                                    function3 = function1;
                                }
                                i35 = i6 & 262144;
                                map3 = EmptyMap.INSTANCE;
                                if (i35 != 0) {
                                    i28 &= -234881025;
                                    textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                                } else {
                                    textStyle3 = textStyle;
                                }
                                z4 = true;
                                i36 = 1;
                            }
                            gapComposer2.endDefaults();
                            int i41111114 = i34;
                            gapComposer2.startReplaceGroup(1676919260);
                            if (jColor != 16) {
                                jPack3 = jPack3;
                                jM752getColor0d7_KjU = jColor;
                                z5 = false;
                            } else {
                                gapComposer2.startReplaceGroup(1676920033);
                                jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                                if (jM752getColor0d7_KjU != 16) {
                                    jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                                }
                                z5 = false;
                                gapComposer2.end(false);
                            }
                            gapComposer2.end(z5);
                            j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                            zChanged = gapComposer2.changed(j11);
                            objRememberedValue2 = gapComposer2.rememberedValue();
                            if (zChanged) {
                                objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                                gapComposer2.updateRememberedValue(objRememberedValue2);
                            } else {
                                objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                                gapComposer2.updateRememberedValue(objRememberedValue2);
                            }
                            textLinkStyles = (TextLinkStyles) objRememberedValue2;
                            zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                            objRememberedValue3 = gapComposer2.rememberedValue();
                            if (zChanged2) {
                                b = 0;
                                objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                                gapComposer2.updateRememberedValue(objRememberedValue3);
                            } else {
                                b = 0;
                                objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                                gapComposer2.updateRememberedValue(objRememberedValue3);
                            }
                            AnnotatedString annotatedString18 = (AnnotatedString) objRememberedValue3;
                            if (textAlign4 != null) {
                                i37 = textAlign4.value;
                            } else {
                                i37 = b;
                            }
                            TextStyle textStyle110 = textStyle3;
                            int i41111115 = i28 << 6;
                            boolean z112 = z4;
                            int i41111116 = i36;
                            Function1 function110 = function3;
                            int i41111117 = i26;
                            BasicTextKt.m186BasicTextCL7eQgs(annotatedString18, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle110, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function110, i41111114, z112, i41111117, i41111116, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i41111115 & 57344) | (i41111115 & 458752) | (i41111115 & 3670016) | (i41111115 & 29360128) | (i41111115 & 234881024), (i14 >> 9) & 14, 512);
                            gapComposer = gapComposer2;
                            i32 = i41111116;
                            function2 = function110;
                            j7 = jPack;
                            map2 = map3;
                            z3 = z112;
                            j9 = jPack2;
                            textAlign3 = textAlign4;
                            i31 = i41111114;
                            j6 = jColor;
                            j8 = jPack3;
                            textStyle2 = textStyle110;
                            fontWeight3 = fontWeight2;
                            modifier3 = modifier2;
                        } else {
                            gapComposer = gapComposer2;
                            gapComposer.skipToGroupEnd();
                            j6 = j;
                            i31 = i;
                            z3 = z;
                            i32 = i3;
                            map2 = map;
                            function2 = function1;
                            textStyle2 = textStyle;
                            j7 = jPack;
                            textAlign3 = textAlign;
                            j8 = j5;
                            j9 = j3;
                            modifier3 = modifier2;
                            fontWeight3 = fontWeight2;
                        }
                        j10 = j8;
                        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                        if (recomposeScopeImplEndRestartGroup != null) {
                            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    ((Integer) obj2).getClass();
                                    int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                                    AnnotatedString annotatedString19 = annotatedString;
                                    Modifier modifier4 = modifier3;
                                    long j12 = j6;
                                    long j13 = j7;
                                    FontWeight fontWeight4 = fontWeight3;
                                    long j14 = j9;
                                    TextAlign textAlign5 = textAlign3;
                                    long j15 = j10;
                                    byte b2 = i31;
                                    boolean z113 = z3;
                                    int i41111118 = i26;
                                    boolean z114 = i32;
                                    Map map4 = map2;
                                    Function1 function111 = function2;
                                    TextStyle textStyle111 = textStyle2;
                                    int i41111119 = i6;
                                    TextKt.m353TextZ58ophY(annotatedString19, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z113, i41111118, z114 ? 1 : 0, map4, function111, textStyle111, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i41111119);
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                    }
                    i28 = i24 | 14352384;
                    if ((i5 & 100663296) != 0) {
                        if ((i6 & 262144) == 0) {
                            i38 = 33554432;
                        } else {
                            i38 = 33554432;
                        }
                        i28 |= i38;
                    }
                    if ((i14 & 306783379) == 306783378) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                        gapComposer2.startDefaults();
                        i33 = i4 & 1;
                        neverEqualPolicy = Composer.Companion.Empty;
                        if (i33 != 0) {
                            if (i39 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                            if (i9 != 0) {
                                jPack = IntMath.pack(0L, Float.NaN);
                            }
                            if (i12 != 0) {
                                fontWeight2 = null;
                            }
                            jPack2 = IntMath.pack(0L, Float.NaN);
                            if (i15 != 0) {
                                textAlign4 = null;
                            } else {
                                textAlign4 = textAlign;
                            }
                            if (i18 != 0) {
                                jPack3 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack3 = j5;
                            }
                            if (i22 != 0) {
                                i34 = 1;
                            } else {
                                i34 = i;
                            }
                            if (i25 != 0) {
                                i26 = Integer.MAX_VALUE;
                            }
                            if (i29 != 0) {
                                objRememberedValue = gapComposer2.rememberedValue();
                                if (objRememberedValue == neverEqualPolicy) {
                                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                function3 = (Function1) objRememberedValue;
                            } else {
                                function3 = function1;
                            }
                            i35 = i6 & 262144;
                            map3 = EmptyMap.INSTANCE;
                            if (i35 != 0) {
                                i28 &= -234881025;
                                textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                            } else {
                                textStyle3 = textStyle;
                            }
                            z4 = true;
                            i36 = 1;
                        } else {
                            if (i39 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                            if (i9 != 0) {
                                jPack = IntMath.pack(0L, Float.NaN);
                            }
                            if (i12 != 0) {
                                fontWeight2 = null;
                            }
                            jPack2 = IntMath.pack(0L, Float.NaN);
                            if (i15 != 0) {
                                textAlign4 = null;
                            } else {
                                textAlign4 = textAlign;
                            }
                            if (i18 != 0) {
                                jPack3 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack3 = j5;
                            }
                            if (i22 != 0) {
                                i34 = 1;
                            } else {
                                i34 = i;
                            }
                            if (i25 != 0) {
                                i26 = Integer.MAX_VALUE;
                            }
                            if (i29 != 0) {
                                objRememberedValue = gapComposer2.rememberedValue();
                                if (objRememberedValue == neverEqualPolicy) {
                                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                function3 = (Function1) objRememberedValue;
                            } else {
                                function3 = function1;
                            }
                            i35 = i6 & 262144;
                            map3 = EmptyMap.INSTANCE;
                            if (i35 != 0) {
                                i28 &= -234881025;
                                textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                            } else {
                                textStyle3 = textStyle;
                            }
                            z4 = true;
                            i36 = 1;
                        }
                        gapComposer2.endDefaults();
                        int i41111118 = i34;
                        gapComposer2.startReplaceGroup(1676919260);
                        if (jColor != 16) {
                            jPack3 = jPack3;
                            jM752getColor0d7_KjU = jColor;
                            z5 = false;
                        } else {
                            gapComposer2.startReplaceGroup(1676920033);
                            jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                            if (jM752getColor0d7_KjU != 16) {
                                jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                            }
                            z5 = false;
                            gapComposer2.end(false);
                        }
                        gapComposer2.end(z5);
                        j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                        zChanged = gapComposer2.changed(j11);
                        objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        textLinkStyles = (TextLinkStyles) objRememberedValue2;
                        zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                        objRememberedValue3 = gapComposer2.rememberedValue();
                        if (zChanged2) {
                            b = 0;
                            objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        } else {
                            b = 0;
                            objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        AnnotatedString annotatedString19 = (AnnotatedString) objRememberedValue3;
                        if (textAlign4 != null) {
                            i37 = textAlign4.value;
                        } else {
                            i37 = b;
                        }
                        TextStyle textStyle111 = textStyle3;
                        int i41111119 = i28 << 6;
                        boolean z113 = z4;
                        int i411111110 = i36;
                        Function1 function111 = function3;
                        int i411111111 = i26;
                        BasicTextKt.m186BasicTextCL7eQgs(annotatedString19, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle111, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function111, i41111118, z113, i411111111, i411111110, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i41111119 & 57344) | (i41111119 & 458752) | (i41111119 & 3670016) | (i41111119 & 29360128) | (i41111119 & 234881024), (i14 >> 9) & 14, 512);
                        gapComposer = gapComposer2;
                        i32 = i411111110;
                        function2 = function111;
                        j7 = jPack;
                        map2 = map3;
                        z3 = z113;
                        j9 = jPack2;
                        textAlign3 = textAlign4;
                        i31 = i41111118;
                        j6 = jColor;
                        j8 = jPack3;
                        textStyle2 = textStyle111;
                        fontWeight3 = fontWeight2;
                        modifier3 = modifier2;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        j6 = j;
                        i31 = i;
                        z3 = z;
                        i32 = i3;
                        map2 = map;
                        function2 = function1;
                        textStyle2 = textStyle;
                        j7 = jPack;
                        textAlign3 = textAlign;
                        j8 = j5;
                        j9 = j3;
                        modifier3 = modifier2;
                        fontWeight3 = fontWeight2;
                    }
                    j10 = j8;
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                                AnnotatedString annotatedString110 = annotatedString;
                                Modifier modifier4 = modifier3;
                                long j12 = j6;
                                long j13 = j7;
                                FontWeight fontWeight4 = fontWeight3;
                                long j14 = j9;
                                TextAlign textAlign5 = textAlign3;
                                long j15 = j10;
                                byte b2 = i31;
                                boolean z114 = z3;
                                int i411111112 = i26;
                                boolean z115 = i32;
                                Map map4 = map2;
                                Function1 function112 = function2;
                                TextStyle textStyle112 = textStyle2;
                                int i411111113 = i6;
                                TextKt.m353TextZ58ophY(annotatedString110, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z114, i411111112, z115 ? 1 : 0, map4, function112, textStyle112, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i411111113);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i24 = i19 | 27648;
                i26 = i2;
                i28 = i24 | 1769472;
                i29 = i6 & 131072;
                if (i29 != 0) {
                    if ((i5 & 12582912) == 0) {
                        if (gapComposer2.changedInstance(function1)) {
                            i30 = 8388608;
                        } else {
                            i30 = 4194304;
                        }
                        i28 |= i30;
                    }
                    if ((i5 & 100663296) != 0) {
                        if ((i6 & 262144) == 0) {
                            i38 = 33554432;
                        } else {
                            i38 = 33554432;
                        }
                        i28 |= i38;
                    }
                    if ((i14 & 306783379) == 306783378) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                        gapComposer2.startDefaults();
                        i33 = i4 & 1;
                        neverEqualPolicy = Composer.Companion.Empty;
                        if (i33 != 0) {
                            if (i39 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                            if (i9 != 0) {
                                jPack = IntMath.pack(0L, Float.NaN);
                            }
                            if (i12 != 0) {
                                fontWeight2 = null;
                            }
                            jPack2 = IntMath.pack(0L, Float.NaN);
                            if (i15 != 0) {
                                textAlign4 = null;
                            } else {
                                textAlign4 = textAlign;
                            }
                            if (i18 != 0) {
                                jPack3 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack3 = j5;
                            }
                            if (i22 != 0) {
                                i34 = 1;
                            } else {
                                i34 = i;
                            }
                            if (i25 != 0) {
                                i26 = Integer.MAX_VALUE;
                            }
                            if (i29 != 0) {
                                objRememberedValue = gapComposer2.rememberedValue();
                                if (objRememberedValue == neverEqualPolicy) {
                                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                function3 = (Function1) objRememberedValue;
                            } else {
                                function3 = function1;
                            }
                            i35 = i6 & 262144;
                            map3 = EmptyMap.INSTANCE;
                            if (i35 != 0) {
                                i28 &= -234881025;
                                textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                            } else {
                                textStyle3 = textStyle;
                            }
                            z4 = true;
                            i36 = 1;
                        } else {
                            if (i39 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                            if (i9 != 0) {
                                jPack = IntMath.pack(0L, Float.NaN);
                            }
                            if (i12 != 0) {
                                fontWeight2 = null;
                            }
                            jPack2 = IntMath.pack(0L, Float.NaN);
                            if (i15 != 0) {
                                textAlign4 = null;
                            } else {
                                textAlign4 = textAlign;
                            }
                            if (i18 != 0) {
                                jPack3 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack3 = j5;
                            }
                            if (i22 != 0) {
                                i34 = 1;
                            } else {
                                i34 = i;
                            }
                            if (i25 != 0) {
                                i26 = Integer.MAX_VALUE;
                            }
                            if (i29 != 0) {
                                objRememberedValue = gapComposer2.rememberedValue();
                                if (objRememberedValue == neverEqualPolicy) {
                                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                function3 = (Function1) objRememberedValue;
                            } else {
                                function3 = function1;
                            }
                            i35 = i6 & 262144;
                            map3 = EmptyMap.INSTANCE;
                            if (i35 != 0) {
                                i28 &= -234881025;
                                textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                            } else {
                                textStyle3 = textStyle;
                            }
                            z4 = true;
                            i36 = 1;
                        }
                        gapComposer2.endDefaults();
                        int i411111112 = i34;
                        gapComposer2.startReplaceGroup(1676919260);
                        if (jColor != 16) {
                            jPack3 = jPack3;
                            jM752getColor0d7_KjU = jColor;
                            z5 = false;
                        } else {
                            gapComposer2.startReplaceGroup(1676920033);
                            jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                            if (jM752getColor0d7_KjU != 16) {
                                jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                            }
                            z5 = false;
                            gapComposer2.end(false);
                        }
                        gapComposer2.end(z5);
                        j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                        zChanged = gapComposer2.changed(j11);
                        objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        textLinkStyles = (TextLinkStyles) objRememberedValue2;
                        zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                        objRememberedValue3 = gapComposer2.rememberedValue();
                        if (zChanged2) {
                            b = 0;
                            objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        } else {
                            b = 0;
                            objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        AnnotatedString annotatedString110 = (AnnotatedString) objRememberedValue3;
                        if (textAlign4 != null) {
                            i37 = textAlign4.value;
                        } else {
                            i37 = b;
                        }
                        TextStyle textStyle112 = textStyle3;
                        int i411111113 = i28 << 6;
                        boolean z114 = z4;
                        int i411111114 = i36;
                        Function1 function112 = function3;
                        int i411111115 = i26;
                        BasicTextKt.m186BasicTextCL7eQgs(annotatedString110, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle112, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function112, i411111112, z114, i411111115, i411111114, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i411111113 & 57344) | (i411111113 & 458752) | (i411111113 & 3670016) | (i411111113 & 29360128) | (i411111113 & 234881024), (i14 >> 9) & 14, 512);
                        gapComposer = gapComposer2;
                        i32 = i411111114;
                        function2 = function112;
                        j7 = jPack;
                        map2 = map3;
                        z3 = z114;
                        j9 = jPack2;
                        textAlign3 = textAlign4;
                        i31 = i411111112;
                        j6 = jColor;
                        j8 = jPack3;
                        textStyle2 = textStyle112;
                        fontWeight3 = fontWeight2;
                        modifier3 = modifier2;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        j6 = j;
                        i31 = i;
                        z3 = z;
                        i32 = i3;
                        map2 = map;
                        function2 = function1;
                        textStyle2 = textStyle;
                        j7 = jPack;
                        textAlign3 = textAlign;
                        j8 = j5;
                        j9 = j3;
                        modifier3 = modifier2;
                        fontWeight3 = fontWeight2;
                    }
                    j10 = j8;
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                                AnnotatedString annotatedString111 = annotatedString;
                                Modifier modifier4 = modifier3;
                                long j12 = j6;
                                long j13 = j7;
                                FontWeight fontWeight4 = fontWeight3;
                                long j14 = j9;
                                TextAlign textAlign5 = textAlign3;
                                long j15 = j10;
                                byte b2 = i31;
                                boolean z115 = z3;
                                int i411111116 = i26;
                                boolean z116 = i32;
                                Map map4 = map2;
                                Function1 function113 = function2;
                                TextStyle textStyle113 = textStyle2;
                                int i411111117 = i6;
                                TextKt.m353TextZ58ophY(annotatedString111, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z115, i411111116, z116 ? 1 : 0, map4, function113, textStyle113, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i411111117);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i28 = i24 | 14352384;
                if ((i5 & 100663296) != 0) {
                    if ((i6 & 262144) == 0) {
                        i38 = 33554432;
                    } else {
                        i38 = 33554432;
                    }
                    i28 |= i38;
                }
                if ((i14 & 306783379) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                    gapComposer2.startDefaults();
                    i33 = i4 & 1;
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (i33 != 0) {
                        if (i39 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        if (i9 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i12 != 0) {
                            fontWeight2 = null;
                        }
                        jPack2 = IntMath.pack(0L, Float.NaN);
                        if (i15 != 0) {
                            textAlign4 = null;
                        } else {
                            textAlign4 = textAlign;
                        }
                        if (i18 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j5;
                        }
                        if (i22 != 0) {
                            i34 = 1;
                        } else {
                            i34 = i;
                        }
                        if (i25 != 0) {
                            i26 = Integer.MAX_VALUE;
                        }
                        if (i29 != 0) {
                            objRememberedValue = gapComposer2.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            function3 = (Function1) objRememberedValue;
                        } else {
                            function3 = function1;
                        }
                        i35 = i6 & 262144;
                        map3 = EmptyMap.INSTANCE;
                        if (i35 != 0) {
                            i28 &= -234881025;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        z4 = true;
                        i36 = 1;
                    } else {
                        if (i39 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        if (i9 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i12 != 0) {
                            fontWeight2 = null;
                        }
                        jPack2 = IntMath.pack(0L, Float.NaN);
                        if (i15 != 0) {
                            textAlign4 = null;
                        } else {
                            textAlign4 = textAlign;
                        }
                        if (i18 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j5;
                        }
                        if (i22 != 0) {
                            i34 = 1;
                        } else {
                            i34 = i;
                        }
                        if (i25 != 0) {
                            i26 = Integer.MAX_VALUE;
                        }
                        if (i29 != 0) {
                            objRememberedValue = gapComposer2.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            function3 = (Function1) objRememberedValue;
                        } else {
                            function3 = function1;
                        }
                        i35 = i6 & 262144;
                        map3 = EmptyMap.INSTANCE;
                        if (i35 != 0) {
                            i28 &= -234881025;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        z4 = true;
                        i36 = 1;
                    }
                    gapComposer2.endDefaults();
                    int i411111116 = i34;
                    gapComposer2.startReplaceGroup(1676919260);
                    if (jColor != 16) {
                        jPack3 = jPack3;
                        jM752getColor0d7_KjU = jColor;
                        z5 = false;
                    } else {
                        gapComposer2.startReplaceGroup(1676920033);
                        jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                        if (jM752getColor0d7_KjU != 16) {
                            jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                        }
                        z5 = false;
                        gapComposer2.end(false);
                    }
                    gapComposer2.end(z5);
                    j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                    zChanged = gapComposer2.changed(j11);
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    textLinkStyles = (TextLinkStyles) objRememberedValue2;
                    zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                    objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged2) {
                        b = 0;
                        objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        b = 0;
                        objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    AnnotatedString annotatedString111 = (AnnotatedString) objRememberedValue3;
                    if (textAlign4 != null) {
                        i37 = textAlign4.value;
                    } else {
                        i37 = b;
                    }
                    TextStyle textStyle113 = textStyle3;
                    int i411111117 = i28 << 6;
                    boolean z115 = z4;
                    int i411111118 = i36;
                    Function1 function113 = function3;
                    int i411111119 = i26;
                    BasicTextKt.m186BasicTextCL7eQgs(annotatedString111, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle113, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function113, i411111116, z115, i411111119, i411111118, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i411111117 & 57344) | (i411111117 & 458752) | (i411111117 & 3670016) | (i411111117 & 29360128) | (i411111117 & 234881024), (i14 >> 9) & 14, 512);
                    gapComposer = gapComposer2;
                    i32 = i411111118;
                    function2 = function113;
                    j7 = jPack;
                    map2 = map3;
                    z3 = z115;
                    j9 = jPack2;
                    textAlign3 = textAlign4;
                    i31 = i411111116;
                    j6 = jColor;
                    j8 = jPack3;
                    textStyle2 = textStyle113;
                    fontWeight3 = fontWeight2;
                    modifier3 = modifier2;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    j6 = j;
                    i31 = i;
                    z3 = z;
                    i32 = i3;
                    map2 = map;
                    function2 = function1;
                    textStyle2 = textStyle;
                    j7 = jPack;
                    textAlign3 = textAlign;
                    j8 = j5;
                    j9 = j3;
                    modifier3 = modifier2;
                    fontWeight3 = fontWeight2;
                }
                j10 = j8;
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                            AnnotatedString annotatedString112 = annotatedString;
                            Modifier modifier4 = modifier3;
                            long j12 = j6;
                            long j13 = j7;
                            FontWeight fontWeight4 = fontWeight3;
                            long j14 = j9;
                            TextAlign textAlign5 = textAlign3;
                            long j15 = j10;
                            byte b2 = i31;
                            boolean z116 = z3;
                            int i4111111110 = i26;
                            boolean z117 = i32;
                            Map map4 = map2;
                            Function1 function114 = function2;
                            TextStyle textStyle114 = textStyle2;
                            int i4111111111 = i6;
                            TextKt.m353TextZ58ophY(annotatedString112, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z116, i4111111110, z117 ? 1 : 0, map4, function114, textStyle114, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i4111111111);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i19 |= 384;
            i22 = i21;
            i24 = i19 | 3072;
            i25 = i6 & 16384;
            if (i25 != 0) {
                if ((i5 & 24576) == 0) {
                    i26 = i2;
                    if (gapComposer2.changed(i26)) {
                        i27 = 16384;
                    } else {
                        i27 = 8192;
                    }
                    i24 |= i27;
                }
                i28 = i24 | 1769472;
                i29 = i6 & 131072;
                if (i29 != 0) {
                    if ((i5 & 12582912) == 0) {
                        if (gapComposer2.changedInstance(function1)) {
                            i30 = 8388608;
                        } else {
                            i30 = 4194304;
                        }
                        i28 |= i30;
                    }
                    if ((i5 & 100663296) != 0) {
                        if ((i6 & 262144) == 0) {
                            i38 = 33554432;
                        } else {
                            i38 = 33554432;
                        }
                        i28 |= i38;
                    }
                    if ((i14 & 306783379) == 306783378) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                        gapComposer2.startDefaults();
                        i33 = i4 & 1;
                        neverEqualPolicy = Composer.Companion.Empty;
                        if (i33 != 0) {
                            if (i39 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                            if (i9 != 0) {
                                jPack = IntMath.pack(0L, Float.NaN);
                            }
                            if (i12 != 0) {
                                fontWeight2 = null;
                            }
                            jPack2 = IntMath.pack(0L, Float.NaN);
                            if (i15 != 0) {
                                textAlign4 = null;
                            } else {
                                textAlign4 = textAlign;
                            }
                            if (i18 != 0) {
                                jPack3 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack3 = j5;
                            }
                            if (i22 != 0) {
                                i34 = 1;
                            } else {
                                i34 = i;
                            }
                            if (i25 != 0) {
                                i26 = Integer.MAX_VALUE;
                            }
                            if (i29 != 0) {
                                objRememberedValue = gapComposer2.rememberedValue();
                                if (objRememberedValue == neverEqualPolicy) {
                                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                function3 = (Function1) objRememberedValue;
                            } else {
                                function3 = function1;
                            }
                            i35 = i6 & 262144;
                            map3 = EmptyMap.INSTANCE;
                            if (i35 != 0) {
                                i28 &= -234881025;
                                textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                            } else {
                                textStyle3 = textStyle;
                            }
                            z4 = true;
                            i36 = 1;
                        } else {
                            if (i39 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                            if (i9 != 0) {
                                jPack = IntMath.pack(0L, Float.NaN);
                            }
                            if (i12 != 0) {
                                fontWeight2 = null;
                            }
                            jPack2 = IntMath.pack(0L, Float.NaN);
                            if (i15 != 0) {
                                textAlign4 = null;
                            } else {
                                textAlign4 = textAlign;
                            }
                            if (i18 != 0) {
                                jPack3 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack3 = j5;
                            }
                            if (i22 != 0) {
                                i34 = 1;
                            } else {
                                i34 = i;
                            }
                            if (i25 != 0) {
                                i26 = Integer.MAX_VALUE;
                            }
                            if (i29 != 0) {
                                objRememberedValue = gapComposer2.rememberedValue();
                                if (objRememberedValue == neverEqualPolicy) {
                                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                function3 = (Function1) objRememberedValue;
                            } else {
                                function3 = function1;
                            }
                            i35 = i6 & 262144;
                            map3 = EmptyMap.INSTANCE;
                            if (i35 != 0) {
                                i28 &= -234881025;
                                textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                            } else {
                                textStyle3 = textStyle;
                            }
                            z4 = true;
                            i36 = 1;
                        }
                        gapComposer2.endDefaults();
                        int i4111111110 = i34;
                        gapComposer2.startReplaceGroup(1676919260);
                        if (jColor != 16) {
                            jPack3 = jPack3;
                            jM752getColor0d7_KjU = jColor;
                            z5 = false;
                        } else {
                            gapComposer2.startReplaceGroup(1676920033);
                            jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                            if (jM752getColor0d7_KjU != 16) {
                                jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                            }
                            z5 = false;
                            gapComposer2.end(false);
                        }
                        gapComposer2.end(z5);
                        j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                        zChanged = gapComposer2.changed(j11);
                        objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        textLinkStyles = (TextLinkStyles) objRememberedValue2;
                        zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                        objRememberedValue3 = gapComposer2.rememberedValue();
                        if (zChanged2) {
                            b = 0;
                            objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        } else {
                            b = 0;
                            objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        AnnotatedString annotatedString112 = (AnnotatedString) objRememberedValue3;
                        if (textAlign4 != null) {
                            i37 = textAlign4.value;
                        } else {
                            i37 = b;
                        }
                        TextStyle textStyle114 = textStyle3;
                        int i4111111111 = i28 << 6;
                        boolean z116 = z4;
                        int i4111111112 = i36;
                        Function1 function114 = function3;
                        int i4111111113 = i26;
                        BasicTextKt.m186BasicTextCL7eQgs(annotatedString112, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle114, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function114, i4111111110, z116, i4111111113, i4111111112, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i4111111111 & 57344) | (i4111111111 & 458752) | (i4111111111 & 3670016) | (i4111111111 & 29360128) | (i4111111111 & 234881024), (i14 >> 9) & 14, 512);
                        gapComposer = gapComposer2;
                        i32 = i4111111112;
                        function2 = function114;
                        j7 = jPack;
                        map2 = map3;
                        z3 = z116;
                        j9 = jPack2;
                        textAlign3 = textAlign4;
                        i31 = i4111111110;
                        j6 = jColor;
                        j8 = jPack3;
                        textStyle2 = textStyle114;
                        fontWeight3 = fontWeight2;
                        modifier3 = modifier2;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        j6 = j;
                        i31 = i;
                        z3 = z;
                        i32 = i3;
                        map2 = map;
                        function2 = function1;
                        textStyle2 = textStyle;
                        j7 = jPack;
                        textAlign3 = textAlign;
                        j8 = j5;
                        j9 = j3;
                        modifier3 = modifier2;
                        fontWeight3 = fontWeight2;
                    }
                    j10 = j8;
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                                AnnotatedString annotatedString113 = annotatedString;
                                Modifier modifier4 = modifier3;
                                long j12 = j6;
                                long j13 = j7;
                                FontWeight fontWeight4 = fontWeight3;
                                long j14 = j9;
                                TextAlign textAlign5 = textAlign3;
                                long j15 = j10;
                                byte b2 = i31;
                                boolean z117 = z3;
                                int i4111111114 = i26;
                                boolean z118 = i32;
                                Map map4 = map2;
                                Function1 function115 = function2;
                                TextStyle textStyle115 = textStyle2;
                                int i4111111115 = i6;
                                TextKt.m353TextZ58ophY(annotatedString113, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z117, i4111111114, z118 ? 1 : 0, map4, function115, textStyle115, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i4111111115);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i28 = i24 | 14352384;
                if ((i5 & 100663296) != 0) {
                    if ((i6 & 262144) == 0) {
                        i38 = 33554432;
                    } else {
                        i38 = 33554432;
                    }
                    i28 |= i38;
                }
                if ((i14 & 306783379) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                    gapComposer2.startDefaults();
                    i33 = i4 & 1;
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (i33 != 0) {
                        if (i39 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        if (i9 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i12 != 0) {
                            fontWeight2 = null;
                        }
                        jPack2 = IntMath.pack(0L, Float.NaN);
                        if (i15 != 0) {
                            textAlign4 = null;
                        } else {
                            textAlign4 = textAlign;
                        }
                        if (i18 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j5;
                        }
                        if (i22 != 0) {
                            i34 = 1;
                        } else {
                            i34 = i;
                        }
                        if (i25 != 0) {
                            i26 = Integer.MAX_VALUE;
                        }
                        if (i29 != 0) {
                            objRememberedValue = gapComposer2.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            function3 = (Function1) objRememberedValue;
                        } else {
                            function3 = function1;
                        }
                        i35 = i6 & 262144;
                        map3 = EmptyMap.INSTANCE;
                        if (i35 != 0) {
                            i28 &= -234881025;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        z4 = true;
                        i36 = 1;
                    } else {
                        if (i39 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        if (i9 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i12 != 0) {
                            fontWeight2 = null;
                        }
                        jPack2 = IntMath.pack(0L, Float.NaN);
                        if (i15 != 0) {
                            textAlign4 = null;
                        } else {
                            textAlign4 = textAlign;
                        }
                        if (i18 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j5;
                        }
                        if (i22 != 0) {
                            i34 = 1;
                        } else {
                            i34 = i;
                        }
                        if (i25 != 0) {
                            i26 = Integer.MAX_VALUE;
                        }
                        if (i29 != 0) {
                            objRememberedValue = gapComposer2.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            function3 = (Function1) objRememberedValue;
                        } else {
                            function3 = function1;
                        }
                        i35 = i6 & 262144;
                        map3 = EmptyMap.INSTANCE;
                        if (i35 != 0) {
                            i28 &= -234881025;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        z4 = true;
                        i36 = 1;
                    }
                    gapComposer2.endDefaults();
                    int i4111111114 = i34;
                    gapComposer2.startReplaceGroup(1676919260);
                    if (jColor != 16) {
                        jPack3 = jPack3;
                        jM752getColor0d7_KjU = jColor;
                        z5 = false;
                    } else {
                        gapComposer2.startReplaceGroup(1676920033);
                        jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                        if (jM752getColor0d7_KjU != 16) {
                            jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                        }
                        z5 = false;
                        gapComposer2.end(false);
                    }
                    gapComposer2.end(z5);
                    j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                    zChanged = gapComposer2.changed(j11);
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    textLinkStyles = (TextLinkStyles) objRememberedValue2;
                    zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                    objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged2) {
                        b = 0;
                        objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        b = 0;
                        objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    AnnotatedString annotatedString113 = (AnnotatedString) objRememberedValue3;
                    if (textAlign4 != null) {
                        i37 = textAlign4.value;
                    } else {
                        i37 = b;
                    }
                    TextStyle textStyle115 = textStyle3;
                    int i4111111115 = i28 << 6;
                    boolean z117 = z4;
                    int i4111111116 = i36;
                    Function1 function115 = function3;
                    int i4111111117 = i26;
                    BasicTextKt.m186BasicTextCL7eQgs(annotatedString113, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle115, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function115, i4111111114, z117, i4111111117, i4111111116, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i4111111115 & 57344) | (i4111111115 & 458752) | (i4111111115 & 3670016) | (i4111111115 & 29360128) | (i4111111115 & 234881024), (i14 >> 9) & 14, 512);
                    gapComposer = gapComposer2;
                    i32 = i4111111116;
                    function2 = function115;
                    j7 = jPack;
                    map2 = map3;
                    z3 = z117;
                    j9 = jPack2;
                    textAlign3 = textAlign4;
                    i31 = i4111111114;
                    j6 = jColor;
                    j8 = jPack3;
                    textStyle2 = textStyle115;
                    fontWeight3 = fontWeight2;
                    modifier3 = modifier2;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    j6 = j;
                    i31 = i;
                    z3 = z;
                    i32 = i3;
                    map2 = map;
                    function2 = function1;
                    textStyle2 = textStyle;
                    j7 = jPack;
                    textAlign3 = textAlign;
                    j8 = j5;
                    j9 = j3;
                    modifier3 = modifier2;
                    fontWeight3 = fontWeight2;
                }
                j10 = j8;
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                            AnnotatedString annotatedString114 = annotatedString;
                            Modifier modifier4 = modifier3;
                            long j12 = j6;
                            long j13 = j7;
                            FontWeight fontWeight4 = fontWeight3;
                            long j14 = j9;
                            TextAlign textAlign5 = textAlign3;
                            long j15 = j10;
                            byte b2 = i31;
                            boolean z118 = z3;
                            int i4111111118 = i26;
                            boolean z119 = i32;
                            Map map4 = map2;
                            Function1 function116 = function2;
                            TextStyle textStyle116 = textStyle2;
                            int i4111111119 = i6;
                            TextKt.m353TextZ58ophY(annotatedString114, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z118, i4111111118, z119 ? 1 : 0, map4, function116, textStyle116, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i4111111119);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i24 = i19 | 27648;
            i26 = i2;
            i28 = i24 | 1769472;
            i29 = i6 & 131072;
            if (i29 != 0) {
                if ((i5 & 12582912) == 0) {
                    if (gapComposer2.changedInstance(function1)) {
                        i30 = 8388608;
                    } else {
                        i30 = 4194304;
                    }
                    i28 |= i30;
                }
                if ((i5 & 100663296) != 0) {
                    if ((i6 & 262144) == 0) {
                        i38 = 33554432;
                    } else {
                        i38 = 33554432;
                    }
                    i28 |= i38;
                }
                if ((i14 & 306783379) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                    gapComposer2.startDefaults();
                    i33 = i4 & 1;
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (i33 != 0) {
                        if (i39 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        if (i9 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i12 != 0) {
                            fontWeight2 = null;
                        }
                        jPack2 = IntMath.pack(0L, Float.NaN);
                        if (i15 != 0) {
                            textAlign4 = null;
                        } else {
                            textAlign4 = textAlign;
                        }
                        if (i18 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j5;
                        }
                        if (i22 != 0) {
                            i34 = 1;
                        } else {
                            i34 = i;
                        }
                        if (i25 != 0) {
                            i26 = Integer.MAX_VALUE;
                        }
                        if (i29 != 0) {
                            objRememberedValue = gapComposer2.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            function3 = (Function1) objRememberedValue;
                        } else {
                            function3 = function1;
                        }
                        i35 = i6 & 262144;
                        map3 = EmptyMap.INSTANCE;
                        if (i35 != 0) {
                            i28 &= -234881025;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        z4 = true;
                        i36 = 1;
                    } else {
                        if (i39 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        if (i9 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i12 != 0) {
                            fontWeight2 = null;
                        }
                        jPack2 = IntMath.pack(0L, Float.NaN);
                        if (i15 != 0) {
                            textAlign4 = null;
                        } else {
                            textAlign4 = textAlign;
                        }
                        if (i18 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j5;
                        }
                        if (i22 != 0) {
                            i34 = 1;
                        } else {
                            i34 = i;
                        }
                        if (i25 != 0) {
                            i26 = Integer.MAX_VALUE;
                        }
                        if (i29 != 0) {
                            objRememberedValue = gapComposer2.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            function3 = (Function1) objRememberedValue;
                        } else {
                            function3 = function1;
                        }
                        i35 = i6 & 262144;
                        map3 = EmptyMap.INSTANCE;
                        if (i35 != 0) {
                            i28 &= -234881025;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        z4 = true;
                        i36 = 1;
                    }
                    gapComposer2.endDefaults();
                    int i4111111118 = i34;
                    gapComposer2.startReplaceGroup(1676919260);
                    if (jColor != 16) {
                        jPack3 = jPack3;
                        jM752getColor0d7_KjU = jColor;
                        z5 = false;
                    } else {
                        gapComposer2.startReplaceGroup(1676920033);
                        jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                        if (jM752getColor0d7_KjU != 16) {
                            jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                        }
                        z5 = false;
                        gapComposer2.end(false);
                    }
                    gapComposer2.end(z5);
                    j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                    zChanged = gapComposer2.changed(j11);
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    textLinkStyles = (TextLinkStyles) objRememberedValue2;
                    zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                    objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged2) {
                        b = 0;
                        objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        b = 0;
                        objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    AnnotatedString annotatedString114 = (AnnotatedString) objRememberedValue3;
                    if (textAlign4 != null) {
                        i37 = textAlign4.value;
                    } else {
                        i37 = b;
                    }
                    TextStyle textStyle116 = textStyle3;
                    int i4111111119 = i28 << 6;
                    boolean z118 = z4;
                    int i41111111110 = i36;
                    Function1 function116 = function3;
                    int i41111111111 = i26;
                    BasicTextKt.m186BasicTextCL7eQgs(annotatedString114, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle116, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function116, i4111111118, z118, i41111111111, i41111111110, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i4111111119 & 57344) | (i4111111119 & 458752) | (i4111111119 & 3670016) | (i4111111119 & 29360128) | (i4111111119 & 234881024), (i14 >> 9) & 14, 512);
                    gapComposer = gapComposer2;
                    i32 = i41111111110;
                    function2 = function116;
                    j7 = jPack;
                    map2 = map3;
                    z3 = z118;
                    j9 = jPack2;
                    textAlign3 = textAlign4;
                    i31 = i4111111118;
                    j6 = jColor;
                    j8 = jPack3;
                    textStyle2 = textStyle116;
                    fontWeight3 = fontWeight2;
                    modifier3 = modifier2;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    j6 = j;
                    i31 = i;
                    z3 = z;
                    i32 = i3;
                    map2 = map;
                    function2 = function1;
                    textStyle2 = textStyle;
                    j7 = jPack;
                    textAlign3 = textAlign;
                    j8 = j5;
                    j9 = j3;
                    modifier3 = modifier2;
                    fontWeight3 = fontWeight2;
                }
                j10 = j8;
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                            AnnotatedString annotatedString115 = annotatedString;
                            Modifier modifier4 = modifier3;
                            long j12 = j6;
                            long j13 = j7;
                            FontWeight fontWeight4 = fontWeight3;
                            long j14 = j9;
                            TextAlign textAlign5 = textAlign3;
                            long j15 = j10;
                            byte b2 = i31;
                            boolean z119 = z3;
                            int i41111111112 = i26;
                            boolean z1110 = i32;
                            Map map4 = map2;
                            Function1 function117 = function2;
                            TextStyle textStyle117 = textStyle2;
                            int i41111111113 = i6;
                            TextKt.m353TextZ58ophY(annotatedString115, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z119, i41111111112, z1110 ? 1 : 0, map4, function117, textStyle117, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i41111111113);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i28 = i24 | 14352384;
            if ((i5 & 100663296) != 0) {
                if ((i6 & 262144) == 0) {
                    i38 = 33554432;
                } else {
                    i38 = 33554432;
                }
                i28 |= i38;
            }
            if ((i14 & 306783379) == 306783378) {
                z2 = true;
            } else {
                z2 = true;
            }
            if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                gapComposer2.startDefaults();
                i33 = i4 & 1;
                neverEqualPolicy = Composer.Companion.Empty;
                if (i33 != 0) {
                    if (i39 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                    if (i9 != 0) {
                        jPack = IntMath.pack(0L, Float.NaN);
                    }
                    if (i12 != 0) {
                        fontWeight2 = null;
                    }
                    jPack2 = IntMath.pack(0L, Float.NaN);
                    if (i15 != 0) {
                        textAlign4 = null;
                    } else {
                        textAlign4 = textAlign;
                    }
                    if (i18 != 0) {
                        jPack3 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack3 = j5;
                    }
                    if (i22 != 0) {
                        i34 = 1;
                    } else {
                        i34 = i;
                    }
                    if (i25 != 0) {
                        i26 = Integer.MAX_VALUE;
                    }
                    if (i29 != 0) {
                        objRememberedValue = gapComposer2.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        function3 = (Function1) objRememberedValue;
                    } else {
                        function3 = function1;
                    }
                    i35 = i6 & 262144;
                    map3 = EmptyMap.INSTANCE;
                    if (i35 != 0) {
                        i28 &= -234881025;
                        textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                    } else {
                        textStyle3 = textStyle;
                    }
                    z4 = true;
                    i36 = 1;
                } else {
                    if (i39 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                    if (i9 != 0) {
                        jPack = IntMath.pack(0L, Float.NaN);
                    }
                    if (i12 != 0) {
                        fontWeight2 = null;
                    }
                    jPack2 = IntMath.pack(0L, Float.NaN);
                    if (i15 != 0) {
                        textAlign4 = null;
                    } else {
                        textAlign4 = textAlign;
                    }
                    if (i18 != 0) {
                        jPack3 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack3 = j5;
                    }
                    if (i22 != 0) {
                        i34 = 1;
                    } else {
                        i34 = i;
                    }
                    if (i25 != 0) {
                        i26 = Integer.MAX_VALUE;
                    }
                    if (i29 != 0) {
                        objRememberedValue = gapComposer2.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        function3 = (Function1) objRememberedValue;
                    } else {
                        function3 = function1;
                    }
                    i35 = i6 & 262144;
                    map3 = EmptyMap.INSTANCE;
                    if (i35 != 0) {
                        i28 &= -234881025;
                        textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                    } else {
                        textStyle3 = textStyle;
                    }
                    z4 = true;
                    i36 = 1;
                }
                gapComposer2.endDefaults();
                int i41111111112 = i34;
                gapComposer2.startReplaceGroup(1676919260);
                if (jColor != 16) {
                    jPack3 = jPack3;
                    jM752getColor0d7_KjU = jColor;
                    z5 = false;
                } else {
                    gapComposer2.startReplaceGroup(1676920033);
                    jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                    if (jM752getColor0d7_KjU != 16) {
                        jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                    }
                    z5 = false;
                    gapComposer2.end(false);
                }
                gapComposer2.end(z5);
                j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                zChanged = gapComposer2.changed(j11);
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                textLinkStyles = (TextLinkStyles) objRememberedValue2;
                zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                objRememberedValue3 = gapComposer2.rememberedValue();
                if (zChanged2) {
                    b = 0;
                    objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                } else {
                    b = 0;
                    objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                AnnotatedString annotatedString115 = (AnnotatedString) objRememberedValue3;
                if (textAlign4 != null) {
                    i37 = textAlign4.value;
                } else {
                    i37 = b;
                }
                TextStyle textStyle117 = textStyle3;
                int i41111111113 = i28 << 6;
                boolean z119 = z4;
                int i41111111114 = i36;
                Function1 function117 = function3;
                int i41111111115 = i26;
                BasicTextKt.m186BasicTextCL7eQgs(annotatedString115, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle117, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function117, i41111111112, z119, i41111111115, i41111111114, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i41111111113 & 57344) | (i41111111113 & 458752) | (i41111111113 & 3670016) | (i41111111113 & 29360128) | (i41111111113 & 234881024), (i14 >> 9) & 14, 512);
                gapComposer = gapComposer2;
                i32 = i41111111114;
                function2 = function117;
                j7 = jPack;
                map2 = map3;
                z3 = z119;
                j9 = jPack2;
                textAlign3 = textAlign4;
                i31 = i41111111112;
                j6 = jColor;
                j8 = jPack3;
                textStyle2 = textStyle117;
                fontWeight3 = fontWeight2;
                modifier3 = modifier2;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                j6 = j;
                i31 = i;
                z3 = z;
                i32 = i3;
                map2 = map;
                function2 = function1;
                textStyle2 = textStyle;
                j7 = jPack;
                textAlign3 = textAlign;
                j8 = j5;
                j9 = j3;
                modifier3 = modifier2;
                fontWeight3 = fontWeight2;
            }
            j10 = j8;
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                        AnnotatedString annotatedString116 = annotatedString;
                        Modifier modifier4 = modifier3;
                        long j12 = j6;
                        long j13 = j7;
                        FontWeight fontWeight4 = fontWeight3;
                        long j14 = j9;
                        TextAlign textAlign5 = textAlign3;
                        long j15 = j10;
                        byte b2 = i31;
                        boolean z1110 = z3;
                        int i41111111116 = i26;
                        boolean z1111 = i32;
                        Map map4 = map2;
                        Function1 function118 = function2;
                        TextStyle textStyle118 = textStyle2;
                        int i41111111117 = i6;
                        TextKt.m353TextZ58ophY(annotatedString116, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z1110, i41111111116, z1111 ? 1 : 0, map4, function118, textStyle118, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i41111111117);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i11 = i8 | 1769472;
        fontWeight2 = fontWeight;
        i14 = i11 | 918552576;
        i15 = i6 & 1024;
        if (i15 != 0) {
            i16 = i5 | 6;
            textAlign2 = textAlign;
        } else {
            textAlign2 = textAlign;
            if ((i5 & 6) == 0) {
                if (gapComposer2.changed(textAlign2)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i16 = i5 | i17;
            } else {
                i16 = i5;
            }
        }
        i18 = i6 & 2048;
        if (i18 != 0) {
            i19 = i16 | 48;
            j5 = j4;
        } else {
            j5 = j4;
            if ((i5 & 48) == 0) {
                if (gapComposer2.changed(j5)) {
                    i20 = 32;
                } else {
                    i20 = 16;
                }
                i16 |= i20;
            }
            i19 = i16;
        }
        i21 = i6 & 4096;
        if (i21 != 0) {
            i22 = i21;
            if ((i5 & 384) == 0) {
                if (gapComposer2.changed(i)) {
                    i23 = 256;
                } else {
                    i23 = 128;
                }
                i19 |= i23;
            }
            i24 = i19 | 3072;
            i25 = i6 & 16384;
            if (i25 != 0) {
                if ((i5 & 24576) == 0) {
                    i26 = i2;
                    if (gapComposer2.changed(i26)) {
                        i27 = 16384;
                    } else {
                        i27 = 8192;
                    }
                    i24 |= i27;
                }
                i28 = i24 | 1769472;
                i29 = i6 & 131072;
                if (i29 != 0) {
                    if ((i5 & 12582912) == 0) {
                        if (gapComposer2.changedInstance(function1)) {
                            i30 = 8388608;
                        } else {
                            i30 = 4194304;
                        }
                        i28 |= i30;
                    }
                    if ((i5 & 100663296) != 0) {
                        if ((i6 & 262144) == 0) {
                            i38 = 33554432;
                        } else {
                            i38 = 33554432;
                        }
                        i28 |= i38;
                    }
                    if ((i14 & 306783379) == 306783378) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                        gapComposer2.startDefaults();
                        i33 = i4 & 1;
                        neverEqualPolicy = Composer.Companion.Empty;
                        if (i33 != 0) {
                            if (i39 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                            if (i9 != 0) {
                                jPack = IntMath.pack(0L, Float.NaN);
                            }
                            if (i12 != 0) {
                                fontWeight2 = null;
                            }
                            jPack2 = IntMath.pack(0L, Float.NaN);
                            if (i15 != 0) {
                                textAlign4 = null;
                            } else {
                                textAlign4 = textAlign;
                            }
                            if (i18 != 0) {
                                jPack3 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack3 = j5;
                            }
                            if (i22 != 0) {
                                i34 = 1;
                            } else {
                                i34 = i;
                            }
                            if (i25 != 0) {
                                i26 = Integer.MAX_VALUE;
                            }
                            if (i29 != 0) {
                                objRememberedValue = gapComposer2.rememberedValue();
                                if (objRememberedValue == neverEqualPolicy) {
                                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                function3 = (Function1) objRememberedValue;
                            } else {
                                function3 = function1;
                            }
                            i35 = i6 & 262144;
                            map3 = EmptyMap.INSTANCE;
                            if (i35 != 0) {
                                i28 &= -234881025;
                                textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                            } else {
                                textStyle3 = textStyle;
                            }
                            z4 = true;
                            i36 = 1;
                        } else {
                            if (i39 != 0) {
                                modifier2 = Modifier.Companion.$$INSTANCE;
                            }
                            jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                            if (i9 != 0) {
                                jPack = IntMath.pack(0L, Float.NaN);
                            }
                            if (i12 != 0) {
                                fontWeight2 = null;
                            }
                            jPack2 = IntMath.pack(0L, Float.NaN);
                            if (i15 != 0) {
                                textAlign4 = null;
                            } else {
                                textAlign4 = textAlign;
                            }
                            if (i18 != 0) {
                                jPack3 = IntMath.pack(0L, Float.NaN);
                            } else {
                                jPack3 = j5;
                            }
                            if (i22 != 0) {
                                i34 = 1;
                            } else {
                                i34 = i;
                            }
                            if (i25 != 0) {
                                i26 = Integer.MAX_VALUE;
                            }
                            if (i29 != 0) {
                                objRememberedValue = gapComposer2.rememberedValue();
                                if (objRememberedValue == neverEqualPolicy) {
                                    objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                    gapComposer2.updateRememberedValue(objRememberedValue);
                                }
                                function3 = (Function1) objRememberedValue;
                            } else {
                                function3 = function1;
                            }
                            i35 = i6 & 262144;
                            map3 = EmptyMap.INSTANCE;
                            if (i35 != 0) {
                                i28 &= -234881025;
                                textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                            } else {
                                textStyle3 = textStyle;
                            }
                            z4 = true;
                            i36 = 1;
                        }
                        gapComposer2.endDefaults();
                        int i41111111116 = i34;
                        gapComposer2.startReplaceGroup(1676919260);
                        if (jColor != 16) {
                            jPack3 = jPack3;
                            jM752getColor0d7_KjU = jColor;
                            z5 = false;
                        } else {
                            gapComposer2.startReplaceGroup(1676920033);
                            jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                            if (jM752getColor0d7_KjU != 16) {
                                jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                            }
                            z5 = false;
                            gapComposer2.end(false);
                        }
                        gapComposer2.end(z5);
                        j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                        zChanged = gapComposer2.changed(j11);
                        objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChanged) {
                            objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        textLinkStyles = (TextLinkStyles) objRememberedValue2;
                        zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                        objRememberedValue3 = gapComposer2.rememberedValue();
                        if (zChanged2) {
                            b = 0;
                            objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        } else {
                            b = 0;
                            objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        AnnotatedString annotatedString116 = (AnnotatedString) objRememberedValue3;
                        if (textAlign4 != null) {
                            i37 = textAlign4.value;
                        } else {
                            i37 = b;
                        }
                        TextStyle textStyle118 = textStyle3;
                        int i41111111117 = i28 << 6;
                        boolean z1110 = z4;
                        int i41111111118 = i36;
                        Function1 function118 = function3;
                        int i41111111119 = i26;
                        BasicTextKt.m186BasicTextCL7eQgs(annotatedString116, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle118, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function118, i41111111116, z1110, i41111111119, i41111111118, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i41111111117 & 57344) | (i41111111117 & 458752) | (i41111111117 & 3670016) | (i41111111117 & 29360128) | (i41111111117 & 234881024), (i14 >> 9) & 14, 512);
                        gapComposer = gapComposer2;
                        i32 = i41111111118;
                        function2 = function118;
                        j7 = jPack;
                        map2 = map3;
                        z3 = z1110;
                        j9 = jPack2;
                        textAlign3 = textAlign4;
                        i31 = i41111111116;
                        j6 = jColor;
                        j8 = jPack3;
                        textStyle2 = textStyle118;
                        fontWeight3 = fontWeight2;
                        modifier3 = modifier2;
                    } else {
                        gapComposer = gapComposer2;
                        gapComposer.skipToGroupEnd();
                        j6 = j;
                        i31 = i;
                        z3 = z;
                        i32 = i3;
                        map2 = map;
                        function2 = function1;
                        textStyle2 = textStyle;
                        j7 = jPack;
                        textAlign3 = textAlign;
                        j8 = j5;
                        j9 = j3;
                        modifier3 = modifier2;
                        fontWeight3 = fontWeight2;
                    }
                    j10 = j8;
                    recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                                int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                                AnnotatedString annotatedString117 = annotatedString;
                                Modifier modifier4 = modifier3;
                                long j12 = j6;
                                long j13 = j7;
                                FontWeight fontWeight4 = fontWeight3;
                                long j14 = j9;
                                TextAlign textAlign5 = textAlign3;
                                long j15 = j10;
                                byte b2 = i31;
                                boolean z1111 = z3;
                                int i411111111110 = i26;
                                boolean z1112 = i32;
                                Map map4 = map2;
                                Function1 function119 = function2;
                                TextStyle textStyle119 = textStyle2;
                                int i411111111111 = i6;
                                TextKt.m353TextZ58ophY(annotatedString117, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z1111, i411111111110, z1112 ? 1 : 0, map4, function119, textStyle119, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i411111111111);
                                return Unit.INSTANCE;
                            }
                        };
                    }
                }
                i28 = i24 | 14352384;
                if ((i5 & 100663296) != 0) {
                    if ((i6 & 262144) == 0) {
                        i38 = 33554432;
                    } else {
                        i38 = 33554432;
                    }
                    i28 |= i38;
                }
                if ((i14 & 306783379) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                    gapComposer2.startDefaults();
                    i33 = i4 & 1;
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (i33 != 0) {
                        if (i39 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        if (i9 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i12 != 0) {
                            fontWeight2 = null;
                        }
                        jPack2 = IntMath.pack(0L, Float.NaN);
                        if (i15 != 0) {
                            textAlign4 = null;
                        } else {
                            textAlign4 = textAlign;
                        }
                        if (i18 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j5;
                        }
                        if (i22 != 0) {
                            i34 = 1;
                        } else {
                            i34 = i;
                        }
                        if (i25 != 0) {
                            i26 = Integer.MAX_VALUE;
                        }
                        if (i29 != 0) {
                            objRememberedValue = gapComposer2.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            function3 = (Function1) objRememberedValue;
                        } else {
                            function3 = function1;
                        }
                        i35 = i6 & 262144;
                        map3 = EmptyMap.INSTANCE;
                        if (i35 != 0) {
                            i28 &= -234881025;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        z4 = true;
                        i36 = 1;
                    } else {
                        if (i39 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        if (i9 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i12 != 0) {
                            fontWeight2 = null;
                        }
                        jPack2 = IntMath.pack(0L, Float.NaN);
                        if (i15 != 0) {
                            textAlign4 = null;
                        } else {
                            textAlign4 = textAlign;
                        }
                        if (i18 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j5;
                        }
                        if (i22 != 0) {
                            i34 = 1;
                        } else {
                            i34 = i;
                        }
                        if (i25 != 0) {
                            i26 = Integer.MAX_VALUE;
                        }
                        if (i29 != 0) {
                            objRememberedValue = gapComposer2.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            function3 = (Function1) objRememberedValue;
                        } else {
                            function3 = function1;
                        }
                        i35 = i6 & 262144;
                        map3 = EmptyMap.INSTANCE;
                        if (i35 != 0) {
                            i28 &= -234881025;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        z4 = true;
                        i36 = 1;
                    }
                    gapComposer2.endDefaults();
                    int i411111111110 = i34;
                    gapComposer2.startReplaceGroup(1676919260);
                    if (jColor != 16) {
                        jPack3 = jPack3;
                        jM752getColor0d7_KjU = jColor;
                        z5 = false;
                    } else {
                        gapComposer2.startReplaceGroup(1676920033);
                        jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                        if (jM752getColor0d7_KjU != 16) {
                            jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                        }
                        z5 = false;
                        gapComposer2.end(false);
                    }
                    gapComposer2.end(z5);
                    j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                    zChanged = gapComposer2.changed(j11);
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    textLinkStyles = (TextLinkStyles) objRememberedValue2;
                    zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                    objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged2) {
                        b = 0;
                        objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        b = 0;
                        objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    AnnotatedString annotatedString117 = (AnnotatedString) objRememberedValue3;
                    if (textAlign4 != null) {
                        i37 = textAlign4.value;
                    } else {
                        i37 = b;
                    }
                    TextStyle textStyle119 = textStyle3;
                    int i411111111111 = i28 << 6;
                    boolean z1111 = z4;
                    int i411111111112 = i36;
                    Function1 function119 = function3;
                    int i411111111113 = i26;
                    BasicTextKt.m186BasicTextCL7eQgs(annotatedString117, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle119, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function119, i411111111110, z1111, i411111111113, i411111111112, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i411111111111 & 57344) | (i411111111111 & 458752) | (i411111111111 & 3670016) | (i411111111111 & 29360128) | (i411111111111 & 234881024), (i14 >> 9) & 14, 512);
                    gapComposer = gapComposer2;
                    i32 = i411111111112;
                    function2 = function119;
                    j7 = jPack;
                    map2 = map3;
                    z3 = z1111;
                    j9 = jPack2;
                    textAlign3 = textAlign4;
                    i31 = i411111111110;
                    j6 = jColor;
                    j8 = jPack3;
                    textStyle2 = textStyle119;
                    fontWeight3 = fontWeight2;
                    modifier3 = modifier2;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    j6 = j;
                    i31 = i;
                    z3 = z;
                    i32 = i3;
                    map2 = map;
                    function2 = function1;
                    textStyle2 = textStyle;
                    j7 = jPack;
                    textAlign3 = textAlign;
                    j8 = j5;
                    j9 = j3;
                    modifier3 = modifier2;
                    fontWeight3 = fontWeight2;
                }
                j10 = j8;
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                            AnnotatedString annotatedString118 = annotatedString;
                            Modifier modifier4 = modifier3;
                            long j12 = j6;
                            long j13 = j7;
                            FontWeight fontWeight4 = fontWeight3;
                            long j14 = j9;
                            TextAlign textAlign5 = textAlign3;
                            long j15 = j10;
                            byte b2 = i31;
                            boolean z1112 = z3;
                            int i411111111114 = i26;
                            boolean z1113 = i32;
                            Map map4 = map2;
                            Function1 function1110 = function2;
                            TextStyle textStyle1110 = textStyle2;
                            int i411111111115 = i6;
                            TextKt.m353TextZ58ophY(annotatedString118, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z1112, i411111111114, z1113 ? 1 : 0, map4, function1110, textStyle1110, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i411111111115);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i24 = i19 | 27648;
            i26 = i2;
            i28 = i24 | 1769472;
            i29 = i6 & 131072;
            if (i29 != 0) {
                if ((i5 & 12582912) == 0) {
                    if (gapComposer2.changedInstance(function1)) {
                        i30 = 8388608;
                    } else {
                        i30 = 4194304;
                    }
                    i28 |= i30;
                }
                if ((i5 & 100663296) != 0) {
                    if ((i6 & 262144) == 0) {
                        i38 = 33554432;
                    } else {
                        i38 = 33554432;
                    }
                    i28 |= i38;
                }
                if ((i14 & 306783379) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                    gapComposer2.startDefaults();
                    i33 = i4 & 1;
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (i33 != 0) {
                        if (i39 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        if (i9 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i12 != 0) {
                            fontWeight2 = null;
                        }
                        jPack2 = IntMath.pack(0L, Float.NaN);
                        if (i15 != 0) {
                            textAlign4 = null;
                        } else {
                            textAlign4 = textAlign;
                        }
                        if (i18 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j5;
                        }
                        if (i22 != 0) {
                            i34 = 1;
                        } else {
                            i34 = i;
                        }
                        if (i25 != 0) {
                            i26 = Integer.MAX_VALUE;
                        }
                        if (i29 != 0) {
                            objRememberedValue = gapComposer2.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            function3 = (Function1) objRememberedValue;
                        } else {
                            function3 = function1;
                        }
                        i35 = i6 & 262144;
                        map3 = EmptyMap.INSTANCE;
                        if (i35 != 0) {
                            i28 &= -234881025;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        z4 = true;
                        i36 = 1;
                    } else {
                        if (i39 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        if (i9 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i12 != 0) {
                            fontWeight2 = null;
                        }
                        jPack2 = IntMath.pack(0L, Float.NaN);
                        if (i15 != 0) {
                            textAlign4 = null;
                        } else {
                            textAlign4 = textAlign;
                        }
                        if (i18 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j5;
                        }
                        if (i22 != 0) {
                            i34 = 1;
                        } else {
                            i34 = i;
                        }
                        if (i25 != 0) {
                            i26 = Integer.MAX_VALUE;
                        }
                        if (i29 != 0) {
                            objRememberedValue = gapComposer2.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            function3 = (Function1) objRememberedValue;
                        } else {
                            function3 = function1;
                        }
                        i35 = i6 & 262144;
                        map3 = EmptyMap.INSTANCE;
                        if (i35 != 0) {
                            i28 &= -234881025;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        z4 = true;
                        i36 = 1;
                    }
                    gapComposer2.endDefaults();
                    int i411111111114 = i34;
                    gapComposer2.startReplaceGroup(1676919260);
                    if (jColor != 16) {
                        jPack3 = jPack3;
                        jM752getColor0d7_KjU = jColor;
                        z5 = false;
                    } else {
                        gapComposer2.startReplaceGroup(1676920033);
                        jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                        if (jM752getColor0d7_KjU != 16) {
                            jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                        }
                        z5 = false;
                        gapComposer2.end(false);
                    }
                    gapComposer2.end(z5);
                    j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                    zChanged = gapComposer2.changed(j11);
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    textLinkStyles = (TextLinkStyles) objRememberedValue2;
                    zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                    objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged2) {
                        b = 0;
                        objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        b = 0;
                        objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    AnnotatedString annotatedString118 = (AnnotatedString) objRememberedValue3;
                    if (textAlign4 != null) {
                        i37 = textAlign4.value;
                    } else {
                        i37 = b;
                    }
                    TextStyle textStyle1110 = textStyle3;
                    int i411111111115 = i28 << 6;
                    boolean z1112 = z4;
                    int i411111111116 = i36;
                    Function1 function1110 = function3;
                    int i411111111117 = i26;
                    BasicTextKt.m186BasicTextCL7eQgs(annotatedString118, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle1110, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function1110, i411111111114, z1112, i411111111117, i411111111116, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i411111111115 & 57344) | (i411111111115 & 458752) | (i411111111115 & 3670016) | (i411111111115 & 29360128) | (i411111111115 & 234881024), (i14 >> 9) & 14, 512);
                    gapComposer = gapComposer2;
                    i32 = i411111111116;
                    function2 = function1110;
                    j7 = jPack;
                    map2 = map3;
                    z3 = z1112;
                    j9 = jPack2;
                    textAlign3 = textAlign4;
                    i31 = i411111111114;
                    j6 = jColor;
                    j8 = jPack3;
                    textStyle2 = textStyle1110;
                    fontWeight3 = fontWeight2;
                    modifier3 = modifier2;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    j6 = j;
                    i31 = i;
                    z3 = z;
                    i32 = i3;
                    map2 = map;
                    function2 = function1;
                    textStyle2 = textStyle;
                    j7 = jPack;
                    textAlign3 = textAlign;
                    j8 = j5;
                    j9 = j3;
                    modifier3 = modifier2;
                    fontWeight3 = fontWeight2;
                }
                j10 = j8;
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                            AnnotatedString annotatedString119 = annotatedString;
                            Modifier modifier4 = modifier3;
                            long j12 = j6;
                            long j13 = j7;
                            FontWeight fontWeight4 = fontWeight3;
                            long j14 = j9;
                            TextAlign textAlign5 = textAlign3;
                            long j15 = j10;
                            byte b2 = i31;
                            boolean z1113 = z3;
                            int i411111111118 = i26;
                            boolean z1114 = i32;
                            Map map4 = map2;
                            Function1 function1111 = function2;
                            TextStyle textStyle1111 = textStyle2;
                            int i411111111119 = i6;
                            TextKt.m353TextZ58ophY(annotatedString119, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z1113, i411111111118, z1114 ? 1 : 0, map4, function1111, textStyle1111, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i411111111119);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i28 = i24 | 14352384;
            if ((i5 & 100663296) != 0) {
                if ((i6 & 262144) == 0) {
                    i38 = 33554432;
                } else {
                    i38 = 33554432;
                }
                i28 |= i38;
            }
            if ((i14 & 306783379) == 306783378) {
                z2 = true;
            } else {
                z2 = true;
            }
            if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                gapComposer2.startDefaults();
                i33 = i4 & 1;
                neverEqualPolicy = Composer.Companion.Empty;
                if (i33 != 0) {
                    if (i39 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                    if (i9 != 0) {
                        jPack = IntMath.pack(0L, Float.NaN);
                    }
                    if (i12 != 0) {
                        fontWeight2 = null;
                    }
                    jPack2 = IntMath.pack(0L, Float.NaN);
                    if (i15 != 0) {
                        textAlign4 = null;
                    } else {
                        textAlign4 = textAlign;
                    }
                    if (i18 != 0) {
                        jPack3 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack3 = j5;
                    }
                    if (i22 != 0) {
                        i34 = 1;
                    } else {
                        i34 = i;
                    }
                    if (i25 != 0) {
                        i26 = Integer.MAX_VALUE;
                    }
                    if (i29 != 0) {
                        objRememberedValue = gapComposer2.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        function3 = (Function1) objRememberedValue;
                    } else {
                        function3 = function1;
                    }
                    i35 = i6 & 262144;
                    map3 = EmptyMap.INSTANCE;
                    if (i35 != 0) {
                        i28 &= -234881025;
                        textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                    } else {
                        textStyle3 = textStyle;
                    }
                    z4 = true;
                    i36 = 1;
                } else {
                    if (i39 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                    if (i9 != 0) {
                        jPack = IntMath.pack(0L, Float.NaN);
                    }
                    if (i12 != 0) {
                        fontWeight2 = null;
                    }
                    jPack2 = IntMath.pack(0L, Float.NaN);
                    if (i15 != 0) {
                        textAlign4 = null;
                    } else {
                        textAlign4 = textAlign;
                    }
                    if (i18 != 0) {
                        jPack3 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack3 = j5;
                    }
                    if (i22 != 0) {
                        i34 = 1;
                    } else {
                        i34 = i;
                    }
                    if (i25 != 0) {
                        i26 = Integer.MAX_VALUE;
                    }
                    if (i29 != 0) {
                        objRememberedValue = gapComposer2.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        function3 = (Function1) objRememberedValue;
                    } else {
                        function3 = function1;
                    }
                    i35 = i6 & 262144;
                    map3 = EmptyMap.INSTANCE;
                    if (i35 != 0) {
                        i28 &= -234881025;
                        textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                    } else {
                        textStyle3 = textStyle;
                    }
                    z4 = true;
                    i36 = 1;
                }
                gapComposer2.endDefaults();
                int i411111111118 = i34;
                gapComposer2.startReplaceGroup(1676919260);
                if (jColor != 16) {
                    jPack3 = jPack3;
                    jM752getColor0d7_KjU = jColor;
                    z5 = false;
                } else {
                    gapComposer2.startReplaceGroup(1676920033);
                    jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                    if (jM752getColor0d7_KjU != 16) {
                        jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                    }
                    z5 = false;
                    gapComposer2.end(false);
                }
                gapComposer2.end(z5);
                j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                zChanged = gapComposer2.changed(j11);
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                textLinkStyles = (TextLinkStyles) objRememberedValue2;
                zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                objRememberedValue3 = gapComposer2.rememberedValue();
                if (zChanged2) {
                    b = 0;
                    objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                } else {
                    b = 0;
                    objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                AnnotatedString annotatedString119 = (AnnotatedString) objRememberedValue3;
                if (textAlign4 != null) {
                    i37 = textAlign4.value;
                } else {
                    i37 = b;
                }
                TextStyle textStyle1111 = textStyle3;
                int i411111111119 = i28 << 6;
                boolean z1113 = z4;
                int i4111111111110 = i36;
                Function1 function1111 = function3;
                int i4111111111111 = i26;
                BasicTextKt.m186BasicTextCL7eQgs(annotatedString119, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle1111, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function1111, i411111111118, z1113, i4111111111111, i4111111111110, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i411111111119 & 57344) | (i411111111119 & 458752) | (i411111111119 & 3670016) | (i411111111119 & 29360128) | (i411111111119 & 234881024), (i14 >> 9) & 14, 512);
                gapComposer = gapComposer2;
                i32 = i4111111111110;
                function2 = function1111;
                j7 = jPack;
                map2 = map3;
                z3 = z1113;
                j9 = jPack2;
                textAlign3 = textAlign4;
                i31 = i411111111118;
                j6 = jColor;
                j8 = jPack3;
                textStyle2 = textStyle1111;
                fontWeight3 = fontWeight2;
                modifier3 = modifier2;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                j6 = j;
                i31 = i;
                z3 = z;
                i32 = i3;
                map2 = map;
                function2 = function1;
                textStyle2 = textStyle;
                j7 = jPack;
                textAlign3 = textAlign;
                j8 = j5;
                j9 = j3;
                modifier3 = modifier2;
                fontWeight3 = fontWeight2;
            }
            j10 = j8;
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                        AnnotatedString annotatedString1110 = annotatedString;
                        Modifier modifier4 = modifier3;
                        long j12 = j6;
                        long j13 = j7;
                        FontWeight fontWeight4 = fontWeight3;
                        long j14 = j9;
                        TextAlign textAlign5 = textAlign3;
                        long j15 = j10;
                        byte b2 = i31;
                        boolean z1114 = z3;
                        int i4111111111112 = i26;
                        boolean z1115 = i32;
                        Map map4 = map2;
                        Function1 function1112 = function2;
                        TextStyle textStyle1112 = textStyle2;
                        int i4111111111113 = i6;
                        TextKt.m353TextZ58ophY(annotatedString1110, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z1114, i4111111111112, z1115 ? 1 : 0, map4, function1112, textStyle1112, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i4111111111113);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i19 |= 384;
        i22 = i21;
        i24 = i19 | 3072;
        i25 = i6 & 16384;
        if (i25 != 0) {
            if ((i5 & 24576) == 0) {
                i26 = i2;
                if (gapComposer2.changed(i26)) {
                    i27 = 16384;
                } else {
                    i27 = 8192;
                }
                i24 |= i27;
            }
            i28 = i24 | 1769472;
            i29 = i6 & 131072;
            if (i29 != 0) {
                if ((i5 & 12582912) == 0) {
                    if (gapComposer2.changedInstance(function1)) {
                        i30 = 8388608;
                    } else {
                        i30 = 4194304;
                    }
                    i28 |= i30;
                }
                if ((i5 & 100663296) != 0) {
                    if ((i6 & 262144) == 0) {
                        i38 = 33554432;
                    } else {
                        i38 = 33554432;
                    }
                    i28 |= i38;
                }
                if ((i14 & 306783379) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                    gapComposer2.startDefaults();
                    i33 = i4 & 1;
                    neverEqualPolicy = Composer.Companion.Empty;
                    if (i33 != 0) {
                        if (i39 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        if (i9 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i12 != 0) {
                            fontWeight2 = null;
                        }
                        jPack2 = IntMath.pack(0L, Float.NaN);
                        if (i15 != 0) {
                            textAlign4 = null;
                        } else {
                            textAlign4 = textAlign;
                        }
                        if (i18 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j5;
                        }
                        if (i22 != 0) {
                            i34 = 1;
                        } else {
                            i34 = i;
                        }
                        if (i25 != 0) {
                            i26 = Integer.MAX_VALUE;
                        }
                        if (i29 != 0) {
                            objRememberedValue = gapComposer2.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            function3 = (Function1) objRememberedValue;
                        } else {
                            function3 = function1;
                        }
                        i35 = i6 & 262144;
                        map3 = EmptyMap.INSTANCE;
                        if (i35 != 0) {
                            i28 &= -234881025;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        z4 = true;
                        i36 = 1;
                    } else {
                        if (i39 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                        if (i9 != 0) {
                            jPack = IntMath.pack(0L, Float.NaN);
                        }
                        if (i12 != 0) {
                            fontWeight2 = null;
                        }
                        jPack2 = IntMath.pack(0L, Float.NaN);
                        if (i15 != 0) {
                            textAlign4 = null;
                        } else {
                            textAlign4 = textAlign;
                        }
                        if (i18 != 0) {
                            jPack3 = IntMath.pack(0L, Float.NaN);
                        } else {
                            jPack3 = j5;
                        }
                        if (i22 != 0) {
                            i34 = 1;
                        } else {
                            i34 = i;
                        }
                        if (i25 != 0) {
                            i26 = Integer.MAX_VALUE;
                        }
                        if (i29 != 0) {
                            objRememberedValue = gapComposer2.rememberedValue();
                            if (objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            function3 = (Function1) objRememberedValue;
                        } else {
                            function3 = function1;
                        }
                        i35 = i6 & 262144;
                        map3 = EmptyMap.INSTANCE;
                        if (i35 != 0) {
                            i28 &= -234881025;
                            textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                        } else {
                            textStyle3 = textStyle;
                        }
                        z4 = true;
                        i36 = 1;
                    }
                    gapComposer2.endDefaults();
                    int i4111111111112 = i34;
                    gapComposer2.startReplaceGroup(1676919260);
                    if (jColor != 16) {
                        jPack3 = jPack3;
                        jM752getColor0d7_KjU = jColor;
                        z5 = false;
                    } else {
                        gapComposer2.startReplaceGroup(1676920033);
                        jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                        if (jM752getColor0d7_KjU != 16) {
                            jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                        }
                        z5 = false;
                        gapComposer2.end(false);
                    }
                    gapComposer2.end(z5);
                    j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                    zChanged = gapComposer2.changed(j11);
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    textLinkStyles = (TextLinkStyles) objRememberedValue2;
                    zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                    objRememberedValue3 = gapComposer2.rememberedValue();
                    if (zChanged2) {
                        b = 0;
                        objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        b = 0;
                        objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                        gapComposer2.updateRememberedValue(objRememberedValue3);
                    }
                    AnnotatedString annotatedString1110 = (AnnotatedString) objRememberedValue3;
                    if (textAlign4 != null) {
                        i37 = textAlign4.value;
                    } else {
                        i37 = b;
                    }
                    TextStyle textStyle1112 = textStyle3;
                    int i4111111111113 = i28 << 6;
                    boolean z1114 = z4;
                    int i4111111111114 = i36;
                    Function1 function1112 = function3;
                    int i4111111111115 = i26;
                    BasicTextKt.m186BasicTextCL7eQgs(annotatedString1110, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle1112, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function1112, i4111111111112, z1114, i4111111111115, i4111111111114, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i4111111111113 & 57344) | (i4111111111113 & 458752) | (i4111111111113 & 3670016) | (i4111111111113 & 29360128) | (i4111111111113 & 234881024), (i14 >> 9) & 14, 512);
                    gapComposer = gapComposer2;
                    i32 = i4111111111114;
                    function2 = function1112;
                    j7 = jPack;
                    map2 = map3;
                    z3 = z1114;
                    j9 = jPack2;
                    textAlign3 = textAlign4;
                    i31 = i4111111111112;
                    j6 = jColor;
                    j8 = jPack3;
                    textStyle2 = textStyle1112;
                    fontWeight3 = fontWeight2;
                    modifier3 = modifier2;
                } else {
                    gapComposer = gapComposer2;
                    gapComposer.skipToGroupEnd();
                    j6 = j;
                    i31 = i;
                    z3 = z;
                    i32 = i3;
                    map2 = map;
                    function2 = function1;
                    textStyle2 = textStyle;
                    j7 = jPack;
                    textAlign3 = textAlign;
                    j8 = j5;
                    j9 = j3;
                    modifier3 = modifier2;
                    fontWeight3 = fontWeight2;
                }
                j10 = j8;
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                            AnnotatedString annotatedString1111 = annotatedString;
                            Modifier modifier4 = modifier3;
                            long j12 = j6;
                            long j13 = j7;
                            FontWeight fontWeight4 = fontWeight3;
                            long j14 = j9;
                            TextAlign textAlign5 = textAlign3;
                            long j15 = j10;
                            byte b2 = i31;
                            boolean z1115 = z3;
                            int i4111111111116 = i26;
                            boolean z1116 = i32;
                            Map map4 = map2;
                            Function1 function1113 = function2;
                            TextStyle textStyle1113 = textStyle2;
                            int i4111111111117 = i6;
                            TextKt.m353TextZ58ophY(annotatedString1111, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z1115, i4111111111116, z1116 ? 1 : 0, map4, function1113, textStyle1113, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i4111111111117);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i28 = i24 | 14352384;
            if ((i5 & 100663296) != 0) {
                if ((i6 & 262144) == 0) {
                    i38 = 33554432;
                } else {
                    i38 = 33554432;
                }
                i28 |= i38;
            }
            if ((i14 & 306783379) == 306783378) {
                z2 = true;
            } else {
                z2 = true;
            }
            if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                gapComposer2.startDefaults();
                i33 = i4 & 1;
                neverEqualPolicy = Composer.Companion.Empty;
                if (i33 != 0) {
                    if (i39 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                    if (i9 != 0) {
                        jPack = IntMath.pack(0L, Float.NaN);
                    }
                    if (i12 != 0) {
                        fontWeight2 = null;
                    }
                    jPack2 = IntMath.pack(0L, Float.NaN);
                    if (i15 != 0) {
                        textAlign4 = null;
                    } else {
                        textAlign4 = textAlign;
                    }
                    if (i18 != 0) {
                        jPack3 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack3 = j5;
                    }
                    if (i22 != 0) {
                        i34 = 1;
                    } else {
                        i34 = i;
                    }
                    if (i25 != 0) {
                        i26 = Integer.MAX_VALUE;
                    }
                    if (i29 != 0) {
                        objRememberedValue = gapComposer2.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        function3 = (Function1) objRememberedValue;
                    } else {
                        function3 = function1;
                    }
                    i35 = i6 & 262144;
                    map3 = EmptyMap.INSTANCE;
                    if (i35 != 0) {
                        i28 &= -234881025;
                        textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                    } else {
                        textStyle3 = textStyle;
                    }
                    z4 = true;
                    i36 = 1;
                } else {
                    if (i39 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                    if (i9 != 0) {
                        jPack = IntMath.pack(0L, Float.NaN);
                    }
                    if (i12 != 0) {
                        fontWeight2 = null;
                    }
                    jPack2 = IntMath.pack(0L, Float.NaN);
                    if (i15 != 0) {
                        textAlign4 = null;
                    } else {
                        textAlign4 = textAlign;
                    }
                    if (i18 != 0) {
                        jPack3 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack3 = j5;
                    }
                    if (i22 != 0) {
                        i34 = 1;
                    } else {
                        i34 = i;
                    }
                    if (i25 != 0) {
                        i26 = Integer.MAX_VALUE;
                    }
                    if (i29 != 0) {
                        objRememberedValue = gapComposer2.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        function3 = (Function1) objRememberedValue;
                    } else {
                        function3 = function1;
                    }
                    i35 = i6 & 262144;
                    map3 = EmptyMap.INSTANCE;
                    if (i35 != 0) {
                        i28 &= -234881025;
                        textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                    } else {
                        textStyle3 = textStyle;
                    }
                    z4 = true;
                    i36 = 1;
                }
                gapComposer2.endDefaults();
                int i4111111111116 = i34;
                gapComposer2.startReplaceGroup(1676919260);
                if (jColor != 16) {
                    jPack3 = jPack3;
                    jM752getColor0d7_KjU = jColor;
                    z5 = false;
                } else {
                    gapComposer2.startReplaceGroup(1676920033);
                    jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                    if (jM752getColor0d7_KjU != 16) {
                        jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                    }
                    z5 = false;
                    gapComposer2.end(false);
                }
                gapComposer2.end(z5);
                j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                zChanged = gapComposer2.changed(j11);
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                textLinkStyles = (TextLinkStyles) objRememberedValue2;
                zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                objRememberedValue3 = gapComposer2.rememberedValue();
                if (zChanged2) {
                    b = 0;
                    objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                } else {
                    b = 0;
                    objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                AnnotatedString annotatedString1111 = (AnnotatedString) objRememberedValue3;
                if (textAlign4 != null) {
                    i37 = textAlign4.value;
                } else {
                    i37 = b;
                }
                TextStyle textStyle1113 = textStyle3;
                int i4111111111117 = i28 << 6;
                boolean z1115 = z4;
                int i4111111111118 = i36;
                Function1 function1113 = function3;
                int i4111111111119 = i26;
                BasicTextKt.m186BasicTextCL7eQgs(annotatedString1111, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle1113, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function1113, i4111111111116, z1115, i4111111111119, i4111111111118, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i4111111111117 & 57344) | (i4111111111117 & 458752) | (i4111111111117 & 3670016) | (i4111111111117 & 29360128) | (i4111111111117 & 234881024), (i14 >> 9) & 14, 512);
                gapComposer = gapComposer2;
                i32 = i4111111111118;
                function2 = function1113;
                j7 = jPack;
                map2 = map3;
                z3 = z1115;
                j9 = jPack2;
                textAlign3 = textAlign4;
                i31 = i4111111111116;
                j6 = jColor;
                j8 = jPack3;
                textStyle2 = textStyle1113;
                fontWeight3 = fontWeight2;
                modifier3 = modifier2;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                j6 = j;
                i31 = i;
                z3 = z;
                i32 = i3;
                map2 = map;
                function2 = function1;
                textStyle2 = textStyle;
                j7 = jPack;
                textAlign3 = textAlign;
                j8 = j5;
                j9 = j3;
                modifier3 = modifier2;
                fontWeight3 = fontWeight2;
            }
            j10 = j8;
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                        AnnotatedString annotatedString1112 = annotatedString;
                        Modifier modifier4 = modifier3;
                        long j12 = j6;
                        long j13 = j7;
                        FontWeight fontWeight4 = fontWeight3;
                        long j14 = j9;
                        TextAlign textAlign5 = textAlign3;
                        long j15 = j10;
                        byte b2 = i31;
                        boolean z1116 = z3;
                        int i41111111111110 = i26;
                        boolean z1117 = i32;
                        Map map4 = map2;
                        Function1 function1114 = function2;
                        TextStyle textStyle1114 = textStyle2;
                        int i41111111111111 = i6;
                        TextKt.m353TextZ58ophY(annotatedString1112, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z1116, i41111111111110, z1117 ? 1 : 0, map4, function1114, textStyle1114, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i41111111111111);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i24 = i19 | 27648;
        i26 = i2;
        i28 = i24 | 1769472;
        i29 = i6 & 131072;
        if (i29 != 0) {
            if ((i5 & 12582912) == 0) {
                if (gapComposer2.changedInstance(function1)) {
                    i30 = 8388608;
                } else {
                    i30 = 4194304;
                }
                i28 |= i30;
            }
            if ((i5 & 100663296) != 0) {
                if ((i6 & 262144) == 0) {
                    i38 = 33554432;
                } else {
                    i38 = 33554432;
                }
                i28 |= i38;
            }
            if ((i14 & 306783379) == 306783378) {
                z2 = true;
            } else {
                z2 = true;
            }
            if (gapComposer2.shouldExecute(i14 & 1, z2)) {
                gapComposer2.startDefaults();
                i33 = i4 & 1;
                neverEqualPolicy = Composer.Companion.Empty;
                if (i33 != 0) {
                    if (i39 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                    if (i9 != 0) {
                        jPack = IntMath.pack(0L, Float.NaN);
                    }
                    if (i12 != 0) {
                        fontWeight2 = null;
                    }
                    jPack2 = IntMath.pack(0L, Float.NaN);
                    if (i15 != 0) {
                        textAlign4 = null;
                    } else {
                        textAlign4 = textAlign;
                    }
                    if (i18 != 0) {
                        jPack3 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack3 = j5;
                    }
                    if (i22 != 0) {
                        i34 = 1;
                    } else {
                        i34 = i;
                    }
                    if (i25 != 0) {
                        i26 = Integer.MAX_VALUE;
                    }
                    if (i29 != 0) {
                        objRememberedValue = gapComposer2.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        function3 = (Function1) objRememberedValue;
                    } else {
                        function3 = function1;
                    }
                    i35 = i6 & 262144;
                    map3 = EmptyMap.INSTANCE;
                    if (i35 != 0) {
                        i28 &= -234881025;
                        textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                    } else {
                        textStyle3 = textStyle;
                    }
                    z4 = true;
                    i36 = 1;
                } else {
                    if (i39 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                    if (i9 != 0) {
                        jPack = IntMath.pack(0L, Float.NaN);
                    }
                    if (i12 != 0) {
                        fontWeight2 = null;
                    }
                    jPack2 = IntMath.pack(0L, Float.NaN);
                    if (i15 != 0) {
                        textAlign4 = null;
                    } else {
                        textAlign4 = textAlign;
                    }
                    if (i18 != 0) {
                        jPack3 = IntMath.pack(0L, Float.NaN);
                    } else {
                        jPack3 = j5;
                    }
                    if (i22 != 0) {
                        i34 = 1;
                    } else {
                        i34 = i;
                    }
                    if (i25 != 0) {
                        i26 = Integer.MAX_VALUE;
                    }
                    if (i29 != 0) {
                        objRememberedValue = gapComposer2.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        function3 = (Function1) objRememberedValue;
                    } else {
                        function3 = function1;
                    }
                    i35 = i6 & 262144;
                    map3 = EmptyMap.INSTANCE;
                    if (i35 != 0) {
                        i28 &= -234881025;
                        textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                    } else {
                        textStyle3 = textStyle;
                    }
                    z4 = true;
                    i36 = 1;
                }
                gapComposer2.endDefaults();
                int i41111111111110 = i34;
                gapComposer2.startReplaceGroup(1676919260);
                if (jColor != 16) {
                    jPack3 = jPack3;
                    jM752getColor0d7_KjU = jColor;
                    z5 = false;
                } else {
                    gapComposer2.startReplaceGroup(1676920033);
                    jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                    if (jM752getColor0d7_KjU != 16) {
                        jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                    }
                    z5 = false;
                    gapComposer2.end(false);
                }
                gapComposer2.end(z5);
                j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
                zChanged = gapComposer2.changed(j11);
                objRememberedValue2 = gapComposer2.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                textLinkStyles = (TextLinkStyles) objRememberedValue2;
                zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
                objRememberedValue3 = gapComposer2.rememberedValue();
                if (zChanged2) {
                    b = 0;
                    objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                } else {
                    b = 0;
                    objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                AnnotatedString annotatedString1112 = (AnnotatedString) objRememberedValue3;
                if (textAlign4 != null) {
                    i37 = textAlign4.value;
                } else {
                    i37 = b;
                }
                TextStyle textStyle1114 = textStyle3;
                int i41111111111111 = i28 << 6;
                boolean z1116 = z4;
                int i41111111111112 = i36;
                Function1 function1114 = function3;
                int i41111111111113 = i26;
                BasicTextKt.m186BasicTextCL7eQgs(annotatedString1112, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle1114, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function1114, i41111111111110, z1116, i41111111111113, i41111111111112, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i41111111111111 & 57344) | (i41111111111111 & 458752) | (i41111111111111 & 3670016) | (i41111111111111 & 29360128) | (i41111111111111 & 234881024), (i14 >> 9) & 14, 512);
                gapComposer = gapComposer2;
                i32 = i41111111111112;
                function2 = function1114;
                j7 = jPack;
                map2 = map3;
                z3 = z1116;
                j9 = jPack2;
                textAlign3 = textAlign4;
                i31 = i41111111111110;
                j6 = jColor;
                j8 = jPack3;
                textStyle2 = textStyle1114;
                fontWeight3 = fontWeight2;
                modifier3 = modifier2;
            } else {
                gapComposer = gapComposer2;
                gapComposer.skipToGroupEnd();
                j6 = j;
                i31 = i;
                z3 = z;
                i32 = i3;
                map2 = map;
                function2 = function1;
                textStyle2 = textStyle;
                j7 = jPack;
                textAlign3 = textAlign;
                j8 = j5;
                j9 = j3;
                modifier3 = modifier2;
                fontWeight3 = fontWeight2;
            }
            j10 = j8;
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                        AnnotatedString annotatedString1113 = annotatedString;
                        Modifier modifier4 = modifier3;
                        long j12 = j6;
                        long j13 = j7;
                        FontWeight fontWeight4 = fontWeight3;
                        long j14 = j9;
                        TextAlign textAlign5 = textAlign3;
                        long j15 = j10;
                        byte b2 = i31;
                        boolean z1117 = z3;
                        int i41111111111114 = i26;
                        boolean z1118 = i32;
                        Map map4 = map2;
                        Function1 function1115 = function2;
                        TextStyle textStyle1115 = textStyle2;
                        int i41111111111115 = i6;
                        TextKt.m353TextZ58ophY(annotatedString1113, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z1117, i41111111111114, z1118 ? 1 : 0, map4, function1115, textStyle1115, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i41111111111115);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i28 = i24 | 14352384;
        if ((i5 & 100663296) != 0) {
            if ((i6 & 262144) == 0) {
                i38 = 33554432;
            } else {
                i38 = 33554432;
            }
            i28 |= i38;
        }
        if ((i14 & 306783379) == 306783378) {
            z2 = true;
        } else {
            z2 = true;
        }
        if (gapComposer2.shouldExecute(i14 & 1, z2)) {
            gapComposer2.startDefaults();
            i33 = i4 & 1;
            neverEqualPolicy = Composer.Companion.Empty;
            if (i33 != 0) {
                if (i39 != 0) {
                    modifier2 = Modifier.Companion.$$INSTANCE;
                }
                jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                if (i9 != 0) {
                    jPack = IntMath.pack(0L, Float.NaN);
                }
                if (i12 != 0) {
                    fontWeight2 = null;
                }
                jPack2 = IntMath.pack(0L, Float.NaN);
                if (i15 != 0) {
                    textAlign4 = null;
                } else {
                    textAlign4 = textAlign;
                }
                if (i18 != 0) {
                    jPack3 = IntMath.pack(0L, Float.NaN);
                } else {
                    jPack3 = j5;
                }
                if (i22 != 0) {
                    i34 = 1;
                } else {
                    i34 = i;
                }
                if (i25 != 0) {
                    i26 = Integer.MAX_VALUE;
                }
                if (i29 != 0) {
                    objRememberedValue = gapComposer2.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    function3 = (Function1) objRememberedValue;
                } else {
                    function3 = function1;
                }
                i35 = i6 & 262144;
                map3 = EmptyMap.INSTANCE;
                if (i35 != 0) {
                    i28 &= -234881025;
                    textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                } else {
                    textStyle3 = textStyle;
                }
                z4 = true;
                i36 = 1;
            } else {
                if (i39 != 0) {
                    modifier2 = Modifier.Companion.$$INSTANCE;
                }
                jColor = ColorKt.Color(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, ColorSpaces.Unspecified);
                if (i9 != 0) {
                    jPack = IntMath.pack(0L, Float.NaN);
                }
                if (i12 != 0) {
                    fontWeight2 = null;
                }
                jPack2 = IntMath.pack(0L, Float.NaN);
                if (i15 != 0) {
                    textAlign4 = null;
                } else {
                    textAlign4 = textAlign;
                }
                if (i18 != 0) {
                    jPack3 = IntMath.pack(0L, Float.NaN);
                } else {
                    jPack3 = j5;
                }
                if (i22 != 0) {
                    i34 = 1;
                } else {
                    i34 = i;
                }
                if (i25 != 0) {
                    i26 = Integer.MAX_VALUE;
                }
                if (i29 != 0) {
                    objRememberedValue = gapComposer2.rememberedValue();
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new TextKt$$ExternalSyntheticLambda0((byte) 0);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    function3 = (Function1) objRememberedValue;
                } else {
                    function3 = function1;
                }
                i35 = i6 & 262144;
                map3 = EmptyMap.INSTANCE;
                if (i35 != 0) {
                    i28 &= -234881025;
                    textStyle3 = (TextStyle) gapComposer2.consume(LocalTextStyle);
                } else {
                    textStyle3 = textStyle;
                }
                z4 = true;
                i36 = 1;
            }
            gapComposer2.endDefaults();
            int i41111111111114 = i34;
            gapComposer2.startReplaceGroup(1676919260);
            if (jColor != 16) {
                jPack3 = jPack3;
                jM752getColor0d7_KjU = jColor;
                z5 = false;
            } else {
                gapComposer2.startReplaceGroup(1676920033);
                jM752getColor0d7_KjU = textStyle3.m752getColor0d7_KjU();
                if (jM752getColor0d7_KjU != 16) {
                    jM752getColor0d7_KjU = ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value;
                }
                z5 = false;
                gapComposer2.end(false);
            }
            gapComposer2.end(z5);
            j11 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.primary;
            zChanged = gapComposer2.changed(j11);
            objRememberedValue2 = gapComposer2.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new TextLinkStyles(new SpanStyle(j11, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Underline, (Shadow) null, 61438), null, null, null);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            textLinkStyles = (TextLinkStyles) objRememberedValue2;
            zChanged2 = ((i14 & 14) == 4) | gapComposer2.changed(textLinkStyles);
            objRememberedValue3 = gapComposer2.rememberedValue();
            if (zChanged2) {
                b = 0;
                objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                gapComposer2.updateRememberedValue(objRememberedValue3);
            } else {
                b = 0;
                objRememberedValue3 = annotatedString.mapAnnotations(new TextKt$$ExternalSyntheticLambda2(b, textLinkStyles));
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            AnnotatedString annotatedString1113 = (AnnotatedString) objRememberedValue3;
            if (textAlign4 != null) {
                i37 = textAlign4.value;
            } else {
                i37 = b;
            }
            TextStyle textStyle1115 = textStyle3;
            int i41111111111115 = i28 << 6;
            boolean z1117 = z4;
            int i41111111111116 = i36;
            Function1 function1115 = function3;
            int i41111111111117 = i26;
            BasicTextKt.m186BasicTextCL7eQgs(annotatedString1113, modifier2, TextStyle.m751mergedA7vx0o$default(textStyle1115, jM752getColor0d7_KjU, jPack, fontWeight2, null, null, jPack2, i37, jPack3, 16609104), function1115, i41111111111114, z1117, i41111111111117, i41111111111116, map3, gapComposer2, ((i28 >> 12) & 7168) | (i14 & 112) | (i41111111111115 & 57344) | (i41111111111115 & 458752) | (i41111111111115 & 3670016) | (i41111111111115 & 29360128) | (i41111111111115 & 234881024), (i14 >> 9) & 14, 512);
            gapComposer = gapComposer2;
            i32 = i41111111111116;
            function2 = function1115;
            j7 = jPack;
            map2 = map3;
            z3 = z1117;
            j9 = jPack2;
            textAlign3 = textAlign4;
            i31 = i41111111111114;
            j6 = jColor;
            j8 = jPack3;
            textStyle2 = textStyle1115;
            fontWeight3 = fontWeight2;
            modifier3 = modifier2;
        } else {
            gapComposer = gapComposer2;
            gapComposer.skipToGroupEnd();
            j6 = j;
            i31 = i;
            z3 = z;
            i32 = i3;
            map2 = map;
            function2 = function1;
            textStyle2 = textStyle;
            j7 = jPack;
            textAlign3 = textAlign;
            j8 = j5;
            j9 = j3;
            modifier3 = modifier2;
            fontWeight3 = fontWeight2;
        }
        j10 = j8;
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                    AnnotatedString annotatedString1114 = annotatedString;
                    Modifier modifier4 = modifier3;
                    long j12 = j6;
                    long j13 = j7;
                    FontWeight fontWeight4 = fontWeight3;
                    long j14 = j9;
                    TextAlign textAlign5 = textAlign3;
                    long j15 = j10;
                    byte b2 = i31;
                    boolean z1118 = z3;
                    int i41111111111118 = i26;
                    boolean z1119 = i32;
                    Map map4 = map2;
                    Function1 function1116 = function2;
                    TextStyle textStyle1116 = textStyle2;
                    int i41111111111119 = i6;
                    TextKt.m353TextZ58ophY(annotatedString1114, modifier4, j12, j13, fontWeight4, j14, textAlign5, j15, b2, z1118, i41111111111118, z1119 ? 1 : 0, map4, function1116, textStyle1116, (Composer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i41111111111119);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
