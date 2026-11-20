package androidx.fragment.app;

import android.view.View;
import androidx.core.os.CancellationSignal;
import androidx.datastore.preferences.PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class SpecialEffectsController$FragmentStateManagerOperation {
    public final ArrayList mCompletionListeners;
    public int mFinalState;
    public final Fragment mFragment;
    public final FragmentStateManager mFragmentStateManager;
    public boolean mIsCanceled;
    public boolean mIsComplete;
    public int mLifecycleImpact;
    public final HashSet mSpecialEffectsSignals;

    public SpecialEffectsController$FragmentStateManagerOperation(int i, int i2, FragmentStateManager fragmentStateManager, CancellationSignal cancellationSignal) {
        Fragment fragment = fragmentStateManager.mFragment;
        this.mCompletionListeners = new ArrayList();
        this.mSpecialEffectsSignals = new HashSet();
        this.mIsCanceled = false;
        this.mIsComplete = false;
        this.mFinalState = i;
        this.mLifecycleImpact = i2;
        this.mFragment = fragment;
        cancellationSignal.setOnCancelListener(new Fragment.AnonymousClass7((byte) 2, this));
        this.mFragmentStateManager = fragmentStateManager;
    }

    public final void cancel() {
        if (this.mIsCanceled) {
            return;
        }
        this.mIsCanceled = true;
        if (this.mSpecialEffectsSignals.isEmpty()) {
            complete();
            return;
        }
        ArrayList arrayList = new ArrayList(this.mSpecialEffectsSignals);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            CancellationSignal cancellationSignal = (CancellationSignal) obj;
            synchronized (cancellationSignal) {
                try {
                    if (!cancellationSignal.mIsCanceled) {
                        cancellationSignal.mIsCanceled = true;
                        cancellationSignal.mCancelInProgress = true;
                        CancellationSignal.OnCancelListener onCancelListener = cancellationSignal.mOnCancelListener;
                        if (onCancelListener != null) {
                            try {
                                onCancelListener.onCancel();
                            } catch (Throwable th) {
                                synchronized (cancellationSignal) {
                                    cancellationSignal.mCancelInProgress = false;
                                    cancellationSignal.notifyAll();
                                    throw th;
                                }
                            }
                        }
                        synchronized (cancellationSignal) {
                            cancellationSignal.mCancelInProgress = false;
                            cancellationSignal.notifyAll();
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final void complete() {
        if (!this.mIsComplete) {
            if (FragmentManager.isLoggingEnabled(2)) {
                toString();
            }
            this.mIsComplete = true;
            ArrayList arrayList = this.mCompletionListeners;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((Runnable) obj).run();
            }
        }
        this.mFragmentStateManager.moveToExpectedState();
    }

    public final void mergeWith(int i, int i2) {
        int iOrdinal = PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility.ordinal(i2);
        Fragment fragment = this.mFragment;
        if (iOrdinal == 0) {
            if (this.mFinalState != 1) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Objects.toString(fragment);
                }
                this.mFinalState = i;
                return;
            }
            return;
        }
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                return;
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                Objects.toString(fragment);
            }
            this.mFinalState = 1;
            this.mLifecycleImpact = 3;
            return;
        }
        if (this.mFinalState == 1) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Objects.toString(fragment);
            }
            this.mFinalState = 2;
            this.mLifecycleImpact = 2;
        }
    }

    public final void onStart() {
        int i = this.mLifecycleImpact;
        FragmentStateManager fragmentStateManager = this.mFragmentStateManager;
        if (i != 2) {
            if (i == 3) {
                Fragment fragment = fragmentStateManager.mFragment;
                View viewRequireView = fragment.requireView();
                if (FragmentManager.isLoggingEnabled(2)) {
                    Objects.toString(viewRequireView.findFocus());
                    viewRequireView.toString();
                    fragment.toString();
                }
                viewRequireView.clearFocus();
                return;
            }
            return;
        }
        Fragment fragment2 = fragmentStateManager.mFragment;
        View viewFindFocus = fragment2.mView.findFocus();
        if (viewFindFocus != null) {
            fragment2.setFocusedView(viewFindFocus);
            if (FragmentManager.isLoggingEnabled(2)) {
                viewFindFocus.toString();
                fragment2.toString();
            }
        }
        View viewRequireView2 = this.mFragment.requireView();
        if (viewRequireView2.getParent() == null) {
            fragmentStateManager.addViewToContainer();
            viewRequireView2.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
        }
        if (viewRequireView2.getAlpha() == CropImageView.DEFAULT_ASPECT_RATIO && viewRequireView2.getVisibility() == 0) {
            viewRequireView2.setVisibility(4);
        }
        viewRequireView2.setAlpha(fragment2.getPostOnViewCreatedAlpha());
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Operation {");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} {mFinalState = ");
        int i = this.mFinalState;
        String str2 = "null";
        if (i == 1) {
            str = "REMOVED";
        } else if (i == 2) {
            str = "VISIBLE";
        } else if (i != 3) {
            str = i != 4 ? "null" : "INVISIBLE";
        } else {
            str = "GONE";
        }
        sb.append(str);
        sb.append("} {mLifecycleImpact = ");
        int i2 = this.mLifecycleImpact;
        if (i2 == 1) {
            str2 = "NONE";
        } else if (i2 == 2) {
            str2 = "ADDING";
        } else if (i2 == 3) {
            str2 = "REMOVING";
        }
        sb.append(str2);
        sb.append("} {mFragment = ");
        sb.append(this.mFragment);
        sb.append("}");
        return sb.toString();
    }
}
