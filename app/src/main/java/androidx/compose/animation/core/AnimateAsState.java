package androidx.compose.animation.core;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class AnimateAsState implements State {
    public Animatable animatable;
    public final CoroutineScope coroutineScope;
    public StandaloneCoroutine job;
    public final ParcelableSnapshotMutableState toolingOverride$delegate;

    public AnimateAsState(Object obj, TwoWayConverterImpl twoWayConverterImpl, AnimationSpec animationSpec, Object obj2, String str, CoroutineScope coroutineScope) {
        this.coroutineScope = coroutineScope;
        this.animatable = new Animatable(obj, twoWayConverterImpl, obj2, str);
        if (obj2 != null && (animationSpec instanceof SpringSpec)) {
            Intrinsics.areEqual(((SpringSpec) animationSpec).visibilityThreshold, obj2);
        }
        this.toolingOverride$delegate = Stack.mutableStateOf$default(null);
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        Object value;
        State state = (State) this.toolingOverride$delegate.getValue();
        return (state == null || (value = state.getValue()) == null) ? this.animatable.getValue() : value;
    }
}
