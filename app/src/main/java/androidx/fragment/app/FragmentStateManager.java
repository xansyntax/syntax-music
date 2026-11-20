package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.strictmode.FragmentReuseViolation;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStoreOwner;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.util.ImageHeaderParser;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.WeakHashMap;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentStateManager {
    public final FragmentAnim$AnimationOrAnimator mDispatcher;
    public final Fragment mFragment;
    public final FragmentStore mFragmentStore;
    public boolean mMovingToState = false;
    public int mFragmentManagerState = -1;

    public FragmentStateManager(FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator, FragmentStore fragmentStore, ClassLoader classLoader, FragmentManager.AnonymousClass3 anonymousClass3, FragmentState fragmentState) {
        this.mDispatcher = fragmentAnim$AnimationOrAnimator;
        this.mFragmentStore = fragmentStore;
        Fragment fragmentInstantiate = Fragment.instantiate(FragmentManager.this.mHost.mContext, fragmentState.mClassName, null);
        Bundle bundle = fragmentState.mArguments;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        fragmentInstantiate.setArguments(bundle);
        fragmentInstantiate.mWho = fragmentState.mWho;
        fragmentInstantiate.mFromLayout = fragmentState.mFromLayout;
        fragmentInstantiate.mRestored = true;
        fragmentInstantiate.mFragmentId = fragmentState.mFragmentId;
        fragmentInstantiate.mContainerId = fragmentState.mContainerId;
        fragmentInstantiate.mTag = fragmentState.mTag;
        fragmentInstantiate.mRetainInstance = fragmentState.mRetainInstance;
        fragmentInstantiate.mRemoving = fragmentState.mRemoving;
        fragmentInstantiate.mDetached = fragmentState.mDetached;
        fragmentInstantiate.mHidden = fragmentState.mHidden;
        fragmentInstantiate.mMaxState = Lifecycle.State.values()[fragmentState.mMaxLifecycleState];
        Bundle bundle2 = fragmentState.mSavedFragmentState;
        if (bundle2 != null) {
            fragmentInstantiate.mSavedFragmentState = bundle2;
        } else {
            fragmentInstantiate.mSavedFragmentState = new Bundle();
        }
        this.mFragment = fragmentInstantiate;
        if (FragmentManager.isLoggingEnabled(2)) {
            Objects.toString(fragmentInstantiate);
        }
    }

    public final void addViewToContainer() {
        View view;
        View view2;
        ArrayList arrayList = (ArrayList) this.mFragmentStore.mAdded;
        Fragment fragment = this.mFragment;
        ViewGroup viewGroup = fragment.mContainer;
        int iIndexOfChild = -1;
        if (viewGroup != null) {
            int iIndexOf = arrayList.indexOf(fragment);
            for (int i = iIndexOf - 1; i >= 0; i--) {
                Fragment fragment2 = (Fragment) arrayList.get(i);
                if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                    iIndexOfChild = viewGroup.indexOfChild(view2) + 1;
                }
            }
            while (true) {
                iIndexOf++;
                if (iIndexOf >= arrayList.size()) {
                    break;
                }
                Fragment fragment3 = (Fragment) arrayList.get(iIndexOf);
                if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                    iIndexOfChild = viewGroup.indexOfChild(view);
                    break;
                }
            }
        }
        fragment.mContainer.addView(fragment.mView, iIndexOfChild);
    }

    public final void attach() {
        boolean zIsLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (zIsLoggingEnabled) {
            Objects.toString(fragment);
        }
        Fragment fragment2 = fragment.mTarget;
        FragmentStateManager fragmentStateManager = null;
        FragmentStore fragmentStore = this.mFragmentStore;
        if (fragment2 != null) {
            FragmentStateManager fragmentStateManager2 = (FragmentStateManager) ((HashMap) fragmentStore.mActive).get(fragment2.mWho);
            if (fragmentStateManager2 == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(fragment);
                Fragment fragment3 = fragment.mTarget;
                sb.append(" declared target fragment ");
                sb.append(fragment3);
                sb.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(sb.toString());
            }
            fragment.mTargetWho = fragment.mTarget.mWho;
            fragment.mTarget = null;
            fragmentStateManager = fragmentStateManager2;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (fragmentStateManager = (FragmentStateManager) ((HashMap) fragmentStore.mActive).get(str)) == null) {
                StringBuilder sb2 = new StringBuilder("Fragment ");
                sb2.append(fragment);
                sb2.append(" declared target fragment ");
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2(IntIntPair$$ExternalSyntheticOutline0.m(sb2, fragment.mTargetWho, " that does not belong to this FragmentManager!"));
                return;
            }
        }
        if (fragmentStateManager != null) {
            fragmentStateManager.moveToExpectedState();
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        fragment.mHost = fragmentManager.mHost;
        fragment.mParentFragment = fragmentManager.mParent;
        FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator = this.mDispatcher;
        fragmentAnim$AnimationOrAnimator.dispatchOnFragmentPreAttached(false);
        fragment.performAttach();
        fragmentAnim$AnimationOrAnimator.dispatchOnFragmentAttached(false);
    }

    public final int computeExpectedState() {
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation;
        Fragment fragment = this.mFragment;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int iMin = this.mFragmentManagerState;
        int iOrdinal = fragment.mMaxState.ordinal();
        int i = 0;
        if (iOrdinal == 1) {
            iMin = Math.min(iMin, 0);
        } else if (iOrdinal == 2) {
            iMin = Math.min(iMin, 1);
        } else if (iOrdinal == 3) {
            iMin = Math.min(iMin, 5);
        } else if (iOrdinal != 4) {
            iMin = Math.min(iMin, -1);
        }
        if (fragment.mFromLayout) {
            boolean z = fragment.mInLayout;
            int i2 = this.mFragmentManagerState;
            if (z) {
                iMin = Math.max(i2, 2);
                View view = fragment.mView;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = i2 < 4 ? Math.min(iMin, fragment.mState) : Math.min(iMin, 1);
            }
        }
        if (!fragment.mAdded) {
            iMin = Math.min(iMin, 1);
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            DefaultSpecialEffectsController orCreateController = DefaultSpecialEffectsController.getOrCreateController(viewGroup, fragment.getParentFragmentManager());
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperationFindPendingOperation = orCreateController.findPendingOperation(fragment);
            int i3 = specialEffectsController$FragmentStateManagerOperationFindPendingOperation != null ? specialEffectsController$FragmentStateManagerOperationFindPendingOperation.mLifecycleImpact : 0;
            ArrayList arrayList = orCreateController.mRunningOperations;
            int size = arrayList.size();
            while (true) {
                if (i >= size) {
                    specialEffectsController$FragmentStateManagerOperation = null;
                    break;
                }
                Object obj = arrayList.get(i);
                i++;
                specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) obj;
                if (specialEffectsController$FragmentStateManagerOperation.mFragment.equals(fragment) && !specialEffectsController$FragmentStateManagerOperation.mIsCanceled) {
                    break;
                }
            }
            i = (specialEffectsController$FragmentStateManagerOperation == null || !(i3 == 0 || i3 == 1)) ? i3 : specialEffectsController$FragmentStateManagerOperation.mLifecycleImpact;
        }
        if (i == 2) {
            iMin = Math.min(iMin, 6);
        } else if (i == 3) {
            iMin = Math.max(iMin, 3);
        } else if (fragment.mRemoving) {
            iMin = fragment.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        if (fragment.mDeferStart && fragment.mState < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Objects.toString(fragment);
        }
        return iMin;
    }

    public final void createView() {
        String resourceName;
        Fragment fragment = this.mFragment;
        if (fragment.mFromLayout) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(3)) {
            Objects.toString(fragment);
        }
        LayoutInflater layoutInflaterPerformGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            int i = fragment.mContainerId;
            if (i == 0) {
                viewGroup = null;
            } else {
                if (i == -1) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m("Cannot create fragment ", fragment, " for a container view with no id"));
                    return;
                }
                viewGroup = (ViewGroup) fragment.mFragmentManager.mContainer.onFindViewById(i);
                if (viewGroup == null) {
                    if (!fragment.mRestored) {
                        try {
                            resourceName = fragment.getResources().getResourceName(fragment.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.mContainerId) + " (" + resourceName + ") for fragment " + fragment);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    FragmentStrictMode.Policy policy = FragmentStrictMode.defaultPolicy;
                    FragmentStrictMode.logIfDebuggingEnabled(new FragmentReuseViolation(fragment, "Attempting to add fragment " + fragment + " to container " + viewGroup + " which is not a FragmentContainerView"));
                    FragmentStrictMode.getNearestPolicy(fragment).getClass();
                }
            }
        }
        fragment.mContainer = viewGroup;
        fragment.performCreateView(layoutInflaterPerformGetLayoutInflater, viewGroup, fragment.mSavedFragmentState);
        View view = fragment.mView;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            fragment.mView.setTag(R.id.fragment_container_view_tag, fragment);
            if (viewGroup != null) {
                addViewToContainer();
            }
            if (fragment.mHidden) {
                fragment.mView.setVisibility(8);
            }
            View view2 = fragment.mView;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            boolean zIsAttachedToWindow = view2.isAttachedToWindow();
            final View view3 = fragment.mView;
            if (zIsAttachedToWindow) {
                view3.requestApplyInsets();
            } else {
                view3.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.FragmentStateManager.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public final void onViewAttachedToWindow(View view4) {
                        View view5 = view3;
                        view5.removeOnAttachStateChangeListener(this);
                        WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                        view5.requestApplyInsets();
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public final void onViewDetachedFromWindow(View view4) {
                    }
                });
            }
            fragment.performViewCreated();
            this.mDispatcher.dispatchOnFragmentViewCreated(false);
            int visibility = fragment.mView.getVisibility();
            fragment.setPostOnViewCreatedAlpha(fragment.mView.getAlpha());
            if (fragment.mContainer != null && visibility == 0) {
                View viewFindFocus = fragment.mView.findFocus();
                if (viewFindFocus != null) {
                    fragment.setFocusedView(viewFindFocus);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        viewFindFocus.toString();
                        Objects.toString(fragment);
                    }
                }
                fragment.mView.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
            }
        }
        fragment.mState = 2;
    }

    public final void destroy() {
        Fragment fragmentFindActiveFragment;
        boolean zIsLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (zIsLoggingEnabled) {
            Objects.toString(fragment);
        }
        int i = 0;
        boolean zIsChangingConfigurations = true;
        boolean z = fragment.mRemoving && !fragment.isInBackStack();
        FragmentStore fragmentStore = this.mFragmentStore;
        if (z && !fragment.mBeingSaved) {
        }
        if (!z) {
            FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) fragmentStore.mNonConfig;
            if (!((fragmentManagerViewModel.mRetainedFragments.containsKey(fragment.mWho) && fragmentManagerViewModel.mStateAutomaticallySaved) ? fragmentManagerViewModel.mHasBeenCleared : true)) {
                String str = fragment.mTargetWho;
                if (str != null && (fragmentFindActiveFragment = fragmentStore.findActiveFragment(str)) != null && fragmentFindActiveFragment.mRetainInstance) {
                    fragment.mTarget = fragmentFindActiveFragment;
                }
                fragment.mState = 0;
                return;
            }
        }
        FragmentHostCallback fragmentHostCallback = fragment.mHost;
        if (fragmentHostCallback instanceof ViewModelStoreOwner) {
            zIsChangingConfigurations = ((FragmentManagerViewModel) fragmentStore.mNonConfig).mHasBeenCleared;
        } else {
            Context context = fragmentHostCallback.mContext;
            if (context instanceof Activity) {
                zIsChangingConfigurations = true ^ ((Activity) context).isChangingConfigurations();
            }
        }
        if ((z && !fragment.mBeingSaved) || zIsChangingConfigurations) {
            FragmentManagerViewModel fragmentManagerViewModel2 = (FragmentManagerViewModel) fragmentStore.mNonConfig;
            if (FragmentManager.isLoggingEnabled(3)) {
                fragmentManagerViewModel2.getClass();
                Objects.toString(fragment);
            }
            fragmentManagerViewModel2.clearNonConfigStateInternal(fragment.mWho);
        }
        fragment.performDestroy();
        this.mDispatcher.dispatchOnFragmentDestroyed(false);
        ArrayList activeFragmentStateManagers = fragmentStore.getActiveFragmentStateManagers();
        int size = activeFragmentStateManagers.size();
        while (i < size) {
            Object obj = activeFragmentStateManagers.get(i);
            i++;
            FragmentStateManager fragmentStateManager = (FragmentStateManager) obj;
            if (fragmentStateManager != null) {
                Fragment fragment2 = fragmentStateManager.mFragment;
                if (fragment.mWho.equals(fragment2.mTargetWho)) {
                    fragment2.mTarget = fragment;
                    fragment2.mTargetWho = null;
                }
            }
        }
        String str2 = fragment.mTargetWho;
        if (str2 != null) {
            fragment.mTarget = fragmentStore.findActiveFragment(str2);
        }
        fragmentStore.makeInactive(this);
    }

    public final void destroyFragmentView() {
        View view;
        boolean zIsLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (zIsLoggingEnabled) {
            Objects.toString(fragment);
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        fragment.performDestroyView();
        this.mDispatcher.dispatchOnFragmentViewDestroyed(false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.setValue(null);
        fragment.mInLayout = false;
    }

    public final void detach() {
        boolean zIsLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (zIsLoggingEnabled) {
            Objects.toString(fragment);
        }
        fragment.performDetach();
        this.mDispatcher.dispatchOnFragmentDetached(false);
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (!fragment.mRemoving || fragment.isInBackStack()) {
            FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) this.mFragmentStore.mNonConfig;
            if (!((fragmentManagerViewModel.mRetainedFragments.containsKey(fragment.mWho) && fragmentManagerViewModel.mStateAutomaticallySaved) ? fragmentManagerViewModel.mHasBeenCleared : true)) {
                return;
            }
        }
        if (FragmentManager.isLoggingEnabled(3)) {
            Objects.toString(fragment);
        }
        fragment.initState();
    }

    public final void ensureInflatedView() {
        Fragment fragment = this.mFragment;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Objects.toString(fragment);
            }
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
            View view = fragment.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                fragment.mView.setTag(R.id.fragment_container_view_tag, fragment);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.performViewCreated();
                this.mDispatcher.dispatchOnFragmentViewCreated(false);
                fragment.mState = 2;
            }
        }
    }

    public final void moveToExpectedState() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        boolean z = this.mMovingToState;
        Fragment fragment = this.mFragment;
        if (z) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Objects.toString(fragment);
                return;
            }
            return;
        }
        try {
            this.mMovingToState = true;
            boolean z2 = false;
            while (true) {
                int iComputeExpectedState = computeExpectedState();
                int i = fragment.mState;
                FragmentStore fragmentStore = this.mFragmentStore;
                if (iComputeExpectedState == i) {
                    if (!z2 && i == -1 && fragment.mRemoving && !fragment.isInBackStack() && !fragment.mBeingSaved) {
                        if (FragmentManager.isLoggingEnabled(3)) {
                            Objects.toString(fragment);
                        }
                        FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) fragmentStore.mNonConfig;
                        if (FragmentManager.isLoggingEnabled(3)) {
                            fragmentManagerViewModel.getClass();
                            Objects.toString(fragment);
                        }
                        fragmentManagerViewModel.clearNonConfigStateInternal(fragment.mWho);
                        fragmentStore.makeInactive(this);
                        if (FragmentManager.isLoggingEnabled(3)) {
                            Objects.toString(fragment);
                        }
                        fragment.initState();
                    }
                    if (fragment.mHiddenChanged) {
                        if (fragment.mView != null && (viewGroup = fragment.mContainer) != null) {
                            DefaultSpecialEffectsController orCreateController = DefaultSpecialEffectsController.getOrCreateController(viewGroup, fragment.getParentFragmentManager());
                            if (fragment.mHidden) {
                                if (FragmentManager.isLoggingEnabled(2)) {
                                    Objects.toString(fragment);
                                }
                                orCreateController.enqueue(3, 1, this);
                            } else {
                                if (FragmentManager.isLoggingEnabled(2)) {
                                    Objects.toString(fragment);
                                }
                                orCreateController.enqueue(2, 1, this);
                            }
                        }
                        FragmentManager fragmentManager = fragment.mFragmentManager;
                        if (fragmentManager != null && fragment.mAdded && FragmentManager.isMenuAvailable(fragment)) {
                            fragmentManager.mNeedMenuInvalidate = true;
                        }
                        fragment.mHiddenChanged = false;
                        fragment.onHiddenChanged(fragment.mHidden);
                        fragment.mChildFragmentManager.dispatchOnHiddenChanged();
                    }
                    return;
                }
                FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator = this.mDispatcher;
                if (iComputeExpectedState > i) {
                    switch (i + 1) {
                        case 0:
                            attach();
                            break;
                        case 1:
                            if (FragmentManager.isLoggingEnabled(3)) {
                                Objects.toString(fragment);
                            }
                            boolean z3 = fragment.mIsCreated;
                            Bundle bundle = fragment.mSavedFragmentState;
                            if (!z3) {
                                fragmentAnim$AnimationOrAnimator.dispatchOnFragmentPreCreated(false);
                                fragment.performCreate(fragment.mSavedFragmentState);
                                fragmentAnim$AnimationOrAnimator.dispatchOnFragmentCreated(false);
                            } else {
                                fragment.restoreChildFragmentState(bundle);
                                fragment.mState = 1;
                            }
                            break;
                        case 2:
                            ensureInflatedView();
                            createView();
                            break;
                        case 3:
                            if (FragmentManager.isLoggingEnabled(3)) {
                                Objects.toString(fragment);
                            }
                            fragment.performActivityCreated(fragment.mSavedFragmentState);
                            fragmentAnim$AnimationOrAnimator.dispatchOnFragmentActivityCreated(false);
                            break;
                        case 4:
                            if (fragment.mView != null && (viewGroup3 = fragment.mContainer) != null) {
                                DefaultSpecialEffectsController orCreateController2 = DefaultSpecialEffectsController.getOrCreateController(viewGroup3, fragment.getParentFragmentManager());
                                int i_from = Fragment$5$$ExternalSyntheticOutline0._from(fragment.mView.getVisibility());
                                if (FragmentManager.isLoggingEnabled(2)) {
                                    Objects.toString(fragment);
                                }
                                orCreateController2.enqueue(i_from, 2, this);
                            }
                            fragment.mState = 4;
                            break;
                        case 5:
                            if (FragmentManager.isLoggingEnabled(3)) {
                                Objects.toString(fragment);
                            }
                            fragment.performStart();
                            fragmentAnim$AnimationOrAnimator.dispatchOnFragmentStarted(false);
                            break;
                        case 6:
                            fragment.mState = 6;
                            break;
                        case 7:
                            resume();
                            break;
                    }
                } else {
                    switch (i - 1) {
                        case ImageHeaderParser.UNKNOWN_ORIENTATION /* -1 */:
                            detach();
                            break;
                        case 0:
                            if (fragment.mBeingSaved) {
                                if (((FragmentState) ((HashMap) fragmentStore.mSavedState).get(fragment.mWho)) == null) {
                                    saveState();
                                }
                            }
                            destroy();
                            break;
                        case 1:
                            destroyFragmentView();
                            fragment.mState = 1;
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            break;
                        case 3:
                            if (FragmentManager.isLoggingEnabled(3)) {
                                Objects.toString(fragment);
                            }
                            if (fragment.mBeingSaved) {
                                saveState();
                            } else if (fragment.mView != null && fragment.mSavedViewState == null) {
                                saveViewState();
                            }
                            if (fragment.mView != null && (viewGroup2 = fragment.mContainer) != null) {
                                DefaultSpecialEffectsController orCreateController3 = DefaultSpecialEffectsController.getOrCreateController(viewGroup2, fragment.getParentFragmentManager());
                                if (FragmentManager.isLoggingEnabled(2)) {
                                    Objects.toString(fragment);
                                }
                                orCreateController3.enqueue(1, 3, this);
                            }
                            fragment.mState = 3;
                            break;
                        case 4:
                            if (FragmentManager.isLoggingEnabled(3)) {
                                Objects.toString(fragment);
                            }
                            fragment.performStop();
                            fragmentAnim$AnimationOrAnimator.dispatchOnFragmentStopped(false);
                            break;
                        case 5:
                            fragment.mState = 5;
                            break;
                        case 6:
                            if (FragmentManager.isLoggingEnabled(3)) {
                                Objects.toString(fragment);
                            }
                            fragment.performPause();
                            fragmentAnim$AnimationOrAnimator.dispatchOnFragmentPaused(false);
                            break;
                    }
                }
                z2 = true;
            }
        } finally {
            this.mMovingToState = false;
        }
    }

    public final void restoreState(ClassLoader classLoader) {
        boolean zBooleanValue;
        Fragment fragment = this.mFragment;
        Bundle bundle = fragment.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        fragment.mSavedViewRegistryState = fragment.mSavedFragmentState.getBundle("android:view_registry_state");
        String string = fragment.mSavedFragmentState.getString("android:target_state");
        fragment.mTargetWho = string;
        if (string != null) {
            fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Boolean bool = fragment.mSavedUserVisibleHint;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
            fragment.mUserVisibleHint = zBooleanValue;
            fragment.mSavedUserVisibleHint = null;
        } else {
            zBooleanValue = fragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
            fragment.mUserVisibleHint = zBooleanValue;
        }
        if (zBooleanValue) {
            return;
        }
        fragment.mDeferStart = true;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002b  */
    public void resume() {
        boolean zIsLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (zIsLoggingEnabled) {
            Objects.toString(fragment);
        }
        View focusedView = fragment.getFocusedView();
        if (focusedView != null) {
            if (focusedView == fragment.mView) {
                focusedView.requestFocus();
                if (FragmentManager.isLoggingEnabled(2)) {
                    focusedView.toString();
                    Objects.toString(fragment);
                    Objects.toString(fragment.mView.findFocus());
                }
            } else {
                ViewParent parent = focusedView.getParent();
                while (true) {
                    if (parent != null) {
                        if (parent == fragment.mView) {
                            break;
                        } else {
                            parent = parent.getParent();
                        }
                    }
                }
                focusedView.requestFocus();
                if (FragmentManager.isLoggingEnabled(2)) {
                    focusedView.toString();
                    Objects.toString(fragment);
                    Objects.toString(fragment.mView.findFocus());
                }
            }
        }
        fragment.setFocusedView(null);
        fragment.performResume();
        this.mDispatcher.dispatchOnFragmentResumed(false);
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    public final void saveState() {
        Fragment fragment = this.mFragment;
        FragmentState fragmentState = new FragmentState(fragment);
        if (fragment.mState <= -1 || fragmentState.mSavedFragmentState != null) {
            fragmentState.mSavedFragmentState = fragment.mSavedFragmentState;
        } else {
            Bundle bundle = new Bundle();
            fragment.performSaveInstanceState(bundle);
            this.mDispatcher.dispatchOnFragmentSaveInstanceState(false);
            if (bundle.isEmpty()) {
                bundle = null;
            }
            if (fragment.mView != null) {
                saveViewState();
            }
            if (fragment.mSavedViewState != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
            }
            if (fragment.mSavedViewRegistryState != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBundle("android:view_registry_state", fragment.mSavedViewRegistryState);
            }
            if (!fragment.mUserVisibleHint) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
            }
            fragmentState.mSavedFragmentState = bundle;
            if (fragment.mTargetWho != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                    fragmentState.mSavedFragmentState = bundle;
                }
                bundle.putString("android:target_state", fragment.mTargetWho);
                int i = fragment.mTargetRequestCode;
                if (i != 0) {
                    fragmentState.mSavedFragmentState.putInt("android:target_req_state", i);
                }
            }
        }
    }

    public final void saveViewState() {
        Fragment fragment = this.mFragment;
        if (fragment.mView == null) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Objects.toString(fragment);
            Objects.toString(fragment.mView);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        fragment.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            fragment.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        fragment.mViewLifecycleOwner.mSavedStateRegistryController.performSave(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        fragment.mSavedViewRegistryState = bundle;
    }

    public FragmentStateManager(FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator, FragmentStore fragmentStore, Fragment fragment) {
        this.mDispatcher = fragmentAnim$AnimationOrAnimator;
        this.mFragmentStore = fragmentStore;
        this.mFragment = fragment;
    }

    public FragmentStateManager(FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator, FragmentStore fragmentStore, Fragment fragment, FragmentState fragmentState) {
        this.mDispatcher = fragmentAnim$AnimationOrAnimator;
        this.mFragmentStore = fragmentStore;
        this.mFragment = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.mSavedFragmentState;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
