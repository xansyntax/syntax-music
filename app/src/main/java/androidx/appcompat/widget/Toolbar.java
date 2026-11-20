package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.window.Api33Impl$$ExternalSyntheticLambda0;
import androidx.core.os.BundleCompat$Api33Impl;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.core.view.ViewCompat;
import androidx.core.widget.AutoScrollHelper$ClampedScroller;
import androidx.core.widget.ListViewAutoScrollHelper;
import androidx.customview.view.AbsSavedState;
import androidx.emoji2.text.EmojiProcessor;
import androidx.fragment.app.FragmentManager;
import androidx.media3.common.FlagSet;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.source.ProgressiveMediaPeriod;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.extractor.Extractor;
import coil3.size.SizeKt;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.text.RegexKt;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup implements MenuHost {
    public FlagSet.Builder mActionMenuPresenterCallback;
    public Api33Impl$$ExternalSyntheticLambda0 mBackInvokedCallback;
    public boolean mBackInvokedCallbackEnabled;
    public OnBackInvokedDispatcher mBackInvokedDispatcher;
    public final int mButtonGravity;
    public AppCompatImageButton mCollapseButtonView;
    public final CharSequence mCollapseDescription;
    public final Drawable mCollapseIcon;
    public boolean mCollapsible;
    public int mContentInsetEndWithActions;
    public int mContentInsetStartWithNavigation;
    public RtlSpacingHelper mContentInsets;
    public boolean mEatingHover;
    public boolean mEatingTouch;
    public View mExpandedActionView;
    public ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    public final int mGravity;
    public final ArrayList mHiddenViews;
    public AppCompatImageView mLogoView;
    public final int mMaxButtonHeight;
    public ToolbarActionBar.AnonymousClass2 mMenuBuilderCallback;
    public final MenuHostHelper mMenuHostHelper;
    public ActionMenuView mMenuView;
    public final AnonymousClass1 mMenuViewItemClickListener;
    public AppCompatImageButton mNavButtonView;
    public OnMenuItemClickListener mOnMenuItemClickListener;
    public ActionMenuPresenter mOuterActionMenuPresenter;
    public Context mPopupContext;
    public int mPopupTheme;
    public ArrayList mProvidedMenuItems;
    public final AnonymousClass2 mShowOverflowMenuRunnable;
    public CharSequence mSubtitleText;
    public int mSubtitleTextAppearance;
    public ColorStateList mSubtitleTextColor;
    public AppCompatTextView mSubtitleTextView;
    public final int[] mTempMargins;
    public final ArrayList mTempViews;
    public int mTitleMarginBottom;
    public int mTitleMarginEnd;
    public int mTitleMarginStart;
    public int mTitleMarginTop;
    public CharSequence mTitleText;
    public int mTitleTextAppearance;
    public ColorStateList mTitleTextColor;
    public AppCompatTextView mTitleTextView;
    public ToolbarWidgetWrapper mWrapper;

    /* JADX INFO: renamed from: androidx.appcompat.widget.Toolbar$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements ActionMenuView.OnMenuItemClickListener, MenuBuilder.Callback {
        public /* synthetic */ AnonymousClass1() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            Toolbar toolbar = Toolbar.this;
            ActionMenuPresenter actionMenuPresenter = toolbar.mMenuView.mPresenter;
            if (actionMenuPresenter == null || !actionMenuPresenter.isOverflowMenuShowing()) {
                Iterator it = toolbar.mMenuHostHelper.mMenuProviders.iterator();
                while (it.hasNext()) {
                    FragmentManager.this.dispatchPrepareOptionsMenu(menuBuilder);
                }
            }
            ToolbarActionBar.AnonymousClass2 anonymousClass2 = toolbar.mMenuBuilderCallback;
            if (anonymousClass2 != null) {
                anonymousClass2.onMenuModeChange(menuBuilder);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.Toolbar$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 implements Runnable {
        public final /* synthetic */ byte $r8$classId;
        public final Object this$0;

        public /* synthetic */ AnonymousClass2(byte b, Object obj) {
            this.$r8$classId = b;
            this.this$0 = obj;
        }

        /* JADX WARN: Code duplicated, block: B:101:0x01b5  */
        @Override // java.lang.Runnable
        public final void run() {
            int actionMasked;
            int i;
            Task taskAwaitTaskToRun;
            long jNanoTime;
            switch (this.$r8$classId) {
                case 0:
                    ((Toolbar) this.this$0).showOverflowMenu();
                    return;
                case 1:
                    ToolbarActionBar toolbarActionBar = (ToolbarActionBar) this.this$0;
                    Window.Callback callback = toolbarActionBar.mWindowCallback;
                    Menu menu = toolbarActionBar.getMenu();
                    MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
                    if (menuBuilder != null) {
                        menuBuilder.stopDispatchingItemsChanged();
                    }
                    try {
                        menu.clear();
                        if (!callback.onCreatePanelMenu(0, menu) || !callback.onPreparePanel(0, null, menu)) {
                            menu.clear();
                        }
                        if (menuBuilder != null) {
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        if (menuBuilder != null) {
                            menuBuilder.startDispatchingItemsChanged();
                        }
                    }
                    break;
                case 2:
                    DropDownListView dropDownListView = (DropDownListView) this.this$0;
                    dropDownListView.mResolveHoverRunnable = null;
                    dropDownListView.drawableStateChanged();
                    return;
                case 3:
                    SearchView.SearchAutoComplete searchAutoComplete = (SearchView.SearchAutoComplete) this.this$0;
                    if (searchAutoComplete.mHasPendingShowSoftInputRequest) {
                        ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
                        searchAutoComplete.mHasPendingShowSoftInputRequest = false;
                        return;
                    }
                    return;
                case 4:
                    AndroidComposeView androidComposeView = (AndroidComposeView) this.this$0;
                    androidComposeView.removeCallbacks(this);
                    MotionEvent motionEvent = androidComposeView.previousMotionEvent;
                    if (motionEvent == null || (actionMasked = motionEvent.getActionMasked()) == 10 || actionMasked == 1) {
                        return;
                    }
                    if (actionMasked == 2 || actionMasked == 7) {
                        i = 7;
                    } else if (actionMasked == 8) {
                        i = 9;
                    } else if (actionMasked != 9) {
                        i = 2;
                    } else {
                        i = 7;
                    }
                    androidComposeView.sendSimulatedEvent(motionEvent, i, androidComposeView.relayoutTime, false);
                    return;
                case 5:
                    ListViewAutoScrollHelper listViewAutoScrollHelper = (ListViewAutoScrollHelper) this.this$0;
                    DropDownListView dropDownListView2 = listViewAutoScrollHelper.mTarget$1;
                    AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = listViewAutoScrollHelper.mScroller;
                    if (listViewAutoScrollHelper.mAnimating) {
                        if (listViewAutoScrollHelper.mNeedsReset) {
                            listViewAutoScrollHelper.mNeedsReset = false;
                            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                            autoScrollHelper$ClampedScroller.mStartTime = jCurrentAnimationTimeMillis;
                            autoScrollHelper$ClampedScroller.mStopTime = -1L;
                            autoScrollHelper$ClampedScroller.mDeltaTime = jCurrentAnimationTimeMillis;
                            autoScrollHelper$ClampedScroller.mStopValue = 0.5f;
                        }
                        if ((autoScrollHelper$ClampedScroller.mStopTime > 0 && AnimationUtils.currentAnimationTimeMillis() > autoScrollHelper$ClampedScroller.mStopTime + ((long) autoScrollHelper$ClampedScroller.mEffectiveRampDown)) || !listViewAutoScrollHelper.shouldAnimate()) {
                            listViewAutoScrollHelper.mAnimating = false;
                            return;
                        }
                        if (listViewAutoScrollHelper.mNeedsCancel) {
                            listViewAutoScrollHelper.mNeedsCancel = false;
                            long jUptimeMillis = SystemClock.uptimeMillis();
                            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0);
                            dropDownListView2.onTouchEvent(motionEventObtain);
                            motionEventObtain.recycle();
                        }
                        if (autoScrollHelper$ClampedScroller.mDeltaTime == 0) {
                            throw new RuntimeException("Cannot compute scroll delta before calling start()");
                        }
                        long jCurrentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                        float valueAt = autoScrollHelper$ClampedScroller.getValueAt(jCurrentAnimationTimeMillis2);
                        long j = jCurrentAnimationTimeMillis2 - autoScrollHelper$ClampedScroller.mDeltaTime;
                        autoScrollHelper$ClampedScroller.mDeltaTime = jCurrentAnimationTimeMillis2;
                        listViewAutoScrollHelper.mTarget.scrollListBy((int) (j * ((valueAt * 4.0f) + ((-4.0f) * valueAt * valueAt)) * autoScrollHelper$ClampedScroller.mTargetVelocityY));
                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        dropDownListView2.postOnAnimation(this);
                        return;
                    }
                    return;
                case 6:
                    ProgressiveMediaPeriod progressiveMediaPeriod = (ProgressiveMediaPeriod) this.this$0;
                    for (SampleQueue sampleQueue : progressiveMediaPeriod.sampleQueues) {
                        sampleQueue.reset(true);
                        DrmSession drmSession = sampleQueue.currentDrmSession;
                        if (drmSession != null) {
                            drmSession.release(sampleQueue.drmEventDispatcher);
                            sampleQueue.currentDrmSession = null;
                            sampleQueue.downstreamFormat = null;
                        }
                    }
                    EmojiProcessor emojiProcessor = progressiveMediaPeriod.progressiveMediaExtractor;
                    Extractor extractor = (Extractor) emojiProcessor.mMetadataRepo;
                    if (extractor != null) {
                        extractor.release();
                        emojiProcessor.mMetadataRepo = null;
                    }
                    emojiProcessor.mGlyphChecker = null;
                    return;
                default:
                    TaskRunner taskRunner = (TaskRunner) this.this$0;
                    synchronized (taskRunner) {
                        taskRunner.runCallCount++;
                        taskAwaitTaskToRun = taskRunner.awaitTaskToRun();
                    }
                    if (taskAwaitTaskToRun == null) {
                        return;
                    }
                    Thread threadCurrentThread = Thread.currentThread();
                    String name = threadCurrentThread.getName();
                    do {
                        Task task = taskAwaitTaskToRun;
                        try {
                            threadCurrentThread.setName(task.name);
                            Logger logger = ((TaskRunner) this.this$0).logger$1;
                            TaskQueue taskQueue = task.queue;
                            taskQueue.getClass();
                            boolean zIsLoggable = logger.isLoggable(Level.FINE);
                            if (zIsLoggable) {
                                jNanoTime = System.nanoTime();
                                RegexKt.log(logger, task, taskQueue, "starting");
                            } else {
                                jNanoTime = -1;
                            }
                            try {
                                long jRunOnce = task.runOnce();
                                if (zIsLoggable) {
                                    RegexKt.log(logger, task, taskQueue, "finished run in " + RegexKt.formatDuration(System.nanoTime() - jNanoTime));
                                }
                                TaskRunner taskRunner2 = (TaskRunner) this.this$0;
                                synchronized (taskRunner2) {
                                    taskRunner2.afterRun(task, jRunOnce, true);
                                    taskAwaitTaskToRun = taskRunner2.awaitTaskToRun();
                                }
                            } catch (Throwable th) {
                                if (zIsLoggable) {
                                    RegexKt.log(logger, task, taskQueue, "failed a run in " + RegexKt.formatDuration(System.nanoTime() - jNanoTime));
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            try {
                                TaskRunner taskRunner3 = (TaskRunner) this.this$0;
                                synchronized (taskRunner3) {
                                    taskRunner3.afterRun(task, -1L, false);
                                    if (!(th2 instanceof InterruptedException)) {
                                        throw th2;
                                    }
                                    Thread.currentThread().interrupt();
                                }
                            } catch (Throwable th3) {
                                threadCurrentThread.setName(name);
                                throw th3;
                            }
                        }
                    } while (taskAwaitTaskToRun != null);
                    threadCurrentThread.setName(name);
                    return;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.Toolbar$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ AnonymousClass4(byte b, Object obj) {
            this.$r8$classId = b;
            this.this$0 = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            byte b = this.$r8$classId;
            Object obj = this.this$0;
            switch (b) {
                case 0:
                    ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = ((Toolbar) obj).mExpandedMenuPresenter;
                    MenuItemImpl menuItemImpl = expandedActionViewMenuPresenter == null ? null : expandedActionViewMenuPresenter.mCurrentExpandedItem;
                    if (menuItemImpl != null) {
                        menuItemImpl.collapseActionView();
                    }
                    break;
                case 1:
                    AlertController alertController = (AlertController) obj;
                    alertController.mHandler.obtainMessage(1, alertController.mDialog).sendToTarget();
                    break;
                default:
                    ((ActionMode) obj).finish();
                    break;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public interface OnMenuItemClickListener {
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AbsSavedState.AnonymousClass2(2);
        public int expandedMenuItemId;
        public boolean isOverflowOpen;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.expandedMenuItemId = parcel.readInt();
            this.isOverflowOpen = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen ? 1 : 0);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.toolbarStyle);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList();
        this.mHiddenViews = new ArrayList();
        this.mTempMargins = new int[2];
        this.mMenuHostHelper = new MenuHostHelper(new Toolbar$$ExternalSyntheticLambda0(this, (byte) 1));
        this.mProvidedMenuItems = new ArrayList();
        this.mMenuViewItemClickListener = new AnonymousClass1();
        this.mShowOverflowMenuRunnable = new AnonymousClass2((byte) 0, this);
        Context context2 = getContext();
        int[] iArr = R$styleable.Toolbar;
        EmojiProcessor emojiProcessorObtainStyledAttributes = EmojiProcessor.obtainStyledAttributes(context2, attributeSet, iArr, R.attr.toolbarStyle);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, (TypedArray) emojiProcessorObtainStyledAttributes.mMetadataRepo, R.attr.toolbarStyle);
        TypedArray typedArray = (TypedArray) emojiProcessorObtainStyledAttributes.mMetadataRepo;
        this.mTitleTextAppearance = typedArray.getResourceId(28, 0);
        this.mSubtitleTextAppearance = typedArray.getResourceId(19, 0);
        this.mGravity = typedArray.getInteger(0, 8388627);
        this.mButtonGravity = typedArray.getInteger(2, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = typedArray.hasValue(27) ? typedArray.getDimensionPixelOffset(27, dimensionPixelOffset) : dimensionPixelOffset;
        this.mTitleMarginBottom = dimensionPixelOffset;
        this.mTitleMarginTop = dimensionPixelOffset;
        this.mTitleMarginEnd = dimensionPixelOffset;
        this.mTitleMarginStart = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.mTitleMarginStart = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.mTitleMarginEnd = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.mTitleMarginTop = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.mTitleMarginBottom = dimensionPixelOffset5;
        }
        this.mMaxButtonHeight = typedArray.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(8, 0);
        ensureContentInsets();
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        rtlSpacingHelper.mIsRelative = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            rtlSpacingHelper.mExplicitLeft = dimensionPixelSize;
            rtlSpacingHelper.mLeft = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            rtlSpacingHelper.mExplicitRight = dimensionPixelSize2;
            rtlSpacingHelper.mRight = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            rtlSpacingHelper.setRelative(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.mContentInsetStartWithNavigation = typedArray.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = typedArray.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.mCollapseIcon = emojiProcessorObtainStyledAttributes.getDrawable(4);
        this.mCollapseDescription = typedArray.getText(3);
        CharSequence text = typedArray.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.mPopupContext = getContext();
        setPopupTheme(typedArray.getResourceId(17, 0));
        Drawable drawable = emojiProcessorObtainStyledAttributes.getDrawable(16);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        CharSequence text3 = typedArray.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawable2 = emojiProcessorObtainStyledAttributes.getDrawable(11);
        if (drawable2 != null) {
            setLogo(drawable2);
        }
        CharSequence text4 = typedArray.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(29)) {
            setTitleTextColor(emojiProcessorObtainStyledAttributes.getColorStateList(29));
        }
        if (typedArray.hasValue(20)) {
            setSubtitleTextColor(emojiProcessorObtainStyledAttributes.getColorStateList(20));
        }
        if (typedArray.hasValue(14)) {
            getMenuInflater().inflate(typedArray.getResourceId(14, 0), getMenu());
        }
        emojiProcessorObtainStyledAttributes.recycle();
    }

    public static LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.mViewType = (byte) 0;
        layoutParams.gravity = 8388627;
        return layoutParams;
    }

    public static LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean z = layoutParams instanceof LayoutParams;
        if (z) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            LayoutParams layoutParams3 = new LayoutParams(layoutParams2);
            layoutParams3.mViewType = (byte) 0;
            layoutParams3.mViewType = layoutParams2.mViewType;
            return layoutParams3;
        }
        if (z) {
            LayoutParams layoutParams4 = new LayoutParams((LayoutParams) layoutParams);
            layoutParams4.mViewType = (byte) 0;
            return layoutParams4;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            LayoutParams layoutParams5 = new LayoutParams(layoutParams);
            layoutParams5.mViewType = (byte) 0;
            return layoutParams5;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        LayoutParams layoutParams6 = new LayoutParams(marginLayoutParams);
        layoutParams6.mViewType = (byte) 0;
        ((ViewGroup.MarginLayoutParams) layoutParams6).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin = marginLayoutParams.bottomMargin;
        return layoutParams6;
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i = 0; i < menu.size(); i++) {
            arrayList.add(menu.getItem(i));
        }
        return arrayList;
    }

    public static int getHorizontalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    public static int getVerticalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void addCustomViewsWithGravity(int i, ArrayList arrayList) {
        boolean z = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection());
        arrayList.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mViewType == 0 && shouldLayout(childAt)) {
                    int i3 = layoutParams.gravity;
                    int layoutDirection = getLayoutDirection();
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i3, layoutDirection) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = layoutDirection == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.mViewType == 0 && shouldLayout(childAt2)) {
                int i5 = layoutParams2.gravity;
                int layoutDirection2 = getLayoutDirection();
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i5, layoutDirection2) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    @Override // androidx.core.view.MenuHost
    public final void addMenuProvider(MenuProvider menuProvider) {
        MenuHostHelper menuHostHelper = this.mMenuHostHelper;
        menuHostHelper.mMenuProviders.add(menuProvider);
        menuHostHelper.mOnInvalidateMenuCallback.run();
    }

    public final void addSystemView(View view, boolean z) {
        LayoutParams layoutParamsGenerateLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParamsGenerateLayoutParams = generateDefaultLayoutParams();
        } else {
            layoutParamsGenerateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (LayoutParams) layoutParams;
        }
        layoutParamsGenerateLayoutParams.mViewType = (byte) 1;
        if (!z || this.mExpandedActionView == null) {
            addView(view, layoutParamsGenerateLayoutParams);
        } else {
            view.setLayoutParams(layoutParamsGenerateLayoutParams);
            this.mHiddenViews.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public final void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.mCollapseButtonView = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            layoutParamsGenerateDefaultLayoutParams.gravity = (this.mButtonGravity & 112) | 8388611;
            layoutParamsGenerateDefaultLayoutParams.mViewType = (byte) 2;
            this.mCollapseButtonView.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener(new AnonymousClass4((byte) 0, this));
        }
    }

    public final void ensureContentInsets() {
        if (this.mContentInsets == null) {
            RtlSpacingHelper rtlSpacingHelper = new RtlSpacingHelper();
            rtlSpacingHelper.mLeft = 0;
            rtlSpacingHelper.mRight = 0;
            rtlSpacingHelper.mStart = Integer.MIN_VALUE;
            rtlSpacingHelper.mEnd = Integer.MIN_VALUE;
            rtlSpacingHelper.mExplicitLeft = 0;
            rtlSpacingHelper.mExplicitRight = 0;
            rtlSpacingHelper.mIsRtl = false;
            rtlSpacingHelper.mIsRelative = false;
            this.mContentInsets = rtlSpacingHelper;
        }
    }

    public final void ensureMenu() {
        ensureMenuView();
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView.mMenu == null) {
            MenuBuilder menuBuilder = (MenuBuilder) actionMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
            updateBackInvokedCallbackState();
        }
    }

    public final void ensureMenuView() {
        if (this.mMenuView == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.mMenuView = actionMenuView;
            actionMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            ActionMenuView actionMenuView2 = this.mMenuView;
            FlagSet.Builder builder = this.mActionMenuPresenterCallback;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1();
            actionMenuView2.mActionMenuPresenterCallback = builder;
            actionMenuView2.mMenuBuilderCallback = anonymousClass1;
            LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            layoutParamsGenerateDefaultLayoutParams.gravity = (this.mButtonGravity & 112) | 8388613;
            this.mMenuView.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
            addSystemView(this.mMenuView, false);
        }
    }

    public final void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            layoutParamsGenerateDefaultLayoutParams.gravity = (this.mButtonGravity & 112) | 8388611;
            this.mNavButtonView.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
        }
    }

    public final int getChildTop(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int i3 = layoutParams.gravity & 112;
        if (i3 != 16 && i3 != 48 && i3 != 80) {
            i3 = this.mGravity & 112;
        }
        if (i3 == 48) {
            return getPaddingTop() - i2;
        }
        if (i3 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        if (iMax < i4) {
            iMax = i4;
        } else {
            int i5 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            if (i5 < i6) {
                iMax = Math.max(0, iMax - (i6 - i5));
            }
        }
        return paddingTop + iMax;
    }

    public CharSequence getCollapseContentDescription() {
        AppCompatImageButton appCompatImageButton = this.mCollapseButtonView;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        AppCompatImageButton appCompatImageButton = this.mCollapseButtonView;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.mIsRtl ? rtlSpacingHelper.mLeft : rtlSpacingHelper.mRight;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.mContentInsetEndWithActions;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.mLeft;
        }
        return 0;
    }

    public int getContentInsetRight() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.mRight;
        }
        return 0;
    }

    public int getContentInsetStart() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.mIsRtl ? rtlSpacingHelper.mRight : rtlSpacingHelper.mLeft;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.mContentInsetStartWithNavigation;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        MenuBuilder menuBuilder;
        ActionMenuView actionMenuView = this.mMenuView;
        return (actionMenuView == null || (menuBuilder = actionMenuView.mMenu) == null || !menuBuilder.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        AppCompatImageView appCompatImageView = this.mLogoView;
        if (appCompatImageView != null) {
            return appCompatImageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        AppCompatImageView appCompatImageView = this.mLogoView;
        if (appCompatImageView != null) {
            return appCompatImageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    public View getNavButtonView() {
        return this.mNavButtonView;
    }

    public CharSequence getNavigationContentDescription() {
        AppCompatImageButton appCompatImageButton = this.mNavButtonView;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        AppCompatImageButton appCompatImageButton = this.mNavButtonView;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getDrawable();
        }
        return null;
    }

    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.mPopupContext;
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    public final TextView getSubtitleTextView() {
        return this.mSubtitleTextView;
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    public final TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    public DecorToolbar getWrapper() {
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.mWrapper;
        if (toolbarWidgetWrapper != null) {
            return toolbarWidgetWrapper;
        }
        ToolbarWidgetWrapper toolbarWidgetWrapper2 = new ToolbarWidgetWrapper(this, true);
        this.mWrapper = toolbarWidgetWrapper2;
        return toolbarWidgetWrapper2;
    }

    public final void invalidateMenu() {
        ArrayList arrayList = this.mProvidedMenuItems;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            getMenu().removeItem(((MenuItem) obj).getItemId());
        }
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        MenuInflater menuInflater = getMenuInflater();
        Iterator it = this.mMenuHostHelper.mMenuProviders.iterator();
        while (it.hasNext()) {
            FragmentManager.this.dispatchCreateOptionsMenu(menu, menuInflater);
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.mProvidedMenuItems = currentMenuItems2;
    }

    public final boolean isChildOrHidden(View view) {
        return view.getParent() == this || this.mHiddenViews.contains(view);
    }

    public final boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.mMenuView;
        return (actionMenuView == null || (actionMenuPresenter = actionMenuView.mPresenter) == null || !actionMenuPresenter.isOverflowMenuShowing()) ? false : true;
    }

    public final int layoutChildLeft(View view, int i, int i2, int[] iArr) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - iArr[0];
        int iMax = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        int childTop = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, childTop, iMax + measuredWidth, view.getMeasuredHeight() + childTop);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + iMax;
    }

    public final int layoutChildRight(View view, int i, int i2, int[] iArr) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - iArr[1];
        int iMax = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int childTop = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, childTop, iMax, view.getMeasuredHeight() + childTop);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
    }

    public final int measureChildCollapseMargins(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i6) + Math.max(0, i5);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + iMax + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public final void measureChildConstrained(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i4 >= 0) {
            if (mode != 0) {
                i4 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i4);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateBackInvokedCallbackState();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
        updateBackInvokedCallbackState();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.mEatingHover = false;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x024b  */
    /* JADX WARN: Code duplicated, block: B:102:0x024e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0270  */
    /* JADX WARN: Code duplicated, block: B:105:0x0273  */
    /* JADX WARN: Code duplicated, block: B:108:0x0285 A[LOOP:0: B:107:0x0283->B:108:0x0285, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:111:0x029d A[LOOP:1: B:110:0x029b->B:111:0x029d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:114:0x02bd A[LOOP:2: B:113:0x02bb->B:114:0x02bd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:118:0x0303 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:119:0x0305  */
    /* JADX WARN: Code duplicated, block: B:120:0x0309  */
    /* JADX WARN: Code duplicated, block: B:123:0x0310 A[LOOP:3: B:122:0x030e->B:123:0x0310, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:20:0x0060  */
    /* JADX WARN: Code duplicated, block: B:22:0x0064  */
    /* JADX WARN: Code duplicated, block: B:23:0x0069  */
    /* JADX WARN: Code duplicated, block: B:26:0x0075  */
    /* JADX WARN: Code duplicated, block: B:28:0x0079  */
    /* JADX WARN: Code duplicated, block: B:29:0x007e  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:44:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:47:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:48:0x0115  */
    /* JADX WARN: Code duplicated, block: B:51:0x011b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x011d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0120  */
    /* JADX WARN: Code duplicated, block: B:55:0x0124  */
    /* JADX WARN: Code duplicated, block: B:56:0x0127  */
    /* JADX WARN: Code duplicated, block: B:59:0x0139  */
    /* JADX WARN: Code duplicated, block: B:61:0x0141 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:68:0x015a  */
    /* JADX WARN: Code duplicated, block: B:70:0x015e  */
    /* JADX WARN: Code duplicated, block: B:72:0x016f  */
    /* JADX WARN: Code duplicated, block: B:73:0x0171  */
    /* JADX WARN: Code duplicated, block: B:75:0x017d  */
    /* JADX WARN: Code duplicated, block: B:77:0x0189  */
    /* JADX WARN: Code duplicated, block: B:78:0x0193  */
    /* JADX WARN: Code duplicated, block: B:80:0x01a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:82:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:85:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:86:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:88:0x01df  */
    /* JADX WARN: Code duplicated, block: B:89:0x0203  */
    /* JADX WARN: Code duplicated, block: B:91:0x0206  */
    /* JADX WARN: Code duplicated, block: B:93:0x020e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x0210  */
    /* JADX WARN: Code duplicated, block: B:96:0x0214  */
    /* JADX WARN: Code duplicated, block: B:99:0x0228  */
    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iLayoutChildLeft;
        int iLayoutChildRight;
        int iMax;
        int iMin;
        boolean zShouldLayout;
        boolean zShouldLayout2;
        int measuredHeight;
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i5;
        boolean z2;
        int i6;
        int i7;
        int paddingTop;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int iMax2;
        int i14;
        int i15;
        int i16;
        int i17;
        ArrayList arrayList;
        int size;
        int iLayoutChildLeft2;
        int i18;
        int size2;
        int i19;
        int i20;
        int size3;
        int i21;
        int i22;
        int measuredWidth;
        int i23;
        int i24;
        int i25;
        int size4;
        AppCompatImageView appCompatImageView;
        View view;
        ActionMenuView actionMenuView;
        AppCompatImageButton appCompatImageButton;
        boolean z3 = getLayoutDirection() == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i26 = width - paddingRight;
        int[] iArr = this.mTempMargins;
        iArr[1] = 0;
        iArr[0] = 0;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        int minimumHeight = getMinimumHeight();
        int iMin2 = minimumHeight >= 0 ? Math.min(minimumHeight, i4 - i2) : 0;
        if (shouldLayout(this.mNavButtonView)) {
            AppCompatImageButton appCompatImageButton2 = this.mNavButtonView;
            if (z3) {
                iLayoutChildRight = layoutChildRight(appCompatImageButton2, i26, iMin2, iArr);
                iLayoutChildLeft = paddingLeft;
            } else {
                iLayoutChildLeft = layoutChildLeft(appCompatImageButton2, paddingLeft, iMin2, iArr);
            }
            if (shouldLayout(this.mCollapseButtonView)) {
                appCompatImageButton = this.mCollapseButtonView;
                if (z3) {
                    iLayoutChildRight = layoutChildRight(appCompatImageButton, iLayoutChildRight, iMin2, iArr);
                } else {
                    iLayoutChildLeft = layoutChildLeft(appCompatImageButton, iLayoutChildLeft, iMin2, iArr);
                }
            }
            if (shouldLayout(this.mMenuView)) {
                actionMenuView = this.mMenuView;
                if (z3) {
                    iLayoutChildLeft = layoutChildLeft(actionMenuView, iLayoutChildLeft, iMin2, iArr);
                } else {
                    iLayoutChildRight = layoutChildRight(actionMenuView, iLayoutChildRight, iMin2, iArr);
                }
            }
            int currentContentInsetLeft = getCurrentContentInsetLeft();
            int currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - iLayoutChildLeft);
            iArr[1] = Math.max(0, currentContentInsetRight - (i26 - iLayoutChildRight));
            iMax = Math.max(iLayoutChildLeft, currentContentInsetLeft);
            iMin = Math.min(iLayoutChildRight, i26 - currentContentInsetRight);
            if (shouldLayout(this.mExpandedActionView)) {
                view = this.mExpandedActionView;
                if (z3) {
                    iMin = layoutChildRight(view, iMin, iMin2, iArr);
                } else {
                    iMax = layoutChildLeft(view, iMax, iMin2, iArr);
                }
            }
            if (shouldLayout(this.mLogoView)) {
                appCompatImageView = this.mLogoView;
                if (z3) {
                    iMin = layoutChildRight(appCompatImageView, iMin, iMin2, iArr);
                } else {
                    iMax = layoutChildLeft(appCompatImageView, iMax, iMin2, iArr);
                }
            }
            zShouldLayout = shouldLayout(this.mTitleTextView);
            zShouldLayout2 = shouldLayout(this.mSubtitleTextView);
            if (zShouldLayout) {
                LayoutParams layoutParams3 = (LayoutParams) this.mTitleTextView.getLayoutParams();
                measuredHeight = this.mTitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin;
            } else {
                measuredHeight = 0;
            }
            if (zShouldLayout2) {
                LayoutParams layoutParams4 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
                measuredHeight = this.mSubtitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin + measuredHeight;
            }
            if (zShouldLayout || zShouldLayout2) {
                if (zShouldLayout) {
                    appCompatTextView = this.mTitleTextView;
                } else {
                    appCompatTextView = this.mSubtitleTextView;
                }
                if (zShouldLayout2) {
                    appCompatTextView2 = this.mSubtitleTextView;
                } else {
                    appCompatTextView2 = this.mTitleTextView;
                }
                layoutParams = (LayoutParams) appCompatTextView.getLayoutParams();
                layoutParams2 = (LayoutParams) appCompatTextView2.getLayoutParams();
                i5 = measuredHeight;
                z2 = (!zShouldLayout && this.mTitleTextView.getMeasuredWidth() > 0) || (zShouldLayout2 && this.mSubtitleTextView.getMeasuredWidth() > 0);
                i6 = this.mGravity & 112;
                i7 = iMax;
                if (i6 == 48) {
                    paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + this.mTitleMarginTop;
                } else if (i6 != 80) {
                    iMax2 = (((height - paddingTop2) - paddingBottom) - i5) / 2;
                    i14 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + this.mTitleMarginTop;
                    if (iMax2 < i14) {
                        iMax2 = i14;
                    } else {
                        i15 = (((height - paddingBottom) - i5) - iMax2) - paddingTop2;
                        i16 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        i17 = this.mTitleMarginBottom;
                        if (i15 < i16 + i17) {
                            iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin + i17) - i15));
                        }
                    }
                    paddingTop = paddingTop2 + iMax2;
                } else {
                    paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin) - this.mTitleMarginBottom) - i5;
                }
                if (z3) {
                    if (z2) {
                        i11 = this.mTitleMarginStart;
                    } else {
                        i11 = 0;
                    }
                    int i27 = i11 - iArr[1];
                    iMin -= Math.max(0, i27);
                    iArr[1] = Math.max(0, -i27);
                    if (zShouldLayout) {
                        LayoutParams layoutParams5 = (LayoutParams) this.mTitleTextView.getLayoutParams();
                        int measuredWidth2 = iMin - this.mTitleTextView.getMeasuredWidth();
                        int measuredHeight2 = this.mTitleTextView.getMeasuredHeight() + paddingTop;
                        this.mTitleTextView.layout(measuredWidth2, paddingTop, iMin, measuredHeight2);
                        i12 = measuredWidth2 - this.mTitleMarginEnd;
                        paddingTop = measuredHeight2 + ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin;
                    } else {
                        i12 = iMin;
                    }
                    if (zShouldLayout2) {
                        int i28 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
                        this.mSubtitleTextView.layout(iMin - this.mSubtitleTextView.getMeasuredWidth(), i28, iMin, this.mSubtitleTextView.getMeasuredHeight() + i28);
                        i13 = iMin - this.mTitleMarginEnd;
                    } else {
                        i13 = iMin;
                    }
                    if (z2) {
                        iMin = Math.min(i12, i13);
                    }
                    iMax = i7;
                } else {
                    if (z2) {
                        i8 = this.mTitleMarginStart;
                    } else {
                        i8 = 0;
                    }
                    int i29 = i8 - iArr[0];
                    iMax = Math.max(0, i29) + i7;
                    iArr[0] = Math.max(0, -i29);
                    if (zShouldLayout) {
                        LayoutParams layoutParams6 = (LayoutParams) this.mTitleTextView.getLayoutParams();
                        int measuredWidth3 = this.mTitleTextView.getMeasuredWidth() + iMax;
                        int measuredHeight3 = this.mTitleTextView.getMeasuredHeight() + paddingTop;
                        this.mTitleTextView.layout(iMax, paddingTop, measuredWidth3, measuredHeight3);
                        i9 = measuredWidth3 + this.mTitleMarginEnd;
                        paddingTop = measuredHeight3 + ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin;
                    } else {
                        i9 = iMax;
                    }
                    if (zShouldLayout2) {
                        int i30 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
                        int measuredWidth4 = this.mSubtitleTextView.getMeasuredWidth() + iMax;
                        this.mSubtitleTextView.layout(iMax, i30, measuredWidth4, this.mSubtitleTextView.getMeasuredHeight() + i30);
                        i10 = measuredWidth4 + this.mTitleMarginEnd;
                    } else {
                        i10 = iMax;
                    }
                    if (z2) {
                        iMax = Math.max(i9, i10);
                    }
                }
            }
            arrayList = this.mTempViews;
            addCustomViewsWithGravity(3, arrayList);
            size = arrayList.size();
            iLayoutChildLeft2 = iMax;
            for (i18 = 0; i18 < size; i18++) {
                iLayoutChildLeft2 = layoutChildLeft((View) arrayList.get(i18), iLayoutChildLeft2, iMin2, iArr);
            }
            addCustomViewsWithGravity(5, arrayList);
            size2 = arrayList.size();
            for (i19 = 0; i19 < size2; i19++) {
                iMin = layoutChildRight((View) arrayList.get(i19), iMin, iMin2, iArr);
            }
            addCustomViewsWithGravity(1, arrayList);
            int i31 = iArr[0];
            i20 = iArr[1];
            size3 = arrayList.size();
            i21 = i31;
            i22 = 0;
            measuredWidth = 0;
            while (i22 < size3) {
                View view2 = (View) arrayList.get(i22);
                LayoutParams layoutParams7 = (LayoutParams) view2.getLayoutParams();
                int i32 = i20;
                int i33 = ((ViewGroup.MarginLayoutParams) layoutParams7).leftMargin - i21;
                int i34 = ((ViewGroup.MarginLayoutParams) layoutParams7).rightMargin - i32;
                int iMax3 = Math.max(0, i33);
                int iMax4 = Math.max(0, i34);
                int iMax5 = Math.max(0, -i33);
                int iMax6 = Math.max(0, -i34);
                measuredWidth += view2.getMeasuredWidth() + iMax3 + iMax4;
                i22++;
                i21 = iMax5;
                i20 = iMax6;
            }
            i24 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
            i25 = measuredWidth + i24;
            if (i24 >= iLayoutChildLeft2) {
                if (i25 > iMin) {
                    iLayoutChildLeft2 = i24 - (i25 - iMin);
                } else {
                    iLayoutChildLeft2 = i24;
                }
            }
            size4 = arrayList.size();
            for (i23 = 0; i23 < size4; i23++) {
                iLayoutChildLeft2 = layoutChildLeft((View) arrayList.get(i23), iLayoutChildLeft2, iMin2, iArr);
            }
            arrayList.clear();
        }
        iLayoutChildLeft = paddingLeft;
        iLayoutChildRight = i26;
        if (shouldLayout(this.mCollapseButtonView)) {
            appCompatImageButton = this.mCollapseButtonView;
            if (z3) {
                iLayoutChildRight = layoutChildRight(appCompatImageButton, iLayoutChildRight, iMin2, iArr);
            } else {
                iLayoutChildLeft = layoutChildLeft(appCompatImageButton, iLayoutChildLeft, iMin2, iArr);
            }
        }
        if (shouldLayout(this.mMenuView)) {
            actionMenuView = this.mMenuView;
            if (z3) {
                iLayoutChildLeft = layoutChildLeft(actionMenuView, iLayoutChildLeft, iMin2, iArr);
            } else {
                iLayoutChildRight = layoutChildRight(actionMenuView, iLayoutChildRight, iMin2, iArr);
            }
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - iLayoutChildLeft);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i26 - iLayoutChildRight));
        iMax = Math.max(iLayoutChildLeft, currentContentInsetLeft2);
        iMin = Math.min(iLayoutChildRight, i26 - currentContentInsetRight2);
        if (shouldLayout(this.mExpandedActionView)) {
            view = this.mExpandedActionView;
            if (z3) {
                iMin = layoutChildRight(view, iMin, iMin2, iArr);
            } else {
                iMax = layoutChildLeft(view, iMax, iMin2, iArr);
            }
        }
        if (shouldLayout(this.mLogoView)) {
            appCompatImageView = this.mLogoView;
            if (z3) {
                iMin = layoutChildRight(appCompatImageView, iMin, iMin2, iArr);
            } else {
                iMax = layoutChildLeft(appCompatImageView, iMax, iMin2, iArr);
            }
        }
        zShouldLayout = shouldLayout(this.mTitleTextView);
        zShouldLayout2 = shouldLayout(this.mSubtitleTextView);
        if (zShouldLayout) {
            LayoutParams layoutParams8 = (LayoutParams) this.mTitleTextView.getLayoutParams();
            measuredHeight = this.mTitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams8).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams8).bottomMargin;
        } else {
            measuredHeight = 0;
        }
        if (zShouldLayout2) {
            LayoutParams layoutParams9 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
            measuredHeight = this.mSubtitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams9).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams9).bottomMargin + measuredHeight;
        }
        if (zShouldLayout) {
            if (zShouldLayout) {
                appCompatTextView = this.mTitleTextView;
            } else {
                appCompatTextView = this.mSubtitleTextView;
            }
            if (zShouldLayout2) {
                appCompatTextView2 = this.mSubtitleTextView;
            } else {
                appCompatTextView2 = this.mTitleTextView;
            }
            layoutParams = (LayoutParams) appCompatTextView.getLayoutParams();
            layoutParams2 = (LayoutParams) appCompatTextView2.getLayoutParams();
            i5 = measuredHeight;
            if (zShouldLayout) {
            }
            i6 = this.mGravity & 112;
            i7 = iMax;
            if (i6 == 48) {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + this.mTitleMarginTop;
            } else if (i6 != 80) {
                iMax2 = (((height - paddingTop2) - paddingBottom) - i5) / 2;
                i14 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + this.mTitleMarginTop;
                if (iMax2 < i14) {
                    iMax2 = i14;
                } else {
                    i15 = (((height - paddingBottom) - i5) - iMax2) - paddingTop2;
                    i16 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    i17 = this.mTitleMarginBottom;
                    if (i15 < i16 + i17) {
                        iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin + i17) - i15));
                    }
                }
                paddingTop = paddingTop2 + iMax2;
            } else {
                paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin) - this.mTitleMarginBottom) - i5;
            }
            if (z3) {
                if (z2) {
                    i11 = this.mTitleMarginStart;
                } else {
                    i11 = 0;
                }
                int i210 = i11 - iArr[1];
                iMin -= Math.max(0, i210);
                iArr[1] = Math.max(0, -i210);
                if (zShouldLayout) {
                    LayoutParams layoutParams10 = (LayoutParams) this.mTitleTextView.getLayoutParams();
                    int measuredWidth5 = iMin - this.mTitleTextView.getMeasuredWidth();
                    int measuredHeight4 = this.mTitleTextView.getMeasuredHeight() + paddingTop;
                    this.mTitleTextView.layout(measuredWidth5, paddingTop, iMin, measuredHeight4);
                    i12 = measuredWidth5 - this.mTitleMarginEnd;
                    paddingTop = measuredHeight4 + ((ViewGroup.MarginLayoutParams) layoutParams10).bottomMargin;
                } else {
                    i12 = iMin;
                }
                if (zShouldLayout2) {
                    int i211 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
                    this.mSubtitleTextView.layout(iMin - this.mSubtitleTextView.getMeasuredWidth(), i211, iMin, this.mSubtitleTextView.getMeasuredHeight() + i211);
                    i13 = iMin - this.mTitleMarginEnd;
                } else {
                    i13 = iMin;
                }
                if (z2) {
                    iMin = Math.min(i12, i13);
                }
                iMax = i7;
            } else {
                if (z2) {
                    i8 = this.mTitleMarginStart;
                } else {
                    i8 = 0;
                }
                int i212 = i8 - iArr[0];
                iMax = Math.max(0, i212) + i7;
                iArr[0] = Math.max(0, -i212);
                if (zShouldLayout) {
                    LayoutParams layoutParams11 = (LayoutParams) this.mTitleTextView.getLayoutParams();
                    int measuredWidth6 = this.mTitleTextView.getMeasuredWidth() + iMax;
                    int measuredHeight5 = this.mTitleTextView.getMeasuredHeight() + paddingTop;
                    this.mTitleTextView.layout(iMax, paddingTop, measuredWidth6, measuredHeight5);
                    i9 = measuredWidth6 + this.mTitleMarginEnd;
                    paddingTop = measuredHeight5 + ((ViewGroup.MarginLayoutParams) layoutParams11).bottomMargin;
                } else {
                    i9 = iMax;
                }
                if (zShouldLayout2) {
                    int i35 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
                    int measuredWidth7 = this.mSubtitleTextView.getMeasuredWidth() + iMax;
                    this.mSubtitleTextView.layout(iMax, i35, measuredWidth7, this.mSubtitleTextView.getMeasuredHeight() + i35);
                    i10 = measuredWidth7 + this.mTitleMarginEnd;
                } else {
                    i10 = iMax;
                }
                if (z2) {
                    iMax = Math.max(i9, i10);
                }
            }
        } else {
            if (zShouldLayout) {
                appCompatTextView = this.mTitleTextView;
            } else {
                appCompatTextView = this.mSubtitleTextView;
            }
            if (zShouldLayout2) {
                appCompatTextView2 = this.mSubtitleTextView;
            } else {
                appCompatTextView2 = this.mTitleTextView;
            }
            layoutParams = (LayoutParams) appCompatTextView.getLayoutParams();
            layoutParams2 = (LayoutParams) appCompatTextView2.getLayoutParams();
            i5 = measuredHeight;
            if (zShouldLayout) {
            }
            i6 = this.mGravity & 112;
            i7 = iMax;
            if (i6 == 48) {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + this.mTitleMarginTop;
            } else if (i6 != 80) {
                iMax2 = (((height - paddingTop2) - paddingBottom) - i5) / 2;
                i14 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + this.mTitleMarginTop;
                if (iMax2 < i14) {
                    iMax2 = i14;
                } else {
                    i15 = (((height - paddingBottom) - i5) - iMax2) - paddingTop2;
                    i16 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    i17 = this.mTitleMarginBottom;
                    if (i15 < i16 + i17) {
                        iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin + i17) - i15));
                    }
                }
                paddingTop = paddingTop2 + iMax2;
            } else {
                paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin) - this.mTitleMarginBottom) - i5;
            }
            if (z3) {
                if (z2) {
                    i11 = this.mTitleMarginStart;
                } else {
                    i11 = 0;
                }
                int i213 = i11 - iArr[1];
                iMin -= Math.max(0, i213);
                iArr[1] = Math.max(0, -i213);
                if (zShouldLayout) {
                    LayoutParams layoutParams12 = (LayoutParams) this.mTitleTextView.getLayoutParams();
                    int measuredWidth8 = iMin - this.mTitleTextView.getMeasuredWidth();
                    int measuredHeight6 = this.mTitleTextView.getMeasuredHeight() + paddingTop;
                    this.mTitleTextView.layout(measuredWidth8, paddingTop, iMin, measuredHeight6);
                    i12 = measuredWidth8 - this.mTitleMarginEnd;
                    paddingTop = measuredHeight6 + ((ViewGroup.MarginLayoutParams) layoutParams12).bottomMargin;
                } else {
                    i12 = iMin;
                }
                if (zShouldLayout2) {
                    int i214 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
                    this.mSubtitleTextView.layout(iMin - this.mSubtitleTextView.getMeasuredWidth(), i214, iMin, this.mSubtitleTextView.getMeasuredHeight() + i214);
                    i13 = iMin - this.mTitleMarginEnd;
                } else {
                    i13 = iMin;
                }
                if (z2) {
                    iMin = Math.min(i12, i13);
                }
                iMax = i7;
            } else {
                if (z2) {
                    i8 = this.mTitleMarginStart;
                } else {
                    i8 = 0;
                }
                int i215 = i8 - iArr[0];
                iMax = Math.max(0, i215) + i7;
                iArr[0] = Math.max(0, -i215);
                if (zShouldLayout) {
                    LayoutParams layoutParams13 = (LayoutParams) this.mTitleTextView.getLayoutParams();
                    int measuredWidth9 = this.mTitleTextView.getMeasuredWidth() + iMax;
                    int measuredHeight7 = this.mTitleTextView.getMeasuredHeight() + paddingTop;
                    this.mTitleTextView.layout(iMax, paddingTop, measuredWidth9, measuredHeight7);
                    i9 = measuredWidth9 + this.mTitleMarginEnd;
                    paddingTop = measuredHeight7 + ((ViewGroup.MarginLayoutParams) layoutParams13).bottomMargin;
                } else {
                    i9 = iMax;
                }
                if (zShouldLayout2) {
                    int i36 = paddingTop + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
                    int measuredWidth10 = this.mSubtitleTextView.getMeasuredWidth() + iMax;
                    this.mSubtitleTextView.layout(iMax, i36, measuredWidth10, this.mSubtitleTextView.getMeasuredHeight() + i36);
                    i10 = measuredWidth10 + this.mTitleMarginEnd;
                } else {
                    i10 = iMax;
                }
                if (z2) {
                    iMax = Math.max(i9, i10);
                }
            }
        }
        arrayList = this.mTempViews;
        addCustomViewsWithGravity(3, arrayList);
        size = arrayList.size();
        iLayoutChildLeft2 = iMax;
        while (i18 < size) {
            iLayoutChildLeft2 = layoutChildLeft((View) arrayList.get(i18), iLayoutChildLeft2, iMin2, iArr);
        }
        addCustomViewsWithGravity(5, arrayList);
        size2 = arrayList.size();
        while (i19 < size2) {
            iMin = layoutChildRight((View) arrayList.get(i19), iMin, iMin2, iArr);
        }
        addCustomViewsWithGravity(1, arrayList);
        int i37 = iArr[0];
        i20 = iArr[1];
        size3 = arrayList.size();
        i21 = i37;
        i22 = 0;
        measuredWidth = 0;
        while (i22 < size3) {
            View view3 = (View) arrayList.get(i22);
            LayoutParams layoutParams14 = (LayoutParams) view3.getLayoutParams();
            int i38 = i20;
            int i39 = ((ViewGroup.MarginLayoutParams) layoutParams14).leftMargin - i21;
            int i310 = ((ViewGroup.MarginLayoutParams) layoutParams14).rightMargin - i38;
            int iMax7 = Math.max(0, i39);
            int iMax8 = Math.max(0, i310);
            int iMax9 = Math.max(0, -i39);
            int iMax10 = Math.max(0, -i310);
            measuredWidth += view3.getMeasuredWidth() + iMax7 + iMax8;
            i22++;
            i21 = iMax9;
            i20 = iMax10;
        }
        i24 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        i25 = measuredWidth + i24;
        if (i24 >= iLayoutChildLeft2) {
            if (i25 > iMin) {
                iLayoutChildLeft2 = i24 - (i25 - iMin);
            } else {
                iLayoutChildLeft2 = i24;
            }
        }
        size4 = arrayList.size();
        while (i23 < size4) {
            iLayoutChildLeft2 = layoutChildLeft((View) arrayList.get(i23), iLayoutChildLeft2, iMin2, iArr);
        }
        arrayList.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        char c;
        Object[] objArr;
        int horizontalMargins;
        int iMax;
        int iCombineMeasuredStates;
        int horizontalMargins2;
        int verticalMargins;
        int iCombineMeasuredStates2;
        int iMax2;
        boolean z = ViewUtils.sInitComputeFitSystemWindowsMethod;
        int i3 = 0;
        if (getLayoutDirection() == 1) {
            objArr = true;
            c = 0;
        } else {
            c = 1;
            objArr = false;
        }
        if (shouldLayout(this.mNavButtonView)) {
            measureChildConstrained(this.mNavButtonView, i, 0, i2, this.mMaxButtonHeight);
            horizontalMargins = getHorizontalMargins(this.mNavButtonView) + this.mNavButtonView.getMeasuredWidth();
            iMax = Math.max(0, getVerticalMargins(this.mNavButtonView) + this.mNavButtonView.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
        } else {
            horizontalMargins = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            measureChildConstrained(this.mCollapseButtonView, i, 0, i2, this.mMaxButtonHeight);
            horizontalMargins = getHorizontalMargins(this.mCollapseButtonView) + this.mCollapseButtonView.getMeasuredWidth();
            iMax = Math.max(iMax, getVerticalMargins(this.mCollapseButtonView) + this.mCollapseButtonView.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.mCollapseButtonView.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, horizontalMargins);
        int iMax4 = Math.max(0, currentContentInsetStart - horizontalMargins);
        Object[] objArr2 = objArr;
        int[] iArr = this.mTempMargins;
        iArr[objArr2 == true ? 1 : 0] = iMax4;
        if (shouldLayout(this.mMenuView)) {
            measureChildConstrained(this.mMenuView, i, iMax3, i2, this.mMaxButtonHeight);
            horizontalMargins2 = getHorizontalMargins(this.mMenuView) + this.mMenuView.getMeasuredWidth();
            iMax = Math.max(iMax, getVerticalMargins(this.mMenuView) + this.mMenuView.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.mMenuView.getMeasuredState());
        } else {
            horizontalMargins2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax5 = iMax3 + Math.max(currentContentInsetEnd, horizontalMargins2);
        iArr[c] = Math.max(0, currentContentInsetEnd - horizontalMargins2);
        if (shouldLayout(this.mExpandedActionView)) {
            iMax5 += measureChildCollapseMargins(this.mExpandedActionView, i, iMax5, i2, 0, iArr);
            iMax = Math.max(iMax, getVerticalMargins(this.mExpandedActionView) + this.mExpandedActionView.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.mExpandedActionView.getMeasuredState());
        }
        if (shouldLayout(this.mLogoView)) {
            iMax5 += measureChildCollapseMargins(this.mLogoView, i, iMax5, i2, 0, iArr);
            iMax = Math.max(iMax, getVerticalMargins(this.mLogoView) + this.mLogoView.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.mLogoView.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (((LayoutParams) childAt.getLayoutParams()).mViewType == 0 && shouldLayout(childAt)) {
                iMax5 += measureChildCollapseMargins(childAt, i, iMax5, i2, 0, iArr);
                int iMax6 = Math.max(iMax, getVerticalMargins(childAt) + childAt.getMeasuredHeight());
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
                iMax = iMax6;
            } else {
                iMax5 = iMax5;
            }
        }
        int i5 = iMax5;
        int i6 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int i7 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView)) {
            measureChildCollapseMargins(this.mTitleTextView, i, i5 + i7, i2, i6, iArr);
            int horizontalMargins3 = getHorizontalMargins(this.mTitleTextView) + this.mTitleTextView.getMeasuredWidth();
            verticalMargins = getVerticalMargins(this.mTitleTextView) + this.mTitleTextView.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.mTitleTextView.getMeasuredState());
            iMax2 = horizontalMargins3;
        } else {
            verticalMargins = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (shouldLayout(this.mSubtitleTextView)) {
            iMax2 = Math.max(iMax2, measureChildCollapseMargins(this.mSubtitleTextView, i, i5 + i7, i2, verticalMargins + i6, iArr));
            verticalMargins += getVerticalMargins(this.mSubtitleTextView) + this.mSubtitleTextView.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.mSubtitleTextView.getMeasuredState());
        }
        if (shouldLayout(this.mTitleTextView) || shouldLayout(this.mSubtitleTextView)) {
            verticalMargins += i6;
        }
        int iMax7 = Math.max(iMax, verticalMargins);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i5 + iMax2;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax7;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16);
        if (!this.mCollapsible) {
            i3 = iResolveSizeAndState2;
            break;
        }
        int childCount2 = getChildCount();
        for (int i8 = 0; i8 < childCount2; i8++) {
            View childAt2 = getChildAt(i8);
            if (shouldLayout(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                i3 = iResolveSizeAndState2;
                break;
            }
        }
        setMeasuredDimension(iResolveSizeAndState, i3);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        ActionMenuView actionMenuView = this.mMenuView;
        MenuBuilder menuBuilder = actionMenuView != null ? actionMenuView.mMenu : null;
        int i = savedState.expandedMenuItemId;
        if (i != 0 && this.mExpandedMenuPresenter != null && menuBuilder != null && (menuItemFindItem = menuBuilder.findItem(i)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (savedState.isOverflowOpen) {
            AnonymousClass2 anonymousClass2 = this.mShowOverflowMenuRunnable;
            removeCallbacks(anonymousClass2);
            post(anonymousClass2);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        ensureContentInsets();
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        boolean z = i == 1;
        if (z == rtlSpacingHelper.mIsRtl) {
            return;
        }
        rtlSpacingHelper.mIsRtl = z;
        if (!rtlSpacingHelper.mIsRelative) {
            rtlSpacingHelper.mLeft = rtlSpacingHelper.mExplicitLeft;
            rtlSpacingHelper.mRight = rtlSpacingHelper.mExplicitRight;
            return;
        }
        if (z) {
            int i2 = rtlSpacingHelper.mEnd;
            if (i2 == Integer.MIN_VALUE) {
                i2 = rtlSpacingHelper.mExplicitLeft;
            }
            rtlSpacingHelper.mLeft = i2;
            int i3 = rtlSpacingHelper.mStart;
            if (i3 == Integer.MIN_VALUE) {
                i3 = rtlSpacingHelper.mExplicitRight;
            }
            rtlSpacingHelper.mRight = i3;
            return;
        }
        int i4 = rtlSpacingHelper.mStart;
        if (i4 == Integer.MIN_VALUE) {
            i4 = rtlSpacingHelper.mExplicitLeft;
        }
        rtlSpacingHelper.mLeft = i4;
        int i5 = rtlSpacingHelper.mEnd;
        if (i5 == Integer.MIN_VALUE) {
            i5 = rtlSpacingHelper.mExplicitRight;
        }
        rtlSpacingHelper.mRight = i5;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        MenuItemImpl menuItemImpl;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
        if (expandedActionViewMenuPresenter != null && (menuItemImpl = expandedActionViewMenuPresenter.mCurrentExpandedItem) != null) {
            savedState.expandedMenuItemId = menuItemImpl.mId;
        }
        savedState.isOverflowOpen = isOverflowMenuShowing();
        return savedState;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.mEatingTouch = false;
        return true;
    }

    @Override // androidx.core.view.MenuHost
    public final void removeMenuProvider(MenuProvider menuProvider) {
        this.mMenuHostHelper.removeMenuProvider(menuProvider);
    }

    public void setBackInvokedCallbackEnabled(boolean z) {
        if (this.mBackInvokedCallbackEnabled != z) {
            this.mBackInvokedCallbackEnabled = z;
            updateBackInvokedCallbackState();
        }
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureCollapseButtonView();
        }
        AppCompatImageButton appCompatImageButton = this.mCollapseButtonView;
        if (appCompatImageButton != null) {
            appCompatImageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            ensureCollapseButtonView();
            this.mCollapseButtonView.setImageDrawable(drawable);
        } else {
            AppCompatImageButton appCompatImageButton = this.mCollapseButtonView;
            if (appCompatImageButton != null) {
                appCompatImageButton.setImageDrawable(this.mCollapseIcon);
            }
        }
    }

    public void setCollapsible(boolean z) {
        this.mCollapsible = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.mContentInsetEndWithActions) {
            this.mContentInsetEndWithActions = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.mContentInsetStartWithNavigation) {
            this.mContentInsetStartWithNavigation = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(Drawable drawable) {
        AppCompatImageView appCompatImageView = this.mLogoView;
        if (drawable != null) {
            if (appCompatImageView == null) {
                appCompatImageView = new AppCompatImageView(getContext(), null, 0);
                this.mLogoView = appCompatImageView;
            }
            if (!isChildOrHidden(appCompatImageView)) {
                addSystemView(this.mLogoView, true);
            }
        } else if (appCompatImageView != null && isChildOrHidden(appCompatImageView)) {
            removeView(this.mLogoView);
            this.mHiddenViews.remove(this.mLogoView);
        }
        AppCompatImageView appCompatImageView2 = this.mLogoView;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.mLogoView == null) {
            this.mLogoView = new AppCompatImageView(getContext(), null, 0);
        }
        AppCompatImageView appCompatImageView = this.mLogoView;
        if (appCompatImageView != null) {
            appCompatImageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureNavButtonView();
        }
        AppCompatImageButton appCompatImageButton = this.mNavButtonView;
        if (appCompatImageButton != null) {
            appCompatImageButton.setContentDescription(charSequence);
            this.mNavButtonView.setTooltipText(charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            ensureNavButtonView();
            if (!isChildOrHidden(this.mNavButtonView)) {
                addSystemView(this.mNavButtonView, true);
            }
        } else {
            AppCompatImageButton appCompatImageButton = this.mNavButtonView;
            if (appCompatImageButton != null && isChildOrHidden(appCompatImageButton)) {
                removeView(this.mNavButtonView);
                this.mHiddenViews.remove(this.mNavButtonView);
            }
        }
        AppCompatImageButton appCompatImageButton2 = this.mNavButtonView;
        if (appCompatImageButton2 != null) {
            appCompatImageButton2.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.mPopupTheme != i) {
            this.mPopupTheme = i;
            if (i == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        AppCompatTextView appCompatTextView = this.mSubtitleTextView;
        if (!zIsEmpty) {
            if (appCompatTextView == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context, null);
                this.mSubtitleTextView = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.mSubtitleTextAppearance;
                if (i != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.mSubtitleTextColor;
                if (colorStateList != null) {
                    this.mSubtitleTextView.setTextColor(colorStateList);
                }
            }
            if (!isChildOrHidden(this.mSubtitleTextView)) {
                addSystemView(this.mSubtitleTextView, true);
            }
        } else if (appCompatTextView != null && isChildOrHidden(appCompatTextView)) {
            removeView(this.mSubtitleTextView);
            this.mHiddenViews.remove(this.mSubtitleTextView);
        }
        AppCompatTextView appCompatTextView3 = this.mSubtitleTextView;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.mSubtitleTextColor = colorStateList;
        AppCompatTextView appCompatTextView = this.mSubtitleTextView;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        AppCompatTextView appCompatTextView = this.mTitleTextView;
        if (!zIsEmpty) {
            if (appCompatTextView == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context, null);
                this.mTitleTextView = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.mTitleTextAppearance;
                if (i != 0) {
                    this.mTitleTextView.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.mTitleTextColor;
                if (colorStateList != null) {
                    this.mTitleTextView.setTextColor(colorStateList);
                }
            }
            if (!isChildOrHidden(this.mTitleTextView)) {
                addSystemView(this.mTitleTextView, true);
            }
        } else if (appCompatTextView != null && isChildOrHidden(appCompatTextView)) {
            removeView(this.mTitleTextView);
            this.mHiddenViews.remove(this.mTitleTextView);
        }
        AppCompatTextView appCompatTextView3 = this.mTitleTextView;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    public void setTitleMarginBottom(int i) {
        this.mTitleMarginBottom = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.mTitleMarginEnd = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.mTitleMarginStart = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.mTitleMarginTop = i;
        requestLayout();
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.mTitleTextColor = colorStateList;
        AppCompatTextView appCompatTextView = this.mTitleTextView;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public final boolean shouldLayout(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public final boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.mMenuView;
        return (actionMenuView == null || (actionMenuPresenter = actionMenuView.mPresenter) == null || !actionMenuPresenter.showOverflowMenu()) ? false : true;
    }

    public final void updateBackInvokedCallbackState() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher = BundleCompat$Api33Impl.findOnBackInvokedDispatcher(this);
            ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
            byte b = 0;
            boolean z = (expandedActionViewMenuPresenter == null || expandedActionViewMenuPresenter.mCurrentExpandedItem == null || onBackInvokedDispatcherFindOnBackInvokedDispatcher == null || !isAttachedToWindow() || !this.mBackInvokedCallbackEnabled) ? false : true;
            if (!z || this.mBackInvokedDispatcher != null) {
                if (z || (onBackInvokedDispatcher = this.mBackInvokedDispatcher) == null) {
                    return;
                }
                BundleCompat$Api33Impl.tryUnregisterOnBackInvokedCallback(onBackInvokedDispatcher, this.mBackInvokedCallback);
                this.mBackInvokedDispatcher = null;
                return;
            }
            Api33Impl$$ExternalSyntheticLambda0 api33Impl$$ExternalSyntheticLambda0 = this.mBackInvokedCallback;
            if (api33Impl$$ExternalSyntheticLambda0 == null) {
                Api33Impl$$ExternalSyntheticLambda0 api33Impl$$ExternalSyntheticLambda1 = new Api33Impl$$ExternalSyntheticLambda0((byte) 2, new Toolbar$$ExternalSyntheticLambda0(this, b));
                this.mBackInvokedCallback = api33Impl$$ExternalSyntheticLambda1;
                api33Impl$$ExternalSyntheticLambda0 = api33Impl$$ExternalSyntheticLambda1;
            }
            BundleCompat$Api33Impl.tryRegisterOnBackInvokedCallback(onBackInvokedDispatcherFindOnBackInvokedDispatcher, api33Impl$$ExternalSyntheticLambda0);
            this.mBackInvokedDispatcher = onBackInvokedDispatcherFindOnBackInvokedDispatcher;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;
        public byte mViewType;

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.gravity = 0;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(SizeKt.getDrawable(getContext(), i));
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ExpandedActionViewMenuPresenter implements MenuPresenter {
        public MenuItemImpl mCurrentExpandedItem;
        public MenuBuilder mMenu;

        public ExpandedActionViewMenuPresenter() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
            Toolbar toolbar = Toolbar.this;
            KeyEvent.Callback callback = toolbar.mExpandedActionView;
            if (callback instanceof CollapsibleActionView) {
                ((MenuItemWrapperICS.CollapsibleActionViewWrapper) ((CollapsibleActionView) callback)).mWrappedView.onActionViewCollapsed();
            }
            toolbar.removeView(toolbar.mExpandedActionView);
            toolbar.removeView(toolbar.mCollapseButtonView);
            toolbar.mExpandedActionView = null;
            ArrayList arrayList = toolbar.mHiddenViews;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                toolbar.addView((View) arrayList.get(size));
            }
            arrayList.clear();
            this.mCurrentExpandedItem = null;
            toolbar.requestLayout();
            menuItemImpl.mIsActionViewExpanded = false;
            menuItemImpl.mMenu.onItemsChanged(false);
            toolbar.updateBackInvokedCallbackState();
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final boolean expandItemActionView(MenuItemImpl menuItemImpl) {
            Toolbar toolbar = Toolbar.this;
            toolbar.ensureCollapseButtonView();
            ViewParent parent = toolbar.mCollapseButtonView.getParent();
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.mCollapseButtonView);
                }
                toolbar.addView(toolbar.mCollapseButtonView);
            }
            View actionView = menuItemImpl.getActionView();
            toolbar.mExpandedActionView = actionView;
            this.mCurrentExpandedItem = menuItemImpl;
            ViewParent parent2 = actionView.getParent();
            if (parent2 != toolbar) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar.mExpandedActionView);
                }
                LayoutParams layoutParamsGenerateDefaultLayoutParams = Toolbar.generateDefaultLayoutParams();
                layoutParamsGenerateDefaultLayoutParams.gravity = (toolbar.mButtonGravity & 112) | 8388611;
                layoutParamsGenerateDefaultLayoutParams.mViewType = (byte) 2;
                toolbar.mExpandedActionView.setLayoutParams(layoutParamsGenerateDefaultLayoutParams);
                toolbar.addView(toolbar.mExpandedActionView);
            }
            for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = toolbar.getChildAt(childCount);
                if (((LayoutParams) childAt.getLayoutParams()).mViewType != 2 && childAt != toolbar.mMenuView) {
                    toolbar.removeViewAt(childCount);
                    toolbar.mHiddenViews.add(childAt);
                }
            }
            toolbar.requestLayout();
            menuItemImpl.mIsActionViewExpanded = true;
            menuItemImpl.mMenu.onItemsChanged(false);
            KeyEvent.Callback callback = toolbar.mExpandedActionView;
            if (callback instanceof CollapsibleActionView) {
                ((MenuItemWrapperICS.CollapsibleActionViewWrapper) ((CollapsibleActionView) callback)).mWrappedView.onActionViewExpanded();
            }
            toolbar.updateBackInvokedCallbackState();
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final boolean flagActionItems() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final void initForMenu(Context context, MenuBuilder menuBuilder) {
            MenuItemImpl menuItemImpl;
            MenuBuilder menuBuilder2 = this.mMenu;
            if (menuBuilder2 != null && (menuItemImpl = this.mCurrentExpandedItem) != null) {
                menuBuilder2.collapseItemActionView(menuItemImpl);
            }
            this.mMenu = menuBuilder;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final void updateMenuView() {
            if (this.mCurrentExpandedItem != null) {
                MenuBuilder menuBuilder = this.mMenu;
                if (menuBuilder != null) {
                    int size = menuBuilder.mItems.size();
                    for (int i = 0; i < size; i++) {
                        if (this.mMenu.getItem(i) == this.mCurrentExpandedItem) {
                            return;
                        }
                    }
                }
                collapseItemActionView(this.mCurrentExpandedItem);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(SizeKt.getDrawable(getContext(), i));
    }

    public void setLogo(int i) {
        setLogo(SizeKt.getDrawable(getContext(), i));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        LayoutParams layoutParams = new LayoutParams(context, attributeSet);
        layoutParams.gravity = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBarLayout);
        layoutParams.gravity = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        layoutParams.mViewType = (byte) 0;
        return layoutParams;
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateLayoutParams(layoutParams);
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public Toolbar(Context context) {
        this(context, null);
    }
}
