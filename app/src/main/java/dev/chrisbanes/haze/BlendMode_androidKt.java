package dev.chrisbanes.haze;

import android.graphics.BlendMode;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BlendMode_androidKt {
    /* JADX INFO: renamed from: toAndroidBlendMode-s9anfk8, reason: not valid java name */
    public static final BlendMode m1537toAndroidBlendModes9anfk8(int i) {
        if (i == 0) {
            return BlendMode.CLEAR;
        }
        if (i == 27) {
            return BlendMode.COLOR;
        }
        if (i == 19) {
            return BlendMode.COLOR_BURN;
        }
        if (i == 18) {
            return BlendMode.COLOR_DODGE;
        }
        if (i == 16) {
            return BlendMode.DARKEN;
        }
        if (i == 22) {
            return BlendMode.DIFFERENCE;
        }
        if (i == 2) {
            return BlendMode.DST;
        }
        if (i == 10) {
            return BlendMode.DST_ATOP;
        }
        if (i == 6) {
            return BlendMode.DST_IN;
        }
        if (i == 8) {
            return BlendMode.DST_OUT;
        }
        if (i == 4) {
            return BlendMode.DST_OVER;
        }
        if (i == 23) {
            return BlendMode.EXCLUSION;
        }
        if (i == 20) {
            return BlendMode.HARD_LIGHT;
        }
        if (i == 25) {
            return BlendMode.HUE;
        }
        if (i == 17) {
            return BlendMode.LIGHTEN;
        }
        if (i == 28) {
            return BlendMode.LUMINOSITY;
        }
        if (i == 13) {
            return BlendMode.MODULATE;
        }
        if (i == 24) {
            return BlendMode.MULTIPLY;
        }
        if (i == 15) {
            return BlendMode.OVERLAY;
        }
        if (i == 26) {
            return BlendMode.SATURATION;
        }
        if (i == 14) {
            return BlendMode.SCREEN;
        }
        if (i == 21) {
            return BlendMode.SOFT_LIGHT;
        }
        if (i == 1) {
            return BlendMode.SRC;
        }
        if (i == 9) {
            return BlendMode.SRC_ATOP;
        }
        if (i == 5) {
            return BlendMode.SRC_IN;
        }
        if (i == 7) {
            return BlendMode.SRC_OUT;
        }
        return i == 3 ? BlendMode.SRC_OVER : BlendMode.SRC_IN;
    }
}
