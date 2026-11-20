package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.Toolbar.ExpandedActionViewMenuPresenter;
import androidx.compose.material3.FabPlacement;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;
import coil3.size.SizeKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.WeakHashMap;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {
    public static final int[] ATTRS = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    public static final WindowInsetsCompat NON_EMPTY_SYSTEM_WINDOW_INSETS;
    public static final Rect ZERO_INSETS;
    public boolean mActionBarExtendsIntoSystemInsets;
    public int mActionBarHeight;
    public ActionBarContainer mActionBarTop;
    public ActionBarVisibilityCallback mActionBarVisibilityCallback;
    public final AnonymousClass2 mAddActionBarHideOffset;
    public boolean mAnimatingForFling;
    public final Rect mBaseContentInsets;
    public WindowInsetsCompat mBaseInnerInsets;
    public ContentFrameLayout mContent;
    public final Rect mContentInsets;
    public ViewPropertyAnimator mCurrentActionBarTopAnimator;
    public boolean mDecorFitsSystemWindows;
    public DecorToolbar mDecorToolbar;
    public OverScroller mFlingEstimator;
    public boolean mHasNonEmbeddedTabs;
    public boolean mHideOnContentScroll;
    public int mHideOnContentScrollReference;
    public WindowInsetsCompat mInnerInsets;
    public final Rect mLastBaseContentInsets;
    public WindowInsetsCompat mLastBaseInnerInsets;
    public WindowInsetsCompat mLastInnerInsets;
    public int mLastSystemUiVisibility;
    public final NoSystemUiLayoutFlagView mNoSystemUiLayoutFlagView;
    public boolean mOverlayMode;
    public final FabPlacement mParentHelper;
    public final AnonymousClass2 mRemoveActionBarHideOffset;
    public final Rect mSystemInsets;
    public final Rect mTmpRect;
    public final ViewPropertyAnimatorCompat.AnonymousClass1 mTopAnimatorListener;
    public Drawable mWindowContentOverlay;
    public int mWindowVisibility;

    /* JADX INFO: renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 implements Runnable {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ ActionBarOverlayLayout this$0;

        public /* synthetic */ AnonymousClass2(ActionBarOverlayLayout actionBarOverlayLayout, byte b) {
            this.$r8$classId = b;
            this.this$0 = actionBarOverlayLayout;
        }

        @Override // java.lang.Runnable
        public final void run() {
            byte b = this.$r8$classId;
            ActionBarOverlayLayout actionBarOverlayLayout = this.this$0;
            switch (b) {
                case 0:
                    actionBarOverlayLayout.haltActionBarHideOffsetAnimations();
                    actionBarOverlayLayout.mCurrentActionBarTopAnimator = actionBarOverlayLayout.mActionBarTop.animate().translationY(CropImageView.DEFAULT_ASPECT_RATIO).setListener(actionBarOverlayLayout.mTopAnimatorListener);
                    break;
                default:
                    actionBarOverlayLayout.haltActionBarHideOffsetAnimations();
                    actionBarOverlayLayout.mCurrentActionBarTopAnimator = actionBarOverlayLayout.mActionBarTop.animate().translationY(-actionBarOverlayLayout.mActionBarTop.getHeight()).setListener(actionBarOverlayLayout.mTopAnimatorListener);
                    break;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface ActionBarVisibilityCallback {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LayoutParams extends ViewGroup.MarginLayoutParams {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class NoSystemUiLayoutFlagView extends View {
        @Override // android.view.View
        public final int getWindowSystemUiVisibility() {
            return 0;
        }
    }

    static {
        WindowInsetsCompat.BuilderImpl builderImpl29;
        int i = Build.VERSION.SDK_INT;
        if (i >= 36) {
            builderImpl29 = new WindowInsetsCompat.BuilderImpl36();
        } else if (i >= 35) {
            builderImpl29 = new WindowInsetsCompat.BuilderImpl35();
        } else if (i >= 34) {
            builderImpl29 = new WindowInsetsCompat.BuilderImpl34();
        } else if (i >= 31) {
            builderImpl29 = new WindowInsetsCompat.BuilderImpl31();
        } else if (i >= 30) {
            builderImpl29 = new WindowInsetsCompat.BuilderImpl30();
        } else {
            builderImpl29 = i >= 29 ? new WindowInsetsCompat.BuilderImpl29() : new WindowInsetsCompat.BuilderImpl20();
        }
        builderImpl29.setSystemWindowInsets(Insets.of(0, 1, 0, 1));
        NON_EMPTY_SYSTEM_WINDOW_INSETS = builderImpl29.build();
        ZERO_INSETS = new Rect();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWindowVisibility = 0;
        this.mBaseContentInsets = new Rect();
        this.mLastBaseContentInsets = new Rect();
        this.mContentInsets = new Rect();
        this.mSystemInsets = new Rect();
        this.mTmpRect = new Rect();
        this.mDecorFitsSystemWindows = true;
        this.mActionBarExtendsIntoSystemInsets = false;
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.CONSUMED;
        this.mBaseInnerInsets = windowInsetsCompat;
        this.mLastBaseInnerInsets = windowInsetsCompat;
        this.mInnerInsets = windowInsetsCompat;
        this.mLastInnerInsets = windowInsetsCompat;
        this.mTopAnimatorListener = new ViewPropertyAnimatorCompat.AnonymousClass1(this);
        this.mRemoveActionBarHideOffset = new AnonymousClass2(this, (byte) 0);
        this.mAddActionBarHideOffset = new AnonymousClass2(this, (byte) 1);
        init(context);
        this.mParentHelper = new FabPlacement();
        NoSystemUiLayoutFlagView noSystemUiLayoutFlagView = new NoSystemUiLayoutFlagView(context);
        noSystemUiLayoutFlagView.setWillNotDraw(true);
        this.mNoSystemUiLayoutFlagView = noSystemUiLayoutFlagView;
        addView(noSystemUiLayoutFlagView);
    }

    public static boolean setMargin(View view, int i, int i2, int i3, int i4) {
        boolean z;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin != i) {
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i;
            z = true;
        } else {
            z = false;
        }
        if (((ViewGroup.MarginLayoutParams) layoutParams).topMargin != i2) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i2;
            z = true;
        }
        if (((ViewGroup.MarginLayoutParams) layoutParams).rightMargin != i3) {
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i3;
            z = true;
        }
        if (((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin == i4) {
            return z;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i4;
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.mWindowContentOverlay != null) {
            if (this.mActionBarTop.getVisibility() == 0) {
                translationY = (int) (this.mActionBarTop.getTranslationY() + this.mActionBarTop.getBottom() + 0.5f);
            } else {
                translationY = 0;
            }
            this.mWindowContentOverlay.setBounds(0, translationY, getWidth(), this.mWindowContentOverlay.getIntrinsicHeight() + translationY);
            this.mWindowContentOverlay.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.mActionBarTop;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        FabPlacement fabPlacement = this.mParentHelper;
        return fabPlacement.height | fabPlacement.left;
    }

    public CharSequence getTitle() {
        pullChildren();
        return ((ToolbarWidgetWrapper) this.mDecorToolbar).mToolbar.getTitle();
    }

    public final void haltActionBarHideOffsetAnimations() {
        removeCallbacks(this.mRemoveActionBarHideOffset);
        removeCallbacks(this.mAddActionBarHideOffset);
        ViewPropertyAnimator viewPropertyAnimator = this.mCurrentActionBarTopAnimator;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void init(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(ATTRS);
        this.mActionBarHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.mWindowContentOverlay = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.mFlingEstimator = new OverScroller(context);
    }

    public final void initFeature(int i) {
        pullChildren();
        if (i == 2) {
            ((ToolbarWidgetWrapper) this.mDecorToolbar).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else if (i == 5) {
            ((ToolbarWidgetWrapper) this.mDecorToolbar).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else {
            if (i != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        boolean margin;
        pullChildren();
        int windowSystemUiVisibility = getWindowSystemUiVisibility();
        boolean z = true;
        boolean z2 = (windowSystemUiVisibility & 256) != 0;
        boolean z3 = (windowSystemUiVisibility & 1536) != 0;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        NoSystemUiLayoutFlagView noSystemUiLayoutFlagView = this.mNoSystemUiLayoutFlagView;
        WindowInsetsCompat windowInsetsCompat = NON_EMPTY_SYSTEM_WINDOW_INSETS;
        Rect rect = this.mTmpRect;
        ViewCompat.Api21Impl.computeSystemWindowInsets(noSystemUiLayoutFlagView, windowInsetsCompat, rect);
        boolean zEquals = rect.equals(ZERO_INSETS);
        this.mDecorFitsSystemWindows = !zEquals;
        boolean z4 = zEquals || (z2 && z3);
        this.mActionBarExtendsIntoSystemInsets = z4;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (actionBarVisibilityCallback != null) {
            ((WindowDecorActionBar) actionBarVisibilityCallback).mContentAnimations = (z2 || z4) ? false : true;
        }
        WindowInsetsCompat windowInsetsCompat2 = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, this);
        WindowInsetsCompat.Impl impl = windowInsetsCompat2.mImpl;
        Insets systemWindowInsets = impl.getSystemWindowInsets();
        int i = systemWindowInsets.left;
        int i2 = systemWindowInsets.left;
        int i3 = systemWindowInsets.top;
        int i4 = systemWindowInsets.right;
        this.mSystemInsets.set(i, i3, i4, systemWindowInsets.bottom);
        if (this.mActionBarExtendsIntoSystemInsets) {
            Insets insets = impl.getInsets(2);
            int i5 = insets.left;
            int i6 = insets.right;
            this.mActionBarTop.setPadding(i2 - i5, i3, i4 - i6, 0);
            margin = setMargin(this.mActionBarTop, insets.left, 0, i6, 0);
        } else {
            this.mActionBarTop.setPadding(0, 0, 0, 0);
            margin = setMargin(this.mActionBarTop, i2, i3, i4, 0);
        }
        Rect rect2 = this.mBaseContentInsets;
        ViewCompat.Api21Impl.computeSystemWindowInsets(this, windowInsetsCompat2, rect2);
        WindowInsetsCompat windowInsetsCompatInset = impl.inset(rect2.left, rect2.top, rect2.right, rect2.bottom);
        this.mBaseInnerInsets = windowInsetsCompatInset;
        if (!this.mLastBaseInnerInsets.equals(windowInsetsCompatInset)) {
            this.mLastBaseInnerInsets = this.mBaseInnerInsets;
            margin = true;
        }
        Rect rect3 = this.mLastBaseContentInsets;
        if (rect3.equals(rect2)) {
            z = margin;
        } else {
            rect3.set(rect2);
        }
        if (z) {
            requestLayout();
        }
        return impl.consumeDisplayCutout().mImpl.consumeSystemWindowInsets().mImpl.consumeStableInsets().toWindowInsets();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        init(getContext());
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        haltActionBarHideOffsetAnimations();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int measuredHeight;
        WindowInsetsCompat.BuilderImpl builderImpl29;
        pullChildren();
        measureChildWithMargins(this.mActionBarTop, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.mActionBarTop.getLayoutParams();
        int iMax = Math.max(0, this.mActionBarTop.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
        int iMax2 = Math.max(0, this.mActionBarTop.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.mActionBarTop.getMeasuredState());
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        boolean z = (getWindowSystemUiVisibility() & 256) != 0;
        if (z) {
            measuredHeight = this.mActionBarHeight;
            if (this.mActionBarExtendsIntoSystemInsets) {
                measuredHeight += this.mSystemInsets.top;
            }
            if (this.mHasNonEmbeddedTabs && this.mActionBarTop.getTabContainer() != null) {
                measuredHeight += this.mActionBarHeight;
            }
        } else {
            measuredHeight = this.mActionBarTop.getVisibility() != 8 ? this.mActionBarTop.getMeasuredHeight() : 0;
        }
        Rect rect = this.mBaseContentInsets;
        Rect rect2 = this.mContentInsets;
        rect2.set(rect);
        WindowInsetsCompat windowInsetsCompat = this.mBaseInnerInsets;
        this.mInnerInsets = windowInsetsCompat;
        if (this.mOverlayMode || z || !this.mDecorFitsSystemWindows) {
            Insets insetsOf = this.mActionBarExtendsIntoSystemInsets ? Insets.of(windowInsetsCompat.mImpl.getSystemWindowInsets().left, Math.max(this.mInnerInsets.mImpl.getSystemWindowInsets().top, measuredHeight), this.mInnerInsets.mImpl.getSystemWindowInsets().right, Math.max(this.mInnerInsets.mImpl.getSystemWindowInsets().bottom, 0)) : Insets.of(windowInsetsCompat.mImpl.getSystemWindowInsets().left, this.mInnerInsets.mImpl.getSystemWindowInsets().top + measuredHeight, this.mInnerInsets.mImpl.getSystemWindowInsets().right, this.mInnerInsets.mImpl.getSystemWindowInsets().bottom);
            WindowInsetsCompat windowInsetsCompat2 = this.mInnerInsets;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 36) {
                builderImpl29 = new WindowInsetsCompat.BuilderImpl36(windowInsetsCompat2);
            } else if (i3 >= 35) {
                builderImpl29 = new WindowInsetsCompat.BuilderImpl35(windowInsetsCompat2);
            } else if (i3 >= 34) {
                builderImpl29 = new WindowInsetsCompat.BuilderImpl34(windowInsetsCompat2);
            } else if (i3 >= 31) {
                builderImpl29 = new WindowInsetsCompat.BuilderImpl31(windowInsetsCompat2);
            } else if (i3 >= 30) {
                builderImpl29 = new WindowInsetsCompat.BuilderImpl30(windowInsetsCompat2);
            } else {
                builderImpl29 = i3 >= 29 ? new WindowInsetsCompat.BuilderImpl29(windowInsetsCompat2) : new WindowInsetsCompat.BuilderImpl20(windowInsetsCompat2);
            }
            builderImpl29.setSystemWindowInsets(insetsOf);
            this.mInnerInsets = builderImpl29.build();
        } else {
            boolean z2 = this.mActionBarExtendsIntoSystemInsets;
            int i4 = rect2.top;
            if (z2) {
                rect2.top = Math.max(i4, measuredHeight);
                rect2.bottom = Math.max(rect2.bottom, 0);
            } else {
                rect2.top = i4 + measuredHeight;
                rect2.bottom = rect2.bottom;
            }
            this.mInnerInsets = this.mInnerInsets.mImpl.inset(0, measuredHeight, 0, 0);
        }
        setMargin(this.mContent, rect2.left, rect2.top, rect2.right, rect2.bottom);
        if (!this.mLastInnerInsets.equals(this.mInnerInsets)) {
            WindowInsetsCompat windowInsetsCompat3 = this.mInnerInsets;
            this.mLastInnerInsets = windowInsetsCompat3;
            ViewCompat.dispatchApplyWindowInsets(this.mContent, windowInsetsCompat3);
        }
        measureChildWithMargins(this.mContent, i, 0, i2, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.mContent.getLayoutParams();
        int iMax3 = Math.max(iMax, this.mContent.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
        int iMax4 = Math.max(iMax2, this.mContent.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.mContent.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax3, getSuggestedMinimumWidth()), i, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax4, getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.mHideOnContentScroll || !z) {
            return false;
        }
        this.mFlingEstimator.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.mFlingEstimator.getFinalY() > this.mActionBarTop.getHeight()) {
            haltActionBarHideOffsetAnimations();
            this.mAddActionBarHideOffset.run();
        } else {
            haltActionBarHideOffsetAnimations();
            this.mRemoveActionBarHideOffset.run();
        }
        this.mAnimatingForFling = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.mHideOnContentScrollReference + i2;
        this.mHideOnContentScrollReference = i5;
        setActionBarHideOffset(i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        WindowDecorActionBar windowDecorActionBar;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.mParentHelper.left = i;
        this.mHideOnContentScrollReference = getActionBarHideOffset();
        haltActionBarHideOffsetAnimations();
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (actionBarVisibilityCallback == null || (viewPropertyAnimatorCompatSet = (windowDecorActionBar = (WindowDecorActionBar) actionBarVisibilityCallback).mCurrentShowAnim) == null) {
            return;
        }
        viewPropertyAnimatorCompatSet.cancel();
        windowDecorActionBar.mCurrentShowAnim = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.mActionBarTop.getVisibility() != 0) {
            return false;
        }
        return this.mHideOnContentScroll;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.mHideOnContentScroll || this.mAnimatingForFling) {
            return;
        }
        if (this.mHideOnContentScrollReference <= this.mActionBarTop.getHeight()) {
            haltActionBarHideOffsetAnimations();
            postDelayed(this.mRemoveActionBarHideOffset, 600L);
        } else {
            haltActionBarHideOffsetAnimations();
            postDelayed(this.mAddActionBarHideOffset, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        pullChildren();
        int i2 = this.mLastSystemUiVisibility ^ i;
        this.mLastSystemUiVisibility = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (actionBarVisibilityCallback != null) {
            WindowDecorActionBar windowDecorActionBar = (WindowDecorActionBar) actionBarVisibilityCallback;
            windowDecorActionBar.mContentAnimations = (z2 || this.mActionBarExtendsIntoSystemInsets) ? false : true;
            if (z || !z2) {
                if (windowDecorActionBar.mHiddenBySystem) {
                    windowDecorActionBar.mHiddenBySystem = false;
                    windowDecorActionBar.updateVisibility(true);
                }
            } else if (!windowDecorActionBar.mHiddenBySystem) {
                windowDecorActionBar.mHiddenBySystem = true;
                windowDecorActionBar.updateVisibility(true);
            }
        }
        if ((i2 & 256) == 0 || this.mActionBarVisibilityCallback == null) {
            return;
        }
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        requestApplyInsets();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.mWindowVisibility = i;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (actionBarVisibilityCallback != null) {
            ((WindowDecorActionBar) actionBarVisibilityCallback).mCurWindowVisibility = i;
        }
    }

    public final void pullChildren() {
        DecorToolbar wrapper;
        if (this.mContent == null) {
            this.mContent = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.mActionBarTop = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof DecorToolbar) {
                wrapper = (DecorToolbar) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                    return;
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.mDecorToolbar = wrapper;
        }
    }

    public void setActionBarHideOffset(int i) {
        haltActionBarHideOffsetAnimations();
        this.mActionBarTop.setTranslationY(-Math.max(0, Math.min(i, this.mActionBarTop.getHeight())));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.mActionBarVisibilityCallback = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            ((WindowDecorActionBar) this.mActionBarVisibilityCallback).mCurWindowVisibility = this.mWindowVisibility;
            int i = this.mLastSystemUiVisibility;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                requestApplyInsets();
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.mHasNonEmbeddedTabs = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.mHideOnContentScroll) {
            this.mHideOnContentScroll = z;
            if (z) {
                return;
            }
            haltActionBarHideOffsetAnimations();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        pullChildren();
        ToolbarWidgetWrapper toolbarWidgetWrapper = (ToolbarWidgetWrapper) this.mDecorToolbar;
        toolbarWidgetWrapper.mIcon = i != 0 ? SizeKt.getDrawable(toolbarWidgetWrapper.mToolbar.getContext(), i) : null;
        toolbarWidgetWrapper.updateToolbarLogo();
    }

    public void setLogo(int i) {
        pullChildren();
        ToolbarWidgetWrapper toolbarWidgetWrapper = (ToolbarWidgetWrapper) this.mDecorToolbar;
        toolbarWidgetWrapper.mLogo = i != 0 ? SizeKt.getDrawable(toolbarWidgetWrapper.mToolbar.getContext(), i) : null;
        toolbarWidgetWrapper.updateToolbarLogo();
    }

    public final void setMenu(MenuBuilder menuBuilder, MenuPresenter.Callback callback) {
        pullChildren();
        ToolbarWidgetWrapper toolbarWidgetWrapper = (ToolbarWidgetWrapper) this.mDecorToolbar;
        Toolbar toolbar = toolbarWidgetWrapper.mToolbar;
        ActionMenuPresenter actionMenuPresenter = toolbarWidgetWrapper.mActionMenuPresenter;
        if (actionMenuPresenter == null) {
            actionMenuPresenter = new ActionMenuPresenter(toolbar.getContext());
            toolbarWidgetWrapper.mActionMenuPresenter = actionMenuPresenter;
        }
        actionMenuPresenter.mCallback = callback;
        if (menuBuilder == null && toolbar.mMenuView == null) {
            return;
        }
        toolbar.ensureMenuView();
        MenuBuilder menuBuilder2 = toolbar.mMenuView.mMenu;
        if (menuBuilder2 == menuBuilder) {
            return;
        }
        if (menuBuilder2 != null) {
            menuBuilder2.removeMenuPresenter(toolbar.mOuterActionMenuPresenter);
            menuBuilder2.removeMenuPresenter(toolbar.mExpandedMenuPresenter);
        }
        if (toolbar.mExpandedMenuPresenter == null) {
            toolbar.mExpandedMenuPresenter = toolbar.new ExpandedActionViewMenuPresenter();
        }
        actionMenuPresenter.mExpandedActionViewsExclusive = true;
        Context context = toolbar.mPopupContext;
        if (menuBuilder != null) {
            menuBuilder.addMenuPresenter(actionMenuPresenter, context);
            menuBuilder.addMenuPresenter(toolbar.mExpandedMenuPresenter, toolbar.mPopupContext);
        } else {
            actionMenuPresenter.initForMenu(context, null);
            toolbar.mExpandedMenuPresenter.initForMenu(toolbar.mPopupContext, null);
            actionMenuPresenter.updateMenuView();
            toolbar.mExpandedMenuPresenter.updateMenuView();
        }
        toolbar.mMenuView.setPopupTheme(toolbar.mPopupTheme);
        toolbar.mMenuView.setPresenter(actionMenuPresenter);
        toolbar.mOuterActionMenuPresenter = actionMenuPresenter;
        toolbar.updateBackInvokedCallbackState();
    }

    public void setOverlayMode(boolean z) {
        this.mOverlayMode = z;
    }

    public void setWindowCallback(Window.Callback callback) {
        pullChildren();
        ((ToolbarWidgetWrapper) this.mDecorToolbar).mWindowCallback = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        pullChildren();
        ToolbarWidgetWrapper toolbarWidgetWrapper = (ToolbarWidgetWrapper) this.mDecorToolbar;
        if (toolbarWidgetWrapper.mTitleSet) {
            return;
        }
        Toolbar toolbar = toolbarWidgetWrapper.mToolbar;
        toolbarWidgetWrapper.mTitle = charSequence;
        if ((toolbarWidgetWrapper.mDisplayOpts & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (toolbarWidgetWrapper.mTitleSet) {
                ViewCompat.setAccessibilityPaneTitle(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(int i, int i2, int i3, int[] iArr) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(nestedScrollView, i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void onNestedScroll(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        onNestedScroll(nestedScrollView, i, i2, i3, i4, i5);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setIcon(Drawable drawable) {
        pullChildren();
        ToolbarWidgetWrapper toolbarWidgetWrapper = (ToolbarWidgetWrapper) this.mDecorToolbar;
        toolbarWidgetWrapper.mIcon = drawable;
        toolbarWidgetWrapper.updateToolbarLogo();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }
}
