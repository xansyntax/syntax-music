package androidx.compose.foundation.gestures;

import android.widget.EdgeEffect;
import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.AndroidOverscroll_androidKt;
import androidx.compose.foundation.EdgeEffectWrapper;
import androidx.compose.foundation.GlowEdgeEffectCompat;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollingLogic$nestedScrollScope$1 {
    public final /* synthetic */ ScrollingLogic this$0;

    public ScrollingLogic$nestedScrollScope$1(ScrollingLogic scrollingLogic) {
        this.this$0 = scrollingLogic;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:104:0x0209  */
    /* JADX WARN: Code duplicated, block: B:106:0x020e  */
    /* JADX WARN: Code duplicated, block: B:108:0x0216  */
    /* JADX WARN: Code duplicated, block: B:109:0x021a  */
    /* JADX WARN: Code duplicated, block: B:112:0x0226  */
    /* JADX WARN: Code duplicated, block: B:114:0x022b  */
    /* JADX WARN: Code duplicated, block: B:116:0x0233  */
    /* JADX WARN: Code duplicated, block: B:117:0x0237  */
    /* JADX WARN: Code duplicated, block: B:119:0x023a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:122:0x0240  */
    /* JADX WARN: Code duplicated, block: B:125:0x0248  */
    /* JADX WARN: Code duplicated, block: B:136:0x0283  */
    /* JADX WARN: Code duplicated, block: B:143:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:145:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:146:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:152:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:159:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:161:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:162:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:168:0x0307  */
    /* JADX WARN: Code duplicated, block: B:175:0x0324  */
    /* JADX WARN: Code duplicated, block: B:177:0x0335  */
    /* JADX WARN: Code duplicated, block: B:178:0x0339  */
    /* JADX WARN: Code duplicated, block: B:184:0x0349  */
    /* JADX WARN: Code duplicated, block: B:189:0x0351  */
    /* JADX WARN: Code duplicated, block: B:192:0x0355  */
    /* JADX WARN: Code duplicated, block: B:56:0x0107  */
    /* JADX WARN: Code duplicated, block: B:57:0x010a  */
    /* JADX WARN: Code duplicated, block: B:67:0x013c A[PHI: r8
      0x013c: PHI (r8v9 float) = (r8v8 float), (r8v12 float) binds: [B:76:0x016a, B:65:0x0135] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:68:0x013f  */
    /* JADX WARN: Code duplicated, block: B:70:0x0147  */
    /* JADX WARN: Code duplicated, block: B:80:0x0188  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: scrollByWithOverscroll-OzD1aCk, reason: not valid java name */
    public final long m107scrollByWithOverscrollOzD1aCk(int i, long j) {
        long j2;
        float fIntBitsToFloat;
        int i2;
        float fM34pullRightk4lQ0M;
        float fIntBitsToFloat2;
        long jFloatToRawIntBits;
        long jM438minusMKHz9U;
        long jM438minusMKHz9U2;
        boolean z;
        boolean zIsAnimating;
        boolean z2;
        EdgeEffect orCreateBottomEffect;
        float fIntBitsToFloat3;
        GlowEdgeEffectCompat glowEdgeEffectCompat;
        float f;
        EdgeEffect orCreateTopEffect;
        float fIntBitsToFloat4;
        GlowEdgeEffectCompat glowEdgeEffectCompat2;
        float f2;
        EdgeEffect orCreateRightEffect;
        float fIntBitsToFloat5;
        GlowEdgeEffectCompat glowEdgeEffectCompat3;
        float f3;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        ScrollingLogic scrollingLogic = this.this$0;
        scrollingLogic.latestScrollSource = i;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = scrollingLogic.overscrollEffect;
        if (androidEdgeEffectOverscrollEffect == null || !scrollingLogic.getShouldDispatchOverscroll()) {
            return scrollingLogic.m103performScroll3eAAhYA(scrollingLogic.outerStateScope, j, i);
        }
        byte b = scrollingLogic.latestScrollSource;
        ScrollingLogic$$ExternalSyntheticLambda0 scrollingLogic$$ExternalSyntheticLambda0 = scrollingLogic.performScrollForOverscroll;
        EdgeEffectWrapper edgeEffectWrapper = androidEdgeEffectOverscrollEffect.edgeEffectWrapper;
        if (Size.m449isEmptyimpl(androidEdgeEffectOverscrollEffect.containerSize)) {
            return ((Offset) scrollingLogic$$ExternalSyntheticLambda0.invoke(new Offset(j))).packedValue;
        }
        if (!androidEdgeEffectOverscrollEffect.scrollCycleInProgress) {
            if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.leftEffect)) {
                androidEdgeEffectOverscrollEffect.m33pullLeftk4lQ0M(0L);
            }
            if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.rightEffect)) {
                androidEdgeEffectOverscrollEffect.m34pullRightk4lQ0M(0L);
            }
            if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.topEffect)) {
                androidEdgeEffectOverscrollEffect.m35pullTopk4lQ0M(0L);
            }
            if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.bottomEffect)) {
                androidEdgeEffectOverscrollEffect.m32pullBottomk4lQ0M(0L);
            }
            androidEdgeEffectOverscrollEffect.scrollCycleInProgress = true;
        }
        int i5 = AndroidOverscroll_androidKt.$r8$clinit;
        float f4 = b == 2 ? 4.0f : 1.0f;
        long jM440timestuRUvjQ = Offset.m440timestuRUvjQ(j, f4);
        int i6 = (int) (j & 4294967295L);
        if (Float.intBitsToFloat(i6) != CropImageView.DEFAULT_ASPECT_RATIO) {
            if (!EdgeEffectWrapper.isStretched(edgeEffectWrapper.topEffect) || Float.intBitsToFloat(i6) >= CropImageView.DEFAULT_ASPECT_RATIO) {
                j2 = 4294967295L;
                if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.bottomEffect) && Float.intBitsToFloat(i6) > CropImageView.DEFAULT_ASPECT_RATIO) {
                    float fM32pullBottomk4lQ0M = androidEdgeEffectOverscrollEffect.m32pullBottomk4lQ0M(jM440timestuRUvjQ);
                    if (!EdgeEffectWrapper.isStretched(edgeEffectWrapper.bottomEffect)) {
                        edgeEffectWrapper.getOrCreateBottomEffect().finish();
                    }
                    fIntBitsToFloat = fM32pullBottomk4lQ0M == Float.intBitsToFloat((int) (jM440timestuRUvjQ & 4294967295L)) ? Float.intBitsToFloat(i6) : fM32pullBottomk4lQ0M / f4;
                }
            } else {
                float fM35pullTopk4lQ0M = androidEdgeEffectOverscrollEffect.m35pullTopk4lQ0M(jM440timestuRUvjQ);
                j2 = 4294967295L;
                if (!EdgeEffectWrapper.isStretched(edgeEffectWrapper.topEffect)) {
                    edgeEffectWrapper.getOrCreateTopEffect().finish();
                }
                fIntBitsToFloat = fM35pullTopk4lQ0M == Float.intBitsToFloat((int) (jM440timestuRUvjQ & 4294967295L)) ? Float.intBitsToFloat(i6) : fM35pullTopk4lQ0M / f4;
            }
            i2 = (int) (j >> 32);
            if (Float.intBitsToFloat(i2) != CropImageView.DEFAULT_ASPECT_RATIO) {
                fIntBitsToFloat2 = 0.0f;
            } else if (!EdgeEffectWrapper.isStretched(edgeEffectWrapper.leftEffect) && Float.intBitsToFloat(i2) < CropImageView.DEFAULT_ASPECT_RATIO) {
                fM34pullRightk4lQ0M = androidEdgeEffectOverscrollEffect.m33pullLeftk4lQ0M(jM440timestuRUvjQ);
                if (!EdgeEffectWrapper.isStretched(edgeEffectWrapper.leftEffect)) {
                    edgeEffectWrapper.getOrCreateLeftEffect().finish();
                }
                if (fM34pullRightk4lQ0M == Float.intBitsToFloat((int) (jM440timestuRUvjQ >> 32))) {
                    fIntBitsToFloat2 = Float.intBitsToFloat(i2);
                } else {
                    fIntBitsToFloat2 = fM34pullRightk4lQ0M / f4;
                }
            } else if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.rightEffect) || Float.intBitsToFloat(i2) <= CropImageView.DEFAULT_ASPECT_RATIO) {
                fIntBitsToFloat2 = 0.0f;
            } else {
                fM34pullRightk4lQ0M = androidEdgeEffectOverscrollEffect.m34pullRightk4lQ0M(jM440timestuRUvjQ);
                if (!EdgeEffectWrapper.isStretched(edgeEffectWrapper.rightEffect)) {
                    edgeEffectWrapper.getOrCreateRightEffect().finish();
                }
                if (fM34pullRightk4lQ0M == Float.intBitsToFloat((int) (jM440timestuRUvjQ >> 32))) {
                    fIntBitsToFloat2 = Float.intBitsToFloat(i2);
                } else {
                    fIntBitsToFloat2 = fM34pullRightk4lQ0M / f4;
                }
            }
            jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & j2);
            if (!Offset.m434equalsimpl0(jFloatToRawIntBits, 0L)) {
                androidEdgeEffectOverscrollEffect.invalidateOverscroll$foundation();
            }
            jM438minusMKHz9U = Offset.m438minusMKHz9U(j, jFloatToRawIntBits);
            long j3 = ((Offset) scrollingLogic$$ExternalSyntheticLambda0.invoke(new Offset(jM438minusMKHz9U))).packedValue;
            jM438minusMKHz9U2 = Offset.m438minusMKHz9U(jM438minusMKHz9U, j3);
            if ((Float.intBitsToFloat((int) (jM438minusMKHz9U >> 32)) == CropImageView.DEFAULT_ASPECT_RATIO || Float.intBitsToFloat((int) (jM438minusMKHz9U & j2)) != CropImageView.DEFAULT_ASPECT_RATIO) && ((Float.intBitsToFloat((int) (j3 >> 32)) != CropImageView.DEFAULT_ASPECT_RATIO || Float.intBitsToFloat((int) (j3 & j2)) != CropImageView.DEFAULT_ASPECT_RATIO) && (EdgeEffectWrapper.isStretched(edgeEffectWrapper.leftEffect) || EdgeEffectWrapper.isStretched(edgeEffectWrapper.topEffect) || EdgeEffectWrapper.isStretched(edgeEffectWrapper.rightEffect) || EdgeEffectWrapper.isStretched(edgeEffectWrapper.bottomEffect)))) {
                androidEdgeEffectOverscrollEffect.animateToReleaseIfNeeded();
            }
            if (b == 1) {
                i3 = (int) (jM438minusMKHz9U2 >> 32);
                if (Float.intBitsToFloat(i3) > 0.5f) {
                    androidEdgeEffectOverscrollEffect.m33pullLeftk4lQ0M(jM438minusMKHz9U2);
                } else {
                    if (Float.intBitsToFloat(i3) < -0.5f) {
                        androidEdgeEffectOverscrollEffect.m34pullRightk4lQ0M(jM438minusMKHz9U2);
                    } else {
                        z3 = false;
                    }
                    i4 = (int) (jM438minusMKHz9U2 & j2);
                    if (Float.intBitsToFloat(i4) > 0.5f) {
                        androidEdgeEffectOverscrollEffect.m35pullTopk4lQ0M(jM438minusMKHz9U2);
                    } else {
                        if (Float.intBitsToFloat(i4) < -0.5f) {
                            androidEdgeEffectOverscrollEffect.m32pullBottomk4lQ0M(jM438minusMKHz9U2);
                        } else {
                            z4 = false;
                        }
                        if (!z3 || z4) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    z4 = true;
                    if (z3) {
                    }
                    z = true;
                }
                z3 = true;
                i4 = (int) (jM438minusMKHz9U2 & j2);
                if (Float.intBitsToFloat(i4) > 0.5f) {
                    androidEdgeEffectOverscrollEffect.m35pullTopk4lQ0M(jM438minusMKHz9U2);
                } else {
                    if (Float.intBitsToFloat(i4) < -0.5f) {
                        androidEdgeEffectOverscrollEffect.m32pullBottomk4lQ0M(jM438minusMKHz9U2);
                    } else {
                        z4 = false;
                    }
                    if (z3) {
                    }
                    z = true;
                }
                z4 = true;
                if (z3) {
                }
                z = true;
            } else {
                z = false;
            }
            if (!Offset.m434equalsimpl0(jM438minusMKHz9U, 0L)) {
                if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.leftEffect) || Float.intBitsToFloat(i2) >= CropImageView.DEFAULT_ASPECT_RATIO) {
                    zIsAnimating = false;
                } else {
                    EdgeEffect orCreateLeftEffect = edgeEffectWrapper.getOrCreateLeftEffect();
                    float fIntBitsToFloat6 = Float.intBitsToFloat(i2);
                    if (orCreateLeftEffect instanceof GlowEdgeEffectCompat) {
                        GlowEdgeEffectCompat glowEdgeEffectCompat4 = (GlowEdgeEffectCompat) orCreateLeftEffect;
                        float f5 = glowEdgeEffectCompat4.oppositeReleaseDelta + fIntBitsToFloat6;
                        glowEdgeEffectCompat4.oppositeReleaseDelta = f5;
                        if (Math.abs(f5) > glowEdgeEffectCompat4.oppositeReleaseDeltaThreshold) {
                            glowEdgeEffectCompat4.onRelease();
                        }
                    } else {
                        orCreateLeftEffect.onRelease();
                    }
                    zIsAnimating = EdgeEffectWrapper.isAnimating(edgeEffectWrapper.leftEffect);
                }
                if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.rightEffect) && Float.intBitsToFloat(i2) > CropImageView.DEFAULT_ASPECT_RATIO) {
                    orCreateRightEffect = edgeEffectWrapper.getOrCreateRightEffect();
                    fIntBitsToFloat5 = Float.intBitsToFloat(i2);
                    if (orCreateRightEffect instanceof GlowEdgeEffectCompat) {
                        glowEdgeEffectCompat3 = (GlowEdgeEffectCompat) orCreateRightEffect;
                        f3 = glowEdgeEffectCompat3.oppositeReleaseDelta + fIntBitsToFloat5;
                        glowEdgeEffectCompat3.oppositeReleaseDelta = f3;
                        if (Math.abs(f3) > glowEdgeEffectCompat3.oppositeReleaseDeltaThreshold) {
                            glowEdgeEffectCompat3.onRelease();
                        }
                    } else {
                        orCreateRightEffect.onRelease();
                    }
                    if (!zIsAnimating || EdgeEffectWrapper.isAnimating(edgeEffectWrapper.rightEffect)) {
                        zIsAnimating = true;
                    } else {
                        zIsAnimating = false;
                    }
                }
                if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.topEffect) && Float.intBitsToFloat(i6) < CropImageView.DEFAULT_ASPECT_RATIO) {
                    orCreateTopEffect = edgeEffectWrapper.getOrCreateTopEffect();
                    fIntBitsToFloat4 = Float.intBitsToFloat(i6);
                    if (orCreateTopEffect instanceof GlowEdgeEffectCompat) {
                        glowEdgeEffectCompat2 = (GlowEdgeEffectCompat) orCreateTopEffect;
                        f2 = glowEdgeEffectCompat2.oppositeReleaseDelta + fIntBitsToFloat4;
                        glowEdgeEffectCompat2.oppositeReleaseDelta = f2;
                        if (Math.abs(f2) > glowEdgeEffectCompat2.oppositeReleaseDeltaThreshold) {
                            glowEdgeEffectCompat2.onRelease();
                        }
                    } else {
                        orCreateTopEffect.onRelease();
                    }
                    if (!zIsAnimating || EdgeEffectWrapper.isAnimating(edgeEffectWrapper.topEffect)) {
                        zIsAnimating = true;
                    } else {
                        zIsAnimating = false;
                    }
                }
                if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.bottomEffect) && Float.intBitsToFloat(i6) > CropImageView.DEFAULT_ASPECT_RATIO) {
                    orCreateBottomEffect = edgeEffectWrapper.getOrCreateBottomEffect();
                    fIntBitsToFloat3 = Float.intBitsToFloat(i6);
                    if (orCreateBottomEffect instanceof GlowEdgeEffectCompat) {
                        glowEdgeEffectCompat = (GlowEdgeEffectCompat) orCreateBottomEffect;
                        f = glowEdgeEffectCompat.oppositeReleaseDelta + fIntBitsToFloat3;
                        glowEdgeEffectCompat.oppositeReleaseDelta = f;
                        if (Math.abs(f) > glowEdgeEffectCompat.oppositeReleaseDeltaThreshold) {
                            glowEdgeEffectCompat.onRelease();
                        }
                    } else {
                        orCreateBottomEffect.onRelease();
                    }
                    if (!zIsAnimating || EdgeEffectWrapper.isAnimating(edgeEffectWrapper.bottomEffect)) {
                        zIsAnimating = true;
                    } else {
                        zIsAnimating = false;
                    }
                }
                if (!zIsAnimating || z) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = z2;
            }
            if (z) {
                androidEdgeEffectOverscrollEffect.invalidateOverscroll$foundation();
            }
            return Offset.m439plusMKHz9U(jFloatToRawIntBits, j3);
        }
        j2 = 4294967295L;
        fIntBitsToFloat = 0.0f;
        i2 = (int) (j >> 32);
        if (Float.intBitsToFloat(i2) != CropImageView.DEFAULT_ASPECT_RATIO) {
            fIntBitsToFloat2 = 0.0f;
        } else if (!EdgeEffectWrapper.isStretched(edgeEffectWrapper.leftEffect)) {
            if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.rightEffect)) {
                fIntBitsToFloat2 = 0.0f;
            } else {
                fIntBitsToFloat2 = 0.0f;
            }
        } else if (EdgeEffectWrapper.isStretched(edgeEffectWrapper.rightEffect)) {
            fIntBitsToFloat2 = 0.0f;
        } else {
            fIntBitsToFloat2 = 0.0f;
        }
        jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & j2);
        if (!Offset.m434equalsimpl0(jFloatToRawIntBits, 0L)) {
            androidEdgeEffectOverscrollEffect.invalidateOverscroll$foundation();
        }
        jM438minusMKHz9U = Offset.m438minusMKHz9U(j, jFloatToRawIntBits);
        long j4 = ((Offset) scrollingLogic$$ExternalSyntheticLambda0.invoke(new Offset(jM438minusMKHz9U))).packedValue;
        jM438minusMKHz9U2 = Offset.m438minusMKHz9U(jM438minusMKHz9U, j4);
        if (Float.intBitsToFloat((int) (jM438minusMKHz9U >> 32)) == CropImageView.DEFAULT_ASPECT_RATIO) {
            androidEdgeEffectOverscrollEffect.animateToReleaseIfNeeded();
        } else {
            androidEdgeEffectOverscrollEffect.animateToReleaseIfNeeded();
        }
        if (b == 1) {
            i3 = (int) (jM438minusMKHz9U2 >> 32);
            if (Float.intBitsToFloat(i3) > 0.5f) {
                androidEdgeEffectOverscrollEffect.m33pullLeftk4lQ0M(jM438minusMKHz9U2);
            } else {
                if (Float.intBitsToFloat(i3) < -0.5f) {
                    androidEdgeEffectOverscrollEffect.m34pullRightk4lQ0M(jM438minusMKHz9U2);
                } else {
                    z3 = false;
                }
                i4 = (int) (jM438minusMKHz9U2 & j2);
                if (Float.intBitsToFloat(i4) > 0.5f) {
                    androidEdgeEffectOverscrollEffect.m35pullTopk4lQ0M(jM438minusMKHz9U2);
                } else {
                    if (Float.intBitsToFloat(i4) < -0.5f) {
                        androidEdgeEffectOverscrollEffect.m32pullBottomk4lQ0M(jM438minusMKHz9U2);
                    } else {
                        z4 = false;
                    }
                    if (z3) {
                    }
                    z = true;
                }
                z4 = true;
                if (z3) {
                }
                z = true;
            }
            z3 = true;
            i4 = (int) (jM438minusMKHz9U2 & j2);
            if (Float.intBitsToFloat(i4) > 0.5f) {
                androidEdgeEffectOverscrollEffect.m35pullTopk4lQ0M(jM438minusMKHz9U2);
            } else {
                if (Float.intBitsToFloat(i4) < -0.5f) {
                    androidEdgeEffectOverscrollEffect.m32pullBottomk4lQ0M(jM438minusMKHz9U2);
                } else {
                    z4 = false;
                }
                if (z3) {
                }
                z = true;
            }
            z4 = true;
            if (z3) {
            }
            z = true;
        } else {
            z = false;
        }
        if (!Offset.m434equalsimpl0(jM438minusMKHz9U, 0L)) {
            if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.leftEffect)) {
                zIsAnimating = false;
            } else {
                zIsAnimating = false;
            }
            if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.rightEffect)) {
                orCreateRightEffect = edgeEffectWrapper.getOrCreateRightEffect();
                fIntBitsToFloat5 = Float.intBitsToFloat(i2);
                if (orCreateRightEffect instanceof GlowEdgeEffectCompat) {
                    glowEdgeEffectCompat3 = (GlowEdgeEffectCompat) orCreateRightEffect;
                    f3 = glowEdgeEffectCompat3.oppositeReleaseDelta + fIntBitsToFloat5;
                    glowEdgeEffectCompat3.oppositeReleaseDelta = f3;
                    if (Math.abs(f3) > glowEdgeEffectCompat3.oppositeReleaseDeltaThreshold) {
                        glowEdgeEffectCompat3.onRelease();
                    }
                } else {
                    orCreateRightEffect.onRelease();
                }
                if (zIsAnimating) {
                    zIsAnimating = true;
                } else {
                    zIsAnimating = true;
                }
            }
            if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.topEffect)) {
                orCreateTopEffect = edgeEffectWrapper.getOrCreateTopEffect();
                fIntBitsToFloat4 = Float.intBitsToFloat(i6);
                if (orCreateTopEffect instanceof GlowEdgeEffectCompat) {
                    glowEdgeEffectCompat2 = (GlowEdgeEffectCompat) orCreateTopEffect;
                    f2 = glowEdgeEffectCompat2.oppositeReleaseDelta + fIntBitsToFloat4;
                    glowEdgeEffectCompat2.oppositeReleaseDelta = f2;
                    if (Math.abs(f2) > glowEdgeEffectCompat2.oppositeReleaseDeltaThreshold) {
                        glowEdgeEffectCompat2.onRelease();
                    }
                } else {
                    orCreateTopEffect.onRelease();
                }
                if (zIsAnimating) {
                    zIsAnimating = true;
                } else {
                    zIsAnimating = true;
                }
            }
            if (EdgeEffectWrapper.isAnimating(edgeEffectWrapper.bottomEffect)) {
                orCreateBottomEffect = edgeEffectWrapper.getOrCreateBottomEffect();
                fIntBitsToFloat3 = Float.intBitsToFloat(i6);
                if (orCreateBottomEffect instanceof GlowEdgeEffectCompat) {
                    glowEdgeEffectCompat = (GlowEdgeEffectCompat) orCreateBottomEffect;
                    f = glowEdgeEffectCompat.oppositeReleaseDelta + fIntBitsToFloat3;
                    glowEdgeEffectCompat.oppositeReleaseDelta = f;
                    if (Math.abs(f) > glowEdgeEffectCompat.oppositeReleaseDeltaThreshold) {
                        glowEdgeEffectCompat.onRelease();
                    }
                } else {
                    orCreateBottomEffect.onRelease();
                }
                if (zIsAnimating) {
                    zIsAnimating = true;
                } else {
                    zIsAnimating = true;
                }
            }
            if (zIsAnimating) {
                z2 = true;
            } else {
                z2 = true;
            }
            z = z2;
        }
        if (z) {
            androidEdgeEffectOverscrollEffect.invalidateOverscroll$foundation();
        }
        return Offset.m439plusMKHz9U(jFloatToRawIntBits, j4);
    }
}
