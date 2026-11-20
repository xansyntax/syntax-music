package com.yalantis.ucrop.model;

import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ImageState {
    private RectF mCropRect;
    private float mCurrentAngle;
    private RectF mCurrentImageRect;
    private float mCurrentScale;

    public ImageState(RectF rectF, RectF rectF2, float f, float f2) {
        this.mCropRect = rectF;
        this.mCurrentImageRect = rectF2;
        this.mCurrentScale = f;
        this.mCurrentAngle = f2;
    }

    public RectF getCropRect() {
        return this.mCropRect;
    }

    public float getCurrentAngle() {
        return this.mCurrentAngle;
    }

    public RectF getCurrentImageRect() {
        return this.mCurrentImageRect;
    }

    public float getCurrentScale() {
        return this.mCurrentScale;
    }
}
