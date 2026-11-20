package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.view.animation.Animation;
import androidx.core.os.CancellationSignal;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentAnim$AnimationOrAnimator implements CancellationSignal.OnCancelListener {
    public final Object animation;
    public final Object animator;

    public FragmentAnim$AnimationOrAnimator(FragmentManager fragmentManager) {
        this.animation = new CopyOnWriteArrayList();
        this.animator = fragmentManager;
    }

    public void dispatchOnFragmentActivityCreated(boolean z) {
        Fragment fragment = ((FragmentManager) this.animator).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentActivityCreated(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animation).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                PathKt$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentAttached(boolean z) {
        FragmentManager fragmentManager = (FragmentManager) this.animator;
        Context context = fragmentManager.mHost.mContext;
        Fragment fragment = fragmentManager.mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentAttached(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animation).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                PathKt$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentCreated(boolean z) {
        Fragment fragment = ((FragmentManager) this.animator).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentCreated(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animation).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                PathKt$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentDestroyed(boolean z) {
        Fragment fragment = ((FragmentManager) this.animator).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentDestroyed(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animation).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                PathKt$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentDetached(boolean z) {
        Fragment fragment = ((FragmentManager) this.animator).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentDetached(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animation).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                PathKt$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentPaused(boolean z) {
        Fragment fragment = ((FragmentManager) this.animator).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentPaused(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animation).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                PathKt$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentPreAttached(boolean z) {
        FragmentManager fragmentManager = (FragmentManager) this.animator;
        Context context = fragmentManager.mHost.mContext;
        Fragment fragment = fragmentManager.mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentPreAttached(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animation).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                PathKt$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentPreCreated(boolean z) {
        Fragment fragment = ((FragmentManager) this.animator).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentPreCreated(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animation).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                PathKt$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentResumed(boolean z) {
        Fragment fragment = ((FragmentManager) this.animator).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentResumed(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animation).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                PathKt$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentSaveInstanceState(boolean z) {
        Fragment fragment = ((FragmentManager) this.animator).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentSaveInstanceState(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animation).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                PathKt$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentStarted(boolean z) {
        Fragment fragment = ((FragmentManager) this.animator).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentStarted(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animation).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                PathKt$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentStopped(boolean z) {
        Fragment fragment = ((FragmentManager) this.animator).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentStopped(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animation).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                PathKt$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentViewCreated(boolean z) {
        Fragment fragment = ((FragmentManager) this.animator).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentViewCreated(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animation).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                PathKt$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    public void dispatchOnFragmentViewDestroyed(boolean z) {
        Fragment fragment = ((FragmentManager) this.animator).mParent;
        if (fragment != null) {
            fragment.getParentFragmentManager().mLifecycleCallbacksDispatcher.dispatchOnFragmentViewDestroyed(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.animation).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                PathKt$$ExternalSyntheticBUOutline0.m();
            } else {
                if (!z) {
                    throw null;
                }
                throw null;
            }
        }
    }

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        ((Animator) this.animator).end();
        if (FragmentManager.isLoggingEnabled(2)) {
            Objects.toString((SpecialEffectsController$FragmentStateManagerOperation) this.animation);
        }
    }

    public FragmentAnim$AnimationOrAnimator(Animation animation) {
        this.animation = animation;
        this.animator = null;
    }

    public FragmentAnim$AnimationOrAnimator(Animator animator) {
        this.animation = null;
        this.animator = animator;
    }

    public FragmentAnim$AnimationOrAnimator(Animator animator, SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation) {
        this.animator = animator;
        this.animation = specialEffectsController$FragmentStateManagerOperation;
    }
}
