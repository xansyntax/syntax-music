package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.StandaloneActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.appcompat.view.menu.ExpandedMenuView;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.ListMenuPresenter.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.SimpleArrayMap;
import androidx.compose.ui.platform.WeakCache;
import androidx.compose.ui.window.Api33Impl$$ExternalSyntheticLambda0;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.app.NavUtils;
import androidx.core.graphics.Insets;
import androidx.core.os.BundleCompat$Api33Impl;
import androidx.core.os.LocaleListCompat;
import androidx.core.os.LocaleListPlatformWrapper;
import androidx.core.view.KeyEventDispatcher$Component;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.emoji2.text.EmojiProcessor;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.tracing.TraceApi29Impl;
import coil3.size.SizeKt;
import com.atilika.kuromoji.ipadic.compile.DictionaryEntry;
import com.google.common.math.IntMath;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.http.ContentType;
import io.ktor.websocket.ControlFramesKt;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;
import okhttp3.Dispatcher;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {
    public ActionBar mActionBar;
    public AnonymousClass2 mActionMenuPresenterCallback;
    public ActionMode mActionMode;
    public PopupWindow mActionModePopup;
    public ActionBarContextView mActionModeView;
    public int mActivityHandlesConfigFlags;
    public boolean mActivityHandlesConfigFlagsChecked;
    public final AppCompatCallback mAppCompatCallback;
    public AppCompatViewInflater mAppCompatViewInflater;
    public AppCompatWindowCallback mAppCompatWindowCallback;
    public AutoTimeNightModeManager mAutoBatteryNightModeManager;
    public AutoTimeNightModeManager mAutoTimeNightModeManager;
    public Api33Impl$$ExternalSyntheticLambda0 mBackCallback;
    public boolean mBaseContextAttached;
    public boolean mClosingActionMenu;
    public final Context mContext;
    public boolean mCreated;
    public ActionBarOverlayLayout mDecorContentParent;
    public boolean mDestroyed;
    public OnBackInvokedDispatcher mDispatcher;
    public Configuration mEffectiveConfiguration;
    public boolean mEnableDefaultActionBarUp;
    public boolean mFeatureIndeterminateProgress;
    public boolean mFeatureProgress;
    public boolean mHasActionBar;
    public final Object mHost;
    public int mInvalidatePanelMenuFeatures;
    public boolean mInvalidatePanelMenuPosted;
    public boolean mIsFloating;
    public final int mLocalNightMode;
    public boolean mLongPressBackDown;
    public SupportMenuInflater mMenuInflater;
    public boolean mOverlayActionBar;
    public boolean mOverlayActionMode;
    public AnonymousClass2 mPanelMenuPresenterCallback;
    public PanelFeatureState[] mPanels;
    public PanelFeatureState mPreparedPanel;
    public AnonymousClass1 mShowActionModePopup;
    public ViewGroup mSubDecor;
    public boolean mSubDecorInstalled;
    public Rect mTempRect1;
    public Rect mTempRect2;
    public int mThemeResId;
    public CharSequence mTitle;
    public TextView mTitleView;
    public Window mWindow;
    public boolean mWindowNoTitle;
    public static final SimpleArrayMap sLocalNightModes = new SimpleArrayMap(0);
    public static final int[] sWindowBackgroundStyleable = {R.attr.windowBackground};
    public static final boolean sCanReturnDifferentContext = !"robolectric".equals(Build.FINGERPRINT);
    public ViewPropertyAnimatorCompat mFadeAnim = null;
    public final AnonymousClass1 mInvalidatePanelMenuRunnable = new AnonymousClass1(this, 0);

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ AppCompatDelegateImpl this$0;

        public /* synthetic */ AnonymousClass1(AppCompatDelegateImpl appCompatDelegateImpl, byte b) {
            this.$r8$classId = b;
            this.this$0 = appCompatDelegateImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewGroup viewGroup;
            byte b = this.$r8$classId;
            byte b2 = 1;
            AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
            switch (b) {
                case 0:
                    if ((appCompatDelegateImpl.mInvalidatePanelMenuFeatures & 1) != 0) {
                        appCompatDelegateImpl.doInvalidatePanelMenu(0);
                    }
                    if ((appCompatDelegateImpl.mInvalidatePanelMenuFeatures & 4096) != 0) {
                        appCompatDelegateImpl.doInvalidatePanelMenu(108);
                    }
                    appCompatDelegateImpl.mInvalidatePanelMenuPosted = false;
                    appCompatDelegateImpl.mInvalidatePanelMenuFeatures = 0;
                    break;
                default:
                    appCompatDelegateImpl.mActionModePopup.showAtLocation(appCompatDelegateImpl.mActionModeView, 55, 0, 0);
                    ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = appCompatDelegateImpl.mFadeAnim;
                    if (viewPropertyAnimatorCompat != null) {
                        viewPropertyAnimatorCompat.cancel();
                    }
                    if (appCompatDelegateImpl.mSubDecorInstalled && (viewGroup = appCompatDelegateImpl.mSubDecor) != null && viewGroup.isLaidOut()) {
                        appCompatDelegateImpl.mActionModeView.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
                        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAnimate = ViewCompat.animate(appCompatDelegateImpl.mActionModeView);
                        viewPropertyAnimatorCompatAnimate.alpha(1.0f);
                        appCompatDelegateImpl.mFadeAnim = viewPropertyAnimatorCompatAnimate;
                        viewPropertyAnimatorCompatAnimate.setListener(new AnonymousClass5(b2, this));
                    } else {
                        appCompatDelegateImpl.mActionModeView.setAlpha(1.0f);
                        appCompatDelegateImpl.mActionModeView.setVisibility(0);
                    }
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 implements OnApplyWindowInsetsListener, ContentFrameLayout.OnAttachListener, MenuPresenter.Callback {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ AppCompatDelegateImpl this$0;

        public /* synthetic */ AnonymousClass2(AppCompatDelegateImpl appCompatDelegateImpl, byte b) {
            this.$r8$classId = b;
            this.this$0 = appCompatDelegateImpl;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            WindowInsetsCompat.BuilderImpl builderImpl29;
            WindowInsetsCompat windowInsetsCompatBuild = windowInsetsCompat;
            WindowInsetsCompat.Impl impl = windowInsetsCompatBuild.mImpl;
            int i = impl.getSystemWindowInsets().top;
            int i2 = impl.getSystemWindowInsets().top;
            AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
            ActionBarContextView actionBarContextView = appCompatDelegateImpl.mActionModeView;
            if (actionBarContextView != null && (actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) appCompatDelegateImpl.mActionModeView.getLayoutParams();
                boolean z = false;
                if (appCompatDelegateImpl.mActionModeView.isShown()) {
                    if (appCompatDelegateImpl.mTempRect1 == null) {
                        appCompatDelegateImpl.mTempRect1 = new Rect();
                        appCompatDelegateImpl.mTempRect2 = new Rect();
                    }
                    Rect rect = appCompatDelegateImpl.mTempRect1;
                    Rect rect2 = appCompatDelegateImpl.mTempRect2;
                    rect.set(impl.getSystemWindowInsets().left, impl.getSystemWindowInsets().top, impl.getSystemWindowInsets().right, impl.getSystemWindowInsets().bottom);
                    Insets insets = impl.getInsets(2);
                    ViewGroup viewGroup = appCompatDelegateImpl.mSubDecor;
                    boolean z2 = true;
                    if (Build.VERSION.SDK_INT >= 29) {
                        boolean z3 = ViewUtils.sInitComputeFitSystemWindowsMethod;
                        TraceApi29Impl.computeFitSystemWindows(viewGroup, rect, rect2);
                    } else {
                        if (!ViewUtils.sInitComputeFitSystemWindowsMethod) {
                            ViewUtils.sInitComputeFitSystemWindowsMethod = true;
                            try {
                                Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                                ViewUtils.sComputeFitSystemWindowsMethod = declaredMethod;
                                if (!declaredMethod.isAccessible()) {
                                    ViewUtils.sComputeFitSystemWindowsMethod.setAccessible(true);
                                }
                            } catch (NoSuchMethodException unused) {
                            }
                        }
                        Method method = ViewUtils.sComputeFitSystemWindowsMethod;
                        if (method != null) {
                            try {
                                method.invoke(viewGroup, rect, rect2);
                            } catch (Exception unused2) {
                            }
                        }
                    }
                    Insets insetsOf = Insets.of(Math.max(0, insets.left - rect2.left), Math.max(0, insets.top - rect2.top), Math.max(0, insets.right - rect2.right), Math.max(0, insets.bottom - rect2.bottom));
                    int i3 = insetsOf.right;
                    int i4 = marginLayoutParams.leftMargin;
                    int i5 = insetsOf.left;
                    if (i4 == i5 && marginLayoutParams.rightMargin == i3) {
                        z2 = false;
                    } else {
                        marginLayoutParams.leftMargin = i5;
                        marginLayoutParams.rightMargin = i3;
                    }
                    ActionBarContextView actionBarContextView2 = appCompatDelegateImpl.mActionModeView;
                    int i6 = rect.left - i5;
                    int i7 = rect.top;
                    int i8 = rect.right - i3;
                    actionBarContextView2.mInsetsPaddingLeft = i6;
                    actionBarContextView2.mInsetsPaddingTop = i7;
                    actionBarContextView2.mInsetsPaddingRight = i8;
                    actionBarContextView2.updatePadding();
                    if (!appCompatDelegateImpl.mOverlayActionMode && rect.top > 0) {
                        i2 = 0;
                    }
                    z = z2;
                }
                if (z) {
                    appCompatDelegateImpl.mActionModeView.setLayoutParams(marginLayoutParams);
                }
            }
            if (i != i2) {
                int i9 = impl.getSystemWindowInsets().left;
                int i10 = impl.getSystemWindowInsets().right;
                int i11 = impl.getSystemWindowInsets().bottom;
                int i12 = Build.VERSION.SDK_INT;
                if (i12 >= 36) {
                    builderImpl29 = new WindowInsetsCompat.BuilderImpl36(windowInsetsCompatBuild);
                } else if (i12 >= 35) {
                    builderImpl29 = new WindowInsetsCompat.BuilderImpl35(windowInsetsCompatBuild);
                } else if (i12 >= 34) {
                    builderImpl29 = new WindowInsetsCompat.BuilderImpl34(windowInsetsCompatBuild);
                } else if (i12 >= 31) {
                    builderImpl29 = new WindowInsetsCompat.BuilderImpl31(windowInsetsCompatBuild);
                } else if (i12 >= 30) {
                    builderImpl29 = new WindowInsetsCompat.BuilderImpl30(windowInsetsCompatBuild);
                } else {
                    builderImpl29 = i12 >= 29 ? new WindowInsetsCompat.BuilderImpl29(windowInsetsCompatBuild) : new WindowInsetsCompat.BuilderImpl20(windowInsetsCompatBuild);
                }
                builderImpl29.setSystemWindowInsets(Insets.of(i9, i2, i10, i11));
                windowInsetsCompatBuild = builderImpl29.build();
            }
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            WindowInsets windowInsets = windowInsetsCompatBuild.toWindowInsets();
            if (windowInsets == null) {
                return windowInsetsCompatBuild;
            }
            WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            return !windowInsetsOnApplyWindowInsets.equals(windowInsets) ? WindowInsetsCompat.toWindowInsetsCompat(windowInsetsOnApplyWindowInsets, view) : windowInsetsCompatBuild;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            PanelFeatureState panelFeatureState;
            byte b = this.$r8$classId;
            AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
            switch (b) {
                case 2:
                    appCompatDelegateImpl.checkCloseActionMenu(menuBuilder);
                    break;
                default:
                    MenuBuilder rootMenu = menuBuilder.getRootMenu();
                    int i = 0;
                    boolean z2 = rootMenu != menuBuilder;
                    if (z2) {
                        menuBuilder = rootMenu;
                    }
                    PanelFeatureState[] panelFeatureStateArr = appCompatDelegateImpl.mPanels;
                    int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
                    while (true) {
                        if (i >= length) {
                            panelFeatureState = null;
                        } else {
                            panelFeatureState = panelFeatureStateArr[i];
                            if (panelFeatureState == null || panelFeatureState.menu != menuBuilder) {
                                i++;
                            }
                        }
                    }
                    if (panelFeatureState != null) {
                        if (!z2) {
                            appCompatDelegateImpl.closePanel(panelFeatureState, z);
                        } else {
                            appCompatDelegateImpl.callOnPanelClosed(panelFeatureState.featureId, panelFeatureState, rootMenu);
                            appCompatDelegateImpl.closePanel(panelFeatureState, true);
                        }
                    }
                    break;
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback callback;
            byte b = this.$r8$classId;
            AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
            switch (b) {
                case 2:
                    Window.Callback callback2 = appCompatDelegateImpl.mWindow.getCallback();
                    if (callback2 != null) {
                        callback2.onMenuOpened(108, menuBuilder);
                    }
                    break;
                default:
                    if (menuBuilder == menuBuilder.getRootMenu() && appCompatDelegateImpl.mHasActionBar && (callback = appCompatDelegateImpl.mWindow.getCallback()) != null && !appCompatDelegateImpl.mDestroyed) {
                        callback.onMenuOpened(108, menuBuilder);
                    }
                    break;
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.AppCompatDelegateImpl$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass5 extends IntMath {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ AnonymousClass5(byte b, Object obj) {
            this.$r8$classId = b;
            this.this$0 = obj;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationEnd() {
            byte b = this.$r8$classId;
            Object obj = this.this$0;
            switch (b) {
                case 0:
                    AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) obj;
                    appCompatDelegateImpl.mActionModeView.setAlpha(1.0f);
                    appCompatDelegateImpl.mFadeAnim.setListener(null);
                    appCompatDelegateImpl.mFadeAnim = null;
                    break;
                case 1:
                    AppCompatDelegateImpl appCompatDelegateImpl2 = ((AnonymousClass1) obj).this$0;
                    appCompatDelegateImpl2.mActionModeView.setAlpha(1.0f);
                    appCompatDelegateImpl2.mFadeAnim.setListener(null);
                    appCompatDelegateImpl2.mFadeAnim = null;
                    break;
                default:
                    AppCompatDelegateImpl appCompatDelegateImpl3 = (AppCompatDelegateImpl) ((WeakCache) obj).referenceQueue;
                    appCompatDelegateImpl3.mActionModeView.setVisibility(8);
                    PopupWindow popupWindow = appCompatDelegateImpl3.mActionModePopup;
                    if (popupWindow != null) {
                        popupWindow.dismiss();
                    } else if (appCompatDelegateImpl3.mActionModeView.getParent() instanceof View) {
                        View view = (View) appCompatDelegateImpl3.mActionModeView.getParent();
                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        view.requestApplyInsets();
                    }
                    appCompatDelegateImpl3.mActionModeView.killMode();
                    appCompatDelegateImpl3.mFadeAnim.setListener(null);
                    appCompatDelegateImpl3.mFadeAnim = null;
                    ViewGroup viewGroup = appCompatDelegateImpl3.mSubDecor;
                    WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                    viewGroup.requestApplyInsets();
                    break;
            }
        }

        @Override // com.google.common.math.IntMath, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart() {
            byte b = this.$r8$classId;
            Object obj = this.this$0;
            switch (b) {
                case 0:
                    AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) obj;
                    appCompatDelegateImpl.mActionModeView.setVisibility(0);
                    if (appCompatDelegateImpl.mActionModeView.getParent() instanceof View) {
                        View view = (View) appCompatDelegateImpl.mActionModeView.getParent();
                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        view.requestApplyInsets();
                    }
                    break;
                case 1:
                    ((AnonymousClass1) obj).this$0.mActionModeView.setVisibility(0);
                    break;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(ContextThemeWrapper contextThemeWrapper) {
            super(contextThemeWrapper);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                    appCompatDelegateImpl.closePanel(appCompatDelegateImpl.getPanelState(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public final void setBackgroundResource(int i) {
            setBackgroundDrawable(SizeKt.getDrawable(getContext(), i));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class PanelFeatureState {
        public int background;
        public View createdPanelView;
        public ListMenuDecorView decorView;
        public int featureId;
        public Bundle frozenActionViewState;
        public byte gravity;
        public boolean isHandled;
        public boolean isOpen;
        public boolean isPrepared;
        public ListMenuPresenter listMenuPresenter;
        public ContextThemeWrapper listPresenterContext;
        public MenuBuilder menu;
        public boolean refreshDecorView;
        public boolean refreshMenuContent;
        public View shownPanelView;
        public int windowAnimations;
    }

    public AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback, Object obj) {
        AppCompatActivity appCompatActivity = null;
        this.mLocalNightMode = -100;
        this.mContext = context;
        this.mAppCompatCallback = appCompatCallback;
        this.mHost = obj;
        if (obj instanceof Dialog) {
            while (context != null) {
                if (!(context instanceof AppCompatActivity)) {
                    if (!(context instanceof ContextWrapper)) {
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                } else {
                    appCompatActivity = (AppCompatActivity) context;
                    break;
                }
            }
            if (appCompatActivity != null) {
                this.mLocalNightMode = ((AppCompatDelegateImpl) appCompatActivity.getDelegate()).mLocalNightMode;
            }
        }
        if (this.mLocalNightMode == -100) {
            String name = this.mHost.getClass().getName();
            SimpleArrayMap simpleArrayMap = sLocalNightModes;
            Integer num = (Integer) simpleArrayMap.get(name);
            if (num != null) {
                this.mLocalNightMode = num.intValue();
                simpleArrayMap.remove(this.mHost.getClass().getName());
            }
        }
        if (window != null) {
            attachToWindow(window);
        }
        AppCompatDrawableManager.preload();
    }

    public static LocaleListCompat calculateApplicationLocales(Context context) {
        LocaleListCompat localeListCompat;
        LocaleListCompat localeListCompat2;
        if (Build.VERSION.SDK_INT >= 33 || (localeListCompat = AppCompatDelegate.sRequestedAppLocales) == null) {
            return null;
        }
        LocaleListPlatformWrapper localeListPlatformWrapper = localeListCompat.mImpl;
        LocaleListCompat localeListCompatForLanguageTags = LocaleListCompat.forLanguageTags(context.getApplicationContext().getResources().getConfiguration().getLocales().toLanguageTags());
        if (localeListPlatformWrapper.mLocaleList.isEmpty()) {
            localeListCompat2 = LocaleListCompat.sEmptyLocaleList;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i = 0;
            while (i < localeListCompatForLanguageTags.mImpl.mLocaleList.size() + localeListPlatformWrapper.mLocaleList.size()) {
                Locale locale = i < localeListPlatformWrapper.mLocaleList.size() ? localeListPlatformWrapper.mLocaleList.get(i) : localeListCompatForLanguageTags.mImpl.mLocaleList.get(i - localeListPlatformWrapper.mLocaleList.size());
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
                i++;
            }
            localeListCompat2 = new LocaleListCompat(new LocaleListPlatformWrapper(new LocaleList((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]))));
        }
        return localeListCompat2.mImpl.mLocaleList.isEmpty() ? localeListCompatForLanguageTags : localeListCompat2;
    }

    public static Configuration createOverrideAppConfiguration(Context context, int i, LocaleListCompat localeListCompat, Configuration configuration, boolean z) {
        int i2;
        if (i == 1) {
            i2 = 16;
        } else if (i != 2) {
            i2 = z ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        } else {
            i2 = 32;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = CropImageView.DEFAULT_ASPECT_RATIO;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & (-49));
        if (localeListCompat != null) {
            configuration2.setLocales(LocaleList.forLanguageTags(localeListCompat.mImpl.mLocaleList.toLanguageTags()));
        }
        return configuration2;
    }

    /* JADX WARN: Code duplicated, block: B:70:0x0109  */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean applyApplicationSpecificConfig(boolean z, boolean z2) {
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        byte b = 0;
        if (this.mDestroyed) {
            return false;
        }
        int i2 = this.mLocalNightMode;
        if (i2 == -100) {
            i2 = AppCompatDelegate.sDefaultNightMode;
        }
        Context context = this.mContext;
        int iMapNightMode = mapNightMode(context, i2);
        int i3 = Build.VERSION.SDK_INT;
        LocaleListCompat localeListCompatCalculateApplicationLocales = i3 < 33 ? calculateApplicationLocales(context) : null;
        if (!z2 && localeListCompatCalculateApplicationLocales != null) {
            localeListCompatCalculateApplicationLocales = LocaleListCompat.forLanguageTags(context.getResources().getConfiguration().getLocales().toLanguageTags());
        }
        Configuration configurationCreateOverrideAppConfiguration = createOverrideAppConfiguration(context, iMapNightMode, localeListCompatCalculateApplicationLocales, null, false);
        boolean z6 = this.mActivityHandlesConfigFlagsChecked;
        Object obj = this.mHost;
        if (z6 || !(obj instanceof Activity)) {
            this.mActivityHandlesConfigFlagsChecked = true;
            i = this.mActivityHandlesConfigFlags;
        } else {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                i = 0;
            } else {
                try {
                    ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, obj.getClass()), i3 >= 29 ? 269221888 : 786432);
                    if (activityInfo != null) {
                        this.mActivityHandlesConfigFlags = activityInfo.configChanges;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    this.mActivityHandlesConfigFlags = 0;
                }
                this.mActivityHandlesConfigFlagsChecked = true;
                i = this.mActivityHandlesConfigFlags;
            }
        }
        Configuration configuration = this.mEffectiveConfiguration;
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        int i4 = configuration.uiMode & 48;
        int i5 = configurationCreateOverrideAppConfiguration.uiMode & 48;
        LocaleListCompat localeListCompatForLanguageTags = LocaleListCompat.forLanguageTags(configuration.getLocales().toLanguageTags());
        LocaleListCompat localeListCompatForLanguageTags2 = localeListCompatCalculateApplicationLocales == null ? null : LocaleListCompat.forLanguageTags(configurationCreateOverrideAppConfiguration.getLocales().toLanguageTags());
        int i6 = i4 != i5 ? 512 : 0;
        if (localeListCompatForLanguageTags2 != null && !localeListCompatForLanguageTags.equals(localeListCompatForLanguageTags2)) {
            i6 |= 8196;
        }
        if (((~i) & i6) != 0 && z && this.mBaseContextAttached && ((sCanReturnDifferentContext || this.mCreated) && (obj instanceof Activity))) {
            Activity activity = (Activity) obj;
            if (activity.isChild()) {
                z3 = false;
            } else {
                int i7 = Build.VERSION.SDK_INT;
                if (i7 >= 31 && (i6 & 8192) != 0) {
                    activity.getWindow().getDecorView().setLayoutDirection(configurationCreateOverrideAppConfiguration.getLayoutDirection());
                }
                if (i7 >= 28) {
                    activity.recreate();
                } else {
                    new Handler(activity.getMainLooper()).post(new ActivityCompat$$ExternalSyntheticLambda0(b, activity));
                }
                z3 = true;
            }
        } else {
            z3 = false;
        }
        if (z3 || i6 == 0) {
            z4 = z3;
        } else {
            b = (i & i6) == i6 ? (byte) 1 : (byte) 0;
            Resources resources = context.getResources();
            Configuration configuration2 = new Configuration(resources.getConfiguration());
            configuration2.uiMode = (resources.getConfiguration().uiMode & (-49)) | i5;
            if (localeListCompatForLanguageTags2 != null) {
                configuration2.setLocales(LocaleList.forLanguageTags(localeListCompatForLanguageTags2.mImpl.mLocaleList.toLanguageTags()));
            }
            resources.updateConfiguration(configuration2, null);
            int i8 = this.mThemeResId;
            if (i8 != 0) {
                context.setTheme(i8);
                z5 = true;
                context.getTheme().applyStyle(this.mThemeResId, true);
            } else {
                z5 = true;
            }
            if (b != 0 && (obj instanceof Activity)) {
                Activity activity2 = (Activity) obj;
                if (activity2 instanceof LifecycleOwner) {
                    if (((LifecycleRegistry) ((LifecycleOwner) activity2).getLifecycle()).state.compareTo(Lifecycle.State.CREATED) >= 0) {
                        activity2.onConfigurationChanged(configuration2);
                        this.mWindow.getDecorView().dispatchConfigurationChanged(configuration2);
                    }
                } else if (this.mCreated && !this.mDestroyed) {
                    activity2.onConfigurationChanged(configuration2);
                    this.mWindow.getDecorView().dispatchConfigurationChanged(configuration2);
                }
            }
            z4 = z5;
        }
        if (z4 && (obj instanceof AppCompatActivity)) {
            if ((i6 & 512) != 0) {
                ((AppCompatActivity) obj).onNightModeChanged(iMapNightMode);
            }
            if ((i6 & 4) != 0) {
                ((AppCompatActivity) obj).onLocalesChanged(localeListCompatCalculateApplicationLocales);
            }
        }
        if (localeListCompatForLanguageTags2 != null) {
            LocaleList.setDefault(LocaleList.forLanguageTags(LocaleListCompat.forLanguageTags(context.getResources().getConfiguration().getLocales().toLanguageTags()).mImpl.mLocaleList.toLanguageTags()));
        }
        if (i2 == 0) {
            getAutoTimeNightModeManager(context).setup();
        } else {
            AutoTimeNightModeManager autoTimeNightModeManager = this.mAutoTimeNightModeManager;
            if (autoTimeNightModeManager != null) {
                autoTimeNightModeManager.cleanup();
            }
        }
        AutoTimeNightModeManager autoTimeNightModeManager2 = this.mAutoBatteryNightModeManager;
        if (i2 == 3) {
            if (autoTimeNightModeManager2 == null) {
                autoTimeNightModeManager2 = new AutoTimeNightModeManager(context);
                this.mAutoBatteryNightModeManager = autoTimeNightModeManager2;
            }
            autoTimeNightModeManager2.setup();
        } else if (autoTimeNightModeManager2 != null) {
            autoTimeNightModeManager2.cleanup();
        }
        return z4;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0074  */
    public final void attachToWindow(Window window) {
        Drawable drawable;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        Api33Impl$$ExternalSyntheticLambda0 api33Impl$$ExternalSyntheticLambda0;
        int resourceId;
        if (this.mWindow != null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("AppCompat has already installed itself into the Window");
            return;
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof AppCompatWindowCallback) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("AppCompat has already installed itself into the Window");
            return;
        }
        AppCompatWindowCallback appCompatWindowCallback = new AppCompatWindowCallback(callback);
        this.mAppCompatWindowCallback = appCompatWindowCallback;
        window.setCallback(appCompatWindowCallback);
        Context context = this.mContext;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, sWindowBackgroundStyleable);
        if (!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) {
            drawable = null;
        } else {
            AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
            synchronized (appCompatDrawableManager) {
                drawable = appCompatDrawableManager.mResourceManager.getDrawable(context, resourceId, true);
            }
        }
        if (drawable != null) {
            window.setBackgroundDrawable(drawable);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.mWindow = window;
        if (Build.VERSION.SDK_INT < 33 || (onBackInvokedDispatcher = this.mDispatcher) != null) {
            return;
        }
        Object obj = this.mHost;
        if (onBackInvokedDispatcher != null && (api33Impl$$ExternalSyntheticLambda0 = this.mBackCallback) != null) {
            BundleCompat$Api33Impl.unregisterOnBackInvokedCallback(onBackInvokedDispatcher, api33Impl$$ExternalSyntheticLambda0);
            this.mBackCallback = null;
        }
        if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            if (activity.getWindow() != null) {
                this.mDispatcher = BundleCompat$Api33Impl.getOnBackInvokedDispatcher(activity);
            } else {
                this.mDispatcher = null;
            }
        } else {
            this.mDispatcher = null;
        }
        updateBackInvokedCallbackState();
    }

    public final void callOnPanelClosed(int i, PanelFeatureState panelFeatureState, MenuBuilder menuBuilder) {
        if (menuBuilder == null) {
            if (panelFeatureState == null && i >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.mPanels;
                if (i < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i];
                }
            }
            if (panelFeatureState != null) {
                menuBuilder = panelFeatureState.menu;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.isOpen) && !this.mDestroyed) {
            AppCompatWindowCallback appCompatWindowCallback = this.mAppCompatWindowCallback;
            Window.Callback callback = this.mWindow.getCallback();
            appCompatWindowCallback.getClass();
            try {
                appCompatWindowCallback.mOnPanelClosedBypassEnabled = true;
                callback.onPanelClosed(i, menuBuilder);
            } finally {
                appCompatWindowCallback.mOnPanelClosedBypassEnabled = false;
            }
        }
    }

    public final void checkCloseActionMenu(MenuBuilder menuBuilder) {
        ActionMenuPresenter actionMenuPresenter;
        if (this.mClosingActionMenu) {
            return;
        }
        this.mClosingActionMenu = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.mDecorContentParent;
        actionBarOverlayLayout.pullChildren();
        ActionMenuView actionMenuView = ((ToolbarWidgetWrapper) actionBarOverlayLayout.mDecorToolbar).mToolbar.mMenuView;
        if (actionMenuView != null && (actionMenuPresenter = actionMenuView.mPresenter) != null) {
            actionMenuPresenter.hideOverflowMenu();
            ActionMenuPresenter.OverflowPopup overflowPopup = actionMenuPresenter.mActionButtonPopup;
            if (overflowPopup != null && overflowPopup.isShowing()) {
                overflowPopup.mPopup.dismiss();
            }
        }
        Window.Callback callback = this.mWindow.getCallback();
        if (callback != null && !this.mDestroyed) {
            callback.onPanelClosed(108, menuBuilder);
        }
        this.mClosingActionMenu = false;
    }

    public final void closePanel(PanelFeatureState panelFeatureState, boolean z) {
        ListMenuDecorView listMenuDecorView;
        ActionBarOverlayLayout actionBarOverlayLayout;
        if (z && panelFeatureState.featureId == 0 && (actionBarOverlayLayout = this.mDecorContentParent) != null) {
            actionBarOverlayLayout.pullChildren();
            if (((ToolbarWidgetWrapper) actionBarOverlayLayout.mDecorToolbar).mToolbar.isOverflowMenuShowing()) {
                checkCloseActionMenu(panelFeatureState.menu);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null && panelFeatureState.isOpen && (listMenuDecorView = panelFeatureState.decorView) != null) {
            windowManager.removeView(listMenuDecorView);
            if (z) {
                callOnPanelClosed(panelFeatureState.featureId, panelFeatureState, null);
            }
        }
        panelFeatureState.isPrepared = false;
        panelFeatureState.isHandled = false;
        panelFeatureState.isOpen = false;
        panelFeatureState.shownPanelView = null;
        panelFeatureState.refreshDecorView = true;
        if (this.mPreparedPanel == panelFeatureState) {
            this.mPreparedPanel = null;
        }
        if (panelFeatureState.featureId == 0) {
            updateBackInvokedCallbackState();
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003f  */
    /* JADX WARN: Code duplicated, block: B:23:0x004a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x004c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:30:0x005e  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x006b  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x0071 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x007b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0085  */
    /* JADX WARN: Code duplicated, block: B:68:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:85:0x0113  */
    /* JADX WARN: Code duplicated, block: B:87:0x0121  */
    /* JADX WARN: Code duplicated, block: B:89:0x0125  */
    /* JADX WARN: Code duplicated, block: B:91:0x012d  */
    /* JADX WARN: Code duplicated, block: B:94:0x0134 A[RETURN] */
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView;
        int keyCode;
        PanelFeatureState panelState;
        ActionBarOverlayLayout actionBarOverlayLayout;
        Context context;
        boolean z;
        boolean zShowOverflowMenu;
        boolean zPreparePanel;
        AudioManager audioManager;
        Toolbar toolbar;
        ActionMenuView actionMenuView;
        ActionMenuPresenter actionMenuPresenter;
        PanelFeatureState panelState2;
        Object obj = this.mHost;
        if ((!(obj instanceof KeyEventDispatcher$Component) && !(obj instanceof AlertDialog)) || (decorView = this.mWindow.getDecorView()) == null || !ViewCompat.dispatchUnhandledKeyEventBeforeHierarchy(decorView, keyEvent)) {
            if (keyEvent.getKeyCode() == 82) {
                AppCompatWindowCallback appCompatWindowCallback = this.mAppCompatWindowCallback;
                Window.Callback callback = this.mWindow.getCallback();
                appCompatWindowCallback.getClass();
                try {
                    appCompatWindowCallback.mDispatchKeyEventBypassEnabled = true;
                    boolean zDispatchKeyEvent = callback.dispatchKeyEvent(keyEvent);
                    appCompatWindowCallback.mDispatchKeyEventBypassEnabled = false;
                    if (!zDispatchKeyEvent) {
                        keyCode = keyEvent.getKeyCode();
                        if (keyEvent.getAction() == 0) {
                            if (keyCode != 4) {
                                this.mLongPressBackDown = (keyEvent.getFlags() & 128) != 0;
                                return false;
                            }
                            if (keyCode == 82) {
                                if (keyEvent.getRepeatCount() == 0) {
                                    panelState2 = getPanelState(0);
                                    if (!panelState2.isOpen) {
                                        preparePanel(panelState2, keyEvent);
                                        return true;
                                    }
                                }
                            }
                            return false;
                        }
                        if (keyCode != 4) {
                            if (keyCode == 82) {
                                if (this.mActionMode == null) {
                                    panelState = getPanelState(0);
                                    actionBarOverlayLayout = this.mDecorContentParent;
                                    context = this.mContext;
                                    if (actionBarOverlayLayout != null) {
                                        actionBarOverlayLayout.pullChildren();
                                        toolbar = ((ToolbarWidgetWrapper) actionBarOverlayLayout.mDecorToolbar).mToolbar;
                                        if (toolbar.getVisibility() == 0 || (actionMenuView = toolbar.mMenuView) == null || !actionMenuView.mReserveOverflow || ViewConfiguration.get(context).hasPermanentMenuKey()) {
                                            z = panelState.isOpen;
                                            if (!z || panelState.isHandled) {
                                                closePanel(panelState, true);
                                                zShowOverflowMenu = z;
                                            } else {
                                                if (panelState.isPrepared) {
                                                    if (panelState.refreshMenuContent) {
                                                        panelState.isPrepared = false;
                                                        zPreparePanel = preparePanel(panelState, keyEvent);
                                                    } else {
                                                        zPreparePanel = true;
                                                    }
                                                    if (zPreparePanel) {
                                                        openPanel(panelState, keyEvent);
                                                        zShowOverflowMenu = true;
                                                    }
                                                }
                                                zShowOverflowMenu = false;
                                            }
                                        } else {
                                            ActionBarOverlayLayout actionBarOverlayLayout2 = this.mDecorContentParent;
                                            actionBarOverlayLayout2.pullChildren();
                                            if (((ToolbarWidgetWrapper) actionBarOverlayLayout2.mDecorToolbar).mToolbar.isOverflowMenuShowing()) {
                                                ActionBarOverlayLayout actionBarOverlayLayout3 = this.mDecorContentParent;
                                                actionBarOverlayLayout3.pullChildren();
                                                ActionMenuView actionMenuView2 = ((ToolbarWidgetWrapper) actionBarOverlayLayout3.mDecorToolbar).mToolbar.mMenuView;
                                                if (actionMenuView2 != null && (actionMenuPresenter = actionMenuView2.mPresenter) != null && actionMenuPresenter.hideOverflowMenu()) {
                                                    zShowOverflowMenu = true;
                                                }
                                            } else if (!this.mDestroyed && preparePanel(panelState, keyEvent)) {
                                                ActionBarOverlayLayout actionBarOverlayLayout4 = this.mDecorContentParent;
                                                actionBarOverlayLayout4.pullChildren();
                                                zShowOverflowMenu = ((ToolbarWidgetWrapper) actionBarOverlayLayout4.mDecorToolbar).mToolbar.showOverflowMenu();
                                            }
                                            zShowOverflowMenu = false;
                                        }
                                    } else {
                                        z = panelState.isOpen;
                                        if (z) {
                                        }
                                        closePanel(panelState, true);
                                        zShowOverflowMenu = z;
                                    }
                                    if (zShowOverflowMenu) {
                                        audioManager = (AudioManager) context.getApplicationContext().getSystemService(ContentType.Audio.TYPE);
                                        if (audioManager != null) {
                                            audioManager.playSoundEffect(0);
                                            return true;
                                        }
                                        Log.w("AppCompatDelegate", "Couldn't get audio manager");
                                        return true;
                                    }
                                }
                            }
                            return false;
                        }
                        if (onBackPressed()) {
                            return false;
                        }
                    }
                } catch (Throwable th) {
                    appCompatWindowCallback.mDispatchKeyEventBypassEnabled = false;
                    throw th;
                }
            } else {
                keyCode = keyEvent.getKeyCode();
                if (keyEvent.getAction() == 0) {
                    if (keyCode != 4) {
                        this.mLongPressBackDown = (keyEvent.getFlags() & 128) != 0;
                        return false;
                    }
                    if (keyCode == 82) {
                        if (keyEvent.getRepeatCount() == 0) {
                            panelState2 = getPanelState(0);
                            if (!panelState2.isOpen) {
                                preparePanel(panelState2, keyEvent);
                                return true;
                            }
                        }
                    }
                    return false;
                }
                if (keyCode != 4) {
                    if (keyCode == 82) {
                        if (this.mActionMode == null) {
                            panelState = getPanelState(0);
                            actionBarOverlayLayout = this.mDecorContentParent;
                            context = this.mContext;
                            if (actionBarOverlayLayout != null) {
                                actionBarOverlayLayout.pullChildren();
                                toolbar = ((ToolbarWidgetWrapper) actionBarOverlayLayout.mDecorToolbar).mToolbar;
                                if (toolbar.getVisibility() == 0) {
                                    z = panelState.isOpen;
                                    if (z) {
                                    }
                                    closePanel(panelState, true);
                                    zShowOverflowMenu = z;
                                } else {
                                    z = panelState.isOpen;
                                    if (z) {
                                    }
                                    closePanel(panelState, true);
                                    zShowOverflowMenu = z;
                                }
                            } else {
                                z = panelState.isOpen;
                                if (z) {
                                }
                                closePanel(panelState, true);
                                zShowOverflowMenu = z;
                            }
                            if (zShowOverflowMenu) {
                                audioManager = (AudioManager) context.getApplicationContext().getSystemService(ContentType.Audio.TYPE);
                                if (audioManager != null) {
                                    audioManager.playSoundEffect(0);
                                    return true;
                                }
                                Log.w("AppCompatDelegate", "Couldn't get audio manager");
                                return true;
                            }
                        }
                    }
                    return false;
                }
                if (onBackPressed()) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void doInvalidatePanelMenu(int i) {
        PanelFeatureState panelState = getPanelState(i);
        if (panelState.menu != null) {
            Bundle bundle = new Bundle();
            panelState.menu.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                panelState.frozenActionViewState = bundle;
            }
            panelState.menu.stopDispatchingItemsChanged();
            panelState.menu.clear();
        }
        panelState.refreshMenuContent = true;
        panelState.refreshDecorView = true;
        if ((i == 108 || i == 0) && this.mDecorContentParent != null) {
            PanelFeatureState panelState2 = getPanelState(0);
            panelState2.isPrepared = false;
            preparePanel(panelState2, null);
        }
    }

    public final void ensureSubDecor() {
        ViewGroup viewGroup;
        if (this.mSubDecorInstalled) {
            return;
        }
        Context context = this.mContext;
        int[] iArr = R$styleable.AppCompatTheme;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(117)) {
            typedArrayObtainStyledAttributes.recycle();
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
            return;
        }
        byte b = 0;
        byte b2 = 1;
        if (typedArrayObtainStyledAttributes.getBoolean(126, false)) {
            requestWindowFeature(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(117, false)) {
            requestWindowFeature(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(118, false)) {
            requestWindowFeature(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(119, false)) {
            requestWindowFeature(10);
        }
        this.mIsFloating = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        ensureWindow();
        this.mWindow.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.mWindowNoTitle) {
            viewGroup = this.mOverlayActionMode ? (ViewGroup) layoutInflaterFrom.inflate(com.yalantis.ucrop.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(com.yalantis.ucrop.R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.mIsFloating) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(com.yalantis.ucrop.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.mOverlayActionBar = false;
            this.mHasActionBar = false;
        } else if (this.mHasActionBar) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(com.yalantis.ucrop.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new ContextThemeWrapper(context, typedValue.resourceId) : context).inflate(com.yalantis.ucrop.R.layout.abc_screen_toolbar, (ViewGroup) null);
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) viewGroup.findViewById(com.yalantis.ucrop.R.id.decor_content_parent);
            this.mDecorContentParent = actionBarOverlayLayout;
            actionBarOverlayLayout.setWindowCallback(this.mWindow.getCallback());
            if (this.mOverlayActionBar) {
                this.mDecorContentParent.initFeature(109);
            }
            if (this.mFeatureProgress) {
                this.mDecorContentParent.initFeature(2);
            }
            if (this.mFeatureIndeterminateProgress) {
                this.mDecorContentParent.initFeature(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            StringBuilder sb = new StringBuilder("AppCompat does not support the current theme features: { windowActionBar: ");
            sb.append(this.mHasActionBar);
            sb.append(", windowActionBarOverlay: ");
            sb.append(this.mOverlayActionBar);
            sb.append(", android:windowIsFloating: ");
            sb.append(this.mIsFloating);
            sb.append(", windowActionModeOverlay: ");
            sb.append(this.mOverlayActionMode);
            sb.append(", windowNoTitle: ");
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1(IntIntPair$$ExternalSyntheticOutline0.m(sb, this.mWindowNoTitle, " }"));
            return;
        }
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this, b);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(viewGroup, anonymousClass2);
        if (this.mDecorContentParent == null) {
            this.mTitleView = (TextView) viewGroup.findViewById(com.yalantis.ucrop.R.id.title);
        }
        boolean z = ViewUtils.sInitComputeFitSystemWindowsMethod;
        try {
            Method method = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(viewGroup, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(com.yalantis.ucrop.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.mWindow.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.mWindow.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new AnonymousClass2(this, b2));
        this.mSubDecor = viewGroup;
        Object obj = this.mHost;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.mTitle;
        if (!TextUtils.isEmpty(title)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.mDecorContentParent;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setWindowTitle(title);
            } else {
                ActionBar actionBar = this.mActionBar;
                if (actionBar != null) {
                    actionBar.setWindowTitle(title);
                } else {
                    TextView textView = this.mTitleView;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.mSubDecor.findViewById(R.id.content);
        View decorView = this.mWindow.getDecorView();
        contentFrameLayout2.mDecorPadding.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        if (contentFrameLayout2.isLaidOut()) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(iArr);
        typedArrayObtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
        typedArrayObtainStyledAttributes2.getValue(ControlFramesKt.MAX_CONTROL_FRAME_PAYLOAD_SIZE, contentFrameLayout2.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes2.hasValue(122)) {
            typedArrayObtainStyledAttributes2.getValue(122, contentFrameLayout2.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(ControlFramesKt.MAX_CLOSE_REASON_MESSAGE_SIZE)) {
            typedArrayObtainStyledAttributes2.getValue(ControlFramesKt.MAX_CLOSE_REASON_MESSAGE_SIZE, contentFrameLayout2.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(120)) {
            typedArrayObtainStyledAttributes2.getValue(120, contentFrameLayout2.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(121)) {
            typedArrayObtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.mSubDecorInstalled = true;
        PanelFeatureState panelState = getPanelState(0);
        if (this.mDestroyed || panelState.menu != null) {
            return;
        }
        invalidatePanelMenu(108);
    }

    public final void ensureWindow() {
        if (this.mWindow == null) {
            Object obj = this.mHost;
            if (obj instanceof Activity) {
                attachToWindow(((Activity) obj).getWindow());
            }
        }
        if (this.mWindow != null) {
            return;
        }
        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("We have not been given a Window");
    }

    public final BaseMenuWrapper getAutoTimeNightModeManager(Context context) {
        AutoTimeNightModeManager autoTimeNightModeManager = this.mAutoTimeNightModeManager;
        if (autoTimeNightModeManager == null) {
            EmojiProcessor emojiProcessor = EmojiProcessor.sInstance;
            if (emojiProcessor == null) {
                Context applicationContext = context.getApplicationContext();
                emojiProcessor = new EmojiProcessor(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
                EmojiProcessor.sInstance = emojiProcessor;
            }
            autoTimeNightModeManager = new AutoTimeNightModeManager(emojiProcessor);
            this.mAutoTimeNightModeManager = autoTimeNightModeManager;
        }
        return autoTimeNightModeManager;
    }

    public final PanelFeatureState getPanelState(int i) {
        PanelFeatureState[] panelFeatureStateArr = this.mPanels;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.mPanels = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState();
        panelFeatureState2.featureId = i;
        panelFeatureState2.refreshDecorView = false;
        panelFeatureStateArr[i] = panelFeatureState2;
        return panelFeatureState2;
    }

    public final void initWindowDecorActionBar() {
        ActionBar windowDecorActionBar;
        ensureSubDecor();
        if (this.mHasActionBar && (windowDecorActionBar = this.mActionBar) == null) {
            Object obj = this.mHost;
            if (obj instanceof Activity) {
                windowDecorActionBar = new WindowDecorActionBar((Activity) obj, this.mOverlayActionBar);
                this.mActionBar = windowDecorActionBar;
            } else if (obj instanceof Dialog) {
                windowDecorActionBar = new WindowDecorActionBar((Dialog) obj);
                this.mActionBar = windowDecorActionBar;
            }
            if (windowDecorActionBar != null) {
                windowDecorActionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void installViewFactory() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.mContext);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof AppCompatDelegateImpl) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void invalidateOptionsMenu() {
        if (this.mActionBar != null) {
            initWindowDecorActionBar();
            if (this.mActionBar.invalidateOptionsMenu()) {
                return;
            }
            invalidatePanelMenu(0);
        }
    }

    public final void invalidatePanelMenu(int i) {
        this.mInvalidatePanelMenuFeatures = (1 << i) | this.mInvalidatePanelMenuFeatures;
        if (this.mInvalidatePanelMenuPosted) {
            return;
        }
        View decorView = this.mWindow.getDecorView();
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        decorView.postOnAnimation(this.mInvalidatePanelMenuRunnable);
        this.mInvalidatePanelMenuPosted = true;
    }

    public final int mapNightMode(Context context, int i) {
        if (i != -100) {
            if (i != -1) {
                if (i != 0) {
                    if (i != 1 && i != 2) {
                        if (i != 3) {
                            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                            return 0;
                        }
                        AutoTimeNightModeManager autoTimeNightModeManager = this.mAutoBatteryNightModeManager;
                        if (autoTimeNightModeManager == null) {
                            autoTimeNightModeManager = new AutoTimeNightModeManager(context);
                            this.mAutoBatteryNightModeManager = autoTimeNightModeManager;
                        }
                        return autoTimeNightModeManager.getApplyableNightMode();
                    }
                } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return getAutoTimeNightModeManager(context).getApplyableNightMode();
                }
            }
            return i;
        }
        return -1;
    }

    public final boolean onBackPressed() {
        boolean z = this.mLongPressBackDown;
        this.mLongPressBackDown = false;
        PanelFeatureState panelState = getPanelState(0);
        if (!panelState.isOpen) {
            ActionMode actionMode = this.mActionMode;
            if (actionMode != null) {
                actionMode.finish();
                return true;
            }
            initWindowDecorActionBar();
            ActionBar actionBar = this.mActionBar;
            if (actionBar == null || !actionBar.collapseActionView()) {
                return false;
            }
        } else if (!z) {
            closePanel(panelState, true);
            return true;
        }
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void onCreate() {
        String parentActivityName;
        this.mBaseContextAttached = true;
        applyApplicationSpecificConfig(false, true);
        ensureWindow();
        Object obj = this.mHost;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    parentActivityName = NavUtils.getParentActivityName(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            } catch (IllegalArgumentException unused) {
                parentActivityName = null;
            }
            if (parentActivityName != null) {
                ActionBar actionBar = this.mActionBar;
                if (actionBar == null) {
                    this.mEnableDefaultActionBarUp = true;
                } else {
                    actionBar.setDefaultDisplayHomeAsUpEnabled(true);
                }
            }
            synchronized (AppCompatDelegate.sActivityDelegatesLock) {
                AppCompatDelegate.removeDelegateFromActives(this);
                AppCompatDelegate.sActivityDelegates.add(new WeakReference(this));
            }
        }
        this.mEffectiveConfiguration = new Configuration(this.mContext.getResources().getConfiguration());
        this.mCreated = true;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View appCompatRatingBar;
        AppCompatViewInflater appCompatViewInflater = this.mAppCompatViewInflater;
        View view2 = null;
        if (appCompatViewInflater == null) {
            int[] iArr = R$styleable.AppCompatTheme;
            Context context2 = this.mContext;
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(iArr);
            String string = typedArrayObtainStyledAttributes.getString(116);
            typedArrayObtainStyledAttributes.recycle();
            if (string == null) {
                appCompatViewInflater = new AppCompatViewInflater();
                this.mAppCompatViewInflater = appCompatViewInflater;
            } else {
                try {
                    appCompatViewInflater = (AppCompatViewInflater) context2.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                    this.mAppCompatViewInflater = appCompatViewInflater;
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    appCompatViewInflater = new AppCompatViewInflater();
                    this.mAppCompatViewInflater = appCompatViewInflater;
                }
            }
        }
        appCompatViewInflater.getClass();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.View, 0, 0);
        byte b = 4;
        int resourceId = typedArrayObtainStyledAttributes2.getResourceId(4, 0);
        if (resourceId != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes2.recycle();
        Context contextThemeWrapper = (resourceId == 0 || ((context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).mThemeResource == resourceId)) ? context : new ContextThemeWrapper(context, resourceId);
        str.getClass();
        switch (str.hashCode()) {
            case -1946472170:
                b = !str.equals("RatingBar") ? (byte) -1 : (byte) 0;
                break;
            case -1455429095:
                b = !str.equals("CheckedTextView") ? (byte) -1 : (byte) 1;
                break;
            case -1346021293:
                b = !str.equals("MultiAutoCompleteTextView") ? (byte) -1 : (byte) 2;
                break;
            case -938935918:
                b = !str.equals("TextView") ? (byte) -1 : (byte) 3;
                break;
            case -937446323:
                if (!str.equals("ImageButton")) {
                    b = -1;
                }
                break;
            case -658531749:
                b = !str.equals("SeekBar") ? (byte) -1 : (byte) 5;
                break;
            case -339785223:
                b = !str.equals("Spinner") ? (byte) -1 : (byte) 6;
                break;
            case 776382189:
                b = !str.equals("RadioButton") ? (byte) -1 : (byte) 7;
                break;
            case 799298502:
                b = !str.equals("ToggleButton") ? (byte) -1 : (byte) 8;
                break;
            case 1125864064:
                b = !str.equals("ImageView") ? (byte) -1 : (byte) 9;
                break;
            case 1413872058:
                b = !str.equals("AutoCompleteTextView") ? (byte) -1 : (byte) 10;
                break;
            case 1601505219:
                b = !str.equals("CheckBox") ? (byte) -1 : (byte) 11;
                break;
            case 1666676343:
                b = !str.equals("EditText") ? (byte) -1 : (byte) 12;
                break;
            case 2001146706:
                b = !str.equals("Button") ? (byte) -1 : (byte) 13;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                appCompatRatingBar = new AppCompatRatingBar(contextThemeWrapper, attributeSet);
                break;
            case 1:
                appCompatRatingBar = new AppCompatCheckedTextView(contextThemeWrapper, attributeSet);
                break;
            case 2:
                appCompatRatingBar = new AppCompatMultiAutoCompleteTextView(contextThemeWrapper, attributeSet);
                break;
            case 3:
                appCompatRatingBar = new AppCompatTextView(contextThemeWrapper, attributeSet);
                break;
            case 4:
                appCompatRatingBar = new AppCompatImageButton(contextThemeWrapper, attributeSet, com.yalantis.ucrop.R.attr.imageButtonStyle);
                break;
            case 5:
                appCompatRatingBar = new AppCompatSeekBar(contextThemeWrapper, attributeSet);
                break;
            case 6:
                appCompatRatingBar = new AppCompatSpinner(contextThemeWrapper, attributeSet);
                break;
            case 7:
                appCompatRatingBar = new AppCompatRadioButton(contextThemeWrapper, attributeSet);
                break;
            case 8:
                appCompatRatingBar = new AppCompatToggleButton(contextThemeWrapper, attributeSet);
                break;
            case 9:
                appCompatRatingBar = new AppCompatImageView(contextThemeWrapper, attributeSet, 0);
                break;
            case 10:
                appCompatRatingBar = new AppCompatAutoCompleteTextView(contextThemeWrapper, attributeSet);
                break;
            case 11:
                appCompatRatingBar = new AppCompatCheckBox(contextThemeWrapper, attributeSet);
                break;
            case DictionaryEntry.PRONUNCIATION /* 12 */:
                appCompatRatingBar = new AppCompatEditText(contextThemeWrapper, attributeSet);
                break;
            case 13:
                appCompatRatingBar = new AppCompatButton(contextThemeWrapper, attributeSet);
                break;
            default:
                appCompatRatingBar = null;
                break;
        }
        if (appCompatRatingBar == null && context != contextThemeWrapper) {
            Object[] objArr = appCompatViewInflater.mConstructorArgs;
            if (str.equals("view")) {
                str = attributeSet.getAttributeValue(null, "class");
            }
            try {
                objArr[0] = contextThemeWrapper;
                objArr[1] = attributeSet;
                if (-1 == str.indexOf(46)) {
                    int i = 0;
                    while (true) {
                        String[] strArr = AppCompatViewInflater.sClassPrefixList;
                        if (i < 3) {
                            View viewCreateViewByPrefix = appCompatViewInflater.createViewByPrefix(contextThemeWrapper, str, strArr[i]);
                            if (viewCreateViewByPrefix != null) {
                                objArr[0] = null;
                                objArr[1] = null;
                                view2 = viewCreateViewByPrefix;
                            } else {
                                i++;
                            }
                        } else {
                            objArr[0] = null;
                            objArr[1] = null;
                        }
                    }
                } else {
                    View viewCreateViewByPrefix2 = appCompatViewInflater.createViewByPrefix(contextThemeWrapper, str, null);
                    objArr[0] = null;
                    objArr[1] = null;
                    view2 = viewCreateViewByPrefix2;
                }
            } catch (Exception unused) {
                objArr[0] = null;
                objArr[1] = null;
            } catch (Throwable th2) {
                objArr[0] = null;
                objArr[1] = null;
                throw th2;
            }
            appCompatRatingBar = view2;
        }
        if (appCompatRatingBar != null) {
            Context context3 = appCompatRatingBar.getContext();
            if ((context3 instanceof ContextWrapper) && appCompatRatingBar.hasOnClickListeners()) {
                TypedArray typedArrayObtainStyledAttributes3 = context3.obtainStyledAttributes(attributeSet, AppCompatViewInflater.sOnClickAttrs);
                String string2 = typedArrayObtainStyledAttributes3.getString(0);
                if (string2 != null) {
                    appCompatRatingBar.setOnClickListener(new AppCompatViewInflater.DeclaredOnClickListener(appCompatRatingBar, string2));
                }
                typedArrayObtainStyledAttributes3.recycle();
            }
            if (Build.VERSION.SDK_INT <= 28) {
                TypedArray typedArrayObtainStyledAttributes4 = contextThemeWrapper.obtainStyledAttributes(attributeSet, AppCompatViewInflater.sAccessibilityHeading);
                if (typedArrayObtainStyledAttributes4.hasValue(0)) {
                    boolean z = typedArrayObtainStyledAttributes4.getBoolean(0, false);
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    new ViewCompat.AnonymousClass1(com.yalantis.ucrop.R.id.tag_accessibility_heading, Boolean.class, 0, 28, (byte) 2).set(appCompatRatingBar, Boolean.valueOf(z));
                }
                typedArrayObtainStyledAttributes4.recycle();
                TypedArray typedArrayObtainStyledAttributes5 = contextThemeWrapper.obtainStyledAttributes(attributeSet, AppCompatViewInflater.sAccessibilityPaneTitle);
                if (typedArrayObtainStyledAttributes5.hasValue(0)) {
                    ViewCompat.setAccessibilityPaneTitle(appCompatRatingBar, typedArrayObtainStyledAttributes5.getString(0));
                }
                typedArrayObtainStyledAttributes5.recycle();
                TypedArray typedArrayObtainStyledAttributes6 = contextThemeWrapper.obtainStyledAttributes(attributeSet, AppCompatViewInflater.sScreenReaderFocusable);
                if (typedArrayObtainStyledAttributes6.hasValue(0)) {
                    boolean z2 = typedArrayObtainStyledAttributes6.getBoolean(0, false);
                    WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                    new ViewCompat.AnonymousClass1(com.yalantis.ucrop.R.id.tag_screen_reader_focusable, Boolean.class, 0, 28, (byte) 0).set(appCompatRatingBar, Boolean.valueOf(z2));
                }
                typedArrayObtainStyledAttributes6.recycle();
            }
        }
        return appCompatRatingBar;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004d  */
    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void onDestroy() {
        if (this.mHost instanceof Activity) {
            synchronized (AppCompatDelegate.sActivityDelegatesLock) {
                AppCompatDelegate.removeDelegateFromActives(this);
            }
        }
        if (this.mInvalidatePanelMenuPosted) {
            this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
        }
        this.mDestroyed = true;
        if (this.mLocalNightMode != -100) {
            Object obj = this.mHost;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                sLocalNightModes.put(this.mHost.getClass().getName(), Integer.valueOf(this.mLocalNightMode));
            } else {
                sLocalNightModes.remove(this.mHost.getClass().getName());
            }
        } else {
            sLocalNightModes.remove(this.mHost.getClass().getName());
        }
        ActionBar actionBar = this.mActionBar;
        if (actionBar != null) {
            actionBar.onDestroy();
        }
        AutoTimeNightModeManager autoTimeNightModeManager = this.mAutoTimeNightModeManager;
        if (autoTimeNightModeManager != null) {
            autoTimeNightModeManager.cleanup();
        }
        AutoTimeNightModeManager autoTimeNightModeManager2 = this.mAutoBatteryNightModeManager;
        if (autoTimeNightModeManager2 != null) {
            autoTimeNightModeManager2.cleanup();
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x002a  */
    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState panelFeatureState;
        Window.Callback callback = this.mWindow.getCallback();
        if (callback != null && !this.mDestroyed) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            PanelFeatureState[] panelFeatureStateArr = this.mPanels;
            int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
            for (int i = 0; i < length; i++) {
                panelFeatureState = panelFeatureStateArr[i];
                if (panelFeatureState != null && panelFeatureState.menu == rootMenu) {
                    if (panelFeatureState != null) {
                        return callback.onMenuItemSelected(panelFeatureState.featureId, menuItem);
                    }
                }
            }
            panelFeatureState = null;
            if (panelFeatureState != null) {
                return callback.onMenuItemSelected(panelFeatureState.featureId, menuItem);
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
    
        if (r6.isOverflowMenuShowing() != false) goto L20;
     */
    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMenuModeChange(MenuBuilder menuBuilder) {
        ActionMenuView actionMenuView;
        ActionMenuPresenter actionMenuPresenter;
        ActionBarOverlayLayout actionBarOverlayLayout = this.mDecorContentParent;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.pullChildren();
            Toolbar toolbar = ((ToolbarWidgetWrapper) actionBarOverlayLayout.mDecorToolbar).mToolbar;
            if (toolbar.getVisibility() == 0 && (actionMenuView = toolbar.mMenuView) != null && actionMenuView.mReserveOverflow) {
                if (ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) {
                    ActionBarOverlayLayout actionBarOverlayLayout2 = this.mDecorContentParent;
                    actionBarOverlayLayout2.pullChildren();
                    ActionMenuView actionMenuView2 = ((ToolbarWidgetWrapper) actionBarOverlayLayout2.mDecorToolbar).mToolbar.mMenuView;
                    if (actionMenuView2 != null) {
                        ActionMenuPresenter actionMenuPresenter2 = actionMenuView2.mPresenter;
                        if (actionMenuPresenter2 != null) {
                            if (actionMenuPresenter2.mPostedOpenRunnable == null) {
                            }
                        }
                    }
                }
                Window.Callback callback = this.mWindow.getCallback();
                ActionBarOverlayLayout actionBarOverlayLayout3 = this.mDecorContentParent;
                actionBarOverlayLayout3.pullChildren();
                if (((ToolbarWidgetWrapper) actionBarOverlayLayout3.mDecorToolbar).mToolbar.isOverflowMenuShowing()) {
                    ActionBarOverlayLayout actionBarOverlayLayout4 = this.mDecorContentParent;
                    actionBarOverlayLayout4.pullChildren();
                    ActionMenuView actionMenuView3 = ((ToolbarWidgetWrapper) actionBarOverlayLayout4.mDecorToolbar).mToolbar.mMenuView;
                    if (actionMenuView3 != null && (actionMenuPresenter = actionMenuView3.mPresenter) != null) {
                        actionMenuPresenter.hideOverflowMenu();
                    }
                    if (this.mDestroyed) {
                        return;
                    }
                    callback.onPanelClosed(108, getPanelState(0).menu);
                    return;
                }
                if (callback == null || this.mDestroyed) {
                    return;
                }
                if (this.mInvalidatePanelMenuPosted && (1 & this.mInvalidatePanelMenuFeatures) != 0) {
                    View decorView = this.mWindow.getDecorView();
                    AnonymousClass1 anonymousClass1 = this.mInvalidatePanelMenuRunnable;
                    decorView.removeCallbacks(anonymousClass1);
                    anonymousClass1.run();
                }
                PanelFeatureState panelState = getPanelState(0);
                MenuBuilder menuBuilder2 = panelState.menu;
                if (menuBuilder2 == null || panelState.refreshMenuContent || !callback.onPreparePanel(0, panelState.createdPanelView, menuBuilder2)) {
                    return;
                }
                callback.onMenuOpened(108, panelState.menu);
                ActionBarOverlayLayout actionBarOverlayLayout5 = this.mDecorContentParent;
                actionBarOverlayLayout5.pullChildren();
                ((ToolbarWidgetWrapper) actionBarOverlayLayout5.mDecorToolbar).mToolbar.showOverflowMenu();
                return;
            }
        }
        PanelFeatureState panelState2 = getPanelState(0);
        panelState2.refreshDecorView = true;
        closePanel(panelState2, false);
        openPanel(panelState2, null);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0171, code lost:
    
        if (r6.getCount() > 0) goto L88;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void openPanel(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        boolean z = panelFeatureState.isOpen;
        int i2 = panelFeatureState.featureId;
        if (z || this.mDestroyed) {
            return;
        }
        Context context = this.mContext;
        if (i2 == 0 && (context.getResources().getConfiguration().screenLayout & 15) == 4) {
            return;
        }
        Window.Callback callback = this.mWindow.getCallback();
        if (callback != null && !callback.onMenuOpened(i2, panelFeatureState.menu)) {
            closePanel(panelFeatureState, true);
            return;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null && preparePanel(panelFeatureState, keyEvent)) {
            ListMenuDecorView listMenuDecorView = panelFeatureState.decorView;
            if (listMenuDecorView != null && !panelFeatureState.refreshDecorView) {
                View view = panelFeatureState.createdPanelView;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i = -1;
                }
                panelFeatureState.isHandled = false;
                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i, -2, 0, 0, 1002, 8519680, -3);
                layoutParams2.gravity = panelFeatureState.gravity;
                layoutParams2.windowAnimations = panelFeatureState.windowAnimations;
                windowManager.addView(panelFeatureState.decorView, layoutParams2);
                panelFeatureState.isOpen = true;
                if (i2 == 0) {
                    updateBackInvokedCallbackState();
                }
            }
            if (listMenuDecorView == null) {
                initWindowDecorActionBar();
                ActionBar actionBar = this.mActionBar;
                Context themedContext = actionBar != null ? actionBar.getThemedContext() : null;
                if (themedContext != null) {
                    context = themedContext;
                }
                TypedValue typedValue = new TypedValue();
                Resources.Theme themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(context.getTheme());
                themeNewTheme.resolveAttribute(com.yalantis.ucrop.R.attr.actionBarPopupTheme, typedValue, true);
                int i3 = typedValue.resourceId;
                if (i3 != 0) {
                    themeNewTheme.applyStyle(i3, true);
                }
                themeNewTheme.resolveAttribute(com.yalantis.ucrop.R.attr.panelMenuListTheme, typedValue, true);
                int i4 = typedValue.resourceId;
                if (i4 != 0) {
                    themeNewTheme.applyStyle(i4, true);
                } else {
                    themeNewTheme.applyStyle(com.yalantis.ucrop.R.style.Theme_AppCompat_CompactMenu, true);
                }
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(themeNewTheme);
                panelFeatureState.listPresenterContext = contextThemeWrapper;
                TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R$styleable.AppCompatTheme);
                panelFeatureState.background = typedArrayObtainStyledAttributes.getResourceId(86, 0);
                panelFeatureState.windowAnimations = typedArrayObtainStyledAttributes.getResourceId(1, 0);
                typedArrayObtainStyledAttributes.recycle();
                panelFeatureState.decorView = new ListMenuDecorView(panelFeatureState.listPresenterContext);
                panelFeatureState.gravity = (byte) 81;
            } else if (panelFeatureState.refreshDecorView && listMenuDecorView.getChildCount() > 0) {
                panelFeatureState.decorView.removeAllViews();
            }
            View view2 = panelFeatureState.createdPanelView;
            if (view2 == null) {
                if (panelFeatureState.menu != null) {
                    AnonymousClass2 anonymousClass2 = this.mPanelMenuPresenterCallback;
                    if (anonymousClass2 == null) {
                        anonymousClass2 = new AnonymousClass2(this, (byte) 3);
                        this.mPanelMenuPresenterCallback = anonymousClass2;
                    }
                    if (panelFeatureState.listMenuPresenter == null) {
                        ListMenuPresenter listMenuPresenter = new ListMenuPresenter(panelFeatureState.listPresenterContext);
                        panelFeatureState.listMenuPresenter = listMenuPresenter;
                        listMenuPresenter.mCallback = anonymousClass2;
                        MenuBuilder menuBuilder = panelFeatureState.menu;
                        menuBuilder.addMenuPresenter(listMenuPresenter, menuBuilder.mContext);
                    }
                    ListMenuPresenter listMenuPresenter2 = panelFeatureState.listMenuPresenter;
                    ListMenuDecorView listMenuDecorView2 = panelFeatureState.decorView;
                    if (listMenuPresenter2.mMenuView == null) {
                        listMenuPresenter2.mMenuView = (ExpandedMenuView) listMenuPresenter2.mInflater.inflate(com.yalantis.ucrop.R.layout.abc_expanded_menu_layout, (ViewGroup) listMenuDecorView2, false);
                        ListMenuPresenter.MenuAdapter menuAdapter = listMenuPresenter2.mAdapter;
                        if (menuAdapter == null) {
                            menuAdapter = listMenuPresenter2.new MenuAdapter();
                            listMenuPresenter2.mAdapter = menuAdapter;
                        }
                        listMenuPresenter2.mMenuView.setAdapter((ListAdapter) menuAdapter);
                        listMenuPresenter2.mMenuView.setOnItemClickListener(listMenuPresenter2);
                    }
                    ExpandedMenuView expandedMenuView = listMenuPresenter2.mMenuView;
                    panelFeatureState.shownPanelView = expandedMenuView;
                    if (expandedMenuView != null) {
                    }
                }
                panelFeatureState.refreshDecorView = true;
                return;
            }
            panelFeatureState.shownPanelView = view2;
            if (panelFeatureState.shownPanelView != null) {
                if (panelFeatureState.createdPanelView == null) {
                    ListMenuPresenter listMenuPresenter3 = panelFeatureState.listMenuPresenter;
                    ListMenuPresenter.MenuAdapter menuAdapter2 = listMenuPresenter3.mAdapter;
                    if (menuAdapter2 == null) {
                        menuAdapter2 = listMenuPresenter3.new MenuAdapter();
                        listMenuPresenter3.mAdapter = menuAdapter2;
                    }
                }
                ViewGroup.LayoutParams layoutParams3 = panelFeatureState.shownPanelView.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
                }
                panelFeatureState.decorView.setBackgroundResource(panelFeatureState.background);
                ViewParent parent = panelFeatureState.shownPanelView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(panelFeatureState.shownPanelView);
                }
                panelFeatureState.decorView.addView(panelFeatureState.shownPanelView, layoutParams3);
                if (!panelFeatureState.shownPanelView.hasFocus()) {
                    panelFeatureState.shownPanelView.requestFocus();
                }
            }
            panelFeatureState.refreshDecorView = true;
            return;
            i = -2;
            panelFeatureState.isHandled = false;
            WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i, -2, 0, 0, 1002, 8519680, -3);
            layoutParams4.gravity = panelFeatureState.gravity;
            layoutParams4.windowAnimations = panelFeatureState.windowAnimations;
            windowManager.addView(panelFeatureState.decorView, layoutParams4);
            panelFeatureState.isOpen = true;
            if (i2 == 0) {
                updateBackInvokedCallbackState();
            }
        }
    }

    public final boolean performPanelShortcut(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent) {
        MenuBuilder menuBuilder;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.isPrepared || preparePanel(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.menu) != null) {
            return menuBuilder.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:62:0x00d6 A[PHI: r6
      0x00d6: PHI (r6v2 androidx.appcompat.view.menu.MenuBuilder) = (r6v1 androidx.appcompat.view.menu.MenuBuilder), (r6v8 androidx.appcompat.view.menu.MenuBuilder) binds: [B:34:0x0054, B:60:0x00d3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:67:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:71:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:74:0x00fd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:82:0x0112  */
    public final boolean preparePanel(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        MenuBuilder menuBuilder;
        ActionBarOverlayLayout actionBarOverlayLayout;
        ActionBarOverlayLayout actionBarOverlayLayout2;
        AnonymousClass2 anonymousClass2;
        Resources.Theme themeNewTheme;
        ActionBarOverlayLayout actionBarOverlayLayout3;
        ActionBarOverlayLayout actionBarOverlayLayout4;
        if (!this.mDestroyed) {
            boolean z = panelFeatureState.isPrepared;
            int i = panelFeatureState.featureId;
            if (z) {
                return true;
            }
            PanelFeatureState panelFeatureState2 = this.mPreparedPanel;
            if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
                closePanel(panelFeatureState2, false);
            }
            Window.Callback callback = this.mWindow.getCallback();
            if (callback != null) {
                panelFeatureState.createdPanelView = callback.onCreatePanelView(i);
            }
            boolean z2 = i == 0 || i == 108;
            if (z2 && (actionBarOverlayLayout4 = this.mDecorContentParent) != null) {
                actionBarOverlayLayout4.pullChildren();
                ((ToolbarWidgetWrapper) actionBarOverlayLayout4.mDecorToolbar).mMenuPrepared = true;
            }
            if (panelFeatureState.createdPanelView == null && (!z2 || !(this.mActionBar instanceof ToolbarActionBar))) {
                MenuBuilder menuBuilder2 = panelFeatureState.menu;
                if (menuBuilder2 == null || panelFeatureState.refreshMenuContent) {
                    if (menuBuilder2 == null) {
                        Context context = this.mContext;
                        if ((i == 0 || i == 108) && this.mDecorContentParent != null) {
                            TypedValue typedValue = new TypedValue();
                            Resources.Theme theme = context.getTheme();
                            theme.resolveAttribute(com.yalantis.ucrop.R.attr.actionBarTheme, typedValue, true);
                            if (typedValue.resourceId != 0) {
                                themeNewTheme = context.getResources().newTheme();
                                themeNewTheme.setTo(theme);
                                themeNewTheme.applyStyle(typedValue.resourceId, true);
                                themeNewTheme.resolveAttribute(com.yalantis.ucrop.R.attr.actionBarWidgetTheme, typedValue, true);
                            } else {
                                theme.resolveAttribute(com.yalantis.ucrop.R.attr.actionBarWidgetTheme, typedValue, true);
                                themeNewTheme = null;
                            }
                            if (typedValue.resourceId != 0) {
                                if (themeNewTheme == null) {
                                    themeNewTheme = context.getResources().newTheme();
                                    themeNewTheme.setTo(theme);
                                }
                                themeNewTheme.applyStyle(typedValue.resourceId, true);
                            }
                            if (themeNewTheme != null) {
                                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                                contextThemeWrapper.getTheme().setTo(themeNewTheme);
                                context = contextThemeWrapper;
                            }
                        }
                        MenuBuilder menuBuilder3 = new MenuBuilder(context);
                        menuBuilder3.mCallback = this;
                        MenuBuilder menuBuilder4 = panelFeatureState.menu;
                        if (menuBuilder3 != menuBuilder4) {
                            if (menuBuilder4 != null) {
                                menuBuilder4.removeMenuPresenter(panelFeatureState.listMenuPresenter);
                            }
                            panelFeatureState.menu = menuBuilder3;
                            ListMenuPresenter listMenuPresenter = panelFeatureState.listMenuPresenter;
                            if (listMenuPresenter != null) {
                                menuBuilder3.addMenuPresenter(listMenuPresenter, menuBuilder3.mContext);
                            }
                        }
                        menuBuilder2 = panelFeatureState.menu;
                        if (menuBuilder2 != null) {
                            if (z2 && (actionBarOverlayLayout2 = this.mDecorContentParent) != null) {
                                anonymousClass2 = this.mActionMenuPresenterCallback;
                                if (anonymousClass2 == null) {
                                    anonymousClass2 = new AnonymousClass2(this, (byte) 2);
                                    this.mActionMenuPresenterCallback = anonymousClass2;
                                }
                                actionBarOverlayLayout2.setMenu(menuBuilder2, anonymousClass2);
                            }
                            panelFeatureState.menu.stopDispatchingItemsChanged();
                            if (callback.onCreatePanelMenu(i, panelFeatureState.menu)) {
                                panelFeatureState.refreshMenuContent = false;
                            } else {
                                menuBuilder = panelFeatureState.menu;
                                if (menuBuilder != null) {
                                    if (menuBuilder != null) {
                                        menuBuilder.removeMenuPresenter(panelFeatureState.listMenuPresenter);
                                    }
                                    panelFeatureState.menu = null;
                                }
                                if (z2 && (actionBarOverlayLayout = this.mDecorContentParent) != null) {
                                    actionBarOverlayLayout.setMenu(null, this.mActionMenuPresenterCallback);
                                }
                            }
                        }
                    } else {
                        if (z2) {
                            anonymousClass2 = this.mActionMenuPresenterCallback;
                            if (anonymousClass2 == null) {
                                anonymousClass2 = new AnonymousClass2(this, (byte) 2);
                                this.mActionMenuPresenterCallback = anonymousClass2;
                            }
                            actionBarOverlayLayout2.setMenu(menuBuilder2, anonymousClass2);
                        }
                        panelFeatureState.menu.stopDispatchingItemsChanged();
                        if (callback.onCreatePanelMenu(i, panelFeatureState.menu)) {
                            menuBuilder = panelFeatureState.menu;
                            if (menuBuilder != null) {
                                if (menuBuilder != null) {
                                    menuBuilder.removeMenuPresenter(panelFeatureState.listMenuPresenter);
                                }
                                panelFeatureState.menu = null;
                            }
                            if (z2) {
                                actionBarOverlayLayout.setMenu(null, this.mActionMenuPresenterCallback);
                            }
                        } else {
                            panelFeatureState.refreshMenuContent = false;
                        }
                    }
                }
                panelFeatureState.menu.stopDispatchingItemsChanged();
                Bundle bundle = panelFeatureState.frozenActionViewState;
                if (bundle != null) {
                    panelFeatureState.menu.restoreActionViewStates(bundle);
                    panelFeatureState.frozenActionViewState = null;
                }
                if (!callback.onPreparePanel(0, panelFeatureState.createdPanelView, panelFeatureState.menu)) {
                    if (z2 && (actionBarOverlayLayout3 = this.mDecorContentParent) != null) {
                        actionBarOverlayLayout3.setMenu(null, this.mActionMenuPresenterCallback);
                    }
                    panelFeatureState.menu.startDispatchingItemsChanged();
                    return false;
                }
                panelFeatureState.menu.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
                panelFeatureState.menu.startDispatchingItemsChanged();
            }
            panelFeatureState.isPrepared = true;
            panelFeatureState.isHandled = false;
            this.mPreparedPanel = panelFeatureState;
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final boolean requestWindowFeature(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i = 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i = 109;
        }
        if (this.mWindowNoTitle && i == 108) {
            return false;
        }
        if (this.mHasActionBar && i == 1) {
            this.mHasActionBar = false;
        }
        if (i == 1) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mWindowNoTitle = true;
            return true;
        }
        if (i == 2) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureProgress = true;
            return true;
        }
        if (i == 5) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureIndeterminateProgress = true;
            return true;
        }
        if (i == 10) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mOverlayActionMode = true;
            return true;
        }
        if (i == 108) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mHasActionBar = true;
            return true;
        }
        if (i != 109) {
            return this.mWindow.requestFeature(i);
        }
        throwFeatureRequestIfSubDecorInstalled();
        this.mOverlayActionBar = true;
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setContentView(int i) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        ActionBarOverlayLayout actionBarOverlayLayout = this.mDecorContentParent;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setWindowTitle(charSequence);
            return;
        }
        ActionBar actionBar = this.mActionBar;
        if (actionBar != null) {
            actionBar.setWindowTitle(charSequence);
            return;
        }
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final ActionMode startSupportActionMode(ActionMode.Callback callback) {
        ActionMode actionModeOnWindowStartingSupportActionMode;
        ViewGroup viewGroup;
        if (callback == null) {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$1("ActionMode callback can not be null.");
            return null;
        }
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
        WeakCache weakCache = new WeakCache(this, callback);
        initWindowDecorActionBar();
        ActionBar actionBar = this.mActionBar;
        AppCompatCallback appCompatCallback = this.mAppCompatCallback;
        if (actionBar != null) {
            ActionMode actionModeStartActionMode = actionBar.startActionMode(weakCache);
            this.mActionMode = actionModeStartActionMode;
            if (actionModeStartActionMode != null) {
                appCompatCallback.onSupportActionModeStarted(actionModeStartActionMode);
            }
        }
        if (this.mActionMode == null) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mFadeAnim;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.cancel();
            }
            ActionMode actionMode2 = this.mActionMode;
            if (actionMode2 != null) {
                actionMode2.finish();
            }
            if (this.mDestroyed) {
                actionModeOnWindowStartingSupportActionMode = null;
            } else {
                try {
                    actionModeOnWindowStartingSupportActionMode = appCompatCallback.onWindowStartingSupportActionMode(weakCache);
                } catch (AbstractMethodError unused) {
                    actionModeOnWindowStartingSupportActionMode = null;
                }
            }
            if (actionModeOnWindowStartingSupportActionMode != null) {
                this.mActionMode = actionModeOnWindowStartingSupportActionMode;
            } else {
                byte b = 1;
                byte b2 = 0;
                if (this.mActionModeView == null) {
                    boolean z = this.mIsFloating;
                    Context context = this.mContext;
                    if (z) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = context.getTheme();
                        theme.resolveAttribute(com.yalantis.ucrop.R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            Resources.Theme themeNewTheme = context.getResources().newTheme();
                            themeNewTheme.setTo(theme);
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                            contextThemeWrapper.getTheme().setTo(themeNewTheme);
                            context = contextThemeWrapper;
                        }
                        this.mActionModeView = new ActionBarContextView(context);
                        PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, com.yalantis.ucrop.R.attr.actionModePopupWindowStyle);
                        this.mActionModePopup = popupWindow;
                        popupWindow.setWindowLayoutType(2);
                        this.mActionModePopup.setContentView(this.mActionModeView);
                        this.mActionModePopup.setWidth(-1);
                        context.getTheme().resolveAttribute(com.yalantis.ucrop.R.attr.actionBarSize, typedValue, true);
                        this.mActionModeView.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                        this.mActionModePopup.setHeight(-2);
                        this.mShowActionModePopup = new AnonymousClass1(this, b);
                    } else {
                        ViewStubCompat viewStubCompat = (ViewStubCompat) this.mSubDecor.findViewById(com.yalantis.ucrop.R.id.action_mode_bar_stub);
                        if (viewStubCompat != null) {
                            initWindowDecorActionBar();
                            ActionBar actionBar2 = this.mActionBar;
                            Context themedContext = actionBar2 != null ? actionBar2.getThemedContext() : null;
                            if (themedContext != null) {
                                context = themedContext;
                            }
                            viewStubCompat.setLayoutInflater(LayoutInflater.from(context));
                            this.mActionModeView = (ActionBarContextView) viewStubCompat.inflate();
                        }
                    }
                }
                if (this.mActionModeView != null) {
                    ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = this.mFadeAnim;
                    if (viewPropertyAnimatorCompat2 != null) {
                        viewPropertyAnimatorCompat2.cancel();
                    }
                    this.mActionModeView.killMode();
                    Context context2 = this.mActionModeView.getContext();
                    ActionBarContextView actionBarContextView = this.mActionModeView;
                    StandaloneActionMode standaloneActionMode = new StandaloneActionMode();
                    standaloneActionMode.mContext = context2;
                    standaloneActionMode.mContextView = actionBarContextView;
                    standaloneActionMode.mCallback = weakCache;
                    MenuBuilder menuBuilder = new MenuBuilder(actionBarContextView.getContext());
                    menuBuilder.mDefaultShowAsAction = true;
                    standaloneActionMode.mMenu = menuBuilder;
                    menuBuilder.mCallback = standaloneActionMode;
                    if (((ActionMode.Callback) weakCache.values).onCreateActionMode(standaloneActionMode, menuBuilder)) {
                        standaloneActionMode.invalidate();
                        this.mActionModeView.initForMode(standaloneActionMode);
                        this.mActionMode = standaloneActionMode;
                        b = (this.mSubDecorInstalled && (viewGroup = this.mSubDecor) != null && viewGroup.isLaidOut()) ? (byte) 1 : (byte) 0;
                        ActionBarContextView actionBarContextView2 = this.mActionModeView;
                        if (b != 0) {
                            actionBarContextView2.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
                            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAnimate = ViewCompat.animate(this.mActionModeView);
                            viewPropertyAnimatorCompatAnimate.alpha(1.0f);
                            this.mFadeAnim = viewPropertyAnimatorCompatAnimate;
                            viewPropertyAnimatorCompatAnimate.setListener(new AnonymousClass5(b2, this));
                        } else {
                            actionBarContextView2.setAlpha(1.0f);
                            this.mActionModeView.setVisibility(0);
                            if (this.mActionModeView.getParent() instanceof View) {
                                View view = (View) this.mActionModeView.getParent();
                                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                                view.requestApplyInsets();
                            }
                        }
                        if (this.mActionModePopup != null) {
                            this.mWindow.getDecorView().post(this.mShowActionModePopup);
                        }
                    } else {
                        this.mActionMode = null;
                    }
                }
            }
            ActionMode actionMode3 = this.mActionMode;
            if (actionMode3 != null) {
                appCompatCallback.onSupportActionModeStarted(actionMode3);
            }
            updateBackInvokedCallbackState();
            this.mActionMode = this.mActionMode;
        }
        updateBackInvokedCallbackState();
        return this.mActionMode;
    }

    public final void throwFeatureRequestIfSubDecorInstalled() {
        if (this.mSubDecorInstalled) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void updateBackInvokedCallbackState() {
        Api33Impl$$ExternalSyntheticLambda0 api33Impl$$ExternalSyntheticLambda0;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z = false;
            if (this.mDispatcher != null && (getPanelState(0).isOpen || this.mActionMode != null)) {
                z = true;
            }
            if (z && this.mBackCallback == null) {
                this.mBackCallback = BundleCompat$Api33Impl.registerOnBackPressedCallback(this.mDispatcher, this);
            } else {
                if (z || (api33Impl$$ExternalSyntheticLambda0 = this.mBackCallback) == null) {
                    return;
                }
                BundleCompat$Api33Impl.unregisterOnBackInvokedCallback(this.mDispatcher, api33Impl$$ExternalSyntheticLambda0);
                this.mBackCallback = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AppCompatWindowCallback implements Window.Callback {
        public ToolbarActionBar.AnonymousClass2 mActionBarCallback;
        public boolean mDispatchKeyEventBypassEnabled;
        public boolean mOnContentChangedBypassEnabled;
        public boolean mOnPanelClosedBypassEnabled;
        public final Window.Callback mWrapped;

        public AppCompatWindowCallback(Window.Callback callback) {
            if (callback != null) {
                this.mWrapped = callback;
            } else {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$1("Window callback may not be null");
                throw null;
            }
        }

        public final void bypassOnContentChanged(Window.Callback callback) {
            try {
                this.mOnContentChangedBypassEnabled = true;
                callback.onContentChanged();
            } finally {
                this.mOnContentChangedBypassEnabled = false;
            }
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
            return this.mWrapped.dispatchGenericMotionEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            boolean z = this.mDispatchKeyEventBypassEnabled;
            Window.Callback callback = this.mWrapped;
            if (z) {
                return callback.dispatchKeyEvent(keyEvent);
            }
            return AppCompatDelegateImpl.this.dispatchKeyEvent(keyEvent) || callback.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            if (!this.mWrapped.dispatchKeyShortcutEvent(keyEvent)) {
                int keyCode = keyEvent.getKeyCode();
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.initWindowDecorActionBar();
                ActionBar actionBar = appCompatDelegateImpl.mActionBar;
                if (actionBar == null || !actionBar.onKeyShortcut(keyCode, keyEvent)) {
                    PanelFeatureState panelFeatureState = appCompatDelegateImpl.mPreparedPanel;
                    if (panelFeatureState == null || !appCompatDelegateImpl.performPanelShortcut(panelFeatureState, keyEvent.getKeyCode(), keyEvent)) {
                        if (appCompatDelegateImpl.mPreparedPanel == null) {
                            PanelFeatureState panelState = appCompatDelegateImpl.getPanelState(0);
                            appCompatDelegateImpl.preparePanel(panelState, keyEvent);
                            boolean zPerformPanelShortcut = appCompatDelegateImpl.performPanelShortcut(panelState, keyEvent.getKeyCode(), keyEvent);
                            panelState.isPrepared = false;
                            if (zPerformPanelShortcut) {
                            }
                        }
                        return false;
                    }
                    PanelFeatureState panelFeatureState2 = appCompatDelegateImpl.mPreparedPanel;
                    if (panelFeatureState2 != null) {
                        panelFeatureState2.isHandled = true;
                        return true;
                    }
                }
            }
            return true;
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            return this.mWrapped.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return this.mWrapped.dispatchTouchEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
            return this.mWrapped.dispatchTrackballEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeFinished(android.view.ActionMode actionMode) {
            this.mWrapped.onActionModeFinished(actionMode);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeStarted(android.view.ActionMode actionMode) {
            this.mWrapped.onActionModeStarted(actionMode);
        }

        @Override // android.view.Window.Callback
        public final void onAttachedToWindow() {
            this.mWrapped.onAttachedToWindow();
        }

        @Override // android.view.Window.Callback
        public final void onContentChanged() {
            if (this.mOnContentChangedBypassEnabled) {
                this.mWrapped.onContentChanged();
            }
        }

        @Override // android.view.Window.Callback
        public final boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return this.mWrapped.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // android.view.Window.Callback
        public final View onCreatePanelView(int i) {
            ToolbarActionBar.AnonymousClass2 anonymousClass2 = this.mActionBarCallback;
            if (anonymousClass2 != null) {
                View view = i == 0 ? new View(ToolbarActionBar.this.mDecorToolbar.mToolbar.getContext()) : null;
                if (view != null) {
                    return view;
                }
            }
            return this.mWrapped.onCreatePanelView(i);
        }

        @Override // android.view.Window.Callback
        public final void onDetachedFromWindow() {
            this.mWrapped.onDetachedFromWindow();
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
            return this.mWrapped.onMenuItemSelected(i, menuItem);
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuOpened(int i, Menu menu) {
            onMenuOpened$androidx$appcompat$view$WindowCallbackWrapper(i, menu);
            if (i == 108) {
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.initWindowDecorActionBar();
                ActionBar actionBar = appCompatDelegateImpl.mActionBar;
                if (actionBar != null) {
                    actionBar.dispatchMenuVisibilityChanged(true);
                }
            }
            return true;
        }

        public final boolean onMenuOpened$androidx$appcompat$view$WindowCallbackWrapper(int i, Menu menu) {
            return this.mWrapped.onMenuOpened(i, menu);
        }

        @Override // android.view.Window.Callback
        public final void onPanelClosed(int i, Menu menu) {
            if (this.mOnPanelClosedBypassEnabled) {
                this.mWrapped.onPanelClosed(i, menu);
                return;
            }
            onPanelClosed$androidx$appcompat$view$WindowCallbackWrapper(i, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (i == 108) {
                appCompatDelegateImpl.initWindowDecorActionBar();
                ActionBar actionBar = appCompatDelegateImpl.mActionBar;
                if (actionBar != null) {
                    actionBar.dispatchMenuVisibilityChanged(false);
                    return;
                }
                return;
            }
            if (i == 0) {
                PanelFeatureState panelState = appCompatDelegateImpl.getPanelState(i);
                if (panelState.isOpen) {
                    appCompatDelegateImpl.closePanel(panelState, false);
                }
            }
        }

        public final void onPanelClosed$androidx$appcompat$view$WindowCallbackWrapper(int i, Menu menu) {
            this.mWrapped.onPanelClosed(i, menu);
        }

        @Override // android.view.Window.Callback
        public final void onPointerCaptureChanged(boolean z) {
            this.mWrapped.onPointerCaptureChanged(z);
        }

        @Override // android.view.Window.Callback
        public final boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.mOverrideVisibleItems = true;
            }
            ToolbarActionBar.AnonymousClass2 anonymousClass2 = this.mActionBarCallback;
            if (anonymousClass2 != null && i == 0) {
                ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
                if (!toolbarActionBar.mToolbarMenuPrepared) {
                    toolbarActionBar.mDecorToolbar.mMenuPrepared = true;
                    toolbarActionBar.mToolbarMenuPrepared = true;
                }
            }
            boolean zOnPreparePanel = this.mWrapped.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.mOverrideVisibleItems = false;
            }
            return zOnPreparePanel;
        }

        @Override // android.view.Window.Callback
        public final void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
            MenuBuilder menuBuilder = AppCompatDelegateImpl.this.getPanelState(0).menu;
            if (menuBuilder != null) {
                onProvideKeyboardShortcuts$androidx$appcompat$view$WindowCallbackWrapper(list, menuBuilder, i);
            } else {
                onProvideKeyboardShortcuts$androidx$appcompat$view$WindowCallbackWrapper(list, menu, i);
            }
        }

        public final void onProvideKeyboardShortcuts$androidx$appcompat$view$WindowCallbackWrapper(List list, Menu menu, int i) {
            this.mWrapped.onProvideKeyboardShortcuts(list, menu, i);
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested(SearchEvent searchEvent) {
            return this.mWrapped.onSearchRequested(searchEvent);
        }

        @Override // android.view.Window.Callback
        public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
            this.mWrapped.onWindowAttributesChanged(layoutParams);
        }

        @Override // android.view.Window.Callback
        public final void onWindowFocusChanged(boolean z) {
            this.mWrapped.onWindowFocusChanged(z);
        }

        @Override // android.view.Window.Callback
        public final android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int i) {
            if (i != 0) {
                return this.mWrapped.onWindowStartingActionMode(callback, i);
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            Dispatcher dispatcher = new Dispatcher(appCompatDelegateImpl.mContext, callback);
            ActionMode actionModeStartSupportActionMode = appCompatDelegateImpl.startSupportActionMode(dispatcher);
            if (actionModeStartSupportActionMode != null) {
                return dispatcher.getActionModeWrapper(actionModeStartSupportActionMode);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested() {
            return this.mWrapped.onSearchRequested();
        }

        @Override // android.view.Window.Callback
        public final android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AutoTimeNightModeManager extends BaseMenuWrapper {
        public final /* synthetic */ byte $r8$classId = 1;
        public final Object mTwilightManager;

        public AutoTimeNightModeManager(Context context) {
            super(AppCompatDelegateImpl.this);
            this.mTwilightManager = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.view.menu.BaseMenuWrapper
        public final IntentFilter createIntentFilterForBroadcastReceiver() {
            switch (this.$r8$classId) {
                case 0:
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.TIME_SET");
                    intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
                    intentFilter.addAction("android.intent.action.TIME_TICK");
                    return intentFilter;
                default:
                    IntentFilter intentFilter2 = new IntentFilter();
                    intentFilter2.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                    return intentFilter2;
            }
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0047  */
        @Override // androidx.appcompat.view.menu.BaseMenuWrapper
        public final int getApplyableNightMode() {
            Location lastKnownLocation;
            boolean z;
            long j;
            byte b = this.$r8$classId;
            Object obj = this.mTwilightManager;
            switch (b) {
                case 0:
                    EmojiProcessor emojiProcessor = (EmojiProcessor) obj;
                    LocationManager locationManager = (LocationManager) emojiProcessor.mMetadataRepo;
                    TwilightManager$TwilightState twilightManager$TwilightState = (TwilightManager$TwilightState) emojiProcessor.mGlyphChecker;
                    if (twilightManager$TwilightState.nextUpdate > System.currentTimeMillis()) {
                        z = twilightManager$TwilightState.isNight;
                    } else {
                        Context context = (Context) emojiProcessor.mSpanFactory;
                        Location lastKnownLocation2 = null;
                        if (DatabaseDao_Impl.AnonymousClass17.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                            try {
                                if (locationManager.isProviderEnabled("network")) {
                                    lastKnownLocation = locationManager.getLastKnownLocation("network");
                                } else {
                                    lastKnownLocation = null;
                                }
                                break;
                            } catch (Exception unused) {
                            }
                        } else {
                            lastKnownLocation = null;
                        }
                        if (DatabaseDao_Impl.AnonymousClass17.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                            try {
                                if (locationManager.isProviderEnabled("gps")) {
                                    lastKnownLocation2 = locationManager.getLastKnownLocation("gps");
                                }
                                break;
                            } catch (Exception unused2) {
                            }
                        }
                        if (lastKnownLocation2 == null || lastKnownLocation == null ? lastKnownLocation2 != null : lastKnownLocation2.getTime() > lastKnownLocation.getTime()) {
                            lastKnownLocation = lastKnownLocation2;
                        }
                        z = false;
                        if (lastKnownLocation != null) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            TwilightCalculator twilightCalculator = TwilightCalculator.sInstance;
                            if (twilightCalculator == null) {
                                twilightCalculator = new TwilightCalculator();
                                TwilightCalculator.sInstance = twilightCalculator;
                            }
                            TwilightCalculator twilightCalculator2 = twilightCalculator;
                            twilightCalculator2.calculateTwilight(jCurrentTimeMillis - 86400000, lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
                            twilightCalculator2.calculateTwilight(jCurrentTimeMillis, lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
                            z = twilightCalculator2.state;
                            long j2 = twilightCalculator2.sunrise;
                            long j3 = twilightCalculator2.sunset;
                            twilightCalculator2.calculateTwilight(jCurrentTimeMillis + 86400000, lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
                            long j4 = twilightCalculator2.sunrise;
                            if (j2 == -1 || j3 == -1) {
                                j = jCurrentTimeMillis + 43200000;
                            } else {
                                if (jCurrentTimeMillis <= j3) {
                                    j4 = jCurrentTimeMillis > j2 ? j3 : j2;
                                }
                                j = j4 + 60000;
                            }
                            twilightManager$TwilightState.isNight = z;
                            twilightManager$TwilightState.nextUpdate = j;
                        } else {
                            Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                            int i = Calendar.getInstance().get(11);
                            if (i < 6 || i >= 22) {
                                z = true;
                            }
                        }
                    }
                    return z ? 2 : 1;
                default:
                    return ((PowerManager) obj).isPowerSaveMode() ? 2 : 1;
            }
        }

        @Override // androidx.appcompat.view.menu.BaseMenuWrapper
        public final void onChange() {
            byte b = this.$r8$classId;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            switch (b) {
                case 0:
                    appCompatDelegateImpl.applyApplicationSpecificConfig(true, true);
                    break;
                default:
                    appCompatDelegateImpl.applyApplicationSpecificConfig(true, true);
                    break;
            }
        }

        public AutoTimeNightModeManager(EmojiProcessor emojiProcessor) {
            super(AppCompatDelegateImpl.this);
            this.mTwilightManager = emojiProcessor;
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setContentView(View view) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
