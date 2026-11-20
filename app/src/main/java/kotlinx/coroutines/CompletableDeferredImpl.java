package kotlinx.coroutines;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class CompletableDeferredImpl extends JobSupport implements CompletableDeferred {
    public final boolean completeExceptionally(Throwable th) {
        return makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(th, false));
    }
}
