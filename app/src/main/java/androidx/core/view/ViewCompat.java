package androidx.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.compose.ui.scrollcapture.ScrollCapture;
import androidx.core.widget.TextViewOnReceiveContentListener;
import com.yalantis.ucrop.R;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ViewCompat {
    public static boolean sAccessibilityDelegateCheckFailed = false;
    public static Field sAccessibilityDelegateField;
    public static final AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager = new AccessibilityPaneVisibilityManager();
    public static WeakHashMap sViewPropertyAnimatorMap;

    /* JADX INFO: renamed from: androidx.core.view.ViewCompat$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 {
        public final /* synthetic */ byte $r8$classId;
        public final byte mContentChangeType;
        public final byte mFrameworkMinimumSdk;
        public final int mTagKey;
        public final Class mType;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(int i, Class cls, int i2, int i3, byte b) {
            this.$r8$classId = b;
            this.mTagKey = i;
            this.mType = cls;
            this.mContentChangeType = i2;
            this.mFrameworkMinimumSdk = i3;
        }

        /* JADX WARN: Code duplicated, block: B:33:0x0076  */
        public final void set(View view, Object obj) {
            Object tag;
            boolean z;
            int i = Build.VERSION.SDK_INT;
            byte b = this.$r8$classId;
            byte b2 = this.mFrameworkMinimumSdk;
            if (i >= b2) {
                switch (b) {
                    case 0:
                        Api28Impl.setScreenReaderFocusable(view, ((Boolean) obj).booleanValue());
                        break;
                    case 1:
                        Api28Impl.setAccessibilityPaneTitle(view, (CharSequence) obj);
                        break;
                    default:
                        Api28Impl.setAccessibilityHeading(view, ((Boolean) obj).booleanValue());
                        break;
                }
                return;
            }
            int i2 = Build.VERSION.SDK_INT;
            AccessibilityDelegateCompat accessibilityDelegateCompat = null;
            int i3 = this.mTagKey;
            if (i2 >= b2) {
                switch (b) {
                    case 0:
                        tag = Boolean.valueOf(Api28Impl.isScreenReaderFocusable(view));
                        break;
                    case 1:
                        tag = Api28Impl.getAccessibilityPaneTitle(view);
                        break;
                    default:
                        tag = Boolean.valueOf(Api28Impl.isAccessibilityHeading(view));
                        break;
                }
            } else {
                tag = view.getTag(i3);
                if (!this.mType.isInstance(tag)) {
                    tag = null;
                }
            }
            boolean z2 = false;
            switch (b) {
                case 0:
                    Boolean bool = (Boolean) tag;
                    Boolean bool2 = (Boolean) obj;
                    if ((bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue())) {
                        z2 = true;
                    }
                    z = !z2;
                    break;
                case 1:
                    z = !TextUtils.equals((CharSequence) tag, (CharSequence) obj);
                    break;
                default:
                    Boolean bool3 = (Boolean) tag;
                    Boolean bool4 = (Boolean) obj;
                    if ((bool3 != null && bool3.booleanValue()) == (bool4 != null && bool4.booleanValue())) {
                        z2 = true;
                    }
                    z = !z2;
                    break;
            }
            if (z) {
                View.AccessibilityDelegate accessibilityDelegateInternal = ViewCompat.getAccessibilityDelegateInternal(view);
                if (accessibilityDelegateInternal != null) {
                    accessibilityDelegateCompat = accessibilityDelegateInternal instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter ? ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) accessibilityDelegateInternal).mCompat : new AccessibilityDelegateCompat(accessibilityDelegateInternal);
                }
                if (accessibilityDelegateCompat == null) {
                    accessibilityDelegateCompat = new AccessibilityDelegateCompat();
                }
                ViewCompat.setAccessibilityDelegate(view, accessibilityDelegateCompat);
                view.setTag(i3, obj);
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, this.mContentChangeType);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Api20Impl {
        public static WindowInsets dispatchApplyWindowInsets(View view, WindowInsets windowInsets) {
            int i = ViewGroupCompat.$r8$clinit;
            return view.dispatchApplyWindowInsets(windowInsets);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Api21Impl {
        public static void callCompatInsetAnimationCallback(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static WindowInsetsCompat computeSystemWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                return WindowInsetsCompat.toWindowInsetsCompat(view.computeSystemWindowInsets(windowInsets, rect), view);
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }

        public static void setOnApplyWindowInsetsListener(final View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener2 = onApplyWindowInsetsListener != null ? new View.OnApplyWindowInsetsListener() { // from class: androidx.core.view.ViewCompat.Api21Impl.1
                public WindowInsetsCompat mLastInsets = null;

                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                    WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view2);
                    int i = Build.VERSION.SDK_INT;
                    OnApplyWindowInsetsListener onApplyWindowInsetsListener3 = onApplyWindowInsetsListener;
                    if (i < 30) {
                        Api21Impl.callCompatInsetAnimationCallback(windowInsets, view);
                        if (windowInsetsCompat.equals(this.mLastInsets)) {
                            return onApplyWindowInsetsListener3.onApplyWindowInsets(view2, windowInsetsCompat).toWindowInsets();
                        }
                    }
                    this.mLastInsets = windowInsetsCompat;
                    WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets = onApplyWindowInsetsListener3.onApplyWindowInsets(view2, windowInsetsCompat);
                    if (i >= 30) {
                        return windowInsetsCompatOnApplyWindowInsets.toWindowInsets();
                    }
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    view2.requestApplyInsets();
                    return windowInsetsCompatOnApplyWindowInsets.toWindowInsets();
                }
            } : null;
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R.id.tag_on_apply_window_listener, onApplyWindowInsetsListener2);
            }
            if (view.getTag(R.id.tag_compat_insets_dispatch) != null) {
                return;
            }
            if (onApplyWindowInsetsListener2 != null) {
                view.setOnApplyWindowInsetsListener(onApplyWindowInsetsListener2);
            } else {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Api23Impl {
        public static WindowInsetsCompat getRootWindowInsets(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets, null);
            WindowInsetsCompat.Impl impl = windowInsetsCompat.mImpl;
            impl.setRootWindowInsets(windowInsetsCompat);
            View rootView = view.getRootView();
            impl.copyRootViewBounds(rootView);
            impl.initDisplayShape(rootView);
            impl.initTypeBoundingRectsMaps();
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Api28Impl {
        public static CharSequence getAccessibilityPaneTitle(View view) {
            return view.getAccessibilityPaneTitle();
        }

        public static boolean isAccessibilityHeading(View view) {
            return view.isAccessibilityHeading();
        }

        public static boolean isScreenReaderFocusable(View view) {
            return view.isScreenReaderFocusable();
        }

        public static void setAccessibilityHeading(View view, boolean z) {
            view.setAccessibilityHeading(z);
        }

        public static void setAccessibilityPaneTitle(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void setScreenReaderFocusable(View view, boolean z) {
            view.setScreenReaderFocusable(z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Api29Impl {
        public static View.AccessibilityDelegate getAccessibilityDelegate(View view) {
            return view.getAccessibilityDelegate();
        }

        public static void saveAttributeDataForStyleable(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Api30Impl {
        public static WindowInsets dispatchApplyWindowInsets(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static CharSequence getStateDescription(View view) {
            return view.getStateDescription();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public abstract class Api31Impl {
        public static String[] getReceiveContentMimeTypes(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static ContentInfoCompat performReceiveContent(View view, ContentInfoCompat contentInfoCompat) {
            ContentInfo wrapped = contentInfoCompat.mCompat.getWrapped();
            Objects.requireNonNull(wrapped);
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(wrapped);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == wrapped ? contentInfoCompat : new ContentInfoCompat(new ScrollCapture(contentInfoPerformReceiveContent));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class UnhandledKeyEventManager {
        public static final ArrayList sViewsWithListeners = new ArrayList();
        public SparseArray mCapturedKeys;
        public WeakReference mLastDispatchedPreViewKeyEvent;
        public WeakHashMap mViewsContainingListeners;

        public final View dispatchInOrder(View view) {
            int size;
            WeakHashMap weakHashMap = this.mViewsContainingListeners;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewDispatchInOrder = dispatchInOrder(viewGroup.getChildAt(childCount));
                        if (viewDispatchInOrder != null) {
                            return viewDispatchInOrder;
                        }
                    }
                }
                ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
                if (arrayList != null && (size = arrayList.size() - 1) >= 0) {
                    arrayList.get(size).getClass();
                    PathKt$$ExternalSyntheticBUOutline0.m();
                }
            }
            return null;
        }
    }

    public static ViewPropertyAnimatorCompat animate(View view) {
        WeakHashMap weakHashMap = sViewPropertyAnimatorMap;
        if (weakHashMap == null) {
            weakHashMap = new WeakHashMap();
            sViewPropertyAnimatorMap = weakHashMap;
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) weakHashMap.get(view);
        if (viewPropertyAnimatorCompat != null) {
            return viewPropertyAnimatorCompat;
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
        sViewPropertyAnimatorMap.put(view, viewPropertyAnimatorCompat2);
        return viewPropertyAnimatorCompat2;
    }

    public static void dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            WindowInsets windowInsetsDispatchApplyWindowInsets = Build.VERSION.SDK_INT >= 30 ? Api30Impl.dispatchApplyWindowInsets(view, windowInsets) : Api20Impl.dispatchApplyWindowInsets(view, windowInsets);
            if (windowInsetsDispatchApplyWindowInsets.equals(windowInsets)) {
                return;
            }
            WindowInsetsCompat.toWindowInsetsCompat(windowInsetsDispatchApplyWindowInsets, view);
        }
    }

    public static boolean dispatchUnhandledKeyEventBeforeCallback(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = UnhandledKeyEventManager.sViewsWithListeners;
        UnhandledKeyEventManager unhandledKeyEventManager = (UnhandledKeyEventManager) view.getTag(R.id.tag_unhandled_key_event_manager);
        if (unhandledKeyEventManager == null) {
            unhandledKeyEventManager = new UnhandledKeyEventManager();
            unhandledKeyEventManager.mViewsContainingListeners = null;
            unhandledKeyEventManager.mCapturedKeys = null;
            unhandledKeyEventManager.mLastDispatchedPreViewKeyEvent = null;
            view.setTag(R.id.tag_unhandled_key_event_manager, unhandledKeyEventManager);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = unhandledKeyEventManager.mViewsContainingListeners;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = UnhandledKeyEventManager.sViewsWithListeners;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    try {
                        if (unhandledKeyEventManager.mViewsContainingListeners == null) {
                            unhandledKeyEventManager.mViewsContainingListeners = new WeakHashMap();
                        }
                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                            ArrayList arrayList3 = UnhandledKeyEventManager.sViewsWithListeners;
                            View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                            if (view2 == null) {
                                arrayList3.remove(size);
                            } else {
                                unhandledKeyEventManager.mViewsContainingListeners.put(view2, Boolean.TRUE);
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    unhandledKeyEventManager.mViewsContainingListeners.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
        View viewDispatchInOrder = unhandledKeyEventManager.dispatchInOrder(view);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (viewDispatchInOrder != null && !KeyEvent.isModifierKey(keyCode)) {
                SparseArray sparseArray = unhandledKeyEventManager.mCapturedKeys;
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    unhandledKeyEventManager.mCapturedKeys = sparseArray;
                }
                sparseArray.put(keyCode, new WeakReference(viewDispatchInOrder));
            }
        }
        return viewDispatchInOrder != null;
    }

    public static boolean dispatchUnhandledKeyEventBeforeHierarchy(View view, KeyEvent keyEvent) {
        ArrayList arrayList;
        int size;
        int iIndexOfKey;
        if (Build.VERSION.SDK_INT < 28) {
            ArrayList arrayList2 = UnhandledKeyEventManager.sViewsWithListeners;
            UnhandledKeyEventManager unhandledKeyEventManager = (UnhandledKeyEventManager) view.getTag(R.id.tag_unhandled_key_event_manager);
            WeakReference weakReference = null;
            if (unhandledKeyEventManager == null) {
                unhandledKeyEventManager = new UnhandledKeyEventManager();
                unhandledKeyEventManager.mViewsContainingListeners = null;
                unhandledKeyEventManager.mCapturedKeys = null;
                unhandledKeyEventManager.mLastDispatchedPreViewKeyEvent = null;
                view.setTag(R.id.tag_unhandled_key_event_manager, unhandledKeyEventManager);
            }
            WeakReference weakReference2 = unhandledKeyEventManager.mLastDispatchedPreViewKeyEvent;
            if (weakReference2 == null || weakReference2.get() != keyEvent) {
                unhandledKeyEventManager.mLastDispatchedPreViewKeyEvent = new WeakReference(keyEvent);
                SparseArray sparseArray = unhandledKeyEventManager.mCapturedKeys;
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    unhandledKeyEventManager.mCapturedKeys = sparseArray;
                }
                if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                    weakReference = (WeakReference) sparseArray.valueAt(iIndexOfKey);
                    sparseArray.removeAt(iIndexOfKey);
                }
                if (weakReference == null) {
                    weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
                }
                if (weakReference != null) {
                    View view2 = (View) weakReference.get();
                    if (view2 == null || !view2.isAttachedToWindow() || (arrayList = (ArrayList) view2.getTag(R.id.tag_unhandled_key_listeners)) == null || (size = arrayList.size() - 1) < 0) {
                        return true;
                    }
                    arrayList.get(size).getClass();
                    PathKt$$ExternalSyntheticBUOutline0.m();
                    return false;
                }
            }
        }
        return false;
    }

    public static View.AccessibilityDelegate getAccessibilityDelegateInternal(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.getAccessibilityDelegate(view);
        }
        if (sAccessibilityDelegateCheckFailed) {
            return null;
        }
        if (sAccessibilityDelegateField == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                sAccessibilityDelegateField = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                sAccessibilityDelegateCheckFailed = true;
                return null;
            }
        }
        try {
            Object obj = sAccessibilityDelegateField.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            sAccessibilityDelegateCheckFailed = true;
            return null;
        }
    }

    public static String[] getOnReceiveContentMimeTypes(AppCompatEditText appCompatEditText) {
        return Build.VERSION.SDK_INT >= 31 ? Api31Impl.getReceiveContentMimeTypes(appCompatEditText) : (String[]) appCompatEditText.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static void notifyViewAccessibilityStateChangedIfNeeded(View view, int i) {
        Object tag;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            int i2 = Build.VERSION.SDK_INT;
            Object accessibilityPaneTitle = null;
            if (i2 >= 28) {
                tag = Api28Impl.getAccessibilityPaneTitle(view);
            } else {
                tag = view.getTag(R.id.tag_accessibility_pane_title);
                if (!CharSequence.class.isInstance(tag)) {
                    tag = null;
                }
            }
            boolean z = ((CharSequence) tag) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i);
                if (z) {
                    List<CharSequence> text = accessibilityEventObtain.getText();
                    if (i2 >= 28) {
                        accessibilityPaneTitle = Api28Impl.getAccessibilityPaneTitle(view);
                    } else {
                        Object tag2 = view.getTag(R.id.tag_accessibility_pane_title);
                        if (CharSequence.class.isInstance(tag2)) {
                            accessibilityPaneTitle = tag2;
                        }
                    }
                    text.add((CharSequence) accessibilityPaneTitle);
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                        return;
                    } catch (AbstractMethodError e) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            List<CharSequence> text2 = accessibilityEventObtain2.getText();
            if (i2 >= 28) {
                accessibilityPaneTitle = Api28Impl.getAccessibilityPaneTitle(view);
            } else {
                Object tag3 = view.getTag(R.id.tag_accessibility_pane_title);
                if (CharSequence.class.isInstance(tag3)) {
                    accessibilityPaneTitle = tag3;
                }
            }
            text2.add((CharSequence) accessibilityPaneTitle);
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    public static ContentInfoCompat performReceiveContent(AppCompatEditText appCompatEditText, ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Objects.toString(contentInfoCompat);
            appCompatEditText.getId();
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.performReceiveContent(appCompatEditText, contentInfoCompat);
        }
        if (((TextViewOnReceiveContentListener) appCompatEditText.getTag(R.id.tag_on_receive_content_listener)) == null) {
            return appCompatEditText.onReceiveContent(contentInfoCompat);
        }
        ContentInfoCompat contentInfoCompatOnReceiveContent = TextViewOnReceiveContentListener.onReceiveContent(appCompatEditText, contentInfoCompat);
        if (contentInfoCompatOnReceiveContent == null) {
            return null;
        }
        return appCompatEditText.onReceiveContent(contentInfoCompatOnReceiveContent);
    }

    public static void saveAttributeDataForStyleable(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.saveAttributeDataForStyleable(view, context, iArr, attributeSet, typedArray, i, 0);
        }
    }

    public static void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        if (accessibilityDelegateCompat == null && (getAccessibilityDelegateInternal(view) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter)) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.mBridge);
    }

    public static void setAccessibilityPaneTitle(View view, CharSequence charSequence) {
        new AnonymousClass1(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28, (byte) 1).set(view, charSequence);
        AccessibilityPaneVisibilityManager accessibilityPaneVisibilityManager = sAccessibilityPaneVisibilityManager;
        if (charSequence == null) {
            accessibilityPaneVisibilityManager.mPanesToVisible.remove(view);
            view.removeOnAttachStateChangeListener(accessibilityPaneVisibilityManager);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(accessibilityPaneVisibilityManager);
        } else {
            accessibilityPaneVisibilityManager.mPanesToVisible.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(accessibilityPaneVisibilityManager);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(accessibilityPaneVisibilityManager);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        public final WeakHashMap mPanesToVisible = new WeakHashMap();

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry entry : this.mPanesToVisible.entrySet()) {
                    View view = (View) entry.getKey();
                    boolean zBooleanValue = ((Boolean) entry.getValue()).booleanValue();
                    boolean z = view.isShown() && view.getWindowVisibility() == 0;
                    if (zBooleanValue != z) {
                        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, z ? 16 : 32);
                        entry.setValue(Boolean.valueOf(z));
                    }
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }
}
