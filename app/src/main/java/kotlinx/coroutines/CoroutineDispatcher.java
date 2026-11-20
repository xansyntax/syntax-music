package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.time.InstantKt$$ExternalSyntheticLambda0;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LimitedDispatcher;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CoroutineDispatcher extends AbstractCoroutineContextElement implements CoroutineContext.Element {
    public static final Key Key = new Key(ContinuationInterceptor$Key.$$INSTANCE, new InstantKt$$ExternalSyntheticLambda0((byte) 25));

    /* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
    public final class Key implements CoroutineContext.Key {
        public final Function1 safeCast;
        public final CoroutineContext.Key topmostKey;

        public Key(CoroutineContext.Key key, Function1 function1) {
            key.getClass();
            this.safeCast = function1;
            this.topmostKey = key instanceof Key ? ((Key) key).topmostKey : key;
        }
    }

    public CoroutineDispatcher() {
        super(ContinuationInterceptor$Key.$$INSTANCE);
    }

    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        DefaultIoScheduler.f646default.dispatch(coroutineContext, runnable);
    }

    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        InlineList.safeDispatch(this, coroutineContext, runnable);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        CoroutineContext.Element element;
        key.getClass();
        if (key instanceof Key) {
            Key key2 = (Key) key;
            CoroutineContext.Key key3 = getKey();
            key3.getClass();
            if ((key3 == key2 || key2.topmostKey == key3) && (element = (CoroutineContext.Element) key2.safeCast.invoke(this)) != null) {
                return element;
            }
        } else if (ContinuationInterceptor$Key.$$INSTANCE == key) {
            return this;
        }
        return null;
    }

    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return !(this instanceof Unconfined);
    }

    public CoroutineDispatcher limitedParallelism(int i, String str) {
        InlineList.checkParallelism(i);
        return new LimitedDispatcher(this, i, str);
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        key.getClass();
        if (key instanceof Key) {
            Key key2 = (Key) key;
            CoroutineContext.Key key3 = getKey();
            key3.getClass();
            if ((key3 != key2 && key2.topmostKey != key3) || ((CoroutineContext.Element) key2.safeCast.invoke(this)) == null) {
                return this;
            }
        } else if (ContinuationInterceptor$Key.$$INSTANCE != key) {
            return this;
        }
        return EmptyCoroutineContext.INSTANCE;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + AwaitKt.getHexAddress(this);
    }
}
