package androidx.compose.foundation;

import androidx.compose.foundation.gestures.DefaultScrollableState;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.core.provider.CallbackWrapper;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollState implements ScrollableState {
    public static final CallbackWrapper Saver = new CallbackWrapper(new ScrollState$$ExternalSyntheticLambda3(0), new BorderKt$$ExternalSyntheticLambda1(18), 7);
    public float accumulator;
    public final DerivedSnapshotState canScrollBackward$delegate;
    public final DerivedSnapshotState canScrollForward$delegate;
    public final DefaultScrollableState scrollableState;
    public final ParcelableSnapshotMutableIntState value$delegate;
    public final ParcelableSnapshotMutableIntState viewportSize$delegate = new ParcelableSnapshotMutableIntState(0);
    public final ParcelableSnapshotMutableIntState contentSize$delegate = new ParcelableSnapshotMutableIntState(0);
    public final ParcelableSnapshotMutableState reverseScrolling$delegate = Stack.mutableStateOf$default(Boolean.FALSE);
    public final MutableInteractionSourceImpl internalInteractionSource = new MutableInteractionSourceImpl();
    public final ParcelableSnapshotMutableIntState _maxValueState = new ParcelableSnapshotMutableIntState(Integer.MAX_VALUE);

    public ScrollState(int i) {
        this.value$delegate = new ParcelableSnapshotMutableIntState(i);
        final byte b = 0;
        this.scrollableState = new DefaultScrollableState(new ScrollState$$ExternalSyntheticLambda0(b, this));
        this.canScrollForward$delegate = SnapshotStateKt__DerivedStateKt.derivedStateOf(new Function0(this) { // from class: androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda1
            public final /* synthetic */ ScrollState f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b2 = b;
                ScrollState scrollState = this.f$0;
                switch (b2) {
                    case 0:
                        return Boolean.valueOf(scrollState.value$delegate.getIntValue() < scrollState._maxValueState.getIntValue());
                    default:
                        return Boolean.valueOf(scrollState.value$delegate.getIntValue() > 0);
                }
            }
        });
        final byte b2 = 1;
        this.canScrollBackward$delegate = SnapshotStateKt__DerivedStateKt.derivedStateOf(new Function0(this) { // from class: androidx.compose.foundation.ScrollState$$ExternalSyntheticLambda1
            public final /* synthetic */ ScrollState f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                byte b3 = b2;
                ScrollState scrollState = this.f$0;
                switch (b3) {
                    case 0:
                        return Boolean.valueOf(scrollState.value$delegate.getIntValue() < scrollState._maxValueState.getIntValue());
                    default:
                        return Boolean.valueOf(scrollState.value$delegate.getIntValue() > 0);
                }
            }
        });
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final float dispatchRawDelta(float f) {
        return this.scrollableState.dispatchRawDelta(f);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final Object scroll(MutatePriority mutatePriority, Function2 function2, ContinuationImpl continuationImpl) {
        Object objScroll = this.scrollableState.scroll(mutatePriority, function2, continuationImpl);
        return objScroll == CoroutineSingletons.COROUTINE_SUSPENDED ? objScroll : Unit.INSTANCE;
    }
}
