package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import coil3.RealImageLoader;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultScrollableState implements ScrollableState {
    public final ParcelableSnapshotMutableState isLastScrollBackwardState;
    public final ParcelableSnapshotMutableState isLastScrollForwardState;
    public final ParcelableSnapshotMutableState isScrollingState;
    public final Function1 onDelta;
    public final DefaultScrollableState$scrollScope$1 scrollScope = new ScrollScope() { // from class: androidx.compose.foundation.gestures.DefaultScrollableState$scrollScope$1
        @Override // androidx.compose.foundation.gestures.ScrollScope
        public final float scrollBy(float f) {
            if (Float.isNaN(f)) {
                return CropImageView.DEFAULT_ASPECT_RATIO;
            }
            DefaultScrollableState defaultScrollableState = this.this$0;
            float fFloatValue = ((Number) defaultScrollableState.onDelta.invoke(Float.valueOf(f))).floatValue();
            defaultScrollableState.isLastScrollForwardState.setValue(Boolean.valueOf(fFloatValue > CropImageView.DEFAULT_ASPECT_RATIO));
            defaultScrollableState.isLastScrollBackwardState.setValue(Boolean.valueOf(fFloatValue < CropImageView.DEFAULT_ASPECT_RATIO));
            return fFloatValue;
        }
    };
    public final MutatorMutex scrollMutex = new MutatorMutex();

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.foundation.gestures.DefaultScrollableState$scrollScope$1] */
    public DefaultScrollableState(Function1 function1) {
        this.onDelta = function1;
        Boolean bool = Boolean.FALSE;
        this.isScrollingState = Stack.mutableStateOf$default(bool);
        this.isLastScrollForwardState = Stack.mutableStateOf$default(bool);
        this.isLastScrollBackwardState = Stack.mutableStateOf$default(bool);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final float dispatchRawDelta(float f) {
        return ((Number) this.onDelta.invoke(Float.valueOf(f))).floatValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean isScrollInProgress() {
        return ((Boolean) this.isScrollingState.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final Object scroll(MutatePriority mutatePriority, Function2 function2, ContinuationImpl continuationImpl) {
        Object objCoroutineScope = AwaitKt.coroutineScope(new RealImageLoader.AnonymousClass2(this, mutatePriority, function2, null, (byte) 11, false), continuationImpl);
        return objCoroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope : Unit.INSTANCE;
    }
}
