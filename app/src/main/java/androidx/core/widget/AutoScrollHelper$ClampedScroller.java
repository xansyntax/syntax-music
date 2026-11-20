package androidx.core.widget;

import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoScrollHelper$ClampedScroller {
    public long mDeltaTime;
    public int mEffectiveRampDown;
    public short mRampDownDuration;
    public short mRampUpDuration;
    public long mStartTime;
    public long mStopTime;
    public float mStopValue;
    public float mTargetVelocityX;
    public float mTargetVelocityY;

    public final float getValueAt(long j) {
        long j2 = this.mStartTime;
        if (j < j2) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        long j3 = this.mStopTime;
        if (j3 < 0 || j < j3) {
            return ListViewAutoScrollHelper.constrain((j - j2) / this.mRampUpDuration, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f) * 0.5f;
        }
        float f = this.mStopValue;
        return (ListViewAutoScrollHelper.constrain((j - j3) / this.mEffectiveRampDown, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f) * f) + (1.0f - f);
    }
}
