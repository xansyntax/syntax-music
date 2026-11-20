package com.metrolist.music.ui.component;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.State;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal._UtilJvmKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DraggableScrollBarOverlayKt$DraggableScrollbar$3$1$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Animatable $animatedThumbY;
    public final /* synthetic */ byte $headerItems;
    public final /* synthetic */ MutableState $isDragging$delegate;
    public final /* synthetic */ State $isUserScrolling$delegate;
    public final /* synthetic */ LazyListState $scrollState;
    public final /* synthetic */ ParcelableSnapshotMutableFloatState $smoothedThumbY$delegate;
    public final /* synthetic */ State $targetThumbY$delegate;
    public byte label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DraggableScrollBarOverlayKt$DraggableScrollbar$3$1$1(LazyListState lazyListState, int i, Animatable animatable, MutableState mutableState, ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState, State state, State state2, Continuation continuation) {
        super(2, continuation);
        this.$scrollState = lazyListState;
        this.$headerItems = i;
        this.$animatedThumbY = animatable;
        this.$isDragging$delegate = mutableState;
        this.$smoothedThumbY$delegate = parcelableSnapshotMutableFloatState;
        this.$isUserScrolling$delegate = state;
        this.$targetThumbY$delegate = state2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DraggableScrollBarOverlayKt$DraggableScrollbar$3$1$1(this.$scrollState, this.$headerItems, this.$animatedThumbY, this.$isDragging$delegate, this.$smoothedThumbY$delegate, this.$isUserScrolling$delegate, this.$targetThumbY$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((DraggableScrollBarOverlayKt$DraggableScrollbar$3$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
    
        if (r11.$animatedThumbY.snapTo(r1, r11) == r8) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008c, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r10, r1, r0, null, null, r11, 12) == r8) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a5, code lost:
    
        if (r10.snapTo(r3, r11) == r8) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00da, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r10, r3, r0, null, null, r11, 12) == r8) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00dc, code lost:
    
        return r8;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        byte b = this.label;
        if (b == 0) {
            ResultKt.throwOnFailure(obj);
            int i = this.$scrollState.getLayoutInfo().totalItemsCount - this.$headerItems;
            boolean zBooleanValue = ((Boolean) this.$isDragging$delegate.getValue()).booleanValue();
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (zBooleanValue) {
                Float f = new Float(this.$smoothedThumbY$delegate.getFloatValue());
                this.label = (byte) 1;
            } else {
                boolean zBooleanValue2 = ((Boolean) this.$isUserScrolling$delegate.getValue()).booleanValue();
                State state = this.$targetThumbY$delegate;
                Animatable animatable = this.$animatedThumbY;
                if (!zBooleanValue2) {
                    Float f2 = new Float(((Number) state.getValue()).floatValue());
                    SpringSpec springSpecSpring$default = ArcSplineKt.spring$default(i < 30 ? 1.5f : 0.9f, i < 30 ? 80.0f : 150.0f, null, 4);
                    this.label = (byte) 4;
                } else if (i < 30) {
                    Float f3 = new Float(((Number) state.getValue()).floatValue());
                    SpringSpec springSpecSpring$default2 = ArcSplineKt.spring$default(1.2f, 100.0f, null, 4);
                    this.label = (byte) 2;
                } else {
                    Float f4 = new Float(((Number) state.getValue()).floatValue());
                    this.label = (byte) 3;
                }
            }
        } else {
            if (b != 1 && b != 2 && b != 3 && b != 4) {
                _UtilJvmKt$$ExternalSyntheticLambda0.m$2("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
