package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public interface CoroutineExceptionHandler extends CoroutineContext.Element {

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Key implements CoroutineContext.Key {
        public static final /* synthetic */ Key $$INSTANCE = new Key();
    }

    void handleException(CoroutineContext coroutineContext, Throwable th);
}
