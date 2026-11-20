package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import androidx.collection.internal.Lock;
import androidx.core.os.CancellationSignal;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.datastore.preferences.PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import coil3.util.UtilsKt;
import com.yalantis.ucrop.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultSpecialEffectsController {
    public final ViewGroup mContainer;
    public final ArrayList mPendingOperations = new ArrayList();
    public final ArrayList mRunningOperations = new ArrayList();
    public boolean mOperationDirectionIsPop = false;
    public boolean mIsContainerPostponed = false;

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnimationInfo extends SpecialEffectsInfo {
        public FragmentAnim$AnimationOrAnimator mAnimation;
        public boolean mIsPop;
        public boolean mLoadedAnim;

        /* JADX WARN: Code duplicated, block: B:74:0x00f3 A[Catch: RuntimeException -> 0x00f9, TRY_LEAVE, TryCatch #2 {RuntimeException -> 0x00f9, blocks: (B:72:0x00ed, B:74:0x00f3), top: B:85:0x00ed }] */
        public final FragmentAnim$AnimationOrAnimator getAnimation(Context context) {
            int enterAnim;
            FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator;
            Animator animatorLoadAnimator;
            int activityTransitResId;
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = this.mOperation;
            Fragment fragment = specialEffectsController$FragmentStateManagerOperation.mFragment;
            boolean z = specialEffectsController$FragmentStateManagerOperation.mFinalState == 2;
            boolean z2 = this.mIsPop;
            int nextTransition = fragment.getNextTransition();
            if (z2) {
                enterAnim = z ? fragment.getPopEnterAnim() : fragment.getPopExitAnim();
            } else {
                enterAnim = z ? fragment.getEnterAnim() : fragment.getExitAnim();
            }
            fragment.setAnimations(0, 0, 0, 0);
            ViewGroup viewGroup = fragment.mContainer;
            FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator2 = null;
            if (viewGroup != null && viewGroup.getTag(R.id.visible_removing_fragment_view_tag) != null) {
                fragment.mContainer.setTag(R.id.visible_removing_fragment_view_tag, null);
            }
            ViewGroup viewGroup2 = fragment.mContainer;
            if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
                Animation animationOnCreateAnimation = fragment.onCreateAnimation(nextTransition, z, enterAnim);
                if (animationOnCreateAnimation != null) {
                    fragmentAnim$AnimationOrAnimator2 = new FragmentAnim$AnimationOrAnimator(animationOnCreateAnimation);
                } else {
                    Animator animatorOnCreateAnimator = fragment.onCreateAnimator(nextTransition, z, enterAnim);
                    if (animatorOnCreateAnimator != null) {
                        fragmentAnim$AnimationOrAnimator2 = new FragmentAnim$AnimationOrAnimator(animatorOnCreateAnimator);
                    } else {
                        if (enterAnim == 0 && nextTransition != 0) {
                            if (nextTransition == 4097) {
                                activityTransitResId = z ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
                            } else if (nextTransition == 8194) {
                                activityTransitResId = z ? R.animator.fragment_close_enter : R.animator.fragment_close_exit;
                            } else if (nextTransition == 8197) {
                                activityTransitResId = z ? UtilsKt.toActivityTransitResId(context, android.R.attr.activityCloseEnterAnimation) : UtilsKt.toActivityTransitResId(context, android.R.attr.activityCloseExitAnimation);
                            } else if (nextTransition == 4099) {
                                activityTransitResId = z ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit;
                            } else if (nextTransition != 4100) {
                                activityTransitResId = -1;
                            } else {
                                activityTransitResId = z ? UtilsKt.toActivityTransitResId(context, android.R.attr.activityOpenEnterAnimation) : UtilsKt.toActivityTransitResId(context, android.R.attr.activityOpenExitAnimation);
                            }
                            enterAnim = activityTransitResId;
                        }
                        if (enterAnim != 0) {
                            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(enterAnim));
                            if (zEquals) {
                                try {
                                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, enterAnim);
                                    if (animationLoadAnimation != null) {
                                        fragmentAnim$AnimationOrAnimator = new FragmentAnim$AnimationOrAnimator(animationLoadAnimation);
                                        fragmentAnim$AnimationOrAnimator2 = fragmentAnim$AnimationOrAnimator;
                                    }
                                } catch (Resources.NotFoundException e) {
                                    throw e;
                                } catch (RuntimeException unused) {
                                    try {
                                        animatorLoadAnimator = AnimatorInflater.loadAnimator(context, enterAnim);
                                        if (animatorLoadAnimator != null) {
                                            fragmentAnim$AnimationOrAnimator = new FragmentAnim$AnimationOrAnimator(animatorLoadAnimator);
                                            fragmentAnim$AnimationOrAnimator2 = fragmentAnim$AnimationOrAnimator;
                                        }
                                    } catch (RuntimeException e2) {
                                        if (zEquals) {
                                            throw e2;
                                        }
                                        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, enterAnim);
                                        if (animationLoadAnimation2 != null) {
                                            fragmentAnim$AnimationOrAnimator2 = new FragmentAnim$AnimationOrAnimator(animationLoadAnimation2);
                                        }
                                    }
                                }
                            } else {
                                animatorLoadAnimator = AnimatorInflater.loadAnimator(context, enterAnim);
                                if (animatorLoadAnimator != null) {
                                    fragmentAnim$AnimationOrAnimator = new FragmentAnim$AnimationOrAnimator(animatorLoadAnimator);
                                    fragmentAnim$AnimationOrAnimator2 = fragmentAnim$AnimationOrAnimator;
                                }
                            }
                        }
                    }
                }
            }
            this.mAnimation = fragmentAnim$AnimationOrAnimator2;
            this.mLoadedAnim = true;
            return fragmentAnim$AnimationOrAnimator2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class SpecialEffectsInfo {
        public final SpecialEffectsController$FragmentStateManagerOperation mOperation;
        public final CancellationSignal mSignal;

        public SpecialEffectsInfo(SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation, CancellationSignal cancellationSignal) {
            this.mOperation = specialEffectsController$FragmentStateManagerOperation;
            this.mSignal = cancellationSignal;
        }

        public final void completeSpecialEffect() {
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = this.mOperation;
            HashSet hashSet = specialEffectsController$FragmentStateManagerOperation.mSpecialEffectsSignals;
            if (hashSet.remove(this.mSignal) && hashSet.isEmpty()) {
                specialEffectsController$FragmentStateManagerOperation.complete();
            }
        }

        public final boolean isVisibilityUnchanged() {
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = this.mOperation;
            int i_from = Fragment$5$$ExternalSyntheticOutline0._from(specialEffectsController$FragmentStateManagerOperation.mFragment.mView);
            int i = specialEffectsController$FragmentStateManagerOperation.mFinalState;
            if (i_from != i) {
                return (i_from == 2 || i == 2) ? false : true;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class TransitionInfo extends SpecialEffectsInfo {
        public final boolean mOverlapAllowed;
        public final Object mSharedElementTransition;
        public final Object mTransition;

        public TransitionInfo(SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation, CancellationSignal cancellationSignal, boolean z, boolean z2) {
            super(specialEffectsController$FragmentStateManagerOperation, cancellationSignal);
            int i = specialEffectsController$FragmentStateManagerOperation.mFinalState;
            Fragment fragment = specialEffectsController$FragmentStateManagerOperation.mFragment;
            if (i == 2) {
                this.mTransition = z ? fragment.getReenterTransition() : fragment.getEnterTransition();
                this.mOverlapAllowed = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
            } else {
                this.mTransition = z ? fragment.getReturnTransition() : fragment.getExitTransition();
                this.mOverlapAllowed = true;
            }
            if (!z2) {
                this.mSharedElementTransition = null;
            } else if (z) {
                this.mSharedElementTransition = fragment.getSharedElementReturnTransition();
            } else {
                this.mSharedElementTransition = fragment.getSharedElementEnterTransition();
            }
        }

        public final FragmentTransitionCompat21 getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionCompat21 fragmentTransitionCompat21 = FragmentTransition.PLATFORM_IMPL;
            boolean z = obj instanceof Transition;
            if (z) {
                return fragmentTransitionCompat21;
            }
            FragmentTransitionCompat21 fragmentTransitionCompat22 = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionCompat22 != null && z) {
                return fragmentTransitionCompat22;
            }
            StringBuilder sb = new StringBuilder("Transition ");
            sb.append(obj);
            Fragment fragment = this.mOperation.mFragment;
            sb.append(" for fragment ");
            sb.append(fragment);
            sb.append(" is not a valid framework Transition or AndroidX Transition");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public DefaultSpecialEffectsController(ViewGroup viewGroup) {
        this.mContainer = viewGroup;
    }

    public static void captureTransitioningViews(View view, ArrayList arrayList) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = ViewGroupCompat.$r8$clinit;
        if (viewGroup.isTransitionGroup()) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                captureTransitioningViews(childAt, arrayList);
            }
        }
    }

    public static void findNamedViews(ArrayMap arrayMap, View view) {
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        String transitionName = view.getTransitionName();
        if (transitionName != null) {
            arrayMap.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(arrayMap, childAt);
                }
            }
        }
    }

    public static DefaultSpecialEffectsController getOrCreateController(ViewGroup viewGroup, Lock lock) {
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof DefaultSpecialEffectsController) {
            return (DefaultSpecialEffectsController) tag;
        }
        lock.getClass();
        DefaultSpecialEffectsController defaultSpecialEffectsController = new DefaultSpecialEffectsController(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, defaultSpecialEffectsController);
        return defaultSpecialEffectsController;
    }

    public static void retainMatchingViews(ArrayMap arrayMap, Collection collection) {
        Iterator it = ((ArrayMap.EntrySet) arrayMap.entrySet()).iterator();
        while (true) {
            ArrayMap.MapIterator mapIterator = (ArrayMap.MapIterator) it;
            if (!mapIterator.hasNext()) {
                return;
            }
            mapIterator.next();
            View view = (View) mapIterator.getValue();
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (!collection.contains(view.getTransitionName())) {
                mapIterator.remove();
            }
        }
    }

    public final void enqueue(int i, int i2, FragmentStateManager fragmentStateManager) {
        synchronized (this.mPendingOperations) {
            try {
                CancellationSignal cancellationSignal = new CancellationSignal();
                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperationFindPendingOperation = findPendingOperation(fragmentStateManager.mFragment);
                if (specialEffectsController$FragmentStateManagerOperationFindPendingOperation != null) {
                    specialEffectsController$FragmentStateManagerOperationFindPendingOperation.mergeWith(i, i2);
                    return;
                }
                final SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = new SpecialEffectsController$FragmentStateManagerOperation(i, i2, fragmentStateManager, cancellationSignal);
                this.mPendingOperations.add(specialEffectsController$FragmentStateManagerOperation);
                final byte b = 0;
                specialEffectsController$FragmentStateManagerOperation.mCompletionListeners.add(new Runnable(this) { // from class: androidx.fragment.app.SpecialEffectsController$1
                    public final /* synthetic */ DefaultSpecialEffectsController this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        byte b2 = b;
                        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2 = specialEffectsController$FragmentStateManagerOperation;
                        DefaultSpecialEffectsController defaultSpecialEffectsController = this.this$0;
                        switch (b2) {
                            case 0:
                                if (defaultSpecialEffectsController.mPendingOperations.contains(specialEffectsController$FragmentStateManagerOperation2)) {
                                    Fragment$5$$ExternalSyntheticOutline0._applyState(specialEffectsController$FragmentStateManagerOperation2.mFragment.mView, specialEffectsController$FragmentStateManagerOperation2.mFinalState);
                                }
                                break;
                            default:
                                defaultSpecialEffectsController.mPendingOperations.remove(specialEffectsController$FragmentStateManagerOperation2);
                                defaultSpecialEffectsController.mRunningOperations.remove(specialEffectsController$FragmentStateManagerOperation2);
                                break;
                        }
                    }
                });
                final byte b2 = 1;
                specialEffectsController$FragmentStateManagerOperation.mCompletionListeners.add(new Runnable(this) { // from class: androidx.fragment.app.SpecialEffectsController$1
                    public final /* synthetic */ DefaultSpecialEffectsController this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        byte b3 = b2;
                        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2 = specialEffectsController$FragmentStateManagerOperation;
                        DefaultSpecialEffectsController defaultSpecialEffectsController = this.this$0;
                        switch (b3) {
                            case 0:
                                if (defaultSpecialEffectsController.mPendingOperations.contains(specialEffectsController$FragmentStateManagerOperation2)) {
                                    Fragment$5$$ExternalSyntheticOutline0._applyState(specialEffectsController$FragmentStateManagerOperation2.mFragment.mView, specialEffectsController$FragmentStateManagerOperation2.mFinalState);
                                }
                                break;
                            default:
                                defaultSpecialEffectsController.mPendingOperations.remove(specialEffectsController$FragmentStateManagerOperation2);
                                defaultSpecialEffectsController.mRunningOperations.remove(specialEffectsController$FragmentStateManagerOperation2);
                                break;
                        }
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:152:0x0421  */
    /* JADX WARN: Code duplicated, block: B:186:0x0532  */
    /* JADX WARN: Code duplicated, block: B:188:0x0537  */
    /* JADX WARN: Code duplicated, block: B:190:0x0543 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:191:0x0545  */
    /* JADX WARN: Code duplicated, block: B:194:0x0561  */
    /* JADX WARN: Code duplicated, block: B:196:0x0568  */
    /* JADX WARN: Code duplicated, block: B:198:0x0570  */
    /* JADX WARN: Code duplicated, block: B:200:0x0577  */
    /* JADX WARN: Code duplicated, block: B:273:0x072a  */
    /* JADX WARN: Code duplicated, block: B:277:0x0740  */
    /* JADX WARN: Code duplicated, block: B:280:0x074a  */
    /* JADX WARN: Code duplicated, block: B:283:0x0754  */
    /* JADX WARN: Code duplicated, block: B:287:0x076e  */
    /* JADX WARN: Code duplicated, block: B:292:0x077f  */
    /* JADX WARN: Code duplicated, block: B:293:0x0782  */
    /* JADX WARN: Code duplicated, block: B:296:0x0788  */
    /* JADX WARN: Code duplicated, block: B:299:0x07b4  */
    /* JADX WARN: Code duplicated, block: B:303:0x07d8  */
    /* JADX WARN: Code duplicated, block: B:307:0x07ee  */
    /* JADX WARN: Code duplicated, block: B:313:0x07ff  */
    /* JADX WARN: Code duplicated, block: B:317:0x081b  */
    /* JADX WARN: Code duplicated, block: B:318:0x0822  */
    /* JADX WARN: Code duplicated, block: B:320:0x083d  */
    /* JADX WARN: Code duplicated, block: B:324:0x0852 A[LOOP:7: B:323:0x0850->B:324:0x0852, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:327:0x086f  */
    /* JADX WARN: Code duplicated, block: B:359:0x077a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:360:0x073a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:361:0x0746 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:362:0x0750 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:363:0x0766 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:367:0x07f5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:369:0x07e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:370:0x0806 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:371:0x07f9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:419:? A[RETURN, SYNTHETIC] */
    public final void executeOperations(ArrayList arrayList, boolean z) {
        byte b;
        byte b2;
        ArrayList arrayList2;
        HashMap map;
        ArrayList arrayList3;
        TransitionSet ordering;
        TransitionSet transitionSet;
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation;
        int i;
        SimpleArrayMap simpleArrayMap;
        int i2;
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2;
        TransitionSet transitionSet2;
        View view;
        byte b3;
        View view2;
        TransitionSet transitionSet3;
        TransitionSet transitionSet4;
        HashMap map2;
        View view3;
        Rect rect;
        ArrayList arrayList4;
        FragmentTransitionCompat21 fragmentTransitionCompat21;
        ArrayList arrayList5;
        int i3;
        boolean z2;
        TransitionSet transitionSet5;
        View view4;
        boolean z3;
        int i4;
        int i5;
        View view5;
        boolean zContainsValue;
        Context context;
        ArrayList arrayList6;
        int size;
        int i6;
        int i7;
        ViewGroup viewGroup;
        boolean z4;
        ArrayList arrayList7;
        int size2;
        int i8;
        int size3;
        int i9;
        AnimationInfo animationInfo;
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation3;
        Fragment fragment;
        View view6;
        Animation animation;
        final AnimationInfo animationInfo2;
        boolean z5;
        FragmentAnim$AnimationOrAnimator animation2;
        Animator animator;
        final SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation4;
        Fragment fragment2;
        final boolean z6;
        ArrayList arrayList8;
        boolean z7 = z;
        int size4 = arrayList.size();
        byte b4 = 0;
        int i10 = 0;
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation5 = null;
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation6 = null;
        while (true) {
            b = 2;
            b2 = 1;
            if (i10 >= size4) {
                break;
            }
            Object obj = arrayList.get(i10);
            i10++;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation7 = (SpecialEffectsController$FragmentStateManagerOperation) obj;
            int i_from = Fragment$5$$ExternalSyntheticOutline0._from(specialEffectsController$FragmentStateManagerOperation7.mFragment.mView);
            int iOrdinal = PreferencesProto$Value$ValueCase$EnumUnboxingSharedUtility.ordinal(specialEffectsController$FragmentStateManagerOperation7.mFinalState);
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    if (iOrdinal == 2 || iOrdinal == 3) {
                    }
                } else if (i_from != 2) {
                    specialEffectsController$FragmentStateManagerOperation6 = specialEffectsController$FragmentStateManagerOperation7;
                }
            }
            if (i_from == 2 && specialEffectsController$FragmentStateManagerOperation5 == null) {
                specialEffectsController$FragmentStateManagerOperation5 = specialEffectsController$FragmentStateManagerOperation7;
            }
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Objects.toString(specialEffectsController$FragmentStateManagerOperation5);
            Objects.toString(specialEffectsController$FragmentStateManagerOperation6);
        }
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList(arrayList);
        Fragment fragment3 = ((SpecialEffectsController$FragmentStateManagerOperation) arrayList.get(arrayList.size() - 1)).mFragment;
        int size5 = arrayList.size();
        int i11 = 0;
        while (i11 < size5) {
            Object obj2 = arrayList.get(i11);
            i11++;
            Fragment.AnimationInfo animationInfo3 = ((SpecialEffectsController$FragmentStateManagerOperation) obj2).mFragment.mAnimationInfo;
            byte b5 = b;
            Fragment.AnimationInfo animationInfo4 = fragment3.mAnimationInfo;
            animationInfo3.mEnterAnim = animationInfo4.mEnterAnim;
            animationInfo3.mExitAnim = animationInfo4.mExitAnim;
            animationInfo3.mPopEnterAnim = animationInfo4.mPopEnterAnim;
            animationInfo3.mPopExitAnim = animationInfo4.mPopExitAnim;
            b = b5;
        }
        byte b6 = b;
        int size6 = arrayList.size();
        int i12 = 0;
        while (i12 < size6) {
            Object obj3 = arrayList.get(i12);
            i12++;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation8 = (SpecialEffectsController$FragmentStateManagerOperation) obj3;
            CancellationSignal cancellationSignal = new CancellationSignal();
            specialEffectsController$FragmentStateManagerOperation8.onStart();
            HashSet hashSet = specialEffectsController$FragmentStateManagerOperation8.mSpecialEffectsSignals;
            hashSet.add(cancellationSignal);
            AnimationInfo animationInfo5 = new AnimationInfo(specialEffectsController$FragmentStateManagerOperation8, cancellationSignal);
            animationInfo5.mLoadedAnim = false;
            animationInfo5.mIsPop = z7;
            arrayList9.add(animationInfo5);
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            specialEffectsController$FragmentStateManagerOperation8.onStart();
            hashSet.add(cancellationSignal2);
            arrayList10.add(new TransitionInfo(specialEffectsController$FragmentStateManagerOperation8, cancellationSignal2, z7, !z7 ? specialEffectsController$FragmentStateManagerOperation8 != specialEffectsController$FragmentStateManagerOperation6 : specialEffectsController$FragmentStateManagerOperation8 != specialEffectsController$FragmentStateManagerOperation5));
            specialEffectsController$FragmentStateManagerOperation8.mCompletionListeners.add(new AnonymousClass1(this, arrayList11, specialEffectsController$FragmentStateManagerOperation8, b4));
        }
        HashMap map3 = new HashMap();
        int size7 = arrayList10.size();
        int i13 = 0;
        FragmentTransitionCompat21 fragmentTransitionCompat22 = null;
        while (i13 < size7) {
            Object obj4 = arrayList10.get(i13);
            i13++;
            TransitionInfo transitionInfo = (TransitionInfo) obj4;
            boolean zIsVisibilityUnchanged = transitionInfo.isVisibilityUnchanged();
            Fragment fragment4 = transitionInfo.mOperation.mFragment;
            b2 = b2;
            Object obj5 = transitionInfo.mTransition;
            if (!zIsVisibilityUnchanged) {
                FragmentTransitionCompat21 handlingImpl = transitionInfo.getHandlingImpl(obj5);
                Object obj6 = transitionInfo.mSharedElementTransition;
                FragmentTransitionCompat21 handlingImpl2 = transitionInfo.getHandlingImpl(obj6);
                int i14 = size7;
                if (handlingImpl != null && handlingImpl2 != null && handlingImpl != handlingImpl2) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + fragment4 + " returned Transition " + obj5 + " which uses a different Transition  type than its shared element transition " + obj6);
                }
                if (handlingImpl == null) {
                    handlingImpl = handlingImpl2;
                }
                if (fragmentTransitionCompat22 == null) {
                    fragmentTransitionCompat22 = handlingImpl;
                } else if (handlingImpl != null && fragmentTransitionCompat22 != handlingImpl) {
                    DifferentialMotionFlingController$$ExternalSyntheticLambda0.m("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ", fragment4, " returned Transition ", obj5, " which uses a different Transition  type than other Fragments.");
                    return;
                }
                size7 = i14;
                i13 = i13;
            }
        }
        byte b7 = b2;
        ViewGroup viewGroup2 = this.mContainer;
        if (fragmentTransitionCompat22 == null) {
            int size8 = arrayList10.size();
            int i15 = 0;
            while (i15 < size8) {
                Object obj7 = arrayList10.get(i15);
                i15++;
                TransitionInfo transitionInfo2 = (TransitionInfo) obj7;
                map3.put(transitionInfo2.mOperation, Boolean.FALSE);
                transitionInfo2.completeSpecialEffect();
            }
            map = map3;
            arrayList2 = arrayList9;
            specialEffectsController$FragmentStateManagerOperation = specialEffectsController$FragmentStateManagerOperation6;
            arrayList3 = arrayList11;
        } else {
            View view7 = new View(viewGroup2.getContext());
            Rect rect2 = new Rect();
            final ArrayList arrayList12 = new ArrayList();
            ArrayList arrayList13 = new ArrayList();
            ArrayMap arrayMap = new ArrayMap(0);
            int size9 = arrayList10.size();
            arrayList2 = arrayList9;
            boolean z8 = false;
            View view8 = null;
            int i16 = 0;
            TransitionSet transitionSet6 = null;
            while (i16 < size9) {
                Object obj8 = arrayList10.get(i16);
                int i17 = i16 + 1;
                Object obj9 = ((TransitionInfo) obj8).mSharedElementTransition;
                if (obj9 == null || specialEffectsController$FragmentStateManagerOperation5 == null) {
                    Rect rect3 = rect2;
                    map2 = map3;
                    view3 = view7;
                    rect = rect3;
                    arrayList4 = arrayList10;
                    fragmentTransitionCompat21 = fragmentTransitionCompat22;
                    arrayList5 = arrayList13;
                    arrayList11 = arrayList11;
                    i3 = size9;
                    z2 = z8;
                    transitionSet5 = transitionSet6;
                    view4 = view8;
                } else {
                    Fragment fragment5 = specialEffectsController$FragmentStateManagerOperation5.mFragment;
                    if (specialEffectsController$FragmentStateManagerOperation6 != null) {
                        Fragment fragment6 = specialEffectsController$FragmentStateManagerOperation6.mFragment;
                        i3 = size9;
                        Transition transitionClone = ((Transition) obj9).clone();
                        if (transitionClone == null) {
                            transitionSet5 = null;
                        } else {
                            transitionSet5 = new TransitionSet();
                            transitionSet5.addTransition(transitionClone);
                        }
                        ArrayList<String> sharedElementSourceNames = fragment6.getSharedElementSourceNames();
                        arrayList4 = arrayList10;
                        ArrayList<String> sharedElementSourceNames2 = fragment5.getSharedElementSourceNames();
                        HashMap map4 = map3;
                        ArrayList<String> sharedElementTargetNames = fragment5.getSharedElementTargetNames();
                        View view9 = view7;
                        Rect rect4 = rect2;
                        int i18 = 0;
                        while (i18 < sharedElementTargetNames.size()) {
                            int iIndexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i18));
                            ArrayList<String> arrayList14 = sharedElementTargetNames;
                            if (iIndexOf != -1) {
                                sharedElementSourceNames.set(iIndexOf, sharedElementSourceNames2.get(i18));
                            }
                            i18++;
                            sharedElementTargetNames = arrayList14;
                        }
                        ArrayList<String> sharedElementTargetNames2 = fragment6.getSharedElementTargetNames();
                        if (z7) {
                            fragment5.getEnterTransitionCallback();
                            fragment6.getExitTransitionCallback();
                        } else {
                            fragment5.getExitTransitionCallback();
                            fragment6.getEnterTransitionCallback();
                        }
                        int i19 = 0;
                        for (int size10 = sharedElementSourceNames.size(); i19 < size10; size10 = size10) {
                            arrayMap.put(sharedElementSourceNames.get(i19), sharedElementTargetNames2.get(i19));
                            i19++;
                        }
                        if (FragmentManager.isLoggingEnabled(b6)) {
                            int size11 = sharedElementTargetNames2.size();
                            for (int i20 = 0; i20 < size11; i20++) {
                                sharedElementTargetNames2.get(i20);
                            }
                            int size12 = sharedElementSourceNames.size();
                            for (int i21 = 0; i21 < size12; i21++) {
                                sharedElementSourceNames.get(i21);
                            }
                        }
                        ArrayMap arrayMap2 = new ArrayMap(0);
                        findNamedViews(arrayMap2, fragment5.mView);
                        arrayMap2.retainAll(sharedElementSourceNames);
                        arrayMap.retainAll(arrayMap2.keySet());
                        ArrayMap arrayMap3 = new ArrayMap(0);
                        findNamedViews(arrayMap3, fragment6.mView);
                        arrayMap3.retainAll(sharedElementTargetNames2);
                        arrayMap3.retainAll(arrayMap.values());
                        FragmentTransitionCompat21 fragmentTransitionCompat23 = FragmentTransition.PLATFORM_IMPL;
                        int i22 = arrayMap.size - 1;
                        while (i22 >= 0) {
                            Fragment fragment7 = fragment5;
                            if (!arrayMap3.containsKey((String) arrayMap.valueAt(i22))) {
                                arrayMap.removeAt(i22);
                            }
                            i22--;
                            fragment5 = fragment7;
                        }
                        Fragment fragment8 = fragment5;
                        retainMatchingViews(arrayMap2, arrayMap.keySet());
                        retainMatchingViews(arrayMap3, arrayMap.values());
                        if (arrayMap.isEmpty()) {
                            arrayList12.clear();
                            arrayList13.clear();
                            z2 = z8;
                            view4 = view8;
                            fragmentTransitionCompat21 = fragmentTransitionCompat22;
                            arrayList5 = arrayList13;
                            view3 = view9;
                            rect = rect4;
                            map2 = map4;
                            transitionSet5 = null;
                        } else {
                            if (z7) {
                                fragment8.getEnterTransitionCallback();
                            } else {
                                fragment6.getEnterTransitionCallback();
                            }
                            OneShotPreDrawListener.add(viewGroup2, new AnonymousClass6(specialEffectsController$FragmentStateManagerOperation6, specialEffectsController$FragmentStateManagerOperation5, z7, arrayMap3));
                            arrayList12.addAll(arrayMap2.values());
                            if (sharedElementSourceNames.isEmpty()) {
                                view4 = view8;
                            } else {
                                view4 = (View) arrayMap2.get(sharedElementSourceNames.get(0));
                                if (view4 != null) {
                                    Rect rect5 = new Rect();
                                    FragmentTransitionCompat21.getBoundsOnScreen(view4, rect5);
                                    transitionSet5.setEpicenterCallback(new Transition.EpicenterCallback() { // from class: androidx.fragment.app.FragmentTransitionCompat21.1
                                        public final /* synthetic */ byte $r8$classId;
                                        public final /* synthetic */ Rect val$epicenter;

                                        public /* synthetic */ AnonymousClass1() {
                                            b = b;
                                            rect = rect5;
                                        }

                                        @Override // android.transition.Transition.EpicenterCallback
                                        public final Rect onGetEpicenter(Transition transition) {
                                            byte b8 = b;
                                            Rect rect6 = rect;
                                            switch (b8) {
                                                case 0:
                                                    return rect6;
                                                default:
                                                    if (rect6.isEmpty()) {
                                                        return null;
                                                    }
                                                    return rect6;
                                            }
                                        }
                                    });
                                }
                            }
                            arrayList13.addAll(arrayMap3.values());
                            if (sharedElementTargetNames2.isEmpty() || (view5 = (View) arrayMap3.get(sharedElementTargetNames2.get(0))) == null) {
                                rect = rect4;
                                z3 = z8;
                            } else {
                                rect = rect4;
                                OneShotPreDrawListener.add(viewGroup2, new AnonymousClass1(fragmentTransitionCompat22, view5, rect, b7));
                                z3 = true;
                            }
                            List<View> targets = transitionSet5.getTargets();
                            targets.clear();
                            int size13 = arrayList12.size();
                            int i23 = 0;
                            while (i23 < size13) {
                                View view10 = (View) arrayList12.get(i23);
                                boolean z9 = z3;
                                int size14 = targets.size();
                                int i24 = 0;
                                while (true) {
                                    if (i24 >= size14) {
                                        i4 = size13;
                                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                                        if (view10.getTransitionName() != null) {
                                            targets.add(view10);
                                        }
                                        int i25 = size14;
                                        while (i25 < targets.size()) {
                                            View view11 = targets.get(i25);
                                            if (view11 instanceof ViewGroup) {
                                                ViewGroup viewGroup3 = (ViewGroup) view11;
                                                int childCount = viewGroup3.getChildCount();
                                                int i26 = 0;
                                                while (i26 < childCount) {
                                                    int i27 = i23;
                                                    View childAt = viewGroup3.getChildAt(i26);
                                                    int i28 = i26;
                                                    int i29 = 0;
                                                    while (true) {
                                                        if (i29 >= size14) {
                                                            i5 = size14;
                                                            if (childAt.getTransitionName() == null) {
                                                                break;
                                                            }
                                                            targets.add(childAt);
                                                            break;
                                                        }
                                                        i5 = size14;
                                                        if (targets.get(i29) == childAt) {
                                                            break;
                                                        }
                                                        i29++;
                                                        size14 = i5;
                                                    }
                                                    i26 = i28 + 1;
                                                    i23 = i27;
                                                    size14 = i5;
                                                }
                                            }
                                            i25++;
                                            i23 = i23;
                                            size14 = size14;
                                        }
                                        break;
                                    }
                                    i4 = size13;
                                    if (targets.get(i24) == view10) {
                                        break;
                                    }
                                    i24++;
                                    size13 = i4;
                                }
                                i23++;
                                z3 = z9;
                                size13 = i4;
                            }
                            boolean z10 = z3;
                            view3 = view9;
                            targets.add(view3);
                            arrayList12.add(view3);
                            FragmentTransitionCompat21.addTargets(transitionSet5, arrayList12);
                            fragmentTransitionCompat21 = fragmentTransitionCompat22;
                            ArrayList arrayList15 = arrayList13;
                            arrayList5 = arrayList15;
                            transitionSet5.addListener((Transition.TransitionListener) new Transition.TransitionListener(fragmentTransitionCompat21, null, null, transitionSet5, arrayList15) { // from class: androidx.fragment.app.FragmentTransitionCompat21.3
                                public final /* synthetic */ Object val$enterTransition;
                                public final /* synthetic */ ArrayList val$enteringViews;
                                public final /* synthetic */ Object val$sharedElementTransition;
                                public final /* synthetic */ ArrayList val$sharedElementsIn;

                                public AnonymousClass3(FragmentTransitionCompat21 fragmentTransitionCompat24, Object obj10, ArrayList arrayList16, Object transitionSet7, ArrayList arrayList17) {
                                    this.val$enterTransition = obj10;
                                    this.val$enteringViews = arrayList16;
                                    this.val$sharedElementTransition = transitionSet7;
                                    this.val$sharedElementsIn = arrayList17;
                                }

                                @Override // android.transition.Transition.TransitionListener
                                public final void onTransitionEnd(Transition transition) {
                                    transition.removeListener(this);
                                }

                                @Override // android.transition.Transition.TransitionListener
                                public final void onTransitionStart(Transition transition) {
                                    Object obj10 = this.val$enterTransition;
                                    if (obj10 != null) {
                                        FragmentTransitionCompat21.replaceTargets(obj10, this.val$enteringViews, null);
                                    }
                                    Object obj11 = this.val$sharedElementTransition;
                                    if (obj11 != null) {
                                        FragmentTransitionCompat21.replaceTargets(obj11, this.val$sharedElementsIn, null);
                                    }
                                }

                                @Override // android.transition.Transition.TransitionListener
                                public final void onTransitionCancel(Transition transition) {
                                }

                                @Override // android.transition.Transition.TransitionListener
                                public final void onTransitionPause(Transition transition) {
                                }

                                @Override // android.transition.Transition.TransitionListener
                                public final void onTransitionResume(Transition transition) {
                                }
                            });
                            Boolean bool = Boolean.TRUE;
                            map2 = map4;
                            map2.put(specialEffectsController$FragmentStateManagerOperation5, bool);
                            map2.put(specialEffectsController$FragmentStateManagerOperation6, bool);
                            z2 = z10;
                        }
                    } else {
                        Rect rect6 = rect2;
                        map2 = map3;
                        view3 = view7;
                        rect = rect6;
                        arrayList4 = arrayList10;
                        fragmentTransitionCompat24 = fragmentTransitionCompat22;
                        arrayList5 = arrayList13;
                        arrayList11 = arrayList11;
                        i3 = size9;
                        z2 = z8;
                        transitionSet7 = transitionSet6;
                        view4 = view8;
                    }
                }
                Rect rect7 = rect;
                view7 = view3;
                map3 = map2;
                rect2 = rect7;
                arrayList13 = arrayList5;
                z8 = z2;
                view8 = view4;
                fragmentTransitionCompat22 = fragmentTransitionCompat24;
                i16 = i17;
                size9 = i3;
                arrayList10 = arrayList4;
                b7 = 1;
                z7 = z;
                transitionSet6 = transitionSet7;
                arrayList11 = arrayList11;
            }
            Rect rect8 = rect2;
            map = map3;
            View view12 = view7;
            ArrayList arrayList16 = arrayList10;
            FragmentTransitionCompat21 fragmentTransitionCompat24 = fragmentTransitionCompat22;
            final ArrayList arrayList17 = arrayList13;
            arrayList3 = arrayList11;
            ArrayList arrayList18 = new ArrayList();
            int size15 = arrayList16.size();
            TransitionSet transitionSet7 = null;
            TransitionSet transitionSet8 = null;
            int i30 = 0;
            while (i30 < size15) {
                ArrayList arrayList19 = arrayList16;
                size15 = size15;
                TransitionInfo transitionInfo3 = (TransitionInfo) arrayList19.get(i30);
                boolean zIsVisibilityUnchanged2 = transitionInfo3.isVisibilityUnchanged();
                i30++;
                SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation9 = transitionInfo3.mOperation;
                if (zIsVisibilityUnchanged2) {
                    map.put(specialEffectsController$FragmentStateManagerOperation9, Boolean.FALSE);
                    transitionInfo3.completeSpecialEffect();
                    arrayList16 = arrayList19;
                    arrayMap = arrayMap;
                } else {
                    ArrayMap arrayMap4 = arrayMap;
                    Object obj10 = transitionInfo3.mTransition;
                    Transition transitionClone2 = obj10 != null ? ((Transition) obj10).clone() : null;
                    boolean z11 = transitionSet6 != null && (specialEffectsController$FragmentStateManagerOperation9 == specialEffectsController$FragmentStateManagerOperation5 || specialEffectsController$FragmentStateManagerOperation9 == specialEffectsController$FragmentStateManagerOperation6);
                    if (transitionClone2 == null) {
                        if (!z11) {
                            map.put(specialEffectsController$FragmentStateManagerOperation9, Boolean.FALSE);
                            transitionInfo3.completeSpecialEffect();
                        }
                        view = view12;
                        specialEffectsController$FragmentStateManagerOperation2 = specialEffectsController$FragmentStateManagerOperation6;
                        arrayList16 = arrayList19;
                        transitionSet2 = transitionSet6;
                        view2 = view8;
                    } else {
                        specialEffectsController$FragmentStateManagerOperation2 = specialEffectsController$FragmentStateManagerOperation6;
                        ArrayList arrayList20 = new ArrayList();
                        arrayList16 = arrayList19;
                        Fragment fragment9 = specialEffectsController$FragmentStateManagerOperation9.mFragment;
                        transitionSet2 = transitionSet6;
                        captureTransitioningViews(fragment9.mView, arrayList20);
                        if (z11) {
                            if (specialEffectsController$FragmentStateManagerOperation9 == specialEffectsController$FragmentStateManagerOperation5) {
                                arrayList20.removeAll(arrayList12);
                            } else {
                                arrayList20.removeAll(arrayList17);
                            }
                        }
                        if (arrayList20.isEmpty()) {
                            transitionClone2.addTarget(view12);
                            view = view12;
                        } else {
                            FragmentTransitionCompat21.addTargets(transitionClone2, arrayList20);
                            transitionClone2.addListener(new Transition.TransitionListener(fragmentTransitionCompat24, transitionClone2, arrayList20, null, null) { // from class: androidx.fragment.app.FragmentTransitionCompat21.3
                                public final /* synthetic */ Object val$enterTransition;
                                public final /* synthetic */ ArrayList val$enteringViews;
                                public final /* synthetic */ Object val$sharedElementTransition;
                                public final /* synthetic */ ArrayList val$sharedElementsIn;

                                public AnonymousClass3(FragmentTransitionCompat21 fragmentTransitionCompat25, Object transitionClone3, ArrayList arrayList21, Object transitionSet9, ArrayList arrayList110) {
                                    this.val$enterTransition = transitionClone3;
                                    this.val$enteringViews = arrayList21;
                                    this.val$sharedElementTransition = transitionSet9;
                                    this.val$sharedElementsIn = arrayList110;
                                }

                                @Override // android.transition.Transition.TransitionListener
                                public final void onTransitionEnd(Transition transition) {
                                    transition.removeListener(this);
                                }

                                @Override // android.transition.Transition.TransitionListener
                                public final void onTransitionStart(Transition transition) {
                                    Object obj11 = this.val$enterTransition;
                                    if (obj11 != null) {
                                        FragmentTransitionCompat21.replaceTargets(obj11, this.val$enteringViews, null);
                                    }
                                    Object obj12 = this.val$sharedElementTransition;
                                    if (obj12 != null) {
                                        FragmentTransitionCompat21.replaceTargets(obj12, this.val$sharedElementsIn, null);
                                    }
                                }

                                @Override // android.transition.Transition.TransitionListener
                                public final void onTransitionCancel(Transition transition) {
                                }

                                @Override // android.transition.Transition.TransitionListener
                                public final void onTransitionPause(Transition transition) {
                                }

                                @Override // android.transition.Transition.TransitionListener
                                public final void onTransitionResume(Transition transition) {
                                }
                            });
                            view = view12;
                            if (specialEffectsController$FragmentStateManagerOperation9.mFinalState == 3) {
                                arrayList3.remove(specialEffectsController$FragmentStateManagerOperation9);
                                ArrayList arrayList21 = new ArrayList(arrayList21);
                                arrayList21.remove(fragment9.mView);
                                transitionClone3.addListener(new Transition.TransitionListener() { // from class: androidx.fragment.app.FragmentTransitionCompat21.2
                                    public final /* synthetic */ ArrayList val$exitingViews;
                                    public final /* synthetic */ View val$fragmentView;

                                    public AnonymousClass2() {
                                        view = view;
                                        arrayList = arrayList21;
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionEnd(Transition transition) {
                                        transition.removeListener(this);
                                        view.setVisibility(8);
                                        ArrayList arrayList22 = arrayList;
                                        int size16 = arrayList22.size();
                                        for (int i31 = 0; i31 < size16; i31++) {
                                            ((View) arrayList22.get(i31)).setVisibility(0);
                                        }
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionStart(Transition transition) {
                                        transition.removeListener(this);
                                        transition.addListener(this);
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionCancel(Transition transition) {
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionPause(Transition transition) {
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionResume(Transition transition) {
                                    }
                                });
                                b3 = b6;
                                OneShotPreDrawListener.add(viewGroup2, new Fragment.AnonymousClass1(b3, arrayList21));
                            }
                            if (specialEffectsController$FragmentStateManagerOperation9.mFinalState == b3) {
                                arrayList18.addAll(arrayList21);
                                if (z8) {
                                    transitionClone3.setEpicenterCallback(new Transition.EpicenterCallback() { // from class: androidx.fragment.app.FragmentTransitionCompat21.1
                                        public final /* synthetic */ byte $r8$classId;
                                        public final /* synthetic */ Rect val$epicenter;

                                        public /* synthetic */ AnonymousClass1() {
                                            b = b;
                                            rect = rect8;
                                        }

                                        @Override // android.transition.Transition.EpicenterCallback
                                        public final Rect onGetEpicenter(Transition transition) {
                                            byte b8 = b;
                                            Rect rect9 = rect;
                                            switch (b8) {
                                                case 0:
                                                    return rect9;
                                                default:
                                                    if (rect9.isEmpty()) {
                                                        return null;
                                                    }
                                                    return rect9;
                                            }
                                        }
                                    });
                                }
                            } else {
                                if (view8 != null) {
                                    Rect rect9 = new Rect();
                                    view2 = view8;
                                    FragmentTransitionCompat21.getBoundsOnScreen(view2, rect9);
                                    transitionClone3.setEpicenterCallback(new Transition.EpicenterCallback() { // from class: androidx.fragment.app.FragmentTransitionCompat21.1
                                        public final /* synthetic */ byte $r8$classId;
                                        public final /* synthetic */ Rect val$epicenter;

                                        public /* synthetic */ AnonymousClass1() {
                                            b = b;
                                            rect = rect9;
                                        }

                                        @Override // android.transition.Transition.EpicenterCallback
                                        public final Rect onGetEpicenter(Transition transition) {
                                            byte b8 = b;
                                            Rect rect10 = rect;
                                            switch (b8) {
                                                case 0:
                                                    return rect10;
                                                default:
                                                    if (rect10.isEmpty()) {
                                                        return null;
                                                    }
                                                    return rect10;
                                            }
                                        }
                                    });
                                }
                                map.put(specialEffectsController$FragmentStateManagerOperation9, Boolean.TRUE);
                                if (transitionInfo3.mOverlapAllowed) {
                                    transitionSet4 = new TransitionSet();
                                    if (transitionSet7 != null) {
                                        transitionSet4.addTransition(transitionSet7);
                                    }
                                    transitionSet4.addTransition(transitionClone3);
                                    transitionSet7 = transitionSet4;
                                } else {
                                    transitionSet3 = new TransitionSet();
                                    if (transitionSet8 != null) {
                                        transitionSet3.addTransition(transitionSet8);
                                    }
                                    transitionSet3.addTransition(transitionClone3);
                                    transitionSet8 = transitionSet3;
                                }
                            }
                            view2 = view8;
                            map.put(specialEffectsController$FragmentStateManagerOperation9, Boolean.TRUE);
                            if (transitionInfo3.mOverlapAllowed) {
                                transitionSet4 = new TransitionSet();
                                if (transitionSet7 != null) {
                                    transitionSet4.addTransition(transitionSet7);
                                }
                                transitionSet4.addTransition(transitionClone3);
                                transitionSet7 = transitionSet4;
                            } else {
                                transitionSet3 = new TransitionSet();
                                if (transitionSet8 != null) {
                                    transitionSet3.addTransition(transitionSet8);
                                }
                                transitionSet3.addTransition(transitionClone3);
                                transitionSet8 = transitionSet3;
                            }
                        }
                        b3 = b6;
                        if (specialEffectsController$FragmentStateManagerOperation9.mFinalState == b3) {
                            arrayList18.addAll(arrayList21);
                            if (z8) {
                                transitionClone3.setEpicenterCallback(new Transition.EpicenterCallback() { // from class: androidx.fragment.app.FragmentTransitionCompat21.1
                                    public final /* synthetic */ byte $r8$classId;
                                    public final /* synthetic */ Rect val$epicenter;

                                    public /* synthetic */ AnonymousClass1() {
                                        b = b;
                                        rect = rect8;
                                    }

                                    @Override // android.transition.Transition.EpicenterCallback
                                    public final Rect onGetEpicenter(Transition transition) {
                                        byte b8 = b;
                                        Rect rect10 = rect;
                                        switch (b8) {
                                            case 0:
                                                return rect10;
                                            default:
                                                if (rect10.isEmpty()) {
                                                    return null;
                                                }
                                                return rect10;
                                        }
                                    }
                                });
                            }
                        } else {
                            if (view8 != null) {
                                Rect rect10 = new Rect();
                                view2 = view8;
                                FragmentTransitionCompat21.getBoundsOnScreen(view2, rect10);
                                transitionClone3.setEpicenterCallback(new Transition.EpicenterCallback() { // from class: androidx.fragment.app.FragmentTransitionCompat21.1
                                    public final /* synthetic */ byte $r8$classId;
                                    public final /* synthetic */ Rect val$epicenter;

                                    public /* synthetic */ AnonymousClass1() {
                                        b = b;
                                        rect = rect10;
                                    }

                                    @Override // android.transition.Transition.EpicenterCallback
                                    public final Rect onGetEpicenter(Transition transition) {
                                        byte b8 = b;
                                        Rect rect11 = rect;
                                        switch (b8) {
                                            case 0:
                                                return rect11;
                                            default:
                                                if (rect11.isEmpty()) {
                                                    return null;
                                                }
                                                return rect11;
                                        }
                                    }
                                });
                            }
                            map.put(specialEffectsController$FragmentStateManagerOperation9, Boolean.TRUE);
                            if (transitionInfo3.mOverlapAllowed) {
                                transitionSet4 = new TransitionSet();
                                if (transitionSet7 != null) {
                                    transitionSet4.addTransition(transitionSet7);
                                }
                                transitionSet4.addTransition(transitionClone3);
                                transitionSet7 = transitionSet4;
                            } else {
                                transitionSet3 = new TransitionSet();
                                if (transitionSet8 != null) {
                                    transitionSet3.addTransition(transitionSet8);
                                }
                                transitionSet3.addTransition(transitionClone3);
                                transitionSet8 = transitionSet3;
                            }
                        }
                        view2 = view8;
                        map.put(specialEffectsController$FragmentStateManagerOperation9, Boolean.TRUE);
                        if (transitionInfo3.mOverlapAllowed) {
                            transitionSet4 = new TransitionSet();
                            if (transitionSet7 != null) {
                                transitionSet4.addTransition(transitionSet7);
                            }
                            transitionSet4.addTransition(transitionClone3);
                            transitionSet7 = transitionSet4;
                        } else {
                            transitionSet3 = new TransitionSet();
                            if (transitionSet8 != null) {
                                transitionSet3.addTransition(transitionSet8);
                            }
                            transitionSet3.addTransition(transitionClone3);
                            transitionSet8 = transitionSet3;
                        }
                    }
                    view8 = view2;
                    view12 = view;
                    arrayMap = arrayMap4;
                    transitionSet6 = transitionSet2;
                    specialEffectsController$FragmentStateManagerOperation6 = specialEffectsController$FragmentStateManagerOperation2;
                    b6 = 2;
                }
            }
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation10 = specialEffectsController$FragmentStateManagerOperation6;
            SimpleArrayMap simpleArrayMap2 = arrayMap;
            TransitionSet transitionSet9 = transitionSet6;
            if (transitionSet7 != null && transitionSet8 != null) {
                ordering = new TransitionSet().addTransition(transitionSet7).addTransition(transitionSet8).setOrdering(1);
            } else if (transitionSet7 != null) {
                ordering = transitionSet7;
            } else {
                ordering = transitionSet8 != null ? transitionSet8 : null;
            }
            if (transitionSet9 != null) {
                TransitionSet transitionSet10 = new TransitionSet();
                if (ordering != null) {
                    transitionSet10.addTransition(ordering);
                }
                transitionSet = transitionSet9;
                transitionSet10.addTransition(transitionSet);
                ordering = transitionSet10;
            } else {
                transitionSet = transitionSet9;
            }
            if (ordering != null) {
                int size16 = arrayList16.size();
                int i31 = 0;
                while (i31 < size16) {
                    arrayList16 = arrayList16;
                    Object obj11 = arrayList16.get(i31);
                    i31++;
                    TransitionInfo transitionInfo4 = (TransitionInfo) obj11;
                    boolean zIsVisibilityUnchanged3 = transitionInfo4.isVisibilityUnchanged();
                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation11 = transitionInfo4.mOperation;
                    if (!zIsVisibilityUnchanged3) {
                        Object obj12 = transitionInfo4.mTransition;
                        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation12 = specialEffectsController$FragmentStateManagerOperation10;
                        boolean z12 = transitionSet != null && (specialEffectsController$FragmentStateManagerOperation11 == specialEffectsController$FragmentStateManagerOperation5 || specialEffectsController$FragmentStateManagerOperation11 == specialEffectsController$FragmentStateManagerOperation12);
                        if (obj12 != null || z12) {
                            WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                            if (viewGroup2.isLaidOut()) {
                                ordering.addListener((Transition.TransitionListener) new Transition.TransitionListener() { // from class: androidx.fragment.app.FragmentTransitionCompat21.4
                                    public AnonymousClass4() {
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionEnd(Transition transition) {
                                        anonymousClass1.run();
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionCancel(Transition transition) {
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionPause(Transition transition) {
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionResume(Transition transition) {
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionStart(Transition transition) {
                                    }
                                });
                            } else {
                                if (FragmentManager.isLoggingEnabled(2)) {
                                    Objects.toString(viewGroup2);
                                    Objects.toString(specialEffectsController$FragmentStateManagerOperation11);
                                }
                                transitionInfo4.completeSpecialEffect();
                            }
                        }
                        specialEffectsController$FragmentStateManagerOperation10 = specialEffectsController$FragmentStateManagerOperation12;
                    }
                }
                specialEffectsController$FragmentStateManagerOperation = specialEffectsController$FragmentStateManagerOperation10;
                WeakHashMap weakHashMap3 = ViewCompat.sViewPropertyAnimatorMap;
                if (viewGroup2.isLaidOut()) {
                    FragmentTransition.setViewVisibility(4, arrayList18);
                    final ArrayList arrayList22 = new ArrayList();
                    int size17 = arrayList17.size();
                    for (int i32 = 0; i32 < size17; i32++) {
                        View view13 = (View) arrayList17.get(i32);
                        WeakHashMap weakHashMap4 = ViewCompat.sViewPropertyAnimatorMap;
                        arrayList22.add(view13.getTransitionName());
                        view13.setTransitionName(null);
                    }
                    if (FragmentManager.isLoggingEnabled(2)) {
                        int size18 = arrayList12.size();
                        int i33 = 0;
                        while (i33 < size18) {
                            Object obj13 = arrayList12.get(i33);
                            i33++;
                            View view14 = (View) obj13;
                            Objects.toString(view14);
                            view14.getTransitionName();
                        }
                        int size19 = arrayList17.size();
                        int i34 = 0;
                        while (i34 < size19) {
                            Object obj14 = arrayList17.get(i34);
                            i34++;
                            View view15 = (View) obj14;
                            Objects.toString(view15);
                            view15.getTransitionName();
                        }
                    }
                    TransitionManager.beginDelayedTransition(viewGroup2, ordering);
                    int size20 = arrayList17.size();
                    final ArrayList arrayList23 = new ArrayList();
                    int i35 = 0;
                    while (i35 < size20) {
                        View view16 = (View) arrayList12.get(i35);
                        WeakHashMap weakHashMap5 = ViewCompat.sViewPropertyAnimatorMap;
                        String transitionName = view16.getTransitionName();
                        arrayList23.add(transitionName);
                        if (transitionName == null) {
                            i2 = size20;
                            simpleArrayMap = simpleArrayMap2;
                        } else {
                            view16.setTransitionName(null);
                            simpleArrayMap = simpleArrayMap2;
                            String str = (String) simpleArrayMap.get(transitionName);
                            int i36 = 0;
                            while (true) {
                                i2 = size20;
                                if (i36 >= size20) {
                                    break;
                                }
                                if (str.equals(arrayList22.get(i36))) {
                                    ((View) arrayList17.get(i36)).setTransitionName(transitionName);
                                    break;
                                } else {
                                    i36++;
                                    size20 = i2;
                                }
                            }
                        }
                        i35++;
                        simpleArrayMap2 = simpleArrayMap;
                        size20 = i2;
                    }
                    final int i37 = size20;
                    OneShotPreDrawListener.add(viewGroup2, new Runnable() { // from class: androidx.fragment.app.FragmentTransitionImpl$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            for (int i38 = 0; i38 < i37; i38++) {
                                View view17 = (View) arrayList17.get(i38);
                                String str2 = (String) arrayList22.get(i38);
                                WeakHashMap weakHashMap6 = ViewCompat.sViewPropertyAnimatorMap;
                                view17.setTransitionName(str2);
                                ((View) arrayList12.get(i38)).setTransitionName((String) arrayList23.get(i38));
                            }
                        }
                    });
                    i = 0;
                    FragmentTransition.setViewVisibility(0, arrayList18);
                    if (transitionSet != null) {
                        transitionSet.getTargets().clear();
                        transitionSet.getTargets().addAll(arrayList17);
                        FragmentTransitionCompat21.replaceTargets(transitionSet, arrayList12, arrayList17);
                    }
                }
                zContainsValue = map.containsValue(Boolean.TRUE);
                context = viewGroup2.getContext();
                arrayList6 = new ArrayList();
                size = arrayList2.size();
                i6 = i;
                i7 = i6;
                while (i7 < size) {
                    arrayList2 = arrayList2;
                    Object obj15 = arrayList2.get(i7);
                    i7++;
                    animationInfo2 = (AnimationInfo) obj15;
                    if (animationInfo2.isVisibilityUnchanged()) {
                        animationInfo2.completeSpecialEffect();
                    } else {
                        animation2 = animationInfo2.getAnimation(context);
                        if (animation2 == null) {
                            animationInfo2.completeSpecialEffect();
                        } else {
                            animator = (Animator) animation2.animator;
                            if (animator == null) {
                                arrayList6.add(animationInfo2);
                            } else {
                                specialEffectsController$FragmentStateManagerOperation4 = animationInfo2.mOperation;
                                fragment2 = specialEffectsController$FragmentStateManagerOperation4.mFragment;
                                z5 = zContainsValue;
                                if (Boolean.TRUE.equals(map.get(specialEffectsController$FragmentStateManagerOperation4))) {
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Objects.toString(fragment2);
                                    }
                                    animationInfo2.completeSpecialEffect();
                                    zContainsValue = z5;
                                } else {
                                    if (specialEffectsController$FragmentStateManagerOperation4.mFinalState == 3) {
                                        z6 = true;
                                    } else {
                                        z6 = false;
                                    }
                                    arrayList8 = arrayList3;
                                    if (z6) {
                                        arrayList8.remove(specialEffectsController$FragmentStateManagerOperation4);
                                    }
                                    final View view17 = fragment2.mView;
                                    viewGroup2.startViewTransition(view17);
                                    final ViewGroup viewGroup4 = viewGroup2;
                                    animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.2
                                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                        public final void onAnimationEnd(Animator animator2) {
                                            ViewGroup viewGroup5 = viewGroup4;
                                            View view18 = view17;
                                            viewGroup5.endViewTransition(view18);
                                            boolean z13 = z6;
                                            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation13 = specialEffectsController$FragmentStateManagerOperation4;
                                            if (z13) {
                                                Fragment$5$$ExternalSyntheticOutline0._applyState(view18, specialEffectsController$FragmentStateManagerOperation13.mFinalState);
                                            }
                                            animationInfo2.completeSpecialEffect();
                                            if (FragmentManager.isLoggingEnabled(2)) {
                                                Objects.toString(specialEffectsController$FragmentStateManagerOperation13);
                                            }
                                        }
                                    });
                                    animator.setTarget(view17);
                                    animator.start();
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        specialEffectsController$FragmentStateManagerOperation4.toString();
                                    }
                                    animationInfo2.mSignal.setOnCancelListener(new FragmentAnim$AnimationOrAnimator(animator, specialEffectsController$FragmentStateManagerOperation4));
                                    arrayList3 = arrayList8;
                                    viewGroup2 = viewGroup4;
                                    i6 = 1;
                                    zContainsValue = z5;
                                }
                            }
                        }
                    }
                    z5 = zContainsValue;
                    zContainsValue = z5;
                }
                viewGroup = viewGroup2;
                z4 = zContainsValue;
                arrayList7 = arrayList3;
                size2 = arrayList6.size();
                i8 = 0;
                while (i8 < size2) {
                    Object obj16 = arrayList6.get(i8);
                    i8++;
                    animationInfo = (AnimationInfo) obj16;
                    specialEffectsController$FragmentStateManagerOperation3 = animationInfo.mOperation;
                    fragment = specialEffectsController$FragmentStateManagerOperation3.mFragment;
                    if (z4) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Objects.toString(fragment);
                        }
                        animationInfo.completeSpecialEffect();
                    } else if (i6 != 0) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Objects.toString(fragment);
                        }
                        animationInfo.completeSpecialEffect();
                    } else {
                        view6 = fragment.mView;
                        FragmentAnim$AnimationOrAnimator animation3 = animationInfo.getAnimation(context);
                        animation3.getClass();
                        animation = (Animation) animation3.animation;
                        animation.getClass();
                        if (specialEffectsController$FragmentStateManagerOperation3.mFinalState != 1) {
                            view6.startAnimation(animation);
                            animationInfo.completeSpecialEffect();
                        } else {
                            viewGroup.startViewTransition(view6);
                            FragmentAnim$EndViewTransitionAnimation fragmentAnim$EndViewTransitionAnimation = new FragmentAnim$EndViewTransitionAnimation(animation, viewGroup, view6);
                            fragmentAnim$EndViewTransitionAnimation.setAnimationListener(new AnonymousClass4(view6, viewGroup, animationInfo, specialEffectsController$FragmentStateManagerOperation3));
                            view6.startAnimation(fragmentAnim$EndViewTransitionAnimation);
                            if (FragmentManager.isLoggingEnabled(2)) {
                                specialEffectsController$FragmentStateManagerOperation3.toString();
                            }
                        }
                        animationInfo.mSignal.setOnCancelListener(new FragmentStore(view6, viewGroup, animationInfo, specialEffectsController$FragmentStateManagerOperation3));
                    }
                }
                size3 = arrayList7.size();
                i9 = 0;
                while (i9 < size3) {
                    Object obj17 = arrayList7.get(i9);
                    i9++;
                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation13 = (SpecialEffectsController$FragmentStateManagerOperation) obj17;
                    Fragment$5$$ExternalSyntheticOutline0._applyState(specialEffectsController$FragmentStateManagerOperation13.mFragment.mView, specialEffectsController$FragmentStateManagerOperation13.mFinalState);
                }
                arrayList7.clear();
                if (FragmentManager.isLoggingEnabled(2)) {
                    Objects.toString(specialEffectsController$FragmentStateManagerOperation5);
                    Objects.toString(specialEffectsController$FragmentStateManagerOperation);
                }
            }
            specialEffectsController$FragmentStateManagerOperation = specialEffectsController$FragmentStateManagerOperation10;
        }
        i = 0;
        zContainsValue = map.containsValue(Boolean.TRUE);
        context = viewGroup2.getContext();
        arrayList6 = new ArrayList();
        size = arrayList2.size();
        i6 = i;
        i7 = i6;
        while (i7 < size) {
            arrayList2 = arrayList2;
            Object obj18 = arrayList2.get(i7);
            i7++;
            animationInfo2 = (AnimationInfo) obj18;
            if (animationInfo2.isVisibilityUnchanged()) {
                animationInfo2.completeSpecialEffect();
            } else {
                animation2 = animationInfo2.getAnimation(context);
                if (animation2 == null) {
                    animationInfo2.completeSpecialEffect();
                } else {
                    animator = (Animator) animation2.animator;
                    if (animator == null) {
                        arrayList6.add(animationInfo2);
                    } else {
                        specialEffectsController$FragmentStateManagerOperation4 = animationInfo2.mOperation;
                        fragment2 = specialEffectsController$FragmentStateManagerOperation4.mFragment;
                        z5 = zContainsValue;
                        if (Boolean.TRUE.equals(map.get(specialEffectsController$FragmentStateManagerOperation4))) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Objects.toString(fragment2);
                            }
                            animationInfo2.completeSpecialEffect();
                            zContainsValue = z5;
                        } else {
                            if (specialEffectsController$FragmentStateManagerOperation4.mFinalState == 3) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            arrayList8 = arrayList3;
                            if (z6) {
                                arrayList8.remove(specialEffectsController$FragmentStateManagerOperation4);
                            }
                            final View view18 = fragment2.mView;
                            viewGroup2.startViewTransition(view18);
                            final ViewGroup viewGroup5 = viewGroup2;
                            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.2
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public final void onAnimationEnd(Animator animator2) {
                                    ViewGroup viewGroup6 = viewGroup5;
                                    View view19 = view18;
                                    viewGroup6.endViewTransition(view19);
                                    boolean z13 = z6;
                                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation14 = specialEffectsController$FragmentStateManagerOperation4;
                                    if (z13) {
                                        Fragment$5$$ExternalSyntheticOutline0._applyState(view19, specialEffectsController$FragmentStateManagerOperation14.mFinalState);
                                    }
                                    animationInfo2.completeSpecialEffect();
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Objects.toString(specialEffectsController$FragmentStateManagerOperation14);
                                    }
                                }
                            });
                            animator.setTarget(view18);
                            animator.start();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                specialEffectsController$FragmentStateManagerOperation4.toString();
                            }
                            animationInfo2.mSignal.setOnCancelListener(new FragmentAnim$AnimationOrAnimator(animator, specialEffectsController$FragmentStateManagerOperation4));
                            arrayList3 = arrayList8;
                            viewGroup2 = viewGroup5;
                            i6 = 1;
                            zContainsValue = z5;
                        }
                    }
                }
            }
            z5 = zContainsValue;
            zContainsValue = z5;
        }
        viewGroup = viewGroup2;
        z4 = zContainsValue;
        arrayList7 = arrayList3;
        size2 = arrayList6.size();
        i8 = 0;
        while (i8 < size2) {
            Object obj19 = arrayList6.get(i8);
            i8++;
            animationInfo = (AnimationInfo) obj19;
            specialEffectsController$FragmentStateManagerOperation3 = animationInfo.mOperation;
            fragment = specialEffectsController$FragmentStateManagerOperation3.mFragment;
            if (z4) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Objects.toString(fragment);
                }
                animationInfo.completeSpecialEffect();
            } else if (i6 != 0) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Objects.toString(fragment);
                }
                animationInfo.completeSpecialEffect();
            } else {
                view6 = fragment.mView;
                FragmentAnim$AnimationOrAnimator animation4 = animationInfo.getAnimation(context);
                animation4.getClass();
                animation = (Animation) animation4.animation;
                animation.getClass();
                if (specialEffectsController$FragmentStateManagerOperation3.mFinalState != 1) {
                    view6.startAnimation(animation);
                    animationInfo.completeSpecialEffect();
                } else {
                    viewGroup.startViewTransition(view6);
                    FragmentAnim$EndViewTransitionAnimation fragmentAnim$EndViewTransitionAnimation2 = new FragmentAnim$EndViewTransitionAnimation(animation, viewGroup, view6);
                    fragmentAnim$EndViewTransitionAnimation2.setAnimationListener(new AnonymousClass4(view6, viewGroup, animationInfo, specialEffectsController$FragmentStateManagerOperation3));
                    view6.startAnimation(fragmentAnim$EndViewTransitionAnimation2);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        specialEffectsController$FragmentStateManagerOperation3.toString();
                    }
                }
                animationInfo.mSignal.setOnCancelListener(new FragmentStore(view6, viewGroup, animationInfo, specialEffectsController$FragmentStateManagerOperation3));
            }
        }
        size3 = arrayList7.size();
        i9 = 0;
        while (i9 < size3) {
            Object obj110 = arrayList7.get(i9);
            i9++;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation14 = (SpecialEffectsController$FragmentStateManagerOperation) obj110;
            Fragment$5$$ExternalSyntheticOutline0._applyState(specialEffectsController$FragmentStateManagerOperation14.mFragment.mView, specialEffectsController$FragmentStateManagerOperation14.mFinalState);
        }
        arrayList7.clear();
        if (FragmentManager.isLoggingEnabled(2)) {
            Objects.toString(specialEffectsController$FragmentStateManagerOperation5);
            Objects.toString(specialEffectsController$FragmentStateManagerOperation);
        }
    }

    public final void executePendingOperations() {
        if (this.mIsContainerPostponed) {
            return;
        }
        ViewGroup viewGroup = this.mContainer;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (!viewGroup.isAttachedToWindow()) {
            forceCompleteAllOperations();
            this.mOperationDirectionIsPop = false;
            return;
        }
        synchronized (this.mPendingOperations) {
            try {
                if (!this.mPendingOperations.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.mRunningOperations);
                    this.mRunningOperations.clear();
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) obj;
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Objects.toString(specialEffectsController$FragmentStateManagerOperation);
                        }
                        specialEffectsController$FragmentStateManagerOperation.cancel();
                        if (!specialEffectsController$FragmentStateManagerOperation.mIsComplete) {
                            this.mRunningOperations.add(specialEffectsController$FragmentStateManagerOperation);
                        }
                    }
                    updateFinalState();
                    ArrayList arrayList2 = new ArrayList(this.mPendingOperations);
                    this.mPendingOperations.clear();
                    this.mRunningOperations.addAll(arrayList2);
                    int size2 = arrayList2.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        Object obj2 = arrayList2.get(i2);
                        i2++;
                        ((SpecialEffectsController$FragmentStateManagerOperation) obj2).onStart();
                    }
                    executeOperations(arrayList2, this.mOperationDirectionIsPop);
                    this.mOperationDirectionIsPop = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final SpecialEffectsController$FragmentStateManagerOperation findPendingOperation(Fragment fragment) {
        ArrayList arrayList = this.mPendingOperations;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) obj;
            if (specialEffectsController$FragmentStateManagerOperation.mFragment.equals(fragment) && !specialEffectsController$FragmentStateManagerOperation.mIsCanceled) {
                return specialEffectsController$FragmentStateManagerOperation;
            }
        }
        return null;
    }

    public final void forceCompleteAllOperations() {
        ViewGroup viewGroup = this.mContainer;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        boolean zIsAttachedToWindow = viewGroup.isAttachedToWindow();
        synchronized (this.mPendingOperations) {
            try {
                updateFinalState();
                ArrayList arrayList = this.mPendingOperations;
                int size = arrayList.size();
                int i = 0;
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((SpecialEffectsController$FragmentStateManagerOperation) obj).onStart();
                }
                ArrayList arrayList2 = new ArrayList(this.mRunningOperations);
                int size2 = arrayList2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList2.get(i3);
                    i3++;
                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) obj2;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        if (!zIsAttachedToWindow) {
                            Objects.toString(this.mContainer);
                        }
                        Objects.toString(specialEffectsController$FragmentStateManagerOperation);
                    }
                    specialEffectsController$FragmentStateManagerOperation.cancel();
                }
                ArrayList arrayList3 = new ArrayList(this.mPendingOperations);
                int size3 = arrayList3.size();
                while (i < size3) {
                    Object obj3 = arrayList3.get(i);
                    i++;
                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2 = (SpecialEffectsController$FragmentStateManagerOperation) obj3;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        if (!zIsAttachedToWindow) {
                            Objects.toString(this.mContainer);
                        }
                        Objects.toString(specialEffectsController$FragmentStateManagerOperation2);
                    }
                    specialEffectsController$FragmentStateManagerOperation2.cancel();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void markPostponedState() {
        synchronized (this.mPendingOperations) {
            try {
                updateFinalState();
                this.mIsContainerPostponed = false;
                for (int size = this.mPendingOperations.size() - 1; size >= 0; size--) {
                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) this.mPendingOperations.get(size);
                    int i_from = Fragment$5$$ExternalSyntheticOutline0._from(specialEffectsController$FragmentStateManagerOperation.mFragment.mView);
                    if (specialEffectsController$FragmentStateManagerOperation.mFinalState == 2 && i_from != 2) {
                        this.mIsContainerPostponed = specialEffectsController$FragmentStateManagerOperation.mFragment.isPostponed();
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void updateFinalState() {
        ArrayList arrayList = this.mPendingOperations;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) obj;
            if (specialEffectsController$FragmentStateManagerOperation.mLifecycleImpact == 2) {
                specialEffectsController$FragmentStateManagerOperation.mergeWith(Fragment$5$$ExternalSyntheticOutline0._from(specialEffectsController$FragmentStateManagerOperation.mFragment.requireView().getVisibility()), 1);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.DefaultSpecialEffectsController$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Object val$awaitingContainerChanges;
        public final /* synthetic */ Object val$operation;

        public AnonymousClass1(TransitionInfo transitionInfo, SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation) {
            this.$r8$classId = (byte) 2;
            this.val$awaitingContainerChanges = transitionInfo;
            this.val$operation = specialEffectsController$FragmentStateManagerOperation;
        }

        @Override // java.lang.Runnable
        public final void run() {
            byte b = this.$r8$classId;
            Object obj = this.val$operation;
            Object obj2 = this.val$awaitingContainerChanges;
            switch (b) {
                case 0:
                    ArrayList arrayList = (ArrayList) obj2;
                    SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) obj;
                    if (arrayList.contains(specialEffectsController$FragmentStateManagerOperation)) {
                        arrayList.remove(specialEffectsController$FragmentStateManagerOperation);
                        Fragment$5$$ExternalSyntheticOutline0._applyState(specialEffectsController$FragmentStateManagerOperation.mFragment.mView, specialEffectsController$FragmentStateManagerOperation.mFinalState);
                    }
                    break;
                case 1:
                    FragmentTransitionCompat21.getBoundsOnScreen((View) obj2, (Rect) obj);
                    break;
                default:
                    ((TransitionInfo) obj2).completeSpecialEffect();
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Objects.toString((SpecialEffectsController$FragmentStateManagerOperation) obj);
                    }
                    break;
            }
        }

        public /* synthetic */ AnonymousClass1(Object obj, Object obj2, Object obj3, byte b) {
            this.$r8$classId = b;
            this.val$awaitingContainerChanges = obj2;
            this.val$operation = obj3;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.DefaultSpecialEffectsController$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass6 implements Runnable {
        public final /* synthetic */ byte $r8$classId = 0;
        public final Object val$firstOut;
        public boolean val$isPop;
        public final Object val$lastIn;

        public AnonymousClass6(LifecycleRegistry lifecycleRegistry, Lifecycle.Event event) {
            event.getClass();
            this.val$lastIn = lifecycleRegistry;
            this.val$firstOut = event;
        }

        @Override // java.lang.Runnable
        public final void run() {
            byte b = this.$r8$classId;
            Object obj = this.val$firstOut;
            Object obj2 = this.val$lastIn;
            switch (b) {
                case 0:
                    Fragment fragment = ((SpecialEffectsController$FragmentStateManagerOperation) obj2).mFragment;
                    Fragment fragment2 = ((SpecialEffectsController$FragmentStateManagerOperation) obj).mFragment;
                    boolean z = this.val$isPop;
                    FragmentTransitionCompat21 fragmentTransitionCompat21 = FragmentTransition.PLATFORM_IMPL;
                    if (!z) {
                        fragment.getEnterTransitionCallback();
                    } else {
                        fragment2.getEnterTransitionCallback();
                    }
                    break;
                default:
                    if (!this.val$isPop) {
                        ((LifecycleRegistry) obj2).handleLifecycleEvent((Lifecycle.Event) obj);
                        this.val$isPop = true;
                    }
                    break;
            }
        }

        public AnonymousClass6(SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation, SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation2, boolean z, ArrayMap arrayMap) {
            this.val$lastIn = specialEffectsController$FragmentStateManagerOperation;
            this.val$firstOut = specialEffectsController$FragmentStateManagerOperation2;
            this.val$isPop = z;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.DefaultSpecialEffectsController$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass4 implements Animation.AnimationListener {
        public final /* synthetic */ AnimationInfo val$animationInfo;
        public final /* synthetic */ ViewGroup val$container;
        public final /* synthetic */ SpecialEffectsController$FragmentStateManagerOperation val$operation;
        public final /* synthetic */ View val$viewToAnimate;

        public AnonymousClass4(View view, ViewGroup viewGroup, AnimationInfo animationInfo, SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation) {
            this.val$operation = specialEffectsController$FragmentStateManagerOperation;
            this.val$container = viewGroup;
            this.val$viewToAnimate = view;
            this.val$animationInfo = animationInfo;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            this.val$container.post(new Fragment.AnonymousClass1((byte) 1, this));
            if (FragmentManager.isLoggingEnabled(2)) {
                Objects.toString(this.val$operation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Objects.toString(this.val$operation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }
    }

    public static DefaultSpecialEffectsController getOrCreateController(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return getOrCreateController(viewGroup, fragmentManager.getSpecialEffectsControllerFactory());
    }
}
