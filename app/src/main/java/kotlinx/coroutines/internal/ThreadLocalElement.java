package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class ThreadLocalElement implements ThreadContextElement {
    public final ThreadLocalKey key;
    public final ThreadLocal threadLocal;
    public final Object value;

    public ThreadLocalElement(Object obj, ThreadLocal threadLocal) {
        this.value = obj;
        this.threadLocal = threadLocal;
        this.key = new ThreadLocalKey(threadLocal);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return function2.invoke(obj, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        if (this.key.equals(key)) {
            return this;
        }
        return null;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return this.key;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return this.key.equals(key) ? EmptyCoroutineContext.INSTANCE : this;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return StringsKt__IndentKt.plus(this, coroutineContext);
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public final void restoreThreadContext(Object obj) {
        this.threadLocal.set(obj);
    }

    public final String toString() {
        return "ThreadLocal(value=" + this.value + ", threadLocal = " + this.threadLocal + ')';
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public final Object updateThreadContext() {
        ThreadLocal threadLocal = this.threadLocal;
        Object obj = threadLocal.get();
        threadLocal.set(this.value);
        return obj;
    }
}
