package com.metrolist.music.constants;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public enum LoudnessLevel {
    /* JADX INFO: Fake field, exist only in values array */
    AGGRESSIVE(-7.0f),
    /* JADX INFO: Fake field, exist only in values array */
    LOUD(-11.0f),
    BALANCED(-14.0f),
    /* JADX INFO: Fake field, exist only in values array */
    QUIET(-19.0f);

    public final float targetLufs;

    LoudnessLevel(float f) {
        this.targetLufs = f;
    }
}
