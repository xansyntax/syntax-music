package androidx.compose.runtime.tooling;

import androidx.collection.internal.Lock;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-784ebb21e2544a232bb05d6c6532484f7cac232a67ed266b53301d1128674b41 */
/* JADX INFO: loaded from: classes.dex */
public final class CompositionErrorContextImpl implements OperationErrorContext, CoroutineContext.Element {
    public static final Lock Key = new Lock((byte) 6);
    public final GapComposer composer;

    public CompositionErrorContextImpl(GapComposer gapComposer) {
        this.composer = gapComposer;
    }

    @Override // androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext
    public final List buildStackTrace(Integer num) {
        return this.composer.parentStackTrace$runtime();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return function2.invoke(obj, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final /* bridge */ CoroutineContext.Element get(CoroutineContext.Key key) {
        return StringsKt__IndentKt.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return Key;
    }

    @Override // androidx.compose.runtime.composer.gapbuffer.changelist.OperationErrorContext
    public final boolean getSourceInformationEnabled() {
        return this.composer.sourceMarkersEnabled;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final /* bridge */ CoroutineContext minusKey(CoroutineContext.Key key) {
        return StringsKt__IndentKt.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final /* bridge */ CoroutineContext plus(CoroutineContext coroutineContext) {
        return StringsKt__IndentKt.plus(this, coroutineContext);
    }
}
