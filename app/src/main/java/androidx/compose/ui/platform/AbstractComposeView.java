package androidx.compose.ui.platform;

import android.content.Context;
import android.os.IBinder;
import android.os.Trace;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.StandardMenuPopup;
import androidx.collection.IntIntPair$$ExternalSyntheticOutline0;
import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.node.Owner;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import coil3.util.UtilsKt;
import com.metrolist.music.db.DatabaseDao_Impl;
import com.yalantis.ucrop.R;
import io.ktor.util.PathKt$$ExternalSyntheticBUOutline0;
import java.lang.ref.WeakReference;
import kotlin.math.MathKt;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractComposeView extends ViewGroup {
    public WeakReference cachedViewTreeCompositionContext;
    public ComposeViewContext composeViewContext;
    public WrappedComposition composition;
    public boolean creatingComposition;
    public GapComposer$$ExternalSyntheticLambda0 disposeViewCompositionStrategy;
    public boolean isTransitionGroupSet;
    public CompositionContext parentContext;
    public IBinder previousAttachedWindowToken;
    public boolean showLayoutBounds;

    public AbstractComposeView(Context context) {
        super(context, null, 0);
        setClipChildren(false);
        setClipToPadding(false);
        setImportantForAccessibility(1);
        StandardMenuPopup.AnonymousClass2 anonymousClass2 = new StandardMenuPopup.AnonymousClass2((byte) 3, this);
        addOnAttachStateChangeListener(anonymousClass2);
        ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 = new ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0((byte) 0);
        MathKt.getPoolingContainerListenerHolder(this).listeners.add(viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0);
        this.disposeViewCompositionStrategy = new GapComposer$$ExternalSyntheticLambda0(this, anonymousClass2, viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0, (byte) 12);
    }

    private final void setParentContext(CompositionContext compositionContext) {
        if (this.parentContext != compositionContext) {
            this.parentContext = compositionContext;
            if (compositionContext != null) {
                this.cachedViewTreeCompositionContext = null;
            }
            WrappedComposition wrappedComposition = this.composition;
            if (wrappedComposition != null) {
                wrappedComposition.dispose();
                this.composition = null;
                if (isAttachedToWindow()) {
                    ensureCompositionCreated();
                }
            }
        }
    }

    private final void setPreviousAttachedWindowToken(IBinder iBinder) {
        if (this.previousAttachedWindowToken != iBinder) {
            this.previousAttachedWindowToken = iBinder;
            this.cachedViewTreeCompositionContext = null;
        }
    }

    public abstract void Content(int i, Composer composer);

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        checkAddView();
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams) {
        checkAddView();
        return super.addViewInLayout(view, i, layoutParams);
    }

    public final void attachedToWindow() {
        if (isAttachedToWindow()) {
            setPreviousAttachedWindowToken(getWindowToken());
            if (this.composeViewContext == null) {
                AndroidComposeView androidComposeView = null;
                if (getChildCount() != 0) {
                    View childAt = getChildAt(0);
                    if (childAt instanceof AndroidComposeView) {
                        androidComposeView = (AndroidComposeView) childAt;
                    }
                }
                if (androidComposeView != null) {
                    androidComposeView.setComposeViewContext(updateAutoCreatedComposeViewContext(InvertMatrixKt.findViewTreeComposeViewRoot(this), androidComposeView.getComposeViewContext()));
                }
            }
            if (getShouldCreateCompositionOnAttachedToWindow()) {
                ensureCompositionCreated();
            }
        }
    }

    public final void checkAddView() {
        if (this.creatingComposition) {
            return;
        }
        PathKt$$ExternalSyntheticBUOutline0.m$2(IntIntPair$$ExternalSyntheticOutline0.m("Cannot add views to ", getClass().getSimpleName(), "; only Compose content is supported"));
    }

    public final void createComposition() {
        ComposeViewContext composeViewContext;
        if (this.parentContext != null || isAttachedToWindow() || ((composeViewContext = this.composeViewContext) != null && composeViewContext.view.isAttachedToWindow())) {
            ensureCompositionCreated();
        } else {
            _UtilJvmKt$$ExternalSyntheticLambda0.m$2("createComposition requires a previous call to createComposition(ComposeViewContext), a parent reference, or the View to be attached to a window. Attach the View or call setParentCompositionReference.");
        }
    }

    public final void disposeComposition() {
        View childAt = getChildAt(0);
        AndroidComposeView androidComposeView = childAt instanceof AndroidComposeView ? (AndroidComposeView) childAt : null;
        if (androidComposeView != null && androidComposeView.composeViewContextIncrementedDuringInit) {
            androidComposeView.getComposeViewContext().decrementViewCount$ui();
            androidComposeView.composeViewContextIncrementedDuringInit = false;
        }
        WrappedComposition wrappedComposition = this.composition;
        if (wrappedComposition != null) {
            wrappedComposition.dispose();
        }
        this.composition = null;
        requestLayout();
    }

    public final void ensureCompositionCreated() {
        if (this.composition == null) {
            try {
                this.creatingComposition = true;
                Trace.beginSection("Compose:initializeView");
                try {
                    ComposeViewContext composeViewContextResolveComposeViewContext = this.composeViewContext;
                    if (composeViewContextResolveComposeViewContext == null) {
                        composeViewContextResolveComposeViewContext = resolveComposeViewContext();
                    }
                    this.composition = Wrapper_androidKt.setContent(this, composeViewContextResolveComposeViewContext, new ComposableLambdaImpl(true, 1003123809, new ComposerKt$$ExternalSyntheticLambda0((byte) 26, this)));
                    Trace.endSection();
                    this.creatingComposition = false;
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            } catch (Throwable th2) {
                this.creatingComposition = false;
                throw th2;
            }
        }
    }

    /* JADX INFO: renamed from: getAutoClearFocusBehavior-4UtRPd4, reason: not valid java name */
    public final int m679getAutoClearFocusBehavior4UtRPd4() {
        Object tag = getTag(R.id.auto_clear_focus_behavior_tag);
        AutoClearFocusBehavior autoClearFocusBehavior = tag instanceof AutoClearFocusBehavior ? (AutoClearFocusBehavior) tag : null;
        if (autoClearFocusBehavior != null) {
            return autoClearFocusBehavior.value;
        }
        return 1;
    }

    public final ComposeViewContext getComposeViewContext$ui() {
        return this.composeViewContext;
    }

    public final boolean getHasComposition() {
        return this.composition != null;
    }

    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return true;
    }

    public final boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    public void internalOnLayout$ui(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.layout(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    public void internalOnMeasure$ui(int i, int i2) {
        View childAt = getChildAt(0);
        if (childAt == null) {
            super.onMeasure(i, i2);
            return;
        }
        childAt.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight()), View.MeasureSpec.getMode(i)), View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom()), View.MeasureSpec.getMode(i2)));
        setMeasuredDimension(getPaddingRight() + getPaddingLeft() + childAt.getMeasuredWidth(), getPaddingBottom() + getPaddingTop() + childAt.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup
    public final boolean isTransitionGroup() {
        return !this.isTransitionGroupSet || super.isTransitionGroup();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MutableScatterMap mutableScatterMap = WindowRecomposer_androidKt.animationScale;
        Object parentOrViewTreeDisjointParent = DatabaseDao_Impl.AnonymousClass17.getParentOrViewTreeDisjointParent(this);
        View view = this;
        while (parentOrViewTreeDisjointParent instanceof View) {
            View view2 = (View) parentOrViewTreeDisjointParent;
            if (view2.getId() == 16908290) {
                break;
            }
            view = view2;
            parentOrViewTreeDisjointParent = view2.getParent();
        }
        if (view.getParent() == null) {
            getHandler().postAtFrontOfQueue(new ActivityCompat$$ExternalSyntheticLambda0((byte) 6, (Object) this));
        } else {
            attachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        internalOnLayout$ui(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        ensureCompositionCreated();
        internalOnMeasure$ui(i, i2);
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.setLayoutDirection(i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0007  */
    public final ComposeViewContext resolveComposeViewContext() {
        ComposeViewContext composeViewContext;
        ViewModelStoreOwner viewModelStoreOwner;
        ViewModelStoreOwner viewModelStoreOwner2 = null;
        if (getChildCount() == 0) {
            composeViewContext = null;
        } else {
            View childAt = getChildAt(0);
            AndroidComposeView androidComposeView = childAt instanceof AndroidComposeView ? (AndroidComposeView) childAt : null;
            if (androidComposeView != null) {
                composeViewContext = androidComposeView.getComposeViewContext();
            } else {
                composeViewContext = null;
            }
        }
        View viewFindViewTreeComposeViewRoot = InvertMatrixKt.findViewTreeComposeViewRoot(this);
        ComposeViewContext composeViewContext2 = InvertMatrixKt.getComposeViewContext(viewFindViewTreeComposeViewRoot);
        if (composeViewContext2 != null) {
            return updateAutoCreatedComposeViewContext(viewFindViewTreeComposeViewRoot, composeViewContext2);
        }
        CompositionContext compositionContextResolveParentCompositionContext = resolveParentCompositionContext();
        LifecycleOwner lifecycleOwner$ui = ViewModelKt.get(viewFindViewTreeComposeViewRoot);
        if (lifecycleOwner$ui == null) {
            lifecycleOwner$ui = composeViewContext != null ? composeViewContext.getLifecycleOwner$ui() : null;
            if (lifecycleOwner$ui == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
                return null;
            }
        }
        LifecycleOwner lifecycleOwner = lifecycleOwner$ui;
        SavedStateRegistryOwner savedStateRegistryOwner = UtilsKt.get(viewFindViewTreeComposeViewRoot);
        if (savedStateRegistryOwner == null) {
            if (composeViewContext != null) {
                composeViewContext.resolveValuesIfNeeded();
                savedStateRegistryOwner = composeViewContext._savedStateRegistryOwner;
                savedStateRegistryOwner.getClass();
            } else {
                savedStateRegistryOwner = null;
            }
            if (savedStateRegistryOwner == null) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("Composed into the View which doesn't propagate ViewTreeSavedStateRegistryOwner!");
                return null;
            }
        }
        SavedStateRegistryOwner savedStateRegistryOwner2 = savedStateRegistryOwner;
        ViewModelStoreOwner viewModelStoreOwnerM835get = ViewModelKt.m835get(viewFindViewTreeComposeViewRoot);
        if (viewModelStoreOwnerM835get == null) {
            if (composeViewContext != null) {
                composeViewContext.resolveValuesIfNeeded();
                viewModelStoreOwner2 = composeViewContext._viewModelStoreOwner;
            }
            viewModelStoreOwner = viewModelStoreOwner2;
        } else {
            viewModelStoreOwner = viewModelStoreOwnerM835get;
        }
        ComposeViewContext composeViewContext3 = new ComposeViewContext(InvertMatrixKt.getComposeViewContext(InvertMatrixKt.findViewTreeComposeViewRoot(viewFindViewTreeComposeViewRoot)), viewFindViewTreeComposeViewRoot, compositionContextResolveParentCompositionContext, lifecycleOwner, savedStateRegistryOwner2, viewModelStoreOwner);
        viewFindViewTreeComposeViewRoot.setTag(R.id.androidx_compose_ui_view_compose_view_context, new WeakReference(composeViewContext3));
        return composeViewContext3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.runtime.CompositionContext] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.runtime.CompositionContext] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.runtime.CompositionContext] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [androidx.compose.runtime.Recomposer] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v19 */
    public final CompositionContext resolveParentCompositionContext() {
        CompositionContext compositionContext;
        ?? compositionContext2 = this.parentContext;
        if (compositionContext2 == 0) {
            compositionContext2 = WindowRecomposer_androidKt.getCompositionContext(this);
            if (compositionContext2 == 0) {
                Object parent = getParent();
                while (true) {
                    if (compositionContext2 != 0 || !(parent instanceof View)) {
                        compositionContext2 = compositionContext2;
                        break;
                    }
                    compositionContext2 = compositionContext2;
                    View view = (View) parent;
                    CompositionContext compositionContext3 = WindowRecomposer_androidKt.getCompositionContext(view);
                    parent = DatabaseDao_Impl.AnonymousClass17.getParentOrViewTreeDisjointParent(view);
                    compositionContext2 = compositionContext3;
                }
            }
            Recomposer.State state = Recomposer.State.ShuttingDown;
            if (compositionContext2 != 0) {
                ?? r3 = (!(compositionContext2 instanceof Recomposer) || ((Recomposer.State) ((Recomposer) compositionContext2)._state.getValue()).compareTo(state) > 0) ? compositionContext2 : 0;
                if (r3 != 0) {
                    this.cachedViewTreeCompositionContext = new WeakReference(r3);
                }
            } else {
                compositionContext2 = 0;
            }
            if (compositionContext2 == 0) {
                WeakReference weakReference = this.cachedViewTreeCompositionContext;
                if (weakReference == null || (compositionContext = (CompositionContext) weakReference.get()) == null || ((compositionContext instanceof Recomposer) && ((Recomposer.State) ((Recomposer) compositionContext)._state.getValue()).compareTo(state) <= 0)) {
                    compositionContext2 = compositionContext;
                    compositionContext2 = compositionContext;
                    compositionContext2 = 0;
                }
                if (compositionContext2 == 0) {
                    compositionContext2 = WindowRecomposer_androidKt.getWindowRecomposer(this);
                    ?? r2 = ((Recomposer.State) compositionContext2._state.getValue()).compareTo(state) > 0 ? compositionContext2 : 0;
                    if (r2 != 0) {
                        this.cachedViewTreeCompositionContext = new WeakReference(r2);
                    }
                }
            }
        }
        return compositionContext2;
    }

    /* JADX INFO: renamed from: setAutoClearFocusBehavior-17tfJxM, reason: not valid java name */
    public final void m680setAutoClearFocusBehavior17tfJxM(int i) {
        setTag(R.id.auto_clear_focus_behavior_tag, new AutoClearFocusBehavior(i));
    }

    public final void setComposeViewContext$ui(ComposeViewContext composeViewContext) {
        if (this.composeViewContext != composeViewContext) {
            if (composeViewContext == null) {
                disposeComposition();
            } else if (getChildCount() != 0) {
                View childAt = getChildAt(0);
                AndroidComposeView androidComposeView = childAt instanceof AndroidComposeView ? (AndroidComposeView) childAt : null;
                if (androidComposeView != null) {
                    if (androidComposeView.getCoroutineContext() != composeViewContext.getCompositionContext$ui().getEffectCoroutineContext()) {
                        disposeComposition();
                    }
                    androidComposeView.setComposeViewContext(composeViewContext);
                }
            }
            this.composeViewContext = composeViewContext;
        }
    }

    public final void setParentCompositionContext(CompositionContext compositionContext) {
        setParentContext(compositionContext);
    }

    public final void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
        KeyEvent.Callback childAt = getChildAt(0);
        if (childAt != null) {
            ((AndroidComposeView) ((Owner) childAt)).setShowLayoutBounds(z);
        }
    }

    @Override // android.view.ViewGroup
    public void setTransitionGroup(boolean z) {
        super.setTransitionGroup(z);
        this.isTransitionGroupSet = true;
    }

    public final void setViewCompositionStrategy(ViewCompositionStrategy viewCompositionStrategy) {
        GapComposer$$ExternalSyntheticLambda0 gapComposer$$ExternalSyntheticLambda0 = this.disposeViewCompositionStrategy;
        if (gapComposer$$ExternalSyntheticLambda0 != null) {
            gapComposer$$ExternalSyntheticLambda0.invoke();
        }
        ((InvertMatrixKt) viewCompositionStrategy).getClass();
        StandardMenuPopup.AnonymousClass2 anonymousClass2 = new StandardMenuPopup.AnonymousClass2((byte) 3, this);
        addOnAttachStateChangeListener(anonymousClass2);
        ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0 = new ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0((byte) 0);
        MathKt.getPoolingContainerListenerHolder(this).listeners.add(viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0);
        this.disposeViewCompositionStrategy = new GapComposer$$ExternalSyntheticLambda0(this, anonymousClass2, viewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$$ExternalSyntheticLambda0, (byte) 12);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public final ComposeViewContext updateAutoCreatedComposeViewContext(View view, ComposeViewContext composeViewContext) {
        CompositionContext compositionContextResolveParentCompositionContext = resolveParentCompositionContext();
        LifecycleOwner lifecycleOwner$ui = ViewModelKt.get(view);
        ViewModelStoreOwner viewModelStoreOwnerM835get = ViewModelKt.m835get(view);
        SavedStateRegistryOwner savedStateRegistryOwner = UtilsKt.get(view);
        if (compositionContextResolveParentCompositionContext == composeViewContext.getCompositionContext$ui() && lifecycleOwner$ui == composeViewContext.getLifecycleOwner$ui()) {
            composeViewContext.resolveValuesIfNeeded();
            if (viewModelStoreOwnerM835get == composeViewContext._viewModelStoreOwner) {
                composeViewContext.resolveValuesIfNeeded();
                SavedStateRegistryOwner savedStateRegistryOwner2 = composeViewContext._savedStateRegistryOwner;
                savedStateRegistryOwner2.getClass();
                if (savedStateRegistryOwner == savedStateRegistryOwner2) {
                    return composeViewContext;
                }
            }
        }
        if (compositionContextResolveParentCompositionContext.getEffectCoroutineContext() != composeViewContext.getCompositionContext$ui().getEffectCoroutineContext()) {
            disposeComposition();
        }
        if (lifecycleOwner$ui == null) {
            lifecycleOwner$ui = composeViewContext.getLifecycleOwner$ui();
        }
        LifecycleOwner lifecycleOwner = lifecycleOwner$ui;
        if (savedStateRegistryOwner == null) {
            composeViewContext.resolveValuesIfNeeded();
            savedStateRegistryOwner = composeViewContext._savedStateRegistryOwner;
            savedStateRegistryOwner.getClass();
        }
        ComposeViewContext composeViewContext2 = new ComposeViewContext(composeViewContext, view, compositionContextResolveParentCompositionContext, lifecycleOwner, savedStateRegistryOwner, viewModelStoreOwnerM835get);
        view.setTag(R.id.androidx_compose_ui_view_compose_view_context, new WeakReference(composeViewContext2));
        return composeViewContext2;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i) {
        checkAddView();
        super.addView(view, i);
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        checkAddView();
        return super.addViewInLayout(view, i, layoutParams, z);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, int i2) {
        checkAddView();
        super.addView(view, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        checkAddView();
        super.addView(view, layoutParams);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        checkAddView();
        super.addView(view, i, layoutParams);
    }

    private static /* synthetic */ void getDisposeViewCompositionStrategy$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }
}
