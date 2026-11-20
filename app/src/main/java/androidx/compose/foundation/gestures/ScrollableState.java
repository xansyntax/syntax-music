package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public interface ScrollableState {
    float dispatchRawDelta(float f);

    default boolean getCanScrollBackward() {
        return true;
    }

    default boolean getCanScrollForward() {
        return true;
    }

    boolean isScrollInProgress();

    Object scroll(MutatePriority mutatePriority, Function2 function2, ContinuationImpl continuationImpl);
}
