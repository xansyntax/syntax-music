package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.unit.Dp;
import com.metrolist.music.ui.menu.SongMenuKt$$ExternalSyntheticLambda73;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AnimateAsStateKt {
    public static final SpringSpec defaultAnimation = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, null, 7);
    public static final SpringSpec dpDefaultSpring;

    static {
        Map map = VisibilityThresholdsKt.VisibilityThresholdMap;
        dpDefaultSpring = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, new Dp(0.4f), 3);
        Float.floatToRawIntBits(1.0f);
        Float.floatToRawIntBits(1.0f);
        Float.floatToRawIntBits(1.0f);
        Float.floatToRawIntBits(1.0f);
    }

    /* JADX INFO: renamed from: animateDpAsState-AjpBEmI, reason: not valid java name */
    public static final AnimateAsState m18animateDpAsStateAjpBEmI(float f, AnimationSpec animationSpec, String str, Composer composer, int i, int i2) {
        if ((i2 & 2) != 0) {
            animationSpec = dpDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            str = "DpAnimation";
        }
        int i3 = i << 6;
        return animateValueAsState(new Dp(f), ArcSplineKt.DpToVector, animationSpec2, null, str, composer, (i & 14) | ((i << 3) & 896) | (57344 & i3) | (i3 & 458752), 8);
    }

    public static final AnimateAsState animateFloatAsState(float f, AnimationSpec animationSpec, String str, Composer composer, int i, int i2) {
        if ((i2 & 2) != 0) {
            animationSpec = defaultAnimation;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 8) != 0) {
            str = "FloatAnimation";
        }
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startReplaceGroup(1144320933);
        gapComposer.end(false);
        return animateValueAsState(Float.valueOf(f), ArcSplineKt.FloatToVector, animationSpec2, null, str, composer, (i << 3) & 57344, 0);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0078 A[PHI: r6
      0x0078: PHI (r6v6 androidx.compose.animation.core.TwoWayConverterImpl) = (r6v4 androidx.compose.animation.core.TwoWayConverterImpl), (r6v7 androidx.compose.animation.core.TwoWayConverterImpl) binds: [B:32:0x0076, B:28:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:37:0x0084  */
    /* JADX WARN: Code duplicated, block: B:40:0x008d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0093 A[PHI: r7
      0x0093: PHI (r7v8 androidx.compose.animation.core.AnimationSpec) = (r7v6 androidx.compose.animation.core.AnimationSpec), (r7v9 androidx.compose.animation.core.AnimationSpec) binds: [B:42:0x0091, B:38:0x008a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:44:0x0095  */
    /* JADX WARN: Code duplicated, block: B:47:0x009f  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c6 A[PHI: r9
      0x00c6: PHI (r9v17 java.lang.String) = (r9v15 java.lang.String), (r9v18 java.lang.String) binds: [B:60:0x00c4, B:56:0x00bd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:62:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00da  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:74:0x00e9  */
    public static final AnimateAsState animateValueAsState(Object obj, TwoWayConverterImpl twoWayConverterImpl, AnimationSpec animationSpec, Float f, String str, Composer composer, int i, int i2) {
        boolean z;
        boolean z2;
        TwoWayConverterImpl twoWayConverterImpl2;
        boolean z3;
        AnimationSpec animationSpec2;
        boolean z4;
        String str2;
        boolean z5;
        boolean z6;
        Object objRememberedValue;
        AnimateAsState animateAsState;
        Float f2 = (i2 & 8) != 0 ? null : f;
        GapComposer gapComposer = (GapComposer) composer;
        Object objRememberedValue2 = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer.Companion.Empty;
        if (objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
        Object objRememberedValue3 = gapComposer.rememberedValue();
        boolean z7 = true;
        if (objRememberedValue3 == neverEqualPolicy) {
            Float f3 = f2;
            objRememberedValue3 = new AnimateAsState(obj, twoWayConverterImpl, animationSpec, f3, str, coroutineScope);
            f2 = f3;
            gapComposer.updateRememberedValue(objRememberedValue3);
            z = false;
        } else {
            z = true;
        }
        AnimateAsState animateAsState2 = (AnimateAsState) objRememberedValue3;
        if (!z) {
            gapComposer.startReplaceGroup(-2111593986);
            gapComposer.end(false);
            return animateAsState2;
        }
        gapComposer.startReplaceGroup(-2111846729);
        if (((i & 14) ^ 6) > 4 && gapComposer.changedInstance(obj)) {
            z2 = true;
        } else if ((i & 6) == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (((i & 112) ^ 48) > 32) {
            twoWayConverterImpl2 = twoWayConverterImpl;
            if (gapComposer.changedInstance(twoWayConverterImpl2)) {
                z3 = true;
            }
            boolean z8 = z2 | z3;
            if (((i & 896) ^ 384) > 256) {
                animationSpec2 = animationSpec;
                if (!gapComposer.changedInstance(animationSpec2)) {
                    z4 = true;
                }
                boolean z9 = z8 | z4 | ((((i & 7168) ^ 3072) <= 2048 && gapComposer.changedInstance(f2)) || (i & 3072) == 2048);
                if (((57344 & i) ^ 24576) > 16384) {
                    str2 = str;
                    if (!gapComposer.changed(str2)) {
                        z5 = true;
                    }
                    boolean z10 = z9 | z5;
                    if ((((458752 & i) ^ 196608) > 131072 || !gapComposer.changed((Object) null)) && (i & 196608) != 131072) {
                    }
                    z6 = z10 | z7;
                    objRememberedValue = gapComposer.rememberedValue();
                    if (!z6 || objRememberedValue == neverEqualPolicy) {
                        animateAsState = animateAsState2;
                        SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda73 = new SongMenuKt$$ExternalSyntheticLambda73(animateAsState, obj, twoWayConverterImpl2, animationSpec2, f2, str2);
                        gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda73);
                        objRememberedValue = songMenuKt$$ExternalSyntheticLambda73;
                    } else {
                        animateAsState = animateAsState2;
                    }
                    Stack.SideEffect((Function0) objRememberedValue, gapComposer);
                    gapComposer.end(false);
                    return animateAsState;
                }
                str2 = str;
                if ((i & 24576) == 16384) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                boolean z11 = z9 | z5;
                z7 = ((458752 & i) ^ 196608) > 131072 ? false : false;
                z6 = z11 | z7;
                objRememberedValue = gapComposer.rememberedValue();
                if (z6) {
                    animateAsState = animateAsState2;
                    SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda74 = new SongMenuKt$$ExternalSyntheticLambda73(animateAsState, obj, twoWayConverterImpl2, animationSpec2, f2, str2);
                    gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda74);
                    objRememberedValue = songMenuKt$$ExternalSyntheticLambda74;
                } else {
                    animateAsState = animateAsState2;
                    SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda75 = new SongMenuKt$$ExternalSyntheticLambda73(animateAsState, obj, twoWayConverterImpl2, animationSpec2, f2, str2);
                    gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda75);
                    objRememberedValue = songMenuKt$$ExternalSyntheticLambda75;
                }
                Stack.SideEffect((Function0) objRememberedValue, gapComposer);
                gapComposer.end(false);
                return animateAsState;
            }
            animationSpec2 = animationSpec;
            if ((i & 384) == 256) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean z12 = z8 | z4 | ((((i & 7168) ^ 3072) <= 2048 && gapComposer.changedInstance(f2)) || (i & 3072) == 2048);
            if (((57344 & i) ^ 24576) > 16384) {
                str2 = str;
                if (!gapComposer.changed(str2)) {
                    z5 = true;
                }
                boolean z13 = z12 | z5;
                if (((458752 & i) ^ 196608) > 131072) {
                }
                z6 = z13 | z7;
                objRememberedValue = gapComposer.rememberedValue();
                if (z6) {
                    animateAsState = animateAsState2;
                    SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda76 = new SongMenuKt$$ExternalSyntheticLambda73(animateAsState, obj, twoWayConverterImpl2, animationSpec2, f2, str2);
                    gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda76);
                    objRememberedValue = songMenuKt$$ExternalSyntheticLambda76;
                } else {
                    animateAsState = animateAsState2;
                    SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda77 = new SongMenuKt$$ExternalSyntheticLambda73(animateAsState, obj, twoWayConverterImpl2, animationSpec2, f2, str2);
                    gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda77);
                    objRememberedValue = songMenuKt$$ExternalSyntheticLambda77;
                }
                Stack.SideEffect((Function0) objRememberedValue, gapComposer);
                gapComposer.end(false);
                return animateAsState;
            }
            str2 = str;
            if ((i & 24576) == 16384) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean z14 = z12 | z5;
            if (((458752 & i) ^ 196608) > 131072) {
            }
            z6 = z14 | z7;
            objRememberedValue = gapComposer.rememberedValue();
            if (z6) {
                animateAsState = animateAsState2;
                SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda78 = new SongMenuKt$$ExternalSyntheticLambda73(animateAsState, obj, twoWayConverterImpl2, animationSpec2, f2, str2);
                gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda78);
                objRememberedValue = songMenuKt$$ExternalSyntheticLambda78;
            } else {
                animateAsState = animateAsState2;
                SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda79 = new SongMenuKt$$ExternalSyntheticLambda73(animateAsState, obj, twoWayConverterImpl2, animationSpec2, f2, str2);
                gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda79);
                objRememberedValue = songMenuKt$$ExternalSyntheticLambda79;
            }
            Stack.SideEffect((Function0) objRememberedValue, gapComposer);
            gapComposer.end(false);
            return animateAsState;
        }
        twoWayConverterImpl2 = twoWayConverterImpl;
        if ((i & 48) == 32) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean z15 = z2 | z3;
        if (((i & 896) ^ 384) > 256) {
            animationSpec2 = animationSpec;
            if (!gapComposer.changedInstance(animationSpec2)) {
                z4 = true;
            }
            boolean z16 = z15 | z4 | ((((i & 7168) ^ 3072) <= 2048 && gapComposer.changedInstance(f2)) || (i & 3072) == 2048);
            if (((57344 & i) ^ 24576) > 16384) {
                str2 = str;
                if (!gapComposer.changed(str2)) {
                    z5 = true;
                }
                boolean z17 = z16 | z5;
                if (((458752 & i) ^ 196608) > 131072) {
                }
                z6 = z17 | z7;
                objRememberedValue = gapComposer.rememberedValue();
                if (z6) {
                    animateAsState = animateAsState2;
                    SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda710 = new SongMenuKt$$ExternalSyntheticLambda73(animateAsState, obj, twoWayConverterImpl2, animationSpec2, f2, str2);
                    gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda710);
                    objRememberedValue = songMenuKt$$ExternalSyntheticLambda710;
                } else {
                    animateAsState = animateAsState2;
                    SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda711 = new SongMenuKt$$ExternalSyntheticLambda73(animateAsState, obj, twoWayConverterImpl2, animationSpec2, f2, str2);
                    gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda711);
                    objRememberedValue = songMenuKt$$ExternalSyntheticLambda711;
                }
                Stack.SideEffect((Function0) objRememberedValue, gapComposer);
                gapComposer.end(false);
                return animateAsState;
            }
            str2 = str;
            if ((i & 24576) == 16384) {
                z5 = true;
            } else {
                z5 = false;
            }
            boolean z18 = z16 | z5;
            if (((458752 & i) ^ 196608) > 131072) {
            }
            z6 = z18 | z7;
            objRememberedValue = gapComposer.rememberedValue();
            if (z6) {
                animateAsState = animateAsState2;
                SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda712 = new SongMenuKt$$ExternalSyntheticLambda73(animateAsState, obj, twoWayConverterImpl2, animationSpec2, f2, str2);
                gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda712);
                objRememberedValue = songMenuKt$$ExternalSyntheticLambda712;
            } else {
                animateAsState = animateAsState2;
                SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda713 = new SongMenuKt$$ExternalSyntheticLambda73(animateAsState, obj, twoWayConverterImpl2, animationSpec2, f2, str2);
                gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda713);
                objRememberedValue = songMenuKt$$ExternalSyntheticLambda713;
            }
            Stack.SideEffect((Function0) objRememberedValue, gapComposer);
            gapComposer.end(false);
            return animateAsState;
        }
        animationSpec2 = animationSpec;
        if ((i & 384) == 256) {
            z4 = true;
        } else {
            z4 = false;
        }
        boolean z19 = z15 | z4 | ((((i & 7168) ^ 3072) <= 2048 && gapComposer.changedInstance(f2)) || (i & 3072) == 2048);
        if (((57344 & i) ^ 24576) > 16384) {
            str2 = str;
            if (!gapComposer.changed(str2)) {
                z5 = true;
            }
            boolean z110 = z19 | z5;
            if (((458752 & i) ^ 196608) > 131072) {
            }
            z6 = z110 | z7;
            objRememberedValue = gapComposer.rememberedValue();
            if (z6) {
                animateAsState = animateAsState2;
                SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda714 = new SongMenuKt$$ExternalSyntheticLambda73(animateAsState, obj, twoWayConverterImpl2, animationSpec2, f2, str2);
                gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda714);
                objRememberedValue = songMenuKt$$ExternalSyntheticLambda714;
            } else {
                animateAsState = animateAsState2;
                SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda715 = new SongMenuKt$$ExternalSyntheticLambda73(animateAsState, obj, twoWayConverterImpl2, animationSpec2, f2, str2);
                gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda715);
                objRememberedValue = songMenuKt$$ExternalSyntheticLambda715;
            }
            Stack.SideEffect((Function0) objRememberedValue, gapComposer);
            gapComposer.end(false);
            return animateAsState;
        }
        str2 = str;
        if ((i & 24576) == 16384) {
            z5 = true;
        } else {
            z5 = false;
        }
        boolean z111 = z19 | z5;
        if (((458752 & i) ^ 196608) > 131072) {
        }
        z6 = z111 | z7;
        objRememberedValue = gapComposer.rememberedValue();
        if (z6) {
            animateAsState = animateAsState2;
            SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda716 = new SongMenuKt$$ExternalSyntheticLambda73(animateAsState, obj, twoWayConverterImpl2, animationSpec2, f2, str2);
            gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda716);
            objRememberedValue = songMenuKt$$ExternalSyntheticLambda716;
        } else {
            animateAsState = animateAsState2;
            SongMenuKt$$ExternalSyntheticLambda73 songMenuKt$$ExternalSyntheticLambda717 = new SongMenuKt$$ExternalSyntheticLambda73(animateAsState, obj, twoWayConverterImpl2, animationSpec2, f2, str2);
            gapComposer.updateRememberedValue(songMenuKt$$ExternalSyntheticLambda717);
            objRememberedValue = songMenuKt$$ExternalSyntheticLambda717;
        }
        Stack.SideEffect((Function0) objRememberedValue, gapComposer);
        gapComposer.end(false);
        return animateAsState;
    }
}
