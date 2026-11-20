package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import com.google.common.math.IntMath;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewPropertyAnimatorCompatSet {
    public Interpolator mInterpolator;
    public boolean mIsStarted;
    public ViewPropertyAnimatorListener mListener;
    public long mDuration = -1;
    public final AnonymousClass1 mProxyListener = new IntMath() { // from class: androidx.appcompat.view.ViewPropertyAnimatorCompatSet.1
        public boolean mProxyStarted = false;
        public int mProxyEndCount = 0;

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationEnd() {
            int i = this.mProxyEndCount + 1;
            this.mProxyEndCount = i;
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = ViewPropertyAnimatorCompatSet.this;
            if (i == viewPropertyAnimatorCompatSet.mAnimators.size()) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = viewPropertyAnimatorCompatSet.mListener;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd();
                }
                this.mProxyEndCount = 0;
                this.mProxyStarted = false;
                viewPropertyAnimatorCompatSet.mIsStarted = false;
            }
        }

        @Override // com.google.common.math.IntMath, androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationStart() {
            if (this.mProxyStarted) {
                return;
            }
            this.mProxyStarted = true;
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = ViewPropertyAnimatorCompatSet.this.mListener;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart();
            }
        }
    };
    public final ArrayList mAnimators = new ArrayList();

    public final void cancel() {
        if (this.mIsStarted) {
            ArrayList arrayList = this.mAnimators;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((ViewPropertyAnimatorCompat) obj).cancel();
            }
            this.mIsStarted = false;
        }
    }

    public final void start() {
        View view;
        if (this.mIsStarted) {
            return;
        }
        ArrayList arrayList = this.mAnimators;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) obj;
            long j = this.mDuration;
            if (j >= 0) {
                viewPropertyAnimatorCompat.setDuration(j);
            }
            Interpolator interpolator = this.mInterpolator;
            if (interpolator != null && (view = (View) viewPropertyAnimatorCompat.mView.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.mListener != null) {
                viewPropertyAnimatorCompat.setListener(this.mProxyListener);
            }
            View view2 = (View) viewPropertyAnimatorCompat.mView.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.mIsStarted = true;
    }
}
