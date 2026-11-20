package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.compose.material3.FabPlacement;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.DifferentialMotionFlingController;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.ScrollFeedbackProviderCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.VelocityTrackerFallback;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.datastore.core.AtomicInt;
import androidx.fragment.app.Fragment$5$$ExternalSyntheticOutline0;
import androidx.fragment.app.FragmentState;
import coil3.size.SizeKt;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.client.utils.CIOKt;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import okhttp3.Cache;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements NestedScrollingParent3 {
    public int mActivePointerId;
    public final Cache.RealCacheRequest mChildHelper;
    public View mChildToScrollTo;
    public final DifferentialMotionFlingController mDifferentialMotionFlingController;
    public final EdgeEffect mEdgeGlowBottom;
    public final EdgeEffect mEdgeGlowTop;
    public boolean mFillViewport;
    public boolean mIsBeingDragged;
    public boolean mIsLaidOut;
    public boolean mIsLayoutDirty;
    public int mLastMotionY;
    public long mLastScroll;
    public int mLastScrollerY;
    public final int mMaximumVelocity;
    public final int mMinimumVelocity;
    public int mNestedYOffset;
    public final FabPlacement mParentHelper;
    public final float mPhysicalCoeff;
    public SavedState mSavedState;
    public final int[] mScrollConsumed;
    public ScrollFeedbackProviderCompat mScrollFeedbackProvider;
    public final int[] mScrollOffset;
    public final OverScroller mScroller;
    public boolean mSmoothScrollingEnabled;
    public final Rect mTempRect;
    public final int mTouchSlop;
    public VelocityTracker mVelocityTracker;
    public float mVerticalScrollFactor;
    public static final float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final AccessibilityDelegate ACCESSIBILITY_DELEGATE = new AccessibilityDelegate();
    public static final int[] SCROLLVIEW_STYLEABLE = {R.attr.fillViewport};

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AccessibilityDelegate extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            accessibilityEvent.setMaxScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setMaxScrollY(nestedScrollView.getScrollRange());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
            this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.setClassName("android.widget.ScrollView");
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            accessibilityNodeInfo.setScrollable(true);
            if (nestedScrollView.getScrollY() > 0) {
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
            }
        }

        /* JADX WARN: Code duplicated, block: B:26:0x006a  */
        /* JADX WARN: Code duplicated, block: B:28:0x0087  */
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            int iMin;
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (nestedScrollView.isEnabled()) {
                int height = nestedScrollView.getHeight();
                Rect rect = new Rect();
                if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                    height = rect.height();
                }
                if (i == 4096) {
                    iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                    if (iMin != nestedScrollView.getScrollY()) {
                        nestedScrollView.smoothScrollBy(0 - nestedScrollView.getScrollX(), true, iMin - nestedScrollView.getScrollY());
                        return true;
                    }
                } else if (i == 8192 || i == 16908344) {
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax != nestedScrollView.getScrollY()) {
                        nestedScrollView.smoothScrollBy(0 - nestedScrollView.getScrollX(), true, iMax - nestedScrollView.getScrollY());
                        return true;
                    }
                } else if (i == 16908346) {
                    iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                    if (iMin != nestedScrollView.getScrollY()) {
                        nestedScrollView.smoothScrollBy(0 - nestedScrollView.getScrollX(), true, iMin - nestedScrollView.getScrollY());
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Api35Impl {
        public static void setFrameContentVelocity(NestedScrollView nestedScrollView, float f) {
            try {
                nestedScrollView.setFrameContentVelocity(f);
            } catch (LinkageError unused) {
            }
        }

        public static void setStylusHandwritingEnabled(EditorInfo editorInfo, boolean z) {
            editorInfo.setStylusHandwritingEnabled(z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface OnScrollChangeListener {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new FragmentState.AnonymousClass1((byte) 9);
        public int scrollPosition;

        public final String toString() {
            StringBuilder sb = new StringBuilder("HorizontalScrollView.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" scrollPosition=");
            return Fragment$5$$ExternalSyntheticOutline0.m(sb, this.scrollPosition, "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.scrollPosition);
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.yalantis.ucrop.R.attr.nestedScrollViewStyle);
        this.mTempRect = new Rect();
        this.mIsLayoutDirty = true;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mDifferentialMotionFlingController = new DifferentialMotionFlingController(getContext(), new AtomicInt((Object) this));
        int i = Build.VERSION.SDK_INT;
        this.mEdgeGlowTop = i >= 31 ? EdgeEffectCompat$Api31Impl.create(context, attributeSet) : new EdgeEffect(context);
        this.mEdgeGlowBottom = i >= 31 ? EdgeEffectCompat$Api31Impl.create(context, attributeSet) : new EdgeEffect(context);
        this.mPhysicalCoeff = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SCROLLVIEW_STYLEABLE, com.yalantis.ucrop.R.attr.nestedScrollViewStyle, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.mParentHelper = new FabPlacement();
        Cache.RealCacheRequest realCacheRequest = new Cache.RealCacheRequest();
        realCacheRequest.body = this;
        this.mChildHelper = realCacheRequest;
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, ACCESSIBILITY_DELEGATE);
    }

    private ScrollFeedbackProviderCompat getScrollFeedbackProvider() {
        ScrollFeedbackProviderCompat scrollFeedbackProviderCompat = this.mScrollFeedbackProvider;
        if (scrollFeedbackProviderCompat != null) {
            return scrollFeedbackProviderCompat;
        }
        ScrollFeedbackProviderCompat scrollFeedbackProviderCompat2 = new ScrollFeedbackProviderCompat(this);
        this.mScrollFeedbackProvider = scrollFeedbackProviderCompat2;
        return scrollFeedbackProviderCompat2;
    }

    public static boolean isViewDescendantOf(View view, NestedScrollView nestedScrollView) {
        if (view == nestedScrollView) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && isViewDescendantOf((View) parent, nestedScrollView);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("ScrollView can host only one direct child");
        }
    }

    public final boolean arrowScroll(int i) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View view = viewFindFocus;
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !isWithinDeltaOfScreen(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            scrollBy(maxScrollAmount, -1, null, 0, 1, true);
        } else {
            Rect rect = this.mTempRect;
            viewFindNextFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(viewFindNextFocus, rect);
            scrollBy(computeScrollDeltaToGetChildRectOnScreen(rect), -1, null, 0, 1, true);
            viewFindNextFocus.requestFocus(i);
        }
        if (view != null && view.isFocused() && !isWithinDeltaOfScreen(view, 0, getHeight())) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0080  */
    /* JADX WARN: Code duplicated, block: B:23:0x008d  */
    /* JADX WARN: Code duplicated, block: B:24:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:26:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:30:0x00c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:40:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ef  */
    @Override // android.view.View
    public final void computeScroll() {
        int iRound;
        int[] iArr;
        int i;
        int scrollRange;
        int i2;
        int overScrollMode;
        OverScroller overScroller = this.mScroller;
        if (overScroller.isFinished()) {
            return;
        }
        overScroller.computeScrollOffset();
        int currY = overScroller.getCurrY();
        int i3 = currY - this.mLastScrollerY;
        int height = getHeight();
        EdgeEffect edgeEffect = this.mEdgeGlowTop;
        EdgeEffect edgeEffect2 = this.mEdgeGlowBottom;
        if (i3 <= 0 || SizeKt.getDistance(edgeEffect) == CropImageView.DEFAULT_ASPECT_RATIO) {
            if (i3 < 0 && SizeKt.getDistance(edgeEffect2) != CropImageView.DEFAULT_ASPECT_RATIO) {
                float f = height;
                iRound = Math.round(SizeKt.onPullDistance(edgeEffect2, (i3 * 4.0f) / f, 0.5f) * (f / 4.0f));
                if (iRound != i3) {
                    edgeEffect2.finish();
                }
            }
            this.mLastScrollerY = currY;
            iArr = this.mScrollConsumed;
            iArr[1] = 0;
            dispatchNestedPreScroll(0, i3, 1, iArr, null);
            i = i3 - iArr[1];
            scrollRange = getScrollRange();
            if (Build.VERSION.SDK_INT >= 35) {
                Api35Impl.setFrameContentVelocity(this, Math.abs(overScroller.getCurrVelocity()));
            }
            if (i != 0) {
                int scrollY = getScrollY();
                overScrollByCompat(i, getScrollX(), scrollY, scrollRange);
                int scrollY2 = getScrollY() - scrollY;
                int i4 = i - scrollY2;
                iArr[1] = 0;
                i2 = 1;
                this.mChildHelper.dispatchNestedScrollInternal(0, scrollY2, 0, i4, this.mScrollOffset, 1, iArr);
                i = i4 - iArr[1];
            } else {
                i2 = 1;
            }
            if (i != 0) {
                overScrollMode = getOverScrollMode();
                if (overScrollMode != 0 || (overScrollMode == i2 && scrollRange > 0)) {
                    if (i < 0) {
                        if (edgeEffect.isFinished()) {
                            edgeEffect.onAbsorb((int) overScroller.getCurrVelocity());
                        }
                    } else if (edgeEffect2.isFinished()) {
                        edgeEffect2.onAbsorb((int) overScroller.getCurrVelocity());
                    }
                }
                overScroller.abortAnimation();
                stopNestedScroll(i2);
            }
            if (overScroller.isFinished()) {
                stopNestedScroll(i2);
            } else {
                postInvalidateOnAnimation();
            }
        }
        iRound = Math.round(SizeKt.onPullDistance(edgeEffect, ((-i3) * 4.0f) / height, 0.5f) * ((-height) / 4.0f));
        if (iRound != i3) {
            edgeEffect.finish();
        }
        i3 -= iRound;
        this.mLastScrollerY = currY;
        iArr = this.mScrollConsumed;
        iArr[1] = 0;
        dispatchNestedPreScroll(0, i3, 1, iArr, null);
        i = i3 - iArr[1];
        scrollRange = getScrollRange();
        if (Build.VERSION.SDK_INT >= 35) {
            Api35Impl.setFrameContentVelocity(this, Math.abs(overScroller.getCurrVelocity()));
        }
        if (i != 0) {
            int scrollY3 = getScrollY();
            overScrollByCompat(i, getScrollX(), scrollY3, scrollRange);
            int scrollY4 = getScrollY() - scrollY3;
            int i5 = i - scrollY4;
            iArr[1] = 0;
            i2 = 1;
            this.mChildHelper.dispatchNestedScrollInternal(0, scrollY4, 0, i5, this.mScrollOffset, 1, iArr);
            i = i5 - iArr[1];
        } else {
            i2 = 1;
        }
        if (i != 0) {
            overScrollMode = getOverScrollMode();
            if (overScrollMode != 0) {
                if (i < 0) {
                    if (edgeEffect.isFinished()) {
                        edgeEffect.onAbsorb((int) overScroller.getCurrVelocity());
                    }
                } else if (edgeEffect2.isFinished()) {
                    edgeEffect2.onAbsorb((int) overScroller.getCurrVelocity());
                }
            } else if (i < 0) {
                if (edgeEffect.isFinished()) {
                    edgeEffect.onAbsorb((int) overScroller.getCurrVelocity());
                }
            } else if (edgeEffect2.isFinished()) {
                edgeEffect2.onAbsorb((int) overScroller.getCurrVelocity());
            }
            overScroller.abortAnimation();
            stopNestedScroll(i2);
        }
        if (overScroller.isFinished()) {
            postInvalidateOnAnimation();
        } else {
            stopNestedScroll(i2);
        }
    }

    public final int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i2 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i - verticalFadingEdgeLength : i;
        int i3 = rect.bottom;
        if (i3 > i2 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i2, (childAt.getBottom() + layoutParams.bottomMargin) - i);
        }
        if (rect.top >= scrollY || i3 >= i2) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i2 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        return scrollY > iMax ? (scrollY - iMax) + bottom : bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f, float f2, boolean z) {
        ViewParent nestedScrollingParentForType;
        Cache.RealCacheRequest realCacheRequest = this.mChildHelper;
        if (realCacheRequest.done && (nestedScrollingParentForType = realCacheRequest.getNestedScrollingParentForType(0)) != null) {
            try {
                return nestedScrollingParentForType.onNestedFling((NestedScrollView) realCacheRequest.body, f, f2, z);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + nestedScrollingParentForType + " does not implement interface method onNestedFling", e);
            }
        }
        return false;
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f, float f2) {
        ViewParent nestedScrollingParentForType;
        Cache.RealCacheRequest realCacheRequest = this.mChildHelper;
        if (realCacheRequest.done && (nestedScrollingParentForType = realCacheRequest.getNestedScrollingParentForType(0)) != null) {
            try {
                return nestedScrollingParentForType.onNestedPreFling((NestedScrollView) realCacheRequest.body, f, f2);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + nestedScrollingParentForType + " does not implement interface method onNestedPreFling", e);
            }
        }
        return false;
    }

    public final boolean dispatchNestedPreScroll(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        ViewParent nestedScrollingParentForType;
        int i4;
        int i5;
        Cache.RealCacheRequest realCacheRequest = this.mChildHelper;
        NestedScrollView nestedScrollView = (NestedScrollView) realCacheRequest.body;
        if (!realCacheRequest.done || (nestedScrollingParentForType = realCacheRequest.getNestedScrollingParentForType(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        if (iArr2 != null) {
            nestedScrollView.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null && (iArr = (int[]) realCacheRequest.this$0) == null) {
            iArr = new int[2];
            realCacheRequest.this$0 = iArr;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        NestedScrollView nestedScrollView2 = (NestedScrollView) realCacheRequest.body;
        if (nestedScrollingParentForType instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) nestedScrollingParentForType).onNestedPreScroll(i, i2, i3, iArr);
        } else if (i3 == 0) {
            try {
                nestedScrollingParentForType.onNestedPreScroll(nestedScrollView2, i, i2, iArr);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + nestedScrollingParentForType + " does not implement interface method onNestedPreScroll", e);
            }
        }
        if (iArr2 != null) {
            nestedScrollView.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mChildHelper.dispatchNestedScrollInternal(i, i2, i3, i4, iArr, 0, null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        EdgeEffect edgeEffect = this.mEdgeGlowTop;
        int paddingLeft2 = 0;
        if (!edgeEffect.isFinished()) {
            int iSave = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int iMin = Math.min(0, scrollY);
            if (getClipToPadding()) {
                width -= getPaddingRight() + getPaddingLeft();
                paddingLeft = getPaddingLeft();
                height -= getPaddingBottom() + getPaddingTop();
                iMin += getPaddingTop();
            } else {
                paddingLeft = 0;
            }
            canvas.translate(paddingLeft, iMin);
            edgeEffect.setSize(width, height);
            if (edgeEffect.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect2 = this.mEdgeGlowBottom;
        if (edgeEffect2.isFinished()) {
            return;
        }
        int iSave2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int iMax = Math.max(getScrollRange(), scrollY) + height2;
        if (getClipToPadding()) {
            width2 -= getPaddingRight() + getPaddingLeft();
            paddingLeft2 = getPaddingLeft();
        }
        if (getClipToPadding()) {
            height2 -= getPaddingBottom() + getPaddingTop();
            iMax -= getPaddingBottom();
        }
        canvas.translate(paddingLeft2 - width2, iMax);
        canvas.rotate(180.0f, width2, CropImageView.DEFAULT_ASPECT_RATIO);
        edgeEffect2.setSize(width2, height2);
        if (edgeEffect2.draw(canvas)) {
            postInvalidateOnAnimation();
        }
        canvas.restoreToCount(iSave2);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0098  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ab  */
    public final boolean executeKeyEvent(KeyEvent keyEvent) {
        View viewFindFocus;
        View viewFindNextFocus;
        this.mTempRect.setEmpty();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                if (keyEvent.getAction() == 0) {
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode == 19) {
                        return keyEvent.isAltPressed() ? fullScroll(33) : arrowScroll(33);
                    }
                    if (keyCode == 20) {
                        return keyEvent.isAltPressed() ? fullScroll(130) : arrowScroll(130);
                    }
                    if (keyCode == 62) {
                        pageScroll(keyEvent.isShiftPressed() ? 33 : 130);
                        return false;
                    }
                    if (keyCode == 92) {
                        return fullScroll(33);
                    }
                    if (keyCode == 93) {
                        return fullScroll(130);
                    }
                    if (keyCode == 122) {
                        pageScroll(33);
                        return false;
                    }
                    if (keyCode == 123) {
                        pageScroll(130);
                        return false;
                    }
                }
            } else if (isFocused() && keyEvent.getKeyCode() != 4) {
                viewFindFocus = findFocus();
                if (viewFindFocus == this) {
                    viewFindFocus = null;
                }
                viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
                if (viewFindNextFocus == null && viewFindNextFocus != this && viewFindNextFocus.requestFocus(130)) {
                    return true;
                }
            }
        } else if (isFocused()) {
            viewFindFocus = findFocus();
            if (viewFindFocus == this) {
                viewFindFocus = null;
            }
            viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
            if (viewFindNextFocus == null) {
            }
        }
        return false;
    }

    public final void fling(int i) {
        if (getChildCount() > 0) {
            this.mScroller.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            startNestedScroll(2, 1);
            this.mLastScrollerY = getScrollY();
            postInvalidateOnAnimation();
            if (Build.VERSION.SDK_INT >= 35) {
                Api35Impl.setFrameContentVelocity(this, Math.abs(this.mScroller.getCurrVelocity()));
            }
        }
    }

    public final boolean fullScroll(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        Rect rect = this.mTempRect;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            rect.bottom = paddingBottom;
            rect.top = paddingBottom - height;
        }
        return scrollAndFocus(i, rect.top, rect.bottom);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        FabPlacement fabPlacement = this.mParentHelper;
        return fabPlacement.height | fabPlacement.left;
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public float getVerticalScrollFactorCompat() {
        float f = this.mVerticalScrollFactor;
        if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
            return f;
        }
        TypedValue typedValue = new TypedValue();
        Context context = getContext();
        if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Expected theme to define listPreferredItemHeight.");
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        float dimension = typedValue.getDimension(context.getResources().getDisplayMetrics());
        this.mVerticalScrollFactor = dimension;
        return dimension;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.mChildHelper.getNestedScrollingParentForType(0) != null;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.mChildHelper.done;
    }

    public final boolean isWithinDeltaOfScreen(View view, int i, int i2) {
        Rect rect = this.mTempRect;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        return rect.bottom + i >= getScrollY() && rect.top - i <= getScrollY() + i2;
    }

    @Override // android.view.ViewGroup
    public final void measureChild(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    /* JADX WARN: Code duplicated, block: B:134:0x029a  */
    /* JADX WARN: Code duplicated, block: B:135:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:137:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:49:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:70:0x0128  */
    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f;
        int i;
        int width;
        boolean z;
        int i2;
        int scaledMinimumFlingVelocity;
        int scaledMaximumFlingVelocity;
        boolean z2;
        float yVelocity;
        float f2;
        long j;
        float f3;
        int i3;
        float fSqrt;
        float f4;
        if (motionEvent.getAction() != 8 || this.mIsBeingDragged) {
            return false;
        }
        if ((motionEvent.getSource() & 2) == 2) {
            float axisValue = motionEvent.getAxisValue(9);
            width = (int) motionEvent.getX();
            i = 9;
            f = axisValue;
        } else if ((motionEvent.getSource() & 4194304) == 4194304) {
            float axisValue2 = motionEvent.getAxisValue(26);
            width = getWidth() / 2;
            f = axisValue2;
            i = 26;
        } else {
            f = 0.0f;
            i = 0;
            width = 0;
        }
        if (f == CropImageView.DEFAULT_ASPECT_RATIO) {
            return false;
        }
        scrollBy(-((int) (getVerticalScrollFactorCompat() * f)), i, motionEvent, width, 1, (motionEvent.getSource() & 8194) == 8194);
        if (i != 0) {
            DifferentialMotionFlingController differentialMotionFlingController = this.mDifferentialMotionFlingController;
            NestedScrollView nestedScrollView = (NestedScrollView) differentialMotionFlingController.mTarget.delegate;
            int[] iArr = differentialMotionFlingController.mFlingVelocityThresholds;
            int source = motionEvent.getSource();
            int deviceId = motionEvent.getDeviceId();
            if (differentialMotionFlingController.mLastProcessedSource == source && differentialMotionFlingController.mLastProcessedDeviceId == deviceId && differentialMotionFlingController.mLastProcessedAxis == i) {
                z2 = false;
                z = true;
                i2 = 0;
            } else {
                Context context = differentialMotionFlingController.mContext;
                z = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int deviceId2 = motionEvent.getDeviceId();
                int source2 = motionEvent.getSource();
                i2 = 0;
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 34) {
                    scaledMinimumFlingVelocity = TextViewCompat$Api34Impl.getScaledMinimumFlingVelocity(viewConfiguration, deviceId2, i, source2);
                } else {
                    InputDevice device = InputDevice.getDevice(deviceId2);
                    if (device == null || device.getMotionRange(i, source2) == null) {
                        scaledMinimumFlingVelocity = Integer.MAX_VALUE;
                    } else {
                        Resources resources = context.getResources();
                        int identifier = (source2 == 4194304 && i == 26) ? resources.getIdentifier("config_viewMinRotaryEncoderFlingVelocity", "dimen", "android") : -1;
                        Objects.requireNonNull(viewConfiguration);
                        if (identifier == -1) {
                            scaledMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                        } else if (identifier == 0 || (scaledMinimumFlingVelocity = resources.getDimensionPixelSize(identifier)) < 0) {
                            scaledMinimumFlingVelocity = Integer.MAX_VALUE;
                        }
                    }
                }
                iArr[0] = scaledMinimumFlingVelocity;
                int deviceId3 = motionEvent.getDeviceId();
                int source3 = motionEvent.getSource();
                if (i4 >= 34) {
                    scaledMaximumFlingVelocity = TextViewCompat$Api34Impl.getScaledMaximumFlingVelocity(viewConfiguration, deviceId3, i, source3);
                } else {
                    InputDevice device2 = InputDevice.getDevice(deviceId3);
                    if (device2 == null || device2.getMotionRange(i, source3) == null) {
                        scaledMaximumFlingVelocity = Integer.MIN_VALUE;
                    } else {
                        Resources resources2 = context.getResources();
                        int identifier2 = (source3 == 4194304 && i == 26) ? resources2.getIdentifier("config_viewMaxRotaryEncoderFlingVelocity", "dimen", "android") : -1;
                        Objects.requireNonNull(viewConfiguration);
                        if (identifier2 == -1) {
                            scaledMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                        } else if (identifier2 == 0 || (scaledMaximumFlingVelocity = resources2.getDimensionPixelSize(identifier2)) < 0) {
                            scaledMaximumFlingVelocity = Integer.MIN_VALUE;
                        }
                    }
                }
                iArr[1] = scaledMaximumFlingVelocity;
                differentialMotionFlingController.mLastProcessedSource = source;
                differentialMotionFlingController.mLastProcessedDeviceId = deviceId;
                differentialMotionFlingController.mLastProcessedAxis = i;
                z2 = true;
            }
            int i5 = iArr[i2];
            VelocityTracker velocityTrackerObtain = differentialMotionFlingController.mVelocityTracker;
            if (i5 == Integer.MAX_VALUE) {
                if (velocityTrackerObtain == null) {
                    return z;
                }
                velocityTrackerObtain.recycle();
                differentialMotionFlingController.mVelocityTracker = null;
                return z;
            }
            if (velocityTrackerObtain == null) {
                velocityTrackerObtain = VelocityTracker.obtain();
                differentialMotionFlingController.mVelocityTracker = velocityTrackerObtain;
            }
            Map map = VelocityTrackerCompat.sFallbackTrackers;
            velocityTrackerObtain.addMovement(motionEvent);
            if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
                Map map2 = VelocityTrackerCompat.sFallbackTrackers;
                if (!map2.containsKey(velocityTrackerObtain)) {
                    map2.put(velocityTrackerObtain, new VelocityTrackerFallback());
                }
                VelocityTrackerFallback velocityTrackerFallback = (VelocityTrackerFallback) map2.get(velocityTrackerObtain);
                long[] jArr = velocityTrackerFallback.mEventTimes;
                long eventTime = motionEvent.getEventTime();
                int i6 = velocityTrackerFallback.mDataPointsBufferSize;
                if (i6 != 0 && eventTime - jArr[velocityTrackerFallback.mDataPointsBufferLastUsedIndex] > 40) {
                    velocityTrackerFallback.mDataPointsBufferSize = i2;
                    velocityTrackerFallback.mLastComputedVelocity = CropImageView.DEFAULT_ASPECT_RATIO;
                    i6 = 0;
                }
                int i7 = (velocityTrackerFallback.mDataPointsBufferLastUsedIndex + 1) % 20;
                velocityTrackerFallback.mDataPointsBufferLastUsedIndex = i7;
                if (i6 != 20) {
                    velocityTrackerFallback.mDataPointsBufferSize = i6 + 1;
                }
                velocityTrackerFallback.mMovements[i7] = motionEvent.getAxisValue(26);
                jArr[velocityTrackerFallback.mDataPointsBufferLastUsedIndex] = eventTime;
            }
            float f5 = Float.MAX_VALUE;
            velocityTrackerObtain.computeCurrentVelocity(CIOKt.DEFAULT_HTTP_POOL_SIZE, Float.MAX_VALUE);
            VelocityTrackerFallback velocityTrackerFallback2 = (VelocityTrackerFallback) VelocityTrackerCompat.sFallbackTrackers.get(velocityTrackerObtain);
            if (velocityTrackerFallback2 != null) {
                float[] fArr = velocityTrackerFallback2.mMovements;
                long[] jArr2 = velocityTrackerFallback2.mEventTimes;
                int i8 = velocityTrackerFallback2.mDataPointsBufferSize;
                if (i8 < 2) {
                    f3 = Float.MAX_VALUE;
                } else {
                    int i9 = velocityTrackerFallback2.mDataPointsBufferLastUsedIndex;
                    int i10 = ((i9 + 20) - (i8 - 1)) % 20;
                    long j2 = jArr2[i9];
                    while (true) {
                        j = jArr2[i10];
                        long j3 = j2 - j;
                        f3 = f5;
                        i3 = velocityTrackerFallback2.mDataPointsBufferSize;
                        if (j3 <= 100) {
                            break;
                        }
                        velocityTrackerFallback2.mDataPointsBufferSize = i3 - 1;
                        i10 = (i10 + 1) % 20;
                        f5 = f3;
                    }
                    if (i3 >= 2) {
                        if (i3 == 2) {
                            int i11 = (i10 + 1) % 20;
                            long j4 = jArr2[i11];
                            if (j != j4) {
                                iArr = iArr;
                                fSqrt = fArr[i11] / (j4 - j);
                            }
                        } else {
                            float f6 = CropImageView.DEFAULT_ASPECT_RATIO;
                            int i12 = 0;
                            int i13 = 0;
                            while (true) {
                                if (i12 >= velocityTrackerFallback2.mDataPointsBufferSize - 1) {
                                    break;
                                }
                                int i14 = i12 + i10;
                                long j5 = jArr2[i14 % 20];
                                int i15 = (i14 + 1) % 20;
                                if (jArr2[i15] != j5) {
                                    i13++;
                                    float fSqrt2 = (f6 < CropImageView.DEFAULT_ASPECT_RATIO ? -1.0f : 1.0f) * ((float) Math.sqrt(2.0f * Math.abs(f6)));
                                    float f7 = fArr[i15] / (jArr2[i15] - j5);
                                    float fAbs = (Math.abs(f7) * (f7 - fSqrt2)) + f6;
                                    if (i13 == z) {
                                        fAbs *= 0.5f;
                                    }
                                    f6 = fAbs;
                                }
                                i12++;
                                iArr = iArr;
                                z = true;
                            }
                            iArr = iArr;
                            float f8 = f6;
                            fSqrt = ((float) Math.sqrt(Math.abs(f8) * 2.0f)) * (f8 < CropImageView.DEFAULT_ASPECT_RATIO ? -1.0f : 1.0f);
                        }
                        f4 = fSqrt * 1000.0f;
                        velocityTrackerFallback2.mLastComputedVelocity = f4;
                        if (f4 < (-Math.abs(f3))) {
                            velocityTrackerFallback2.mLastComputedVelocity = -Math.abs(f3);
                        } else if (velocityTrackerFallback2.mLastComputedVelocity > Math.abs(f3)) {
                            velocityTrackerFallback2.mLastComputedVelocity = Math.abs(f3);
                        }
                    }
                }
                fSqrt = CropImageView.DEFAULT_ASPECT_RATIO;
                f4 = fSqrt * 1000.0f;
                velocityTrackerFallback2.mLastComputedVelocity = f4;
                if (f4 < (-Math.abs(f3))) {
                    velocityTrackerFallback2.mLastComputedVelocity = -Math.abs(f3);
                } else if (velocityTrackerFallback2.mLastComputedVelocity > Math.abs(f3)) {
                    velocityTrackerFallback2.mLastComputedVelocity = Math.abs(f3);
                }
            } else {
                iArr = iArr;
            }
            if (Build.VERSION.SDK_INT >= 34) {
                yVelocity = TextViewCompat$Api34Impl.getAxisVelocity(velocityTrackerObtain, i);
            } else if (i == 0) {
                yVelocity = velocityTrackerObtain.getXVelocity();
            } else if (i == 1) {
                yVelocity = velocityTrackerObtain.getYVelocity();
            } else {
                VelocityTrackerFallback velocityTrackerFallback3 = (VelocityTrackerFallback) VelocityTrackerCompat.sFallbackTrackers.get(velocityTrackerObtain);
                yVelocity = (velocityTrackerFallback3 == null || i != 26) ? CropImageView.DEFAULT_ASPECT_RATIO : velocityTrackerFallback3.mLastComputedVelocity;
            }
            float f9 = yVelocity * (-nestedScrollView.getVerticalScrollFactorCompat());
            float fSignum = Math.signum(f9);
            if (z2 || (fSignum != Math.signum(differentialMotionFlingController.mLastFlingVelocity) && fSignum != CropImageView.DEFAULT_ASPECT_RATIO)) {
                nestedScrollView.mScroller.abortAnimation();
            }
            if (Math.abs(f9) >= iArr[0]) {
                int i16 = iArr[1];
                float fMax = Math.max(-i16, Math.min(f9, i16));
                if (fMax == CropImageView.DEFAULT_ASPECT_RATIO) {
                    f2 = 0.0f;
                } else {
                    nestedScrollView.mScroller.abortAnimation();
                    nestedScrollView.fling((int) fMax);
                    f2 = fMax;
                }
                differentialMotionFlingController.mLastFlingVelocity = f2;
                return true;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0081  */
    /* JADX WARN: Code duplicated, block: B:36:0x0089  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x0113  */
    /* JADX WARN: Code duplicated, block: B:70:0x0127  */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int action = motionEvent.getAction();
        boolean z = true;
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        int i = action & 255;
        if (i == 0) {
            int y = (int) motionEvent.getY();
            int x = (int) motionEvent.getX();
            int childCount = getChildCount();
            OverScroller overScroller = this.mScroller;
            if (childCount > 0) {
                int scrollY = getScrollY();
                View childAt = getChildAt(0);
                if (y < childAt.getTop() - scrollY || y >= childAt.getBottom() - scrollY || x < childAt.getLeft() || x >= childAt.getRight()) {
                    if (!stopGlowAnimations(motionEvent) && overScroller.isFinished()) {
                        z = false;
                    }
                    this.mIsBeingDragged = z;
                    velocityTracker = this.mVelocityTracker;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        this.mVelocityTracker = null;
                    }
                } else {
                    this.mLastMotionY = y;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    VelocityTracker velocityTracker3 = this.mVelocityTracker;
                    if (velocityTracker3 == null) {
                        this.mVelocityTracker = VelocityTracker.obtain();
                    } else {
                        velocityTracker3.clear();
                    }
                    this.mVelocityTracker.addMovement(motionEvent);
                    overScroller.computeScrollOffset();
                    if (!stopGlowAnimations(motionEvent) && overScroller.isFinished()) {
                        z = false;
                    }
                    this.mIsBeingDragged = z;
                    startNestedScroll(2, 0);
                }
            } else {
                if (!stopGlowAnimations(motionEvent)) {
                    z = false;
                }
                this.mIsBeingDragged = z;
                velocityTracker = this.mVelocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.mVelocityTracker = null;
                }
            }
        } else if (i == 1) {
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.mVelocityTracker = null;
            }
            if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            stopNestedScroll(0);
        } else if (i == 2) {
            int i2 = this.mActivePointerId;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + i2 + " in onInterceptTouchEvent");
                } else {
                    int y2 = (int) motionEvent.getY(iFindPointerIndex);
                    if (Math.abs(y2 - this.mLastMotionY) > this.mTouchSlop && (2 & getNestedScrollAxes()) == 0) {
                        this.mIsBeingDragged = true;
                        this.mLastMotionY = y2;
                        VelocityTracker velocityTrackerObtain = this.mVelocityTracker;
                        if (velocityTrackerObtain == null) {
                            velocityTrackerObtain = VelocityTracker.obtain();
                            this.mVelocityTracker = velocityTrackerObtain;
                        }
                        velocityTrackerObtain.addMovement(motionEvent);
                        this.mNestedYOffset = 0;
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
            }
        } else if (i == 3) {
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.mVelocityTracker = null;
            }
            if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            stopNestedScroll(0);
        } else if (i == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        return this.mIsBeingDragged;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        int i5 = 0;
        this.mIsLayoutDirty = false;
        View view = this.mChildToScrollTo;
        if (view != null && isViewDescendantOf(view, this)) {
            View view2 = this.mChildToScrollTo;
            Rect rect = this.mTempRect;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int iComputeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
            if (iComputeScrollDeltaToGetChildRectOnScreen != 0) {
                scrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen);
            }
        }
        this.mChildToScrollTo = null;
        if (!this.mIsLaidOut) {
            if (this.mSavedState != null) {
                scrollTo(getScrollX(), this.mSavedState.scrollPosition);
                this.mSavedState = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                measuredHeight = 0;
            }
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            if (paddingTop < measuredHeight && scrollY >= 0) {
                i5 = paddingTop + scrollY > measuredHeight ? measuredHeight - paddingTop : scrollY;
            }
            if (i5 != scrollY) {
                scrollTo(getScrollX(), i5);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.mIsLaidOut = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mFillViewport && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(CropImageView.DEFAULT_ASPECT_RATIO, f2, true);
        fling((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(int i, int i2, int i3, int[] iArr) {
        dispatchNestedPreScroll(i, i2, i3, iArr, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScrollInternal(i4, 0, null);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        FabPlacement fabPlacement = this.mParentHelper;
        if (i2 == 1) {
            fabPlacement.height = i;
        } else {
            fabPlacement.left = i;
        }
        startNestedScroll(2, i2);
    }

    public final void onNestedScrollInternal(int i, int i2, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.mChildHelper.dispatchNestedScrollInternal(0, scrollY2, 0, i - scrollY2, null, i2, iArr);
    }

    @Override // android.view.View
    public final void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (viewFindNextFocus != null && isWithinDeltaOfScreen(viewFindNextFocus, 0, getHeight())) {
            return viewFindNextFocus.requestFocus(i, rect);
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mSavedState = savedState;
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.scrollPosition = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    public final void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    public final void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mLastMotionY = (int) motionEvent.getY(i);
            this.mActivePointerId = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !isWithinDeltaOfScreen(viewFindFocus, 0, i4)) {
            return;
        }
        Rect rect = this.mTempRect;
        viewFindFocus.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(viewFindFocus, rect);
        int iComputeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        if (iComputeScrollDeltaToGetChildRectOnScreen != 0) {
            if (this.mSmoothScrollingEnabled) {
                smoothScrollBy(0, false, iComputeScrollDeltaToGetChildRectOnScreen);
            } else {
                scrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen);
            }
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View view, int i) {
        FabPlacement fabPlacement = this.mParentHelper;
        if (i == 1) {
            fabPlacement.height = 0;
        } else {
            fabPlacement.left = 0;
        }
        stopNestedScroll(i);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x011d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0125  */
    /* JADX WARN: Code duplicated, block: B:54:0x012d  */
    /* JADX WARN: Code duplicated, block: B:56:0x0133  */
    /* JADX WARN: Code duplicated, block: B:59:0x013a  */
    /* JADX WARN: Code duplicated, block: B:60:0x013c  */
    /* JADX WARN: Code duplicated, block: B:63:0x0141  */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        float fOnPullDistance;
        int iRound;
        int i;
        int iAbs;
        int i2;
        ViewParent parent2;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mNestedYOffset = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        float f = this.mNestedYOffset;
        float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
        motionEventObtain.offsetLocation(CropImageView.DEFAULT_ASPECT_RATIO, f);
        if (actionMasked != 0) {
            EdgeEffect edgeEffect = this.mEdgeGlowTop;
            EdgeEffect edgeEffect2 = this.mEdgeGlowBottom;
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(CIOKt.DEFAULT_HTTP_POOL_SIZE, this.mMaximumVelocity);
                int yVelocity = (int) velocityTracker.getYVelocity(this.mActivePointerId);
                if (Math.abs(yVelocity) >= this.mMinimumVelocity) {
                    if (SizeKt.getDistance(edgeEffect) != CropImageView.DEFAULT_ASPECT_RATIO) {
                        if (shouldAbsorb(edgeEffect, yVelocity)) {
                            edgeEffect.onAbsorb(yVelocity);
                        } else {
                            fling(-yVelocity);
                        }
                    } else if (SizeKt.getDistance(edgeEffect2) != CropImageView.DEFAULT_ASPECT_RATIO) {
                        int i3 = -yVelocity;
                        if (shouldAbsorb(edgeEffect2, i3)) {
                            edgeEffect2.onAbsorb(i3);
                        } else {
                            fling(i3);
                        }
                    } else {
                        int i4 = -yVelocity;
                        float f3 = i4;
                        if (!dispatchNestedPreFling(CropImageView.DEFAULT_ASPECT_RATIO, f3)) {
                            dispatchNestedFling(CropImageView.DEFAULT_ASPECT_RATIO, f3, true);
                            fling(i4);
                        }
                    }
                } else if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                this.mActivePointerId = -1;
                this.mIsBeingDragged = false;
                VelocityTracker velocityTracker2 = this.mVelocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.mVelocityTracker = null;
                }
                stopNestedScroll(0);
                edgeEffect.onRelease();
                edgeEffect2.onRelease();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
                } else {
                    int y = (int) motionEvent.getY(iFindPointerIndex);
                    int i5 = this.mLastMotionY - y;
                    float x = motionEvent.getX(iFindPointerIndex) / getWidth();
                    float height = i5 / getHeight();
                    if (SizeKt.getDistance(edgeEffect) != CropImageView.DEFAULT_ASPECT_RATIO) {
                        fOnPullDistance = -SizeKt.onPullDistance(edgeEffect, -height, x);
                        if (SizeKt.getDistance(edgeEffect) == CropImageView.DEFAULT_ASPECT_RATIO) {
                            edgeEffect.onRelease();
                        }
                    } else if (SizeKt.getDistance(edgeEffect2) != CropImageView.DEFAULT_ASPECT_RATIO) {
                        fOnPullDistance = SizeKt.onPullDistance(edgeEffect2, height, 1.0f - x);
                        if (SizeKt.getDistance(edgeEffect2) == CropImageView.DEFAULT_ASPECT_RATIO) {
                            edgeEffect2.onRelease();
                        }
                    } else {
                        iRound = Math.round(f2 * getHeight());
                        if (iRound != 0) {
                            invalidate();
                        }
                        i = i5 - iRound;
                        if (!this.mIsBeingDragged) {
                            iAbs = Math.abs(i);
                            i2 = this.mTouchSlop;
                            if (iAbs > i2) {
                                parent2 = getParent();
                                if (parent2 != null) {
                                    parent2.requestDisallowInterceptTouchEvent(true);
                                }
                                this.mIsBeingDragged = true;
                                if (i > 0) {
                                    i -= i2;
                                } else {
                                    i += i2;
                                }
                            }
                        }
                        if (this.mIsBeingDragged) {
                            int iScrollBy = scrollBy(i, 1, motionEvent, (int) motionEvent.getX(iFindPointerIndex), 0, false);
                            this.mLastMotionY = y - iScrollBy;
                            this.mNestedYOffset += iScrollBy;
                        }
                    }
                    f2 = fOnPullDistance;
                    iRound = Math.round(f2 * getHeight());
                    if (iRound != 0) {
                        invalidate();
                    }
                    i = i5 - iRound;
                    if (!this.mIsBeingDragged) {
                        iAbs = Math.abs(i);
                        i2 = this.mTouchSlop;
                        if (iAbs > i2) {
                            parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                            this.mIsBeingDragged = true;
                            if (i > 0) {
                                i -= i2;
                            } else {
                                i += i2;
                            }
                        }
                    }
                    if (this.mIsBeingDragged) {
                        int iScrollBy2 = scrollBy(i, 1, motionEvent, (int) motionEvent.getX(iFindPointerIndex), 0, false);
                        this.mLastMotionY = y - iScrollBy2;
                        this.mNestedYOffset += iScrollBy2;
                    }
                }
            } else if (actionMasked == 3) {
                if (this.mIsBeingDragged && getChildCount() > 0) {
                    if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        postInvalidateOnAnimation();
                    }
                }
                this.mActivePointerId = -1;
                this.mIsBeingDragged = false;
                VelocityTracker velocityTracker3 = this.mVelocityTracker;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.mVelocityTracker = null;
                }
                stopNestedScroll(0);
                edgeEffect.onRelease();
                edgeEffect2.onRelease();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.mLastMotionY = (int) motionEvent.getY(actionIndex);
                this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                onSecondaryPointerUp(motionEvent);
                this.mLastMotionY = (int) motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.mIsBeingDragged && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            OverScroller overScroller = this.mScroller;
            if (!overScroller.isFinished()) {
                overScroller.abortAnimation();
                stopNestedScroll(1);
            }
            int y2 = (int) motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            this.mLastMotionY = y2;
            this.mActivePointerId = pointerId;
            startNestedScroll(2, 0);
        }
        VelocityTracker velocityTracker4 = this.mVelocityTracker;
        if (velocityTracker4 != null) {
            velocityTracker4.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    public final boolean overScrollByCompat(int i, int i2, int i3, int i4) {
        int i5;
        boolean z;
        int i6;
        boolean z2;
        getOverScrollMode();
        super.computeHorizontalScrollRange();
        super.computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        super.computeVerticalScrollExtent();
        int i7 = i3 + i;
        if (i2 <= 0 && i2 >= 0) {
            i5 = i2;
            z = false;
        } else {
            i5 = 0;
            z = true;
        }
        if (i7 <= i4) {
            if (i7 < 0) {
                i6 = 0;
            } else {
                i6 = i7;
                z2 = false;
            }
            if (z2 && this.mChildHelper.getNestedScrollingParentForType(1) == null) {
                this.mScroller.springBack(i5, i6, 0, 0, 0, getScrollRange());
            }
            super.scrollTo(i5, i6);
            return !z || z2;
        }
        i6 = i4;
        z2 = true;
        if (z2) {
            this.mScroller.springBack(i5, i6, 0, 0, 0, getScrollRange());
        }
        super.scrollTo(i5, i6);
        if (z) {
        }
    }

    public final void pageScroll(int i) {
        boolean z = i == 130;
        int height = getHeight();
        Rect rect = this.mTempRect;
        if (z) {
            rect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                if (rect.top + height > paddingBottom) {
                    rect.top = paddingBottom - height;
                }
            }
        } else {
            int scrollY = getScrollY() - height;
            rect.top = scrollY;
            if (scrollY < 0) {
                rect.top = 0;
            }
        }
        int i2 = rect.top;
        int i3 = height + i2;
        rect.bottom = i3;
        scrollAndFocus(i, i2, i3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (this.mIsLayoutDirty) {
            this.mChildToScrollTo = view2;
        } else {
            Rect rect = this.mTempRect;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int iComputeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
            if (iComputeScrollDeltaToGetChildRectOnScreen != 0) {
                scrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen);
            }
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int iComputeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean z2 = iComputeScrollDeltaToGetChildRectOnScreen != 0;
        if (z2) {
            if (z) {
                scrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen);
                return z2;
            }
            smoothScrollBy(0, false, iComputeScrollDeltaToGetChildRectOnScreen);
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        VelocityTracker velocityTracker;
        if (z && (velocityTracker = this.mVelocityTracker) != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0068  */
    public final boolean scrollAndFocus(int i, int i2, int i3) {
        boolean z;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z2 = i == 33;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z3 = false;
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = focusables.get(i5);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i2 < bottom && top < i3) {
                boolean z4 = i2 < top && bottom < i3;
                if (view == null) {
                    view = view2;
                    z3 = z4;
                } else {
                    boolean z5 = (z2 && top < view.getTop()) || (!z2 && bottom > view.getBottom());
                    if (z3) {
                        if (z4 && z5) {
                            view = view2;
                        }
                    } else if (z4) {
                        view = view2;
                        z3 = true;
                    } else if (z5) {
                        view = view2;
                    }
                }
            }
        }
        View view3 = view == null ? this : view;
        if (i2 < scrollY || i3 > i4) {
            scrollBy(z2 ? i2 - scrollY : i3 - i4, -1, null, 0, 1, true);
            z = true;
        } else {
            z = false;
        }
        if (view3 != findFocus()) {
            view3.requestFocus(i);
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0116  */
    /* JADX WARN: Code duplicated, block: B:60:0x0127  */
    public final int scrollBy(int i, int i2, MotionEvent motionEvent, int i3, int i4, boolean z) {
        int i5;
        int i6;
        boolean z2;
        boolean z3;
        VelocityTracker velocityTracker;
        if (i4 == 1) {
            startNestedScroll(2, i4);
        }
        boolean zDispatchNestedPreScroll = dispatchNestedPreScroll(0, i, i4, this.mScrollConsumed, this.mScrollOffset);
        int[] iArr = this.mScrollOffset;
        int[] iArr2 = this.mScrollConsumed;
        if (zDispatchNestedPreScroll) {
            i5 = i - iArr2[1];
            i6 = iArr[1];
        } else {
            i5 = i;
            i6 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        int overScrollMode = getOverScrollMode();
        boolean z4 = (overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0)) && !z;
        boolean z5 = overScrollByCompat(i5, 0, scrollY, scrollRange) && this.mChildHelper.getNestedScrollingParentForType(i4) == null;
        int scrollY2 = getScrollY() - scrollY;
        if (motionEvent != null && scrollY2 != 0) {
            getScrollFeedbackProvider().mImpl.onScrollProgress(motionEvent.getDeviceId(), motionEvent.getSource(), i2, scrollY2);
        }
        iArr2[1] = 0;
        this.mChildHelper.dispatchNestedScrollInternal(0, scrollY2, 0, i5 - scrollY2, this.mScrollOffset, i4, iArr2);
        int i7 = i6 + iArr[1];
        int i8 = i5 - iArr2[1];
        int i9 = scrollY + i8;
        EdgeEffect edgeEffect = this.mEdgeGlowBottom;
        EdgeEffect edgeEffect2 = this.mEdgeGlowTop;
        if (i9 >= 0) {
            if (i9 > scrollRange && z4) {
                SizeKt.onPullDistance(edgeEffect, i8 / getHeight(), 1.0f - (i3 / getWidth()));
                if (motionEvent != null) {
                    z2 = false;
                    getScrollFeedbackProvider().mImpl.onScrollLimit(motionEvent.getDeviceId(), motionEvent.getSource(), i2, false);
                } else {
                    z2 = false;
                }
                if (!edgeEffect2.isFinished()) {
                    edgeEffect2.onRelease();
                }
            }
            if (edgeEffect2.isFinished() || !edgeEffect.isFinished()) {
                postInvalidateOnAnimation();
                z3 = z2;
            } else {
                z3 = z5;
            }
            if (z3 && i4 == 0 && (velocityTracker = this.mVelocityTracker) != null) {
                velocityTracker.clear();
            }
            if (i4 == 1) {
                stopNestedScroll(i4);
                edgeEffect2.onRelease();
                edgeEffect.onRelease();
            }
            return i7;
        }
        if (z4) {
            SizeKt.onPullDistance(edgeEffect2, (-i8) / getHeight(), i3 / getWidth());
            if (motionEvent != null) {
                getScrollFeedbackProvider().mImpl.onScrollLimit(motionEvent.getDeviceId(), motionEvent.getSource(), i2, true);
            }
            if (!edgeEffect.isFinished()) {
                edgeEffect.onRelease();
            }
        }
        z2 = false;
        if (edgeEffect2.isFinished()) {
            postInvalidateOnAnimation();
            z3 = z2;
        } else {
            postInvalidateOnAnimation();
            z3 = z2;
        }
        if (z3) {
            velocityTracker.clear();
        }
        if (i4 == 1) {
            stopNestedScroll(i4);
            edgeEffect2.onRelease();
            edgeEffect.onRelease();
        }
        return i7;
    }

    @Override // android.view.View
    public final void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (width >= width2 || i < 0) {
                i = 0;
            } else if (width + i > width2) {
                i = width2 - width;
            }
            if (height >= height2 || i2 < 0) {
                i2 = 0;
            } else if (height + i2 > height2) {
                i2 = height2 - height;
            }
            if (i == getScrollX() && i2 == getScrollY()) {
                return;
            }
            super.scrollTo(i, i2);
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.mFillViewport) {
            this.mFillViewport = z;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        Cache.RealCacheRequest realCacheRequest = this.mChildHelper;
        if (realCacheRequest.done) {
            NestedScrollView nestedScrollView = (NestedScrollView) realCacheRequest.body;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            nestedScrollView.stopNestedScroll();
        }
        realCacheRequest.done = z;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.mSmoothScrollingEnabled = z;
    }

    public final boolean shouldAbsorb(EdgeEffect edgeEffect, int i) {
        if (i > 0) {
            return true;
        }
        float distance = SizeKt.getDistance(edgeEffect) * getHeight();
        float fAbs = Math.abs(-i) * 0.35f;
        float f = this.mPhysicalCoeff * 0.015f;
        double dLog = Math.log(fAbs / f);
        double d = DECELERATION_RATE;
        return ((float) (Math.exp((d / (d - 1.0d)) * dLog) * ((double) f))) < distance;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int i, boolean z, int i2) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iMax = Math.max(0, Math.min(i2 + scrollY, Math.max(0, height - height2))) - scrollY;
            this.mScroller.startScroll(getScrollX(), scrollY, 0, iMax, 250);
            if (z) {
                startNestedScroll(2, 1);
            } else {
                stopNestedScroll(1);
            }
            this.mLastScrollerY = getScrollY();
            postInvalidateOnAnimation();
        } else {
            OverScroller overScroller = this.mScroller;
            if (!overScroller.isFinished()) {
                overScroller.abortAnimation();
                stopNestedScroll(1);
            }
            scrollBy(i, i2);
        }
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }

    public final boolean startNestedScroll(int i, int i2) {
        boolean zOnStartNestedScroll;
        Cache.RealCacheRequest realCacheRequest = this.mChildHelper;
        View view = (NestedScrollView) realCacheRequest.body;
        if (realCacheRequest.getNestedScrollingParentForType(i2) != null) {
            return true;
        }
        if (realCacheRequest.done) {
            View view2 = view;
            for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                boolean z = parent instanceof NestedScrollingParent2;
                if (z) {
                    zOnStartNestedScroll = ((NestedScrollingParent2) parent).onStartNestedScroll(view2, view, i, i2);
                } else if (i2 == 0) {
                    try {
                        zOnStartNestedScroll = parent.onStartNestedScroll(view2, view, i);
                    } catch (AbstractMethodError e) {
                        Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e);
                        zOnStartNestedScroll = false;
                    }
                } else {
                    zOnStartNestedScroll = false;
                }
                if (zOnStartNestedScroll) {
                    if (i2 == 0) {
                        realCacheRequest.editor = parent;
                    } else if (i2 == 1) {
                        realCacheRequest.cacheOut = parent;
                    }
                    if (z) {
                        ((NestedScrollingParent2) parent).onNestedScrollAccepted(view2, view, i, i2);
                        return true;
                    }
                    if (i2 != 0) {
                        return true;
                    }
                    try {
                        parent.onNestedScrollAccepted(view2, view, i);
                        return true;
                    } catch (AbstractMethodError e2) {
                        Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e2);
                        return true;
                    }
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
        }
        return false;
    }

    public final boolean stopGlowAnimations(MotionEvent motionEvent) {
        boolean z;
        EdgeEffect edgeEffect = this.mEdgeGlowTop;
        if (SizeKt.getDistance(edgeEffect) != CropImageView.DEFAULT_ASPECT_RATIO) {
            SizeKt.onPullDistance(edgeEffect, CropImageView.DEFAULT_ASPECT_RATIO, motionEvent.getX() / getWidth());
            z = true;
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.mEdgeGlowBottom;
        if (SizeKt.getDistance(edgeEffect2) == CropImageView.DEFAULT_ASPECT_RATIO) {
            return z;
        }
        SizeKt.onPullDistance(edgeEffect2, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    public final void stopNestedScroll(int i) {
        Cache.RealCacheRequest realCacheRequest = this.mChildHelper;
        ViewParent nestedScrollingParentForType = realCacheRequest.getNestedScrollingParentForType(i);
        if (nestedScrollingParentForType != null) {
            NestedScrollView nestedScrollView = (NestedScrollView) realCacheRequest.body;
            if (nestedScrollingParentForType instanceof NestedScrollingParent2) {
                ((NestedScrollingParent2) nestedScrollingParentForType).onStopNestedScroll(nestedScrollView, i);
            } else if (i == 0) {
                try {
                    nestedScrollingParentForType.onStopNestedScroll(nestedScrollView);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + nestedScrollingParentForType + " does not implement interface method onStopNestedScroll", e);
                }
            }
            if (i == 0) {
                realCacheRequest.editor = null;
            } else {
                if (i != 1) {
                    return;
                }
                realCacheRequest.cacheOut = null;
            }
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4, int i5) {
        onNestedScrollInternal(i4, i5, null);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void onNestedScroll(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        onNestedScrollInternal(i4, i5, iArr);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, 0, iArr, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i) {
        if (getChildCount() <= 0) {
            super.addView(view, i);
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("ScrollView can host only one direct child");
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("ScrollView can host only one direct child");
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i, layoutParams);
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("ScrollView can host only one direct child");
        }
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, 0, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i) {
        return startNestedScroll(i, 0);
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }
}
