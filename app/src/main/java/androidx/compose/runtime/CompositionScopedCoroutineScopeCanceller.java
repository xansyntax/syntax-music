package androidx.compose.runtime;

import androidx.compose.animation.core.MutationInterruptedException;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CompositionScopedCoroutineScopeCanceller implements RememberObserver {
    public final CoroutineScope coroutineScope;

    public CompositionScopedCoroutineScopeCanceller(CoroutineScope coroutineScope) {
        this.coroutineScope = coroutineScope;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope instanceof RememberedCoroutineScope) {
            ((RememberedCoroutineScope) coroutineScope).cancelIfCreated();
        } else {
            AwaitKt.cancel(coroutineScope, new MutationInterruptedException());
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope instanceof RememberedCoroutineScope) {
            ((RememberedCoroutineScope) coroutineScope).cancelIfCreated();
        } else {
            AwaitKt.cancel(coroutineScope, new MutationInterruptedException());
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
    }
}
