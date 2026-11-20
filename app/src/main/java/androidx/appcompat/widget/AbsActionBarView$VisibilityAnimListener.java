package androidx.appcompat.widget;

import androidx.core.view.ViewPropertyAnimatorListener;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AbsActionBarView$VisibilityAnimListener implements ViewPropertyAnimatorListener {
    public boolean mCanceled = false;
    public byte mFinalVisibility;
    public final /* synthetic */ ActionBarContextView this$0;

    public AbsActionBarView$VisibilityAnimListener(ActionBarContextView actionBarContextView) {
        this.this$0 = actionBarContextView;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationCancel() {
        this.mCanceled = true;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationEnd() {
        if (this.mCanceled) {
            return;
        }
        ActionBarContextView actionBarContextView = this.this$0;
        actionBarContextView.mVisibilityAnim = null;
        super/*android.view.View*/.setVisibility(this.mFinalVisibility);
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationStart() {
        super/*android.view.View*/.setVisibility(0);
        this.mCanceled = false;
    }
}
