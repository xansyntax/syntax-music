package kotlin.coroutines;

import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractCoroutineContextElement implements CoroutineContext.Element {
    private final CoroutineContext.Key key;

    public AbstractCoroutineContextElement(CoroutineContext.Key key) {
        key.getClass();
        this.key = key;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public /* bridge */ <R> R fold(R r, Function2 function2) {
        return (R) StringsKt__IndentKt.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public /* bridge */ <E extends CoroutineContext.Element> E get(CoroutineContext.Key key) {
        return (E) StringsKt__IndentKt.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key getKey() {
        return this.key;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public /* bridge */ CoroutineContext minusKey(CoroutineContext.Key key) {
        return StringsKt__IndentKt.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public /* bridge */ CoroutineContext plus(CoroutineContext coroutineContext) {
        return StringsKt__IndentKt.plus(this, coroutineContext);
    }
}
