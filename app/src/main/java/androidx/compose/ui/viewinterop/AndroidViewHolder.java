package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.collection.MutableScatterMap;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.text.selection.SelectionMagnifierKt;
import androidx.compose.material3.FabPlacement;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollNode;
import androidx.compose.ui.input.pointer.PointerInteropFilter;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.InnerNodeCoordinator;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerScope;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.WindowRecomposer_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda6;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.window.DialogLayout;
import androidx.compose.ui.window.PopupLayout$$ExternalSyntheticLambda5;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.sqlite.SQLite;
import coil3.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil3.disk.UtilsKt$$ExternalSyntheticLambda0;
import coil3.network.okhttp.internal.CallsKt$await$2$1;
import coil3.util.LifecyclesKt;
import com.dokar.quickjs.QuickJs$$ExternalSyntheticLambda1;
import com.yalantis.ucrop.R;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.uuid.UuidKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidViewHolder extends ViewGroup implements NestedScrollingParent3, ComposeNodeLifecycleCallback, OwnerScope, OnApplyWindowInsetsListener {
    public static final SaversKt$$ExternalSyntheticLambda6 OnCommitAffectingUpdate = new SaversKt$$ExternalSyntheticLambda6((byte) 20);
    public Function1 bringIntoViewRequester;
    public Density density;
    public final NestedScrollDispatcher dispatcher;
    public boolean hasUpdateBlock;
    public WindowInsetsCompat insets;
    public boolean isDrawing;
    public int lastHeightMeasureSpec;
    public int lastWidthMeasureSpec;
    public final LayoutNode layoutNode;
    public LifecycleOwner lifecycleOwner;
    public final int[] location;
    public Modifier modifier;
    public final FabPlacement nestedScrollingParentHelper;
    public Function1 onDensityChanged;
    public Function1 onModifierChanged;
    public Function1 onRequestDisallowInterceptTouchEvent;
    public final Owner owner;
    public final int[] position;
    public Function0 release;
    public Function0 reset;
    public final AndroidViewHolder$$ExternalSyntheticLambda7 runInvalidate;
    public final AndroidViewHolder$$ExternalSyntheticLambda7 runUpdate;
    public SavedStateRegistryOwner savedStateRegistryOwner;
    public long size;
    public Function0 update;
    public final View view;

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedFling$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ boolean $consumed;
        public final /* synthetic */ long $viewVelocity;
        public byte label;
        public final /* synthetic */ AndroidViewHolder this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z, AndroidViewHolder androidViewHolder, long j, Continuation continuation) {
            super(2, continuation);
            this.$consumed = z;
            this.this$0 = androidViewHolder;
            this.$viewVelocity = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$consumed, this.this$0, this.$viewVelocity, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.label;
            if (b == 0) {
                ResultKt.throwOnFailure(obj);
                NestedScrollDispatcher nestedScrollDispatcher = this.this$0.dispatcher;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (this.$consumed) {
                    this.label = (byte) 2;
                    Object objM582dispatchPostFlingRZ2iAVY = nestedScrollDispatcher.m582dispatchPostFlingRZ2iAVY(this.$viewVelocity, 0L, this);
                    if (objM582dispatchPostFlingRZ2iAVY != coroutineSingletons) {
                        obj = objM582dispatchPostFlingRZ2iAVY;
                        long j = ((Velocity) obj).packedValue;
                    }
                } else {
                    this.label = (byte) 1;
                    Object objM582dispatchPostFlingRZ2iAVY2 = nestedScrollDispatcher.m582dispatchPostFlingRZ2iAVY(0L, this.$viewVelocity, this);
                    if (objM582dispatchPostFlingRZ2iAVY2 != coroutineSingletons) {
                        obj = objM582dispatchPostFlingRZ2iAVY2;
                        long j2 = ((Velocity) obj).packedValue;
                    }
                }
                return coroutineSingletons;
            }
            if (b == 1) {
                ResultKt.throwOnFailure(obj);
                long j3 = ((Velocity) obj).packedValue;
            } else {
                if (b != 2) {
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                long j4 = ((Velocity) obj).packedValue;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedPreFling$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class C00381 extends SuspendLambda implements Function2 {
        public final /* synthetic */ byte $r8$classId;
        public final /* synthetic */ long $toBeConsumed;
        public boolean label;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C00381(Object obj, long j, Continuation continuation, byte b) {
            super(2, continuation);
            this.$r8$classId = b;
            this.this$0 = obj;
            this.$toBeConsumed = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            byte b = this.$r8$classId;
            Object obj2 = this.this$0;
            switch (b) {
                case 0:
                    return new C00381((AndroidViewHolder) obj2, this.$toBeConsumed, continuation, (byte) 0);
                default:
                    return new C00381((Animatable) obj2, this.$toBeConsumed, continuation, (byte) 1);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (b) {
                case 0:
                    break;
            }
            return ((C00381) create(coroutineScope, continuation)).invokeSuspend(unit);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte b = this.$r8$classId;
            Unit unit = Unit.INSTANCE;
            long j = this.$toBeConsumed;
            Object obj2 = this.this$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            switch (b) {
                case 0:
                    boolean z = this.label;
                    if (!z) {
                        ResultKt.throwOnFailure(obj);
                        NestedScrollDispatcher nestedScrollDispatcher = ((AndroidViewHolder) obj2).dispatcher;
                        this.label = true;
                        return nestedScrollDispatcher.m583dispatchPreFlingQWom1Mo(j, this) == coroutineSingletons ? coroutineSingletons : unit;
                    }
                    if (z) {
                        ResultKt.throwOnFailure(obj);
                        return unit;
                    }
                    _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                    return null;
                default:
                    boolean z2 = this.label;
                    if (z2) {
                        if (z2) {
                            ResultKt.throwOnFailure(obj);
                            return unit;
                        }
                        _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    Animatable animatable = (Animatable) obj2;
                    Offset offset = new Offset(j);
                    SpringSpec springSpec = SelectionMagnifierKt.MagnifierSpringSpec;
                    this.label = true;
                    return Animatable.animateTo$default(animatable, offset, springSpec, null, null, this, 12) == coroutineSingletons ? coroutineSingletons : unit;
            }
        }
    }

    public AndroidViewHolder(Context context, GapComposer.CompositionContextImpl compositionContextImpl, int i, NestedScrollDispatcher nestedScrollDispatcher, View view, Owner owner) {
        super(context);
        this.dispatcher = nestedScrollDispatcher;
        this.view = view;
        this.owner = owner;
        MutableScatterMap mutableScatterMap = WindowRecomposer_androidKt.animationScale;
        setTag(R.id.androidx_compose_ui_view_composition_context, compositionContextImpl);
        byte b = 0;
        setSaveFromParentEnabled(false);
        addView(view);
        final ViewFactoryHolder viewFactoryHolder = (ViewFactoryHolder) this;
        byte b2 = 1;
        DialogLayout.AnonymousClass1 anonymousClass1 = new DialogLayout.AnonymousClass1(viewFactoryHolder, b2);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        WindowInsetsAnimationCompat.setCallback(this, anonymousClass1);
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(this, this);
        byte b3 = 2;
        this.update = new UtilsKt$$ExternalSyntheticLambda0((byte) 2);
        byte b4 = 3;
        this.reset = new UtilsKt$$ExternalSyntheticLambda0((byte) 3);
        this.release = new UtilsKt$$ExternalSyntheticLambda0((byte) 4);
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        this.modifier = companion;
        this.density = LifecyclesKt.Density$default();
        this.position = new int[2];
        this.size = 0L;
        this.runUpdate = new AndroidViewHolder$$ExternalSyntheticLambda7(viewFactoryHolder, b);
        this.runInvalidate = new AndroidViewHolder$$ExternalSyntheticLambda7(viewFactoryHolder, b2);
        this.location = new int[2];
        this.lastWidthMeasureSpec = Integer.MIN_VALUE;
        this.lastHeightMeasureSpec = Integer.MIN_VALUE;
        this.nestedScrollingParentHelper = new FabPlacement();
        final LayoutNode layoutNode = new LayoutNode(3);
        layoutNode.interopViewFactoryHolder = viewFactoryHolder;
        Modifier modifierSemantics = SemanticsModifierKt.semantics(NestedScrollModifierKt.nestedScroll(companion, AndroidView_androidKt.NoOpScrollConnection, nestedScrollDispatcher), true, new SaversKt$$ExternalSyntheticLambda6((byte) 21));
        PointerInteropFilter pointerInteropFilter = new PointerInteropFilter();
        pointerInteropFilter.onTouchEvent = new AndroidViewHolder$$ExternalSyntheticLambda4(viewFactoryHolder, b2);
        CallsKt$await$2$1 callsKt$await$2$1 = new CallsKt$await$2$1();
        CallsKt$await$2$1 callsKt$await$2$2 = pointerInteropFilter.requestDisallowInterceptTouchEvent;
        if (callsKt$await$2$2 != null) {
            callsKt$await$2$2.$this_await = null;
        }
        pointerInteropFilter.requestDisallowInterceptTouchEvent = callsKt$await$2$1;
        callsKt$await$2$1.$this_await = pointerInteropFilter;
        setOnRequestDisallowInterceptTouchEvent$ui(callsKt$await$2$1);
        Modifier modifierThen = RulerKt.onGloballyPositioned(ClipKt.drawBehind(modifierSemantics.then(pointerInteropFilter), new coil3.compose.internal.UtilsKt$$ExternalSyntheticLambda0((Object) viewFactoryHolder, (Object) layoutNode, (Object) viewFactoryHolder, (byte) 24)), new AndroidViewHolder$$ExternalSyntheticLambda3(viewFactoryHolder, layoutNode, b2)).then(new BringIntoViewElement(new AndroidViewHolder$$ExternalSyntheticLambda4(viewFactoryHolder, b3)));
        layoutNode.setModifier(this.modifier.then(modifierThen));
        this.onModifierChanged = new QuickJs$$ExternalSyntheticLambda1(layoutNode, modifierThen, b4);
        layoutNode.setDensity(this.density);
        this.onDensityChanged = new DiskLruCache$$ExternalSyntheticLambda0((byte) 9, layoutNode);
        layoutNode.onAttach = new AndroidViewHolder$$ExternalSyntheticLambda3(viewFactoryHolder, layoutNode, b);
        layoutNode.onDetach = new AndroidViewHolder$$ExternalSyntheticLambda4(viewFactoryHolder, b);
        layoutNode.setMeasurePolicy(new MeasurePolicy() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5
            @Override // androidx.compose.ui.layout.MeasurePolicy
            public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i2) {
                ViewFactoryHolder viewFactoryHolder2 = viewFactoryHolder;
                ViewGroup.LayoutParams layoutParams = viewFactoryHolder2.getLayoutParams();
                layoutParams.getClass();
                viewFactoryHolder2.measure(AndroidViewHolder.obtainMeasureSpec(0, i2, layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
                return viewFactoryHolder2.getMeasuredHeight();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i2) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                ViewFactoryHolder viewFactoryHolder2 = viewFactoryHolder;
                ViewGroup.LayoutParams layoutParams = viewFactoryHolder2.getLayoutParams();
                layoutParams.getClass();
                viewFactoryHolder2.measure(iMakeMeasureSpec, AndroidViewHolder.obtainMeasureSpec(0, i2, layoutParams.height));
                return viewFactoryHolder2.getMeasuredWidth();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo13measure3p2s80s(MeasureScope measureScope, List list, long j) {
                ViewFactoryHolder viewFactoryHolder2 = viewFactoryHolder;
                int childCount = viewFactoryHolder2.getChildCount();
                EmptyMap emptyMap = EmptyMap.INSTANCE;
                if (childCount == 0) {
                    return measureScope.layout(Constraints.m786getMinWidthimpl(j), Constraints.m785getMinHeightimpl(j), emptyMap, new SaversKt$$ExternalSyntheticLambda6((byte) 22));
                }
                if (Constraints.m786getMinWidthimpl(j) != 0) {
                    viewFactoryHolder2.getChildAt(0).setMinimumWidth(Constraints.m786getMinWidthimpl(j));
                }
                if (Constraints.m785getMinHeightimpl(j) != 0) {
                    viewFactoryHolder2.getChildAt(0).setMinimumHeight(Constraints.m785getMinHeightimpl(j));
                }
                int iM786getMinWidthimpl = Constraints.m786getMinWidthimpl(j);
                int iM784getMaxWidthimpl = Constraints.m784getMaxWidthimpl(j);
                ViewGroup.LayoutParams layoutParams = viewFactoryHolder2.getLayoutParams();
                layoutParams.getClass();
                int iObtainMeasureSpec = AndroidViewHolder.obtainMeasureSpec(iM786getMinWidthimpl, iM784getMaxWidthimpl, layoutParams.width);
                int iM785getMinHeightimpl = Constraints.m785getMinHeightimpl(j);
                int iM783getMaxHeightimpl = Constraints.m783getMaxHeightimpl(j);
                ViewGroup.LayoutParams layoutParams2 = viewFactoryHolder2.getLayoutParams();
                layoutParams2.getClass();
                viewFactoryHolder2.measure(iObtainMeasureSpec, AndroidViewHolder.obtainMeasureSpec(iM785getMinHeightimpl, iM783getMaxHeightimpl, layoutParams2.height));
                return measureScope.layout(viewFactoryHolder2.getMeasuredWidth(), viewFactoryHolder2.getMeasuredHeight(), emptyMap, new AndroidViewHolder$$ExternalSyntheticLambda3(viewFactoryHolder2, layoutNode, (byte) 2));
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i2) {
                ViewFactoryHolder viewFactoryHolder2 = viewFactoryHolder;
                ViewGroup.LayoutParams layoutParams = viewFactoryHolder2.getLayoutParams();
                layoutParams.getClass();
                viewFactoryHolder2.measure(AndroidViewHolder.obtainMeasureSpec(0, i2, layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
                return viewFactoryHolder2.getMeasuredHeight();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i2) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                ViewFactoryHolder viewFactoryHolder2 = viewFactoryHolder;
                ViewGroup.LayoutParams layoutParams = viewFactoryHolder2.getLayoutParams();
                layoutParams.getClass();
                viewFactoryHolder2.measure(iMakeMeasureSpec, AndroidViewHolder.obtainMeasureSpec(0, i2, layoutParams.height));
                return viewFactoryHolder2.getMeasuredWidth();
            }
        });
        this.layoutNode = layoutNode;
    }

    private final OwnerSnapshotObserver getSnapshotObserver() {
        if (!isAttachedToWindow()) {
            InlineClassHelperKt.throwIllegalStateException("Expected AndroidViewHolder to be attached when observing reads.");
        }
        return ((AndroidComposeView) this.owner).getSnapshotObserver();
    }

    public static Insets inset(Insets insets, int i, int i2, int i3, int i4) {
        int i5 = insets.left - i;
        if (i5 < 0) {
            i5 = 0;
        }
        int i6 = insets.top - i2;
        if (i6 < 0) {
            i6 = 0;
        }
        int i7 = insets.right - i3;
        if (i7 < 0) {
            i7 = 0;
        }
        int i8 = insets.bottom - i4;
        return Insets.of(i5, i6, i7, i8 >= 0 ? i8 : 0);
    }

    public static int obtainMeasureSpec(int i, int i2, int i3) {
        if (i3 >= 0 || i == i2) {
            return View.MeasureSpec.makeMeasureSpec(UuidKt.coerceIn(i3, i, i2), 1073741824);
        }
        if (i3 != -2 || i2 == Integer.MAX_VALUE) {
            return (i3 != -1 || i2 == Integer.MAX_VALUE) ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        }
        return View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE);
    }

    public static final void runUpdate$lambda$0(ViewFactoryHolder viewFactoryHolder) {
        if (viewFactoryHolder.hasUpdateBlock && viewFactoryHolder.isAttachedToWindow() && viewFactoryHolder.view.getParent() == viewFactoryHolder) {
            OwnerSnapshotObserver snapshotObserver = viewFactoryHolder.getSnapshotObserver();
            snapshotObserver.observer.observeReads(viewFactoryHolder, OnCommitAffectingUpdate, viewFactoryHolder.update);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean gatherTransparentRegion(Region region) {
        if (region == null) {
            return true;
        }
        int[] iArr = this.location;
        getLocationInWindow(iArr);
        int i = iArr[0];
        region.op(i, iArr[1], getWidth() + i, getHeight() + iArr[1], Region.Op.DIFFERENCE);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.compose.ui.viewinterop.AndroidViewHolder";
    }

    public final Density getDensity() {
        return this.density;
    }

    public final View getInteropView() {
        return this.view;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    @Override // android.view.View
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        return layoutParams == null ? new ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        FabPlacement fabPlacement = this.nestedScrollingParentHelper;
        return fabPlacement.height | fabPlacement.left;
    }

    public final Function1 getOnDensityChanged$ui() {
        return this.onDensityChanged;
    }

    public final Function1 getOnModifierChanged$ui() {
        return this.onModifierChanged;
    }

    public final Function1 getOnRequestDisallowInterceptTouchEvent$ui() {
        return this.onRequestDisallowInterceptTouchEvent;
    }

    public final Function0 getRelease() {
        return this.release;
    }

    public final Function0 getReset() {
        return this.reset;
    }

    public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
        return this.savedStateRegistryOwner;
    }

    public final Function0 getUpdate() {
        return this.update;
    }

    public final View getView() {
        return this.view;
    }

    public final WindowInsetsCompat insetToLayoutPosition(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat.Impl impl = windowInsetsCompat.mImpl;
        Insets insets = impl.getInsets(-1);
        Insets insets2 = Insets.NONE;
        if (!insets.equals(insets2) || !impl.getInsetsIgnoringVisibility(-9).equals(insets2) || impl.getDisplayCutout() != null) {
            InnerNodeCoordinator innerNodeCoordinator = (InnerNodeCoordinator) this.layoutNode.nodes.innerCoordinator;
            if (innerNodeCoordinator.tail.isAttached) {
                long jM847roundk4lQ0M = SQLite.m847roundk4lQ0M(innerNodeCoordinator.mo606localToRootMKHz9U(0L));
                int i = (int) (jM847roundk4lQ0M >> 32);
                if (i < 0) {
                    i = 0;
                }
                int i2 = (int) (jM847roundk4lQ0M & 4294967295L);
                if (i2 < 0) {
                    i2 = 0;
                }
                long jMo603getSizeYbymL2g = RulerKt.findRootCoordinates(innerNodeCoordinator).mo603getSizeYbymL2g();
                int i3 = (int) (jMo603getSizeYbymL2g >> 32);
                int i4 = (int) (jMo603getSizeYbymL2g & 4294967295L);
                long j = innerNodeCoordinator.measuredSize;
                long jM847roundk4lQ0M2 = SQLite.m847roundk4lQ0M(innerNodeCoordinator.mo606localToRootMKHz9U((((long) Float.floatToRawIntBits((int) (j >> 32))) << 32) | (((long) Float.floatToRawIntBits((int) (j & 4294967295L))) & 4294967295L)));
                int i5 = i3 - ((int) (jM847roundk4lQ0M2 >> 32));
                if (i5 < 0) {
                    i5 = 0;
                }
                int i6 = i4 - ((int) (4294967295L & jM847roundk4lQ0M2));
                int i7 = i6 >= 0 ? i6 : 0;
                if (i != 0 || i2 != 0 || i5 != 0 || i7 != 0) {
                    return windowInsetsCompat.mImpl.inset(i, i2, i5, i7);
                }
            }
        }
        return windowInsetsCompat;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        super.invalidateChildInParent(iArr, rect);
        if (!this.isDrawing) {
            this.layoutNode.invalidateLayer$ui();
            return null;
        }
        this.view.postOnAnimation(new PopupLayout$$ExternalSyntheticLambda5(this.runInvalidate, (byte) 4));
        return null;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.view.isNestedScrollingEnabled();
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final boolean isValidOwnerScope() {
        return isAttachedToWindow();
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        this.insets = new WindowInsetsCompat(windowInsetsCompat);
        return insetToLayoutPosition(windowInsetsCompat);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.runUpdate.invoke();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void onDeactivate() {
        this.reset.invoke();
        removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onDescendantInvalidated(View view, View view2) {
        super.onDescendantInvalidated(view, view2);
        if (!this.isDrawing) {
            this.layoutNode.invalidateLayer$ui();
        } else {
            this.view.postOnAnimation(new PopupLayout$$ExternalSyntheticLambda5(this.runInvalidate, (byte) 4));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getSnapshotObserver().observer.clear(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.view.layout(0, 0, i3 - i, i4 - i2);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        View view = this.view;
        if (view.getParent() != this) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
            return;
        }
        if (view.getVisibility() == 8) {
            setMeasuredDimension(0, 0);
            return;
        }
        view.measure(i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
        this.lastWidthMeasureSpec = i;
        this.lastHeightMeasureSpec = i2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.view.isNestedScrollingEnabled()) {
            return false;
        }
        AwaitKt.launch$default(this.dispatcher.getCoroutineScope(), null, null, new AnonymousClass1(z, this, MathKt.Velocity(f * (-1.0f), f2 * (-1.0f)), null), 3);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        if (!this.view.isNestedScrollingEnabled()) {
            return false;
        }
        AwaitKt.launch$default(this.dispatcher.getCoroutineScope(), null, null, new C00381(this, MathKt.Velocity(f * (-1.0f), f2 * (-1.0f)), null, (byte) 0), 3);
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(int i, int i2, int i3, int[] iArr) {
        if (this.view.isNestedScrollingEnabled()) {
            long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(i2 * (-1.0f))) & 4294967295L) | (((long) Float.floatToRawIntBits(i * (-1.0f))) << 32);
            int i4 = i3 == 0 ? 1 : 2;
            NestedScrollNode nestedScrollNode = this.dispatcher.nestedScrollNode;
            NestedScrollNode parentNestedScrollNode$ui = nestedScrollNode != null ? nestedScrollNode.getParentNestedScrollNode$ui() : null;
            long jMo178onPreScrollOzD1aCk = parentNestedScrollNode$ui != null ? parentNestedScrollNode$ui.mo178onPreScrollOzD1aCk(i4, jFloatToRawIntBits) : 0L;
            iArr[0] = MathKt.roundToInt(Float.intBitsToFloat((int) (jMo178onPreScrollOzD1aCk >> 32))) * (-1);
            iArr[1] = MathKt.roundToInt(Float.intBitsToFloat((int) (jMo178onPreScrollOzD1aCk & 4294967295L))) * (-1);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void onNestedScroll(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (this.view.isNestedScrollingEnabled()) {
            long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(i * (-1.0f))) << 32) | (((long) Float.floatToRawIntBits(i2 * (-1.0f))) & 4294967295L);
            long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(i3 * (-1.0f))) << 32) | (((long) Float.floatToRawIntBits(i4 * (-1.0f))) & 4294967295L);
            int i6 = i5 == 0 ? 1 : 2;
            NestedScrollNode nestedScrollNode = this.dispatcher.nestedScrollNode;
            NestedScrollNode parentNestedScrollNode$ui = nestedScrollNode != null ? nestedScrollNode.getParentNestedScrollNode$ui() : null;
            long jMo100onPostScrollDzOQY0M = parentNestedScrollNode$ui != null ? parentNestedScrollNode$ui.mo100onPostScrollDzOQY0M(i6, jFloatToRawIntBits, jFloatToRawIntBits2) : 0L;
            iArr[0] = MathKt.roundToInt(Float.intBitsToFloat((int) (jMo100onPostScrollDzOQY0M >> 32))) * (-1);
            iArr[1] = MathKt.roundToInt(Float.intBitsToFloat((int) (jMo100onPostScrollDzOQY0M & 4294967295L))) * (-1);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        FabPlacement fabPlacement = this.nestedScrollingParentHelper;
        if (i2 == 1) {
            fabPlacement.height = i;
        } else {
            fabPlacement.left = i;
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void onRelease() {
        this.release.invoke();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return ((i & 2) == 0 && (i & 1) == 0) ? false : true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View view, int i) {
        FabPlacement fabPlacement = this.nestedScrollingParentHelper;
        if (i == 1) {
            fabPlacement.height = 0;
        } else {
            fabPlacement.left = 0;
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Function1 function1 = this.bringIntoViewRequester;
        if (function1 == null) {
            return true;
        }
        function1.invoke(rect != null ? new androidx.compose.ui.geometry.Rect(rect.left, rect.top, rect.right, rect.bottom) : null);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        Function1 function1 = this.onRequestDisallowInterceptTouchEvent;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public final void setDensity(Density density) {
        if (density != this.density) {
            this.density = density;
            Function1 function1 = this.onDensityChanged;
            if (function1 != null) {
                function1.invoke(density);
            }
        }
    }

    public final void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != this.lifecycleOwner) {
            this.lifecycleOwner = lifecycleOwner;
            setTag(R.id.view_tree_lifecycle_owner, lifecycleOwner);
        }
    }

    public final void setModifier(Modifier modifier) {
        if (modifier != this.modifier) {
            this.modifier = modifier;
            Function1 function1 = this.onModifierChanged;
            if (function1 != null) {
                function1.invoke(modifier);
            }
        }
    }

    public final void setOnDensityChanged$ui(Function1 function1) {
        this.onDensityChanged = function1;
    }

    public final void setOnModifierChanged$ui(Function1 function1) {
        this.onModifierChanged = function1;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui(Function1 function1) {
        this.onRequestDisallowInterceptTouchEvent = function1;
    }

    public final void setRelease(Function0 function0) {
        this.release = function0;
    }

    public final void setReset(Function0 function0) {
        this.reset = function0;
    }

    public final void setSavedStateRegistryOwner(SavedStateRegistryOwner savedStateRegistryOwner) {
        if (savedStateRegistryOwner != this.savedStateRegistryOwner) {
            this.savedStateRegistryOwner = savedStateRegistryOwner;
            setTag(R.id.view_tree_saved_state_registry_owner, savedStateRegistryOwner);
        }
    }

    public final void setUpdate(Function0 function0) {
        this.update = function0;
        this.hasUpdateBlock = true;
        this.runUpdate.invoke();
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4, int i5) {
        if (this.view.isNestedScrollingEnabled()) {
            long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(i * (-1.0f))) << 32) | (((long) Float.floatToRawIntBits(i2 * (-1.0f))) & 4294967295L);
            long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(i3 * (-1.0f))) << 32) | (((long) Float.floatToRawIntBits(i4 * (-1.0f))) & 4294967295L);
            int i6 = i5 == 0 ? 1 : 2;
            NestedScrollNode nestedScrollNode = this.dispatcher.nestedScrollNode;
            NestedScrollNode parentNestedScrollNode$ui = nestedScrollNode != null ? nestedScrollNode.getParentNestedScrollNode$ui() : null;
            if (parentNestedScrollNode$ui != null) {
                parentNestedScrollNode$ui.mo100onPostScrollDzOQY0M(i6, jFloatToRawIntBits, jFloatToRawIntBits2);
            }
        }
    }
}
