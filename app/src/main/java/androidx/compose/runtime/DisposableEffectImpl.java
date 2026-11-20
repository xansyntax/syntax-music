package androidx.compose.runtime;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class DisposableEffectImpl implements RememberObserver {
    public final Function1 effect;
    public DisposableEffectResult onDispose;

    public DisposableEffectImpl(Function1 function1) {
        this.effect = function1;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        DisposableEffectResult disposableEffectResult = this.onDispose;
        if (disposableEffectResult != null) {
            disposableEffectResult.dispose();
        }
        this.onDispose = null;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
        this.onDispose = (DisposableEffectResult) this.effect.invoke(Stack.InternalDisposableEffectScope);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
    }
}
