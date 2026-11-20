package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewPropertyAnimatorCompat {
    public final WeakReference mView;

    public ViewPropertyAnimatorCompat(View view) {
        this.mView = new WeakReference(view);
    }

    public final void alpha(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().alpha(f);
        }
    }

    public final void cancel() {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void setDuration(long j) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
    }

    public final void setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = (View) this.mView.get();
        if (view != null) {
            if (viewPropertyAnimatorListener != null) {
                view.animate().setListener(new AnonymousClass1(viewPropertyAnimatorListener, view));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void translationY(float f) {
        View view = (View) this.mView.get();
        if (view != null) {
            view.animate().translationY(f);
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.ViewPropertyAnimatorCompat$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends AnimatorListenerAdapter {
        public final /* synthetic */ byte $r8$classId = 1;
        public final /* synthetic */ Object val$listener;

        public AnonymousClass1(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.val$listener = actionBarOverlayLayout;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            byte b = this.$r8$classId;
            Object obj = this.val$listener;
            switch (b) {
                case 0:
                    ((ViewPropertyAnimatorListener) obj).onAnimationCancel();
                    break;
                default:
                    ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) obj;
                    actionBarOverlayLayout.mCurrentActionBarTopAnimator = null;
                    actionBarOverlayLayout.mAnimatingForFling = false;
                    break;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            byte b = this.$r8$classId;
            Object obj = this.val$listener;
            switch (b) {
                case 0:
                    ((ViewPropertyAnimatorListener) obj).onAnimationEnd();
                    break;
                default:
                    ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) obj;
                    actionBarOverlayLayout.mCurrentActionBarTopAnimator = null;
                    actionBarOverlayLayout.mAnimatingForFling = false;
                    break;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            switch (this.$r8$classId) {
                case 0:
                    ((ViewPropertyAnimatorListener) this.val$listener).onAnimationStart();
                    break;
                default:
                    super.onAnimationStart(animator);
                    break;
            }
        }

        public AnonymousClass1(ViewPropertyAnimatorListener viewPropertyAnimatorListener, View view) {
            this.val$listener = viewPropertyAnimatorListener;
        }
    }
}
