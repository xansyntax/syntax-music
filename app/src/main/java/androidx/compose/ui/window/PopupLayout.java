package androidx.compose.ui.window;

import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import androidx.activity.OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.graphics.layer.ViewLayer;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda6;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.ViewModelKt;
import androidx.room.RoomDatabase$$ExternalSyntheticLambda0;
import coil3.util.UtilsKt;
import com.metrolist.music.MainActivity$$ExternalSyntheticLambda0;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class PopupLayout extends AbstractComposeView {
    public static final SaversKt$$ExternalSyntheticLambda6 onCommitAffectingPopupPosition = new SaversKt$$ExternalSyntheticLambda6((byte) 28);
    public Api33Impl$$ExternalSyntheticLambda0 backCallback;
    public final DerivedSnapshotState canCalculatePosition$delegate;
    public final View composeView;
    public final ParcelableSnapshotMutableState content$delegate;
    public final boolean isNested;
    public final int[] locationOnScreen;
    public Function0 onDismissRequest;
    public final WindowManager.LayoutParams params;
    public IntRect parentBounds;
    public final ParcelableSnapshotMutableState parentLayoutCoordinates$delegate;
    public LayoutDirection parentLayoutDirection;
    public final ParcelableSnapshotMutableState popupContentSize$delegate;
    public final PopupLayoutHelperImpl popupLayoutHelper;
    public PopupPositionProvider positionProvider;
    public final Rect previousWindowVisibleFrame;
    public PopupProperties properties;
    public boolean shouldCreateCompositionOnAttachedToWindow;
    public final SnapshotStateObserver snapshotStateObserver;
    public String testTag;
    public final WindowManager windowManager;

    /* JADX INFO: renamed from: androidx.compose.ui.window.PopupLayout$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass2 extends ViewOutlineProvider {
        public final /* synthetic */ byte $r8$classId;

        public /* synthetic */ AnonymousClass2(byte b) {
            this.$r8$classId = b;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View view, Outline outline) {
            ViewLayer viewLayer;
            Outline outline2;
            switch (this.$r8$classId) {
                case 0:
                    outline.setRect(0, 0, view.getWidth(), view.getHeight());
                    outline.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
                    return;
                case 1:
                    outline.setRect(0, 0, view.getWidth(), view.getHeight());
                    outline.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
                    return;
                case 2:
                    if (!(view instanceof ViewLayer) || (outline2 = (viewLayer = (ViewLayer) view).layerOutline) == null) {
                        return;
                    }
                    outline.set(outline2);
                    float f = viewLayer.outsetLeft;
                    if (f == CropImageView.DEFAULT_ASPECT_RATIO && viewLayer.outsetTop == CropImageView.DEFAULT_ASPECT_RATIO) {
                        return;
                    }
                    outline.offset((int) f, (int) viewLayer.outsetTop);
                    return;
                case 3:
                    view.getClass();
                    throw new ClassCastException();
                default:
                    outline.setRect(0, 0, view.getWidth(), view.getHeight());
                    outline.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
                    return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code duplicated, block: B:41:0x00d2  */
    public PopupLayout(Function0 function0, PopupProperties popupProperties, String str, View view, Density density, PopupPositionProvider popupPositionProvider, UUID uuid, boolean z) {
        IBinder iBinder;
        super(view.getContext());
        int i = Build.VERSION.SDK_INT;
        PopupLayoutHelperImpl popupLayoutHelperImpl30 = i >= 30 ? new PopupLayoutHelperImpl30() : i >= 29 ? new PopupLayoutHelperImpl29() : new PopupLayoutHelperImpl();
        this.onDismissRequest = function0;
        this.properties = popupProperties;
        this.testTag = str;
        this.composeView = view;
        this.isNested = z;
        this.popupLayoutHelper = popupLayoutHelperImpl30;
        Object systemService = view.getContext().getSystemService("window");
        systemService.getClass();
        this.windowManager = (WindowManager) systemService;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 8388659;
        PopupProperties popupProperties2 = this.properties;
        boolean zIsFlagSecureEnabled = AndroidPopup_androidKt.isFlagSecureEnabled(view);
        boolean z2 = popupProperties2.inheritSecurePolicy;
        int i2 = popupProperties2.flags;
        if (z2 && zIsFlagSecureEnabled) {
            i2 |= 8192;
        } else if (z2 && !zIsFlagSecureEnabled) {
            i2 &= -8193;
        }
        layoutParams.flags = i2;
        if (i >= 31 && !Float.isNaN(this.properties.blurBehindRadius)) {
            PopupApi31Impl.INSTANCE.setBlurBehindRadius(layoutParams, density.mo75roundToPx0680j_4(this.properties.blurBehindRadius));
        }
        if (!Float.isNaN(this.properties.scrimAlpha)) {
            float f = this.properties.scrimAlpha;
            int i3 = layoutParams.flags;
            if (f > CropImageView.DEFAULT_ASPECT_RATIO) {
                layoutParams.flags = i3 | 2;
                layoutParams.dimAmount = f;
            } else {
                layoutParams.flags = i3 & (-3);
                layoutParams.dimAmount = CropImageView.DEFAULT_ASPECT_RATIO;
            }
        }
        PopupProperties popupProperties3 = this.properties;
        layoutParams.type = popupProperties3.windowType;
        IBinder iBinder2 = popupProperties3.windowToken;
        ViewGroup.LayoutParams layoutParams2 = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams3 = layoutParams2 instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams2 : null;
        IBinder applicationWindowToken = view.getApplicationWindowToken();
        if (layoutParams3 == null) {
            iBinder = null;
        } else {
            int i4 = layoutParams3.type;
            layoutParams3 = (1000 > i4 || i4 >= 2000) ? null : layoutParams3;
            if (layoutParams3 != null) {
                iBinder = layoutParams3.token;
            } else {
                iBinder = null;
            }
        }
        layoutParams.token = iBinder2 == null ? iBinder == null ? applicationWindowToken : iBinder : iBinder2;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.setTitle(view.getContext().getResources().getString(R.string.default_popup_window_title));
        this.params = layoutParams;
        this.positionProvider = popupPositionProvider;
        this.parentLayoutDirection = LayoutDirection.Ltr;
        this.popupContentSize$delegate = Stack.mutableStateOf$default(null);
        this.parentLayoutCoordinates$delegate = Stack.mutableStateOf$default(null);
        this.canCalculatePosition$delegate = SnapshotStateKt__DerivedStateKt.derivedStateOf(new RoomDatabase$$ExternalSyntheticLambda0((byte) 21, this));
        this.previousWindowVisibleFrame = new Rect();
        byte b = 0;
        this.snapshotStateObserver = new SnapshotStateObserver(new PopupLayout$$ExternalSyntheticLambda3(this, b));
        setId(android.R.id.content);
        setTag(R.id.view_tree_lifecycle_owner, ViewModelKt.get(view));
        setTag(R.id.view_tree_view_model_store_owner, ViewModelKt.m835get(view));
        setTag(R.id.view_tree_saved_state_registry_owner, UtilsKt.get(view));
        setTag(R.id.compose_view_saveable_id_tag, "Popup:" + uuid);
        setClipChildren(false);
        setElevation(density.mo81toPx0680j_4(8.0f));
        setOutlineProvider(new AnonymousClass2(b));
        this.content$delegate = Stack.mutableStateOf$default(AndroidDialog_androidKt.f7lambda$1131826196);
        this.locationOnScreen = new int[2];
    }

    public static final boolean canCalculatePosition_delegate$lambda$0(PopupLayout popupLayout) {
        LayoutCoordinates parentLayoutCoordinates = popupLayout.getParentLayoutCoordinates();
        if (parentLayoutCoordinates == null || !parentLayoutCoordinates.isAttached$1()) {
            parentLayoutCoordinates = null;
        }
        return (parentLayoutCoordinates == null || popupLayout.m825getPopupContentSizebOM6tXw() == null) ? false : true;
    }

    private final Function2 getContent() {
        return (Function2) this.content$delegate.getValue();
    }

    private final IntRect getDisplayBounds() {
        int i = this.properties.flags & 512;
        View view = this.composeView;
        Rect rect = this.previousWindowVisibleFrame;
        PopupLayoutHelperImpl popupLayoutHelperImpl = this.popupLayoutHelper;
        if (i == 0) {
            popupLayoutHelperImpl.getClass();
            view.getWindowVisibleDisplayFrame(rect);
        } else {
            popupLayoutHelperImpl.getWindowBounds(view, rect);
        }
        return new IntRect(rect.left, rect.top, rect.right, rect.bottom);
    }

    private final LayoutCoordinates getParentLayoutCoordinates() {
        return (LayoutCoordinates) this.parentLayoutCoordinates$delegate.getValue();
    }

    private final void setParentLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this.parentLayoutCoordinates$delegate.setValue(layoutCoordinates);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void Content(int i, Composer composer) {
        GapComposer gapComposer = (GapComposer) composer;
        gapComposer.startRestartGroup(-857613600);
        int i2 = (gapComposer.changedInstance(this) ? 4 : 2) | i;
        byte b = 1;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            getContent().invoke(gapComposer, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MainActivity$$ExternalSyntheticLambda0(this, i, b);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.properties.dismissOnBackPress) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getKeyCode() == 4 || keyEvent.getKeyCode() == 111) {
            KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
            if (keyDispatcherState == null) {
                return super.dispatchKeyEvent(keyEvent);
            }
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                keyDispatcherState.startTracking(keyEvent, this);
                return true;
            }
            if (keyEvent.getAction() == 1 && keyDispatcherState.isTracking(keyEvent) && !keyEvent.isCanceled()) {
                Function0 function0 = this.onDismissRequest;
                if (function0 != null) {
                    function0.invoke();
                }
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final boolean getCanCalculatePosition() {
        return ((Boolean) this.canCalculatePosition$delegate.getValue()).booleanValue();
    }

    public final WindowManager.LayoutParams getParams$ui() {
        return this.params;
    }

    public final LayoutDirection getParentLayoutDirection() {
        return this.parentLayoutDirection;
    }

    /* JADX INFO: renamed from: getPopupContentSize-bOM6tXw, reason: not valid java name */
    public final IntSize m825getPopupContentSizebOM6tXw() {
        return (IntSize) this.popupContentSize$delegate.getValue();
    }

    public final PopupPositionProvider getPositionProvider() {
        return this.positionProvider;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public final String getTestTag() {
        return this.testTag;
    }

    public /* bridge */ /* synthetic */ View getViewRoot() {
        return null;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void internalOnLayout$ui(boolean z, int i, int i2, int i3, int i4) {
        super.internalOnLayout$ui(z, i, i2, i3, i4);
        this.properties.getClass();
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        WindowManager.LayoutParams layoutParams = this.params;
        layoutParams.width = measuredWidth;
        layoutParams.height = childAt.getMeasuredHeight();
        this.popupLayoutHelper.getClass();
        this.windowManager.updateViewLayout(this, layoutParams);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void internalOnMeasure$ui(int i, int i2) {
        this.properties.getClass();
        IntRect displayBounds = getDisplayBounds();
        super.internalOnMeasure$ui(View.MeasureSpec.makeMeasureSpec(displayBounds.getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(displayBounds.getHeight(), Integer.MIN_VALUE));
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.snapshotStateObserver.start();
        if (!this.properties.dismissOnBackPress || Build.VERSION.SDK_INT < 33) {
            return;
        }
        Api33Impl$$ExternalSyntheticLambda0 api33Impl$$ExternalSyntheticLambda0 = this.backCallback;
        if (api33Impl$$ExternalSyntheticLambda0 == null) {
            Api33Impl$$ExternalSyntheticLambda0 api33Impl$$ExternalSyntheticLambda1 = new Api33Impl$$ExternalSyntheticLambda0((byte) 0, this.onDismissRequest);
            this.backCallback = api33Impl$$ExternalSyntheticLambda1;
            api33Impl$$ExternalSyntheticLambda0 = api33Impl$$ExternalSyntheticLambda1;
        }
        Api33Impl.maybeRegisterBackCallback(this, api33Impl$$ExternalSyntheticLambda0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SnapshotStateObserver snapshotStateObserver = this.snapshotStateObserver;
        OnBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 = snapshotStateObserver.applyUnsubscribe;
        if (onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0 != null) {
            onBackPressedDispatcher$OnBackPressedEventInput$$ExternalSyntheticLambda0.dispose();
        }
        snapshotStateObserver.clear();
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.maybeUnregisterBackCallback(this, this.backCallback);
        }
        this.backCallback = null;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.properties.dismissOnClickOutside) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent != null && motionEvent.getAction() == 0 && (motionEvent.getX() < CropImageView.DEFAULT_ASPECT_RATIO || motionEvent.getX() >= getWidth() || motionEvent.getY() < CropImageView.DEFAULT_ASPECT_RATIO || motionEvent.getY() >= getHeight())) {
            Function0 function0 = this.onDismissRequest;
            if (function0 != null) {
                function0.invoke();
                return true;
            }
        } else {
            if (motionEvent == null || motionEvent.getAction() != 4) {
                return super.onTouchEvent(motionEvent);
            }
            Function0 function1 = this.onDismissRequest;
            if (function1 != null) {
                function1.invoke();
            }
        }
        return true;
    }

    public final void setContent(CompositionContext compositionContext, Function2 function2) {
        setParentCompositionContext(compositionContext);
        setContent(function2);
        this.shouldCreateCompositionOnAttachedToWindow = true;
    }

    public final void setParentLayoutDirection(LayoutDirection layoutDirection) {
        this.parentLayoutDirection = layoutDirection;
    }

    /* JADX INFO: renamed from: setPopupContentSize-fhxjrPA, reason: not valid java name */
    public final void m826setPopupContentSizefhxjrPA(IntSize intSize) {
        this.popupContentSize$delegate.setValue(intSize);
    }

    public final void setPositionProvider(PopupPositionProvider popupPositionProvider) {
        this.positionProvider = popupPositionProvider;
    }

    public final void setTestTag(String str) {
        this.testTag = str;
    }

    public final void updateParameters(Function0 function0, PopupProperties popupProperties, String str, LayoutDirection layoutDirection, Density density) {
        int i;
        this.onDismissRequest = function0;
        this.testTag = str;
        if (!Intrinsics.areEqual(this.properties, popupProperties)) {
            popupProperties.getClass();
            float f = popupProperties.scrimAlpha;
            float f2 = popupProperties.blurBehindRadius;
            this.properties = popupProperties;
            boolean zIsFlagSecureEnabled = AndroidPopup_androidKt.isFlagSecureEnabled(this.composeView);
            boolean z = popupProperties.inheritSecurePolicy;
            int i2 = popupProperties.flags;
            if (z && zIsFlagSecureEnabled) {
                i2 |= 8192;
            } else if (z && !zIsFlagSecureEnabled) {
                i2 &= -8193;
            }
            WindowManager.LayoutParams layoutParams = this.params;
            layoutParams.flags = i2;
            if (Build.VERSION.SDK_INT >= 31 && !Float.isNaN(f2)) {
                PopupApi31Impl.INSTANCE.setBlurBehindRadius(layoutParams, density.mo75roundToPx0680j_4(f2));
            }
            if (!Float.isNaN(f)) {
                int i3 = layoutParams.flags;
                if (f > CropImageView.DEFAULT_ASPECT_RATIO) {
                    layoutParams.flags = i3 | 2;
                    layoutParams.dimAmount = f;
                } else {
                    layoutParams.flags = i3 & (-3);
                    layoutParams.dimAmount = CropImageView.DEFAULT_ASPECT_RATIO;
                }
            }
            this.popupLayoutHelper.getClass();
            this.windowManager.updateViewLayout(this, layoutParams);
        }
        int iOrdinal = layoutDirection.ordinal();
        if (iOrdinal != 0) {
            i = 1;
            if (iOrdinal != 1) {
                PathKt$$ExternalSyntheticBUOutline0.m$1();
                return;
            }
        } else {
            i = 0;
        }
        super.setLayoutDirection(i);
    }

    public final void updateParentBounds$ui() {
        LayoutCoordinates parentLayoutCoordinates = getParentLayoutCoordinates();
        if (parentLayoutCoordinates != null) {
            if (!parentLayoutCoordinates.isAttached$1()) {
                parentLayoutCoordinates = null;
            }
            if (parentLayoutCoordinates == null) {
                return;
            }
            long jMo603getSizeYbymL2g = parentLayoutCoordinates.mo603getSizeYbymL2g();
            long jMo607localToScreenMKHz9U = this.isNested ? parentLayoutCoordinates.mo607localToScreenMKHz9U(0L) : parentLayoutCoordinates.mo608localToWindowMKHz9U(0L);
            IntRect intRectM1058IntRectVbeCjmY = DatabaseDao_Impl.AnonymousClass17.m1058IntRectVbeCjmY((((long) Math.round(Float.intBitsToFloat((int) (jMo607localToScreenMKHz9U >> 32)))) << 32) | (4294967295L & ((long) Math.round(Float.intBitsToFloat((int) (jMo607localToScreenMKHz9U & 4294967295L))))), jMo603getSizeYbymL2g);
            if (intRectM1058IntRectVbeCjmY.equals(this.parentBounds)) {
                return;
            }
            this.parentBounds = intRectM1058IntRectVbeCjmY;
            updatePosition();
        }
    }

    public final void updateParentLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        setParentLayoutCoordinates(layoutCoordinates);
        updateParentBounds$ui();
    }

    public final void updatePosition() {
        IntSize intSizeM825getPopupContentSizebOM6tXw;
        final IntRect intRect = this.parentBounds;
        if (intRect == null || (intSizeM825getPopupContentSizebOM6tXw = m825getPopupContentSizebOM6tXw()) == null) {
            return;
        }
        final long j = intSizeM825getPopupContentSizebOM6tXw.packedValue;
        IntRect displayBounds = getDisplayBounds();
        final long height = (((long) displayBounds.getHeight()) & 4294967295L) | (((long) displayBounds.getWidth()) << 32);
        final Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.element = 0L;
        this.snapshotStateObserver.observeReads(this, onCommitAffectingPopupPosition, new Function0() { // from class: androidx.compose.ui.window.PopupLayout$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PopupLayout popupLayout = this;
                ref$LongRef.element = popupLayout.positionProvider.mo210calculatePositionllwVHH4(height, j, intRect, popupLayout.parentLayoutDirection);
                return Unit.INSTANCE;
            }
        });
        long j2 = ref$LongRef.element;
        WindowManager.LayoutParams layoutParams = this.params;
        layoutParams.x = (int) (j2 >> 32);
        layoutParams.y = (int) (j2 & 4294967295L);
        boolean z = this.properties.excludeFromSystemGesture;
        PopupLayoutHelperImpl popupLayoutHelperImpl = this.popupLayoutHelper;
        if (z) {
            popupLayoutHelperImpl.setGestureExclusionRects(this, (int) (height >> 32), (int) (height & 4294967295L));
        }
        popupLayoutHelperImpl.getClass();
        this.windowManager.updateViewLayout(this, layoutParams);
    }

    private final void setContent(Function2 function2) {
        this.content$delegate.setValue(function2);
    }

    public static /* synthetic */ void getParams$ui$annotations() {
    }

    public AbstractComposeView getSubCompositionView() {
        return this;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
    }
}
