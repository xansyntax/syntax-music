package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.internal.InlineList;
import okio.Okio__OkioKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyStandaloneCoroutine extends StandaloneCoroutine {
    public final Continuation continuation;

    public LazyStandaloneCoroutine(CoroutineContext coroutineContext, Function2 function2) {
        super(coroutineContext, false);
        this.continuation = Okio__OkioKt.createCoroutineUnintercepted(this, this, function2);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void onStart() throws Throwable {
        try {
            InlineList.resumeCancellableWithInternal(Unit.INSTANCE, Okio__OkioKt.intercepted(this.continuation));
        } catch (Throwable th) {
            StringsKt__IndentKt.dispatcherFailure(th, this);
            throw null;
        }
    }
}
