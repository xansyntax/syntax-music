package io.ktor.client.plugins.websocket;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredImpl;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final class BuildersKt$webSocketSession$2$1$1 implements Function1 {
    final /* synthetic */ CompletableDeferred $sessionCompleted;

    public BuildersKt$webSocketSession$2$1$1(CompletableDeferred completableDeferred) {
        this.$sessionCompleted = completableDeferred;
    }

    public final void invoke(Throwable th) {
        CompletableDeferred completableDeferred = this.$sessionCompleted;
        if (th != null) {
            ((CompletableDeferredImpl) completableDeferred).completeExceptionally(th);
        } else {
            ((CompletableDeferredImpl) completableDeferred).makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }
}
