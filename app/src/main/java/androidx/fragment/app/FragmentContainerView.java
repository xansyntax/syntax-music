package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.R$styleable;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import com.yalantis.ucrop.R;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.WeakHashMap;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {
    public View.OnApplyWindowInsetsListener applyWindowInsetsListener;
    public final ArrayList disappearingFragmentChildren;
    public boolean drawDisappearingViewsFirst;
    public final ArrayList transitioningFragmentViews;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, FragmentManager fragmentManager) {
        View view;
        super(context, attributeSet);
        context.getClass();
        attributeSet.getClass();
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
        String classAttribute = attributeSet.getClassAttribute();
        int i = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FragmentContainerView, 0, 0);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(0) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(1);
        typedArrayObtainStyledAttributes.recycle();
        int id = getId();
        Fragment fragmentFindFragmentById = fragmentManager.findFragmentById(id);
        if (classAttribute != null && fragmentFindFragmentById == null) {
            if (id == -1) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2(IntIntPair$$ExternalSyntheticOutline0.m("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : ""));
                throw null;
            }
            FragmentManager.AnonymousClass3 fragmentFactory = fragmentManager.getFragmentFactory();
            context.getClassLoader();
            Fragment fragmentInstantiate = Fragment.instantiate(FragmentManager.this.mHost.mContext, classAttribute, null);
            fragmentInstantiate.getClass();
            fragmentInstantiate.onInflate(context, attributeSet, (Bundle) null);
            BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
            backStackRecord.mReorderingAllowed = true;
            fragmentInstantiate.mContainer = this;
            int id2 = getId();
            String str = fragmentInstantiate.mPreviousWho;
            if (str != null) {
                FragmentStrictMode.onFragmentReuse(fragmentInstantiate, str);
            }
            Class<?> cls = fragmentInstantiate.getClass();
            int modifiers = cls.getModifiers();
            if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
                DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Fragment ", cls.getCanonicalName(), " must be a public static class to be  properly recreated from instance state.");
                throw null;
            }
            if (string != null) {
                String str2 = fragmentInstantiate.mTag;
                if (str2 != null && !string.equals(str2)) {
                    StringBuilder sb = new StringBuilder("Can't change tag of fragment ");
                    sb.append(fragmentInstantiate);
                    String str3 = fragmentInstantiate.mTag;
                    sb.append(": was ");
                    sb.append(str3);
                    sb.append(" now ");
                    sb.append(string);
                    throw new IllegalStateException(sb.toString());
                }
                fragmentInstantiate.mTag = string;
            }
            if (id2 != 0) {
                if (id2 == -1) {
                    DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Can't add fragment ", fragmentInstantiate, " with tag ", string, " to container view with no id");
                    throw null;
                }
                int i2 = fragmentInstantiate.mFragmentId;
                if (i2 != 0 && i2 != id2) {
                    StringBuilder sb2 = new StringBuilder("Can't change container ID of fragment ");
                    sb2.append(fragmentInstantiate);
                    int i3 = fragmentInstantiate.mFragmentId;
                    sb2.append(": was ");
                    sb2.append(i3);
                    sb2.append(" now ");
                    sb2.append(id2);
                    throw new IllegalStateException(sb2.toString());
                }
                fragmentInstantiate.mFragmentId = id2;
                fragmentInstantiate.mContainerId = id2;
            }
            FragmentTransaction$Op fragmentTransaction$Op = new FragmentTransaction$Op(fragmentInstantiate, 1);
            backStackRecord.mOps.add(fragmentTransaction$Op);
            fragmentTransaction$Op.mEnterAnim = backStackRecord.mEnterAnim;
            fragmentTransaction$Op.mExitAnim = backStackRecord.mExitAnim;
            fragmentTransaction$Op.mPopEnterAnim = backStackRecord.mPopEnterAnim;
            fragmentTransaction$Op.mPopExitAnim = backStackRecord.mPopExitAnim;
            FragmentManager fragmentManager2 = backStackRecord.mManager;
            FragmentStore fragmentStore = fragmentManager2.mFragmentStore;
            fragmentInstantiate.mFragmentManager = fragmentManager2;
            if (backStackRecord.mAddToBackStack) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("This transaction is already being added to the back stack");
                throw null;
            }
            if (fragmentManager2.mHost != null && !fragmentManager2.mDestroyed) {
                fragmentManager2.ensureExecReady(true);
                backStackRecord.generateOps(fragmentManager2.mTmpRecords, fragmentManager2.mTmpIsPop);
                fragmentManager2.mExecutingActions = true;
                try {
                    fragmentManager2.removeRedundantOperationsAndExecute(fragmentManager2.mTmpRecords, fragmentManager2.mTmpIsPop);
                    fragmentManager2.cleanupExec();
                    fragmentManager2.updateOnBackPressedCallbackEnabled();
                    if (fragmentManager2.mHavePendingDeferredStart) {
                        fragmentManager2.mHavePendingDeferredStart = false;
                        ArrayList activeFragmentStateManagers = fragmentStore.getActiveFragmentStateManagers();
                        int size = activeFragmentStateManagers.size();
                        int i4 = 0;
                        while (i4 < size) {
                            Object obj = activeFragmentStateManagers.get(i4);
                            i4++;
                            FragmentStateManager fragmentStateManager = (FragmentStateManager) obj;
                            Fragment fragment = fragmentStateManager.mFragment;
                            if (fragment.mDeferStart) {
                                if (fragmentManager2.mExecutingActions) {
                                    fragmentManager2.mHavePendingDeferredStart = true;
                                } else {
                                    fragment.mDeferStart = false;
                                    fragmentStateManager.moveToExpectedState();
                                }
                            }
                        }
                    }
                    ((HashMap) fragmentStore.mActive).values().removeAll(Collections.singleton(null));
                } catch (Throwable th) {
                    fragmentManager2.cleanupExec();
                    throw th;
                }
            }
        }
        ArrayList activeFragmentStateManagers2 = fragmentManager.mFragmentStore.getActiveFragmentStateManagers();
        int size2 = activeFragmentStateManagers2.size();
        while (i < size2) {
            Object obj2 = activeFragmentStateManagers2.get(i);
            i++;
            FragmentStateManager fragmentStateManager2 = (FragmentStateManager) obj2;
            Fragment fragment2 = fragmentStateManager2.mFragment;
            if (fragment2.mContainerId == getId() && (view = fragment2.mView) != null && view.getParent() == null) {
                fragment2.mContainer = this;
                fragmentStateManager2.addViewToContainer();
            }
        }
    }

    public final void addDisappearingFragmentView(View view) {
        if (this.transitioningFragmentViews.contains(view)) {
            this.disappearingFragmentChildren.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        view.getClass();
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if ((tag instanceof Fragment ? (Fragment) tag : null) != null) {
            super.addView(view, i, layoutParams);
        } else {
            PathKt$$ExternalSyntheticBUOutline0.m("Views added to a FragmentContainerView must be associated with a Fragment. View ", view, " is not associated with a Fragment.");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsetsCompat windowInsetsCompat;
        windowInsets.getClass();
        WindowInsetsCompat windowInsetsCompat2 = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, null);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.applyWindowInsetsListener;
        if (onApplyWindowInsetsListener != null) {
            WindowInsets windowInsetsOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets);
            windowInsetsOnApplyWindowInsets.getClass();
            windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsetsOnApplyWindowInsets, null);
        } else {
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            WindowInsets windowInsets2 = windowInsetsCompat2.toWindowInsets();
            if (windowInsets2 != null && !windowInsets2.equals(windowInsets2)) {
                windowInsetsCompat2 = WindowInsetsCompat.toWindowInsetsCompat(windowInsets2, this);
            }
            windowInsetsCompat = windowInsetsCompat2;
        }
        if (!windowInsetsCompat.mImpl.isConsumed()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewCompat.dispatchApplyWindowInsets(getChildAt(i), windowInsetsCompat);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        canvas.getClass();
        if (this.drawDisappearingViewsFirst) {
            ArrayList arrayList = this.disappearingFragmentChildren;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                super.drawChild(canvas, (View) obj, getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        canvas.getClass();
        view.getClass();
        if (this.drawDisappearingViewsFirst) {
            ArrayList arrayList = this.disappearingFragmentChildren;
            if (!arrayList.isEmpty() && arrayList.contains(view)) {
                return false;
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        view.getClass();
        this.transitioningFragmentViews.remove(view);
        if (this.disappearingFragmentChildren.remove(view)) {
            this.drawDisappearingViewsFirst = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends Fragment> F getFragment() {
        FragmentActivity fragmentActivity;
        Fragment fragment;
        FragmentManager supportFragmentManager;
        View view = this;
        while (true) {
            fragmentActivity = null;
            if (view == null) {
                fragment = null;
                break;
            }
            Object tag = view.getTag(R.id.fragment_container_view_tag);
            fragment = tag instanceof Fragment ? (Fragment) tag : null;
            if (fragment != null) {
                break;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        if (fragment == null) {
            for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
                if (context instanceof FragmentActivity) {
                    fragmentActivity = (FragmentActivity) context;
                    break;
                }
            }
            if (fragmentActivity == null) {
                throw new IllegalStateException("View " + this + " is not within a subclass of FragmentActivity.");
            }
            supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        } else {
            if (!fragment.isAdded()) {
                throw new IllegalStateException("The Fragment " + fragment + " that owns View " + this + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
            }
            supportFragmentManager = fragment.getChildFragmentManager();
        }
        return (F) supportFragmentManager.findFragmentById(getId());
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        windowInsets.getClass();
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            } else {
                View childAt = getChildAt(childCount);
                childAt.getClass();
                addDisappearingFragmentView(childAt);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        view.getClass();
        addDisappearingFragmentView(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i) {
        View childAt = getChildAt(i);
        childAt.getClass();
        addDisappearingFragmentView(childAt);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        view.getClass();
        addDisappearingFragmentView(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            View childAt = getChildAt(i4);
            childAt.getClass();
            addDisappearingFragmentView(childAt);
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            View childAt = getChildAt(i4);
            childAt.getClass();
            addDisappearingFragmentView(childAt);
        }
        super.removeViewsInLayout(i, i2);
    }

    public final void setDrawDisappearingViewsLast(boolean z) {
        this.drawDisappearingViewsFirst = z;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        onApplyWindowInsetsListener.getClass();
        this.applyWindowInsetsListener = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        view.getClass();
        if (view.getParent() == this) {
            this.transitioningFragmentViews.add(view);
        }
        super.startViewTransition(view);
    }
}
