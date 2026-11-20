package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.SparseArrayCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.customview.view.AbsSavedState;
import androidx.fragment.app.strictmode.FragmentReuseViolation;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.GetRetainInstanceUsageViolation;
import androidx.fragment.app.strictmode.GetTargetFragmentUsageViolation;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider$AndroidViewModelFactory;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.loader.app.LoaderManager;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import coil3.network.HttpException;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.UCropFragment;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    AnimationInfo mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mBeingSaved;
    private boolean mCalled;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    ViewModelProvider$Factory mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManager mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    FragmentHostCallback mHost;
    boolean mInLayout;
    boolean mIsCreated;
    LayoutInflater mLayoutInflater;
    LifecycleRegistry mLifecycleRegistry;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    Runnable mPostponedDurationRunnable;
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    private final OnPreAttachedListener mSavedStateAttachListener;
    SavedStateRegistryController mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    View mView;
    FragmentViewLifecycleOwner mViewLifecycleOwner;
    int mState = -1;
    String mWho = UUID.randomUUID().toString();
    String mTargetWho = null;
    private Boolean mIsPrimaryNavigationFragment = null;
    FragmentManager mChildFragmentManager = new FragmentManagerImpl();
    boolean mMenuVisible = true;
    boolean mUserVisibleHint = true;
    Lifecycle.State mMaxState = Lifecycle.State.RESUMED;
    MutableLiveData mViewLifecycleOwnerLiveData = new MutableLiveData();
    private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
    private final ArrayList<OnPreAttachedListener> mOnPreAttachedListeners = new ArrayList<>();

    /* JADX INFO: renamed from: androidx.fragment.app.Fragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ AnonymousClass1(byte b, Object obj) {
            this.$r8$classId = b;
            this.this$0 = obj;
        }

        @Override // java.lang.Runnable
        public final void run() {
            byte b = this.$r8$classId;
            Object obj = this.this$0;
            switch (b) {
                case 0:
                    ((UCropFragment) obj).startPostponedEnterTransition();
                    break;
                case 1:
                    DefaultSpecialEffectsController.AnonymousClass4 anonymousClass4 = (DefaultSpecialEffectsController.AnonymousClass4) obj;
                    anonymousClass4.val$container.endViewTransition(anonymousClass4.val$viewToAnimate);
                    anonymousClass4.val$animationInfo.completeSpecialEffect();
                    break;
                case 2:
                    FragmentTransition.setViewVisibility(4, (ArrayList) obj);
                    break;
                case 3:
                    ((Fragment) obj).callStartTransitionListener(false);
                    break;
                case 4:
                    ((DefaultSpecialEffectsController) obj).executePendingOperations();
                    break;
                default:
                    ((FragmentManager) obj).execPendingActions(true);
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.Fragment$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass7 implements CancellationSignal.OnCancelListener {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ AnonymousClass7(byte b, Object obj) {
            this.$r8$classId = b;
            this.this$0 = obj;
        }

        @Override // androidx.core.os.CancellationSignal.OnCancelListener
        public void onCancel() {
            ((SpecialEffectsController$FragmentStateManagerOperation) this.this$0).cancel();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnimationInfo {
        public Boolean mAllowEnterTransitionOverlap;
        public Boolean mAllowReturnTransitionOverlap;
        public int mEnterAnim;
        public Object mEnterTransition;
        public boolean mEnterTransitionPostponed;
        public int mExitAnim;
        public Object mExitTransition;
        public View mFocusedView;
        public boolean mIsPop;
        public int mNextTransition;
        public int mPopEnterAnim;
        public int mPopExitAnim;
        public float mPostOnViewCreatedAlpha;
        public Object mReenterTransition;
        public Object mReturnTransition;
        public Object mSharedElementEnterTransition;
        public Object mSharedElementReturnTransition;
        public ArrayList mSharedElementSourceNames;
        public ArrayList mSharedElementTargetNames;
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class OnPreAttachedListener {
        public abstract void onPreAttached();
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new AbsSavedState.AnonymousClass2(4);
        public final Bundle mState;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle = parcel.readBundle();
            this.mState = bundle;
            if (classLoader == null || bundle == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.mState);
        }
    }

    public Fragment() {
        final UCropFragment uCropFragment = (UCropFragment) this;
        this.mPostponedDurationRunnable = new AnonymousClass1((byte) 0, uCropFragment);
        this.mSavedStateAttachListener = new OnPreAttachedListener() { // from class: androidx.fragment.app.Fragment.2
            @Override // androidx.fragment.app.Fragment.OnPreAttachedListener
            public final void onPreAttached() {
                UCropFragment uCropFragment2 = uCropFragment;
                uCropFragment2.mSavedStateRegistryController.impl.performAttach();
                ViewModelKt.enableSavedStateHandles(uCropFragment2);
            }
        };
        initLifecycle();
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) FragmentManager.AnonymousClass3.loadFragmentClass(context.getClassLoader(), str).getConstructor(null).newInstance(null);
            if (bundle == null) {
                return fragment;
            }
            bundle.setClassLoader(fragment.getClass().getClassLoader());
            fragment.setArguments(bundle);
            return fragment;
        } catch (IllegalAccessException e) {
            throw new HttpException(IntIntPair$$ExternalSyntheticOutline0.m("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
        } catch (InstantiationException e2) {
            throw new HttpException(IntIntPair$$ExternalSyntheticOutline0.m("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (NoSuchMethodException e3) {
            throw new HttpException(IntIntPair$$ExternalSyntheticOutline0.m("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e3);
        } catch (InvocationTargetException e4) {
            throw new HttpException(IntIntPair$$ExternalSyntheticOutline0.m("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e4);
        }
    }

    public void callStartTransitionListener(boolean z) {
        ViewGroup viewGroup;
        FragmentManager fragmentManager;
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo != null) {
            animationInfo.mEnterTransitionPostponed = false;
        }
        if (this.mView == null || (viewGroup = this.mContainer) == null || (fragmentManager = this.mFragmentManager) == null) {
            return;
        }
        DefaultSpecialEffectsController orCreateController = DefaultSpecialEffectsController.getOrCreateController(viewGroup, fragmentManager.getSpecialEffectsControllerFactory());
        orCreateController.markPostponedState();
        if (z) {
            this.mHost.mHandler.post(new AnonymousClass1((byte) 4, orCreateController));
        } else {
            orCreateController.executePendingOperations();
        }
    }

    public FragmentContainer createFragmentContainer() {
        return new FragmentContainer() { // from class: androidx.fragment.app.Fragment.5
            @Override // androidx.fragment.app.FragmentContainer
            public final View onFindViewById(int i) {
                Fragment fragment = Fragment.this;
                View view = fragment.mView;
                if (view != null) {
                    return view.findViewById(i);
                }
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", fragment, " does not have a view"));
                return null;
            }

            @Override // androidx.fragment.app.FragmentContainer
            public final boolean onHasView() {
                return Fragment.this.mView != null;
            }
        };
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        Fragment targetFragment = getTargetFragment(false);
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            LoaderManager.getInstance(this).dump(str, printWriter);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ServerSentEventKt.COLON);
        this.mChildFragmentManager.dump(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final AnimationInfo ensureAnimationInfo() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo != null) {
            return animationInfo;
        }
        AnimationInfo animationInfo2 = new AnimationInfo();
        animationInfo2.mEnterTransition = null;
        Object obj = USE_DEFAULT_TRANSITION;
        animationInfo2.mReturnTransition = obj;
        animationInfo2.mExitTransition = null;
        animationInfo2.mReenterTransition = obj;
        animationInfo2.mSharedElementEnterTransition = null;
        animationInfo2.mSharedElementReturnTransition = obj;
        animationInfo2.mPostOnViewCreatedAlpha = 1.0f;
        animationInfo2.mFocusedView = null;
        this.mAnimationInfo = animationInfo2;
        return animationInfo2;
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public Fragment findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.mFragmentStore.findFragmentByWho(str);
    }

    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final FragmentActivity getActivity() {
        FragmentHostCallback fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            return null;
        }
        return fragmentHostCallback.mActivity;
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null || (bool = animationInfo.mAllowEnterTransitionOverlap) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null || (bool = animationInfo.mAllowReturnTransitionOverlap) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public View getAnimatingAway() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        animationInfo.getClass();
        return null;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final FragmentManager getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " has not been attached yet."));
        return null;
    }

    public Context getContext() {
        FragmentHostCallback fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            return null;
        }
        return fragmentHostCallback.mContext;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && FragmentManager.isLoggingEnabled(3)) {
            Objects.toString(requireContext().getApplicationContext());
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(0);
        LinkedHashMap linkedHashMap = mutableCreationExtras.extras;
        if (application != null) {
            linkedHashMap.put(ViewModelProvider$AndroidViewModelFactory.APPLICATION_KEY, application);
        }
        linkedHashMap.put(ViewModelKt.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        linkedHashMap.put(ViewModelKt.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (getArguments() != null) {
            linkedHashMap.put(ViewModelKt.DEFAULT_ARGS_KEY, getArguments());
        }
        return mutableCreationExtras;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider$Factory getDefaultViewModelProviderFactory() {
        Application application = null;
        if (this.mFragmentManager == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Can't access ViewModels from detached fragment");
            return null;
        }
        ViewModelProvider$Factory viewModelProvider$Factory = this.mDefaultFactory;
        if (viewModelProvider$Factory != null) {
            return viewModelProvider$Factory;
        }
        for (Context applicationContext = requireContext().getApplicationContext(); applicationContext instanceof ContextWrapper; applicationContext = ((ContextWrapper) applicationContext).getBaseContext()) {
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
        }
        if (application == null && FragmentManager.isLoggingEnabled(3)) {
            Objects.toString(requireContext().getApplicationContext());
        }
        SavedStateViewModelFactory savedStateViewModelFactory = new SavedStateViewModelFactory(application, this, getArguments());
        this.mDefaultFactory = savedStateViewModelFactory;
        return savedStateViewModelFactory;
    }

    public int getEnterAnim() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mEnterAnim;
    }

    public Object getEnterTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mEnterTransition;
    }

    public SharedElementCallback getEnterTransitionCallback() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        animationInfo.getClass();
        return null;
    }

    public int getExitAnim() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mExitAnim;
    }

    public Object getExitTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mExitTransition;
    }

    public SharedElementCallback getExitTransitionCallback() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        animationInfo.getClass();
        return null;
    }

    public View getFocusedView() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mFocusedView;
    }

    @Deprecated
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        FragmentHostCallback fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            return null;
        }
        return FragmentActivity.this;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        FragmentHostCallback fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
            return null;
        }
        FragmentActivity fragmentActivity = FragmentActivity.this;
        LayoutInflater layoutInflaterCloneInContext = fragmentActivity.getLayoutInflater().cloneInContext(fragmentActivity);
        layoutInflaterCloneInContext.setFactory2(this.mChildFragmentManager.mLayoutInflaterFactory);
        return layoutInflaterCloneInContext;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public LoaderManager getLoaderManager() {
        return LoaderManager.getInstance(this);
    }

    public final int getMinimumMaxLifecycleState() {
        Lifecycle.State state = this.mMaxState;
        return (state == Lifecycle.State.INITIALIZED || this.mParentFragment == null) ? state.ordinal() : Math.min(state.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    }

    public int getNextTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mNextTransition;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final FragmentManager getParentFragmentManager() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " not associated with a fragment manager."));
        return null;
    }

    public boolean getPopDirection() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return false;
        }
        return animationInfo.mIsPop;
    }

    public int getPopEnterAnim() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mPopEnterAnim;
    }

    public int getPopExitAnim() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mPopExitAnim;
    }

    public float getPostOnViewCreatedAlpha() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 1.0f;
        }
        return animationInfo.mPostOnViewCreatedAlpha;
    }

    public Object getReenterTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        Object obj = animationInfo.mReenterTransition;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        FragmentStrictMode.Policy policy = FragmentStrictMode.defaultPolicy;
        FragmentStrictMode.logIfDebuggingEnabled(new GetRetainInstanceUsageViolation(this, "Attempting to get retain instance for fragment " + this));
        FragmentStrictMode.getNearestPolicy(this).getClass();
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        Object obj = animationInfo.mReturnTransition;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.savedStateRegistry;
    }

    public Object getSharedElementEnterTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mSharedElementEnterTransition;
    }

    public Object getSharedElementReturnTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        Object obj = animationInfo.mSharedElementReturnTransition;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    public ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        AnimationInfo animationInfo = this.mAnimationInfo;
        return (animationInfo == null || (arrayList = animationInfo.mSharedElementSourceNames) == null) ? new ArrayList<>() : arrayList;
    }

    public ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        AnimationInfo animationInfo = this.mAnimationInfo;
        return (animationInfo == null || (arrayList = animationInfo.mSharedElementTargetNames) == null) ? new ArrayList<>() : arrayList;
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getTag() {
        return this.mTag;
    }

    public final Fragment getTargetFragment(boolean z) {
        String str;
        if (z) {
            FragmentStrictMode.Policy policy = FragmentStrictMode.defaultPolicy;
            FragmentStrictMode.logIfDebuggingEnabled(new GetTargetFragmentUsageViolation(this, "Attempting to get target fragment from fragment " + this));
            FragmentStrictMode.getNearestPolicy(this).getClass();
        }
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return fragmentManager.mFragmentStore.findActiveFragment(str);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        FragmentStrictMode.Policy policy = FragmentStrictMode.defaultPolicy;
        FragmentStrictMode.logIfDebuggingEnabled(new GetTargetFragmentUsageViolation(this, "Attempting to get target request code from fragment " + this));
        FragmentStrictMode.getNearestPolicy(this).getClass();
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public LifecycleOwner getViewLifecycleOwner() {
        FragmentViewLifecycleOwner fragmentViewLifecycleOwner = this.mViewLifecycleOwner;
        if (fragmentViewLifecycleOwner != null) {
            return fragmentViewLifecycleOwner;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
        return null;
    }

    public LiveData getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (this.mFragmentManager == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Can't access ViewModels from detached fragment");
            return null;
        }
        if (getMinimumMaxLifecycleState() == 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
            return null;
        }
        HashMap map = this.mFragmentManager.mNonConfig.mViewModelStores;
        ViewModelStore viewModelStore = (ViewModelStore) map.get(this.mWho);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        map.put(this.mWho, viewModelStore2);
        return viewModelStore2;
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final void initLifecycle() {
        this.mLifecycleRegistry = new LifecycleRegistry(this, true);
        this.mSavedStateRegistryController = new SavedStateRegistryController(new SavedStateRegistryImpl(this, new RoomDatabase$$ExternalSyntheticLambda0((byte) 27, this)));
        this.mDefaultFactory = null;
        if (this.mOnPreAttachedListeners.contains(this.mSavedStateAttachListener)) {
            return;
        }
        OnPreAttachedListener onPreAttachedListener = this.mSavedStateAttachListener;
        if (this.mState >= 0) {
            onPreAttachedListener.onPreAttached();
        } else {
            this.mOnPreAttachedListeners.add(onPreAttachedListener);
        }
    }

    public void initState() {
        initLifecycle();
        this.mPreviousWho = this.mWho;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        if (this.mHidden) {
            return true;
        }
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            Fragment fragment = this.mParentFragment;
            fragmentManager.getClass();
            if (fragment == null ? false : fragment.isHidden()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        if (!this.mMenuVisible) {
            return false;
        }
        if (this.mFragmentManager != null) {
            Fragment fragment = this.mParentFragment;
            if (!(fragment == null ? true : fragment.isMenuVisible())) {
                return false;
            }
        }
        return true;
    }

    public boolean isPostponed() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return false;
        }
        return animationInfo.mEnterTransitionPostponed;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            return false;
        }
        return fragmentManager.mStateSaved || fragmentManager.mStopped;
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.noteStateNotSaved();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i, int i2, Intent intent) {
        if (FragmentManager.isLoggingEnabled(2)) {
            toString();
            Objects.toString(intent);
        }
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        FragmentHostCallback fragmentHostCallback = this.mHost;
        FragmentActivity fragmentActivity = fragmentHostCallback == null ? null : fragmentHostCallback.mActivity;
        if (fragmentActivity != null) {
            this.mCalled = false;
            onAttach((Activity) fragmentActivity);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        FragmentManager fragmentManager = this.mChildFragmentManager;
        if (fragmentManager.mCurState >= 1) {
            return;
        }
        fragmentManager.mStateSaved = false;
        fragmentManager.mStopped = false;
        fragmentManager.mNonConfig.mIsStateSaved = false;
        fragmentManager.dispatchStateChange(1);
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public abstract View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        FragmentHostCallback fragmentHostCallback = this.mHost;
        FragmentActivity fragmentActivity = fragmentHostCallback == null ? null : fragmentHostCallback.mActivity;
        if (fragmentActivity != null) {
            this.mCalled = false;
            onInflate((Activity) fragmentActivity, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    @Deprecated
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
            throw new SuperNotCalledException(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " did not call through to super.onActivityCreated()"));
        }
        if (FragmentManager.isLoggingEnabled(3)) {
            toString();
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
        FragmentManager fragmentManager = this.mChildFragmentManager;
        fragmentManager.mStateSaved = false;
        fragmentManager.mStopped = false;
        fragmentManager.mNonConfig.mIsStateSaved = false;
        fragmentManager.dispatchStateChange(4);
    }

    public void performAttach() {
        ArrayList<OnPreAttachedListener> arrayList = this.mOnPreAttachedListeners;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            OnPreAttachedListener onPreAttachedListener = arrayList.get(i);
            i++;
            onPreAttachedListener.onPreAttached();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.attachController(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.mContext);
        if (!this.mCalled) {
            throw new SuperNotCalledException(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " did not call through to super.onAttach()"));
        }
        Iterator it = this.mFragmentManager.mOnAttachListeners.iterator();
        while (it.hasNext()) {
            ((FragmentOnAttachListener) it.next()).onAttachFragment$1(this);
        }
        FragmentManager fragmentManager = this.mChildFragmentManager;
        fragmentManager.mStateSaved = false;
        fragmentManager.mStopped = false;
        fragmentManager.mNonConfig.mIsStateSaved = false;
        fragmentManager.dispatchStateChange(0);
    }

    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.dispatchContextItemSelected(menuItem);
    }

    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.addObserver(new LifecycleEventObserver() { // from class: androidx.fragment.app.Fragment.6
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                View view;
                if (event != Lifecycle.Event.ON_STOP || (view = Fragment.this.mView) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
        this.mSavedStateRegistryController.performRestore(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (!this.mCalled) {
            throw new SuperNotCalledException(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " did not call through to super.onCreate()"));
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z = true;
        }
        return this.mChildFragmentManager.dispatchCreateOptionsMenu(menu, menuInflater) | z;
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new FragmentViewLifecycleOwner(this, getViewModelStore());
        View viewOnCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = viewOnCreateView;
        FragmentViewLifecycleOwner fragmentViewLifecycleOwner = this.mViewLifecycleOwner;
        if (viewOnCreateView == null) {
            if (fragmentViewLifecycleOwner.mLifecycleRegistry == null) {
                this.mViewLifecycleOwner = null;
                return;
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Called getViewLifecycleOwner() but onCreateView() returned null");
                return;
            }
        }
        fragmentViewLifecycleOwner.initialize();
        View view = this.mView;
        FragmentViewLifecycleOwner fragmentViewLifecycleOwner2 = this.mViewLifecycleOwner;
        view.getClass();
        view.setTag(R.id.view_tree_lifecycle_owner, fragmentViewLifecycleOwner2);
        View view2 = this.mView;
        FragmentViewLifecycleOwner fragmentViewLifecycleOwner3 = this.mViewLifecycleOwner;
        view2.getClass();
        view2.setTag(R.id.view_tree_view_model_store_owner, fragmentViewLifecycleOwner3);
        View view3 = this.mView;
        FragmentViewLifecycleOwner fragmentViewLifecycleOwner4 = this.mViewLifecycleOwner;
        view3.getClass();
        view3.setTag(R.id.view_tree_saved_state_registry_owner, fragmentViewLifecycleOwner4);
        this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
    }

    public void performDestroy() {
        this.mChildFragmentManager.dispatchDestroy();
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new SuperNotCalledException(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " did not call through to super.onDestroy()"));
        }
    }

    public void performDestroyView() {
        this.mChildFragmentManager.dispatchStateChange(1);
        if (this.mView != null) {
            FragmentViewLifecycleOwner fragmentViewLifecycleOwner = this.mViewLifecycleOwner;
            fragmentViewLifecycleOwner.initialize();
            if (fragmentViewLifecycleOwner.mLifecycleRegistry.state.compareTo(Lifecycle.State.CREATED) >= 0) {
                this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
            }
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new SuperNotCalledException(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " did not call through to super.onDestroyView()"));
        }
        SparseArrayCompat sparseArrayCompat = LoaderManager.getInstance(this).mLoaderViewModel.mLoaders;
        if (sparseArrayCompat.size() <= 0) {
            this.mPerformedCreateView = false;
        } else {
            sparseArrayCompat.valueAt(0).getClass();
            PathKt$$ExternalSyntheticBUOutline0.m();
        }
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new SuperNotCalledException(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " did not call through to super.onDetach()"));
        }
        FragmentManager fragmentManager = this.mChildFragmentManager;
        if (fragmentManager.mDestroyed) {
            return;
        }
        fragmentManager.dispatchDestroy();
        this.mChildFragmentManager = new FragmentManagerImpl();
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = layoutInflaterOnGetLayoutInflater;
        return layoutInflaterOnGetLayoutInflater;
    }

    public void performLowMemory() {
        onLowMemory();
    }

    public void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.dispatchOptionsItemSelected(menuItem);
    }

    public void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.dispatchOptionsMenuClosed(menu);
    }

    public void performPause() {
        this.mChildFragmentManager.dispatchStateChange(5);
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new SuperNotCalledException(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " did not call through to super.onPause()"));
        }
    }

    public void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z = true;
        }
        return this.mChildFragmentManager.dispatchPrepareOptionsMenu(menu) | z;
    }

    public void performPrimaryNavigationFragmentChanged() {
        this.mFragmentManager.getClass();
        boolean zIsPrimaryNavigation = FragmentManager.isPrimaryNavigation(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != zIsPrimaryNavigation) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(zIsPrimaryNavigation);
            onPrimaryNavigationFragmentChanged(zIsPrimaryNavigation);
            FragmentManager fragmentManager = this.mChildFragmentManager;
            fragmentManager.updateOnBackPressedCallbackEnabled();
            fragmentManager.dispatchParentPrimaryNavigationFragmentChanged(fragmentManager.mPrimaryNav);
        }
    }

    public void performResume() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new SuperNotCalledException(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " did not call through to super.onResume()"));
        }
        LifecycleRegistry lifecycleRegistry = this.mLifecycleRegistry;
        Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
        lifecycleRegistry.handleLifecycleEvent(event);
        if (this.mView != null) {
            this.mViewLifecycleOwner.mLifecycleRegistry.handleLifecycleEvent(event);
        }
        FragmentManager fragmentManager = this.mChildFragmentManager;
        fragmentManager.mStateSaved = false;
        fragmentManager.mStopped = false;
        fragmentManager.mNonConfig.mIsStateSaved = false;
        fragmentManager.dispatchStateChange(7);
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.performSave(bundle);
        bundle.putParcelable("android:support:fragments", this.mChildFragmentManager.saveAllStateInternal());
    }

    public void performStart() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new SuperNotCalledException(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " did not call through to super.onStart()"));
        }
        LifecycleRegistry lifecycleRegistry = this.mLifecycleRegistry;
        Lifecycle.Event event = Lifecycle.Event.ON_START;
        lifecycleRegistry.handleLifecycleEvent(event);
        if (this.mView != null) {
            this.mViewLifecycleOwner.mLifecycleRegistry.handleLifecycleEvent(event);
        }
        FragmentManager fragmentManager = this.mChildFragmentManager;
        fragmentManager.mStateSaved = false;
        fragmentManager.mStopped = false;
        fragmentManager.mNonConfig.mIsStateSaved = false;
        fragmentManager.dispatchStateChange(5);
    }

    public void performStop() {
        FragmentManager fragmentManager = this.mChildFragmentManager;
        fragmentManager.mStopped = true;
        fragmentManager.mNonConfig.mIsStateSaved = true;
        fragmentManager.dispatchStateChange(4);
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new SuperNotCalledException(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " did not call through to super.onStop()"));
        }
    }

    public void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.dispatchStateChange(2);
    }

    public final void postponeEnterTransition(long j, TimeUnit timeUnit) {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
        FragmentManager fragmentManager = this.mFragmentManager;
        Handler handler = fragmentManager != null ? fragmentManager.mHost.mHandler : new Handler(Looper.getMainLooper());
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j));
    }

    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.fragment.app.Fragment$10] */
    public final AnonymousClass10 prepareCallInternal(final ActivityResultContract activityResultContract, final AnonymousClass7 anonymousClass7, final ActivityResultCallback activityResultCallback) {
        if (this.mState > 1) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
            return null;
        }
        final AtomicReference atomicReference = new AtomicReference();
        OnPreAttachedListener onPreAttachedListener = new OnPreAttachedListener() { // from class: androidx.fragment.app.Fragment.9
            @Override // androidx.fragment.app.Fragment.OnPreAttachedListener
            public final void onPreAttached() {
                ActivityResultRegistry activityResultRegistry;
                Fragment fragment = Fragment.this;
                String strGenerateActivityResultKey = fragment.generateActivityResultKey();
                AnonymousClass7 anonymousClass8 = anonymousClass7;
                switch (anonymousClass8.$r8$classId) {
                    case 0:
                        Fragment fragment2 = (Fragment) anonymousClass8.this$0;
                        Object obj = fragment2.mHost;
                        activityResultRegistry = !(obj instanceof ActivityResultRegistryOwner) ? fragment2.requireActivity().getActivityResultRegistry() : ((ActivityResultRegistryOwner) obj).getActivityResultRegistry();
                        break;
                    default:
                        activityResultRegistry = (ActivityResultRegistry) anonymousClass8.this$0;
                        break;
                }
                atomicReference.set(activityResultRegistry.register(strGenerateActivityResultKey, fragment, activityResultContract, activityResultCallback));
            }
        };
        if (this.mState >= 0) {
            onPreAttachedListener.onPreAttached();
        } else {
            this.mOnPreAttachedListeners.add(onPreAttachedListener);
        }
        return new ActivityResultLauncher() { // from class: androidx.fragment.app.Fragment.10
            @Override // androidx.activity.result.ActivityResultLauncher
            public final void launch(Object obj) {
                ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) atomicReference.get();
                if (activityResultLauncher != null) {
                    activityResultLauncher.launch(obj);
                } else {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Operation cannot be started before fragment is in created state");
                }
            }
        };
    }

    public final <I, O> ActivityResultLauncher registerForActivityResult(ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
        return prepareCallInternal(activityResultContract, new AnonymousClass7((byte) 0, this), activityResultCallback);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] strArr, int i) {
        if (this.mHost == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " not attached to Activity"));
            return;
        }
        FragmentManager parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.mRequestPermissions == null) {
            parentFragmentManager.mHost.getClass();
            return;
        }
        parentFragmentManager.mLaunchedFragments.addLast(new FragmentManager.LaunchedFragmentInfo(this.mWho, i));
        parentFragmentManager.mRequestPermissions.launch(strArr);
    }

    public final FragmentActivity requireActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " not attached to an activity."));
        return null;
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " does not have any arguments."));
        return null;
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " not attached to a context."));
        return null;
    }

    @Deprecated
    public final FragmentManager requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " not attached to a host."));
        return null;
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " is not attached to any Fragment or host"));
            return null;
        }
        StringBuilder sb = new StringBuilder("Fragment ");
        sb.append(this);
        Context context = getContext();
        sb.append(" is not a child Fragment, it is directly attached to ");
        sb.append(context);
        throw new IllegalStateException(sb.toString());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
        return null;
    }

    public void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.restoreSaveStateInternal(parcelable);
        FragmentManager fragmentManager = this.mChildFragmentManager;
        fragmentManager.mStateSaved = false;
        fragmentManager.mStopped = false;
        fragmentManager.mNonConfig.mIsStateSaved = false;
        fragmentManager.dispatchStateChange(1);
    }

    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            FragmentViewLifecycleOwner fragmentViewLifecycleOwner = this.mViewLifecycleOwner;
            fragmentViewLifecycleOwner.mSavedStateRegistryController.performRestore(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new SuperNotCalledException(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " did not call through to super.onViewStateRestored()"));
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        ensureAnimationInfo().mAllowEnterTransitionOverlap = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        ensureAnimationInfo().mAllowReturnTransitionOverlap = Boolean.valueOf(z);
    }

    public void setAnimations(int i, int i2, int i3, int i4) {
        if (this.mAnimationInfo == null && i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return;
        }
        ensureAnimationInfo().mEnterAnim = i;
        ensureAnimationInfo().mExitAnim = i2;
        ensureAnimationInfo().mPopEnterAnim = i3;
        ensureAnimationInfo().mPopExitAnim = i4;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager == null || !isStateSaved()) {
            this.mArguments = bundle;
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Fragment already added and state has been saved");
        }
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ensureAnimationInfo().getClass();
    }

    public void setEnterTransition(Object obj) {
        ensureAnimationInfo().mEnterTransition = obj;
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ensureAnimationInfo().getClass();
    }

    public void setExitTransition(Object obj) {
        ensureAnimationInfo().mExitTransition = obj;
    }

    public void setFocusedView(View view) {
        ensureAnimationInfo().mFocusedView = view;
    }

    @Deprecated
    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (!isAdded() || isHidden()) {
                return;
            }
            FragmentActivity.this.invalidateOptionsMenu();
        }
    }

    public void setInitialSavedState(SavedState savedState) {
        Bundle bundle;
        if (this.mFragmentManager != null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Fragment already added");
            return;
        }
        if (savedState == null || (bundle = savedState.mState) == null) {
            bundle = null;
        }
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                FragmentActivity.this.invalidateOptionsMenu();
            }
        }
    }

    public void setNextTransition(int i) {
        if (this.mAnimationInfo == null && i == 0) {
            return;
        }
        ensureAnimationInfo();
        this.mAnimationInfo.mNextTransition = i;
    }

    public void setPopDirection(boolean z) {
        if (this.mAnimationInfo == null) {
            return;
        }
        ensureAnimationInfo().mIsPop = z;
    }

    public void setPostOnViewCreatedAlpha(float f) {
        ensureAnimationInfo().mPostOnViewCreatedAlpha = f;
    }

    public void setReenterTransition(Object obj) {
        ensureAnimationInfo().mReenterTransition = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z) {
        FragmentStrictMode.Policy policy = FragmentStrictMode.defaultPolicy;
        FragmentStrictMode.logIfDebuggingEnabled(new GetRetainInstanceUsageViolation(this, "Attempting to set retain instance for fragment " + this));
        FragmentStrictMode.getNearestPolicy(this).getClass();
        this.mRetainInstance = z;
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            this.mRetainInstanceChangedWhileDetached = true;
            return;
        }
        FragmentManagerViewModel fragmentManagerViewModel = fragmentManager.mNonConfig;
        if (z) {
            fragmentManagerViewModel.addRetainedFragment(this);
        } else {
            fragmentManagerViewModel.removeRetainedFragment(this);
        }
    }

    public void setReturnTransition(Object obj) {
        ensureAnimationInfo().mReturnTransition = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        ensureAnimationInfo().mSharedElementEnterTransition = obj;
    }

    public void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        ensureAnimationInfo();
        AnimationInfo animationInfo = this.mAnimationInfo;
        animationInfo.mSharedElementSourceNames = arrayList;
        animationInfo.mSharedElementTargetNames = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        ensureAnimationInfo().mSharedElementReturnTransition = obj;
    }

    @Deprecated
    public void setTargetFragment(Fragment fragment, int i) {
        if (fragment != null) {
            FragmentStrictMode.Policy policy = FragmentStrictMode.defaultPolicy;
            FragmentStrictMode.logIfDebuggingEnabled(new GetTargetFragmentUsageViolation(this, "Attempting to set target fragment " + fragment + " with request code " + i + " for fragment " + this));
            FragmentStrictMode.getNearestPolicy(this).getClass();
        }
        FragmentManager fragmentManager = this.mFragmentManager;
        FragmentManager fragmentManager2 = fragment != null ? fragment.mFragmentManager : null;
        if (fragmentManager != null && fragmentManager2 != null && fragmentManager != fragmentManager2) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", fragment, " must share the same FragmentManager to be set as a target fragment"));
            return;
        }
        for (Fragment targetFragment = fragment; targetFragment != null; targetFragment = targetFragment.getTargetFragment(false)) {
            if (targetFragment.equals(this)) {
                DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Setting ", fragment, " as the target of ", this, " would create a target cycle");
                return;
            }
        }
        if (fragment == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
            this.mTargetWho = null;
            this.mTarget = fragment;
        } else {
            this.mTargetWho = fragment.mWho;
            this.mTarget = null;
        }
        this.mTargetRequestCode = i;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        FragmentStrictMode.Policy policy = FragmentStrictMode.defaultPolicy;
        FragmentStrictMode.logIfDebuggingEnabled(new FragmentReuseViolation(this, "Attempting to set user visible hint to " + z + " for fragment " + this));
        FragmentStrictMode.getNearestPolicy(this).getClass();
        boolean z2 = false;
        if (!this.mUserVisibleHint && z && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            FragmentManager fragmentManager = this.mFragmentManager;
            FragmentStateManager fragmentStateManagerCreateOrGetFragmentStateManager = fragmentManager.createOrGetFragmentStateManager(this);
            Fragment fragment = fragmentStateManagerCreateOrGetFragmentStateManager.mFragment;
            if (fragment.mDeferStart) {
                if (fragmentManager.mExecutingActions) {
                    fragmentManager.mHavePendingDeferredStart = true;
                } else {
                    fragment.mDeferStart = false;
                    fragmentStateManagerCreateOrGetFragmentStateManager.moveToExpectedState();
                }
            }
        }
        this.mUserVisibleHint = z;
        if (this.mState < 5 && !z) {
            z2 = true;
        }
        this.mDeferStart = z2;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        FragmentHostCallback fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            return false;
        }
        FragmentActivity fragmentActivity = FragmentActivity.this;
        int i = Build.VERSION.SDK_INT;
        if (i < 33 && TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return false;
        }
        if (i >= 32) {
            return fragmentActivity.shouldShowRequestPermissionRationale(str);
        }
        if (i != 31) {
            return fragmentActivity.shouldShowRequestPermissionRationale(str);
        }
        try {
            return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(fragmentActivity.getApplication().getPackageManager(), str)).booleanValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return fragmentActivity.shouldShowRequestPermissionRationale(str);
        }
    }

    public void startActivity(Intent intent, Bundle bundle) {
        FragmentHostCallback fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            fragmentHostCallback.mContext.startActivity(intent, bundle);
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " not attached to Activity"));
        }
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (this.mHost == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " not attached to Activity"));
            return;
        }
        FragmentManager parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.mStartActivityForResult != null) {
            parentFragmentManager.mLaunchedFragments.addLast(new FragmentManager.LaunchedFragmentInfo(this.mWho, i));
            if (intent != null && bundle != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            parentFragmentManager.mStartActivityForResult.launch(intent);
            return;
        }
        FragmentHostCallback fragmentHostCallback = parentFragmentManager.mHost;
        if (i == -1) {
            fragmentHostCallback.mContext.startActivity(intent, bundle);
        } else {
            fragmentHostCallback.getClass();
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Starting activity with a requestCode requires a FragmentActivity host");
        }
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2;
        if (this.mHost == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2(Fragment$5$$ExternalSyntheticOutline0.m("Fragment ", this, " not attached to Activity"));
            return;
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            toString();
            Objects.toString(intentSender);
            Objects.toString(intent);
            Objects.toString(bundle);
        }
        FragmentManager parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.mStartIntentSenderForResult == null) {
            FragmentHostCallback fragmentHostCallback = parentFragmentManager.mHost;
            if (i == -1) {
                fragmentHostCallback.mActivity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
                return;
            } else {
                fragmentHostCallback.getClass();
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Starting intent sender with a requestCode requires a FragmentActivity host");
                return;
            }
        }
        if (bundle != null) {
            if (intent == null) {
                intent2 = new Intent();
                intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            } else {
                intent2 = intent;
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                bundle.toString();
                intent2.toString();
                Objects.toString(this);
            }
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        } else {
            intent2 = intent;
        }
        intentSender.getClass();
        IntentSenderRequest intentSenderRequest = new IntentSenderRequest(intentSender, intent2, i2, i3);
        parentFragmentManager.mLaunchedFragments.addLast(new FragmentManager.LaunchedFragmentInfo(this.mWho, i));
        if (FragmentManager.isLoggingEnabled(2)) {
            toString();
        }
        parentFragmentManager.mStartIntentSenderForResult.launch(intentSenderRequest);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !ensureAnimationInfo().mEnterTransitionPostponed) {
            return;
        }
        if (this.mHost == null) {
            ensureAnimationInfo().mEnterTransitionPostponed = false;
        } else if (Looper.myLooper() != this.mHost.mHandler.getLooper()) {
            this.mHost.mHandler.postAtFrontOfQueue(new AnonymousClass1((byte) 3, this));
        } else {
            callStartTransitionListener(true);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final <I, O> ActivityResultLauncher registerForActivityResult(ActivityResultContract activityResultContract, ActivityResultRegistry activityResultRegistry, ActivityResultCallback activityResultCallback) {
        return prepareCallInternal(activityResultContract, new AnonymousClass7((byte) 1, activityResultRegistry), activityResultCallback);
    }

    @Deprecated
    public void onDestroyOptionsMenu() {
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    @Deprecated
    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    @Deprecated
    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Deprecated
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().mEnterTransitionPostponed = true;
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        return getTargetFragment(true);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    @Deprecated
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }
}
