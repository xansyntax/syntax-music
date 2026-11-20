package com.metrolist.music.ui.component;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.gestures.DefaultDraggableState;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import com.metrolist.innertubex.InnerTube$feedback$2;
import com.metrolist.music.ui.player.PlayerKt$$ExternalSyntheticLambda0;
import com.metrolist.music.utils.SyncUtils;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetState implements DraggableState {
    public final /* synthetic */ DefaultDraggableState $$delegate_0;
    public final Animatable animatable;
    public final float collapsedBound;
    public final CoroutineScope coroutineScope;
    public final BottomSheetKt$$ExternalSyntheticLambda9 onAnchorChanged;
    public final AnimationState value$delegate;
    public final DerivedSnapshotState isDismissed$delegate = SnapshotStateKt__DerivedStateKt.derivedStateOf(new PlayerKt$$ExternalSyntheticLambda0(this, (byte) 2));
    public final DerivedSnapshotState isCollapsed$delegate = SnapshotStateKt__DerivedStateKt.derivedStateOf(new PlayerKt$$ExternalSyntheticLambda0(this, (byte) 3));
    public final DerivedSnapshotState isExpanded$delegate = SnapshotStateKt__DerivedStateKt.derivedStateOf(new PlayerKt$$ExternalSyntheticLambda0(this, (byte) 4));
    public final DerivedSnapshotState progress$delegate = SnapshotStateKt__DerivedStateKt.derivedStateOf(new PlayerKt$$ExternalSyntheticLambda0(this, (byte) 5));

    public BottomSheetState(DefaultDraggableState defaultDraggableState, CoroutineScope coroutineScope, Animatable animatable, BottomSheetKt$$ExternalSyntheticLambda9 bottomSheetKt$$ExternalSyntheticLambda9, float f) {
        this.$$delegate_0 = defaultDraggableState;
        this.coroutineScope = coroutineScope;
        this.animatable = animatable;
        this.onAnchorChanged = bottomSheetKt$$ExternalSyntheticLambda9;
        this.collapsedBound = f;
        this.value$delegate = animatable.internalState;
    }

    public final void collapse() {
        SpringSpec springSpec = new SpringSpec(7, null);
        this.onAnchorChanged.invoke(1);
        AwaitKt.launch$default(this.coroutineScope, null, null, new BottomSheetState$expand$1(this, springSpec, null, (byte) 1), 3);
    }

    public final void collapseSoft() {
        SpringSpec springSpecSpring$default = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, null, 5);
        this.onAnchorChanged.invoke(1);
        AwaitKt.launch$default(this.coroutineScope, null, null, new BottomSheetState$expand$1(this, springSpecSpring$default, null, (byte) 1), 3);
    }

    public final void dismiss() {
        this.onAnchorChanged.invoke(0);
        AwaitKt.launch$default(this.coroutineScope, null, null, new SyncUtils.AnonymousClass2(this, null, (byte) 24), 3);
    }

    public final void dispatchRawDelta(float f) {
        this.$$delegate_0.onDelta.invoke(Float.valueOf(f));
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public final Object drag(InnerTube$feedback$2 innerTube$feedback$2, NavHostKt$NavHost$29$1 navHostKt$NavHost$29$1) {
        return this.$$delegate_0.drag(innerTube$feedback$2, navHostKt$NavHost$29$1);
    }

    public final void expandSoft() {
        SpringSpec springSpecSpring$default = ArcSplineKt.spring$default(CropImageView.DEFAULT_ASPECT_RATIO, 400.0f, null, 5);
        this.onAnchorChanged.invoke(2);
        AwaitKt.launch$default(this.coroutineScope, null, null, new BottomSheetState$expand$1(this, springSpecSpring$default, null, (byte) 0), 3);
    }

    public final float getProgress() {
        return ((Number) this.progress$delegate.getValue()).floatValue();
    }

    /* JADX INFO: renamed from: getValue-D9Ej5fM, reason: not valid java name */
    public final float m1456getValueD9Ej5fM() {
        return ((Dp) this.value$delegate.value$delegate.getValue()).value;
    }

    public final boolean isCollapsed() {
        return ((Boolean) this.isCollapsed$delegate.getValue()).booleanValue();
    }

    public final boolean isDismissed() {
        return ((Boolean) this.isDismissed$delegate.getValue()).booleanValue();
    }

    public final boolean isExpanded() {
        return ((Boolean) this.isExpanded$delegate.getValue()).booleanValue();
    }

    public final void performFling(float f, Function0 function0) {
        byte b = 0;
        CoroutineScope coroutineScope = this.coroutineScope;
        BottomSheetKt$$ExternalSyntheticLambda9 bottomSheetKt$$ExternalSyntheticLambda9 = this.onAnchorChanged;
        Continuation continuation = null;
        if (f > 250.0f) {
            SpringSpec springSpec = new SpringSpec(7, null);
            bottomSheetKt$$ExternalSyntheticLambda9.invoke(2);
            AwaitKt.launch$default(coroutineScope, null, null, new BottomSheetState$expand$1(this, springSpec, continuation, b), 3);
            return;
        }
        float f2 = this.collapsedBound;
        if (f < -250.0f) {
            if (Dp.m795compareTo0680j_4(m1456getValueD9Ej5fM(), f2) >= 0 || function0 == null) {
                collapse();
                return;
            } else {
                dismiss();
                function0.invoke();
                return;
            }
        }
        Animatable animatable = this.animatable;
        Comparable comparable = animatable.lowerBound;
        comparable.getClass();
        float f3 = ((Dp) comparable).value;
        Comparable comparable2 = animatable.lowerBound;
        comparable2.getClass();
        float f4 = (((f2 - ((Dp) comparable2).value) + CropImageView.DEFAULT_ASPECT_RATIO) / 2.0f) + CropImageView.DEFAULT_ASPECT_RATIO;
        Comparable comparable3 = animatable.upperBound;
        comparable3.getClass();
        float f5 = (((((Dp) comparable3).value - f2) + CropImageView.DEFAULT_ASPECT_RATIO) / 2.0f) + CropImageView.DEFAULT_ASPECT_RATIO;
        Comparable comparable4 = animatable.upperBound;
        comparable4.getClass();
        float f6 = ((Dp) comparable4).value;
        float fM1456getValueD9Ej5fM = m1456getValueD9Ej5fM();
        if (Dp.m795compareTo0680j_4(fM1456getValueD9Ej5fM, f3) >= 0 && Dp.m795compareTo0680j_4(fM1456getValueD9Ej5fM, f4) <= 0) {
            if (function0 == null) {
                collapse();
                return;
            } else {
                dismiss();
                function0.invoke();
                return;
            }
        }
        if (Dp.m795compareTo0680j_4(fM1456getValueD9Ej5fM, f4) >= 0 && Dp.m795compareTo0680j_4(fM1456getValueD9Ej5fM, f5) <= 0) {
            collapse();
        } else {
            if (Dp.m795compareTo0680j_4(fM1456getValueD9Ej5fM, f5) < 0 || Dp.m795compareTo0680j_4(fM1456getValueD9Ej5fM, f6) > 0) {
                return;
            }
            SpringSpec springSpec2 = new SpringSpec(7, null);
            bottomSheetKt$$ExternalSyntheticLambda9.invoke(2);
            AwaitKt.launch$default(coroutineScope, null, null, new BottomSheetState$expand$1(this, springSpec2, continuation, b), 3);
        }
    }
}
