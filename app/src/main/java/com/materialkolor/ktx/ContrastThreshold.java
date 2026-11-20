package com.materialkolor.ktx;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public enum ContrastThreshold {
    WCAG_AA_NORMAL_TEXT(4.5d),
    /* JADX INFO: Fake field, exist only in values array */
    WCAG_AA_LARGE_TEXT(3.0d),
    /* JADX INFO: Fake field, exist only in values array */
    WCAG_AAA_NORMAL_TEXT(7.0d),
    /* JADX INFO: Fake field, exist only in values array */
    WCAG_AAA_LARGE_TEXT(4.5d);

    public final double threshold;

    ContrastThreshold(double d) {
        this.threshold = d;
    }
}
