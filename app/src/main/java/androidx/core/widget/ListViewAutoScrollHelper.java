package androidx.core.widget;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.yalantis.ucrop.view.CropImageView;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ListViewAutoScrollHelper implements View.OnTouchListener {
    public static final int DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    public final int mActivationDelay;
    public boolean mAlreadyDelayed;
    public boolean mAnimating;
    public final AccelerateInterpolator mEdgeInterpolator;
    public boolean mEnabled;
    public final float[] mMaximumEdges;
    public final float[] mMaximumVelocity;
    public final float[] mMinimumVelocity;
    public boolean mNeedsCancel;
    public boolean mNeedsReset;
    public final float[] mRelativeEdges;
    public final float[] mRelativeVelocity;
    public Toolbar.AnonymousClass2 mRunnable;
    public final AutoScrollHelper$ClampedScroller mScroller;
    public final DropDownListView mTarget;
    public final DropDownListView mTarget$1;

    public ListViewAutoScrollHelper(DropDownListView dropDownListView) {
        AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = new AutoScrollHelper$ClampedScroller();
        autoScrollHelper$ClampedScroller.mStartTime = Long.MIN_VALUE;
        autoScrollHelper$ClampedScroller.mStopTime = -1L;
        autoScrollHelper$ClampedScroller.mDeltaTime = 0L;
        this.mScroller = autoScrollHelper$ClampedScroller;
        this.mEdgeInterpolator = new AccelerateInterpolator();
        float[] fArr = {CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO};
        this.mRelativeEdges = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.mMaximumEdges = fArr2;
        float[] fArr3 = {CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO};
        this.mRelativeVelocity = fArr3;
        float[] fArr4 = {CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO};
        this.mMinimumVelocity = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.mMaximumVelocity = fArr5;
        this.mTarget$1 = dropDownListView;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = ((int) ((1575.0f * f) + 0.5f)) / 1000.0f;
        fArr5[0] = f2;
        fArr5[1] = f2;
        float f3 = ((int) ((f * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f3;
        fArr4[1] = f3;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.mActivationDelay = DEFAULT_ACTIVATION_DELAY;
        autoScrollHelper$ClampedScroller.mRampUpDuration = (short) 500;
        autoScrollHelper$ClampedScroller.mRampDownDuration = (short) 500;
        this.mTarget = dropDownListView;
    }

    public static float constrain(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        return f < f2 ? f2 : f;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:13:0x003c  */
    /* JADX WARN: Code duplicated, block: B:15:0x004b  */
    /* JADX WARN: Code duplicated, block: B:17:0x0051  */
    public final float computeTargetVelocity(int i, float f, float f2, float f3) {
        float fConstrain;
        float interpolation;
        float fConstrain2 = constrain(this.mRelativeEdges[i] * f2, CropImageView.DEFAULT_ASPECT_RATIO, this.mMaximumEdges[i]);
        float fConstrainEdgeValue = constrainEdgeValue(f2 - f, fConstrain2) - constrainEdgeValue(f, fConstrain2);
        AccelerateInterpolator accelerateInterpolator = this.mEdgeInterpolator;
        if (fConstrainEdgeValue >= CropImageView.DEFAULT_ASPECT_RATIO) {
            if (fConstrainEdgeValue > CropImageView.DEFAULT_ASPECT_RATIO) {
                interpolation = accelerateInterpolator.getInterpolation(fConstrainEdgeValue);
            } else {
                fConstrain = 0.0f;
            }
            if (fConstrain == CropImageView.DEFAULT_ASPECT_RATIO) {
                return CropImageView.DEFAULT_ASPECT_RATIO;
            }
            float f4 = this.mRelativeVelocity[i];
            float f5 = this.mMinimumVelocity[i];
            float f6 = this.mMaximumVelocity[i];
            float f7 = f4 * f3;
            return fConstrain > CropImageView.DEFAULT_ASPECT_RATIO ? constrain(fConstrain * f7, f5, f6) : -constrain((-fConstrain) * f7, f5, f6);
        }
        interpolation = -accelerateInterpolator.getInterpolation(-fConstrainEdgeValue);
        fConstrain = constrain(interpolation, -1.0f, 1.0f);
        if (fConstrain == CropImageView.DEFAULT_ASPECT_RATIO) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        float f8 = this.mRelativeVelocity[i];
        float f9 = this.mMinimumVelocity[i];
        float f10 = this.mMaximumVelocity[i];
        float f11 = f8 * f3;
        if (fConstrain > CropImageView.DEFAULT_ASPECT_RATIO) {
        }
    }

    public final float constrainEdgeValue(float f, float f2) {
        if (f2 != CropImageView.DEFAULT_ASPECT_RATIO && f < f2) {
            if (f >= CropImageView.DEFAULT_ASPECT_RATIO) {
                return 1.0f - (f / f2);
            }
            if (this.mAnimating) {
                return 1.0f;
            }
        }
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r0 != 3) goto L30;
     */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        if (this.mEnabled) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                    }
                }
                requestStop();
                return false;
            }
            this.mNeedsCancel = true;
            this.mAlreadyDelayed = false;
            float x = motionEvent.getX();
            float width = view.getWidth();
            DropDownListView dropDownListView = this.mTarget$1;
            float fComputeTargetVelocity = computeTargetVelocity(0, x, width, dropDownListView.getWidth());
            float fComputeTargetVelocity2 = computeTargetVelocity(1, motionEvent.getY(), view.getHeight(), dropDownListView.getHeight());
            AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = this.mScroller;
            autoScrollHelper$ClampedScroller.mTargetVelocityX = fComputeTargetVelocity;
            autoScrollHelper$ClampedScroller.mTargetVelocityY = fComputeTargetVelocity2;
            if (!this.mAnimating && shouldAnimate()) {
                Toolbar.AnonymousClass2 anonymousClass2 = this.mRunnable;
                if (anonymousClass2 == null) {
                    anonymousClass2 = new Toolbar.AnonymousClass2((byte) 5, this);
                    this.mRunnable = anonymousClass2;
                }
                this.mAnimating = true;
                this.mNeedsReset = true;
                if (this.mAlreadyDelayed || (i = this.mActivationDelay) <= 0) {
                    anonymousClass2.run();
                } else {
                    long j = i;
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    dropDownListView.postOnAnimationDelayed(anonymousClass2, j);
                }
                this.mAlreadyDelayed = true;
            }
        }
        return false;
    }

    public final void requestStop() {
        int i = 0;
        if (this.mNeedsReset) {
            this.mAnimating = false;
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = this.mScroller;
        int i2 = (int) (jCurrentAnimationTimeMillis - autoScrollHelper$ClampedScroller.mStartTime);
        short s = autoScrollHelper$ClampedScroller.mRampDownDuration;
        if (i2 > s) {
            i = s;
        } else if (i2 >= 0) {
            i = i2;
        }
        autoScrollHelper$ClampedScroller.mEffectiveRampDown = i;
        autoScrollHelper$ClampedScroller.mStopValue = autoScrollHelper$ClampedScroller.getValueAt(jCurrentAnimationTimeMillis);
        autoScrollHelper$ClampedScroller.mStopTime = jCurrentAnimationTimeMillis;
    }

    public final boolean shouldAnimate() {
        DropDownListView dropDownListView;
        int count;
        AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = this.mScroller;
        float f = autoScrollHelper$ClampedScroller.mTargetVelocityY;
        int iAbs = (int) (f / Math.abs(f));
        Math.abs(autoScrollHelper$ClampedScroller.mTargetVelocityX);
        if (iAbs != 0 && (count = (dropDownListView = this.mTarget).getCount()) != 0) {
            int childCount = dropDownListView.getChildCount();
            int firstVisiblePosition = dropDownListView.getFirstVisiblePosition();
            int i = firstVisiblePosition + childCount;
            if (iAbs <= 0 ? !(iAbs >= 0 || (firstVisiblePosition <= 0 && dropDownListView.getChildAt(0).getTop() >= 0)) : !(i >= count && dropDownListView.getChildAt(childCount - 1).getBottom() <= dropDownListView.getHeight())) {
                return true;
            }
        }
        return false;
    }
}
